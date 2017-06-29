package Raumklima;
//TODO config wieder schreiben nachdem irgendeiner der werte ge�ndert wurde
//TODO concat CSV-files
//TODO arduino Config
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;
import java.net.*;
import java.nio.channels.*;

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
public class Raumklima implements ActionListener,WindowListener,WindowStateListener,ChartMouseListener,ComponentListener,KeyListener, MouseListener
{
    public static boolean CLOSE_WINDOW_ALT_REQUIRED=false;
    public static boolean OPEN_HELP_WINDOW_ALT_REQUIRED=false;
    public static boolean OPEN_NEW_PLOT_ALT_REQUIRED=false;
    public static boolean OPEN_NEW_WINDOW_ALT_REQUIRED=false;
    public static boolean OPEN_SETTINGS_WINDOW_ALT_REQUIRED=false;
    public static boolean REFRESH_FRAME_ALT_REQUIRED=false;
    public static boolean SAVE_GRAPH_IMAGE_ALT_REQUIRED=false;
    public static boolean TOGGLE_BOTTOM_PANEL_VISIBILITY_ALT_REQUIRED=false;
    public static boolean TOGGLE_FULLSCREEN_MODE_ALT_REQUIRED=false;

    public static boolean CLOSE_WINDOW_ALT_GRAPH_REQUIRED=false;
    public static boolean OPEN_HELP_WINDOW_ALT_GRAPH_REQUIRED=false;
    public static boolean OPEN_NEW_PLOT_ALT_GRAPH_REQUIRED=false;
    public static boolean OPEN_NEW_WINDOW_ALT_GRAPH_REQUIRED=false;
    public static boolean OPEN_SETTINGS_WINDOW_ALT_GRAPH_REQUIRED=false;
    public static boolean REFRESH_FRAME_ALT_GRAPH_REQUIRED=false;
    public static boolean SAVE_GRAPH_IMAGE_ALT_GRAPH_REQUIRED=false;
    public static boolean TOGGLE_BOTTOM_PANEL_VISIBILITY_ALT_GRAPH_REQUIRED=false;
    public static boolean TOGGLE_FULLSCREEN_MODE_ALT_GRAPH_REQUIRED=false;

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
    public static int SAVE_GRAPH_IMAGE_KEY_CODE=83;
    public static int TOGGLE_BOTTOM_PANEL_VISIBILITY_KEY_CODE=69;//E
    public static int TOGGLE_FULLSCREEN_MODE_KEY_CODE=122;//F11

    public static int HEIGHT_OF_DATA_BLOCK=25;
    public static int WIDTH_OF_DATA_BLOCK=370;
    public static int NUMBER_OF_KEY_COMBOS=9;
    public static int NUMBER_OF_COPYRIGHT_NOTES=24;
    public static int NUMBER_OF_CONFIG_ENTRIES=83;

    public static String CLOSE_WINDOW_KEY_STRING="W";
    public static String OPEN_HELP_WINDOW_KEY_STRING="F1";
    public static String OPEN_NEW_PLOT_KEY_STRING="O";
    public static String OPEN_NEW_WINDOW_KEY_STRING="N";
    public static String OPEN_SETTINGS_WINDOW_KEY_STRING="I";
    public static String REFRESH_FRAME_KEY_STRING="F5";
    public static String SAVE_GRAPH_IMAGE_KEY_STRING="S";
    public static String TOGGLE_BOTTOM_PANEL_VISIBILITY_KEY_STRING = "E";
    public static String TOGGLE_FULLSCREEN_MODE_KEY_STRING="F11";

    public static final double VERSION=1.0;

    boolean allowKeyComboChange=false;
    private boolean bottomPanelExpanded=false;
    private boolean changeAltDown;
    private boolean changeAltGrDown;
    private boolean changeCtrlDown;
    private boolean changeShiftDown;
    private boolean jFilePickerFailed=false;
    private boolean fullscreen=false;
    private boolean saveJpeg;
    private boolean savePng;

    private JButton helpWindowCloseButton;
    private JButton[] rightPanelButtons;

    private BufferedReader br;

    private ChartPanel chartPanel;

    private Crosshair xCrosshair;
    private Crosshair[] yCrosshairs;

    private Dimension fullscreenDimension;

    private File csvFile;

    private GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

    private Image logo;

    private int changeKeyCode;
    private int counter=0;
    private int dataPanelX=0;
    private int dataPanelY;
    private int numberOfGraphs;
    private int titleNumber=1;

    private JButton changeKeyComboButton;
    private JButton saveKeyComboButton;

    private JCheckBox jpegCheckBox;
    private JCheckBox pngCheckBox;

    private JFileChooser fileChooser;

    private JFreeChart jFreeChart;

    private JFrame configureKeyComboWindow;
    private JFrame fileChooserWindow;
    private JFrame helpWindow;
    private JFrame mainWindow;
    private JFrame settingsWindow;

    private JLabel leftPanelTitle;
    private JLabel rightPanelTitle;
    private JLabel waitText;
    private JLabel[] configureKeyComboText;
    private JLabel[] copyrightNotes;
    private JLabel[] dataLabels;
    private JLabel[] helpWindowText;
    private JLabel[] settingsWindowText;

    private JMenu fileMenu;
    private JMenu openHelpWindowMenu;
    private JMenu openSettingsWindowMenu;
    private JMenu toggleFullscreenModeMenu;

    private JMenuBar mainWindowMenuBar;

    private JMenuItem closeWindowMenuItem;
    private JMenuItem openDifferentPlotMenuItem;
    private JMenuItem openNewWindowMenuItem;

    private JPanel dataPanel;
    private JPanel helpPanel;
    private JPanel settingsWindowLeftPanel;
    private JPanel settingsWindowRightPanel;
    private JPanel waitPanel;
    private JPanel[] settingsWindowRightInnerPanel;

    private JScrollPane helpWindowScrollPane;

    private JTextField[] dataBoxes;
    private JTextField keyComboAusgabe;

    private Raumklima next;
    private Raumklima previous;

    private String changeKeyChar;
    private String title="Raumklima-Auswertungssoftware";
    private String[] dataValueDescriptors;
    private String[] configRaw;
    private String[] editKeyComboWindowText;
    private BufferedWriter bw;
    private int currentlyEditedKeycombo;
	private File configFile;
	private int width;
	private int height;
	private Dimension windowDimension;
	private Dimension bottomPanelDimension;
	private Dimension topPanelDimension;
	private JPanel[] dataPanels;

