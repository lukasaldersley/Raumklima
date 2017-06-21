/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Marker
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.ValueMarker
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.data.time.Day
 *  org.jfree.data.time.Hour
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RectangleInsets
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.ui.about.ProjectInfo
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.about.ProjectInfo;

public class TimeSeriesDemo4
extends ApplicationFrame {
    public TimeSeriesDemo4(String string) {
        super(string);
        XYDataset xYDataset = TimeSeriesDemo4.createDataset();
        JFreeChart jFreeChart = TimeSeriesDemo4.createChart(xYDataset);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        chartPanel.setMouseZoomable(true);
        this.setContentPane((Container)chartPanel);
    }

    private static XYDataset createDataset() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Random Data"));
        Day day = new Day();
        timeSeries.add((RegularTimePeriod)new Hour(0, day), 500.2);
        timeSeries.add((RegularTimePeriod)new Hour(2, day), 694.1);
        timeSeries.add((RegularTimePeriod)new Hour(3, day), 734.4);
        timeSeries.add((RegularTimePeriod)new Hour(4, day), 453.2);
        timeSeries.add((RegularTimePeriod)new Hour(7, day), 500.2);
        timeSeries.add((RegularTimePeriod)new Hour(8, day), null);
        timeSeries.add((RegularTimePeriod)new Hour(12, day), 734.4);
        timeSeries.add((RegularTimePeriod)new Hour(16, day), 453.2);
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection(timeSeries);
        return timeSeriesCollection;
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        String string = "\u20a2\u20a2\u20a3\u20a4\u20a5\u20a6\u20a7\u20a8\u20a9\u20aa";
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)string, (String)"Time", (String)"Value", (XYDataset)xYDataset, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setInsets(new RectangleInsets(0.0, 0.0, 0.0, 20.0));
        ValueMarker valueMarker = new ValueMarker(700.0);
        valueMarker.setPaint((Paint)Color.blue);
        valueMarker.setAlpha(0.8f);
        xYPlot.addRangeMarker((Marker)valueMarker);
        xYPlot.setBackgroundPaint(null);
        xYPlot.setBackgroundImage(JFreeChart.INFO.getLogo());
        xYPlot.getDomainAxis().setLowerMargin(0.0);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = TimeSeriesDemo4.createChart(TimeSeriesDemo4.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        TimeSeriesDemo4 timeSeriesDemo4 = new TimeSeriesDemo4("Time Series Demo 4");
        timeSeriesDemo4.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)timeSeriesDemo4));
        timeSeriesDemo4.setVisible(true);
    }
}

