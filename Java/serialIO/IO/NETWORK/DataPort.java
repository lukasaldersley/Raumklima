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
import java.util.List;
import javax.swing.*;
import java.security.*;
import javax.crypto.*;

public class DataPort implements Runnable {
    private static FileWriter writer;
    private static File file;
    private static int portNumber=4321;
    private static KeyPair key;
    public static PublicKey publicKey;
    private static PrivateKey privateKey;
    private int number;
    private GPServer gpServer;
    ServerSocket server;
    Socket client;

    public DataPort(int portNumber,int nr,GPServer newServer){
        number=nr;
        gpServer=newServer;
    }

    @SuppressWarnings("resource")
    public void run(){
        try {
            server = new ServerSocket(portNumber);
            client= server.accept();
            handleConnection(client);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (client != null)
                try {
                    client.close();
                    gpServer.setPortUnused(number);
                } catch (IOException e) {
                }
        }
    }

    @SuppressWarnings("resource")
    private static void handleConnection(Socket client) throws IOException {
        String zwsp1 = "";
        String zwsp2 = "";
        Scanner in = new Scanner(client.getInputStream());
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        while(true){
            zwsp1 = in.nextLine();
            if(zwsp1.equals("#EXIT!")){
                break;
            }
            else{
                out.println("SECONDARY RX: "+zwsp1);
            }
            /*
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
            }
            else{
                schreiben(zwsp1, zwsp2);
            }*/
        }
    }

    public void generateRSAKeys(){
        try{
            final KeyPairGenerator keygen=KeyPairGenerator.getInstance("RSA");
            keygen.initialize(1024);
            key=keygen.generateKeyPair();
            publicKey=key.getPublic();
            privateKey=key.getPrivate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        //publicKey.
    }

    public byte[] encrypt(String message,PublicKey pk){
        byte[] chiffrat=null;
        try{
            Cipher cipher=Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE,pk);
            chiffrat =cipher.doFinal(message.getBytes());
        }catch(Exception e){
            e.printStackTrace();
        }
        return chiffrat;
    }

    private String decrypt(byte[] chiffrat,PrivateKey sk){
        byte[] dec=null;
        try{
            Cipher cipher=Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE,sk);
            dec=cipher.doFinal(chiffrat);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new String(dec);
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
