/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
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

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Shape;
import java.awt.Window;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
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

public class TimeSeriesDemo9
extends ApplicationFrame {
    public TimeSeriesDemo9(String string) {
        super(string);
        XYDataset xYDataset = TimeSeriesDemo9.createDataset();
        JFreeChart jFreeChart = TimeSeriesDemo9.createChart(xYDataset);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)chartPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Time Series Demo 9", (String)"Date", (String)"Price Per Unit", (XYDataset)xYDataset, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        XYItemRenderer xYItemRenderer = xYPlot.getRenderer();
        if (xYItemRenderer instanceof XYLineAndShapeRenderer) {
            XYLineAndShapeRenderer xYLineAndShapeRenderer = (XYLineAndShapeRenderer)xYItemRenderer;
            xYLineAndShapeRenderer.setBaseShapesVisible(true);
            xYLineAndShapeRenderer.setBaseShapesFilled(true);
            xYLineAndShapeRenderer.setSeriesShape(0, (Shape)new Ellipse2D.Double(-3.0, -3.0, 6.0, 6.0));
            xYLineAndShapeRenderer.setSeriesShape(1, (Shape)new Rectangle2D.Double(-3.0, -3.0, 6.0, 6.0));
            GeneralPath generalPath = new GeneralPath();
            generalPath.moveTo(0.0f, -3.0f);
            generalPath.lineTo(3.0f, 3.0f);
            generalPath.lineTo(-3.0f, 3.0f);
            generalPath.closePath();
            xYLineAndShapeRenderer.setSeriesShape(2, (Shape)generalPath);
            GeneralPath generalPath2 = new GeneralPath();
            generalPath2.moveTo(-1.0f, -3.0f);
            generalPath2.lineTo(1.0f, -3.0f);
            generalPath2.lineTo(1.0f, -1.0f);
            generalPath2.lineTo(3.0f, -1.0f);
            generalPath2.lineTo(3.0f, 1.0f);
            generalPath2.lineTo(1.0f, 1.0f);
            generalPath2.lineTo(1.0f, 3.0f);
            generalPath2.lineTo(-1.0f, 3.0f);
            generalPath2.lineTo(-1.0f, 1.0f);
            generalPath2.lineTo(-3.0f, 1.0f);
            generalPath2.lineTo(-3.0f, -1.0f);
            generalPath2.lineTo(-1.0f, -1.0f);
            generalPath2.closePath();
            xYLineAndShapeRenderer.setSeriesShape(3, (Shape)generalPath2);
        }
        xYPlot.getDomainAxis().setVisible(false);
        xYPlot.getRangeAxis().setVisible(false);
        return jFreeChart;
    }

    private static XYDataset createDataset() {
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        for (int i = 0; i < 4; ++i) {
            timeSeriesCollection.addSeries(TimeSeriesDemo9.createTimeSeries(i, 10));
        }
        return timeSeriesCollection;
    }

    private static TimeSeries createTimeSeries(int n, int n2) {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)("Series " + n)));
        Day day = new Day();
        for (int i = 0; i < n2; ++i) {
            timeSeries.add((RegularTimePeriod)day, Math.random());
            day = (Day)day.next();
        }
        return timeSeries;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = TimeSeriesDemo9.createChart(TimeSeriesDemo9.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        TimeSeriesDemo9 timeSeriesDemo9 = new TimeSeriesDemo9("Time Series Demo 9");
        timeSeriesDemo9.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)timeSeriesDemo9));
        timeSeriesDemo9.setVisible(true);
    }
}

