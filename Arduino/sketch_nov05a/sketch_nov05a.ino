#include "MQ135.h"
#include <SD.h>
MQ135 gasSensor = MQ135(A4);
File file;
void setup() {
  SD.begin(4);
  Serial.begin(115200);
}

void loop() {
  file=SD.open("XXXXXA.txt",FILE_WRITE);
  //float X=gasSensor.getRZero();
  float X=gasSensor.getPPM();
  file.println(X);
  Serial.println(X);
  file.close();
}
