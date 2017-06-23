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
 *  org.jfree.chart.renderer.category.BarRenderer3D
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
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BarChart3DDemo1
extends ApplicationFrame {
    public BarChart3DDemo1(String string) {
        super(string);
        JPanel jPanel = BarChart3DDemo1.createDemoPanel();
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(10.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset.addValue(15.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Category 3"));
        defaultCategoryDataset.addValue(14.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Category 4"));
        defaultCategoryDataset.addValue(-5.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue(-7.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset.addValue(14.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Category 3"));
        defaultCategoryDataset.addValue(-3.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Category 4"));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue(17.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset.addValue(-12.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Category 3"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Category 4"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"Series 4"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue(15.0, (Comparable)((Object)"Series 4"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset.addValue(11.0, (Comparable)((Object)"Series 4"), (Comparable)((Object)"Category 3"));
        defaultCategoryDataset.addValue(0.0, (Comparable)((Object)"Series 4"), (Comparable)((Object)"Category 4"));
        defaultCategoryDataset.addValue(-8.0, (Comparable)((Object)"Series 5"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue(-6.0, (Comparable)((Object)"Series 5"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset.addValue(10.0, (Comparable)((Object)"Series 5"), (Comparable)((Object)"Category 3"));
        defaultCategoryDataset.addValue(-9.0, (Comparable)((Object)"Series 5"), (Comparable)((Object)"Category 4"));
        defaultCategoryDataset.addValue(9.0, (Comparable)((Object)"Series 6"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue(8.0, (Comparable)((Object)"Series 6"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset.addValue(0.0, (Comparable)((Object)"Series 6"), (Comparable)((Object)"Category 3"));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)"Series 6"), (Comparable)((Object)"Category 4"));
        defaultCategoryDataset.addValue(-10.0, (Comparable)((Object)"Series 7"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue(9.0, (Comparable)((Object)"Series 7"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"Series 7"), (Comparable)((Object)"Category 3"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"Series 7"), (Comparable)((Object)"Category 4"));
        defaultCategoryDataset.addValue(11.0, (Comparable)((Object)"Series 8"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue(13.0, (Comparable)((Object)"Series 8"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset.addValue(9.0, (Comparable)((Object)"Series 8"), (Comparable)((Object)"Category 3"));
        defaultCategoryDataset.addValue(9.0, (Comparable)((Object)"Series 8"), (Comparable)((Object)"Category 4"));
        defaultCategoryDataset.addValue(-3.0, (Comparable)((Object)"Series 9"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"Series 9"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset.addValue(11.0, (Comparable)((Object)"Series 9"), (Comparable)((Object)"Category 3"));
        defaultCategoryDataset.addValue(-10.0, (Comparable)((Object)"Series 9"), (Comparable)((Object)"Category 4"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createBarChart3D((String)"3D Bar Chart Demo", (String)"Category", (String)"Value", (CategoryDataset)categoryDataset);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setOutlineVisible(false);
        categoryPlot.setDomainGridlinesVisible(true);
        CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions((double)0.39269908169872414));
        categoryAxis.setCategoryMargin(0.0);
        BarRenderer3D barRenderer3D = (BarRenderer3D)categoryPlot.getRenderer();
        barRenderer3D.setDrawBarOutline(false);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = BarChart3DDemo1.createChart(BarChart3DDemo1.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setPreferredSize(new Dimension(600, 400));
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        BarChart3DDemo1 barChart3DDemo1 = new BarChart3DDemo1("JFreeChart: BarChart3DDemo1.java");
        barChart3DDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)barChart3DDemo1));
        barChart3DDemo1.setVisible(true);
    }
}

