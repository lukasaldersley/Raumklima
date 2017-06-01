#include <LiquidCrystal.h>
#include "DS3232RTC.h"
#include <TimeLib.h>
#include <LiquidCrystal_I2C.h>
#include <Wire.h>
#include <SPI.h>
#include <SD.h>
#include <DHT.h>
#include <SFE_BMP180.h>
#include <Adafruit_Sensor.h>
#include <Adafruit_BME280.h>


//INFORMATION----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
/**
   Files/Examples/Websites referenced in this sketch

   Websites:
    -https://www.sunfounder.com/learn/Super-Kit-V2-0-for-Arduino/lesson-8-lcd1602-super-kit.html              File:LCD1602SunFounder.htm
    -https://www.sunfounder.com/learn/Super-Kit-V2-0-for-Arduino/lesson-14-rotary-encoder-super-kit.html      File:ROTATORY_ENCODERSunFounder.htm
   Files/Examples:
    -SD\ReadWrite
*/

//PINS-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

/*INTERRUPTS:
  -pin 2: Interrupt0
  -pin 3: Interrupt1
  -pin 18: interrupt5
  -pin 19: interrupt4

  UNBENUTZBAR WEGEN I²C
  -pin 20 (=SDA): Interrupt5
  -pin 21 (=SCL): Interrupt6
*/

const int SD_PIN = 8;
const int BRIGHTNESS_PIN = A2;
const int LOUDNESS_PIN = A3;
const int DHT_PIN = 4;

//GENERAL SYSTEM VARS--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
unsigned long datasetCounter = 0;//?

long baudrate = 115200;
int BMPReadingDelay = 0;

String sendoff = "";
String fileName = "";

//DEVICES--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
File file;
#define DHTTYPE DHT22
DHT dht(DHT_PIN, DHTTYPE);
SFE_BMP180 BMP180;
Adafruit_BME280 BME280;


//DATA VARS------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

double TOTAL_Temperature = 0.0;
double TOTAL_Humidity = 0.0;
double TOTAL_Airpressure = 0.0;
double DHT_Temperature = 0.0;
double DHT_Humidity = 0.0;
double DHT_Heat_Index = 0.0;
double BMP180_Airpressure = 0.0;
double BMP180_Temperature = 0.0;
double BME280_Airpressure = 0.0;
double BME280_Temperature = 0.0;
double BME280_Humidity = 0.0;
double Loudness = 0.0;
double Brightness = 0.0;

//METHODS--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//INITIALISATION-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
void setup() {
  Serial2.begin(9600);//INITIALIZE SERIAL COMMUNICATION WITH BLUETOOTH MODULE
  Serial.begin(115200);
  Serial.println("INITING");

  pinMode(3, INPUT_PULLUP); //ich hab den widerstand auf dem board vergessen deswegen der interne
  attachInterrupt(1, alwaysInterruptButton_Push, FALLING);

  if (!SD.begin(SD_PIN)) { //readWrite Sample   //INITIALIZE SD-CARD
    Serial.println("SD-FAIL");
  }
  else {
    Serial.println("SD-Success");
  }

  fileName = getTimeName();
  Serial.println(fileName);

  Serial.println("BME280_Temperature;BME280_Humidity;BME280_Airpressure;BMP180_Temperature;BMP180_Airpressure;DHT_Temperature;DHT_HEAT_INDEX;DHT_Humidity;TOTAL_Temperature;TOTAL_Airpressure;TOTAL_Humidity;Brightness;Loudness");


  file = SD.open(fileName, FILE_WRITE);
  if (file) {
    file.println("BME280_Temperature;BME280_Humidity;BME280_Airpressure;BMP180_Temperature;BMP180_Airpressure;DHT_Temperature;DHT_HEAT_INDEX;DHT_Humidity;TOTAL_Temperature;TOTAL_Airpressure;TOTAL_Humidity;Brightness;Loudness");
    file.close();
  }
  else {//RETRY ONCE MORE
    file = SD.open(fileName, FILE_WRITE);
    if (file) {
      Serial.println("SD FAILED ONCE While writing the titles");
      file.println("BME280_Temperature;BME280_Humidity;BME280_Airpressure;BMP180_Temperature;BMP180_Airpressure;DHT_Temperature;DHT_HEAT_INDEX;DHT_Humidity;TOTAL_Temperature;TOTAL_Airpressure;TOTAL_Humidity;Brightness;Loudness");
      file.close();
    }
    else {
      Serial.println("SD FAILED twice While writing the titles");
    }
  }

  dht.begin();
  BMP180.begin();
  BME280.begin();
}

