/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.SymbolAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.renderer.category.LineAndShapeRenderer
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.util.ShapeUtilities
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.ShapeUtilities;

public class LineChartDemo8
extends ApplicationFrame {
    public LineChartDemo8(String string) {
        super(string);
        JPanel jPanel = LineChartDemo8.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(0.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue(2.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset.addValue(1.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Category 3"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Category 4"));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Category 5"));
        defaultCategoryDataset.addValue(2.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Category 3"));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Category 4"));
        defaultCategoryDataset.addValue(2.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Category 5"));
        defaultCategoryDataset.addValue(1.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Category 3"));
        defaultCategoryDataset.addValue(2.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Category 4"));
        defaultCategoryDataset.addValue(0.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Category 5"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createLineChart((String)"Line Chart Demo 8", (String)"Category", (String)"Count", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        SymbolAxis symbolAxis = new SymbolAxis("Group", new String[]{"A", "B", "C", "D", "E", "F"});
        categoryPlot.setRangeAxis((ValueAxis)symbolAxis);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        LineAndShapeRenderer lineAndShapeRenderer = (LineAndShapeRenderer)categoryPlot.getRenderer();
        lineAndShapeRenderer.setSeriesShapesVisible(0, true);
        lineAndShapeRenderer.setSeriesShapesVisible(1, false);
        lineAndShapeRenderer.setSeriesShapesVisible(2, true);
        lineAndShapeRenderer.setSeriesLinesVisible(2, false);
        lineAndShapeRenderer.setSeriesShape(2, ShapeUtilities.createDiamond((float)4.0f));
        lineAndShapeRenderer.setDrawOutlines(true);
        lineAndShapeRenderer.setUseFillPaint(true);
        lineAndShapeRenderer.setBaseFillPaint((Paint)Color.white);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = LineChartDemo8.createChart(LineChartDemo8.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        LineChartDemo8 lineChartDemo8 = new LineChartDemo8("JFreeChart: LineChartDemo8.java");
        lineChartDemo8.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)lineChartDemo8));
        lineChartDemo8.setVisible(true);
    }
}

