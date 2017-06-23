/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.CategoryItemLabelGenerator
 *  org.jfree.chart.labels.StandardCategoryItemLabelGenerator
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.renderer.category.StackedBarRenderer
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import java.text.NumberFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StackedBarChartDemo7
extends ApplicationFrame {
    public StackedBarChartDemo7(String string) {
        super(string);
        JPanel jPanel = StackedBarChartDemo7.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(32.4, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue(17.8, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue(27.7, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue(43.2, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset.addValue(15.6, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset.addValue(18.3, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset.addValue(23.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Category 3"));
        defaultCategoryDataset.addValue(111.3, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Category 3"));
        defaultCategoryDataset.addValue(25.5, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Category 3"));
        defaultCategoryDataset.addValue(13.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Category 4"));
        defaultCategoryDataset.addValue(11.8, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Category 4"));
        defaultCategoryDataset.addValue(29.5, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Category 4"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createStackedBarChart((String)"Stacked Bar Chart Demo 7", (String)"Category", (String)"Value", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setNumberFormatOverride(NumberFormat.getPercentInstance());
        StackedBarRenderer stackedBarRenderer = (StackedBarRenderer)categoryPlot.getRenderer();
        stackedBarRenderer.setRenderAsPercentages(true);
        stackedBarRenderer.setDrawBarOutline(false);
        stackedBarRenderer.setBaseItemLabelsVisible(true);
        stackedBarRenderer.setBaseItemLabelGenerator((CategoryItemLabelGenerator)new StandardCategoryItemLabelGenerator());
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = StackedBarChartDemo7.createChart(StackedBarChartDemo7.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        StackedBarChartDemo7 stackedBarChartDemo7 = new StackedBarChartDemo7("Stacked Bar Chart Demo 7");
        stackedBarChartDemo7.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)stackedBarChartDemo7));
        stackedBarChartDemo7.setVisible(true);
    }
}

