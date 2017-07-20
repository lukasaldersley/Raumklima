#include <LiquidCrystal_I2C.h>

LiquidCrystal_I2C lcd(0x27,16,4);

void setup(){
  lcd.init();
  lcd.print("SERVUS");
  lcd.noBacklight();
  delay(1000);
  lcd.backlight();
}

void loop(){
  ;
}

