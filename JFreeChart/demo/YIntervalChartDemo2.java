/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYErrorRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.xy.IntervalXYDataset
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.YIntervalSeries
 *  org.jfree.data.xy.YIntervalSeriesCollection
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Window;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYErrorRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.YIntervalSeries;
import org.jfree.data.xy.YIntervalSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class YIntervalChartDemo2
extends ApplicationFrame {
    public YIntervalChartDemo2(String string) {
        super(string);
        JPanel jPanel = YIntervalChartDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static void add(YIntervalSeries yIntervalSeries, int n, int n2, int n3, double d, double d2) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(n, n2, n3);
        yIntervalSeries.add((double)calendar.getTime().getTime(), d, d - d2, d + d2);
    }

    private static IntervalXYDataset createDataset() {
        YIntervalSeries yIntervalSeries = new YIntervalSeries((Comparable)((Object)"Series 1"));
        YIntervalChartDemo2.add(yIntervalSeries, 2005, 4, 16, 1309.0, 13.0);
        YIntervalChartDemo2.add(yIntervalSeries, 2005, 9, 18, 1312.0, 12.0);
        YIntervalChartDemo2.add(yIntervalSeries, 2005, 10, 7, 1309.0, 12.0);
        YIntervalChartDemo2.add(yIntervalSeries, 2006, 0, 12, 1311.0, 12.0);
        YIntervalChartDemo2.add(yIntervalSeries, 2006, 1, 7, 1311.0, 13.0);
        YIntervalChartDemo2.add(yIntervalSeries, 2006, 3, 3, 1309.0, 13.0);
        YIntervalChartDemo2.add(yIntervalSeries, 2006, 3, 4, 1307.0, 13.0);
        YIntervalChartDemo2.add(yIntervalSeries, 2006, 3, 6, 1305.0, 13.0);
        YIntervalChartDemo2.add(yIntervalSeries, 2006, 3, 13, 1303.0, 13.0);
        YIntervalChartDemo2.add(yIntervalSeries, 2006, 3, 25, 1308.0, 13.0);
        YIntervalChartDemo2.add(yIntervalSeries, 2006, 3, 28, 1311.0, 13.0);
        YIntervalChartDemo2.add(yIntervalSeries, 2006, 4, 2, 1306.0, 13.0);
        YIntervalChartDemo2.add(yIntervalSeries, 2006, 4, 15, 1303.0, 13.0);
        YIntervalChartDemo2.add(yIntervalSeries, 2006, 4, 18, 1311.0, 13.0);
        YIntervalChartDemo2.add(yIntervalSeries, 2006, 10, 16, 1301.0, 13.0);
        YIntervalSeriesCollection yIntervalSeriesCollection = new YIntervalSeriesCollection();
        yIntervalSeriesCollection.addSeries(yIntervalSeries);
        return yIntervalSeriesCollection;
    }

    private static JFreeChart createChart(IntervalXYDataset intervalXYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYLineChart((String)"YIntervalChartDemo2", (String)"Date", (String)"Value", (XYDataset)intervalXYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        xYPlot.setDomainAxis((ValueAxis)new DateAxis("Date"));
        NumberAxis numberAxis = (NumberAxis)xYPlot.getRangeAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberAxis.setAutoRangeIncludesZero(false);
        XYErrorRenderer xYErrorRenderer = new XYErrorRenderer();
        xYErrorRenderer.setBaseLinesVisible(true);
        xYErrorRenderer.setUseFillPaint(true);
        xYErrorRenderer.setBaseFillPaint((Paint)Color.white);
        xYPlot.setRenderer((XYItemRenderer)xYErrorRenderer);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = YIntervalChartDemo2.createChart(YIntervalChartDemo2.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        YIntervalChartDemo2 yIntervalChartDemo2 = new YIntervalChartDemo2("JFreeChart: YIntervalChartDemo2.java");
        yIntervalChartDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)yIntervalChartDemo2));
        yIntervalChartDemo2.setVisible(true);
    }
}

