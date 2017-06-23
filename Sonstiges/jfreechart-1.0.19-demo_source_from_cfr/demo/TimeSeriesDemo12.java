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
 *  org.jfree.data.time.Minute
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.BasicStroke;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Stroke;
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
import org.jfree.data.time.Minute;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesDemo12
extends ApplicationFrame {
    public TimeSeriesDemo12(String string) {
        super(string);
        XYDataset xYDataset = TimeSeriesDemo12.createDataset();
        JFreeChart jFreeChart = TimeSeriesDemo12.createChart(xYDataset);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        chartPanel.setMouseZoomable(true);
        this.setContentPane((Container)chartPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        XYLineAndShapeRenderer xYLineAndShapeRenderer;
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Sample Chart", (String)"Date", (String)"Value", (XYDataset)xYDataset, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainCrosshairVisible(true);
        xYPlot.setRangeCrosshairVisible(false);
        XYItemRenderer xYItemRenderer = xYPlot.getRenderer();
        if (xYItemRenderer instanceof XYLineAndShapeRenderer) {
            xYLineAndShapeRenderer = (XYLineAndShapeRenderer)xYItemRenderer;
            xYLineAndShapeRenderer.setBaseShapesVisible(true);
            xYLineAndShapeRenderer.setBaseShapesFilled(true);
            xYItemRenderer.setSeriesStroke(0, (Stroke)new BasicStroke(2.0f));
            xYItemRenderer.setSeriesStroke(1, (Stroke)new BasicStroke(2.0f));
        }
        xYLineAndShapeRenderer = (DateAxis)xYPlot.getDomainAxis();
        xYLineAndShapeRenderer.setDateFormatOverride((DateFormat)new SimpleDateFormat("hh:mma"));
        return jFreeChart;
    }

    private static XYDataset createDataset() {
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Series 1"));
        timeSeries.add((RegularTimePeriod)new Minute(0, 0, 7, 12, 2003), 1.2);
        timeSeries.add((RegularTimePeriod)new Minute(30, 12, 7, 12, 2003), 3.0);
        timeSeries.add((RegularTimePeriod)new Minute(15, 14, 7, 12, 2003), 8.0);
        TimeSeries timeSeries2 = new TimeSeries((Comparable)((Object)"Series 2"));
        timeSeries2.add((RegularTimePeriod)new Minute(0, 3, 7, 12, 2003), 0.0);
        timeSeries2.add((RegularTimePeriod)new Minute(30, 9, 7, 12, 2003), 0.0);
        timeSeries2.add((RegularTimePeriod)new Minute(15, 10, 7, 12, 2003), 0.0);
        timeSeriesCollection.addSeries(timeSeries);
        timeSeriesCollection.addSeries(timeSeries2);
        return timeSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = TimeSeriesDemo12.createChart(TimeSeriesDemo12.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        TimeSeriesDemo12 timeSeriesDemo12 = new TimeSeriesDemo12("Time Series Demo 12");
        timeSeriesDemo12.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)timeSeriesDemo12));
        timeSeriesDemo12.setVisible(true);
    }
}

