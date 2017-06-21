/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.data.xy.IntervalXYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import demo.SimpleIntervalXYDataset;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYBarChartDemo3
extends ApplicationFrame {
    public XYBarChartDemo3(String string) {
        super(string);
        SimpleIntervalXYDataset simpleIntervalXYDataset = new SimpleIntervalXYDataset();
        JFreeChart jFreeChart = XYBarChartDemo3.createChart(simpleIntervalXYDataset);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setPreferredSize(new Dimension(500, 300));
        this.setContentPane((Container)chartPanel);
    }

    private static JFreeChart createChart(IntervalXYDataset intervalXYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYBarChart((String)"Sample", (String)"X", (boolean)false, (String)"Y", (IntervalXYDataset)intervalXYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        return new ChartPanel(XYBarChartDemo3.createChart(new SimpleIntervalXYDataset()));
    }

    public static void main(String[] arrstring) {
        XYBarChartDemo3 xYBarChartDemo3 = new XYBarChartDemo3("XY Bar Chart Demo 3");
        xYBarChartDemo3.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)xYBarChartDemo3));
        xYBarChartDemo3.setVisible(true);
    }
}

