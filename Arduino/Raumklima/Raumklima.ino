//#include <LiquidCrystal.h>
#include "DS3232RTC.h"
#include <TimeLib.h>
#include <Time.h> 
#include <LiquidCrystal_I2C.h>
#include <Wire.h>
#include <SPI.h>
#include <SD.h>
#include <Adafruit_Sensor.h>
#include <Adafruit_BME280.h>
#include <Servo.h>
#include <LowPower.h>
#include <hx711.h>

#define SERVO_PIN 9
#define HX711_CLK A0
#define HX711_DAT A1
#define SERVO_MAX 180
#define SERVO_MIN 10

#define MenuInterruptNumber 0
#define ValueInterruptNumber 1
#define SD_PIN 8
#define BRIGHTNESS_SENSOR_A_PIN A2
#define LOUDNESS_SENSOR_PIN A3
#define CO2_PIN A1
#define POWER_ON true
#define POWER_OFF false
#define VERSION "1.0.0.0"



bool pwr = true; //hier wird gespeichert ob sich der controller im schlafmodus befinden sollte
time_t t;



Hx711 scale(HX711_DAT, HX711_CLK);
File file;
Adafruit_BME280 BME280;
LiquidCrystal_I2C directLcd(0x26, 20, 4);
LiquidCrystal_I2C indirectLcd(0x27, 16, 2);
Servo servo;

String titles = "Temperatur (in C);Luftfeuchtigkeit (in %);Luftdruck (in hPa);Helligkeit (0%-100%);CO2-Level (ppm);Lautstärke (#EH)";

int nextWake;
int minutesPriorToWakeTime = 5;
int wakeRate = 6;

//GENERAL SYSTEM VARS--
boolean directLcdEnabled = true;
boolean indirectLcdEnabled = false;
boolean needsUpdate = false;
boolean needsValueUpdate = false;
boolean physik = true;
boolean recording = false;
boolean sending = false;
boolean  SDFail = true;

int changeScreenThreshold = 10;
int displayCounter = 0;
int menuPage = 0;
int directLcdContrast = 75;
int directindirectLcdrightness = 255;

long baudrate = 115200;
String sendoff = "";
String fileName = "";
String recievedCommand = "";

unsigned long lastMenuTime = 0;
unsigned long lastValueTime = 0;
unsigned long lastData;
unsigned long counter = 0;
boolean servoIsTipped = false;
int servoValue = 0;

byte AE[8] = {
  0b01010,
  0b00000,
  0b01110,
  0b10001,
  0b11111,
  0b10001,
  0b10001,
  0b00000
};

byte OE[8] = {
  0b01010,
  0b00000,
  0b01110,
  0b10001,
  0b10001,
  0b10001,
  0b01110,
  0b00000
};

byte UE[8] = {
  0b01010,
  0b00000,
  0b10001,
  0b10001,
  0b10001,
  0b10001,
  0b01110,
  0b00000
};

//DATA VARS
double Airpressure = 0.0;
double Temperature = 0.0;
double Humidity = 0.0;
double RTC_Temperature = 0.0;
double LOUD = 0.0;
double LDR = 0.0;
double CO2 = 0.0;
double RAIN = 0.0;

//METHODS--
//

//INITIALISATION-
void setup() {
  Serial.begin(115200);
  delay(10);
  Serial.println("HELLO WORLD; I AM INITIALIZING");
  attachInterrupt(MenuInterruptNumber, iterateMenu, RISING);
  servo.attach(SERVO_PIN);
  initBoard();
}

