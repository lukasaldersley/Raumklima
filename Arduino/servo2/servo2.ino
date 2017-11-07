/* Sweep
 by BARRAGAN <http://barraganstudio.com>
 This example code is in the public domain.

 modified 8 Nov 2013
 by Scott Fitzgerald
 http://www.arduino.cc/en/Tutorial/Sweep
*/

#include <Servo.h>

Servo servo;  // create servo object to control a servo
// twelve servo objects can be created on most boards

int pos = 0;    // variable to store the servo position

void setup() {
  Serial.begin(115200);
  servo.attach(5);  // attaches the servo on pin 9 to the servo object
}

void loop() {
  if(Serial.available()){
    String X=Serial.readString();
    Serial.println(X);
    int Y=X.toInt();
    if(Y>pos){
      for(;pos<=Y;pos++){
        servo.write(pos);
        delay(10);
      }
      digitalWrite(9,LOW);
    }
    else{
      for(;pos>=Y;pos--){
        servo.write(pos);
        delay(10);
      }
      digitalWrite(9,LOW);
    }
  }
}

