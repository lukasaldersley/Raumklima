/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.LegendItem
 *  org.jfree.chart.LegendItemCollection
 *  org.jfree.chart.LegendItemSource
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.renderer.category.BarRenderer
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.title.LegendTitle
 *  org.jfree.chart.title.TextTitle
 *  org.jfree.chart.title.Title
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.HorizontalAlignment
 *  org.jfree.ui.RectangleEdge
 *  org.jfree.ui.RectangleInsets
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Window;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.LegendItemSource;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class StackedBarChartDemo2
extends ApplicationFrame {
    public StackedBarChartDemo2(String string) {
        super(string);
        JPanel jPanel = StackedBarChartDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(81.0, (Comparable)((Object)"Against all torture"), (Comparable)((Object)"Italy"));
        defaultCategoryDataset.addValue(72.0, (Comparable)((Object)"Against all torture"), (Comparable)((Object)"Great Britain"));
        defaultCategoryDataset.addValue(58.0, (Comparable)((Object)"Against all torture"), (Comparable)((Object)"USA"));
        defaultCategoryDataset.addValue(48.0, (Comparable)((Object)"Against all torture"), (Comparable)((Object)"Israel"));
        defaultCategoryDataset.addValue(43.0, (Comparable)((Object)"Against all torture"), (Comparable)((Object)"Russia"));
        defaultCategoryDataset.addValue(23.0, (Comparable)((Object)"Against all torture"), (Comparable)((Object)"India"));
        defaultCategoryDataset.addValue(59.0, (Comparable)((Object)"Against all torture"), (Comparable)((Object)"Average (*)"));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)"-"), (Comparable)((Object)"Italy"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"-"), (Comparable)((Object)"Great Britain"));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)"-"), (Comparable)((Object)"USA"));
        defaultCategoryDataset.addValue(9.0, (Comparable)((Object)"-"), (Comparable)((Object)"Israel"));
        defaultCategoryDataset.addValue(20.0, (Comparable)((Object)"-"), (Comparable)((Object)"Russia"));
        defaultCategoryDataset.addValue(45.0, (Comparable)((Object)"-"), (Comparable)((Object)"India"));
        defaultCategoryDataset.addValue(12.0, (Comparable)((Object)"-"), (Comparable)((Object)"Average (*)"));
        defaultCategoryDataset.addValue(14.0, (Comparable)((Object)"Some degree permissible"), (Comparable)((Object)"Italy"));
        defaultCategoryDataset.addValue(24.0, (Comparable)((Object)"Some degree permissible"), (Comparable)((Object)"Great Britain"));
        defaultCategoryDataset.addValue(36.0, (Comparable)((Object)"Some degree permissible"), (Comparable)((Object)"USA"));
        defaultCategoryDataset.addValue(43.0, (Comparable)((Object)"Some degree permissible"), (Comparable)((Object)"Israel"));
        defaultCategoryDataset.addValue(37.0, (Comparable)((Object)"Some degree permissible"), (Comparable)((Object)"Russia"));
        defaultCategoryDataset.addValue(32.0, (Comparable)((Object)"Some degree permissible"), (Comparable)((Object)"India"));
        defaultCategoryDataset.addValue(29.0, (Comparable)((Object)"Some degree permissible"), (Comparable)((Object)"Average (*)"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createStackedBarChart((String)"Public Opinion : Torture of Prisoners", (String)"Country", (String)"%", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.HORIZONTAL, (boolean)false, (boolean)true, (boolean)false);
        jFreeChart.getTitle().setMargin(2.0, 0.0, 0.0, 0.0);
        TextTitle textTitle = new TextTitle("Source: http://news.bbc.co.uk/1/hi/world/6063386.stm", new Font("Dialog", 0, 11));
        textTitle.setPosition(RectangleEdge.BOTTOM);
        textTitle.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        textTitle.setMargin(0.0, 0.0, 4.0, 4.0);
        jFreeChart.addSubtitle((Title)textTitle);
        TextTitle textTitle2 = new TextTitle("(*) Across 27,000 respondents in 25 countries", new Font("Dialog", 0, 11));
        textTitle2.setPosition(RectangleEdge.BOTTOM);
        textTitle2.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        textTitle2.setMargin(4.0, 0.0, 2.0, 4.0);
        jFreeChart.addSubtitle((Title)textTitle2);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        LegendItemCollection legendItemCollection = new LegendItemCollection();
        legendItemCollection.add(new LegendItem("Against all torture", null, null, null, (Shape)new Rectangle2D.Double(-6.0, -3.0, 12.0, 6.0), (Paint)Color.green));
        legendItemCollection.add(new LegendItem("Some degree permissible", null, null, null, (Shape)new Rectangle2D.Double(-6.0, -3.0, 12.0, 6.0), (Paint)Color.red));
        categoryPlot.setFixedLegendItems(legendItemCollection);
        categoryPlot.setInsets(new RectangleInsets(5.0, 5.0, 5.0, 20.0));
        LegendTitle legendTitle = new LegendTitle((LegendItemSource)categoryPlot);
        legendTitle.setPosition(RectangleEdge.BOTTOM);
        jFreeChart.addSubtitle((Title)legendTitle);
        categoryPlot.setDomainGridlinesVisible(true);
        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberAxis.setUpperMargin(0.0);
        BarRenderer barRenderer = (BarRenderer)categoryPlot.getRenderer();
        barRenderer.setDrawBarOutline(false);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        GradientPaint gradientPaint = new GradientPaint(0.0f, 0.0f, Color.green, 0.0f, 0.0f, new Color(0, 64, 0));
        Color color = new Color(0, 0, 0, 0);
        GradientPaint gradientPaint2 = new GradientPaint(0.0f, 0.0f, Color.red, 0.0f, 0.0f, new Color(64, 0, 0));
        barRenderer.setSeriesPaint(0, (Paint)gradientPaint);
        barRenderer.setSeriesPaint(1, (Paint)color);
        barRenderer.setSeriesPaint(2, (Paint)gradientPaint2);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = StackedBarChartDemo2.createChart(StackedBarChartDemo2.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        StackedBarChartDemo2 stackedBarChartDemo2 = new StackedBarChartDemo2("JFreeChart: StackedBarChartDemo2.java");
        stackedBarChartDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)stackedBarChartDemo2));
        stackedBarChartDemo2.setVisible(true);
    }
}