void initBoard() {
  Serial.println("INITING");

  //analogWrite(DIRECT_LCD_CONTRAST_PIN, directLcdContrast);
  //analogWrite(DIRECT_LCD_BACKLIGHT_PIN, directindirectLcdrightness);

  indirectLcd.init();
  indirectLcd.noBacklight();

  directLcd.init();//.begin(20, 4);
  directLcd.clear();
  directLcd.backlight();
  directLcd.print("Initialisieren...");

  createChars();

  //pinMode(3, INPUT); //ich hab den widerstand auf dem board vergessen deswegen der interne
  //attachInterrupt(1, alwaysInterruptButton_Push, RISING);
  attachInterrupt(0, iterateMenu, RISING); //TODO ï¿½berlegen
  attachInterrupt(1, increaseValue, RISING);

  directLcd.setCursor(0, 1);
  directLcd.print("SD-Karte: ");
  if (!SD.begin(SD_PIN)) { //readWrite Sample   //INITIALIZE SD-CARD
    Serial.println("SD-FAIL");
    directLcd.print("FAIL");
    SDFail = true;
  }
  else {
    Serial.println("SD-Success");
    directLcd.print("OK");
    SDFail = false;
  }

  /*fileName = getTimeName();
    Serial.println(fileName);
    directLcd.setCursor(0, 2);
    directLcd.print("DATEINAME fuer CSV:");
    directLcd.setCursor(0, 3);
    directLcd.print(fileName);*/

  Serial.println(titles);

  delay(500);
  directLcd.clear();
  directLcd.print("SD-Schreibzugriff:");
  directLcd.setCursor(0, 1);

  directLcd.setCursor(0, 2);
  directLcd.print("BME280: ");
  BME280.begin();
  directLcd.print("OK");
  delay(500);
  //directLcd.clear();
  //directLcd.print("FERTIG!");
  //directLcd.setCursor(0, 2);
  //directLcd.print("DATEINAME fuer CSV:");
  //directLcd.setCursor(0, 3);
  //directLcd.print(fileName);
  //delay(2000);
}

//OUTPUT DATA--
void getData() {
  Temperature = BME280.readTemperature();
  Airpressure = BME280.readPressure() / 100; // /1000 um von Pa auf hPa umzurechnen
  Humidity = BME280.readHumidity();

  LDR = analogRead(BRIGHTNESS_SENSOR_A_PIN);
  LDR = map(LDR, 0, 1023, 100, 0);
  LOUD = analogRead(LOUDNESS_SENSOR_PIN);
  LOUD = map(LOUD, 0, 1023, 100, 0);
  CO2 = analogRead(CO2_PIN);
  CO2 = map(CO2, 0, 1023, 100, 0);
  sendoff = String(Temperature) + ";" + Humidity + ";" + Airpressure + ";" + LDR + ";" + CO2 + ";" + LOUD;
  if (!physik) {
    RAIN = scale.getGram();
    flipServo();
    RAIN = scale.getGram() - RAIN;
    flipServo();
    sendoff += ";";
    sendoff += RAIN;
  }
}

void printDataToSD() {
  if (!SDFail) {
    counter++;
    file.close();
    file = SD.open(fileName, FILE_WRITE);
    if (file) {
      file.println(sendoff);
      file.close();
    }
    else {//RETRY ONCE MORE
      Serial.println("FAILED ONCE");
      file = SD.open(fileName, FILE_WRITE);
      if (file) {
        file.println(sendoff);
        file.close();
      }
      else {
        Serial.println("FAILED TWICE");
      }
    }
    file.close();
  }
}

void printDataToUART0() { //Main Serial Port
  Serial.println(sendoff);
}

//CRUCIAL SYSTEM METHODS
void(*resetSystem)(void) = 0; //RESETS THE SYSTEM

