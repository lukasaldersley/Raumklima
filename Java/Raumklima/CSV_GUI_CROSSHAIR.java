package SCHULE.W_SEMINAR;

import org.jfree.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.*;
/**
 * This class theoretically should display all of the recorded graphs from the sd card
 * 
 * @author Lukas Aldersley
 * @version 0.9.0.0
 */
public class CSV_GUI_CROSSHAIR
{
    JFileChooser fileChooser;
    File csvFile;
    JFrame jFileChooserWindow;
    public CSV_GUI_CROSSHAIR()
    {
        jFileChooserWindow=new JFrame();
        
        fileChooser=new JFileChooser();
        fileChooser.setDialogTitle("Bitte CSV-Datei ausw�hlen");
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Aufgezeichnete Klimadaten (.csv/.CSV)","csv","CSV"));
    }
    
    public void showOpenDialog(){
        fileChooser.showOpenDialog(jFileChooserWindow);
    }
}
