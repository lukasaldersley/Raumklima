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
 *  org.jfree.data.time.Month
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
import org.jfree.data.time.Month;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesDemo1
extends ApplicationFrame {
    public TimeSeriesDemo1(String string) {
        super(string);
        JPanel jPanel = TimeSeriesDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        XYLineAndShapeRenderer xYLineAndShapeRenderer;
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Legal & General Unit Trust Prices", (String)"Date", (String)"Price Per Unit", (XYDataset)xYDataset, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(false);
        xYPlot.setDomainCrosshairVisible(true);
        xYPlot.setRangeCrosshairVisible(true);
        XYItemRenderer xYItemRenderer = xYPlot.getRenderer();
        if (xYItemRenderer instanceof XYLineAndShapeRenderer) {
            xYLineAndShapeRenderer = (XYLineAndShapeRenderer)xYItemRenderer;
            xYLineAndShapeRenderer.setBaseShapesVisible(false);
        }
        xYLineAndShapeRenderer = (DateAxis)xYPlot.getDomainAxis();
        xYLineAndShapeRenderer.setDateFormatOverride((DateFormat)new SimpleDateFormat("MMM-yyyy"));
        return jFreeChart;
    }

    private static XYDataset createDataset() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"L&G European Index Trust"));
        timeSeries.add((RegularTimePeriod)new Month(2, 2001), 181.8);
        timeSeries.add((RegularTimePeriod)new Month(3, 2001), 167.3);
        timeSeries.add((RegularTimePeriod)new Month(4, 2001), 153.8);
        timeSeries.add((RegularTimePeriod)new Month(5, 2001), 167.6);
        timeSeries.add((RegularTimePeriod)new Month(6, 2001), 158.8);
        timeSeries.add((RegularTimePeriod)new Month(7, 2001), 148.3);
        timeSeries.add((RegularTimePeriod)new Month(8, 2001), 153.9);
        timeSeries.add((RegularTimePeriod)new Month(9, 2001), 142.7);
        timeSeries.add((RegularTimePeriod)new Month(10, 2001), 123.2);
        timeSeries.add((RegularTimePeriod)new Month(11, 2001), 131.8);
        timeSeries.add((RegularTimePeriod)new Month(12, 2001), 139.6);
        timeSeries.add((RegularTimePeriod)new Month(1, 2002), 142.9);
        timeSeries.add((RegularTimePeriod)new Month(2, 2002), 138.7);
        timeSeries.add((RegularTimePeriod)new Month(3, 2002), 137.3);
        timeSeries.add((RegularTimePeriod)new Month(4, 2002), 143.9);
        timeSeries.add((RegularTimePeriod)new Month(5, 2002), 139.8);
        timeSeries.add((RegularTimePeriod)new Month(6, 2002), 137.0);
        timeSeries.add((RegularTimePeriod)new Month(7, 2002), 132.8);
        timeSeries.add((RegularTimePeriod)new Month(8, 2002), 110.3);
        timeSeries.add((RegularTimePeriod)new Month(9, 2002), 110.5);
        timeSeries.add((RegularTimePeriod)new Month(10, 2002), 94.11);
        timeSeries.add((RegularTimePeriod)new Month(11, 2002), 102.5);
        timeSeries.add((RegularTimePeriod)new Month(12, 2002), 112.3);
        timeSeries.add((RegularTimePeriod)new Month(1, 2003), 104.0);
        timeSeries.add((RegularTimePeriod)new Month(2, 2003), 98.53);
        timeSeries.add((RegularTimePeriod)new Month(3, 2003), 97.15);
        timeSeries.add((RegularTimePeriod)new Month(4, 2003), 94.9);
        timeSeries.add((RegularTimePeriod)new Month(5, 2003), 107.8);
        timeSeries.add((RegularTimePeriod)new Month(6, 2003), 113.7);
        timeSeries.add((RegularTimePeriod)new Month(7, 2003), 112.5);
        timeSeries.add((RegularTimePeriod)new Month(8, 2003), 118.6);
        timeSeries.add((RegularTimePeriod)new Month(9, 2003), 123.8);
        timeSeries.add((RegularTimePeriod)new Month(10, 2003), 117.2);
        timeSeries.add((RegularTimePeriod)new Month(11, 2003), 123.0);
        timeSeries.add((RegularTimePeriod)new Month(12, 2003), 127.0);
        timeSeries.add((RegularTimePeriod)new Month(1, 2004), 132.7);
        timeSeries.add((RegularTimePeriod)new Month(2, 2004), 132.4);
        timeSeries.add((RegularTimePeriod)new Month(3, 2004), 131.7);
        timeSeries.add((RegularTimePeriod)new Month(4, 2004), 128.0);
        timeSeries.add((RegularTimePeriod)new Month(5, 2004), 131.8);
        timeSeries.add((RegularTimePeriod)new Month(6, 2004), 127.4);
        timeSeries.add((RegularTimePeriod)new Month(7, 2004), 133.5);
        timeSeries.add((RegularTimePeriod)new Month(8, 2004), 126.0);
        timeSeries.add((RegularTimePeriod)new Month(9, 2004), 129.5);
        timeSeries.add((RegularTimePeriod)new Month(10, 2004), 135.3);
        timeSeries.add((RegularTimePeriod)new Month(11, 2004), 138.0);
        timeSeries.add((RegularTimePeriod)new Month(12, 2004), 141.3);
        timeSeries.add((RegularTimePeriod)new Month(1, 2005), 148.8);
        timeSeries.add((RegularTimePeriod)new Month(2, 2005), 147.1);
        timeSeries.add((RegularTimePeriod)new Month(3, 2005), 150.7);
        timeSeries.add((RegularTimePeriod)new Month(4, 2005), 150.0);
        timeSeries.add((RegularTimePeriod)new Month(5, 2005), 145.7);
        timeSeries.add((RegularTimePeriod)new Month(6, 2005), 152.0);
        timeSeries.add((RegularTimePeriod)new Month(7, 2005), 157.2);
        timeSeries.add((RegularTimePeriod)new Month(8, 2005), 167.0);
        timeSeries.add((RegularTimePeriod)new Month(9, 2005), 165.0);
        timeSeries.add((RegularTimePeriod)new Month(10, 2005), 171.6);
        timeSeries.add((RegularTimePeriod)new Month(11, 2005), 166.2);
        timeSeries.add((RegularTimePeriod)new Month(12, 2005), 174.3);
        timeSeries.add((RegularTimePeriod)new Month(1, 2006), 183.8);
        timeSeries.add((RegularTimePeriod)new Month(2, 2006), 187.0);
        timeSeries.add((RegularTimePeriod)new Month(3, 2006), 191.3);
        timeSeries.add((RegularTimePeriod)new Month(4, 2006), 202.5);
        timeSeries.add((RegularTimePeriod)new Month(5, 2006), 200.6);
        timeSeries.add((RegularTimePeriod)new Month(6, 2006), 187.3);
        timeSeries.add((RegularTimePeriod)new Month(7, 2006), 192.2);
        timeSeries.add((RegularTimePeriod)new Month(8, 2006), 190.8);
        timeSeries.add((RegularTimePeriod)new Month(9, 2006), 194.7);
        timeSeries.add((RegularTimePeriod)new Month(10, 2006), 201.3);
        timeSeries.add((RegularTimePeriod)new Month(11, 2006), 205.1);
        timeSeries.add((RegularTimePeriod)new Month(12, 2006), 206.7);
        timeSeries.add((RegularTimePeriod)new Month(1, 2007), 216.8);
        timeSeries.add((RegularTimePeriod)new Month(2, 2007), 218.0);
        timeSeries.add((RegularTimePeriod)new Month(3, 2007), 215.4);
        timeSeries.add((RegularTimePeriod)new Month(4, 2007), 223.0);
        timeSeries.add((RegularTimePeriod)new Month(5, 2007), 235.1);
        timeSeries.add((RegularTimePeriod)new Month(6, 2007), 242.0);
        timeSeries.add((RegularTimePeriod)new Month(7, 2007), 237.8);
        TimeSeries timeSeries2 = new TimeSeries((Comparable)((Object)"L&G UK Index Trust"));
        timeSeries2.add((RegularTimePeriod)new Month(2, 2001), 129.6);
        timeSeries2.add((RegularTimePeriod)new Month(3, 2001), 123.2);
        timeSeries2.add((RegularTimePeriod)new Month(4, 2001), 117.2);
        timeSeries2.add((RegularTimePeriod)new Month(5, 2001), 124.1);
        timeSeries2.add((RegularTimePeriod)new Month(6, 2001), 122.6);
        timeSeries2.add((RegularTimePeriod)new Month(7, 2001), 119.2);
        timeSeries2.add((RegularTimePeriod)new Month(8, 2001), 116.5);
        timeSeries2.add((RegularTimePeriod)new Month(9, 2001), 112.7);
        timeSeries2.add((RegularTimePeriod)new Month(10, 2001), 101.5);
        timeSeries2.add((RegularTimePeriod)new Month(11, 2001), 106.1);
        timeSeries2.add((RegularTimePeriod)new Month(12, 2001), 110.3);
        timeSeries2.add((RegularTimePeriod)new Month(1, 2002), 111.7);
        timeSeries2.add((RegularTimePeriod)new Month(2, 2002), 111.0);
        timeSeries2.add((RegularTimePeriod)new Month(3, 2002), 109.6);
        timeSeries2.add((RegularTimePeriod)new Month(4, 2002), 113.2);
        timeSeries2.add((RegularTimePeriod)new Month(5, 2002), 111.6);
        timeSeries2.add((RegularTimePeriod)new Month(6, 2002), 108.8);
        timeSeries2.add((RegularTimePeriod)new Month(7, 2002), 101.6);
        timeSeries2.add((RegularTimePeriod)new Month(8, 2002), 90.95);
        timeSeries2.add((RegularTimePeriod)new Month(9, 2002), 91.02);
        timeSeries2.add((RegularTimePeriod)new Month(10, 2002), 82.37);
        timeSeries2.add((RegularTimePeriod)new Month(11, 2002), 86.32);
        timeSeries2.add((RegularTimePeriod)new Month(12, 2002), 91.0);
        timeSeries2.add((RegularTimePeriod)new Month(1, 2003), 86.0);
        timeSeries2.add((RegularTimePeriod)new Month(2, 2003), 80.04);
        timeSeries2.add((RegularTimePeriod)new Month(3, 2003), 80.4);
        timeSeries2.add((RegularTimePeriod)new Month(4, 2003), 80.28);
        timeSeries2.add((RegularTimePeriod)new Month(5, 2003), 86.42);
        timeSeries2.add((RegularTimePeriod)new Month(6, 2003), 91.4);
        timeSeries2.add((RegularTimePeriod)new Month(7, 2003), 90.52);
        timeSeries2.add((RegularTimePeriod)new Month(8, 2003), 93.11);
        timeSeries2.add((RegularTimePeriod)new Month(9, 2003), 96.8);
        timeSeries2.add((RegularTimePeriod)new Month(10, 2003), 94.78);
        timeSeries2.add((RegularTimePeriod)new Month(11, 2003), 99.56);
        timeSeries2.add((RegularTimePeriod)new Month(12, 2003), 100.8);
        timeSeries2.add((RegularTimePeriod)new Month(1, 2004), 103.4);
        timeSeries2.add((RegularTimePeriod)new Month(2, 2004), 102.1);
        timeSeries2.add((RegularTimePeriod)new Month(3, 2004), 105.3);
        timeSeries2.add((RegularTimePeriod)new Month(4, 2004), 103.7);
        timeSeries2.add((RegularTimePeriod)new Month(5, 2004), 105.2);
        timeSeries2.add((RegularTimePeriod)new Month(6, 2004), 103.7);
        timeSeries2.add((RegularTimePeriod)new Month(7, 2004), 105.7);
        timeSeries2.add((RegularTimePeriod)new Month(8, 2004), 103.6);
        timeSeries2.add((RegularTimePeriod)new Month(9, 2004), 106.1);
        timeSeries2.add((RegularTimePeriod)new Month(10, 2004), 109.3);
        timeSeries2.add((RegularTimePeriod)new Month(11, 2004), 110.3);
        timeSeries2.add((RegularTimePeriod)new Month(12, 2004), 112.6);
        timeSeries2.add((RegularTimePeriod)new Month(1, 2005), 116.0);
        timeSeries2.add((RegularTimePeriod)new Month(2, 2005), 117.3);
        timeSeries2.add((RegularTimePeriod)new Month(3, 2005), 120.1);
        timeSeries2.add((RegularTimePeriod)new Month(4, 2005), 119.3);
        timeSeries2.add((RegularTimePeriod)new Month(5, 2005), 116.2);
        timeSeries2.add((RegularTimePeriod)new Month(6, 2005), 120.8);
        timeSeries2.add((RegularTimePeriod)new Month(7, 2005), 125.2);
        timeSeries2.add((RegularTimePeriod)new Month(8, 2005), 127.7);
        timeSeries2.add((RegularTimePeriod)new Month(9, 2005), 130.8);
        timeSeries2.add((RegularTimePeriod)new Month(10, 2005), 131.0);
        timeSeries2.add((RegularTimePeriod)new Month(11, 2005), 135.3);
        timeSeries2.add((RegularTimePeriod)new Month(12, 2005), 141.2);
        timeSeries2.add((RegularTimePeriod)new Month(1, 2006), 144.7);
        timeSeries2.add((RegularTimePeriod)new Month(2, 2006), 146.4);
        timeSeries2.add((RegularTimePeriod)new Month(3, 2006), 151.9);
        timeSeries2.add((RegularTimePeriod)new Month(4, 2006), 153.5);
        timeSeries2.add((RegularTimePeriod)new Month(5, 2006), 144.5);
        timeSeries2.add((RegularTimePeriod)new Month(6, 2006), 150.1);
        timeSeries2.add((RegularTimePeriod)new Month(7, 2006), 148.7);
        timeSeries2.add((RegularTimePeriod)new Month(8, 2006), 150.1);
        timeSeries2.add((RegularTimePeriod)new Month(9, 2006), 151.6);
        timeSeries2.add((RegularTimePeriod)new Month(10, 2006), 153.4);
        timeSeries2.add((RegularTimePeriod)new Month(11, 2006), 158.3);
        timeSeries2.add((RegularTimePeriod)new Month(12, 2006), 157.6);
        timeSeries2.add((RegularTimePeriod)new Month(1, 2007), 163.9);
        timeSeries2.add((RegularTimePeriod)new Month(2, 2007), 163.8);
        timeSeries2.add((RegularTimePeriod)new Month(3, 2007), 162.0);
        timeSeries2.add((RegularTimePeriod)new Month(4, 2007), 167.1);
        timeSeries2.add((RegularTimePeriod)new Month(5, 2007), 170.0);
        timeSeries2.add((RegularTimePeriod)new Month(6, 2007), 175.7);
        timeSeries2.add((RegularTimePeriod)new Month(7, 2007), 171.9);
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        timeSeriesCollection.addSeries(timeSeries);
        timeSeriesCollection.addSeries(timeSeries2);
        return timeSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = TimeSeriesDemo1.createChart(TimeSeriesDemo1.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        TimeSeriesDemo1 timeSeriesDemo1 = new TimeSeriesDemo1("Time Series Demo 1");
        timeSeriesDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)timeSeriesDemo1));
        timeSeriesDemo1.setVisible(true);
    }
}

