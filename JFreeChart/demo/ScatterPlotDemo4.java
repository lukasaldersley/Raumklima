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
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
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

public class ScatterPlotDemo4
extends ApplicationFrame {
    public ScatterPlotDemo4(String string) {
        super(string);
        JPanel jPanel = ScatterPlotDemo4.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    public static JPanel createDemoPanel() {
        SampleXYDataset2 sampleXYDataset2 = new SampleXYDataset2();
        JFreeChart jFreeChart = ChartFactory.createScatterPlot((String)"Scatter Plot Demo 4", (String)"X", (String)"Y", (XYDataset)sampleXYDataset2, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setRangeTickBandPaint((Paint)new Color(200, 200, 100, 100));
        XYDotRenderer xYDotRenderer = new XYDotRenderer();
        xYDotRenderer.setDotWidth(4);
        xYDotRenderer.setDotHeight(4);
        xYPlot.setRenderer((XYItemRenderer)xYDotRenderer);
        xYPlot.setDomainCrosshairVisible(true);
        xYPlot.setRangeCrosshairVisible(true);
        NumberAxis numberAxis = (NumberAxis)xYPlot.getDomainAxis();
        numberAxis.setAutoRangeIncludesZero(false);
        xYPlot.getRangeAxis().setInverted(true);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        ScatterPlotDemo4 scatterPlotDemo4 = new ScatterPlotDemo4("JFreeChart: ScatterPlotDemo4.java");
        scatterPlotDemo4.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)scatterPlotDemo4));
        scatterPlotDemo4.setVisible(true);
    }
}

