#include <Mouse.h>
#include <Keyboard.h>
int L = 400;
void setup() {
  Keyboard.begin();
  Mouse.begin();

  delay(1000);
  Keyboard.press(KEY_RIGHT_GUI);
  Keyboard.press('r');
  Keyboard.releaseAll();
  delay(300);
  Keyboard.print("picpick");
  Keyboard.press(KEY_RETURN);
  Keyboard.releaseAll();
  delay(750);
  Keyboard.press(KEY_LEFT_CTRL);
  Keyboard.press('n');
  Keyboard.releaseAll();
  delay(750);
  Keyboard.press(KEY_RETURN);
  Keyboard.releaseAll();
  for (int i = 0; i < 2000; i++) {
    Mouse.move(-1, -1, 0);
    //delay(1);
  }
  for (int i = 0; i < 640; i++) {
    Mouse.move(1, 0, 0);
    //delay(1);
  }
  for (int i = 0; i < 80; i++) {
    Mouse.move(0, 1, 0);
  }
  Mouse.click();
  for (int i = 0; i < 640; i++) {
    Mouse.move(-1, 0, 0);
    //delay(1);
  }
  for (int i = 0; i < 80; i++) {
    Mouse.move(0, -1, 0);
  }
  for (int i = 0; i < 900; i++) {
    Mouse.move(0, 1, 0);
    // delay(1);
  }
  for (int i = 0; i < 200; i++) {
    Mouse.move(1, 0, 0);
    // delay(1);
  }
  Mouse.press();
  for (int i = 0; i < 4; i++) {
    for (int i = 0; i < L; i++) {
      Mouse.move(0, -1, 0);
      delay(1);
    }
    for (int i = 0; i < L; i++) {
      Mouse.move(1, 0, 0);
      delay(1);
    }
    for (int i = 0; i < L / 2; i++) {
      Mouse.move(-1, -1, 0);
      delay(1);
    }
    for (int i = 0; i < L / 2; i++) {
      Mouse.move(-1, 1, 0);
      delay(1);
    }
    for (int i = 0; i < L; i++) {
      Mouse.move(1, 1, 0);
      delay(1);
    }
    for (int i = 0; i < L; i++) {
      Mouse.move(0, -1, 0);
      delay(1);
    }
    for (int i = 0; i < L; i++) {
      Mouse.move(-1, 1, 0);
      delay(1);
    }
    for (int i = 0; i < L; i++) {
      Mouse.move(1, 0, 0);
      delay(1);
    }
  }
  Mouse.release();
  delay(1);
  Mouse.end();
  delay(5000);
  Keyboard.press(KEY_LEFT_ALT);
  Keyboard.press(KEY_F4);
  Keyboard.releaseAll();
  delay(100);
  Keyboard.press(KEY_RIGHT_ARROW);
  Keyboard.releaseAll();
  delay(100);
  Keyboard.press(KEY_RETURN);
  Keyboard.releaseAll();
  delay(1000);
  Keyboard.press(KEY_RIGHT_GUI);
  Keyboard.press('r');
  Keyboard.releaseAll();
  delay(1000);
  Keyboard.print("%userprofile%&Desktop&Raumklima.jar");
  delay(1000);
  Keyboard.press(KEY_RETURN);
  Keyboard.releaseAll();
  delay(2000);
  for (int i = 0; i < 10; i++) {
    Keyboard.write(KEY_TAB);
    delay(10);
  }
  delay(10);
  for (int i = 0; i < 3; i++) {
    Keyboard.write(KEY_DOWN_ARROW);
    delay(10);
  }
  delay(10);
  Keyboard.write(KEY_RETURN);
  delay(100);
  for (int i = 0; i < 6; i++) {
    Keyboard.write(KEY_DOWN_ARROW);
    delay(15);
  }
  delay(20);
  Keyboard.write(KEY_RIGHT_ARROW);
  delay(10);
  Keyboard.write(KEY_RIGHT_ARROW);
  delay(100);
  Keyboard.write(KEY_RETURN);
  delay(3000);
  Keyboard.write(KEY_F11);
  Keyboard.end();
}

void loop() {
  // put your main code here, to run repeatedly:

}