    /**
     * the standard constructor (without the optional values of the second Constructor, which is only needed in order to make the numbering in the Title of the MainWindow work. This Constructor just calls the {@code setup()} Method.
     */
    public Raumklima(){
        setup();
    }

    /**
     * the Secondary Constructor, which includes the "advanced" features (for the numbering scheme). This Constructor just calls the {@code setup()} Method.
     * @param newTitleNumber the number that should be displayed in the Titlebar on the MainWindow
     * @param newPrevious the preceding instance of Raumklima (only used to update the numbering scheme if a window is closed or opened)
     * @param newNext the following instance of Raumklima (only used to update the numbering scheme if a window is closed or opened)
     */
    public Raumklima(int newTitleNumber, Raumklima newPrevious, Raumklima newNext) {
        titleNumber=newTitleNumber;
        previous=newPrevious;
        next=newNext;
        setup();
    }

    /**
     * This Method does basically all the initialisation. It is called by both Constructors.
     */
    private void setup(){
        //Check for Software updates and automaitically perform them
    	configFile=new File("RaumklimaConfig.txt");
    	if(!configFile.exists()){//Download the default configuration file
    		try{
                URL website = new URL("https://raw.githubusercontent.com/lukasaldersley/Raumklima/master/Release/RaumklimaConfig.txt");
                ReadableByteChannel rbc = Channels.newChannel(website.openStream());
                FileOutputStream fos = new FileOutputStream("RaumklimaConfig.txt");
                fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
                fos.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
    	}
        if(checkIfUpdateAvailable()){
            updateJar();
        }

        //intialise JFrames
        fileChooserWindow=new JFrame();
        settingsWindow=new JFrame();
        helpWindow=new JFrame();
        mainWindow=new JFrame();
        configureKeyComboWindow=new JFrame();

        //Initialise and fill the WaitPanel
        waitPanel=new JPanel(new BorderLayout());
        waitText=new JLabel("Bitte Warten.");
        waitText.setHorizontalAlignment(SwingConstants.CENTER);
        waitPanel.add(waitText,BorderLayout.CENTER);

        //Add the temporary WaitPanel to The Window
        mainWindow.add(waitPanel);

        //make the plain empty JFrame visible, so the User knows that something's happening
        mainWindow.setSize(800, 480);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setVisible(true);

        //setup some very basic stuff
        //setup some basic sizes
        fullscreenDimension=new Dimension(graphicsDevice.getDisplayMode().getWidth(),graphicsDevice.getDisplayMode().getHeight());
        
        //setup the logo
        try {
            logo = ImageIO.read(new File("../Resources/Weather.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //read in the RaumklimaConfig.txt file, which holds the configuration
        configRaw=new String[NUMBER_OF_CONFIG_ENTRIES];
        try {
            br = new BufferedReader(new FileReader(configFile));
            for(int i=0;i<NUMBER_OF_CONFIG_ENTRIES;i++){
                configRaw[i]=br.readLine();
            }
            //System.out.println(configRaw[9]);
            //CLOSE_WINDOW_KEY_CODE=Integer.parseInt(new String(configRaw[9].trim().getBytes("UTF-8"),"UTF-8"));
            CLOSE_WINDOW_KEY_CODE=Integer.parseInt(configRaw[9]);
            CLOSE_WINDOW_KEY_STRING=configRaw[10];
            OPEN_HELP_WINDOW_KEY_CODE=Integer.parseInt(configRaw[16].trim());
            OPEN_HELP_WINDOW_KEY_STRING=configRaw[17];
            OPEN_NEW_PLOT_KEY_CODE=Integer.parseInt(configRaw[23].trim());
            OPEN_NEW_PLOT_KEY_STRING=configRaw[24];
            OPEN_NEW_WINDOW_KEY_CODE=Integer.parseInt(configRaw[30].trim());
            OPEN_NEW_WINDOW_KEY_STRING=configRaw[31];
            OPEN_SETTINGS_WINDOW_KEY_CODE=Integer.parseInt(configRaw[37].trim());
            OPEN_SETTINGS_WINDOW_KEY_STRING=configRaw[38];
            REFRESH_FRAME_KEY_CODE=Integer.parseInt(configRaw[44].trim());
            REFRESH_FRAME_KEY_STRING=configRaw[45];
            SAVE_GRAPH_IMAGE_KEY_CODE=Integer.parseInt(configRaw[51].trim());
            SAVE_GRAPH_IMAGE_KEY_STRING=configRaw[52];
            TOGGLE_BOTTOM_PANEL_VISIBILITY_KEY_CODE=Integer.parseInt(configRaw[58].trim());
            TOGGLE_BOTTOM_PANEL_VISIBILITY_KEY_STRING=configRaw[59];
            TOGGLE_FULLSCREEN_MODE_KEY_CODE=Integer.parseInt(configRaw[65].trim());
            TOGGLE_FULLSCREEN_MODE_KEY_STRING=configRaw[66];

            CLOSE_WINDOW_ALT_REQUIRED=configRaw[11].equals("YES");
            CLOSE_WINDOW_ALT_GRAPH_REQUIRED=configRaw[12].equals("YES");
            CLOSE_WINDOW_CTRL_REQUIRED=configRaw[13].equals("YES");
            CLOSE_WINDOW_SHIFT_REQUIRED=configRaw[14].equals("YES");

            OPEN_HELP_WINDOW_ALT_REQUIRED=configRaw[18].equals("YES");
            OPEN_HELP_WINDOW_ALT_GRAPH_REQUIRED=configRaw[19].equals("YES");
            OPEN_HELP_WINDOW_CTRL_REQUIRED=configRaw[20].equals("YES");
            OPEN_HELP_WINDOW_SHIFT_REQUIRED=configRaw[21].equals("YES");

            OPEN_NEW_PLOT_ALT_REQUIRED=configRaw[25].equals("YES");
            OPEN_NEW_PLOT_ALT_GRAPH_REQUIRED=configRaw[26].equals("YES");
            OPEN_NEW_PLOT_CTRL_REQUIRED=configRaw[27].equals("YES");
            OPEN_NEW_PLOT_SHIFT_REQUIRED=configRaw[28].equals("YES");

            OPEN_NEW_WINDOW_ALT_REQUIRED=configRaw[32].equals("YES");
            OPEN_NEW_WINDOW_ALT_GRAPH_REQUIRED=configRaw[33].equals("YES");
            OPEN_NEW_WINDOW_CTRL_REQUIRED=configRaw[34].equals("YES");
            OPEN_NEW_WINDOW_SHIFT_REQUIRED=configRaw[35].equals("YES");

            OPEN_SETTINGS_WINDOW_ALT_REQUIRED=configRaw[39].equals("YES");
            OPEN_SETTINGS_WINDOW_ALT_GRAPH_REQUIRED=configRaw[40].equals("YES");
            OPEN_SETTINGS_WINDOW_CTRL_REQUIRED=configRaw[41].equals("YES");
            OPEN_SETTINGS_WINDOW_SHIFT_REQUIRED=configRaw[42].equals("YES");

            REFRESH_FRAME_ALT_REQUIRED=configRaw[46].equals("YES");
            REFRESH_FRAME_ALT_GRAPH_REQUIRED=configRaw[47].equals("YES");
            REFRESH_FRAME_CTRL_REQUIRED=configRaw[48].equals("YES");
            REFRESH_FRAME_SHIFT_REQUIRED=configRaw[49].equals("YES");

            SAVE_GRAPH_IMAGE_ALT_REQUIRED=configRaw[53].equals("YES");
            SAVE_GRAPH_IMAGE_ALT_GRAPH_REQUIRED=configRaw[54].equals("YES");
            SAVE_GRAPH_IMAGE_CTRL_REQUIRED=configRaw[55].equals("YES");
            SAVE_GRAPH_IMAGE_SHIFT_REQUIRED=configRaw[56].equals("YES");

            TOGGLE_BOTTOM_PANEL_VISIBILITY_ALT_REQUIRED=configRaw[60].equals("YES");
            TOGGLE_BOTTOM_PANEL_VISIBILITY_ALT_GRAPH_REQUIRED=configRaw[61].equals("YES");
            TOGGLE_BOTTOM_PANEL_VISIBILITY_CTRL_REQUIRED=configRaw[62].equals("YES");
            TOGGLE_BOTTOM_PANEL_VISIBILITY_SHIFT_REQUIRED=configRaw[63].equals("YES");

            TOGGLE_FULLSCREEN_MODE_ALT_REQUIRED=configRaw[67].equals("YES");
            TOGGLE_FULLSCREEN_MODE_ALT_GRAPH_REQUIRED=configRaw[68].equals("YES");
            TOGGLE_FULLSCREEN_MODE_CTRL_REQUIRED=configRaw[69].equals("YES");
            TOGGLE_FULLSCREEN_MODE_SHIFT_REQUIRED=configRaw[70].equals("YES");

            if(configRaw[74].equals("YES")){
                savePng=true;
            }
            else{
                savePng=false;
            }
            if(configRaw[76].equals("YES")){
                saveJpeg=true;
            }
            else{
                saveJpeg=false;
            }
            if(configRaw[80].equals("YES")){
                fullscreen=true;
            }
            else{
                fullscreen=false;
            }
            if(configRaw[82].equals("YES")){
                bottomPanelExpanded=true;
            }
            else{
                bottomPanelExpanded=false;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        //Initialise and setup FileChooser
        fileChooser=new JFileChooser();
        fileChooser.setDialogTitle("Bitte CSV-Datei auswählen");
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Aufgezeichnete Klimadaten (.csv/.CSV)","csv","CSV"));

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
        mainWindow.setJMenuBar(mainWindowMenuBar);

        openHelpWindowMenu=new JMenu("Hilfe ("+OPEN_HELP_WINDOW_KEY_STRING+")");
        openHelpWindowMenu.addMouseListener(this);
        mainWindowMenuBar.add(openHelpWindowMenu);

        //setup the MainWindow
        mainWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        mainWindow.setIconImage(logo);
        mainWindow.setMinimumSize(new Dimension(370,400));//mindestens 1 block der Textfelder MUSS draufpassen (370px)
        setTitle();

        //Set a Different Cursor to indicate The program is working
        try{
            mainWindow.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        }
        catch(Exception e){
            e.printStackTrace();
        }

        //keyComboWindow
        //beim Textfeld 5 wird noch der name der zu ändernden tastenkombi eingef�gt
        try{
            editKeyComboWindowText=new String[NUMBER_OF_KEY_COMBOS];
            configureKeyComboWindow.setLayout(new GridLayout(0,1));
            configureKeyComboWindow.setTitle("Tastenkombination ändern");
            configureKeyComboWindow.setSize(new Dimension(540,470));
            configureKeyComboWindow.setLocationRelativeTo(null);
            br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("configureKeyComboText.txt")));
            int anz=12;
            configureKeyComboText=new JLabel[anz];
            for(int i=0;i<anz;i++){
                configureKeyComboText[i]=new JLabel(br.readLine());
                configureKeyComboWindow.add(configureKeyComboText[i]);
            }
            keyComboAusgabe=new JTextField();
            keyComboAusgabe.setEditable(false);
            //keyComboAusgabe.setFocusable(false);
            configureKeyComboWindow.add(keyComboAusgabe);
            changeKeyComboButton=new JButton("ändern");
            changeKeyComboButton.addActionListener(this);
            configureKeyComboWindow.add(changeKeyComboButton);
            saveKeyComboButton=new JButton("Schließen");
            saveKeyComboButton.addActionListener(this);
            configureKeyComboWindow.add(saveKeyComboButton);
            configureKeyComboWindow.validate();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        //Setup the HeplpWindow
        helpWindowScrollPane=new JScrollPane();
        helpWindow.setSize(520,480);
        helpWindow.setLocationRelativeTo(null);
        helpWindow.setTitle("Hilfe");
        helpPanel=new JPanel(new GridLayout(0,1));

        helpWindowScrollPane.setViewportView(helpPanel);
        helpWindowScrollPane.setPreferredSize(new Dimension(helpWindow.getWidth(), helpWindow.getHeight()-53));
        helpWindow.add(helpWindowScrollPane,BorderLayout.NORTH);

        helpWindowCloseButton=new JButton("Schließen");
        helpWindowCloseButton.addActionListener(this);
        helpWindowCloseButton.setPreferredSize(new Dimension(helpWindow.getWidth(),25));
        helpWindow.add(helpWindowCloseButton,BorderLayout.SOUTH);

        helpWindow.setResizable(false);

        helpWindowText=new JLabel[NUMBER_OF_KEY_COMBOS];
        settingsWindowText=new JLabel[NUMBER_OF_KEY_COMBOS];
        rightPanelButtons=new JButton[NUMBER_OF_KEY_COMBOS];
        settingsWindowRightInnerPanel=new JPanel[NUMBER_OF_KEY_COMBOS];

        //SettingsWindow
        settingsWindow.setSize(800,320);
        settingsWindow.setTitle("Einstellungen");
        settingsWindow.setLocationRelativeTo(null);
        settingsWindowLeftPanel=new JPanel();
        settingsWindowRightPanel=new JPanel();
        settingsWindowLeftPanel.setLayout(new GridLayout(0,1));
        settingsWindowRightPanel.setLayout(new GridLayout(0,1));

        leftPanelTitle=new JLabel("Verendete Dateitypen:");
        leftPanelTitle.setFont(new Font(Font.SERIF,Font.BOLD, 16));
        pngCheckBox=new JCheckBox(("PNG"));
        pngCheckBox.addActionListener(this);
        pngCheckBox.setSelected(savePng);
        jpegCheckBox=new JCheckBox("JPEG");
        jpegCheckBox.addActionListener(this);
        jpegCheckBox.setSelected(saveJpeg);
        //pdfCheckBox=new JCheckBox();
        //svgCheckBox=new JCheckBox();
        settingsWindowLeftPanel.add(leftPanelTitle);
        settingsWindowLeftPanel.add(pngCheckBox);
        settingsWindowLeftPanel.add(jpegCheckBox);

        settingsWindow.add(settingsWindowLeftPanel,BorderLayout.WEST);

        rightPanelTitle=new JLabel("Tastenkürzel:");
        rightPanelTitle.setFont(new Font(Font.SERIF,Font.BOLD, 16));
        settingsWindowRightPanel.add(rightPanelTitle, BorderLayout.NORTH);
        readInTextsForKeyCombos();
        for(int i=0;i<NUMBER_OF_KEY_COMBOS;i++){
            settingsWindowRightPanel.add(settingsWindowRightInnerPanel[i], BorderLayout.SOUTH);
        }

        settingsWindow.add(settingsWindowRightPanel, BorderLayout.EAST);
        settingsWindow.validate();

        //validiere das hilfefenster nochmals 
        helpWindow.validate();

        //get the data and draw the graph
        //proceed only if successful otherwise exit
        jFreeChart = createChart(createDataset());
        if(jFilePickerFailed==false){
            chartPanel = new ChartPanel(jFreeChart);
            CrosshairOverlay crosshairOverlay = new CrosshairOverlay();
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

            //Initialise the DataPanel
            dataPanelX=floor(fullscreenDimension.width/370);
            dataPanelY=roof((double)((double)numberOfGraphs/(double)dataPanelX));

            if(dataPanelX*dataPanelY<numberOfGraphs){//Something went terribly WRONG!!!!
                System.out.println("HELP SPACIAL COLLISION OF numberOfGraphs and panelX/Y: "+numberOfGraphs+"|"+dataPanelX+"x"+dataPanelY);
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

            //Remove the temporary WaitPanel
            mainWindow.remove(waitPanel);

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
            if(fullscreen){
                fullscreen=false;
                toggleFullscreen();
            }
            //if the mottomPanel should be made invisible on startup, do it here
            if(!bottomPanelExpanded){
                toggleBottomPanel();
            }
            chartPanel.getPopupMenu().remove(3);//den punkt speichern zum speichern des aktuellen Chartinhalts entfernen, da es sonst probleme mit dem vollbildmodus gibt wenn jemand darauf klickt.
            refreshPage();
            //revert the Cursor Back To Normal
            mainWindow.setCursor(Cursor.getDefaultCursor());
        }
        else{
            exit();
        }
    }

    /**
     * After the Programm has checked whether an update from github is available it performs this update
     */
    public void updateJar(){
        try{
            File oldFile=new File("Raumklima.jar");
            oldFile.delete();
            //fileUrl: "https://raw.githubusercontent.com/lukasaldersley/Raumklima/master/Release/VERSION"
            URL website = new URL("https://github.com/lukasaldersley/Raumklima/raw/master/Release/Raumklima.jar");
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream("Raumklima.jar");
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            fos.close();
            Runtime.getRuntime().exec("java -jar Raumklima.jar");
            System.exit(0);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Checks whether an Update is available
     * @return true if an update is available, false if no update is available
     */
    public boolean checkIfUpdateAvailable(){
        try{
            URL website = new URL("https://raw.githubusercontent.com/lukasaldersley/Raumklima/master/Release/VERSION");
            br=new  BufferedReader(new InputStreamReader(website.openStream()));
            if(Double.parseDouble(br.readLine().trim())>VERSION){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Writes the Configuration (which is saved in a {@link String} Array in Memory) to a File on the local Storage
     */
    private void writeConfigFile(){
    	System.out.println("writingConfig");
        try {
        File cf=new File("RaumklimaConfig.txt");
        cf.delete();
        cf.createNewFile();
        bw = new BufferedWriter(new FileWriter(cf));
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

    private void readInTextsForKeyCombos() {
        br=new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("HelpTexts.txt")));
        try{

            String line="";
            for(int i=0;i<NUMBER_OF_KEY_COMBOS;i++){
                settingsWindowRightInnerPanel[i]=new JPanel(new BorderLayout());
                line=br.readLine();
                editKeyComboWindowText[i]=line;
                line +=": ";
                helpWindowText[i]=new JLabel(line);
                helpWindowText[i].setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
                helpPanel.add(helpWindowText[i]);
            }
            //add Copyright notice
            br=new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("CopyrightNotes.txt")));
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
            if(CLOSE_WINDOW_ALT_GRAPH_REQUIRED){
                helpWindowText[0].setText(helpWindowText[0].getText()+"AltGr+");
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
            if(OPEN_HELP_WINDOW_ALT_GRAPH_REQUIRED){
                helpWindowText[1].setText(helpWindowText[1].getText()+"AltGr+");
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
            if(OPEN_NEW_PLOT_ALT_GRAPH_REQUIRED){
                helpWindowText[2].setText(helpWindowText[2].getText()+"AltGr+");
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
            if(OPEN_NEW_WINDOW_ALT_GRAPH_REQUIRED){
                helpWindowText[3].setText(helpWindowText[3].getText()+"AltGr+");
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
            if(OPEN_SETTINGS_WINDOW_ALT_GRAPH_REQUIRED){
                helpWindowText[4].setText(helpWindowText[4].getText()+"AltGr+");
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
            if(REFRESH_FRAME_ALT_GRAPH_REQUIRED){
                helpWindowText[5].setText(helpWindowText[5].getText()+"AltGr+");
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
            if(SAVE_GRAPH_IMAGE_ALT_GRAPH_REQUIRED){
                helpWindowText[6].setText(helpWindowText[6].getText()+"AltGr+");
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
            if(TOGGLE_BOTTOM_PANEL_VISIBILITY_ALT_GRAPH_REQUIRED){
                helpWindowText[7].setText(helpWindowText[7].getText()+"AltGr+");
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
            if(TOGGLE_FULLSCREEN_MODE_ALT_GRAPH_REQUIRED){
                helpWindowText[8].setText(helpWindowText[8].getText()+"AltGr+");
            }
            if(TOGGLE_FULLSCREEN_MODE_CTRL_REQUIRED){
                helpWindowText[8].setText(helpWindowText[8].getText()+"Strg+");
            }
            if(TOGGLE_FULLSCREEN_MODE_SHIFT_REQUIRED){
                helpWindowText[8].setText(helpWindowText[8].getText()+"Shift+");
            }
            helpWindowText[1].setText(helpWindowText[1].getText()+OPEN_HELP_WINDOW_KEY_STRING);
            helpWindowText[0].setText(helpWindowText[0].getText()+CLOSE_WINDOW_KEY_STRING);
            helpWindowText[2].setText(helpWindowText[2].getText()+OPEN_NEW_PLOT_KEY_STRING);
            helpWindowText[3].setText(helpWindowText[3].getText()+OPEN_NEW_WINDOW_KEY_STRING);
            helpWindowText[4].setText(helpWindowText[4].getText()+OPEN_SETTINGS_WINDOW_KEY_STRING);
            helpWindowText[5].setText(helpWindowText[5].getText()+REFRESH_FRAME_KEY_STRING);
            helpWindowText[6].setText(helpWindowText[6].getText()+SAVE_GRAPH_IMAGE_KEY_STRING);
            helpWindowText[7].setText(helpWindowText[7].getText()+TOGGLE_BOTTOM_PANEL_VISIBILITY_KEY_STRING);
            helpWindowText[8].setText(helpWindowText[8].getText()+TOGGLE_FULLSCREEN_MODE_KEY_STRING);
            for(int i=0;i<NUMBER_OF_KEY_COMBOS;i++){
                for(int j=helpWindowText[i].getText().length();j<60;j++){
                    helpWindowText[i].setText(helpWindowText[i].getText()+" ");
                }
            }
            for(int i=0;i<NUMBER_OF_KEY_COMBOS;i++){
                //die Gleichen elmente für die Einstellungsseite Verwenden
                settingsWindowText[i]=new JLabel(helpWindowText[i].getText());
                settingsWindowText[i].setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
                settingsWindowRightInnerPanel[i].add(settingsWindowText[i],BorderLayout.WEST);
                rightPanelButtons[i]=new JButton("Ändern");
                rightPanelButtons[i].setPreferredSize(new Dimension(100,25));
                rightPanelButtons[i].addActionListener(this);
                settingsWindowRightInnerPanel[i].add(rightPanelButtons[i],BorderLayout.EAST);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            JLabel error=new JLabel("Ein Fehler ist aufgetreten und diese Seite konnte nicht geladen werden. Bitte laden Sie das Programm neu.");
            helpPanel.add(error);
        }
    }

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

    //TODO layout Überdenken
    private void refreshPage(){
    	System.out.println(mainWindow.getSize());
    	width=mainWindow.getWidth()-15;
    	if(fullscreen){
    		height=mainWindow.getHeight()-(23+8);
    	}
    	else{
    	height=mainWindow.getHeight()-(53+8);
    	}
    	windowDimension=new Dimension(width,height);
    	System.out.println(windowDimension);
    	dataPanelX=floor((double)(windowDimension.getWidth()/(double)(WIDTH_OF_DATA_BLOCK)));
    	dataPanelY=roof(numberOfGraphs/(double)(dataPanelX));
    	dataPanel.setLayout(new GridLayout(dataPanelY,dataPanelX));
    	System.out.println(numberOfGraphs+" | "+dataPanelX+"x"+dataPanelY);
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
    	System.out.println(topPanelDimension);
    	System.out.println(bottomPanelDimension);
    	System.out.println();
        mainWindow.validate();
    }

    private void deactivateFullscreen(){
        graphicsDevice.setFullScreenWindow(null);
        fullscreen=false;
        refreshPage();
        writeConfigFile();
    }

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
        writeConfigFile();
    }

    private void avtivateFullscreen(){
        graphicsDevice.setFullScreenWindow(mainWindow);
        fullscreen=true;
        refreshPage();
        writeConfigFile();
    }

    private int showOpenDialog(){
        return fileChooser.showOpenDialog(fileChooserWindow);
    }

    private JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYLineChart(null,"Zeit (s)","Werte",xYDataset);
        return jFreeChart;
    }

    @SuppressWarnings("rawtypes")
    private XYDataset createDataset() {
        XYSeriesCollection xYSeriesCollection = new XYSeriesCollection();
        int returnVal = showOpenDialog();
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try{
                csvFile=fileChooser.getSelectedFile();
                br=new BufferedReader(new FileReader(csvFile));
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        else{
            jFilePickerFailed=true;
            return xYSeriesCollection;
        }

        XYSeries[] xYSeries;

        try{
            String line=br.readLine();
            dataValueDescriptors=line.split(";");

            numberOfGraphs=dataValueDescriptors.length;

            xYSeries=new XYSeries[numberOfGraphs];

            for (int i = 0; i < numberOfGraphs; ++i) {
                xYSeries[i] = new XYSeries((Comparable)((Object)(dataValueDescriptors[i])));
            }

            line=br.readLine();
            while(line!=null||line!=""){
                if(line==null||line==""){
                    break;
                }
                //System.out.println(line);
                line=line.replace("NAN","0,00");
                line=line.replace(',', '.');
                //System.out.println(line);
                String[] zwso=line.split(";");
                double[] zwsp=new double[numberOfGraphs];
                for(int i=0;i<numberOfGraphs;i++){
                    zwsp[i]=Double.parseDouble(zwso[i]);
                    xYSeries[i].add(counter,zwsp[i]);
                }
                counter++;
                line=br.readLine();
                if(line==null||line==""){
                    break;
                }
            }

            for (int i = 0; i < numberOfGraphs; ++i) {
                xYSeriesCollection.addSeries(xYSeries[i]);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return xYSeriesCollection;
    }

    private void exit(){
        mainWindow.setVisible(false);
        mainWindow.dispose();
        fileChooserWindow.dispose();
        settingsWindow.dispose();
        helpWindow.dispose();
        configureKeyComboWindow.dispose();
    }

    @Override
    public void chartMouseClicked(ChartMouseEvent chartMouseEvent) {
        Rectangle2D rectangle2D = chartPanel.getScreenDataArea();
        JFreeChart jFreeChart = chartMouseEvent.getChart();
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        ValueAxis valueAxis = xYPlot.getDomainAxis();
        double d = valueAxis.java2DToValue((double)chartMouseEvent.getTrigger().getX(), rectangle2D, RectangleEdge.BOTTOM);
        this.xCrosshair.setValue(d);
        for (int i = 0; i < numberOfGraphs; ++i) {
            double d2 = DatasetUtilities.findYValue((XYDataset)xYPlot.getDataset(), (int)i, (double)d);
            dataBoxes[i].setText(String.valueOf(d2));
        }
    }

    @Override
    public void chartMouseMoved(ChartMouseEvent chartMouseEvent) {
        Rectangle2D rectangle2D = chartPanel.getScreenDataArea();
        JFreeChart jFreeChart = chartMouseEvent.getChart();
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        ValueAxis valueAxis = xYPlot.getDomainAxis();
        double d = valueAxis.java2DToValue((double)chartMouseEvent.getTrigger().getX(), rectangle2D, RectangleEdge.BOTTOM);
        this.xCrosshair.setValue(d);
        for (int i = 0; i < numberOfGraphs; ++i) {
            double d2 = DatasetUtilities.findYValue((XYDataset)xYPlot.getDataset(), (int)i, (double)d);
            yCrosshairs[i].setValue(d2);
        }
    }

    private void toggleHelpWindow(){
        helpWindow.setSize(helpWindow.getWidth()-10, helpWindow.getHeight());
        helpWindow.setVisible(true);
        helpWindow.setSize(helpWindow.getWidth()+10, helpWindow.getHeight());
        helpWindow.validate();
    }

    private void toggleSettingsWindow(){
        settingsWindow.setVisible(!settingsWindow.isVisible());
    }

    @Override
    public void componentResized(ComponentEvent event) {
        refreshPage();
    }

    @Override
    public void windowStateChanged(WindowEvent event) {
        refreshPage();
    }

    @Override
    public void windowClosing(WindowEvent event) {
        exit();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource()==changeKeyComboButton){
        	mainWindow.removeKeyListener(this);
            allowKeyComboChange=true;
            keyComboAusgabe.setText("Bereit");
            keyComboAusgabe.requestFocus();
            keyComboAusgabe.requestFocusInWindow();
            keyComboAusgabe.grabFocus();
        }
        if(event.getSource()==saveKeyComboButton){
        	mainWindow.addKeyListener(this);
            configureKeyComboWindow.setVisible(false);
            
            if(changeAltDown){
        		configRaw[currentlyEditedKeycombo*7+11]="YES";
        	}
        	else{
        		configRaw[currentlyEditedKeycombo*7+11]="NO";
        	}
            
            if(changeAltGrDown){
        		configRaw[currentlyEditedKeycombo*7+12]="YES";
        	}
        	else{
        		configRaw[currentlyEditedKeycombo*7+12]="NO";
        	}
            
            if(changeCtrlDown){
        		configRaw[currentlyEditedKeycombo*7+13]="YES";
        	}
        	else{
        		configRaw[currentlyEditedKeycombo*7+13]="NO";
        	}
            
            if(changeShiftDown){
        		configRaw[currentlyEditedKeycombo*7+14]="YES";
        	}
        	else{
        		configRaw[currentlyEditedKeycombo*7+14]="NO";
        	}
        	configRaw[currentlyEditedKeycombo*7+9]=String.valueOf(changeKeyCode);
        	configRaw[currentlyEditedKeycombo*7+10]=changeKeyChar;
        	
            
            if(currentlyEditedKeycombo==0){
            	CLOSE_WINDOW_ALT_REQUIRED=changeAltDown;
            	CLOSE_WINDOW_ALT_GRAPH_REQUIRED=changeAltGrDown;
            	CLOSE_WINDOW_CTRL_REQUIRED=changeCtrlDown;
            	CLOSE_WINDOW_SHIFT_REQUIRED=changeShiftDown;
            	CLOSE_WINDOW_KEY_STRING=changeKeyChar;
            	CLOSE_WINDOW_KEY_CODE=changeKeyCode;
            }
            else if(currentlyEditedKeycombo==1){
            	OPEN_HELP_WINDOW_ALT_REQUIRED=changeAltDown;
            	OPEN_HELP_WINDOW_ALT_GRAPH_REQUIRED=changeAltGrDown;
            	OPEN_HELP_WINDOW_CTRL_REQUIRED=changeCtrlDown;
            	OPEN_HELP_WINDOW_SHIFT_REQUIRED=changeShiftDown;
            	OPEN_HELP_WINDOW_KEY_STRING=changeKeyChar;
            	OPEN_HELP_WINDOW_KEY_CODE=changeKeyCode;
            }
            else if(currentlyEditedKeycombo==2){
            	OPEN_NEW_PLOT_ALT_REQUIRED=changeAltDown;
            	OPEN_NEW_PLOT_ALT_GRAPH_REQUIRED=changeAltGrDown;
            	OPEN_NEW_PLOT_CTRL_REQUIRED=changeCtrlDown;
            	OPEN_NEW_PLOT_SHIFT_REQUIRED=changeShiftDown;
            	OPEN_NEW_PLOT_KEY_STRING=changeKeyChar;
            	OPEN_NEW_PLOT_KEY_CODE=changeKeyCode;
            }
            else if(currentlyEditedKeycombo==3){
            	OPEN_NEW_WINDOW_ALT_REQUIRED=changeAltDown;
            	OPEN_NEW_WINDOW_ALT_GRAPH_REQUIRED=changeAltGrDown;
            	OPEN_NEW_WINDOW_CTRL_REQUIRED=changeCtrlDown;
            	OPEN_NEW_WINDOW_SHIFT_REQUIRED=changeShiftDown;
            	OPEN_NEW_WINDOW_KEY_STRING=changeKeyChar;
            	OPEN_NEW_WINDOW_KEY_CODE=changeKeyCode;
            }
            else if(currentlyEditedKeycombo==4){
            	OPEN_SETTINGS_WINDOW_ALT_REQUIRED=changeAltDown;
            	OPEN_SETTINGS_WINDOW_ALT_GRAPH_REQUIRED=changeAltGrDown;
            	OPEN_SETTINGS_WINDOW_CTRL_REQUIRED=changeCtrlDown;
            	OPEN_SETTINGS_WINDOW_SHIFT_REQUIRED=changeShiftDown;
            	OPEN_SETTINGS_WINDOW_KEY_STRING=changeKeyChar;
            	OPEN_SETTINGS_WINDOW_KEY_CODE=changeKeyCode;
            }
            else if(currentlyEditedKeycombo==5){
            	REFRESH_FRAME_ALT_REQUIRED=changeAltDown;
            	REFRESH_FRAME_ALT_GRAPH_REQUIRED=changeAltGrDown;
            	REFRESH_FRAME_CTRL_REQUIRED=changeCtrlDown;
            	REFRESH_FRAME_SHIFT_REQUIRED=changeShiftDown;
            	REFRESH_FRAME_KEY_STRING=changeKeyChar;
            	REFRESH_FRAME_KEY_CODE=changeKeyCode;
            }
            else if(currentlyEditedKeycombo==6){
            	SAVE_GRAPH_IMAGE_ALT_REQUIRED=changeAltDown;
            	SAVE_GRAPH_IMAGE_ALT_GRAPH_REQUIRED=changeAltGrDown;
            	SAVE_GRAPH_IMAGE_CTRL_REQUIRED=changeCtrlDown;
            	SAVE_GRAPH_IMAGE_SHIFT_REQUIRED=changeShiftDown;
            	SAVE_GRAPH_IMAGE_KEY_STRING=changeKeyChar;
            	SAVE_GRAPH_IMAGE_KEY_CODE=changeKeyCode;
            }
            else if(currentlyEditedKeycombo==7){
            	TOGGLE_BOTTOM_PANEL_VISIBILITY_ALT_REQUIRED=changeAltDown;
            	TOGGLE_BOTTOM_PANEL_VISIBILITY_ALT_GRAPH_REQUIRED=changeAltGrDown;
            	TOGGLE_BOTTOM_PANEL_VISIBILITY_CTRL_REQUIRED=changeCtrlDown;
            	TOGGLE_BOTTOM_PANEL_VISIBILITY_SHIFT_REQUIRED=changeShiftDown;
            	TOGGLE_BOTTOM_PANEL_VISIBILITY_KEY_STRING=changeKeyChar;
            	TOGGLE_BOTTOM_PANEL_VISIBILITY_KEY_CODE=changeKeyCode;
            }
            else if(currentlyEditedKeycombo==8){
            	TOGGLE_FULLSCREEN_MODE_ALT_REQUIRED=changeAltDown;
            	TOGGLE_FULLSCREEN_MODE_ALT_GRAPH_REQUIRED=changeAltGrDown;
            	TOGGLE_FULLSCREEN_MODE_CTRL_REQUIRED=changeCtrlDown;
            	TOGGLE_FULLSCREEN_MODE_SHIFT_REQUIRED=changeShiftDown;
            	TOGGLE_FULLSCREEN_MODE_KEY_STRING=changeKeyChar;
            	TOGGLE_FULLSCREEN_MODE_KEY_CODE=changeKeyCode;
            }
            writeConfigFile();
            readInTextsForKeyCombos();
        }
        if(event.getSource()==openDifferentPlotMenuItem){
            openNewPlot();
        }
        if(event.getSource()==openNewWindowMenuItem){
            openNewWindow();
        }
        if(event.getSource()==closeWindowMenuItem){
            closeWindow();
        }
        if(event.getSource()==helpWindowCloseButton){
            helpWindow.setVisible(false);
        }
        if(event.getSource()==jpegCheckBox){
            if(pngCheckBox.isSelected()){
                configRaw[74]="YES";
                savePng=true;
            }
            else{
                configRaw[74]="NO";
                savePng=false;
            }
            writeConfigFile();
        }
        if(event.getSource()==jpegCheckBox){
            if(jpegCheckBox.isSelected()){
                configRaw[76]="YES";
                saveJpeg=true;
            }
            else{
                configRaw[76]="NO";
                saveJpeg=false;
            }
            writeConfigFile();
        }
        for(int i=0;i<NUMBER_OF_KEY_COMBOS;i++){
            if(event.getSource()==rightPanelButtons[i]){
                openEditCeyComboWindow(i);
            }
        }
    }

    private void openEditCeyComboWindow(int in) {
        configureKeyComboText[5].setText(configureKeyComboText[5].getText()+editKeyComboWindowText[in]);
        configureKeyComboWindow.setVisible(true);
        currentlyEditedKeycombo=in;
    }

    private void setPrevious(Raumklima newPrevious) {
        previous=newPrevious;
    }

    private void setNext(Raumklima newNext) {
        next=newNext;
    }

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

    private void openNewWindow(){
        next=new Raumklima(titleNumber+1,this,next);
    }

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

    private void decrementTitleNumber() {
        titleNumber--;
        setTitle();
        if(next!=null){
            next.decrementTitleNumber();
        }
    }

    private void setTitle(){
        if(titleNumber==1){
            mainWindow.setTitle(title);
        }
        else{
            mainWindow.setTitle(title+" ("+titleNumber+")");
        }
    }

    public static void main(String[] args){
        new Raumklima();
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        if(event.getSource()==openSettingsWindowMenu){
            deactivateFullscreen();
            toggleSettingsWindow();
        }
        if(event.getSource()==openHelpWindowMenu){
            deactivateFullscreen();
            toggleHelpWindow();
        }
        if(event.getSource()==toggleFullscreenModeMenu){
            toggleFullscreen();
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {
        if(allowKeyComboChange){
            allowKeyComboChange=false;
            //System.out.println("KeyReleased");
            keyComboAusgabe.setText("");
            if(event.isAltDown()){
                keyComboAusgabe.setText("Alt+");
                changeAltDown=true;
            }
            if(event.isAltGraphDown()){
                keyComboAusgabe.setText(keyComboAusgabe.getText()+"AltGr+");
                changeAltGrDown=true;
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
            System.out.print(event.getKeyChar());
            System.out.println(":"+event.getExtendedKeyCode()+":"+getKeyStringFromKeyCode(event.getExtendedKeyCode()));
            changeKeyCode=event.getExtendedKeyCode();
        }
    }

    private String getKeyStringFromKeyCode(int code){
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
            case 129: return"´";
            case 130: return"^";
            case 144: return"NUM";
            case 145: return"ROLLEN";
            case 153: return"<";
            case 154: return"DRUCK";
            case 155: return"EINFG";
            case 520: return"#";
            case 521: return"+";
            case 524:return"WINDOWS";
            case 16777412: return"Ä";
            case 16777430: return"Ö";
            case 16777439: return"ß";
            case 16777468: return"Ü";
            default:return "ERROR:"+String.valueOf(code)+"("+String.valueOf((char)(code))+")";
        }
    }

    @Override
    public void keyPressed(KeyEvent event) {
        if(event.getExtendedKeyCode()==TOGGLE_FULLSCREEN_MODE_KEY_CODE&&event.isAltDown()==TOGGLE_FULLSCREEN_MODE_ALT_REQUIRED&&event.isAltGraphDown()==TOGGLE_FULLSCREEN_MODE_ALT_GRAPH_REQUIRED&&event.isControlDown()==TOGGLE_FULLSCREEN_MODE_CTRL_REQUIRED&&event.isShiftDown()==TOGGLE_FULLSCREEN_MODE_SHIFT_REQUIRED){
            toggleFullscreen();
        }
        if(event.getExtendedKeyCode()==REFRESH_FRAME_KEY_CODE&&event.isAltDown()==REFRESH_FRAME_ALT_REQUIRED&&event.isAltGraphDown()==REFRESH_FRAME_ALT_GRAPH_REQUIRED&&event.isControlDown()==REFRESH_FRAME_CTRL_REQUIRED&&event.isShiftDown()==REFRESH_FRAME_SHIFT_REQUIRED){
            refreshPage();
        }
        if(event.getExtendedKeyCode()==OPEN_HELP_WINDOW_KEY_CODE&&event.isAltDown()==OPEN_HELP_WINDOW_ALT_REQUIRED&&event.isAltGraphDown()==OPEN_HELP_WINDOW_ALT_GRAPH_REQUIRED&&event.isControlDown()==OPEN_HELP_WINDOW_CTRL_REQUIRED&&event.isShiftDown()==OPEN_HELP_WINDOW_SHIFT_REQUIRED){
            deactivateFullscreen();
            toggleHelpWindow();
        }
        if(event.getExtendedKeyCode()==OPEN_NEW_PLOT_KEY_CODE&&event.isAltDown()==OPEN_NEW_PLOT_ALT_REQUIRED&&event.isAltGraphDown()==OPEN_NEW_PLOT_ALT_GRAPH_REQUIRED&&event.isControlDown()==OPEN_NEW_PLOT_CTRL_REQUIRED&&event.isShiftDown()==OPEN_NEW_PLOT_SHIFT_REQUIRED){
            deactivateFullscreen();
            openNewPlot();
        }
        if(event.getExtendedKeyCode()==OPEN_NEW_WINDOW_KEY_CODE&&event.isAltDown()==OPEN_NEW_WINDOW_ALT_REQUIRED&&event.isAltGraphDown()==OPEN_NEW_WINDOW_ALT_GRAPH_REQUIRED&&event.isControlDown()==OPEN_NEW_WINDOW_CTRL_REQUIRED&&event.isShiftDown()==OPEN_NEW_WINDOW_SHIFT_REQUIRED){
            deactivateFullscreen();
            openNewWindow();
        }
        if(event.getExtendedKeyCode()==CLOSE_WINDOW_KEY_CODE&&event.isAltDown()==CLOSE_WINDOW_ALT_REQUIRED&&event.isAltGraphDown()==CLOSE_WINDOW_ALT_GRAPH_REQUIRED&&event.isControlDown()==CLOSE_WINDOW_CTRL_REQUIRED&&event.isShiftDown()==CLOSE_WINDOW_SHIFT_REQUIRED){
            deactivateFullscreen();
            closeWindow();
        }
        if(event.getExtendedKeyCode()==TOGGLE_BOTTOM_PANEL_VISIBILITY_KEY_CODE&&event.isAltDown()==TOGGLE_BOTTOM_PANEL_VISIBILITY_ALT_REQUIRED&&event.isAltGraphDown()==TOGGLE_BOTTOM_PANEL_VISIBILITY_ALT_GRAPH_REQUIRED&&event.isControlDown()==TOGGLE_BOTTOM_PANEL_VISIBILITY_CTRL_REQUIRED&&event.isShiftDown()==TOGGLE_BOTTOM_PANEL_VISIBILITY_SHIFT_REQUIRED){
            toggleBottomPanel();
        }
        if(event.getExtendedKeyCode()==OPEN_SETTINGS_WINDOW_KEY_CODE&&event.isAltDown()==OPEN_SETTINGS_WINDOW_ALT_REQUIRED&&event.isAltGraphDown()==OPEN_SETTINGS_WINDOW_ALT_GRAPH_REQUIRED&&event.isControlDown()==OPEN_SETTINGS_WINDOW_CTRL_REQUIRED&&event.isShiftDown()==OPEN_SETTINGS_WINDOW_SHIFT_REQUIRED){
            deactivateFullscreen();
            toggleSettingsWindow();
        }
        if(event.getExtendedKeyCode()==SAVE_GRAPH_IMAGE_KEY_CODE&&event.isAltDown()==SAVE_GRAPH_IMAGE_ALT_REQUIRED&&event.isAltGraphDown()==SAVE_GRAPH_IMAGE_ALT_GRAPH_REQUIRED&&event.isControlDown()==SAVE_GRAPH_IMAGE_CTRL_REQUIRED&&event.isShiftDown()==SAVE_GRAPH_IMAGE_SHIFT_REQUIRED){
            if(saveJpeg){
                try {
                    ChartUtilities.saveChartAsJPEG(new File(csvFile.getName()+".jpeg"), jFreeChart, fullscreenDimension.width, fullscreenDimension.height);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(savePng){
                try {
                    ChartUtilities.saveChartAsPNG(new File(csvFile.getName()+".png"), jFreeChart, fullscreenDimension.width, fullscreenDimension.height);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

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
}