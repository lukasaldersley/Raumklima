/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.annotations.CategoryAnnotation
 *  org.jfree.chart.annotations.CategoryTextAnnotation
 *  org.jfree.chart.axis.CategoryAnchor
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.CategoryItemLabelGenerator
 *  org.jfree.chart.labels.ItemLabelAnchor
 *  org.jfree.chart.labels.ItemLabelPosition
 *  org.jfree.chart.labels.StandardCategoryItemLabelGenerator
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Marker
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.ValueMarker
 *  org.jfree.chart.renderer.category.BarRenderer3D
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.Layer
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
import java.text.NumberFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.CategoryAnnotation;
import org.jfree.chart.annotations.CategoryTextAnnotation;
import org.jfree.chart.axis.CategoryAnchor;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.Layer;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class BarChart3DDemo4
extends ApplicationFrame {
    public BarChart3DDemo4(String string) {
        super(string);
        CategoryDataset categoryDataset = BarChart3DDemo4.createDataset();
        JFreeChart jFreeChart = BarChart3DDemo4.createChart(categoryDataset);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)chartPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(0.77, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Robert"));
        defaultCategoryDataset.addValue(0.93, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Mary"));
        defaultCategoryDataset.addValue(0.59, (Comparable)((Object)"Series 1"), (Comparable)((Object)"John"));
        defaultCategoryDataset.addValue(0.75, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Ellen"));
        defaultCategoryDataset.addValue(0.63, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Jack"));
        defaultCategoryDataset.addValue(0.95, (Comparable)((Object)"Series 1"), (Comparable)((Object)"David"));
        defaultCategoryDataset.addValue(0.71, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Mark"));
        defaultCategoryDataset.addValue(0.65, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Andy"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createBarChart3D((String)"Student Grades", (String)"Students", (String)"Grade", (CategoryDataset)categoryDataset);
        jFreeChart.removeLegend();
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        CustomBarRenderer3D customBarRenderer3D = new CustomBarRenderer3D();
        customBarRenderer3D.setBaseItemLabelGenerator((CategoryItemLabelGenerator)new StandardCategoryItemLabelGenerator());
        customBarRenderer3D.setBaseItemLabelsVisible(true);
        customBarRenderer3D.setItemLabelAnchorOffset(10.0);
        customBarRenderer3D.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
        categoryPlot.setRenderer((CategoryItemRenderer)customBarRenderer3D);
        ValueMarker valueMarker = new ValueMarker(0.7, (Paint)new Color(200, 200, 255), (Stroke)new BasicStroke(1.0f), (Paint)new Color(200, 200, 255), (Stroke)new BasicStroke(1.0f), 1.0f);
        categoryPlot.addRangeMarker((Marker)valueMarker, Layer.BACKGROUND);
        customBarRenderer3D.setBaseItemLabelsVisible(true);
        customBarRenderer3D.setMaximumBarWidth(0.05);
        CategoryTextAnnotation categoryTextAnnotation = new CategoryTextAnnotation("Minimum grade to pass", (Comparable)((Object)"Robert"), 0.71);
        categoryTextAnnotation.setCategoryAnchor(CategoryAnchor.START);
        categoryTextAnnotation.setFont(new Font("SansSerif", 0, 12));
        categoryTextAnnotation.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categoryPlot.addAnnotation((CategoryAnnotation)categoryTextAnnotation);
        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setNumberFormatOverride(NumberFormat.getPercentInstance());
        numberAxis.setUpperMargin(0.1);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = BarChart3DDemo4.createChart(BarChart3DDemo4.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        BarChart3DDemo4 barChart3DDemo4 = new BarChart3DDemo4("JFreeChart: BarChart3DDemo4.java");
        barChart3DDemo4.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)barChart3DDemo4));
        barChart3DDemo4.setVisible(true);
    }

    static class CustomBarRenderer3D
    extends BarRenderer3D {
        public Paint getItemPaint(int n, int n2) {
            CategoryDataset categoryDataset = this.getPlot().getDataset();
            double d = categoryDataset.getValue(n, n2).doubleValue();
            if (d >= 0.7) {
                return Color.green;
            }
            return Color.red;
        }
    }

}

