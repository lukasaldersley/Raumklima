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
#define POWER_ON true
#define POWER_OFF false
#define VERSION "1.0.0.0"
#define PWR_PIN 6



bool pwr = true; //hier wird gespeichert ob sich der controller im schlafmodus befinden sollte
time_t t;
bool GeoPause=false;
unsigned long lastInteraction=0;

MQ135 CO2_SENSOR = MQ135(CO2_PIN);

Hx711 scale(HX711_DAT, HX711_CLK);
File file;
Adafruit_BME280 BME280;
LiquidCrystal_I2C directLcd(0x26, 20, 4);
LiquidCrystal_I2C indirectLcd(0x27, 16, 2);
Servo servo;

String titles = "Temperatur (in C);Luftfeuchtigkeit (in %);Luftdruck (in hPa);Helligkeit (0%-100%);CO2-Level (ppm);Lautstärke (#Einheit)";

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
int indirectLcdrightness = 255;

long baudrate = 115200;
String sendoff = "";
String fileName = "NICHTS";
String recievedCommand = "";

unsigned long lastMenuTime = 0;
unsigned long lastValueTime = 0;
unsigned long lastData;
unsigned long counter = 0;
boolean servoIsTipped = false;
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

//METHODS--
//

//INITIALISATION-
void setup() {
  Serial.begin(115200);
  Serial.println("STARTING");
  for (int i = 0; i < 54; i++) {
    digitalWrite(i, LOW);
  }
  digitalWrite(PWR_PIN, HIGH);
  delay(10);
  Serial.println("HELLO WORLD; I AM INITIALIZING");
  attachInterrupt(MenuInterruptNumber, iterateMenu, RISING);
  servo.attach(SERVO_PIN);
  servo.write(SERVO_MIN);
  scale.setOffset(8751100);
  scale.setScale(414.63);
  initBoard();
}

void initBoard() {
  digitalWrite(PWR_PIN, HIGH);
  Serial.println("INITING");

  //analogWrite(DIRECT_LCD_CONTRAST_PIN, directLcdContrast);
  //analogWrite(DIRECT_LCD_BACKLIGHT_PIN, indirectLcdrightness);

  indirectLcd.init();
  indirectLcd.noBacklight();
  Serial.println("I_DIR_LCD");
  directLcd.init();//.begin(20, 4);
  directLcd.clear();
  directLcd.backlight();
  directLcd.print("Initialisieren...");
  Serial.println("LCD_DONE");
  //pinMode(3, INPUT); //ich hab den widerstand auf dem board vergessen deswegen der interne
  attachInterrupt(ValueInterruptNumber, increaseValue, RISING);
  Serial.println("INTERRUPT");
  directLcd.setCursor(0, 1);
  time_t tGET = RTC.get();
  Serial.println("TIME: " + String(day(tGET)) + "." + month(tGET) + "." + year(tGET) + " " + hour(tGET) + ":" + minute(tGET) + ":" + second(tGET));
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
  Serial.println("SD");

  Serial.println(titles);

  delay(500);
  directLcd.clear();
  directLcd.print("SD-Schreibzugriff:");
  directLcd.setCursor(0, 1);

  directLcd.setCursor(0, 2);
  directLcd.print("BME280: ");
  if (BME280.begin()) {
    directLcd.print("OK");
  }
  else {
    directLcd.print("ERROR");
    Serial.print("!!!WARNING!!!\n\n\nBME280 NOT AVAILABLE\n\n\n!!!WARNING!!!\n\n\n\n\n\n");
    delay(1000);
  }
  delay(500);
}

//OUTPUT DATA--
/*
   Liest die Sensodradten und berechnet falls nötig die durchschnitte
*/
void getData() {
  Temperature = BME280.readTemperature();
  Airpressure = BME280.readPressure() / 100; // /100 um von Pa auf hPa umzurechnen
  Humidity = BME280.readHumidity();

  LDR = analogRead(BRIGHTNESS_SENSOR_A_PIN);
  LDR += analogRead(BRIGHTNESS_SENSOR_B_PIN);
  LDR = LDR / 2.0;
  LDR = map(LDR, 0, 1023, 0, 100);//von ADC-Data in % umwandeln
  LOUD = analogRead(LOUDNESS_SENSOR_PIN);
  LOUD = map(LOUD, 0, 1023, 0, 100);//von ADC-Data in % umwandeln
  CO2 = CO2_SENSOR.getPPM();
  sendoff = String(Temperature) + ";" + Humidity + ";" + Airpressure + ";" + LDR + ";" + CO2 + ";" + LOUD;
  if (recording&&(!physik)&&(!GeoPause)) {
    RAIN = scale.getGram();
    flipServo();//servo auskippen
    RAIN = scale.getGram() - RAIN;
    RAIN = RAIN / 4.8175; //umrechnung von g in mm/m²
    flipServo();//aufrichten
    sendoff += ";";
    sendoff += RAIN;
  }
}

