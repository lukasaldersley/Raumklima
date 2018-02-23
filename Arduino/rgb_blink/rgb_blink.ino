#define RGB_R 13
#define RGB_G 12
#define RGB_B 11

void setup() {
  pinMode(RGB_R,OUTPUT);
  pinMode(RGB_G,OUTPUT);
  pinMode(RGB_B,OUTPUT);
}

void loop() {
  digitalWrite(RGB_R,!digitalRead(RGB_R));
  delay(150);
  digitalWrite(RGB_R,!digitalRead(RGB_R));
  delay(50);
  digitalWrite(RGB_G,!digitalRead(RGB_G));
  delay(150);
  digitalWrite(RGB_G,!digitalRead(RGB_G));
  delay(50);
  digitalWrite(RGB_B,!digitalRead(RGB_B));
  delay(150);
  digitalWrite(RGB_B,!digitalRead(RGB_B));
  delay(50);
  digitalWrite(RGB_B,!digitalRead(RGB_B));
  digitalWrite(RGB_G,!digitalRead(RGB_G));
  digitalWrite(RGB_R,!digitalRead(RGB_R));
  delay(150);
  digitalWrite(RGB_B,!digitalRead(RGB_B));
  digitalWrite(RGB_G,!digitalRead(RGB_G));
  digitalWrite(RGB_R,!digitalRead(RGB_R));
  delay(50);
}
