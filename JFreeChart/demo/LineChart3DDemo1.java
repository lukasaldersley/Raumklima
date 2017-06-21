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
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class LineChart3DDemo1
extends ApplicationFrame {
    public LineChart3DDemo1(String string) {
        super(string);
        JPanel jPanel = LineChart3DDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(143.2, (Comparable)((Object)"S1"), (Comparable)((Object)"C1"));
        defaultCategoryDataset.addValue(120.2, (Comparable)((Object)"S1"), (Comparable)((Object)"C2"));
        defaultCategoryDataset.addValue(135.0, (Comparable)((Object)"S1"), (Comparable)((Object)"C3"));
        defaultCategoryDataset.addValue(115.0, (Comparable)((Object)"S1"), (Comparable)((Object)"C4"));
        defaultCategoryDataset.addValue(98.7, (Comparable)((Object)"S2"), (Comparable)((Object)"C1"));
        defaultCategoryDataset.addValue(63.2, (Comparable)((Object)"S2"), (Comparable)((Object)"C2"));
        defaultCategoryDataset.addValue(71.4, (Comparable)((Object)"S2"), (Comparable)((Object)"C3"));
        defaultCategoryDataset.addValue(55.0, (Comparable)((Object)"S2"), (Comparable)((Object)"C4"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createLineChart3D((String)"Line Chart 3D Demo 1", (String)null, (String)"Class Count", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)false, (boolean)true, (boolean)false);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setAutoRangeIncludesZero(false);
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = LineChart3DDemo1.createChart(LineChart3DDemo1.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        LineChart3DDemo1 lineChart3DDemo1 = new LineChart3DDemo1("JFreeChart: LineChart3DDemo1.java");
        lineChart3DDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)lineChart3DDemo1));
        lineChart3DDemo1.setVisible(true);
    }
}

