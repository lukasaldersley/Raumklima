/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.time.Day
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.date.SerialDate
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import demo.DemoPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Paint;
import java.awt.Window;
import java.util.Date;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.date.SerialDate;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesDemo11
extends ApplicationFrame {
    public TimeSeriesDemo11(String string) {
        super(string);
        this.setContentPane((Container)TimeSeriesDemo11.createDemoPanel());
    }

    private static JFreeChart createChart(String string, XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)string, (String)"Date", (String)"Price", (XYDataset)xYDataset, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setOrientation(PlotOrientation.VERTICAL);
        XYItemRenderer xYItemRenderer = xYPlot.getRenderer();
        xYItemRenderer.setSeriesPaint(0, (Paint)Color.blue);
        return jFreeChart;
    }

    private static XYDataset createDataset(String string, double d, RegularTimePeriod regularTimePeriod, int n) {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)string));
        RegularTimePeriod regularTimePeriod2 = regularTimePeriod;
        double d2 = d;
        for (int i = 0; i < n; ++i) {
            timeSeries.add(regularTimePeriod2, d2);
            regularTimePeriod2 = regularTimePeriod2.previous();
            d2 *= 1.0 + (Math.random() - 0.495) / 10.0;
        }
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        timeSeriesCollection.addSeries(timeSeries);
        return timeSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        DemoPanel demoPanel = new DemoPanel(new GridLayout(2, 2));
        demoPanel.setPreferredSize(new Dimension(800, 600));
        Day day = new Day();
        XYDataset xYDataset = TimeSeriesDemo11.createDataset("Series 1", 100.0, (RegularTimePeriod)day, 365);
        JFreeChart jFreeChart = TimeSeriesDemo11.createChart("Chart 1 : 1 Year", xYDataset);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        demoPanel.add((Component)chartPanel);
        JFreeChart jFreeChart2 = TimeSeriesDemo11.createChart("Chart 2 : 6 Months", xYDataset);
        SerialDate serialDate = day.getSerialDate();
        SerialDate serialDate2 = SerialDate.addMonths((int)-6, (SerialDate)serialDate);
        Day day2 = new Day(serialDate2);
        XYPlot xYPlot = (XYPlot)jFreeChart2.getPlot();
        DateAxis dateAxis = (DateAxis)xYPlot.getDomainAxis();
        dateAxis.setRange(day2.getStart(), day.getEnd());
        ChartPanel chartPanel2 = new ChartPanel(jFreeChart2);
        demoPanel.add((Component)chartPanel2);
        JFreeChart jFreeChart3 = TimeSeriesDemo11.createChart("Chart 3 : 3 Months", xYDataset);
        SerialDate serialDate3 = SerialDate.addMonths((int)-3, (SerialDate)serialDate);
        Day day3 = new Day(serialDate3);
        XYPlot xYPlot2 = (XYPlot)jFreeChart3.getPlot();
        DateAxis dateAxis2 = (DateAxis)xYPlot2.getDomainAxis();
        dateAxis2.setRange(day3.getStart(), day.getEnd());
        ChartPanel chartPanel3 = new ChartPanel(jFreeChart3);
        demoPanel.add((Component)chartPanel3);
        JFreeChart jFreeChart4 = TimeSeriesDemo11.createChart("Chart 4 : 1 Month", xYDataset);
        SerialDate serialDate4 = SerialDate.addMonths((int)-1, (SerialDate)serialDate);
        Day day4 = new Day(serialDate4);
        XYPlot xYPlot3 = (XYPlot)jFreeChart4.getPlot();
        DateAxis dateAxis3 = (DateAxis)xYPlot3.getDomainAxis();
        dateAxis3.setRange(day4.getStart(), day.getEnd());
        ChartPanel chartPanel4 = new ChartPanel(jFreeChart4);
        demoPanel.add((Component)chartPanel4);
        demoPanel.addChart(jFreeChart);
        demoPanel.addChart(jFreeChart2);
        demoPanel.addChart(jFreeChart3);
        demoPanel.addChart(jFreeChart4);
        return demoPanel;
    }

    public static void main(String[] arrstring) {
        TimeSeriesDemo11 timeSeriesDemo11 = new TimeSeriesDemo11("Time Series Demo 11");
        timeSeriesDemo11.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)timeSeriesDemo11));
        timeSeriesDemo11.setVisible(true);
    }
}

