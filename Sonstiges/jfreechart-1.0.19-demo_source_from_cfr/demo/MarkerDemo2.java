/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.PeriodAxis
 *  org.jfree.chart.axis.PeriodAxisLabelInfo
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.IntervalMarker
 *  org.jfree.chart.plot.Marker
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.ValueMarker
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.time.Day
 *  org.jfree.data.time.Hour
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.Layer
 *  org.jfree.ui.LengthAdjustmentType
 *  org.jfree.ui.RectangleAnchor
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.ui.TextAnchor
 */
package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.Window;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.PeriodAxis;
import org.jfree.chart.axis.PeriodAxisLabelInfo;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.Layer;
import org.jfree.ui.LengthAdjustmentType;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class MarkerDemo2
extends ApplicationFrame {
    public MarkerDemo2(String string) {
        super(string);
        XYDataset xYDataset = MarkerDemo2.createDataset();
        JFreeChart jFreeChart = MarkerDemo2.createChart(xYDataset);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        chartPanel.setDomainZoomable(true);
        chartPanel.setRangeZoomable(true);
        this.setContentPane((Container)chartPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYLineChart((String)"Marker Demo 2", (String)"X", (String)"Temperature", (XYDataset)xYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)false, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        PeriodAxis periodAxis = new PeriodAxis(null, (RegularTimePeriod)new Hour(0, 30, 6, 2005), (RegularTimePeriod)new Hour(23, 30, 6, 2005));
        PeriodAxisLabelInfo[] arrperiodAxisLabelInfo = new PeriodAxisLabelInfo[]{new PeriodAxisLabelInfo(Hour.class, (DateFormat)new SimpleDateFormat("HH")), new PeriodAxisLabelInfo(Day.class, (DateFormat)new SimpleDateFormat("dd-MMM"))};
        periodAxis.setLabelInfo(arrperiodAxisLabelInfo);
        xYPlot.setDomainAxis((ValueAxis)periodAxis);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        xYPlot.setDomainGridlinePaint((Paint)Color.lightGray);
        xYPlot.setDomainGridlineStroke((Stroke)new BasicStroke(1.0f));
        xYPlot.setRangeGridlinePaint((Paint)Color.lightGray);
        xYPlot.setRangeGridlineStroke((Stroke)new BasicStroke(1.0f));
        xYPlot.setRangeTickBandPaint((Paint)new Color(240, 240, 240));
        ValueAxis valueAxis = xYPlot.getRangeAxis();
        valueAxis.setRange(0.0, 100.0);
        XYItemRenderer xYItemRenderer = xYPlot.getRenderer();
        xYItemRenderer.setSeriesPaint(0, (Paint)Color.green);
        xYItemRenderer.setSeriesStroke(0, (Stroke)new BasicStroke(2.0f));
        ValueMarker valueMarker = new ValueMarker(80.0);
        valueMarker.setLabelOffsetType(LengthAdjustmentType.EXPAND);
        valueMarker.setPaint((Paint)Color.red);
        valueMarker.setStroke((Stroke)new BasicStroke(2.0f));
        valueMarker.setLabel("Temperature Threshold");
        valueMarker.setLabelFont(new Font("SansSerif", 0, 11));
        valueMarker.setLabelPaint((Paint)Color.red);
        valueMarker.setLabelAnchor(RectangleAnchor.TOP_LEFT);
        valueMarker.setLabelTextAnchor(TextAnchor.BOTTOM_LEFT);
        xYPlot.addRangeMarker((Marker)valueMarker);
        Hour hour = new Hour(18, 30, 6, 2005);
        Hour hour2 = new Hour(20, 30, 6, 2005);
        double d = hour.getFirstMillisecond();
        double d2 = hour2.getFirstMillisecond();
        IntervalMarker intervalMarker = new IntervalMarker(d, d2);
        intervalMarker.setLabelOffsetType(LengthAdjustmentType.EXPAND);
        intervalMarker.setPaint((Paint)new Color(150, 150, 255));
        intervalMarker.setLabel("Automatic Cooling");
        intervalMarker.setLabelFont(new Font("SansSerif", 0, 11));
        intervalMarker.setLabelPaint((Paint)Color.blue);
        intervalMarker.setLabelAnchor(RectangleAnchor.TOP_LEFT);
        intervalMarker.setLabelTextAnchor(TextAnchor.TOP_RIGHT);
        xYPlot.addDomainMarker((Marker)intervalMarker, Layer.BACKGROUND);
        ValueMarker valueMarker2 = new ValueMarker(d, (Paint)Color.blue, (Stroke)new BasicStroke(2.0f));
        ValueMarker valueMarker3 = new ValueMarker(d2, (Paint)Color.blue, (Stroke)new BasicStroke(2.0f));
        xYPlot.addDomainMarker((Marker)valueMarker2, Layer.BACKGROUND);
        xYPlot.addDomainMarker((Marker)valueMarker3, Layer.BACKGROUND);
        return jFreeChart;
    }

    private static XYDataset createDataset() {
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Temperature"));
        timeSeries.add((RegularTimePeriod)new Hour(0, 30, 6, 2005), 45.3);
        timeSeries.add((RegularTimePeriod)new Hour(1, 30, 6, 2005), 48.9);
        timeSeries.add((RegularTimePeriod)new Hour(2, 30, 6, 2005), 52.1);
        timeSeries.add((RegularTimePeriod)new Hour(3, 30, 6, 2005), 44.8);
        timeSeries.add((RegularTimePeriod)new Hour(4, 30, 6, 2005), 49.9);
        timeSeries.add((RegularTimePeriod)new Hour(5, 30, 6, 2005), 55.5);
        timeSeries.add((RegularTimePeriod)new Hour(6, 30, 6, 2005), 58.2);
        timeSeries.add((RegularTimePeriod)new Hour(7, 30, 6, 2005), 58.1);
        timeSeries.add((RegularTimePeriod)new Hour(8, 30, 6, 2005), 63.7);
        timeSeries.add((RegularTimePeriod)new Hour(9, 30, 6, 2005), 66.3);
        timeSeries.add((RegularTimePeriod)new Hour(10, 30, 6, 2005), 69.8);
        timeSeries.add((RegularTimePeriod)new Hour(11, 30, 6, 2005), 70.1);
        timeSeries.add((RegularTimePeriod)new Hour(12, 30, 6, 2005), 72.4);
        timeSeries.add((RegularTimePeriod)new Hour(13, 30, 6, 2005), 69.7);
        timeSeries.add((RegularTimePeriod)new Hour(14, 30, 6, 2005), 68.6);
        timeSeries.add((RegularTimePeriod)new Hour(15, 30, 6, 2005), 70.9);
        timeSeries.add((RegularTimePeriod)new Hour(16, 30, 6, 2005), 73.4);
        timeSeries.add((RegularTimePeriod)new Hour(17, 30, 6, 2005), 77.5);
        timeSeries.add((RegularTimePeriod)new Hour(18, 30, 6, 2005), 82.9);
        timeSeries.add((RegularTimePeriod)new Hour(19, 30, 6, 2005), 62.1);
        timeSeries.add((RegularTimePeriod)new Hour(20, 30, 6, 2005), 37.3);
        timeSeries.add((RegularTimePeriod)new Hour(21, 30, 6, 2005), 40.7);
        timeSeries.add((RegularTimePeriod)new Hour(22, 30, 6, 2005), 44.2);
        timeSeries.add((RegularTimePeriod)new Hour(23, 30, 6, 2005), 49.8);
        timeSeriesCollection.addSeries(timeSeries);
        return timeSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = MarkerDemo2.createChart(MarkerDemo2.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        MarkerDemo2 markerDemo2 = new MarkerDemo2("JFreeChart: MarkerDemo2.java");
        markerDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)markerDemo2));
        markerDemo2.setVisible(true);
    }
}

