#include "hx711.h"

Hx711 scale(A1, A0);
void setup() {
 Serial.begin(9600);
  scale.setOffset(8751100);
  scale.setScale(414.63);
}

void loop() {
  Serial.println(scale.getGram());
  delay(200);
}
