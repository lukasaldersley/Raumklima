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
 *  org.jfree.data.xy.DefaultXYDataset
 *  org.jfree.data.xy.XYDataset
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
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class DefaultXYDatasetDemo2
extends ApplicationFrame {
    public DefaultXYDatasetDemo2(String string) {
        super(string);
        JPanel jPanel = DefaultXYDatasetDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createScatterPlot((String)"DefaultXYDatasetDemo2", (String)"X", (String)"Y", (XYDataset)xYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)false, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        return jFreeChart;
    }

    private static XYDataset createDataset() {
        DefaultXYDataset defaultXYDataset = new DefaultXYDataset();
        double[] arrd = new double[1000];
        double[] arrd2 = new double[1000];
        for (int i = 0; i < 1000; ++i) {
            arrd[i] = Math.random() + 1.0;
            arrd2[i] = Math.random() + 1.0;
        }
        double[][] arrarrd = new double[][]{arrd, arrd2};
        defaultXYDataset.addSeries((Comparable)((Object)"Series 1"), (double[][])arrarrd);
        return defaultXYDataset;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = DefaultXYDatasetDemo2.createChart(DefaultXYDatasetDemo2.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        DefaultXYDatasetDemo2 defaultXYDatasetDemo2 = new DefaultXYDatasetDemo2("JFreeChart: DefaultXYDatasetDemo2.java");
        defaultXYDatasetDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)defaultXYDatasetDemo2));
        defaultXYDatasetDemo2.setVisible(true);
    }
}

