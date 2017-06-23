/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.labels.PieSectionLabelGenerator
 *  org.jfree.chart.labels.StandardPieSectionLabelGenerator
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
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.TableOrder;

public class MultiplePieChartDemo4
extends ApplicationFrame {
    public MultiplePieChartDemo4(String string) {
        super(string);
        CategoryDataset categoryDataset = MultiplePieChartDemo4.createDataset();
        JFreeChart jFreeChart = MultiplePieChartDemo4.createChart(categoryDataset);
        ChartPanel chartPanel = new ChartPanel(jFreeChart, true, true, true, false, true);
        chartPanel.setPreferredSize(new Dimension(600, 380));
        this.setContentPane((Container)chartPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(5.6, (Comparable)((Object)"Row 0"), (Comparable)((Object)"Column 0"));
        defaultCategoryDataset.addValue(3.2, (Comparable)((Object)"Row 0"), (Comparable)((Object)"Column 1"));
        defaultCategoryDataset.addValue(1.8, (Comparable)((Object)"Row 0"), (Comparable)((Object)"Column 2"));
        defaultCategoryDataset.addValue(0.2, (Comparable)((Object)"Row 0"), (Comparable)((Object)"Column 3"));
        defaultCategoryDataset.addValue(4.1, (Comparable)((Object)"Row 0"), (Comparable)((Object)"Column 4"));
        defaultCategoryDataset.addValue(9.8, (Comparable)((Object)"Row 1"), (Comparable)((Object)"Column 0"));
        defaultCategoryDataset.addValue(6.3, (Comparable)((Object)"Row 1"), (Comparable)((Object)"Column 1"));
        defaultCategoryDataset.addValue(0.1, (Comparable)((Object)"Row 1"), (Comparable)((Object)"Column 2"));
        defaultCategoryDataset.addValue(1.9, (Comparable)((Object)"Row 1"), (Comparable)((Object)"Column 3"));
        defaultCategoryDataset.addValue(9.6, (Comparable)((Object)"Row 1"), (Comparable)((Object)"Column 4"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"Row 2"), (Comparable)((Object)"Column 0"));
        defaultCategoryDataset.addValue(5.2, (Comparable)((Object)"Row 2"), (Comparable)((Object)"Column 1"));
        defaultCategoryDataset.addValue(2.8, (Comparable)((Object)"Row 2"), (Comparable)((Object)"Column 2"));
        defaultCategoryDataset.addValue(8.8, (Comparable)((Object)"Row 2"), (Comparable)((Object)"Column 3"));
        defaultCategoryDataset.addValue(7.2, (Comparable)((Object)"Row 2"), (Comparable)((Object)"Column 4"));
        defaultCategoryDataset.addValue(9.5, (Comparable)((Object)"Row 3"), (Comparable)((Object)"Column 0"));
        defaultCategoryDataset.addValue(1.2, (Comparable)((Object)"Row 3"), (Comparable)((Object)"Column 1"));
        defaultCategoryDataset.addValue(4.5, (Comparable)((Object)"Row 3"), (Comparable)((Object)"Column 2"));
        defaultCategoryDataset.addValue(4.4, (Comparable)((Object)"Row 3"), (Comparable)((Object)"Column 3"));
        defaultCategoryDataset.addValue(0.2, (Comparable)((Object)"Row 3"), (Comparable)((Object)"Column 4"));
        defaultCategoryDataset.addValue(3.5, (Comparable)((Object)"Row 4"), (Comparable)((Object)"Column 0"));
        defaultCategoryDataset.addValue(6.7, (Comparable)((Object)"Row 4"), (Comparable)((Object)"Column 1"));
        defaultCategoryDataset.addValue(9.0, (Comparable)((Object)"Row 4"), (Comparable)((Object)"Column 2"));
        defaultCategoryDataset.addValue(1.0, (Comparable)((Object)"Row 4"), (Comparable)((Object)"Column 3"));
        defaultCategoryDataset.addValue(5.2, (Comparable)((Object)"Row 4"), (Comparable)((Object)"Column 4"));
        defaultCategoryDataset.addValue(5.1, (Comparable)((Object)"Row 5"), (Comparable)((Object)"Column 0"));
        defaultCategoryDataset.addValue(6.7, (Comparable)((Object)"Row 5"), (Comparable)((Object)"Column 1"));
        defaultCategoryDataset.addValue(0.9, (Comparable)((Object)"Row 5"), (Comparable)((Object)"Column 2"));
        defaultCategoryDataset.addValue(3.3, (Comparable)((Object)"Row 5"), (Comparable)((Object)"Column 3"));
        defaultCategoryDataset.addValue(3.9, (Comparable)((Object)"Row 5"), (Comparable)((Object)"Column 4"));
        defaultCategoryDataset.addValue(5.6, (Comparable)((Object)"Row 6"), (Comparable)((Object)"Column 0"));
        defaultCategoryDataset.addValue(5.6, (Comparable)((Object)"Row 6"), (Comparable)((Object)"Column 1"));
        defaultCategoryDataset.addValue(5.6, (Comparable)((Object)"Row 6"), (Comparable)((Object)"Column 2"));
        defaultCategoryDataset.addValue(5.6, (Comparable)((Object)"Row 6"), (Comparable)((Object)"Column 3"));
        defaultCategoryDataset.addValue(5.6, (Comparable)((Object)"Row 6"), (Comparable)((Object)"Column 4"));
        defaultCategoryDataset.addValue(7.5, (Comparable)((Object)"Row 7"), (Comparable)((Object)"Column 0"));
        defaultCategoryDataset.addValue(9.0, (Comparable)((Object)"Row 7"), (Comparable)((Object)"Column 1"));
        defaultCategoryDataset.addValue(3.4, (Comparable)((Object)"Row 7"), (Comparable)((Object)"Column 2"));
        defaultCategoryDataset.addValue(4.1, (Comparable)((Object)"Row 7"), (Comparable)((Object)"Column 3"));
        defaultCategoryDataset.addValue(0.5, (Comparable)((Object)"Row 7"), (Comparable)((Object)"Column 4"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createMultiplePieChart3D((String)"Multiple Pie Chart Demo 4", (CategoryDataset)categoryDataset, (TableOrder)TableOrder.BY_COLUMN, (boolean)false, (boolean)true, (boolean)false);
        MultiplePiePlot multiplePiePlot = (MultiplePiePlot)jFreeChart.getPlot();
        multiplePiePlot.setLimit(0.1);
        JFreeChart jFreeChart2 = multiplePiePlot.getPieChart();
        PiePlot piePlot = (PiePlot)jFreeChart2.getPlot();
        piePlot.setIgnoreNullValues(true);
        piePlot.setLabelGenerator((PieSectionLabelGenerator)new StandardPieSectionLabelGenerator("{0}"));
        piePlot.setMaximumLabelWidth(0.2);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = MultiplePieChartDemo4.createChart(MultiplePieChartDemo4.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        MultiplePieChartDemo4 multiplePieChartDemo4 = new MultiplePieChartDemo4("JFreeChart: MultiplePieChartDemo4.java");
        multiplePieChartDemo4.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)multiplePieChartDemo4));
        multiplePieChartDemo4.setVisible(true);
    }
}

