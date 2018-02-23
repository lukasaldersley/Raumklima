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
#include "MQ135.h"


#define VERSION "1.5.0.0"




#define SERVO_PIN 5
#define HX711_CLK A0
#define HX711_DAT A1
#define SERVO_MAX 180
#define SERVO_MIN 10

#define MenuInterruptNumber 1
#define ValueInterruptNumber 0
#define SD_PIN 4
#define BRIGHTNESS_SENSOR_A_PIN A2
#define BRIGHTNESS_SENSOR_B_PIN A3
#define LOUDNESS_SENSOR_PIN A5
#define CO2_PIN A4
#define VERSION "1.5.0.0"
#define PWR_PIN 6



bool physik = true;
bool recording = false;
boolean onHold = false;
unsigned long lastInteraction = 0;


String recievedCommand = "";
#define MenuInterruptNumber 1
#define ValueInterruptNumber 0

#define wakeRate 6//Abstand zwischen messungen im GEOGRAPHIE MODUS
#define minutesPriorToWakeTime 2//Wie lange das Gerät vor der eigentlichen messung aufwachen soll; wird gebraucht damit die Sensorik hochfahren kann

int wakes[] = {0, 6, 12, 18};//die zeitpunkte für die Messungen im geo modus


MQ135 CO2_SENSOR = MQ135(CO2_PIN);
Hx711 scale(HX711_DAT, HX711_CLK);
File file;
Adafruit_BME280 BME280;
LiquidCrystal_I2C directLcd(0x26, 20, 4);
LiquidCrystal_I2C indirectLcd(0x27, 16, 2);
Servo servo;


String titles = "Temperatur (in C);Luftfeuchtigkeit (in %);Luftdruck (in hPa);Helligkeit (0%-100%);CO2-Level (ppm);Lautstärke (#Einheit)";

//GENERAL SYSTEM VARS--
boolean directLcdEnabled = true;
boolean indirectLcdEnabled = false;
boolean needsUpdate = false;
boolean needsValueUpdate = false;
boolean sending = false;
boolean  SDFail = true;

int changeScreenThreshold = 10;
int displayCounter = 0;
int menuPage = 0;
int directLcdContrast = 75;
int indirectLcdrightness = 255;

long baudrate = 115200;
String sendoff = "";
String fileName = "NICHTS";

unsigned long counter = 0;
boolean servoIsTipped = false;
unsigned long lastMenuTime = 0;
unsigned long lastValueTime = 0;
unsigned long lastData;

int servoValue = 0;
int phC = 0;
//DATA VARS
double Airpressure = 0.0;
double Temperature = 0.0;
double Humidity = 0.0;
double RTC_Temperature = 0.0;
double LOUD = 0.0;
double LDR = 0.0;
double CO2 = 0.0;
double RAIN = 0.0;
boolean calcPPM=true;


void setup() {
  Serial.begin(115200);
  delay(100);
  initBoard();
}

void initBoard() {
  time_t tGET = RTC.get();
  Serial.println("TIME: " + String(day(tGET)) + "." + month(tGET) + "." + year(tGET) + " " + hour(tGET) + ":" + minute(tGET) + ":" + second(tGET));
}

void getData() {
  Serial.println("GETTING DATA");
}

void printData() {
  Serial.println("SENDING DATA");
}

void printLcd() {
  Serial.println("LCDs");
}

