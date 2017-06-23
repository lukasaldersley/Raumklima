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
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.Week
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.YIntervalSeries
 *  org.jfree.data.xy.YIntervalSeriesCollection
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
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.Week;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.YIntervalSeries;
import org.jfree.data.xy.YIntervalSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class DeviationRendererDemo2
extends ApplicationFrame {
    public DeviationRendererDemo2(String string) {
        super(string);
        JPanel jPanel = DeviationRendererDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static XYDataset createDataset() {
        YIntervalSeries yIntervalSeries = new YIntervalSeries((Comparable)((Object)"Series 1"));
        YIntervalSeries yIntervalSeries2 = new YIntervalSeries((Comparable)((Object)"Series 2"));
        Week week = new Week();
        double d = 100.0;
        double d2 = 100.0;
        for (int i = 0; i <= 52; ++i) {
            double d3 = 0.05 * (double)i;
            yIntervalSeries.add((double)week.getFirstMillisecond(), d, d - d3, d + d3);
            d = d + Math.random() - 0.45;
            double d4 = 0.07 * (double)i;
            yIntervalSeries2.add((double)week.getFirstMillisecond(), d2, d2 - d4, d2 + d4);
            d2 = d2 + Math.random() - 0.55;
            week = week.next();
        }
        YIntervalSeriesCollection yIntervalSeriesCollection = new YIntervalSeriesCollection();
        yIntervalSeriesCollection.addSeries(yIntervalSeries);
        yIntervalSeriesCollection.addSeries(yIntervalSeries2);
        return yIntervalSeriesCollection;
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Projected Values - Test", (String)"Date", (String)"Index Projection", (XYDataset)xYDataset, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(false);
        xYPlot.setInsets(new RectangleInsets(5.0, 5.0, 5.0, 20.0));
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
        JFreeChart jFreeChart = DeviationRendererDemo2.createChart(DeviationRendererDemo2.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        DeviationRendererDemo2 deviationRendererDemo2 = new DeviationRendererDemo2("JFreeChart: DeviationRendererDemo2.java");
        deviationRendererDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)deviationRendererDemo2));
        deviationRendererDemo2.setVisible(true);
    }
}

