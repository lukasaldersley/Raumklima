#include <Keyboard.h>
#include <Mouse.h>
void setup() {
Keyboard.begin();
Mouse.begin();
delay(1000);
Mouse.move(100,100,0);
delay(1000);
Keyboard.press(KEY_RIGHT_GUI);
delay(1000);
Keyboard.release(KEY_RIGHT_GUI);
delay(1000);
Mouse.move(-100,-100-0);
}

void loop() {}
