package SCHULE.W_SEMINAR;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import com.fazecast.jSerialComm.*;
import serialIO.IO.DISK.FILE;
/**
 * Write a description of class GUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GUI
{
    private JFrame window;
    private JTextField status;
    private JScrollPane scroll;
    private JTextArea area;
    SerialPort[] ports;
    private Scanner data;
    private String zwsp;
    private int baudRate=250000;
    Thread communicationThread;
    private JPanel panel;
    private JTextField[] val;
    private JLabel[] valt;
    private double[] parsed;
    private GRAPH graph;
    private CSV csv;
    private SERIAL_INTERFACE serialInterface;
    int port=0;
    int baud=250000;
    private JComboBox portChooser;
    public GUI(){
        initComm();
        
       // ports=serialInterface.getAvailablePorts();
        csv=new CSV();
        initJFrame();
       // serialInterface.configureConnection(port,baud,8,1,SerialPort.NO_PARITY);//ODD_PARITY);
        communicationThread.start();
    }
    
    public void println(String in){
        System.out.println(in);
        area.append(in+System.getProperty("line.separator"));
        String[] value=in.split(";");
        for(int i=0;i<7;i++){
            val[i].setText(value[i]);
        }
        val[0].setText(val[0].getText()+"V");
        val[1].setText(val[1].getText()+"");
        val[2].setText(val[2].getText()+"%");
        val[3].setText(val[3].getText()+"°C");
        val[4].setText(val[4].getText()+"°C");
        val[5].setText(val[5].getText()+"°C");
        val[6].setText(val[6].getText()+"hPa (=mBar)");
        for(int i=0;i<7;i++){
            parsed[i]=Double.parseDouble(value[i]);
        }
        
        graph.send(parsed);
    }
    
    public void setStatus(String in){
        status.setText(in);
    }

    private void initJFrame(){
        window=new JFrame();

        status=new JTextField();
        window.add(status,BorderLayout.NORTH);
        
        area = new JTextArea(5, 30);
        area.setText("");
        scroll = new JScrollPane();
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setViewportView(area);
        window.add(scroll, BorderLayout.CENTER);
        
        int nr=10;
        panel=new JPanel(new GridLayout(4,0));
        val=new JTextField[nr];
        valt=new JLabel[nr+1];
        valt[0]=new JLabel("BATTERISPANNUNG: ");
        valt[1]=new JLabel("HELLIGKEIT: ");
        valt[2]=new JLabel("DHTLuftFeuchtigkeit: ");
        valt[3]=new JLabel("DHTTemperatur: ");
        valt[4]=new JLabel("DHTHitzeIndex: ");
        valt[5]=new JLabel("BMPTemperatur: ");
        valt[6]=new JLabel("BMPLuftDruck: ");
        valt[7]=new JLabel("COM-PORT: ");
        valt[8]=new JLabel("BAUDRATE: ");
        valt[9]=new JLabel("PORT-PARAMS: ");
        valt[10]=new JLabel("PORT: ");
        for(int i=0;i<nr;i++){
            val[i]=new JTextField();
            panel.add(valt[i]);
            panel.add(val[i]);
        }
        val[7].setText(ports[port].getDescriptivePortName());
        val[8].setText(String.valueOf(baud));
        val[9].setText(ports[port].getDescriptivePortName()+","+baud+",N,8,1");
        panel.add(valt[10]);
        portChooser=new JComboBox();
        
        parsed=new double[7];
        
        window.add(panel,BorderLayout.SOUTH);
        
        window.setVisible(true);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void initComm(){
       // serialInterface=new SERIAL_INTERFACE(this,csv);
        communicationThread=new Thread(serialInterface);
    }

    public static void delay(long in){
        try{
            Thread.sleep(in);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
