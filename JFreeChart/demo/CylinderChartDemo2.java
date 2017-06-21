/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.labels.CategoryToolTipGenerator
 *  org.jfree.chart.labels.StandardCategoryToolTipGenerator
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.GradientPaintTransformType
 *  org.jfree.ui.GradientPaintTransformer
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.ui.StandardGradientPaintTransformer
 */
package demo;

import demo.CylinderRenderer;
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
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.StandardGradientPaintTransformer;

public class CylinderChartDemo2
extends ApplicationFrame {
    public CylinderChartDemo2(String string) {
        super(string);
        ChartPanel chartPanel = (ChartPanel)CylinderChartDemo2.createDemoPanel();
        chartPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)chartPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"S1"), (Comparable)((Object)"Monday"));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)"S1"), (Comparable)((Object)"Tuesday"));
        defaultCategoryDataset.addValue(-7.0, (Comparable)((Object)"S1"), (Comparable)((Object)"Wednesday"));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)"S1"), (Comparable)((Object)"Thursday"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"S1"), (Comparable)((Object)"Friday"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createBarChart3D((String)"Cylinder Chart Demo 2", (String)"Category", (String)"Value", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.HORIZONTAL, (boolean)false, (boolean)true, (boolean)false);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setRangePannable(true);
        Paint[] arrpaint = CylinderChartDemo2.createPaint();
        CustomCylinderRenderer customCylinderRenderer = new CustomCylinderRenderer(arrpaint);
        customCylinderRenderer.setGradientPaintTransformer((GradientPaintTransformer)new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_VERTICAL));
        customCylinderRenderer.setBaseOutlinePaint((Paint)Color.gray);
        customCylinderRenderer.setBaseOutlineStroke((Stroke)new BasicStroke(0.3f));
        customCylinderRenderer.setBaseToolTipGenerator((CategoryToolTipGenerator)new StandardCategoryToolTipGenerator());
        categoryPlot.setRenderer((CategoryItemRenderer)customCylinderRenderer);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    private static Paint[] createPaint() {
        Paint[] arrpaint = new Paint[]{new GradientPaint(0.0f, 0.0f, Color.white, 0.0f, 0.0f, Color.red), new GradientPaint(0.0f, 0.0f, Color.white, 0.0f, 0.0f, Color.green), new GradientPaint(0.0f, 0.0f, Color.white, 0.0f, 0.0f, Color.blue), new GradientPaint(0.0f, 0.0f, Color.white, 0.0f, 0.0f, Color.orange), new GradientPaint(0.0f, 0.0f, Color.white, 0.0f, 0.0f, Color.magenta)};
        return arrpaint;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = CylinderChartDemo2.createChart(CylinderChartDemo2.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        CylinderChartDemo2 cylinderChartDemo2 = new CylinderChartDemo2("JFreeChart: CylinderChartDemo2.java");
        cylinderChartDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)cylinderChartDemo2));
        cylinderChartDemo2.setVisible(true);
    }

    static class CustomCylinderRenderer
    extends CylinderRenderer {
        private Paint[] colors;

        public CustomCylinderRenderer(Paint[] arrpaint) {
            this.colors = arrpaint;
        }

        public Paint getItemPaint(int n, int n2) {
            return this.colors[n2 % this.colors.length];
        }
    }

}

