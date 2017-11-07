#include "DS3232RTC.h"
#include <TimeLib.h>
#include <Time.h>
#include <LiquidCrystal_I2C.h>
#include <Wire.h>
#include <SPI.h>
#include <SD.h>
#include <Adafruit_Sensor.h>
#include <Adafruit_BME280.h>
#include <Servo.h>
#include <LowPower.h>
#include <hx711.h>
#include "MQ135.h"

#define HX711_CLK A0
#define HX711_DAT A1
#define BRIGHTNESS_SENSOR_A_PIN A2
#define BRIGHTNESS_SENSOR_B_PIN A3
#define CO2_PIN A4
#define LOUDNESS_SENSOR_PIN A5


#define SD_PIN 4
#define SERVO_PIN 5
#define PWR_PIN 6

#define SERVO_MAX 180
#define SERVO_MIN 10

#define MenuInterruptNumber 0
#define ValueInterruptNumber 1
#define POWER_ON true
#define POWER_OFF false
#define VERSION "1.0.0.0"

bool pwr=true;

MQ135 CO2_SENSOR=MQ135(CO2_PIN);
LiquidCrystal_I2C directLcd(0x26, 20, 4);
LiquidCrystal_I2C indirectLcd(0x27, 16, 2);
Adafruit_BME280 BME280;
//Hx711 scale(HX711_DAT, HX711_CLK);
Servo servo;
File file;

void setup() {
  Serial.begin(115200);
  Serial.println("INIT");
}

void loop() {
}
