/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.AxisLocation
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
 *  org.jfree.data.time.Day
 *  org.jfree.data.time.RegularTimePeriod
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
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class MultipleAxisDemo4
extends ApplicationFrame {
    public MultipleAxisDemo4(String string) {
        super(string);
        JPanel jPanel = MultipleAxisDemo4.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(600, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart() {
        XYDataset xYDataset = MultipleAxisDemo4.createDataset("March 2007", 100.0, (RegularTimePeriod)new Day(1, 3, 2007), 31);
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Multiple Axis Demo 4", (String)"Date", (String)"Value", (XYDataset)xYDataset, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setOrientation(PlotOrientation.VERTICAL);
        DateAxis dateAxis = (DateAxis)xYPlot.getDomainAxis();
        dateAxis.setDateFormatOverride((DateFormat)new SimpleDateFormat("d-MMM-yyyy"));
        XYItemRenderer xYItemRenderer = xYPlot.getRenderer();
        xYItemRenderer.setSeriesPaint(0, (Paint)Color.red);
        NumberAxis numberAxis = (NumberAxis)xYPlot.getRangeAxis();
        numberAxis.setTickLabelPaint((Paint)Color.red);
        DateAxis dateAxis2 = new DateAxis("Date");
        dateAxis2.setDateFormatOverride((DateFormat)new SimpleDateFormat("d-MMM-yyyy"));
        xYPlot.setDomainAxis(1, (ValueAxis)dateAxis2);
        xYPlot.setDomainAxisLocation(1, AxisLocation.TOP_OR_LEFT);
        NumberAxis numberAxis2 = new NumberAxis("Value");
        numberAxis2.setAutoRangeIncludesZero(false);
        numberAxis2.setTickLabelPaint((Paint)Color.blue);
        xYPlot.setRangeAxis(1, (ValueAxis)numberAxis2);
        xYPlot.setRangeAxisLocation(1, AxisLocation.BOTTOM_OR_RIGHT);
        XYDataset xYDataset2 = MultipleAxisDemo4.createDataset("July 2007", 1000.0, (RegularTimePeriod)new Day(1, 7, 2007), 31);
        xYPlot.setDataset(1, xYDataset2);
        xYPlot.mapDatasetToDomainAxis(1, 1);
        xYPlot.mapDatasetToRangeAxis(1, 1);
        XYLineAndShapeRenderer xYLineAndShapeRenderer = new XYLineAndShapeRenderer(true, false);
        xYLineAndShapeRenderer.setSeriesPaint(0, (Paint)Color.blue);
        xYPlot.setRenderer(1, (XYItemRenderer)xYLineAndShapeRenderer);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    private static XYDataset createDataset(String string, double d, RegularTimePeriod regularTimePeriod, int n) {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)string));
        RegularTimePeriod regularTimePeriod2 = regularTimePeriod;
        double d2 = d;
        for (int i = 0; i < n; ++i) {
            timeSeries.add(regularTimePeriod2, d2);
            regularTimePeriod2 = regularTimePeriod2.next();
            d2 *= 1.0 + (Math.random() - 0.495) / 10.0;
        }
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        timeSeriesCollection.addSeries(timeSeries);
        return timeSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = MultipleAxisDemo4.createChart();
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        MultipleAxisDemo4 multipleAxisDemo4 = new MultipleAxisDemo4("JFreeChart: MultipleAxisDemo4.java");
        multipleAxisDemo4.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)multipleAxisDemo4));
        multipleAxisDemo4.setVisible(true);
    }
}

