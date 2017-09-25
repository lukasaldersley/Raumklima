#include <TimeLib.h>
#include "DS3232RTC.h"
#include <SPI.h>
#include <SD.h>
int minutesBeforeWakeup=1;
int nextWakeTime;
int wtd=1;
const int SD_PIN = 8;
String fileName="lglglglg.txt";
String z="";
File file;
void setup() {
  Serial.begin(115200);
  Serial.println("SD: "+SD.begin(SD_PIN));
}

void loop() {
  file.close();
  file = SD.open(fileName, FILE_WRITE);
  time_t t = RTC.get();
  nextWakeTime=hour(t)+1;
  String tm="";
  tm+=day(t);
  tm+=".";
  tm+=month(t);
  tm+=".";
  tm+=year(t);
  tm+="  ";
  tm+=hour(t);
  tm+=":";
  tm+=minute(t);
  tm+=":";
  tm+=second(t);
  file.println("sendingToSleep: "+tm);
  Serial.println("sendingToSleep: "+tm);
  sleepUntil(nextWakeTime,0);
  t=RTC.get();
  tm="";
  tm+=day(t);
  tm+=".";
  tm+=month(t);
  tm+=".";
  tm+=year(t);
  tm+="  ";
  tm+=hour(t);
  tm+=":";
  tm+=minute(t);
  tm+=":";
  tm+=second(t);
  file.println(z);
  Serial.println("Woken: "+tm);
  file.println("Woken: "+tm);
  file.println(" ");
  Serial.println(" ");
  nextWakeTime+=wtd;
  if(nextWakeTime>23){
    nextWakeTime-=24;
  }
}

void sleepUntil(int HT,int MT){
  time_t t = RTC.get();
  int HC=hour(t);
  int MC=minute(t);
  if(HT<HC){
    HT+=24;
  }
  int HTS=HT-HC;
  if(MT<MC){
    HTS--;
    MT+=60;
  }
  int MTS=MT-MC;
  MTS+=HTS*60;
  sleep(MTS);
}

void sleep(int minutes) {
  long eightSecondsSleepIterations = (minutes - minutesBeforeWakeup) * 7.5;//sollte auf die zu schlafende zeit -15 minuten kommen
  Serial.println(eightSecondsSleepIterations);
  z="\t";
  z+=eightSecondsSleepIterations;
  for(long i=0;i<eightSecondsSleepIterations;i++){
    delay(8000);
  }
}
