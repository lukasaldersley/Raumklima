/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.data.function.Function2D
 *  org.jfree.data.function.NormalDistributionFunction2D
 *  org.jfree.data.general.DatasetUtilities
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
import org.jfree.data.function.Function2D;
import org.jfree.data.function.NormalDistributionFunction2D;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class NormalDistributionDemo1
extends ApplicationFrame {
    public NormalDistributionDemo1(String string) {
        super(string);
        JPanel jPanel = NormalDistributionDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = NormalDistributionDemo1.createChart(NormalDistributionDemo1.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static XYDataset createDataset() {
        NormalDistributionFunction2D normalDistributionFunction2D = new NormalDistributionFunction2D(0.0, 1.0);
        XYDataset xYDataset = DatasetUtilities.sampleFunction2D((Function2D)normalDistributionFunction2D, (double)-5.0, (double)5.0, (int)100, (Comparable)((Object)"Normal"));
        return xYDataset;
    }

    public static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYLineChart((String)"Normal Distribution", (String)"X", (String)"Y", (XYDataset)xYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        return jFreeChart;
    }

    public static void main(String[] arrstring) {
        NormalDistributionDemo1 normalDistributionDemo1 = new NormalDistributionDemo1("JFreeChart: NormalDistributionDemo1.java");
        normalDistributionDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)normalDistributionDemo1));
        normalDistributionDemo1.setVisible(true);
    }
}

