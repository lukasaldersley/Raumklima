/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.CategoryItemLabelGenerator
 *  org.jfree.chart.labels.ItemLabelAnchor
 *  org.jfree.chart.labels.ItemLabelPosition
 *  org.jfree.chart.labels.StandardCategoryItemLabelGenerator
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.DefaultDrawingSupplier
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.renderer.category.StackedBarRenderer
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.ui.TextAnchor
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Window;
import java.text.NumberFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class ItemLabelDemo5
extends ApplicationFrame {
    public ItemLabelDemo5(String string) {
        super(string);
        JPanel jPanel = ItemLabelDemo5.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    public static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(52.83, (Comparable)((Object)"Germany"), (Comparable)((Object)"Western EU"));
        defaultCategoryDataset.addValue(20.83, (Comparable)((Object)"France"), (Comparable)((Object)"Western EU"));
        defaultCategoryDataset.addValue(10.83, (Comparable)((Object)"Great Britain"), (Comparable)((Object)"Western EU"));
        defaultCategoryDataset.addValue(7.33, (Comparable)((Object)"Netherlands"), (Comparable)((Object)"Western EU"));
        defaultCategoryDataset.addValue(4.66, (Comparable)((Object)"Belgium"), (Comparable)((Object)"Western EU"));
        defaultCategoryDataset.addValue(57.14, (Comparable)((Object)"Spain"), (Comparable)((Object)"Southern EU"));
        defaultCategoryDataset.addValue(14.28, (Comparable)((Object)"Greece"), (Comparable)((Object)"Southern EU"));
        defaultCategoryDataset.addValue(14.28, (Comparable)((Object)"Italy"), (Comparable)((Object)"Southern EU"));
        defaultCategoryDataset.addValue(14.28, (Comparable)((Object)"Portugal"), (Comparable)((Object)"Southern EU"));
        defaultCategoryDataset.addValue(100.0, (Comparable)((Object)"Czech Republic"), (Comparable)((Object)"Eastern EU"));
        defaultCategoryDataset.addValue(66.66, (Comparable)((Object)"Denmark"), (Comparable)((Object)"Scandinavia"));
        defaultCategoryDataset.addValue(33.33, (Comparable)((Object)"Finland"), (Comparable)((Object)"Scandinavia"));
        defaultCategoryDataset.addValue(0.0, (Comparable)((Object)""), (Comparable)((Object)"Africa"));
        defaultCategoryDataset.addValue(100.0, (Comparable)((Object)"Israel"), (Comparable)((Object)"Asia"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createStackedBarChart((String)"Item Label Demo 5", (String)null, (String)null, (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)false, (boolean)true, (boolean)false);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        MyStackedBarRenderer myStackedBarRenderer = new MyStackedBarRenderer();
        categoryPlot.setRenderer((CategoryItemRenderer)myStackedBarRenderer);
        ItemLabelPosition itemLabelPosition = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER, TextAnchor.CENTER, 0.0);
        myStackedBarRenderer.setPositiveItemLabelPositionFallback(itemLabelPosition);
        myStackedBarRenderer.setNegativeItemLabelPositionFallback(itemLabelPosition);
        StandardCategoryItemLabelGenerator standardCategoryItemLabelGenerator = new StandardCategoryItemLabelGenerator("{0}", NumberFormat.getInstance());
        myStackedBarRenderer.setBaseItemLabelGenerator((CategoryItemLabelGenerator)standardCategoryItemLabelGenerator);
        myStackedBarRenderer.setBaseItemLabelsVisible(true);
        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setUpperBound(100.0);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = ItemLabelDemo5.createChart(ItemLabelDemo5.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        ItemLabelDemo5 itemLabelDemo5 = new ItemLabelDemo5("JFreeChart: ItemLabelDemo5.java");
        itemLabelDemo5.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)itemLabelDemo5));
        itemLabelDemo5.setVisible(true);
    }

    private static class MyStackedBarRenderer
    extends StackedBarRenderer {
        int oldColumn = -99;
        int count = 0;
        Paint[] list = DefaultDrawingSupplier.DEFAULT_PAINT_SEQUENCE;

        private MyStackedBarRenderer() {
        }

        public Paint getItemPaint(int n, int n2) {
            if (this.oldColumn != n2) {
                this.count = 0;
                this.oldColumn = n2;
            } else {
                ++this.count;
            }
            return this.list[this.count];
        }
    }

}

