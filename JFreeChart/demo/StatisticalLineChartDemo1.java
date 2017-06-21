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
 *  org.jfree.chart.renderer.category.StatisticalLineAndShapeRenderer
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.statistics.DefaultStatisticalCategoryDataset
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
import org.jfree.chart.renderer.category.StatisticalLineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.statistics.DefaultStatisticalCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StatisticalLineChartDemo1
extends ApplicationFrame {
    public StatisticalLineChartDemo1(String string) {
        super(string);
        JPanel jPanel = StatisticalLineChartDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultStatisticalCategoryDataset defaultStatisticalCategoryDataset = new DefaultStatisticalCategoryDataset();
        defaultStatisticalCategoryDataset.add(10.0, 2.4, (Comparable)((Object)"Row 1"), (Comparable)((Object)"Column 1"));
        defaultStatisticalCategoryDataset.add(15.0, 4.4, (Comparable)((Object)"Row 1"), (Comparable)((Object)"Column 2"));
        defaultStatisticalCategoryDataset.add(13.0, 2.1, (Comparable)((Object)"Row 1"), (Comparable)((Object)"Column 3"));
        defaultStatisticalCategoryDataset.add(7.0, 1.3, (Comparable)((Object)"Row 1"), (Comparable)((Object)"Column 4"));
        defaultStatisticalCategoryDataset.add(22.0, 2.4, (Comparable)((Object)"Row 2"), (Comparable)((Object)"Column 1"));
        defaultStatisticalCategoryDataset.add(18.0, 4.4, (Comparable)((Object)"Row 2"), (Comparable)((Object)"Column 2"));
        defaultStatisticalCategoryDataset.add(28.0, 2.1, (Comparable)((Object)"Row 2"), (Comparable)((Object)"Column 3"));
        defaultStatisticalCategoryDataset.add(17.0, 1.3, (Comparable)((Object)"Row 2"), (Comparable)((Object)"Column 4"));
        return defaultStatisticalCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createLineChart((String)"Statistical Line Chart Demo 1", (String)"Type", (String)"Value", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setRangePannable(true);
        CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
        categoryAxis.setUpperMargin(0.0);
        categoryAxis.setLowerMargin(0.0);
        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberAxis.setAutoRangeIncludesZero(true);
        StatisticalLineAndShapeRenderer statisticalLineAndShapeRenderer = new StatisticalLineAndShapeRenderer(true, false);
        statisticalLineAndShapeRenderer.setUseSeriesOffset(true);
        categoryPlot.setRenderer((CategoryItemRenderer)statisticalLineAndShapeRenderer);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = StatisticalLineChartDemo1.createChart(StatisticalLineChartDemo1.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        StatisticalLineChartDemo1 statisticalLineChartDemo1 = new StatisticalLineChartDemo1("JFreeChart: StatisticalLineChartDemo1.java");
        statisticalLineChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)statisticalLineChartDemo1));
        statisticalLineChartDemo1.setVisible(true);
    }
}