//GET SENSOR DATA-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
void getSensorData() {
  getBMEValues();
  getBMPValues();
  getDHTValues();
  getLoudnessValues();
  getBrightnessValues();
  getTemperatureValues();
  getHumidityValues();
  getPressureValues();
}

void getBMEValues() {
  BME280_Temperature = BME280.readTemperature();
  BME280_Airpressure = BME280.readPressure() / 100.00;
  BME280_Humidity = BME280.readHumidity();
}

void getDHTValues() {//partially from dht22.ino

  //WARNING: THE DHT22-SENSOR IS KNOWN TO BE INRELIABLE AND TO PRODUCE INVALID NUMBERS EVERY QUATER OF AN HOUR OR SO

  double nHum;//GENERATE LOCAL VARIABLES IN ORDER TO NOT OVERWRITE THE KNOWN TO BE GOOD VALUES FROM THE LAST ITERATION WITH INVALID ONES
  double nTem;
  double nHic;

  nHum = dht.readHumidity();
  nTem = dht.readTemperature();
  //nTem = nTem - DHT_Correction_Factor;

  if (isnan(nTem) || isnan(nHum)) {//IF AN ERROR OCCURS RETRY
    nHum = dht.readHumidity();
    nTem = dht.readTemperature();
    //nTem = nTem - DHT_Correction_Factor;
    if (isnan(nTem) || isnan(nHum)) {//IF AN ERROR OCCURS AGAIN JUST GIVE UP AND USE THE OLD VALUE TO PREVENT DOWNSPIKES IN THE FINAL GRAPH; SIMPLY WAIT FOR THE NEXT ITERATION AND RETY AGAIN
      nHum = DHT_Humidity;
      nTem = DHT_Temperature;
    }
  }
  //IF NO ERROR OCCURED ACCEPT THE NEW VALUES AND OVERWRITE THE OLD ONES
  DHT_Humidity = nHum;
  DHT_Temperature = nTem;
  DHT_Heat_Index = dht.computeHeatIndex(DHT_Temperature, DHT_Humidity, false);
}

void getBMPValues() {
  BMPReadingDelay = BMP180.startTemperature();
  delay(BMPReadingDelay);
  BMPReadingDelay = BMP180.getTemperature(BMP180_Temperature);
  delay(BMPReadingDelay);
  BMPReadingDelay = BMP180.startPressure(3);
  delay(BMPReadingDelay);
  BMPReadingDelay = BMP180.getPressure(BMP180_Airpressure, BMP180_Temperature);
  delay(BMPReadingDelay);
}

void getPressureValues() {
  TOTAL_Airpressure = (BMP180_Airpressure + BME280_Airpressure) / 2;
}

void getTemperatureValues() {
  TOTAL_Temperature = (DHT_Temperature + BMP180_Temperature + BME280_Temperature) / 3;
}

void getHumidityValues() {
  TOTAL_Humidity = (DHT_Humidity + BME280_Humidity) / 2.0;
}

void getBrightnessValues() {
  Brightness = analogRead(BRIGHTNESS_PIN);
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
  sendoff += BMP180_Temperature;
  sendoff += ";";
  sendoff += BMP180_Airpressure;
  sendoff += ";";
  sendoff += DHT_Temperature;
  sendoff += ";";
  sendoff += DHT_Heat_Index;
  sendoff += ";";
  sendoff += DHT_Humidity;
  sendoff += ";";
  sendoff += TOTAL_Temperature;
  sendoff += ";";
  sendoff += TOTAL_Airpressure;
  sendoff += ";";
  sendoff += TOTAL_Humidity;
  sendoff += ";";
  sendoff += Brightness;
  sendoff += ";";
  sendoff += Loudness;
  sendoff.replace('.', ',');
}

//OUTPUT DATA-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
void getDATA() {
  getSensorData();
  constructSendoffString();
}

void printDataToSD() {
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

void printDataToUART0() { //Main Serial Port
  Serial.println(sendoff);
}

void printDataToUART2() { //BT-Module
  Serial2.println(sendoff);
}

//CRUCIAL SYSTEM METHODS------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
void(*resetSystem)(void) = 0; //RESETS THE SYSTEM

void loop() {
  getDATA();
  printDataToSD();
  printDataToUART0();
  printDataToUART2();
  delay(1000);
}

String getTimeName() {
  time_t t = RTC.get(); //get current UNIX-Timestamp from the Temperaturecompensated Oscillator of the DS3132 Real-Time-Clock
  //problem sind die 8.3 dateinamen mit maximallänge von 12 zeichen (8 für den dateinamen und 4 z.b. .csv für die dateiendung
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

void alwaysInterruptButton_Push() {
  ;
}

