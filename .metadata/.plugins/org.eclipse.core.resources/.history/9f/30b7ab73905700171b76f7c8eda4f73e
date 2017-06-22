package serialIO.SERIAL;

import java.util.Scanner;
import com.fazecast.jSerialComm.*;

public class SERIAL {
	public static void SEND(String msg) {
		;
	}

	@SuppressWarnings("resource")
	public static String RECIEVE() {
		Scanner data;
		String zwsps = "00000000";
		try {
			SerialPort[] ports = SerialPort.getCommPorts();
			SerialPort serialPort = ports[0];
			serialPort.openPort();
			// serialPort.setComPortParameters(250000, 8, 1,
			// SerialPort.NO_PARITY);
			serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
			data = new Scanner(serialPort.getInputStream());
			System.out.println(data.nextLine());
			zwsps = data.nextLine();
			serialPort.closePort();
		} catch (Exception e) {
			e.printStackTrace();
			return "00000000";
		}
		return zwsps;
	}
}
