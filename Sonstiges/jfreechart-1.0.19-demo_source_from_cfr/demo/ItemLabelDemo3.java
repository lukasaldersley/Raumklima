/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.CategoryItemLabelGenerator
 *  org.jfree.chart.labels.ItemLabelAnchor
 *  org.jfree.chart.labels.ItemLabelPosition
 *  org.jfree.chart.labels.StandardCategoryItemLabelGenerator
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
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
import java.awt.Font;
import java.awt.Window;
import java.text.NumberFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class ItemLabelDemo3
extends ApplicationFrame {
    public ItemLabelDemo3(String string) {
        super(string);
        JPanel jPanel = ItemLabelDemo3.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(51.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Apples"));
        defaultCategoryDataset.addValue(44.3, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Bananas"));
        defaultCategoryDataset.addValue(93.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Oranges"));
        defaultCategoryDataset.addValue(35.6, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Pears"));
        defaultCategoryDataset.addValue(75.1, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Plums"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createBarChart((String)"Item Label Demo 3", (String)"Category", (String)"Value", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)false, (boolean)true, (boolean)false);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setRangePannable(true);
        categoryPlot.setRangeZeroBaselineVisible(true);
        CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
        categoryAxis.setVisible(false);
        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setUpperMargin(0.15);
        CategoryItemRenderer categoryItemRenderer = categoryPlot.getRenderer();
        StandardCategoryItemLabelGenerator standardCategoryItemLabelGenerator = new StandardCategoryItemLabelGenerator("{1}", NumberFormat.getInstance());
        categoryItemRenderer.setBaseItemLabelGenerator((CategoryItemLabelGenerator)standardCategoryItemLabelGenerator);
        categoryItemRenderer.setBaseItemLabelFont(new Font("SansSerif", 0, 12));
        categoryItemRenderer.setBaseItemLabelsVisible(true);
        categoryItemRenderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER, TextAnchor.CENTER, -1.5707963267948966));
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = ItemLabelDemo3.createChart(ItemLabelDemo3.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        ItemLabelDemo3 itemLabelDemo3 = new ItemLabelDemo3("JFreeChart: ItemLabelDemo3.java");
        itemLabelDemo3.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)itemLabelDemo3));
        itemLabelDemo3.setVisible(true);
    }
}

