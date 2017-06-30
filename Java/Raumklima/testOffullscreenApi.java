package Raumklima;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class testOffullscreenApi {
	
	GraphicsDevice gd=GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	public GraphicsDevice[] gda;
	public testOffullscreenApi(){
		JFrame window=new JFrame();
		window.setLayout(new GridLayout(0,1));
		gda=GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
		JLabel[] lbl=new JLabel[gda.length];
		for(int i=0;i<gda.length;i++){
			lbl[i]=new JLabel(gda[i].getIDstring()+" "+gda[i].getType()+" "+gda[i].hashCode()+" "+gda[i].getConfigurations()+" "+gda[i].getDefaultConfiguration()+" "+gda[i].getDisplayMode()+" "+gda[i].getDisplayModes()+" "+gda[i].getFullScreenWindow()+" "+gda[i].isDisplayChangeSupported()+" "+gda[i].isFullScreenSupported());
			window.add(lbl[i]);
		}
		gd.setFullScreenWindow(window);
	}
	
	

	public static void main(String[] args) {
		new testOffullscreenApi();
	}

}
