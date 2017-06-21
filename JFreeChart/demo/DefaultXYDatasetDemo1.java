/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.PlotOrientation
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
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class DefaultXYDatasetDemo1
extends ApplicationFrame {
    public DefaultXYDatasetDemo1(String string) {
        super(string);
        JPanel jPanel = DefaultXYDatasetDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        return ChartFactory.createScatterPlot((String)"DefaultXYDatasetDemo1", (String)"X", (String)"Y", (XYDataset)xYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)false, (boolean)false);
    }

    private static XYDataset createDataset() {
        DefaultXYDataset defaultXYDataset = new DefaultXYDataset();
        double[] arrd = new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0};
        double[] arrd2 = new double[]{8.0, 7.0, 6.0, 5.0, 4.0, 3.0, 2.0, 1.0};
        double[][] arrarrd = new double[][]{arrd, arrd2};
        defaultXYDataset.addSeries((Comparable)((Object)"Series 1"), (double[][])arrarrd);
        double[] arrd3 = new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0};
        double[] arrd4 = new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0};
        double[][] arrarrd2 = new double[][]{arrd3, arrd4};
        defaultXYDataset.addSeries((Comparable)((Object)"Series 2"), (double[][])arrarrd2);
        return defaultXYDataset;
    }

    public static JPanel createDemoPanel() {
        return new ChartPanel(DefaultXYDatasetDemo1.createChart(DefaultXYDatasetDemo1.createDataset()));
    }

    public static void main(String[] arrstring) {
        DefaultXYDatasetDemo1 defaultXYDatasetDemo1 = new DefaultXYDatasetDemo1("JFreeChart: DefautlXYDatasetDemo1.java");
        defaultXYDatasetDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)defaultXYDatasetDemo1));
        defaultXYDatasetDemo1.setVisible(true);
    }
}

