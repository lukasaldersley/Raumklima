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
 *  org.jfree.chart.renderer.xy.XYBarRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.xy.DefaultIntervalXYDataset
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
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.DefaultIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYBarChartDemo6
extends ApplicationFrame {
    public XYBarChartDemo6(String string) {
        super(string);
        JPanel jPanel = XYBarChartDemo6.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 300));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(IntervalXYDataset intervalXYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYBarChart((String)"XYBarChartDemo6", (String)"X", (boolean)false, (String)"Y", (IntervalXYDataset)intervalXYDataset, (PlotOrientation)PlotOrientation.HORIZONTAL, (boolean)false, (boolean)false, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        XYBarRenderer xYBarRenderer = (XYBarRenderer)xYPlot.getRenderer();
        xYBarRenderer.setUseYInterval(true);
        xYPlot.setRenderer((XYItemRenderer)xYBarRenderer);
        return jFreeChart;
    }

    private static IntervalXYDataset createDataset() {
        DefaultIntervalXYDataset defaultIntervalXYDataset = new DefaultIntervalXYDataset();
        double[] arrd = new double[]{1.0, 2.0, 3.0, 4.0};
        double[] arrd2 = new double[]{0.9, 1.8, 2.7, 3.6};
        double[] arrd3 = new double[]{1.1, 2.2, 3.3, 4.4};
        double[] arrd4 = new double[]{1.0, 2.0, 3.0, 4.0};
        double[] arrd5 = new double[]{0.9, 1.8, 2.7, 3.6};
        double[] arrd6 = new double[]{1.1, 2.2, 3.3, 4.4};
        double[][] arrarrd = new double[][]{arrd, arrd2, arrd3, arrd4, arrd5, arrd6};
        defaultIntervalXYDataset.addSeries((Comparable)((Object)"Series 1"), (double[][])arrarrd);
        return defaultIntervalXYDataset;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = XYBarChartDemo6.createChart(XYBarChartDemo6.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        XYBarChartDemo6 xYBarChartDemo6 = new XYBarChartDemo6("JFreeChart : XYBarChartDemo6");
        xYBarChartDemo6.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)xYBarChartDemo6));
        xYBarChartDemo6.setVisible(true);
    }
}

