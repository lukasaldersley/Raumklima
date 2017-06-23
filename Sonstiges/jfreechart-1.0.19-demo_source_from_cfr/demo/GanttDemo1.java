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
 *  org.jfree.chart.renderer.category.GanttRenderer
 *  org.jfree.data.category.IntervalCategoryDataset
 *  org.jfree.data.gantt.Task
 *  org.jfree.data.gantt.TaskSeries
 *  org.jfree.data.gantt.TaskSeriesCollection
 *  org.jfree.data.time.SimpleTimePeriod
 *  org.jfree.data.time.TimePeriod
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
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
import org.jfree.chart.renderer.category.GanttRenderer;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.time.SimpleTimePeriod;
import org.jfree.data.time.TimePeriod;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class GanttDemo1
extends ApplicationFrame {
    public GanttDemo1(String string) {
        super(string);
        JPanel jPanel = GanttDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    public static IntervalCategoryDataset createDataset() {
        TaskSeries taskSeries = new TaskSeries("Scheduled");
        taskSeries.add(new Task("Write Proposal", (TimePeriod)new SimpleTimePeriod(GanttDemo1.date(1, 3, 2001), GanttDemo1.date(5, 3, 2001))));
        taskSeries.add(new Task("Obtain Approval", (TimePeriod)new SimpleTimePeriod(GanttDemo1.date(9, 3, 2001), GanttDemo1.date(9, 3, 2001))));
        taskSeries.add(new Task("Requirements Analysis", (TimePeriod)new SimpleTimePeriod(GanttDemo1.date(10, 3, 2001), GanttDemo1.date(5, 4, 2001))));
        taskSeries.add(new Task("Design Phase", (TimePeriod)new SimpleTimePeriod(GanttDemo1.date(6, 4, 2001), GanttDemo1.date(30, 4, 2001))));
        taskSeries.add(new Task("Design Signoff", (TimePeriod)new SimpleTimePeriod(GanttDemo1.date(2, 5, 2001), GanttDemo1.date(2, 5, 2001))));
        taskSeries.add(new Task("Alpha Implementation", (TimePeriod)new SimpleTimePeriod(GanttDemo1.date(3, 5, 2001), GanttDemo1.date(31, 6, 2001))));
        taskSeries.add(new Task("Design Review", (TimePeriod)new SimpleTimePeriod(GanttDemo1.date(1, 7, 2001), GanttDemo1.date(8, 7, 2001))));
        taskSeries.add(new Task("Revised Design Signoff", (TimePeriod)new SimpleTimePeriod(GanttDemo1.date(10, 7, 2001), GanttDemo1.date(10, 7, 2001))));
        taskSeries.add(new Task("Beta Implementation", (TimePeriod)new SimpleTimePeriod(GanttDemo1.date(12, 7, 2001), GanttDemo1.date(12, 8, 2001))));
        taskSeries.add(new Task("Testing", (TimePeriod)new SimpleTimePeriod(GanttDemo1.date(13, 8, 2001), GanttDemo1.date(31, 9, 2001))));
        taskSeries.add(new Task("Final Implementation", (TimePeriod)new SimpleTimePeriod(GanttDemo1.date(1, 10, 2001), GanttDemo1.date(15, 10, 2001))));
        taskSeries.add(new Task("Signoff", (TimePeriod)new SimpleTimePeriod(GanttDemo1.date(28, 10, 2001), GanttDemo1.date(30, 10, 2001))));
        TaskSeries taskSeries2 = new TaskSeries("Actual");
        taskSeries2.add(new Task("Write Proposal", (TimePeriod)new SimpleTimePeriod(GanttDemo1.date(1, 3, 2001), GanttDemo1.date(5, 3, 2001))));
        taskSeries2.add(new Task("Obtain Approval", (TimePeriod)new SimpleTimePeriod(GanttDemo1.date(9, 3, 2001), GanttDemo1.date(9, 3, 2001))));
        taskSeries2.add(new Task("Requirements Analysis", (TimePeriod)new SimpleTimePeriod(GanttDemo1.date(10, 3, 2001), GanttDemo1.date(15, 4, 2001))));
        taskSeries2.add(new Task("Design Phase", (TimePeriod)new SimpleTimePeriod(GanttDemo1.date(15, 4, 2001), GanttDemo1.date(17, 5, 2001))));
        taskSeries2.add(new Task("Design Signoff", (TimePeriod)new SimpleTimePeriod(GanttDemo1.date(30, 5, 2001), GanttDemo1.date(30, 5, 2001))));
        taskSeries2.add(new Task("Alpha Implementation", (TimePeriod)new SimpleTimePeriod(GanttDemo1.date(1, 6, 2001), GanttDemo1.date(12, 8, 2001))));
        taskSeries2.add(new Task("Design Review", (TimePeriod)new SimpleTimePeriod(GanttDemo1.date(12, 8, 2001), GanttDemo1.date(22, 8, 2001))));
        taskSeries2.add(new Task("Revised Design Signoff", (TimePeriod)new SimpleTimePeriod(GanttDemo1.date(25, 8, 2001), GanttDemo1.date(27, 8, 2001))));
        taskSeries2.add(new Task("Beta Implementation", (TimePeriod)new SimpleTimePeriod(GanttDemo1.date(27, 8, 2001), GanttDemo1.date(30, 9, 2001))));
        taskSeries2.add(new Task("Testing", (TimePeriod)new SimpleTimePeriod(GanttDemo1.date(31, 9, 2001), GanttDemo1.date(17, 10, 2001))));
        taskSeries2.add(new Task("Final Implementation", (TimePeriod)new SimpleTimePeriod(GanttDemo1.date(18, 10, 2001), GanttDemo1.date(5, 11, 2001))));
        taskSeries2.add(new Task("Signoff", (TimePeriod)new SimpleTimePeriod(GanttDemo1.date(10, 11, 2001), GanttDemo1.date(11, 11, 2001))));
        TaskSeriesCollection taskSeriesCollection = new TaskSeriesCollection();
        taskSeriesCollection.add(taskSeries);
        taskSeriesCollection.add(taskSeries2);
        return taskSeriesCollection;
    }

    private static Date date(int n, int n2, int n3) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(n3, n2, n);
        Date date = calendar.getTime();
        return date;
    }

    private static JFreeChart createChart(IntervalCategoryDataset intervalCategoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createGanttChart((String)"Gantt Chart Demo", (String)"Task", (String)"Date", (IntervalCategoryDataset)intervalCategoryDataset, (boolean)true, (boolean)true, (boolean)false);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setRangePannable(true);
        categoryPlot.getDomainAxis().setMaximumCategoryLabelWidthRatio(10.0f);
        categoryPlot.setRangeCrosshairVisible(true);
        GanttRenderer ganttRenderer = (GanttRenderer)categoryPlot.getRenderer();
        ganttRenderer.setDrawBarOutline(false);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = GanttDemo1.createChart(GanttDemo1.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        GanttDemo1 ganttDemo1 = new GanttDemo1("JFreeChart: GanttDemo1.java");
        ganttDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)ganttDemo1));
        ganttDemo1.setVisible(true);
    }
}

