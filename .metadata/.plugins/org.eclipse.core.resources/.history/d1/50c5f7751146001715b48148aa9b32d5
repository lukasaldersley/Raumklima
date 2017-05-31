import java.awt.event.*;
import java.awt.*;
import serialIO.IO.DISK.FILE;
import javax.swing.*;
public class LCD2004LayoutConcept implements ActionListener
{
    private JFrame window;
    private JTextField eins,zwei,drei,vier;
    private JButton button;

    public static void main(String[] args){
        new LCD2004LayoutConcept();
    }

    LCD2004LayoutConcept(){
        button=new JButton();
        window=new JFrame();
        eins = new JTextField(20);
        eins.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) { 
                    if (eins.getText().length() >= 20 ) // limit textfield to 3 characters
                        e.consume(); 
                }  
            });
        zwei = new JTextField(20);
        zwei.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) { 
                    if (zwei.getText().length() >= 20 ) // limit textfield to 3 characters
                        e.consume(); 
                }  
            });
        drei = new JTextField(20);
        drei.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) { 
                    if (drei.getText().length() >= 20 ) // limit textfield to 3 characters
                        e.consume(); 
                }  
            });
        vier = new JTextField(20);
        vier.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) { 
                    if (vier.getText().length() >= 20 ) // limit textfield to 3 characters
                        e.consume(); 
                }  
            });
        JPanel panel=new JPanel();
        panel.add(eins);
        panel.add(zwei);
        panel.add(drei);
        panel.add(vier);
        window.add(panel,BorderLayout.CENTER);
        button.addActionListener(this);
        window.add(button,BorderLayout.SOUTH);
        button.setText("SAVE TO FILE");
        window.setVisible(true);
        window.setSize(400,200);
        window.setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
            FILE.WRITE("LCD2004.txt","**********************",true);
            FILE.WRITE("LCD2004.txt","*"+eins.getText()+"*",true);
            FILE.WRITE("LCD2004.txt","*"+zwei.getText()+"*",true);
            FILE.WRITE("LCD2004.txt","*"+drei.getText()+"*",true);
            FILE.WRITE("LCD2004.txt","*"+vier.getText()+"*",true);
            FILE.WRITE("LCD2004.txt","**********************",true);
            
            FILE.WRITE("LCD2004.txt","",true);
            FILE.WRITE("LCD2004.txt","",true);
            FILE.WRITE("LCD2004.txt","",true);
            FILE.WRITE("LCD2004.txt","",true);
        }
    }
}
