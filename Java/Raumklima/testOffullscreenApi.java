package Raumklima;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class testOffullscreenApi {
	
	GraphicsDevice gd=GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	private GraphicsDevice[] gda;
	public testOffullscreenApi(){
		JFrame window=new JFrame();
		JLabel lbl=new JLabel("HIhvhgdfds<sfxghjkljhgfdsadfghjkjhgvcxysdfghjk");
		window.add(lbl);
		window.pack();
		gd.setFullScreenWindow(window);
		gda=GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
		for(int i=0;i<gda.length;i++){
			System.out.println(gda[i].isFullScreenSupported());
			System.out.println(gda[i].getIDstring());
			System.out.println();
		}
	}

	public static void main(String[] args) {
		new testOffullscreenApi();
	}

}
