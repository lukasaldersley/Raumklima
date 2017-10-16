#include <Wire.h>

#if defined(__AVR_ATmega328P__)
#include <Adafruit_BME280.h>
#include <Servo.h>
#include <hx711.h>

#define SERVO_PIN 0
#define HX711_CLK 0
#define HX711_DAT 0
#define CO2_PIN A2
#define LOUDNESS_SENSOR_PIN A3
#define BRIGHTNESS_SENSOR_PIN A6

#define SERVO_MAX 180
#define SERVO_MIN 10
Adafruit_BME280 BME280;
Hx711 scale(HX711_DAT, HX711_CLK);
Servo servo;
boolean servoIsTipped = false;
int servoValue = 0;

#elif defined(__AVR_ATmega32U4__)
#include <LowPower.h>
#include <DS3232RTC.h>
#include <TimeLib.h>
#include <LiquidCrystal_I2C.h>
#include <SPI.h>
#include <SD.h>

#define PCB_POWER_PIN 5
#define lcdA_Addr 0x27
#define lcdB_Addr 0x28
#define MenuInterruptNumber 0
#define ValueInterruptNumber 1
#define SD_PIN 4
unsigned long displayCounter = 0;
int changeScreenThreshold = 10;
boolean lcdAEnabled = true;
#endif
#define interPcbBaud 115200

double Temp;
double Air;
double Hum;
double LDR;
double LOUD;
double CO2;
double RAIN;
boolean ph = true; //ob gerät im physik modus
String dataString = "kldj<slkvfhjlkj";

#if defined (__AVR_ATmega32U4__)
byte nextWake = 0;
byte wakeEarly = 5; //definiert, dass der controller 5 minuten früher als die angebene zeit aufwachen soll.
//(damit die sensoren zeit zum reaktivieren haben)
byte wakeRate = 6; //es sollen 6 stunden zwischen den wachphasen vergehen

byte menuPage = 0; //momentan angezeigte seite des menüs
boolean needsUpdate = false; //needs update => einstellungsseite muss angepasst werden
boolean needsValueUpdate = false; //needsValueUpdate => eine variable muss angepasst werden

boolean rc = false; // ob aufgezeichnet wird

String fName = "";
File file;

unsigned long baud = 115200UL;
unsigned long lastMenuTime = 0UL;
unsigned long lastValueTime = 0UL;
bool pwr = true; //hier wird gespeichert ob sich der controller im schlafmodus befinden sollte
time_t t;

LiquidCrystal_I2C lcdA(lcdA_Addr, 20, 4);

LiquidCrystal_I2C lcdB(lcdB_Addr, 16, 2);
#endif
void setup() {
  Serial.println("SETUP BEGINNING");
#if defined (__AVR_ATmega32U4__)
  attachInterrupt(MenuInterruptNumber, iterateMenu, RISING);
#endif
  initBoard();
  Serial.println("SETUP DONE");
}

