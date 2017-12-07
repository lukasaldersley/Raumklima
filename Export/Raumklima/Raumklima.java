package Raumklima;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.panel.CrosshairOverlay;
import org.jfree.chart.panel.Overlay;
import org.jfree.chart.plot.Crosshair;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleEdge;

import com.fazecast.jSerialComm.SerialPort;

/* 
 * *JPanel*.setLayout(new BoxLayout(*JPanel*, BoxLayout.Y_AXIS));
 * 
 * *JPanel* steht für eine Instanz eines beliebigen JPanel
 * https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/BoxLayoutDemoProject/src/layout/BoxLayoutDemo.java
 */

public class Raumklima implements ActionListener,WindowListener,WindowStateListener,ChartMouseListener,ComponentListener,KeyListener, MouseListener, FocusListener
{
    public static boolean debug=false;
    public static boolean logging=false;
    public static boolean log_ready=false;
    public static String branch="master";
    public static String projectUri="https://raw.githubusercontent.com/lukasaldersley/Raumklima/";
    public static String downloadTargetUri="https://github.com/lukasaldersley/Raumklima/raw/";

    public static final String VERSION="2.4.9.8";

    public static boolean CLOSE_WINDOW_ALT_REQUIRED=false;
    public static boolean OPEN_HELP_WINDOW_ALT_REQUIRED=false;
    public static boolean OPEN_NEW_PLOT_ALT_REQUIRED=false;
    public static boolean OPEN_NEW_WINDOW_ALT_REQUIRED=false;
    public static boolean OPEN_SETTINGS_WINDOW_ALT_REQUIRED=false;
    public static boolean REFRESH_FRAME_ALT_REQUIRED=false;
    public static boolean SAVE_GRAPH_IMAGE_ALT_REQUIRED=false;
    public static boolean TOGGLE_BOTTOM_PANEL_VISIBILITY_ALT_REQUIRED=false;
    public static boolean TOGGLE_FULLSCREEN_MODE_ALT_REQUIRED=false;

    public static boolean CLOSE_WINDOW_CTRL_REQUIRED=true;
    public static boolean OPEN_HELP_WINDOW_CTRL_REQUIRED=false;
    public static boolean OPEN_NEW_PLOT_CTRL_REQUIRED=true;
    public static boolean OPEN_NEW_WINDOW_CTRL_REQUIRED=true;
    public static boolean OPEN_SETTINGS_WINDOW_CTRL_REQUIRED=true;
    public static boolean REFRESH_FRAME_CTRL_REQUIRED=false;
    public static boolean SAVE_GRAPH_IMAGE_CTRL_REQUIRED=true;
    public static boolean TOGGLE_BOTTOM_PANEL_VISIBILITY_CTRL_REQUIRED=true;
    public static boolean TOGGLE_FULLSCREEN_MODE_CTRL_REQUIRED=false;

    public static boolean CLOSE_WINDOW_SHIFT_REQUIRED=false;
    public static boolean OPEN_HELP_WINDOW_SHIFT_REQUIRED=false;
    public static boolean OPEN_NEW_PLOT_SHIFT_REQUIRED=false;
    public static boolean OPEN_NEW_WINDOW_SHIFT_REQUIRED=false;
    public static boolean OPEN_SETTINGS_WINDOW_SHIFT_REQUIRED=false;
    public static boolean REFRESH_FRAME_SHIFT_REQUIRED=false;
    public static boolean SAVE_GRAPH_IMAGE_SHIFT_REQUIRED=false;
    public static boolean TOGGLE_BOTTOM_PANEL_VISIBILITY_SHIFT_REQUIRED=false;
    public static boolean TOGGLE_FULLSCREEN_MODE_SHIFT_REQUIRED=false;

    public static int CLOSE_WINDOW_KEY_CODE=87;//W
    public static int OPEN_HELP_WINDOW_KEY_CODE=112;//F1
    public static int OPEN_NEW_PLOT_KEY_CODE=79;//O
    public static int OPEN_NEW_WINDOW_KEY_CODE=78;//N
    public static int OPEN_SETTINGS_WINDOW_KEY_CODE=73;//I
    public static int REFRESH_FRAME_KEY_CODE=116;//F5
    public static int SAVE_GRAPH_IMAGE_KEY_CODE=83;//S
    public static int TOGGLE_BOTTOM_PANEL_VISIBILITY_KEY_CODE=69;//E
    public static int TOGGLE_FULLSCREEN_MODE_KEY_CODE=122;//F11

    public static String CLOSE_WINDOW_KEY_STRING="W";
    public static String OPEN_HELP_WINDOW_KEY_STRING="F1";
    public static String OPEN_NEW_PLOT_KEY_STRING="O";
    public static String OPEN_NEW_WINDOW_KEY_STRING="N";
    public static String OPEN_SETTINGS_WINDOW_KEY_STRING="I";
    public static String REFRESH_FRAME_KEY_STRING="F5";
    public static String SAVE_GRAPH_IMAGE_KEY_STRING="S";
    public static String TOGGLE_BOTTOM_PANEL_VISIBILITY_KEY_STRING = "E";
    public static String TOGGLE_FULLSCREEN_MODE_KEY_STRING="F11";

    public static int HEIGHT_OF_DATA_BLOCK=25;
    public static int WIDTH_OF_DATA_BLOCK=370;
    public static int NUMBER_OF_KEY_COMBOS=9;
    public static int NUMBER_OF_COPYRIGHT_NOTES=2000;
    public static int NUMBER_OF_CONFIG_ENTRIES=91;

    private boolean allowKeyCombinationChange=false;
    private boolean bottomPanelExpanded=false;
    private boolean changeAltDown=false;
    private boolean changeCtrlDown=false;
    private boolean changeShiftDown=false;
    private boolean jFilePickerFailed=false;
    private boolean fullscreen=false;
    private boolean saveJpeg=true;
    private boolean savePng=true;
    private boolean autoUpdate=true;
    private boolean fullscreenOk=false;
    private boolean bottomPanelExpandedOnStartup=false;
    private boolean fullscreenOnStartup=false;
    private boolean keyCombinationsEnabled=true;
    private boolean isCustomInterpolated;
    private boolean getImageSizeAutomatically;
    private boolean geoMode;
    private boolean replotting=false;
    private boolean onlyInterpolationChanging=false;
    private boolean isAlwaysOnTop=false;
    private boolean[] graphIsVisible;

    private BufferedReader br;

    private BufferedWriter bw;

    private ButtonGroup FullscreenOptionsButtonGroup;
    private ButtonGroup UpdateOptionsButtonGroup;
    private ButtonGroup interpolateButtonGroup;
    private ButtonGroup GeoModeButtonGroup;

    private ChartPanel chartPanel;

    private Crosshair xCrosshair;
    private Crosshair[] yCrosshairs;

    private CrosshairOverlay crosshairOverlay;

    private Dimension fullscreenDimension;
    private Dimension windowDimension;
    private Dimension bottomPanelDimension;
    private Dimension topPanelDimension;

    private File csvFile;
    private File configFile;
    private File oldFile;
    private static File logFile;

    private FileOutputStream fileOutputStream;

    private static FileWriter logWriter;

    private GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

    private int changeKeyCode;
    private int counter=0;
    private int dataPanelX=0;
    private int dataPanelY;
    private int numberOfGraphs;
    private int titleNumber=1;
    private int width;
    private int height;
    private int currentlyEditedKeyCombinationNumber;
    private int interpolationOffset=0;
    private int interpolationFactor=0;
    private int imageWidth;
    private int imageHeight;

    private JButton changeKeyCombinationButton;
    private JButton saveKeyCombinationButton;
    private JButton helpWindowCloseButton;
    private JButton UpdateNow;
    private JButton changeInterpolationSettings;
    private JButton GeoModeOkButton;
    private JButton[] KeyCombinationChangeButton;

    private JCheckBox jpegCheckBox;
    private JCheckBox pngCheckBox;
    private JCheckBox dataPanelOnStartup;
    private JCheckBox fullscreenOnStartupComboBox;
    private JCheckBox FiletypePngCheckBox;
    private JCheckBox FiletypeJpgCheckBox;
    private JCheckBox imageSizeAutoCheckBox;
    private JCheckBox[] selectGraphVisibilityCheckBox;

    private JFileChooser fileChooser;

    private JFreeChart jFreeChart;

    private JFrame setNewKeyCombinationWindow;
    private JFrame fileChooserWindow;
    private JFrame helpWindow;
    private JFrame mainWindow;
    private JFrame settingsWindow;

    private JLabel KeyCombinationPanelTitle;
    private JLabel pleaseWaitMessageText;
    private JLabel[] configureKeyCombinationText;
    private JLabel[] copyrightNotes;
    private JLabel[] dataLabels;
    private JLabel[] helpWindowText;
    private JLabel[] settingsWindowText;

    private JMenu fileMenu;
    private JMenu openHelpWindowMenu;
    private JMenu openSettingsWindowMenu;
    private JMenu toggleFullscreenModeMenu;
    private JMenu saveGraphImagesMenu;
    private JMenu toggleDataPanelMenu;

    private JMenuBar mainWindowMenuBar;

    private JMenuItem closeWindowMenuItem;
    private JMenuItem openDifferentPlotMenuItem;
    private JMenuItem openNewWindowMenuItem;

    private JPanel dataPanel;
    private JPanel helpPanel;
    private JPanel KeyCombinationSettingsFramePanel;
    private JPanel pleaseWaitMessagePanel;
    private JPanel GeneralSettings;
    private JPanel GraphSettings;
    private JPanel KeyCombinationSettings;
    private JPanel FileTypePanel;
    private JPanel FullscreenOptionsPanel;
    private JPanel FullscreenOptionsButtonGroupPanel;
    private JPanel UpdateOptionsPanel;
    private JPanel UpdateOptionsButtonGroupPanel;
    private JPanel GeoModePanel;
    private JPanel interpolateOffsetPanel;
    private JPanel interpolateOffsetValuePanel;
    private JPanel interpolateCustomPanel;
    private JPanel visibilitySettings;
    private JPanel interpolationSettings;
    private JPanel FileSizePanel;
    private JPanel selectVisibleGraphsPanel;
    private JPanel interpolationSettingsBasePanel;
    private JPanel GeneralInterpolationSettings;
    private JPanel[] dataPanels;
    private JPanel[] KeyCombinationSettingsEntryPanel;

    private JRadioButton MaximizeWindowRadioButton;
    private JRadioButton FullscreenExclusiveRadioButton;
    private JRadioButton AutoUpdateRadioButton;
    private JRadioButton ManualUpdateRadioButton;
    private JRadioButton interpolate1x;
    private JRadioButton interpolate4x;
    private JRadioButton interpolate10x;
    private JRadioButton interpolate100x;
    private JRadioButton interpolate1000x;
    private JRadioButton interpolateCustom;
    private JRadioButton RegularModeButton;
    private JRadioButton GeoModeButton;

    private JScrollPane helpWindowScrollPane;
    private JScrollPane selectVisibleGraphsScrollPane;

    private JTabbedPane SettingsPageTabbedPane;

    private JTextField keyComboAusgabe;
    private JTextField imageWidthBox;
    private JTextField imageHeightBox;
    private JTextField interpolateCustomInputBox;
    private JTextField interpolationOffsetValueBox;
    private JTextField[] dataBoxes;

    private Raumklima next;
    private Raumklima previous;

    private ReadableByteChannel readableByteChannelFromSource;

    private String changeKeyChar;
    private String title="Raumklima-Auswertungssoftware";
    private String[] dataValueDescriptors;
    private String[] configRaw;
    private String[] setNewKeyCombinationTexts;

    private URL source;

    private XYSeries[] xYSeries;

    private XYSeriesCollection xYSeriesCollection;
    private JPanel DeviceSettings;
    private JLabel DeviceSettingsTitle;
    JButton SetRTCButton;
    private JLabel SystemTimeLabel;
    private JLabel DeviceTimeLabel;
    private JPanel SystemTimePanel;
    private JPanel DeviceTimePanel;
    private JTextField SystemTimeField;
    private Timer SystemTimeFieldTimer;
    private SimpleDateFormat SystemTimeFormatter;
    private JTextField DeviceTimeField;
    Timer DeviceTimeFieldTimer;
    Date DeviceDate;
    long DeviceMillis;
    SerialPort[] ports;
    SerialPort port;
    Scanner serialScanner;
    BufferedWriter serialWriter;
    SimpleDateFormat DeviceDateFormat;
    boolean SerialAvailable;
    private JPanel DeviceConnPanel;
    private JComboBox<String> DeviceConnComboBox;
    private JButton DeviceConnRefreshButton;
    private JButton DeviceConnConnectButton;
    private int selectedPort;
    private SerialWorker SerialListener;
    private Thread SerialThread;
    String RXDate;
    JPanel TimePanel;
	private boolean SerialForbidden;

    public static void main(String[] args){//Startet das Programm (ggf mnit debug/logging)
        for(int i=0;i<args.length;i++){
            if(args[i].equalsIgnoreCase("log")||args[i].equalsIgnoreCase("l")||args[i].equalsIgnoreCase("/log")||args[i].equalsIgnoreCase("/l")||args[i].equalsIgnoreCase("-log")||args[i].equalsIgnoreCase("-l")){
                logging=true;
                log("");
                System.out.println("Dateiname für die Aufzeichnung: "+logFile.getName());
            }
            if(args[i].equalsIgnoreCase("debug")||args[i].equalsIgnoreCase("d")||args[i].equalsIgnoreCase("/debug")||args[i].equalsIgnoreCase("/d")||args[i].equalsIgnoreCase("-debug")||args[i].equalsIgnoreCase("-d")){
                debug=true;
                logln("Debugmodus aktiviert");
            }
            else if(args[i].equalsIgnoreCase("?")||args[i].equalsIgnoreCase("help")||args[i].equalsIgnoreCase("h")||args[i].equalsIgnoreCase("/?")||args[i].equalsIgnoreCase("/help")||args[i].equalsIgnoreCase("/h")||args[i].equalsIgnoreCase("-?")||args[i].equalsIgnoreCase("-help")||args[i].equalsIgnoreCase("-h")){
                System.out.println("\nBefehlszeilenparameter\n\n\"d\" oder \"debug\"\t\tDebugmodus\n\"l\" oder \"log\"\t\t\tAusgabe in Datei abspeichern\n\"h\", \"?\" oder \"help\"\t\tdiese Hilfe anzeigen");
                System.exit(0);
            }
        }
        new Raumklima();
    }

