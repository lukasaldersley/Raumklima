/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.DateTickUnit
 *  org.jfree.chart.axis.DateTickUnitType
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.StandardXYItemRenderer
 *  org.jfree.chart.renderer.xy.XYBarRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.time.Day
 *  org.jfree.data.time.Hour
 *  org.jfree.data.time.Minute
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.DateTickUnitType;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Minute;
import org.jfree.data.time.SimpleTimePeriod;
import org.jfree.data.time.TimePeriod;
import org.jfree.data.time.TimePeriodValues;
import org.jfree.data.time.TimePeriodValuesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimePeriodValuesDemo1
extends ApplicationFrame {
    public TimePeriodValuesDemo1(String string) {
        super(string);
        XYDataset xYDataset = this.createDataset1();
        XYBarRenderer xYBarRenderer = new XYBarRenderer();
        DateAxis dateAxis = new DateAxis("Date");
        dateAxis.setVerticalTickLabels(true);
        dateAxis.setTickUnit(new DateTickUnit(DateTickUnitType.HOUR, 1));
        dateAxis.setDateFormatOverride((DateFormat)new SimpleDateFormat("hh:mm"));
        dateAxis.setLowerMargin(0.01);
        dateAxis.setUpperMargin(0.01);
        NumberAxis numberAxis = new NumberAxis("Value");
        XYPlot xYPlot = new XYPlot(xYDataset, (ValueAxis)dateAxis, (ValueAxis)numberAxis, (XYItemRenderer)xYBarRenderer);
        XYDataset xYDataset2 = this.createDataset2();
        StandardXYItemRenderer standardXYItemRenderer = new StandardXYItemRenderer(3);
        standardXYItemRenderer.setBaseShapesFilled(true);
        xYPlot.setDataset(1, xYDataset2);
        xYPlot.setRenderer(1, (XYItemRenderer)standardXYItemRenderer);
        JFreeChart jFreeChart = new JFreeChart("Supply and Demand", (Plot)xYPlot);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        chartPanel.setMouseZoomable(true);
        this.setContentPane((Container)chartPanel);
    }

    public XYDataset createDataset1() {
        TimePeriodValues timePeriodValues = new TimePeriodValues("Supply");
        TimePeriodValues timePeriodValues2 = new TimePeriodValues("Demand");
        Day day = new Day();
        for (int i = 0; i < 24; ++i) {
            Minute minute = new Minute(0, new Hour(i, day));
            Minute minute2 = new Minute(15, new Hour(i, day));
            Minute minute3 = new Minute(30, new Hour(i, day));
            Minute minute4 = new Minute(45, new Hour(i, day));
            Minute minute5 = new Minute(0, new Hour(i + 1, day));
            timePeriodValues.add((TimePeriod)new SimpleTimePeriod(minute.getStart(), minute2.getStart()), Math.random());
            timePeriodValues2.add((TimePeriod)new SimpleTimePeriod(minute2.getStart(), minute3.getStart()), Math.random());
            timePeriodValues.add((TimePeriod)new SimpleTimePeriod(minute3.getStart(), minute4.getStart()), Math.random());
            timePeriodValues2.add((TimePeriod)new SimpleTimePeriod(minute4.getStart(), minute5.getStart()), Math.random());
        }
        TimePeriodValuesCollection timePeriodValuesCollection = new TimePeriodValuesCollection();
        timePeriodValuesCollection.addSeries(timePeriodValues);
        timePeriodValuesCollection.addSeries(timePeriodValues2);
        return timePeriodValuesCollection;
    }

    public XYDataset createDataset2() {
        TimePeriodValues timePeriodValues = new TimePeriodValues("WebCOINS");
        Day day = new Day();
        for (int i = 0; i < 24; ++i) {
            Minute minute = new Minute(0, new Hour(i, day));
            Minute minute2 = new Minute(30, new Hour(i, day));
            Minute minute3 = new Minute(0, new Hour(i + 1, day));
            timePeriodValues.add((TimePeriod)new SimpleTimePeriod(minute.getStart(), minute2.getStart()), Math.random() * 2.0);
            timePeriodValues.add((TimePeriod)new SimpleTimePeriod(minute2.getStart(), minute3.getStart()), Math.random() * 2.0);
        }
        TimePeriodValuesCollection timePeriodValuesCollection = new TimePeriodValuesCollection();
        timePeriodValuesCollection.addSeries(timePeriodValues);
        return timePeriodValuesCollection;
    }

    public static void main(String[] arrstring) {
        TimePeriodValuesDemo1 timePeriodValuesDemo1 = new TimePeriodValuesDemo1("Time Period Values Demo 1");
        timePeriodValuesDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)timePeriodValuesDemo1));
        timePeriodValuesDemo1.setVisible(true);
    }
}

