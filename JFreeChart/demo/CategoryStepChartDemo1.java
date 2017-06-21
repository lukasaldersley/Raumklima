/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.axis.CategoryLabelPositions
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.CategoryToolTipGenerator
 *  org.jfree.chart.labels.StandardCategoryToolTipGenerator
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.renderer.category.CategoryStepRenderer
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.general.DatasetUtilities
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RectangleInsets
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
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.CategoryStepRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class CategoryStepChartDemo1
extends ApplicationFrame {
    public CategoryStepChartDemo1(String string) {
        super(string);
        ChartPanel chartPanel = (ChartPanel)CategoryStepChartDemo1.createDemoPanel();
        chartPanel.setPreferredSize(new Dimension(500, 270));
        chartPanel.setEnforceFileExtensions(false);
        this.setContentPane((Container)chartPanel);
    }

    private static CategoryDataset createDataset() {
        double[][] arrarrd = new double[][]{{1.0, 4.0, 3.0, 5.0, 5.0, 7.0, 7.0, 8.0}, {5.0, 7.0, 6.0, 8.0, 4.0, 4.0, 2.0, 1.0}, {4.0, 3.0, 2.0, 3.0, 6.0, 3.0, 4.0, 3.0}};
        CategoryDataset categoryDataset = DatasetUtilities.createCategoryDataset((String)"Series ", (String)"Type ", (double[][])arrarrd);
        return categoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        CategoryStepRenderer categoryStepRenderer = new CategoryStepRenderer(true);
        categoryStepRenderer.setBaseToolTipGenerator((CategoryToolTipGenerator)new StandardCategoryToolTipGenerator());
        CategoryAxis categoryAxis = new CategoryAxis("Category");
        NumberAxis numberAxis = new NumberAxis("Value");
        CategoryPlot categoryPlot = new CategoryPlot(categoryDataset, categoryAxis, (ValueAxis)numberAxis, (CategoryItemRenderer)categoryStepRenderer);
        categoryPlot.setRangePannable(true);
        JFreeChart jFreeChart = new JFreeChart("Category Step Chart", (Plot)categoryPlot);
        categoryPlot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        categoryPlot.setDomainGridlinesVisible(true);
        categoryPlot.setRangeGridlinesVisible(true);
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        categoryAxis.setLowerMargin(0.0);
        categoryAxis.setUpperMargin(0.0);
        categoryAxis.addCategoryLabelToolTip((Comparable)((Object)"Type 1"), "The first type.");
        categoryAxis.addCategoryLabelToolTip((Comparable)((Object)"Type 2"), "The second type.");
        categoryAxis.addCategoryLabelToolTip((Comparable)((Object)"Type 3"), "The third type.");
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberAxis.setLabelAngle(0.0);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = CategoryStepChartDemo1.createChart(CategoryStepChartDemo1.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        CategoryStepChartDemo1 categoryStepChartDemo1 = new CategoryStepChartDemo1("JFreeChart : CategoryStepChartDemo1.java");
        categoryStepChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)categoryStepChartDemo1));
        categoryStepChartDemo1.setVisible(true);
    }
}

