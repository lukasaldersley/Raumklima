#include <LiquidCrystal.h>

const int DIRECT_LCD_RS_PIN=49;
const int DIRECT_LCD_E_PIN=47;
const int DIRECT_LCD_CONTRAST_PIN=45;
const int DIRECT_LCD_BACKLIGHT_PIN=44;
const int DIRECT_LCD_D4_PIN=41;
const int DIRECT_LCD_D5_PIN=39;
const int DIRECT_LCD_D6_PIN=37;
const int DIRECT_LCD_D7_PIN=35;
LiquidCrystal directLcd(DIRECT_LCD_RS_PIN,DIRECT_LCD_E_PIN,DIRECT_LCD_D4_PIN,DIRECT_LCD_D5_PIN,DIRECT_LCD_D6_PIN,DIRECT_LCD_D7_PIN);
//INITIALISATION-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
void setup() {
  Serial.begin(115200);
  Serial.println("INITING");

  analogWrite(DIRECT_LCD_CONTRAST_PIN,128);
  analogWrite(DIRECT_LCD_BACKLIGHT_PIN,255);

  directLcd.begin(16,2);
  directLcd.clear();
  directLcd.print("HALLO WELT!");
}

void loop() {
}
