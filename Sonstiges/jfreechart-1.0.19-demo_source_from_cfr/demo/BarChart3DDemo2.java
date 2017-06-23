/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.axis.CategoryLabelPosition
 *  org.jfree.chart.axis.CategoryLabelPositions
 *  org.jfree.chart.axis.CategoryLabelWidthType
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.text.TextBlockAnchor
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RectangleAnchor
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.ui.TextAnchor
 *  org.jfree.util.SortOrder
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
import org.jfree.chart.axis.CategoryLabelPosition;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.CategoryLabelWidthType;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.text.TextBlockAnchor;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;
import org.jfree.util.SortOrder;

public class BarChart3DDemo2
extends ApplicationFrame {
    public BarChart3DDemo2(String string) {
        super(string);
        JPanel jPanel = BarChart3DDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(23.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"London"));
        defaultCategoryDataset.addValue(14.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"New York"));
        defaultCategoryDataset.addValue(14.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Istanbul"));
        defaultCategoryDataset.addValue(14.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Cairo"));
        defaultCategoryDataset.addValue(13.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"London"));
        defaultCategoryDataset.addValue(19.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"New York"));
        defaultCategoryDataset.addValue(19.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Istanbul"));
        defaultCategoryDataset.addValue(19.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Cairo"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"London"));
        defaultCategoryDataset.addValue(9.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"New York"));
        defaultCategoryDataset.addValue(9.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Istanbul"));
        defaultCategoryDataset.addValue(9.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Cairo"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createBarChart3D((String)"3D Bar Chart Demo 2", (String)"Category", (String)"Value", (CategoryDataset)categoryDataset);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setOrientation(PlotOrientation.HORIZONTAL);
        categoryPlot.setRowRenderingOrder(SortOrder.DESCENDING);
        categoryPlot.setColumnRenderingOrder(SortOrder.DESCENDING);
        categoryPlot.setForegroundAlpha(1.0f);
        categoryPlot.setRangePannable(true);
        CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
        CategoryLabelPositions categoryLabelPositions = categoryAxis.getCategoryLabelPositions();
        CategoryLabelPosition categoryLabelPosition = new CategoryLabelPosition(RectangleAnchor.LEFT, TextBlockAnchor.CENTER_LEFT, TextAnchor.CENTER_LEFT, 0.0, CategoryLabelWidthType.RANGE, 0.3f);
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.replaceLeftPosition((CategoryLabelPositions)categoryLabelPositions, (CategoryLabelPosition)categoryLabelPosition));
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = BarChart3DDemo2.createChart(BarChart3DDemo2.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        BarChart3DDemo2 barChart3DDemo2 = new BarChart3DDemo2("JFreeChart: BarChart3DDemo2.java");
        barChart3DDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)barChart3DDemo2));
        barChart3DDemo2.setVisible(true);
    }
}

