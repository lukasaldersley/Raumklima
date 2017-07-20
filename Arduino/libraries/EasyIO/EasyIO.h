#ifndef EasyIO_h
#define EasyIO_h

#include "avr/io.h"
class EasyIO{
  public:
  EasyIO();
  void sp(int pin,bool state);
  void setPin(int pin,bool state);
  void sps(int pin,bool state);
  void setPinState(int pin,bool state);
};
#endif