/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
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

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StackedAreaChartDemo1
extends ApplicationFrame {
    public StackedAreaChartDemo1(String string) {
        super(string);
        JPanel jPanel = StackedAreaChartDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    public static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(1.0, (Comparable)((Object)"S1"), (Comparable)((Object)"C1"));
        defaultCategoryDataset.addValue(2.0, (Comparable)((Object)"S1"), (Comparable)((Object)"C2"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"S1"), (Comparable)((Object)"C3"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"S1"), (Comparable)((Object)"C4"));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)"S1"), (Comparable)((Object)"C5"));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)"S1"), (Comparable)((Object)"C6"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"S1"), (Comparable)((Object)"C7"));
        defaultCategoryDataset.addValue(8.0, (Comparable)((Object)"S1"), (Comparable)((Object)"C8"));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)"S2"), (Comparable)((Object)"C1"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"S2"), (Comparable)((Object)"C2"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"S2"), (Comparable)((Object)"C3"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"S2"), (Comparable)((Object)"C4"));
        defaultCategoryDataset.addValue(9.0, (Comparable)((Object)"S2"), (Comparable)((Object)"C5"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"S2"), (Comparable)((Object)"C6"));
        defaultCategoryDataset.addValue(2.0, (Comparable)((Object)"S2"), (Comparable)((Object)"C7"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"S2"), (Comparable)((Object)"C8"));
        defaultCategoryDataset.addValue(1.0, (Comparable)((Object)"S3"), (Comparable)((Object)"C1"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"S3"), (Comparable)((Object)"C2"));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)"S3"), (Comparable)((Object)"C3"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"S3"), (Comparable)((Object)"C4"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"S3"), (Comparable)((Object)"C5"));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)"S3"), (Comparable)((Object)"C6"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"S3"), (Comparable)((Object)"C7"));
        defaultCategoryDataset.addValue(1.0, (Comparable)((Object)"S3"), (Comparable)((Object)"C8"));
        return defaultCategoryDataset;
    }

    public static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createStackedAreaChart((String)"Stacked Area Chart", (String)"Category", (String)"Value", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setForegroundAlpha(0.85f);
        CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
        categoryAxis.setLowerMargin(0.0);
        categoryAxis.setUpperMargin(0.0);
        categoryAxis.setCategoryMargin(0.0);
        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        CategoryItemRenderer categoryItemRenderer = categoryPlot.getRenderer();
        categoryItemRenderer.setBaseItemLabelsVisible(true);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = StackedAreaChartDemo1.createChart(StackedAreaChartDemo1.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        StackedAreaChartDemo1 stackedAreaChartDemo1 = new StackedAreaChartDemo1("JFreeChart: StackedAreaChartDemo1.java");
        stackedAreaChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)stackedAreaChartDemo1));
        stackedAreaChartDemo1.setVisible(true);
    }
}

