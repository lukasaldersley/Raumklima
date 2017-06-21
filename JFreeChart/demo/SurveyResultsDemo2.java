/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.axis.ExtendedCategoryAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.ItemLabelAnchor
 *  org.jfree.chart.labels.ItemLabelPosition
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.renderer.category.BarRenderer
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.title.TextTitle
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.HorizontalAlignment
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.ui.TextAnchor
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ExtendedCategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class SurveyResultsDemo2
extends ApplicationFrame {
    public SurveyResultsDemo2(String string) {
        super(string);
        JPanel jPanel = SurveyResultsDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(300, 270));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(1.32, (Comparable)((Object)"Results"), (Comparable)((Object)"Sm."));
        defaultCategoryDataset.addValue(0.4, (Comparable)((Object)"Results"), (Comparable)((Object)"Med."));
        defaultCategoryDataset.addValue(2.62, (Comparable)((Object)"Results"), (Comparable)((Object)"Lg."));
        defaultCategoryDataset.addValue(1.44, (Comparable)((Object)"Results"), (Comparable)((Object)"All"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createBarChart((String)null, (String)null, (String)null, (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)false, (boolean)true, (boolean)false);
        jFreeChart.setBackgroundPaint((Paint)Color.white);
        jFreeChart.getPlot().setOutlinePaint(null);
        TextTitle textTitle = new TextTitle("Figure 8.5 - Case studies are available");
        textTitle.setHorizontalAlignment(HorizontalAlignment.LEFT);
        textTitle.setBackgroundPaint((Paint)Color.red);
        textTitle.setPaint((Paint)Color.white);
        jFreeChart.setTitle(textTitle);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        ValueAxis valueAxis = categoryPlot.getRangeAxis();
        valueAxis.setRange(0.0, 5.0);
        valueAxis.setVisible(false);
        ExtendedCategoryAxis extendedCategoryAxis = new ExtendedCategoryAxis(null);
        extendedCategoryAxis.setTickLabelFont(new Font("SansSerif", 1, 12));
        extendedCategoryAxis.setCategoryMargin(0.3);
        extendedCategoryAxis.addSubLabel((Comparable)((Object)"Sm."), "(10)");
        extendedCategoryAxis.addSubLabel((Comparable)((Object)"Med."), "(10)");
        extendedCategoryAxis.addSubLabel((Comparable)((Object)"Lg."), "(10)");
        extendedCategoryAxis.addSubLabel((Comparable)((Object)"All"), "(10)");
        categoryPlot.setDomainAxis((CategoryAxis)extendedCategoryAxis);
        BarRenderer barRenderer = (BarRenderer)categoryPlot.getRenderer();
        barRenderer.setSeriesPaint(0, (Paint)new Color(156, 164, 74));
        barRenderer.setDrawBarOutline(false);
        barRenderer.setBaseItemLabelsVisible(true);
        barRenderer.setBaseItemLabelFont(new Font("SansSerif", 0, 18));
        ItemLabelPosition itemLabelPosition = new ItemLabelPosition(ItemLabelAnchor.INSIDE12, TextAnchor.TOP_CENTER);
        barRenderer.setBasePositiveItemLabelPosition(itemLabelPosition);
        barRenderer.setPositiveItemLabelPositionFallback(new ItemLabelPosition());
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = SurveyResultsDemo2.createChart(SurveyResultsDemo2.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        SurveyResultsDemo2 surveyResultsDemo2 = new SurveyResultsDemo2("Survey Results Demo 2");
        surveyResultsDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)surveyResultsDemo2));
        surveyResultsDemo2.setVisible(true);
    }
}

