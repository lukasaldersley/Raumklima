#include <avr/sleep.h>
#include <avr/wdt.h>

// watchdog interrupt
ISR (WDT_vect) 
{
   wdt_disable();  // disable watchdog
}  // end of WDT_vect

void setup() {
  Serial.begin(115200);
  Serial.print("VORHER: ");
  Serial.println(millis());
  delay(1000);
  Serial.println(" ");
  sleep(0,18);
  delay(1000);
  Serial.println(" ");
  Serial.print("NACHHER: ");
  Serial.println(millis());
}

void loop() {}


void sleep(int hours, int minutes) {
  long eightSecondsSleepIterations = ((minutes - 15) + (hours * 60)) * 7.5;//sollte auf die zu schlafende zeit -15 minuten kommen
  for (; eightSecondsSleepIterations > 0; eightSecondsSleepIterations--) {
    powerDown();
  }
}

void powerDown(){
  // disable ADC
  ADCSRA = 0;  

  // clear various "reset" flags
  MCUSR = 0;     
  // allow changes, disable reset
  WDTCSR = bit (WDCE) | bit (WDE);
  // set interrupt mode and an interval 
  WDTCSR = bit (WDIE) | bit (WDP3) | bit (WDP0);    // set WDIE, and 8 seconds delay
  wdt_reset();  // pat the dog
  
  set_sleep_mode (SLEEP_MODE_PWR_DOWN);  
  noInterrupts ();           // timed sequence follows
  sleep_enable();
 
  // turn off brown-out enable in software
  //MCUCR = bit (BODS) | bit (BODSE);
  //MCUCR = bit (BODS); 
  interrupts ();             // guarantees next instruction executed
  sleep_cpu ();  
  
  // cancel sleep as a precaution
  sleep_disable();
}
