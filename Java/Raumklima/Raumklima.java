package Raumklima;//TODO Settings
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
    public static int OPEN_NEW_PLOT_KEY_CODE=79;//O
    public static int OPEN_NEW_WINDOW_KEY_CODE=78;//N
    public static int CLOSE_KEY_CODE=87;//W
    public static int OPEN_SETTINGS_KEY_CODE=73;//I
    public static int EXPAND_COLLAPSE_BOTTOMPANEL_KEY_CODE=69;//E
    public static int OPEN_HELP_KEY_CODE=112;//F1
    public static int TOGGLE_FULLSCREEN_MODE_KEY_CODE=122;//F11
    public static int REFRESH_FRAME_KEY_CODE=116;//F5
    public static int HEIGHT_OF_DATA_BLOCK=25;
    public static int WIDTH_OF_DATA_BLOCK=370;
    public static int NUMBER_OF_KEY_COMBOS=8;
    public static int NUMBER_OF_COPYRIGHT_NOTES;
    public static String OPEN_SETTINGS_KEY_STRING="I";
    public static String OPEN_HELP_KEY_STRING="F1";
    public static String OPEN_NEW_PLOT_KEY_STRING="O";
    public static String OPEN_NEW_WINDOW_KEY_STRING="N";
    public static String CLOSE_WINDOW_KEY_STRING="W";
    public static String REPAINT_KEY_STRING="F5";
    public static String TOGGLE_FULLSCREEN_KEY_STRING="F11";
    public static String EXPAND_COLLAPSE_BOTTOMPANEL_KEY_STRING = "E";

    private boolean bottomPanelExpanded=true;
    private boolean jFilePickerFailed=false;
    private boolean fullscreen=false;

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

    private JButton helpWindowCloseButton;

    private JFileChooser fileChooser;

    private JFrame fileChooserWindow;
    private JFrame helpWindow;
    private JFrame mainWindow;
    private JFrame settingsWindow;

    private JLabel[] copyrightNotes;
    private JLabel[] dataLabels;
    private JLabel[] helpWindowText;
    private JLabel waitText;

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
    private JPanel waitPanel;

    private JScrollPane helpWindowScrollPane;

    private JTextField[] dataBoxes;

    private Raumklima next;
    private Raumklima previous;

    private String title="Raumklima-Auswertungssoftware";
    private String[] dataValueDescriptors;
	private JPanel settingsWindowLeftPanel;
	private JPanel settingsWindowRightPanel;
	private JLabel leftPanelTitle;
	private JCheckBox pngCheckBox;
	private JCheckBox jpgCheckBox;
	private JCheckBox pdfCheckBox;
	private JLabel rightPanelTitle;
	private JButton[] rightPanelButtons;
	private JPanel[] settingsWindowRightInnerPanel;

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
        try{
            //System.out.println(br.readLine());
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
        openSettingsWindowMenu.addMouseListener(this);
        mainWindowMenuBar.add(openSettingsWindowMenu);

        toggleFullscreenModeMenu=new JMenu("Vollbildmodus ("+TOGGLE_FULLSCREEN_KEY_STRING+")");
        toggleFullscreenModeMenu.addMouseListener(this);
        mainWindowMenuBar.add(toggleFullscreenModeMenu);
        mainWindow.setJMenuBar(mainWindowMenuBar);

        openHelpWindowMenu=new JMenu("Hilfe ("+OPEN_HELP_KEY_STRING+")");
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
        helpWindowScrollPane=new JScrollPane();
        helpWindow.setSize(480,500);
        helpWindow.setLocationRelativeTo(null);
        helpWindow.setTitle("Hilfe");
        helpPanel=new JPanel(new GridLayout(0,1));

        //TODO

        //add Copyright notice
        br=new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("CopyrightNotes.txt")));
        try{
            String line="";
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

        helpWindowScrollPane.setViewportView(helpPanel);
        helpWindowScrollPane.setPreferredSize(new Dimension(helpWindow.getWidth(), helpWindow.getHeight()-53));
        helpWindow.add(helpWindowScrollPane,BorderLayout.NORTH);

        helpWindowCloseButton=new JButton("Schlie�en");
        helpWindowCloseButton.addActionListener(this);
        helpWindowCloseButton.setPreferredSize(new Dimension(helpWindow.getWidth(),25));
        helpWindow.add(helpWindowCloseButton,BorderLayout.SOUTH);

        helpWindow.validate();
        helpWindow.setResizable(false);
        
        //SettingsWindow
        settingsWindow.setSize(650,320);
        settingsWindow.setTitle("Einstellungen");
        settingsWindow.setLocationRelativeTo(null);
        settingsWindowLeftPanel=new JPanel();
        settingsWindowRightPanel=new JPanel();
        settingsWindowLeftPanel.setLayout(new GridLayout(0,1));
        settingsWindowRightPanel.setLayout(new GridLayout(0,1));
        
        leftPanelTitle=new JLabel("Verendete Dateitypen:");
        pngCheckBox=new JCheckBox(("PNG"));
        pngCheckBox.addActionListener(this);
        jpgCheckBox=new JCheckBox("JPG");
        jpgCheckBox.addActionListener(this);
        //pdfCheckBox=new JCheckBox();
        //svgCheckBox=new JCheckBox();
        //TODO pr�fen ob in Config gesetzt
        settingsWindowLeftPanel.add(leftPanelTitle);
        settingsWindowLeftPanel.add(pngCheckBox);
        settingsWindowLeftPanel.add(jpgCheckBox);
        
        settingsWindow.add(settingsWindowLeftPanel,BorderLayout.WEST);
        
        rightPanelTitle=new JLabel("Tastenk�rzel:");
        settingsWindowRightPanel.add(rightPanelTitle, BorderLayout.NORTH);
        readInTextsForKeyCombos();
        for(int i=0;i<NUMBER_OF_KEY_COMBOS;i++){
        settingsWindowRightPanel.add(settingsWindowRightInnerPanel[i], BorderLayout.SOUTH);
        }
        
        settingsWindow.add(settingsWindowRightPanel, BorderLayout.EAST);
        settingsWindow.validate();
        

        //get the data and draw the graph
        //proceed only if successful otherwise exit
        JFreeChart jFreeChart = createChart(createDataset());
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
            toggleFullscreen();
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
            helpWindowText=new JLabel[NUMBER_OF_KEY_COMBOS];
            rightPanelButtons=new JButton[NUMBER_OF_KEY_COMBOS];
            settingsWindowRightInnerPanel=new JPanel[NUMBER_OF_KEY_COMBOS];
            for(int i=0;i<NUMBER_OF_KEY_COMBOS;i++){
            	settingsWindowRightInnerPanel[i]=new JPanel(new BorderLayout());
                line=br.readLine();
                helpWindowText[i]=new JLabel(line);
                helpWindowText[i].setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
                helpPanel.add(helpWindowText[i]);
                //die Gleichen elmente f�r die Einstellungsseite Verwenden
                settingsWindowRightInnerPanel[i].add(helpWindowText[i],BorderLayout.WEST);
                rightPanelButtons[i]=new JButton("�ndern");
                rightPanelButtons[i].setPreferredSize(new Dimension(100,25));
                rightPanelButtons[i].addActionListener(this);
                settingsWindowRightInnerPanel[i].add(rightPanelButtons[i],BorderLayout.EAST);
            }
            helpWindowText[0].setText(helpWindowText[0].getText()+OPEN_HELP_KEY_STRING);
            helpWindowText[1].setText(helpWindowText[1].getText()+TOGGLE_FULLSCREEN_KEY_STRING);
            helpWindowText[2].setText(helpWindowText[2].getText()+REPAINT_KEY_STRING);
            helpWindowText[3].setText(helpWindowText[3].getText()+OPEN_SETTINGS_KEY_STRING);
            helpWindowText[4].setText(helpWindowText[4].getText()+OPEN_NEW_WINDOW_KEY_STRING);
            helpWindowText[5].setText(helpWindowText[5].getText()+CLOSE_WINDOW_KEY_STRING);
            helpWindowText[6].setText(helpWindowText[6].getText()+OPEN_NEW_PLOT_KEY_STRING);
            helpWindowText[7].setText(helpWindowText[7].getText()+EXPAND_COLLAPSE_BOTTOMPANEL_KEY_STRING);
            for(int i=0;i<NUMBER_OF_KEY_COMBOS;i++){
                for(int j=helpWindowText[i].getText().length();j<45;j++){
                    helpWindowText[i].setText(helpWindowText[i].getText()+" ");
                }
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

    private void refreshPage(){//TODO extrema pr�fen
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
        mainWindow.setFocusable(settingsWindow.isVisible());
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
    public void keyReleased(KeyEvent event) {
        if(event.getExtendedKeyCode()==TOGGLE_FULLSCREEN_MODE_KEY_CODE)
        {
            toggleFullscreen();
        }
        if(event.getExtendedKeyCode()==REFRESH_FRAME_KEY_CODE){
            refreshPage();
        }
        if(event.getExtendedKeyCode()==OPEN_HELP_KEY_CODE){
            deactivateFullscreen();
            toggleHelpWindow();
        }
        if(event.isControlDown()){
            if(event.getExtendedKeyCode()==OPEN_NEW_PLOT_KEY_CODE){
                deactivateFullscreen();
                openNewPlot();
            }
            if(event.getExtendedKeyCode()==OPEN_NEW_WINDOW_KEY_CODE){
                deactivateFullscreen();
                openNewWindow();
            }
            if(event.getExtendedKeyCode()==CLOSE_KEY_CODE){
                deactivateFullscreen();
                closeWindow();
            }
            if(event.getExtendedKeyCode()==EXPAND_COLLAPSE_BOTTOMPANEL_KEY_CODE){
                toggleBottomPanel();
            }
            if(event.getExtendedKeyCode()==OPEN_SETTINGS_KEY_CODE){
                deactivateFullscreen();
                toggleSettingsWindow();
            }
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
    public void keyPressed(KeyEvent event) {}
}