/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.axis.CategoryLabelPositions
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
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BarChart3DDemo3
extends ApplicationFrame {
    public BarChart3DDemo3(String string) {
        super(string);
        JPanel jPanel = BarChart3DDemo3.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(25.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue(34.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset.addValue(19.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue(29.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset.addValue(41.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue(33.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Category 2"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createBarChart3D((String)"3D Bar Chart Demo", (String)"Category", (String)"Value", (CategoryDataset)categoryDataset);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions((double)0.39269908169872414));
        CategoryItemRenderer categoryItemRenderer = categoryPlot.getRenderer();
        categoryItemRenderer.setBaseItemLabelsVisible(true);
        BarRenderer barRenderer = (BarRenderer)categoryItemRenderer;
        barRenderer.setItemMargin(0.2);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = BarChart3DDemo3.createChart(BarChart3DDemo3.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        BarChart3DDemo3 barChart3DDemo3 = new BarChart3DDemo3("JFreeChart: BarChart3DDemo3.java");
        barChart3DDemo3.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)barChart3DDemo3));
        barChart3DDemo3.setVisible(true);
    }
}

