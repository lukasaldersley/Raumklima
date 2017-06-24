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
public class Raumklima implements ActionListener,WindowListener,WindowStateListener,ChartMouseListener,ComponentListener,KeyListener, MouseListener
{
    public static int OPEN_NEW_PLOT_KEY_CODE=78;//O
    public static int OPEN_NEW_WINDOW_KEY_CODE=79;//N
    public static int CLOSE_KEY_CODE=87;//W
    public static int OPEN_SETTINGS_KEY_CODE=73;//I
    public static int EXPAND_COLLAPSE_BOTTOMPANEL_KEY_CODE=69;//E
    public static int SAVE_GRAPH_KEY_CODE=83;//S
    public static int OPEN_HELP_KEY_CODE=112;//F1
    public static int TOGGLE_FULLSCREEN_MODE_KEY_CODE=122;//F11
    public static int REFRESH_FRAME_KEY_CODE=116;//F5
    public static String OPEN_SETTINGS_KEY_STRING="I";
    public static String OPEN_HELP_KEY_STRING="F1";
    public static String OPEN_NEW_PLOT_KEY_STRING="O";
    public static String OPEN_NEW_WINDOW_KEY_STRING="N";
    public static String CLOSE_WINDOW_KEY_STRING="W";
    public static String REPAINT_KEY_STRING="F5";
    public static String TOGGLE_FULLSCREEN_KEY_STRING="F11";
    public static String EXPAND_COLLAPSE_BOTTOMPANEL_KEY_STRING = "E";
    public static String SAVE_GRAPH_KEY_STRING = "S";
    public static int HEIGHT_OF_DATA_BLOCK=25;
    public static int WIDTH_OF_DATA_BLOCK=370;
    public static int NUMBER_OF_KEY_COMBOS=9;
	public static int NUMBER_OF_COPYRIGHT_NOTES;

    private JFileChooser fileChooser;
    private File csvFile;
    private BufferedReader br;
    private int counter=0;

    private JFrame fileChooserWindow;
    private JFrame settingsWindow;
    private JFrame helpWindow;
    private JFrame mainWindow;

    private JPanel dataPanel;
    private JPanel waitPanel;
    private ChartPanel chartPanel;
    private Crosshair xCrosshair;
    private Crosshair[] yCrosshairs;

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
    private boolean jFilePickerFailed=false;
    private int numberOfGraphs;
    private GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    private boolean fullscreen=false;
    private String[] dataValueDescriptors;
    private Dimension fullscreenDimension;
    private Dimension windowedTopPanelDimension;

    private JTextField[] dataBoxes;
    private JLabel[] dataLabels;
    private int dataPanelX=0;
    private int dataPanelY;
    private JPanel[] helpWindowSubPanel;
    private JButton[] helpWindowKeyChangeButton;
    private JButton helpWindowCloseButton;
    private JLabel[] helpWindowSubPanelText;
    private JScrollPane helpWindowScrollPane;
    private JPanel helpPanel;
	private JLabel[] copyrightNotes;

