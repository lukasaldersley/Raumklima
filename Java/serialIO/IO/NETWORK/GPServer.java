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

public class GPServer {
    private static FileWriter writer;
    private static File file;
    private static int portNumber=4321;
    private static KeyPair key;
    public static PublicKey publicKey;
    private static PrivateKey privateKey;
    private static DataPort[] dataPorts;
    private static boolean[] dataPortsAvailable;

    public GPServer(){
        dataPorts=new DataPort[10];
        dataPortsAvailable=new boolean[10];
        for(int i=0;i<10;i++){
            dataPorts[i]=new DataPort(43210+i,i,this);
            dataPortsAvailable[i]=true;
        }
    }
    
    private static void logClient(Socket in){
        long xy=System.currentTimeMillis();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy; HH:mm:ss");
        Date currentTime = new Date(xy);
        String erg = formatter.format(currentTime);
        String msg="UNIX-TIME:       "+xy+"\r\nTIME:            "+erg+"\r\nCLIENT-IP:       "+in.getInetAddress()+"\r\n"+"CLIENT-PORT:     "+in.getPort()+"\r\n"+"SERVER-IP:       "+in.getLocalAddress()+"\r\n"+"SERVER-PORT:     "+in.getLocalPort()+"\r\n\r\n\r\n";
        if(System.getProperty("os.name").startsWith("Win")){
            schreiben(System.getProperty("user.home")+"\\Desktop\\ExceptopnalLog.txt",msg);
        }
        else{
            ;
        }
    }

    @SuppressWarnings("resource")
    private static void handleConnection(Socket client) throws IOException {
        logClient(client);
        Scanner in = new Scanner(client.getInputStream());
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        String zwsp=in.nextLine();
        int usedPort=-1;
        boolean search=true;
        for(int i=0;i<10;i++){
            if(search){
                if(dataPortsAvailable[i]==true){
                    usedPort=i;
                    dataPortsAvailable[i]=false;
                    search=false;
                }
            }
        }
        if(usedPort==-1){
            System.out.println("KEIN FREIER PORT");
            out.println("ERROR");
        }
        else{
            dataPorts[usedPort].run();
            out.println(43210+usedPort);
        }
        /*String zwsp1 = "";
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
         */
    }

    public void setPortUnused(int port){
        dataPorts[port]=new DataPort(43210+port,port,this);
        dataPortsAvailable[port]=true;
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {
        int nPortNumber=0;
        try{
            if(args[0]!=null||!args[0].equals("")){
                nPortNumber=Integer.parseInt(args[0]);
                Object[] options={"JA","STANDARD VERWENDEN","NEUEN EINGEBEN"};
                int result=JOptionPane.showOptionDialog(null,"Wollen Sie wirklich "+nPortNumber+" als Server-Port verwenden?","BESTÄTIGUNG ERFORDERLICH",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                if(result==0){
                    portNumber=nPortNumber;
                }
                else if(result==2){
                    portNumber=Integer.parseInt(JOptionPane.showInputDialog(null,"Geben Sie Ihren Namen ein","Eine Eingabeaufforderung",JOptionPane.PLAIN_MESSAGE));
                }
                else{
                    ;
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            portNumber=4321;
        }
        new GPServer();

        ServerSocket server = new ServerSocket(portNumber);

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
