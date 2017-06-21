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
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.xy.DefaultXYZDataset
 *  org.jfree.data.xy.XYZDataset
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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BubbleChartDemo1
extends ApplicationFrame {
    public BubbleChartDemo1(String string) {
        super(string);
        JPanel jPanel = BubbleChartDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(XYZDataset xYZDataset) {
        JFreeChart jFreeChart = ChartFactory.createBubbleChart((String)"Bubble Chart Demo 1", (String)"X", (String)"Y", (XYZDataset)xYZDataset, (PlotOrientation)PlotOrientation.HORIZONTAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setForegroundAlpha(0.65f);
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        XYItemRenderer xYItemRenderer = xYPlot.getRenderer();
        xYItemRenderer.setSeriesPaint(0, (Paint)Color.blue);
        NumberAxis numberAxis = (NumberAxis)xYPlot.getDomainAxis();
        numberAxis.setLowerMargin(0.15);
        numberAxis.setUpperMargin(0.15);
        NumberAxis numberAxis2 = (NumberAxis)xYPlot.getRangeAxis();
        numberAxis2.setLowerMargin(0.15);
        numberAxis2.setUpperMargin(0.15);
        return jFreeChart;
    }

    public static XYZDataset createDataset() {
        DefaultXYZDataset defaultXYZDataset = new DefaultXYZDataset();
        double[] arrd = new double[]{2.1, 2.3, 2.3, 2.2, 2.2, 1.8, 1.8, 1.9, 2.3, 3.8};
        double[] arrd2 = new double[]{14.1, 11.1, 10.0, 8.8, 8.7, 8.4, 5.4, 4.1, 4.1, 25.0};
        double[] arrd3 = new double[]{2.4, 2.7, 2.7, 2.2, 2.2, 2.2, 2.1, 2.2, 1.6, 4.0};
        double[][] arrarrd = new double[][]{arrd, arrd2, arrd3};
        defaultXYZDataset.addSeries((Comparable)((Object)"Series 1"), (double[][])arrarrd);
        return defaultXYZDataset;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = BubbleChartDemo1.createChart(BubbleChartDemo1.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setDomainZoomable(true);
        chartPanel.setRangeZoomable(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        BubbleChartDemo1 bubbleChartDemo1 = new BubbleChartDemo1("JFreeChart: BubbleChartDemo1.java");
        bubbleChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)bubbleChartDemo1));
        bubbleChartDemo1.setVisible(true);
    }
}

