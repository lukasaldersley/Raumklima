/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.annotations.XYAnnotation
 *  org.jfree.chart.annotations.XYDrawableAnnotation
 *  org.jfree.chart.annotations.XYPointerAnnotation
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.StandardXYToolTipGenerator
 *  org.jfree.chart.labels.XYToolTipGenerator
 *  org.jfree.chart.plot.Marker
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.ValueMarker
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.title.LegendTitle
 *  org.jfree.chart.title.Title
 *  org.jfree.data.time.Day
 *  org.jfree.data.time.Hour
 *  org.jfree.data.time.Minute
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.Drawable
 *  org.jfree.ui.LengthAdjustmentType
 *  org.jfree.ui.RectangleAnchor
 *  org.jfree.ui.RectangleEdge
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.ui.TextAnchor
 */
package demo;

import demo.CircleDrawer;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYAnnotation;
import org.jfree.chart.annotations.XYDrawableAnnotation;
import org.jfree.chart.annotations.XYPointerAnnotation;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Minute;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.Drawable;
import org.jfree.ui.LengthAdjustmentType;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class MarkerDemo1
extends ApplicationFrame {
    public MarkerDemo1(String string) {
        super(string);
        ChartPanel chartPanel = (ChartPanel)MarkerDemo1.createDemoPanel();
        chartPanel.setPreferredSize(new Dimension(500, 270));
        chartPanel.setDomainZoomable(true);
        chartPanel.setRangeZoomable(true);
        this.setContentPane((Container)chartPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createScatterPlot((String)"Marker Demo 1", (String)"X", (String)"Y", (XYDataset)xYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        LegendTitle legendTitle = (LegendTitle)jFreeChart.getSubtitle(0);
        legendTitle.setPosition(RectangleEdge.RIGHT);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        xYPlot.getRenderer().setBaseToolTipGenerator((XYToolTipGenerator)StandardXYToolTipGenerator.getTimeSeriesInstance());
        DateAxis dateAxis = new DateAxis("Time");
        dateAxis.setUpperMargin(0.5);
        xYPlot.setDomainAxis((ValueAxis)dateAxis);
        ValueAxis valueAxis = xYPlot.getRangeAxis();
        valueAxis.setUpperMargin(0.3);
        valueAxis.setLowerMargin(0.5);
        ValueMarker valueMarker = new ValueMarker(200.0);
        valueMarker.setLabelOffsetType(LengthAdjustmentType.EXPAND);
        valueMarker.setPaint((Paint)Color.green);
        valueMarker.setLabel("Bid Start Price");
        valueMarker.setLabelAnchor(RectangleAnchor.BOTTOM_RIGHT);
        valueMarker.setLabelTextAnchor(TextAnchor.TOP_RIGHT);
        xYPlot.addRangeMarker((Marker)valueMarker);
        ValueMarker valueMarker2 = new ValueMarker(175.0);
        valueMarker2.setLabelOffsetType(LengthAdjustmentType.EXPAND);
        valueMarker2.setPaint((Paint)Color.red);
        valueMarker2.setLabel("Target Price");
        valueMarker2.setLabelAnchor(RectangleAnchor.TOP_RIGHT);
        valueMarker2.setLabelTextAnchor(TextAnchor.BOTTOM_RIGHT);
        xYPlot.addRangeMarker((Marker)valueMarker2);
        Hour hour = new Hour(2, new Day(22, 5, 2003));
        double d = hour.getFirstMillisecond();
        ValueMarker valueMarker3 = new ValueMarker(d);
        valueMarker3.setPaint((Paint)Color.orange);
        valueMarker3.setLabel("Original Close (02:00)");
        valueMarker3.setLabelAnchor(RectangleAnchor.TOP_LEFT);
        valueMarker3.setLabelTextAnchor(TextAnchor.TOP_RIGHT);
        xYPlot.addDomainMarker((Marker)valueMarker3);
        Minute minute = new Minute(15, hour);
        d = minute.getFirstMillisecond();
        ValueMarker valueMarker4 = new ValueMarker(d);
        valueMarker4.setPaint((Paint)Color.red);
        valueMarker4.setLabel("Close Date (02:15)");
        valueMarker4.setLabelAnchor(RectangleAnchor.TOP_RIGHT);
        valueMarker4.setLabelTextAnchor(TextAnchor.TOP_LEFT);
        xYPlot.addDomainMarker((Marker)valueMarker4);
        Hour hour2 = new Hour(2, new Day(22, 5, 2003));
        Minute minute2 = new Minute(10, hour2);
        d = minute2.getFirstMillisecond();
        CircleDrawer circleDrawer = new CircleDrawer(Color.red, new BasicStroke(1.0f), null);
        XYDrawableAnnotation xYDrawableAnnotation = new XYDrawableAnnotation(d, 163.0, 11.0, 11.0, (Drawable)circleDrawer);
        xYPlot.addAnnotation((XYAnnotation)xYDrawableAnnotation);
        XYPointerAnnotation xYPointerAnnotation = new XYPointerAnnotation("Best Bid", d, 163.0, 2.356194490192345);
        xYPointerAnnotation.setBaseRadius(35.0);
        xYPointerAnnotation.setTipRadius(10.0);
        xYPointerAnnotation.setFont(new Font("SansSerif", 0, 9));
        xYPointerAnnotation.setPaint((Paint)Color.blue);
        xYPointerAnnotation.setTextAnchor(TextAnchor.HALF_ASCENT_RIGHT);
        xYPlot.addAnnotation((XYAnnotation)xYPointerAnnotation);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    private static XYDataset createDataset() {
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        timeSeriesCollection.addSeries(MarkerDemo1.createSupplier1Bids());
        timeSeriesCollection.addSeries(MarkerDemo1.createSupplier2Bids());
        return timeSeriesCollection;
    }

    private static TimeSeries createSupplier1Bids() {
        Hour hour = new Hour(1, new Day(22, 5, 2003));
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Supplier 1"));
        timeSeries.add((RegularTimePeriod)new Minute(13, hour), 200.0);
        timeSeries.add((RegularTimePeriod)new Minute(14, hour), 195.0);
        timeSeries.add((RegularTimePeriod)new Minute(45, hour), 190.0);
        timeSeries.add((RegularTimePeriod)new Minute(46, hour), 188.0);
        timeSeries.add((RegularTimePeriod)new Minute(47, hour), 185.0);
        timeSeries.add((RegularTimePeriod)new Minute(52, hour), 180.0);
        return timeSeries;
    }

    private static TimeSeries createSupplier2Bids() {
        Hour hour = new Hour(1, new Day(22, 5, 2003));
        Hour hour2 = (Hour)hour.next();
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Supplier 2"));
        timeSeries.add((RegularTimePeriod)new Minute(25, hour), 185.0);
        timeSeries.add((RegularTimePeriod)new Minute(0, hour2), 175.0);
        timeSeries.add((RegularTimePeriod)new Minute(5, hour2), 170.0);
        timeSeries.add((RegularTimePeriod)new Minute(6, hour2), 168.0);
        timeSeries.add((RegularTimePeriod)new Minute(9, hour2), 165.0);
        timeSeries.add((RegularTimePeriod)new Minute(10, hour2), 163.0);
        return timeSeries;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = MarkerDemo1.createChart(MarkerDemo1.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        MarkerDemo1 markerDemo1 = new MarkerDemo1("JFreeChart: MarkerDemo1.java");
        markerDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)markerDemo1));
        markerDemo1.setVisible(true);
    }
}

