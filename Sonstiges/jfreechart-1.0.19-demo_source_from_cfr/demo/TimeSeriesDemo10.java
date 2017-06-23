/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.data.time.Hour
 *  org.jfree.data.time.Minute
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Minute;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesDemo10
extends ApplicationFrame {
    public TimeSeriesDemo10(String string) {
        super(string);
        XYDataset xYDataset = TimeSeriesDemo10.createDataset();
        JFreeChart jFreeChart = TimeSeriesDemo10.createChart(xYDataset);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)chartPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Time Series Demo 10", (String)"Time", (String)"Value", (XYDataset)xYDataset, (boolean)true, (boolean)true, (boolean)false);
        return jFreeChart;
    }

    private static XYDataset createDataset() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Per Minute Data"));
        Hour hour = new Hour();
        timeSeries.add((RegularTimePeriod)new Minute(1, hour), 10.2);
        timeSeries.add((RegularTimePeriod)new Minute(3, hour), 17.3);
        timeSeries.add((RegularTimePeriod)new Minute(9, hour), 14.6);
        timeSeries.add((RegularTimePeriod)new Minute(11, hour), 11.9);
        timeSeries.add((RegularTimePeriod)new Minute(15, hour), 13.5);
        timeSeries.add((RegularTimePeriod)new Minute(19, hour), 10.9);
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection(timeSeries);
        return timeSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = TimeSeriesDemo10.createChart(TimeSeriesDemo10.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        TimeSeriesDemo10 timeSeriesDemo10 = new TimeSeriesDemo10("Time Series Demo 10");
        timeSeriesDemo10.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)timeSeriesDemo10));
        timeSeriesDemo10.setVisible(true);
    }
}

