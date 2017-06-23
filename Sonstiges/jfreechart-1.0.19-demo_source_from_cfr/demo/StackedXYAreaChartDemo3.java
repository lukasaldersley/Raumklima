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
 *  org.jfree.data.time.Day
 *  org.jfree.data.time.TimePeriod
 *  org.jfree.data.time.TimeTableXYDataset
 *  org.jfree.data.xy.TableXYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
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
import org.jfree.data.time.Day;
import org.jfree.data.time.TimePeriod;
import org.jfree.data.time.TimeTableXYDataset;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StackedXYAreaChartDemo3
extends ApplicationFrame {
    public StackedXYAreaChartDemo3(String string) {
        super(string);
        JPanel jPanel = StackedXYAreaChartDemo3.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static TableXYDataset createDataset() {
        TimeTableXYDataset timeTableXYDataset = new TimeTableXYDataset();
        timeTableXYDataset.add((TimePeriod)new Day(14, 2, 2007), 87.0, (Comparable)((Object)"Series 1"));
        timeTableXYDataset.add((TimePeriod)new Day(15, 2, 2007), 67.0, (Comparable)((Object)"Series 1"));
        timeTableXYDataset.add((TimePeriod)new Day(16, 2, 2007), 78.0, (Comparable)((Object)"Series 1"));
        timeTableXYDataset.add((TimePeriod)new Day(17, 2, 2007), 55.0, (Comparable)((Object)"Series 1"));
        timeTableXYDataset.add((TimePeriod)new Day(18, 2, 2007), 58.0, (Comparable)((Object)"Series 1"));
        timeTableXYDataset.add((TimePeriod)new Day(19, 2, 2007), 60.0, (Comparable)((Object)"Series 1"));
        timeTableXYDataset.add((TimePeriod)new Day(14, 2, 2007), 45.0, (Comparable)((Object)"Series 2"));
        timeTableXYDataset.add((TimePeriod)new Day(15, 2, 2007), 67.0, (Comparable)((Object)"Series 2"));
        timeTableXYDataset.add((TimePeriod)new Day(16, 2, 2007), 61.0, (Comparable)((Object)"Series 2"));
        timeTableXYDataset.add((TimePeriod)new Day(17, 2, 2007), 58.0, (Comparable)((Object)"Series 2"));
        timeTableXYDataset.add((TimePeriod)new Day(18, 2, 2007), 73.0, (Comparable)((Object)"Series 2"));
        timeTableXYDataset.add((TimePeriod)new Day(19, 2, 2007), 64.0, (Comparable)((Object)"Series 2"));
        timeTableXYDataset.add((TimePeriod)new Day(14, 2, 2007), 32.0, (Comparable)((Object)"Series 3"));
        timeTableXYDataset.add((TimePeriod)new Day(15, 2, 2007), 38.0, (Comparable)((Object)"Series 3"));
        timeTableXYDataset.add((TimePeriod)new Day(16, 2, 2007), 43.0, (Comparable)((Object)"Series 3"));
        timeTableXYDataset.add((TimePeriod)new Day(17, 2, 2007), 12.0, (Comparable)((Object)"Series 3"));
        timeTableXYDataset.add((TimePeriod)new Day(18, 2, 2007), 19.0, (Comparable)((Object)"Series 3"));
        timeTableXYDataset.add((TimePeriod)new Day(19, 2, 2007), 26.0, (Comparable)((Object)"Series 3"));
        return timeTableXYDataset;
    }

    private static JFreeChart createChart(TableXYDataset tableXYDataset) {
        JFreeChart jFreeChart = ChartFactory.createStackedXYAreaChart((String)"Stacked XY Area Chart Demo 3", (String)"X Value", (String)"Y Value", (TableXYDataset)tableXYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        DateAxis dateAxis = new DateAxis("Date");
        xYPlot.setDomainAxis((ValueAxis)dateAxis);
        dateAxis.setLowerMargin(0.0);
        dateAxis.setUpperMargin(0.0);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = StackedXYAreaChartDemo3.createChart(StackedXYAreaChartDemo3.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        StackedXYAreaChartDemo3 stackedXYAreaChartDemo3 = new StackedXYAreaChartDemo3("Stacked XY Area Chart Demo 3");
        stackedXYAreaChartDemo3.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)stackedXYAreaChartDemo3));
        stackedXYAreaChartDemo3.setVisible(true);
    }
}

