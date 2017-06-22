package Raumklima;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.*;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.panel.*;
import org.jfree.chart.plot.*;
import org.jfree.data.general.*;
import org.jfree.data.xy.*;
import org.jfree.ui.*;
public class Raumklima implements ActionListener,WindowListener,WindowStateListener,ChartMouseListener,ComponentListener
{
    public static int OPEN_KEY_ID=78;//O
    public static int OPEN_NEW_KEY_ID=79;//N
    public static int CLOSE_KEY_ID=87;//W
    public static int OPEN_SETTINGS_KEY_ID=73;//I
    public static int EXPAND_COLLAPSE_BOTTOMPANEL_KEY_ID=69;//E
    public static int SAVE_GRAPH_KEY_ID=83;//S
    public static int OPEN_HELP_KEY_ID=112;
    public static int TOGGLE_FULLSCREEN_MODE_KEY_ID=122;
    public static int REFRESH_FRAME_KEY_ID=116;
    public static String OPEN_SETTINGS_KEY_STRING="I";
    public static String OPEN_HELP_KEY_STRING="F1";
    public static String OPEN_NEW_PLOT_KEY_STRING="O";
    public static String OPEN_NEW_WINDOW_KEY_STRING="N";
    public static String CLOSE_WINDOW_KEY_STRING="W";
    public static String REPAINT_KEY_STRING="F5";
    public static String TOGGLE_FULLSCREEN_KEY_STRING="F11";
    public static int HEIGHT_OF_DATA_BLOCK=35;
    public static int WIDTH_OF_DATA_BLOCK=370;
    
    private JFileChooser fileChooser;
    private File csvFile;
    private File configFile;
    private BufferedReader br;
    private int counter=0;
    
    private JFrame fileChooserWindow;
    private JFrame settingsWindow;
    private JFrame helpWindow;
    private JFrame mainWindow;
    
    private JPanel chartPanel;
    private JPanel dataPanel;
    private JPanel waitPanel;
    
    private JMenuBar mainWindowMenuBar;
    private JMenu fileMenu;
    private JMenuItem closeWindowMenuItem;
    private JMenuItem openNewWindowMenuItem;
    private JMenuItem openDifferentPlotMenuItem;
    private JMenu openHelpWindowMenu;
    private JMenu openSettingsWindowMenu;
    private JMenu toggleFullscreenModeMenu;
	private JLabel waitText;
	private Image logo;
    public Raumklima(){
    	//setup some very basic stuff
    	try {
    	    logo = ImageIO.read(new File("../Resources/Weather.png"));
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("config.txt")));
    	try{
    		System.out.println(br.readLine());
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	
        //Initialise JFrames
        fileChooserWindow=new JFrame();
        settingsWindow=new JFrame();
        helpWindow=new JFrame();
        mainWindow=new JFrame();
        
        //Initialise and setup FileChooser
        fileChooser=new JFileChooser();
        fileChooser.setDialogTitle("Bitte CSV-Datei ausw�hlen");
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Aufgezeichnete Klimadaten (.csv/.CSV)","csv","CSV"));
        
        //Initialise and fill the MenuBar on the MainWindow
        mainWindowMenuBar=new JMenuBar();
        
        fileMenu=new JMenu("Datei");
        openDifferentPlotMenuItem=new JMenuItem("Datei �ffnen (Strg+"+OPEN_NEW_PLOT_KEY_STRING+")");
        openDifferentPlotMenuItem.addActionListener(this);
        fileMenu.add(openDifferentPlotMenuItem);
        openNewWindowMenuItem=new JMenuItem("neues Fenster �ffnen (Strg+"+OPEN_NEW_WINDOW_KEY_STRING+")");
        openNewWindowMenuItem.addActionListener(this);
        fileMenu.add(openNewWindowMenuItem);
        closeWindowMenuItem=new JMenuItem("Fenster schlie�en (Strg+"+CLOSE_WINDOW_KEY_STRING+")");
        closeWindowMenuItem.addActionListener(this);
        fileMenu.add(closeWindowMenuItem);
        
        mainWindowMenuBar.add(fileMenu);
        
        openSettingsWindowMenu=new JMenu("Einstellungen (Strg+"+OPEN_SETTINGS_KEY_STRING+")");
        openSettingsWindowMenu.addActionListener(this);
        mainWindowMenuBar.add(openSettingsWindowMenu);
        
        toggleFullscreenModeMenu=new JMenu("Vollbildmodus ("+TOGGLE_FULLSCREEN_KEY_STRING+")");
        toggleFullscreenModeMenu.addActionListener(this);
        mainWindowMenuBar.add(toggleFullscreenModeMenu);
        mainWindow.setJMenuBar(mainWindowMenuBar);

        openHelpWindowMenu=new JMenu("Hilfe ("+OPEN_HELP_KEY_STRING+")");
        openHelpWindowMenu.addActionListener(this);
        mainWindowMenuBar.add(openHelpWindowMenu);
        
        //Initialise and fill the WaitPanel
        waitPanel=new JPanel(new BorderLayout());
        waitText=new JLabel("Bitte Warten.");
        waitText.setHorizontalAlignment(SwingConstants.CENTER);
        waitPanel.add(waitText,BorderLayout.CENTER);
        
        //setup the MainWindow
        mainWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        mainWindow.addWindowListener(this);
        mainWindow.setTitle("Raumklima-Auswertungssoftware");
        mainWindow.setIconImage(logo);
        
        //Add the temporary WaitPanel to The Window
        mainWindow.add(waitPanel);
        mainWindow.setSize(800, 480);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setVisible(true);
    }
	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void componentResized(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void chartMouseClicked(ChartMouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void chartMouseMoved(ChartMouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowStateChanged(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent arg0) {
		mainWindow.dispose();
		fileChooserWindow.dispose();
		settingsWindow.dispose();
		helpWindow.dispose();
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args){
		new Raumklima();
	}
}