    public Raumklima(){
        //Initialise JFrames
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
        mainWindow.setTitle("Raumklima-Auswertungssoftware");
        mainWindow.setIconImage(logo);
        mainWindow.setMinimumSize(new Dimension(370,400));//mindestens 1 block der Textfelder MUSS draufpassen (370px)

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
        
        br=new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("HelpTexts.txt")));
        try{

            String line="";
            helpWindowSubPanel=new JPanel[NUMBER_OF_KEY_COMBOS];
            helpWindowSubPanelText=new JLabel[NUMBER_OF_KEY_COMBOS];
            helpWindowKeyChangeButton=new JButton[NUMBER_OF_KEY_COMBOS];
            for(int i=0;i<NUMBER_OF_KEY_COMBOS;i++){
                line=br.readLine();
                helpWindowSubPanel[i]=new JPanel(new FlowLayout());
                helpWindowSubPanelText[i]=new JLabel(line);
                helpWindowKeyChangeButton[i]=new JButton("�ndern");
                helpWindowSubPanelText[i].setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
                helpWindowKeyChangeButton[i].addActionListener(this);
                helpWindowSubPanel[i].add(helpWindowSubPanelText[i],BorderLayout.WEST);
                helpWindowSubPanel[i].add(helpWindowKeyChangeButton[i],BorderLayout.EAST);
                //helpWindow.add(helpWindowSubPanel[i]);
                helpPanel.add(helpWindowSubPanel[i]);
            }
            helpWindowSubPanelText[0].setText(helpWindowSubPanelText[0].getText()+OPEN_HELP_KEY_STRING);
            helpWindowSubPanelText[1].setText(helpWindowSubPanelText[1].getText()+TOGGLE_FULLSCREEN_KEY_STRING);
            helpWindowSubPanelText[2].setText(helpWindowSubPanelText[2].getText()+REPAINT_KEY_STRING);
            helpWindowSubPanelText[3].setText(helpWindowSubPanelText[3].getText()+OPEN_SETTINGS_KEY_STRING);
            helpWindowSubPanelText[4].setText(helpWindowSubPanelText[4].getText()+OPEN_NEW_WINDOW_KEY_STRING);
            helpWindowSubPanelText[5].setText(helpWindowSubPanelText[5].getText()+CLOSE_WINDOW_KEY_STRING);
            helpWindowSubPanelText[6].setText(helpWindowSubPanelText[6].getText()+OPEN_NEW_PLOT_KEY_STRING);
            helpWindowSubPanelText[7].setText(helpWindowSubPanelText[7].getText()+EXPAND_COLLAPSE_BOTTOMPANEL_KEY_STRING);
            helpWindowSubPanelText[8].setText(helpWindowSubPanelText[8].getText()+SAVE_GRAPH_KEY_STRING);
            for(int i=0;i<NUMBER_OF_KEY_COMBOS;i++){
                for(int j=helpWindowSubPanelText[i].getText().length();j<45;j++){
                    helpWindowSubPanelText[i].setText(helpWindowSubPanelText[i].getText()+" ");
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
            JLabel error=new JLabel("Ein Fehler ist aufgetreten und diese Seite konnte nicht geladen werden. Bitte laden Sie das Programm neu.");
            helpPanel.add(error);
        }
        
        
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
        helpWindowScrollPane.setPreferredSize(new Dimension(helpWindow.getWidth(), helpWindow.getHeight()-60));
        helpWindow.add(helpWindowScrollPane,BorderLayout.NORTH);

        helpWindowCloseButton=new JButton("Schlie�en");
        helpWindowCloseButton.addActionListener(this);
        helpWindowCloseButton.setPreferredSize(new Dimension(helpWindow.getWidth(),25));
        helpWindow.add(helpWindowCloseButton,BorderLayout.SOUTH);
        
        helpWindow.validate();


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

            fullscreenDimension.setSize(fullscreenDimension.width,(graphicsDevice.getDisplayMode().getHeight()-30)-HEIGHT_OF_DATA_BLOCK*dataPanelY);

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
        }
        else{
            exit();
        }
    }

    public int floor(double in){
        return (int)in;
    }

    public int roof(double in){
        if( ((int)(in))-in==0.00000000){
            return (int)in;
        }
        else{
            return (int)in+1;
        }
    }

    public int roofA(double in){
        if( ((int)(in))-in==0.00000000){
            return (int)in;
        }
        else{
            return (int)in+1;
        }
    }

    public void toggleFullscreen(){
        if(fullscreen){//if fullscreenMode is already enabled, disable it
            deactivateFullscreen();
        }
        else{//the fullscreenMode is disabled, so enable it
            avtivateFullscreen();
        }
    }

    private void refreshPage(){
        dataPanelX=floor(mainWindow.getWidth()/370);
        dataPanelY=roof((double)((double)numberOfGraphs/(double)dataPanelX));
        if(dataPanelX*dataPanelY<numberOfGraphs){//Something went terribly WRONG!!!!
            System.out.println("HELP SPACIAL COLLISION OF numberOfGraphs and panelX/Y: "+numberOfGraphs+"|"+dataPanelX+"x"+dataPanelY);
        }

        dataPanel.setLayout(new GridLayout(dataPanelY,dataPanelX*2));

        windowedTopPanelDimension.setSize(mainWindow.getWidth(),(mainWindow.getHeight()-30)-HEIGHT_OF_DATA_BLOCK*dataPanelY);

        chartPanel.setPreferredSize(windowedTopPanelDimension);

        chartPanel.setVisible(false);
        dataPanel.setVisible(false);
        dataPanel.setVisible(true);
        chartPanel.setVisible(true);
        mainWindow.validate();
    }

    private void deactivateFullscreen(){
        graphicsDevice.setFullScreenWindow(null);
        fullscreen=false;
        chartPanel.setPreferredSize(new Dimension(mainWindow.getWidth(),mainWindow.getHeight()-60));
        mainWindow.validate();
        refreshPage();
    }

    private void avtivateFullscreen(){
        graphicsDevice.setFullScreenWindow(mainWindow);
        fullscreen=true;
        chartPanel.setPreferredSize(fullscreenDimension);
        refreshPage();
    }

    public int showOpenDialog(){
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
        mainWindow.dispose();
        fileChooserWindow.dispose();
        settingsWindow.dispose();
        helpWindow.dispose();
    }

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
        mainWindow.setFocusable(helpWindow.isVisible());
        helpWindow.setVisible(!helpWindow.isVisible());
    }

    private void toggleSettingsWindow(){
        mainWindow.setFocusable(settingsWindow.isVisible());
        settingsWindow.setVisible(!settingsWindow.isVisible());
    }

    @Override
    public void componentResized(ComponentEvent event) {
        if(!fullscreen){
            chartPanel.setPreferredSize(new Dimension(mainWindow.getWidth(),mainWindow.getHeight()-60));
        }
        else{
            chartPanel.setPreferredSize(fullscreenDimension);
        }
        mainWindow.validate();
        refreshPage();
    }

    @Override
    public void windowStateChanged(WindowEvent event) {
        if(!fullscreen){
            chartPanel.setPreferredSize(new Dimension(mainWindow.getWidth(),mainWindow.getHeight()-60));
        }
        else{
            chartPanel.setPreferredSize(fullscreenDimension);
        }
        mainWindow.validate();
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

        for(int i=0;i<NUMBER_OF_KEY_COMBOS;i++){
            if(event.getSource()==helpWindowKeyChangeButton[i]){
                changeKeyCombo(i);
            }
        }
    }

    private void changeKeyCombo(int i) {
        // TODO Tastenkombi �ndern
    }

    public void openNewPlot(){
        new Raumklima();
        exit();
        //TODO rearrange numbers
    }

    public void openNewWindow(){
        new Raumklima();
        //TODO rearrange numbers
    }

    public void closeWindow(){
        exit();
        //TODO rearrange numbers
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
            System.out.println("HELP");
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
            if(event.getExtendedKeyCode()==SAVE_GRAPH_KEY_CODE){
                ;
            }
            if(event.getExtendedKeyCode()==EXPAND_COLLAPSE_BOTTOMPANEL_KEY_CODE){
                if(dataPanel.isVisible()){
                    dataPanel.setVisible(false);
                }
                else{
                    dataPanel.setVisible(true);
                }
                //TODO viel zeug
            }
            if(event.getExtendedKeyCode()==OPEN_SETTINGS_KEY_CODE){
                System.out.println("SETTINGS");
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
            System.out.println("SETTINGS");
            deactivateFullscreen();
            toggleSettingsWindow();
        }
        if(event.getSource()==openHelpWindowMenu){
            System.out.println("HELP");
            deactivateFullscreen();
            toggleHelpWindow();
        }
        if(event.getSource()==toggleFullscreenModeMenu){
            System.out.println("FULLSCREEN");
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