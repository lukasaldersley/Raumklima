/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.ClusteredXYBarRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.time.Day
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.IntervalXYDataset
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
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.ClusteredXYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYBarChartDemo2
extends ApplicationFrame {
    public XYBarChartDemo2(String string) {
        super(string);
        JPanel jPanel = XYBarChartDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 300));
        this.setContentPane((Container)jPanel);
    }

    private static IntervalXYDataset createDataset() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Series 1"));
        timeSeries.add((RegularTimePeriod)new Day(1, 1, 2003), 54.3);
        timeSeries.add((RegularTimePeriod)new Day(2, 1, 2003), 20.3);
        timeSeries.add((RegularTimePeriod)new Day(3, 1, 2003), 43.4);
        timeSeries.add((RegularTimePeriod)new Day(4, 1, 2003), -12.0);
        TimeSeries timeSeries2 = new TimeSeries((Comparable)((Object)"Series 2"));
        timeSeries2.add((RegularTimePeriod)new Day(1, 1, 2003), 8.0);
        timeSeries2.add((RegularTimePeriod)new Day(2, 1, 2003), 16.0);
        timeSeries2.add((RegularTimePeriod)new Day(3, 1, 2003), 21.0);
        timeSeries2.add((RegularTimePeriod)new Day(4, 1, 2003), 5.0);
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        timeSeriesCollection.addSeries(timeSeries);
        timeSeriesCollection.addSeries(timeSeries2);
        return timeSeriesCollection;
    }

    private static JFreeChart createChart(IntervalXYDataset intervalXYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYBarChart((String)"XY Bar Chart Demo 2", (String)"Date", (boolean)true, (String)"Y", (IntervalXYDataset)intervalXYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        ClusteredXYBarRenderer clusteredXYBarRenderer = new ClusteredXYBarRenderer(0.0, false);
        xYPlot.setRenderer((XYItemRenderer)clusteredXYBarRenderer);
        clusteredXYBarRenderer.setDrawBarOutline(false);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        return new ChartPanel(XYBarChartDemo2.createChart(XYBarChartDemo2.createDataset()));
    }

    public static void main(String[] arrstring) {
        XYBarChartDemo2 xYBarChartDemo2 = new XYBarChartDemo2("JFreeChart: XYBarChartDemo2.java");
        xYBarChartDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)xYBarChartDemo2));
        xYBarChartDemo2.setVisible(true);
    }
}

