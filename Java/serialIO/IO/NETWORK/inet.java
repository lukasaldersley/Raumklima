package serialIO.IO.NETWORK;

import java.net.*;
import java.util.Enumeration;

public class inet {
	public static void main(String[] args) throws Exception {
		System.out.println("version 1");
		System.out.println("Your Host addr: " + InetAddress.getLocalHost().getHostAddress()); // often
																								// returns
																								// "127.0.0.1"
		Enumeration<NetworkInterface> n = NetworkInterface.getNetworkInterfaces();
		for (; n.hasMoreElements();) {
			NetworkInterface e = n.nextElement();

			Enumeration<InetAddress> a = e.getInetAddresses();
			for (; a.hasMoreElements();) {
				InetAddress addr = a.nextElement();
				System.out.println("  " + addr.getHostAddress());
			}
		}
		System.out.println("version 2");
		try {
			InetAddress inet = InetAddress.getLocalHost();
			InetAddress[] ips = InetAddress.getAllByName(inet.getCanonicalHostName());
			if (ips != null) {
				for (int i = 0; i < ips.length; i++) {
					System.out.println(ips[i]);
				}
			}
		} catch (UnknownHostException e) {

		}
	}
}
