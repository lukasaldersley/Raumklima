/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.PeriodAxis
 *  org.jfree.chart.axis.PeriodAxisLabelInfo
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.data.time.Day
 *  org.jfree.data.time.Month
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.IntervalXYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RectangleInsets
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.Window;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.PeriodAxis;
import org.jfree.chart.axis.PeriodAxisLabelInfo;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Day;
import org.jfree.data.time.Month;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class PeriodAxisDemo3
extends ApplicationFrame {
    public PeriodAxisDemo3(String string) {
        super(string);
        JPanel jPanel = PeriodAxisDemo3.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(IntervalXYDataset intervalXYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYBarChart((String)"Maximum Temperature", (String)"Day", (boolean)true, (String)"Temperature", (IntervalXYDataset)intervalXYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainCrosshairVisible(true);
        xYPlot.setRangeCrosshairVisible(true);
        PeriodAxis periodAxis = new PeriodAxis("Day");
        periodAxis.setAutoRangeTimePeriodClass(Day.class);
        PeriodAxisLabelInfo[] arrperiodAxisLabelInfo = new PeriodAxisLabelInfo[]{new PeriodAxisLabelInfo(Day.class, (DateFormat)new SimpleDateFormat("d")), new PeriodAxisLabelInfo(Day.class, (DateFormat)new SimpleDateFormat("E"), new RectangleInsets(2.0, 2.0, 2.0, 2.0), new Font("SansSerif", 1, 10), (Paint)Color.blue, false, (Stroke)new BasicStroke(0.0f), (Paint)Color.lightGray), new PeriodAxisLabelInfo(Month.class, (DateFormat)new SimpleDateFormat("MMM"))};
        periodAxis.setLabelInfo(arrperiodAxisLabelInfo);
        xYPlot.setDomainAxis((ValueAxis)periodAxis);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    private static IntervalXYDataset createDataset() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Temperature"));
        timeSeries.add((RegularTimePeriod)new Day(1, 4, 2006), 14.5);
        timeSeries.add((RegularTimePeriod)new Day(2, 4, 2006), 11.5);
        timeSeries.add((RegularTimePeriod)new Day(3, 4, 2006), 13.7);
        timeSeries.add((RegularTimePeriod)new Day(4, 4, 2006), 10.5);
        timeSeries.add((RegularTimePeriod)new Day(5, 4, 2006), 14.9);
        timeSeries.add((RegularTimePeriod)new Day(6, 4, 2006), 15.7);
        timeSeries.add((RegularTimePeriod)new Day(7, 4, 2006), 11.5);
        timeSeries.add((RegularTimePeriod)new Day(8, 4, 2006), 9.5);
        timeSeries.add((RegularTimePeriod)new Day(9, 4, 2006), 10.9);
        timeSeries.add((RegularTimePeriod)new Day(10, 4, 2006), 14.1);
        timeSeries.add((RegularTimePeriod)new Day(11, 4, 2006), 12.3);
        timeSeries.add((RegularTimePeriod)new Day(12, 4, 2006), 14.3);
        timeSeries.add((RegularTimePeriod)new Day(13, 4, 2006), 19.0);
        timeSeries.add((RegularTimePeriod)new Day(14, 4, 2006), 17.9);
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        timeSeriesCollection.addSeries(timeSeries);
        return timeSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = PeriodAxisDemo3.createChart(PeriodAxisDemo3.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        PeriodAxisDemo3 periodAxisDemo3 = new PeriodAxisDemo3("JFreeChart: PeriodAxisDemo3.java");
        periodAxisDemo3.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)periodAxisDemo3));
        periodAxisDemo3.setVisible(true);
    }
}