void loop() {
#if defined (__AVR_ATmega32U4__)

  if (millis() % 1000 < 10) {
    Serial.println("GETTING DATA");
    Serial1.println("GIMME!");
    dataString = Serial1.readString();
    Serial.println("READ DATA");
    Serial.println(dataString);
    if (rc) {
      Serial.println("in RC if");
      printDataToSD(dataString);
      if (!ph) {
        Serial.println("in geo if-- Powering down");
      }
        digitalWrite(PCB_POWER_PIN,LOW);
        sleepUntil(nextWake, 0);
      }
    }
/*
    if (displayCounter < changeScreenThreshold) { //BME280
      displayCounter++;
      lcdA.clear();
      lcdA.print("MESSWERTE (I)");
      lcdA.setCursor(0, 1);
      lcdA.print("Temp: ");
      lcdA.print(Temp);
      lcdA.setCursor(0, 2);
      lcdA.print("Luftdruck: ");
      lcdA.print(Air);
      lcdA.setCursor(0, 3);
      lcdA.print("Hum: ");
      lcdA.print(Hum);
    }
    else if (displayCounter < changeScreenThreshold * 2) { //RTC,LOUDNESS,BRIGHTNESS
      displayCounter++;
      lcdA.clear();
      lcdA.print("MESSWERTE (II)");
      lcdA.setCursor(0, 1);
      lcdA.print("CO2: ");
      lcdA.print(CO2);
      lcdA.print(" %");
      lcdA.setCursor(0, 2);
      lcdA.print("Helligkeit: ");
      lcdA.print(LDR);
      lcdA.print(" %");
      lcdA.setCursor(0, 3);
      lcdA.print("Lautstaerke: ");
      lcdA.print(LOUD);
    }
    else if (displayCounter < changeScreenThreshold * 3) { //sonstiges
      displayCounter++;
      lcdA.clear();
      lcdA.print("SONSTIGES");
      lcdA.setCursor(0, 1);
      lcdA.print("DATEI: ");
      lcdA.print(fName);
      lcdA.setCursor(0, 2);
      lcdA.print("AUFZEICHNUNG ");
      if (rc) {
        lcdA.print("LAEUFT");
      }
      else {
        lcdA.print("GESTOPPT");
      }
      lcdA.setCursor(0, 3);
      lcdA.print("MODUS: ");
      if (ph) {
        lcdA.print("PHYSIK");
      }
      else {
        lcdA.print("GEOGRAPHIE");
      }
    }
    else {
      displayCounter = 0;
    }

    if (needsUpdate) {
      if (menuPage == 0) {
        needsUpdate = false;
        lcdB.noBacklight();
        lcdB.clear();
      }
      else if (menuPage == 1) {
        needsUpdate = false;
        lcdB.backlight();
        lcdB.clear();
        lcdB.print("AUFZEICHNUNG:");
        lcdB.setCursor(0, 1);
        if (rc) {
          lcdB.print("LÄUFT");
        }
        else {
          lcdB.print("GESTOPPT");
        }
      }
    }
    else if (menuPage == 2) {
      needsUpdate = false;
      lcdB.clear();
      lcdB.print("FACHSCHAFT:");
      lcdB.setCursor(0, 1);
      if (ph) {
        lcdB.print("PHYSIK");
      }
      else {
        lcdB.print("GEOGRAPHIE");
      }
    }
    else if (menuPage == 3) {
      needsUpdate = false;
      lcdB.clear();
      lcdB.print("HAUPT-LCD STATUS");
      lcdB.setCursor(0, 1);
      if (lcdAEnabled) {
        lcdB.print("AN");
      }
      else {
        lcdB.print("AUS");
      }
    }
    else {
      needsUpdate = false;
      lcdB.clear();
      lcdB.noBacklight();
    }
  }

  if (needsValueUpdate) {
    if (menuPage == 1) {
      needsValueUpdate = false;
      rc = !rc;
      lcdB.clear();
      lcdB.print("AUFZEICHNUNG:");
      lcdB.setCursor(0, 1);
      if (rc) {
        fileName();
        file = SD.open(fName, FILE_WRITE);
        if (file) {
          file.print("Temperatur;Luftfeuchtigkeit;Luftdruck;Helligkeit;Lautstärke;CO2-Level");
          if (!ph) {
            file.print("Niederschlagsmenge");
          }
          file.println("");
          file.close();
          //lcdA.print("OK");
        }
        else {//RETRY ONCE MORE
          file = SD.open(fName, FILE_WRITE);
          if (file) {
            Serial.println("SD FAILED ONCE While writing the titles");
            file.print("Temperatur;Luftfeuchtigkeit;Luftdruck;Helligkeit;Lautstärke;CO2-Level");
            if (!ph) {
              file.print("Niederschlagsmenge");
            }
            file.println("");
            file.close();
            //lcdA.print("OK");
          }
          else {
            Serial.println("SD FAILED twice While writing the titles");
            lcdB.print("NICHT mÃ¶glich!");
          }
        }

        lcdB.print("LAEUFT");
      }
      else {
        lcdB.print("GESTOPPT");
      }
    }
    else if (menuPage == 2) {
      needsValueUpdate = false;
      ph = !ph;
      lcdB.clear();
      lcdB.print("AUFZEICHNUNG");
      lcdB.setCursor(0, 1);
      lcdB.print("WURDE GESTOPPT");
      delay(2000);
      lcdB.clear();
      lcdB.print("FACHSCHAFT:");
      lcdB.setCursor(0, 1);
      if (ph) {
        lcdB.print("PHYSIK");
      }
      else {
        lcdB.print("GEOGRAPHIE");
      }
    }
    else if (menuPage == 3) {
      needsValueUpdate = false;
      lcdAEnabled = !lcdAEnabled;
      lcdB.clear();
      lcdB.print("HAUPT-LCD STATUS");
      lcdB.setCursor(0, 1);
      if (lcdAEnabled) {
        lcdB.print("AN");
      }
      else {
        lcdB.print("AUS");
      }
      if (lcdAEnabled) {
        lcdA.backlight();
      }
      else {
        lcdA.noBacklight();
      }
    }
  }
*/
#elif defined (__AVR_ATmega328P__)
  if (Serial.available()) {
    String msg = Serial.readString();
    /*if (msg.startsWith("MODE")) {
      if (msg.endsWith("PHYSIK")) {
        ph = true;
      }
      else {
        ph = false;
      }
    }
    else */if (msg.startsWith("GIMME!")) {
      getData();
      Serial.println(dataString);
    }
  }
#endif
}

