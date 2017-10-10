#include <Adafruit_BME280.h>
#include <Servo.h>
#include <hx711.h>


#define SERVO_PIN 0
#define HX711_CLK 0
#define HX711_DAT 0
#define CO2_PIN 0
#define LSP 0
#define BSP 0

#define SERVO_MAX 180
#define SERVO_MIN 10
#define PBC_SIG_OUT_PIN 13
#define PBC_SIG_IN_PIN 13


int phSec=1;
boolean ph=true;//ob gerät im physik modus
boolean rc=false;// ob aufgezeichnet wird


double BME_Temp;
double BME_Air;
double BME_Hum;
//double RTC_Temp;
double LDR;
double LOUD;
double CO2;
double RAIN;




Adafruit_BME280 BME280;
Hx711 scale(HX711_DAT,HX711_CLK);
Servo servo;


void loop() {
  if(digitalRead(PCB_SIG_IN_PIN)==HIGH){
    
  }
  if (millis() % phSec*1000 < 10) {
      if (ph) {
      Serial.println(gD(false));
      }
      else {
        Serial.println(gD(true));
        delay(20000);
        sleepUntil(nextWake, 0);
        }
      }
}

String gD(boolean extended){
  BME_Temp = BME280.readTemperature();
  BME_Air = BME280.readPressure() / 1000.00;
  BME_Hum = BME280.readHumidity();
  //RTC_Temp=RTC.temperature()/4.0;
  LDR = analogRead(BSP);
  LDR = map(LDR, 0, 1023, 100, 0);
  LOUD=analogRead(LSP);
  LOUD=map(LOUD,0,1023,100,0);
  CO2=analogRead(CO2_PIN);
  CO2=map(CO2,0,1023,100,0);
  String dS=String(BME_Temp)+";"+BME_Hum+";"+BME_Air+";"+LDR+";"+LOUD+";"+CO2;
  if(extended){
    RAIN=scale.getGram();
    flipServo();
    RAIN=scale.getGram()-RAIN;
    flipServo();
    dS+=";";
    dS+=RAIN;
  }
  return ds;
}

void initBoard() {
  Serial.begin(baud);
  attachInterrupt(VIN,increaseValue,RISING);
  lcdA.init();
  lcdB.init();
  servo.attach(SERVO_PIN);
  BME280.begin();
  scale.setOffset(8408983);
  scale.setScale(412.950292);
  digitalWrite(PCB_SIG_OUT_PIN,HIGH);
}



void flipServo(){}

