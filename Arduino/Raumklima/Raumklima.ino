#include <avr/sleep.h>
#include <avr/wdt.h>
#include <Arduino.h>
#include <LiquidCrystal.h>
#include "DS3232RTC.h"
#include <TimeLib.h>
#include <LiquidCrystal_I2C.h>
#include <Wire.h>
#include <SPI.h>
#include <SD.h>
#include <Adafruit_Sensor.h>
#include <Adafruit_BME280.h>
#include <Servo.h>
#include "hx711.h"


//SETUP FOR SLEEP-----------------------------------------------------------------------------------------------------------------------------------------------
//von http://www.gammon.com.au/forum/?id=11497 Sketch H
// watchdog interrupt
ISR (WDT_vect)
{
  wdt_disable();  // disable watchdog
}  // end of WDT_vect


//INFORMATION----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
/**
  Files/Examples/Websites referenced in this sketch

  Websites:
  -https://www.sunfounder.com/learn/Super-Kit-V2-0-for-Arduino/lesson-8-lcd1602-super-kit.html              File:LCD1602SunFounder.htm
  Files/Examples:
  -SD\ReadWrite
*/

//PINS-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

/*INTERRUPTS:
  -pin 2: Interrupt0//MENU
  -pin 3: Interrupt1//increaseValue
  -pin 18: interrupt5
  -pin 19: interrupt4

  UNBENUTZBAR WEGEN Iï¿½C
  -pin 20 (=SDA): Interrupt5
  -pin 21 (=SCL): Interrupt6
*/

const int SD_PIN = 8;
const int BRIGHTNESS_PIN = A2;
const int LOUDNESS_PIN = A3;
const int MQ_2_PIN = A0;
const int MQ_135_PIN = A1;

const int DIRECT_LCD_RS_PIN = 49;
const int DIRECT_LCD_E_PIN = 47;
const int DIRECT_LCD_CONTRAST_PIN = 45;
const int DIRECT_LCD_BACKLIGHT_PIN = 44;
const int DIRECT_LCD_D4_PIN = 41;
const int DIRECT_LCD_D5_PIN = 39;
const int DIRECT_LCD_D6_PIN = 37;
const int DIRECT_LCD_D7_PIN = 35;


const bool POWER_ON = true;
const bool POWER_OFF = false;

byte Port_A;
byte Port_B;
byte Port_C;
byte Port_D;
byte Port_E;
byte Port_F;
byte Port_G;
byte Port_H;
byte Port_J;
byte Port_K;
byte Port_L;

int nextWakeTime;
int minutesPriorToWakeTime = 15;
int wakeTimeDistance = 6;

//GENERAL SYSTEM VARS--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
boolean directLcdEnabled = true;
boolean indirectLcdEnabled = false;
boolean needsUpdate = false;
boolean needsValueUpdate = false;
boolean physik = false;
boolean recording = false;
boolean sending = false;
boolean  SDFail = true;

int changeScreenThreshold = 10;
int displayCounter = 0;
int menuPage = 0;
int directLcdContrast = 75;
int directLcdBrightness = 255;


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
int SERVO_MAX=180;
int SERVO_MIN=10;
const int SERVO_PIN=9;


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


//DEVICES--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
File file;
Adafruit_BME280 BME280;
LiquidCrystal directLcd(DIRECT_LCD_RS_PIN, DIRECT_LCD_E_PIN, DIRECT_LCD_D4_PIN, DIRECT_LCD_D5_PIN, DIRECT_LCD_D6_PIN, DIRECT_LCD_D7_PIN);
LiquidCrystal_I2C indirectLcd(0x27, 16, 2);
Servo servo;


//DATA VARS------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

double TOTAL_Temperature = 0.0;
double BME280_Airpressure = 0.0;
double BME280_Temperature = 0.0;
double BME280_Humidity = 0.0;
double RTC_Temperature = 0.0;
double Loudness = 0.0;
double Brightness = 0.0;
double MQ_2_Value = 0.0;
double MQ_135_Value = 0.0;

