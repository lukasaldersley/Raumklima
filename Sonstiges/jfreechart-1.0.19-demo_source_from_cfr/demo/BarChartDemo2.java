/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.AxisLocation
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.CategorySeriesLabelGenerator
 *  org.jfree.chart.labels.StandardCategorySeriesLabelGenerator
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.renderer.category.BarRenderer
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.general.DatasetUtilities
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.GradientPaintTransformType
 *  org.jfree.ui.GradientPaintTransformer
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.ui.StandardGradientPaintTransformer
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
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.CategorySeriesLabelGenerator;
import org.jfree.chart.labels.StandardCategorySeriesLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.StandardGradientPaintTransformer;

public class BarChartDemo2
extends ApplicationFrame {
    public BarChartDemo2(String string) {
        super(string);
        JPanel jPanel = BarChartDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
        double[][] arrarrd = new double[][]{{1.0, 43.0, 35.0, 58.0, 54.0, 77.0, 71.0, 89.0}, {54.0, 75.0, 63.0, 83.0, 43.0, 46.0, 27.0, 13.0}, {41.0, 33.0, 22.0, 34.0, 62.0, 32.0, 42.0, 34.0}};
        return DatasetUtilities.createCategoryDataset((String)"Series ", (String)"Factor ", (double[][])arrarrd);
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createBarChart((String)"Bar Chart Demo 2", (String)"Category", (String)"Score (%)", (CategoryDataset)categoryDataset);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setOrientation(PlotOrientation.HORIZONTAL);
        categoryPlot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setRange(0.0, 100.0);
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer barRenderer = (BarRenderer)categoryPlot.getRenderer();
        GradientPaint gradientPaint = new GradientPaint(0.0f, 0.0f, new Color(0, 0, 128), 0.0f, 0.0f, Color.blue);
        GradientPaint gradientPaint2 = new GradientPaint(0.0f, 0.0f, new Color(0, 128, 0), 0.0f, 0.0f, Color.green);
        GradientPaint gradientPaint3 = new GradientPaint(0.0f, 0.0f, new Color(128, 0, 0), 0.0f, 0.0f, Color.red);
        barRenderer.setSeriesPaint(0, (Paint)gradientPaint);
        barRenderer.setSeriesPaint(1, (Paint)gradientPaint2);
        barRenderer.setSeriesPaint(2, (Paint)gradientPaint3);
        barRenderer.setGradientPaintTransformer((GradientPaintTransformer)new StandardGradientPaintTransformer(GradientPaintTransformType.HORIZONTAL));
        barRenderer.setDrawBarOutline(false);
        barRenderer.setLegendItemToolTipGenerator((CategorySeriesLabelGenerator)new StandardCategorySeriesLabelGenerator("Tooltip: {0}"));
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = BarChartDemo2.createChart(BarChartDemo2.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        BarChartDemo2 barChartDemo2 = new BarChartDemo2("JFreeChart: BarChartDemo2.java");
        barChartDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)barChartDemo2));
        barChartDemo2.setVisible(true);
    }
}

