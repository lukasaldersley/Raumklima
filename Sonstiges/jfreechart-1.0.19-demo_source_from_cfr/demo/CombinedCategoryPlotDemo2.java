/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.axis.CategoryLabelPositions
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.CategoryToolTipGenerator
 *  org.jfree.chart.labels.StandardCategoryToolTipGenerator
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.CombinedRangeCategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.renderer.category.BarRenderer
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.renderer.category.LineAndShapeRenderer
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CombinedRangeCategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class CombinedCategoryPlotDemo2
extends ApplicationFrame {
    public CombinedCategoryPlotDemo2(String string) {
        super(string);
        JPanel jPanel = CombinedCategoryPlotDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    public static CategoryDataset createDataset1() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        String string = "First";
        String string2 = "Second";
        String string3 = "Type 1";
        String string4 = "Type 2";
        String string5 = "Type 3";
        String string6 = "Type 4";
        String string7 = "Type 5";
        String string8 = "Type 6";
        String string9 = "Type 7";
        String string10 = "Type 8";
        defaultCategoryDataset.addValue(1.0, (Comparable)((Object)string), (Comparable)((Object)string3));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)string), (Comparable)((Object)string4));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)string), (Comparable)((Object)string5));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)string), (Comparable)((Object)string6));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)string), (Comparable)((Object)string7));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)string), (Comparable)((Object)string8));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)string), (Comparable)((Object)string9));
        defaultCategoryDataset.addValue(8.0, (Comparable)((Object)string), (Comparable)((Object)string10));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)string2), (Comparable)((Object)string3));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)string2), (Comparable)((Object)string4));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)string2), (Comparable)((Object)string5));
        defaultCategoryDataset.addValue(8.0, (Comparable)((Object)string2), (Comparable)((Object)string6));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)string2), (Comparable)((Object)string7));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)string2), (Comparable)((Object)string8));
        defaultCategoryDataset.addValue(2.0, (Comparable)((Object)string2), (Comparable)((Object)string9));
        defaultCategoryDataset.addValue(1.0, (Comparable)((Object)string2), (Comparable)((Object)string10));
        return defaultCategoryDataset;
    }

    public static CategoryDataset createDataset2() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        String string = "Third";
        String string2 = "Fourth";
        String string3 = "Sector 1";
        String string4 = "Sector 2";
        String string5 = "Sector 3";
        String string6 = "Sector 4";
        defaultCategoryDataset.addValue(11.0, (Comparable)((Object)string), (Comparable)((Object)string3));
        defaultCategoryDataset.addValue(14.0, (Comparable)((Object)string), (Comparable)((Object)string4));
        defaultCategoryDataset.addValue(13.0, (Comparable)((Object)string), (Comparable)((Object)string5));
        defaultCategoryDataset.addValue(15.0, (Comparable)((Object)string), (Comparable)((Object)string6));
        defaultCategoryDataset.addValue(15.0, (Comparable)((Object)string2), (Comparable)((Object)string3));
        defaultCategoryDataset.addValue(17.0, (Comparable)((Object)string2), (Comparable)((Object)string4));
        defaultCategoryDataset.addValue(16.0, (Comparable)((Object)string2), (Comparable)((Object)string5));
        defaultCategoryDataset.addValue(18.0, (Comparable)((Object)string2), (Comparable)((Object)string6));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart() {
        CategoryDataset categoryDataset = CombinedCategoryPlotDemo2.createDataset1();
        CategoryAxis categoryAxis = new CategoryAxis("Class 1");
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        categoryAxis.setMaximumCategoryLabelWidthRatio(5.0f);
        LineAndShapeRenderer lineAndShapeRenderer = new LineAndShapeRenderer();
        lineAndShapeRenderer.setBaseToolTipGenerator((CategoryToolTipGenerator)new StandardCategoryToolTipGenerator());
        CategoryPlot categoryPlot = new CategoryPlot(categoryDataset, categoryAxis, null, (CategoryItemRenderer)lineAndShapeRenderer);
        categoryPlot.setDomainGridlinesVisible(true);
        CategoryDataset categoryDataset2 = CombinedCategoryPlotDemo2.createDataset2();
        CategoryAxis categoryAxis2 = new CategoryAxis("Class 2");
        categoryAxis2.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        categoryAxis2.setMaximumCategoryLabelWidthRatio(5.0f);
        BarRenderer barRenderer = new BarRenderer();
        barRenderer.setBaseToolTipGenerator((CategoryToolTipGenerator)new StandardCategoryToolTipGenerator());
        CategoryPlot categoryPlot2 = new CategoryPlot(categoryDataset2, categoryAxis2, null, (CategoryItemRenderer)barRenderer);
        categoryPlot2.setDomainGridlinesVisible(true);
        NumberAxis numberAxis = new NumberAxis("Value");
        CombinedRangeCategoryPlot combinedRangeCategoryPlot = new CombinedRangeCategoryPlot((ValueAxis)numberAxis);
        combinedRangeCategoryPlot.setRangePannable(true);
        combinedRangeCategoryPlot.add(categoryPlot, 3);
        combinedRangeCategoryPlot.add(categoryPlot2, 2);
        combinedRangeCategoryPlot.setOrientation(PlotOrientation.HORIZONTAL);
        JFreeChart jFreeChart = new JFreeChart("Combined Range Category Plot Demo", new Font("SansSerif", 1, 12), (Plot)combinedRangeCategoryPlot, true);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = CombinedCategoryPlotDemo2.createChart();
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        String string = "JFreeChart: CombinedCategoryPlotDemo2.java";
        CombinedCategoryPlotDemo2 combinedCategoryPlotDemo2 = new CombinedCategoryPlotDemo2(string);
        combinedCategoryPlotDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)combinedCategoryPlotDemo2));
        combinedCategoryPlotDemo2.setVisible(true);
    }
}

