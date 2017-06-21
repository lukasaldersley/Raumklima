/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.MultiplePiePlot
 *  org.jfree.chart.plot.PiePlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.util.TableOrder
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.TableOrder;

public class MultiplePieChartDemo3
extends ApplicationFrame {
    public MultiplePieChartDemo3(String string) {
        super(string);
        CategoryDataset categoryDataset = MultiplePieChartDemo3.createDataset();
        JFreeChart jFreeChart = MultiplePieChartDemo3.createChart(categoryDataset);
        ChartPanel chartPanel = new ChartPanel(jFreeChart, true, true, true, false, true);
        chartPanel.setPreferredSize(new Dimension(600, 380));
        this.setContentPane((Container)chartPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(5.6, (Comparable)((Object)"Row 0"), (Comparable)((Object)"Column 0"));
        defaultCategoryDataset.addValue(4.3, (Comparable)((Object)"Row 0"), (Comparable)((Object)"Column 1"));
        defaultCategoryDataset.addValue(6.7, (Comparable)((Object)"Row 0"), (Comparable)((Object)"Column 2"));
        defaultCategoryDataset.addValue(4.4, (Comparable)((Object)"Row 0"), (Comparable)((Object)"Column 3"));
        defaultCategoryDataset.addValue(6.1, (Comparable)((Object)"Row 0"), (Comparable)((Object)"Column 4"));
        defaultCategoryDataset.addValue(5.8, (Comparable)((Object)"Row 1"), (Comparable)((Object)"Column 0"));
        defaultCategoryDataset.addValue(3.2, (Comparable)((Object)"Row 1"), (Comparable)((Object)"Column 1"));
        defaultCategoryDataset.addValue(4.5, (Comparable)((Object)"Row 1"), (Comparable)((Object)"Column 2"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"Row 1"), (Comparable)((Object)"Column 3"));
        defaultCategoryDataset.addValue(5.8, (Comparable)((Object)"Row 1"), (Comparable)((Object)"Column 4"));
        defaultCategoryDataset.addValue(5.3, (Comparable)((Object)"Row 2"), (Comparable)((Object)"Column 0"));
        defaultCategoryDataset.addValue(6.7, (Comparable)((Object)"Row 2"), (Comparable)((Object)"Column 1"));
        defaultCategoryDataset.addValue(7.1, (Comparable)((Object)"Row 2"), (Comparable)((Object)"Column 2"));
        defaultCategoryDataset.addValue(4.2, (Comparable)((Object)"Row 2"), (Comparable)((Object)"Column 3"));
        defaultCategoryDataset.addValue(9.0, (Comparable)((Object)"Row 2"), (Comparable)((Object)"Column 4"));
        defaultCategoryDataset.addValue(5.6, (Comparable)((Object)"Row 3"), (Comparable)((Object)"Column 0"));
        defaultCategoryDataset.addValue(5.6, (Comparable)((Object)"Row 3"), (Comparable)((Object)"Column 1"));
        defaultCategoryDataset.addValue(5.6, (Comparable)((Object)"Row 3"), (Comparable)((Object)"Column 2"));
        defaultCategoryDataset.addValue(5.6, (Comparable)((Object)"Row 3"), (Comparable)((Object)"Column 3"));
        defaultCategoryDataset.addValue(5.6, (Comparable)((Object)"Row 3"), (Comparable)((Object)"Column 4"));
        defaultCategoryDataset.addValue(5.6, (Comparable)((Object)"Row 4"), (Comparable)((Object)"Column 0"));
        defaultCategoryDataset.addValue(5.6, (Comparable)((Object)"Row 4"), (Comparable)((Object)"Column 1"));
        defaultCategoryDataset.addValue(5.6, (Comparable)((Object)"Row 4"), (Comparable)((Object)"Column 2"));
        defaultCategoryDataset.addValue(5.6, (Comparable)((Object)"Row 4"), (Comparable)((Object)"Column 3"));
        defaultCategoryDataset.addValue(5.6, (Comparable)((Object)"Row 4"), (Comparable)((Object)"Column 4"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createMultiplePieChart3D((String)"Multiple Pie Chart Demo 3", (CategoryDataset)categoryDataset, (TableOrder)TableOrder.BY_COLUMN, (boolean)true, (boolean)true, (boolean)false);
        MultiplePiePlot multiplePiePlot = (MultiplePiePlot)jFreeChart.getPlot();
        PiePlot piePlot = (PiePlot)multiplePiePlot.getPieChart().getPlot();
        piePlot.setMaximumLabelWidth(0.18);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = MultiplePieChartDemo3.createChart(MultiplePieChartDemo3.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        MultiplePieChartDemo3 multiplePieChartDemo3 = new MultiplePieChartDemo3("JFreeChart: MultiplePieChartDemo3.java");
        multiplePieChartDemo3.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)multiplePieChartDemo3));
        multiplePieChartDemo3.setVisible(true);
    }
}

