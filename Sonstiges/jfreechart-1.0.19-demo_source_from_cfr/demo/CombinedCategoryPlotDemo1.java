/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.CategoryToolTipGenerator
 *  org.jfree.chart.labels.StandardCategoryToolTipGenerator
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.CombinedDomainCategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.renderer.category.BarRenderer
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.renderer.category.LineAndShapeRenderer
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RectangleInsets
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
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CombinedDomainCategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class CombinedCategoryPlotDemo1
extends ApplicationFrame {
    public CombinedCategoryPlotDemo1(String string) {
        super(string);
        JPanel jPanel = CombinedCategoryPlotDemo1.createDemoPanel();
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
        String string3 = "Type 1";
        String string4 = "Type 2";
        String string5 = "Type 3";
        String string6 = "Type 4";
        String string7 = "Type 5";
        String string8 = "Type 6";
        String string9 = "Type 7";
        String string10 = "Type 8";
        defaultCategoryDataset.addValue(11.0, (Comparable)((Object)string), (Comparable)((Object)string3));
        defaultCategoryDataset.addValue(14.0, (Comparable)((Object)string), (Comparable)((Object)string4));
        defaultCategoryDataset.addValue(13.0, (Comparable)((Object)string), (Comparable)((Object)string5));
        defaultCategoryDataset.addValue(15.0, (Comparable)((Object)string), (Comparable)((Object)string6));
        defaultCategoryDataset.addValue(15.0, (Comparable)((Object)string), (Comparable)((Object)string7));
        defaultCategoryDataset.addValue(17.0, (Comparable)((Object)string), (Comparable)((Object)string8));
        defaultCategoryDataset.addValue(17.0, (Comparable)((Object)string), (Comparable)((Object)string9));
        defaultCategoryDataset.addValue(18.0, (Comparable)((Object)string), (Comparable)((Object)string10));
        defaultCategoryDataset.addValue(15.0, (Comparable)((Object)string2), (Comparable)((Object)string3));
        defaultCategoryDataset.addValue(17.0, (Comparable)((Object)string2), (Comparable)((Object)string4));
        defaultCategoryDataset.addValue(16.0, (Comparable)((Object)string2), (Comparable)((Object)string5));
        defaultCategoryDataset.addValue(18.0, (Comparable)((Object)string2), (Comparable)((Object)string6));
        defaultCategoryDataset.addValue(14.0, (Comparable)((Object)string2), (Comparable)((Object)string7));
        defaultCategoryDataset.addValue(14.0, (Comparable)((Object)string2), (Comparable)((Object)string8));
        defaultCategoryDataset.addValue(12.0, (Comparable)((Object)string2), (Comparable)((Object)string9));
        defaultCategoryDataset.addValue(11.0, (Comparable)((Object)string2), (Comparable)((Object)string10));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart() {
        CategoryDataset categoryDataset = CombinedCategoryPlotDemo1.createDataset1();
        NumberAxis numberAxis = new NumberAxis("Value");
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        LineAndShapeRenderer lineAndShapeRenderer = new LineAndShapeRenderer();
        lineAndShapeRenderer.setBaseToolTipGenerator((CategoryToolTipGenerator)new StandardCategoryToolTipGenerator());
        CategoryPlot categoryPlot = new CategoryPlot(categoryDataset, null, (ValueAxis)numberAxis, (CategoryItemRenderer)lineAndShapeRenderer);
        categoryPlot.setDomainGridlinesVisible(true);
        CategoryDataset categoryDataset2 = CombinedCategoryPlotDemo1.createDataset2();
        NumberAxis numberAxis2 = new NumberAxis("Value");
        numberAxis2.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer barRenderer = new BarRenderer();
        barRenderer.setBaseToolTipGenerator((CategoryToolTipGenerator)new StandardCategoryToolTipGenerator());
        CategoryPlot categoryPlot2 = new CategoryPlot(categoryDataset2, null, (ValueAxis)numberAxis2, (CategoryItemRenderer)barRenderer);
        categoryPlot2.setDomainGridlinesVisible(true);
        CategoryAxis categoryAxis = new CategoryAxis("Category");
        CombinedDomainCategoryPlot combinedDomainCategoryPlot = new CombinedDomainCategoryPlot(categoryAxis);
        combinedDomainCategoryPlot.add(categoryPlot, 2);
        combinedDomainCategoryPlot.add(categoryPlot2, 1);
        JFreeChart jFreeChart = new JFreeChart("Combined Domain Category Plot Demo", new Font("SansSerif", 1, 12), (Plot)combinedDomainCategoryPlot, true);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        categoryPlot.setAxisOffset(RectangleInsets.ZERO_INSETS);
        categoryPlot2.setAxisOffset(RectangleInsets.ZERO_INSETS);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = CombinedCategoryPlotDemo1.createChart();
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        String string = "JFreeChart: CombinedCategoryPlotDemo1.java";
        CombinedCategoryPlotDemo1 combinedCategoryPlotDemo1 = new CombinedCategoryPlotDemo1(string);
        combinedCategoryPlotDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)combinedCategoryPlotDemo1));
        combinedCategoryPlotDemo1.setVisible(true);
    }
}

