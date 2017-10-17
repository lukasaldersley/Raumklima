package serialIO.IO.NETWORK;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.net.ServerSocket;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
public class FT_RX
{
    private Socket IN;
    private ServerSocket ME;
    Socket mySocket;
    private FileOutputStream fileOutStream;
    private File file;
    private JFileChooser fileChooser;
    private PrintWriter answer;
    private Scanner incomming;
    
    public FT_RX(){
    	setupServer();
    }
    
    public static void main(String[] args){
    	new FT_RX();
    }

    private void pickDestinationFile(String name){
    	System.out.println("Picking file for "+name);
        fileChooser=new JFileChooser();
        fileChooser.setDialogTitle("Bitte Speicherort für \""+name+"\" auswählen");
        fileChooser.setMultiSelectionEnabled(false);
        if (fileChooser.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {
            file=fileChooser.getSelectedFile();
        }
    }

    private void save(byte[] fileData){
        try{
            fileOutStream = new FileOutputStream(file.getAbsolutePath());
            fileOutStream.write(fileData);
            fileOutStream.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private void setupConnection(String Address){
        try {
			IN=new Socket(Address,25522);
	        answer=new PrintWriter(IN.getOutputStream(),true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private void setupServer(){
    	try{
        ME=new ServerSocket(25511);
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
        while(true){
        	try {
				mySocket=ME.accept();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	if(mySocket!=null|!mySocket.isClosed()){
        		System.out.println("A Client has been accepted: "+mySocket.getInetAddress().getHostName()+" DETAILS: "+mySocket.getInetAddress().getHostAddress()+":"+mySocket.getPort());
        		break;
        	}
        }
        try {
			incomming=new Scanner(mySocket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Waiting on Defs");
        String N=incomming.nextLine();
        System.out.println("GOT DEFS");
        setupConnection(mySocket.getInetAddress().getHostAddress());
        System.out.println(N);
        int NumberOfBytes=Integer.parseInt(N.split("|")[1].split(":")[1]);
        pickDestinationFile(N.split("|")[0].split(":")[1]);
        send("OK");
        save(recieve(NumberOfBytes));
    }

    private void send(String message){
        answer.println(message);
    }
    
    private byte[] recieve(int numberOfBytes){
        byte[] bytes=new byte[numberOfBytes];
        for(int i=0;i<numberOfBytes;i++){
            bytes[i]=incomming.nextByte();
        }
        return bytes;
    }
}