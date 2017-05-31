package SCHULE.W_SEMINAR.SERIAL;
import java.util.Scanner;
import com.fazecast.jSerialComm.*;

public class GetSerial {

	public static String get(int anzahl) {
		Scanner data;
		String zwsps = "00000000";
		try {
			for (int i = 0; i < anzahl; i++) {
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
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return zwsps;
	}

	/*
	 * public static String get(int anzahl,int x){ Scanner data; String
	 * zwsps="00000000"; try{ for(int i=0;i<anzahl;i++){ SerialPort[] ports =
	 * SerialPort.getCommPorts(); SerialPort serialPort = ports[0];
	 * serialPort.openPort(); //serialPort.setComPortParameters(9600, 8, 1,
	 * SerialPort.NO_PARITY);
	 * serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0,
	 * 0); data = new Scanner(serialPort.getInputStream());
	 * System.out.println(data.nextLine()); zwsps=data.nextLine();
	 * serialPort.closePort(); try { Thread.sleep(1000); } catch
	 * (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } } } catch (Exception e){ e.printStackTrace(); }
	 * return zwsps; }
	 * 
	 * public static String get(int anzahl){ Scanner data; try{ String[] zwsps;
	 * String zwspsa=""; zwsps=new String[anzahl]; for(int i=0;i<anzahl;i++){
	 * SerialPort[] ports = SerialPort.getCommPorts(); SerialPort serialPort =
	 * ports[0]; serialPort.openPort(); //serialPort.setComPortParameters(9600,
	 * 8, 1, SerialPort.NO_PARITY);
	 * serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0,
	 * 0); data = new Scanner(serialPort.getInputStream());
	 * System.out.println(data.nextLine()); zwsps[i]=data.nextLine();
	 * serialPort.closePort(); try { Thread.sleep(1000); } catch
	 * (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } } int laenge=0; for(int i=0;i<anzahl;i++){
	 * if(zwsps[i].length()>laenge){ laenge=zwsps[i].length(); zwspsa=zwsps[i];
	 * System.out.println(i); } } return zwspsa; } catch (Exception e){
	 * e.printStackTrace(); } return "00000000"; }
	 */
}