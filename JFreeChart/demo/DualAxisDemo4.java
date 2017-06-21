/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.AxisLocation
 *  org.jfree.chart.axis.NumberAxis3D
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.DatasetRenderingOrder
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.renderer.category.LineRenderer3D
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class DualAxisDemo4
extends ApplicationFrame {
    public DualAxisDemo4(String string) {
        super(string);
        JPanel jPanel = DualAxisDemo4.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart() {
        CategoryDataset categoryDataset = DualAxisDemo4.createDataset1();
        JFreeChart jFreeChart = ChartFactory.createBarChart3D((String)"Dual Axis Chart", (String)"Category", (String)"Value", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
        categoryPlot.setRangeAxisLocation(AxisLocation.TOP_OR_LEFT);
        CategoryItemRenderer categoryItemRenderer = categoryPlot.getRenderer();
        categoryItemRenderer.setSeriesPaint(0, (Paint)Color.red);
        categoryItemRenderer.setSeriesPaint(1, (Paint)Color.yellow);
        categoryItemRenderer.setSeriesPaint(2, (Paint)Color.green);
        CategoryDataset categoryDataset2 = DualAxisDemo4.createDataset2();
        NumberAxis3D numberAxis3D = new NumberAxis3D("Secondary");
        categoryPlot.setRangeAxis(1, (ValueAxis)numberAxis3D);
        categoryPlot.setDataset(1, categoryDataset2);
        categoryPlot.mapDatasetToRangeAxis(1, 1);
        LineRenderer3D lineRenderer3D = new LineRenderer3D();
        lineRenderer3D.setSeriesPaint(0, (Paint)Color.blue);
        categoryPlot.setRenderer(1, (CategoryItemRenderer)lineRenderer3D);
        categoryPlot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    private static CategoryDataset createDataset1() {
        String string = "First";
        String string2 = "Second";
        String string3 = "Third";
        String string4 = "Category 1";
        String string5 = "Category 2";
        String string6 = "Category 3";
        String string7 = "Category 4";
        String string8 = "Category 5";
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(1.0, (Comparable)((Object)string), (Comparable)((Object)string4));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)string), (Comparable)((Object)string5));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)string), (Comparable)((Object)string6));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)string), (Comparable)((Object)string7));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)string), (Comparable)((Object)string8));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)string2), (Comparable)((Object)string4));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)string2), (Comparable)((Object)string5));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)string2), (Comparable)((Object)string6));
        defaultCategoryDataset.addValue(8.0, (Comparable)((Object)string2), (Comparable)((Object)string7));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)string2), (Comparable)((Object)string8));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)string3), (Comparable)((Object)string4));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)string3), (Comparable)((Object)string5));
        defaultCategoryDataset.addValue(2.0, (Comparable)((Object)string3), (Comparable)((Object)string6));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)string3), (Comparable)((Object)string7));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)string3), (Comparable)((Object)string8));
        return defaultCategoryDataset;
    }

    private static CategoryDataset createDataset2() {
        String string = "Fourth";
        String string2 = "Category 1";
        String string3 = "Category 2";
        String string4 = "Category 3";
        String string5 = "Category 4";
        String string6 = "Category 5";
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(15.0, (Comparable)((Object)string), (Comparable)((Object)string2));
        defaultCategoryDataset.addValue(24.0, (Comparable)((Object)string), (Comparable)((Object)string3));
        defaultCategoryDataset.addValue(31.0, (Comparable)((Object)string), (Comparable)((Object)string4));
        defaultCategoryDataset.addValue(25.0, (Comparable)((Object)string), (Comparable)((Object)string5));
        defaultCategoryDataset.addValue(56.0, (Comparable)((Object)string), (Comparable)((Object)string6));
        return defaultCategoryDataset;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = DualAxisDemo4.createChart();
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        DualAxisDemo4 dualAxisDemo4 = new DualAxisDemo4("JFreeChart: DualAxisDemo4.java");
        dualAxisDemo4.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)dualAxisDemo4));
        dualAxisDemo4.setVisible(true);
    }
}

