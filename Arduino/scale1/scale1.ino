#include "hx711.h"
#include <LiquidCrystal_I2C.h>
#include <Servo.h>
//#include DigiCDC für serial in digistump
// Hx711.DOUT - pin #A1
// Hx711.SCK - pin #A0
Hx711 scale(A1,A0);
LiquidCrystal_I2C lcd (0x27, 20, 4);
unsigned long value=0;
int cnt=0;
bool reco=false;
 long wgtAvg=0;
void setup() {
  attachInterrupt(0,rec,FALLING);
  scale.setOffset(8408983);
  scale.setScale(412.950292);//     8832670
  Serial.begin(9600);
  Serial.println("Value;Average");
  lcd.init();
  lcd.backlight();
  lcd.clear();
  lcd.print("WERT:");
  lcd.setCursor(0,2);
  lcd.print("Durchschnitt:");
}

void loop() {
  if(reco){
  lcd.setCursor(19,2);
  lcd.print(" M");
  double prev=scale.getGram();
  lcd.setCursor(19,2);
  lcd.print("D");
  lcd.setCursor(19,3);
  lcd.print("M");
  double podt=scale.getGram();
  lcd.setCursor(19,2);
  lcd.print(" ");
  lcd.setCursor(0,1);
  lcd.print("DIFF: ");
  lcd.print(podt-prev);
  lcd.print(" g");
  delay(500);
  lcd.setCursor(19,3);
  lcd.print(" ");
  reco=false;
  }
  cnt++;
  /*long val=scale.averageValue();
  Serial.print(val);
  value+=val;
  Serial.print(";");
  Serial.print(value/cnt);
  Serial.print(";");*/
  lcd.setCursor(19,0);
  lcd.print(" ");
  double wgt=scale.getGram();
  lcd.setCursor(19,0);
  lcd.print("*");
  delay(200);
  Serial.print(wgt);
  lcd.setCursor(7,0);
  lcd.print(wgt);
  lcd.print(" g");
  lcd.print("     ");
  Serial.print(";");
  wgtAvg+=wgt;
  Serial.println(wgtAvg/cnt);
  lcd.setCursor(0,3);
  lcd.print(wgtAvg/cnt);
  lcd.print(" g");
  lcd.print("     ");
}

void rec(){
  reco=true;
}