/*
   Shreibt den inhalt der String varaible sendoff in die datei auf der sd-karte, sofern beim start eine sd-karte erkannt wurde
*/
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

/*
   Sendet inhalt der String variable sendoff an den Serielle port
*/
void printDataToUART0() { //Main Serial Port
  Serial.println(sendoff);
}

void loop() {
  /*if ((!pwr)&&(!GeoPause)&&millis()>lastInteraction) { //board SOLLTE im schalfmodus sein und NICHT in der normalen ausführung und wird deshalb in den schlafmodus geschickt
    directLcd.noBacklight();
    indirectLcd.noBacklight();
    sleepUntil(nextWake, minutesPriorToWakeTime);
  }*/

  if (Serial.available()) {//Falls befehle von der Software an das gerät gesendet weren (Einstellungen, Versionsabfragen, Zeitdefinitionen etc. wird das hier verarbeitet
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
      else if (recievedCommand.startsWith("LCD")) {//Haupt lcd status setzen
        directLcdEnabled = recievedCommand.endsWith("ON");
        if (directLcdEnabled) {
          directLcd.backlight();
        }
        else {
          directLcd.noBacklight();
        }
      }
      else if (recievedCommand.startsWith("REC")) {//status der aufzeichnung setzen
        recording = recievedCommand.endsWith("ON");
        Serial.print("REC: ");
        Serial.println(recording);
        if (recording) {
          fileName = getTimeName();//von der RTC die zeit holenn und nen dateinamen draus basteln
          file = SD.open(fileName, FILE_WRITE);
          if (file) {//Titelzeile für die Aufzeichnung schreiben
            if (physik) {
              file.println(titles);
            }
            else {
              file.println(titles + ";Niederschlagsmenge (in mm)");
            }
            file.close();
            Serial.println("OK");
          }
          else {
            Serial.println("FAIL");
          }
        }
        else {
          Serial.println("N/A");
        }
      }
      else if (recievedCommand.startsWith("GETTIME")) {//RTC zeit senden (für debugging/kontrolle)
        Serial.println("sending time Info:");
        time_t tGET = RTC.get();
        t = RTC.get();
        Serial.println("TIME: " + String(day(tGET)) + "." + month(tGET) + "." + year(tGET) + " " + hour(tGET) + ":" + minute(tGET) + ":" + second(tGET));
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
        t = RTC.get();
      }
    }
    delay(1000);//zum entschleunigen
  }

  if (!sending) {//für ein noch nicht verwendetes feature (es gibt einen auto-updater, deshalb wird es vermutlich in zukunft verwendet werden

    if (needsUpdate) {//wenn auf eine anderen Menüseite gewechselt wird, geschieht das hier
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
            indirectLcd.print("LAEUFT");
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
      else if(menuPage==4){
        needsUpdate=false;
        indirectLcd.clear();
        indirectLcd.print("GEO-TEST");
        indirectLcd.setCursor(0,1);
        indirectLcd.print("STARTEN");
      }
      else {
        needsUpdate = false;
        indirectLcd.clear();
        indirectLcd.noBacklight();
      }
    }

    if (needsValueUpdate) {//falls teile auf einem Display abgeändert werden müssen bzw. aufzeichnung oder displays an/ausgeschaltet werden, geschieht das hier
      if (menuPage == 1) {//menüseite für die aufzeichnung
        needsValueUpdate = false;
        recording = !recording;
        indirectLcd.clear();
        indirectLcd.print("AUFZEICHNUNG:");
        indirectLcd.setCursor(0, 1);
        if (recording) {//wenn die aufzeichnung noch nicht läuft, starten, sonst stoppen
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
            indirectLcd.print("LAEUFT");
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
              indirectLcd.print("LAEUFT");
            }
            else {
              Serial.println("SD FAILED twice While writing the titles");
              indirectLcd.print("NICHT moeglich!");
            }
          }

        }
        else {
          indirectLcd.print("GESTOPPT");
        }
      }
      else if (menuPage == 2) {//Modus (Physik/GEO)
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
      else if (menuPage == 3) {//LCD-Status
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
      else if (menuPage == 4) {
        needsValueUpdate = false;
        indirectLcd.setCursor(0, 1);
        indirectLcd.print("                ");
        indirectLcd.setCursor(0, 1);
        indirectLcd.print("WARTEN...TARE");
        double TEST = scale.getGram();
        indirectLcd.setCursor(0,1);
        indirectLcd.print("WARTEN...LEEREN");
        delay(1000);
        flipServo();//servo auskippen
        indirectLcd.setCursor(0,1);
        indirectLcd.print("WARTEN...MESSEN");
        TEST = scale.getGram() - TEST;
        delay(1000);
        indirectLcd.setCursor(0,1);
        indirectLcd.print(TEST);
        indirectLcd.print("g - ");
        TEST = TEST / 4.8175; //umrechnung von g in mm/m²
        indirectLcd.print(TEST);
        indirectLcd.print("mm");
        flipServo();//aufrichten
      }
    }

    if (millis() % 1000 < 10) {//hier geschieht das eigentliche: 1x pro Sekunde +/- 10ms (ungefähr)wird überprüft ob daten geholt werden müssen, und ob gezeichnet werden soll.
      //Serial.println("GETTING DATA");
      getData();//sensordaten holen
      if (physik && phC == 10) { //physik und aufzuzeichnender datensatz
        phC = 0;//phC ist der counter damit aufzeichnung nur alle 10 sekunden, reaktion auf einstellungen und live daten aber 1x pro sekunde
        if (recording) {
          printDataToSD();//falls aufgezeichnet werden soll, an die sd schicken
        }
        printDataToUART0();//auf der konsole ausgeben
      }
      else if (physik) { //physik und "Füllmaterial datensatz"
        phC++;
      }
      else if (recording&&lastInteraction-millis()>60000) { //muss geo sein und aufzeichnen
        GeoPause=false;
        directLcd.noBacklight();
        indirectLcd.noBacklight();
        //ausführung kommt hioer nicht mehr raus bios die zeit abgelaufen ist und gemessen wurde
        Serial.println("powerDown: " + getTimeName());//debugging
        digitalWrite(PWR_PIN, LOW); //stromversorgung fürs board abschalten
        delay(2000);//letzes "üms überleben kämpfen" abwaretn
        sleepUntil(nextWake, minutesPriorToWakeTime);//schlafen bis zum nächsten geo-messzeitpunkt aber minutesPriorToWakeTime minuten früher aufwachen, damit die Sensoren aufheizen bzw. sich vorbereiten können
        digitalWrite(PWR_PIN, HIGH); //strom wieder an
        Serial.println("woken: " + getTimeName());//debugging
        initBoard();//sensoren initialisieren
        while (minute(RTC.get()) > 0) {//waren bis die volle stunde erreicht ist
          delay(30000);//abwarten bis die zeit um ist. d.h. die volle stunde erreicht ist. nur alle halbe minute abprüfen
          getData();//manche Sensoren müssen ein paar mal abgefragt werden bis die werte passen
        }
        getData();//endgültig die werte holen
        printDataToSD();//ENDLICH aufzeichnen
      }

      //ALLES WAS FOLGT SIND DIE LIVE-DATEN
      //Ich kommentier des jetz nicht alles, des is mir zu aufwendig
      if (displayCounter < changeScreenThreshold) { //BME280
        displayCounter++;
        directLcd.clear();
        directLcd.print("MESSWERTE (I)");
        directLcd.setCursor(0, 1);
        directLcd.print("Temperatur: ");
        directLcd.print(Temperature);
        directLcd.print(" C");
        directLcd.setCursor(0, 2);
        directLcd.print("Luftdruck: ");
        directLcd.print(Airpressure);
        directLcd.print("hPa");
        directLcd.setCursor(0, 3);
        directLcd.print("Luftfeuchte: ");
        directLcd.print(Humidity);
        directLcd.print("%");
      }
      else if (displayCounter < changeScreenThreshold * 2) { //RTC,LOUDNESS,BRIGHTNESS
        displayCounter++;
        directLcd.clear();
        directLcd.print("MESSWERTE (II)");
        directLcd.setCursor(0, 1);
        directLcd.print("CO2: ");
        directLcd.print(CO2);
        directLcd.print(" ppm");
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
        directLcd.print("AUFZEICHNUNG: ");
        if (recording) {
          directLcd.print("AN");
        }
        else {
          directLcd.print("AUS");
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
        directLcd.print("KEINE ABSOLUTE WERTE");
        directLcd.setCursor(0, 2);
        directLcd.print("NUR FUER ZEITVERLAUF");
        directLcd.setCursor(0, 3);
        directLcd.print("CO2: ");
        directLcd.print(CO2);
        directLcd.print(" ppm");
      }
      else {
        displayCounter = 0;
      }
    }
  }
}