void initBoard() {
#if defined (__AVR_ATmega32U4__)
digitalWrite(PCB_POWER_PIN,HIGH);
  Serial.begin(baud);
  Serial1.begin(interPcbBaud);
  attachInterrupt(ValueInterruptNumber, increaseValue, RISING);
  lcdA.init();
  lcdB.init();
  SD.begin(SD_PIN);
#elif defined (__AVR_ATmega328P__)
Serial.begin(interPcbBaud);
Serial.println("FUCK OFF");
  BME280.begin();
#endif
}

#if defined (__AVR_ATmega328P__)
void getData() {
  Temp = BME280.readTemperature();
  Air = BME280.readPressure() / 1000; // /1000 um von Pa auf kPa umzurechnen
  Hum = BME280.readHumidity();

  LDR = analogRead(BRIGHTNESS_SENSOR_PIN);
  LDR = map(LDR, 0, 1023, 100, 0);
  LOUD = analogRead(LOUDNESS_SENSOR_PIN);
  LOUD = map(LOUD, 0, 1023, 100, 0);
  CO2 = analogRead(CO2_PIN);
  CO2 = map(CO2, 0, 1023, 100, 0);
  dataString == String(Temp) + ";" + Hum + ";" + Air + ";" + LDR + ";" + LOUD + ";" + CO2;
  if (!ph) {
    RAIN = scale.getGram();
    flipServo();
    RAIN = scale.getGram() - RAIN;
    flipServo();
    dataString += ";";
    dataString += RAIN;
  }
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
#endif

#if defined (__AVR_ATmega32U4__)
void printDataToSD(String data) {
  file.close();
  file = SD.open(fName, FILE_WRITE);
  if (file) {
    file.println(data);
    file.close();
  }
  else {
    file = SD.open(fName, FILE_WRITE);
    if (file) {
      file.println(data);
      file.close();
    }
    else {
      Serial.println("SD FAILED");
    }
  }
  file.close();
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

void fileName() {
  t = RTC.get();
  fName = "";
  byte b = month(t);
  if (b < 10) {
    fName += "0";
  }
  fName += b;
  b = day(t);
  if (b < 10) {
    fName += "0";
  }
  fName += b;
  b = hour(t);
  if (b < 10) {
    fName += "0";
  }
  fName += b;
  b = minute(t);
  if (b < 10) {
    fName += "0";
  }
}

void iterateMenu() {
  if (!pwr) {
    initBoard();
  }
  if (millis() - lastMenuTime > 300) {
    lastMenuTime = millis();
    if (menuPage == 0) { //rc
      menuPage = 1;
      needsUpdate = true;
    }
    else if (menuPage == 1) { //Geoph
      menuPage = 2;
      needsUpdate = true;
    }
    else if (menuPage == 2) { //lcdA ON/OFF
      menuPage = 3;
      needsUpdate = true;
    }
    else {
      menuPage = 0;
      needsUpdate = true;
      if (!pwr) {
        sleepUntil(nextWake - wakeRate, 0); //wieder einschlafen falls vorher aufgewacht
      }
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
#endif
