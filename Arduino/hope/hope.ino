void setup() {
  // put your setup code here, to run once:
pinMode(12,OUTPUT);
pinMode(13,OUTPUT);
}

void loop() {
  digitalWrite(13,!digitalRead(13));
  delay(500);
  digitalWrite(13,!digitalRead(13));
  delay(500);
  digitalWrite(12,!digitalRead(12));
  delay(500);
  digitalWrite(12,!digitalRead(12));
  delay(500);
}
