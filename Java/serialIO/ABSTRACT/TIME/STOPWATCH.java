package serialIO.ABSTRACT.TIME;

public class STOPWATCH extends Thread {
	private long startzeit;
	private long stoppzeit;

	public STOPWATCH() {
		// hat nichts zu tun , kann man weglassen.
	}

	public void warte(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// tue nichts !;
		}
	}

	public void starten() {
		startzeit = System.currentTimeMillis();
	}

	public void stoppen() {
		stoppzeit = System.currentTimeMillis();
	}

	public long langAusgeben() {
		return (stoppzeit - startzeit);
	}

	public void konsoleAusgeben() {
		long h = (stoppzeit - startzeit) / 3600000;
		long min = ((stoppzeit - startzeit) / 60000) - h * 60;
		long sec = ((stoppzeit - startzeit) / 1000) - (min * 60 + h * 3600);
		long msec = (stoppzeit - startzeit) - (sec * 1000 + min * 60000 + h * 3600000);
		System.out.println("GESAMTZEIT:");
		System.out.println(h + " h.");
		System.out.println(min + " min.");
		System.out.println(sec + " sec.");
		System.out.println(msec + " msec.");
		/*
		 * System.err.println("GESAMTZEIT:"); System.err.println(h+" h.");
		 * System.err.println(min+" min."); System.err.println(sec +" sec.");
		 * System.err.println(msec+" msec.");
		 */
	}

	public void test() {
		long t = System.currentTimeMillis();
		System.out.println(t);

		long d = (t / 24) / 3600000;
		long h = (t) / 3600000 - d * 24;
		long min = ((t) / 60000) - h * 60;
		long sec = ((t) / 1000) - (min * 60 + h * 3600);
		long msec = (t) - (sec * 1000 + min * 60000 + h * 3600000);
		System.out.println("GESAMTZEIT:");
		System.out.println(d + "tage");
		System.out.println(h + " h.");
		System.out.println(min + " min.");
		System.out.println(sec + " sec.");
		System.out.println(msec + " msec.");
	}

	public String stringAusgeben() {
		return String.valueOf(stoppzeit - startzeit);
	}

	public String retS() {
		long t = stoppzeit - startzeit;
		long d = (t / 24) / 3600000;
		long h = (t) / 3600000 - d * 24;
		long min = ((t) / 60000) - h * 60;
		long sec = ((t) / 1000) - (min * 60 + h * 3600);
		long msec = (t) - (sec * 1000 + min * 60000 + h * 3600000);
		String zwsp = "";
		zwsp += "GESAMTZEIT: " + System.getProperty("line.separator");
		zwsp += d + " tage" + System.getProperty("line.separator");
		zwsp += h + " h." + System.getProperty("line.separator");
		zwsp += min + " min." + System.getProperty("line.separator");
		zwsp += sec + " sec." + System.getProperty("line.separator");
		zwsp += msec + " msec." + System.getProperty("line.separator");
		return zwsp;
	}

	public String retSa() {
		long t = stoppzeit - startzeit;
		long d = (t / 24) / 3600000;
		long h = (t) / 3600000 - d * 24;
		long min = ((t) / 60000) - h * 60;
		long sec = ((t) / 1000) - (min * 60 + h * 3600);
		long msec = (t) - (sec * 1000 + min * 60000 + h * 3600000);
		String zwsp = "\r\n";
		zwsp += "          " + d + " tage" + System.getProperty("line.separator");
		zwsp += "          " + h + " h." + System.getProperty("line.separator");
		zwsp += "          " + min + " min." + System.getProperty("line.separator");
		zwsp += "          " + sec + " sec." + System.getProperty("line.separator");
		zwsp += "          " + msec + " msec." + System.getProperty("line.separator");
		return zwsp;
	}

	public int intAusgeben() {
		return (int) (stoppzeit - startzeit);
	}
}
