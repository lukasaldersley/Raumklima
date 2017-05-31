import java.awt.Font;

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
import java.io.*;
@SuppressWarnings({ "unused", "serial" })
public class CombinedXYPlotDemo1 extends ApplicationFrame {
    BufferedReader br;
    int counter=0;
    /**
     * Constructs a new demonstration application.
     *
     * @param title  the frame title.
     */
    public CombinedXYPlotDemo1(final String title) {

        super(title);
        final JFreeChart chart = createCombinedChart();
        final ChartPanel panel = new ChartPanel(chart, true, true, true, false, true);
        panel.setPreferredSize(new java.awt.Dimension(1900, 1000));
        setContentPane(panel);

    }

    /**
     * Creates a combined chart.
     *
     * @return the combined chart.
     */
    private JFreeChart createCombinedChart() {

        // create subplot 1...
        final XYDataset data1 = createDataset1();
        final XYItemRenderer renderer1 = new StandardXYItemRenderer();
        final NumberAxis rangeAxis1 = new NumberAxis("Range 1");
        final XYPlot subplot1 = new XYPlot(data1, null, rangeAxis1, renderer1);
        subplot1.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);

        /*final XYTextAnnotation annotation = new XYTextAnnotation("Hello!", 50.0, 10000.0);
        annotation.setFont(new Font("SansSerif", Font.PLAIN, 9));
        annotation.setRotationAngle(Math.PI / 4.0);
        subplot1.addAnnotation(annotation);*/

        /*// create subplot 2...
        final XYDataset data2 = createDataset2();
        final XYItemRenderer renderer2 = new StandardXYItemRenderer();
        final NumberAxis rangeAxis2 = new NumberAxis("Range 2");
        rangeAxis2.setAutoRangeIncludesZero(false);
        final XYPlot subplot2 = new XYPlot(data2, null, rangeAxis2, renderer2);
        subplot2.setRangeAxisLocation(AxisLocation.TOP_OR_LEFT);*/

        // parent plot...
        final CombinedDomainXYPlot plot = new CombinedDomainXYPlot(new NumberAxis("Domain"));
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

        try{
            String name="F:\\CODE\\JAVA\\LOG_3.CSV";
            br = new BufferedReader(new FileReader(name));
        }
        catch(Exception e){
            e.printStackTrace();
        }

        // create dataset 1...
        XYSeries series1 = new XYSeries("Batterie Spannung");
        XYSeries series2 = new XYSeries("Helligkeit");
        XYSeries series3 = new XYSeries("Luftfeuchtigkeit");
        XYSeries series4 = new XYSeries("Temperatur (DHT)");
        XYSeries series5 = new XYSeries("Hic (DHT)");
        XYSeries series6 = new XYSeries("Temperatur (BMP)");
        XYSeries series7 = new XYSeries("Luftdruck");
        try{
            br.readLine();
            String zeile=br.readLine();
            while(zeile!=null||zeile!=""){
                System.out.println(zeile);
                zeile.replace(',', '.');
                System.out.println(zeile);
                String[] zwso=zeile.split(";");
                double[] zwsp=new double[7];
                for(int i=0;i<7;i++){
                    zwsp[i]=Double.parseDouble(zwso[i]);
                }
                series1.add(counter,zwsp[0]);
                series2.add(counter,zwsp[1]);
                series3.add(counter,zwsp[2]);
                series4.add(counter,zwsp[3]);
                series5.add(counter,zwsp[4]);
                series6.add(counter,zwsp[5]);
                series7.add(counter,zwsp[6]);
                counter++;
                zeile=br.readLine();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        //series1.add(10.0, 12353.3);

        final XYSeriesCollection collection = new XYSeriesCollection();
        collection.addSeries(series1);
        collection.addSeries(series2);
        collection.addSeries(series3);
        collection.addSeries(series4);
        collection.addSeries(series5);
        collection.addSeries(series6);
        collection.addSeries(series7);
        return collection;

    }

    // ****************************************************************************
    // * JFREECHART DEVELOPER GUIDE                                               *
    // * The JFreeChart Developer Guide, written by David Gilbert, is available   *
    // * to purchase from Object Refinery Limited:                                *
    // *                                                                          *
    // * http://www.object-refinery.com/jfreechart/guide.html                     *
    // *                                                                          *
    // * Sales are used to provide funding for the JFreeChart project - please    * 
    // * support us so that we can continue developing free software.             *
    // ****************************************************************************

    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(final String[] args) {

        final CombinedXYPlotDemo1 demo = new CombinedXYPlotDemo1("CombinedDomainXYPlot Demo");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}
