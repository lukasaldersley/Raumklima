#include <LiquidCrystal.h>
#include "DS3232RTC.h"
#include <TimeLib.h>
#include <LiquidCrystal_I2C.h>
#include <Wire.h>
#include <SPI.h>
#include <SD.h>
#include <DHT.h>
#include <SFE_BMP180.h>
#include <EEPROM.h>
#include <Adafruit_Sensor.h>
#include <Adafruit_BME280.h>



double total_AirPressure;


//INFORMATION----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
/**
   Files/Examples/Websites referenced in this sketch

   Websites:
    -https://www.sunfounder.com/learn/Super-Kit-V2-0-for-Arduino/lesson-8-lcd1602-super-kit.html              File:LCD1602SunFounder.htm
    -https://www.sunfounder.com/learn/Super-Kit-V2-0-for-Arduino/lesson-14-rotary-encoder-super-kit.html      File:ROTATORY_ENCODERSunFounder.htm
   Files/Examples:
    -EEPROM\eeprom_read
    -EEPROM\eeprom_get
    -EEPROM\eeprom_write
    -EEPROM\eeprom_put
    -SD\ReadWrite
*/

//PINS-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//INTERRUPTS VERWENDET:
//Interrupt0 pin 2
//Interrupt1 pin 3
//interrupt5 pin 18
//interrupt4 pin 19
const int SD_PIN = 8;

const int DIRECT_LCD_BRIGHTNESS_PIN = 44;
const int DIRECT_LCD_CONTRAST_PIN = 45;
const int DIRECT_LCD_RS_PIN = 49;
const int DIRECT_LCD_E_PIN = 47;
const int DIRECT_LCD_D4_PIN = 41;
const int DIRECT_LCD_D5_PIN = 39;
const int DIRECT_LCD_D6_PIN = 37;
const int DIRECT_LCD_D7_PIN = 35;
const int INDIRECT_LCD_BRIGHTNESS_PIN = 32;//nur leer
const int INDIRECT_LCD_CONTRAST_PIN = 32;//nur leer

const int MQ_2_PIN = A0;
const int MQ_135_PIN = A1;
const int BRIGHTNESS_PIN = A2;
const int LOUDNESS_PIN = A3;
const int BatteryVoltagePin = 33; //TODO
const int DHT_PIN = 4;
const int TOP_BUTTON_PIN = 3;
const int BOTTOM_BUTTON_PIN = 31;

const int ENCODER_CLK_PIN = 2;  //INTERRUPT0
const int ENCODER_DT_PIN = 9;
const int ENCODER_SW_PIN = 7;

//GENERAL SYSTEM VARS--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
boolean stopped = false;
boolean recording = true;
boolean SD_FAIL = false;
boolean isInSettings = false;
boolean directLcdEnabled = true;
boolean indirectLcdEnabled = false;
boolean isUNO = false;

volatile boolean TurnDetected = false;
volatile boolean up;

unsigned long datasetCounter = 0;
unsigned int displayCounter = 0;

long baudrate = 250000;
int EEPROM_ADDR = 0;
int BMPReadingDelay = 0;

byte directLcdContrast = 120;
byte indirectLcdContrast = 120;
byte directLcdBrightness = 255;
byte indirectLcdBrightness = 255;

String sendoff = "";
String fileName = "";

double ENCODER_VALUE = 0;

byte ungefaehr[8] = {
  0b00000,
  0b01010,
  0b10100,
  0b00000,
  0b01010,
  0b10100,
  0b00000,
  0b00000
};

byte grad[8] = {
  0b00010,
  0b00101,
  0b00010,
  0b00000,
  0b00000,
  0b00000,
  0b00000,
  0b00000
};

byte fehler[8] = {
  0b10101,
  0b11011,
  0b10101,
  0b01010,
  0b01010,
  0b10101,
  0b11011,
  0b10101
};

//DEVICES--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
LiquidCrystal directLcd(DIRECT_LCD_RS_PIN, DIRECT_LCD_E_PIN, DIRECT_LCD_D4_PIN, DIRECT_LCD_D5_PIN, DIRECT_LCD_D6_PIN, DIRECT_LCD_D7_PIN);
//LiquidCrystal_I2C indirectLcd (0x37, 20, 4);
LiquidCrystal_I2C indirectLcd (0x37, 16, 2);
File file;
#define DHTTYPE DHT22
DHT dht(DHT_PIN, DHTTYPE);
SFE_BMP180 BMP180;
Adafruit_BME280 BME280;


