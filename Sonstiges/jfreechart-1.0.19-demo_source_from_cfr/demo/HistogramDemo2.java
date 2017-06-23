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
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYBarRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.statistics.SimpleHistogramBin
 *  org.jfree.data.statistics.SimpleHistogramDataset
 *  org.jfree.data.xy.IntervalXYDataset
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
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.statistics.SimpleHistogramBin;
import org.jfree.data.statistics.SimpleHistogramDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class HistogramDemo2
extends ApplicationFrame {
    public HistogramDemo2(String string) {
        super(string);
        JPanel jPanel = HistogramDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static IntervalXYDataset createDataset() {
        SimpleHistogramDataset simpleHistogramDataset = new SimpleHistogramDataset((Comparable)((Object)"Series 1"));
        SimpleHistogramBin simpleHistogramBin = new SimpleHistogramBin(0.0, 1.0, true, false);
        SimpleHistogramBin simpleHistogramBin2 = new SimpleHistogramBin(1.0, 2.0, true, false);
        SimpleHistogramBin simpleHistogramBin3 = new SimpleHistogramBin(2.0, 3.0, true, false);
        SimpleHistogramBin simpleHistogramBin4 = new SimpleHistogramBin(3.0, 4.0, true, true);
        simpleHistogramBin.setItemCount(1);
        simpleHistogramBin2.setItemCount(10);
        simpleHistogramBin3.setItemCount(15);
        simpleHistogramBin4.setItemCount(20);
        simpleHistogramDataset.addBin(simpleHistogramBin);
        simpleHistogramDataset.addBin(simpleHistogramBin2);
        simpleHistogramDataset.addBin(simpleHistogramBin3);
        simpleHistogramDataset.addBin(simpleHistogramBin4);
        return simpleHistogramDataset;
    }

    private static JFreeChart createChart(IntervalXYDataset intervalXYDataset) {
        JFreeChart jFreeChart = ChartFactory.createHistogram((String)"HistogramDemo2", (String)null, (String)null, (IntervalXYDataset)intervalXYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setForegroundAlpha(0.85f);
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        NumberAxis numberAxis = (NumberAxis)xYPlot.getRangeAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        XYBarRenderer xYBarRenderer = (XYBarRenderer)xYPlot.getRenderer();
        xYBarRenderer.setDrawBarOutline(false);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = HistogramDemo2.createChart(HistogramDemo2.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        HistogramDemo2 histogramDemo2 = new HistogramDemo2("JFreeChart: HistogramDemo2.java");
        histogramDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)histogramDemo2));
        histogramDemo2.setVisible(true);
    }
}

