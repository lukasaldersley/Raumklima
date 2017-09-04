package Raumklima;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
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
import java.io.OutputStreamWriter;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
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
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleEdge;

import com.fazecast.jSerialComm.SerialPort;

//TODO concat CSV-files
//TODO arduino Config

/* 
 * *JPanel*.setLayout(new BoxLayout(*JPanel*, BoxLayout.Y_AXIS));
 * 
 * *JPanel* steht für eine Instanz eines beliebigen JPanel
 * https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/BoxLayoutDemoProject/src/layout/BoxLayoutDemo.java
 */

public class Raumklima implements ActionListener,WindowListener,WindowStateListener,ChartMouseListener,ComponentListener,KeyListener, MouseListener
{
    public boolean debug=false;
    public static String branch="master";//V1 and V1.5 are Options
    public static String projectUri="https://raw.githubusercontent.com/lukasaldersley/Raumklima/";

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
    public static int NUMBER_OF_COPYRIGHT_NOTES=24;
    public static int NUMBER_OF_CONFIG_ENTRIES=83;

    public static final double VERSION=1.6;
    public static final double BUILD=1.0;

    private boolean allowKeyComboChange=false;
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
    private boolean bottomPanelExpandedOnStartup=true;
    private boolean fullscreenOnStartup=false;
    private boolean looping = true;
    private boolean keyCombinationsEnabled=true;
    private boolean[] seriesVisible;

    private BufferedReader br;

    private BufferedWriter bw;
    private BufferedWriter portWriter;

    private ButtonGroup FullscreenOptionsButtonGroup;
    private ButtonGroup UpdateOptionsButtonGroup;

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

    private FileOutputStream fileOutputStream;

    private GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

    private Image logo;

    private int changeKeyCode;
    private int counter=0;
    private int dataPanelX=0;
    private int dataPanelY;
    private int numberOfGraphs;
    private int titleNumber=1;
    private int width;
    private int height;
    private int currentlyEditedKeyCombinationNumber;

    private JButton changeKeyComboButton;
    private JButton saveKeyComboButton;
    private JButton helpWindowCloseButton;
    private JButton importButton;
    private JButton UpdateNow;
    private JButton[] KeyComboChangeButton;

    private JCheckBox jpegCheckBox;
    private JCheckBox pngCheckBox;
    private JCheckBox dataPanelOnStartup;
    private JCheckBox fullscreenOnStartupComboBox;
    private JCheckBox FiletypePngCheckBox;
    private JCheckBox FiletypeJpgCheckBox;

    private JComboBox<String> comboBox;

    private JFileChooser fileChooser;

    private JFreeChart jFreeChart;

    private JFrame setNewKeyCombinationWindow;
    private JFrame fileChooserWindow;
    private JFrame helpWindow;
    private JFrame mainWindow;
    private JFrame settingsWindow;

    private JLabel KeyComboPanelTitle;
    private JLabel pleaseWaitMessageText;
    private JLabel[] configureKeyComboText;
    private JLabel[] copyrightNotes;
    private JLabel[] dataLabels;
    private JLabel[] helpWindowText;
    private JLabel[] settingsWindowText;
    private XYSeries[] xYSeries;

    private JMenu fileMenu;
    private JMenu openHelpWindowMenu;
    private JMenu openSettingsWindowMenu;
    private JMenu toggleFullscreenModeMenu;
    private JMenu saveGraphImagesMenu;

    private JMenuBar mainWindowMenuBar;

    private JMenuItem closeWindowMenuItem;
    private JMenuItem openDifferentPlotMenuItem;
    private JMenuItem openNewWindowMenuItem;

    private JPanel dataPanel;
    private JPanel helpPanel;
    private JPanel KeyComboSettingsFramePanel;
    private JPanel pleaseWaitMessagePanel;
    private JPanel GeneralSettings;
    private JPanel GraphSettings;
    private JPanel KeyComboSettings;
    private JPanel FileTypePanel;
    private JPanel FullscreenOptionsPanel;
    private JPanel FullscreenOptionsButtonGroupPanel;
    private JPanel UpdateOptionsPanel;
    private JPanel UpdateOptionsButtonGroupPanel;
    private JPanel[] dataPanels;
    private JPanel[] KeyComboSettingsEntryPanel;

    private JProgressBar progress;

    private JRadioButton MaximizeWindowRadioButton;
    private JRadioButton FullscreenExclusiveRadioButton;
    private JRadioButton AutoUpdateRadioButton;
    private JRadioButton ManualUpdateRadioButton;

