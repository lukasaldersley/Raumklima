package CSV_PLOTTER;

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
import java.awt.Image;
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
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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

//TODO concat CSV-files
//TODO arduino Config

/* 
 * *JPanel*.setLayout(new BoxLayout(*JPanel*, BoxLayout.Y_AXIS));
 * 
 * *JPanel* steht für eine Instanz eines beliebigen JPanel
 * https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/BoxLayoutDemoProject/src/layout/BoxLayoutDemo.java
 */

public class CSV_PLOTTER implements ActionListener,WindowListener,WindowStateListener,ChartMouseListener,ComponentListener,KeyListener, MouseListener, FocusListener
{

    


    private ButtonGroup FullscreenOptionsButtonGroup;
    private ButtonGroup UpdateOptionsButtonGroup;

    private ChartPanel chartPanel;

    private Crosshair xCrosshair;
    private Crosshair[] yCrosshairs;

    private CrosshairOverlay crosshairOverlay;


    private GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();


    private static File csvFile;
    private int changeKeyCode;
    private int counter=0;
    private int dataPanelX=0;
    private int dataPanelY;
    private int numberOfGraphs;
    private int titleNumber=1;
    private int width;
    private int height;
    private int currentlyEditedKeyCombinationNumber;

    private JButton changeKeyCombinationButton;
    private JButton saveKeyCombinationButton;
    private JButton helpWindowCloseButton;
    private JButton UpdateNow;
    private JButton[] KeyCombinationChangeButton;

    private JCheckBox jpegCheckBox;
    private JCheckBox pngCheckBox;
    private JCheckBox dataPanelOnStartup;
    private JCheckBox fullscreenOnStartupComboBox;
    private JCheckBox FiletypePngCheckBox;
    private JCheckBox FiletypeJpgCheckBox;

    //private JComboBox<String> comboBox;

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
    private JPanel[] dataPanels;
    private JPanel[] KeyCombinationSettingsEntryPanel;

    private JRadioButton MaximizeWindowRadioButton;
    private JRadioButton FullscreenExclusiveRadioButton;
    private JRadioButton AutoUpdateRadioButton;
    private JRadioButton ManualUpdateRadioButton;

    private JScrollPane helpWindowScrollPane;

    private JTabbedPane SettingsPageTabbedPane;

    private JTextField[] dataBoxes;
    private JTextField keyComboAusgabe;

    private CSV_PLOTTER next;
    private CSV_PLOTTER previous;


    private String changeKeyChar;
    private String title="CSV_PLOTTER-Auswertungssoftware";
    private String[] dataValueDescriptors;
    private String[] setNewKeyCombinationTexts;


    private XYSeries[] xYSeries;

    private XYSeriesCollection xYSeriesCollection;
    private JPanel FileSizePanel;
    private JTextField imageWidthBox;
    private JTextField imageHeightBox;
    private JCheckBox imageSizeAutoCheckBox;
    private JPanel selectVisibleGraphsPanel;
    private JScrollPane selectVisibleGraphsScrollPane;
    private JCheckBox[] selectGraphVisibilityCheckBox;
    private boolean[] graphIsVisible;
    private JPanel visibilitySettings;
    private JPanel interpolationSettings;
    private JRadioButton interpolate1x;
    private JRadioButton interpolate4x;
    private JRadioButton interpolate10x;
    private JRadioButton interpolate100x;
    private JRadioButton interpolate1000x;
    private JRadioButton interpolateCustom;
    private ButtonGroup interpolateButtonGroup;
    private JPanel interpolateCustomPanel;
    private JTextField interpolateCustomInputBox;
	private JPanel interpolationSettingsBasePanel;

    public static void main(String[] args){
        //if(args.length==0){
        new CSV_PLOTTER();
        /*}
        else{
        new CSV_PLOTTER(args[0]);
        }*/
    }

    /**
     * the standard constructor (without the optional values of the second Constructor, which is only needed in order to make the numbering in the Title of the MainWindow work. This Constructor just calls the {@code setup()} Method.
     */
    public CSV_PLOTTER(){
        setup(true,"");
    }

