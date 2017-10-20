#include <Servo.h>
Servo servo;
int pos = 0;
int target = 180;
void setup() {
  servo.attach(9);

  delay(2000);
  servo.write(0);
  delay(20000);
  for(int i=0;i<180;i++){
    servo.write(i);
    delay(20);
  }
}

void loop(){}