void loop() {

  if (Serial.available()) {
    recievedCommand = Serial.readString();
    //Serial.println("RECIEVED: " + recievedCommand);
    if (!recievedCommand.equals("")) {
      if (recievedCommand.startsWith("VERSION")) {
        Serial.println(VERSION);
      }
      else if (recievedCommand.equals("GETTIME")) {
        time_t tGET=RTC.get();
        Serial.println("TIME: "+String(day(tGET))+"."+month(tGET)+"."+year(tGET)+" "+hour(tGET)+":"+minute(tGET)+":"+second(tGET));
      }
      else if (recievedCommand.startsWith("SETTIME")) {//bsp: "SETTIME_20.10.2017_21.55.18"
        //recievedCommand = recievedCommand.substring(0, 7);
        time_t tSET;
        tmElements_t tm;
        Serial.println(recievedCommand.substring(8, 10).toInt());
        tm.Day=recievedCommand.substring(8, 10).toInt();
        Serial.println(recievedCommand.substring(11, 13).toInt());
        tm.Month=recievedCommand.substring(11, 13).toInt();
        Serial.println(CalendarYrToTm(recievedCommand.substring(14, 18).toInt()));
        tm.Year=CalendarYrToTm(recievedCommand.substring(14, 18).toInt());
        Serial.println(recievedCommand.substring(19,21).toInt());
        tm.Hour=recievedCommand.substring(19,21).toInt();
        Serial.println(recievedCommand.substring(22,24).toInt());
        tm.Hour=recievedCommand.substring(22,24).toInt();
        Serial.println(recievedCommand.substring(25,27).toInt());
        tm.Hour=recievedCommand.substring(25,27).toInt();
        tm.Day=24;
        tm.Month=10;
        tm.Year=29;
        tm.Hour=22;
        tm.Minute=30;
        tm.Second=30;
        tSET=makeTime(tm);        
        Serial.println("TIME (SET): "+String(day(tSET))+"."+month(tSET)+"."+year(tSET)+" "+hour(tSET)+":"+minute(tSET)+":"+second(tSET));
        //RTC.set(t);
      }
    }
    delay(1000);
  }

  if (!sending) {

    if (needsUpdate) {
      Serial.println("AN UPDATE IS NEEDED");
      if (menuPage == 0) {
        needsUpdate = false;
        indirectLcd.noBacklight();
        indirectLcd.clear();
      }
      else if (menuPage == 1) {
        needsUpdate = false;
        indirectLcd.backlight();
        indirectLcd.clear();
        indirectLcd.print("AUFZEICHNUNG:");
        indirectLcd.setCursor(0, 1);
        if (!SDFail) {
          if (recording) {
            indirectLcd.print("L");
            indirectLcd.write(0);
            indirectLcd.print("UFT");
          }
          else {
            indirectLcd.print("GESTOPPT");
          }
        }
        else {
          indirectLcd.print("NICHT VERFUEGBAR");
        }
      }
      else if (menuPage == 2) {
        needsUpdate = false;
        indirectLcd.clear();
        indirectLcd.print("FACHSCHAFT:");
        indirectLcd.setCursor(0, 1);
        if (physik) {
          indirectLcd.print("PHYSIK");
        }
        else {
          indirectLcd.print("GEOGRAPHIE");
        }
      }
      else if (menuPage == 3) {
        needsUpdate = false;
        indirectLcd.clear();
        indirectLcd.print("HAUPT-LCD STATUS");
        indirectLcd.setCursor(0, 1);
        if (directLcdEnabled) {
          indirectLcd.print("AN");
        }
        else {
          indirectLcd.print("AUS");
        }
      }
      else {
        needsUpdate = false;
        indirectLcd.clear();
        indirectLcd.noBacklight();
      }
    }

    if (needsValueUpdate) {
      if (menuPage == 1) {
        needsValueUpdate = false;
        recording = !recording;
        indirectLcd.clear();
        indirectLcd.print("AUFZEICHNUNG:");
        indirectLcd.setCursor(0, 1);
        if (recording) {
          fileName = getTimeName();
          file = SD.open(fileName, FILE_WRITE);
          if (file) {
            if (physik) {
              file.println(titles);
            }
            else {
              file.println(titles + ";Niederschlagsmenge (in mm)");
            }
            file.close();
            //directLcd.print("OK");
          }
          else {//RETRY ONCE MORE
            file = SD.open(fileName, FILE_WRITE);
            if (file) {
              Serial.println("SD FAILED ONCE While writing the titles");
              if (physik) {
                file.println(titles);
              }
              else {
                file.println(titles + ";Niederschlagsmenge (in mm)");
              }
              file.close();
              //directLcd.print("OK");
            }
            else {
              Serial.println("SD FAILED twice While writing the titles");
              indirectLcd.print("NICHT moeglich!");
            }
          }

          indirectLcd.print("LAEUFT");
        }
        else {
          indirectLcd.print("GESTOPPT");
        }
      }
      else if (menuPage == 2) {
        needsValueUpdate = false;
        physik = !physik;
        indirectLcd.clear();
        indirectLcd.print("FACHSCHAFT:");
        indirectLcd.setCursor(0, 1);
        if (physik) {
          indirectLcd.print("PHYSIK");
        }
        else {
          indirectLcd.print("GEOGRAPHIE");
        }
      }
      else if (menuPage == 3) {
        needsValueUpdate = false;
        directLcdEnabled = !directLcdEnabled;
        indirectLcd.clear();
        indirectLcd.print("HAUPT-LCD STATUS");
        indirectLcd.setCursor(0, 1);
        if (directLcdEnabled) {
          indirectLcd.print("AN");
        }
        else {
          indirectLcd.print("AUS");
        }
        if (directLcdEnabled) {
          directLcd.backlight();
        }
        else {
          directLcd.noBacklight();
        }
      }
    }

    if (millis() % 1000 == 0) {
      //Serial.println("GETTING DATA");
      getData();
      if (physik) {
        if (recording) {
          printDataToSD();
        }
        printDataToUART0();
      }
      else {
        //if(geoReady()){
        //geoMessen();
        Serial.println("powerDown: " + getTimeName());
        delay(2000);
        sleepUntil(nextWake, 0);
        Serial.println("woken: " + getTimeName());
        // }
      }

      if (displayCounter < changeScreenThreshold) { //BME280
        displayCounter++;
        directLcd.clear();
        directLcd.print("MESSWERTE (I)");
        directLcd.setCursor(0, 1);
        directLcd.print("Temp: ");
        directLcd.print(Temperature);
        directLcd.setCursor(0, 2);
        directLcd.print("Luftdruck: ");
        directLcd.print(Airpressure);
        directLcd.setCursor(0, 3);
        directLcd.print("Hum: ");
        directLcd.print(Humidity);
      }
      else if (displayCounter < changeScreenThreshold * 2) { //RTC,LOUDNESS,BRIGHTNESS
        displayCounter++;
        directLcd.clear();
        directLcd.print("MESSWERTE (II)");
        directLcd.setCursor(0, 1);
        directLcd.print("CO2: ");
        directLcd.print(CO2);
        directLcd.print(" %");
        directLcd.setCursor(0, 2);
        directLcd.print("Helligkeit: ");
        directLcd.print(LDR);
        directLcd.print(" %");
        directLcd.setCursor(0, 3);
        directLcd.print("Lautstaerke: ");
        directLcd.print(LOUD);
      }
      else if (displayCounter < changeScreenThreshold * 3) { //sonstiges
        displayCounter++;
        directLcd.clear();
        directLcd.print("SONSTIGES");
        directLcd.setCursor(0, 1);
        directLcd.print("DATEI: ");
        directLcd.print(fileName);
        directLcd.setCursor(0, 2);
        directLcd.print("AUFZEICHNUNG ");
        if (recording) {
          directLcd.print("LAEUFT");
        }
        else {
          directLcd.print("GESTOPPT");
        }
        directLcd.setCursor(0, 3);
        directLcd.print("MODUS: ");
        if (physik) {
          directLcd.print("PHYSIK");
        }
        else {
          directLcd.print("GEOGRAPHIE");
        }
      }
      else if (displayCounter < changeScreenThreshold * 7) { //gaswerte
        displayCounter++;
        directLcd.clear();
        directLcd.print("GAS-SENSOREN");
        directLcd.setCursor(0, 1);
        directLcd.print("ROHWERT: ");
        directLcd.print(CO2);
      }
      else {
        displayCounter = 0;
      }
    }
  }
}

