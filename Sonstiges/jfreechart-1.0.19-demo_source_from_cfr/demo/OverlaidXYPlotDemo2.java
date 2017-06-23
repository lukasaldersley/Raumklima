/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.DateTickMarkPosition
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.StandardXYToolTipGenerator
 *  org.jfree.chart.labels.XYToolTipGenerator
 *  org.jfree.chart.plot.DatasetRenderingOrder
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.StandardXYItemRenderer
 *  org.jfree.chart.renderer.xy.XYBarRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.time.Day
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimePeriodAnchor
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.IntervalXYDataset
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickMarkPosition;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimePeriodAnchor;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class OverlaidXYPlotDemo2
extends ApplicationFrame {
    public OverlaidXYPlotDemo2(String string) {
        super(string);
        JPanel jPanel = OverlaidXYPlotDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart() {
        DateAxis dateAxis = new DateAxis("Date");
        dateAxis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
        NumberAxis numberAxis = new NumberAxis("Value");
        IntervalXYDataset intervalXYDataset = OverlaidXYPlotDemo2.createDataset1();
        XYBarRenderer xYBarRenderer = new XYBarRenderer(0.2);
        xYBarRenderer.setBaseToolTipGenerator((XYToolTipGenerator)new StandardXYToolTipGenerator("{0}: ({1}, {2})", (DateFormat)new SimpleDateFormat("d-MMM-yyyy"), (NumberFormat)new DecimalFormat("0.00")));
        XYPlot xYPlot = new XYPlot((XYDataset)intervalXYDataset, (ValueAxis)dateAxis, (ValueAxis)numberAxis, (XYItemRenderer)xYBarRenderer);
        NumberAxis numberAxis2 = new NumberAxis("Value 2");
        xYPlot.setRangeAxis(1, (ValueAxis)numberAxis2);
        XYDataset xYDataset = OverlaidXYPlotDemo2.createDataset2A();
        StandardXYItemRenderer standardXYItemRenderer = new StandardXYItemRenderer();
        standardXYItemRenderer.setBaseToolTipGenerator((XYToolTipGenerator)new StandardXYToolTipGenerator("{0}: ({1}, {2})", (DateFormat)new SimpleDateFormat("d-MMM-yyyy"), (NumberFormat)new DecimalFormat("0.00")));
        xYPlot.setDataset(1, xYDataset);
        xYPlot.setRenderer(1, (XYItemRenderer)standardXYItemRenderer);
        XYDataset xYDataset2 = OverlaidXYPlotDemo2.createDataset2B();
        xYPlot.setDataset(2, xYDataset2);
        xYPlot.setRenderer(2, (XYItemRenderer)new StandardXYItemRenderer());
        xYPlot.mapDatasetToRangeAxis(2, 1);
        xYPlot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
        xYPlot.setOrientation(PlotOrientation.VERTICAL);
        JFreeChart jFreeChart = new JFreeChart("Overlaid XYPlot Demo 2", JFreeChart.DEFAULT_TITLE_FONT, (Plot)xYPlot, true);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    private static IntervalXYDataset createDataset1() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Series 1"));
        timeSeries.add((RegularTimePeriod)new Day(1, 3, 2002), 12353.3);
        timeSeries.add((RegularTimePeriod)new Day(2, 3, 2002), 13734.4);
        timeSeries.add((RegularTimePeriod)new Day(3, 3, 2002), 14525.3);
        timeSeries.add((RegularTimePeriod)new Day(4, 3, 2002), 13984.3);
        timeSeries.add((RegularTimePeriod)new Day(5, 3, 2002), 12999.4);
        timeSeries.add((RegularTimePeriod)new Day(6, 3, 2002), 14274.3);
        timeSeries.add((RegularTimePeriod)new Day(7, 3, 2002), 15943.5);
        timeSeries.add((RegularTimePeriod)new Day(8, 3, 2002), 14845.3);
        timeSeries.add((RegularTimePeriod)new Day(9, 3, 2002), 14645.4);
        timeSeries.add((RegularTimePeriod)new Day(10, 3, 2002), 16234.6);
        timeSeries.add((RegularTimePeriod)new Day(11, 3, 2002), 17232.3);
        timeSeries.add((RegularTimePeriod)new Day(12, 3, 2002), 14232.2);
        timeSeries.add((RegularTimePeriod)new Day(13, 3, 2002), 13102.2);
        timeSeries.add((RegularTimePeriod)new Day(14, 3, 2002), 14230.2);
        timeSeries.add((RegularTimePeriod)new Day(15, 3, 2002), 11235.2);
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection(timeSeries);
        return timeSeriesCollection;
    }

    private static XYDataset createDataset2A() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Series 2"));
        timeSeries.add((RegularTimePeriod)new Day(3, 3, 2002), 16853.2);
        timeSeries.add((RegularTimePeriod)new Day(4, 3, 2002), 19642.3);
        timeSeries.add((RegularTimePeriod)new Day(5, 3, 2002), 18253.5);
        timeSeries.add((RegularTimePeriod)new Day(6, 3, 2002), 15352.3);
        timeSeries.add((RegularTimePeriod)new Day(7, 3, 2002), 13532.0);
        timeSeries.add((RegularTimePeriod)new Day(8, 3, 2002), 12635.3);
        timeSeries.add((RegularTimePeriod)new Day(9, 3, 2002), 13998.2);
        timeSeries.add((RegularTimePeriod)new Day(10, 3, 2002), 11943.2);
        timeSeries.add((RegularTimePeriod)new Day(11, 3, 2002), 16943.9);
        timeSeries.add((RegularTimePeriod)new Day(12, 3, 2002), 17843.2);
        timeSeries.add((RegularTimePeriod)new Day(13, 3, 2002), 16495.3);
        timeSeries.add((RegularTimePeriod)new Day(14, 3, 2002), 17943.6);
        timeSeries.add((RegularTimePeriod)new Day(15, 3, 2002), 18500.7);
        timeSeries.add((RegularTimePeriod)new Day(16, 3, 2002), 19595.9);
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection(timeSeries);
        timeSeriesCollection.setXPosition(TimePeriodAnchor.MIDDLE);
        return timeSeriesCollection;
    }

    private static XYDataset createDataset2B() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Series 2B"));
        timeSeries.add((RegularTimePeriod)new Day(3, 3, 2002), 43.9);
        timeSeries.add((RegularTimePeriod)new Day(4, 3, 2002), 72.6);
        timeSeries.add((RegularTimePeriod)new Day(5, 3, 2002), 89.4);
        timeSeries.add((RegularTimePeriod)new Day(6, 3, 2002), 23.8);
        timeSeries.add((RegularTimePeriod)new Day(7, 3, 2002), 45.0);
        timeSeries.add((RegularTimePeriod)new Day(8, 3, 2002), 65.8);
        timeSeries.add((RegularTimePeriod)new Day(9, 3, 2002), 92.1);
        timeSeries.add((RegularTimePeriod)new Day(10, 3, 2002), 84.7);
        timeSeries.add((RegularTimePeriod)new Day(11, 3, 2002), 77.2);
        timeSeries.add((RegularTimePeriod)new Day(12, 3, 2002), 65.1);
        timeSeries.add((RegularTimePeriod)new Day(13, 3, 2002), 78.5);
        timeSeries.add((RegularTimePeriod)new Day(14, 3, 2002), 75.3);
        timeSeries.add((RegularTimePeriod)new Day(15, 3, 2002), 69.9);
        timeSeries.add((RegularTimePeriod)new Day(20, 3, 2002), 56.6);
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection(timeSeries);
        timeSeriesCollection.setXPosition(TimePeriodAnchor.MIDDLE);
        return timeSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = OverlaidXYPlotDemo2.createChart();
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        OverlaidXYPlotDemo2 overlaidXYPlotDemo2 = new OverlaidXYPlotDemo2("JFreeChart : OverlaidXYPlotDemo2.java");
        overlaidXYPlotDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)overlaidXYPlotDemo2));
        overlaidXYPlotDemo2.setVisible(true);
    }
}