    public static void log(Object msg){//anstatt von System.out.print() wird log() verwendet; folgende methoden analog
        if(debug){
            System.out.print(msg);
        }
        try{
            if(logging){
                if(log_ready){//falls logdatei schon vorhanden => reinschreiben
                    logWriter.write(String.valueOf(msg));
                    logWriter.flush();
                }
                else{//sonst erst ertellen und dann reinschreiben
                    logFile=new File("RaumklimaLog_"+new SimpleDateFormat("dd.MM.yyyy_HH,mm").format(new Date())+".txt");
                    logWriter=new FileWriter(logFile);
                    log_ready=true;
                    logWriter.write(String.valueOf(msg));
                    logWriter.flush();
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void logln(Object msg){
        if(debug){
            System.out.println(msg);
        }
        try{
            if(logging){
                if(log_ready){
                    logWriter.write(String.valueOf(msg)+System.lineSeparator());
                    logWriter.flush();
                }
                else{
                    logFile=new File("RaumklimaLog_"+new SimpleDateFormat("dd.MM.yyyy_HH,mm").format(new Date())+".txt");
                    logWriter=new FileWriter(logFile);
                    log_ready=true;
                    logWriter.write(String.valueOf(msg)+System.lineSeparator());
                    logWriter.flush();
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void logln(){
        if(debug){
            System.out.println();
        }
        try{
            if(logging){
                if(log_ready){
                    logWriter.write(System.lineSeparator());
                    logWriter.flush();
                }
                else{
                    logFile=new File("RaumklimaLog_"+new SimpleDateFormat("dd.MM.yyyy_HH,mm").format(new Date())+".txt");
                    logWriter=new FileWriter(logFile);
                    log_ready=true;
                    logWriter.write(System.lineSeparator());
                    logWriter.flush();
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * the standard constructor
     * This Constructor just calls the {@code setup()} Method.
     */
    public Raumklima(){
        setup(true,"");
    }

    /**
     * the Secondary Constructor, which includes the "advanced" features (for the numbering scheme). This Constructor just calls the setup Method.
     * @param newTitleNumber the number that should be displayed in the Titlebar on the MainWindow
     * @param newPrevious the preceding instance of Raumklima (only used to update the numbering scheme if a window is closed or opened)
     * @param newNext the following instance of Raumklima (only used to update the numbering scheme if a window is closed or opened)
     */
    public Raumklima(int newTitleNumber, Raumklima newPrevious, Raumklima newNext) {
        SerialForbidden=true;
        titleNumber=newTitleNumber;
        previous=newPrevious;
        next=newNext;
        setup(true,"");
    }

    /**
     * This Method does basically all the initialisation. It is called by all Constructors.
     * @param settingsWindowUpperLeftPanel 
     */
    private void setup(boolean usingFileChooser, String fileName){

        logln(Charset.defaultCharset());
        //check if the Configurationfile exists, if not download it
        configFile=new File("RaumklimaConfig.txt");
        if(!configFile.exists()){//falls keine config datei vorhanden => standadddatei herunterladen
            //https://stackoverflow.com/questions/921262/how-to-download-and-save-a-file-from-internet-using-java
            //(antwort von dfa und Attila)
            //how-to-download-and-save-a-file-from-internet-using-java.htm
            //1.9.17 20:58
            try{
                source = new URL(projectUri+branch+"/PublicVersion/RaumklimaConfig.txt");
                readableByteChannelFromSource = Channels.newChannel(source.openStream());
                fileOutputStream = new FileOutputStream("RaumklimaConfig.txt");
                fileOutputStream.getChannel().transferFrom(readableByteChannelFromSource, 0, Long.MAX_VALUE);
                fileOutputStream.close();
                configFile=new File("RaumklimaConfig.txt");
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

        //Check for Software updates
        if(autoUpdate){
            if(checkIfUpdateAvailable()){
                updateJar();
            }
        }
        
        if(!SerialForbidden) {
        ports=SerialPort.getCommPorts();
        SerialPort P;
        for(int i=0;i<ports.length;i++) {
            P=ports[i];
            logln(P.getDescriptivePortName()+"|"+P.getSystemPortName());
            if(P.getDescriptivePortName().startsWith("Arduino Mega 2560")) {//"Arduino Leonardo")){
                port=P;
                port.setBaudRate(115200);
                SerialAvailable=port.openPort();
                logln(port.isOpen());
                SerialAvailable=port.isOpen();
                selectedPort=i;
            }
        }
        logln(SerialAvailable);
        if(port==null) {
            logln("NO APROPRIATE SERIAL PORT");
            SerialAvailable=false;
        }
        else {
            if(SerialAvailable) {
                logln(port);
                serialScanner=new Scanner(new InputStreamReader(port.getInputStream()));
                serialWriter=new BufferedWriter(new OutputStreamWriter(port.getOutputStream()));
                SerialAvailable=true;
            }
        }
        }
        else {
        	SerialAvailable=false;
        }

        //intialise JFrames
        fileChooserWindow=new JFrame();
        settingsWindow=new JFrame();
        helpWindow=new JFrame();
        mainWindow=new JFrame();
        setNewKeyCombinationWindow=new JFrame();

        //Set a Different Cursor to indicate The program is working
        try{
            mainWindow.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        }
        catch(Exception e){
            e.printStackTrace();
        }

        //Initialise and fill the pleaseWaitMessagePanel
        pleaseWaitMessagePanel=new JPanel(new BorderLayout());
        pleaseWaitMessageText=new JLabel("Bitte Warten...");
        pleaseWaitMessageText.setHorizontalAlignment(SwingConstants.CENTER);
        pleaseWaitMessagePanel.add(pleaseWaitMessageText,BorderLayout.CENTER);

        //Add the temporary pleaseWaitMessagePanel to The Window
        mainWindow.add(pleaseWaitMessagePanel);

        //make the plain empty JFrame visible, so the User knows that something's happening
        mainWindow.setSize(800, 480);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setVisible(true);

        //setup some very basic stuff

        //setup some basic sizes
        fullscreenDimension=new Dimension(graphicsDevice.getDisplayMode().getWidth(),graphicsDevice.getDisplayMode().getHeight());

        //setup the logo

        URL url=getClass().getResource("Resources/Weather.png");

        logln(url);
        mainWindow.setIconImage(new ImageIcon(url).getImage());
        //https://stackoverflow.com/questions/9864267/loading-image-resource/9866659#9866659 antwort von icza

        //read the ConfigurationFile
        loadConfigurationFile();

        //Initialise and setup FileChooser
        fileChooser=new JFileChooser();
        fileChooser.setDialogTitle("Bitte CSV-Datei auswählen");
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Aufgezeichnete Klimadaten (.csv/.CSV)","csv","CSV","Csv"));

        //setup the MainWindow
        mainWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        mainWindow.setMinimumSize(new Dimension(WIDTH_OF_DATA_BLOCK,400));//mindestens 1 block der Textfelder MUSS draufpassen (370px)
        setTitle();

        //Validiere das hauptfenster nochmals
        mainWindow.validate();

        //get the data and draw the graph
        //proceed only if successful otherwise exit
        pickCsvFile(usingFileChooser,fileName);
        if(jFilePickerFailed==false){
            jFreeChart = createDataset();
            setupCrosshairOverlays();

            setupDataPanel();

            mainWindow.setJMenuBar(createMainWindowMenuBar());
            setupChangeKeyCombinationHelperWindow();
            setupHelpWindow();
            setupSettingsWindow();
            settingsWindow.validate();
            //validiere das hilfefenster nochmals 
            helpWindow.validate();

            //Remove the temporary pleaseWaitMessagePanel
            //TODO WTF Why does it have worked even with this NOT beeing commented out? mainWindow.remove(pleaseWaitMessagePanel);

            mainWindow.add(chartPanel,BorderLayout.NORTH);
            mainWindow.add(dataPanel,BorderLayout.SOUTH);

            //make the program able to react by adding the ActionListeners
            keyComboAusgabe.addKeyListener(this);
            mainWindow.addKeyListener(this);
            mainWindow.addComponentListener(this);
            mainWindow.addWindowStateListener(this);
            mainWindow.addWindowListener(this);
            chartPanel.addChartMouseListener(this);
            mainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            //if the fullscreenMode should be activated on startup, do it now
            if(fullscreenOnStartup){
                fullscreen=false;
                toggleFullscreen();
            }
            //if the mottomPanel should be made invisible on startup, do it here
            if(bottomPanelExpandedOnStartup){
                toggleBottomPanel();
            }
            chartPanel.getPopupMenu().remove(3);//den punkt speichern zum speichern des aktuellen Chartinhalts entfernen, da es sonst probleme mit dem vollbildmodus gibt wenn jemand darauf klickt.
            refreshPage();
            //revert the Cursor Back To Normal
            mainWindow.setCursor(Cursor.getDefaultCursor());
            mainWindow.remove(pleaseWaitMessagePanel);
            mainWindow.setAlwaysOnTop(isAlwaysOnTop);
        }
        else{
            exit();
        }
    }

    /*
     * initialisiert den datenbereich/detailbereich (unten die textfelder)
     */
    private void setupDataPanel() {
        //Initialise the DataPanel
        dataPanelX=floor(fullscreenDimension.width/370);
        dataPanelY=roof((double)((double)numberOfGraphs/(double)dataPanelX));

        if(dataPanelX*dataPanelY<numberOfGraphs){
            //Something went TERRIBLY WRONG!!!!
            //HASN'T BEEN OBSERVED FOR A LONG TIME (a lot of options have been tested)
            //Probably will never occur again
            System.err.println("HELP: SPACIAL COLLISION OF numberOfGraphs and panelX/Y: "+numberOfGraphs+"|"+dataPanelX+"x"+dataPanelY);
            logln("HELP: SPACIAL COLLISION OF numberOfGraphs and panelX/Y: "+numberOfGraphs+"|"+dataPanelX+"x"+dataPanelY);
        }

        dataPanel=new JPanel(new GridLayout(dataPanelY,dataPanelX*2));

        dataLabels=new JLabel[numberOfGraphs];
        dataBoxes=new JTextField[numberOfGraphs];
        dataPanels=new JPanel[numberOfGraphs];

        for(int i=0;i<numberOfGraphs;i++){
            dataPanels[i]=new JPanel(new GridLayout(1,2));
            dataPanels[i].setPreferredSize(new Dimension(WIDTH_OF_DATA_BLOCK,HEIGHT_OF_DATA_BLOCK));
            dataLabels[i]=new JLabel(dataValueDescriptors[i]);
            dataBoxes[i]=new JTextField();
            dataPanels[i].add(dataLabels[i]);
            dataPanels[i].add(dataBoxes[i]);
            dataPanel.add(dataPanels[i]);
        }
    }

    /*
     * initialisiert die crosshairs, also die fadenkreuze
     */
    private void setupCrosshairOverlays() {
        chartPanel = new ChartPanel(jFreeChart);
        crosshairOverlay = new CrosshairOverlay();
        xCrosshair = new Crosshair(Double.NaN, (Paint)Color.GRAY, (Stroke)new BasicStroke(0.0f));
        xCrosshair.setLabelVisible(true);
        crosshairOverlay.addDomainCrosshair(xCrosshair);
        yCrosshairs = new Crosshair[numberOfGraphs];
        for (int i = 0; i < numberOfGraphs; ++i) {
            yCrosshairs[i] = new Crosshair(Double.NaN, (Paint)Color.GRAY, (Stroke)new BasicStroke(0.0f));
            yCrosshairs[i].setLabelVisible(true);
            if (i % 2 != 0) {
                yCrosshairs[i].setLabelAnchor(RectangleAnchor.TOP_RIGHT);
            }
            crosshairOverlay.addRangeCrosshair(yCrosshairs[i]);
        }
        chartPanel.addOverlay((Overlay)crosshairOverlay);
    }

    /*
     * Fenster mit anweisungen für das ändern der tastenkombis
     */
    private void setupChangeKeyCombinationHelperWindow() {
        try{
            setNewKeyCombinationTexts=new String[NUMBER_OF_KEY_COMBOS];
            JPanel auxiliaryPanel=new JPanel();
            auxiliaryPanel.setLayout(new BoxLayout(auxiliaryPanel,BoxLayout.Y_AXIS));
            setNewKeyCombinationWindow.setTitle("Tastenkombination ändern");
            setNewKeyCombinationWindow.setSize(new Dimension(540,470));
            setNewKeyCombinationWindow.setLocationRelativeTo(null);
            br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("configureKeyComboText.txt")));
            int anz=12;
            configureKeyCombinationText=new JLabel[anz];
            for(int i=0;i<anz;i++){
                configureKeyCombinationText[i]=new JLabel(br.readLine());
                auxiliaryPanel.add(configureKeyCombinationText[i]);
            }
            keyComboAusgabe=new JTextField();
            keyComboAusgabe.setEditable(false);
            //keyComboAusgabe.setFocusable(false);
            auxiliaryPanel.add(keyComboAusgabe);
            changeKeyCombinationButton=new JButton("Ändern");
            changeKeyCombinationButton.addActionListener(this);
            auxiliaryPanel.add(changeKeyCombinationButton);
            saveKeyCombinationButton=new JButton("Schließen");
            saveKeyCombinationButton.addActionListener(this);
            auxiliaryPanel.add(saveKeyCombinationButton);
            setNewKeyCombinationWindow.add(auxiliaryPanel);
            setNewKeyCombinationWindow.validate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /*
     * Einstellungsfenst6er und alle inhalte initialisieren
     */
    private void setupSettingsWindow(){
        settingsWindowText=new JLabel[NUMBER_OF_KEY_COMBOS];
        KeyCombinationChangeButton=new JButton[NUMBER_OF_KEY_COMBOS];
        KeyCombinationSettingsEntryPanel=new JPanel[NUMBER_OF_KEY_COMBOS];

        //SettingsWindow
        settingsWindow.setSize(800,480);
        settingsWindow.setTitle("Einstellungen");
        settingsWindow.setLocationRelativeTo(null);
        KeyCombinationSettingsFramePanel=new JPanel();

        SettingsPageTabbedPane=new JTabbedPane();
        GeneralSettings=new JPanel(); //F11, Updates prüfen, Update policy, Dateitypen 
        GraphSettings=new JPanel();  //sichtbarkeit, interplolation
        KeyCombinationSettings=new JPanel();  //keys ändern
        DeviceSettings=new JPanel();

        GeneralSettings.setLayout(new BoxLayout(GeneralSettings, BoxLayout.Y_AXIS));

        FileTypePanel=new JPanel();
        FileTypePanel.setLayout(new BoxLayout(FileTypePanel, BoxLayout.Y_AXIS));
        FileTypePanel.add(new JLabel("Optionen für das Abspeichern des momentanen Bildes"));
        FiletypePngCheckBox=new JCheckBox("PNG");
        FiletypePngCheckBox.setSelected(savePng);
        FiletypePngCheckBox.addActionListener(this);
        FiletypeJpgCheckBox=new JCheckBox("JPG");
        FiletypeJpgCheckBox.setSelected(saveJpeg);
        FiletypeJpgCheckBox.addActionListener(this);
        FileTypePanel.add(FiletypePngCheckBox);
        FileTypePanel.add(FiletypeJpgCheckBox);
        FileSizePanel=new JPanel();
        FileSizePanel.setLayout(new BoxLayout(FileSizePanel,BoxLayout.X_AXIS));
        imageWidthBox=new JTextField();
        imageWidthBox.setText(String.valueOf(imageWidth));
        imageWidthBox.setMinimumSize(new Dimension(50,23));
        imageWidthBox.setMaximumSize(new Dimension(50,23));
        imageWidthBox.getDocument().addDocumentListener(new DocumentListener(){

                @Override
                public void changedUpdate(DocumentEvent e) {}

                @Override
                public void insertUpdate(DocumentEvent e) {

                    logln("A");
                    imageWidth=Integer.parseInt(imageWidthBox.getText());
                    reloadBackend();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    if(!imageWidthBox.getText().equals("")){

                        logln("B");
                        imageWidth=Integer.parseInt(imageWidthBox.getText());
                        reloadBackend();
                    }
                }

            });
        imageHeightBox=new JTextField();
        imageHeightBox.setText(String.valueOf(imageHeight));
        imageHeightBox.setMinimumSize(new Dimension(50,23));
        imageHeightBox.setMaximumSize(new Dimension(50,23));
        imageHeightBox.getDocument().addDocumentListener(new DocumentListener(){

                @Override
                public void changedUpdate(DocumentEvent e) {}

                @Override
                public void insertUpdate(DocumentEvent e) {

                    logln("A");
                    imageHeight=Integer.parseInt(imageHeightBox.getText());
                    reloadBackend();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    if(!imageHeightBox.getText().equals("")){

                        logln("B");
                        imageHeight=Integer.parseInt(imageHeightBox.getText());
                        reloadBackend();
                    }
                }

            });
        FileSizePanel.add(imageWidthBox);
        FileSizePanel.add(new JLabel("x"));
        FileSizePanel.add(imageHeightBox);
        FileSizePanel.add(new JLabel("    "));
        imageSizeAutoCheckBox=new JCheckBox("Automatisch festlegen");
        FileSizePanel.add(imageSizeAutoCheckBox);
        imageSizeAutoCheckBox.addActionListener(this);
        if(getImageSizeAutomatically){
            imageHeightBox.setEnabled(false);
            imageWidthBox.setEnabled(false);
            imageSizeAutoCheckBox.setSelected(true);
        }
        FileSizePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        FileTypePanel.add(FileSizePanel);
        FileSizePanel.validate();
        FileTypePanel.add(new JLabel(" "));
        FileTypePanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        FullscreenOptionsPanel=new JPanel();
        FullscreenOptionsPanel.setLayout(new BoxLayout(FullscreenOptionsPanel, BoxLayout.Y_AXIS));
        FullscreenOptionsButtonGroup=new ButtonGroup();
        MaximizeWindowRadioButton=new JRadioButton("Fenster Maximieren");
        FullscreenExclusiveRadioButton=new JRadioButton("Vollbildmodus (Nicht verfügbar auf Computern mit Intel-Grafik)");
        FullscreenOptionsButtonGroup.add(MaximizeWindowRadioButton);
        FullscreenOptionsButtonGroup.add(FullscreenExclusiveRadioButton);
        MaximizeWindowRadioButton.setSelected(!fullscreenOk);
        FullscreenExclusiveRadioButton.setSelected(fullscreenOk);
        MaximizeWindowRadioButton.addActionListener(this);
        FullscreenExclusiveRadioButton.addActionListener(this);
        FullscreenOptionsPanel.add(new JLabel("Vollbildmodus"));
        FullscreenOptionsButtonGroupPanel=new JPanel();
        FullscreenOptionsButtonGroupPanel.setLayout(new BoxLayout(FullscreenOptionsButtonGroupPanel, BoxLayout.Y_AXIS));
        FullscreenOptionsButtonGroupPanel.add(MaximizeWindowRadioButton);
        FullscreenOptionsButtonGroupPanel.add(FullscreenExclusiveRadioButton);
        FullscreenOptionsButtonGroupPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        FullscreenOptionsPanel.add(FullscreenOptionsButtonGroupPanel);
        FullscreenOptionsPanel.add(new JLabel(" "));
        FullscreenOptionsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        CheckFullscreenAvailability();

        GeoModePanel=new JPanel();
        GeoModePanel.setLayout(new BoxLayout(GeoModePanel,BoxLayout.Y_AXIS));
        GeoModePanel.add(new JLabel("Anzeigemodus:"));
        GeoModeButtonGroup=new ButtonGroup();
        RegularModeButton=new JRadioButton("Standardmodus");
        GeoModeButton=new JRadioButton("Geographie-modus (NUR Tagestemperaturdurchschnitt und Tagesniederschlag)");
        GeoModeButtonGroup.add(GeoModeButton);
        GeoModeButtonGroup.add(RegularModeButton);
        GeoModePanel.add(RegularModeButton);
        GeoModePanel.add(GeoModeButton);
        GeoModeOkButton=new JButton("Übernehmen");
        GeoModeOkButton.addActionListener(this);
        GeoModePanel.add(GeoModeOkButton);
        GeoModePanel.add(new JLabel(" "));
        GeoModeButton.setSelected(geoMode);
        RegularModeButton.setSelected(!geoMode);

        UpdateOptionsPanel=new JPanel();
        UpdateOptionsPanel.setLayout(new BoxLayout(UpdateOptionsPanel, BoxLayout.Y_AXIS));
        UpdateOptionsButtonGroup=new ButtonGroup();
        AutoUpdateRadioButton=new JRadioButton("Automatisch beim Start prüfen");
        ManualUpdateRadioButton=new JRadioButton("Nur Manuell");
        UpdateOptionsButtonGroup.add(AutoUpdateRadioButton);
        UpdateOptionsButtonGroup.add(ManualUpdateRadioButton);
        AutoUpdateRadioButton.setSelected(autoUpdate);
        ManualUpdateRadioButton.setSelected(!autoUpdate);
        UpdateNow=new JButton("Jetzt auf Updates prüfen");
        UpdateNow.addActionListener(this);
        AutoUpdateRadioButton.addActionListener(this);
        ManualUpdateRadioButton.addActionListener(this);
        UpdateOptionsButtonGroupPanel=new JPanel();
        UpdateOptionsButtonGroupPanel.setLayout(new BoxLayout(UpdateOptionsButtonGroupPanel, BoxLayout.Y_AXIS));
        UpdateOptionsButtonGroupPanel.add(AutoUpdateRadioButton);
        UpdateOptionsButtonGroupPanel.add(ManualUpdateRadioButton);
        UpdateOptionsButtonGroupPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        UpdateOptionsPanel.add(new JLabel("Update Optionen"));
        UpdateOptionsPanel.add(UpdateOptionsButtonGroupPanel);
        UpdateOptionsPanel.add(UpdateNow);
        UpdateOptionsPanel.add(new JLabel(" "));
        UpdateOptionsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        GeneralSettings.add(FileTypePanel);
        GeneralSettings.add(FullscreenOptionsPanel);
        GeneralSettings.add(GeoModePanel);
        GeneralSettings.add(UpdateOptionsPanel);

        setupGraphSettings();

        KeyCombinationPanelTitle=new JLabel("Tastenkürzel:");
        KeyCombinationPanelTitle.setFont(new Font(Font.SERIF,Font.BOLD, 16));
        KeyCombinationSettingsFramePanel.setLayout(new GridLayout(0,1));
        KeyCombinationSettingsFramePanel.add(KeyCombinationPanelTitle);
        for(int i=0;i<NUMBER_OF_KEY_COMBOS;i++){
            KeyCombinationSettingsEntryPanel[i]=new JPanel(new BorderLayout());
            settingsWindowText[i]=new JLabel();
            settingsWindowText[i].setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
            KeyCombinationSettingsEntryPanel[i].add(settingsWindowText[i],BorderLayout.WEST);
            KeyCombinationChangeButton[i]=new JButton("Ändern");
            KeyCombinationChangeButton[i].setPreferredSize(new Dimension(100,25));
            KeyCombinationChangeButton[i].addActionListener(this);
            KeyCombinationSettingsEntryPanel[i].add(KeyCombinationChangeButton[i],BorderLayout.EAST);
            KeyCombinationSettingsFramePanel.add(KeyCombinationSettingsEntryPanel[i]);
        }
        loadTextForHelpWindowAndKeyCombinations();
        KeyCombinationSettings.add(KeyCombinationSettingsFramePanel);

        DeviceSettings.setLayout(new BoxLayout(DeviceSettings,BoxLayout.Y_AXIS));

        DeviceSettingsTitle=new JLabel("Geräte-Einstellungen");
        DeviceSettingsTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        DeviceSettings.add(DeviceSettingsTitle);

        TimePanel=new JPanel(new BorderLayout());
        TimePanel.setPreferredSize(new Dimension(550,75));
        TimePanel.setMaximumSize(new Dimension(550,75));
        TimePanel.setMinimumSize(new Dimension(550,75));
        TimePanel.setAlignmentX(Component.LEFT_ALIGNMENT);//|||||||||||||||||||||||||||||||||||||||||||||||||
        //TimePanel.setBackground(Color.GREEN);

        DeviceConnPanel=new JPanel();
        //DeviceConnPanel.setBackground(Color.RED);
        DeviceConnPanel.setAlignmentX(Component.LEFT_ALIGNMENT);//|||||||||||||||||||||||||||||||||||||||||||||||||
        DeviceConnPanel.setPreferredSize(new Dimension(600,50));
        DeviceConnPanel.setMaximumSize(new Dimension(600,50));
        DeviceConnPanel.setMinimumSize(new Dimension(600,50));
        DeviceConnComboBox=new JComboBox<String>();
        DeviceConnRefreshButton=new JButton("Aktualisieren");
        DeviceConnConnectButton=new JButton("Verbinden");
        if(!SerialForbidden) {
            DeviceConnConnectButton.addActionListener(this);
            DeviceConnRefreshButton.addActionListener(this);
        for(SerialPort P:ports) {
            DeviceConnComboBox.addItem(P.getDescriptivePortName());
        }
        if(SerialAvailable) {
            DeviceConnComboBox.setSelectedIndex(selectedPort);
        }
        }
        if(SerialForbidden) {
        	DeviceConnPanel.add(new JLabel("KEIN ZUGRIFF AUF SERIELLE SCHNITTSTELLE - Bitte Programm neustarten um Zugriff zu Bekommen"), BorderLayout.NORTH);
        }
        DeviceConnPanel.add(new JLabel("Verbinden mit: "), BorderLayout.NORTH);
        DeviceConnPanel.add(DeviceConnComboBox, BorderLayout.CENTER);
        DeviceConnPanel.add(DeviceConnConnectButton, BorderLayout.EAST);
        DeviceConnPanel.add(DeviceConnRefreshButton, BorderLayout.SOUTH);

        DeviceSettings.add(DeviceConnPanel);
        if(SerialForbidden) {
        DeviceConnPanel.setEnabled(false);
        DeviceConnComboBox.setEnabled(false);
        DeviceConnConnectButton.setEnabled(false);
        DeviceConnRefreshButton.setEnabled(false);
        }

        SystemTimePanel=new JPanel();
        SystemTimePanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        //SystemTimePanel.setBackground(Color.YELLOW);
        SystemTimePanel.setPreferredSize(new Dimension(220,22));
        SystemTimePanel.setMaximumSize(new Dimension(220,22));
        SystemTimePanel.setMinimumSize(new Dimension(220,22));
        SystemTimeLabel=new JLabel("Systemzeit: ");
        SystemTimeField=new JTextField();
        SystemTimeField.setEditable(false);
        SystemTimeFormatter=new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        SystemTimeField.setText(SystemTimeFormatter.format(new Date(System.currentTimeMillis())));
        SystemTimeFieldTimer=new Timer(1000, new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    SystemTimeField.setText(SystemTimeFormatter.format(new Date(System.currentTimeMillis())));
                }
            }
        );
        SystemTimeFieldTimer.start();

        SystemTimePanel.add(SystemTimeLabel,BorderLayout.WEST);
        SystemTimePanel.add(SystemTimeField,BorderLayout.EAST);
        SystemTimePanel.setPreferredSize(new Dimension(200,25));
        //SystemTimePanel.setAlignmentX(Component.RIGHT_ALIGNMENT);

        TimePanel.add(SystemTimePanel,BorderLayout.NORTH);

        DeviceTimePanel=new JPanel();
        DeviceTimePanel.setAlignmentX(Component.RIGHT_ALIGNMENT);//////////////////////////////////////////////////////
        //DeviceTimePanel.setBackground(Color.BLUE);
        DeviceTimePanel.setPreferredSize(new Dimension(220,22));
        DeviceTimePanel.setMaximumSize(new Dimension(220,22));
        DeviceTimePanel.setMinimumSize(new Dimension(220,22));
        DeviceTimeLabel=new JLabel("Gerätezeit: ");
        DeviceTimeField=new JTextField("UNBEKANNT");
        DeviceTimeField.setEditable(false);

        DeviceDateFormat=new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        RXDate="";//"11.11.2011 11:10:11";
        if((!SerialForbidden)&&SerialAvailable) {
        SerialListener=new SerialWorker(this);
        SerialThread=new Thread(SerialListener);
        SerialThread.start();
        DeviceTimeFieldTimer=new Timer(1000, new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    DeviceMillis+=1000;
                    DeviceTimeField.setText(SystemTimeFormatter.format(new Date(DeviceMillis)));
                }
            }
        );
            DeviceTimeFieldTimer.start();
        }

        DeviceTimePanel.add(DeviceTimeLabel,BorderLayout.WEST);
        DeviceTimePanel.add(DeviceTimeField,BorderLayout.EAST);
        DeviceTimePanel.setPreferredSize(new Dimension(200,25));
        DeviceTimePanel.setAlignmentX(Component.RIGHT_ALIGNMENT);

        TimePanel.add(DeviceTimePanel,BorderLayout.CENTER);
        TimePanel.add(new JLabel("HINWEIS: Bitte warten Sie etwa 30 Sekunden, bevor Sie Versuchen die Uhr zu Stellen."),BorderLayout.SOUTH);

        TimePanel.validate();
        DeviceSettings.add(TimePanel);

        SetRTCButton=new JButton("Uhr Stellen");
        SetRTCButton.addActionListener(this);
        SetRTCButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        DeviceSettings.add(SetRTCButton);
        if(SerialForbidden||(!SerialAvailable)) {
        	SetRTCButton.setEnabled(false);
        }

        SettingsPageTabbedPane.addTab("Allgemeine Einstellungen",GeneralSettings);
        SettingsPageTabbedPane.addTab("Graphenbereich",GraphSettings);
        SettingsPageTabbedPane.addTab("Tastenkombinationen",KeyCombinationSettings);
        SettingsPageTabbedPane.addTab("Gerät", DeviceSettings);
        JPanel soon=new JPanel();
        JLabel sonn=new JLabel("KOMMT BALD (1-2 Tage/22-24.11.2017). Backend ist schon fertig");
        soon.add(sonn);
        //TODO SettingsPageTabbedPane.addTab("Gerät", soon);
        settingsWindow.add(SettingsPageTabbedPane);
        settingsWindow.setResizable(false);
    }

    /*
     * auskopplung von der obigen methode
     * initialisiert den tab "Graphenbereich"
     */
    void setupGraphSettings(){
        GraphSettings.removeAll();
        visibilitySettings=new JPanel();
        visibilitySettings.setLayout(new BoxLayout(visibilitySettings,BoxLayout.Y_AXIS));
        visibilitySettings.add(new JLabel("Graphensichtbarkeit"));
        visibilitySettings.add(new JLabel(" "));
        selectVisibleGraphsPanel=new JPanel();
        selectVisibleGraphsPanel.setLayout(new BoxLayout(selectVisibleGraphsPanel,BoxLayout.Y_AXIS));
        selectGraphVisibilityCheckBox=new JCheckBox[numberOfGraphs];
        for(int i=0;i<numberOfGraphs;i++){
            selectGraphVisibilityCheckBox[i]=new JCheckBox(dataValueDescriptors[i]);
            selectGraphVisibilityCheckBox[i].setSelected(graphIsVisible[i]);
            selectGraphVisibilityCheckBox[i].addActionListener(this);
            selectVisibleGraphsPanel.add(selectGraphVisibilityCheckBox[i]);
        }
        selectVisibleGraphsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        selectVisibleGraphsScrollPane=new JScrollPane(selectVisibleGraphsPanel);
        selectVisibleGraphsScrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        visibilitySettings.add(selectVisibleGraphsScrollPane);
        GraphSettings.setLayout(new BoxLayout(GraphSettings,BoxLayout.X_AXIS));
        GraphSettings.add(visibilitySettings);

        GeneralInterpolationSettings=new JPanel();
        GeneralInterpolationSettings.setLayout(new BoxLayout(GeneralInterpolationSettings,BoxLayout.Y_AXIS));
        interpolationSettingsBasePanel=new JPanel();
        interpolationSettingsBasePanel.setLayout(new BoxLayout(interpolationSettingsBasePanel,BoxLayout.Y_AXIS));
        interpolationSettings=new JPanel();
        interpolationSettings.setLayout(new BoxLayout(interpolationSettings, BoxLayout.Y_AXIS));
        JLabel title=new JLabel("Interpolation");
        interpolationSettings.add(title);
        interpolationSettings.add(new JLabel(" "));
        interpolateButtonGroup=new ButtonGroup();
        interpolate1x=new JRadioButton("Alle Werte zeichnen");
        interpolate4x=new JRadioButton("jeden 4. Wert zeichnen");
        interpolate10x=new JRadioButton("jeden 10. Wert zeichnen");
        interpolate100x=new JRadioButton("jeden 100. Wert zeichnen");
        interpolate1000x=new JRadioButton("jeden 1000. Wert zeichnen");
        interpolateCustomPanel=new JPanel();
        interpolateCustomPanel.setLayout(new BoxLayout(interpolateCustomPanel,BoxLayout.X_AXIS));
        interpolateCustom=new JRadioButton("Benutzerdefiniert");
        interpolateCustomInputBox=new JTextField();
        interpolateCustomInputBox.addFocusListener(this);
        interpolateCustomInputBox.setMinimumSize(new Dimension(60,23));
        interpolateCustomInputBox.setMaximumSize(new Dimension(60,23));
        interpolateCustomInputBox.getDocument().addDocumentListener(new DocumentListener(){

                @Override
                public void changedUpdate(DocumentEvent arg0) {}

                @Override
                public void insertUpdate(DocumentEvent arg0) {interpolateCustom.setSelected(true);}

                @Override
                public void removeUpdate(DocumentEvent arg0) {interpolateCustom.setSelected(true);}

            });

        interpolateCustomPanel.add(new JLabel("jeden "));
        interpolateCustomPanel.add(interpolateCustomInputBox);
        interpolateCustomPanel.add(new JLabel(". Wert zeichnen"));
        interpolateButtonGroup.add(interpolate1x);
        interpolateButtonGroup.add(interpolate4x);
        interpolateButtonGroup.add(interpolate10x);
        interpolateButtonGroup.add(interpolate100x);
        interpolateButtonGroup.add(interpolate1000x);
        interpolateButtonGroup.add(interpolateCustom);
        interpolationSettings.add(interpolate1x);
        interpolationSettings.add(interpolate4x);
        interpolationSettings.add(interpolate10x);
        interpolationSettings.add(interpolate100x);
        interpolationSettings.add(interpolate1000x);
        interpolationSettings.add(interpolateCustom);
        if(!isCustomInterpolated){
            if(interpolationFactor==1){
                interpolate1x.setSelected(true);
            }
            else if(interpolationFactor==4){
                interpolate4x.setSelected(true);
            }
            else if(interpolationFactor==10){
                interpolate10x.setSelected(true);
            }
            else if(interpolationFactor==100){
                interpolate100x.setSelected(true);
            }
            else if(interpolationFactor==1000){
                interpolate1000x.setSelected(true);
            }
            else{
                interpolateCustom.setSelected(true);
                interpolateCustomInputBox.setText(String.valueOf(interpolationFactor));
                isCustomInterpolated=true;
                saveConfigurationFile();
            }
        }
        else{
            interpolateCustom.setSelected(true);
            interpolateCustomInputBox.setText(String.valueOf(interpolationFactor));
        }
        //interpolationSettings.add(interpolateCustomPanel);
        interpolationSettings.setAlignmentX(Component.RIGHT_ALIGNMENT);
        interpolateCustomPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        interpolationSettingsBasePanel.setLayout(new BoxLayout(interpolationSettingsBasePanel,BoxLayout.Y_AXIS));
        interpolationSettingsBasePanel.setMaximumSize(new Dimension(200,480));
        interpolationSettingsBasePanel.add(interpolationSettings,BorderLayout.NORTH);
        interpolationSettingsBasePanel.add(interpolateCustomPanel,BorderLayout.CENTER);
        interpolateOffsetPanel=new JPanel();
        interpolateOffsetPanel.setLayout(new BoxLayout(interpolateOffsetPanel,BoxLayout.Y_AXIS));
        interpolateOffsetPanel.add(new JLabel(" "));
        interpolateOffsetPanel.add(new JLabel(" "));
        JLabel x=new JLabel("Startwert:                                      ");/*                                       */
        x.setAlignmentX(Component.RIGHT_ALIGNMENT);
        interpolateOffsetPanel.add(x);
        interpolateOffsetPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        interpolateOffsetPanel.setMinimumSize(new Dimension(200,100));
        interpolateOffsetValuePanel=new JPanel();
        interpolateOffsetValuePanel.setLayout(new BoxLayout(interpolateOffsetValuePanel,BoxLayout.X_AXIS));
        interpolateOffsetValuePanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        interpolationOffsetValueBox=new JTextField();
        interpolationOffsetValueBox.setMinimumSize(new Dimension(60,23));
        interpolationOffsetValueBox.setPreferredSize(new Dimension(60,23));
        interpolationOffsetValueBox.setMaximumSize(new Dimension(60,23));
        interpolationOffsetValueBox.setText(String.valueOf(interpolationOffset)+1);
        interpolateOffsetValuePanel.add(interpolationOffsetValueBox);
        interpolateOffsetValuePanel.add(new JLabel(". Wert                         "));
        interpolateOffsetPanel.add(interpolateOffsetValuePanel);
        //interpolateOffsetPanel.setBackground(Color.YELLOW);
        interpolateOffsetPanel.add(new JLabel(" "));
        interpolateOffsetPanel.add(new JLabel(" "));
        interpolateOffsetPanel.add(new JLabel(" "));
        interpolateOffsetPanel.add(new JLabel(" "));
        interpolateOffsetPanel.add(new JLabel(" "));
        interpolateOffsetPanel.add(new JLabel(" "));
        interpolateOffsetPanel.add(new JLabel(" "));
        changeInterpolationSettings=new JButton("OK (nur Interpolation)");
        changeInterpolationSettings.setAlignmentX(Component.RIGHT_ALIGNMENT);
        changeInterpolationSettings.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        changeInterpolationSettings.addActionListener(this);
        interpolateOffsetPanel.add(changeInterpolationSettings);

        interpolationSettingsBasePanel.add(interpolateOffsetPanel,BorderLayout.SOUTH);

        GeneralInterpolationSettings.add(interpolationSettingsBasePanel);

        GraphSettings.add(GeneralInterpolationSettings);
    }

    /*
     * das Fenster, das bei F1 oder "hilfe" erschenint wird hier vorbereitet
     */
    private void setupHelpWindow(){
        //Setup the HeplpWindow
        helpWindowScrollPane=new JScrollPane();
        helpWindow.setSize(800,480);
        helpWindow.setLocationRelativeTo(null);
        helpWindow.setTitle("Hilfe");
        helpPanel=new JPanel();
        helpPanel.setLayout(new BoxLayout(helpPanel,BoxLayout.Y_AXIS));

        helpWindowScrollPane.setViewportView(helpPanel);
        helpWindowScrollPane.setPreferredSize(new Dimension(helpWindow.getWidth(), helpWindow.getHeight()-53));
        helpWindow.add(helpWindowScrollPane,BorderLayout.NORTH);

        helpWindowCloseButton=new JButton("Schließen");
        helpWindowCloseButton.addActionListener(this);
        helpWindowCloseButton.setPreferredSize(new Dimension(helpWindow.getWidth(),25));
        helpWindow.add(helpWindowCloseButton,BorderLayout.SOUTH);

        helpWindow.setResizable(false);

        helpWindowText=new JLabel[NUMBER_OF_KEY_COMBOS];
    }

    private JMenuBar createMainWindowMenuBar() {
        //Initialise and fill the MenuBar on the MainWindow
        mainWindowMenuBar=new JMenuBar();

        fileMenu=new JMenu("Datei");
        openDifferentPlotMenuItem=new JMenuItem("Datei öffnen (Strg+"+OPEN_NEW_PLOT_KEY_STRING+")");
        openDifferentPlotMenuItem.addActionListener(this);
        fileMenu.add(openDifferentPlotMenuItem);
        openNewWindowMenuItem=new JMenuItem("neues Fenster öffnen (Strg+"+OPEN_NEW_WINDOW_KEY_STRING+")");
        openNewWindowMenuItem.addActionListener(this);
        fileMenu.add(openNewWindowMenuItem);
        closeWindowMenuItem=new JMenuItem("Fenster schließen (Strg+"+CLOSE_WINDOW_KEY_STRING+")");
        closeWindowMenuItem.addActionListener(this);
        fileMenu.add(closeWindowMenuItem);

        mainWindowMenuBar.add(fileMenu);

        openSettingsWindowMenu=new JMenu("Einstellungen (Strg+"+OPEN_SETTINGS_WINDOW_KEY_STRING+")");
        openSettingsWindowMenu.addMouseListener(this);
        mainWindowMenuBar.add(openSettingsWindowMenu);

        toggleFullscreenModeMenu=new JMenu("Vollbildmodus ("+TOGGLE_FULLSCREEN_MODE_KEY_STRING+")");
        toggleFullscreenModeMenu.addMouseListener(this);
        mainWindowMenuBar.add(toggleFullscreenModeMenu);

        openHelpWindowMenu=new JMenu("Hilfe ("+OPEN_HELP_WINDOW_KEY_STRING+")");
        openHelpWindowMenu.addMouseListener(this);
        mainWindowMenuBar.add(openHelpWindowMenu);

        saveGraphImagesMenu=new JMenu("Graphen speichern (Strg+"+SAVE_GRAPH_IMAGE_KEY_STRING+")");
        saveGraphImagesMenu.addMouseListener(this);
        mainWindowMenuBar.add(saveGraphImagesMenu);

        toggleDataPanelMenu=new JMenu("Detailansicht (Strg+E)");
        toggleDataPanelMenu.addMouseListener(this);
        mainWindowMenuBar.add(toggleDataPanelMenu);

        mainWindowMenuBar.addKeyListener(this);
        return mainWindowMenuBar;
    }

    public void loadConfigurationFile(){//read in the RaumklimaConfig.txt file, which holds the configuration
        configRaw=new String[NUMBER_OF_CONFIG_ENTRIES];
        try {
            br = new BufferedReader(new FileReader(configFile));
            for(int i=0;i<NUMBER_OF_CONFIG_ENTRIES;i++){
                configRaw[i]=br.readLine();

                logln("CFG: "+configRaw[i]);
            }
            //logln(configRaw[9]);
            //CLOSE_WINDOW_KEY_CODE=Integer.parseInt(new String(configRaw[9].trim().getBytes("UTF-8"),"UTF-8"));
            CLOSE_WINDOW_KEY_CODE=Integer.parseInt(configRaw[8]);
            CLOSE_WINDOW_KEY_STRING=configRaw[9];
            OPEN_HELP_WINDOW_KEY_CODE=Integer.parseInt(configRaw[14].trim());
            OPEN_HELP_WINDOW_KEY_STRING=configRaw[15];
            OPEN_NEW_PLOT_KEY_CODE=Integer.parseInt(configRaw[20].trim());
            OPEN_NEW_PLOT_KEY_STRING=configRaw[21];
            OPEN_NEW_WINDOW_KEY_CODE=Integer.parseInt(configRaw[26].trim());
            OPEN_NEW_WINDOW_KEY_STRING=configRaw[27];
            OPEN_SETTINGS_WINDOW_KEY_CODE=Integer.parseInt(configRaw[32].trim());
            OPEN_SETTINGS_WINDOW_KEY_STRING=configRaw[33];
            REFRESH_FRAME_KEY_CODE=Integer.parseInt(configRaw[38].trim());
            REFRESH_FRAME_KEY_STRING=configRaw[39];
            SAVE_GRAPH_IMAGE_KEY_CODE=Integer.parseInt(configRaw[44].trim());
            SAVE_GRAPH_IMAGE_KEY_STRING=configRaw[45];
            TOGGLE_BOTTOM_PANEL_VISIBILITY_KEY_CODE=Integer.parseInt(configRaw[50].trim());
            TOGGLE_BOTTOM_PANEL_VISIBILITY_KEY_STRING=configRaw[51];
            TOGGLE_FULLSCREEN_MODE_KEY_CODE=Integer.parseInt(configRaw[56].trim());
            TOGGLE_FULLSCREEN_MODE_KEY_STRING=configRaw[57];

            CLOSE_WINDOW_ALT_REQUIRED=configRaw[10].equals("YES");
            CLOSE_WINDOW_CTRL_REQUIRED=configRaw[11].equals("YES");
            CLOSE_WINDOW_SHIFT_REQUIRED=configRaw[12].equals("YES");

            OPEN_HELP_WINDOW_ALT_REQUIRED=configRaw[16].equals("YES");
            OPEN_HELP_WINDOW_CTRL_REQUIRED=configRaw[17].equals("YES");
            OPEN_HELP_WINDOW_SHIFT_REQUIRED=configRaw[18].equals("YES");

            OPEN_NEW_PLOT_ALT_REQUIRED=configRaw[22].equals("YES");
            OPEN_NEW_PLOT_CTRL_REQUIRED=configRaw[23].equals("YES");
            OPEN_NEW_PLOT_SHIFT_REQUIRED=configRaw[24].equals("YES");

            OPEN_NEW_WINDOW_ALT_REQUIRED=configRaw[28].equals("YES");
            OPEN_NEW_WINDOW_CTRL_REQUIRED=configRaw[29].equals("YES");
            OPEN_NEW_WINDOW_SHIFT_REQUIRED=configRaw[30].equals("YES");

            OPEN_SETTINGS_WINDOW_ALT_REQUIRED=configRaw[34].equals("YES");
            OPEN_SETTINGS_WINDOW_CTRL_REQUIRED=configRaw[35].equals("YES");
            OPEN_SETTINGS_WINDOW_SHIFT_REQUIRED=configRaw[36].equals("YES");

            REFRESH_FRAME_ALT_REQUIRED=configRaw[40].equals("YES");
            REFRESH_FRAME_CTRL_REQUIRED=configRaw[41].equals("YES");
            REFRESH_FRAME_SHIFT_REQUIRED=configRaw[42].equals("YES");

            SAVE_GRAPH_IMAGE_ALT_REQUIRED=configRaw[46].equals("YES");
            SAVE_GRAPH_IMAGE_CTRL_REQUIRED=configRaw[47].equals("YES");
            SAVE_GRAPH_IMAGE_SHIFT_REQUIRED=configRaw[48].equals("YES");

            TOGGLE_BOTTOM_PANEL_VISIBILITY_ALT_REQUIRED=configRaw[52].equals("YES");
            TOGGLE_BOTTOM_PANEL_VISIBILITY_CTRL_REQUIRED=configRaw[53].equals("YES");
            TOGGLE_BOTTOM_PANEL_VISIBILITY_SHIFT_REQUIRED=configRaw[54].equals("YES");

            TOGGLE_FULLSCREEN_MODE_ALT_REQUIRED=configRaw[58].equals("YES");
            TOGGLE_FULLSCREEN_MODE_CTRL_REQUIRED=configRaw[59].equals("YES");
            TOGGLE_FULLSCREEN_MODE_SHIFT_REQUIRED=configRaw[60].equals("YES");

            savePng=configRaw[64].equals("YES");
            saveJpeg=configRaw[66].equals("YES");
            imageWidth=Integer.parseInt(configRaw[68].trim());
            imageHeight=Integer.parseInt(configRaw[70].trim());
            getImageSizeAutomatically=configRaw[72].equals("YES");
            fullscreenOnStartup=configRaw[76].equals("YES");
            fullscreenOk=configRaw[78].equals("YES");
            bottomPanelExpandedOnStartup=configRaw[80].equals("YES");
            autoUpdate=configRaw[82].equals("YES");
            interpolationFactor=Integer.parseInt(configRaw[84].trim());
            isCustomInterpolated=configRaw[86].equals("YES");
            interpolationOffset=Integer.parseInt(configRaw[88].trim());
            geoMode=configRaw[90].equals("YES");
            if(getImageSizeAutomatically){
                imageHeight=fullscreenDimension.height;
                imageWidth=fullscreenDimension.width;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Writes the Configuration (which is saved in a {@link String} Array in Memory) to a {@link File} on the local Storage
     */
    private void saveConfigurationFile(){

        logln("updating config");
        configRaw[8]=String.valueOf(CLOSE_WINDOW_KEY_CODE);
        configRaw[9]=CLOSE_WINDOW_KEY_STRING;
        configRaw[14]=String.valueOf(OPEN_HELP_WINDOW_KEY_CODE);
        configRaw[15]=OPEN_HELP_WINDOW_KEY_STRING;
        configRaw[20]=String.valueOf(OPEN_NEW_PLOT_KEY_CODE);
        configRaw[21]=OPEN_NEW_PLOT_KEY_STRING;
        configRaw[26]=String.valueOf(OPEN_NEW_WINDOW_KEY_CODE);
        configRaw[27]=OPEN_NEW_WINDOW_KEY_STRING;
        configRaw[32]=String.valueOf(OPEN_SETTINGS_WINDOW_KEY_CODE);
        configRaw[33]=OPEN_SETTINGS_WINDOW_KEY_STRING;
        configRaw[38]=String.valueOf(REFRESH_FRAME_KEY_CODE);
        configRaw[39]=REFRESH_FRAME_KEY_STRING;
        configRaw[44]=String.valueOf(SAVE_GRAPH_IMAGE_KEY_CODE);
        configRaw[45]=SAVE_GRAPH_IMAGE_KEY_STRING;
        configRaw[50]=String.valueOf(TOGGLE_BOTTOM_PANEL_VISIBILITY_KEY_CODE);
        configRaw[51]=TOGGLE_BOTTOM_PANEL_VISIBILITY_KEY_STRING;
        configRaw[56]=String.valueOf(TOGGLE_FULLSCREEN_MODE_KEY_CODE);
        configRaw[57]=TOGGLE_FULLSCREEN_MODE_KEY_STRING;

        configRaw[10]=getYesNoString(CLOSE_WINDOW_ALT_REQUIRED);
        configRaw[11]=getYesNoString(CLOSE_WINDOW_CTRL_REQUIRED);
        configRaw[12]=getYesNoString(CLOSE_WINDOW_SHIFT_REQUIRED);

        configRaw[16]=getYesNoString(OPEN_HELP_WINDOW_ALT_REQUIRED);
        configRaw[17]=getYesNoString(OPEN_HELP_WINDOW_CTRL_REQUIRED);
        configRaw[18]=getYesNoString(OPEN_HELP_WINDOW_SHIFT_REQUIRED);

        configRaw[22]=getYesNoString(OPEN_NEW_PLOT_ALT_REQUIRED);
        configRaw[23]=getYesNoString(OPEN_NEW_PLOT_CTRL_REQUIRED);
        configRaw[24]=getYesNoString(OPEN_NEW_PLOT_SHIFT_REQUIRED);

        configRaw[28]=getYesNoString(OPEN_NEW_WINDOW_ALT_REQUIRED);
        configRaw[29]=getYesNoString(OPEN_NEW_WINDOW_CTRL_REQUIRED);
        configRaw[30]=getYesNoString(OPEN_NEW_WINDOW_SHIFT_REQUIRED);

        configRaw[34]=getYesNoString(OPEN_SETTINGS_WINDOW_ALT_REQUIRED);
        configRaw[35]=getYesNoString(OPEN_SETTINGS_WINDOW_CTRL_REQUIRED);
        configRaw[36]=getYesNoString(OPEN_SETTINGS_WINDOW_SHIFT_REQUIRED);

        configRaw[40]=getYesNoString(REFRESH_FRAME_ALT_REQUIRED);
        configRaw[41]=getYesNoString(REFRESH_FRAME_CTRL_REQUIRED);
        configRaw[42]=getYesNoString(REFRESH_FRAME_SHIFT_REQUIRED);

        configRaw[46]=getYesNoString(SAVE_GRAPH_IMAGE_ALT_REQUIRED);
        configRaw[47]=getYesNoString(SAVE_GRAPH_IMAGE_CTRL_REQUIRED);
        configRaw[48]=getYesNoString(SAVE_GRAPH_IMAGE_SHIFT_REQUIRED);

        configRaw[52]=getYesNoString(TOGGLE_BOTTOM_PANEL_VISIBILITY_ALT_REQUIRED);
        configRaw[53]=getYesNoString(TOGGLE_BOTTOM_PANEL_VISIBILITY_CTRL_REQUIRED);
        configRaw[54]=getYesNoString(TOGGLE_BOTTOM_PANEL_VISIBILITY_SHIFT_REQUIRED);

        configRaw[58]=getYesNoString(TOGGLE_FULLSCREEN_MODE_ALT_REQUIRED);
        configRaw[59]=getYesNoString(TOGGLE_FULLSCREEN_MODE_CTRL_REQUIRED);
        configRaw[60]=getYesNoString(TOGGLE_FULLSCREEN_MODE_SHIFT_REQUIRED);

        configRaw[64]=getYesNoString(savePng);
        configRaw[66]=getYesNoString(saveJpeg);
        configRaw[68]=String.valueOf(imageWidth);
        configRaw[70]=String.valueOf(imageHeight);
        configRaw[72]=getYesNoString(getImageSizeAutomatically);
        configRaw[76]=getYesNoString(fullscreenOnStartup);
        configRaw[78]=getYesNoString(fullscreenOk);
        configRaw[80]=getYesNoString(bottomPanelExpandedOnStartup);
        configRaw[82]=getYesNoString(autoUpdate);
        configRaw[84]=String.valueOf(interpolationFactor);
        configRaw[86]=getYesNoString(isCustomInterpolated);
        configRaw[88]=String.valueOf(interpolationOffset);
        configRaw[90]=getYesNoString(geoMode);

        logln("writing Config");
        try {
            configFile=new File("RaumklimaConfig.txt");
            configFile.delete();
            configFile.createNewFile();
            bw = new BufferedWriter(new FileWriter(configFile));
            for(int i=0;i<NUMBER_OF_CONFIG_ENTRIES;i++){
                bw.write(configRaw[i]);
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks whether an Update is available
     * @return true if an update is available, false if no update is available
     */
    public boolean checkIfUpdateAvailable(){
        try{
            source = new URL(projectUri+branch+"/PublicVersion/VERSION");

            logln(projectUri+branch+"/PublicVersion/VERSION");
            br=new  BufferedReader(new InputStreamReader(source.openStream()));
            String RemoteVersion=br.readLine().trim();
            //in String.split muss ein '.' escaped werden
            //http://www.java-examples.com/java-string-split-example
            //06.09.2017 3:46 Uhr
            //(codezeilen 31-41 im beispiel auf der website)
            String[] remote=RemoteVersion.split("\\.");
            String[] local=VERSION.split("\\.");
            for(int i=0;i<4;i++){

                logln(local[i]+" | "+remote[i]);
                if(Integer.parseInt(remote[i])>Integer.parseInt(local[i])){
                    return true;
                }
            }
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * After the Programm has checked whether an update from github is available it performs this update
     */
    public void updateJar(){
        try{
            //quelle wie oben bei der config datei
            oldFile=new File("Raumklima.jar");
            oldFile.delete();
            //fileUrl: "https://raw.githubusercontent.com/lukasaldersley/Raumklima/master/PublicVersion/VERSION"
            source = new URL(downloadTargetUri+branch+"/PublicVersion/Raumklima.jar");
            readableByteChannelFromSource = Channels.newChannel(source.openStream());
            fileOutputStream = new FileOutputStream("Raumklima.jar");
            fileOutputStream.getChannel().transferFrom(readableByteChannelFromSource, 0, Long.MAX_VALUE);
            fileOutputStream.close();
            Runtime.getRuntime().exec("java -jar Raumklima.jar");
            System.exit(0);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /*
     * gibt "YES" zurüch falls eingabe true, sonst gibt die methode "NO" zurück
     * 
     * hab ich geschrieben weil in der saveConfigFile es sonst viel zu unübersichtlich geworden währe
     */
    private String getYesNoString(boolean in){
        if(in){
            return "YES";
        }
        return "NO";
    }

    /*
     * liest textdateien in denen die tastenkombis, die betriebsanweisung und ähnliches stehen
     */
    private void loadTextForHelpWindowAndKeyCombinations() {
        try{
            String line="";
            for(int i=0;i<NUMBER_OF_KEY_COMBOS;i++){
                helpWindowText[i]=new JLabel();
                helpWindowText[i].setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
                helpPanel.add(helpWindowText[i]);
            }
            br=new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("CopyrightNotes.txt"),"UTF-8"));//https://stackoverflow.com/questions/12920039/encoding-in-exported-jar antwort von davmac 
            try{
                copyrightNotes=new JLabel[NUMBER_OF_COPYRIGHT_NOTES+3];
                copyrightNotes[0]=new JLabel(" ");
                helpPanel.add(copyrightNotes[0]);
                copyrightNotes[1]=new JLabel(" ");
                helpPanel.add(copyrightNotes[1]);
                copyrightNotes[2]=new JLabel("Version: "+VERSION);
                helpPanel.add(copyrightNotes[2]);
                for(int i=3;i<NUMBER_OF_COPYRIGHT_NOTES+3;i++){
                    line=br.readLine();
                    copyrightNotes[i]=new JLabel(line);
                    if(line==null){
                        break;
                    }
                    logln(line);
                    helpPanel.add(copyrightNotes[i]);
                }
            }
            catch(Exception e){
                e.printStackTrace();
                JLabel error=new JLabel("Ein Fehler ist aufgetreten und diese Seite konnte nicht geladen werden. Bitte laden Sie das Programm neu.");
                helpPanel.add(error);
            }
            if(CLOSE_WINDOW_ALT_REQUIRED){
                helpWindowText[0].setText(helpWindowText[0].getText()+"Alt+");
            }
            if(CLOSE_WINDOW_CTRL_REQUIRED){
                helpWindowText[0].setText(helpWindowText[0].getText()+"Strg+");
            }
            if(CLOSE_WINDOW_SHIFT_REQUIRED){
                helpWindowText[0].setText(helpWindowText[0].getText()+"Shift+");
            }
            if(OPEN_HELP_WINDOW_ALT_REQUIRED){
                helpWindowText[1].setText(helpWindowText[1].getText()+"Alt+");
            }
            if(OPEN_HELP_WINDOW_CTRL_REQUIRED){
                helpWindowText[1].setText(helpWindowText[1].getText()+"Strg+");
            }
            if(OPEN_HELP_WINDOW_SHIFT_REQUIRED){
                helpWindowText[1].setText(helpWindowText[1].getText()+"Shift+");
            }
            if(OPEN_NEW_PLOT_ALT_REQUIRED){
                helpWindowText[2].setText(helpWindowText[2].getText()+"Alt+");
            }
            if(OPEN_NEW_PLOT_CTRL_REQUIRED){
                helpWindowText[2].setText(helpWindowText[2].getText()+"Strg+");
            }
            if(OPEN_NEW_PLOT_SHIFT_REQUIRED){
                helpWindowText[2].setText(helpWindowText[2].getText()+"Shift+");
            }
            if(OPEN_NEW_WINDOW_ALT_REQUIRED){
                helpWindowText[3].setText(helpWindowText[3].getText()+"Alt+");
            }
            if(OPEN_NEW_WINDOW_CTRL_REQUIRED){
                helpWindowText[3].setText(helpWindowText[3].getText()+"Strg+");
            }
            if(OPEN_NEW_WINDOW_SHIFT_REQUIRED){
                helpWindowText[3].setText(helpWindowText[3].getText()+"Shift+");
            }
            if(OPEN_SETTINGS_WINDOW_ALT_REQUIRED){
                helpWindowText[4].setText(helpWindowText[4].getText()+"Alt+");
            }
            if(OPEN_SETTINGS_WINDOW_CTRL_REQUIRED){
                helpWindowText[4].setText(helpWindowText[4].getText()+"Strg+");
            }
            if(OPEN_SETTINGS_WINDOW_SHIFT_REQUIRED){
                helpWindowText[4].setText(helpWindowText[4].getText()+"Shift+");
            }
            if(REFRESH_FRAME_ALT_REQUIRED){
                helpWindowText[5].setText(helpWindowText[5].getText()+"Alt+");
            }
            if(REFRESH_FRAME_CTRL_REQUIRED){
                helpWindowText[5].setText(helpWindowText[5].getText()+"Strg+");
            }
            if(REFRESH_FRAME_SHIFT_REQUIRED){
                helpWindowText[5].setText(helpWindowText[5].getText()+"Shift+");
            }
            if(SAVE_GRAPH_IMAGE_ALT_REQUIRED){
                helpWindowText[6].setText(helpWindowText[6].getText()+"Alt+");
            }
            if(SAVE_GRAPH_IMAGE_CTRL_REQUIRED){
                helpWindowText[6].setText(helpWindowText[6].getText()+"Strg+");
            }
            if(SAVE_GRAPH_IMAGE_SHIFT_REQUIRED){
                helpWindowText[6].setText(helpWindowText[6].getText()+"Shift+");
            }
            if(TOGGLE_BOTTOM_PANEL_VISIBILITY_ALT_REQUIRED){
                helpWindowText[7].setText(helpWindowText[7].getText()+"Alt+");
            }
            if(TOGGLE_BOTTOM_PANEL_VISIBILITY_CTRL_REQUIRED){
                helpWindowText[7].setText(helpWindowText[7].getText()+"Strg+");
            }
            if(TOGGLE_BOTTOM_PANEL_VISIBILITY_SHIFT_REQUIRED){
                helpWindowText[7].setText(helpWindowText[7].getText()+"Shift+");
            }
            if(TOGGLE_FULLSCREEN_MODE_ALT_REQUIRED){
                helpWindowText[8].setText(helpWindowText[8].getText()+"Alt+");
            }
            if(TOGGLE_FULLSCREEN_MODE_CTRL_REQUIRED){
                helpWindowText[8].setText(helpWindowText[8].getText()+"Strg+");
            }
            if(TOGGLE_FULLSCREEN_MODE_SHIFT_REQUIRED){
                helpWindowText[8].setText(helpWindowText[8].getText()+"Shift+");
            }
            helpWindowText[0].setText(helpWindowText[0].getText()+CLOSE_WINDOW_KEY_STRING);
            helpWindowText[1].setText(helpWindowText[1].getText()+OPEN_HELP_WINDOW_KEY_STRING);
            helpWindowText[2].setText(helpWindowText[2].getText()+OPEN_NEW_PLOT_KEY_STRING);
            helpWindowText[3].setText(helpWindowText[3].getText()+OPEN_NEW_WINDOW_KEY_STRING);
            helpWindowText[4].setText(helpWindowText[4].getText()+OPEN_SETTINGS_WINDOW_KEY_STRING);
            helpWindowText[5].setText(helpWindowText[5].getText()+REFRESH_FRAME_KEY_STRING);
            helpWindowText[6].setText(helpWindowText[6].getText()+SAVE_GRAPH_IMAGE_KEY_STRING);
            helpWindowText[7].setText(helpWindowText[7].getText()+TOGGLE_BOTTOM_PANEL_VISIBILITY_KEY_STRING);
            helpWindowText[8].setText(helpWindowText[8].getText()+TOGGLE_FULLSCREEN_MODE_KEY_STRING);

            closeWindowMenuItem.setText("Fenster schließen ("+helpWindowText[0].getText()+")");
            openHelpWindowMenu.setText("Hilfe ("+helpWindowText[1].getText()+")");
            openDifferentPlotMenuItem.setText("Datei öffnen ("+helpWindowText[2].getText()+")");
            openNewWindowMenuItem.setText("neues Fenster öffnen ("+helpWindowText[3].getText()+")");
            openSettingsWindowMenu.setText("Einstellungen ("+helpWindowText[4].getText()+")");
            saveGraphImagesMenu.setText("Graphen speichern ("+helpWindowText[6].getText()+")");
            toggleDataPanelMenu.setText("Detailansicht ("+helpWindowText[7].getText()+")");
            toggleFullscreenModeMenu.setText("Vollbildmodus ("+helpWindowText[8].getText()+")");

            br=new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("HelpTexts.txt"),"UTF-8"));//https://stackoverflow.com/questions/12920039/encoding-in-exported-jar antwort von davmac 
            for(int i=0;i<NUMBER_OF_KEY_COMBOS;i++){
                line=br.readLine();
                setNewKeyCombinationTexts[i]=line;
                line +=": ";
                helpWindowText[i].setText(line+helpWindowText[i].getText());
                for(int j=helpWindowText[i].getText().length();j<60;j++){
                    helpWindowText[i].setText(helpWindowText[i].getText()+" ");
                }
            }
            for(int i=0;i<NUMBER_OF_KEY_COMBOS;i++){
                //die Gleichen elmente für die Einstellungsseite Verwenden
                settingsWindowText[i].setText(helpWindowText[i].getText());
            }
        }
        catch(Exception e){
            e.printStackTrace();
            JLabel error=new JLabel("Ein Fehler ist aufgetreten und diese Seite konnte nicht geladen werden. Bitte starten Sie das Programm neu.");
            helpPanel.add(error);
        }
    }

    /*
     * floor und roof sind die mathematischen funktionen ceil und floor
     * sind nur für die übersicht in den methoden in denen diese gebraucht werden (zum berechnen der breiten und höhen des detailbereichs
     */
    private int floor(double in){
        return (int)in;
    }

    private int roof(double in){
        if( ((int)(in))-in==0.00){
            return (int)in;
        }
        else{
            return (int)in+1;
        }
    }

    /*
     * selbsterklärend.
     * schaltet zwischen vollbild und nicht-vollbild um
     */
    private void toggleFullscreen(){
        //Set a Different Cursor to indicate The program is working
        try{
            mainWindow.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        }
        catch(Exception e){
            e.printStackTrace();
        }

        if(fullscreen){//if fullscreenMode is already enabled, disable it
            deactivateFullscreen();
        }
        else{//the fullscreenMode is disabled, so enable it
            avtivateFullscreen();
        }
        mainWindow.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    /*
     * lädt die größenverhältnisse der abteile im programm neu
     */
    private void refreshPage(){
        logln(mainWindow.getSize());
        width=mainWindow.getWidth()-15;
        if(fullscreen&&fullscreenOk){
            height=mainWindow.getHeight()-(23+8);
        }
        else{
            height=mainWindow.getHeight()-(53+8);
            windowDimension=new Dimension(width,height);
        }

        logln(windowDimension);
        dataPanelX=floor((double)(windowDimension.getWidth()/(double)(WIDTH_OF_DATA_BLOCK)));
        dataPanelY=roof(numberOfGraphs/(double)(dataPanelX));
        dataPanel.setLayout(new GridLayout(dataPanelY,dataPanelX));

        logln(numberOfGraphs+" | "+dataPanelX+"x"+dataPanelY);
        bottomPanelDimension=new Dimension(width,dataPanelY*HEIGHT_OF_DATA_BLOCK);
        if(bottomPanelExpanded){
            topPanelDimension=new Dimension(width,height-(dataPanelY*HEIGHT_OF_DATA_BLOCK));
            dataPanel.setVisible(true);
        }
        else{
            topPanelDimension=new Dimension(width,height);
            dataPanel.setVisible(false);
        }
        dataPanel.setPreferredSize(bottomPanelDimension);
        chartPanel.setPreferredSize(topPanelDimension);

        logln(topPanelDimension);
        logln(bottomPanelDimension);
        logln();
        mainWindow.validate();
    }

    /*
     * verlässt den vollbildmodus
     */
    private void deactivateFullscreen(){
        if(fullscreenOk){//GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(new JFrame("HI"));
            graphicsDevice.setFullScreenWindow(null);
        }
        else{
            mainWindow.setExtendedState(JFrame.NORMAL);
        }
        fullscreen=false;
        refreshPage();
        saveConfigurationFile();
    }

    /*
     * statet den vollbildmodus
     */
    private void avtivateFullscreen(){
        if(fullscreenOk){
            graphicsDevice=GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
            graphicsDevice.setFullScreenWindow(mainWindow);
        }
        else{
            mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        fullscreen=true;
        refreshPage();
        saveConfigurationFile();
    }

    /*
     * detailbereich sichtbar/unsichtbar machen
     */
    private void toggleBottomPanel(){
        if(bottomPanelExpanded){
            bottomPanelExpanded=false;
            dataPanel.setVisible(false);
        }
        else{
            bottomPanelExpanded=true;
            dataPanel.setVisible(true);
        }
        refreshPage();
        saveConfigurationFile();
    }

    /*
     * zeigt den dateipicker an
     * 
     * warum ich des damals als eigene methode gemacht hab, weiß ich nicht mehr
     */
    private int showOpenDialog(){
        return fileChooser.showOpenDialog(fileChooserWindow);
    }

    /*
     * lädt die csv datei; ES WIRD NOCH NICHTS EINGELESEN
     */
    private void pickCsvFile(boolean doShowOpenDialog,String fileName) {
        xYSeriesCollection = new XYSeriesCollection();
        if(doShowOpenDialog){
            int returnVal = showOpenDialog();
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                try{
                    csvFile=fileChooser.getSelectedFile();
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
            else{
                jFilePickerFailed=true;
            }
        }
        else{
            csvFile=new File(fileName);
        }
    }

    /*
    * erstellt den graphenbereich
    * 
    * - liest dei datei ein
    * - abhängig vom modus nur zeichnen oder auch durchschnitte
    * - interpolation und offset werden ebenfalls berücksichtigt
    */
    @SuppressWarnings("rawtypes")
    private JFreeChart createDataset(){

        try{
            xYSeriesCollection.removeAllSeries();
            br=new BufferedReader(new FileReader(csvFile));
            String line=br.readLine();
            dataValueDescriptors=line.split(";");
            numberOfGraphs=dataValueDescriptors.length;
            if(geoMode){
                int temps = 0;
                int drops=0;
                numberOfGraphs=2;
                for(int i=0;i<dataValueDescriptors.length;i++){
                    if(dataValueDescriptors[i].substring(0, dataValueDescriptors[i].indexOf('(')).equalsIgnoreCase("Niederschlagsmenge")){
                        drops=i;
                    }
                    if(dataValueDescriptors[i].substring(0, dataValueDescriptors[i].indexOf('(')).equalsIgnoreCase("Temperatur")){
                        temps=i;
                    }
                }
                if(temps==0&&drops==0){
                    geoMode=false;
                    GeoModeButton.setSelected(false);
                    RegularModeButton.setSelected(true);
                    reloadBackend();
                    return createDataset();
                }
                xYSeries=new XYSeries[numberOfGraphs];
                if(!onlyInterpolationChanging){
                    graphIsVisible=new boolean[numberOfGraphs];
                }

                xYSeries[0] = new XYSeries((Comparable)((Object)(dataValueDescriptors[temps].substring(0, dataValueDescriptors[temps].indexOf('(')))));
                xYSeries[1] = new XYSeries((Comparable)((Object)(dataValueDescriptors[drops].substring(0, dataValueDescriptors[drops].indexOf('(')))));
                if(!onlyInterpolationChanging){
                    graphIsVisible[0]=true;
                    graphIsVisible[1]=true;
                }

                if(interpolationFactor<1){
                    interpolationFactor=1;
                }

                line=br.readLine();
                for(int x=0;x<interpolationOffset*4;x++){
                    line=br.readLine();
                }
                counter=0;
                double ns=0.0;
                double te=0.0;
                while(line!=null&&!line.equals("")){
                    if(line==null||line.equals("")){
                        break;
                    }
                    ns=0;
                    te=0;
                    for(int l=0;l<4;l++){
                        line=line.replace("NAN","0,00");
                        line=line.replace(',', '.');
                        String[] zwso=line.split(";");
                        double[] zwsp=new double[2];
                        zwsp[0]=Double.parseDouble(zwso[temps]);
                        zwsp[1]=Double.parseDouble(zwso[drops]);
                        ns+=zwsp[1];
                        te+=zwsp[0];
                        line=br.readLine();
                        if(line==null||line.equals("")){
                            break;
                        }
                    }
                    if(line==null||line.equals("")){
                        break;
                    }
                    te/=4;
                    xYSeries[0].add(counter, te);
                    xYSeries[1].add(counter,ns);
                    counter++;
                    for(int j=0;j<interpolationFactor*4;j++){
                        line=br.readLine();
                    }
                    if(line==null||line.equals("")){
                        break;
                    }
                }

            }
            else{//physik modus
                xYSeries=new XYSeries[numberOfGraphs];
                if(!onlyInterpolationChanging){
                    graphIsVisible=new boolean[numberOfGraphs];
                }

                for (int i = 0; i < numberOfGraphs; ++i) {
                    try{
                        xYSeries[i] = new XYSeries(dataValueDescriptors[i].substring(0, dataValueDescriptors[i].indexOf('(')));
                    }
                    catch(StringIndexOutOfBoundsException e){
                        xYSeries[i]=new XYSeries(dataValueDescriptors[i]);
                    }
                    if(!onlyInterpolationChanging){
                        graphIsVisible[i]=true;
                    }
                }
                if(interpolationFactor<1){
                    interpolationFactor=1;
                }
                //int numberOfLines=numberOfLinesInFile(csvFile);

                line=br.readLine();
                for(int x=0;x<interpolationOffset;x++){
                    line=br.readLine();
                }
                counter=0;
                while(line!=null&&!line.equals("")){
                    if(line==null||line.equals("")){
                        break;
                    }
                    //logln(line);
                    line=line.replace("NAN","0,00");
                    line=line.replace(',', '.');
                    //logln(line);
                    String[] zwso=line.split(";");
                    double[] zwsp=new double[numberOfGraphs];
                    for(int i=0;i<numberOfGraphs;i++){
                        try{
                            zwsp[i]=Double.parseDouble(zwso[i]);
                            xYSeries[i].add(counter,zwsp[i]);
                        }
                        catch(Exception e){
                            e.printStackTrace();

                            logln(i);
                        }
                    }
                    counter++;
                    for(int j=0;j<interpolationFactor;j++){
                        line=br.readLine();
                    }
                    if(line==null||line.equals("")){
                        break;
                    }
                }
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        if(replotting){
            setupGraphSettings();
        }

        if(selectGraphVisibilityCheckBox!=null){
            for (int i = 0; i < numberOfGraphs; ++i) {
                if(selectGraphVisibilityCheckBox[i].isSelected()){
                    xYSeriesCollection.addSeries(xYSeries[i]);
                }
            }
        }
        else{
            for (int i = 0; i < numberOfGraphs; ++i) {
                xYSeriesCollection.addSeries(xYSeries[i]);
            }
        }
        JFreeChart chart;
        if(geoMode){
            chart = ChartFactory.createXYLineChart(null,"Zeit","Werte",xYSeriesCollection);
        }
        else{
            chart = ChartFactory.createXYLineChart(null,"Zeit (etwa "+10*interpolationFactor+" Sekunden zwischen den Messwerten)","Werte",xYSeriesCollection);
        }
        onlyInterpolationChanging=false;
        return chart;
    }

    /*
    * für zukünftige funktionen; wird gegenwärtig nicht verwendet 
    */
    @SuppressWarnings("unused")
    private int numberOfLinesInFile(File inputFile) {
        //https://stackoverflow.com/questions/453018/number-of-lines-in-a-file-in-java
        //antwort von Telmo Marques und er.vikas
        LineNumberReader lnr;
        try {
            lnr = new LineNumberReader(new FileReader(inputFile));
            lnr.skip(Long.MAX_VALUE);
            lnr.close();
            logln("NumberOfLines: "+lnr.getLineNumber()+1);
            return lnr.getLineNumber()+1;
        }
        catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /*
     * schließt das programm ordnungsgemäß
     */
    private void exit(){
        mainWindow.setVisible(false);
        mainWindow.dispose();
        fileChooserWindow.dispose();
        settingsWindow.dispose();
        helpWindow.dispose();
        setNewKeyCombinationWindow.dispose();
        try{//die einzige exception, die passieren k�nnte , ist dass die fileChooser Auswahl abgebrochen wird, die timer unitialisiert sind und das Programm deswegen sbschmieren k�nnte
            SystemTimeFieldTimer.stop();
        }
        catch(NullPointerException e1){
            logln(e1);
        }
        try{
            DeviceTimeFieldTimer.stop();
        }
        catch(NullPointerException e2){
            logln(e2);
        }
    }

    /*
     * wenn irgendwo auf die zeichenebene geklickt wird, wird das hier verarbeitet
     * 
     * die genauen werte an dieser position werden ebenfalls hier ermittelt (für den detailbereich)
     */
    @Override
    public void chartMouseClicked(ChartMouseEvent e) {

        Rectangle2D rectangle2D = chartPanel.getScreenDataArea();
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        ValueAxis valueAxis = xYPlot.getDomainAxis();
        double x = valueAxis.java2DToValue((double)e.getTrigger().getX(), rectangle2D, RectangleEdge.BOTTOM);
        xCrosshair.setValue(x);

        /*int x=e.getTrigger().getX();
        int maxRAW=chartPanel.getWidth();
        double minCAL=chartPanel.getChartRenderingInfo().getPlotInfo().getDataArea().getX();
        double maxCAL=chartPanel.getChartRenderingInfo().getPlotInfo().getDataArea().getWidth();
        x=reMap(0,maxRAW,minCAL,maxCAL,x);
        x=reMap(0,maxCAL,0,counter,x);
        xCrosshair.setValue(x);*/
        int correctedIndex=0;
        for (int i = 0; i < numberOfGraphs; ++i) {
            try {
                if(graphIsVisible[i]){
                    dataBoxes[i].setText(String.valueOf(new DecimalFormat("###.#").format(xYSeries[correctedIndex].getY((int)x).doubleValue())));//https://stackoverflow.com/questions/13210491/math-round-java antwort von arshajii
                    correctedIndex++;
                }
                else{
                    dataBoxes[i].setText("N/A (ausgeblendet)");
                }
            }
            catch(IndexOutOfBoundsException ex) {
                break;//TODO maybe log(ex);
            }
        }
    }

    /*
     * versuchsmethode für chartMouseMoved und -clicked
     */
    public int reMap(double minPre,double maxPre,double minPost,double maxPost,double val){
        double Fact=val/(maxPre-minPre);
        System.out.println(Fact);
        double zws=Fact*(maxPost-minPost);
        zws+=minPost;
        if(zws>maxPost){
            zws=maxPost;
        }
        if(zws<minPost){
            zws=minPost;
        }
        return (int)zws;
    }

    /*
     * wenn die maus über die zeichenebene bewegt wird wird das hier verarbeitet
     */
    @Override
    public void chartMouseMoved(ChartMouseEvent e){
        Rectangle2D rectangle2D = chartPanel.getScreenDataArea();
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        ValueAxis valueAxis = xYPlot.getDomainAxis();
        double x = valueAxis.java2DToValue((double)e.getTrigger().getX(), rectangle2D, RectangleEdge.BOTTOM);
        xCrosshair.setValue(x);

        /*int x=e.getTrigger().getX();
        int maxRAW=chartPanel.getWidth();
        double minCAL=chartPanel.getChartRenderingInfo().getPlotInfo().getDataArea().getX();
        double maxCAL=chartPanel.getChartRenderingInfo().getPlotInfo().getDataArea().getWidth();
        x=reMap(0,maxRAW,minCAL,maxCAL,x);
        x=reMap(minCAL,maxCAL,0,counter,x);
        xCrosshair.setValue(x);*/
        int correctedIndex=0;
        for (int i = 0; i < numberOfGraphs; ++i) {
            try {
                if(graphIsVisible[i]){
                    yCrosshairs[i].setValue(xYSeries[correctedIndex].getY((int)x).doubleValue());
                    correctedIndex++;
                }
            }
            catch(IndexOutOfBoundsException ex) {
                break;
                //TODO Maybe log?
            }
        }
    }

    /*
     * macht das fenster "Hilfe" sichtbar
     */
    private void makeHelpWindowVisible(){
        helpWindow.setSize(helpWindow.getWidth()-10, helpWindow.getHeight());
        helpWindow.setVisible(true);
        helpWindow.setSize(helpWindow.getWidth()+10, helpWindow.getHeight());
        helpWindow.validate();
        if(helpWindow.isVisible()){
            mainWindow.setAlwaysOnTop(false);
        }
        else{
            mainWindow.setAlwaysOnTop(isAlwaysOnTop);
        }
    }

    /*
     * macht das einstellungsfenster sichtbar/unsichtbar
     */
    private void toggleSettingsWindow(){
        settingsWindow.setVisible(!settingsWindow.isVisible());
        if(settingsWindow.isVisible()){
            mainWindow.setAlwaysOnTop(false);
        }
        else{
            mainWindow.setAlwaysOnTop(isAlwaysOnTop);
        }
    }

    /*
     * wenn irgendwas seine größe ändert, alle größen sicherheitshalber neu berechnen
     */
    @Override
    public void componentResized(ComponentEvent event) {
        refreshPage();
    }

    /*
     * falls das fenster maximiert oder sonst irgenwie verändert wird, alle größen sicherheitshalber neu berechnen
     */
    @Override
    public void windowStateChanged(WindowEvent event) {
        refreshPage();
    }

    /*
     * ordnungsgemäß beenden
     */
    @Override
    public void windowClosing(WindowEvent event) {
        exit();
    }

    /*
     * alle ActionListener werden hier verarbeitet
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        logln("EVENT FIRED");
        if(event.getSource()==imageSizeAutoCheckBox){//in den winstellungen bildgröße automatisch festlegen
            if(imageSizeAutoCheckBox.isSelected()){
                imageWidthBox.setText(String.valueOf(fullscreenDimension.width));
                imageWidth=Integer.parseInt(imageWidthBox.getText());
                imageWidthBox.setEnabled(false);
                imageHeightBox.setText(String.valueOf(fullscreenDimension.height));
                imageHeight=Integer.parseInt(imageHeightBox.getText());
                imageHeightBox.setEnabled(false);
                getImageSizeAutomatically=true;
            }
            else{
                imageWidthBox.setEnabled(true);
                imageHeightBox.setEnabled(true);
                getImageSizeAutomatically=false;
            }
        }
        else if(event.getSource()==changeKeyCombinationButton){//im tastenkombi ändern fesnter knopf
            mainWindow.removeKeyListener(this);
            allowKeyCombinationChange=true;
            keyComboAusgabe.setText("Bereit");
            keyComboAusgabe.requestFocus();
            keyComboAusgabe.requestFocusInWindow();
            keyComboAusgabe.grabFocus();
        }
        else if(event.getSource()==saveKeyCombinationButton){//speichern im tastenkombi ändern fenster
            mainWindow.addKeyListener(this);
            setNewKeyCombinationWindow.setVisible(false);
            //des was hier danach kommt ist bloß die fallunterscheidung welche konfigurationswerte angepasst werden müssen
            //genauer kommentier ich des nicht
            if(currentlyEditedKeyCombinationNumber==0){
                CLOSE_WINDOW_ALT_REQUIRED=changeAltDown;
                CLOSE_WINDOW_CTRL_REQUIRED=changeCtrlDown;
                CLOSE_WINDOW_SHIFT_REQUIRED=changeShiftDown;
                CLOSE_WINDOW_KEY_STRING=changeKeyChar;
                CLOSE_WINDOW_KEY_CODE=changeKeyCode;
            }
            else if(currentlyEditedKeyCombinationNumber==1){
                OPEN_HELP_WINDOW_ALT_REQUIRED=changeAltDown;
                OPEN_HELP_WINDOW_CTRL_REQUIRED=changeCtrlDown;
                OPEN_HELP_WINDOW_SHIFT_REQUIRED=changeShiftDown;
                OPEN_HELP_WINDOW_KEY_STRING=changeKeyChar;
                OPEN_HELP_WINDOW_KEY_CODE=changeKeyCode;
            }
            else if(currentlyEditedKeyCombinationNumber==2){
                OPEN_NEW_PLOT_ALT_REQUIRED=changeAltDown;
                OPEN_NEW_PLOT_CTRL_REQUIRED=changeCtrlDown;
                OPEN_NEW_PLOT_SHIFT_REQUIRED=changeShiftDown;
                OPEN_NEW_PLOT_KEY_STRING=changeKeyChar;
                OPEN_NEW_PLOT_KEY_CODE=changeKeyCode;
            }
            else if(currentlyEditedKeyCombinationNumber==3){
                OPEN_NEW_WINDOW_ALT_REQUIRED=changeAltDown;
                OPEN_NEW_WINDOW_CTRL_REQUIRED=changeCtrlDown;
                OPEN_NEW_WINDOW_SHIFT_REQUIRED=changeShiftDown;
                OPEN_NEW_WINDOW_KEY_STRING=changeKeyChar;
                OPEN_NEW_WINDOW_KEY_CODE=changeKeyCode;
            }
            else if(currentlyEditedKeyCombinationNumber==4){
                OPEN_SETTINGS_WINDOW_ALT_REQUIRED=changeAltDown;
                OPEN_SETTINGS_WINDOW_CTRL_REQUIRED=changeCtrlDown;
                OPEN_SETTINGS_WINDOW_SHIFT_REQUIRED=changeShiftDown;
                OPEN_SETTINGS_WINDOW_KEY_STRING=changeKeyChar;
                OPEN_SETTINGS_WINDOW_KEY_CODE=changeKeyCode;
            }
            else if(currentlyEditedKeyCombinationNumber==5){
                REFRESH_FRAME_ALT_REQUIRED=changeAltDown;
                REFRESH_FRAME_CTRL_REQUIRED=changeCtrlDown;
                REFRESH_FRAME_SHIFT_REQUIRED=changeShiftDown;
                REFRESH_FRAME_KEY_STRING=changeKeyChar;
                REFRESH_FRAME_KEY_CODE=changeKeyCode;
            }
            else if(currentlyEditedKeyCombinationNumber==6){
                SAVE_GRAPH_IMAGE_ALT_REQUIRED=changeAltDown;
                SAVE_GRAPH_IMAGE_CTRL_REQUIRED=changeCtrlDown;
                SAVE_GRAPH_IMAGE_SHIFT_REQUIRED=changeShiftDown;
                SAVE_GRAPH_IMAGE_KEY_STRING=changeKeyChar;
                SAVE_GRAPH_IMAGE_KEY_CODE=changeKeyCode;
            }
            else if(currentlyEditedKeyCombinationNumber==7){
                TOGGLE_BOTTOM_PANEL_VISIBILITY_ALT_REQUIRED=changeAltDown;
                TOGGLE_BOTTOM_PANEL_VISIBILITY_CTRL_REQUIRED=changeCtrlDown;
                TOGGLE_BOTTOM_PANEL_VISIBILITY_SHIFT_REQUIRED=changeShiftDown;
                TOGGLE_BOTTOM_PANEL_VISIBILITY_KEY_STRING=changeKeyChar;
                TOGGLE_BOTTOM_PANEL_VISIBILITY_KEY_CODE=changeKeyCode;
            }
            else if(currentlyEditedKeyCombinationNumber==8){
                TOGGLE_FULLSCREEN_MODE_ALT_REQUIRED=changeAltDown;
                TOGGLE_FULLSCREEN_MODE_CTRL_REQUIRED=changeCtrlDown;
                TOGGLE_FULLSCREEN_MODE_SHIFT_REQUIRED=changeShiftDown;
                TOGGLE_FULLSCREEN_MODE_KEY_STRING=changeKeyChar;
                TOGGLE_FULLSCREEN_MODE_KEY_CODE=changeKeyCode;
            }
            keyCombinationsEnabled=true;
        }
        else if(event.getSource()==openDifferentPlotMenuItem){//datei -> Datei öffnen
            openNewPlot();
        }
        else if(event.getSource()==openNewWindowMenuItem){//Datei -> Neues Fenster öffnen
            openNewWindow();
        }
        else if(event.getSource()==closeWindowMenuItem){//Datei -> Fenster schließen
            closeWindow();
        }
        else if(event.getSource()==helpWindowCloseButton){//hilfefenster schließen
            helpWindow.setVisible(false);
        }
        else if(event.getSource()==pngCheckBox){//einstellungen  -> png speichern
            if(pngCheckBox.isSelected()){
                savePng=true;
            }
            else{
                savePng=false;
            }
        }
        else if(event.getSource()==jpegCheckBox){//einstellungen  -> jpg speichern
            if(jpegCheckBox.isSelected()){
                saveJpeg=true;
            }
            else{
                saveJpeg=false;
            }
            saveConfigurationFile();
        }
        else if(event.getSource()==fullscreenOnStartupComboBox){//einstellungen im vollbild starten
            if(fullscreenOnStartupComboBox.isSelected()){
                fullscreenOnStartup=true;
            }
            else{
                fullscreenOnStartup=true;
            }
            saveConfigurationFile();
        }
        else if(event.getSource()==dataPanelOnStartup){//einstellungen detailbereich beim starten
            if(dataPanelOnStartup.isSelected()){
                bottomPanelExpandedOnStartup=true;
            }
            else{
                bottomPanelExpandedOnStartup=true;
            }
            saveConfigurationFile();
        }
        else if(event.getSource()==AutoUpdateRadioButton){//einstellungen auto-update
            autoUpdate=AutoUpdateRadioButton.isSelected();
        }
        else if(event.getSource()==ManualUpdateRadioButton){//einstellungen nur manuell updaten
            autoUpdate=AutoUpdateRadioButton.isSelected();
        }
        else if(event.getSource()==FullscreenExclusiveRadioButton){//einstellungen Vollbild Vollbild
            fullscreenOk=FullscreenExclusiveRadioButton.isSelected();
        }
        else if(event.getSource()==MaximizeWindowRadioButton){//einstellungen Vollbild Maximiert
            fullscreenOk=FullscreenExclusiveRadioButton.isSelected();
        }
        else if(event.getSource()==changeInterpolationSettings){//einstrellungen "OK (nur Interpolation)"
            if(interpolateCustom.isSelected()){
                isCustomInterpolated=true;
                try{
                    interpolationFactor=Integer.parseInt(interpolateCustomInputBox.getText());
                }
                catch(NumberFormatException e){
                    interpolationFactor=1;
                }
            }
            else{
                isCustomInterpolated=false;
                if(interpolate1x.isSelected()){
                    interpolationFactor=1;
                }
                else if(interpolate4x.isSelected()){
                    interpolationFactor=4;
                }
                else if(interpolate10x.isSelected()){
                    interpolationFactor=10;
                }
                else if(interpolate100x.isSelected()){
                    interpolationFactor=100;
                }
                else if(interpolate1000x.isSelected()){
                    interpolationFactor=1000;
                }
                else{
                    interpolationFactor=1;
                }
            }
            try{
                interpolationOffset=Integer.parseInt(interpolationOffsetValueBox.getText())-1;
            }
            catch(NumberFormatException e){
                interpolationOffset=0;
            }
            if(interpolationOffset<0){
                interpolationOffset=0;
            }
            if(interpolationFactor<1){
                interpolationFactor=1;
            }
            onlyInterpolationChanging=true;
            replot();
        }
        if(event.getSource()==SetRTCButton){
            try{
                serialWriter.write("SETTIME "+SystemTimeField.getText());
                serialWriter.flush();
            }
            catch(Exception e){
                logln(e);
            }
        }
        if(event.getSource()==DeviceConnRefreshButton) {
        	DeviceConnComboBox.removeAllItems();
        	ports=SerialPort.getCommPorts();
        	        SerialPort P;
        	        for(int i=0;i<ports.length;i++) {
        	            P=ports[i];
        	            logln(P.getDescriptivePortName()+"|"+P.getSystemPortName());
        	            if(P.getDescriptivePortName().startsWith("Arduino Mega 2560")) {//"Arduino Leonardo")){
        	                /*port=P;
        	                port.setBaudRate(115200);
        	                SerialAvailable=port.openPort();
        	                logln(port.isOpen());
        	                SerialAvailable=port.isOpen();*/
        	                selectedPort=i;
        	            }
        	        }
        	        logln(SerialAvailable);
        	for(SerialPort PT:ports) {
        	            DeviceConnComboBox.addItem(PT.getDescriptivePortName());
        	        }
        	        if(SerialAvailable) {
        	            DeviceConnComboBox.setSelectedIndex(selectedPort);
        	        }
        }
        if(event.getSource()==DeviceConnConnectButton) {
        	try {
        	SerialThread.stop();
        	SerialThread.destroy();
        	SerialThread=null;
        	SerialListener=null;
        	}
        	catch(NullPointerException exc) {
        		logln(exc);
        	}
        	catch(Exception exy) {
        		log("CRITICAL: ");
        		logln(exy);
        	}
        	System.gc();
        	port=ports[DeviceConnComboBox.getSelectedIndex()];
        	if(port==null) {
                logln("NO APROPRIATE SERIAL PORT");
                SerialAvailable=false;
            }
            else {
                if(SerialAvailable) {
                    logln(port);
                    serialScanner=new Scanner(new InputStreamReader(port.getInputStream()));
                    serialWriter=new BufferedWriter(new OutputStreamWriter(port.getOutputStream()));
                    SerialAvailable=true;
                }
            }
	        SerialListener=new SerialWorker(this);
	        SerialThread=new Thread(SerialListener);
	        SerialThread.start();
        }
        if(event.getSource()==GeoModeOkButton){//Geo-Modus/Physik-modus
            geoMode=GeoModeButton.isSelected();
            replot();
        }
        for(int i=0;i<NUMBER_OF_KEY_COMBOS;i++){//tastenkombis ändern
            if(event.getSource()==KeyCombinationChangeButton[i]){
                openSetNewKeyCombinationWindow(i);
            }
        }
        for(int i=0;i<numberOfGraphs;i++){//graphen ausblenden
            if(event.getSource()==selectGraphVisibilityCheckBox[i]){
                setSeriesVisible(i,selectGraphVisibilityCheckBox[i].isSelected());
            }
        }
        reloadBackend();
    }

    /*
     * graphen neu zeichnen
     */
    private void replot(){
        replotting=true;
        mainWindow.remove(chartPanel);
        jFreeChart=createDataset();
        setupCrosshairOverlays();
        mainWindow.add(chartPanel,BorderLayout.NORTH);
        chartPanel.addChartMouseListener(this);
        mainWindow.validate();
        replotting=false;
    }

    /*
     * datenreihe sichtbar/unsichtbar machen
     */
    private void setSeriesVisible(int number,boolean selected) {
        if(graphIsVisible[number]==selected){//ist bereits im gewünschten status
            return;
        }
        graphIsVisible[number]=selected;
        if(selected){//hinzufügen
            xYSeriesCollection.removeAllSeries();

            for(int i=0;i<numberOfGraphs;i++){

                yCrosshairs[i].setVisible(false);

                if(graphIsVisible[i]){

                    xYSeriesCollection.addSeries(xYSeries[i]);

                    yCrosshairs[i].setVisible(true);

                }

            }
        }
        else{//entfernen
            yCrosshairs[number].setVisible(false);
            xYSeriesCollection.removeSeries(xYSeries[number]);
        }
    }

    /*
     * konfigutration etc neu laden
     */
    private void reloadBackend(){
        saveConfigurationFile();
        loadConfigurationFile();
        loadTextForHelpWindowAndKeyCombinations();
    }

    /*
     * fesnter zum tastenkombis ändern öffnen
     */
    private void openSetNewKeyCombinationWindow(int input) {
        keyCombinationsEnabled=false;
        configureKeyCombinationText[5].setText(configureKeyCombinationText[5].getText()+setNewKeyCombinationTexts[input]);
        setNewKeyCombinationWindow.setVisible(true);
        currentlyEditedKeyCombinationNumber=input;
    }

    /*
     * "elternfenster" setzen
     */
    private void setPrevious(Raumklima newPrevious) {
        previous=newPrevious;
    }

    /*
     * "kindfenster setzen
     */
    private void setNext(Raumklima newNext) {
        next=newNext;
    }

    /*
     * andere datei öffnen
     * eigene eigenschaften (eltern/kindfenster/nummer) an neues Fenster weitergeben und sich selber schließen
     */
    private void openNewPlot(){
        mainWindow.setVisible(false);
        Raumklima neu=new Raumklima(titleNumber,previous,next);
        if(next!=null){
            next.setPrevious(neu);
        }
        if(previous!=null){
            previous.setNext(neu);
        }
        exit();
    }

    /*
     * neues fenster
     */
    private void openNewWindow(){
        next=new Raumklima(titleNumber+1,this,next);
    }

    /*
     * Fenster zumachen
     */
    private void closeWindow(){
        if(next!=null){
            next.decrementTitleNumber();
            next.setPrevious(previous);
        }
        if(previous!=null){
            previous.setNext(next);
        }
        exit();
    }

    /*
     * Nummer im titel vom Hauptfenster verringern
     */
    private void decrementTitleNumber() {
        titleNumber--;
        setTitle();
        if(next!=null){
            next.decrementTitleNumber();
        }
    }

    /*
     * Hapzfenster Titel setzen
     */
    private void setTitle(){
        if(titleNumber==1){
            mainWindow.setTitle(title);
        }
        else{
            mainWindow.setTitle(title+" ("+titleNumber+")");
        }
    }

    /*
     * MenuBar im Hauptfenster reagieren
     */
    @Override
    public void mouseClicked(MouseEvent event) {
        if(event.getSource()==openSettingsWindowMenu){
            deactivateFullscreen();
            toggleSettingsWindow();
        }
        if(event.getSource()==openHelpWindowMenu){
            deactivateFullscreen();
            makeHelpWindowVisible();
        }
        if(event.getSource()==toggleFullscreenModeMenu){
            toggleFullscreen();
        }
        else if(event.getSource()==saveGraphImagesMenu){
            saveImages();
        }
        else if(event.getSource()==toggleDataPanelMenu){
            toggleBottomPanel();
        }
    }

    /**
     * This Method handles the Key Events for changing the KeyCombinations
     */
    @Override
    public void keyReleased(KeyEvent event) {
        if(allowKeyCombinationChange){
            allowKeyCombinationChange=false;
            //logln("KeyReleased");
            keyComboAusgabe.setText("");
            if(event.isAltDown()){
                keyComboAusgabe.setText("Alt+");
                changeAltDown=true;
            }
            if(event.isControlDown()){
                keyComboAusgabe.setText(keyComboAusgabe.getText()+"Strg+");
                changeCtrlDown=true;
            }
            if(event.isShiftDown()){
                keyComboAusgabe.setText(keyComboAusgabe.getText()+"Shift+");
                changeShiftDown=true;
            }
            //keyComboAusgabe.setText(keyComboAusgabe.getText()+String.valueOf(event.getKeyChar()));
            keyComboAusgabe.setText(keyComboAusgabe.getText()+getKeyStringFromKeyCode(event.getExtendedKeyCode()));
            changeKeyChar=getKeyStringFromKeyCode(event.getExtendedKeyCode());
            changeKeyCode=event.getExtendedKeyCode();

            log(event.getKeyChar());

            logln(":"+event.getExtendedKeyCode()+":"+getKeyStringFromKeyCode(event.getExtendedKeyCode()));
            changeKeyCode=event.getExtendedKeyCode();
        }
    }

    /*
     * einen String, mit dem namen des Keycodes organisieren, dass bim ändern der Tastenkombis statt "17+18+127" "STRG+ALT+ENTF" steht
     */
    private String getKeyStringFromKeyCode(int code){
        //mir ist bekannt, dass die Methode KeyEvent.getKeyText(int) existiert, jedoch sind ausgaben wie "Zirkumflex (Dead)" meiner meinung nach unverständlicher als "^"
        switch(code){
            case 8: return"BACKSPACE";
            case 10: return"ENTER";
            case 16:return "SHIFT";
            case 17: return"STRG";
            case 18:return"ALT";
            case 20:return"CAPS_LOCK";
            case 27: return"ESC";
            case 32: return"SPACE";
            case 33: return"BILD_AUF";
            case 34: return"BILD_AB";
            case 35: return"ENDE";
            case 36: return"POS1";
            case 37: return"PFEILTASTE_LINKS";
            case 38: return"PFEILTASTE_OBEN";
            case 39: return"PFEILTASTE_RECHTS";
            case 40: return"PFEILTASTE_UNTEN";
            case 44: return",";
            case 45: return"-";
            case 46: return".";
            case 48: return"0";
            case 49: return"1";
            case 50: return"2";
            case 51: return"3";
            case 52: return"4";
            case 53: return"5";
            case 54: return"6";
            case 55: return"7";
            case 56: return"8";
            case 57: return"9";
            case 65: return"A";
            case 66: return"B";
            case 67: return"C";
            case 68: return"D";
            case 69: return"E";
            case 70: return"F";
            case 71: return"G";
            case 72: return"H";
            case 73: return"I";
            case 74: return"J";
            case 75: return"K";
            case 76: return"L";
            case 77: return"M";
            case 78: return"N";
            case 79: return"O";
            case 80: return"P";
            case 81: return"Q";
            case 82: return"R";
            case 83: return"S";
            case 84: return"T";
            case 85: return"U";
            case 86: return"V";
            case 87: return"W";
            case 88: return"X";
            case 89: return"Y";
            case 90: return"Z";
            case 96: return"NUM_0";
            case 97: return"NUM_1";
            case 98: return"NUM_2";
            case 99: return"NUM_3";
            case 100: return"NUM_4";
            case 101: return"NUM_5";
            case 102: return"NUM_6";
            case 103: return"NUM_7";
            case 104: return"NUM_8";
            case 105: return"NUM_9";
            case 106: return"NUM_*";
            case 107: return"NUM_+";
            case 109: return"NUM_-";
            case 110: return"NUM_,";
            case 111: return"NUM_/";
            case 112: return"F1";
            case 113: return"F2";
            case 114: return"F3";
            case 115: return"F4";
            case 116: return"F5";
            case 117: return"F6";
            case 118: return"F7";
            case 119: return"F8";
            case 120: return"F9";
            case 121: return"F10";
            case 122: return"F11";
            case 123: return"F12";
            case 127: return"ENTF";
            case 129: return"´";//appostroph
            case 130: return"^";
            case 144: return"NUM";
            case 145: return"ROLLEN";
            case 153: return"<";
            case 154: return"DRUCK";
            case 155: return"EINFG";
            case 520: return"#";
            case 521: return"+";
            case 524:return"WINDOWS";
            case 16777412: return"Ä"; //AE
            case 16777430: return"Ö"; //OE
            case 16777439: return"ß"; //'SS'
            case 16777468: return"Ü"; //UE
            default:return "ERROR:"+String.valueOf(code)+"("+String.valueOf((char)(code))+")";
        }
    }

    /**
     * This method handles the Key Events for the various KeyCombinations
     */
    @Override
    public void keyPressed(KeyEvent event) {

        logln("KeyText (extended): "+KeyEvent.getKeyText(event.getExtendedKeyCode())+"    KeyText: "+KeyEvent.getKeyText(event.getKeyCode())+"    KeyString (eigenbau&&extended): "+getKeyStringFromKeyCode(event.getExtendedKeyCode())+"    KeyString(eigenbau): "+getKeyStringFromKeyCode(event.getKeyCode()));
        if(keyCombinationsEnabled){
            if(event.getExtendedKeyCode()==TOGGLE_FULLSCREEN_MODE_KEY_CODE&&event.isAltDown()==TOGGLE_FULLSCREEN_MODE_ALT_REQUIRED&&event.isControlDown()==TOGGLE_FULLSCREEN_MODE_CTRL_REQUIRED&&event.isShiftDown()==TOGGLE_FULLSCREEN_MODE_SHIFT_REQUIRED){
                toggleFullscreen();
            }
            if(event.getExtendedKeyCode()==REFRESH_FRAME_KEY_CODE&&event.isAltDown()==REFRESH_FRAME_ALT_REQUIRED&&event.isControlDown()==REFRESH_FRAME_CTRL_REQUIRED&&event.isShiftDown()==REFRESH_FRAME_SHIFT_REQUIRED){
                refreshPage();
            }
            if(event.getExtendedKeyCode()==OPEN_HELP_WINDOW_KEY_CODE&&event.isAltDown()==OPEN_HELP_WINDOW_ALT_REQUIRED&&event.isControlDown()==OPEN_HELP_WINDOW_CTRL_REQUIRED&&event.isShiftDown()==OPEN_HELP_WINDOW_SHIFT_REQUIRED){
                deactivateFullscreen();
                makeHelpWindowVisible();
            }
            if(event.getExtendedKeyCode()==OPEN_NEW_PLOT_KEY_CODE&&event.isAltDown()==OPEN_NEW_PLOT_ALT_REQUIRED&&event.isControlDown()==OPEN_NEW_PLOT_CTRL_REQUIRED&&event.isShiftDown()==OPEN_NEW_PLOT_SHIFT_REQUIRED){
                deactivateFullscreen();
                openNewPlot();
            }
            if(event.getExtendedKeyCode()==OPEN_NEW_WINDOW_KEY_CODE&&event.isAltDown()==OPEN_NEW_WINDOW_ALT_REQUIRED&&event.isControlDown()==OPEN_NEW_WINDOW_CTRL_REQUIRED&&event.isShiftDown()==OPEN_NEW_WINDOW_SHIFT_REQUIRED){
                deactivateFullscreen();
                openNewWindow();
            }
            if(event.getExtendedKeyCode()==CLOSE_WINDOW_KEY_CODE&&event.isAltDown()==CLOSE_WINDOW_ALT_REQUIRED&&event.isControlDown()==CLOSE_WINDOW_CTRL_REQUIRED&&event.isShiftDown()==CLOSE_WINDOW_SHIFT_REQUIRED){
                deactivateFullscreen();
                closeWindow();
            }
            if(event.getExtendedKeyCode()==TOGGLE_BOTTOM_PANEL_VISIBILITY_KEY_CODE&&event.isAltDown()==TOGGLE_BOTTOM_PANEL_VISIBILITY_ALT_REQUIRED&&event.isControlDown()==TOGGLE_BOTTOM_PANEL_VISIBILITY_CTRL_REQUIRED&&event.isShiftDown()==TOGGLE_BOTTOM_PANEL_VISIBILITY_SHIFT_REQUIRED){
                toggleBottomPanel();
            }
            if(event.getExtendedKeyCode()==OPEN_SETTINGS_WINDOW_KEY_CODE&&event.isAltDown()==OPEN_SETTINGS_WINDOW_ALT_REQUIRED&&event.isControlDown()==OPEN_SETTINGS_WINDOW_CTRL_REQUIRED&&event.isShiftDown()==OPEN_SETTINGS_WINDOW_SHIFT_REQUIRED){
                deactivateFullscreen();
                toggleSettingsWindow();
            }
            if(event.getExtendedKeyCode()==SAVE_GRAPH_IMAGE_KEY_CODE&&event.isAltDown()==SAVE_GRAPH_IMAGE_ALT_REQUIRED&&event.isControlDown()==SAVE_GRAPH_IMAGE_CTRL_REQUIRED&&event.isShiftDown()==SAVE_GRAPH_IMAGE_SHIFT_REQUIRED){
                saveImages();
            }
        }
    }

    /* 
     * bilder speichern
     */
    private void saveImages() {

        logln("SAVING");
        if(saveJpeg){

            logln("JPG");
            try {
                ChartUtilities.saveChartAsJPEG(new File(csvFile.getName()+".jpeg"), jFreeChart, imageWidth, imageHeight);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(savePng){

            logln("PNG");
            try {
                ChartUtilities.saveChartAsPNG(new File(csvFile.getName()+".png"), jFreeChart, imageWidth, imageHeight);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
     * eine eventhandler methode eigentlich uninteressant (in den einstellungen)
     */
    @Override
    public void focusGained(FocusEvent arg0) {
        interpolateCustom.setSelected(true);
    }

    /*
     * überprüft ob vollbild erlaubt ist (INTEL => NOPE; kein intel => YES)
     */
    private void CheckFullscreenAvailability(){
        try{
            if(System.getProperty("os.name").contains("Win")||System.getProperty("os.name").contains("WIN")||System.getProperty("os.name").contains("win")){//System ist irgend eine Windows Version

                logln("WINDOWS");
                br=new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("wmic path win32_VideoController get name").getInputStream()));//cmd parameter von https://superuser.com/questions/723506/get-the-video-card-model-via-command-line-in-windows
            }
            else{//System ist irgendwas (Linux/UNIX/Mac OS)... Jedenfalls was mit bash

                logln("LINUX");
                br=new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("lspci -vnn | grep VGA -A 12").getInputStream()));//cmd parameter von http://www.binarytides.com/linux-get-gpu-information/
            }
            String zeile=br.readLine();
            String alles="";
            while(true){

                logln("\t\""+zeile+"\"");
                if(zeile==null/*||zeile.equals("")*/){
                    break;
                }
                alles+=zeile;
                zeile=br.readLine();
            }
            if(alles.contains("Intel")||alles.contains("Intel")||alles.contains("intel")){
                FullscreenExclusiveRadioButton.setEnabled(false);
                MaximizeWindowRadioButton.setSelected(true);
                fullscreenOk=false;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //alles was jetzt noch folgt sind eventhandler, die implementiert werden müssen, aber vollkommen wurscht sind
    @Override
    public void keyTyped(KeyEvent event) {}

    @Override
    public void mouseEntered(MouseEvent event) {}

    @Override
    public void mouseExited(MouseEvent event) {}

    @Override
    public void mousePressed(MouseEvent event) {}

    @Override
    public void mouseReleased(MouseEvent event) {}

    @Override
    public void componentHidden(ComponentEvent event) {}

    @Override
    public void componentMoved(ComponentEvent event) {}

    @Override
    public void componentShown(ComponentEvent event) {}

    @Override
    public void windowActivated(WindowEvent event) {}

    @Override
    public void windowClosed(WindowEvent event) {}

    @Override
    public void windowDeactivated(WindowEvent event) {}

    @Override
    public void windowDeiconified(WindowEvent event) {}

    @Override
    public void windowIconified(WindowEvent event) {}

    @Override
    public void windowOpened(WindowEvent event) {}

    @Override
    public void focusLost(FocusEvent arg0) {}
}