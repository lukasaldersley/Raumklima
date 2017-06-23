/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.CategoryMarker
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.renderer.category.LineAndShapeRenderer
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.Layer
 *  org.jfree.ui.RectangleInsets
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.ui.TextAnchor
 */
package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryMarker;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.Layer;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class CategoryMarkerDemo1
extends ApplicationFrame {
    public CategoryMarkerDemo1(String string) {
        super(string);
        JPanel jPanel = CategoryMarkerDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(21.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue(50.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset.addValue(152.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Category 3"));
        defaultCategoryDataset.addValue(184.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Category 4"));
        defaultCategoryDataset.addValue(299.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Category 5"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createLineChart((String)"Category Marker Demo 1", (String)"Category", (String)"Count", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        LineAndShapeRenderer lineAndShapeRenderer = (LineAndShapeRenderer)categoryPlot.getRenderer();
        lineAndShapeRenderer.setSeriesShapesVisible(0, true);
        lineAndShapeRenderer.setDrawOutlines(true);
        lineAndShapeRenderer.setUseFillPaint(true);
        lineAndShapeRenderer.setBaseFillPaint((Paint)Color.white);
        CategoryMarker categoryMarker = new CategoryMarker((Comparable)((Object)"Category 4"), (Paint)Color.blue, (Stroke)new BasicStroke(1.0f));
        categoryMarker.setDrawAsLine(true);
        categoryMarker.setLabel("Marker Label");
        categoryMarker.setLabelFont(new Font("Dialog", 0, 11));
        categoryMarker.setLabelTextAnchor(TextAnchor.TOP_RIGHT);
        categoryMarker.setLabelOffset(new RectangleInsets(2.0, 5.0, 2.0, 5.0));
        categoryPlot.addDomainMarker(categoryMarker, Layer.BACKGROUND);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = CategoryMarkerDemo1.createChart(CategoryMarkerDemo1.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        CategoryMarkerDemo1 categoryMarkerDemo1 = new CategoryMarkerDemo1("JFreeChart: CategoryMarkerDemo1.java");
        categoryMarkerDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)categoryMarkerDemo1));
        categoryMarkerDemo1.setVisible(true);
    }
}

