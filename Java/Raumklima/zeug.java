package Raumklima;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.*;
public class zeug
{
    JFrame window;
    GraphicsDevice gd=GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    public zeug(){
        window=new JFrame("LBFHASDJKBFFFSDJKLNAJKLNASDNJKLJ");
        o(gd.isDisplayChangeSupported());
        o(gd.isFullScreenSupported());
    }
    
    public void o(Object ob){
        System.out.println(ob);
    }
}
