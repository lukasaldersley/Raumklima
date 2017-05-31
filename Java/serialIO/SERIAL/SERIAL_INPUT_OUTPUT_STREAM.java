package serialIO.SERIAL;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import com.fazecast.jSerialComm.SerialPort;

public class SERIAL_INPUT_OUTPUT_STREAM {
	
	static InputStream in=null;
	static OutputStream out=null;
	static BufferedReader inReader;
	static BufferedWriter outWriter;
	
	public static void main(String[] args) {
		SerialPort[] ports = SerialPort.getCommPorts();
		SerialPort serialPort = ports[0];
		serialPort.openPort();
		serialPort.setComPortParameters(115200, 8, 1, SerialPort.NO_PARITY);
		serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 100, 0);
		in=serialPort.getInputStream();
		out=serialPort.getOutputStream();
		inReader=new BufferedReader(new InputStreamReader(in));
		outWriter=new BufferedWriter(new OutputStreamWriter(out));
		String zwsp="";
		while (true) {
			try {
				zwsp=inReader.readLine();
			} catch (IOException e) {
				//e.printStackTrace();
			}
			if(zwsp.contains("CAM")){
				System.out.println(zwsp);
				zwsp="";
				//try {
				//	outWriter.write("ECHO: "+zwsp);
				//} catch (IOException e) {
				//	e.printStackTrace();
				//}
			}
		}
	}
}