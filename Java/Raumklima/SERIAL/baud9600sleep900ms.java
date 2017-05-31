package SCHULE.W_SEMINAR.SERIAL;
import java.util.Scanner;
import com.fazecast.jSerialComm.*;

public class baud9600sleep900ms {
	private static Scanner data;

	public static void main(String[] args) {
		while (true) {
			SerialPort[] ports = SerialPort.getCommPorts();
			SerialPort serialPort = ports[0];
			serialPort.openPort();
			// serialPort.setComPortParameters(9600, 8, 1,
			// SerialPort.NO_PARITY);
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
		}
	}
}