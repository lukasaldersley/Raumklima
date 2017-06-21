/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.CategoryItemLabelGenerator
 *  org.jfree.chart.labels.ItemLabelAnchor
 *  org.jfree.chart.labels.ItemLabelPosition
 *  org.jfree.chart.labels.StandardCategoryItemLabelGenerator
 *  org.jfree.chart.plot.CategoryMarker
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.renderer.category.BarRenderer
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.general.DatasetUtilities
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.Layer
 *  org.jfree.ui.LengthAdjustmentType
 *  org.jfree.ui.RectangleAnchor
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.ui.TextAnchor
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Window;
import java.util.Arrays;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryMarker;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.Layer;
import org.jfree.ui.LengthAdjustmentType;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class BarChartDemo3
extends ApplicationFrame {
    public BarChartDemo3(String string) {
        super(string);
        JPanel jPanel = BarChartDemo3.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
        double[][] arrarrd = new double[][]{{4.0, 3.0, -2.0, 3.0, 6.0}};
        return DatasetUtilities.createCategoryDataset((String)"Series ", (String)"Category ", (double[][])arrarrd);
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createBarChart((String)"Bar Chart Demo 3", (String)"Category", (String)"Value", (CategoryDataset)categoryDataset);
        jFreeChart.removeLegend();
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setNoDataMessage("NO DATA!");
        categoryPlot.setRangePannable(true);
        Paint[] arrpaint = new Paint[]{new Color(196, 215, 216), new Color(78, 137, 139), new Color(138, 177, 178), new Color(19, 97, 100)};
        CustomRenderer customRenderer = new CustomRenderer(arrpaint);
        customRenderer.setBaseItemLabelGenerator((CategoryItemLabelGenerator)new StandardCategoryItemLabelGenerator());
        customRenderer.setBaseItemLabelsVisible(true);
        ItemLabelPosition itemLabelPosition = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER, TextAnchor.CENTER, 0.0);
        customRenderer.setBasePositiveItemLabelPosition(itemLabelPosition);
        categoryPlot.setRenderer((CategoryItemRenderer)customRenderer);
        CategoryMarker categoryMarker = new CategoryMarker((Comparable)((Object)"Category 3"));
        categoryMarker.setLabel("Special");
        categoryMarker.setPaint((Paint)new Color(221, 255, 221, 128));
        categoryMarker.setAlpha(0.5f);
        categoryMarker.setLabelAnchor(RectangleAnchor.TOP_LEFT);
        categoryMarker.setLabelTextAnchor(TextAnchor.TOP_LEFT);
        categoryMarker.setLabelOffsetType(LengthAdjustmentType.CONTRACT);
        categoryPlot.addDomainMarker(categoryMarker, Layer.BACKGROUND);
        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberAxis.setLowerMargin(0.15);
        numberAxis.setUpperMargin(0.15);
        NumberAxis numberAxis2 = new NumberAxis(null);
        numberAxis2.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberAxis2.setLowerMargin(0.15);
        numberAxis2.setUpperMargin(0.15);
        categoryPlot.setRangeAxis(1, (ValueAxis)numberAxis2);
        CategoryAxis categoryAxis = new CategoryAxis(null);
        categoryPlot.setDomainAxis(1, categoryAxis);
        List<Integer> list = Arrays.asList(new Integer(0), new Integer(1));
        categoryPlot.mapDatasetToDomainAxes(0, list);
        categoryPlot.mapDatasetToRangeAxes(0, list);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = BarChartDemo3.createChart(BarChartDemo3.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        BarChartDemo3 barChartDemo3 = new BarChartDemo3("JFreeChart: BarChartDemo3.java");
        barChartDemo3.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)barChartDemo3));
        barChartDemo3.setVisible(true);
    }

    static class CustomRenderer
    extends BarRenderer {
        private Paint[] colors;

        public CustomRenderer(Paint[] arrpaint) {
            this.colors = arrpaint;
        }

        public Paint getItemPaint(int n, int n2) {
            return this.colors[n2 % this.colors.length];
        }
    }

}

