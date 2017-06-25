package Raumklima;
//TODO config wieder schreiben nachdem irgendeiner der werte ge�ndert wurde
//TODO concat CSV-files
//TODO arduino Config
//TODO updater
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
public class Raumklima implements ActionListener,WindowListener,WindowStateListener,ChartMouseListener,ComponentListener,KeyListener, MouseListener
{
    public static boolean CWAR=false;
    public static boolean OHAR=false;
    public static boolean ONPAR=false;
    public static boolean ONWAR=false;
    public static boolean OSAR=false;
    public static boolean RFAR=false;
    public static boolean SGIAR=false;
    public static boolean TBPVAR=false;
    public static boolean TFMAR=false;

    public static boolean CWAGR=false;
    public static boolean OHAGR=false;
    public static boolean ONPAGR=false;
    public static boolean ONWAGR=false;
    public static boolean OSAGR=false;
    public static boolean RFAGR=false;
    public static boolean SGIAGR=false;
    public static boolean TBPVAGR=false;
    public static boolean TFMAGR=false;

    public static boolean CWCR=true;
    public static boolean OHCR=false;
    public static boolean ONPCR=true;
    public static boolean ONWCR=true;
    public static boolean OSCR=true;
    public static boolean RFCR=false;
    public static boolean SGICR=true;
    public static boolean TBPVCR=true;
    public static boolean TFMCR=false;

    public static boolean CWSR=false;
    public static boolean OHSR=false;
    public static boolean ONPSR=false;
    public static boolean ONWSR=false;
    public static boolean OSSR=false;
    public static boolean RFSR=false;
    public static boolean SGISR=false;
    public static boolean TBPVSR=false;
    public static boolean TFMSR=false;

    public static int CLOSW_WINDOW_KEY_CODE=87;//W
    public static int OHKEY_CODE=112;//F1
    public static int ONPKEY_CODE=79;//O
    public static int ONWKEY_CODE=78;//N
    public static int OSKEY_CODE=73;//I
    public static int RFKEY_CODE=116;//F5
    public static int SGIKEY_CODE=83;
    public static int TBPV_KEY_CODE=69;//E
    public static int TFM_KEY_CODE=122;//F11

    public static int HEIGHT_OF_DATA_BLOCK=25;
    public static int WIDTH_OF_DATA_BLOCK=370;
    public static int NUMBER_OF_KEY_COMBOS=9;
    public static int NUMBER_OF_COPYRIGHT_NOTES;
    public static int NUMBER_OF_CONFIG_ENTRIES=83;

    public static String CWKEY_STRING="W";
    public static String OHKEY_STRING="F1";
    public static String ONPKEY_STRING="O";
    public static String ONWKEY_STRING="N";
    public static String OSKEY_STRING="I";
    public static String RFKEY_STRING="F5";
    public static String SGIKEY_STRING="S";
    public static String TBPV_KEY_STRING = "E";
    public static String TFM_KEY_STRING="F11";

    public static final int VERSION=0;

    private boolean bottomPanelExpanded=false;
    private boolean jFilePickerFailed=false;
    private boolean fullscreen=false;

    private JButton helpWindowCloseButton;
    private JButton[] rightPanelButtons;

    private BufferedReader br;

    private ChartPanel chartPanel;

    private Crosshair xCrosshair;
    private Crosshair[] yCrosshairs;

    private Dimension fullscreenDimension;
    private Dimension windowedTopPanelDimension;

    private File csvFile;

    private GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

    private Image logo;

    private int counter=0;
    private int dataPanelX=0;
    private int dataPanelY;
    private int numberOfGraphs;
    private int titleNumber=1;

    private JCheckBox jpegCheckBox;
    private JCheckBox pngCheckBox;

    private JFileChooser fileChooser;

    private JFrame configureKeyComboWindow;
    private JFrame fileChooserWindow;
    private JFrame helpWindow;
    private JFrame mainWindow;
    private JFrame settingsWindow;

    private JLabel leftPanelTitle;
    private JLabel rightPanelTitle;
    private JLabel waitText;
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

    private Raumklima next;
    private Raumklima previous;

