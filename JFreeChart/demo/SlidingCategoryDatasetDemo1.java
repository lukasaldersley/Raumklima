/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.renderer.category.BarRenderer
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.data.category.SlidingCategoryDataset
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
import javax.swing.BorderFactory;
import javax.swing.BoundedRangeModel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.category.SlidingCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class SlidingCategoryDatasetDemo1
extends ApplicationFrame {
    public SlidingCategoryDatasetDemo1(String string) {
        super(string);
        this.setDefaultCloseOperation(3);
        this.setContentPane((Container)SlidingCategoryDatasetDemo1.createDemoPanel());
    }

    public static JPanel createDemoPanel() {
        return new MyDemoPanel();
    }

    public static void main(String[] arrstring) {
        SlidingCategoryDatasetDemo1 slidingCategoryDatasetDemo1 = new SlidingCategoryDatasetDemo1("JFreeChart: SlidingCategoryDatasetDemo1.java");
        slidingCategoryDatasetDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)slidingCategoryDatasetDemo1));
        slidingCategoryDatasetDemo1.setVisible(true);
    }

    static class MyDemoPanel
    extends DemoPanel
    implements ChangeListener {
        JScrollBar scroller;
        SlidingCategoryDataset dataset = new SlidingCategoryDataset(MyDemoPanel.createDataset(), 0, 20);

        public MyDemoPanel() {
            super(new BorderLayout());
            JFreeChart jFreeChart = MyDemoPanel.createChart((CategoryDataset)this.dataset);
            this.addChart(jFreeChart);
            ChartPanel chartPanel = new ChartPanel(jFreeChart);
            chartPanel.setPreferredSize(new Dimension(400, 400));
            this.scroller = new JScrollBar(1, 0, 20, 0, 50);
            this.add((Component)chartPanel);
            this.scroller.getModel().addChangeListener(this);
            JPanel jPanel = new JPanel(new BorderLayout());
            jPanel.add(this.scroller);
            jPanel.setBorder(BorderFactory.createEmptyBorder(66, 2, 2, 2));
            jPanel.setBackground(Color.white);
            this.add((Component)jPanel, "East");
        }

        private static CategoryDataset createDataset() {
            DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
            for (int i = 0; i < 50; ++i) {
                defaultCategoryDataset.addValue(Math.random() * 100.0, (Comparable)((Object)"S1"), (Comparable)((Object)("Series " + i)));
            }
            return defaultCategoryDataset;
        }

        private static JFreeChart createChart(CategoryDataset categoryDataset) {
            JFreeChart jFreeChart = ChartFactory.createBarChart((String)"SlidingCategoryDatasetDemo1", (String)"Series", (String)"Value", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.HORIZONTAL, (boolean)false, (boolean)true, (boolean)false);
            CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
            CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
            categoryAxis.setMaximumCategoryLabelWidthRatio(0.8f);
            categoryAxis.setLowerMargin(0.02);
            categoryAxis.setUpperMargin(0.02);
            NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
            numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
            numberAxis.setRange(0.0, 100.0);
            BarRenderer barRenderer = (BarRenderer)categoryPlot.getRenderer();
            barRenderer.setDrawBarOutline(false);
            GradientPaint gradientPaint = new GradientPaint(0.0f, 0.0f, Color.blue, 0.0f, 0.0f, new Color(0, 0, 64));
            barRenderer.setSeriesPaint(0, (Paint)gradientPaint);
            return jFreeChart;
        }

        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            this.dataset.setFirstCategoryIndex(this.scroller.getValue());
        }
    }

}

