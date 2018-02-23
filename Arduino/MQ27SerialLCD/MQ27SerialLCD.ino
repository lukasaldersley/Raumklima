/* Air Quality Sensor (MQ135) [S037] : http://rdiot.tistory.com/110 [RDIoT Demo] */

//edit by Lukas Aldersley

//libraries
#include <MQ135.h>
#include <LiquidCrystal.h>
#include <SD.h>
#include <Adafruit_Sensor.h>
#include <Adafruit_BME280.h>

//constants
const int pin1 = A0;
const int pin2 = A1;
const long BAUD = 115200;

double TEMP=0,HUM=0,ATM=0,MQ2=0,MQ7=0;

//objects

LiquidCrystal lcd(2,3,4,5,6,7);
MQ135 MQ2S = MQ135(pin1);
MQ135 MQ7S = MQ135(pin2);
Adafruit_BME280 BME280;
File f;

String DATA="";


void setup() {
  Serial.begin(BAUD);       //Initialize Serial monitor
  lcd.begin(16,2);
  if(SD.begin(10)){
    Serial.println("SD OK");
    lcd.print("SD OK");
  }
  else{
    Serial.println("SD FAIL");
    lcd.print("SD FAIL");
  }
  f=SD.open("DATA.csv",FILE_WRITE);
  f.println("MQ2;MQ7;TEMP;HUM;ATM");
  f.close();
  lcd.setCursor(0,1);
  if(BME280.begin()){
    lcd.print("BME280 OK");
    Serial.println("BME280 OK");
  }
  else{
    lcd.print("BME280 FAIL");
    Serial.println("BME280 FAIL");
  }
  Serial.println("MQ2;MQ7;TEMP;HUM;ATM");
  delay(2000);
}

void loop()
{
  DATA="";
  TEMP=BME280.readTemperature();
  ATM=BME280.readPressure()/1000.0;
  HUM=BME280.readHumidity();
  MQ2=MQ2S.getPPM();
  MQ7=MQ7S.getPPM();

  DATA+=String(MQ2)+";"+String(MQ7)+";"+String(TEMP)+";"+String(HUM)+";"+String(ATM);

  f=SD.open("DATA.csv",FILE_WRITE);
  f.println(DATA);
  f.close();
  
  Serial.println(DATA);

  lcd.clear();
  lcd.print("2:"+String(MQ2)+" 7:"+String(MQ7));
  lcd.setCursor(0,1);
  lcd.print("T:"+String(TEMP)+" H:"+String(HUM));
  delay(1000);    //delay for one second
}
