package serialIO.IO.NETWORK;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.Scanner;

public class Network {
    Socket server = null;
    static Socket serverS = null;
    static FileWriter writer;
    static File file;
    static String time = "";

    public Network() {
    }

    public void setNameTime(String inp) {
        time = inp;
    }

    public String getMyIP() {
        try {
            URL url = new URL("http://checkip.amazonaws.com/");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            return br.readLine();
        } catch (Exception e) {
            log("                " + e.toString());
        }
        return "NULL";
    }

    public String gip() {
        try {
            URL url = new URL("http://checkip.amazonaws.com/");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            return br.readLine();
        } catch (Exception e) {
        }
        return "NULL";
    }

    public static String getMyIPStatic() {
        try {
            URL url = new URL("http://checkip.amazonaws.com/");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            return br.readLine();
        } catch (Exception e) {
            log("                " + e.toString());
        }
        return "NULL";
    }

    public boolean checkLocalLAN() {
        try {
            URL url2 = new URL("http://1.1.1.1/local.txt");
            BufferedReader br2 = new BufferedReader(new InputStreamReader(url2.openStream()));
            if (br2.readLine().equals("true")) {
                return true;
            }
        } catch (Exception e) {
            log("                " + e.toString());
        }
        return false;
    }

    public boolean checkLocal() {
        try {
            URL url2 = new URL("http://192.168.2.117/local.txt");
            BufferedReader br2 = new BufferedReader(new InputStreamReader(url2.openStream()));
            if (br2.readLine().equals("true")) {
                return true;
            }
        } catch (Exception e) {
            log("                " + e.toString());
        }
        return false;
    }

    public boolean checkLocalCanonicalName() {
        try {
            URL url2 = new URL("http://raspberrypi/local.txt");
            BufferedReader br2 = new BufferedReader(new InputStreamReader(url2.openStream()));
            if (br2.readLine().equals("true")) {
                return true;
            }
        } catch (Exception e) {
            log("                " + e.toString());
        }
        return false;
    }

    public String getMyLocalIP() {// TODO
        return "192.168.2.117";
    }

    public static boolean checkLocalStatic() {
        try {
            URL url = new URL("http://192.168.2.117/local.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            if (br.readLine().equals("true")) {
                return true;
            }
        } catch (Exception e) {
            log("                " + e.toString());
        }
        try {
            URL url2 = new URL("http://raspberrypi/local.txt");
            BufferedReader br2 = new BufferedReader(new InputStreamReader(url2.openStream()));
            if (br2.readLine().equals("true")) {
                return true;
            }
        } catch (Exception e) {
            log("                " + e.toString());
        }
        return false;
    }

    public boolean serverDown() {
        String res1;
        String res2;
        String res3;
        try {
            URL url = new URL("http://192.168.2.117/down.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            res1 = br.readLine();
        } catch (Exception e) {
            log("                " + e.toString());
            res1 = "true";
        }
        try {
            URL url2 = new URL("http://pumuckl112.selfhost.eu/down.txt");
            BufferedReader br2 = new BufferedReader(new InputStreamReader(url2.openStream()));
            res2 = br2.readLine();
        } catch (Exception e) {
            log("                " + e.toString());
            res2 = "true";
        }
        try {
            URL url3 = new URL("http://raspberrypi/down.txt");
            BufferedReader br3 = new BufferedReader(new InputStreamReader(url3.openStream()));
            res3 = br3.readLine();
        } catch (Exception e) {
            log("                " + e.toString());
            res3 = "true";
        }
        if (res1.equals("false") || res2.equals("false") || res3.equals("false")) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean serverDownStatic() {
        String res1;
        String res2;
        String res3;
        try {
            URL url = new URL("http://192.168.2.117/down.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            res1 = br.readLine();
        } catch (Exception e) {
            log("                " + e.toString());
            res1 = "true";
        }
        try {
            URL url2 = new URL("http://pumuckl112.selfhost.eu/down.txt");
            BufferedReader br2 = new BufferedReader(new InputStreamReader(url2.openStream()));
            res2 = br2.readLine();
        } catch (Exception e) {
            log("                " + e.toString());
            res2 = "true";
        }
        try {
            URL url3 = new URL("http://raspberrypi/down.txt");
            BufferedReader br3 = new BufferedReader(new InputStreamReader(url3.openStream()));
            res3 = br3.readLine();
        } catch (Exception e) {
            log("                " + e.toString());
            res3 = "true";
        }
        if (res1.equals("false") || res2.equals("false") || res3.equals("false")) {
            return false;
        } else {
            return true;
        }
    }

    @SuppressWarnings("resource")
    public String serverAnswer(String address, String name, String command) {
        String ergebnis = "";
        try {
            server = new Socket(address, 4321);
            PrintWriter out = new PrintWriter(server.getOutputStream(), true);
            Scanner in = new Scanner(server.getInputStream());

            out.println(name);
            out.println(command);
            ergebnis = in.nextLine();
        } catch (Exception e) {
            if (command == "#ALIVE") {
                ergebnis = "DEAD";
                log("                " + e.toString());
            } else {
                log("                " + e.toString());
                e.printStackTrace();
            }
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    log("                " + e.toString());
                }
            }
        }
        return ergebnis;
    }

    @SuppressWarnings("resource")
    public String serverAnswer(String address, int port, String message) {
        String ergebnis = "";
        try {
            server = new Socket(address, port);
            PrintWriter out = new PrintWriter(server.getOutputStream(), true);
            Scanner in = new Scanner(server.getInputStream());

            out.println(message);
            ergebnis = in.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ergebnis;
    }

    public void serverCommand(String address, String name, String command) {
        try {
            server = new Socket(address, 4321);
            PrintWriter out = new PrintWriter(server.getOutputStream(), true);

            out.println(name);
            out.println(command);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (server != null)
                try {
                    server.close();
                } catch (IOException e) {
                    ;
                }
        }
    }

    public void apprend(String address, String target, String message) {

        try {
            server = new Socket(address, 4321);
            PrintWriter out = new PrintWriter(server.getOutputStream(), true);

            out.println(target);
            out.println(message);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (server != null)
                try {
                    server.close();
                } catch (IOException e) {
                    ;
                }
        }
    }

    public static void apprendStatic(String address, String target, String message) {

        try {
            serverS = new Socket(address, 4321);
            PrintWriter out = new PrintWriter(serverS.getOutputStream(), true);

            out.println(target);
            out.println(message);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverS != null)
                try {
                    serverS.close();
                } catch (IOException e) {
                    ;
                }
        }
    }

    public static void ln() {
        file = new File("log_" + getMyIPStatic() + "_@_" + time + ".dll");
        try {
            writer = new FileWriter(file, true);
            writer.write(System.getProperty("line.separator"));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void log(String inhalt) {
        file = new File("log_" + getMyIPStatic() + "_@_" + time + ".dll");
        try {
            writer = new FileWriter(file, true);
            writer.write(inhalt);
            writer.flush();
            writer.close();
            ln();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(String pfad) {
        File datei = new File(pfad);
        if (datei.exists()) {
            datei.delete();
        }
    }

    public static void deleteStatic(String pfad) {
        File datei = new File(pfad);
        if (datei.exists()) {
            datei.delete();
        }
    }

    public String findRaspberryPI() {
        String zwsp;
        if (checkLocalLAN()) {
            zwsp = "1.1.1.1";
        } else if (checkLocal()) {
            zwsp = "192.168.2.117";
        } else if (checkLocalCanonicalName()) {
            zwsp = "raspberrypi";
        } else {
            zwsp = "pumuckl112.selfhost.eu";
        }
        return zwsp;
    }
}