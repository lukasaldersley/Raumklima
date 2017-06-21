/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.annotations.CategoryAnnotation
 *  org.jfree.chart.annotations.CategoryTextAnnotation
 *  org.jfree.chart.axis.CategoryAnchor
 *  org.jfree.chart.axis.CategoryAxis
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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.CategoryAnnotation;
import org.jfree.chart.annotations.CategoryTextAnnotation;
import org.jfree.chart.axis.CategoryAnchor;
import org.jfree.chart.axis.CategoryAxis;
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

public class SurveyResultsDemo1
extends ApplicationFrame {
    public SurveyResultsDemo1(String string) {
        super(string);
        JPanel jPanel = SurveyResultsDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(700, 600));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(2.01, (Comparable)((Object)"Results"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue(2.02, (Comparable)((Object)"Results"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset.addValue(2.0, (Comparable)((Object)"Results"), (Comparable)((Object)"Category 3"));
        defaultCategoryDataset.addValue(1.97, (Comparable)((Object)"Results"), (Comparable)((Object)"Category 4"));
        defaultCategoryDataset.addValue(1.44, (Comparable)((Object)"Results"), (Comparable)((Object)"Category 5"));
        defaultCategoryDataset.addValue(1.49, (Comparable)((Object)"Results"), (Comparable)((Object)"Category 6"));
        defaultCategoryDataset.addValue(1.49, (Comparable)((Object)"Results"), (Comparable)((Object)"Category 7"));
        defaultCategoryDataset.addValue(1.48, (Comparable)((Object)"Results"), (Comparable)((Object)"Category 8"));
        defaultCategoryDataset.addValue(4.26, (Comparable)((Object)"Results"), (Comparable)((Object)"Category 9"));
        defaultCategoryDataset.addValue(4.08, (Comparable)((Object)"Results"), (Comparable)((Object)"Category 10"));
        defaultCategoryDataset.addValue(4.03, (Comparable)((Object)"Results"), (Comparable)((Object)"Category 11"));
        defaultCategoryDataset.addValue(3.92, (Comparable)((Object)"Results"), (Comparable)((Object)"Category 12"));
        defaultCategoryDataset.addValue(3.99, (Comparable)((Object)"Results"), (Comparable)((Object)"Category 13"));
        defaultCategoryDataset.addValue(2.23, (Comparable)((Object)"Results"), (Comparable)((Object)"Category 14"));
        defaultCategoryDataset.addValue(2.6, (Comparable)((Object)"Results"), (Comparable)((Object)"Overall"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createBarChart((String)null, (String)null, (String)null, (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.HORIZONTAL, (boolean)false, (boolean)true, (boolean)false);
        jFreeChart.setBackgroundPaint((Paint)Color.white);
        TextTitle textTitle = new TextTitle("Figure 7 | I. Resources - The site offers users relevant, informative and educational resources");
        textTitle.setHorizontalAlignment(HorizontalAlignment.LEFT);
        textTitle.setBackgroundPaint((Paint)Color.red);
        textTitle.setPaint((Paint)Color.white);
        jFreeChart.setTitle(textTitle);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setOutlinePaint(null);
        categoryPlot.setDomainGridlinesVisible(true);
        categoryPlot.setDomainGridlinePosition(CategoryAnchor.END);
        categoryPlot.setDomainGridlineStroke((Stroke)new BasicStroke(0.5f));
        categoryPlot.setDomainGridlinePaint((Paint)Color.black);
        categoryPlot.setRangeGridlinesVisible(false);
        categoryPlot.clearRangeMarkers();
        CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
        categoryAxis.setVisible(false);
        categoryAxis.setCategoryMargin(0.5);
        categoryPlot.getRangeAxis().setVisible(false);
        BarRenderer barRenderer = (BarRenderer)categoryPlot.getRenderer();
        barRenderer.setSeriesPaint(0, (Paint)new Color(156, 164, 74));
        barRenderer.setDrawBarOutline(false);
        barRenderer.setBaseItemLabelsVisible(true);
        barRenderer.setBaseItemLabelFont(new Font("SansSerif", 1, 10));
        ItemLabelPosition itemLabelPosition = new ItemLabelPosition(ItemLabelAnchor.INSIDE3, TextAnchor.CENTER_RIGHT);
        barRenderer.setBasePositiveItemLabelPosition(itemLabelPosition);
        CategoryTextAnnotation categoryTextAnnotation = new CategoryTextAnnotation("1. White papers are available.", (Comparable)((Object)"Category 1"), 0.0);
        categoryTextAnnotation.setFont(new Font("SansSerif", 1, 12));
        categoryTextAnnotation.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categoryTextAnnotation.setCategoryAnchor(CategoryAnchor.START);
        categoryPlot.addAnnotation((CategoryAnnotation)categoryTextAnnotation);
        CategoryTextAnnotation categoryTextAnnotation2 = new CategoryTextAnnotation("2. White papers enhance users understanding of the firm and its expertise.", (Comparable)((Object)"Category 2"), 0.0);
        categoryTextAnnotation2.setFont(new Font("SansSerif", 0, 12));
        categoryTextAnnotation2.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categoryTextAnnotation2.setCategoryAnchor(CategoryAnchor.START);
        categoryPlot.addAnnotation((CategoryAnnotation)categoryTextAnnotation2);
        CategoryTextAnnotation categoryTextAnnotation3 = new CategoryTextAnnotation("3. White papers are relevant to the firm's prospects and clients.", (Comparable)((Object)"Category 3"), 0.0);
        categoryTextAnnotation3.setFont(new Font("SansSerif", 0, 12));
        categoryTextAnnotation3.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categoryTextAnnotation3.setCategoryAnchor(CategoryAnchor.START);
        categoryPlot.addAnnotation((CategoryAnnotation)categoryTextAnnotation3);
        CategoryTextAnnotation categoryTextAnnotation4 = new CategoryTextAnnotation("4. White papers are relevant to the firm's positioning.", (Comparable)((Object)"Category 4"), 0.0);
        categoryTextAnnotation4.setFont(new Font("SansSerif", 0, 12));
        categoryTextAnnotation4.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categoryTextAnnotation4.setCategoryAnchor(CategoryAnchor.START);
        categoryPlot.addAnnotation((CategoryAnnotation)categoryTextAnnotation4);
        CategoryTextAnnotation categoryTextAnnotation5 = new CategoryTextAnnotation("5. Case studies are available.", (Comparable)((Object)"Category 5"), 0.0);
        categoryTextAnnotation5.setFont(new Font("SansSerif", 1, 12));
        categoryTextAnnotation5.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categoryTextAnnotation5.setCategoryAnchor(CategoryAnchor.START);
        categoryPlot.addAnnotation((CategoryAnnotation)categoryTextAnnotation5);
        CategoryTextAnnotation categoryTextAnnotation6 = new CategoryTextAnnotation("6. Case studies enhance users understanding of the firm and its expertise.", (Comparable)((Object)"Category 6"), 0.0);
        categoryTextAnnotation6.setFont(new Font("SansSerif", 0, 12));
        categoryTextAnnotation6.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categoryTextAnnotation6.setCategoryAnchor(CategoryAnchor.START);
        categoryPlot.addAnnotation((CategoryAnnotation)categoryTextAnnotation6);
        CategoryTextAnnotation categoryTextAnnotation7 = new CategoryTextAnnotation("7. Case studies are relevant to the firm's prospects and clients.", (Comparable)((Object)"Category 7"), 0.0);
        categoryTextAnnotation7.setFont(new Font("SansSerif", 0, 12));
        categoryTextAnnotation7.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categoryTextAnnotation7.setCategoryAnchor(CategoryAnchor.START);
        categoryPlot.addAnnotation((CategoryAnnotation)categoryTextAnnotation7);
        CategoryTextAnnotation categoryTextAnnotation8 = new CategoryTextAnnotation("8. White papers are relevant to the firm's positioning.", (Comparable)((Object)"Category 8"), 0.0);
        categoryTextAnnotation8.setFont(new Font("SansSerif", 0, 12));
        categoryTextAnnotation8.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categoryTextAnnotation8.setCategoryAnchor(CategoryAnchor.START);
        categoryPlot.addAnnotation((CategoryAnnotation)categoryTextAnnotation8);
        CategoryTextAnnotation categoryTextAnnotation9 = new CategoryTextAnnotation("9. Case studies are available.", (Comparable)((Object)"Category 9"), 0.0);
        categoryTextAnnotation9.setFont(new Font("SansSerif", 1, 12));
        categoryTextAnnotation9.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categoryTextAnnotation9.setCategoryAnchor(CategoryAnchor.START);
        categoryPlot.addAnnotation((CategoryAnnotation)categoryTextAnnotation9);
        CategoryTextAnnotation categoryTextAnnotation10 = new CategoryTextAnnotation("10. Case studies enhance users understanding of the firm and its expertise.", (Comparable)((Object)"Category 10"), 0.0);
        categoryTextAnnotation10.setFont(new Font("SansSerif", 0, 12));
        categoryTextAnnotation10.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categoryTextAnnotation10.setCategoryAnchor(CategoryAnchor.START);
        categoryPlot.addAnnotation((CategoryAnnotation)categoryTextAnnotation10);
        CategoryTextAnnotation categoryTextAnnotation11 = new CategoryTextAnnotation("11. Case studies are relevant to the firm's prospects and clients.", (Comparable)((Object)"Category 11"), 0.0);
        categoryTextAnnotation11.setFont(new Font("SansSerif", 0, 12));
        categoryTextAnnotation11.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categoryTextAnnotation11.setCategoryAnchor(CategoryAnchor.START);
        categoryPlot.addAnnotation((CategoryAnnotation)categoryTextAnnotation11);
        CategoryTextAnnotation categoryTextAnnotation12 = new CategoryTextAnnotation("12. White papers are relevant to the firm's positioning.", (Comparable)((Object)"Category 12"), 0.0);
        categoryTextAnnotation12.setFont(new Font("SansSerif", 0, 12));
        categoryTextAnnotation12.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categoryTextAnnotation12.setCategoryAnchor(CategoryAnchor.START);
        categoryPlot.addAnnotation((CategoryAnnotation)categoryTextAnnotation12);
        CategoryTextAnnotation categoryTextAnnotation13 = new CategoryTextAnnotation("13. Users can easily access resources based on viewer interest.", (Comparable)((Object)"Category 13"), 0.0);
        categoryTextAnnotation13.setFont(new Font("SansSerif", 1, 12));
        categoryTextAnnotation13.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categoryTextAnnotation13.setCategoryAnchor(CategoryAnchor.START);
        categoryPlot.addAnnotation((CategoryAnnotation)categoryTextAnnotation13);
        CategoryTextAnnotation categoryTextAnnotation14 = new CategoryTextAnnotation("14. Access to additional hyperlinks enhances users's ability to find relevant information.", (Comparable)((Object)"Category 14"), 0.0);
        categoryTextAnnotation14.setFont(new Font("SansSerif", 1, 12));
        categoryTextAnnotation14.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categoryTextAnnotation14.setCategoryAnchor(CategoryAnchor.START);
        categoryPlot.addAnnotation((CategoryAnnotation)categoryTextAnnotation14);
        CategoryTextAnnotation categoryTextAnnotation15 = new CategoryTextAnnotation("15. OVERALL EFFECTIVENESS.", (Comparable)((Object)"Overall"), 0.0);
        categoryTextAnnotation15.setFont(new Font("SansSerif", 1, 12));
        categoryTextAnnotation15.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categoryTextAnnotation15.setCategoryAnchor(CategoryAnchor.START);
        categoryPlot.addAnnotation((CategoryAnnotation)categoryTextAnnotation15);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = SurveyResultsDemo1.createChart(SurveyResultsDemo1.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        SurveyResultsDemo1 surveyResultsDemo1 = new SurveyResultsDemo1("Survey Results Demo 1");
        surveyResultsDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)surveyResultsDemo1));
        surveyResultsDemo1.setVisible(true);
    }
}

