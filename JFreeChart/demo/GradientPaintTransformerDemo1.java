/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.renderer.category.BarPainter
 *  org.jfree.chart.renderer.category.BarRenderer
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.renderer.category.StandardBarPainter
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.GradientPaintTransformType
 *  org.jfree.ui.GradientPaintTransformer
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.ui.StandardGradientPaintTransformer
 */
package demo;

import demo.DemoPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Paint;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarPainter;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.StandardGradientPaintTransformer;

public class GradientPaintTransformerDemo1
extends ApplicationFrame {
    public GradientPaintTransformerDemo1(String string) {
        super(string);
        this.setContentPane((Container)GradientPaintTransformerDemo1.createDemoPanel());
    }

    private static JFreeChart createChart(String string, CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createBarChart((String)string, (String)null, (String)"Value", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        BarRenderer barRenderer = (BarRenderer)categoryPlot.getRenderer();
        barRenderer.setItemMargin(0.02);
        return jFreeChart;
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Category 1"));
        return defaultCategoryDataset;
    }

    public static JPanel createDemoPanel() {
        DemoPanel demoPanel = new DemoPanel(new GridLayout(2, 2));
        demoPanel.setPreferredSize(new Dimension(800, 600));
        CategoryDataset categoryDataset = GradientPaintTransformerDemo1.createDataset();
        JFreeChart jFreeChart = GradientPaintTransformerDemo1.createChart("Type: VERTICAL", categoryDataset);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        BarRenderer barRenderer = (BarRenderer)categoryPlot.getRenderer();
        barRenderer.setBarPainter((BarPainter)new StandardBarPainter());
        barRenderer.setDrawBarOutline(false);
        barRenderer.setSeriesPaint(0, (Paint)new GradientPaint(0.0f, 0.0f, Color.red, 0.0f, 0.0f, Color.yellow));
        barRenderer.setSeriesPaint(1, (Paint)new GradientPaint(0.0f, 0.0f, Color.blue, 0.0f, 0.0f, Color.green));
        barRenderer.setGradientPaintTransformer((GradientPaintTransformer)new StandardGradientPaintTransformer(GradientPaintTransformType.VERTICAL));
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        demoPanel.add((Component)chartPanel);
        JFreeChart jFreeChart2 = GradientPaintTransformerDemo1.createChart("Type: HORIZONTAL", categoryDataset);
        CategoryPlot categoryPlot2 = (CategoryPlot)jFreeChart2.getPlot();
        BarRenderer barRenderer2 = (BarRenderer)categoryPlot2.getRenderer();
        barRenderer2.setBarPainter((BarPainter)new StandardBarPainter());
        barRenderer2.setDrawBarOutline(false);
        barRenderer2.setSeriesPaint(0, (Paint)new GradientPaint(0.0f, 0.0f, Color.red, 0.0f, 0.0f, Color.yellow));
        barRenderer2.setSeriesPaint(1, (Paint)new GradientPaint(0.0f, 0.0f, Color.blue, 0.0f, 0.0f, Color.green));
        barRenderer2.setGradientPaintTransformer((GradientPaintTransformer)new StandardGradientPaintTransformer(GradientPaintTransformType.HORIZONTAL));
        ChartPanel chartPanel2 = new ChartPanel(jFreeChart2);
        demoPanel.add((Component)chartPanel2);
        JFreeChart jFreeChart3 = GradientPaintTransformerDemo1.createChart("Type: CENTER_VERTICAL", categoryDataset);
        CategoryPlot categoryPlot3 = (CategoryPlot)jFreeChart3.getPlot();
        BarRenderer barRenderer3 = (BarRenderer)categoryPlot3.getRenderer();
        barRenderer3.setBarPainter((BarPainter)new StandardBarPainter());
        barRenderer3.setDrawBarOutline(false);
        barRenderer3.setSeriesPaint(0, (Paint)new GradientPaint(0.0f, 0.0f, Color.red, 0.0f, 0.0f, Color.yellow));
        barRenderer3.setSeriesPaint(1, (Paint)new GradientPaint(0.0f, 0.0f, Color.blue, 0.0f, 0.0f, Color.green));
        barRenderer3.setGradientPaintTransformer((GradientPaintTransformer)new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_VERTICAL));
        ChartPanel chartPanel3 = new ChartPanel(jFreeChart3);
        demoPanel.add((Component)chartPanel3);
        JFreeChart jFreeChart4 = GradientPaintTransformerDemo1.createChart("Type: CENTER_HORIZONTAL", categoryDataset);
        CategoryPlot categoryPlot4 = (CategoryPlot)jFreeChart4.getPlot();
        BarRenderer barRenderer4 = (BarRenderer)categoryPlot4.getRenderer();
        barRenderer4.setBarPainter((BarPainter)new StandardBarPainter());
        barRenderer4.setDrawBarOutline(false);
        barRenderer4.setSeriesPaint(0, (Paint)new GradientPaint(0.0f, 0.0f, Color.red, 0.0f, 0.0f, Color.yellow));
        barRenderer4.setSeriesPaint(1, (Paint)new GradientPaint(0.0f, 0.0f, Color.blue, 0.0f, 0.0f, Color.green));
        barRenderer4.setGradientPaintTransformer((GradientPaintTransformer)new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_HORIZONTAL));
        ChartPanel chartPanel4 = new ChartPanel(jFreeChart4);
        demoPanel.add((Component)chartPanel4);
        demoPanel.addChart(jFreeChart);
        demoPanel.addChart(jFreeChart2);
        demoPanel.addChart(jFreeChart3);
        demoPanel.addChart(jFreeChart4);
        return demoPanel;
    }

    public static void main(String[] arrstring) {
        GradientPaintTransformerDemo1 gradientPaintTransformerDemo1 = new GradientPaintTransformerDemo1("JFreeChart: GradientPaintTransformerDemo1.java");
        gradientPaintTransformerDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)gradientPaintTransformerDemo1));
        gradientPaintTransformerDemo1.setVisible(true);
    }
}

