#include "DS3232RTC.h"
#include <TimeLib.h>
#include <Time.h>
#include <Wire.h>
#define VERSION "1.0.0.0"
time_t t;
String recievedCommand="";

//METHODS--
//

//INITIALISATION-
void setup() {
  Serial.begin(115200);
  time_t tGET = RTC.get();
  Serial.println("TIME: " + String(day(tGET)) + "." + month(tGET) + "." + year(tGET) + " " + hour(tGET) + ":" + minute(tGET) + ":" + second(tGET));  
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
}
