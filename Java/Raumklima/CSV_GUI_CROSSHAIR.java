package Raumklima;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.panel.CrosshairOverlay;
import org.jfree.chart.panel.Overlay;
import org.jfree.chart.plot.Crosshair;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleEdge;
import org.jfree.chart.*;
import org.jfree.chart.annotations.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.panel.*;
import org.jfree.chart.renderer.xy.*;
import org.jfree.data.xy.*;
import org.jfree.ui.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.*;
import java.awt.*;

public class CSV_GUI_CROSSHAIR implements ChartMouseListener{
    JFileChooser fileChooser;
    File csvFile;
    JFrame jFileChooserWindow;
    BufferedReader br;
    int counter=0;

    JFrame window;
    private ChartPanel chartPanel;
    private Crosshair xCrosshair;
    private Crosshair[] yCrosshairs;
    private int numberOfGraphs;

    private JPanel jPanel;
    public CSV_GUI_CROSSHAIR(String string) {
        window=new JFrame(string);
        window.setVisible(true);
        window.setSize(680,450);
        JLabel status=new JLabel("Bitte Warten");
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

        //window.setContentPane(CrosshairOverlayDemo2.createDemoPanel());
        //window.setContentPane(jPanel);
        window.remove(status);
        window.add(jPanel);
        window.pack();
        window.setCursor(Cursor.getDefaultCursor());
    }

    private JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYLineChart((String)"CrosshairOverlayDemo2", (String)"X", (String)"Y", (XYDataset)xYDataset);
        return jFreeChart;
    }

    private XYDataset createDataset() {
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
            System.exit(-1);
        }

        XYSeriesCollection xYSeriesCollection = new XYSeriesCollection();
        XYSeries[] xYSeries;

        try{
            String zeile=br.readLine();
            String[] titleStrings=zeile.split(";");

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
                System.out.println(zeile);
                zeile=zeile.replace("NAN","0,00");
                zeile=zeile.replace(',', '.');
                System.out.println(zeile);
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
        ;
    }

    public void chartMouseMoved(ChartMouseEvent chartMouseEvent) {
        Rectangle2D rectangle2D = chartPanel.getScreenDataArea();
        JFreeChart jFreeChart = chartMouseEvent.getChart();
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        ValueAxis valueAxis = xYPlot.getDomainAxis();
        double d = valueAxis.java2DToValue((double)chartMouseEvent.getTrigger().getX(), rectangle2D, RectangleEdge.BOTTOM);
        this.xCrosshair.setValue(d);
        for (int i = 0; i < 4; ++i) {
            double d2 = DatasetUtilities.findYValue((XYDataset)xYPlot.getDataset(), (int)i, (double)d);
            this.yCrosshairs[i].setValue(d2);
        }
    }

    private void initJFileChooser(){
        jFileChooserWindow=new JFrame();

        fileChooser=new JFileChooser();
        fileChooser.setDialogTitle("Bitte CSV-Datei auswählen");
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Aufgezeichnete Klimadaten (.csv/.CSV)","csv","CSV"));
    }

    public int showOpenDialog(){
        return fileChooser.showOpenDialog(jFileChooserWindow);
    }

    public static void main(String[] arrstring) {
        SwingUtilities.invokeLater(new Runnable(){

                @Override
                public void run() {
                    new CSV_GUI_CROSSHAIR("JFreeChart: CrosshairOverlayDemo2.java");
                }
            });
    }
}

