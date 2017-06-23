/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.AbstractCategoryItemLabelGenerator
 *  org.jfree.chart.labels.CategoryItemLabelGenerator
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.text.NumberFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.AbstractCategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class ItemLabelDemo1
extends ApplicationFrame {
    public ItemLabelDemo1(String string) {
        super(string);
        JPanel jPanel = ItemLabelDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(11.0, (Comparable)((Object)"S1"), (Comparable)((Object)"C1"));
        defaultCategoryDataset.addValue(44.3, (Comparable)((Object)"S1"), (Comparable)((Object)"C2"));
        defaultCategoryDataset.addValue(93.0, (Comparable)((Object)"S1"), (Comparable)((Object)"C3"));
        defaultCategoryDataset.addValue(35.6, (Comparable)((Object)"S1"), (Comparable)((Object)"C4"));
        defaultCategoryDataset.addValue(75.1, (Comparable)((Object)"S1"), (Comparable)((Object)"C5"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createBarChart((String)"Item Label Demo 1", (String)"Category", (String)"Value", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)false, (boolean)true, (boolean)false);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setRangePannable(true);
        categoryPlot.setRangeZeroBaselineVisible(true);
        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setUpperMargin(0.15);
        CategoryItemRenderer categoryItemRenderer = categoryPlot.getRenderer();
        categoryItemRenderer.setBaseItemLabelGenerator((CategoryItemLabelGenerator)new LabelGenerator(50.0));
        categoryItemRenderer.setBaseItemLabelFont(new Font("Serif", 0, 20));
        categoryItemRenderer.setBaseItemLabelsVisible(true);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = ItemLabelDemo1.createChart(ItemLabelDemo1.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        ItemLabelDemo1 itemLabelDemo1 = new ItemLabelDemo1("JFreeChart: ItemLabelDemo1.java");
        itemLabelDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)itemLabelDemo1));
        itemLabelDemo1.setVisible(true);
    }

    static class LabelGenerator
    extends AbstractCategoryItemLabelGenerator
    implements CategoryItemLabelGenerator {
        private double threshold;

        public LabelGenerator(double d) {
            super("", NumberFormat.getInstance());
            this.threshold = d;
        }

        public String generateLabel(CategoryDataset categoryDataset, int n, int n2) {
            double d;
            String string = null;
            Number number = categoryDataset.getValue(n, n2);
            if (number != null && (d = number.doubleValue()) > this.threshold) {
                string = number.toString();
            }
            return string;
        }
    }

}

