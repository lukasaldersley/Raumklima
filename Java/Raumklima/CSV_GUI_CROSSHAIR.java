package Raumklima;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;

import javax.swing.*;
import javax.swing.filechooser.*;

import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.panel.*;
import org.jfree.chart.plot.*;
import org.jfree.data.general.*;
import org.jfree.data.xy.*;
import org.jfree.ui.*;

public class CSV_GUI_CROSSHAIR implements ChartMouseListener, KeyListener, ComponentListener, WindowStateListener, WindowListener{
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
    private JFileChooser fileChooser;
    private File csvFile;
    private JFrame jFileChooserWindow;
    private BufferedReader br;
    private int counter=0;

    private JFrame window;
    private ChartPanel chartPanel;
    private Crosshair xCrosshair;
    private Crosshair[] yCrosshairs;
    private int numberOfGraphs;

    private JPanel jPanel;
    private JPanel bottomPanel;
    private JLabel[] boxDesc;
    private JTextField[] box;

    private String[] titleStrings;

    private GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    private static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
    private int ScreenWidth = gd.getDisplayMode().getWidth();
    private int ScreenHeight = gd.getDisplayMode().getHeight();
    private int width,height;
    private int bottomPanelHeight;
    private boolean fullscreen=false;
    private int nrOfRows;
    private int nrOfRowElements;
    private JLabel status;
    private String name;
    private int number;
    private boolean shutdown=false;
    private CSV_GUI_CROSSHAIR nextOne=null;
    private CSV_GUI_CROSSHAIR previousOne=null;
    private JMenuBar menuBar;
    private JMenuItem help;
    private JMenuItem settings;
    public CSV_GUI_CROSSHAIR(String string,int integer,CSV_GUI_CROSSHAIR newPrevious,CSV_GUI_CROSSHAIR newNext) {
        menuBar=new JMenuBar();
        help=new JMenuItem("Hilfe (F1)");
        settings=new JMenuItem("Einstellungen (Strg+"+OPEN_SETTINGS_KEY_STRING+")");
        menuBar.add(help);
        menuBar.add(settings);
        number=integer;
        name=string;
        if(number==1){
            window=new JFrame(name);
        }
        else{
            window=new JFrame(name+" ("+number+")");
        }
        window.setVisible(true);
        window.setSize(800,480);
        status=new JLabel("Bitte Warten");
        window.add(status);
        window.repaint();
        window.setLocationRelativeTo(null);
        try{
            window.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        initJFileChooser();
        jPanel=new JPanel(new BorderLayout());
        JFreeChart jFreeChart = createChart(createDataset());
        if(shutdown==false){
            chartPanel = new ChartPanel(jFreeChart);
            chartPanel.addChartMouseListener((ChartMouseListener)this);
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
            jPanel.add((Component)chartPanel);

            bottomPanel=new JPanel();
            box=new JTextField[numberOfGraphs];
            boxDesc=new JLabel[numberOfGraphs];
            int zws=(int)(Math.floor(ScreenWidth/370))*2;
            if(zws==0){
                zws=1;
            }
            bottomPanel.setLayout(new GridLayout(0,zws,0,10));

            for(int i=0;i<numberOfGraphs;i++){
                box[i]=new JTextField();
                boxDesc[i]=new JLabel("                "+titleStrings[i]+":");
                bottomPanel.add(boxDesc[i]);
                bottomPanel.add(box[i]);
            }
            bottomPanelHeight=(int)(35*(Math.floor((numberOfGraphs-0.1)/(numberOfGraphs/(int)(Math.floor(ScreenWidth/370))*2))+1));
            bottomPanel.setPreferredSize(new Dimension(ScreenWidth,bottomPanelHeight));
            jPanel.setPreferredSize(new Dimension(ScreenWidth,ScreenHeight-(30+bottomPanelHeight)));
            window.remove(status);
            window.add(jPanel, BorderLayout.NORTH);
            window.add(bottomPanel,BorderLayout.SOUTH);
            window.pack();
            window.setLocationRelativeTo(null);
            window.setCursor(Cursor.getDefaultCursor());
            window.setMinimumSize(new Dimension(370,300));
            window.setJMenuBar(menuBar);
            device.setFullScreenWindow(window);
            fullscreen=true;
            window.addKeyListener(this);
            window.addComponentListener(this);
            bottomPanel.addComponentListener(this);
            window.addWindowStateListener(this);
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        else{
            window.dispose();
            jFileChooserWindow.dispose();
        }
    }

    public void setNextOne(CSV_GUI_CROSSHAIR newNext){
        nextOne=newNext;
    }

    public void setPreviousOne(CSV_GUI_CROSSHAIR newPrevious){
        previousOne=newPrevious;
    }

    public void decrementInt(){
        number--;
        if(number==1){
            window.setTitle(name);
        }
        else{
            window.setTitle(name+" ("+number+")");
        }
        if(nextOne!=null){
            nextOne.decrementInt();
        }
    }

    private JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYLineChart((String)"RAUMKLIMA AUSWERTUNGSSOFTWARE", (String)"SAMPLES", (String)"VALUES", (XYDataset)xYDataset);
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
            shutdown=true;
            return xYSeriesCollection;
        }

        XYSeries[] xYSeries;

        try{
            String zeile=br.readLine();
            titleStrings=zeile.split(";");

            numberOfGraphs=titleStrings.length;

            xYSeries=new XYSeries[numberOfGraphs];

            for (int i = 0; i < numberOfGraphs; ++i) {
                xYSeries[i] = new XYSeries((Comparable)((Object)(titleStrings[i])));
            }

            zeile=br.readLine();
            while(zeile!=null||zeile!=""){
                if(zeile==null||zeile==""){
                    break;
                }
                //System.out.println(zeile);
                zeile=zeile.replace("NAN","0,00");
                zeile=zeile.replace(',', '.');
                //System.out.println(zeile);
                String[] zwso=zeile.split(";");
                double[] zwsp=new double[numberOfGraphs];
                for(int i=0;i<numberOfGraphs;i++){
                    zwsp[i]=Double.parseDouble(zwso[i]);
                    xYSeries[i].add(counter,zwsp[i]);
                }
                counter++;
                zeile=br.readLine();
                if(zeile==null||zeile==""){
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

    public void chartMouseClicked(ChartMouseEvent chartMouseEvent) {
        Rectangle2D rectangle2D = chartPanel.getScreenDataArea();
        JFreeChart jFreeChart = chartMouseEvent.getChart();
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        ValueAxis valueAxis = xYPlot.getDomainAxis();
        double d = valueAxis.java2DToValue((double)chartMouseEvent.getTrigger().getX(), rectangle2D, RectangleEdge.BOTTOM);
        this.xCrosshair.setValue(d);
        for (int i = 0; i < numberOfGraphs; ++i) {
            double d2 = DatasetUtilities.findYValue((XYDataset)xYPlot.getDataset(), (int)i, (double)d);
            box[i].setText(String.valueOf(d2));
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

    private void initJFileChooser(){
        jFileChooserWindow=new JFrame();

        fileChooser=new JFileChooser();
        fileChooser.setDialogTitle("Bitte CSV-Datei ausw?hlen");
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Aufgezeichnete Klimadaten (.csv/.CSV)","csv","CSV"));
    }

    public int showOpenDialog(){
        return fileChooser.showOpenDialog(jFileChooserWindow);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){

                @Override
                public void run() {
                    new CSV_GUI_CROSSHAIR("Raumklima Auswertungssoftware",1,null,null);
                }
            });
    }

    //TODO nummern in der titelzeile sinnvoller machen
    @Override
    public void keyPressed(KeyEvent event) {
        //System.out.println("PRESSED:"+event.getKeyCode()+"|"+event.getID());
        System.out.println(event.getKeyCode());
        if(event.getKeyCode()==OPEN_KEY_ID&&event.isControlDown()){//Strg+N ?ffnet eine neue instanz der software
            System.out.println("STRG+N");
            if(fullscreen){
                fullscreen=false;
                bottomPanel.setPreferredSize(new Dimension(800,bottomPanelHeight));
                jPanel.setPreferredSize(new Dimension(800,480-(30+bottomPanelHeight)));
                device.setFullScreenWindow(null);
                window.pack();
                window.setLocationRelativeTo(null);
            }
            setNextOne(new CSV_GUI_CROSSHAIR(name,++number,this,null));
        }
        else if(event.getKeyCode()==OPEN_NEW_KEY_ID&&event.isControlDown()){//Strg+O ?ffnet eine neue instanz und schlie?t sich selbst
            System.out.println("STRG+O");
            window.setVisible(false);
            if(fullscreen){
                fullscreen=false;
                bottomPanel.setPreferredSize(new Dimension(800,bottomPanelHeight));
                jPanel.setPreferredSize(new Dimension(800,480-(30+bottomPanelHeight)));
                device.setFullScreenWindow(null);
                window.pack();
                window.setLocationRelativeTo(null);
            }
            CSV_GUI_CROSSHAIR zw=new CSV_GUI_CROSSHAIR(name,number,previousOne,nextOne);
            if(previousOne!=null){
                previousOne.setNextOne(zw);
            }
            if(nextOne!=null){
                nextOne.setPreviousOne(zw);
            }
            window.dispose();
            jFileChooserWindow.dispose();
        }
        else if(event.getKeyCode()==CLOSE_KEY_ID&&event.isControlDown()){//Strg+W schlie?t sich selbst
            System.out.println("STRG+W");
            if(nextOne!=null){
                nextOne.decrementInt();
                nextOne.setPreviousOne(previousOne);
            }
            if(previousOne!=null){
                previousOne.setNextOne(nextOne);
            }
            window.dispose();
            jFileChooserWindow.dispose();
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {
        //System.out.println("RELEASED:"+event.getKeyCode()+"|"+event.getID());
        System.out.println(event.getKeyCode());
        if(event.getKeyCode()==TOGGLE_FULLSCREEN_MODE_KEY_ID){
            System.out.println("F11");
            if(fullscreen){
                fullscreen=false;
                bottomPanel.setPreferredSize(new Dimension(800,bottomPanelHeight));
                jPanel.setPreferredSize(new Dimension(800,480-(30+bottomPanelHeight)));
                device.setFullScreenWindow(null);
                window.pack();
                window.setLocationRelativeTo(null);
            }
            else{
                fullscreen=true;
                bottomPanel.setPreferredSize(new Dimension(ScreenWidth,bottomPanelHeight));
                jPanel.setPreferredSize(new Dimension(ScreenWidth,ScreenHeight-(30+bottomPanelHeight)));
                device.setFullScreenWindow(window);
            }
        }
        if(event.getKeyCode()==REFRESH_FRAME_KEY_ID){
            window.pack();
        }
    }

    public int floor(double in){
        return (int)(in);
    }

    @Override
    public void componentResized(ComponentEvent arg0) {
        if(!fullscreen){
            System.out.println("WINDOW SIZE: "+width+"x"+height);
            width=window.getWidth();
            height=window.getHeight();
            System.out.println("WINDOW SIZE AFTER GET: "+width+"x"+height);
            nrOfRowElements=floor(width/370);
            nrOfRows=floor(numberOfGraphs/nrOfRowElements)+1;
            bottomPanel.setLayout(new GridLayout(0,nrOfRowElements*2,0,10));
            bottomPanelHeight=40*nrOfRows;
            bottomPanel.setPreferredSize(new Dimension(width,bottomPanelHeight));
            jPanel.setPreferredSize(new Dimension(width,height-(30+bottomPanelHeight)));
            System.out.println("FUCKING JPANEL HEIGHT: "+width+"x"+(height-(30+bottomPanelHeight)));
            jPanel.setSize(new Dimension(width,height-(30+bottomPanelHeight)));
            window.repaint();
            System.out.println("BOTTOMPANEL HEIGHT: "+bottomPanelHeight);
            System.out.println("# of elementcombos per row: "+nrOfRowElements);
            System.out.println("# of  rows: "+nrOfRows);
            System.out.println(jPanel.getPreferredSize());
            System.out.println(bottomPanel.getPreferredSize());
            System.out.println();
            //jpanel.doLayout();
            jPanel.validate();
        }
    }

    @Override
    public void windowStateChanged(WindowEvent e) {
        if(!fullscreen){
            System.out.println("WINDOW SIZE\n: "+width+"x"+height);
            width=window.getWidth();
            height=window.getHeight();
            nrOfRowElements=floor(width/370);
            nrOfRows=floor(numberOfGraphs/nrOfRowElements)+1;
            bottomPanel.setLayout(new GridLayout(0,nrOfRowElements*2,0,10));
            bottomPanelHeight=35*nrOfRows;
            bottomPanel.setPreferredSize(new Dimension(width,bottomPanelHeight));
            jPanel.setPreferredSize(new Dimension(width,height-(/*30+*/bottomPanelHeight)));
            jPanel.setSize(new Dimension(width,height-(/*30+*/bottomPanelHeight)));
            window.repaint();
            System.out.println("BOTTOMPANEL HEIGHT: "+bottomPanelHeight);
            System.out.println("# of elementcombos per row: "+nrOfRowElements);
            System.out.println("# of  rows: "+nrOfRows);
            System.out.println();
        }
    }

    @Override
    public void windowClosing(WindowEvent arg0) {
        System.out.println("CALLED WINDOW-CLOSING-METHOD");
        window.dispose();
        jFileChooserWindow.dispose();
    }

    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowClosed(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void componentHidden(ComponentEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void componentMoved(ComponentEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void componentShown(ComponentEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }
}