    private JScrollPane helpWindowScrollPane;

    private JTabbedPane SettingsPageTabbedPane;

    private JTextField[] dataBoxes;
    private JTextField keyComboAusgabe;

    private Raumklima next;
    private Raumklima previous;

    private ReadableByteChannel readableByteChannelFromSource;

    private SerialPort port;
    private SerialPort[] ports;

    private String changeKeyChar;
    private String title="Raumklima-Auswertungssoftware";
    private String[] dataValueDescriptors;
    private String[] configRaw;
    private String[] setNewKeyCombinationTexts;

    private URL source;

    private XYSeriesCollection xYSeriesCollection;
	private int imageWidth;
	private int imageHeight;
	private JPanel FileSizePanel;
	private JTextField imageWidthBox;
	private JTextField imageHeightBox;
	private JCheckBox imageSizeAutoCheckBox;
	private boolean getImageSizeAutomatically;

    public static void main(String[] args){
        if(args.length==0){
            new Raumklima();
        }
        else{
            new Raumklima(args[0]);
        }
    }

    /**
     * the standard constructor (without the optional values of the second Constructor, which is only needed in order to make the numbering in the Title of the MainWindow work. This Constructor just calls the {@code setup()} Method.
     */
    public Raumklima(){
        setup(true,"");
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
        setup(true,"");
    }

