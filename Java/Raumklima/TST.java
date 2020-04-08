package Raumklima;
import java.awt.Color;
import javax.swing.JFrame;
public class TST
{
    public TST(){
        JFrame X=new JFrame();
        X.setAlwaysOnTop(true);
        X.setBounds(0,0,3840,1080);
        X.setBackground(Color.RED);
        X.setUndecorated(true);
        X.setVisible(true);
        try{Thread.sleep(10000);}catch(Exception e){e.printStackTrace();}
        X.setVisible(false);
    }
}
