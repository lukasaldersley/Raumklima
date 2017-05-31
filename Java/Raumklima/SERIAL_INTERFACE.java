package SCHULE.W_SEMINAR;

import com.fazecast.jSerialComm.*;

import java.io.*;
public class SERIAL_INTERFACE implements Runnable
{
    BufferedWriter out;
    BufferedReader in;
    SerialPort[] availablePorts;
    SerialPort currentPort;
    public SERIAL_INTERFACE()
    {
        availablePorts=SerialPort.getCommPorts();
    }

    public SerialPort[] getPorts(){
        return availablePorts;
    }   

    public void setup(int portNumber,int baudrate,int dataBits, int stopBits,String parity){
        currentPort=availablePorts[portNumber];
        if(parity.equals("O")){
            currentPort.setComPortParameters(baudrate,dataBits,stopBits,SerialPort.ODD_PARITY);
        }
        else if(parity.equals("E")){
            currentPort.setComPortParameters(baudrate,dataBits,stopBits,SerialPort.EVEN_PARITY);
        }
        else{
            currentPort.setComPortParameters(baudrate,dataBits,stopBits,SerialPort.NO_PARITY);
        }
        currentPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING,0,0);
        out=new BufferedWriter(new OutputStreamWriter(currentPort.getOutputStream()));
        in=new BufferedReader(new InputStreamReader(currentPort.getInputStream()));
    }

    public void write(String message){
        try{
            out.write(message);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public String read(){
        try{
            return in.readLine();
        }
        catch(Exception ex){
            ex.printStackTrace();
            return "";
        }
    }

    @Override public void run(){
        ;
    }
}