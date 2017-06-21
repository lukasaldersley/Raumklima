/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYBarRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.util.RelativeDateFormat
 *  org.jfree.data.time.Day
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.IntervalXYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.util.RelativeDateFormat;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class RelativeDateFormatDemo2
extends ApplicationFrame {
    public RelativeDateFormatDemo2(String string) {
        super(string);
        JPanel jPanel = RelativeDateFormatDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(IntervalXYDataset intervalXYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYBarChart((String)"RelativeDateFormat Demo 2", (String)"Date ", (boolean)true, (String)"Time To Complete", (IntervalXYDataset)intervalXYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainCrosshairVisible(true);
        xYPlot.setRangeCrosshairVisible(true);
        XYBarRenderer xYBarRenderer = (XYBarRenderer)xYPlot.getRenderer();
        xYBarRenderer.setDrawBarOutline(false);
        DateAxis dateAxis = new DateAxis();
        RelativeDateFormat relativeDateFormat = new RelativeDateFormat();
        relativeDateFormat.setShowZeroDays(false);
        relativeDateFormat.setSecondFormatter((NumberFormat)new DecimalFormat("00"));
        dateAxis.setDateFormatOverride((DateFormat)relativeDateFormat);
        xYPlot.setRangeAxis((ValueAxis)dateAxis);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    private static IntervalXYDataset createDataset() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Completion"));
        timeSeries.add((RegularTimePeriod)new Day(19, 1, 2007), 3343000.0);
        timeSeries.add((RegularTimePeriod)new Day(20, 1, 2007), 3420000.0);
        timeSeries.add((RegularTimePeriod)new Day(21, 1, 2007), 3515000.0);
        timeSeries.add((RegularTimePeriod)new Day(22, 1, 2007), 3315000.0);
        timeSeries.add((RegularTimePeriod)new Day(23, 1, 2007), 3490000.0);
        timeSeries.add((RegularTimePeriod)new Day(24, 1, 2007), 3556000.0);
        timeSeries.add((RegularTimePeriod)new Day(25, 1, 2007), 3383000.0);
        timeSeries.add((RegularTimePeriod)new Day(26, 1, 2007), 3575000.0);
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        timeSeriesCollection.addSeries(timeSeries);
        return timeSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = RelativeDateFormatDemo2.createChart(RelativeDateFormatDemo2.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        RelativeDateFormatDemo2 relativeDateFormatDemo2 = new RelativeDateFormatDemo2("JFreeChart: RelativeDateFormatDemo2.java");
        relativeDateFormatDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)relativeDateFormatDemo2));
        relativeDateFormatDemo2.setVisible(true);
    }
}

