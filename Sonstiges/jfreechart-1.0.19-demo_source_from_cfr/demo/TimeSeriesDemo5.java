/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.SamplingXYLineRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.general.SeriesException
 *  org.jfree.data.time.Day
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
import java.io.PrintStream;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.SamplingXYLineRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.general.SeriesException;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesDemo5
extends ApplicationFrame {
    public TimeSeriesDemo5(String string) {
        super(string);
        JPanel jPanel = TimeSeriesDemo5.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static XYDataset createDataset() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Random Data"));
        Day day = new Day(1, 1, 1990);
        double d = 100.0;
        for (int i = 0; i < 100000; ++i) {
            try {
                d = d + Math.random() - 0.5;
                timeSeries.add((RegularTimePeriod)day, (Number)new Double(d));
                day = (Day)day.next();
                continue;
            }
            catch (SeriesException seriesException) {
                System.err.println("Error adding to series");
            }
        }
        return new TimeSeriesCollection(timeSeries);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Test", (String)"Day", (String)"Value", (XYDataset)xYDataset, (boolean)false, (boolean)false, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainPannable(true);
        SamplingXYLineRenderer samplingXYLineRenderer = new SamplingXYLineRenderer();
        xYPlot.setRenderer((XYItemRenderer)samplingXYLineRenderer);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = TimeSeriesDemo5.createChart(TimeSeriesDemo5.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        String string = "\u20a2\u20a2\u20a2\u20a3\u20a4\u20a5\u20a6\u20a7\u20a8\u20a9\u20aa";
        TimeSeriesDemo5 timeSeriesDemo5 = new TimeSeriesDemo5(string);
        timeSeriesDemo5.pack();
        RefineryUtilities.positionFrameRandomly((Window)((Object)timeSeriesDemo5));
        timeSeriesDemo5.setVisible(true);
    }
}

