/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.DateTickUnit
 *  org.jfree.chart.axis.DateTickUnitType
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.StandardXYSeriesLabelGenerator
 *  org.jfree.chart.labels.XYSeriesLabelGenerator
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
 *  org.jfree.data.time.Month
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
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.DateTickUnitType;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardXYSeriesLabelGenerator;
import org.jfree.chart.labels.XYSeriesLabelGenerator;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesDemo3
extends ApplicationFrame {
    public TimeSeriesDemo3(String string) {
        super(string);
        XYDataset xYDataset = TimeSeriesDemo3.createDataset();
        JFreeChart jFreeChart = TimeSeriesDemo3.createChart(xYDataset);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)chartPanel);
    }

    private static XYDataset createDataset() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Series 1"));
        timeSeries.add((RegularTimePeriod)new Month(1, 2002), 500.2);
        timeSeries.add((RegularTimePeriod)new Month(2, 2002), 694.1);
        timeSeries.add((RegularTimePeriod)new Month(3, 2002), 734.4);
        timeSeries.add((RegularTimePeriod)new Month(4, 2002), 453.2);
        timeSeries.add((RegularTimePeriod)new Month(5, 2002), 500.2);
        timeSeries.add((RegularTimePeriod)new Month(6, 2002), 345.6);
        timeSeries.add((RegularTimePeriod)new Month(7, 2002), 500.2);
        timeSeries.add((RegularTimePeriod)new Month(8, 2002), 694.1);
        timeSeries.add((RegularTimePeriod)new Month(9, 2002), 734.4);
        timeSeries.add((RegularTimePeriod)new Month(10, 2002), 453.2);
        timeSeries.add((RegularTimePeriod)new Month(11, 2002), 500.2);
        timeSeries.add((RegularTimePeriod)new Month(12, 2002), 345.6);
        TimeSeries timeSeries2 = new TimeSeries((Comparable)((Object)"Series 2"));
        timeSeries2.add((RegularTimePeriod)new Month(1, 2002), 234.1);
        timeSeries2.add((RegularTimePeriod)new Month(2, 2002), 623.7);
        timeSeries2.add((RegularTimePeriod)new Month(3, 2002), 642.5);
        timeSeries2.add((RegularTimePeriod)new Month(4, 2002), 651.4);
        timeSeries2.add((RegularTimePeriod)new Month(5, 2002), 643.5);
        timeSeries2.add((RegularTimePeriod)new Month(6, 2002), 785.6);
        timeSeries2.add((RegularTimePeriod)new Month(7, 2002), 234.1);
        timeSeries2.add((RegularTimePeriod)new Month(8, 2002), 623.7);
        timeSeries2.add((RegularTimePeriod)new Month(9, 2002), 642.5);
        timeSeries2.add((RegularTimePeriod)new Month(10, 2002), 651.4);
        timeSeries2.add((RegularTimePeriod)new Month(11, 2002), 643.5);
        timeSeries2.add((RegularTimePeriod)new Month(12, 2002), 785.6);
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        timeSeriesCollection.addSeries(timeSeries);
        timeSeriesCollection.addSeries(timeSeries2);
        return timeSeriesCollection;
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Time Series Demo 3", (String)"Time", (String)"Value", (XYDataset)xYDataset, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        DateAxis dateAxis = (DateAxis)xYPlot.getDomainAxis();
        dateAxis.setTickUnit(new DateTickUnit(DateTickUnitType.MONTH, 1, (DateFormat)new SimpleDateFormat("MMM-yyyy")));
        dateAxis.setVerticalTickLabels(true);
        XYLineAndShapeRenderer xYLineAndShapeRenderer = (XYLineAndShapeRenderer)xYPlot.getRenderer();
        xYLineAndShapeRenderer.setBaseShapesVisible(true);
        xYLineAndShapeRenderer.setSeriesFillPaint(0, (Paint)Color.red);
        xYLineAndShapeRenderer.setSeriesFillPaint(1, (Paint)Color.white);
        xYLineAndShapeRenderer.setUseFillPaint(true);
        xYLineAndShapeRenderer.setLegendItemToolTipGenerator((XYSeriesLabelGenerator)new StandardXYSeriesLabelGenerator("Tooltip {0}"));
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = TimeSeriesDemo3.createChart(TimeSeriesDemo3.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        TimeSeriesDemo3 timeSeriesDemo3 = new TimeSeriesDemo3("Time Series Demo 3");
        timeSeriesDemo3.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)timeSeriesDemo3));
        timeSeriesDemo3.setVisible(true);
    }
}

