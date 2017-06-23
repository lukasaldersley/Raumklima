/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.data.category.IntervalCategoryDataset
 *  org.jfree.data.gantt.Task
 *  org.jfree.data.gantt.TaskSeries
 *  org.jfree.data.gantt.TaskSeriesCollection
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Window;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class GanttDemo2
extends ApplicationFrame {
    public GanttDemo2(String string) {
        super(string);
        JPanel jPanel = GanttDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(IntervalCategoryDataset intervalCategoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createGanttChart((String)"Gantt Chart Demo", (String)"Task", (String)"Date", (IntervalCategoryDataset)intervalCategoryDataset, (boolean)true, (boolean)true, (boolean)false);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setRangePannable(true);
        categoryPlot.getDomainAxis().setMaximumCategoryLabelWidthRatio(10.0f);
        CategoryItemRenderer categoryItemRenderer = categoryPlot.getRenderer();
        categoryItemRenderer.setSeriesPaint(0, (Paint)Color.blue);
        return jFreeChart;
    }

    private static IntervalCategoryDataset createDataset() {
        TaskSeries taskSeries = new TaskSeries("Scheduled");
        Task task = new Task("Write Proposal", GanttDemo2.date(1, 3, 2001), GanttDemo2.date(5, 3, 2001));
        task.setPercentComplete(1.0);
        taskSeries.add(task);
        Task task2 = new Task("Obtain Approval", GanttDemo2.date(9, 3, 2001), GanttDemo2.date(9, 3, 2001));
        task2.setPercentComplete(1.0);
        taskSeries.add(task2);
        Task task3 = new Task("Requirements Analysis", GanttDemo2.date(10, 3, 2001), GanttDemo2.date(5, 4, 2001));
        Task task4 = new Task("Requirements 1", GanttDemo2.date(10, 3, 2001), GanttDemo2.date(25, 3, 2001));
        task4.setPercentComplete(1.0);
        Task task5 = new Task("Requirements 2", GanttDemo2.date(1, 4, 2001), GanttDemo2.date(5, 4, 2001));
        task5.setPercentComplete(1.0);
        task3.addSubtask(task4);
        task3.addSubtask(task5);
        taskSeries.add(task3);
        Task task6 = new Task("Design Phase", GanttDemo2.date(6, 4, 2001), GanttDemo2.date(30, 4, 2001));
        Task task7 = new Task("Design 1", GanttDemo2.date(6, 4, 2001), GanttDemo2.date(10, 4, 2001));
        task7.setPercentComplete(1.0);
        Task task8 = new Task("Design 2", GanttDemo2.date(15, 4, 2001), GanttDemo2.date(20, 4, 2001));
        task8.setPercentComplete(1.0);
        Task task9 = new Task("Design 3", GanttDemo2.date(23, 4, 2001), GanttDemo2.date(30, 4, 2001));
        task9.setPercentComplete(0.5);
        task6.addSubtask(task7);
        task6.addSubtask(task8);
        task6.addSubtask(task9);
        taskSeries.add(task6);
        Task task10 = new Task("Design Signoff", GanttDemo2.date(2, 5, 2001), GanttDemo2.date(2, 5, 2001));
        taskSeries.add(task10);
        Task task11 = new Task("Alpha Implementation", GanttDemo2.date(3, 5, 2001), GanttDemo2.date(31, 6, 2001));
        task11.setPercentComplete(0.6);
        taskSeries.add(task11);
        Task task12 = new Task("Design Review", GanttDemo2.date(1, 7, 2001), GanttDemo2.date(8, 7, 2001));
        task12.setPercentComplete(0.0);
        taskSeries.add(task12);
        Task task13 = new Task("Revised Design Signoff", GanttDemo2.date(10, 7, 2001), GanttDemo2.date(10, 7, 2001));
        task13.setPercentComplete(0.0);
        taskSeries.add(task13);
        Task task14 = new Task("Beta Implementation", GanttDemo2.date(12, 7, 2001), GanttDemo2.date(12, 8, 2001));
        task14.setPercentComplete(0.0);
        taskSeries.add(task14);
        Task task15 = new Task("Testing", GanttDemo2.date(13, 8, 2001), GanttDemo2.date(31, 9, 2001));
        task15.setPercentComplete(0.0);
        taskSeries.add(task15);
        Task task16 = new Task("Final Implementation", GanttDemo2.date(1, 10, 2001), GanttDemo2.date(15, 10, 2001));
        task16.setPercentComplete(0.0);
        taskSeries.add(task16);
        Task task17 = new Task("Signoff", GanttDemo2.date(28, 10, 2001), GanttDemo2.date(30, 10, 2001));
        task17.setPercentComplete(0.0);
        taskSeries.add(task17);
        TaskSeriesCollection taskSeriesCollection = new TaskSeriesCollection();
        taskSeriesCollection.add(taskSeries);
        return taskSeriesCollection;
    }

    private static Date date(int n, int n2, int n3) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(n3, n2, n);
        Date date = calendar.getTime();
        return date;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = GanttDemo2.createChart(GanttDemo2.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        GanttDemo2 ganttDemo2 = new GanttDemo2("JFreeChart: GanttDemo2.java");
        ganttDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)ganttDemo2));
        ganttDemo2.setVisible(true);
    }
}

