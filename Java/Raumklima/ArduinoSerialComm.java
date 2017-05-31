package SCHULE.W_SEMINAR;
import java.util.Scanner;
import com.fazecast.jSerialComm.*;
import serialIO.IO.DISK.FILE;

public class ArduinoSerialComm implements Runnable {
    private Scanner data;
    private String zwsp,zwsp1,zwsp2;
    private int port,baud,trenner,bits,parity;
    private GUI gui;
    private boolean x=true;

    public ArduinoSerialComm(int port,int baud,int bits,int trenner,int parity,GUI gui){
        this.port=port;
        this.baud=baud;
        this.bits=bits;
        this.trenner=trenner;
        this.parity=parity;
        this.gui=gui;
    }

    @Override public void run(){

        SerialPort[] ports = SerialPort.getCommPorts();

        SerialPort serialPort = ports[port];
        if (serialPort.openPort()){
            System.out.println("Port opened successfully.");
            System.out.println("Delaying to stabilize the serial connection");
            delay(2000);
        }
        else {
            System.out.println("Unable to open the port.");
            return;
        }
        serialPort.setComPortParameters(baud, bits, trenner,parity);
        // serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 0,
        // 0);
        data = new Scanner(serialPort.getInputStream());
        for(int i=0;i<101;i++){//30 sec buffer
            System.out.println("BUILDING BUFFER: "+i+"%");
            gui.setStatus("BUILDING BUFFER: "+i+"%");
            delay(300);
        }
        while (true) {
            try{
                while(true){
                    zwsp1=data.nextLine();
                    zwsp2=data.nextLine();
                    System.out.println();
                    System.out.println(zwsp1);
                    System.out.println(zwsp2);
                    if(!zwsp1.startsWith("0")){
                        zwsp2=data.nextLine();
                        zwsp1=data.nextLine();                    
                    }
                    String y="";
                    for(int i=2;i<zwsp1.length();i++){
                        y+=zwsp1.charAt(i);
                    }
                    zwsp1=y;
                    y="";
                    for(int i=2;i<zwsp2.length();i++){
                        y+=zwsp2.charAt(i);
                    }
                    zwsp2=y;
                    if(zwsp1.equals(zwsp2)){
                        zwsp=zwsp1;
                        break;
                    }
                }

                if(zwsp.contains("NAN")){
                    gui.setStatus("FEHLER: UNGÜLTIGER MESSWERT!!");
                    //System.err.println("FEHLER: UNGÜLTIGER MESSWERT!!");
                    continue;
                }
                zwsp.replace(',',';');
                String zwsps="";
                for(int i=2;i<zwsp.length();i++){
                    if(zwsp.charAt(i)=='.'||zwsp.charAt(i)==';'||zwsp.charAt(i)==','||zwsp.charAt(i)=='0'||zwsp.charAt(i)=='1'||zwsp.charAt(i)=='2'||zwsp.charAt(i)=='3'||zwsp.charAt(i)=='4'||zwsp.charAt(i)=='5'||zwsp.charAt(i)=='6'||zwsp.charAt(i)=='7'||zwsp.charAt(i)=='8'||zwsp.charAt(i)=='9'){
                        zwsps+=zwsp.charAt(i);
                    }
                }
                gui.println(zwsps);
                gui.setStatus("RECIEVING, NO ERRORS");
                //System.out.println(zwsp);
                //FILE.WRITE("SensorData["+System.currentTimeMillis()+"].csv",zwsp,true);
                delay(500);
            } catch (Exception e) {
                delay(5000);
                gui.setStatus(e.toString());
                System.out.println(e.toString());
                e.printStackTrace();
                data = new Scanner(serialPort.getInputStream());
            }
        }
    }

    public void delay(long in){
        try{
            Thread.sleep(in);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
