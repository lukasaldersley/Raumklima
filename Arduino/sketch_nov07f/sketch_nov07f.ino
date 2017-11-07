
#include <Servo.h>
#include <LowPower.h>


#define SERVO_PIN 5
#define SERVO_MAX 180
#define SERVO_MIN 10


boolean servoIsTipped = false;
int servoValue = 10;
Servo servo;
void setup() {
  Serial.begin(115200);
  Serial.println("INIT");
  servo.attach(SERVO_PIN);
  servo.write(SERVO_MIN);
}

void loop() {
  delay(2000);
  Serial.println("FLIP");
  flipServo();
  delay(2000);
  Serial.println("FLIP");
  flipServo();
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
