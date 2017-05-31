package serialIO.SERIAL;

import java.util.Scanner;
import com.fazecast.jSerialComm.*;

public class Baud2400 {
	private static Scanner data;

	public static void main(String[] args) {
		SerialPort[] ports = SerialPort.getCommPorts();
		SerialPort serialPort = ports[0];
		serialPort.openPort();
		serialPort.setComPortParameters(2400, 8, 1, SerialPort.NO_PARITY);
		while (true) {
			try {
				data = new Scanner(serialPort.getInputStream());
				System.out.println(data.nextLine());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}