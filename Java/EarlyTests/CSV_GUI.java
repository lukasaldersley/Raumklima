package EarlyTests;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
/**
 * This class theoretically should display all of the recorded graphs from the SD card
 * 
 * @author Lukas Aldersley
 * @version 0.9.0.0
 */
public class CSV_GUI
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
        new CSV_GUI();
    }

    public CSV_GUI()
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
        final XYSeriesCollection collection = new XYSeriesCollection();
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
        fileChooser.setDialogTitle("Bitte CSV-Datei ausw�hlen");
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Aufgezeichnete Klimadaten (.csv/.CSV)","csv","CSV"));
    }

    public int showOpenDialog(){
        return fileChooser.showOpenDialog(jFileChooserWindow);
    }
}
