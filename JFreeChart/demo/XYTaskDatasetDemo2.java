/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.SymbolAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.CombinedDomainXYPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYBarRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
 *  org.jfree.data.gantt.Task
 *  org.jfree.data.gantt.TaskSeries
 *  org.jfree.data.gantt.TaskSeriesCollection
 *  org.jfree.data.gantt.XYTaskDataset
 *  org.jfree.data.time.Day
 *  org.jfree.data.time.Hour
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.IntervalXYDataset
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Window;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.gantt.XYTaskDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYTaskDatasetDemo2
extends ApplicationFrame {
    public XYTaskDatasetDemo2(String string) {
        super(string);
        JPanel jPanel = XYTaskDatasetDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 300));
        this.setContentPane((Container)jPanel);
    }

    private static XYPlot createSubplot1(XYDataset xYDataset) {
        XYLineAndShapeRenderer xYLineAndShapeRenderer = new XYLineAndShapeRenderer();
        xYLineAndShapeRenderer.setUseFillPaint(true);
        xYLineAndShapeRenderer.setBaseFillPaint((Paint)Color.white);
        xYLineAndShapeRenderer.setBaseShape((Shape)new Ellipse2D.Double(-4.0, -4.0, 8.0, 8.0));
        xYLineAndShapeRenderer.setAutoPopulateSeriesShape(false);
        NumberAxis numberAxis = new NumberAxis("Y");
        numberAxis.setLowerMargin(0.1);
        numberAxis.setUpperMargin(0.1);
        XYPlot xYPlot = new XYPlot(xYDataset, (ValueAxis)new DateAxis("Time"), (ValueAxis)numberAxis, (XYItemRenderer)xYLineAndShapeRenderer);
        return xYPlot;
    }

    private static XYPlot createSubplot2(IntervalXYDataset intervalXYDataset) {
        DateAxis dateAxis = new DateAxis("Date/Time");
        SymbolAxis symbolAxis = new SymbolAxis("Resources", new String[]{"Team A", "Team B", "Team C", "Team D", "Team E"});
        symbolAxis.setGridBandsVisible(false);
        XYBarRenderer xYBarRenderer = new XYBarRenderer();
        xYBarRenderer.setUseYInterval(true);
        XYPlot xYPlot = new XYPlot((XYDataset)intervalXYDataset, (ValueAxis)dateAxis, (ValueAxis)symbolAxis, (XYItemRenderer)xYBarRenderer);
        return xYPlot;
    }

    private static JFreeChart createChart() {
        CombinedDomainXYPlot combinedDomainXYPlot = new CombinedDomainXYPlot((ValueAxis)new DateAxis("Date/Time"));
        combinedDomainXYPlot.setDomainPannable(true);
        combinedDomainXYPlot.add(XYTaskDatasetDemo2.createSubplot1(XYTaskDatasetDemo2.createDataset1()));
        combinedDomainXYPlot.add(XYTaskDatasetDemo2.createSubplot2(XYTaskDatasetDemo2.createDataset2()));
        JFreeChart jFreeChart = new JFreeChart("XYTaskDatasetDemo2", (Plot)combinedDomainXYPlot);
        jFreeChart.setBackgroundPaint((Paint)Color.white);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        return new ChartPanel(XYTaskDatasetDemo2.createChart());
    }

    private static XYDataset createDataset1() {
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Time Series 1"));
        timeSeries.add((RegularTimePeriod)new Hour(0, new Day()), 20214.5);
        timeSeries.add((RegularTimePeriod)new Hour(4, new Day()), 73346.5);
        timeSeries.add((RegularTimePeriod)new Hour(8, new Day()), 54643.6);
        timeSeries.add((RegularTimePeriod)new Hour(12, new Day()), 92683.8);
        timeSeries.add((RegularTimePeriod)new Hour(16, new Day()), 110235.4);
        timeSeries.add((RegularTimePeriod)new Hour(20, new Day()), 120742.5);
        timeSeries.add((RegularTimePeriod)new Hour(24, new Day()), 90654.5);
        timeSeriesCollection.addSeries(timeSeries);
        return timeSeriesCollection;
    }

    private static IntervalXYDataset createDataset2() {
        XYTaskDataset xYTaskDataset = new XYTaskDataset(XYTaskDatasetDemo2.createTasks());
        xYTaskDataset.setTransposed(true);
        xYTaskDataset.setSeriesWidth(0.6);
        return xYTaskDataset;
    }

    private static TaskSeriesCollection createTasks() {
        TaskSeriesCollection taskSeriesCollection = new TaskSeriesCollection();
        TaskSeries taskSeries = new TaskSeries("Team A");
        taskSeries.add(new Task("T1a", (TimePeriod)new Hour(11, new Day())));
        taskSeries.add(new Task("T1b", (TimePeriod)new Hour(14, new Day())));
        taskSeries.add(new Task("T1c", (TimePeriod)new Hour(16, new Day())));
        TaskSeries taskSeries2 = new TaskSeries("Team B");
        taskSeries2.add(new Task("T2a", (TimePeriod)new Hour(13, new Day())));
        taskSeries2.add(new Task("T2b", (TimePeriod)new Hour(19, new Day())));
        taskSeries2.add(new Task("T2c", (TimePeriod)new Hour(21, new Day())));
        TaskSeries taskSeries3 = new TaskSeries("Team C");
        taskSeries3.add(new Task("T3a", (TimePeriod)new Hour(13, new Day())));
        taskSeries3.add(new Task("T3b", (TimePeriod)new Hour(19, new Day())));
        taskSeries3.add(new Task("T3c", (TimePeriod)new Hour(21, new Day())));
        TaskSeries taskSeries4 = new TaskSeries("Team D");
        taskSeries4.add(new Task("T4a", (TimePeriod)new Day()));
        TaskSeries taskSeries5 = new TaskSeries("Team E");
        taskSeries5.add(new Task("T5a", (TimePeriod)new Day()));
        taskSeriesCollection.add(taskSeries);
        taskSeriesCollection.add(taskSeries2);
        taskSeriesCollection.add(taskSeries3);
        taskSeriesCollection.add(taskSeries4);
        taskSeriesCollection.add(taskSeries5);
        return taskSeriesCollection;
    }

    public static void main(String[] arrstring) {
        XYTaskDatasetDemo2 xYTaskDatasetDemo2 = new XYTaskDatasetDemo2("JFreeChart : XYTaskDatasetDemo2.java");
        xYTaskDatasetDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)xYTaskDatasetDemo2));
        xYTaskDatasetDemo2.setVisible(true);
    }
}

