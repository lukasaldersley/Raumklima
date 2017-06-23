/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.CategorySeriesLabelGenerator
 *  org.jfree.chart.labels.StandardCategorySeriesLabelGenerator
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.renderer.category.BarRenderer
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
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
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.CategorySeriesLabelGenerator;
import org.jfree.chart.labels.StandardCategorySeriesLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BarChartDemo4
extends ApplicationFrame {
    public BarChartDemo4(String string) {
        super(string);
        JPanel jPanel = BarChartDemo4.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(1.0, (Comparable)((Object)"First"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)"Second"), (Comparable)((Object)"Category 1"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createBarChart((String)"Bar Chart Demo 4", (String)null, (String)"Value", (CategoryDataset)categoryDataset);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer barRenderer = (BarRenderer)categoryPlot.getRenderer();
        barRenderer.setDrawBarOutline(false);
        barRenderer.setMaximumBarWidth(0.1);
        barRenderer.setLegendItemLabelGenerator((CategorySeriesLabelGenerator)new StandardCategorySeriesLabelGenerator("{0} series"));
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = BarChartDemo4.createChart(BarChartDemo4.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        BarChartDemo4 barChartDemo4 = new BarChartDemo4("JFreeChart: BarChartDemo4.java");
        barChartDemo4.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)barChartDemo4));
        barChartDemo4.setVisible(true);
    }
}

