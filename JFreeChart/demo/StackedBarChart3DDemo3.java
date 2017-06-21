/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.labels.CategoryItemLabelGenerator
 *  org.jfree.chart.labels.ItemLabelAnchor
 *  org.jfree.chart.labels.ItemLabelPosition
 *  org.jfree.chart.labels.StandardCategoryItemLabelGenerator
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.renderer.category.BarRenderer
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.ui.TextAnchor
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class StackedBarChart3DDemo3
extends ApplicationFrame {
    public StackedBarChart3DDemo3(String string) {
        super(string);
        JPanel jPanel = StackedBarChart3DDemo3.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    public static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(10.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"C1"));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"C2"));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"C3"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"C4"));
        defaultCategoryDataset.addValue(8.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"C5"));
        defaultCategoryDataset.addValue(9.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"C6"));
        defaultCategoryDataset.addValue(10.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"C7"));
        defaultCategoryDataset.addValue(11.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"C8"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"C9"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"C1"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"C2"));
        defaultCategoryDataset.addValue(17.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"C3"));
        defaultCategoryDataset.addValue(-15.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"C4"));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"C5"));
        defaultCategoryDataset.addValue(8.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"C6"));
        defaultCategoryDataset.addValue(9.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"C7"));
        defaultCategoryDataset.addValue(13.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"C8"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"C9"));
        defaultCategoryDataset.addValue(15.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"C1"));
        defaultCategoryDataset.addValue(-14.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"C2"));
        defaultCategoryDataset.addValue(12.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"C3"));
        defaultCategoryDataset.addValue(11.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"C4"));
        defaultCategoryDataset.addValue(10.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"C5"));
        defaultCategoryDataset.addValue(0.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"C6"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"C7"));
        defaultCategoryDataset.addValue(9.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"C8"));
        defaultCategoryDataset.addValue(11.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"C9"));
        defaultCategoryDataset.addValue(14.0, (Comparable)((Object)"Series 4"), (Comparable)((Object)"C1"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"Series 4"), (Comparable)((Object)"C2"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"Series 4"), (Comparable)((Object)"C3"));
        defaultCategoryDataset.addValue(0.0, (Comparable)((Object)"Series 4"), (Comparable)((Object)"C4"));
        defaultCategoryDataset.addValue(9.0, (Comparable)((Object)"Series 4"), (Comparable)((Object)"C5"));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)"Series 4"), (Comparable)((Object)"C6"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"Series 4"), (Comparable)((Object)"C7"));
        defaultCategoryDataset.addValue(9.0, (Comparable)((Object)"Series 4"), (Comparable)((Object)"C8"));
        defaultCategoryDataset.addValue(10.0, (Comparable)((Object)"Series 4"), (Comparable)((Object)"C9"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createStackedBarChart3D((String)"Stacked Bar Chart 3D Demo 3", (String)"Category", (String)"Value", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.HORIZONTAL, (boolean)true, (boolean)true, (boolean)false);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        BarRenderer barRenderer = (BarRenderer)categoryPlot.getRenderer();
        barRenderer.setDrawBarOutline(false);
        barRenderer.setBaseItemLabelGenerator((CategoryItemLabelGenerator)new StandardCategoryItemLabelGenerator());
        barRenderer.setBaseItemLabelsVisible(true);
        barRenderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
        barRenderer.setBaseNegativeItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = StackedBarChart3DDemo3.createChart(StackedBarChart3DDemo3.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        StackedBarChart3DDemo3 stackedBarChart3DDemo3 = new StackedBarChart3DDemo3("Stacked Bar Chart 3D Demo 3");
        stackedBarChart3DDemo3.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)stackedBarChart3DDemo3));
        stackedBarChart3DDemo3.setVisible(true);
    }
}

