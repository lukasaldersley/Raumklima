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
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.IntervalMarker
 *  org.jfree.chart.plot.Marker
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.renderer.category.GanttRenderer
 *  org.jfree.data.Range
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.IntervalCategoryDataset
 *  org.jfree.data.gantt.GanttCategoryDataset
 *  org.jfree.data.gantt.SlidingGanttCategoryDataset
 *  org.jfree.data.gantt.Task
 *  org.jfree.data.gantt.TaskSeries
 *  org.jfree.data.gantt.TaskSeriesCollection
 *  org.jfree.data.general.DatasetUtilities
 *  org.jfree.data.time.Day
 *  org.jfree.data.time.Hour
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.Layer
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Paint;
import java.awt.Window;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.BoundedRangeModel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.GanttRenderer;
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.GanttCategoryDataset;
import org.jfree.data.gantt.SlidingGanttCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.Layer;
import org.jfree.ui.RefineryUtilities;

public class SlidingGanttDatasetDemo1
extends ApplicationFrame {
    public SlidingGanttDatasetDemo1(String string) {
        super(string);
        this.setDefaultCloseOperation(3);
        this.setContentPane((Container)SlidingGanttDatasetDemo1.createDemoPanel());
    }

    public static JPanel createDemoPanel() {
        return new DemoPanel();
    }

    public static void main(String[] arrstring) {
        SlidingGanttDatasetDemo1 slidingGanttDatasetDemo1 = new SlidingGanttDatasetDemo1("JFreeChart: SlidingGanttDatasetDemo1.java");
        slidingGanttDatasetDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)slidingGanttDatasetDemo1));
        slidingGanttDatasetDemo1.setVisible(true);
    }

    static class DemoPanel
    extends JPanel
    implements ChangeListener {
        JScrollBar scroller;
        SlidingGanttCategoryDataset dataset = new SlidingGanttCategoryDataset(DemoPanel.createDataset(), 0, 15);

        public DemoPanel() {
            super(new BorderLayout());
            JFreeChart jFreeChart = DemoPanel.createChart(this.dataset);
            ChartPanel chartPanel = new ChartPanel(jFreeChart);
            chartPanel.setPreferredSize(new Dimension(400, 400));
            this.scroller = new JScrollBar(1, 0, 15, 0, 50);
            this.add((Component)chartPanel);
            this.scroller.getModel().addChangeListener(this);
            JPanel jPanel = new JPanel(new BorderLayout());
            jPanel.add(this.scroller);
            jPanel.setBorder(BorderFactory.createEmptyBorder(66, 2, 2, 2));
            this.add((Component)jPanel, "East");
        }

        public static GanttCategoryDataset createDataset() {
            TaskSeries taskSeries = new TaskSeries("Scheduled");
            Day day = new Day();
            Day day2 = new Day();
            for (int i = 0; i < 50; ++i) {
                int n = (int)(Math.random() * 10.0) + 1;
                for (int j = 0; j < n; ++j) {
                    day2 = (Day)day2.next();
                }
                taskSeries.add(new Task("Task " + i, new Date(day.getMiddleMillisecond()), new Date(day2.getMiddleMillisecond())));
                day = (Day)day2.next();
                day2 = (Day)day2.next();
            }
            TaskSeriesCollection taskSeriesCollection = new TaskSeriesCollection();
            taskSeriesCollection.add(taskSeries);
            return taskSeriesCollection;
        }

        private static JFreeChart createChart(SlidingGanttCategoryDataset slidingGanttCategoryDataset) {
            IntervalMarker intervalMarker;
            JFreeChart jFreeChart = ChartFactory.createGanttChart((String)"Gantt Chart Demo", (String)"Task", (String)"Date", (IntervalCategoryDataset)slidingGanttCategoryDataset, (boolean)true, (boolean)true, (boolean)false);
            CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
            Hour hour = new Hour(1, 14, 5, 2008);
            for (int i = 0; i < 12; ++i) {
                intervalMarker = new IntervalMarker((double)hour.getFirstMillisecond(), (double)hour.getLastMillisecond(), (Paint)Color.lightGray);
                categoryPlot.addRangeMarker((Marker)intervalMarker, Layer.BACKGROUND);
                hour = (Hour)hour.next().next();
            }
            categoryPlot.getDomainAxis().setMaximumCategoryLabelWidthRatio(10.0f);
            DateAxis dateAxis = (DateAxis)categoryPlot.getRangeAxis();
            dateAxis.setRange(DatasetUtilities.findRangeBounds((CategoryDataset)slidingGanttCategoryDataset.getUnderlyingDataset(), (boolean)true));
            intervalMarker = (GanttRenderer)categoryPlot.getRenderer();
            intervalMarker.setDrawBarOutline(false);
            intervalMarker.setShadowVisible(false);
            return jFreeChart;
        }

        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            this.dataset.setFirstCategoryIndex(this.scroller.getValue());
        }
    }

}

