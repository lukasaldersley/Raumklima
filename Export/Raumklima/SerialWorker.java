package Raumklima;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class SerialWorker implements Runnable
{
    Raumklima raum;
    public SerialWorker(Raumklima rk)
    {
        raum=rk;
    }

    @Override
    public void run() {
        if(raum.SerialAvailable) {
            try{
                Thread.sleep(1000);
            }
            catch(Exception e){
                Raumklima.logln(e);
            }
            Raumklima.logln(raum.port.isOpen());
            //for(int x=0;x<10;x++){
                try {
                    raum.serialWriter.write("GETTIME");
                    raum.serialWriter.flush();
                    Raumklima.logln("SENDING INFO");
                } catch (IOException e2) {
                    Raumklima.logln(e2);
                }
                /*try{
                    Thread.sleep(1000);
                }
                catch(Exception exya){
                    raum.logln(exya);
                }	
            }*/
            try {
                Thread.sleep(1500);
            } catch (Exception ex) {
                Raumklima.logln(ex);
            }
            //for(int i=0;i<20;i++) {
            while(true) {
                try{
                    raum.RXDate=raum.serialScanner.nextLine();
                }
                catch(NoSuchElementException ey){
                    continue;
                }
                catch(Exception exy){
                    Raumklima.logln(exy);
                }
                //System.err.println(raum.RXDate);
                Raumklima.logln("\t"+raum.RXDate);
                if(raum.RXDate.startsWith("TIME: ")) {
                    Raumklima.logln("FOUND THE DATE");
                    break;
                }
                else {
                    Raumklima.logln("HAVNT FOUND TIME YET");
                }

                try {
                    Thread.sleep(500);
                } catch (Exception ex) {
                    Raumklima.logln(ex);
                }
            }
            if(raum.RXDate.startsWith("TIME: ")) {
                raum.RXDate=raum.RXDate.replace("TIME: ", "");
                raum.RXDate=raum.RXDate.trim();
            }
            try {
                raum.DeviceDate=raum.DeviceDateFormat.parse(raum.RXDate);
                raum.DeviceMillis=raum.DeviceDate.getTime();
                raum.DeviceTimeFieldTimer.start();
                raum.SetRTCButton.setEnabled(true);
            } catch (ParseException e1) {
                Raumklima.logln(e1);
            }
        }
    }
}
