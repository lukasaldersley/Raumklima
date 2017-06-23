/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.SubCategoryAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.renderer.category.BarRenderer
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
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
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.SubCategoryAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class SubCategoryAxisDemo1
extends ApplicationFrame {
    public SubCategoryAxisDemo1(String string) {
        super(string);
        JPanel jPanel = SubCategoryAxisDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
        String string = "S1";
        String string2 = "S2";
        String string3 = "S3";
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

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createBarChart((String)"SubCategoryAxis Demo 1", (String)"Category", (String)"Value", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)false, (boolean)true, (boolean)false);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setBackgroundPaint((Paint)Color.lightGray);
        SubCategoryAxis subCategoryAxis = new SubCategoryAxis(null);
        subCategoryAxis.addSubCategory((Comparable)((Object)"S1"));
        subCategoryAxis.addSubCategory((Comparable)((Object)"S2"));
        subCategoryAxis.addSubCategory((Comparable)((Object)"S3"));
        categoryPlot.setDomainAxis((CategoryAxis)subCategoryAxis);
        categoryPlot.setDomainGridlinePaint((Paint)Color.white);
        categoryPlot.setDomainGridlinesVisible(true);
        categoryPlot.setRangeGridlinePaint((Paint)Color.white);
        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer barRenderer = (BarRenderer)categoryPlot.getRenderer();
        barRenderer.setDrawBarOutline(false);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        GradientPaint gradientPaint = new GradientPaint(0.0f, 0.0f, Color.blue, 0.0f, 0.0f, new Color(0, 0, 64));
        GradientPaint gradientPaint2 = new GradientPaint(0.0f, 0.0f, Color.green, 0.0f, 0.0f, new Color(0, 64, 0));
        GradientPaint gradientPaint3 = new GradientPaint(0.0f, 0.0f, Color.red, 0.0f, 0.0f, new Color(64, 0, 0));
        barRenderer.setSeriesPaint(0, (Paint)gradientPaint);
        barRenderer.setSeriesPaint(1, (Paint)gradientPaint2);
        barRenderer.setSeriesPaint(2, (Paint)gradientPaint3);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = SubCategoryAxisDemo1.createChart(SubCategoryAxisDemo1.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        SubCategoryAxisDemo1 subCategoryAxisDemo1 = new SubCategoryAxisDemo1("JFreeChart: SubCategoryAxisDemo1.java");
        subCategoryAxisDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)subCategoryAxisDemo1));
        subCategoryAxisDemo1.setVisible(true);
    }
}

