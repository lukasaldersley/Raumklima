/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.Marker
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.ValueMarker
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.data.time.Quarter
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
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Quarter;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesDemo2
extends ApplicationFrame {
    public TimeSeriesDemo2(String string) {
        super(string);
        XYDataset xYDataset = TimeSeriesDemo2.createDataset();
        JFreeChart jFreeChart = TimeSeriesDemo2.createChart(xYDataset);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)chartPanel);
    }

    private static XYDataset createDataset() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Quarterly Data"));
        timeSeries.add((RegularTimePeriod)new Quarter(1, 2001), 500.2);
        timeSeries.add((RegularTimePeriod)new Quarter(2, 2001), 694.1);
        timeSeries.add((RegularTimePeriod)new Quarter(3, 2001), 734.4);
        timeSeries.add((RegularTimePeriod)new Quarter(4, 2001), 453.2);
        timeSeries.add((RegularTimePeriod)new Quarter(1, 2002), 500.2);
        timeSeries.add((RegularTimePeriod)new Quarter(2, 2002), null);
        timeSeries.add((RegularTimePeriod)new Quarter(3, 2002), 734.4);
        timeSeries.add((RegularTimePeriod)new Quarter(4, 2002), 453.2);
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection(timeSeries);
        return timeSeriesCollection;
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Time Series Demo 2", (String)"Time", (String)"Value", (XYDataset)xYDataset, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.addRangeMarker((Marker)new ValueMarker(550.0));
        Quarter quarter = new Quarter(2, 2002);
        xYPlot.addDomainMarker((Marker)new ValueMarker((double)quarter.getMiddleMillisecond()));
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = TimeSeriesDemo2.createChart(TimeSeriesDemo2.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        TimeSeriesDemo2 timeSeriesDemo2 = new TimeSeriesDemo2("Time Series Demo 2");
        timeSeriesDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)timeSeriesDemo2));
        timeSeriesDemo2.setVisible(true);
    }
}

