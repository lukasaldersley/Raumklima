#include <SPI.h>
#include <SD.h>
const int SD_PIN = 8;
String fileName="lglglglg.txt";
File file;
void setup() {
  Serial.begin(115200);
  Serial.println("SD: "+SD.begin(SD_PIN));
  file=SD.open(fileName);
    while (file.available()) {
      Serial.write(file.read());
    }
    file.close();
}

void loop() {
}
