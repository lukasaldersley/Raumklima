package serialIO.IO.NETWORK;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class FT_TX {
	public static void main(String[] args){
		new FT_TX();
	}

	private Socket mySocket;
	
	public FT_TX(){
		try {
			ServerSocket me=new ServerSocket(25522);
			Socket out=new Socket("localhost",25511);
			PrintWriter outP=new PrintWriter(out.getOutputStream());
			System.out.println("Sending");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			outP.println("NAME:TST.XXX|ZAHL:10");
			while(true){
				mySocket=me.accept();
				if(mySocket!=null|!mySocket.isClosed()){
	        		System.out.println("A Client has been accepted: "+mySocket.getInetAddress().getHostName()+" DETAILS: "+mySocket.getInetAddress().getHostAddress()+":"+mySocket.getPort());
	        		break;
	        	}
			}
			Scanner inpt=new Scanner(mySocket.getInputStream());
			if(inpt.nextLine().equals("OK")){
				for(int i=0;i<10;i++){
					outP.println(0x41);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