    private String title="Raumklima-Auswertungssoftware";
    private String[] dataValueDescriptors;
    private String[] configRaw;
    private boolean savePng;
    private boolean saveJpeg;
    private JFreeChart jFreeChart;
    private JLabel[] configureKeyComboText;
    private JTextField keyComboAusgabe;
    private JButton changeKeyComboButton;
    private JButton saveKeyComboButton;
    private String[] keyComboText;
    private boolean changeAltDown;
    private boolean changeAltGrDown;
    private boolean changeCtrlDown;
    private boolean changeShiftDown;
    private String changeKeyChar;
    private int changeKeyCode;

    public Raumklima(){
        setup();
    }

    public Raumklima(int newTitleNumber, Raumklima newPrevious, Raumklima newNext) {
        titleNumber=newTitleNumber;
        previous=newPrevious;
        next=newNext;
        setup();
    }

    private void setup(){//Initialise JFrames
        fileChooserWindow=new JFrame();
        settingsWindow=new JFrame();
        helpWindow=new JFrame();
        mainWindow=new JFrame();

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
        fullscreenDimension=new Dimension(graphicsDevice.getDisplayMode().getWidth(),graphicsDevice.getDisplayMode().getHeight()-30);
        windowedTopPanelDimension=new Dimension(graphicsDevice.getDisplayMode().getWidth(),graphicsDevice.getDisplayMode().getHeight()-30);
        try {
            logo = ImageIO.read(new File("../Resources/Weather.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("config.txt")));
        configRaw=new String[NUMBER_OF_CONFIG_ENTRIES];
        try{
            for(int i=0;i<NUMBER_OF_CONFIG_ENTRIES;i++){
                configRaw[i]=br.readLine();
            }
            CLOSW_WINDOW_KEY_CODE=Integer.parseInt(configRaw[9]);
            CWKEY_STRING=configRaw[10];
            OHKEY_CODE=Integer.parseInt(configRaw[16]);
            OHKEY_STRING=configRaw[17];
            ONPKEY_CODE=Integer.parseInt(configRaw[23]);
            ONPKEY_STRING=configRaw[24];
            ONWKEY_CODE=Integer.parseInt(configRaw[30]);
            ONWKEY_STRING=configRaw[31];
            OSKEY_CODE=Integer.parseInt(configRaw[37]);
            OSKEY_STRING=configRaw[38];
            RFKEY_CODE=Integer.parseInt(configRaw[44]);
            RFKEY_STRING=configRaw[45];
            SGIKEY_CODE=Integer.parseInt(configRaw[51]);
            SGIKEY_STRING=configRaw[52];
            TBPV_KEY_CODE=Integer.parseInt(configRaw[58]);
            TBPV_KEY_STRING=configRaw[59];
            TFM_KEY_CODE=Integer.parseInt(configRaw[65]);
            TFM_KEY_STRING=configRaw[66];

            CWAR=configRaw[11].equals("YES");
            CWAGR=configRaw[12].equals("YES");
            CWCR=configRaw[13].equals("YES");
            CWSR=configRaw[14].equals("YES");

            OHAR=configRaw[18].equals("YES");
            OHAGR=configRaw[19].equals("YES");
            OHCR=configRaw[20].equals("YES");
            OHSR=configRaw[21].equals("YES");

            ONPAR=configRaw[25].equals("YES");
            ONPAGR=configRaw[26].equals("YES");
            ONPCR=configRaw[27].equals("YES");
            ONPSR=configRaw[28].equals("YES");

            ONWAR=configRaw[32].equals("YES");
            ONWAGR=configRaw[33].equals("YES");
            ONWCR=configRaw[34].equals("YES");
            ONWSR=configRaw[35].equals("YES");

            OSAR=configRaw[39].equals("YES");
            OSAGR=configRaw[40].equals("YES");
            OSCR=configRaw[41].equals("YES");
            OSSR=configRaw[42].equals("YES");

            RFAR=configRaw[46].equals("YES");
            RFAGR=configRaw[47].equals("YES");
            RFCR=configRaw[48].equals("YES");
            RFSR=configRaw[49].equals("YES");

            SGIAR=configRaw[53].equals("YES");
            SGIAGR=configRaw[54].equals("YES");
            SGICR=configRaw[55].equals("YES");
            SGISR=configRaw[56].equals("YES");

            TBPVAR=configRaw[60].equals("YES");
            TBPVAGR=configRaw[61].equals("YES");
            TBPVCR=configRaw[62].equals("YES");
            TBPVSR=configRaw[63].equals("YES");

            TFMAR=configRaw[67].equals("YES");
            TFMAGR=configRaw[68].equals("YES");
            TFMCR=configRaw[69].equals("YES");
            TFMSR=configRaw[70].equals("YES");

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
        fileChooser.setDialogTitle("Bitte CSV-Datei ausw?hlen");
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Aufgezeichnete Klimadaten (.csv/.CSV)","csv","CSV"));

        //Initialise and fill the MenuBar on the MainWindow
        mainWindowMenuBar=new JMenuBar();

        fileMenu=new JMenu("Datei");
        openDifferentPlotMenuItem=new JMenuItem("Datei �ffnen (Strg+"+ONPKEY_STRING+")");
        openDifferentPlotMenuItem.addActionListener(this);
        fileMenu.add(openDifferentPlotMenuItem);
        openNewWindowMenuItem=new JMenuItem("neues Fenster �ffnen (Strg+"+ONWKEY_STRING+")");
        openNewWindowMenuItem.addActionListener(this);
        fileMenu.add(openNewWindowMenuItem);
        closeWindowMenuItem=new JMenuItem("Fenster schlie�en (Strg+"+CWKEY_STRING+")");
        closeWindowMenuItem.addActionListener(this);
        fileMenu.add(closeWindowMenuItem);

        mainWindowMenuBar.add(fileMenu);

        openSettingsWindowMenu=new JMenu("Einstellungen (Strg+"+OSKEY_STRING+")");
        openSettingsWindowMenu.addMouseListener(this);
        mainWindowMenuBar.add(openSettingsWindowMenu);

        toggleFullscreenModeMenu=new JMenu("Vollbildmodus ("+TFM_KEY_STRING+")");
        toggleFullscreenModeMenu.addMouseListener(this);
        mainWindowMenuBar.add(toggleFullscreenModeMenu);
        mainWindow.setJMenuBar(mainWindowMenuBar);

        openHelpWindowMenu=new JMenu("Hilfe ("+OHKEY_STRING+")");
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

        //Setup the HeplpPage
        keyComboText=new String[NUMBER_OF_KEY_COMBOS];
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

        helpWindow.validate();
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

        //keyComboWindow
        //beim Textfeld 5 wird noch der name der zu ändernden tastenkombi eingef�gt
        try{
            configureKeyComboWindow=new JFrame();
            configureKeyComboWindow.setLayout(new GridLayout(0,1));
            configureKeyComboWindow.setTitle("Tastenkombination ändern");
            configureKeyComboWindow.setSize(new Dimension(540,470));
            configureKeyComboWindow.setLocationRelativeTo(null);
            br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("configureKeyComboText.txt")));
            int anz=Integer.parseInt(br.readLine());
            configureKeyComboText=new JLabel[anz];
            for(int i=0;i<anz;i++){
                configureKeyComboText[i]=new JLabel(br.readLine());
                configureKeyComboWindow.add(configureKeyComboText[i]);
            }
            keyComboAusgabe=new JTextField();
            keyComboAusgabe.setEditable(false);
            keyComboAusgabe.setFocusable(false);
            configureKeyComboWindow.add(keyComboAusgabe);
            changeKeyComboButton=new JButton("Ändern");
            changeKeyComboButton.addActionListener(this);
            configureKeyComboWindow.add(changeKeyComboButton);
            saveKeyComboButton=new JButton("Schließen");
            saveKeyComboButton.addActionListener(this);
            configureKeyComboWindow.add(saveKeyComboButton);
        }
        catch(Exception e){
            e.printStackTrace();
        }

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

            for(int i=0;i<numberOfGraphs;i++){
                dataLabels[i]=new JLabel(dataValueDescriptors[i]);
                dataBoxes[i]=new JTextField();
                dataPanel.add(dataLabels[i]);
                dataPanel.add(dataBoxes[i]);
            }

            //Remove the temporary WaitPanel
            mainWindow.remove(waitPanel);

            mainWindow.add(chartPanel,BorderLayout.NORTH);
            mainWindow.add(dataPanel,BorderLayout.SOUTH);

            if(bottomPanelExpanded){
                fullscreenDimension.setSize(fullscreenDimension.width,(graphicsDevice.getDisplayMode().getHeight()-30)-HEIGHT_OF_DATA_BLOCK*dataPanelY);
            }
            else{
                ;//remains the same
            }

            //make the program able to react by adding the ActionListeners
            mainWindow.addKeyListener(this);
            mainWindow.addComponentListener(this);
            mainWindow.addWindowStateListener(this);
            mainWindow.addWindowListener(this);
            chartPanel.addChartMouseListener(this);

            //finalise the mainWindow and revert the Cursor Back To Normal
            mainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            mainWindow.setCursor(Cursor.getDefaultCursor());
            if(fullscreen){
                fullscreen=!fullscreen;//damit das program den Vollbildmodus korrekterweise einschaltet
                //und nicht glaubt dass der Vollbildmodus schon an war und ihn deaktiviert
                //siehe oben beim config-lesenn und in der Config datei.
                toggleFullscreen();
            }
            if(!bottomPanelExpanded){
                toggleBottomPanel();
            }
            chartPanel.getPopupMenu().remove(3);//den punkt speichern zum speichern des aktuellen Chartinhalts entfernen, da es sonst probleme mit dem vollbildmodus gibt wenn jemand darauf klickt.
        }
        else{
            exit();
        }
    }

    private void readInTextsForKeyCombos() {
        br=new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("HelpTexts.txt")));
        try{

            String line="";
            for(int i=0;i<NUMBER_OF_KEY_COMBOS;i++){
                settingsWindowRightInnerPanel[i]=new JPanel(new BorderLayout());
                line=br.readLine();
                keyComboText[i]=line;
                line +=": ";
                helpWindowText[i]=new JLabel(line);
                helpWindowText[i].setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
                helpPanel.add(helpWindowText[i]);
            }
            //add Copyright notice
            br=new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("CopyrightNotes.txt")));
            try{
                NUMBER_OF_COPYRIGHT_NOTES=Integer.parseInt(br.readLine());
                copyrightNotes=new JLabel[NUMBER_OF_COPYRIGHT_NOTES];
                for(int i=0;i<NUMBER_OF_COPYRIGHT_NOTES;i++){
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
            if(CWAR){
                helpWindowText[0].setText(helpWindowText[0].getText()+"Alt+");
            }
            if(CWAGR){
                helpWindowText[0].setText(helpWindowText[0].getText()+"AltGr+");
            }
            if(CWCR){
                helpWindowText[0].setText(helpWindowText[0].getText()+"Strg+");
            }
            if(CWSR){
                helpWindowText[0].setText(helpWindowText[0].getText()+"Shift+");
            }
            if(OHAR){
                helpWindowText[1].setText(helpWindowText[1].getText()+"Alt+");
            }
            if(OHAGR){
                helpWindowText[1].setText(helpWindowText[1].getText()+"AltGr+");
            }
            if(OHCR){
                helpWindowText[1].setText(helpWindowText[1].getText()+"Strg+");
            }
            if(OHSR){
                helpWindowText[1].setText(helpWindowText[1].getText()+"Shift+");
            }
            if(ONPAR){
                helpWindowText[2].setText(helpWindowText[2].getText()+"Alt+");
            }
            if(ONPAGR){
                helpWindowText[2].setText(helpWindowText[2].getText()+"AltGr+");
            }
            if(ONPCR){
                helpWindowText[2].setText(helpWindowText[2].getText()+"Strg+");
            }
            if(ONPSR){
                helpWindowText[2].setText(helpWindowText[2].getText()+"Shift+");
            }
            if(ONWAR){
                helpWindowText[3].setText(helpWindowText[3].getText()+"Alt+");
            }
            if(ONWAGR){
                helpWindowText[3].setText(helpWindowText[3].getText()+"AltGr+");
            }
            if(ONWCR){
                helpWindowText[3].setText(helpWindowText[3].getText()+"Strg+");
            }
            if(ONWSR){
                helpWindowText[3].setText(helpWindowText[3].getText()+"Shift+");
            }
            if(OSAR){
                helpWindowText[4].setText(helpWindowText[4].getText()+"Alt+");
            }
            if(OSAGR){
                helpWindowText[4].setText(helpWindowText[4].getText()+"AltGr+");
            }
            if(OSCR){
                helpWindowText[4].setText(helpWindowText[4].getText()+"Strg+");
            }
            if(OSSR){
                helpWindowText[4].setText(helpWindowText[4].getText()+"Shift+");
            }
            if(RFAR){
                helpWindowText[5].setText(helpWindowText[5].getText()+"Alt+");
            }
            if(RFAGR){
                helpWindowText[5].setText(helpWindowText[5].getText()+"AltGr+");
            }
            if(RFCR){
                helpWindowText[5].setText(helpWindowText[5].getText()+"Strg+");
            }
            if(RFSR){
                helpWindowText[5].setText(helpWindowText[5].getText()+"Shift+");
            }
            if(SGIAR){
                helpWindowText[6].setText(helpWindowText[6].getText()+"Alt+");
            }
            if(SGIAGR){
                helpWindowText[6].setText(helpWindowText[6].getText()+"AltGr+");
            }
            if(SGICR){
                helpWindowText[6].setText(helpWindowText[6].getText()+"Strg+");
            }
            if(SGISR){
                helpWindowText[6].setText(helpWindowText[6].getText()+"Shift+");
            }
            if(TBPVAR){
                helpWindowText[7].setText(helpWindowText[7].getText()+"Alt+");
            }
            if(TBPVAGR){
                helpWindowText[7].setText(helpWindowText[7].getText()+"AltGr+");
            }
            if(TBPVCR){
                helpWindowText[7].setText(helpWindowText[7].getText()+"Strg+");
            }
            if(TBPVSR){
                helpWindowText[7].setText(helpWindowText[7].getText()+"Shift+");
            }
            if(TFMAR){
                helpWindowText[8].setText(helpWindowText[8].getText()+"Alt+");
            }
            if(TFMAGR){
                helpWindowText[8].setText(helpWindowText[8].getText()+"AltGr+");
            }
            if(TFMCR){
                helpWindowText[8].setText(helpWindowText[8].getText()+"Strg+");
            }
            if(TFMSR){
                helpWindowText[8].setText(helpWindowText[8].getText()+"Shift+");
            }
            helpWindowText[1].setText(helpWindowText[1].getText()+OHKEY_STRING);
            helpWindowText[0].setText(helpWindowText[0].getText()+CWKEY_STRING);
            helpWindowText[2].setText(helpWindowText[2].getText()+ONPKEY_STRING);
            helpWindowText[3].setText(helpWindowText[3].getText()+ONWKEY_STRING);
            helpWindowText[4].setText(helpWindowText[4].getText()+OSKEY_STRING);
            helpWindowText[5].setText(helpWindowText[5].getText()+RFKEY_STRING);
            helpWindowText[6].setText(helpWindowText[6].getText()+SGIKEY_STRING);
            helpWindowText[7].setText(helpWindowText[7].getText()+TBPV_KEY_STRING);
            helpWindowText[8].setText(helpWindowText[8].getText()+TFM_KEY_STRING);
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
        if( ((int)(in))-in==0.00000000){
            return (int)in;
        }
        else{
            return (int)in+1;
        }
    }

    private void toggleFullscreen(){
        if(fullscreen){//if fullscreenMode is already enabled, disable it
            deactivateFullscreen();
        }
        else{//the fullscreenMode is disabled, so enable it
            avtivateFullscreen();
        }
    }

    //TODO layout Überdenken
    private void refreshPage(){
        dataPanelX=floor(mainWindow.getWidth()/370);
        dataPanelY=roof((double)((double)numberOfGraphs/(double)dataPanelX));
        if(dataPanelX*dataPanelY<numberOfGraphs){//Something went terribly WRONG!!!!
            System.out.println("HELP SPACIAL COLLISION OF numberOfGraphs and panelX/Y: "+numberOfGraphs+"|"+dataPanelX+"x"+dataPanelY);
        }

        dataPanel.setLayout(new GridLayout(dataPanelY,dataPanelX*2));
        if(bottomPanelExpanded){
            windowedTopPanelDimension.setSize(mainWindow.getWidth(),(mainWindow.getHeight()-30)-HEIGHT_OF_DATA_BLOCK*dataPanelY);
        }
        else{
            windowedTopPanelDimension.setSize(mainWindow.getWidth(),mainWindow.getHeight()-30);
        }

        chartPanel.setPreferredSize(windowedTopPanelDimension);

        chartPanel.setVisible(false);
        if(bottomPanelExpanded){
            dataPanel.setVisible(false);
            dataPanel.setVisible(true);
        }
        chartPanel.setVisible(true);
        mainWindow.validate();
    }

    private void deactivateFullscreen(){
        graphicsDevice.setFullScreenWindow(null);
        fullscreen=false;
        refreshPage();
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
    }

    private void avtivateFullscreen(){
        graphicsDevice.setFullScreenWindow(mainWindow);
        fullscreen=true;
        refreshPage();
    }

    private int showOpenDialog(){
        return fileChooser.showOpenDialog(fileChooserWindow);
    }

    private JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYLineChart(null,"Zeit","Werte",xYDataset);
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
        //mainWindow.setFocusable(settingsWindow.isVisible());
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
            configureKeyComboWindow.addKeyListener(this);
            keyComboAusgabe.setText("Bereit");
        }
        if(event.getSource()==saveKeyComboButton){
            configureKeyComboWindow.removeKeyListener(this);
            mainWindow.addKeyListener(this);
            configureKeyComboWindow.setVisible(false);
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
        }
        for(int i=0;i<NUMBER_OF_KEY_COMBOS;i++){
            if(event.getSource()==rightPanelButtons[i]){
                openEditCeyComboWindow(i);
            }
        }
    }

    private void openEditCeyComboWindow(int in) {
        mainWindow.removeKeyListener(this);
        configureKeyComboText[5].setText(configureKeyComboText[5].getText()+keyComboText[in]);
        configureKeyComboWindow.setVisible(true);
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
        if(configureKeyComboWindow.isVisible()){
            System.out.println("KeyReleased");
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
            keyComboAusgabe.setText(keyComboAusgabe.getText()+event.getKeyChar());
            changeKeyChar=String.valueOf(event.getKeyChar());
            changeKeyCode=event.getExtendedKeyCode();
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

    //jedesmal wenn eine taste gedr�ckt wird pr�fen ob alle bedingungen erf�llt sind
    @Override
    public void keyPressed(KeyEvent event) {
        if(event.getExtendedKeyCode()==TFM_KEY_CODE&&event.isAltDown()==TFMAR&&event.isAltGraphDown()==TFMAGR&&event.isControlDown()==TFMCR&&event.isShiftDown()==TFMSR){
            toggleFullscreen();
        }
        if(event.getExtendedKeyCode()==RFKEY_CODE&&event.isAltDown()==RFAR&&event.isAltGraphDown()==RFAGR&&event.isControlDown()==RFCR&&event.isShiftDown()==RFSR){
            refreshPage();
        }
        if(event.getExtendedKeyCode()==OHKEY_CODE&&event.isAltDown()==OHAR&&event.isAltGraphDown()==OHAGR&&event.isControlDown()==OHCR&&event.isShiftDown()==OHSR){
            deactivateFullscreen();
            toggleHelpWindow();
        }
        if(event.getExtendedKeyCode()==ONPKEY_CODE&&event.isAltDown()==ONPAR&&event.isAltGraphDown()==ONPAGR&&event.isControlDown()==ONPCR&&event.isShiftDown()==ONPSR){
            deactivateFullscreen();
            openNewPlot();
        }
        if(event.getExtendedKeyCode()==ONWKEY_CODE&&event.isAltDown()==ONWAR&&event.isAltGraphDown()==ONWAGR&&event.isControlDown()==ONWCR&&event.isShiftDown()==ONWSR){
            deactivateFullscreen();
            openNewWindow();
        }
        if(event.getExtendedKeyCode()==CLOSW_WINDOW_KEY_CODE&&event.isAltDown()==CWAR&&event.isAltGraphDown()==CWAGR&&event.isControlDown()==CWCR&&event.isShiftDown()==CWSR){
            deactivateFullscreen();
            closeWindow();
        }
        if(event.getExtendedKeyCode()==TBPV_KEY_CODE&&event.isAltDown()==TBPVAR&&event.isAltGraphDown()==TBPVAGR&&event.isControlDown()==TBPVCR&&event.isShiftDown()==TBPVSR){
            toggleBottomPanel();
        }
        if(event.getExtendedKeyCode()==OSKEY_CODE&&event.isAltDown()==OSAR&&event.isAltGraphDown()==OSAGR&&event.isControlDown()==OSCR&&event.isShiftDown()==OSSR){
            deactivateFullscreen();
            toggleSettingsWindow();
        }
        if(event.getExtendedKeyCode()==SGIKEY_CODE&&event.isAltDown()==SGIAR&&event.isAltGraphDown()==SGIAGR&&event.isControlDown()==SGICR&&event.isShiftDown()==SGISR){
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
}