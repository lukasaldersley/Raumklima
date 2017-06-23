/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.CategoryToolTipGenerator
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
 *  org.jfree.ui.RectangleEdge
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Window;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.CategoryToolTipGenerator;
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
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;

public class BarChartDemo11
extends ApplicationFrame {
    public BarChartDemo11(String string) {
        super(string);
        JPanel jPanel = BarChartDemo11.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(33.0, (Comparable)((Object)"S1"), (Comparable)((Object)"GNU General Public License (GPL) 2.0"));
        defaultCategoryDataset.addValue(13.0, (Comparable)((Object)"S1"), (Comparable)((Object)"Apache License 2.0"));
        defaultCategoryDataset.addValue(12.0, (Comparable)((Object)"S1"), (Comparable)((Object)"GNU General Public License (GPL) 3.0"));
        defaultCategoryDataset.addValue(11.0, (Comparable)((Object)"S1"), (Comparable)((Object)"MIT License"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"S1"), (Comparable)((Object)"BSD License 2.0"));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)"S1"), (Comparable)((Object)"Artistic Licence (Perl)"));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)"S1"), (Comparable)((Object)"GNU Lesser General Public License (LGPL) 2.1"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"S1"), (Comparable)((Object)"GNU Lesser General Public License (LGPL) 3.0"));
        defaultCategoryDataset.addValue(2.0, (Comparable)((Object)"S1"), (Comparable)((Object)"Eclipse Public License"));
        defaultCategoryDataset.addValue(1.0, (Comparable)((Object)"S1"), (Comparable)((Object)"Code Project 1.02 License"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createBarChart((String)"Open Source Projects By License", (String)"License", (String)"Percent", (CategoryDataset)categoryDataset);
        jFreeChart.removeLegend();
        TextTitle textTitle = new TextTitle("Source: http://www.blackducksoftware.com/resources/data/top-20-licenses (as at 30 Aug 2013)", new Font("Dialog", 0, 9));
        textTitle.setPosition(RectangleEdge.BOTTOM);
        jFreeChart.addSubtitle((Title)textTitle);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setOrientation(PlotOrientation.HORIZONTAL);
        categoryPlot.setDomainGridlinesVisible(true);
        categoryPlot.getDomainAxis().setMaximumCategoryLabelWidthRatio(0.8f);
        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer barRenderer = (BarRenderer)categoryPlot.getRenderer();
        barRenderer.setDrawBarOutline(false);
        StandardCategoryToolTipGenerator standardCategoryToolTipGenerator = new StandardCategoryToolTipGenerator("{1}: {2} percent", (NumberFormat)new DecimalFormat("0"));
        barRenderer.setBaseToolTipGenerator((CategoryToolTipGenerator)standardCategoryToolTipGenerator);
        GradientPaint gradientPaint = new GradientPaint(0.0f, 0.0f, Color.BLUE, 0.0f, 0.0f, new Color(0, 0, 64));
        barRenderer.setSeriesPaint(0, (Paint)gradientPaint);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = BarChartDemo11.createChart(BarChartDemo11.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        BarChartDemo11 barChartDemo11 = new BarChartDemo11("JFreeChart: BarChartDemo11.java");
        barChartDemo11.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)barChartDemo11));
        barChartDemo11.setVisible(true);
    }
}

