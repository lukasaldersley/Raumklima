/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.general.DefaultKeyedValues2DDataset
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
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DefaultKeyedValues2DDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PopulationChartDemo1
extends ApplicationFrame {
    public PopulationChartDemo1(String string) {
        super(string);
        JPanel jPanel = PopulationChartDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    public static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createStackedBarChart((String)"Population Chart Demo 1", (String)"Age Group", (String)"Population (millions)", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.HORIZONTAL, (boolean)true, (boolean)true, (boolean)false);
        return jFreeChart;
    }

    public static CategoryDataset createDataset() {
        DefaultKeyedValues2DDataset defaultKeyedValues2DDataset = new DefaultKeyedValues2DDataset();
        defaultKeyedValues2DDataset.addValue(-6.0, (Comparable)((Object)"Male"), (Comparable)((Object)"70+"));
        defaultKeyedValues2DDataset.addValue(-8.0, (Comparable)((Object)"Male"), (Comparable)((Object)"60-69"));
        defaultKeyedValues2DDataset.addValue(-11.0, (Comparable)((Object)"Male"), (Comparable)((Object)"50-59"));
        defaultKeyedValues2DDataset.addValue(-13.0, (Comparable)((Object)"Male"), (Comparable)((Object)"40-49"));
        defaultKeyedValues2DDataset.addValue(-14.0, (Comparable)((Object)"Male"), (Comparable)((Object)"30-39"));
        defaultKeyedValues2DDataset.addValue(-15.0, (Comparable)((Object)"Male"), (Comparable)((Object)"20-29"));
        defaultKeyedValues2DDataset.addValue(-19.0, (Comparable)((Object)"Male"), (Comparable)((Object)"10-19"));
        defaultKeyedValues2DDataset.addValue(-21.0, (Comparable)((Object)"Male"), (Comparable)((Object)"0-9"));
        defaultKeyedValues2DDataset.addValue(10.0, (Comparable)((Object)"Female"), (Comparable)((Object)"70+"));
        defaultKeyedValues2DDataset.addValue(12.0, (Comparable)((Object)"Female"), (Comparable)((Object)"60-69"));
        defaultKeyedValues2DDataset.addValue(13.0, (Comparable)((Object)"Female"), (Comparable)((Object)"50-59"));
        defaultKeyedValues2DDataset.addValue(14.0, (Comparable)((Object)"Female"), (Comparable)((Object)"40-49"));
        defaultKeyedValues2DDataset.addValue(15.0, (Comparable)((Object)"Female"), (Comparable)((Object)"30-39"));
        defaultKeyedValues2DDataset.addValue(17.0, (Comparable)((Object)"Female"), (Comparable)((Object)"20-29"));
        defaultKeyedValues2DDataset.addValue(19.0, (Comparable)((Object)"Female"), (Comparable)((Object)"10-19"));
        defaultKeyedValues2DDataset.addValue(20.0, (Comparable)((Object)"Female"), (Comparable)((Object)"0-9"));
        return defaultKeyedValues2DDataset;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = PopulationChartDemo1.createChart(PopulationChartDemo1.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        PopulationChartDemo1 populationChartDemo1 = new PopulationChartDemo1("JFreeChart: PopulationChartDemo1.java");
        populationChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)populationChartDemo1));
        populationChartDemo1.setVisible(true);
    }
}

