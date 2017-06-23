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
import org.jfree.data.time.SimpleTimePeriod;
import org.jfree.data.time.TimePeriod;
import org.jfree.data.time.TimePeriodValues;
import org.jfree.data.time.TimePeriodValuesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimePeriodValuesDemo3
extends ApplicationFrame {
    public TimePeriodValuesDemo3(String string) {
        super(string);
        XYDataset xYDataset = this.createDataset();
        XYBarRenderer xYBarRenderer = new XYBarRenderer();
        xYBarRenderer.setDrawBarOutline(false);
        DateAxis dateAxis = new DateAxis("Date");
        NumberAxis numberAxis = new NumberAxis("Value");
        XYPlot xYPlot = new XYPlot(xYDataset, (ValueAxis)dateAxis, (ValueAxis)numberAxis, (XYItemRenderer)xYBarRenderer);
        JFreeChart jFreeChart = new JFreeChart("Time Period Values Demo 3", (Plot)xYPlot);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        chartPanel.setMouseZoomable(true);
        this.setContentPane((Container)chartPanel);
    }

    public XYDataset createDataset() {
        Date date;
        TimePeriodValues timePeriodValues = new TimePeriodValues("Series 1");
        DateFormat dateFormat = DateFormat.getInstance();
        try {
            date = dateFormat.parse("11/5/2003 0:00:00.000");
            Date date2 = dateFormat.parse("11/5/2003 0:15:00.000");
            Date date3 = dateFormat.parse("11/5/2003 0:30:00.000");
            Date date4 = dateFormat.parse("11/5/2003 0:45:00.000");
            Date date5 = dateFormat.parse("11/5/2003 1:00:00.001");
            Date date6 = dateFormat.parse("11/5/2003 1:14:59.999");
            Date date7 = dateFormat.parse("11/5/2003 1:30:00.000");
            Date date8 = dateFormat.parse("11/5/2003 1:45:00.000");
            Date date9 = dateFormat.parse("11/5/2003 2:00:00.000");
            Date date10 = dateFormat.parse("11/5/2003 2:15:00.000");
            timePeriodValues.add((TimePeriod)new SimpleTimePeriod(date, date2), 0.39);
            timePeriodValues.add((TimePeriod)new SimpleTimePeriod(date3, date4), 0.225);
            timePeriodValues.add((TimePeriod)new SimpleTimePeriod(date4, date5), 0.235);
            timePeriodValues.add((TimePeriod)new SimpleTimePeriod(date5, date6), 0.238);
            timePeriodValues.add((TimePeriod)new SimpleTimePeriod(date6, date7), 0.236);
            timePeriodValues.add((TimePeriod)new SimpleTimePeriod(date7, date8), 0.25);
            timePeriodValues.add((TimePeriod)new SimpleTimePeriod(date8, date9), 0.238);
            timePeriodValues.add((TimePeriod)new SimpleTimePeriod(date9, date10), 0.215);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        date = new TimePeriodValuesCollection();
        date.addSeries(timePeriodValues);
        return date;
    }

    public static void main(String[] arrstring) {
        TimePeriodValuesDemo3 timePeriodValuesDemo3 = new TimePeriodValuesDemo3("JFreeChart: TimePeriodValuesDemo3.java");
        timePeriodValuesDemo3.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)timePeriodValuesDemo3));
        timePeriodValuesDemo3.setVisible(true);
    }
}

