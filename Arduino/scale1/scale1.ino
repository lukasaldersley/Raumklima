#include "hx711.h"

Hx711 scale(A1,A0);
unsigned long value=0;
int cnt=0;
int wgtAvg=0;
void setup() {
  scale.setOffset(8408983);
  scale.setScale(412.950292);//     8832670
  Serial.begin(9600);
  Serial.println("Value;Average");
}

void loop() {
  long val=scale.averageValue();
  Serial.print(val);
  cnt++;
  value+=val;
  Serial.print(";");
  Serial.print(value/cnt);
  Serial.print(";");
  int wgt=scale.getGram();
  Serial.print(wgt);
  Serial.print(";");
  wgtAvg+=wgt;
  Serial.println(wgtAvg/cnt);
}
