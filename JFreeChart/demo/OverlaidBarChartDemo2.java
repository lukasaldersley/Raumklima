/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.CategoryToolTipGenerator
 *  org.jfree.chart.labels.StandardCategoryToolTipGenerator
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.DatasetRenderingOrder
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.renderer.category.BarRenderer
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.renderer.category.LevelRenderer
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.BasicStroke;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Stroke;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LevelRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class OverlaidBarChartDemo2
extends ApplicationFrame {
    public OverlaidBarChartDemo2(String string) {
        super(string);
        JPanel jPanel = OverlaidBarChartDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(1.0, (Comparable)((Object)"S1"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"S1"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"S1"), (Comparable)((Object)"Category 3"));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)"S1"), (Comparable)((Object)"Category 4"));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)"S1"), (Comparable)((Object)"Category 5"));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)"S2"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"S2"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)"S2"), (Comparable)((Object)"Category 3"));
        defaultCategoryDataset.addValue(8.0, (Comparable)((Object)"S2"), (Comparable)((Object)"Category 4"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"S2"), (Comparable)((Object)"Category 5"));
        BarRenderer barRenderer = new BarRenderer();
        barRenderer.setBaseToolTipGenerator((CategoryToolTipGenerator)new StandardCategoryToolTipGenerator());
        CategoryPlot categoryPlot = new CategoryPlot();
        categoryPlot.setDataset((CategoryDataset)defaultCategoryDataset);
        categoryPlot.setRenderer((CategoryItemRenderer)barRenderer);
        categoryPlot.setDomainAxis(new CategoryAxis("Category"));
        categoryPlot.setRangeAxis((ValueAxis)new NumberAxis("Value"));
        categoryPlot.setOrientation(PlotOrientation.VERTICAL);
        categoryPlot.setRangeGridlinesVisible(true);
        categoryPlot.setDomainGridlinesVisible(true);
        categoryPlot.setRangeZeroBaselineVisible(true);
        categoryPlot.setRangePannable(true);
        DefaultCategoryDataset defaultCategoryDataset2 = new DefaultCategoryDataset();
        defaultCategoryDataset2.addValue(6.0, (Comparable)((Object)"Prior 1"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset2.addValue(7.0, (Comparable)((Object)"Prior 1"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset2.addValue(2.0, (Comparable)((Object)"Prior 1"), (Comparable)((Object)"Category 3"));
        defaultCategoryDataset2.addValue(6.0, (Comparable)((Object)"Prior 1"), (Comparable)((Object)"Category 4"));
        defaultCategoryDataset2.addValue(6.0, (Comparable)((Object)"Prior 1"), (Comparable)((Object)"Category 5"));
        defaultCategoryDataset2.addValue(4.0, (Comparable)((Object)"Prior 2"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset2.addValue(2.0, (Comparable)((Object)"Prior 2"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset2.addValue(1.0, (Comparable)((Object)"Prior 2"), (Comparable)((Object)"Category 3"));
        defaultCategoryDataset2.addValue(3.0, (Comparable)((Object)"Prior 2"), (Comparable)((Object)"Category 4"));
        defaultCategoryDataset2.addValue(2.0, (Comparable)((Object)"Prior 2"), (Comparable)((Object)"Category 5"));
        LevelRenderer levelRenderer = new LevelRenderer();
        categoryPlot.setDataset(1, (CategoryDataset)defaultCategoryDataset2);
        categoryPlot.setRenderer(1, (CategoryItemRenderer)levelRenderer);
        categoryPlot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
        JFreeChart jFreeChart = new JFreeChart((Plot)categoryPlot);
        jFreeChart.setTitle("OverlaidBarChartDemo2");
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        levelRenderer.setSeriesStroke(0, (Stroke)new BasicStroke(2.0f));
        levelRenderer.setSeriesStroke(1, (Stroke)new BasicStroke(2.0f));
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = OverlaidBarChartDemo2.createChart();
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        OverlaidBarChartDemo2 overlaidBarChartDemo2 = new OverlaidBarChartDemo2("JFreeChart: OverlaidBarChartDemo2.java");
        overlaidBarChartDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)overlaidBarChartDemo2));
        overlaidBarChartDemo2.setVisible(true);
    }
}

