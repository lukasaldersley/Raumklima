/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.ClusteredXYBarRenderer
 *  org.jfree.chart.renderer.xy.XYBarRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.time.Day
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.IntervalXYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.GradientPaintTransformType
 *  org.jfree.ui.GradientPaintTransformer
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.ui.StandardGradientPaintTransformer
 */
package demo;

import demo.DemoPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Paint;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.ClusteredXYBarRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.StandardGradientPaintTransformer;

public class ClusteredXYBarRendererDemo1
extends ApplicationFrame {
    public ClusteredXYBarRendererDemo1(String string) {
        super(string);
        this.setContentPane((Container)ClusteredXYBarRendererDemo1.createDemoPanel());
    }

    private static JFreeChart createChart(String string, IntervalXYDataset intervalXYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYBarChart((String)string, (String)null, (boolean)true, (String)"Y", (IntervalXYDataset)intervalXYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        ClusteredXYBarRenderer clusteredXYBarRenderer = new ClusteredXYBarRenderer(0.2, false);
        xYPlot.setRenderer((XYItemRenderer)clusteredXYBarRenderer);
        return jFreeChart;
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

    public static JPanel createDemoPanel() {
        DemoPanel demoPanel = new DemoPanel(new GridLayout(2, 2));
        demoPanel.setPreferredSize(new Dimension(800, 600));
        IntervalXYDataset intervalXYDataset = ClusteredXYBarRendererDemo1.createDataset();
        JFreeChart jFreeChart = ClusteredXYBarRendererDemo1.createChart("Vertical", intervalXYDataset);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        XYBarRenderer xYBarRenderer = (XYBarRenderer)xYPlot.getRenderer();
        xYBarRenderer.setDrawBarOutline(false);
        xYBarRenderer.setSeriesPaint(0, (Paint)new GradientPaint(0.0f, 0.0f, Color.red, 0.0f, 0.0f, Color.yellow));
        xYBarRenderer.setSeriesPaint(1, (Paint)new GradientPaint(0.0f, 0.0f, Color.blue, 0.0f, 0.0f, Color.green));
        xYBarRenderer.setGradientPaintTransformer((GradientPaintTransformer)new StandardGradientPaintTransformer(GradientPaintTransformType.VERTICAL));
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        demoPanel.add((Component)chartPanel);
        JFreeChart jFreeChart2 = ClusteredXYBarRendererDemo1.createChart("Vertical / Inverted Axis", intervalXYDataset);
        XYPlot xYPlot2 = (XYPlot)jFreeChart2.getPlot();
        XYBarRenderer xYBarRenderer2 = (XYBarRenderer)xYPlot2.getRenderer();
        xYBarRenderer2.setDrawBarOutline(false);
        xYBarRenderer2.setSeriesPaint(0, (Paint)new GradientPaint(0.0f, 0.0f, Color.red, 0.0f, 0.0f, Color.yellow));
        xYBarRenderer2.setSeriesPaint(1, (Paint)new GradientPaint(0.0f, 0.0f, Color.blue, 0.0f, 0.0f, Color.green));
        xYBarRenderer2.setGradientPaintTransformer((GradientPaintTransformer)new StandardGradientPaintTransformer(GradientPaintTransformType.HORIZONTAL));
        xYPlot2.getDomainAxis().setInverted(true);
        ChartPanel chartPanel2 = new ChartPanel(jFreeChart2);
        demoPanel.add((Component)chartPanel2);
        JFreeChart jFreeChart3 = ClusteredXYBarRendererDemo1.createChart("Horizontal", intervalXYDataset);
        XYPlot xYPlot3 = (XYPlot)jFreeChart3.getPlot();
        xYPlot3.setOrientation(PlotOrientation.HORIZONTAL);
        XYBarRenderer xYBarRenderer3 = (XYBarRenderer)xYPlot3.getRenderer();
        xYBarRenderer3.setDrawBarOutline(false);
        xYBarRenderer3.setSeriesPaint(0, (Paint)new GradientPaint(0.0f, 0.0f, Color.red, 0.0f, 0.0f, Color.yellow));
        xYBarRenderer3.setSeriesPaint(1, (Paint)new GradientPaint(0.0f, 0.0f, Color.blue, 0.0f, 0.0f, Color.green));
        xYBarRenderer3.setGradientPaintTransformer((GradientPaintTransformer)new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_VERTICAL));
        ChartPanel chartPanel3 = new ChartPanel(jFreeChart3);
        demoPanel.add((Component)chartPanel3);
        JFreeChart jFreeChart4 = ClusteredXYBarRendererDemo1.createChart("Horizontal / Inverted Axis", intervalXYDataset);
        XYPlot xYPlot4 = (XYPlot)jFreeChart4.getPlot();
        xYPlot4.setOrientation(PlotOrientation.HORIZONTAL);
        XYBarRenderer xYBarRenderer4 = (XYBarRenderer)xYPlot4.getRenderer();
        xYBarRenderer4.setDrawBarOutline(false);
        xYBarRenderer4.setSeriesPaint(0, (Paint)new GradientPaint(0.0f, 0.0f, Color.red, 0.0f, 0.0f, Color.yellow));
        xYBarRenderer4.setSeriesPaint(1, (Paint)new GradientPaint(0.0f, 0.0f, Color.blue, 0.0f, 0.0f, Color.green));
        xYBarRenderer4.setGradientPaintTransformer((GradientPaintTransformer)new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_HORIZONTAL));
        xYPlot4.getDomainAxis().setInverted(true);
        ChartPanel chartPanel4 = new ChartPanel(jFreeChart4);
        demoPanel.add((Component)chartPanel4);
        demoPanel.addChart(jFreeChart);
        demoPanel.addChart(jFreeChart2);
        demoPanel.addChart(jFreeChart3);
        demoPanel.addChart(jFreeChart4);
        return demoPanel;
    }

    public static void main(String[] arrstring) {
        ClusteredXYBarRendererDemo1 clusteredXYBarRendererDemo1 = new ClusteredXYBarRendererDemo1("JFreeChart: ClusteredXYBarRendererDemo1.java");
        clusteredXYBarRendererDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)clusteredXYBarRendererDemo1));
        clusteredXYBarRendererDemo1.setVisible(true);
    }
}

