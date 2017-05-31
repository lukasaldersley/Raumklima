package SCHULE.W_SEMINAR;
import java.util.Scanner;
import com.fazecast.jSerialComm.*;
import serialIO.IO.DISK.FILE;

public class ArduinoSensorValueCSV {
    private static Scanner data;
    private static String zwsp;
    public static void main(String[] args) {

        SerialPort[] ports = SerialPort.getCommPorts();

        SerialPort serialPort = ports[0];
        if (serialPort.openPort()){
            System.out.println("Port opened successfully.");
            System.out.println("Delaying to stabilize the serial connection");
            delay(2000);
        }
        else {
            System.out.println("Unable to open the port.");
            return;
        }
        serialPort.setComPortParameters(250000, 8, 1, SerialPort.NO_PARITY);
        // serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 0,
        // 0);
        data = new Scanner(serialPort.getInputStream());
        for(int i=0;i<100;i++){//10 sec buffer
            System.out.println("BUILDING BUFFER: "+i+"%");
            delay(100);
        }
        while (true) {
            try {
                zwsp=data.nextLine();
                if(zwsp.contains("NAN")){
                    System.err.println("FEHLER: UNGÜLTIGER MESSWERT!!");
                    continue;
                }
                zwsp.replace(',',';');
                System.out.println(zwsp);
                FILE.WRITE("SensorData["+System.currentTimeMillis()+"].csv",zwsp,true);
                delay(500);
            } catch (Exception e) {
                delay(5000);
                System.out.println(e.toString());
                e.printStackTrace();
                data = new Scanner(serialPort.getInputStream());
            }
        }
    }

    public static void delay(long in){
        try{
            Thread.sleep(in);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
