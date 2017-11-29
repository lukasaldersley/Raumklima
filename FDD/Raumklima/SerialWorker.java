package Raumklima;

import java.io.IOException;
import java.text.ParseException;

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
            try {
                raum.serialWriter.write("GETTIME");
            } catch (IOException e2) {
                raum.logln(e2);
            }
            try {
                Thread.sleep(1500);
            } catch (Exception ex) {
                raum.logln(ex);
            }
            //for(int i=0;i<20;i++) {
            while(true) {
                try{
                    raum.RXDate=raum.serialScanner.nextLine();
                }
                catch(Exception ey){
                    raum.logln(ey);
                }
                if(raum.RXDate.startsWith("TIME: ")) {
                    System.out.println("FOUND THE DATE");
                    break;
                }
                else {
                    System.out.println("HAVNT FOUND TIME YET");
                }

                try {
                    Thread.sleep(100);
                } catch (Exception ex) {
                    raum.logln(ex);
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
            } catch (ParseException e1) {
                raum.logln(e1);
            }
        }
    }
}
