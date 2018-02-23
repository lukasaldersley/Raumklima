#include <LiquidCrystal_I2C.h>

LiquidCrystal_I2C directLcd(0x26, 20, 4);
LiquidCrystal_I2C indirectLcd(0x27, 16, 2);

void setup() {
  pinMode(6,OUTPUT);
  digitalWrite(6,HIGH);
  indirectLcd.init();
  directLcd.init();//.begin(20, 4);
  directLcd.backlight();
  indirectLcd.backlight();
}

void loop() {
  // put your main code here, to run repeatedly:

}
