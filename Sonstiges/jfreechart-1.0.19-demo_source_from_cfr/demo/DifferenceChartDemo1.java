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
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYDifferenceRenderer
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

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYDifferenceRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class DifferenceChartDemo1
extends ApplicationFrame {
    public DifferenceChartDemo1(String string) {
        super(string);
        JPanel jPanel = DifferenceChartDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static XYDataset createDataset() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Random 1"));
        TimeSeries timeSeries2 = new TimeSeries((Comparable)((Object)"Random 2"));
        double d = 0.0;
        double d2 = 0.0;
        Day day = new Day();
        for (int i = 0; i < 200; ++i) {
            d = d + Math.random() - 0.5;
            d2 = d2 + Math.random() - 0.5;
            timeSeries.add((RegularTimePeriod)day, d);
            timeSeries2.add((RegularTimePeriod)day, d2);
            day = (Day)day.next();
        }
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        timeSeriesCollection.addSeries(timeSeries);
        timeSeriesCollection.addSeries(timeSeries2);
        return timeSeriesCollection;
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Difference Chart Demo 1", (String)"Time", (String)"Value", (XYDataset)xYDataset, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainPannable(true);
        XYDifferenceRenderer xYDifferenceRenderer = new XYDifferenceRenderer((Paint)Color.green, (Paint)Color.red, false);
        xYDifferenceRenderer.setRoundXCoordinates(true);
        xYPlot.setDomainCrosshairLockedOnData(true);
        xYPlot.setRangeCrosshairLockedOnData(true);
        xYPlot.setDomainCrosshairVisible(true);
        xYPlot.setRangeCrosshairVisible(true);
        xYPlot.setRenderer((XYItemRenderer)xYDifferenceRenderer);
        DateAxis dateAxis = new DateAxis("Time");
        dateAxis.setLowerMargin(0.0);
        dateAxis.setUpperMargin(0.0);
        xYPlot.setDomainAxis((ValueAxis)dateAxis);
        xYPlot.setForegroundAlpha(0.5f);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = DifferenceChartDemo1.createChart(DifferenceChartDemo1.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        DifferenceChartDemo1 differenceChartDemo1 = new DifferenceChartDemo1("JFreeChart: DifferenceChartDemo1.java");
        differenceChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)differenceChartDemo1));
        differenceChartDemo1.setVisible(true);
    }
}

