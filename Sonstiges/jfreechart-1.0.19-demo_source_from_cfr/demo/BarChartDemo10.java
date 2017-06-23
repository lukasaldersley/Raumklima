/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.axis.CategoryLabelPositions
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
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

import demo.Animator;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BarChartDemo10
extends ApplicationFrame {
    public BarChartDemo10(String string) {
        super(string);
        JPanel jPanel = BarChartDemo10.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static DefaultCategoryDataset createDataset() {
        String string = "First";
        String string2 = "Second";
        String string3 = "Third";
        String string4 = "Category 1";
        String string5 = "Category 2";
        String string6 = "Category 3";
        String string7 = "Category 4";
        String string8 = "Category 5";
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(31.0, (Comparable)((Object)string), (Comparable)((Object)string4));
        defaultCategoryDataset.addValue(44.0, (Comparable)((Object)string), (Comparable)((Object)string5));
        defaultCategoryDataset.addValue(33.0, (Comparable)((Object)string), (Comparable)((Object)string6));
        defaultCategoryDataset.addValue(45.0, (Comparable)((Object)string), (Comparable)((Object)string7));
        defaultCategoryDataset.addValue(35.0, (Comparable)((Object)string), (Comparable)((Object)string8));
        defaultCategoryDataset.addValue(45.0, (Comparable)((Object)string2), (Comparable)((Object)string4));
        defaultCategoryDataset.addValue(37.0, (Comparable)((Object)string2), (Comparable)((Object)string5));
        defaultCategoryDataset.addValue(46.0, (Comparable)((Object)string2), (Comparable)((Object)string6));
        defaultCategoryDataset.addValue(38.0, (Comparable)((Object)string2), (Comparable)((Object)string7));
        defaultCategoryDataset.addValue(44.0, (Comparable)((Object)string2), (Comparable)((Object)string8));
        defaultCategoryDataset.addValue(34.0, (Comparable)((Object)string3), (Comparable)((Object)string4));
        defaultCategoryDataset.addValue(43.0, (Comparable)((Object)string3), (Comparable)((Object)string5));
        defaultCategoryDataset.addValue(32.0, (Comparable)((Object)string3), (Comparable)((Object)string6));
        defaultCategoryDataset.addValue(43.0, (Comparable)((Object)string3), (Comparable)((Object)string7));
        defaultCategoryDataset.addValue(36.0, (Comparable)((Object)string3), (Comparable)((Object)string8));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createBarChart((String)"Bar Chart Demo 10", (String)"Category", (String)"Value", (CategoryDataset)categoryDataset);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setDomainGridlinesVisible(true);
        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer barRenderer = (BarRenderer)categoryPlot.getRenderer();
        barRenderer.setDrawBarOutline(false);
        GradientPaint gradientPaint = new GradientPaint(0.0f, 0.0f, Color.BLUE, 0.0f, 0.0f, new Color(0, 0, 64));
        GradientPaint gradientPaint2 = new GradientPaint(0.0f, 0.0f, Color.GREEN, 0.0f, 0.0f, new Color(0, 64, 0));
        GradientPaint gradientPaint3 = new GradientPaint(0.0f, 0.0f, Color.RED, 0.0f, 0.0f, new Color(64, 0, 0));
        barRenderer.setSeriesPaint(0, (Paint)gradientPaint);
        barRenderer.setSeriesPaint(1, (Paint)gradientPaint2);
        barRenderer.setSeriesPaint(2, (Paint)gradientPaint3);
        CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions((double)0.5235987755982988));
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        DefaultCategoryDataset defaultCategoryDataset = BarChartDemo10.createDataset();
        JFreeChart jFreeChart = BarChartDemo10.createChart((CategoryDataset)defaultCategoryDataset);
        Animator animator = new Animator(defaultCategoryDataset);
        animator.start();
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        BarChartDemo10 barChartDemo10 = new BarChartDemo10("JFreeChart: BarChartDemo10.java");
        barChartDemo10.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)barChartDemo10));
        barChartDemo10.setVisible(true);
    }
}

