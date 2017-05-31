package SCHULE.W_SEMINAR;
import java.util.Scanner;
import com.fazecast.jSerialComm.*;
import serialIO.IO.DISK.FILE;

public class SERIAL_INTERFACE implements Runnable {
    private Scanner data;
    private String zwsp,zwsp1,zwsp2;
    private int port,baud,trenner,bits,parity;
    private GUI gui;
    private boolean x=true;
    private CSV csv;
    SerialPort serialPort;
    SerialPort[] ports;

    public SERIAL_INTERFACE(GUI gui,CSV csv){
        this.gui=gui;
        this.csv=csv;
        ports = SerialPort.getCommPorts();
    }

    public SerialPort[] getAvailablePorts(){
        return ports;
    }

    public void configureConnection(int port,int baud,int bits,int trenner,int parity){
        this.port=port;
        this.baud=baud;
        this.bits=bits;
        this.trenner=trenner;
        this.parity=parity;
        serialPort = ports[port];
    }

    @Override public void run(){
        if (serialPort.openPort()){
            System.out.println("Port opened successfully.");
            gui.setStatus("Port opened successfully!");
            System.out.println("Delaying to stabilize the serial connection");
            delay(2000);
        }
        else {
            System.out.println("Unable to open the port.");
            gui.setStatus("UNABLE TO OPEN THE PORT--PORT PROBABLY BUSY/OCCUPIED");
            return;
        }
        serialPort.setComPortParameters(baud, bits, trenner,parity);
        // serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 0,
        // 0);
        data = new Scanner(serialPort.getInputStream());
        /*for(int i=0;i<101;i++){//30 sec buffer
        System.out.println("BUILDING BUFFER: "+i+"%");
        gui.setStatus("BUILDING BUFFER: "+i+"%");
        delay(300);
        }*/
        while (true) {
            try{
                if(data.hasNext()){
                    zwsp=data.nextLine();
                    System.out.println("EMPFANGENER WERT(UNVERARBEITET): "+zwsp);

                    if(zwsp.contains("NAN")){
                        gui.setStatus("FEHLER: GER�T VERMUTLICH BESCH�DIGT!!-UNG�LTIGER MESSWERT");
                        //System.err.println("FEHLER: UNG�LTIGER MESSWERT!!");
                        //delay(250);
                        continue;
                    }
                    zwsp.replace(',','.');
                    String zwsps="";
                    for(int i=0;i<zwsp.length();i++){
                        if(zwsp.charAt(i)=='.'||zwsp.charAt(i)==';'||zwsp.charAt(i)==','||zwsp.charAt(i)=='0'||zwsp.charAt(i)=='1'||zwsp.charAt(i)=='2'||zwsp.charAt(i)=='3'||zwsp.charAt(i)=='4'||zwsp.charAt(i)=='5'||zwsp.charAt(i)=='6'||zwsp.charAt(i)=='7'||zwsp.charAt(i)=='8'||zwsp.charAt(i)=='9'){
                            zwsps+=zwsp.charAt(i);
                        }
                    }
                    gui.println(zwsps);
                    csv.println(zwsps);
                    gui.setStatus("RECIEVING, NO ERRORS");
                    System.out.println(zwsp);
                    FILE.WRITE("SensorData.csv",zwsp,true);
                }
            } catch (Exception e) {
                //delay(5000);
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

    public void sendConfig(String params){
        ;
    }
}
