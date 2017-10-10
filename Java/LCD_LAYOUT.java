import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class LCD_LAYOUT implements KeyListener, ActionListener
{
    public JTextField[][] field;
    JFrame window;
    JPanel panel;
    JButton save;
    int currentX=0;
    int currentY=0;
    int maxY;
    int maxX;
    JTextField f;
    public static void main(String[] args){
        new LCD_LAYOUT(20,4);
    }

    public LCD_LAYOUT(int X,int Y){
        maxY=Y;
        maxX=X;
        window=new JFrame();
        panel=new JPanel();
        save=new JButton("SAVE");
        save.addActionListener(this);
        panel.setLayout(new GridLayout(Y,X,2,2));
        window.add(panel,BorderLayout.NORTH);
        window.add(save,BorderLayout.SOUTH);
        field=new JTextField[X][Y];
        f=new JTextField();
        window.add(f,BorderLayout.CENTER);
        f.addKeyListener(this);
        for(int j=0;j<Y;j++){
            for(int i=0;i<X;i++){
                field[i][j]=new JTextField();
                field[i][j].setPreferredSize(new Dimension(15,20));
                field[i][j].setMinimumSize(new Dimension(15,20));
                field[i][j].setMaximumSize(new Dimension(15,20));
                field[i][j].addKeyListener(this);
                panel.add(field[i][j]);
            }
        }
        window.addKeyListener(this);
        panel.addKeyListener(this);
        save.addKeyListener(this);
        window.setVisible(true);
        window.pack();
        window.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        System.out.println("KEYS:\n\n");
        System.out.println("XXX.clear();");
        for(int j=0;j<maxY;j++){
            String X="XXX.setCursor(0,"+j+");";
            System.out.println(X);
            X="XXX.print(\"";
            for(int i=0;i<maxX;i++){
                X+=field[i][j].getText();
            }
            X+="\");";
            System.out.println(X);
        }
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        if(arg0.getSource()==f){
            if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
                if(f.getText().equals("")){
                    for(int i=0;i<maxX;i++){
                        field[i][currentY].setText("");
                    }
                }
                else{
                    char[] v=f.getText().toCharArray();
                    for(int i=0;i<v.length;i++){
                        field[i][currentY].setText(String.valueOf(v[i]));
                    }
                }
                currentY++;
                currentX=0;
                f.setText("");
                if(currentY==maxY){
                    currentY=0;
                }
            }
            return;
        }
        else{
            if(arg0.getKeyCode()==KeyEvent.VK_LEFT){
                currentX--;
            }
            else if(arg0.getKeyCode()==KeyEvent.VK_RIGHT){
                currentX++;
            }
            else if(arg0.getKeyCode()==KeyEvent.VK_DOWN){
                currentY++;
            }
            else if(arg0.getKeyCode()==KeyEvent.VK_UP){
                currentY--;
            }

            if(currentX<0){
                currentX=0;
            }
            if(currentY<0){
                currentY=0;
            }
            if(currentY>=maxY){
                currentY=maxY-1;
            }
            if(currentX>=maxX){
                currentX=maxX-1;
            }
            field[currentX][currentY].grabFocus();
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
    }
}