String getTimeName() {
  time_t t = RTC.get(); //get current UNIX-Timestamp from the Temperaturecompensated Oscillator of the DS3132 Real-Time-Clock
  //problem sind die 8.3 dateinamen mit maximallï¿½nge von 12 zeichen (8 fï¿½r den dateinamen und 4 z.b. .csv fï¿½r die dateiendung
  String a = "";
  int zwsp = 0;
  zwsp = month(t);
  if (zwsp < 10) {
    a += "0";
  }
  a += zwsp;
  zwsp = day(t);
  if (zwsp < 10) {
    a += "0";
  }
  a += zwsp;
  zwsp = hour(t);
  if (zwsp < 10) {
    a += "0";
  }
  a += zwsp;
  zwsp = minute(t);
  if (zwsp < 10) {
    a += "0";
  }
  a += zwsp;
  a += ".csv";
  return a;
}

void iterateMenu() {
  if (millis() - lastMenuTime > 300) {
    lastMenuTime = millis();
    Serial.println("MENU");
    if (menuPage == 0) { //recording
      menuPage = 1;
      Serial.println("RECORDING");
      needsUpdate = true;
    }
    else if (menuPage == 1) { //GeoPhysik
      menuPage = 2;
      needsUpdate = true;
      Serial.println("GEO");
    }
    else if (menuPage == 2) { //directLcdON/OFF
      Serial.println("LCD");
      menuPage = 3;
      needsUpdate = true;
    }
    else {
      menuPage = 0;
      Serial.println("OFF");
      needsUpdate = true;
    }
  }
}

