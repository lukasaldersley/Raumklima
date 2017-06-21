/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.renderer.category.StackedBarRenderer
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StackedBarDemo3
extends ApplicationFrame {
    public StackedBarDemo3(String string) {
        super(string);
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(1.0, (Comparable)((Object)"Row 1"), (Comparable)((Object)"Column 1"));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)"Row 1"), (Comparable)((Object)"Column 2"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"Row 1"), (Comparable)((Object)"Column 3"));
        defaultCategoryDataset.addValue(2.0, (Comparable)((Object)"Row 2"), (Comparable)((Object)"Column 1"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"Row 2"), (Comparable)((Object)"Column 2"));
        defaultCategoryDataset.addValue(2.0, (Comparable)((Object)"Row 2"), (Comparable)((Object)"Column 3"));
        JFreeChart jFreeChart = ChartFactory.createStackedBarChart((String)"StackedBarDemo3", (String)"Category", (String)"Value", (CategoryDataset)defaultCategoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        StackedBarRenderer stackedBarRenderer = (StackedBarRenderer)categoryPlot.getRenderer();
        stackedBarRenderer.setRenderAsPercentages(true);
        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setLabel("Percentage");
        numberAxis.setNumberFormatOverride((NumberFormat)new DecimalFormat("0.0%"));
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)chartPanel);
    }

    public static void main(String[] arrstring) {
        StackedBarDemo3 stackedBarDemo3 = new StackedBarDemo3("StackedBarDemo3");
        stackedBarDemo3.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)stackedBarDemo3));
        stackedBarDemo3.setVisible(true);
    }
}

