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
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.YIntervalRenderer
 *  org.jfree.data.xy.IntervalXYDataset
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.YIntervalSeries
 *  org.jfree.data.xy.YIntervalSeriesCollection
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
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.YIntervalRenderer;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.YIntervalSeries;
import org.jfree.data.xy.YIntervalSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class YIntervalChartDemo1
extends ApplicationFrame {
    public YIntervalChartDemo1(String string) {
        super(string);
        JPanel jPanel = YIntervalChartDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 300));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(IntervalXYDataset intervalXYDataset) {
        JFreeChart jFreeChart = ChartFactory.createScatterPlot((String)"Y Interval Chart Demo 1", (String)"X", (String)"Y", (XYDataset)intervalXYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainPannable(true);
        xYPlot.setRenderer((XYItemRenderer)new YIntervalRenderer());
        return jFreeChart;
    }

    private static IntervalXYDataset createDataset() {
        double d = 100.0;
        YIntervalSeries yIntervalSeries = new YIntervalSeries((Comparable)((Object)"Series 1"));
        for (int i = 0; i < 100; ++i) {
            yIntervalSeries.add((double)i, d, d - 3.0, (d += Math.random() - 0.49) + 3.0);
        }
        YIntervalSeriesCollection yIntervalSeriesCollection = new YIntervalSeriesCollection();
        yIntervalSeriesCollection.addSeries(yIntervalSeries);
        return yIntervalSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = YIntervalChartDemo1.createChart(YIntervalChartDemo1.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        YIntervalChartDemo1 yIntervalChartDemo1 = new YIntervalChartDemo1("JFreeChart: YIntervalChartDemo1.java");
        yIntervalChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)yIntervalChartDemo1));
        yIntervalChartDemo1.setVisible(true);
    }
}

