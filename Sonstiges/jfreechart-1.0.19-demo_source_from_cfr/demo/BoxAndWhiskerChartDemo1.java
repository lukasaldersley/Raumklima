/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.data.statistics.BoxAndWhiskerCategoryDataset
 *  org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BoxAndWhiskerChartDemo1
extends ApplicationFrame {
    public BoxAndWhiskerChartDemo1(String string) {
        super(string);
        JPanel jPanel = BoxAndWhiskerChartDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static BoxAndWhiskerCategoryDataset createDataset() {
        int n = 3;
        int n2 = 5;
        int n3 = 20;
        DefaultBoxAndWhiskerCategoryDataset defaultBoxAndWhiskerCategoryDataset = new DefaultBoxAndWhiskerCategoryDataset();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                List list = BoxAndWhiskerChartDemo1.createValueList(0.0, 20.0, n3);
                defaultBoxAndWhiskerCategoryDataset.add(list, (Comparable)((Object)("Series " + i)), (Comparable)((Object)("Category " + j)));
            }
        }
        return defaultBoxAndWhiskerCategoryDataset;
    }

    private static List createValueList(double d, double d2, int n) {
        ArrayList<Double> arrayList = new ArrayList<Double>();
        for (int i = 0; i < n; ++i) {
            double d3 = d + Math.random() * (d2 - d);
            arrayList.add(new Double(d3));
        }
        return arrayList;
    }

    private static JFreeChart createChart(BoxAndWhiskerCategoryDataset boxAndWhiskerCategoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createBoxAndWhiskerChart((String)"Box and Whisker Chart Demo 1", (String)"Category", (String)"Value", (BoxAndWhiskerCategoryDataset)boxAndWhiskerCategoryDataset, (boolean)true);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setDomainGridlinesVisible(true);
        categoryPlot.setRangePannable(true);
        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = BoxAndWhiskerChartDemo1.createChart(BoxAndWhiskerChartDemo1.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        BoxAndWhiskerChartDemo1 boxAndWhiskerChartDemo1 = new BoxAndWhiskerChartDemo1("JFreeChart: BoxAndWhiskerChartDemo1.java");
        boxAndWhiskerChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)boxAndWhiskerChartDemo1));
        boxAndWhiskerChartDemo1.setVisible(true);
    }
}

