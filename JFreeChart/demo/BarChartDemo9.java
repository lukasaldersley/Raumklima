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
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.renderer.category.BarPainter
 *  org.jfree.chart.renderer.category.BarRenderer
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.renderer.category.StandardBarPainter
 *  org.jfree.chart.title.TextTitle
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.GradientPaintTransformType
 *  org.jfree.ui.GradientPaintTransformer
 *  org.jfree.ui.RectangleInsets
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.ui.StandardGradientPaintTransformer
 */
package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GradientPaint;
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
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarPainter;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.StandardGradientPaintTransformer;

public class BarChartDemo9
extends ApplicationFrame {
    public BarChartDemo9(String string) {
        super(string);
        JPanel jPanel = BarChartDemo9.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(410.0, (Comparable)((Object)"Network Traffic"), (Comparable)((Object)"Monday"));
        defaultCategoryDataset.addValue(680.0, (Comparable)((Object)"Network Traffic"), (Comparable)((Object)"Tuesday"));
        defaultCategoryDataset.addValue(530.0, (Comparable)((Object)"Network Traffic"), (Comparable)((Object)"Wednesday"));
        defaultCategoryDataset.addValue(570.0, (Comparable)((Object)"Network Traffic"), (Comparable)((Object)"Thursday"));
        defaultCategoryDataset.addValue(330.0, (Comparable)((Object)"Network Traffic"), (Comparable)((Object)"Friday"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createBarChart((String)"Bar Chart Demo 9", (String)null, (String)"Value", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)false, (boolean)true, (boolean)false);
        TextTitle textTitle = jFreeChart.getTitle();
        textTitle.setBorder(0.0, 0.0, 1.0, 0.0);
        textTitle.setBackgroundPaint((Paint)new GradientPaint(0.0f, 0.0f, Color.red, 350.0f, 0.0f, Color.white, true));
        textTitle.setExpandToFitSpace(true);
        jFreeChart.setBackgroundPaint((Paint)new GradientPaint(0.0f, 0.0f, Color.yellow, 350.0f, 0.0f, Color.white, true));
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setNoDataMessage("NO DATA!");
        categoryPlot.setBackgroundPaint(null);
        categoryPlot.setInsets(new RectangleInsets(10.0, 5.0, 5.0, 5.0));
        categoryPlot.setOutlinePaint((Paint)Color.black);
        categoryPlot.setRangeGridlinePaint((Paint)Color.gray);
        categoryPlot.setRangeGridlineStroke((Stroke)new BasicStroke(1.0f));
        Paint[] arrpaint = BarChartDemo9.createPaint();
        CustomBarRenderer customBarRenderer = new CustomBarRenderer(arrpaint);
        customBarRenderer.setBarPainter((BarPainter)new StandardBarPainter());
        customBarRenderer.setDrawBarOutline(true);
        customBarRenderer.setGradientPaintTransformer((GradientPaintTransformer)new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_HORIZONTAL));
        categoryPlot.setRenderer((CategoryItemRenderer)customBarRenderer);
        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberAxis.setRange(0.0, 800.0);
        numberAxis.setTickMarkPaint((Paint)Color.black);
        return jFreeChart;
    }

    private static Paint[] createPaint() {
        Paint[] arrpaint = new Paint[]{new GradientPaint(0.0f, 0.0f, Color.red, 0.0f, 0.0f, Color.white), new GradientPaint(0.0f, 0.0f, Color.green, 0.0f, 0.0f, Color.white), new GradientPaint(0.0f, 0.0f, Color.blue, 0.0f, 0.0f, Color.white), new GradientPaint(0.0f, 0.0f, Color.orange, 0.0f, 0.0f, Color.white), new GradientPaint(0.0f, 0.0f, Color.magenta, 0.0f, 0.0f, Color.white)};
        return arrpaint;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = BarChartDemo9.createChart(BarChartDemo9.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        BarChartDemo9 barChartDemo9 = new BarChartDemo9("JFreeChart: BarChartDemo9.java");
        barChartDemo9.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)barChartDemo9));
        barChartDemo9.setVisible(true);
    }

    static class CustomBarRenderer
    extends BarRenderer {
        private Paint[] colors;

        public CustomBarRenderer(Paint[] arrpaint) {
            this.colors = arrpaint;
        }

        public Paint getItemPaint(int n, int n2) {
            return this.colors[n2 % this.colors.length];
        }
    }

}

