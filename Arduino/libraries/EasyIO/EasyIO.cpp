#include "EasyIO.h"
#include "avr/io.h"

EasyIO::EasyIO(){
	;
}

EasyIO::void sp(int pin,bool state){
	if(state==true){
		if(pin==13){
			DDRB |=0B00100000;
	}
	else{
		if(pin==13){
			DDRB&^=0B00100000;
	}
}

EasyIO::void setPin(int pin,bool state){
	if(state==true){
		if(pin==13){
			DDRB |=0B00100000;
	}
	else{
		if(pin==13){
			DDRB&^=0B00100000;
	}
}

EasyIO::void sps(int pin,bool state){
	if(state==true){
		if(pin==13){
			DDRB |=0B00100000;
	}
	else{
		if(pin==13){
			DDRB&^=0B00100000;
	}
}

EasyIO::void setPinState(int pin,bool state){
	if(state==true){
		if(pin==13){
			DDRB |=0B00100000;
	}
	else{
		if(pin==13){
			DDRB&^=0B00100000;
	}
}