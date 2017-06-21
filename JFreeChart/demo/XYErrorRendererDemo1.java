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
 *  org.jfree.data.xy.XYIntervalSeries
 *  org.jfree.data.xy.XYIntervalSeriesCollection
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
import org.jfree.data.xy.XYIntervalSeries;
import org.jfree.data.xy.XYIntervalSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYErrorRendererDemo1
extends ApplicationFrame {
    public XYErrorRendererDemo1(String string) {
        super(string);
        JPanel jPanel = XYErrorRendererDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(IntervalXYDataset intervalXYDataset) {
        NumberAxis numberAxis = new NumberAxis("X");
        NumberAxis numberAxis2 = new NumberAxis("Y");
        XYErrorRenderer xYErrorRenderer = new XYErrorRenderer();
        XYPlot xYPlot = new XYPlot((XYDataset)intervalXYDataset, (ValueAxis)numberAxis, (ValueAxis)numberAxis2, (XYItemRenderer)xYErrorRenderer);
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        xYPlot.setBackgroundPaint((Paint)Color.lightGray);
        xYPlot.setDomainGridlinePaint((Paint)Color.white);
        xYPlot.setRangeGridlinePaint((Paint)Color.white);
        JFreeChart jFreeChart = new JFreeChart("XYErrorRenderer Demo 1", (Plot)xYPlot);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    private static IntervalXYDataset createDataset() {
        XYIntervalSeriesCollection xYIntervalSeriesCollection = new XYIntervalSeriesCollection();
        XYIntervalSeries xYIntervalSeries = new XYIntervalSeries((Comparable)((Object)"Series 1"));
        xYIntervalSeries.add(1.0, 0.5, 1.5, 10.0, 9.0, 11.0);
        xYIntervalSeries.add(10.0, 8.7, 11.21, 6.1, 4.34, 7.54);
        xYIntervalSeries.add(17.8, 16.0, 18.9, 4.5, 3.1, 5.8);
        XYIntervalSeries xYIntervalSeries2 = new XYIntervalSeries((Comparable)((Object)"Series 2"));
        xYIntervalSeries2.add(3.0, 2.5, 3.5, 7.0, 6.0, 8.0);
        xYIntervalSeries2.add(13.0, 11.5, 14.5, 13.0, 11.5, 14.5);
        xYIntervalSeries2.add(24.0, 22.7, 25.21, 16.1, 14.34, 17.54);
        xYIntervalSeriesCollection.addSeries(xYIntervalSeries);
        xYIntervalSeriesCollection.addSeries(xYIntervalSeries2);
        return xYIntervalSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = XYErrorRendererDemo1.createChart(XYErrorRendererDemo1.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        XYErrorRendererDemo1 xYErrorRendererDemo1 = new XYErrorRendererDemo1("JFreeChart: XYErrorRendererDemo1.java");
        xYErrorRendererDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)xYErrorRendererDemo1));
        xYErrorRendererDemo1.setVisible(true);
    }
}

