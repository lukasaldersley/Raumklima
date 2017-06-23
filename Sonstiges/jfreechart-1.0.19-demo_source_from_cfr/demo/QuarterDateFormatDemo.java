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
 *  org.jfree.chart.axis.QuarterDateFormat
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
 *  org.jfree.data.time.Month
 *  org.jfree.data.time.Quarter
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RectangleInsets
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Window;
import java.text.DateFormat;
import java.util.TimeZone;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.PeriodAxis;
import org.jfree.chart.axis.PeriodAxisLabelInfo;
import org.jfree.chart.axis.QuarterDateFormat;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.Quarter;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class QuarterDateFormatDemo
extends ApplicationFrame {
    public QuarterDateFormatDemo(String string) {
        super(string);
        JPanel jPanel = QuarterDateFormatDemo.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Legal & General Unit Trust Prices", (String)"Date", (String)"Price Per Unit", (XYDataset)xYDataset, (boolean)true, (boolean)true, (boolean)false);
        jFreeChart.setBackgroundPaint((Paint)Color.white);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        PeriodAxis periodAxis = new PeriodAxis("Quarter", (RegularTimePeriod)new Quarter(), (RegularTimePeriod)new Quarter());
        periodAxis.setAutoRangeTimePeriodClass(Quarter.class);
        PeriodAxisLabelInfo[] arrperiodAxisLabelInfo = new PeriodAxisLabelInfo[]{new PeriodAxisLabelInfo(Quarter.class, (DateFormat)new QuarterDateFormat(TimeZone.getDefault(), QuarterDateFormat.ROMAN_QUARTERS))};
        periodAxis.setLabelInfo(arrperiodAxisLabelInfo);
        xYPlot.setDomainAxis((ValueAxis)periodAxis);
        xYPlot.setBackgroundPaint((Paint)Color.lightGray);
        xYPlot.setDomainGridlinePaint((Paint)Color.white);
        xYPlot.setRangeGridlinePaint((Paint)Color.white);
        xYPlot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        xYPlot.setDomainCrosshairVisible(true);
        xYPlot.setRangeCrosshairVisible(true);
        XYItemRenderer xYItemRenderer = xYPlot.getRenderer();
        if (xYItemRenderer instanceof XYLineAndShapeRenderer) {
            XYLineAndShapeRenderer xYLineAndShapeRenderer = (XYLineAndShapeRenderer)xYItemRenderer;
            xYLineAndShapeRenderer.setBaseShapesVisible(true);
            xYLineAndShapeRenderer.setBaseShapesFilled(true);
        }
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    private static XYDataset createDataset() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"L&G European Index Trust"));
        timeSeries.add((RegularTimePeriod)new Month(2, 2001), 181.8);
        timeSeries.add((RegularTimePeriod)new Month(3, 2001), 167.3);
        timeSeries.add((RegularTimePeriod)new Month(4, 2001), 153.8);
        timeSeries.add((RegularTimePeriod)new Month(5, 2001), 167.6);
        timeSeries.add((RegularTimePeriod)new Month(6, 2001), 158.8);
        timeSeries.add((RegularTimePeriod)new Month(7, 2001), 148.3);
        timeSeries.add((RegularTimePeriod)new Month(8, 2001), 153.9);
        timeSeries.add((RegularTimePeriod)new Month(9, 2001), 142.7);
        timeSeries.add((RegularTimePeriod)new Month(10, 2001), 123.2);
        timeSeries.add((RegularTimePeriod)new Month(11, 2001), 131.8);
        timeSeries.add((RegularTimePeriod)new Month(12, 2001), 139.6);
        timeSeries.add((RegularTimePeriod)new Month(1, 2002), 142.9);
        timeSeries.add((RegularTimePeriod)new Month(2, 2002), 138.7);
        timeSeries.add((RegularTimePeriod)new Month(3, 2002), 137.3);
        timeSeries.add((RegularTimePeriod)new Month(4, 2002), 143.9);
        timeSeries.add((RegularTimePeriod)new Month(5, 2002), 139.8);
        timeSeries.add((RegularTimePeriod)new Month(6, 2002), 137.0);
        timeSeries.add((RegularTimePeriod)new Month(7, 2002), 132.8);
        TimeSeries timeSeries2 = new TimeSeries((Comparable)((Object)"L&G UK Index Trust"));
        timeSeries2.add((RegularTimePeriod)new Month(2, 2001), 129.6);
        timeSeries2.add((RegularTimePeriod)new Month(3, 2001), 123.2);
        timeSeries2.add((RegularTimePeriod)new Month(4, 2001), 117.2);
        timeSeries2.add((RegularTimePeriod)new Month(5, 2001), 124.1);
        timeSeries2.add((RegularTimePeriod)new Month(6, 2001), 122.6);
        timeSeries2.add((RegularTimePeriod)new Month(7, 2001), 119.2);
        timeSeries2.add((RegularTimePeriod)new Month(8, 2001), 116.5);
        timeSeries2.add((RegularTimePeriod)new Month(9, 2001), 112.7);
        timeSeries2.add((RegularTimePeriod)new Month(10, 2001), 101.5);
        timeSeries2.add((RegularTimePeriod)new Month(11, 2001), 106.1);
        timeSeries2.add((RegularTimePeriod)new Month(12, 2001), 110.3);
        timeSeries2.add((RegularTimePeriod)new Month(1, 2002), 111.7);
        timeSeries2.add((RegularTimePeriod)new Month(2, 2002), 111.0);
        timeSeries2.add((RegularTimePeriod)new Month(3, 2002), 109.6);
        timeSeries2.add((RegularTimePeriod)new Month(4, 2002), 113.2);
        timeSeries2.add((RegularTimePeriod)new Month(5, 2002), 111.6);
        timeSeries2.add((RegularTimePeriod)new Month(6, 2002), 108.8);
        timeSeries2.add((RegularTimePeriod)new Month(7, 2002), 101.6);
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        timeSeriesCollection.addSeries(timeSeries);
        timeSeriesCollection.addSeries(timeSeries2);
        return timeSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = QuarterDateFormatDemo.createChart(QuarterDateFormatDemo.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        QuarterDateFormatDemo quarterDateFormatDemo = new QuarterDateFormatDemo("JFreeChart: QuarterDateFormatDemo.java");
        quarterDateFormatDemo.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)quarterDateFormatDemo));
        quarterDateFormatDemo.setVisible(true);
    }
}

