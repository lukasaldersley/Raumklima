/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.renderer.category.MinMaxCategoryRenderer
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
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
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.MinMaxCategoryRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class MinMaxCategoryPlotDemo1
extends ApplicationFrame {
    public MinMaxCategoryPlotDemo1(String string) {
        super(string);
        JPanel jPanel = MinMaxCategoryPlotDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    public static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(1.0, (Comparable)((Object)"First"), (Comparable)((Object)"C1"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"First"), (Comparable)((Object)"C2"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"First"), (Comparable)((Object)"C3"));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)"First"), (Comparable)((Object)"C4"));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)"First"), (Comparable)((Object)"C5"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"First"), (Comparable)((Object)"C6"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"First"), (Comparable)((Object)"C7"));
        defaultCategoryDataset.addValue(8.0, (Comparable)((Object)"First"), (Comparable)((Object)"C8"));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)"Second"), (Comparable)((Object)"C1"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"Second"), (Comparable)((Object)"C2"));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)"Second"), (Comparable)((Object)"C3"));
        defaultCategoryDataset.addValue(8.0, (Comparable)((Object)"Second"), (Comparable)((Object)"C4"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"Second"), (Comparable)((Object)"C5"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"Second"), (Comparable)((Object)"C6"));
        defaultCategoryDataset.addValue(2.0, (Comparable)((Object)"Second"), (Comparable)((Object)"C7"));
        defaultCategoryDataset.addValue(1.0, (Comparable)((Object)"Second"), (Comparable)((Object)"C8"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"Third"), (Comparable)((Object)"C1"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"Third"), (Comparable)((Object)"C2"));
        defaultCategoryDataset.addValue(2.0, (Comparable)((Object)"Third"), (Comparable)((Object)"C3"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"Third"), (Comparable)((Object)"C4"));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)"Third"), (Comparable)((Object)"C5"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"Third"), (Comparable)((Object)"C6"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"Third"), (Comparable)((Object)"C7"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"Third"), (Comparable)((Object)"C8"));
        return defaultCategoryDataset;
    }

    public static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createBarChart((String)"Min/Max Category Plot", (String)"Category", (String)"Value", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setRangePannable(true);
        MinMaxCategoryRenderer minMaxCategoryRenderer = new MinMaxCategoryRenderer();
        minMaxCategoryRenderer.setDrawLines(false);
        categoryPlot.setRenderer((CategoryItemRenderer)minMaxCategoryRenderer);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = MinMaxCategoryPlotDemo1.createChart(MinMaxCategoryPlotDemo1.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        MinMaxCategoryPlotDemo1 minMaxCategoryPlotDemo1 = new MinMaxCategoryPlotDemo1("JFreeChart: MinMaxCategoryPlotDemo1.java");
        minMaxCategoryPlotDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)minMaxCategoryPlotDemo1));
        minMaxCategoryPlotDemo1.setVisible(true);
    }
}

