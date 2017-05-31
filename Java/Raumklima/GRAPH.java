package SCHULE.W_SEMINAR;
import java.util.Scanner;
import serialIO.IO.DISK.FILE;
import javax.swing.*;

public class GRAPH extends JPanel {
    private JPanel graphArea;
    private JScrollPane scrollPane;
    private double[] currentValues;
    public GRAPH(){
        scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setViewportView(graphArea);
        this.add(scrollPane);
    }

    public void delay(long in){
        try{
            Thread.sleep(in);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void send(double[] in){
        currentValues=in;
    }
}
