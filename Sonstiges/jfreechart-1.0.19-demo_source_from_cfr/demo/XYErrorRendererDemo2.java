/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYErrorRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.xy.IntervalXYDataset
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.YIntervalSeries
 *  org.jfree.data.xy.YIntervalSeriesCollection
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYErrorRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.YIntervalSeries;
import org.jfree.data.xy.YIntervalSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYErrorRendererDemo2
extends ApplicationFrame {
    public XYErrorRendererDemo2(String string) {
        super(string);
        JPanel jPanel = XYErrorRendererDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(IntervalXYDataset intervalXYDataset) {
        NumberAxis numberAxis = new NumberAxis("X");
        NumberAxis numberAxis2 = new NumberAxis("Y");
        XYErrorRenderer xYErrorRenderer = new XYErrorRenderer();
        xYErrorRenderer.setBaseLinesVisible(true);
        xYErrorRenderer.setBaseShapesVisible(false);
        XYPlot xYPlot = new XYPlot((XYDataset)intervalXYDataset, (ValueAxis)numberAxis, (ValueAxis)numberAxis2, (XYItemRenderer)xYErrorRenderer);
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        xYPlot.setBackgroundPaint((Paint)Color.lightGray);
        xYPlot.setDomainGridlinePaint((Paint)Color.white);
        xYPlot.setRangeGridlinePaint((Paint)Color.white);
        JFreeChart jFreeChart = new JFreeChart("XYErrorRenderer Demo 2", (Plot)xYPlot);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    private static IntervalXYDataset createDataset() {
        YIntervalSeriesCollection yIntervalSeriesCollection = new YIntervalSeriesCollection();
        YIntervalSeries yIntervalSeries = new YIntervalSeries((Comparable)((Object)"Series 1"));
        yIntervalSeries.add(1.0, 10.0, 9.0, 11.0);
        yIntervalSeries.add(10.0, 6.1, 4.34, 7.54);
        yIntervalSeries.add(17.8, 4.5, 3.1, 5.8);
        YIntervalSeries yIntervalSeries2 = new YIntervalSeries((Comparable)((Object)"Series 2"));
        yIntervalSeries2.add(3.0, 7.0, 6.0, 8.0);
        yIntervalSeries2.add(13.0, 13.0, 11.5, 14.5);
        yIntervalSeries2.add(24.0, 16.1, 14.34, 17.54);
        yIntervalSeriesCollection.addSeries(yIntervalSeries);
        yIntervalSeriesCollection.addSeries(yIntervalSeries2);
        return yIntervalSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = XYErrorRendererDemo2.createChart(XYErrorRendererDemo2.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        XYErrorRendererDemo2 xYErrorRendererDemo2 = new XYErrorRendererDemo2("JFreeChart: XYErrorRendererDemo2.java");
        xYErrorRendererDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)xYErrorRendererDemo2));
        xYErrorRendererDemo2.setVisible(true);
    }
}

