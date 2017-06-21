/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.axis.CategoryLabelPositions
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.CategoryItemLabelGenerator
 *  org.jfree.chart.labels.StandardCategoryItemLabelGenerator
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.renderer.category.BarPainter
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.renderer.category.StackedBarRenderer
 *  org.jfree.chart.renderer.category.StandardBarPainter
 *  org.jfree.chart.title.TextTitle
 *  org.jfree.chart.title.Title
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Window;
import java.awt.font.TextAttribute;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.renderer.category.BarPainter;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StackedBarChartDemo1
extends ApplicationFrame {
    public StackedBarChartDemo1(String string) {
        super(string);
        JPanel jPanel = StackedBarChartDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(197.0, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"Brazil"));
        defaultCategoryDataset.addValue(64.0, (Comparable)((Object)"Domestic"), (Comparable)((Object)"Brazil"));
        defaultCategoryDataset.addValue(57.0, (Comparable)((Object)"Industrial"), (Comparable)((Object)"Brazil"));
        defaultCategoryDataset.addValue(339.0, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"Indonesia"));
        defaultCategoryDataset.addValue(30.0, (Comparable)((Object)"Domestic"), (Comparable)((Object)"Indonesia"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"Industrial"), (Comparable)((Object)"Indonesia"));
        defaultCategoryDataset.addValue(279.0, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"China"));
        defaultCategoryDataset.addValue(27.0, (Comparable)((Object)"Domestic"), (Comparable)((Object)"China"));
        defaultCategoryDataset.addValue(107.0, (Comparable)((Object)"Industrial"), (Comparable)((Object)"China"));
        defaultCategoryDataset.addValue(92.0, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"Germany"));
        defaultCategoryDataset.addValue(55.0, (Comparable)((Object)"Domestic"), (Comparable)((Object)"Germany"));
        defaultCategoryDataset.addValue(313.0, (Comparable)((Object)"Industrial"), (Comparable)((Object)"Germany"));
        defaultCategoryDataset.addValue(96.0, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"Russia"));
        defaultCategoryDataset.addValue(102.0, (Comparable)((Object)"Domestic"), (Comparable)((Object)"Russia"));
        defaultCategoryDataset.addValue(337.0, (Comparable)((Object)"Industrial"), (Comparable)((Object)"Russia"));
        defaultCategoryDataset.addValue(403.0, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"Turkey"));
        defaultCategoryDataset.addValue(82.0, (Comparable)((Object)"Domestic"), (Comparable)((Object)"Turkey"));
        defaultCategoryDataset.addValue(60.0, (Comparable)((Object)"Industrial"), (Comparable)((Object)"Turkey"));
        defaultCategoryDataset.addValue(536.0, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"Bangladesh"));
        defaultCategoryDataset.addValue(17.0, (Comparable)((Object)"Domestic"), (Comparable)((Object)"Bangladesh"));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)"Industrial"), (Comparable)((Object)"Bangladesh"));
        defaultCategoryDataset.addValue(508.0, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"India"));
        defaultCategoryDataset.addValue(47.0, (Comparable)((Object)"Domestic"), (Comparable)((Object)"India"));
        defaultCategoryDataset.addValue(30.0, (Comparable)((Object)"Industrial"), (Comparable)((Object)"India"));
        defaultCategoryDataset.addValue(428.0, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"Japan"));
        defaultCategoryDataset.addValue(138.0, (Comparable)((Object)"Domestic"), (Comparable)((Object)"Japan"));
        defaultCategoryDataset.addValue(124.0, (Comparable)((Object)"Industrial"), (Comparable)((Object)"Japan"));
        defaultCategoryDataset.addValue(325.0, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"Italy"));
        defaultCategoryDataset.addValue(130.0, (Comparable)((Object)"Domestic"), (Comparable)((Object)"Italy"));
        defaultCategoryDataset.addValue(268.0, (Comparable)((Object)"Industrial"), (Comparable)((Object)"Italy"));
        defaultCategoryDataset.addValue(569.0, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"Mexico"));
        defaultCategoryDataset.addValue(126.0, (Comparable)((Object)"Domestic"), (Comparable)((Object)"Mexico"));
        defaultCategoryDataset.addValue(37.0, (Comparable)((Object)"Industrial"), (Comparable)((Object)"Mexico"));
        defaultCategoryDataset.addValue(576.0, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"Vietnam"));
        defaultCategoryDataset.addValue(68.0, (Comparable)((Object)"Domestic"), (Comparable)((Object)"Vietnam"));
        defaultCategoryDataset.addValue(203.0, (Comparable)((Object)"Industrial"), (Comparable)((Object)"Vietnam"));
        defaultCategoryDataset.addValue(794.0, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"Egypt"));
        defaultCategoryDataset.addValue(74.0, (Comparable)((Object)"Domestic"), (Comparable)((Object)"Egypt"));
        defaultCategoryDataset.addValue(55.0, (Comparable)((Object)"Industrial"), (Comparable)((Object)"Egypt"));
        defaultCategoryDataset.addValue(954.0, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"Iran"));
        defaultCategoryDataset.addValue(21.0, (Comparable)((Object)"Domestic"), (Comparable)((Object)"Iran"));
        defaultCategoryDataset.addValue(73.0, (Comparable)((Object)"Industrial"), (Comparable)((Object)"Iran"));
        defaultCategoryDataset.addValue(1029.0, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"Pakistan"));
        defaultCategoryDataset.addValue(21.0, (Comparable)((Object)"Domestic"), (Comparable)((Object)"Pakistan"));
        defaultCategoryDataset.addValue(21.0, (Comparable)((Object)"Industrial"), (Comparable)((Object)"Pakistan"));
        defaultCategoryDataset.addValue(1236.0, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"Thailand"));
        defaultCategoryDataset.addValue(26.0, (Comparable)((Object)"Domestic"), (Comparable)((Object)"Thailand"));
        defaultCategoryDataset.addValue(26.0, (Comparable)((Object)"Industrial"), (Comparable)((Object)"Thailand"));
        defaultCategoryDataset.addValue(165.0, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"Canada"));
        defaultCategoryDataset.addValue(274.0, (Comparable)((Object)"Domestic"), (Comparable)((Object)"Canada"));
        defaultCategoryDataset.addValue(947.0, (Comparable)((Object)"Industrial"), (Comparable)((Object)"Canada"));
        defaultCategoryDataset.addValue(1363.0, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"Iraq"));
        defaultCategoryDataset.addValue(44.0, (Comparable)((Object)"Domestic"), (Comparable)((Object)"Iraq"));
        defaultCategoryDataset.addValue(74.0, (Comparable)((Object)"Industrial"), (Comparable)((Object)"Iraq"));
        defaultCategoryDataset.addValue(656.0, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"US"));
        defaultCategoryDataset.addValue(208.0, (Comparable)((Object)"Domestic"), (Comparable)((Object)"US"));
        defaultCategoryDataset.addValue(736.0, (Comparable)((Object)"Industrial"), (Comparable)((Object)"US"));
        defaultCategoryDataset.addValue(2040.0, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"Uzbekistan"));
        defaultCategoryDataset.addValue(110.0, (Comparable)((Object)"Domestic"), (Comparable)((Object)"Uzbekistan"));
        defaultCategoryDataset.addValue(44.0, (Comparable)((Object)"Industrial"), (Comparable)((Object)"Uzbekistan"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createStackedBarChart((String)"Freshwater Usage By Country", (String)"Country", (String)"Value", (CategoryDataset)categoryDataset);
        jFreeChart.addSubtitle((Title)new TextTitle("Source: http://en.wikipedia.org/wiki/Peak_water#Water_supply"));
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
        categoryAxis.setLowerMargin(0.01);
        categoryAxis.setUpperMargin(0.01);
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
        AttributedString attributedString = new AttributedString("m3/person/year");
        attributedString.addAttribute(TextAttribute.WEIGHT, TextAttribute.WEIGHT_ULTRABOLD);
        attributedString.addAttribute(TextAttribute.SIZE, 14);
        attributedString.addAttribute(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUPER, 1, 2);
        categoryPlot.getRangeAxis().setAttributedLabel(attributedString);
        StackedBarRenderer stackedBarRenderer = (StackedBarRenderer)categoryPlot.getRenderer();
        stackedBarRenderer.setDrawBarOutline(false);
        stackedBarRenderer.setBarPainter((BarPainter)new StandardBarPainter());
        stackedBarRenderer.setBaseItemLabelsVisible(true);
        stackedBarRenderer.setBaseItemLabelGenerator((CategoryItemLabelGenerator)new StandardCategoryItemLabelGenerator());
        stackedBarRenderer.setBaseItemLabelPaint((Paint)Color.WHITE);
        stackedBarRenderer.setSeriesPaint(0, (Paint)new Color(0, 55, 122));
        stackedBarRenderer.setSeriesPaint(1, (Paint)new Color(24, 123, 58));
        stackedBarRenderer.setSeriesPaint(2, (Paint)Color.RED);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = StackedBarChartDemo1.createChart(StackedBarChartDemo1.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        StackedBarChartDemo1 stackedBarChartDemo1 = new StackedBarChartDemo1("JFreeChart: StackedBarChartDemo1");
        stackedBarChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)stackedBarChartDemo1));
        stackedBarChartDemo1.setVisible(true);
    }
}

