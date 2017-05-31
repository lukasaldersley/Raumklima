package serialIO.SERIAL;

import java.util.Scanner;
import com.fazecast.jSerialComm.*;

public class jssc {
	private static Scanner data;

	public static void main(String[] args) {

		SerialPort[] ports = SerialPort.getCommPorts();

		SerialPort serialPort = ports[0];
		if (serialPort.openPort())
			System.out.println("Port opened successfully.");
		else {
			System.out.println("Unable to open the port.");
			return;
		}
		// serialPort.setComPortParameters(9600, 8, 1, SerialPort.NO_PARITY);
		// serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 0,
		// 0);

		data = new Scanner(serialPort.getInputStream());
		while (true) {
			try {
				System.out.println(data.nextLine());
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				System.out.println(e.toString());
			}
		}
	}
}
