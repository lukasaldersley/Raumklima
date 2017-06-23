/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.CategoryItemLabelGenerator
 *  org.jfree.chart.labels.CategoryToolTipGenerator
 *  org.jfree.chart.labels.StandardCategoryItemLabelGenerator
 *  org.jfree.chart.labels.StandardCategoryToolTipGenerator
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import demo.ExtendedStackedBarRenderer;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import java.text.NumberFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StackedBarChartDemo3
extends ApplicationFrame {
    public StackedBarChartDemo3(String string) {
        super(string);
        JPanel jPanel = StackedBarChartDemo3.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(10.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Jan"));
        defaultCategoryDataset.addValue(12.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Feb"));
        defaultCategoryDataset.addValue(13.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Mar"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Jan"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Feb"));
        defaultCategoryDataset.addValue(2.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Mar"));
        defaultCategoryDataset.addValue(2.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Jan"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Feb"));
        defaultCategoryDataset.addValue(2.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Mar"));
        defaultCategoryDataset.addValue(2.0, (Comparable)((Object)"Series 4"), (Comparable)((Object)"Jan"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"Series 4"), (Comparable)((Object)"Feb"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"Series 4"), (Comparable)((Object)"Mar"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createStackedBarChart((String)"Stacked Bar Chart Demo 3", (String)"Category", (String)"Value", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)false, (boolean)false);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        ExtendedStackedBarRenderer extendedStackedBarRenderer = new ExtendedStackedBarRenderer();
        extendedStackedBarRenderer.setBaseItemLabelsVisible(true);
        extendedStackedBarRenderer.setBaseItemLabelGenerator((CategoryItemLabelGenerator)new StandardCategoryItemLabelGenerator());
        extendedStackedBarRenderer.setBaseToolTipGenerator((CategoryToolTipGenerator)new StandardCategoryToolTipGenerator());
        categoryPlot.setRenderer((CategoryItemRenderer)extendedStackedBarRenderer);
        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberAxis.setLowerMargin(0.15);
        numberAxis.setUpperMargin(0.15);
        numberAxis.setNumberFormatOverride(NumberFormat.getPercentInstance());
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = StackedBarChartDemo3.createChart(StackedBarChartDemo3.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        StackedBarChartDemo3 stackedBarChartDemo3 = new StackedBarChartDemo3("Stacked Bar Chart Demo 3");
        stackedBarChartDemo3.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)stackedBarChartDemo3));
        stackedBarChartDemo3.setVisible(true);
    }
}

