package serialIO.SERIAL;

import java.util.Scanner;
import com.fazecast.jSerialComm.*;

public class Methodensammlung {
	public static String get(int anzahl) {
		Scanner data;
		try {
			String zwsps = "";
			for (int i = 0; i < anzahl; i++) {
				SerialPort[] ports = SerialPort.getCommPorts();
				SerialPort serialPort = ports[0];
				serialPort.openPort();
				// serialPort.setComPortParameters(9600, 8, 1,
				// SerialPort.NO_PARITY);
				serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
				data = new Scanner(serialPort.getInputStream());
				System.out.println(data.nextLine());
				zwsps = data.nextLine();
				serialPort.closePort();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return zwsps;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "00000000";
	}

	private static Scanner data;

	public static String get() {
		String zwsp = "";
		SerialPort[] ports = SerialPort.getCommPorts();
		SerialPort serialPort = ports[0];
		serialPort.openPort();
		// serialPort.setComPortParameters(9600, 8, 1, SerialPort.NO_PARITY);
		serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
		data = new Scanner(serialPort.getInputStream());
		System.out.println(data.nextLine());
		serialPort.closePort();
		try {
			Thread.sleep(900);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SerialPort[] ports1 = SerialPort.getCommPorts();
		SerialPort serialPort1 = ports1[0];
		serialPort1.openPort();
		// serialPort.setComPortParameters(9600, 8, 1, SerialPort.NO_PARITY);
		serialPort1.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
		data = new Scanner(serialPort1.getInputStream());
		System.out.println(data.nextLine());
		zwsp += data.nextLine();
		serialPort1.closePort();
		return zwsp;
	}
}