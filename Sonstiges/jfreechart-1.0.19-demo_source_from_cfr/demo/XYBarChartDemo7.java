/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.SymbolAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYBarRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.time.Day
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.xy.IntervalXYDataset
 *  org.jfree.data.xy.XYIntervalSeries
 *  org.jfree.data.xy.XYIntervalSeriesCollection
 *  org.jfree.ui.ApplicationFrame
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
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYIntervalSeries;
import org.jfree.data.xy.XYIntervalSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYBarChartDemo7
extends ApplicationFrame {
    public XYBarChartDemo7(String string) {
        super(string);
        JPanel jPanel = XYBarChartDemo7.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 300));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(IntervalXYDataset intervalXYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYBarChart((String)"XYBarChartDemo7", (String)"Date", (boolean)true, (String)"Y", (IntervalXYDataset)intervalXYDataset, (PlotOrientation)PlotOrientation.HORIZONTAL, (boolean)true, (boolean)false, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setRangePannable(true);
        xYPlot.setRangeAxis((ValueAxis)new DateAxis("Date"));
        SymbolAxis symbolAxis = new SymbolAxis("Series", new String[]{"S1", "S2", "S3"});
        symbolAxis.setGridBandsVisible(false);
        xYPlot.setDomainAxis((ValueAxis)symbolAxis);
        XYBarRenderer xYBarRenderer = (XYBarRenderer)xYPlot.getRenderer();
        xYBarRenderer.setUseYInterval(true);
        xYPlot.setRenderer((XYItemRenderer)xYBarRenderer);
        xYPlot.setBackgroundPaint((Paint)Color.lightGray);
        xYPlot.setDomainGridlinePaint((Paint)Color.white);
        xYPlot.setRangeGridlinePaint((Paint)Color.white);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    private static IntervalXYDataset createDataset() {
        Day day = new Day(12, 6, 2007);
        Day day2 = new Day(13, 6, 2007);
        Day day3 = new Day(14, 6, 2007);
        Day day4 = new Day(15, 6, 2007);
        Day day5 = new Day(16, 6, 2007);
        Day day6 = new Day(17, 6, 2007);
        XYIntervalSeriesCollection xYIntervalSeriesCollection = new XYIntervalSeriesCollection();
        XYIntervalSeries xYIntervalSeries = new XYIntervalSeries((Comparable)((Object)"S1"));
        XYIntervalSeries xYIntervalSeries2 = new XYIntervalSeries((Comparable)((Object)"S2"));
        XYIntervalSeries xYIntervalSeries3 = new XYIntervalSeries((Comparable)((Object)"S3"));
        XYBarChartDemo7.addItem(xYIntervalSeries, (RegularTimePeriod)day, (RegularTimePeriod)day2, 0);
        XYBarChartDemo7.addItem(xYIntervalSeries, (RegularTimePeriod)day4, (RegularTimePeriod)day4, 0);
        XYBarChartDemo7.addItem(xYIntervalSeries2, (RegularTimePeriod)day, (RegularTimePeriod)day6, 1);
        XYBarChartDemo7.addItem(xYIntervalSeries3, (RegularTimePeriod)day3, (RegularTimePeriod)day5, 2);
        xYIntervalSeriesCollection.addSeries(xYIntervalSeries);
        xYIntervalSeriesCollection.addSeries(xYIntervalSeries2);
        xYIntervalSeriesCollection.addSeries(xYIntervalSeries3);
        return xYIntervalSeriesCollection;
    }

    private static void addItem(XYIntervalSeries xYIntervalSeries, RegularTimePeriod regularTimePeriod, RegularTimePeriod regularTimePeriod2, int n) {
        xYIntervalSeries.add((double)n, (double)n - 0.45, (double)n + 0.45, (double)regularTimePeriod.getFirstMillisecond(), (double)regularTimePeriod.getFirstMillisecond(), (double)regularTimePeriod2.getLastMillisecond());
    }

    public static JPanel createDemoPanel() {
        return new ChartPanel(XYBarChartDemo7.createChart(XYBarChartDemo7.createDataset()));
    }

    public static void main(String[] arrstring) {
        XYBarChartDemo7 xYBarChartDemo7 = new XYBarChartDemo7("JFreeChart : XYBarChartDemo7.java");
        xYBarChartDemo7.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)xYBarChartDemo7));
        xYBarChartDemo7.setVisible(true);
    }
}

