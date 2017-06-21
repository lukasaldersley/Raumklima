/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.DeviationRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.YIntervalSeries
 *  org.jfree.data.xy.YIntervalSeriesCollection
 *  org.jfree.ui.ApplicationFrame
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
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.DeviationRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.YIntervalSeries;
import org.jfree.data.xy.YIntervalSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class DeviationRendererDemo1
extends ApplicationFrame {
    public DeviationRendererDemo1(String string) {
        super(string);
        JPanel jPanel = DeviationRendererDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static XYDataset createDataset() {
        YIntervalSeries yIntervalSeries = new YIntervalSeries((Comparable)((Object)"Series 1"));
        YIntervalSeries yIntervalSeries2 = new YIntervalSeries((Comparable)((Object)"Series 2"));
        double d = 100.0;
        double d2 = 100.0;
        for (int i = 0; i <= 100; ++i) {
            d = d + Math.random() - 0.48;
            double d3 = 0.05 * (double)i;
            yIntervalSeries.add((double)i, d, d - d3, d + d3);
            d2 = d2 + Math.random() - 0.5;
            double d4 = 0.07 * (double)i;
            yIntervalSeries2.add((double)i, d2, d2 - d4, d2 + d4);
        }
        YIntervalSeriesCollection yIntervalSeriesCollection = new YIntervalSeriesCollection();
        yIntervalSeriesCollection.addSeries(yIntervalSeries);
        yIntervalSeriesCollection.addSeries(yIntervalSeries2);
        return yIntervalSeriesCollection;
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYLineChart((String)"DeviationRenderer - Demo 1", (String)"X", (String)"Y", (XYDataset)xYDataset);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainPannable(true);
        DeviationRenderer deviationRenderer = new DeviationRenderer(true, false);
        deviationRenderer.setSeriesStroke(0, (Stroke)new BasicStroke(3.0f, 1, 1));
        deviationRenderer.setSeriesStroke(0, (Stroke)new BasicStroke(3.0f, 1, 1));
        deviationRenderer.setSeriesStroke(1, (Stroke)new BasicStroke(3.0f, 1, 1));
        deviationRenderer.setSeriesFillPaint(0, (Paint)new Color(255, 200, 200));
        deviationRenderer.setSeriesFillPaint(1, (Paint)new Color(200, 200, 255));
        xYPlot.setRenderer((XYItemRenderer)deviationRenderer);
        NumberAxis numberAxis = (NumberAxis)xYPlot.getRangeAxis();
        numberAxis.setAutoRangeIncludesZero(false);
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = DeviationRendererDemo1.createChart(DeviationRendererDemo1.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        DeviationRendererDemo1 deviationRendererDemo1 = new DeviationRendererDemo1("JFreeChart : DeviationRendererDemo1.java");
        deviationRendererDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)deviationRendererDemo1));
        deviationRendererDemo1.setVisible(true);
    }
}

