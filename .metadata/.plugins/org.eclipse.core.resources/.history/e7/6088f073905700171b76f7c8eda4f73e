package serialIO.IO.NETWORK;

import java.net.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JServer {
	static FileWriter writer;
	static File file;

	@SuppressWarnings("resource")
	private static void handleConnection(Socket client) throws IOException {
		String zwsp1 = "";
		String zwsp2 = "";
		Scanner in = new Scanner(client.getInputStream());
		PrintWriter out = new PrintWriter(client.getOutputStream(), true);
		zwsp1 = in.nextLine();
		try {
			zwsp2 = in.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (zwsp2.equals("#KILL")) {
			File datei = new File(zwsp1);
			if (datei.exists()) {
				datei.delete();
			}
		} else if (zwsp2.equals("#LINE")) {
			newLine(zwsp1);
		} else if (zwsp2.equals("#IP")) {
			String erg;
			try {
				URL url = new URL("http://checkip.amazonaws.com/");
				BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
				erg = br.readLine();
			} catch (Exception e) {
				erg = "NULL";
			}
			out.println(erg);
		} else if (zwsp2.equals("#TIME")) {
			out.println(System.currentTimeMillis());
		} else if (zwsp2.equals("#TIME_AND_DATE")) {
			String erg = "hi";
			SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy@HH:mm:ss");
			Date currentTime = new Date();
			erg = formatter.format(currentTime);
			out.println(erg);
		} else if (zwsp2.equals("#EXISTS")) {
			File datei = new File(zwsp1);
			if (datei.exists()) {
				out.println("true");
			} else {
				out.println("false");
			}
		} else if (zwsp2.equals("#ALIVE")) {
			out.println("ALIVE");
		} else {
			schreiben(zwsp1, zwsp2);
		}

	}

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(4321);

		while (true) {
			Socket client = null;

			try {
				client = server.accept();
				handleConnection(client);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (client != null)
					try {
						client.close();
					} catch (IOException e) {
					}
			}
		}
	}

	public static void newLine(String pfad) {
		file = new File(pfad);
		try {
			writer = new FileWriter(file, true);
			writer.write(System.getProperty("line.separator"));
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void schreiben(String pfad, String inhalt) {
		// File anlegen
		file = new File(pfad);
		try {
			// new FileWriter(file ,true) - falls die Datei bereits existiert
			// werden die Bytes an das Ende der Datei geschrieben

			// new FileWriter(file) - falls die Datei bereits existiert
			// wird diese überschrieben
			writer = new FileWriter(file, true);

			// Text wird in den Stream geschrieben
			writer.write(inhalt);

			// Schreibt den Stream in die Datei
			// Sollte immer am Ende ausgeführt werden, sodass der Stream
			// leer ist und alles in der Datei steht.
			writer.flush();

			// Schließt den Stream
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
