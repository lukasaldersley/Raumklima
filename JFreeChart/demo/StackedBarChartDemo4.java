/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.LegendItem
 *  org.jfree.chart.LegendItemCollection
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.axis.SubCategoryAxis
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.renderer.category.GroupedStackedBarRenderer
 *  org.jfree.data.KeyToGroupMap
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.GradientPaintTransformType
 *  org.jfree.ui.GradientPaintTransformer
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.ui.StandardGradientPaintTransformer
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.SubCategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.StandardGradientPaintTransformer;

public class StackedBarChartDemo4
extends ApplicationFrame {
    public StackedBarChartDemo4(String string) {
        super(string);
        JPanel jPanel = StackedBarChartDemo4.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(590, 350));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(20.3, (Comparable)((Object)"Product 1 (US)"), (Comparable)((Object)"Jan 04"));
        defaultCategoryDataset.addValue(27.2, (Comparable)((Object)"Product 1 (US)"), (Comparable)((Object)"Feb 04"));
        defaultCategoryDataset.addValue(19.7, (Comparable)((Object)"Product 1 (US)"), (Comparable)((Object)"Mar 04"));
        defaultCategoryDataset.addValue(19.4, (Comparable)((Object)"Product 1 (Europe)"), (Comparable)((Object)"Jan 04"));
        defaultCategoryDataset.addValue(10.9, (Comparable)((Object)"Product 1 (Europe)"), (Comparable)((Object)"Feb 04"));
        defaultCategoryDataset.addValue(18.4, (Comparable)((Object)"Product 1 (Europe)"), (Comparable)((Object)"Mar 04"));
        defaultCategoryDataset.addValue(16.5, (Comparable)((Object)"Product 1 (Asia)"), (Comparable)((Object)"Jan 04"));
        defaultCategoryDataset.addValue(15.9, (Comparable)((Object)"Product 1 (Asia)"), (Comparable)((Object)"Feb 04"));
        defaultCategoryDataset.addValue(16.1, (Comparable)((Object)"Product 1 (Asia)"), (Comparable)((Object)"Mar 04"));
        defaultCategoryDataset.addValue(13.2, (Comparable)((Object)"Product 1 (Middle East)"), (Comparable)((Object)"Jan 04"));
        defaultCategoryDataset.addValue(14.4, (Comparable)((Object)"Product 1 (Middle East)"), (Comparable)((Object)"Feb 04"));
        defaultCategoryDataset.addValue(13.7, (Comparable)((Object)"Product 1 (Middle East)"), (Comparable)((Object)"Mar 04"));
        defaultCategoryDataset.addValue(23.3, (Comparable)((Object)"Product 2 (US)"), (Comparable)((Object)"Jan 04"));
        defaultCategoryDataset.addValue(16.2, (Comparable)((Object)"Product 2 (US)"), (Comparable)((Object)"Feb 04"));
        defaultCategoryDataset.addValue(28.7, (Comparable)((Object)"Product 2 (US)"), (Comparable)((Object)"Mar 04"));
        defaultCategoryDataset.addValue(12.7, (Comparable)((Object)"Product 2 (Europe)"), (Comparable)((Object)"Jan 04"));
        defaultCategoryDataset.addValue(17.9, (Comparable)((Object)"Product 2 (Europe)"), (Comparable)((Object)"Feb 04"));
        defaultCategoryDataset.addValue(12.6, (Comparable)((Object)"Product 2 (Europe)"), (Comparable)((Object)"Mar 04"));
        defaultCategoryDataset.addValue(15.4, (Comparable)((Object)"Product 2 (Asia)"), (Comparable)((Object)"Jan 04"));
        defaultCategoryDataset.addValue(21.0, (Comparable)((Object)"Product 2 (Asia)"), (Comparable)((Object)"Feb 04"));
        defaultCategoryDataset.addValue(11.1, (Comparable)((Object)"Product 2 (Asia)"), (Comparable)((Object)"Mar 04"));
        defaultCategoryDataset.addValue(23.8, (Comparable)((Object)"Product 2 (Middle East)"), (Comparable)((Object)"Jan 04"));
        defaultCategoryDataset.addValue(23.4, (Comparable)((Object)"Product 2 (Middle East)"), (Comparable)((Object)"Feb 04"));
        defaultCategoryDataset.addValue(19.3, (Comparable)((Object)"Product 2 (Middle East)"), (Comparable)((Object)"Mar 04"));
        defaultCategoryDataset.addValue(11.9, (Comparable)((Object)"Product 3 (US)"), (Comparable)((Object)"Jan 04"));
        defaultCategoryDataset.addValue(31.0, (Comparable)((Object)"Product 3 (US)"), (Comparable)((Object)"Feb 04"));
        defaultCategoryDataset.addValue(22.7, (Comparable)((Object)"Product 3 (US)"), (Comparable)((Object)"Mar 04"));
        defaultCategoryDataset.addValue(15.3, (Comparable)((Object)"Product 3 (Europe)"), (Comparable)((Object)"Jan 04"));
        defaultCategoryDataset.addValue(14.4, (Comparable)((Object)"Product 3 (Europe)"), (Comparable)((Object)"Feb 04"));
        defaultCategoryDataset.addValue(25.3, (Comparable)((Object)"Product 3 (Europe)"), (Comparable)((Object)"Mar 04"));
        defaultCategoryDataset.addValue(23.9, (Comparable)((Object)"Product 3 (Asia)"), (Comparable)((Object)"Jan 04"));
        defaultCategoryDataset.addValue(19.0, (Comparable)((Object)"Product 3 (Asia)"), (Comparable)((Object)"Feb 04"));
        defaultCategoryDataset.addValue(10.1, (Comparable)((Object)"Product 3 (Asia)"), (Comparable)((Object)"Mar 04"));
        defaultCategoryDataset.addValue(13.2, (Comparable)((Object)"Product 3 (Middle East)"), (Comparable)((Object)"Jan 04"));
        defaultCategoryDataset.addValue(15.5, (Comparable)((Object)"Product 3 (Middle East)"), (Comparable)((Object)"Feb 04"));
        defaultCategoryDataset.addValue(10.1, (Comparable)((Object)"Product 3 (Middle East)"), (Comparable)((Object)"Mar 04"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createStackedBarChart((String)"Stacked Bar Chart Demo 4", (String)"Category", (String)"Value", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        GroupedStackedBarRenderer groupedStackedBarRenderer = new GroupedStackedBarRenderer();
        KeyToGroupMap keyToGroupMap = new KeyToGroupMap((Comparable)((Object)"G1"));
        keyToGroupMap.mapKeyToGroup((Comparable)((Object)"Product 1 (US)"), (Comparable)((Object)"G1"));
        keyToGroupMap.mapKeyToGroup((Comparable)((Object)"Product 1 (Europe)"), (Comparable)((Object)"G1"));
        keyToGroupMap.mapKeyToGroup((Comparable)((Object)"Product 1 (Asia)"), (Comparable)((Object)"G1"));
        keyToGroupMap.mapKeyToGroup((Comparable)((Object)"Product 1 (Middle East)"), (Comparable)((Object)"G1"));
        keyToGroupMap.mapKeyToGroup((Comparable)((Object)"Product 2 (US)"), (Comparable)((Object)"G2"));
        keyToGroupMap.mapKeyToGroup((Comparable)((Object)"Product 2 (Europe)"), (Comparable)((Object)"G2"));
        keyToGroupMap.mapKeyToGroup((Comparable)((Object)"Product 2 (Asia)"), (Comparable)((Object)"G2"));
        keyToGroupMap.mapKeyToGroup((Comparable)((Object)"Product 2 (Middle East)"), (Comparable)((Object)"G2"));
        keyToGroupMap.mapKeyToGroup((Comparable)((Object)"Product 3 (US)"), (Comparable)((Object)"G3"));
        keyToGroupMap.mapKeyToGroup((Comparable)((Object)"Product 3 (Europe)"), (Comparable)((Object)"G3"));
        keyToGroupMap.mapKeyToGroup((Comparable)((Object)"Product 3 (Asia)"), (Comparable)((Object)"G3"));
        keyToGroupMap.mapKeyToGroup((Comparable)((Object)"Product 3 (Middle East)"), (Comparable)((Object)"G3"));
        groupedStackedBarRenderer.setSeriesToGroupMap(keyToGroupMap);
        groupedStackedBarRenderer.setItemMargin(0.1);
        groupedStackedBarRenderer.setDrawBarOutline(false);
        SubCategoryAxis subCategoryAxis = new SubCategoryAxis("Product / Month");
        subCategoryAxis.setCategoryMargin(0.05);
        subCategoryAxis.addSubCategory((Comparable)((Object)"Product 1"));
        subCategoryAxis.addSubCategory((Comparable)((Object)"Product 2"));
        subCategoryAxis.addSubCategory((Comparable)((Object)"Product 3"));
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setDomainAxis((CategoryAxis)subCategoryAxis);
        categoryPlot.setRenderer((CategoryItemRenderer)groupedStackedBarRenderer);
        categoryPlot.setFixedLegendItems(StackedBarChartDemo4.createLegendItems());
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        subCategoryAxis.setSubLabelFont(new Font("Tahoma", 2, 10));
        GradientPaint gradientPaint = new GradientPaint(0.0f, 0.0f, new Color(34, 34, 255), 0.0f, 0.0f, new Color(136, 136, 255));
        groupedStackedBarRenderer.setSeriesPaint(0, (Paint)gradientPaint);
        groupedStackedBarRenderer.setSeriesPaint(4, (Paint)gradientPaint);
        groupedStackedBarRenderer.setSeriesPaint(8, (Paint)gradientPaint);
        GradientPaint gradientPaint2 = new GradientPaint(0.0f, 0.0f, new Color(34, 255, 34), 0.0f, 0.0f, new Color(136, 255, 136));
        groupedStackedBarRenderer.setSeriesPaint(1, (Paint)gradientPaint2);
        groupedStackedBarRenderer.setSeriesPaint(5, (Paint)gradientPaint2);
        groupedStackedBarRenderer.setSeriesPaint(9, (Paint)gradientPaint2);
        GradientPaint gradientPaint3 = new GradientPaint(0.0f, 0.0f, new Color(255, 34, 34), 0.0f, 0.0f, new Color(255, 136, 136));
        groupedStackedBarRenderer.setSeriesPaint(2, (Paint)gradientPaint3);
        groupedStackedBarRenderer.setSeriesPaint(6, (Paint)gradientPaint3);
        groupedStackedBarRenderer.setSeriesPaint(10, (Paint)gradientPaint3);
        GradientPaint gradientPaint4 = new GradientPaint(0.0f, 0.0f, new Color(255, 255, 34), 0.0f, 0.0f, new Color(255, 255, 136));
        groupedStackedBarRenderer.setSeriesPaint(3, (Paint)gradientPaint4);
        groupedStackedBarRenderer.setSeriesPaint(7, (Paint)gradientPaint4);
        groupedStackedBarRenderer.setSeriesPaint(11, (Paint)gradientPaint4);
        groupedStackedBarRenderer.setGradientPaintTransformer((GradientPaintTransformer)new StandardGradientPaintTransformer(GradientPaintTransformType.HORIZONTAL));
        return jFreeChart;
    }

    private static LegendItemCollection createLegendItems() {
        LegendItemCollection legendItemCollection = new LegendItemCollection();
        LegendItem legendItem = new LegendItem("US", "-", null, null, Plot.DEFAULT_LEGEND_ITEM_BOX, (Paint)new Color(34, 34, 255));
        LegendItem legendItem2 = new LegendItem("Europe", "-", null, null, Plot.DEFAULT_LEGEND_ITEM_BOX, (Paint)new Color(34, 255, 34));
        LegendItem legendItem3 = new LegendItem("Asia", "-", null, null, Plot.DEFAULT_LEGEND_ITEM_BOX, (Paint)new Color(255, 34, 34));
        LegendItem legendItem4 = new LegendItem("Middle East", "-", null, null, Plot.DEFAULT_LEGEND_ITEM_BOX, (Paint)new Color(255, 255, 34));
        legendItemCollection.add(legendItem);
        legendItemCollection.add(legendItem2);
        legendItemCollection.add(legendItem3);
        legendItemCollection.add(legendItem4);
        return legendItemCollection;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = StackedBarChartDemo4.createChart(StackedBarChartDemo4.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        StackedBarChartDemo4 stackedBarChartDemo4 = new StackedBarChartDemo4("Stacked Bar Chart Demo 4");
        stackedBarChartDemo4.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)stackedBarChartDemo4));
        stackedBarChartDemo4.setVisible(true);
    }
}

