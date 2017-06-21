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
 *  org.jfree.chart.labels.StandardXYToolTipGenerator
 *  org.jfree.chart.labels.XYToolTipGenerator
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.time.Day
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.XYDataset
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
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYAreaChartDemo2
extends ApplicationFrame {
    public XYAreaChartDemo2(String string) {
        super(string);
        JPanel jPanel = XYAreaChartDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static XYDataset createDataset() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Random 1"));
        double d = 0.0;
        Day day = new Day();
        for (int i = 0; i < 200; ++i) {
            d = d + Math.random() - 0.5;
            timeSeries.add((RegularTimePeriod)day, d);
            day = (Day)day.next();
        }
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection(timeSeries);
        return timeSeriesCollection;
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYAreaChart((String)"XY Area Chart Demo 2", (String)"Time", (String)"Value", (XYDataset)xYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainPannable(true);
        DateAxis dateAxis = new DateAxis("Time");
        dateAxis.setLowerMargin(0.0);
        dateAxis.setUpperMargin(0.0);
        xYPlot.setDomainAxis((ValueAxis)dateAxis);
        xYPlot.setForegroundAlpha(0.5f);
        XYItemRenderer xYItemRenderer = xYPlot.getRenderer();
        xYItemRenderer.setBaseToolTipGenerator((XYToolTipGenerator)new StandardXYToolTipGenerator("{0}: ({1}, {2})", (DateFormat)new SimpleDateFormat("d-MMM-yyyy"), (NumberFormat)new DecimalFormat("#,##0.00")));
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        return new ChartPanel(XYAreaChartDemo2.createChart(XYAreaChartDemo2.createDataset()));
    }

    public static void main(String[] arrstring) {
        XYAreaChartDemo2 xYAreaChartDemo2 = new XYAreaChartDemo2("XY Area Chart Demo 2");
        xYAreaChartDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)xYAreaChartDemo2));
        xYAreaChartDemo2.setVisible(true);
    }
}

