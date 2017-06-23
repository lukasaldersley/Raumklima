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
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.renderer.category.IntervalBarRenderer
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultIntervalCategoryDataset
 *  org.jfree.data.category.IntervalCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.IntervalBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultIntervalCategoryDataset;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class IntervalBarChartDemo1
extends ApplicationFrame {
    private static final long serialVersionUID = 1;

    public IntervalBarChartDemo1(String string) {
        super(string);
        JPanel jPanel = IntervalBarChartDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static IntervalCategoryDataset createDataset() {
        double[] arrd = new double[]{0.1, 0.2, 0.3};
        double[] arrd2 = new double[]{0.3, 0.4, 0.5};
        double[] arrd3 = new double[]{0.5, 0.6, 0.7};
        double[] arrd4 = new double[]{0.7, 0.8, 0.9};
        double[][] arrarrd = new double[][]{arrd, arrd2};
        double[][] arrarrd2 = new double[][]{arrd3, arrd4};
        DefaultIntervalCategoryDataset defaultIntervalCategoryDataset = new DefaultIntervalCategoryDataset((double[][])arrarrd, (double[][])arrarrd2);
        return defaultIntervalCategoryDataset;
    }

    private static JFreeChart createChart(IntervalCategoryDataset intervalCategoryDataset) {
        CategoryAxis categoryAxis = new CategoryAxis("Category");
        NumberAxis numberAxis = new NumberAxis("Percentage");
        numberAxis.setNumberFormatOverride((NumberFormat)new DecimalFormat("0.00%"));
        IntervalBarRenderer intervalBarRenderer = new IntervalBarRenderer();
        CategoryPlot categoryPlot = new CategoryPlot((CategoryDataset)intervalCategoryDataset, categoryAxis, (ValueAxis)numberAxis, (CategoryItemRenderer)intervalBarRenderer);
        JFreeChart jFreeChart = new JFreeChart("IntervalBarChartDemo1", (Plot)categoryPlot);
        categoryPlot.setDomainGridlinesVisible(true);
        categoryPlot.setRangePannable(true);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = IntervalBarChartDemo1.createChart(IntervalBarChartDemo1.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        IntervalBarChartDemo1 intervalBarChartDemo1 = new IntervalBarChartDemo1("JFreeChart: IntervalBarChartDemo1.java");
        intervalBarChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)intervalBarChartDemo1));
        intervalBarChartDemo1.setVisible(true);
    }
}

