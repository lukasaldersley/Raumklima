/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.AxisLocation
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.CategoryItemLabelGenerator
 *  org.jfree.chart.labels.CategoryToolTipGenerator
 *  org.jfree.chart.labels.StandardCategoryItemLabelGenerator
 *  org.jfree.chart.labels.StandardCategoryToolTipGenerator
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.renderer.category.BarRenderer
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.title.TextTitle
 *  org.jfree.chart.title.Title
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
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BarChartDemo5
extends ApplicationFrame {
    public BarChartDemo5(String string) {
        super(string);
        JPanel jPanel = BarChartDemo5.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        String string = "Prison Population Rates";
        defaultCategoryDataset.addValue(59.0, (Comparable)((Object)string), (Comparable)((Object)"Norway"));
        defaultCategoryDataset.addValue(69.0, (Comparable)((Object)string), (Comparable)((Object)"Switzerland"));
        defaultCategoryDataset.addValue(85.0, (Comparable)((Object)string), (Comparable)((Object)"France"));
        defaultCategoryDataset.addValue(93.0, (Comparable)((Object)string), (Comparable)((Object)"Syria"));
        defaultCategoryDataset.addValue(96.0, (Comparable)((Object)string), (Comparable)((Object)"Germany"));
        defaultCategoryDataset.addValue(111.0, (Comparable)((Object)string), (Comparable)((Object)"China"));
        defaultCategoryDataset.addValue(116.0, (Comparable)((Object)string), (Comparable)((Object)"Australia"));
        defaultCategoryDataset.addValue(121.0, (Comparable)((Object)string), (Comparable)((Object)"Egypt"));
        defaultCategoryDataset.addValue(129.0, (Comparable)((Object)string), (Comparable)((Object)"England & Wales"));
        defaultCategoryDataset.addValue(157.0, (Comparable)((Object)string), (Comparable)((Object)"New Zealand"));
        defaultCategoryDataset.addValue(205.0, (Comparable)((Object)string), (Comparable)((Object)"Chile"));
        defaultCategoryDataset.addValue(229.0, (Comparable)((Object)string), (Comparable)((Object)"Iran"));
        defaultCategoryDataset.addValue(359.0, (Comparable)((Object)string), (Comparable)((Object)"Singapore"));
        defaultCategoryDataset.addValue(404.0, (Comparable)((Object)string), (Comparable)((Object)"South Africa"));
        defaultCategoryDataset.addValue(406.0, (Comparable)((Object)string), (Comparable)((Object)"Ukraine"));
        defaultCategoryDataset.addValue(686.0, (Comparable)((Object)string), (Comparable)((Object)"USA"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createBarChart((String)"Prison Population Rates - Selected Countries", (String)"Country", (String)"Prisoners Per 100,000 National Population", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.HORIZONTAL, (boolean)false, (boolean)true, (boolean)false);
        jFreeChart.addSubtitle((Title)new TextTitle("Source: http://www.homeoffice.gov.uk/rds/pdfs2/r188.pdf", new Font("Dialog", 2, 10)));
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
        categoryPlot.setRangePannable(true);
        BarRenderer barRenderer = (BarRenderer)categoryPlot.getRenderer();
        barRenderer.setItemLabelAnchorOffset(9.0);
        barRenderer.setBaseItemLabelsVisible(true);
        barRenderer.setBaseItemLabelGenerator((CategoryItemLabelGenerator)new StandardCategoryItemLabelGenerator());
        barRenderer.setBaseToolTipGenerator((CategoryToolTipGenerator)new StandardCategoryToolTipGenerator("{0}, {1}) = {2} per 100,000", (NumberFormat)new DecimalFormat("0")));
        CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
        categoryAxis.setCategoryMargin(0.25);
        categoryAxis.setUpperMargin(0.02);
        categoryAxis.setLowerMargin(0.02);
        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberAxis.setUpperMargin(0.1);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = BarChartDemo5.createChart(BarChartDemo5.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        BarChartDemo5 barChartDemo5 = new BarChartDemo5("JFreeChart: BarChartDemo5.java");
        barChartDemo5.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)barChartDemo5));
        barChartDemo5.setVisible(true);
    }
}

