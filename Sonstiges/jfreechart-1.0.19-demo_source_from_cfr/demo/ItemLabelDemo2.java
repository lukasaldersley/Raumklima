/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.AxisLocation
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.AbstractCategoryItemLabelGenerator
 *  org.jfree.chart.labels.CategoryItemLabelGenerator
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

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import java.text.NumberFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.AbstractCategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class ItemLabelDemo2
extends ApplicationFrame {
    public ItemLabelDemo2(String string) {
        super(string);
        JPanel jPanel = ItemLabelDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(100.0, (Comparable)((Object)"S1"), (Comparable)((Object)"C1"));
        defaultCategoryDataset.addValue(44.3, (Comparable)((Object)"S1"), (Comparable)((Object)"C2"));
        defaultCategoryDataset.addValue(93.0, (Comparable)((Object)"S1"), (Comparable)((Object)"C3"));
        defaultCategoryDataset.addValue(80.0, (Comparable)((Object)"S2"), (Comparable)((Object)"C1"));
        defaultCategoryDataset.addValue(75.1, (Comparable)((Object)"S2"), (Comparable)((Object)"C2"));
        defaultCategoryDataset.addValue(15.1, (Comparable)((Object)"S2"), (Comparable)((Object)"C3"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createBarChart((String)"Item Label Demo 2", (String)"Category", (String)"Value", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.HORIZONTAL, (boolean)true, (boolean)true, (boolean)false);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
        categoryPlot.setRangePannable(true);
        categoryPlot.setRangeZeroBaselineVisible(true);
        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setUpperMargin(0.25);
        BarRenderer barRenderer = (BarRenderer)categoryPlot.getRenderer();
        barRenderer.setBaseItemLabelsVisible(true);
        barRenderer.setItemLabelAnchorOffset(7.0);
        barRenderer.setBaseItemLabelGenerator((CategoryItemLabelGenerator)new LabelGenerator(null));
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = ItemLabelDemo2.createChart(ItemLabelDemo2.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        ItemLabelDemo2 itemLabelDemo2 = new ItemLabelDemo2("JFreeChart: ItemLabelDemo2.java");
        itemLabelDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)itemLabelDemo2));
        itemLabelDemo2.setVisible(true);
    }

    static class LabelGenerator
    extends AbstractCategoryItemLabelGenerator
    implements CategoryItemLabelGenerator {
        private Integer category;
        private NumberFormat formatter = NumberFormat.getPercentInstance();

        public LabelGenerator(int n) {
            this(new Integer(n));
        }

        public LabelGenerator(Integer n) {
            super("", NumberFormat.getInstance());
            this.category = n;
        }

        public String generateLabel(CategoryDataset categoryDataset, int n, int n2) {
            Number number;
            String string = null;
            double d = 0.0;
            if (this.category != null) {
                number = categoryDataset.getValue(n, this.category.intValue());
                d = number.doubleValue();
            } else {
                d = this.calculateSeriesTotal(categoryDataset, n);
            }
            number = categoryDataset.getValue(n, n2);
            if (number != null) {
                double d2 = number.doubleValue();
                string = number.toString() + " (" + this.formatter.format(d2 / d) + ")";
            }
            return string;
        }

        private double calculateSeriesTotal(CategoryDataset categoryDataset, int n) {
            double d = 0.0;
            for (int i = 0; i < categoryDataset.getColumnCount(); ++i) {
                Number number = categoryDataset.getValue(n, i);
                if (number == null) continue;
                d += number.doubleValue();
            }
            return d;
        }
    }

}

