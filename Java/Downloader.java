import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Downloader implements ActionListener
{
    private URL source;
    private ReadableByteChannel readableByteChannelFromSource;
    private FileOutputStream fileOutputStream;
    private JFrame window;
    private JButton dl;
    private JTextField input;
    File indexFile;

    public Downloader()
    {
        window=new JFrame();
        dl=new JButton();
        input=new JTextField();
        window.add(input,BorderLayout.NORTH);
        dl.addActionListener(this);
        dl.setText("Download");
        window.add(dl, BorderLayout.SOUTH);
        window.setSize(new Dimension(1280,100));
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("DOWNLOADER");
        window.setVisible(true);
        indexFile=new File("DownloadedWebsites.txt");
        if(!indexFile.exists()){
            try {
                indexFile.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        new Downloader();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        try{
            source = new URL(input.getText());
            readableByteChannelFromSource = Channels.newChannel(source.openStream());
            String indexes="";
            BufferedReader br=new BufferedReader(new FileReader(indexFile));
            String zeile=br.readLine();
            while(true){
                if(zeile==null){
                    break;
                }
                indexes+=zeile+"\r\n";
                zeile=br.readLine();
            }
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");//http://www.mkyong.com/java/java-how-to-get-current-date-time-date-and-calender/
            Date date = new Date();
            System.out.println(indexes);
            indexes+=input.getText()+"\t"+dateFormat.format(date)+"\r\n";
            System.out.println(indexes);
            BufferedWriter bw = new BufferedWriter(new FileWriter(indexFile));
            bw.write(indexes);
            bw.flush();
            bw.close();
            br.close();
            input.setText(input.getText().replace("https://",""));
            input.setText(input.getText().replace("http://",""));
            input.setText(input.getText().replace("/","_"));
            input.setText(input.getText().replace("\\","_"));
            input.setText(input.getText().replace(":","_"));
            input.setText(input.getText().replace("*","_"));
            input.setText(input.getText().replace("?","_"));
            input.setText(input.getText().replace("\"","_"));
            input.setText(input.getText().replace("<","_"));
            input.setText(input.getText().replace(">","_"));
            input.setText(input.getText().replace("|","_"));
            fileOutputStream = new FileOutputStream(input.getText()+".htm");
            fileOutputStream.getChannel().transferFrom(readableByteChannelFromSource, 0, Long.MAX_VALUE);
            fileOutputStream.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
