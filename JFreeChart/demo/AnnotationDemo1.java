/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.annotations.XYAnnotation
 *  org.jfree.chart.annotations.XYTextAnnotation
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.title.TextTitle
 *  org.jfree.chart.title.Title
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.XYSeries
 *  org.jfree.data.xy.XYSeriesCollection
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.ui.TextAnchor
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYAnnotation;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class AnnotationDemo1
extends ApplicationFrame {
    public AnnotationDemo1(String string) {
        super(string);
        JPanel jPanel = AnnotationDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(360, 500));
        this.setContentPane((Container)jPanel);
    }

    private static XYSeriesCollection createDataset() {
        XYSeriesCollection xYSeriesCollection = new XYSeriesCollection();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(XYSeriesCollection.class.getClassLoader().getResourceAsStream("demo/wtageinf.txt")));
            String string = bufferedReader.readLine();
            string = bufferedReader.readLine();
            string = bufferedReader.readLine();
            string = bufferedReader.readLine();
            XYSeries xYSeries = new XYSeries((Comparable)((Object)"P3"), true, false);
            XYSeries xYSeries2 = new XYSeries((Comparable)((Object)"P5"), true, false);
            XYSeries xYSeries3 = new XYSeries((Comparable)((Object)"P10"), true, false);
            XYSeries xYSeries4 = new XYSeries((Comparable)((Object)"P25"), true, false);
            XYSeries xYSeries5 = new XYSeries((Comparable)((Object)"P50"), true, false);
            XYSeries xYSeries6 = new XYSeries((Comparable)((Object)"P75"), true, false);
            XYSeries xYSeries7 = new XYSeries((Comparable)((Object)"P90"), true, false);
            XYSeries xYSeries8 = new XYSeries((Comparable)((Object)"P95"), true, false);
            XYSeries xYSeries9 = new XYSeries((Comparable)((Object)"P97"), true, false);
            string = bufferedReader.readLine();
            while (string != null) {
                int n = Integer.parseInt(string.substring(1, 8).trim());
                float f = Float.parseFloat(string.substring(9, 17).trim());
                float f2 = Float.parseFloat(string.substring(69, 86).trim());
                float f3 = Float.parseFloat(string.substring(87, 103).trim());
                float f4 = Float.parseFloat(string.substring(104, 122).trim());
                float f5 = Float.parseFloat(string.substring(123, 140).trim());
                float f6 = Float.parseFloat(string.substring(141, 158).trim());
                float f7 = Float.parseFloat(string.substring(159, 176).trim());
                float f8 = Float.parseFloat(string.substring(177, 193).trim());
                float f9 = Float.parseFloat(string.substring(194, 212).trim());
                float f10 = Float.parseFloat(string.substring(212, string.length()).trim());
                if (n == 1) {
                    xYSeries.add((double)f, (double)f2);
                    xYSeries2.add((double)f, (double)f3);
                    xYSeries3.add((double)f, (double)f4);
                    xYSeries4.add((double)f, (double)f5);
                    xYSeries5.add((double)f, (double)f6);
                    xYSeries6.add((double)f, (double)f7);
                    xYSeries7.add((double)f, (double)f8);
                    xYSeries8.add((double)f, (double)f9);
                    xYSeries9.add((double)f, (double)f10);
                }
                string = bufferedReader.readLine();
            }
            xYSeriesCollection.addSeries(xYSeries);
            xYSeriesCollection.addSeries(xYSeries2);
            xYSeriesCollection.addSeries(xYSeries3);
            xYSeriesCollection.addSeries(xYSeries4);
            xYSeriesCollection.addSeries(xYSeries5);
            xYSeriesCollection.addSeries(xYSeries6);
            xYSeriesCollection.addSeries(xYSeries7);
            xYSeriesCollection.addSeries(xYSeries8);
            xYSeriesCollection.addSeries(xYSeries9);
        }
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println(fileNotFoundException);
        }
        catch (IOException iOException) {
            System.err.println(iOException);
        }
        return xYSeriesCollection;
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYLineChart((String)null, (String)"Age in Months", (String)"Weight (kg)", (XYDataset)xYDataset);
        TextTitle textTitle = new TextTitle("Growth Charts: United States", new Font("SansSerif", 1, 14));
        TextTitle textTitle2 = new TextTitle("Weight-for-age percentiles: boys, birth to 36 months", new Font("SansSerif", 0, 11));
        jFreeChart.addSubtitle((Title)textTitle);
        jFreeChart.addSubtitle((Title)textTitle2);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        NumberAxis numberAxis = (NumberAxis)xYPlot.getDomainAxis();
        numberAxis.setUpperMargin(0.12);
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        NumberAxis numberAxis2 = (NumberAxis)xYPlot.getRangeAxis();
        numberAxis2.setAutoRangeIncludesZero(false);
        Font font = new Font("SansSerif", 0, 9);
        XYTextAnnotation xYTextAnnotation = new XYTextAnnotation("3rd", 36.5, 11.76);
        xYTextAnnotation.setFont(font);
        xYTextAnnotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        xYPlot.addAnnotation((XYAnnotation)xYTextAnnotation);
        xYTextAnnotation = new XYTextAnnotation("5th", 36.5, 12.04);
        xYTextAnnotation.setFont(font);
        xYTextAnnotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        xYPlot.addAnnotation((XYAnnotation)xYTextAnnotation);
        xYTextAnnotation = new XYTextAnnotation("10th", 36.5, 12.493);
        xYTextAnnotation.setFont(font);
        xYTextAnnotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        xYPlot.addAnnotation((XYAnnotation)xYTextAnnotation);
        xYTextAnnotation = new XYTextAnnotation("25th", 36.5, 13.313);
        xYTextAnnotation.setFont(font);
        xYTextAnnotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        xYPlot.addAnnotation((XYAnnotation)xYTextAnnotation);
        xYTextAnnotation = new XYTextAnnotation("50th", 36.5, 14.33);
        xYTextAnnotation.setFont(font);
        xYTextAnnotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        xYPlot.addAnnotation((XYAnnotation)xYTextAnnotation);
        xYTextAnnotation = new XYTextAnnotation("75th", 36.5, 15.478);
        xYTextAnnotation.setFont(font);
        xYTextAnnotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        xYPlot.addAnnotation((XYAnnotation)xYTextAnnotation);
        xYTextAnnotation = new XYTextAnnotation("90th", 36.5, 16.642);
        xYTextAnnotation.setFont(font);
        xYTextAnnotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        xYPlot.addAnnotation((XYAnnotation)xYTextAnnotation);
        xYTextAnnotation = new XYTextAnnotation("95th", 36.5, 17.408);
        xYTextAnnotation.setFont(font);
        xYTextAnnotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        xYPlot.addAnnotation((XYAnnotation)xYTextAnnotation);
        xYTextAnnotation = new XYTextAnnotation("97th", 36.5, 17.936);
        xYTextAnnotation.setFont(font);
        xYTextAnnotation.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        xYPlot.addAnnotation((XYAnnotation)xYTextAnnotation);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = AnnotationDemo1.createChart((XYDataset)AnnotationDemo1.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        AnnotationDemo1 annotationDemo1 = new AnnotationDemo1("JFreeChart: AnnotationDemo1.java");
        annotationDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)annotationDemo1));
        annotationDemo1.setVisible(true);
    }
}

