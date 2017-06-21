/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYDotRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import demo.SampleXYDataset2;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYDotRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class ScatterPlotDemo2
extends ApplicationFrame {
    public ScatterPlotDemo2(String string) {
        super(string);
        JPanel jPanel = ScatterPlotDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createScatterPlot((String)"Scatter Plot Demo 2", (String)"X", (String)"Y", (XYDataset)xYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainCrosshairVisible(true);
        xYPlot.setDomainCrosshairLockedOnData(true);
        xYPlot.setRangeCrosshairVisible(true);
        xYPlot.setRangeCrosshairLockedOnData(true);
        xYPlot.setDomainZeroBaselineVisible(true);
        xYPlot.setRangeZeroBaselineVisible(true);
        XYDotRenderer xYDotRenderer = new XYDotRenderer();
        xYDotRenderer.setDotWidth(2);
        xYDotRenderer.setDotHeight(2);
        xYPlot.setRenderer((XYItemRenderer)xYDotRenderer);
        NumberAxis numberAxis = (NumberAxis)xYPlot.getDomainAxis();
        numberAxis.setAutoRangeIncludesZero(false);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = ScatterPlotDemo2.createChart(new SampleXYDataset2());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        ScatterPlotDemo2 scatterPlotDemo2 = new ScatterPlotDemo2("JFreeChart: ScatterPlotDemo2.java");
        scatterPlotDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)scatterPlotDemo2));
        scatterPlotDemo2.setVisible(true);
    }
}

