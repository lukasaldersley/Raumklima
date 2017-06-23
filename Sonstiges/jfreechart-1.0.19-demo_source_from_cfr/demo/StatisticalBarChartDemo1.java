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
 *  org.jfree.chart.labels.ItemLabelAnchor
 *  org.jfree.chart.labels.ItemLabelPosition
 *  org.jfree.chart.labels.StandardCategoryItemLabelGenerator
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.renderer.category.StatisticalBarRenderer
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.statistics.DefaultStatisticalCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.ui.TextAnchor
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.StatisticalBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.statistics.DefaultStatisticalCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class StatisticalBarChartDemo1
extends ApplicationFrame {
    private static final long serialVersionUID = 1;

    public StatisticalBarChartDemo1(String string) {
        super(string);
        JPanel jPanel = StatisticalBarChartDemo1.createDemoPanel();
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
        JFreeChart jFreeChart = ChartFactory.createLineChart((String)"Statistical Bar Chart Demo 1", (String)"Type", (String)"Value", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberAxis.setAutoRangeIncludesZero(false);
        StatisticalBarRenderer statisticalBarRenderer = new StatisticalBarRenderer();
        statisticalBarRenderer.setDrawBarOutline(false);
        statisticalBarRenderer.setErrorIndicatorPaint((Paint)Color.black);
        statisticalBarRenderer.setIncludeBaseInRange(false);
        categoryPlot.setRenderer((CategoryItemRenderer)statisticalBarRenderer);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        statisticalBarRenderer.setBaseItemLabelGenerator((CategoryItemLabelGenerator)new StandardCategoryItemLabelGenerator());
        statisticalBarRenderer.setBaseItemLabelsVisible(true);
        statisticalBarRenderer.setBaseItemLabelPaint((Paint)Color.yellow);
        statisticalBarRenderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.INSIDE6, TextAnchor.BOTTOM_CENTER));
        GradientPaint gradientPaint = new GradientPaint(0.0f, 0.0f, Color.blue, 0.0f, 0.0f, new Color(0, 0, 64));
        GradientPaint gradientPaint2 = new GradientPaint(0.0f, 0.0f, Color.green, 0.0f, 0.0f, new Color(0, 64, 0));
        statisticalBarRenderer.setSeriesPaint(0, (Paint)gradientPaint);
        statisticalBarRenderer.setSeriesPaint(1, (Paint)gradientPaint2);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = StatisticalBarChartDemo1.createChart(StatisticalBarChartDemo1.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        StatisticalBarChartDemo1 statisticalBarChartDemo1 = new StatisticalBarChartDemo1("JFreeChart: StatisticalBarChartDemo1.java");
        statisticalBarChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)statisticalBarChartDemo1));
        statisticalBarChartDemo1.setVisible(true);
    }
}

