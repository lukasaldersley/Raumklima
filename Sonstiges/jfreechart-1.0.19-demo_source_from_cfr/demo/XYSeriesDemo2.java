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
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.XYSeries
 *  org.jfree.data.xy.XYSeriesCollection
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
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYSeriesDemo2
extends ApplicationFrame {
    public XYSeriesDemo2(String string) {
        super(string);
        XYDataset xYDataset = XYSeriesDemo2.createDataset();
        JFreeChart jFreeChart = XYSeriesDemo2.createChart(xYDataset);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)chartPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYLineChart((String)"XY Series Demo 2", (String)"X", (String)"Y", (XYDataset)xYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        NumberAxis numberAxis = (NumberAxis)xYPlot.getRangeAxis();
        numberAxis.setAutoRangeIncludesZero(false);
        numberAxis.setAutoRangeMinimumSize(1.0);
        return jFreeChart;
    }

    private static XYDataset createDataset() {
        XYSeries xYSeries = new XYSeries((Comparable)((Object)"Flat Data"));
        xYSeries.add(1.0, 100.0);
        xYSeries.add(5.0, 100.0);
        xYSeries.add(4.0, 100.0);
        xYSeries.add(12.5, 100.0);
        xYSeries.add(17.3, 100.0);
        xYSeries.add(21.2, 100.0);
        xYSeries.add(21.9, 100.0);
        xYSeries.add(25.6, 100.0);
        xYSeries.add(30.0, 100.0);
        XYSeriesCollection xYSeriesCollection = new XYSeriesCollection(xYSeries);
        return xYSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = XYSeriesDemo2.createChart(XYSeriesDemo2.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        XYSeriesDemo2 xYSeriesDemo2 = new XYSeriesDemo2("JFreeChart: XYSeriesDemo2.java");
        xYSeriesDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)xYSeriesDemo2));
        xYSeriesDemo2.setVisible(true);
    }
}