String getTimeName() {
  time_t t = RTC.get(); //momentane zeit von der RTC abfragen
  //problem sind die 8.3 dateinamen mit maximallänge von 12 zeichen (8 für den dateinamen und 4 z.b. .csv für die dateiendung
  String a = "";//String in den alles reingebastelt wird
  //die ganzen "IF" sind um führende nullen hinzubekommen
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
  lastInteraction=millis();
  if((!physik)&&recording){
    GeoPause=true;
  }
  if (millis() - lastMenuTime > 300) {//wenn der letze knopfdruck über 1/3S her ist weitermachen, ansonsten könnten des noch die nachwirkungen vom non-debounced switch (bei interesse googlen) sein
    lastMenuTime = millis();//millis() ist die zeit in millisekunden, die der sketch schon läuft
    //eigentliche aktion beim nächsten loop durchgang
    //um eine seite weiterschalten und am ende zurück zu 0
    if (!pwr) { //des sollte den controller wieder wachbekommen falls man aus versehen des ding schlafen geschickt hat
      pwr = true;
      digitalWrite(PWR_PIN, HIGH);
      initBoard();
    }
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
    else if (menuPage == 3) {
      Serial.println("GEO-DEMO");
      menuPage = 4;
      needsUpdate=true;
    }
    else {
      menuPage = 0;
      Serial.println("OFF");
      needsUpdate = true;
    }
  }
}

