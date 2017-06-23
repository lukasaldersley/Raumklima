/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
 *  org.jfree.data.time.Day
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Window;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesDemo15
extends ApplicationFrame {
    public TimeSeriesDemo15(String string) {
        super(string);
        JPanel jPanel = TimeSeriesDemo15.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        XYLineAndShapeRenderer xYLineAndShapeRenderer;
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Bug Report Submissions for Java", (String)"Date", (String)"Evaluation ID", (XYDataset)xYDataset, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainCrosshairVisible(true);
        xYPlot.setRangeCrosshairVisible(true);
        XYItemRenderer xYItemRenderer = xYPlot.getRenderer();
        if (xYItemRenderer instanceof XYLineAndShapeRenderer) {
            xYLineAndShapeRenderer = (XYLineAndShapeRenderer)xYItemRenderer;
            xYLineAndShapeRenderer.setBaseShapesVisible(true);
            xYLineAndShapeRenderer.setBaseShapesFilled(true);
            xYLineAndShapeRenderer.setUseFillPaint(true);
            xYLineAndShapeRenderer.setBaseFillPaint((Paint)Color.white);
        }
        xYLineAndShapeRenderer = (DateAxis)xYPlot.getDomainAxis();
        xYLineAndShapeRenderer.setDateFormatOverride((DateFormat)new SimpleDateFormat("MMM-yyyy"));
        return jFreeChart;
    }

    private static XYDataset createDataset() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Bugs"));
        timeSeries.add((RegularTimePeriod)new Day(27, 6, 2005), 478474.0);
        timeSeries.add((RegularTimePeriod)new Day(24, 1, 2006), 633804.0);
        timeSeries.add((RegularTimePeriod)new Day(28, 4, 2006), 694096.0);
        timeSeries.add((RegularTimePeriod)new Day(12, 5, 2006), 704680.0);
        timeSeries.add((RegularTimePeriod)new Day(16, 5, 2006), 709599.0);
        timeSeries.add((RegularTimePeriod)new Day(21, 6, 2006), 734754.0);
        timeSeries.add((RegularTimePeriod)new Day(27, 7, 2006), 760008.0);
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        timeSeriesCollection.addSeries(timeSeries);
        return timeSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = TimeSeriesDemo15.createChart(TimeSeriesDemo15.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        TimeSeriesDemo15 timeSeriesDemo15 = new TimeSeriesDemo15("Time Series Demo 15");
        timeSeriesDemo15.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)timeSeriesDemo15));
        timeSeriesDemo15.setVisible(true);
    }
}

