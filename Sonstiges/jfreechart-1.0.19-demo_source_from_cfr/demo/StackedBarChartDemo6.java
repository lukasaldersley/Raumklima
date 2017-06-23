/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.ValueAxis
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
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StackedBarChartDemo6
extends ApplicationFrame {
    public StackedBarChartDemo6(String string) {
        super(string);
        JPanel jPanel = StackedBarChartDemo6.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        long l = 86400000;
        defaultCategoryDataset.addValue((double)(3 * l), (Comparable)((Object)"Series 1"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue((double)(1 * l), (Comparable)((Object)"Series 2"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue((double)(2 * l), (Comparable)((Object)"Series 3"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue((double)(4 * l), (Comparable)((Object)"Series 1"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset.addValue((double)(5 * l), (Comparable)((Object)"Series 2"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset.addValue((double)(1 * l), (Comparable)((Object)"Series 3"), (Comparable)((Object)"Category 2"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createStackedBarChart((String)"Stacked Bar Chart Demo 6", (String)"Category", (String)"Value", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.HORIZONTAL, (boolean)true, (boolean)true, (boolean)false);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        StackedBarRenderer stackedBarRenderer = (StackedBarRenderer)categoryPlot.getRenderer();
        stackedBarRenderer.setDrawBarOutline(false);
        long l = System.currentTimeMillis();
        stackedBarRenderer.setBase((double)l);
        DateAxis dateAxis = new DateAxis("Date");
        dateAxis.setLowerMargin(0.0);
        categoryPlot.setRangeAxis((ValueAxis)dateAxis);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = StackedBarChartDemo6.createChart(StackedBarChartDemo6.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        StackedBarChartDemo6 stackedBarChartDemo6 = new StackedBarChartDemo6("Stacked Bar Chart Demo 6");
        stackedBarChartDemo6.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)stackedBarChartDemo6));
        stackedBarChartDemo6.setVisible(true);
    }
}

