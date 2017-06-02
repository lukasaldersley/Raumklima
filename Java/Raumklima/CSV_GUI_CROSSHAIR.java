package Raumklima;

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
/**
 * This class theoretically should display all of the recorded graphs from the SD card
 * 
 * @author Lukas Aldersley
 * @version 0.9.0.0
 */
public class CSV_GUI_CROSSHAIR
{
    JFileChooser fileChooser;
    File csvFile;
    JFrame jFileChooserWindow;
    ApplicationFrame frame;
    JFreeChart chart;
    ChartPanel panel;
    BufferedReader br;
    int counter=0;

    public static void main(String[] args){
        new CSV_GUI_CROSSHAIR();
    }

    public CSV_GUI_CROSSHAIR()
    {
        initJFileChooser();
        frame=new ApplicationFrame("CombinedDomainXYPlot Demo");

        chart=createCombinedChart();
        panel = new ChartPanel(chart, true, true, true, false, true);
        panel.setPreferredSize(new java.awt.Dimension(1500, 800));
        frame.setContentPane(panel);

        frame.pack();
        RefineryUtilities.centerFrameOnScreen(frame);
        frame.setVisible(true);
    }

    private JFreeChart createCombinedChart() {

        // create subplot 1...
        XYDataset data1 = createDataset1();
        XYItemRenderer renderer1 = new StandardXYItemRenderer();
        NumberAxis rangeAxis1 = new NumberAxis("Range 1");
        XYPlot subplot1 = new XYPlot(data1, null, rangeAxis1, renderer1);
        subplot1.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);

        final XYTextAnnotation annotation = new XYTextAnnotation("Hello!", 50.0, 10000.0);
        annotation.setFont(new Font("SansSerif", Font.PLAIN, 9));
        annotation.setRotationAngle(Math.PI / 4.0);
        subplot1.addAnnotation(annotation);

        // parent plot...
        CombinedDomainXYPlot plot = new CombinedDomainXYPlot(new NumberAxis("Domain"));
        plot.setGap(10.0);

        // add the subplots...
        plot.add(subplot1, 1);
        //plot.add(subplot2, 1);
        plot.setOrientation(PlotOrientation.VERTICAL);

        // return a new chart containing the overlaid plot...
        return new JFreeChart("CombinedDomainXYPlot Demo",
            JFreeChart.DEFAULT_TITLE_FONT, plot, true);

    }

    /**
     * Creates a sample dataset.
     *
     * @return Series 1.
     */
    private XYDataset createDataset1() {
        int returnVal = showOpenDialog();
        final XYSeriesCollection collection = new XYSeriesCollection();
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
        // create dataset 1...
        //XYSeries series1 = new XYSeries("Batterie Spannung");
        //XYSeries series2 = new XYSeries("Helligkeit");
        try{
            String zeile=br.readLine();
            String[] zwspS=zeile.split(";");
            XYSeries[] series=new XYSeries[zwspS.length];
            for(int i=0;i<zwspS.length;i++){
                series[i]=new XYSeries(zwspS[i]);
            }
            zeile=br.readLine();
            zeile=br.readLine();
            zeile=br.readLine();
            while(zeile!=null||zeile!=""){
                if(zeile==null||zeile==""){
                    break;
                }
                System.out.println(zeile);
                zeile.replace(',', '.');
                System.out.println(zeile);
                String[] zwso=zeile.split(";");
                double[] zwsp=new double[zwspS.length];
                for(int i=0;i<zwspS.length;i++){
                    zwsp[i]=Double.parseDouble(zwso[i]);
                    series[i].add(counter,zwsp[i]);
                }
                //series1.add(counter,zwsp[0]);
                //series2.add(counter,zwsp[1]);
                counter++;
                zeile=br.readLine();
                if(zeile==null||zeile==""){
                    break;
                }
            }
            for(int i=0;i<zwspS.length;i++){
                collection.addSeries(series[i]);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        //series1.add(10.0, 12353.3);

        //collection.addSeries(series1);
        //collection.addSeries(series2);
        return collection;

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
}