    /**
     * the Secondary Constructor, which includes the "advanced" features (for the numbering scheme). This Constructor just calls the {@code setup()} Method.
     * @param newTitleNumber the number that should be displayed in the Titlebar on the MainWindow
     * @param newPrevious the preceding instance of CSV_PLOTTER (only used to update the numbering scheme if a window is closed or opened)
     * @param newNext the following instance of CSV_PLOTTER (only used to update the numbering scheme if a window is closed or opened)
     */
    public CSV_PLOTTER(int newTitleNumber, CSV_PLOTTER newPrevious, CSV_PLOTTER newNext) {
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
    	try {
			Runtime.getRuntime().exec("explorer");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        FILES.initConfig();

        FILES.update();

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
STATE.fullscreenDimension=new Dimension(graphicsDevice.getDisplayMode().getWidth(),graphicsDevice.getDisplayMode().getHeight());

        //setup the logo
        
        URL url=getClass().getResource("Resources/Weather.png");
        if(STATE.debug){
        System.out.println(url);
        }
      mainWindow.setIconImage(new ImageIcon(url).getImage());
      //https://stackoverflow.com/questions/9864267/loading-image-resource/9866659#9866659 antwort von icza

        //read the ConfigurationFile
        FILES.loadConfigurationFile();

        //Initialise and setup FileChooser
        fileChooser=new JFileChooser();
        fileChooser.setDialogTitle("Bitte CSV-Datei auswählen");
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Aufgezeichnete Klimadaten (.csv/.CSV)","csv","CSV","Csv"));

        //setup the MainWindow
        mainWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        mainWindow.setMinimumSize(new Dimension(STATE.WIDTH_OF_DATA_BLOCK,400));//mindestens 1 block der Textfelder MUSS draufpassen (370px)
        setTitle();

        //Validiere das hauptfenster nochmals
        mainWindow.validate();

        //get the data and draw the graph
        //proceed only if successful otherwise exit
        jFreeChart = createChart(createDataset(usingFileChooser,fileName));
        if(STATE.jFilePickerFailed==false){
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
            if(STATE.fullscreenOnStartup){
            	STATE.fullscreen=false;
                toggleFullscreen();
            }
            //if the mottomPanel should be made invisible on startup, do it here
            if(STATE.bottomPanelExpandedOnStartup){
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

    private void setupDataPanel() {
        //Initialise the DataPanel
        dataPanelX=floor(STATE.fullscreenDimension.width/370);
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
            dataPanels[i].setPreferredSize(new Dimension(STATE.WIDTH_OF_DATA_BLOCK,STATE.HEIGHT_OF_DATA_BLOCK));
            dataLabels[i]=new JLabel(dataValueDescriptors[i]);
            dataBoxes[i]=new JTextField();
            dataPanels[i].add(dataLabels[i]);
            dataPanels[i].add(dataBoxes[i]);
            dataPanel.add(dataPanels[i]);
        }
    }

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

    private void setupChangeKeyCombinationHelperWindow() {
        try{
            setNewKeyCombinationTexts=new String[STATE.NUMBER_OF_KEY_COMBOS];
            JPanel auxiliaryPanel=new JPanel();
            auxiliaryPanel.setLayout(new BoxLayout(auxiliaryPanel,BoxLayout.Y_AXIS));
            setNewKeyCombinationWindow.setTitle("Tastenkombination ändern");
            setNewKeyCombinationWindow.setSize(new Dimension(540,470));
            setNewKeyCombinationWindow.setLocationRelativeTo(null);
            FILES.br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("configureKeyComboText.txt")));
            int anz=12;
            configureKeyCombinationText=new JLabel[anz];
            for(int i=0;i<anz;i++){
                configureKeyCombinationText[i]=new JLabel(FILES.br.readLine());
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

    private void setupSettingsWindow(){
        settingsWindowText=new JLabel[STATE.NUMBER_OF_KEY_COMBOS];
        KeyCombinationChangeButton=new JButton[STATE.NUMBER_OF_KEY_COMBOS];
        KeyCombinationSettingsEntryPanel=new JPanel[STATE.NUMBER_OF_KEY_COMBOS];

        //SettingsWindow
        settingsWindow.setSize(800,480);
        settingsWindow.setTitle("Einstellungen");
        settingsWindow.setLocationRelativeTo(null);
        KeyCombinationSettingsFramePanel=new JPanel();

        SettingsPageTabbedPane=new JTabbedPane();
        GeneralSettings=new JPanel(); //F11, Updates pr�fen, Update policy, Dateitypen 
        GraphSettings=new JPanel();  //sichtbarkeit, interplolation
        KeyCombinationSettings=new JPanel();  //keysändern

        GeneralSettings.setLayout(new BoxLayout(GeneralSettings, BoxLayout.Y_AXIS));

        FileTypePanel=new JPanel();
        FileTypePanel.setLayout(new BoxLayout(FileTypePanel, BoxLayout.Y_AXIS));
        FileTypePanel.add(new JLabel("Verwendete Dateitypen"));
        FiletypePngCheckBox=new JCheckBox("PNG");
        FiletypePngCheckBox.setSelected(STATE.savePng);
        FiletypePngCheckBox.addActionListener(this);
        FiletypeJpgCheckBox=new JCheckBox("JPG");
        FiletypeJpgCheckBox.setSelected(STATE.saveJpeg);
        FiletypeJpgCheckBox.addActionListener(this);
        FileTypePanel.add(FiletypePngCheckBox);
        FileTypePanel.add(FiletypeJpgCheckBox);
        FileSizePanel=new JPanel();
        FileSizePanel.setLayout(new BoxLayout(FileSizePanel,BoxLayout.X_AXIS));
        imageWidthBox=new JTextField();
        imageWidthBox.setText(String.valueOf(STATE.imageWidth));
        imageWidthBox.setMinimumSize(new Dimension(50,23));
        imageWidthBox.setMaximumSize(new Dimension(50,23));
        imageWidthBox.getDocument().addDocumentListener(new DocumentListener(){

                @Override
                public void changedUpdate(DocumentEvent e) {}

                @Override
                public void insertUpdate(DocumentEvent e) {
                    System.out.println("A");
                    STATE.imageWidth=Integer.parseInt(imageWidthBox.getText());
                    reloadBackend();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    if(!imageWidthBox.getText().equals("")){
                        System.out.println("B");
                        STATE.imageWidth=Integer.parseInt(imageWidthBox.getText());
                        reloadBackend();
                    }
                }

            });
        imageHeightBox=new JTextField();
        imageHeightBox.setText(String.valueOf(STATE.imageHeight));
        imageHeightBox.setMinimumSize(new Dimension(50,23));
        imageHeightBox.setMaximumSize(new Dimension(50,23));
        imageHeightBox.getDocument().addDocumentListener(new DocumentListener(){

                @Override
                public void changedUpdate(DocumentEvent e) {}

                @Override
                public void insertUpdate(DocumentEvent e) {
                    System.out.println("A");
                    STATE.imageHeight=Integer.parseInt(imageHeightBox.getText());
                    reloadBackend();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    if(!imageHeightBox.getText().equals("")){
                        System.out.println("B");
                        STATE.imageHeight=Integer.parseInt(imageHeightBox.getText());
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
        if(STATE.getImageSizeAutomatically){
            imageHeightBox.setEnabled(false);
            imageWidthBox.setEnabled(false);
            imageSizeAutoCheckBox.setSelected(true);
        }
        FileSizePanel.setAlignmentX(Component.LEFT_ALIGNMENT);//TODO HALP
        FileTypePanel.add(FileSizePanel);
        FileSizePanel.validate();
        FileTypePanel.add(new JLabel(" "));
        FileTypePanel.setAlignmentX(Component.LEFT_ALIGNMENT);//TODO HALP

        FullscreenOptionsPanel=new JPanel();
        FullscreenOptionsPanel.setLayout(new BoxLayout(FullscreenOptionsPanel, BoxLayout.Y_AXIS));
        FullscreenOptionsButtonGroup=new ButtonGroup();
        MaximizeWindowRadioButton=new JRadioButton("Fenster Maximieren");
        FullscreenExclusiveRadioButton=new JRadioButton("Vollbildmodus (Nicht verfügbar auf Computern mit Intel-Grafik)");
        FullscreenOptionsButtonGroup.add(MaximizeWindowRadioButton);
        FullscreenOptionsButtonGroup.add(FullscreenExclusiveRadioButton);
        MaximizeWindowRadioButton.setSelected(!STATE.fullscreenOk);
        FullscreenExclusiveRadioButton.setSelected(STATE.fullscreenOk);
        MaximizeWindowRadioButton.addActionListener(this);
        FullscreenExclusiveRadioButton.addActionListener(this);
        FullscreenOptionsPanel.add(new JLabel("Vollbildmodus"));
        FullscreenOptionsButtonGroupPanel=new JPanel();
        FullscreenOptionsButtonGroupPanel.setLayout(new BoxLayout(FullscreenOptionsButtonGroupPanel, BoxLayout.Y_AXIS));
        FullscreenOptionsButtonGroupPanel.add(MaximizeWindowRadioButton);
        FullscreenOptionsButtonGroupPanel.add(FullscreenExclusiveRadioButton);
        FullscreenOptionsButtonGroupPanel.setAlignmentX(Component.LEFT_ALIGNMENT);//TODO HALP
        FullscreenOptionsPanel.add(FullscreenOptionsButtonGroupPanel);
        FullscreenOptionsPanel.add(new JLabel(" "));
        FullscreenOptionsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);//TODO HALP

        UpdateOptionsPanel=new JPanel();
        UpdateOptionsPanel.setLayout(new BoxLayout(UpdateOptionsPanel, BoxLayout.Y_AXIS));
        UpdateOptionsButtonGroup=new ButtonGroup();
        AutoUpdateRadioButton=new JRadioButton("Automatisch beim Start prüfen");
        ManualUpdateRadioButton=new JRadioButton("Nur Manuell");
        UpdateOptionsButtonGroup.add(AutoUpdateRadioButton);
        UpdateOptionsButtonGroup.add(ManualUpdateRadioButton);
        AutoUpdateRadioButton.setSelected(STATE.autoUpdate);
        ManualUpdateRadioButton.setSelected(!STATE.autoUpdate);
        UpdateNow=new JButton("Jetzt auf Updates prüfen");
        UpdateNow.addActionListener(this);
        AutoUpdateRadioButton.addActionListener(this);
        ManualUpdateRadioButton.addActionListener(this);
        UpdateOptionsButtonGroupPanel=new JPanel();
        UpdateOptionsButtonGroupPanel.setLayout(new BoxLayout(UpdateOptionsButtonGroupPanel, BoxLayout.Y_AXIS));
        UpdateOptionsButtonGroupPanel.add(AutoUpdateRadioButton);
        UpdateOptionsButtonGroupPanel.add(ManualUpdateRadioButton);
        UpdateOptionsButtonGroupPanel.setAlignmentX(Component.LEFT_ALIGNMENT);//TODO HALP
        UpdateOptionsPanel.add(new JLabel("Update Optionen"));
        UpdateOptionsPanel.add(UpdateOptionsButtonGroupPanel);
        UpdateOptionsPanel.add(UpdateNow);
        UpdateOptionsPanel.add(new JLabel(" "));
        UpdateOptionsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);//TODO HALP

        GeneralSettings.add(FileTypePanel);
        GeneralSettings.add(FullscreenOptionsPanel);
        GeneralSettings.add(UpdateOptionsPanel);

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
        selectVisibleGraphsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);//TODO HALP
        selectVisibleGraphsScrollPane=new JScrollPane(selectVisibleGraphsPanel);
        selectVisibleGraphsScrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);//TODO HALP
        visibilitySettings.add(selectVisibleGraphsScrollPane);
        GraphSettings.setLayout(new BoxLayout(GraphSettings,BoxLayout.X_AXIS));
        GraphSettings.add(visibilitySettings);

        interpolationSettingsBasePanel=new JPanel();
        //interpolationSettingsBasePanel.setBackground(Color.YELLOW);
        interpolationSettings=new JPanel();
        //interpolationSettings.setBackground(Color.GREEN);
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
        //interpolateCustomPanel.setBackground(Color.RED);
        interpolateCustomPanel.setLayout(new BoxLayout(interpolateCustomPanel,BoxLayout.X_AXIS));
        interpolateCustom=new JRadioButton("Benutzerdefiniert");
        interpolateCustomInputBox=new JTextField();
        interpolateCustomInputBox.addFocusListener(this);
        interpolateCustomInputBox.setMinimumSize(new Dimension(60,23));
        interpolateCustomInputBox.setMaximumSize(new Dimension(60,23));
        interpolateCustomInputBox.getDocument().addDocumentListener(new DocumentListener(){

                @Override
                public void changedUpdate(DocumentEvent arg0) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void insertUpdate(DocumentEvent arg0) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void removeUpdate(DocumentEvent arg0) {
                    // TODO Auto-generated method stub

                }

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
        interpolate1x.addActionListener(this);
        interpolate4x.addActionListener(this);
        interpolate10x.addActionListener(this);
        interpolate100x.addActionListener(this);
        interpolate1000x.addActionListener(this);
        interpolateCustom.addActionListener(this);
        interpolationSettings.add(interpolate1x);
        interpolationSettings.add(interpolate4x);
        interpolationSettings.add(interpolate10x);
        interpolationSettings.add(interpolate100x);
        interpolationSettings.add(interpolate1000x);
        interpolationSettings.add(interpolateCustom);
        //interpolationSettings.add(interpolateCustomPanel);
        interpolationSettings.setAlignmentX(Component.RIGHT_ALIGNMENT);
        interpolateCustomPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        interpolationSettingsBasePanel.setLayout(new BoxLayout(interpolationSettingsBasePanel,BoxLayout.Y_AXIS));
        interpolationSettingsBasePanel.setMaximumSize(new Dimension(200,480));
        interpolationSettingsBasePanel.add(interpolationSettings,BorderLayout.NORTH);
        interpolationSettingsBasePanel.add(interpolateCustomPanel,BorderLayout.SOUTH);
		GraphSettings.add(interpolationSettingsBasePanel);

        KeyCombinationPanelTitle=new JLabel("Tastenkürzel:");
        KeyCombinationPanelTitle.setFont(new Font(Font.SERIF,Font.BOLD, 16));
        KeyCombinationSettingsFramePanel.setLayout(new GridLayout(0,1));
        KeyCombinationSettingsFramePanel.add(KeyCombinationPanelTitle);
        for(int i=0;i<STATE.NUMBER_OF_KEY_COMBOS;i++){
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

        SettingsPageTabbedPane.addTab("Allgemeine Einstellungen",GeneralSettings);
        SettingsPageTabbedPane.addTab("Graphenbereich",GraphSettings);
        SettingsPageTabbedPane.addTab("Tastenkombinationen",KeyCombinationSettings);
        settingsWindow.add(SettingsPageTabbedPane);
    }

    private void setupHelpWindow(){
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

        helpWindowText=new JLabel[STATE.NUMBER_OF_KEY_COMBOS];
    }

    private JMenuBar createMainWindowMenuBar() {
        //Initialise and fill the MenuBar on the MainWindow
        mainWindowMenuBar=new JMenuBar();

        fileMenu=new JMenu("Datei");
        openDifferentPlotMenuItem=new JMenuItem("Datei öffnen (Strg+"+STATE.OPEN_NEW_PLOT_KEY_STRING+")");
        openDifferentPlotMenuItem.addActionListener(this);
        fileMenu.add(openDifferentPlotMenuItem);
        openNewWindowMenuItem=new JMenuItem("neues Fenster öffnen (Strg+"+STATE.OPEN_NEW_WINDOW_KEY_STRING+")");
        openNewWindowMenuItem.addActionListener(this);
        fileMenu.add(openNewWindowMenuItem);
        closeWindowMenuItem=new JMenuItem("Fenster schließen (Strg+"+STATE.CLOSE_WINDOW_KEY_STRING+")");
        closeWindowMenuItem.addActionListener(this);
        fileMenu.add(closeWindowMenuItem);

        mainWindowMenuBar.add(fileMenu);

        openSettingsWindowMenu=new JMenu("Einstellungen (Strg+"+STATE.OPEN_SETTINGS_WINDOW_KEY_STRING+")");
        openSettingsWindowMenu.addMouseListener(this);
        mainWindowMenuBar.add(openSettingsWindowMenu);

        toggleFullscreenModeMenu=new JMenu("Vollbildmodus ("+STATE.TOGGLE_FULLSCREEN_MODE_KEY_STRING+")");
        toggleFullscreenModeMenu.addMouseListener(this);
        mainWindowMenuBar.add(toggleFullscreenModeMenu);

        openHelpWindowMenu=new JMenu("Hilfe ("+STATE.OPEN_HELP_WINDOW_KEY_STRING+")");
        openHelpWindowMenu.addMouseListener(this);
        mainWindowMenuBar.add(openHelpWindowMenu);

        saveGraphImagesMenu=new JMenu("Graphen speichern (Strg+"+STATE.SAVE_GRAPH_IMAGE_KEY_STRING+")");
        saveGraphImagesMenu.addActionListener(this);
        mainWindowMenuBar.add(saveGraphImagesMenu);

        mainWindowMenuBar.addKeyListener(this);
        return mainWindowMenuBar;
    }

    

    private void loadTextForHelpWindowAndKeyCombinations() {
        try{

            String line="";
            for(int i=0;i<STATE.NUMBER_OF_KEY_COMBOS;i++){
                helpWindowText[i]=new JLabel();
                helpWindowText[i].setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
                helpPanel.add(helpWindowText[i]);
            }
            //add Copyright notice
            FILES.br=new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("CopyrightNotes.txt")));
            try{
                copyrightNotes=new JLabel[STATE.NUMBER_OF_COPYRIGHT_NOTES+3];
                copyrightNotes[0]=new JLabel(" ");
                helpPanel.add(copyrightNotes[0]);
                copyrightNotes[1]=new JLabel(" ");
                helpPanel.add(copyrightNotes[1]);
                copyrightNotes[2]=new JLabel("Version: "+FILES.VERSION);
                helpPanel.add(copyrightNotes[2]);
                for(int i=3;i<STATE.NUMBER_OF_COPYRIGHT_NOTES+3;i++){
                    line=FILES.br.readLine();
                    copyrightNotes[i]=new JLabel(line);
                    helpPanel.add(copyrightNotes[i]);
                }
            }
            catch(Exception e){
                e.printStackTrace();
                JLabel error=new JLabel("Ein Fehler ist aufgetreten und diese Seite konnte nicht geladen werden. Bitte laden Sie das Programm neu.");
                helpPanel.add(error);
            }
            if(STATE.CLOSE_WINDOW_ALT_REQUIRED){
                helpWindowText[0].setText(helpWindowText[0].getText()+"Alt+");
            }
            if(STATE.CLOSE_WINDOW_CTRL_REQUIRED){
                helpWindowText[0].setText(helpWindowText[0].getText()+"Strg+");
            }
            if(STATE.CLOSE_WINDOW_SHIFT_REQUIRED){
                helpWindowText[0].setText(helpWindowText[0].getText()+"Shift+");
            }
            if(STATE.OPEN_HELP_WINDOW_ALT_REQUIRED){
                helpWindowText[1].setText(helpWindowText[1].getText()+"Alt+");
            }
            if(STATE.OPEN_HELP_WINDOW_CTRL_REQUIRED){
                helpWindowText[1].setText(helpWindowText[1].getText()+"Strg+");
            }
            if(STATE.OPEN_HELP_WINDOW_SHIFT_REQUIRED){
                helpWindowText[1].setText(helpWindowText[1].getText()+"Shift+");
            }
            if(STATE.OPEN_NEW_PLOT_ALT_REQUIRED){
                helpWindowText[2].setText(helpWindowText[2].getText()+"Alt+");
            }
            if(STATE.OPEN_NEW_PLOT_CTRL_REQUIRED){
                helpWindowText[2].setText(helpWindowText[2].getText()+"Strg+");
            }
            if(STATE.OPEN_NEW_PLOT_SHIFT_REQUIRED){
                helpWindowText[2].setText(helpWindowText[2].getText()+"Shift+");
            }
            if(STATE.OPEN_NEW_WINDOW_ALT_REQUIRED){
                helpWindowText[3].setText(helpWindowText[3].getText()+"Alt+");
            }
            if(STATE.OPEN_NEW_WINDOW_CTRL_REQUIRED){
                helpWindowText[3].setText(helpWindowText[3].getText()+"Strg+");
            }
            if(STATE.OPEN_NEW_WINDOW_SHIFT_REQUIRED){
                helpWindowText[3].setText(helpWindowText[3].getText()+"Shift+");
            }
            if(STATE.OPEN_SETTINGS_WINDOW_ALT_REQUIRED){
                helpWindowText[4].setText(helpWindowText[4].getText()+"Alt+");
            }
            if(STATE.OPEN_SETTINGS_WINDOW_CTRL_REQUIRED){
                helpWindowText[4].setText(helpWindowText[4].getText()+"Strg+");
            }
            if(STATE.OPEN_SETTINGS_WINDOW_SHIFT_REQUIRED){
                helpWindowText[4].setText(helpWindowText[4].getText()+"Shift+");
            }
            if(STATE.REFRESH_FRAME_ALT_REQUIRED){
                helpWindowText[5].setText(helpWindowText[5].getText()+"Alt+");
            }
            if(STATE.REFRESH_FRAME_CTRL_REQUIRED){
                helpWindowText[5].setText(helpWindowText[5].getText()+"Strg+");
            }
            if(STATE.REFRESH_FRAME_SHIFT_REQUIRED){
                helpWindowText[5].setText(helpWindowText[5].getText()+"Shift+");
            }
            if(STATE.SAVE_GRAPH_IMAGE_ALT_REQUIRED){
                helpWindowText[6].setText(helpWindowText[6].getText()+"Alt+");
            }
            if(STATE.SAVE_GRAPH_IMAGE_CTRL_REQUIRED){
                helpWindowText[6].setText(helpWindowText[6].getText()+"Strg+");
            }
            if(STATE.SAVE_GRAPH_IMAGE_SHIFT_REQUIRED){
                helpWindowText[6].setText(helpWindowText[6].getText()+"Shift+");
            }
            if(STATE.TOGGLE_BOTTOM_PANEL_VISIBILITY_ALT_REQUIRED){
                helpWindowText[7].setText(helpWindowText[7].getText()+"Alt+");
            }
            if(STATE.TOGGLE_BOTTOM_PANEL_VISIBILITY_CTRL_REQUIRED){
                helpWindowText[7].setText(helpWindowText[7].getText()+"Strg+");
            }
            if(STATE.TOGGLE_BOTTOM_PANEL_VISIBILITY_SHIFT_REQUIRED){
                helpWindowText[7].setText(helpWindowText[7].getText()+"Shift+");
            }
            if(STATE.TOGGLE_FULLSCREEN_MODE_ALT_REQUIRED){
                helpWindowText[8].setText(helpWindowText[8].getText()+"Alt+");
            }
            if(STATE.TOGGLE_FULLSCREEN_MODE_CTRL_REQUIRED){
                helpWindowText[8].setText(helpWindowText[8].getText()+"Strg+");
            }
            if(STATE.TOGGLE_FULLSCREEN_MODE_SHIFT_REQUIRED){
                helpWindowText[8].setText(helpWindowText[8].getText()+"Shift+");
            }
            helpWindowText[0].setText(helpWindowText[0].getText()+STATE.CLOSE_WINDOW_KEY_STRING);
            helpWindowText[1].setText(helpWindowText[1].getText()+STATE.OPEN_HELP_WINDOW_KEY_STRING);
            helpWindowText[2].setText(helpWindowText[2].getText()+STATE.OPEN_NEW_PLOT_KEY_STRING);
            helpWindowText[3].setText(helpWindowText[3].getText()+STATE.OPEN_NEW_WINDOW_KEY_STRING);
            helpWindowText[4].setText(helpWindowText[4].getText()+STATE.OPEN_SETTINGS_WINDOW_KEY_STRING);
            helpWindowText[5].setText(helpWindowText[5].getText()+STATE.REFRESH_FRAME_KEY_STRING);
            helpWindowText[6].setText(helpWindowText[6].getText()+STATE.SAVE_GRAPH_IMAGE_KEY_STRING);
            helpWindowText[7].setText(helpWindowText[7].getText()+STATE.TOGGLE_BOTTOM_PANEL_VISIBILITY_KEY_STRING);
            helpWindowText[8].setText(helpWindowText[8].getText()+STATE.TOGGLE_FULLSCREEN_MODE_KEY_STRING);

            closeWindowMenuItem.setText("Fenster schließen ("+helpWindowText[0].getText()+")");
            openHelpWindowMenu.setText("Hilfe ("+helpWindowText[1].getText()+")");
            openDifferentPlotMenuItem.setText("Datei öffnen ("+helpWindowText[2].getText()+")");
            openNewWindowMenuItem.setText("neues Fenster öffnen ("+helpWindowText[3].getText()+")");
            openSettingsWindowMenu.setText("Einstellungen ("+helpWindowText[4].getText()+")");
            saveGraphImagesMenu.setText("Graphen speichern ("+helpWindowText[6].getText()+")");
            toggleFullscreenModeMenu.setText("Vollbildmodus ("+helpWindowText[8].getText()+")");

            FILES.br=new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("HelpTexts.txt")));
            for(int i=0;i<STATE.NUMBER_OF_KEY_COMBOS;i++){
                line=FILES.br.readLine();
                setNewKeyCombinationTexts[i]=line;
                line +=": ";
                helpWindowText[i].setText(line+helpWindowText[i].getText());
                for(int j=helpWindowText[i].getText().length();j<60;j++){
                    helpWindowText[i].setText(helpWindowText[i].getText()+" ");
                }
            }
            for(int i=0;i<STATE.NUMBER_OF_KEY_COMBOS;i++){
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

        if(STATE.fullscreen){//if fullscreenMode is already enabled, disable it
            deactivateFullscreen();
        }
        else{//the fullscreenMode is disabled, so enable it
            avtivateFullscreen();
        }
        mainWindow.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    private void refreshPage(){
        if(STATE.debug){
            System.out.println(mainWindow.getSize());
        }
        width=mainWindow.getWidth()-15;
        if(STATE.fullscreen&&STATE.fullscreenOk){
            height=mainWindow.getHeight()-(23+8);
        }
        else{
            height=mainWindow.getHeight()-(53+8);
        }
        STATE.windowDimension=new Dimension(width,height);
        if(STATE.debug){
            System.out.println(STATE.windowDimension);
        }
        dataPanelX=floor((double)(STATE.windowDimension.getWidth()/(double)(STATE.WIDTH_OF_DATA_BLOCK)));
        dataPanelY=roof(numberOfGraphs/(double)(dataPanelX));
        dataPanel.setLayout(new GridLayout(dataPanelY,dataPanelX));
        if(STATE.debug){
            System.out.println(numberOfGraphs+" | "+dataPanelX+"x"+dataPanelY);
        }
        STATE.bottomPanelDimension=new Dimension(width,dataPanelY*STATE.HEIGHT_OF_DATA_BLOCK);
        if(STATE.bottomPanelExpanded){
        	STATE.topPanelDimension=new Dimension(width,height-(dataPanelY*STATE.HEIGHT_OF_DATA_BLOCK));
            dataPanel.setVisible(true);
        }
        else{
        	STATE.topPanelDimension=new Dimension(width,height);
            dataPanel.setVisible(false);
        }
        dataPanel.setPreferredSize(STATE.bottomPanelDimension);
        chartPanel.setPreferredSize(STATE.topPanelDimension);
        if(STATE.debug){
            System.out.println(STATE.topPanelDimension);
        }
        if(STATE.debug){
            System.out.println(STATE.bottomPanelDimension);
        }
        if(STATE.debug){
            System.out.println();
        }
        mainWindow.validate();
    }

    private void deactivateFullscreen(){
        if(STATE.fullscreenOk){
            graphicsDevice.setFullScreenWindow(null);
        }
        else{
            mainWindow.setExtendedState(JFrame.NORMAL);
        }
        STATE.fullscreen=false;
        refreshPage();
        FILES.saveConfigurationFile();
    }

    private void toggleBottomPanel(){
        if(STATE.bottomPanelExpanded){
        	STATE.bottomPanelExpanded=false;
            dataPanel.setVisible(false);
        }
        else{
        	STATE.bottomPanelExpanded=true;
            dataPanel.setVisible(true);
        }
        refreshPage();
        FILES.saveConfigurationFile();
    }

    private void avtivateFullscreen(){
        if(STATE.fullscreenOk){
            graphicsDevice.setFullScreenWindow(mainWindow);
        }
        else{
            mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        STATE.fullscreen=true;
        refreshPage();
        FILES.saveConfigurationFile();
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
                    FILES.br=new BufferedReader(new FileReader(csvFile));
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
            else{
            	STATE.jFilePickerFailed=true;
                return xYSeriesCollection;
            }
        }
        else{
            csvFile=new File(fileName);
        }

        try{
            String line=FILES.br.readLine();
            dataValueDescriptors=line.split(";");

            numberOfGraphs=dataValueDescriptors.length;

            xYSeries=new XYSeries[numberOfGraphs];
            graphIsVisible=new boolean[numberOfGraphs];

            for (int i = 0; i < numberOfGraphs; ++i) {
                xYSeries[i] = new XYSeries((Comparable)((Object)(dataValueDescriptors[i])));
                graphIsVisible[i]=true;
            }

            line=FILES.br.readLine();
            for(int x=0;x<STATE.interpolationOffset;x++){
            	line=FILES.br.readLine();
            }
            while(line!=null||line!=""){
                for(int i=0;i<STATE.interpolationFactor-1;i++){
                	line=FILES.br.readLine();
                }
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
                        if(STATE.debug){
                            System.out.println(i);
                        }
                    }
                }
                //counter+=2;
                counter++;
                //br.readLine();
                line=FILES.br.readLine();
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
        int correctedIndex=0;
        for (int i = 0; i < numberOfGraphs; ++i) {
            if(graphIsVisible[i]){
                double d2 = DatasetUtilities.findYValue((XYDataset)xYPlot.getDataset(), (int)correctedIndex, (double)d);
                dataBoxes[i].setText(String.valueOf(d2));
                correctedIndex++;
            }
            else{
                dataBoxes[i].setText("N/A (ausgeblendet)");
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
        int correctedIndex=0;
        for (int i = 0; i < numberOfGraphs; ++i) {
            if(graphIsVisible[i]){
                double d2 = DatasetUtilities.findYValue((XYDataset)xYPlot.getDataset(), (int)correctedIndex, (double)d);
                yCrosshairs[i].setValue(d2);
                correctedIndex++;
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
                imageWidthBox.setText(String.valueOf(STATE.fullscreenDimension.width));
                STATE.imageWidth=Integer.parseInt(imageWidthBox.getText());
                imageWidthBox.setEnabled(false);
                imageHeightBox.setText(String.valueOf(STATE.fullscreenDimension.height));
                STATE.imageHeight=Integer.parseInt(imageHeightBox.getText());
                imageHeightBox.setEnabled(false);
                STATE.getImageSizeAutomatically=true;
            }
            else{
                imageWidthBox.setEnabled(true);
                imageHeightBox.setEnabled(true);
                STATE.getImageSizeAutomatically=false;
            }
        }
        else if(event.getSource()==changeKeyCombinationButton){
            mainWindow.removeKeyListener(this);
            STATE.allowKeyCombinationChange=true;
            keyComboAusgabe.setText("Bereit");
            keyComboAusgabe.requestFocus();
            keyComboAusgabe.requestFocusInWindow();
            keyComboAusgabe.grabFocus();
        }
        else if(event.getSource()==saveKeyCombinationButton){
            mainWindow.addKeyListener(this);
            setNewKeyCombinationWindow.setVisible(false);

            if(currentlyEditedKeyCombinationNumber==0){
                STATE.CLOSE_WINDOW_ALT_REQUIRED=STATE.changeAltDown;
                STATE.CLOSE_WINDOW_CTRL_REQUIRED=STATE.changeCtrlDown;
                STATE.CLOSE_WINDOW_SHIFT_REQUIRED=STATE.changeShiftDown;
                STATE.CLOSE_WINDOW_KEY_STRING=changeKeyChar;
                STATE.                CLOSE_WINDOW_KEY_CODE=changeKeyCode;
            }
            else if(currentlyEditedKeyCombinationNumber==1){
            	STATE.OPEN_HELP_WINDOW_ALT_REQUIRED=STATE.changeAltDown;
                STATE.OPEN_HELP_WINDOW_CTRL_REQUIRED=STATE.changeCtrlDown;
                STATE.OPEN_HELP_WINDOW_SHIFT_REQUIRED=STATE.changeShiftDown;
                STATE.OPEN_HELP_WINDOW_KEY_STRING=changeKeyChar;
                STATE.OPEN_HELP_WINDOW_KEY_CODE=changeKeyCode;
            }
            else if(currentlyEditedKeyCombinationNumber==2){
            	STATE.OPEN_NEW_PLOT_ALT_REQUIRED=STATE.changeAltDown;
                STATE.OPEN_NEW_PLOT_CTRL_REQUIRED=STATE.changeCtrlDown;
                STATE.OPEN_NEW_PLOT_SHIFT_REQUIRED=STATE.changeShiftDown;
                STATE.OPEN_NEW_PLOT_KEY_STRING=changeKeyChar;
                STATE.OPEN_NEW_PLOT_KEY_CODE=changeKeyCode;
            }
            else if(currentlyEditedKeyCombinationNumber==3){
            	STATE.OPEN_NEW_WINDOW_ALT_REQUIRED=STATE.changeAltDown;
                STATE. OPEN_NEW_WINDOW_CTRL_REQUIRED=STATE.changeCtrlDown;
                STATE. OPEN_NEW_WINDOW_SHIFT_REQUIRED=STATE.changeShiftDown;
                STATE. OPEN_NEW_WINDOW_KEY_STRING=changeKeyChar;
                STATE. OPEN_NEW_WINDOW_KEY_CODE=changeKeyCode;
            }
            else if(currentlyEditedKeyCombinationNumber==4){
            	STATE.OPEN_SETTINGS_WINDOW_ALT_REQUIRED=STATE.changeAltDown;
            	STATE.OPEN_SETTINGS_WINDOW_CTRL_REQUIRED=STATE.changeCtrlDown;
            	STATE.OPEN_SETTINGS_WINDOW_SHIFT_REQUIRED=STATE.changeShiftDown;
            	STATE.OPEN_SETTINGS_WINDOW_KEY_STRING=changeKeyChar;
            	STATE. OPEN_SETTINGS_WINDOW_KEY_CODE=changeKeyCode;
            }
            else if(currentlyEditedKeyCombinationNumber==5){
            	STATE.REFRESH_FRAME_ALT_REQUIRED=STATE.changeAltDown;
            	STATE.REFRESH_FRAME_CTRL_REQUIRED=STATE.changeCtrlDown;
            	STATE.REFRESH_FRAME_SHIFT_REQUIRED=STATE.changeShiftDown;
            	STATE.REFRESH_FRAME_KEY_STRING=changeKeyChar;
            	STATE.REFRESH_FRAME_KEY_CODE=changeKeyCode;
            }
            else if(currentlyEditedKeyCombinationNumber==6){
            	STATE.SAVE_GRAPH_IMAGE_ALT_REQUIRED=STATE.changeAltDown;
            	STATE.SAVE_GRAPH_IMAGE_CTRL_REQUIRED=STATE.changeCtrlDown;
            	STATE.SAVE_GRAPH_IMAGE_SHIFT_REQUIRED=STATE.changeShiftDown;
            	STATE.SAVE_GRAPH_IMAGE_KEY_STRING=changeKeyChar;
            	STATE.SAVE_GRAPH_IMAGE_KEY_CODE=changeKeyCode;
            }
            else if(currentlyEditedKeyCombinationNumber==7){
            	STATE.TOGGLE_BOTTOM_PANEL_VISIBILITY_ALT_REQUIRED=STATE.changeAltDown;
            	STATE.TOGGLE_BOTTOM_PANEL_VISIBILITY_CTRL_REQUIRED=STATE.changeCtrlDown;
            	STATE.TOGGLE_BOTTOM_PANEL_VISIBILITY_SHIFT_REQUIRED=STATE.changeShiftDown;
            	STATE.TOGGLE_BOTTOM_PANEL_VISIBILITY_KEY_STRING=changeKeyChar;
            	STATE.TOGGLE_BOTTOM_PANEL_VISIBILITY_KEY_CODE=changeKeyCode;
            }
            else if(currentlyEditedKeyCombinationNumber==8){
            	STATE.TOGGLE_FULLSCREEN_MODE_ALT_REQUIRED=STATE.changeAltDown;
            	STATE.TOGGLE_FULLSCREEN_MODE_CTRL_REQUIRED=STATE.changeCtrlDown;
            	STATE.TOGGLE_FULLSCREEN_MODE_SHIFT_REQUIRED=STATE.changeShiftDown;
            	STATE.TOGGLE_FULLSCREEN_MODE_KEY_STRING=changeKeyChar;
            	STATE.TOGGLE_FULLSCREEN_MODE_KEY_CODE=changeKeyCode;
            }
            STATE.keyCombinationsEnabled=true;
        }
        else if(event.getSource()==openDifferentPlotMenuItem){
            openNewPlot();
        }
        else if(event.getSource()==openNewWindowMenuItem){
            openNewWindow();
        }
        else if(event.getSource()==closeWindowMenuItem){
            closeWindow();
        }
        else if(event.getSource()==saveGraphImagesMenu){
            saveImages();
        }
        else if(event.getSource()==helpWindowCloseButton){
            helpWindow.setVisible(false);
        }
        else if(event.getSource()==jpegCheckBox){
            if(pngCheckBox.isSelected()){
            	STATE.savePng=true;
            }
            else{
            	STATE.savePng=false;
            }
        }
        else if(event.getSource()==jpegCheckBox){
            if(jpegCheckBox.isSelected()){
            	STATE.saveJpeg=true;
            }
            else{
            	STATE.saveJpeg=false;
            }
            FILES.saveConfigurationFile();
        }
        else if(event.getSource()==fullscreenOnStartupComboBox){
            if(fullscreenOnStartupComboBox.isSelected()){
            	STATE.fullscreenOnStartup=true;
            }
            else{
            	STATE.fullscreenOnStartup=true;
            }
            FILES.saveConfigurationFile();
        }
        else if(event.getSource()==dataPanelOnStartup){
            if(dataPanelOnStartup.isSelected()){
            	STATE. bottomPanelExpandedOnStartup=true;
            }
            else{
            	STATE. bottomPanelExpandedOnStartup=true;
            }
            FILES.saveConfigurationFile();
        }
        else if(event.getSource()==AutoUpdateRadioButton){
        	STATE. autoUpdate=AutoUpdateRadioButton.isSelected();
        }
        else if(event.getSource()==ManualUpdateRadioButton){
        	STATE. autoUpdate=AutoUpdateRadioButton.isSelected();
        }
        else if(event.getSource()==FullscreenExclusiveRadioButton){
        	STATE. fullscreenOk=FullscreenExclusiveRadioButton.isSelected();
        }
        else if(event.getSource()==MaximizeWindowRadioButton){
        	STATE. fullscreenOk=FullscreenExclusiveRadioButton.isSelected();
        }
        for(int i=0;i<STATE.NUMBER_OF_KEY_COMBOS;i++){
            if(event.getSource()==KeyCombinationChangeButton[i]){
                openSetNewKeyCombinationWindow(i);
            }
        }
        for(int i=0;i<numberOfGraphs;i++){
            if(event.getSource()==selectGraphVisibilityCheckBox[i]){
                setSeriesVisible(i,selectGraphVisibilityCheckBox[i].isSelected());
            }
        }
        reloadBackend();
    }

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

    private void reloadBackend(){
    	FILES.saveConfigurationFile();
    	FILES.loadConfigurationFile();
        loadTextForHelpWindowAndKeyCombinations();
    }

    private void openSetNewKeyCombinationWindow(int input) {
    	STATE.keyCombinationsEnabled=false;
        configureKeyCombinationText[5].setText(configureKeyCombinationText[5].getText()+setNewKeyCombinationTexts[input]);
        setNewKeyCombinationWindow.setVisible(true);
        currentlyEditedKeyCombinationNumber=input;
    }

    private void setPrevious(CSV_PLOTTER newPrevious) {
        previous=newPrevious;
    }

    private void setNext(CSV_PLOTTER newNext) {
        next=newNext;
    }

    private void openNewPlot(){
        mainWindow.setVisible(false);
        CSV_PLOTTER neu=new CSV_PLOTTER(titleNumber,previous,next);
        if(next!=null){
            next.setPrevious(neu);
        }
        if(previous!=null){
            previous.setNext(neu);
        }
        exit();
    }

    private void openNewWindow(){
        next=new CSV_PLOTTER(titleNumber+1,this,next);
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
     * This Method handles the Key Events for changing the KeyCombinations
     */
    @Override
    public void keyReleased(KeyEvent event) {
        if(STATE.allowKeyCombinationChange){
        	STATE.allowKeyCombinationChange=false;
            //System.out.println("KeyReleased");
            keyComboAusgabe.setText("");
            if(event.isAltDown()){
                keyComboAusgabe.setText("Alt+");
                STATE.changeAltDown=true;
            }
            if(event.isControlDown()){
                keyComboAusgabe.setText(keyComboAusgabe.getText()+"Strg+");
                STATE.changeCtrlDown=true;
            }
            if(event.isShiftDown()){
                keyComboAusgabe.setText(keyComboAusgabe.getText()+"Shift+");
                STATE.changeShiftDown=true;
            }
            //keyComboAusgabe.setText(keyComboAusgabe.getText()+String.valueOf(event.getKeyChar()));
            keyComboAusgabe.setText(keyComboAusgabe.getText()+getKeyStringFromKeyCode(event.getExtendedKeyCode()));
            changeKeyChar=getKeyStringFromKeyCode(event.getExtendedKeyCode());
            changeKeyCode=event.getExtendedKeyCode();
            if(STATE.debug){
                System.out.print(event.getKeyChar());
            }
            if(STATE.debug){
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
     * This method handles the Key Events for the various KeyCombinations
     */
    @Override
    public void keyPressed(KeyEvent event) {
        System.out.println("KeyText (extended): "+KeyEvent.getKeyText(event.getExtendedKeyCode())+"    KeyText: "+KeyEvent.getKeyText(event.getKeyCode())+"    KeyString (eigenbau&&extended): "+getKeyStringFromKeyCode(event.getExtendedKeyCode())+"    KeyString(eigenbau): "+getKeyStringFromKeyCode(event.getKeyCode()));
        if(STATE.keyCombinationsEnabled){
            if(event.getExtendedKeyCode()==STATE.TOGGLE_FULLSCREEN_MODE_KEY_CODE&&event.isAltDown()==STATE.TOGGLE_FULLSCREEN_MODE_ALT_REQUIRED&&event.isControlDown()==STATE.TOGGLE_FULLSCREEN_MODE_CTRL_REQUIRED&&event.isShiftDown()==STATE.TOGGLE_FULLSCREEN_MODE_SHIFT_REQUIRED){
                toggleFullscreen();
            }
            if(event.getExtendedKeyCode()==STATE.REFRESH_FRAME_KEY_CODE&&event.isAltDown()==STATE.REFRESH_FRAME_ALT_REQUIRED&&event.isControlDown()==STATE.REFRESH_FRAME_CTRL_REQUIRED&&event.isShiftDown()==STATE.REFRESH_FRAME_SHIFT_REQUIRED){
                refreshPage();
            }
            if(event.getExtendedKeyCode()==STATE.OPEN_HELP_WINDOW_KEY_CODE&&event.isAltDown()==STATE.OPEN_HELP_WINDOW_ALT_REQUIRED&&event.isControlDown()==STATE.OPEN_HELP_WINDOW_CTRL_REQUIRED&&event.isShiftDown()==STATE.OPEN_HELP_WINDOW_SHIFT_REQUIRED){
                deactivateFullscreen();
                makeHelpWindowVisible();
            }
            if(event.getExtendedKeyCode()==STATE.OPEN_NEW_PLOT_KEY_CODE&&event.isAltDown()==STATE.OPEN_NEW_PLOT_ALT_REQUIRED&&event.isControlDown()==STATE.OPEN_NEW_PLOT_CTRL_REQUIRED&&event.isShiftDown()==STATE.OPEN_NEW_PLOT_SHIFT_REQUIRED){
                deactivateFullscreen();
                openNewPlot();
            }
            if(event.getExtendedKeyCode()==STATE.OPEN_NEW_WINDOW_KEY_CODE&&event.isAltDown()==STATE.OPEN_NEW_WINDOW_ALT_REQUIRED&&event.isControlDown()==STATE.OPEN_NEW_WINDOW_CTRL_REQUIRED&&event.isShiftDown()==STATE.OPEN_NEW_WINDOW_SHIFT_REQUIRED){
                deactivateFullscreen();
                openNewWindow();
            }
            if(event.getExtendedKeyCode()==STATE.CLOSE_WINDOW_KEY_CODE&&event.isAltDown()==STATE.CLOSE_WINDOW_ALT_REQUIRED&&event.isControlDown()==STATE.CLOSE_WINDOW_CTRL_REQUIRED&&event.isShiftDown()==STATE.CLOSE_WINDOW_SHIFT_REQUIRED){
                deactivateFullscreen();
                closeWindow();
            }
            if(event.getExtendedKeyCode()==STATE.TOGGLE_BOTTOM_PANEL_VISIBILITY_KEY_CODE&&event.isAltDown()==STATE.TOGGLE_BOTTOM_PANEL_VISIBILITY_ALT_REQUIRED&&event.isControlDown()==STATE.TOGGLE_BOTTOM_PANEL_VISIBILITY_CTRL_REQUIRED&&event.isShiftDown()==STATE.TOGGLE_BOTTOM_PANEL_VISIBILITY_SHIFT_REQUIRED){
                toggleBottomPanel();
            }
            if(event.getExtendedKeyCode()==STATE.OPEN_SETTINGS_WINDOW_KEY_CODE&&event.isAltDown()==STATE.OPEN_SETTINGS_WINDOW_ALT_REQUIRED&&event.isControlDown()==STATE.OPEN_SETTINGS_WINDOW_CTRL_REQUIRED&&event.isShiftDown()==STATE.OPEN_SETTINGS_WINDOW_SHIFT_REQUIRED){
                deactivateFullscreen();
                toggleSettingsWindow();
            }
            if(event.getExtendedKeyCode()==STATE.SAVE_GRAPH_IMAGE_KEY_CODE&&event.isAltDown()==STATE.SAVE_GRAPH_IMAGE_ALT_REQUIRED&&event.isControlDown()==STATE.SAVE_GRAPH_IMAGE_CTRL_REQUIRED&&event.isShiftDown()==STATE.SAVE_GRAPH_IMAGE_SHIFT_REQUIRED){
                saveImages();
            }
        }
    }

    private void saveImages() {
        if(STATE.saveJpeg){
            try {
                ChartUtilities.saveChartAsJPEG(new File(csvFile.getName()+".jpeg"), jFreeChart, STATE.imageWidth, STATE.imageHeight);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(STATE.savePng){
            try {
                ChartUtilities.saveChartAsPNG(new File(csvFile.getName()+".png"), jFreeChart, STATE.imageWidth, STATE.imageHeight);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

	@Override
	public void focusGained(FocusEvent arg0) {
	interpolateCustom.setSelected(true);
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

	@Override
	public void focusLost(FocusEvent arg0) {}
}