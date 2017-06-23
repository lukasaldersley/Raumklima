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
 *  org.jfree.data.gantt.Task
 *  org.jfree.data.gantt.TaskSeries
 *  org.jfree.data.gantt.TaskSeriesCollection
 *  org.jfree.data.gantt.XYTaskDataset
 *  org.jfree.data.time.Day
 *  org.jfree.data.time.Hour
 *  org.jfree.data.time.TimePeriod
 *  org.jfree.data.xy.IntervalXYDataset
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
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.gantt.XYTaskDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.TimePeriod;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYTaskDatasetDemo1
extends ApplicationFrame {
    public XYTaskDatasetDemo1(String string) {
        super(string);
        JPanel jPanel = XYTaskDatasetDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 300));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(IntervalXYDataset intervalXYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYBarChart((String)"XYTaskDatasetDemo1", (String)"Resource", (boolean)false, (String)"Timing", (IntervalXYDataset)intervalXYDataset, (PlotOrientation)PlotOrientation.HORIZONTAL, (boolean)true, (boolean)false, (boolean)false);
        jFreeChart.setBackgroundPaint((Paint)Color.white);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setRangePannable(true);
        SymbolAxis symbolAxis = new SymbolAxis("Series", new String[]{"Team A", "Team B", "Team C", "Team D"});
        symbolAxis.setGridBandsVisible(false);
        xYPlot.setDomainAxis((ValueAxis)symbolAxis);
        XYBarRenderer xYBarRenderer = (XYBarRenderer)xYPlot.getRenderer();
        xYBarRenderer.setUseYInterval(true);
        xYPlot.setRangeAxis((ValueAxis)new DateAxis("Timing"));
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = XYTaskDatasetDemo1.createChart(XYTaskDatasetDemo1.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    private static IntervalXYDataset createDataset() {
        return new XYTaskDataset(XYTaskDatasetDemo1.createTasks());
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
        taskSeriesCollection.add(taskSeries);
        taskSeriesCollection.add(taskSeries2);
        taskSeriesCollection.add(taskSeries3);
        taskSeriesCollection.add(taskSeries4);
        return taskSeriesCollection;
    }

    public static void main(String[] arrstring) {
        XYTaskDatasetDemo1 xYTaskDatasetDemo1 = new XYTaskDatasetDemo1("JFreeChart : XYTaskDatasetDemo1.java");
        xYTaskDatasetDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)xYTaskDatasetDemo1));
        xYTaskDatasetDemo1.setVisible(true);
    }
}

