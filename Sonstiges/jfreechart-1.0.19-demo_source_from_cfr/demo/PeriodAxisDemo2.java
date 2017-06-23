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
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
 *  org.jfree.data.time.Day
 *  org.jfree.data.time.Month
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimePeriodAnchor
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.time.Year
 *  org.jfree.data.xy.XYDataset
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
import java.util.TimeZone;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.PeriodAxis;
import org.jfree.chart.axis.PeriodAxisLabelInfo;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.Month;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimePeriodAnchor;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class PeriodAxisDemo2
extends ApplicationFrame {
    public PeriodAxisDemo2(String string) {
        super(string);
        XYDataset xYDataset = PeriodAxisDemo2.createDataset();
        JFreeChart jFreeChart = PeriodAxisDemo2.createChart(xYDataset);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        chartPanel.setMouseZoomable(true, true);
        this.setContentPane((Container)chartPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        XYLineAndShapeRenderer xYLineAndShapeRenderer;
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Legal & General Unit Trust Prices", (String)"Date", (String)"Price Per Unit", (XYDataset)xYDataset, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainCrosshairVisible(true);
        xYPlot.setRangeCrosshairVisible(true);
        XYItemRenderer xYItemRenderer = xYPlot.getRenderer();
        if (xYItemRenderer instanceof XYLineAndShapeRenderer) {
            xYLineAndShapeRenderer = (XYLineAndShapeRenderer)xYItemRenderer;
            xYLineAndShapeRenderer.setBaseShapesVisible(true);
            xYLineAndShapeRenderer.setBaseShapesFilled(true);
            xYLineAndShapeRenderer.setBaseItemLabelsVisible(true);
        }
        xYLineAndShapeRenderer = new PeriodAxis("Date");
        xYLineAndShapeRenderer.setTimeZone(TimeZone.getTimeZone("Pacific/Auckland"));
        xYLineAndShapeRenderer.setAutoRangeTimePeriodClass(Day.class);
        PeriodAxisLabelInfo[] arrperiodAxisLabelInfo = new PeriodAxisLabelInfo[]{new PeriodAxisLabelInfo(Day.class, (DateFormat)new SimpleDateFormat("d")), new PeriodAxisLabelInfo(Month.class, (DateFormat)new SimpleDateFormat("MMM"), new RectangleInsets(2.0, 2.0, 2.0, 2.0), new Font("SansSerif", 1, 10), (Paint)Color.blue, false, (Stroke)new BasicStroke(0.0f), (Paint)Color.lightGray), new PeriodAxisLabelInfo(Year.class, (DateFormat)new SimpleDateFormat("yyyy"))};
        xYLineAndShapeRenderer.setLabelInfo(arrperiodAxisLabelInfo);
        xYPlot.setDomainAxis((ValueAxis)xYLineAndShapeRenderer);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    private static XYDataset createDataset() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"L&G European Index Trust"));
        timeSeries.add((RegularTimePeriod)new Day(24, 1, 2004), 181.8);
        timeSeries.add((RegularTimePeriod)new Day(25, 1, 2004), 167.3);
        timeSeries.add((RegularTimePeriod)new Day(26, 1, 2004), 153.8);
        timeSeries.add((RegularTimePeriod)new Day(27, 1, 2004), 167.6);
        timeSeries.add((RegularTimePeriod)new Day(28, 1, 2004), 158.8);
        timeSeries.add((RegularTimePeriod)new Day(29, 1, 2004), 148.3);
        timeSeries.add((RegularTimePeriod)new Day(30, 1, 2004), 153.9);
        timeSeries.add((RegularTimePeriod)new Day(31, 1, 2004), 142.7);
        timeSeries.add((RegularTimePeriod)new Day(1, 2, 2004), 123.2);
        timeSeries.add((RegularTimePeriod)new Day(2, 2, 2004), 131.8);
        timeSeries.add((RegularTimePeriod)new Day(3, 2, 2004), 139.6);
        timeSeries.add((RegularTimePeriod)new Day(4, 2, 2004), 142.9);
        timeSeries.add((RegularTimePeriod)new Day(5, 2, 2004), 138.7);
        timeSeries.add((RegularTimePeriod)new Day(6, 2, 2004), 137.3);
        timeSeries.add((RegularTimePeriod)new Day(7, 2, 2004), 143.9);
        timeSeries.add((RegularTimePeriod)new Day(8, 2, 2004), 139.8);
        timeSeries.add((RegularTimePeriod)new Day(9, 2, 2004), 137.0);
        timeSeries.add((RegularTimePeriod)new Day(10, 2, 2004), 132.8);
        TimeZone timeZone = TimeZone.getTimeZone("Pacific/Auckland");
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection(timeZone);
        timeSeriesCollection.addSeries(timeSeries);
        timeSeriesCollection.setXPosition(TimePeriodAnchor.MIDDLE);
        return timeSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = PeriodAxisDemo2.createChart(PeriodAxisDemo2.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        PeriodAxisDemo2 periodAxisDemo2 = new PeriodAxisDemo2("JFreeChart: PeriodAxisDemo2.java");
        periodAxisDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)periodAxisDemo2));
        periodAxisDemo2.setVisible(true);
    }
}

