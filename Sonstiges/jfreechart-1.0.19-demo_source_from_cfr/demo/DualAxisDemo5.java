/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.LegendItem
 *  org.jfree.chart.LegendItemCollection
 *  org.jfree.chart.axis.AxisLocation
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.axis.NumberAxis
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

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class DualAxisDemo5
extends ApplicationFrame {
    public DualAxisDemo5(String string) {
        super(string);
        CategoryDataset categoryDataset = DualAxisDemo5.createDataset1();
        CategoryDataset categoryDataset2 = DualAxisDemo5.createDataset2();
        JFreeChart jFreeChart = DualAxisDemo5.createChart(categoryDataset, categoryDataset2);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)chartPanel);
    }

    private static CategoryDataset createDataset1() {
        String string = "Series 1";
        String string2 = "Dummy 1";
        String string3 = "Category 1";
        String string4 = "Category 2";
        String string5 = "Category 3";
        String string6 = "Category 4";
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(1.0, (Comparable)((Object)string), (Comparable)((Object)string3));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)string), (Comparable)((Object)string4));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)string), (Comparable)((Object)string5));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)string), (Comparable)((Object)string6));
        defaultCategoryDataset.addValue(null, (Comparable)((Object)string2), (Comparable)((Object)string3));
        defaultCategoryDataset.addValue(null, (Comparable)((Object)string2), (Comparable)((Object)string4));
        defaultCategoryDataset.addValue(null, (Comparable)((Object)string2), (Comparable)((Object)string5));
        defaultCategoryDataset.addValue(null, (Comparable)((Object)string2), (Comparable)((Object)string6));
        return defaultCategoryDataset;
    }

    private static CategoryDataset createDataset2() {
        String string = "Dummy 2";
        String string2 = "Series 2";
        String string3 = "Category 1";
        String string4 = "Category 2";
        String string5 = "Category 3";
        String string6 = "Category 4";
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(null, (Comparable)((Object)string), (Comparable)((Object)string3));
        defaultCategoryDataset.addValue(null, (Comparable)((Object)string), (Comparable)((Object)string4));
        defaultCategoryDataset.addValue(null, (Comparable)((Object)string), (Comparable)((Object)string5));
        defaultCategoryDataset.addValue(null, (Comparable)((Object)string), (Comparable)((Object)string6));
        defaultCategoryDataset.addValue(75.0, (Comparable)((Object)string2), (Comparable)((Object)string3));
        defaultCategoryDataset.addValue(87.0, (Comparable)((Object)string2), (Comparable)((Object)string4));
        defaultCategoryDataset.addValue(96.0, (Comparable)((Object)string2), (Comparable)((Object)string5));
        defaultCategoryDataset.addValue(68.0, (Comparable)((Object)string2), (Comparable)((Object)string6));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset, CategoryDataset categoryDataset2) {
        CategoryAxis categoryAxis = new CategoryAxis("Category");
        NumberAxis numberAxis = new NumberAxis("Value");
        BarRenderer barRenderer = new BarRenderer();
        CategoryPlot categoryPlot = new CategoryPlot(categoryDataset, categoryAxis, (ValueAxis)numberAxis, (CategoryItemRenderer)barRenderer){

            public LegendItemCollection getLegendItems() {
                CategoryItemRenderer categoryItemRenderer;
                LegendItem legendItem;
                LegendItemCollection legendItemCollection = new LegendItemCollection();
                CategoryDataset categoryDataset = this.getDataset();
                if (categoryDataset != null && (categoryItemRenderer = this.getRenderer()) != null) {
                    legendItem = categoryItemRenderer.getLegendItem(0, 0);
                    legendItemCollection.add(legendItem);
                }
                if ((categoryItemRenderer = this.getDataset(1)) != null && (legendItem = this.getRenderer(1)) != null) {
                    LegendItem legendItem2 = legendItem.getLegendItem(1, 1);
                    legendItemCollection.add(legendItem2);
                }
                return legendItemCollection;
            }
        };
        JFreeChart jFreeChart = new JFreeChart("Dual Axis Bar Chart", (Plot)categoryPlot);
        categoryPlot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
        categoryPlot.setDataset(1, categoryDataset2);
        categoryPlot.mapDatasetToRangeAxis(1, 1);
        NumberAxis numberAxis2 = new NumberAxis("Secondary");
        categoryPlot.setRangeAxis(1, (ValueAxis)numberAxis2);
        categoryPlot.setRangeAxisLocation(1, AxisLocation.BOTTOM_OR_RIGHT);
        BarRenderer barRenderer2 = new BarRenderer();
        categoryPlot.setRenderer(1, (CategoryItemRenderer)barRenderer2);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = DualAxisDemo5.createChart(DualAxisDemo5.createDataset1(), DualAxisDemo5.createDataset2());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        DualAxisDemo5 dualAxisDemo5 = new DualAxisDemo5("JFreeChart: DualAxisDemo5.java");
        dualAxisDemo5.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)dualAxisDemo5));
        dualAxisDemo5.setVisible(true);
    }

}