    /**
     * this is only experimental (Definitely unfinished). 
     * This is an attempt to read data directly from the arduino. 
     * please ignore
     */
    public Raumklima(String fileName){
        mainWindow=new JFrame("Importieren");
        progress=new JProgressBar();
        progress.setMinimum(0);
        progress.setValue(0);

        ports= SerialPort.getCommPorts();

        comboBox=new JComboBox<String>();
        for(int i=0;i<ports.length;i++){
            comboBox.addItem(ports[i].getDescriptivePortName());
        }

        importButton=new JButton("Starte Import");
        importButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    port=ports[comboBox.getSelectedIndex()];
                    looping=false;
                }
            });
        mainWindow.setLayout(new GridLayout(0,1));
        mainWindow.add(comboBox);
        mainWindow.add(progress);
        mainWindow.add(importButton);
        mainWindow.pack();
        mainWindow.setVisible(true);
        mainWindow.setLocationRelativeTo(null);

        while(looping){}//warten
        csvFile=new File(fileName);
        try{
            port.openPort();
            port.setBaudRate(112500);
            portWriter=new BufferedWriter(new OutputStreamWriter(port.getOutputStream()));
            br=new BufferedReader(new InputStreamReader(port.getInputStream()));
            bw=new BufferedWriter(new FileWriter(csvFile));
            String zeile="";
            do{
                portWriter.write("READY");
                portWriter.flush();
                zeile=br.readLine();
                System.out.println(zeile);
            }
            while(!zeile.equals("OK"));
            int numberOfLines=Integer.parseInt(zeile.trim());
            progress.setMaximum(numberOfLines);
            for(int i=0;i<numberOfLines;i++){
                bw.write(br.read());
            }
            bw.flush();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        setup(false,fileName);
        System.gc();
    }

    /**
     * This Method does basically all the initialisation. It is called by all Constructors.
     * @param settingsWindowUpperLeftPanel 
     */
    private void setup(boolean usingFileChooser, String fileName){
        //check if the Configurationfile exists, if not download it
        configFile=new File("RaumklimaConfig.txt");
        if(!configFile.exists()){
            //https://stackoverflow.com/questions/921262/how-to-download-and-save-a-file-from-internet-using-java
            //(antwort von dfa und Attila)
            //how-to-download-and-save-a-file-from-internet-using-java.htm
            //1.9.17 20:58
            try{
                source = new URL(projectUri+branch+"/Release/RaumklimaConfig.txt");
                readableByteChannelFromSource = Channels.newChannel(source.openStream());
                fileOutputStream = new FileOutputStream("RaumklimaConfig.txt");
                fileOutputStream.getChannel().transferFrom(readableByteChannelFromSource, 0, Long.MAX_VALUE);
                fileOutputStream.close();
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
        pleaseWaitMessageText=new JLabel("Bitte Warten.");
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
        try {
            logo = ImageIO.read(new File("../Resources/Weather.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //read the ConfigurationFile
        loadConfigurationFile();

        //Initialise and setup FileChooser
        fileChooser=new JFileChooser();
        fileChooser.setDialogTitle("Bitte CSV-Datei auswählen");
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Aufgezeichnete Klimadaten (.csv/.CSV)","csv","CSV","Csv"));

        //setup the MainWindow
        mainWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        mainWindow.setIconImage(logo);
        mainWindow.setMinimumSize(new Dimension(WIDTH_OF_DATA_BLOCK,400));//mindestens 1 block der Textfelder MUSS draufpassen (370px)
        setTitle();

        mainWindow.setJMenuBar(createMainWindowMenuBar());
        try{
            setNewKeyCombinationTexts=new String[NUMBER_OF_KEY_COMBOS];
            JPanel auxiliaryPanel=new JPanel();
            auxiliaryPanel.setLayout(new BoxLayout(auxiliaryPanel,BoxLayout.Y_AXIS));
            setNewKeyCombinationWindow.setTitle("Tastenkombination ändern");
            setNewKeyCombinationWindow.setSize(new Dimension(540,470));
            setNewKeyCombinationWindow.setLocationRelativeTo(null);
            br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("configureKeyComboText.txt")));
            int anz=12;
            configureKeyComboText=new JLabel[anz];
            for(int i=0;i<anz;i++){
                configureKeyComboText[i]=new JLabel(br.readLine());
                auxiliaryPanel.add(configureKeyComboText[i]);
            }
            keyComboAusgabe=new JTextField();
            keyComboAusgabe.setEditable(false);
            //keyComboAusgabe.setFocusable(false);
            auxiliaryPanel.add(keyComboAusgabe);
            changeKeyComboButton=new JButton("Ändern");
            changeKeyComboButton.addActionListener(this);
            auxiliaryPanel.add(changeKeyComboButton);
            saveKeyComboButton=new JButton("Schließen");
            saveKeyComboButton.addActionListener(this);
            auxiliaryPanel.add(saveKeyComboButton);
            setNewKeyCombinationWindow.add(auxiliaryPanel);
            setNewKeyCombinationWindow.validate();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        //Setup the HeplpWindow
        helpWindowScrollPane=new JScrollPane();
        helpWindow.setSize(520,480);
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

        settingsWindowText=new JLabel[NUMBER_OF_KEY_COMBOS];
        KeyComboChangeButton=new JButton[NUMBER_OF_KEY_COMBOS];
        KeyComboSettingsEntryPanel=new JPanel[NUMBER_OF_KEY_COMBOS];

        //SettingsWindow
        settingsWindow.setSize(800,480);
        settingsWindow.setTitle("Einstellungen");
        settingsWindow.setLocationRelativeTo(null);
        KeyComboSettingsFramePanel=new JPanel();

        SettingsPageTabbedPane=new JTabbedPane();
        GeneralSettings=new JPanel(); //F11, Updates pr�fen, Update policy, Dateitypen 
        GraphSettings=new JPanel();  //sichtbarkeit, interplolation
        KeyComboSettings=new JPanel();  //keysändern

        GeneralSettings.setLayout(new BoxLayout(GeneralSettings, BoxLayout.Y_AXIS));

        FileTypePanel=new JPanel();
        FileTypePanel.setLayout(new BoxLayout(FileTypePanel, BoxLayout.Y_AXIS));
        FileTypePanel.add(new JLabel("Verwendete Dateitypen"));
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
				System.out.println("A");
	    		imageWidth=Integer.parseInt(imageWidthBox.getText());
	    		reloadBackend();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if(!imageWidthBox.getText().equals("")){
				System.out.println("B");
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
				System.out.println("A");
	    		imageHeight=Integer.parseInt(imageHeightBox.getText());
	    		reloadBackend();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if(!imageHeightBox.getText().equals("")){
				System.out.println("B");
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
        FileTypePanel.add(FileSizePanel);
        FileSizePanel.validate();
        FileTypePanel.add(new JLabel(" "));

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
        FullscreenOptionsPanel.add(FullscreenOptionsButtonGroupPanel);
        FullscreenOptionsPanel.add(new JLabel(" "));

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
        UpdateOptionsPanel.add(new JLabel("Update Optionen"));
        UpdateOptionsPanel.add(UpdateOptionsButtonGroupPanel);
        UpdateOptionsPanel.add(UpdateNow);
        UpdateOptionsPanel.add(new JLabel(" "));

        GeneralSettings.add(FileTypePanel);
        GeneralSettings.add(FullscreenOptionsPanel);
        GeneralSettings.add(UpdateOptionsPanel);

        KeyComboPanelTitle=new JLabel("Tastenkürzel:");
        KeyComboPanelTitle.setFont(new Font(Font.SERIF,Font.BOLD, 16));
        KeyComboSettingsFramePanel.setLayout(new GridLayout(0,1));
        KeyComboSettingsFramePanel.add(KeyComboPanelTitle);
        for(int i=0;i<NUMBER_OF_KEY_COMBOS;i++){
            KeyComboSettingsEntryPanel[i]=new JPanel(new BorderLayout());
            settingsWindowText[i]=new JLabel();
            settingsWindowText[i].setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
            KeyComboSettingsEntryPanel[i].add(settingsWindowText[i],BorderLayout.WEST);
            KeyComboChangeButton[i]=new JButton("Ändern");
            KeyComboChangeButton[i].setPreferredSize(new Dimension(100,25));
            KeyComboChangeButton[i].addActionListener(this);
            KeyComboSettingsEntryPanel[i].add(KeyComboChangeButton[i],BorderLayout.EAST);
            KeyComboSettingsFramePanel.add(KeyComboSettingsEntryPanel[i]);
        }
        loadTextForHelpWindowAndKeyCombinations();
        KeyComboSettings.add(KeyComboSettingsFramePanel);

        SettingsPageTabbedPane.addTab("Allgemeine Einstellungen",GeneralSettings);
        SettingsPageTabbedPane.addTab("Graphenbereich",GraphSettings);
        SettingsPageTabbedPane.addTab("Tastenkombinationen",KeyComboSettings);
        settingsWindow.add(SettingsPageTabbedPane);

        settingsWindow.validate();
        //validiere das hilfefenster nochmals 
        helpWindow.validate();

        //Validiere das hauptfenster nochmals
        mainWindow.validate();

        //get the data and draw the graph
        //proceed only if successful otherwise exit
        jFreeChart = createChart(createDataset(usingFileChooser,fileName));
        if(jFilePickerFailed==false){
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

            //Initialise the DataPanel
            dataPanelX=floor(fullscreenDimension.width/370);
            dataPanelY=roof((double)((double)numberOfGraphs/(double)dataPanelX));

            if(dataPanelX*dataPanelY<numberOfGraphs){
                //Something went TERRIBLY WRONG!!!!
                //HASN'T BEEN OBSERVED FOR A LONG TIME (a lot of options have been tested
                System.err.println("HELP: SPACIAL COLLISION OF numberOfGraphs and panelX/Y: "+numberOfGraphs+"|"+dataPanelX+"x"+dataPanelY);
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
        }
        else{
            exit();
        }
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
        saveGraphImagesMenu.addActionListener(this);
        mainWindowMenuBar.add(saveGraphImagesMenu);

        mainWindowMenuBar.addKeyListener(this);
        return mainWindowMenuBar;
    }

    public void loadConfigurationFile(){//read in the RaumklimaConfig.txt file, which holds the configuration
        configRaw=new String[NUMBER_OF_CONFIG_ENTRIES];
        try {
            br = new BufferedReader(new FileReader(configFile));
            for(int i=0;i<NUMBER_OF_CONFIG_ENTRIES;i++){
                configRaw[i]=br.readLine();
                if(debug){
                    System.out.println("CFG: "+configRaw[i]);
                }
            }
            //System.out.println(configRaw[9]);
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
     * Writes the Configuration (which is saved in a {@link String} Array in Memory) to a File on the local Storage
     */
    private void saveConfigurationFile(){
        if(debug){
            System.out.println("updating config");
        }
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

        if(debug){
            System.out.println("writing Config");
        }
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
            source = new URL(projectUri+branch+"/Release/VERSION");
            br=new  BufferedReader(new InputStreamReader(source.openStream()));
            if(Double.parseDouble(br.readLine().trim())>VERSION){
                return true;
            }
            else{
            	source=new URL(projectUri+branch+"/Release/BUILD");
            	br=new  BufferedReader(new InputStreamReader(source.openStream()));
                if(Double.parseDouble(br.readLine().trim())>VERSION){
                    return true;
                }
                else{
                return false;
                }
            }
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
            oldFile=new File("Raumklima.jar");
            oldFile.delete();
            //fileUrl: "https://raw.githubusercontent.com/lukasaldersley/Raumklima/master/Release/VERSION"
            source = new URL(projectUri+"raw/"+branch+"/Release/Raumklima.jar");
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

    private String getYesNoString(boolean in){
        if(in){
            return "YES";
        }
        return "NO";
    }

    private void loadTextForHelpWindowAndKeyCombinations() {
        try{

            String line="";
            for(int i=0;i<NUMBER_OF_KEY_COMBOS;i++){
                helpWindowText[i]=new JLabel();
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
            toggleFullscreenModeMenu.setText("Vollbildmodus ("+helpWindowText[8].getText()+")");

            br=new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("HelpTexts.txt")));
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

    private void refreshPage(){
        if(debug){
            System.out.println(mainWindow.getSize());
        }
        width=mainWindow.getWidth()-15;
        if(fullscreen&&fullscreenOk){
            height=mainWindow.getHeight()-(23+8);
        }
        else{
            height=mainWindow.getHeight()-(53+8);
        }
        windowDimension=new Dimension(width,height);
        if(debug){
            System.out.println(windowDimension);
        }
        dataPanelX=floor((double)(windowDimension.getWidth()/(double)(WIDTH_OF_DATA_BLOCK)));
        dataPanelY=roof(numberOfGraphs/(double)(dataPanelX));
        dataPanel.setLayout(new GridLayout(dataPanelY,dataPanelX));
        if(debug){
            System.out.println(numberOfGraphs+" | "+dataPanelX+"x"+dataPanelY);
        }
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
        if(debug){
            System.out.println(topPanelDimension);
        }
        if(debug){
            System.out.println(bottomPanelDimension);
        }
        if(debug){
            System.out.println();
        }
        mainWindow.validate();
    }

    private void deactivateFullscreen(){
        if(fullscreenOk){
            graphicsDevice.setFullScreenWindow(null);
        }
        else{
            mainWindow.setExtendedState(JFrame.NORMAL);
        }
        fullscreen=false;
        refreshPage();
        saveConfigurationFile();
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
        saveConfigurationFile();
    }

    private void avtivateFullscreen(){
        if(fullscreenOk){
            graphicsDevice.setFullScreenWindow(mainWindow);
        }
        else{
            mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        fullscreen=true;
        refreshPage();
        saveConfigurationFile();
    }

    private int showOpenDialog(){
        return fileChooser.showOpenDialog(fileChooserWindow);
    }

    private JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYLineChart(null,"Zeit (s)","Werte",xYDataset);
        return jFreeChart;
    }

    @SuppressWarnings("rawtypes")
    private XYDataset createDataset(boolean doShowOpenDialog,String fileName) {
        xYSeriesCollection = new XYSeriesCollection();
        if(doShowOpenDialog){
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
        }
        else{
            csvFile=new File(fileName);
        }

        try{
            String line=br.readLine();
            dataValueDescriptors=line.split(";");

            numberOfGraphs=dataValueDescriptors.length;

            xYSeries=new XYSeries[numberOfGraphs];
            seriesVisible=new boolean[numberOfGraphs];
            //TODO

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
                    try{
                        zwsp[i]=Double.parseDouble(zwso[i]);
                        xYSeries[i].add(counter,zwsp[i]);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                        if(debug){
                            System.out.println(i);
                        }
                    }
                }
                //counter+=2;
                counter++;
                //br.readLine();
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
        setNewKeyCombinationWindow.dispose();
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
            if(seriesVisible[i]){
                int nInt=0;
                for(int j=0;j<i;j++){
                    if(seriesVisible[i]){
                        nInt++;
                    }
                }
                if(debug){
                    System.out.println(i+"=>"+nInt);
                }
                double d2 = DatasetUtilities.findYValue((XYDataset)xYPlot.getDataset(), (int)nInt, (double)d);
                dataBoxes[i].setText(String.valueOf(d2));
            }
            else
            {
                dataBoxes[i].setText("N/A");
            }
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
        for(int i=0;i<numberOfGraphs;i++)
        {
            if(debug){
                System.out.println(seriesVisible[i]);
            }
        }
        for (int i = 0; i < numberOfGraphs; ++i) {
            if(seriesVisible[i]){
                int nInt=0;
                for(int j=0;j<i;j++){
                    if(seriesVisible[j]){
                        nInt++;
                    }
                }
                if(debug){
                    System.out.println(i+"=>"+nInt);
                }
                double d2 = DatasetUtilities.findYValue((XYDataset)xYPlot.getDataset(), (int)nInt, (double)d);
                yCrosshairs[i].setValue(d2);
            }
        }
    }

    private void makeHelpWindowVisible(){
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
    	System.out.println("EVENT FIRED");
    	if(event.getSource()==imageSizeAutoCheckBox){
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
            setNewKeyCombinationWindow.setVisible(false);

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
        if(event.getSource()==openDifferentPlotMenuItem){
            openNewPlot();
        }
        if(event.getSource()==openNewWindowMenuItem){
            openNewWindow();
        }
        if(event.getSource()==closeWindowMenuItem){
            closeWindow();
        }
        if(event.getSource()==saveGraphImagesMenu){
            saveImages();
        }
        if(event.getSource()==helpWindowCloseButton){
            helpWindow.setVisible(false);
        }
        if(event.getSource()==jpegCheckBox){
            if(pngCheckBox.isSelected()){
                savePng=true;
            }
            else{
                savePng=false;
            }
        }
        if(event.getSource()==jpegCheckBox){
            if(jpegCheckBox.isSelected()){
                saveJpeg=true;
            }
            else{
                saveJpeg=false;
            }
            saveConfigurationFile();
        }
        if(event.getSource()==fullscreenOnStartupComboBox){
            if(fullscreenOnStartupComboBox.isSelected()){
                fullscreenOnStartup=true;
            }
            else{
                fullscreenOnStartup=true;
            }
            saveConfigurationFile();
        }
        if(event.getSource()==dataPanelOnStartup){
            if(dataPanelOnStartup.isSelected()){
                bottomPanelExpandedOnStartup=true;
            }
            else{
                bottomPanelExpandedOnStartup=true;
            }
            saveConfigurationFile();
        }
        if(event.getSource()==AutoUpdateRadioButton){
            autoUpdate=AutoUpdateRadioButton.isSelected();
        }
        if(event.getSource()==ManualUpdateRadioButton){
            autoUpdate=AutoUpdateRadioButton.isSelected();
        }
        if(event.getSource()==FullscreenExclusiveRadioButton){
            fullscreenOk=FullscreenExclusiveRadioButton.isSelected();
        }
        if(event.getSource()==MaximizeWindowRadioButton){
            fullscreenOk=FullscreenExclusiveRadioButton.isSelected();
        }
        for(int i=0;i<NUMBER_OF_KEY_COMBOS;i++){
            if(event.getSource()==KeyComboChangeButton[i]){
                openSetNewKeyCombinationWindow(i);
            }
        }
        reloadBackend();
    }

    private void reloadBackend(){
        saveConfigurationFile();
        loadConfigurationFile();
        loadTextForHelpWindowAndKeyCombinations();
    }

    private void openSetNewKeyCombinationWindow(int input) {
    	keyCombinationsEnabled=false;
        configureKeyComboText[5].setText(configureKeyComboText[5].getText()+setNewKeyCombinationTexts[input]);
        setNewKeyCombinationWindow.setVisible(true);
        currentlyEditedKeyCombinationNumber=input;
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
    }

    /**
     * This Method handles the Key Events for changing the KeyCombos
     */
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
            if(debug){
                System.out.print(event.getKeyChar());
            }
            if(debug){
                System.out.println(":"+event.getExtendedKeyCode()+":"+getKeyStringFromKeyCode(event.getExtendedKeyCode()));
            }
            changeKeyCode=event.getExtendedKeyCode();
        }
    }

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
     * This method handles the Key Events for the various KeyCombos
     */
    @Override
    public void keyPressed(KeyEvent event) {
    	System.out.println("KeyText (extended): "+KeyEvent.getKeyText(event.getExtendedKeyCode())+"    KeyText: "+KeyEvent.getKeyText(event.getKeyCode())+"    KeyString (eigenbau&&extended): "+getKeyStringFromKeyCode(event.getExtendedKeyCode())+"    KeyString(eigenbau): "+getKeyStringFromKeyCode(event.getKeyCode()));
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

    private void saveImages() {
        if(saveJpeg){
            try {
                ChartUtilities.saveChartAsJPEG(new File(csvFile.getName()+".jpeg"), jFreeChart, imageWidth, imageHeight);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(savePng){
            try {
                ChartUtilities.saveChartAsPNG(new File(csvFile.getName()+".png"), jFreeChart, imageWidth, imageHeight);
            } catch (IOException e) {
                e.printStackTrace();
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