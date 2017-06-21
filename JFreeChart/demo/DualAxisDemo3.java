/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.AxisLocation
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.DatasetRenderingOrder
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.renderer.category.LineAndShapeRenderer
 *  org.jfree.chart.title.LegendTitle
 *  org.jfree.chart.title.Title
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RectangleEdge
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;

public class DualAxisDemo3
extends ApplicationFrame {
    public DualAxisDemo3(String string) {
        super(string);
        JPanel jPanel = DualAxisDemo3.createDemoPanel();
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart() {
        CategoryDataset categoryDataset = DualAxisDemo3.createDataset1();
        JFreeChart jFreeChart = ChartFactory.createBarChart((String)"Dual Axis Chart", (String)"Category", (String)"Value", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.HORIZONTAL, (boolean)true, (boolean)true, (boolean)false);
        LegendTitle legendTitle = (LegendTitle)jFreeChart.getSubtitle(0);
        legendTitle.setPosition(RectangleEdge.LEFT);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
        categoryPlot.getDomainAxis().setMaximumCategoryLabelWidthRatio(10.0f);
        CategoryDataset categoryDataset2 = DualAxisDemo3.createDataset2();
        NumberAxis numberAxis = new NumberAxis("Secondary");
        categoryPlot.setRangeAxis(1, (ValueAxis)numberAxis);
        categoryPlot.setDataset(1, categoryDataset2);
        categoryPlot.mapDatasetToRangeAxis(1, 1);
        categoryPlot.setRangeAxisLocation(1, AxisLocation.BOTTOM_OR_RIGHT);
        LineAndShapeRenderer lineAndShapeRenderer = new LineAndShapeRenderer();
        categoryPlot.setRenderer(1, (CategoryItemRenderer)lineAndShapeRenderer);
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
        String string9 = "Category 6";
        String string10 = "Category 7";
        String string11 = "Category 8";
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(1.0, (Comparable)((Object)string), (Comparable)((Object)string4));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)string), (Comparable)((Object)string5));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)string), (Comparable)((Object)string6));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)string), (Comparable)((Object)string7));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)string), (Comparable)((Object)string8));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)string), (Comparable)((Object)string9));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)string), (Comparable)((Object)string10));
        defaultCategoryDataset.addValue(8.0, (Comparable)((Object)string), (Comparable)((Object)string11));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)string2), (Comparable)((Object)string4));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)string2), (Comparable)((Object)string5));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)string2), (Comparable)((Object)string6));
        defaultCategoryDataset.addValue(8.0, (Comparable)((Object)string2), (Comparable)((Object)string7));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)string2), (Comparable)((Object)string8));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)string2), (Comparable)((Object)string9));
        defaultCategoryDataset.addValue(2.0, (Comparable)((Object)string2), (Comparable)((Object)string10));
        defaultCategoryDataset.addValue(1.0, (Comparable)((Object)string2), (Comparable)((Object)string11));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)string3), (Comparable)((Object)string4));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)string3), (Comparable)((Object)string5));
        defaultCategoryDataset.addValue(2.0, (Comparable)((Object)string3), (Comparable)((Object)string6));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)string3), (Comparable)((Object)string7));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)string3), (Comparable)((Object)string8));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)string3), (Comparable)((Object)string9));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)string3), (Comparable)((Object)string10));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)string3), (Comparable)((Object)string11));
        return defaultCategoryDataset;
    }

    private static CategoryDataset createDataset2() {
        String string = "Fourth";
        String string2 = "Category 1";
        String string3 = "Category 2";
        String string4 = "Category 3";
        String string5 = "Category 4";
        String string6 = "Category 5";
        String string7 = "Category 6";
        String string8 = "Category 7";
        String string9 = "Category 8";
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(15.0, (Comparable)((Object)string), (Comparable)((Object)string2));
        defaultCategoryDataset.addValue(24.0, (Comparable)((Object)string), (Comparable)((Object)string3));
        defaultCategoryDataset.addValue(31.0, (Comparable)((Object)string), (Comparable)((Object)string4));
        defaultCategoryDataset.addValue(25.0, (Comparable)((Object)string), (Comparable)((Object)string5));
        defaultCategoryDataset.addValue(56.0, (Comparable)((Object)string), (Comparable)((Object)string6));
        defaultCategoryDataset.addValue(37.0, (Comparable)((Object)string), (Comparable)((Object)string7));
        defaultCategoryDataset.addValue(77.0, (Comparable)((Object)string), (Comparable)((Object)string8));
        defaultCategoryDataset.addValue(18.0, (Comparable)((Object)string), (Comparable)((Object)string9));
        return defaultCategoryDataset;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = DualAxisDemo3.createChart();
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        DualAxisDemo3 dualAxisDemo3 = new DualAxisDemo3("JFreeChart: DualAxisDemo3.java");
        dualAxisDemo3.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)dualAxisDemo3));
        dualAxisDemo3.setVisible(true);
    }
}

