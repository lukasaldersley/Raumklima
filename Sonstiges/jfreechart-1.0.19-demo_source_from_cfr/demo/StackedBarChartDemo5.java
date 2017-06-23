/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.axis.SubCategoryAxis
 *  org.jfree.chart.labels.CategoryItemLabelGenerator
 *  org.jfree.chart.labels.ItemLabelAnchor
 *  org.jfree.chart.labels.ItemLabelPosition
 *  org.jfree.chart.labels.StandardCategoryItemLabelGenerator
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.renderer.category.GroupedStackedBarRenderer
 *  org.jfree.data.KeyToGroupMap
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
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.SubCategoryAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class StackedBarChartDemo5
extends ApplicationFrame {
    public StackedBarChartDemo5(String string) {
        super(string);
        JPanel jPanel = StackedBarChartDemo5.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(3396.0, (Comparable)((Object)"S1"), (Comparable)((Object)"C1"));
        defaultCategoryDataset.addValue(1580.0, (Comparable)((Object)"S2"), (Comparable)((Object)"C1"));
        defaultCategoryDataset.addValue(76.0, (Comparable)((Object)"S3"), (Comparable)((Object)"C1"));
        defaultCategoryDataset.addValue(10100.0, (Comparable)((Object)"S4"), (Comparable)((Object)"C1"));
        defaultCategoryDataset.addValue(3429.0, (Comparable)((Object)"S1"), (Comparable)((Object)"C2"));
        defaultCategoryDataset.addValue(1562.0, (Comparable)((Object)"S2"), (Comparable)((Object)"C2"));
        defaultCategoryDataset.addValue(61.0, (Comparable)((Object)"S3"), (Comparable)((Object)"C2"));
        defaultCategoryDataset.addValue(-10100.0, (Comparable)((Object)"S4"), (Comparable)((Object)"C2"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createStackedBarChart((String)"Stacked Bar Chart Demo 5", (String)"Category", (String)"Value", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        GroupedStackedBarRenderer groupedStackedBarRenderer = new GroupedStackedBarRenderer();
        KeyToGroupMap keyToGroupMap = new KeyToGroupMap((Comparable)((Object)"G1"));
        keyToGroupMap.mapKeyToGroup((Comparable)((Object)"S1"), (Comparable)((Object)"G1"));
        keyToGroupMap.mapKeyToGroup((Comparable)((Object)"S2"), (Comparable)((Object)"G1"));
        keyToGroupMap.mapKeyToGroup((Comparable)((Object)"S3"), (Comparable)((Object)"G2"));
        keyToGroupMap.mapKeyToGroup((Comparable)((Object)"S4"), (Comparable)((Object)"G3"));
        groupedStackedBarRenderer.setSeriesToGroupMap(keyToGroupMap);
        groupedStackedBarRenderer.setBaseItemLabelGenerator((CategoryItemLabelGenerator)new StandardCategoryItemLabelGenerator());
        groupedStackedBarRenderer.setBaseItemLabelsVisible(true);
        groupedStackedBarRenderer.setPositiveItemLabelPositionFallback(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER));
        groupedStackedBarRenderer.setItemMargin(0.1);
        SubCategoryAxis subCategoryAxis = new SubCategoryAxis("Category / Group");
        subCategoryAxis.setCategoryMargin(0.05);
        subCategoryAxis.addSubCategory((Comparable)((Object)"G1"));
        subCategoryAxis.addSubCategory((Comparable)((Object)"G2"));
        subCategoryAxis.addSubCategory((Comparable)((Object)"G3"));
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setDomainAxis((CategoryAxis)subCategoryAxis);
        categoryPlot.setRenderer((CategoryItemRenderer)groupedStackedBarRenderer);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = StackedBarChartDemo5.createChart(StackedBarChartDemo5.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        StackedBarChartDemo5 stackedBarChartDemo5 = new StackedBarChartDemo5("Stacked Bar Chart Demo 5");
        stackedBarChartDemo5.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)stackedBarChartDemo5));
        stackedBarChartDemo5.setVisible(true);
    }
}

