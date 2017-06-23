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
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.renderer.category.BarRenderer
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RectangleInsets
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import demo.DemoPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Paint;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
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
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class AxisOffsetsDemo1
extends ApplicationFrame {
    public AxisOffsetsDemo1(String string) {
        super(string);
        JPanel jPanel = AxisOffsetsDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
        String string = "S1";
        String string2 = "S2";
        String string3 = "S3";
        String string4 = "C1";
        String string5 = "C2";
        String string6 = "C3";
        String string7 = "C4";
        String string8 = "C5";
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(1.0, (Comparable)((Object)string), (Comparable)((Object)string4));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)string), (Comparable)((Object)string5));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)string), (Comparable)((Object)string6));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)string), (Comparable)((Object)string7));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)string), (Comparable)((Object)string8));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)string2), (Comparable)((Object)string4));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)string2), (Comparable)((Object)string5));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)string2), (Comparable)((Object)string6));
        defaultCategoryDataset.addValue(8.0, (Comparable)((Object)string2), (Comparable)((Object)string7));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)string2), (Comparable)((Object)string8));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)string3), (Comparable)((Object)string4));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)string3), (Comparable)((Object)string5));
        defaultCategoryDataset.addValue(2.0, (Comparable)((Object)string3), (Comparable)((Object)string6));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)string3), (Comparable)((Object)string7));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)string3), (Comparable)((Object)string8));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(String string, CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createBarChart((String)string, (String)"Category", (String)"Value", (CategoryDataset)categoryDataset);
        jFreeChart.removeLegend();
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
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = AxisOffsetsDemo1.createChart("Axis Offsets: 0", AxisOffsetsDemo1.createDataset());
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setAxisOffset(RectangleInsets.ZERO_INSETS);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMinimumDrawWidth(0);
        chartPanel.setMinimumDrawHeight(0);
        JFreeChart jFreeChart2 = AxisOffsetsDemo1.createChart("Axis Offsets: 5", AxisOffsetsDemo1.createDataset());
        ChartPanel chartPanel2 = new ChartPanel(jFreeChart2);
        chartPanel2.setMinimumDrawWidth(0);
        chartPanel2.setMinimumDrawHeight(0);
        CategoryPlot categoryPlot2 = (CategoryPlot)jFreeChart2.getPlot();
        categoryPlot2.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        DemoPanel demoPanel = new DemoPanel(new GridLayout(2, 1));
        demoPanel.add((Component)chartPanel);
        demoPanel.add((Component)chartPanel2);
        demoPanel.addChart(jFreeChart);
        demoPanel.addChart(jFreeChart2);
        return demoPanel;
    }

    public static void main(String[] arrstring) {
        AxisOffsetsDemo1 axisOffsetsDemo1 = new AxisOffsetsDemo1("JFreeChart: AxisOffsetsDemo1.java");
        axisOffsetsDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)axisOffsetsDemo1));
        axisOffsetsDemo1.setVisible(true);
    }
}