//DATA VARS------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
double brightness = 0.00;
double totalTemperature = 0.00;
double RTC_Temperature = 0.00;
double DHT_Temperature = 0.00;
double BMP180_Temperature = 0.00;
double DHT_Heat_Index = 0.00;
double DHT_Humidity = 0.00;
double BMP180_airPressure = 0.00;
double BME280_airPressure = 0.00;
double BME280_Temperature = 0.00;
double BME280_Humidity = 0.00;
double carbonDioxideLevel = 0.00;
double batteryVoltage = 0.00;
double windSpeed = 0.00;
double totalAirPressure = 0.00;
double totalHumidity = 0.00;

//METHODS--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//INITIALISATION-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
void setup() {
  //Serial2.begin(9600);
  pinMode(ENCODER_CLK_PIN, INPUT);
  pinMode(ENCODER_DT_PIN, INPUT);
  pinMode(ENCODER_SW_PIN, INPUT);
  //attachInterrupt (0, encoderTurned, FALLING);
  pinMode(3,INPUT_PULLUP);//ich hab den widerstand auf dem board vergessen deswegen der interne
  attachInterrupt(1, alwaysInterruptButton_Push, FALLING);

  indirectLcd.init();                      //INITIALIZE BOTH LCD-DISPLAYS
  indirectLcdStatus(directLcdEnabled);
  directLcd.begin(20, 4);
  directLcdStatus(indirectLcdEnabled);

  // loadEEPROM_Config();//STORED DATA

  Serial.begin(115200);//INITIALIZE SERIAL COMMUNICATION WITH BLUETOOTH MODULE

  Serial.println("INITING THE CRAP OUT OF THE SYSTEM");
  //SERIAL COMMUNICATION WITH WIFI MODULE
  //Serial3.begin(250000);//INITIALIZE SERIAL COMMUNICATION WITH RASPBERRY PI

  if (!SD.begin(SD_PIN)) { //readWrite Sample   //INITIALIZE SD-CARD
    Serial.println("SD-FAIL");
    directLcd.print("SD-Card FAILED");
    //delay(750);
  }
  else {
    Serial.println("SD-Success");
  }

  createChars();
  fileName = getTimeName();
  Serial.println(fileName);


  file = SD.open(fileName, FILE_WRITE);
  if (file) {
    file.println("Batteriespannung;Luftdruck;CO²-Wert;Helligkeit;Luftfeuchtigkeit;Temperatur(Durchschnitt);Gefühlte temperatur;Windgeschwindigkeit;Temperatur(DHT);Temperatur(DHT-KORRIGIERT);Temperatur(BMP)");
    file.close();
  }
  else {//RETRY ONCE MORE
    file = SD.open(fileName, FILE_WRITE);
    if (file) {
      directLcd.clear();
      directLcd.print("SD FAILED ONCE");
      file.println("Batteriespannung;Luftdruck;CO²-Wert;Helligkeit;Luftfeuchtigkeit;Temperatur(Durchschnitt);Gefühlte temperatur;Windgeschwindigkeit;Temperatur(DHT);Temperatur(DHT-KORRIGIERT);Temperatur(BMP)");
      file.close();
    }
    else {
      directLcd.print("SD FAILED twice");
    }
  }

  dht.begin();
  BMP180.begin();
  BME280.begin();
}

void loadEEPROM_Config() {
  /*
     EEPROM-CONFIG:

      -baudrate
      -directLcdEnabled
      -directLcdContrast
      -directLcdBrightness
      -indirectLcdEnabled
      -indirectLcdContrast
      -indirectLcdBrightness
      -recording
  */
  baudrate = EEPROM.read(EEPROM_ADDR);
  EEPROM_ADDR += sizeof(long);
  directLcdEnabled = EEPROM.read(EEPROM_ADDR);
  EEPROM_ADDR += sizeof(boolean);
  directLcdContrast = EEPROM.read(EEPROM_ADDR);
  EEPROM_ADDR += sizeof(byte);
  directLcdBrightness = EEPROM.read(EEPROM_ADDR);
  EEPROM_ADDR += sizeof(byte);
  indirectLcdEnabled = EEPROM.read(EEPROM_ADDR);
  EEPROM_ADDR += sizeof(boolean);
  indirectLcdContrast = EEPROM.read(EEPROM_ADDR);
  EEPROM_ADDR += sizeof(byte);
  indirectLcdBrightness = EEPROM.read(EEPROM_ADDR);
  EEPROM_ADDR += sizeof(byte);
  recording = EEPROM.read(EEPROM_ADDR);
  EEPROM_ADDR = 0;
}

