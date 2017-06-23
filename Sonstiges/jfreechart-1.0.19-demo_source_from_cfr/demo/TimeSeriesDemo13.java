/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.DateTickUnit
 *  org.jfree.chart.axis.DateTickUnitType
 *  org.jfree.chart.axis.TickUnit
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.TickUnits
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.time.Week
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Window;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.DateTickUnitType;
import org.jfree.chart.axis.TickUnit;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.TickUnits;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Week;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesDemo13
extends ApplicationFrame {
    public TimeSeriesDemo13(String string) {
        super(string);
        this.setContentPane((Container)TimeSeriesDemo13.createDemoPanel());
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        XYLineAndShapeRenderer xYLineAndShapeRenderer;
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Weekly Data", (String)"Date", (String)"Value", (XYDataset)xYDataset, (boolean)true, (boolean)true, (boolean)false);
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
        TickUnits tickUnits = new TickUnits();
        tickUnits.add((TickUnit)new DateTickUnit(DateTickUnitType.DAY, 1, (DateFormat)new SimpleDateFormat("MMM dd ''yy")));
        tickUnits.add((TickUnit)new DateTickUnit(DateTickUnitType.DAY, 7, (DateFormat)new SimpleDateFormat("MMM dd ''yy")));
        tickUnits.add((TickUnit)new DateTickUnit(DateTickUnitType.MONTH, 1, (DateFormat)new SimpleDateFormat("MMM ''yy")));
        xYLineAndShapeRenderer.setStandardTickUnits((TickUnitSource)tickUnits);
        return jFreeChart;
    }

    private static XYDataset createDataset(int n) {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Random Data"));
        Week week = new Week();
        double d = 100.0;
        for (int i = 0; i < n; ++i) {
            timeSeries.add((RegularTimePeriod)week, d);
            d *= 1.0 + (Math.random() - 0.499) / 100.0;
            week = week.next();
        }
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection(timeSeries);
        return timeSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        XYDataset xYDataset = TimeSeriesDemo13.createDataset(26);
        JFreeChart jFreeChart = TimeSeriesDemo13.createChart(xYDataset);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        XYDataset xYDataset2 = TimeSeriesDemo13.createDataset(1);
        JFreeChart jFreeChart2 = TimeSeriesDemo13.createChart(xYDataset2);
        ChartPanel chartPanel2 = new ChartPanel(jFreeChart2);
        JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.add("Chart 1", (Component)chartPanel);
        jTabbedPane.add("Chart 2", (Component)chartPanel2);
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setPreferredSize(new Dimension(500, 270));
        jPanel.add(jTabbedPane);
        return jPanel;
    }

    public static void main(String[] arrstring) {
        TimeSeriesDemo13 timeSeriesDemo13 = new TimeSeriesDemo13("Time Series Demo 13");
        timeSeriesDemo13.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)timeSeriesDemo13));
        timeSeriesDemo13.setVisible(true);
    }
}

