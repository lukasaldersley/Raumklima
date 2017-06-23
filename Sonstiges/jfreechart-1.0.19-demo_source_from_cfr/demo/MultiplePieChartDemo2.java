/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.labels.PieSectionLabelGenerator
 *  org.jfree.chart.labels.StandardPieSectionLabelGenerator
 *  org.jfree.chart.plot.MultiplePiePlot
 *  org.jfree.chart.plot.PiePlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.general.DatasetUtilities
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.util.TableOrder
 */
package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.Window;
import java.text.NumberFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.TableOrder;

public class MultiplePieChartDemo2
extends ApplicationFrame {
    public MultiplePieChartDemo2(String string) {
        super(string);
        CategoryDataset categoryDataset = MultiplePieChartDemo2.createDataset();
        JFreeChart jFreeChart = MultiplePieChartDemo2.createChart(categoryDataset);
        ChartPanel chartPanel = new ChartPanel(jFreeChart, true, true, true, false, true);
        chartPanel.setPreferredSize(new Dimension(600, 380));
        this.setContentPane((Container)chartPanel);
    }

    private static CategoryDataset createDataset() {
        double[][] arrarrd = new double[][]{{3.0, 4.0, 3.0, 5.0}, {5.0, 7.0, 6.0, 8.0}, {5.0, 7.0, 3.0, 8.0}, {1.0, 2.0, 3.0, 4.0}, {2.0, 3.0, 2.0, 3.0}};
        CategoryDataset categoryDataset = DatasetUtilities.createCategoryDataset((String)"Region ", (String)"Sales/Q", (double[][])arrarrd);
        return categoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createMultiplePieChart((String)"Multiple Pie Chart", (CategoryDataset)categoryDataset, (TableOrder)TableOrder.BY_COLUMN, (boolean)true, (boolean)true, (boolean)false);
        MultiplePiePlot multiplePiePlot = (MultiplePiePlot)jFreeChart.getPlot();
        multiplePiePlot.setBackgroundPaint((Paint)Color.white);
        multiplePiePlot.setOutlineStroke((Stroke)new BasicStroke(1.0f));
        JFreeChart jFreeChart2 = multiplePiePlot.getPieChart();
        PiePlot piePlot = (PiePlot)jFreeChart2.getPlot();
        piePlot.setBackgroundPaint(null);
        piePlot.setOutlineStroke(null);
        piePlot.setLabelGenerator((PieSectionLabelGenerator)new StandardPieSectionLabelGenerator("{0} ({2})", NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance()));
        piePlot.setMaximumLabelWidth(0.2);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = MultiplePieChartDemo2.createChart(MultiplePieChartDemo2.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        MultiplePieChartDemo2 multiplePieChartDemo2 = new MultiplePieChartDemo2("JFreeChart: MultiplePieChartDemo2.java");
        multiplePieChartDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)multiplePieChartDemo2));
        multiplePieChartDemo2.setVisible(true);
    }
}

