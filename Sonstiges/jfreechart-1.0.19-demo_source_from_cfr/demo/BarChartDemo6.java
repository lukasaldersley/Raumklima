/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RectangleInsets
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class BarChartDemo6
extends ApplicationFrame {
    public BarChartDemo6(String string) {
        super(string);
        JPanel jPanel = BarChartDemo6.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(83.0, (Comparable)((Object)"First"), (Comparable)((Object)"Factor 1"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createBarChart((String)null, (String)"Category", (String)"Score (%)", (CategoryDataset)categoryDataset);
        jFreeChart.removeLegend();
        jFreeChart.setBackgroundPaint((Paint)Color.YELLOW);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setOrientation(PlotOrientation.HORIZONTAL);
        categoryPlot.setInsets(new RectangleInsets(0.0, 0.0, 0.0, 0.0));
        categoryPlot.setAxisOffset(RectangleInsets.ZERO_INSETS);
        categoryPlot.setRangeGridlinesVisible(false);
        CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
        categoryAxis.setLowerMargin(0.2);
        categoryAxis.setUpperMargin(0.2);
        categoryAxis.setVisible(false);
        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setRange(0.0, 100.0);
        numberAxis.setVisible(false);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = BarChartDemo6.createChart(BarChartDemo6.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        BarChartDemo6 barChartDemo6 = new BarChartDemo6("JFreeChart: BarChartDemo6.java");
        barChartDemo6.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)barChartDemo6));
        barChartDemo6.setVisible(true);
    }
}

