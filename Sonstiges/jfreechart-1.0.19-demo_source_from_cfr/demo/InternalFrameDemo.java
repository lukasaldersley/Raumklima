/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.data.time.Minute
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Minute;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class InternalFrameDemo
extends ApplicationFrame {
    public InternalFrameDemo(String string) {
        super(string);
        JDesktopPane jDesktopPane = new JDesktopPane();
        jDesktopPane.setPreferredSize(new Dimension(600, 400));
        JInternalFrame jInternalFrame = this.createFrame1();
        jDesktopPane.add(jInternalFrame);
        jInternalFrame.pack();
        jInternalFrame.setVisible(true);
        JInternalFrame jInternalFrame2 = this.createFrame2();
        jDesktopPane.add(jInternalFrame2);
        jInternalFrame2.pack();
        jInternalFrame2.setLocation(100, 200);
        jInternalFrame2.setVisible(true);
        this.getContentPane().add(jDesktopPane);
    }

    private JInternalFrame createFrame1() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(34.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue(23.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset.addValue(54.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Category 3"));
        JFreeChart jFreeChart = ChartFactory.createBarChart((String)"Bar Chart", (String)"Category", (String)"Series", (CategoryDataset)defaultCategoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setPreferredSize(new Dimension(200, 100));
        JInternalFrame jInternalFrame = new JInternalFrame("Frame 1", true);
        jInternalFrame.getContentPane().add((Component)chartPanel);
        return jInternalFrame;
    }

    private JInternalFrame createFrame2() {
        XYDataset xYDataset = this.createDataset("Series 1", 100.0, (RegularTimePeriod)new Minute(), 200);
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Time Series Chart", (String)"Time of Day", (String)"Value", (XYDataset)xYDataset, (boolean)true, (boolean)true, (boolean)false);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setPreferredSize(new Dimension(200, 100));
        JInternalFrame jInternalFrame = new JInternalFrame("Frame 2", true);
        jInternalFrame.getContentPane().add((Component)chartPanel);
        return jInternalFrame;
    }

    private XYDataset createDataset(String string, double d, RegularTimePeriod regularTimePeriod, int n) {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)string));
        RegularTimePeriod regularTimePeriod2 = regularTimePeriod;
        double d2 = d;
        for (int i = 0; i < n; ++i) {
            timeSeries.add(regularTimePeriod2, d2);
            regularTimePeriod2 = regularTimePeriod2.next();
            d2 *= 1.0 + (Math.random() - 0.495) / 10.0;
        }
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        timeSeriesCollection.addSeries(timeSeries);
        return timeSeriesCollection;
    }

    public static void main(String[] arrstring) {
        InternalFrameDemo internalFrameDemo = new InternalFrameDemo("Internal Frame Demo");
        internalFrameDemo.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)internalFrameDemo));
        internalFrameDemo.setVisible(true);
    }
}