void loop() {
  if (onHold && minute(RTC.get()) == 0) {
    onHold = false;
  }

  if (millis() % 10000 < 10) {
    delay(10);
    getData();
    printLcd();
    if (recording && (!onHold)) {
      if (physik) { //Physik speichern
        printData();
      }
      else { //Geo speichern
        printData();
        goToSleep();
      }
    }
  }










  if (Serial.available()) {//Falls befehle von der Software an das gerät gesendet weren (Einstellungen, Versionsabfragen, Zeitdefinitionen etc. wird das hier verarbeitet
    Serial.println("SERIAL DATA AVAILABLE");
    recievedCommand = Serial.readString();
    recievedCommand.trim();//möglicherweise vorhandenene zeilenvorschübe entfernen
    recievedCommand.replace("\r", "");
    recievedCommand.replace("\n", "");
    recievedCommand.trim();
    Serial.println("RECIEVED: " + recievedCommand);
    if (!recievedCommand.equals("")) {
      if (recievedCommand.startsWith("VERSION")) {
        Serial.println(VERSION);
      }
      else if (recievedCommand.startsWith("MODE")) {
        if (recievedCommand.endsWith("GEO")) {
          physik = false;
          Serial.println("GEO-Modus aktiviert");
        }
        else if (recievedCommand.endsWith("PHYSIK")) {
          physik = true;
          Serial.println("PHYSIK-Modus aktiviert");
        }
        else {
          Serial.println("FEHLER: KEINE KORREKTE EINGABE");
        }
      }
      else if (recievedCommand.startsWith("REC")) {
        if (recievedCommand.endsWith("OFF")) {
          recording = false;
          Serial.println("aufzeichnung deaktiviert");
        }
        else if (recievedCommand.endsWith("ON")) {
          recording = true;
          Serial.println("aufzeichnung aktiviert");
        }
        else {
          Serial.println("FEHLER: KEINE KORREKTE EINGABE");
        }
      }
      else if (recievedCommand.startsWith("GETTIME")) {//RTC zeit senden (für debugging/kontrolle)
        Serial.println("sending time Info:");
        time_t tGET = RTC.get();
        Serial.println("TIME: " + String(day(tGET)) + "." + month(tGET) + "." + year(tGET) + " " + hour(tGET) + ":" + minute(tGET) + ":" + second(tGET));
      }
      else if (recievedCommand.startsWith("TIMEFORMAT")) {
        Serial.println("Um die Uhrzeit der internen Uhr zu ändern geben Sie folgenden Befehl ein: SETTIME 07.11.2017 11:15:00 \r\nErsetzen Sie dabei die Beispielzahlen durch das echte Datum/die echte Uhrzeit.");
      }
      else if (recievedCommand.startsWith("SETTIME")) {//bsp: "SETTIME_02.11.2017_22.13.00"           //setzt die zeit der RTC und gibt die gesetzte zeit zur kontrolle aus
        Serial.println("SETTING TIME");
        time_t tSET;
        tmElements_t tm;
        Serial.println(CalendarYrToTm(recievedCommand.substring(14, 18).toInt()));
        tm.Year = CalendarYrToTm(recievedCommand.substring(14, 18).toInt());
        Serial.println(recievedCommand.substring(11, 13).toInt());
        tm.Month = recievedCommand.substring(11, 13).toInt();
        Serial.println(recievedCommand.substring(8, 10).toInt());
        tm.Day = recievedCommand.substring(8, 10).toInt();
        Serial.println(recievedCommand.substring(19, 21).toInt());
        tm.Hour = recievedCommand.substring(19, 21).toInt();
        Serial.println(recievedCommand.substring(22, 24).toInt());
        tm.Minute = recievedCommand.substring(22, 24).toInt();
        Serial.println(recievedCommand.substring(25, 27).toInt());
        tm.Second = recievedCommand.substring(25, 27).toInt();
        tSET = makeTime(tm);
        Serial.println("TIME (SET): " + String(day(tSET)) + "." + month(tSET) + "." + year(tSET) + " " + hour(tSET) + ":" + minute(tSET) + ":" + second(tSET));
        Serial.print("RETURNED: ");
        Serial.println(RTC.set(tSET));//wenns '0' ist wars erfolgreich, sonst nicht
        time_t tGET = RTC.get();
        Serial.println("TIME (GET): " + String(day(tGET)) + "." + month(tGET) + "." + year(tGET) + " " + hour(tGET) + ":" + minute(tGET) + ":" + second(tGET));
      }
    }
    delay(1000);//zum entschleunigen
  }
}




void goToSleep() {

  time_t tGET = RTC.get();
  Serial.println("DOWN: " + String(hour(tGET)) + ":" + minute(tGET) + ":" + second(tGET));
  time_t C = RTC.get();
  int CH = hour(C);
  int CM = minute(C);
  int SH;
  int SM;
  int arraySize = (sizeof(wakes) / sizeof(int));
  for (int i = 0; i < arraySize; i++) {
    int value = wakes[i] - 1;
    if (value > 23) {
      value -= 24;
    }
    if (value < 0) {
      value += 24;
    }
    if (CH == (value) && CM > 60 - minutesPriorToWakeTime) {
      Serial.println("RENTIERT SICH NICHT");
      return;//es rentiert sich nicht einzuschlafen => einfach wach bleiben
    }
    if (CH < wakes[i] + wakeRate) {
      SH = wakes[i] + wakeRate - 1;
      Serial.print("H: ");
      Serial.println(SH);
      SM = 60 - minutesPriorToWakeTime;
      Serial.print("M: ");
      Serial.println(SM);
      break;
    }
  }

  int HTS = SH - CH;
  int MTS = ((SM + 60) - CM) % 60;
  int MS = HTS * 60 + MTS;
  int CTS = (int)(7.5 * MS);
  Serial.print("CyclesToSleep: ");
  Serial.println(CTS);
  delay(1000);
  for (; CTS > 0; CTS--) {
    Serial.print(".");
    delay(8000);
    //sleep8S();
  }
  onHold = true;
  tGET = RTC.get();
  Serial.println("\r\nUP: " + String(hour(tGET)) + ":" + minute(tGET) + ":" + second(tGET));
}

void sleep8S() {//acht sekunden schlafern (ist die längste zeit, die geschlafen werden kann (abgesehen von "FÜR IMMER", dann krig ich den aber nicht mehr wach außer irgendwer drücht nen knopf
  LowPower.powerDown(SLEEP_8S, ADC_OFF, BOD_OFF);
  //http://www.rocketscream.com/blog/2011/07/04/lightweight-low-power-arduino-library/
}
