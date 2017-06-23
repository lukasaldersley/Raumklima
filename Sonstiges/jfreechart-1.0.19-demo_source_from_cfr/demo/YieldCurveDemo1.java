/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.AxisState
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.DateTick
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
 *  org.jfree.chart.title.TextTitle
 *  org.jfree.chart.title.Title
 *  org.jfree.data.time.Day
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.HorizontalAlignment
 *  org.jfree.ui.RectangleEdge
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.ui.TextAnchor
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.geom.Rectangle2D;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTick;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class YieldCurveDemo1
extends ApplicationFrame {
    public YieldCurveDemo1(String string) {
        super(string);
        JPanel jPanel = YieldCurveDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        XYLineAndShapeRenderer xYLineAndShapeRenderer;
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"US$ Treasury Yields", (String)"Date", (String)"Yield", (XYDataset)xYDataset);
        jFreeChart.removeLegend();
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        GregorianCalendar gregorianCalendar = new GregorianCalendar(2005, 10, 15);
        xYPlot.setDomainAxis((ValueAxis)new CustomDateAxis("Date", gregorianCalendar.getTime()));
        xYPlot.setDomainCrosshairVisible(true);
        xYPlot.setRangeCrosshairVisible(true);
        XYItemRenderer xYItemRenderer = xYPlot.getRenderer();
        if (xYItemRenderer instanceof XYLineAndShapeRenderer) {
            xYLineAndShapeRenderer = (XYLineAndShapeRenderer)xYItemRenderer;
            xYLineAndShapeRenderer.setBaseShapesVisible(true);
            xYLineAndShapeRenderer.setBaseShapesFilled(true);
        }
        xYLineAndShapeRenderer = (DateAxis)xYPlot.getDomainAxis();
        xYLineAndShapeRenderer.setDateFormatOverride((DateFormat)new SimpleDateFormat("MMM-yyyy"));
        jFreeChart.addSubtitle((Title)new TextTitle("November 2005"));
        TextTitle textTitle = new TextTitle("Source: http://www.econstats.com/r/r_am1.htm");
        textTitle.setFont(new Font("Dialog", 0, 9));
        textTitle.setPosition(RectangleEdge.BOTTOM);
        textTitle.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        jFreeChart.addSubtitle((Title)textTitle);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    private static XYDataset createDataset() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"US$ Treasury Yields"));
        Day day = new Day(1, 12, 2005);
        Day day2 = new Day(1, 2, 2006);
        Day day3 = new Day(1, 5, 2006);
        Day day4 = new Day(1, 12, 2006);
        Day day5 = new Day(1, 12, 2007);
        Day day6 = new Day(1, 12, 2008);
        Day day7 = new Day(1, 12, 2010);
        Day day8 = new Day(1, 12, 2012);
        Day day9 = new Day(1, 12, 2015);
        Day day10 = new Day(1, 12, 2025);
        timeSeries.add((RegularTimePeriod)day, 3.79);
        timeSeries.add((RegularTimePeriod)day2, 3.995);
        timeSeries.add((RegularTimePeriod)day3, 4.26);
        timeSeries.add((RegularTimePeriod)day4, 4.3225);
        timeSeries.add((RegularTimePeriod)day5, 4.4475);
        timeSeries.add((RegularTimePeriod)day6, 4.475);
        timeSeries.add((RegularTimePeriod)day7, 4.52);
        timeSeries.add((RegularTimePeriod)day8, 4.56);
        timeSeries.add((RegularTimePeriod)day9, 4.625);
        timeSeries.add((RegularTimePeriod)day10, 4.905);
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        timeSeriesCollection.addSeries(timeSeries);
        return timeSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = YieldCurveDemo1.createChart(YieldCurveDemo1.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        YieldCurveDemo1 yieldCurveDemo1 = new YieldCurveDemo1("JFreeChart: YieldCurveDemo1.java");
        yieldCurveDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)yieldCurveDemo1));
        yieldCurveDemo1.setVisible(true);
    }

    static class CustomDateAxis
    extends DateAxis {
        private Date base;

        public CustomDateAxis(String string, Date date) {
            super(string);
            this.base = date;
        }

        public List refreshTicks(Graphics2D graphics2D, AxisState axisState, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
            ArrayList<DateTick> arrayList = new ArrayList<DateTick>();
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime(this.base);
            gregorianCalendar.add(2, 1);
            arrayList.add(new DateTick(gregorianCalendar.getTime(), "1M", TextAnchor.TOP_CENTER, TextAnchor.CENTER, 0.0));
            gregorianCalendar.add(2, 5);
            gregorianCalendar.add(2, 6);
            arrayList.add(new DateTick(gregorianCalendar.getTime(), "1Y", TextAnchor.TOP_CENTER, TextAnchor.CENTER, 0.0));
            gregorianCalendar.add(1, 1);
            arrayList.add(new DateTick(gregorianCalendar.getTime(), "2Y", TextAnchor.TOP_CENTER, TextAnchor.CENTER, 0.0));
            gregorianCalendar.add(1, 1);
            arrayList.add(new DateTick(gregorianCalendar.getTime(), "3Y", TextAnchor.TOP_CENTER, TextAnchor.CENTER, 0.0));
            gregorianCalendar.add(1, 2);
            arrayList.add(new DateTick(gregorianCalendar.getTime(), "5Y", TextAnchor.TOP_CENTER, TextAnchor.CENTER, 0.0));
            gregorianCalendar.add(1, 5);
            arrayList.add(new DateTick(gregorianCalendar.getTime(), "10Y", TextAnchor.TOP_CENTER, TextAnchor.CENTER, 0.0));
            gregorianCalendar.add(1, 10);
            arrayList.add(new DateTick(gregorianCalendar.getTime(), "20Y", TextAnchor.TOP_CENTER, TextAnchor.CENTER, 0.0));
            return arrayList;
        }
    }

}

