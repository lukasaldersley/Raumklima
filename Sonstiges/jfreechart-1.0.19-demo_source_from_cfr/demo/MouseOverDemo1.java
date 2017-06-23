/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartMouseEvent
 *  org.jfree.chart.ChartMouseListener
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.entity.CategoryItemEntity
 *  org.jfree.chart.entity.ChartEntity
 *  org.jfree.chart.event.RendererChangeEvent
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

import demo.DemoPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.LayoutManager;
import java.awt.Paint;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class MouseOverDemo1
extends ApplicationFrame {
    public MouseOverDemo1(String string) {
        super(string);
        JPanel jPanel = MouseOverDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
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

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createBarChart((String)"Mouseover Demo 1", (String)"Category", (String)"Value", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setDomainGridlinesVisible(true);
        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        MyBarRenderer myBarRenderer = new MyBarRenderer();
        myBarRenderer.setDrawBarOutline(true);
        categoryPlot.setRenderer((CategoryItemRenderer)myBarRenderer);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        GradientPaint gradientPaint = new GradientPaint(0.0f, 0.0f, Color.blue, 0.0f, 0.0f, new Color(0, 0, 64));
        GradientPaint gradientPaint2 = new GradientPaint(0.0f, 0.0f, Color.green, 0.0f, 0.0f, new Color(0, 64, 0));
        GradientPaint gradientPaint3 = new GradientPaint(0.0f, 0.0f, Color.red, 0.0f, 0.0f, new Color(64, 0, 0));
        myBarRenderer.setSeriesPaint(0, (Paint)gradientPaint);
        myBarRenderer.setSeriesPaint(1, (Paint)gradientPaint2);
        myBarRenderer.setSeriesPaint(2, (Paint)gradientPaint3);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = MouseOverDemo1.createChart(MouseOverDemo1.createDataset());
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        MyBarRenderer myBarRenderer = (MyBarRenderer)categoryPlot.getRenderer();
        MyDemoPanel myDemoPanel = new MyDemoPanel(myBarRenderer);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        myDemoPanel.addChart(jFreeChart);
        chartPanel.addChartMouseListener((ChartMouseListener)myDemoPanel);
        myDemoPanel.add((Component)chartPanel);
        return myDemoPanel;
    }

    public static void main(String[] arrstring) {
        MouseOverDemo1 mouseOverDemo1 = new MouseOverDemo1("JFreeChart: MouseoverDemo1.java");
        mouseOverDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)mouseOverDemo1));
        mouseOverDemo1.setVisible(true);
    }

    static class MyDemoPanel
    extends DemoPanel
    implements ChartMouseListener {
        private MyBarRenderer renderer;

        public MyDemoPanel(MyBarRenderer myBarRenderer) {
            super(new BorderLayout());
            this.renderer = myBarRenderer;
        }

        public void chartMouseMoved(ChartMouseEvent chartMouseEvent) {
            ChartEntity chartEntity = chartMouseEvent.getEntity();
            if (!(chartEntity instanceof CategoryItemEntity)) {
                this.renderer.setHighlightedItem(-1, -1);
                return;
            }
            CategoryItemEntity categoryItemEntity = (CategoryItemEntity)chartEntity;
            CategoryDataset categoryDataset = categoryItemEntity.getDataset();
            this.renderer.setHighlightedItem(categoryDataset.getRowIndex(categoryItemEntity.getRowKey()), categoryDataset.getColumnIndex(categoryItemEntity.getColumnKey()));
        }

        public void chartMouseClicked(ChartMouseEvent chartMouseEvent) {
        }
    }

    static class MyBarRenderer
    extends BarRenderer {
        private int highlightRow = -1;
        private int highlightColumn = -1;

        MyBarRenderer() {
        }

        public void setHighlightedItem(int n, int n2) {
            if (this.highlightRow == n && this.highlightColumn == n2) {
                return;
            }
            this.highlightRow = n;
            this.highlightColumn = n2;
            this.notifyListeners(new RendererChangeEvent((Object)this));
        }

        public Paint getItemOutlinePaint(int n, int n2) {
            if (n == this.highlightRow && n2 == this.highlightColumn) {
                return Color.yellow;
            }
            return super.getItemOutlinePaint(n, n2);
        }
    }

}

