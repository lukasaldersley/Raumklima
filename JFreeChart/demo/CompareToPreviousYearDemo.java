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
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
 *  org.jfree.data.time.Month
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimePeriodAnchor
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
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
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimePeriodAnchor;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class CompareToPreviousYearDemo
extends ApplicationFrame {
    public CompareToPreviousYearDemo(String string) {
        super(string);
        ChartPanel chartPanel = (ChartPanel)CompareToPreviousYearDemo.createDemoPanel();
        chartPanel.setPreferredSize(new Dimension(500, 270));
        chartPanel.setMouseZoomable(true, true);
        this.setContentPane((Container)chartPanel);
    }

    private static JFreeChart createChart() {
        XYDataset xYDataset = CompareToPreviousYearDemo.createDataset2006();
        XYDataset xYDataset2 = CompareToPreviousYearDemo.createDataset2007();
        DateAxis dateAxis = new DateAxis("Date");
        Month month = new Month(1, 2007);
        Month month2 = new Month(12, 2007);
        dateAxis.setRange((double)month.getFirstMillisecond(), (double)month2.getLastMillisecond());
        dateAxis.setDateFormatOverride((DateFormat)new SimpleDateFormat("MMM"));
        dateAxis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
        XYLineAndShapeRenderer xYLineAndShapeRenderer = new XYLineAndShapeRenderer();
        xYLineAndShapeRenderer.setUseFillPaint(true);
        xYLineAndShapeRenderer.setBaseFillPaint((Paint)Color.white);
        xYLineAndShapeRenderer.setBaseToolTipGenerator((XYToolTipGenerator)new StandardXYToolTipGenerator("{1}: {2}", (DateFormat)new SimpleDateFormat("MMM-yyyy"), (NumberFormat)new DecimalFormat("0.00")));
        XYPlot xYPlot = new XYPlot(xYDataset2, (ValueAxis)dateAxis, (ValueAxis)new NumberAxis("Sales"), (XYItemRenderer)xYLineAndShapeRenderer);
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        DateAxis dateAxis2 = new DateAxis();
        dateAxis2.setVisible(false);
        xYPlot.setDomainAxis(1, (ValueAxis)dateAxis2);
        xYPlot.setDataset(1, xYDataset);
        xYPlot.mapDatasetToDomainAxis(1, 1);
        XYLineAndShapeRenderer xYLineAndShapeRenderer2 = new XYLineAndShapeRenderer();
        xYLineAndShapeRenderer2.setSeriesPaint(0, (Paint)Color.blue);
        xYLineAndShapeRenderer2.setUseFillPaint(true);
        xYLineAndShapeRenderer2.setBaseFillPaint((Paint)Color.white);
        xYLineAndShapeRenderer2.setBaseToolTipGenerator((XYToolTipGenerator)new StandardXYToolTipGenerator("{1}: {2}", (DateFormat)new SimpleDateFormat("MMM-yyyy"), (NumberFormat)new DecimalFormat("0.00")));
        xYPlot.setRenderer(1, (XYItemRenderer)xYLineAndShapeRenderer2);
        JFreeChart jFreeChart = new JFreeChart("Sales Comparison Chart", (Plot)xYPlot);
        xYPlot.setDomainCrosshairVisible(true);
        xYPlot.setRangeCrosshairVisible(true);
        DateAxis dateAxis3 = (DateAxis)xYPlot.getDomainAxis();
        dateAxis3.setDateFormatOverride((DateFormat)new SimpleDateFormat("MMM-yyyy"));
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    private static XYDataset createDataset2006() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Sales 2006"));
        timeSeries.add((RegularTimePeriod)new Month(1, 2006), 100.0);
        timeSeries.add((RegularTimePeriod)new Month(2, 2006), 102.3);
        timeSeries.add((RegularTimePeriod)new Month(3, 2006), 105.7);
        timeSeries.add((RegularTimePeriod)new Month(4, 2006), 104.2);
        timeSeries.add((RegularTimePeriod)new Month(5, 2006), 114.7);
        timeSeries.add((RegularTimePeriod)new Month(6, 2006), 121.7);
        timeSeries.add((RegularTimePeriod)new Month(7, 2006), 155.6);
        timeSeries.add((RegularTimePeriod)new Month(8, 2006), 143.2);
        timeSeries.add((RegularTimePeriod)new Month(9, 2006), 131.9);
        timeSeries.add((RegularTimePeriod)new Month(10, 2006), 120.0);
        timeSeries.add((RegularTimePeriod)new Month(11, 2006), 109.9);
        timeSeries.add((RegularTimePeriod)new Month(12, 2006), 99.6);
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        timeSeriesCollection.addSeries(timeSeries);
        timeSeriesCollection.setXPosition(TimePeriodAnchor.MIDDLE);
        return timeSeriesCollection;
    }

    private static XYDataset createDataset2007() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Sales 2007"));
        timeSeries.add((RegularTimePeriod)new Month(1, 2007), 163.9);
        timeSeries.add((RegularTimePeriod)new Month(2, 2007), 163.8);
        timeSeries.add((RegularTimePeriod)new Month(3, 2007), 162.0);
        timeSeries.add((RegularTimePeriod)new Month(4, 2007), 167.1);
        timeSeries.add((RegularTimePeriod)new Month(5, 2007), 170.0);
        timeSeries.add((RegularTimePeriod)new Month(6, 2007), 175.7);
        timeSeries.add((RegularTimePeriod)new Month(7, 2007), 171.9);
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        timeSeriesCollection.addSeries(timeSeries);
        timeSeriesCollection.setXPosition(TimePeriodAnchor.MIDDLE);
        return timeSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = CompareToPreviousYearDemo.createChart();
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        CompareToPreviousYearDemo compareToPreviousYearDemo = new CompareToPreviousYearDemo("JFreeChart: CompareToPreviousYearDemo.java");
        compareToPreviousYearDemo.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)compareToPreviousYearDemo));
        compareToPreviousYearDemo.setVisible(true);
    }
}