void increaseValue() {
  lastInteraction=millis();
  if((!physik)&&recording){
    GeoPause=true;
  }
  if (millis() - lastValueTime > 300) {//gleiches wie bei iteraterMenu
    //verarbeitung im loop
    lastValueTime = millis();
    if (menuPage > 0) {
      needsValueUpdate = true;//solange irgend eine menüseite offen ist im loop ggf zeug anpassen
    }
  }
}

void sleepUntil(int HT, int MT) {//GUTE NACHT
  //der ganze berechnungsquatsch rechent aus wie oft 8 sekunden in die zu schlafende zeit reinpasst
  pwr = false;
  detachInterrupt(ValueInterruptNumber);//damit die buttons nicht nerven
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
  for (; MTS > 0; MTS--) {//je nachdem wie oft 8 sekunden in die zeit reinpasst, wird gepennt
    sleep8S();
  }
  pwr = true;
  nextWake += wakeRate;//organisiert die nächste aufwachzeit für den nächsten durchgang
  if (nextWake > 23) {//passt <uf bei overflow der tagesstunden
    nextWake -= 24;
  }
  initBoard();//sensoren wieder aktivuieren
}

void sleep8S() {//acht sekunden schlafern (ist die längste zeit, die geschlafen werden kann (abgesehen von "FÜR IMMER", dann krig ich den aber nicht mehr wach außer irgendwer drücht nen knopf
  LowPower.powerDown(SLEEP_8S, ADC_OFF, BOD_OFF);
  //http://www.rocketscream.com/blog/2011/07/04/lightweight-low-power-arduino-library/
}

void flipServo() {//Niederschlagsmesser umdrehen
  servoIsTipped = ! servoIsTipped;
  if (!servoIsTipped) {
    Serial.println("UP");
    for (; servoValue > SERVO_MIN; servoValue--) {
      servo.write(servoValue);
      delay(10);
    }
  }
  else {
    Serial.println("DOWNWQARDS");
    for (; servoValue < SERVO_MAX; servoValue++) {
      servo.write(servoValue);
      delay(10);
    }
  }
}
