#include <TimeLib.h>
#include "DS3232RTC.h"
void setup() {
  Serial.begin(115200);
  while(!Serial){
    delay(1);
  }
  Serial.println("I'm alive");
}

void loop() {
  Serial.println("TIME:");
  time_t t = RTC.get();
  Serial.print(day(t));
  Serial.print(".");
  Serial.print(month(t));
  Serial.print(".");
  Serial.print(year(t));
  Serial.print("_");
  Serial.print(hour(t));
  Serial.print(":");
  Serial.print(minute(t));
  Serial.print(":");
  Serial.println(second(t));
  delay(1000);
}