//METHODS--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//INITIALISATION-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
void setup() {
  servo.attach(SERVO_PIN);
  Serial.begin(115200);
  Serial.println("INITING");

  analogWrite(DIRECT_LCD_CONTRAST_PIN, directLcdContrast);
  analogWrite(DIRECT_LCD_BACKLIGHT_PIN, directLcdBrightness);

  indirectLcd.init();
  indirectLcd.noBacklight();

  directLcd.begin(20, 4);
  directLcd.clear();
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

  Serial.println("BME280_Temperature;BME280_Humidity;BME280_Airpressure;RTC_Temperature;TOTAL_Temperature;Brightness;Loudness;MQ2;MQ135");

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

//GET SENSOR DATA-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
void getSensorData() {
  getBMEValues();
  getRTCValues();
  getLoudnessValues();
  getBrightnessValues();
  getTemperatureValues();
  getGasValues();
}

void getGasValues() {
  MQ_2_Value = analogRead(MQ_2_PIN) / 10;
  MQ_135_Value = analogRead(MQ_135_PIN) / 10;
}

void getRTCValues() {
  RTC_Temperature = RTC.temperature() / 4.0;
}

void getBMEValues() {
  BME280_Temperature = BME280.readTemperature();
  BME280_Airpressure = BME280.readPressure() / 1000.00;
  BME280_Humidity = BME280.readHumidity();
}

void getTemperatureValues() {
  TOTAL_Temperature = (BME280_Temperature + RTC_Temperature) / 2.0;
}

void getBrightnessValues() {
  Brightness = analogRead(BRIGHTNESS_PIN);
  Brightness = map(Brightness, 0, 1023, 100, 0);
}

void getLoudnessValues() {
  Loudness = analogRead(LOUDNESS_PIN);
}

//PREPARE DATA----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
void constructSendoffString() {
  sendoff = "";
  sendoff += BME280_Temperature;
  sendoff += ";";
  sendoff += BME280_Humidity;
  sendoff += ";";
  sendoff += BME280_Airpressure;
  sendoff += ";";
  sendoff += RTC_Temperature;
  sendoff += ";";
  sendoff += TOTAL_Temperature;
  sendoff += ";";
  sendoff += Brightness;
  sendoff += ";";
  sendoff += Loudness;
  sendoff += ";";
  sendoff += MQ_2_Value;
  sendoff += ";";
  sendoff += MQ_135_Value;
  sendoff += ";";
  sendoff += (double)((millis() - lastData) / 10.0);
  lastData = millis();
  sendoff.replace('.', ',');
}

//OUTPUT DATA-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
void getDATA() {
  getSensorData();
  constructSendoffString();
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

void printDataToUART2() { //BT-Module
  int x = ((int)(sendoff.length()));
  //Serial.println(x);
  for (int i = x; i < 140; i++) { //sollten 140 zeichen sein
    sendoff += "X";
  }
  x = ((int)(sendoff.length()));
  //Serial.println(x);
  Serial2.print(sendoff);
}

//CRUCIAL SYSTEM METHODS------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
void(*resetSystem)(void) = 0; //RESETS THE SYSTEM

void loop() {

  if (Serial.available()) {
    recievedCommand = Serial.readString();
    Serial.println("RECIEVED: " + recievedCommand);
  }
  if (!recievedCommand.equals("")) {
    if (recievedCommand.equals("READY")) {
      if (!SDFail) {
        sending = true;
        Serial.println("OK");
        Serial.println(counter);
        file.close();
        file = SD.open(fileName);
        if (file) {
          for (unsigned long i = 0; i < counter; i++) {
            Serial.println(file.readString());
          }
        }
        else {
          file.close();
          file = SD.open(fileName);
          if (file) {
            for (unsigned long i = 0; i < counter; i++) {
              Serial.println(file.readString());
            }
          }
        }
        sending = false;
      }
      else {
        Serial.print("FAILED");
        //TODO in DESKTOP
      }
    }
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
          indirectLcd.print("NICHT VERFÃœGBAR");
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
            //file.println("BME280_Temperature;BME280_Humidity;BME280_Airpressure;RTC_Temperature;TOTAL_Temperature;TOTAL_Airpressure;TOTAL_Humidity;Brightness;Loudness;MQ2;MQ135;BMP180_Temperature;BMP180_Airpressure;DHT_Temperature;DHT_HEAT_INDEX;DHT_Humidity");
            file.println("BME280_Temperature;BME280_Humidity;BME280_Airpressure;RTC_Temperature;TOTAL_Temperature;Brightness;Loudness;MQ2;MQ135;");
            file.close();
            //directLcd.print("OK");
          }
          else {//RETRY ONCE MORE
            file = SD.open(fileName, FILE_WRITE);
            if (file) {
              Serial.println("SD FAILED ONCE While writing the titles");
              //file.println("BME280_Temperature;BME280_Humidity;BME280_Airpressure;RTC_Temperature;TOTAL_Temperature;TOTAL_Airpressure;TOTAL_Humidity;Brightness;Loudness;MQ2;MQ135;BMP180_Temperature;BMP180_Airpressure;DHT_Temperature;DHT_HEAT_INDEX;DHT_Humidity");
              file.println("BME280_Temperature;BME280_Humidity;BME280_Airpressure;RTC_Temperature;TOTAL_Temperature;Brightness;Loudness;MQ2;MQ135;");
              file.close();
              //directLcd.print("OK");
            }
            else {
              Serial.println("SD FAILED twice While writing the titles");
              indirectLcd.print("NICHT mÃ¶glich!");
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
          analogWrite(DIRECT_LCD_BACKLIGHT_PIN, directLcdBrightness);
          analogWrite(DIRECT_LCD_CONTRAST_PIN, directLcdContrast);
        }
        else {
          analogWrite(DIRECT_LCD_BACKLIGHT_PIN, 0);
          analogWrite(DIRECT_LCD_CONTRAST_PIN, 255);
        }
      }
    }

    if (millis() % 1000 == 0) {
      Serial.println("HALLOUHGOZTUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIISD");
      getDATA();
      if (physik) {
        if (recording) {
          printDataToSD();
        }
        printDataToUART0();
        printDataToUART2();
      }
      else {
        //if(geoReady()){
        //geoMessen();
        Serial.println("powerDown" + getTimeName());
        delay(2000);
        sleepUntil(nextWakeTime, 0);
        Serial.println(getTimeName());
        // }
      }

      if (displayCounter < changeScreenThreshold) { //BME280
        displayCounter++;
        directLcd.clear();
        directLcd.print("BME280-Werte");
        directLcd.setCursor(0, 1);
        directLcd.print("Temp: ");
        directLcd.print(BME280_Temperature);
        directLcd.setCursor(0, 2);
        directLcd.print("Luftdruck: ");
        directLcd.print(BME280_Airpressure);
        directLcd.setCursor(0, 3);
        directLcd.print("Hum: ");
        directLcd.print(BME280_Humidity);
      }
      else if (displayCounter < changeScreenThreshold * 2) { //RTC,LOUDNESS,BRIGHTNESS
        displayCounter++;
        directLcd.clear();
        directLcd.print("SONSTIGES");
        directLcd.setCursor(0, 1);
        directLcd.print("RTC-Temp: ");
        directLcd.print(RTC_Temperature);
        directLcd.setCursor(0, 2);
        directLcd.print("Helligkeit: ");
        directLcd.print(Brightness);
        directLcd.setCursor(0, 3);
        directLcd.print("Lautstaerke: ");
        directLcd.print(Loudness);
      }
      else if (displayCounter < changeScreenThreshold * 3) { //sondtiges
        displayCounter++;
        directLcd.clear();
        directLcd.print("SONSTIGES (II)");
        directLcd.setCursor(0, 1);
        directLcd.print("DATEI: ");
        directLcd.print(fileName);
        directLcd.setCursor(0, 2);
        directLcd.print("AUFZEICHNUNG ");
        if (!SDFail) {
          if (recording) {
            directLcd.print("LAEUFT");
          }
          else {
            directLcd.print("GESTOPPT");
          }
        }
        else {
          directLcd.print("N/A");
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
      else if (displayCounter < changeScreenThreshold * 4) { //temperaturen
        displayCounter++;
        directLcd.clear();
        directLcd.print("TEMPERATUREN");
        directLcd.setCursor(0, 1);
        directLcd.print("BME: ");
        directLcd.print(BME280_Temperature);
        directLcd.setCursor(0, 2);
        directLcd.print("RTC: ");
        directLcd.print(RTC_Temperature);
        directLcd.setCursor(0, 3);
        directLcd.print("DURCHSCHNITT: ");
        directLcd.print(TOTAL_Temperature);
      }
      else if (displayCounter < changeScreenThreshold * 5) { //luftfeuchtigkeiten
        displayCounter++;
        directLcd.clear();
        directLcd.print("LUFTFEUCHTIGKEITEN");
        directLcd.setCursor(0, 1);
        directLcd.print("BME280 ");
        directLcd.print(BME280_Humidity);
      }
      else if (displayCounter < changeScreenThreshold * 6) { //luftdrï¿½cke
        displayCounter++;
        directLcd.clear();
        directLcd.print("LUFTDRUECKE");
        directLcd.setCursor(0, 1);
        directLcd.print("BME280: ");
        directLcd.print(BME280_Airpressure);
      }
      else if (displayCounter < changeScreenThreshold * 7) { //gaswerte
        displayCounter++;
        directLcd.clear();
        directLcd.print("GAS-SENSOREN");
        directLcd.setCursor(0, 1);
        directLcd.print("MQ_2: ");
        directLcd.print(MQ_2_Value);
        directLcd.setCursor(0, 2);
        directLcd.print("MQ_135: ");
        directLcd.print(MQ_135_Value);
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

void PCB_POWER(bool state) {
  if (state == POWER_ON) {
    PORTA = Port_A; //&=B01111111;
    PORTB = Port_B;
    PORTC = Port_C;
    PORTD = Port_D;
    PORTE = Port_E;
    PORTF = Port_F;
    PORTG = Port_G;
    PORTH = Port_H;
    PORTJ = Port_J;
    PORTK = Port_K;
    PORTL = Port_L;
  }
  else {
    //PORTA|=B10000000;
    Port_A = PORTA;
    Port_B = PORTB;
    Port_C = PORTC;
    Port_D = PORTD;
    Port_E = PORTE;
    Port_F = PORTF;
    Port_G = PORTG;
    Port_H = PORTH;
    Port_J = PORTJ;
    Port_K = PORTK;
    Port_L = PORTL;
    PORTA = B00000000;
    PORTB = B00000000;
    PORTC = B00000000;
    PORTD = B00000000;
    PORTE = B00000000;
    PORTF = B00000000;
    PORTG = B00000000;
    PORTH = B00000000;
    PORTJ = B00000000;
    PORTK = B00000000;
    PORTL = B00000000;
  }
}

void sleepUntil(int HT, int MT) {
  nextWakeTime += wakeTimeDistance;
  if (nextWakeTime > 23) {
    nextWakeTime -= 24;
  }
  time_t t = RTC.get();
  int HC = hour(t);
  int MC = minute(t);
  if (HT < HC) {
    HT += 24;
  }
  int HTS = HT - HC;
  if (MT < MC) {
    HTS--;
    MT += 60;
  }
  int MTS = MT - MC;
  MTS += HTS * 60;
  sleep(MTS);
}

void sleep(int minutes) {
  PCB_POWER(POWER_OFF);
  long eightSecondsSleepIterations = (minutes - minutesPriorToWakeTime) * 7.5;//sollte auf die zu schlafende zeit -minutesPriorToWakeTime minuten kommen
  for (; eightSecondsSleepIterations > 0; eightSecondsSleepIterations--) {
    powerDown();
  }
  PCB_POWER(POWER_ON);
}

void powerDown() {
  //von http://www.gammon.com.au/forum/?id=11497 Sketch H
  // disable ADC
  ADCSRA = 0;

  // clear various "reset" flags
  MCUSR = 0;
  // allow changes, disable reset
  WDTCSR = bit (WDCE) | bit (WDE);
  // set interrupt mode and an interval
  WDTCSR = bit (WDIE) | bit (WDP3) | bit (WDP0);    // set WDIE, and 8 seconds delay
  wdt_reset();  // pat the dog

  set_sleep_mode (SLEEP_MODE_PWR_DOWN);
  noInterrupts ();           // timed sequence follows
  sleep_enable();

  // turn off brown-out enable in software
  //MCUCR = bit (BODS) | bit (BODSE);
  //MCUCR = bit (BODS);
  interrupts ();             // guarantees next instruction executed
  sleep_cpu ();

  // cancel sleep as a precaution
  sleep_disable();
}

void flipServo() {
  servoIsTipped != servoIsTipped;
  if (servoIsTipped) {
    for (servoValue = SERVO_MIN; servoValue <= SERVO_MAX; servoValue++) {
      servo.write(servoValue);
      delay(10);
    }
  }
  else {
    for (servoValue = SERVO_MAX; servoValue >= SERVO_MIN; servoValue--) {
      servo.write(servoValue);
      delay(10);
    }
  }
}