void increaseValue() {
  if (millis() - lastValueTime > 300) {
    lastValueTime = millis();
    if (menuPage == 1) {
      needsValueUpdate = true;
    }
    else if (menuPage == 2) {
      needsValueUpdate = true;
    }
    else if (menuPage == 3) {
      needsValueUpdate = true;
    }
  }
}

void createChars() {
  indirectLcd.createChar('0', AE);
  indirectLcd.createChar(1, OE);
  indirectLcd.createChar(2, UE);
  directLcd.createChar('0', AE);
  directLcd.createChar(1, OE);
  directLcd.createChar(2, UE);
}

void sleepUntil(int HT, int MT) {
  pwr = false;
  detachInterrupt(ValueInterruptNumber);
  nextWake += wakeRate;
  if (nextWake > 23) {
    nextWake -= 24;
  }
  t = RTC.get();
  byte HC = hour(t);
  byte MC = minute(t);
  if (HT < HC) {
    HT += 24;
  }
  byte HTS = HT - HC;
  if (MT < MC) {
    HTS--;
    MT += 60;
  }
  int MTS = MT - MC;
  MTS += HTS * 60;
  MTS *= 7.5;
  for (; MTS > 0; MTS--) {
    sleep8S();
  }
  pwr = true;
  initBoard();
}

void sleep8S() {
  LowPower.powerDown(SLEEP_8S, ADC_OFF, BOD_OFF);
  //http://www.rocketscream.com/blog/2011/07/04/lightweight-low-power-arduino-library/
}

void poweroff() {}

void poweron() {}

void flipServo() {
  servoIsTipped != servoIsTipped;
  if (servoIsTipped) {
    for (; servoValue < SERVO_MAX; servoValue++) {
      servo.write(servoValue);
      delay(10);
    }
  }
  else {
    for (; servoValue > SERVO_MIN; servoValue--) {
      servo.write(servoValue);
      delay(10);
    }
  }
}
