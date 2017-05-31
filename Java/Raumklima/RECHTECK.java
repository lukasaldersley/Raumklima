package SCHULE.W_SEMINAR;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class RECHTECK extends JPanel
{
    private int farbCode=0;
    private Color farbe;

    public RECHTECK()
    {
        farbe=Color.BLACK;
        farbCode=0;
        setSize(50,50);
    }

    public void paint(Graphics g)
    {						
        g.setColor(farbe);
        g.fillRect(0,0,50,50);
    }

    public void farbetauschen()
    {
        if(farbCode==0)
        {
            farbe=Color.RED;
            repaint();
            farbCode=1;
        }
        else if(farbCode==1){
            farbe=Color.GREEN;
            repaint();
            farbCode=2;
        }
        else if(farbCode==2){
            farbe=Color.BLUE;
            repaint();
            farbCode=3;
        }
        else
        {
            farbe=Color.BLACK;
            repaint();
            farbCode=0;
        }
    }
    
    boolean farbig(){
        return farbCode!=0;
    }
}