//GET SENSOR DATA-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
void getSensorData() {
  getDHTValues();
  getBMPValues();
  getBMEValues();
  getBrightnessValues();
  getCarbonDioxideValues();
  getBatteryVoltage();
  getTemperatureValues();
  getPressureValues();
}

void getBMEValues() {
  BME280_Temperature = BME280.readTemperature();
  BME280_airPressure = BME280.readPressure() / 100.00;
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
  BMPReadingDelay = BMP180.getPressure(BMP180_airPressure, BMP180_Temperature);
  delay(BMPReadingDelay);
}

void getPressureValues() {
  total_AirPressure = (BMP180_airPressure + BME280_airPressure) / 2;
}

void getTemperatureValues() {
  totalTemperature = (DHT_Temperature + BMP180_Temperature + BME280_Temperature) / 3;
}

void getCarbonDioxideValues() {
  carbonDioxideLevel = analogRead(7);
}

void getBrightnessValues() {
  brightness = analogRead(BRIGHTNESS_PIN);
}

void getBatteryVoltage() {
  batteryVoltage = ((analogRead(A2) * 15 / 1024) * 1.027);
}

void getWindValue() {
  ;
}

//PREPARE DATA----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
void constructSendoffString() {
  sendoff = "";
  sendoff += BME280_Temperature;
  sendoff += ";";
  sendoff += BME280_Humidity;
  sendoff += ";";
  sendoff += BME280_airPressure;
  sendoff += ";";
  sendoff += BMP180_Temperature;
  sendoff += ";";
  sendoff += BMP180_airPressure;
  sendoff += ";";
  sendoff += total_AirPressure;
  sendoff += ";";
  sendoff += DHT_Temperature;
  sendoff += ";";
  sendoff += DHT_Heat_Index;
  sendoff += ";";
  sendoff += DHT_Humidity;
  sendoff += ";";
  sendoff += totalTemperature;
  sendoff += ";";
  sendoff += batteryVoltage;
  sendoff += ";";
  sendoff += brightness;
  sendoff += ";";
  sendoff += carbonDioxideLevel;
  sendoff += ";";
  sendoff += windSpeed;
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

/*void printDataToUART1(){//BT-Module
  Serial1.println(sendoff);
  }

  void printDataToUART3(){//RASPBERRY PI
  Serial3.println(sendoff);
  }*/

//CRUCIAL SYSTEM METHODS------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
/*void encoderTurned() {
  TurnDetected = true;
  if (digitalRead(ENCODER_CLK_PIN) == digitalRead(ENCODER_DT_PIN)) {
    ENCODER_VALUE++;
  }
  else {
    ENCODER_VALUE--;
  }
  }*/

void(*resetSystem)(void) = 0; //RESETS THE SYSTEM

void directLcdStatus(boolean newStatus) {
  if (newStatus) {
    analogWrite(DIRECT_LCD_CONTRAST_PIN, directLcdContrast);
    analogWrite(DIRECT_LCD_BRIGHTNESS_PIN, directLcdBrightness);
  }
  else {
    digitalWrite(DIRECT_LCD_CONTRAST_PIN, HIGH);
    digitalWrite(DIRECT_LCD_BRIGHTNESS_PIN, LOW);
  }
}

void indirectLcdStatus(boolean newStatus) {
  if (newStatus) {
    analogWrite(INDIRECT_LCD_CONTRAST_PIN, indirectLcdContrast);
    analogWrite(INDIRECT_LCD_BRIGHTNESS_PIN, indirectLcdBrightness);
  }
  else {
    digitalWrite(INDIRECT_LCD_CONTRAST_PIN, HIGH);
    digitalWrite(INDIRECT_LCD_BRIGHTNESS_PIN, LOW);
  }
}

void printScreenOne() { //SetScreen one
  directLcd.clear();
  printToLCD(1, 0, 0, "DHT22-Sensor:   ");
  printToLCD(1, 0, 1, "Feuchtigkeit:");
  printToLCD(1, 13, 1, DHT_Humidity);
  printToLCD(1, 18, 1, "%");
  printToLCD(1, 0, 2, "Temperatur:");
  printToLCD(1, 11, 2, DHT_Temperature);
  writeToLCD(1, 16, 2, "gradC");
  printToLCD(1, 0, 3, "Hitzeindex:");
  printToLCD(1, 11, 3, DHT_Heat_Index);
  writeToLCD(1, 16, 3, "gradC");
}

void printScreenTwo() { //Set Screen two
  directLcd.clear();
  printToLCD(1, 0, 0, "BMP180-Sensor:");
  printToLCD(1, 0, 1, "Temperatur:");
  printToLCD(1, 11, 1, BMP180_Temperature);
  writeToLCD(1, 16, 1, "gradC");
  printToLCD(1, 0, 2, "Luftdruck:");
  printToLCD(1, 10, 2, BMP180_airPressure);
  printToLCD(1, 17, 2, "hPa");
}

void printScreenThree() {
  directLcd.clear();
  printToLCD(1, 0, 0, "BME280-Sensor:");
  printToLCD(1, 0, 1, "Temperatur:");
  printToLCD(1, 11, 1, BME280_Temperature);
  writeToLCD(1, 16, 1, "gradC");
  printToLCD(1, 0, 2, "Luftdruck:");
  printToLCD(1, 10, 2, BME280_airPressure);
  printToLCD(1, 17, 2, "hPa");
  printToLCD(1, 0, 3, "Luftfeuchte:");
  printToLCD(1, 12, 3, BME280_Humidity);
  printToLCD(1, 19, "%");
}

void printScreenFour() { //Set Screen Three
  directLcd.clear();
  printToLCD(1, 0, 0, "MISC");
  printToLCD(1, 0, 1, "Batterie: ");
  printToLCD(1, 10, 1, batteryVoltage);
  printToLCD(1, 15, 1, "V");
  printToLCD(1, 0, 2, "HELLIGKEIT: ");
  printToLCD(1, 11, 2, brightness);
}

void printToLCD(int LCDIdentifier, int XPos, int YPos, String text) {
  if (LCDIdentifier == 1) { //Haupt-Display
    directLcd.setCursor(XPos, YPos);
    directLcd.print(text);
  }
  else {
  }
}

void printToLCD(int LCDIdentifier, int XPos, int YPos, double text) {
  if (LCDIdentifier == 1) { //Haupt-Display
    directLcd.setCursor(XPos, YPos);
    directLcd.print(text);
  }
  else {
  }
}

void createChars() {
  directLcd.createChar(0, fehler);
  directLcd.createChar(1, ungefaehr);
  directLcd.createChar(2, grad);
}

void writeToLCD(int LCDIdentifier, int XPos, int YPos, String txt) {
  byte msg;
  if (txt == "ungefaehr") {
    msg = 1;
  }
  else if (txt == "grad") {
    msg = 2;
  }
  else if (txt == "gradC") {
    msg = 2;
    printToLCD(LCDIdentifier, XPos + 1, YPos, "C");
  }
  else {
    msg = 0;
  }
  if (LCDIdentifier == 1) { //Haupt-Display
    directLcd.setCursor(XPos, YPos);
    directLcd.write(msg);
  }
  else {
  }
}

void loop() {
  getDATA();
  printDataToSD();
  printDataToUART0();
  delay(1000);
  if (displayCounter == 0) {
    printScreenOne();
    displayCounter++;
  }
  else if (displayCounter == 10) {
    printScreenTwo();
    displayCounter++;
  }
  else if (displayCounter == 20) {
    printScreenThree();
    displayCounter++;
  }
  else if (displayCounter == 30) {
    printScreenFour();
    displayCounter ++;
  }
  else if (displayCounter == 40) {
    displayCounter = 0;
  }
  else {
    displayCounter++;
  }
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

