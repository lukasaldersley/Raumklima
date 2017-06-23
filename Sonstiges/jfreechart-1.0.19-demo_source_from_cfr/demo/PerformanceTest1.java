/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.StandardXYItemRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.time.FixedMillisecond
 *  org.jfree.data.time.Millisecond
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.time.TimeSeriesDataItem
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.XYSeries
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RectangleInsets
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.Window;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.FixedMillisecond;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.TimeSeriesDataItem;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class PerformanceTest1
extends ApplicationFrame {
    private TimeSeries timings = new TimeSeries((Comparable)((Object)"Timings"));

    public PerformanceTest1(String string) {
        super(string);
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection(this.timings);
        JFreeChart jFreeChart = PerformanceTest1.createChart((XYDataset)timeSeriesCollection);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        chartPanel.setMouseZoomable(true);
        this.setContentPane((Container)chartPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Performance Test 1", (String)"Time", (String)"Milliseconds", (XYDataset)xYDataset, (boolean)true, (boolean)true, (boolean)false);
        jFreeChart.setBackgroundPaint((Paint)Color.white);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setBackgroundPaint((Paint)Color.lightGray);
        xYPlot.setDomainGridlinePaint((Paint)Color.white);
        xYPlot.setRangeGridlinePaint((Paint)Color.white);
        xYPlot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        xYPlot.setDomainCrosshairVisible(true);
        xYPlot.setRangeCrosshairVisible(true);
        XYItemRenderer xYItemRenderer = xYPlot.getRenderer();
        if (xYItemRenderer instanceof StandardXYItemRenderer) {
            StandardXYItemRenderer standardXYItemRenderer = (StandardXYItemRenderer)xYItemRenderer;
            standardXYItemRenderer.setSeriesStroke(0, (Stroke)new BasicStroke(1.1f));
        }
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = PerformanceTest1.createChart(null);
        return new ChartPanel(jFreeChart);
    }

    public void addObservation(long l) {
        this.timings.addOrUpdate((RegularTimePeriod)new Millisecond(), (double)l);
    }

    public static void main2(String[] arrstring) {
        PerformanceTest1 performanceTest1 = new PerformanceTest1("Performance Test 1");
        performanceTest1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)performanceTest1));
        performanceTest1.setVisible(true);
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Test"));
        timeSeries.setMaximumItemAge(200);
        do {
            Millisecond millisecond = new Millisecond();
            long l = System.currentTimeMillis();
            for (int i = 0; i < 200; ++i) {
                millisecond = (Millisecond)millisecond.next();
                timeSeries.addOrUpdate((RegularTimePeriod)millisecond, 1.0);
            }
            long l2 = System.currentTimeMillis();
            performanceTest1.addObservation(l2 - l);
        } while (true);
    }

    public static void main4(String[] arrstring) {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Test"));
        timeSeries.setMaximumItemCount(4000);
        FixedMillisecond fixedMillisecond = new FixedMillisecond();
        for (int i = 0; i < 40000; ++i) {
            long l = System.currentTimeMillis();
            for (int j = 0; j < 400; ++j) {
                fixedMillisecond = (FixedMillisecond)fixedMillisecond.next();
                timeSeries.add((RegularTimePeriod)fixedMillisecond, Math.random());
            }
            long l2 = System.currentTimeMillis();
            System.out.println("" + i + " --> " + (l2 - l) + " (" + Runtime.getRuntime().freeMemory() + " / " + Runtime.getRuntime().totalMemory() + ")");
        }
    }

    public static void main5(String[] arrstring) {
        XYSeries xYSeries = new XYSeries((Comparable)((Object)"Test"));
        xYSeries.setMaximumItemCount(4000);
        int n = 0;
        for (int i = 0; i < 40000; ++i) {
            long l = System.currentTimeMillis();
            for (int j = 0; j < 4000; ++j) {
                xYSeries.add((double)n++, Math.random());
            }
            long l2 = System.currentTimeMillis();
            System.out.println("" + i + " --> " + (l2 - l) + " (" + Runtime.getRuntime().freeMemory() + " / " + Runtime.getRuntime().totalMemory() + ")");
        }
    }

    public static void main(String[] arrstring) {
        int n;
        ArrayList<Double> arrayList = new ArrayList<Double>();
        for (n = 0; n < 4000; ++n) {
            arrayList.add(new Double(Math.random()));
        }
        n = 0;
        for (int i = 0; i < 20000; ++i) {
            long l = System.currentTimeMillis();
            for (int j = 0; j < 1000000; ++j) {
                n += j;
            }
            long l2 = System.currentTimeMillis();
            System.out.println("" + i + " --> " + (l2 - l) + " (" + Runtime.getRuntime().freeMemory() + " / " + Runtime.getRuntime().totalMemory() + ")");
        }
    }

    public static void main3(String[] arrstring) {
        int n;
        ArrayList<Millisecond> arrayList = new ArrayList<Millisecond>();
        Millisecond millisecond = new Millisecond();
        for (n = 0; n < 200; ++n) {
            millisecond = (Millisecond)millisecond.next();
            arrayList.add(millisecond);
        }
        for (n = 0; n < 2000; ++n) {
            long l = System.currentTimeMillis();
            Collections.binarySearch(arrayList, new Millisecond());
            long l2 = System.currentTimeMillis();
            System.out.println("" + n + " --> " + (l2 - l) + " (" + Runtime.getRuntime().freeMemory() + " / " + Runtime.getRuntime().totalMemory() + ")");
        }
    }
}

