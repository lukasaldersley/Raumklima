/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.CompassFormat
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.NumberTickUnit
 *  org.jfree.chart.axis.TickUnit
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.TickUnits
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYAreaRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.time.Minute
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
import java.text.NumberFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CompassFormat;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.TickUnit;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.TickUnits;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Minute;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class CompassFormatDemo1
extends ApplicationFrame {
    public CompassFormatDemo1(String string) {
        super(string);
        JPanel jPanel = CompassFormatDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static XYDataset createDirectionDataset(int n) {
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Wind Direction"));
        Minute minute = new Minute();
        double d = 180.0;
        for (int i = 0; i < n; ++i) {
            timeSeries.add((RegularTimePeriod)minute, d);
            minute = minute.next();
            if ((d += (Math.random() - 0.5) * 15.0) < 0.0) {
                d += 360.0;
                continue;
            }
            if (d <= 360.0) continue;
            d -= 360.0;
        }
        timeSeriesCollection.addSeries(timeSeries);
        return timeSeriesCollection;
    }

    private static XYDataset createForceDataset(int n) {
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Wind Force"));
        Minute minute = new Minute();
        double d = 3.0;
        for (int i = 0; i < n; ++i) {
            timeSeries.add((RegularTimePeriod)minute, d);
            minute = minute.next();
            d = Math.max(0.5, d + (Math.random() - 0.5) * 0.5);
        }
        timeSeriesCollection.addSeries(timeSeries);
        return timeSeriesCollection;
    }

    private static JFreeChart createChart() {
        XYDataset xYDataset = CompassFormatDemo1.createDirectionDataset(600);
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Time", (String)"Date", (String)"Direction", (XYDataset)xYDataset, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        xYPlot.getDomainAxis().setLowerMargin(0.0);
        xYPlot.getDomainAxis().setUpperMargin(0.0);
        NumberAxis numberAxis = (NumberAxis)xYPlot.getRangeAxis();
        numberAxis.setAutoRangeIncludesZero(false);
        TickUnits tickUnits = new TickUnits();
        tickUnits.add((TickUnit)new NumberTickUnit(180.0, (NumberFormat)new CompassFormat()));
        tickUnits.add((TickUnit)new NumberTickUnit(90.0, (NumberFormat)new CompassFormat()));
        tickUnits.add((TickUnit)new NumberTickUnit(45.0, (NumberFormat)new CompassFormat()));
        tickUnits.add((TickUnit)new NumberTickUnit(22.5, (NumberFormat)new CompassFormat()));
        numberAxis.setStandardTickUnits((TickUnitSource)tickUnits);
        xYPlot.setRangeAxis((ValueAxis)numberAxis);
        XYAreaRenderer xYAreaRenderer = new XYAreaRenderer();
        NumberAxis numberAxis2 = new NumberAxis("Force");
        numberAxis2.setRange(0.0, 12.0);
        xYAreaRenderer.setSeriesPaint(0, (Paint)new Color(0, 0, 255, 128));
        xYPlot.setDataset(1, CompassFormatDemo1.createForceDataset(600));
        xYPlot.setRenderer(1, (XYItemRenderer)xYAreaRenderer);
        xYPlot.setRangeAxis(1, (ValueAxis)numberAxis2);
        xYPlot.mapDatasetToRangeAxis(1, 1);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = CompassFormatDemo1.createChart();
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        CompassFormatDemo1 compassFormatDemo1 = new CompassFormatDemo1("JFreeChart: CompassFormatDemo1.java");
        compassFormatDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)compassFormatDemo1));
        compassFormatDemo1.setVisible(true);
    }
}

