/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.AxisLocation
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
 *  org.jfree.data.time.Minute
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
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Minute;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class MultipleAxisDemo2
extends ApplicationFrame {
    public MultipleAxisDemo2(String string) {
        super(string);
        JPanel jPanel = MultipleAxisDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(600, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart() {
        XYDataset xYDataset = MultipleAxisDemo2.createDataset("Series 1", 100.0, (RegularTimePeriod)new Minute(), 200);
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Multiple Axis Demo 2", (String)"Time of Day", (String)"Primary Range Axis", (XYDataset)xYDataset, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainPannable(true);
        xYPlot.setOrientation(PlotOrientation.VERTICAL);
        NumberAxis numberAxis = new NumberAxis("Domain Axis 2");
        numberAxis.setAutoRangeIncludesZero(false);
        xYPlot.setDomainAxis(1, (ValueAxis)numberAxis);
        NumberAxis numberAxis2 = new NumberAxis("Range Axis 2");
        xYPlot.setRangeAxis(1, (ValueAxis)numberAxis2);
        xYPlot.setRangeAxisLocation(1, AxisLocation.BOTTOM_OR_RIGHT);
        XYDataset xYDataset2 = MultipleAxisDemo2.createDataset("Series 2", 1000.0, (RegularTimePeriod)new Minute(), 170);
        xYPlot.setDataset(1, xYDataset2);
        xYPlot.mapDatasetToDomainAxis(1, 1);
        xYPlot.mapDatasetToRangeAxis(1, 1);
        xYPlot.setRenderer(1, (XYItemRenderer)new XYLineAndShapeRenderer(true, false));
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    private static XYDataset createDataset(String string, double d, RegularTimePeriod regularTimePeriod, int n) {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)string));
        RegularTimePeriod regularTimePeriod2 = regularTimePeriod;
        double d2 = d;
        for (int i = 0; i < n; ++i) {
            timeSeries.add(regularTimePeriod2, d2);
            regularTimePeriod2 = regularTimePeriod2.next();
            d2 *= 1.0 + (Math.random() - 0.495) / 10.0;
        }
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        timeSeriesCollection.addSeries(timeSeries);
        return timeSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = MultipleAxisDemo2.createChart();
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        MultipleAxisDemo2 multipleAxisDemo2 = new MultipleAxisDemo2("JFreeChart: MultipleAxisDemo2.java");
        multipleAxisDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)multipleAxisDemo2));
        multipleAxisDemo2.setVisible(true);
    }
}

