/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.CategoryToolTipGenerator
 *  org.jfree.chart.labels.StandardCategoryToolTipGenerator
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.renderer.category.LineAndShapeRenderer
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.data.time.Day
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import java.text.DateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Day;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class EventFrequencyDemo1
extends ApplicationFrame {
    public EventFrequencyDemo1(String string) {
        super(string);
        JPanel jPanel = EventFrequencyDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createBarChart((String)"Event Frequency Demo", (String)"Category", (String)"Value", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.HORIZONTAL, (boolean)true, (boolean)true, (boolean)false);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setRangePannable(true);
        categoryPlot.getDomainAxis().setMaximumCategoryLabelWidthRatio(10.0f);
        categoryPlot.setRangeAxis((ValueAxis)new DateAxis("Date"));
        StandardCategoryToolTipGenerator standardCategoryToolTipGenerator = new StandardCategoryToolTipGenerator("{0}, {1} : {2}", DateFormat.getDateInstance());
        LineAndShapeRenderer lineAndShapeRenderer = new LineAndShapeRenderer(false, true);
        lineAndShapeRenderer.setBaseToolTipGenerator((CategoryToolTipGenerator)standardCategoryToolTipGenerator);
        categoryPlot.setRenderer((CategoryItemRenderer)lineAndShapeRenderer);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        Day day = new Day(12, 6, 2002);
        Day day2 = new Day(14, 6, 2002);
        Day day3 = new Day(15, 6, 2002);
        Day day4 = new Day(10, 7, 2002);
        Day day5 = new Day(20, 7, 2002);
        Day day6 = new Day(22, 8, 2002);
        defaultCategoryDataset.setValue((Number)new Long(day.getMiddleMillisecond()), (Comparable)((Object)"Series 1"), (Comparable)((Object)"Requirement 1"));
        defaultCategoryDataset.setValue((Number)new Long(day.getMiddleMillisecond()), (Comparable)((Object)"Series 1"), (Comparable)((Object)"Requirement 2"));
        defaultCategoryDataset.setValue((Number)new Long(day2.getMiddleMillisecond()), (Comparable)((Object)"Series 1"), (Comparable)((Object)"Requirement 3"));
        defaultCategoryDataset.setValue((Number)new Long(day3.getMiddleMillisecond()), (Comparable)((Object)"Series 2"), (Comparable)((Object)"Requirement 1"));
        defaultCategoryDataset.setValue((Number)new Long(day4.getMiddleMillisecond()), (Comparable)((Object)"Series 2"), (Comparable)((Object)"Requirement 3"));
        defaultCategoryDataset.setValue((Number)new Long(day5.getMiddleMillisecond()), (Comparable)((Object)"Series 3"), (Comparable)((Object)"Requirement 2"));
        defaultCategoryDataset.setValue((Number)new Long(day6.getMiddleMillisecond()), (Comparable)((Object)"Series 1"), (Comparable)((Object)"Requirement 4"));
        return defaultCategoryDataset;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = EventFrequencyDemo1.createChart(EventFrequencyDemo1.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        EventFrequencyDemo1 eventFrequencyDemo1 = new EventFrequencyDemo1("JFreeChart: EventFrequencyDemo1.java");
        eventFrequencyDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)eventFrequencyDemo1));
        eventFrequencyDemo1.setVisible(true);
    }
}

