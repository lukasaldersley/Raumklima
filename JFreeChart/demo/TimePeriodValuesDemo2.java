/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYBarRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.time.Day
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.SimpleTimePeriod
 *  org.jfree.data.time.TimePeriod
 *  org.jfree.data.time.TimePeriodValues
 *  org.jfree.data.time.TimePeriodValuesCollection
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import java.util.Date;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.SimpleTimePeriod;
import org.jfree.data.time.TimePeriod;
import org.jfree.data.time.TimePeriodValues;
import org.jfree.data.time.TimePeriodValuesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimePeriodValuesDemo2
extends ApplicationFrame {
    public TimePeriodValuesDemo2(String string) {
        super(string);
        XYDataset xYDataset = this.createDataset();
        XYBarRenderer xYBarRenderer = new XYBarRenderer();
        DateAxis dateAxis = new DateAxis("Date");
        NumberAxis numberAxis = new NumberAxis("Value");
        XYPlot xYPlot = new XYPlot(xYDataset, (ValueAxis)dateAxis, (ValueAxis)numberAxis, (XYItemRenderer)xYBarRenderer);
        JFreeChart jFreeChart = new JFreeChart("Time Period Values Demo", (Plot)xYPlot);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        chartPanel.setMouseZoomable(true);
        this.setContentPane((Container)chartPanel);
    }

    public XYDataset createDataset() {
        TimePeriodValues timePeriodValues = new TimePeriodValues("Series 1");
        Day day = new Day();
        Day day2 = (Day)day.next();
        Day day3 = (Day)day2.next();
        Day day4 = (Day)day3.next();
        Day day5 = (Day)day4.next();
        Day day6 = (Day)day5.next();
        Day day7 = (Day)day6.next();
        timePeriodValues.add((TimePeriod)new SimpleTimePeriod(day6.getStart(), day6.getEnd()), 74.95);
        timePeriodValues.add((TimePeriod)new SimpleTimePeriod(day.getStart(), day2.getEnd()), 55.75);
        timePeriodValues.add((TimePeriod)new SimpleTimePeriod(day7.getStart(), day7.getEnd()), 90.45);
        timePeriodValues.add((TimePeriod)new SimpleTimePeriod(day3.getStart(), day5.getEnd()), 105.75);
        TimePeriodValuesCollection timePeriodValuesCollection = new TimePeriodValuesCollection();
        timePeriodValuesCollection.addSeries(timePeriodValues);
        return timePeriodValuesCollection;
    }

    public static void main(String[] arrstring) {
        TimePeriodValuesDemo2 timePeriodValuesDemo2 = new TimePeriodValuesDemo2("Time Period Values Demo 2");
        timePeriodValuesDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)timePeriodValuesDemo2));
        timePeriodValuesDemo2.setVisible(true);
    }
}

