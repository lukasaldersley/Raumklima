/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
 *  org.jfree.chart.util.RelativeDateFormat
 *  org.jfree.data.time.Minute
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.Second
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
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.util.RelativeDateFormat;
import org.jfree.data.time.Minute;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class RelativeDateFormatDemo1
extends ApplicationFrame {
    public RelativeDateFormatDemo1(String string) {
        super(string);
        JPanel jPanel = RelativeDateFormatDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        XYLineAndShapeRenderer xYLineAndShapeRenderer;
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Exercise Chart", (String)"Elapsed Time", (String)"Beats Per Minute", (XYDataset)xYDataset, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainCrosshairVisible(true);
        xYPlot.setRangeCrosshairVisible(true);
        XYItemRenderer xYItemRenderer = xYPlot.getRenderer();
        if (xYItemRenderer instanceof XYLineAndShapeRenderer) {
            xYLineAndShapeRenderer = (XYLineAndShapeRenderer)xYItemRenderer;
            xYLineAndShapeRenderer.setBaseShapesVisible(true);
            xYLineAndShapeRenderer.setBaseShapesFilled(true);
        }
        xYLineAndShapeRenderer = (DateAxis)xYPlot.getDomainAxis();
        Minute minute = new Minute(0, 9, 1, 10, 2006);
        RelativeDateFormat relativeDateFormat = new RelativeDateFormat(minute.getFirstMillisecond());
        relativeDateFormat.setSecondFormatter((NumberFormat)new DecimalFormat("00"));
        xYLineAndShapeRenderer.setDateFormatOverride((DateFormat)relativeDateFormat);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    private static XYDataset createDataset() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Heart Rate"));
        timeSeries.add((RegularTimePeriod)new Second(45, 6, 9, 1, 10, 2006), 143.0);
        timeSeries.add((RegularTimePeriod)new Second(33, 8, 9, 1, 10, 2006), 167.0);
        timeSeries.add((RegularTimePeriod)new Second(10, 10, 9, 1, 10, 2006), 189.0);
        timeSeries.add((RegularTimePeriod)new Second(19, 12, 9, 1, 10, 2006), 156.0);
        timeSeries.add((RegularTimePeriod)new Second(5, 15, 9, 1, 10, 2006), 176.0);
        timeSeries.add((RegularTimePeriod)new Second(12, 16, 9, 1, 10, 2006), 183.0);
        timeSeries.add((RegularTimePeriod)new Second(6, 18, 9, 1, 10, 2006), 138.0);
        timeSeries.add((RegularTimePeriod)new Second(11, 20, 9, 1, 10, 2006), 102.0);
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        timeSeriesCollection.addSeries(timeSeries);
        return timeSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = RelativeDateFormatDemo1.createChart(RelativeDateFormatDemo1.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        RelativeDateFormatDemo1 relativeDateFormatDemo1 = new RelativeDateFormatDemo1("JFreeChart: RelativeDateFormatDemo1.java");
        relativeDateFormatDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)relativeDateFormatDemo1));
        relativeDateFormatDemo1.setVisible(true);
    }
}

