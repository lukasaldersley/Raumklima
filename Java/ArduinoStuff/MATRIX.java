package ArduinoStuff;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;

public class MATRIX implements MouseListener, ActionListener
{
    private FileWriter writer;
    private File file;
    private JFrame window;
    private JPanel[] buttonPanel;
    private JPanel basePanel,ctrPanel;
    private RECHTECK[][][] rechteck;
    private int panelX=5;
    private int panelY=7;
    private int anzahl=1;
    private JButton button;
    private JButton[] buttons;
    private JButton[] dreher;
    private JButton[] reset;
    private JButton[] load;

    /*
     * @param nr: number of blocks
     * @param hor: X-Richtung
     * @param ver: Y-Richtung
     */
    public MATRIX(int nr,int hor,int ver)
    {
        anzahl=nr;
        panelX=hor;
        panelY=ver;

        window=new JFrame();
        window.setTitle("LEDMATRIX");

        basePanel=new JPanel();
        basePanel.setSize((55*hor)*nr+50*(nr-1),(58*ver));//nicht unbedingt notwendig
        basePanel.setPreferredSize(new Dimension((55*hor)*nr+50*(nr-1),(58*ver)));
        basePanel.setLayout(new GridLayout(1,nr,50,0));//1 bedeutet nur 1 in y richtung,nr bedeutet nr in x richtung, 50 bedeutet 50 px abstand zwischen blöcken

        buttonPanel=new JPanel[nr];
        ctrPanel=new JPanel();
        ctrPanel.setLayout(new GridLayout(4,nr,50,0));
        buttons=new JButton[nr];
        dreher=new JButton[nr];
        reset=new JButton[nr];
        load=new JButton[nr];
        rechteck=new RECHTECK[nr][hor][ver];
        for(int i=0;i<nr;i++){
            buttonPanel[i]=new JPanel();
            basePanel.add(setupButtonPanel(buttonPanel[i],i,hor,ver));
            buttons[i]=new JButton("SAVE "+(i+1));
            buttons[i].addActionListener(this);
            ctrPanel.add(buttons[i]);
        }
        for(int i=0;i<nr;i++){
            dreher[i]=new JButton((i+1)+" UMKEHREN");
            dreher[i].addActionListener(this);
            ctrPanel.add(dreher[i]);
        }
        for(int i=0;i<nr;i++){
            reset[i]=new JButton("RESET "+(i+1));
            reset[i].addActionListener(this);
            ctrPanel.add(reset[i]);
        }
        for(int i=0;i<nr;i++){
            load[i]=new JButton("LOAD "+(i+1));
            load[i].addActionListener(this);
            ctrPanel.add(load[i]);
        }

        window.add(basePanel,BorderLayout.CENTER);

        button=new JButton("ALLE UMKEHREN");
        button.addActionListener(this);

        window.add(button,BorderLayout.NORTH);

        window.add(ctrPanel,BorderLayout.SOUTH);

        window.pack();
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public MATRIX(){
        int nr=1;
        int hor=5;
        int ver=7;

        anzahl=nr;
        panelX=hor;
        panelY=ver;

        window=new JFrame();
        window.setTitle("LEDMATRIX");

        basePanel=new JPanel();
        basePanel.setSize((55*hor)*nr+50*(nr-1),(58*ver));//nicht unbedingt notwendig
        basePanel.setPreferredSize(new Dimension((55*hor)*nr+50*(nr-1),(58*ver)));
        basePanel.setLayout(new GridLayout(1,nr,50,0));//1 bedeutet nur 1 in y richtung,nr bedeutet nr in x richtung, 50 bedeutet 50 px abstand zwischen blöcken

        buttonPanel=new JPanel[nr];
        ctrPanel=new JPanel();
        ctrPanel.setLayout(new GridLayout(4,nr,50,0));
        buttons=new JButton[nr];
        dreher=new JButton[nr];
        reset=new JButton[nr];
        load=new JButton[nr];
        rechteck=new RECHTECK[nr][hor][ver];
        for(int i=0;i<nr;i++){
            buttonPanel[i]=new JPanel();
            basePanel.add(setupButtonPanel(buttonPanel[i],i,hor,ver));
            buttons[i]=new JButton("SAVE "+(i+1));
            buttons[i].addActionListener(this);
            ctrPanel.add(buttons[i]);
        }
        for(int i=0;i<nr;i++){
            dreher[i]=new JButton((i+1)+" UMKEHREN");
            dreher[i].addActionListener(this);
            ctrPanel.add(dreher[i]);
        }
        for(int i=0;i<nr;i++){
            reset[i]=new JButton("RESET "+(i+1));
            reset[i].addActionListener(this);
            ctrPanel.add(reset[i]);
        }
        for(int i=0;i<nr;i++){
            load[i]=new JButton("LOAD "+(i+1));
            load[i].addActionListener(this);
            ctrPanel.add(load[i]);
        }

        window.add(basePanel,BorderLayout.CENTER);

        button=new JButton("ALLE UMKEHREN");
        button.addActionListener(this);

        window.add(button,BorderLayout.NORTH);

        window.add(ctrPanel,BorderLayout.SOUTH);

        window.pack();
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void mouseClicked(MouseEvent e){
        Rectangle rect=window.getBounds();
        for(int z=0;z<anzahl;z++){
            for(int x=0;x<panelX;x++){
                for(int y=0;y<panelY;y++){
                    if(e.getSource()==rechteck[z][x][y]){
                        farbWechsel(z,x,y);
                        window.setSize(0,0);//das hier, zusammen mit window.pack sorgt dafür dass keine der button fragmente zu sehen sind
                        window.pack();
                        window.setBounds(rect);
                        log("PANEL: "+z+";            X: "+x+";            Y: "+y,"LEDMatrixKeyStrokes.txt");
                    }
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Rectangle rect=window.getBounds();
        if(e.getSource()==button){
            farbenUmdrehenOhneDelay();
            window.setSize(0,0);//das hier, zusammen mit window.pack sorgt dafür dass keine der button fragmente zu sehen sind
            window.pack();
            window.setBounds(rect);
        }

        for(int i=0;i<anzahl;i++){
            if(e.getSource()==buttons[i]){
                //TODO
                printBinaryForArduino(i,JOptionPane.showInputDialog("NAME DES ZEICHENS EINGEBEN"));
            }

            if(e.getSource()==dreher[i]){
                farbenUmdrehenPanelOhneDelay(i);
                window.setSize(0,0);//das hier, zusammen mit window.pack sorgt dafür dass keine der button fragmente zu sehen sind
                window.pack();
                window.setBounds(rect);
            }

            if(e.getSource()==reset[i]){
                reset(i);
                window.setSize(0,0);//das hier, zusammen mit window.pack sorgt dafür dass keine der button fragmente zu sehen sind
                window.pack();
                window.setBounds(rect);
            }

            if(e.getSource()==load[i]){
                load(i);
                window.setSize(0,0);
                window.pack();
                window.setBounds(rect);
            }
        }
    }

    public JPanel setupButtonPanel(JPanel panel,int nr,int hor,int ver){
        panel.setLayout(new GridLayout(ver,hor));
        for(int y=0;y<ver;y++)
        {
            for(int x=0;x<hor;x++)
            {              
                rechteck[nr][x][y]=new RECHTECK();
                panel.add(rechteck[nr][x][y]);
                rechteck[nr][x][y].addMouseListener(this);
            }
        }
        return panel;
    }

    public void farbWechsel(int panel,int x, int y)
    {
        rechteck[panel][x][y].farbetauschen();
    }

    public void farbenUmdrehenOhneDelay()
    {
        for(int z=0;z<anzahl;z++){
            for(int y=0;y<panelY;y++){
                for(int x=0;x<panelX;x++){
                    farbWechsel(z,x,y);
                }
            }
        }
    }

    public void reset(int pan){
        for(int y=0;y<panelY;y++){
            for(int x=0;x<panelX;x++){
                while(rechteck[pan][x][y].farbig()){
                    farbWechsel(pan,x,y);
                }
            }
        }
    }

    public void farbenUmdrehenPanelOhneDelay(int z)
    {
        for(int y=0;y<panelY;y++){
            for(int x=0;x<panelX;x++){
                farbWechsel(z,x,y);
            }
        }
    }

    public void farbenUmdrehenMitDelay()
    {
        for(int z=0;z<anzahl;z++){
            for(int y=0;y<panelY;y++){
                for(int x=0;x<panelX;x++){
                    farbWechsel(z,x,y);
                    try{
                        Thread.sleep(50);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    public void log(String inhalt,String fileName) {
        file = new File(fileName);
        try {
            writer = new FileWriter(file,true);//true damit an die bestehende datei angegängt wird, sonst würde Sie überschrieben
            writer.write(inhalt);
            writer.flush();
            writer.close();
            ln(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ln(String fileName) {
        file = new File(fileName);
        try {
            writer = new FileWriter(file,true);//true damit an die bestehende datei angegängt wird, sonst würde Sie überschrieben
            writer.write(System.getProperty("line.separator"));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printBinaryForArduino(int panelNumber,String name){
        String res="byte "+name+"[5] = {";
        for(int x=0;x<panelX;x++){
            byte b=0;
            for(int y=0;y<panelY;y++){
                if(rechteck[panelNumber][x][y].farbig()){
                    b|=(1<<y);
                }
            }
            res+=String.valueOf(b);
            if(x<panelX-1){
                res+=",  ";
            }
            else{
                res+="};";
            }
        }
        log(res,"../../"+"logiLCD"+".txt");
    }

    public void load(int panel){
        if(panelX==5&&panelY==8){
            loadArduino(panel);
        }
        else{
            //TODO LOAD SOMETHING
        }
    }

    @SuppressWarnings("resource")
    public void loadArduino(int panel){
        reset(panel);
        String content="";
        try{
            String name="../"+JOptionPane.showInputDialog("NAME")+".txt";
            BufferedReader br = new BufferedReader(new FileReader(name));
            String zeile=br.readLine();
            while(zeile!=null){
                content+=zeile;
                zeile=br.readLine();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        String finali="";
        for(int i=content.length()-77;i<content.length()-2;i++){
            finali+=content.charAt(i);
        }
        System.out.println(content);
        System.out.println(finali);
        char[] chars=new char[finali.length()];
        int x=0;
        for(int i=0;i<finali.length();i++){
            if(i%10==5||i%10==6||i%10==7||i%10==8||i%10==9){
                ;
            }
            else{
                chars[x]=finali.charAt(i);
                x++;
            }
        }
        finali=new String(chars);
        System.out.println(finali);
        int zaehler=0;
        for(int y=0;y<panelY;y++){
            for(x=0;x<panelX;x++){// Variable x von oben wird wiederverwendet, hat aber nichts mit dem inhalt von oben zu tun!
                if(finali.charAt(zaehler)=='1'){
                    farbWechsel(panel,x,y);
                }
                zaehler++;
            }
        }
    }

    public static void main(String[] args){
        new MATRIX(1,5,7);
    }
}