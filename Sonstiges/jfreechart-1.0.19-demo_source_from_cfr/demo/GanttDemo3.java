/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.CategoryItemLabelGenerator
 *  org.jfree.chart.labels.ItemLabelAnchor
 *  org.jfree.chart.labels.ItemLabelPosition
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.renderer.category.GanttRenderer
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.IntervalCategoryDataset
 *  org.jfree.data.gantt.Task
 *  org.jfree.data.gantt.TaskSeries
 *  org.jfree.data.gantt.TaskSeriesCollection
 *  org.jfree.data.time.SimpleTimePeriod
 *  org.jfree.data.time.TimePeriod
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.ui.TextAnchor
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.GanttRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.time.SimpleTimePeriod;
import org.jfree.data.time.TimePeriod;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class GanttDemo3
extends ApplicationFrame {
    public GanttDemo3(String string) {
        super(string);
        JPanel jPanel = GanttDemo3.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 370));
        this.setContentPane((Container)jPanel);
    }

    public static IntervalCategoryDataset createDataset() {
        TaskSeries taskSeries = new TaskSeries("Scheduled");
        taskSeries.add(new Task("Write Proposal", (TimePeriod)new SimpleTimePeriod(GanttDemo3.date(1, 3, 2001), GanttDemo3.date(5, 3, 2001))));
        taskSeries.add(new Task("Obtain Approval", (TimePeriod)new SimpleTimePeriod(GanttDemo3.date(9, 3, 2001), GanttDemo3.date(9, 3, 2001))));
        taskSeries.add(new Task("Requirements Analysis", (TimePeriod)new SimpleTimePeriod(GanttDemo3.date(10, 3, 2001), GanttDemo3.date(5, 4, 2001))));
        taskSeries.add(new Task("Design Phase", (TimePeriod)new SimpleTimePeriod(GanttDemo3.date(6, 4, 2001), GanttDemo3.date(30, 4, 2001))));
        taskSeries.add(new Task("Design Signoff", (TimePeriod)new SimpleTimePeriod(GanttDemo3.date(2, 5, 2001), GanttDemo3.date(2, 5, 2001))));
        taskSeries.add(new Task("Alpha Implementation", (TimePeriod)new SimpleTimePeriod(GanttDemo3.date(3, 5, 2001), GanttDemo3.date(31, 6, 2001))));
        taskSeries.add(new Task("Design Review", (TimePeriod)new SimpleTimePeriod(GanttDemo3.date(1, 7, 2001), GanttDemo3.date(8, 7, 2001))));
        taskSeries.add(new Task("Revised Design Signoff", (TimePeriod)new SimpleTimePeriod(GanttDemo3.date(10, 7, 2001), GanttDemo3.date(10, 7, 2001))));
        taskSeries.add(new Task("Beta Implementation", (TimePeriod)new SimpleTimePeriod(GanttDemo3.date(12, 7, 2001), GanttDemo3.date(12, 8, 2001))));
        taskSeries.add(new Task("Testing", (TimePeriod)new SimpleTimePeriod(GanttDemo3.date(13, 8, 2001), GanttDemo3.date(31, 9, 2001))));
        taskSeries.add(new Task("Final Implementation", (TimePeriod)new SimpleTimePeriod(GanttDemo3.date(1, 10, 2001), GanttDemo3.date(15, 10, 2001))));
        taskSeries.add(new Task("Signoff", (TimePeriod)new SimpleTimePeriod(GanttDemo3.date(28, 10, 2001), GanttDemo3.date(30, 10, 2001))));
        TaskSeries taskSeries2 = new TaskSeries("Actual");
        taskSeries2.add(new Task("Write Proposal", (TimePeriod)new SimpleTimePeriod(GanttDemo3.date(1, 3, 2001), GanttDemo3.date(5, 3, 2001))));
        taskSeries2.add(new Task("Obtain Approval", (TimePeriod)new SimpleTimePeriod(GanttDemo3.date(9, 3, 2001), GanttDemo3.date(9, 3, 2001))));
        taskSeries2.add(new Task("Requirements Analysis", (TimePeriod)new SimpleTimePeriod(GanttDemo3.date(10, 3, 2001), GanttDemo3.date(15, 4, 2001))));
        taskSeries2.add(new Task("Design Phase", (TimePeriod)new SimpleTimePeriod(GanttDemo3.date(15, 4, 2001), GanttDemo3.date(17, 5, 2001))));
        taskSeries2.add(new Task("Design Signoff", (TimePeriod)new SimpleTimePeriod(GanttDemo3.date(30, 5, 2001), GanttDemo3.date(30, 5, 2001))));
        taskSeries2.add(new Task("Alpha Implementation", (TimePeriod)new SimpleTimePeriod(GanttDemo3.date(1, 6, 2001), GanttDemo3.date(12, 8, 2001))));
        taskSeries2.add(new Task("Design Review", (TimePeriod)new SimpleTimePeriod(GanttDemo3.date(12, 8, 2001), GanttDemo3.date(22, 8, 2001))));
        taskSeries2.add(new Task("Revised Design Signoff", (TimePeriod)new SimpleTimePeriod(GanttDemo3.date(25, 8, 2001), GanttDemo3.date(27, 8, 2001))));
        taskSeries2.add(new Task("Beta Implementation", (TimePeriod)new SimpleTimePeriod(GanttDemo3.date(27, 8, 2001), GanttDemo3.date(30, 9, 2001))));
        taskSeries2.add(new Task("Testing", (TimePeriod)new SimpleTimePeriod(GanttDemo3.date(31, 9, 2001), GanttDemo3.date(17, 10, 2001))));
        taskSeries2.add(new Task("Final Implementation", (TimePeriod)new SimpleTimePeriod(GanttDemo3.date(18, 10, 2001), GanttDemo3.date(5, 11, 2001))));
        taskSeries2.add(new Task("Signoff", (TimePeriod)new SimpleTimePeriod(GanttDemo3.date(10, 11, 2001), GanttDemo3.date(11, 11, 2001))));
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
        JFreeChart jFreeChart = ChartFactory.createGanttChart((String)"Gantt Chart Demo", (String)"Task", (String)"Date", (IntervalCategoryDataset)intervalCategoryDataset);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setRangePannable(true);
        categoryPlot.getDomainAxis().setMaximumCategoryLabelWidthRatio(10.0f);
        DateAxis dateAxis = (DateAxis)categoryPlot.getRangeAxis();
        dateAxis.setUpperMargin(0.2);
        GanttRenderer ganttRenderer = (GanttRenderer)categoryPlot.getRenderer();
        ganttRenderer.setDrawBarOutline(false);
        ganttRenderer.setBaseItemLabelGenerator((CategoryItemLabelGenerator)new MyLabelGenerator(new SimpleDateFormat("d-MMM")));
        ganttRenderer.setBaseItemLabelsVisible(true);
        ganttRenderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE3, TextAnchor.CENTER_LEFT));
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = GanttDemo3.createChart(GanttDemo3.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        GanttDemo3 ganttDemo3 = new GanttDemo3("JFreeChart: GanttDemo3.java");
        ganttDemo3.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)ganttDemo3));
        ganttDemo3.setVisible(true);
    }

    static class MyLabelGenerator
    implements CategoryItemLabelGenerator {
        DateFormat df;

        public MyLabelGenerator(DateFormat dateFormat) {
            this.df = dateFormat;
        }

        public String generateLabel(CategoryDataset categoryDataset, int n, int n2) {
            Number number;
            if (categoryDataset instanceof IntervalCategoryDataset) {
                IntervalCategoryDataset intervalCategoryDataset = (IntervalCategoryDataset)categoryDataset;
                number = intervalCategoryDataset.getEndValue(n, n2);
            } else {
                number = categoryDataset.getValue(n, n2);
            }
            if (number == null) {
                return "null";
            }
            long l = number.longValue();
            Date date = new Date(l);
            return this.df.format(date);
        }

        public String generateColumnLabel(CategoryDataset categoryDataset, int n) {
            return categoryDataset.getColumnKey(n).toString();
        }

        public String generateRowLabel(CategoryDataset categoryDataset, int n) {
            return categoryDataset.getRowKey(n).toString();
        }
    }

}

