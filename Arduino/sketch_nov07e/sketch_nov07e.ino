
#include <Servo.h>
#include <LowPower.h>
#include <hx711.h>


#define SERVO_PIN 5
#define HX711_CLK A0
#define HX711_DAT A1
#define SERVO_MAX 180
#define SERVO_MIN 10

Hx711 scale(HX711_DAT, HX711_CLK);

boolean servoIsTipped = false;
int servoValue = 10;
Servo servo;
void setup() {
  Serial.begin(115200);
  Serial.println("INIT");
  servo.attach(SERVO_PIN);
  servo.write(SERVO_MIN);
  scale.setOffset(8751100);
  scale.setScale(414.63);
}

void loop() {
  delay(10000);
  float X=scale.getGram();
  Serial.print("PRE: ");
  Serial.println(X);
  delay(2000);
  flipServo();
  delay(2000);
  flipServo();
  X=X-scale.getGram();
  Serial.print("DIFF: ");
  Serial.println(X);
  flipServo();
  for(int i=0;i<3;i++){
    sleep8S();
  }
  flipServo();
}

void sleep8S() {//acht sekunden schlafern (ist die längste zeit, die geschlafen werden kann (abgesehen von "FÜR IMMER", dann krig ich den aber nicht mehr wach außer irgendwer drücht nen knopf
  LowPower.powerDown(SLEEP_8S, ADC_OFF, BOD_OFF);
  //http://www.rocketscream.com/blog/2011/07/04/lightweight-low-power-arduino-library/
}

void flipServo() {//Niederschlagsmesser umdrehen
  servoIsTipped =! servoIsTipped;
  if (!servoIsTipped) {
    Serial.println("UP");
    for (; servoValue > SERVO_MIN; servoValue--) {
      servo.write(servoValue);
      delay(10);
    }
  }
  else {
    Serial.println("DOWNWQARDS");
    for (; servoValue < SERVO_MAX; servoValue++) {
      servo.write(servoValue);
      delay(10);
    }
  }
}
