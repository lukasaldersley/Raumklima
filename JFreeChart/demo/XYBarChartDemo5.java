/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.DateTickMarkPosition
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.StandardXYToolTipGenerator
 *  org.jfree.chart.labels.XYToolTipGenerator
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYBarRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.title.TextTitle
 *  org.jfree.chart.title.Title
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.time.Year
 *  org.jfree.data.xy.IntervalXYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.HorizontalAlignment
 *  org.jfree.ui.RectangleEdge
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Window;
import java.io.PrintStream;
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
import org.jfree.chart.axis.DateTickMarkPosition;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;

public class XYBarChartDemo5
extends ApplicationFrame {
    public XYBarChartDemo5(String string) {
        super(string);
        JPanel jPanel = XYBarChartDemo5.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 300));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(IntervalXYDataset intervalXYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYBarChart((String)"US Budget Deficit", (String)"Year", (boolean)true, (String)"$ Billion", (IntervalXYDataset)intervalXYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)false, (boolean)false, (boolean)false);
        TextTitle textTitle = new TextTitle("Source: http://www.cbo.gov/showdoc.cfm?index=1821&sequence=0#table12");
        textTitle.setFont(new Font("Dialog", 0, 8));
        textTitle.setPosition(RectangleEdge.BOTTOM);
        textTitle.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        jFreeChart.addSubtitle((Title)textTitle);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        XYBarRenderer xYBarRenderer = (XYBarRenderer)xYPlot.getRenderer();
        xYBarRenderer.setDrawBarOutline(true);
        xYBarRenderer.setSeriesOutlinePaint(0, (Paint)Color.red);
        StandardXYToolTipGenerator standardXYToolTipGenerator = new StandardXYToolTipGenerator("{1} = {2}", (DateFormat)new SimpleDateFormat("yyyy"), (NumberFormat)new DecimalFormat("0"));
        xYBarRenderer.setBaseToolTipGenerator((XYToolTipGenerator)standardXYToolTipGenerator);
        DateAxis dateAxis = (DateAxis)xYPlot.getDomainAxis();
        dateAxis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
        dateAxis.setLowerMargin(0.01);
        dateAxis.setUpperMargin(0.01);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    private static IntervalXYDataset createDataset() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Budget"), "Year", "$ Million");
        try {
            timeSeries.add((RegularTimePeriod)new Year(1980), -74.0);
            timeSeries.add((RegularTimePeriod)new Year(1981), -79.0);
            timeSeries.add((RegularTimePeriod)new Year(1982), -128.0);
            timeSeries.add((RegularTimePeriod)new Year(1983), -208.0);
            timeSeries.add((RegularTimePeriod)new Year(1984), -185.0);
            timeSeries.add((RegularTimePeriod)new Year(1985), -212.0);
            timeSeries.add((RegularTimePeriod)new Year(1986), -221.0);
            timeSeries.add((RegularTimePeriod)new Year(1987), -150.0);
            timeSeries.add((RegularTimePeriod)new Year(1988), -155.0);
            timeSeries.add((RegularTimePeriod)new Year(1989), -153.0);
            timeSeries.add((RegularTimePeriod)new Year(1990), -221.0);
            timeSeries.add((RegularTimePeriod)new Year(1991), -269.0);
            timeSeries.add((RegularTimePeriod)new Year(1992), -290.0);
            timeSeries.add((RegularTimePeriod)new Year(1993), -255.0);
            timeSeries.add((RegularTimePeriod)new Year(1994), -203.0);
            timeSeries.add((RegularTimePeriod)new Year(1995), -164.0);
            timeSeries.add((RegularTimePeriod)new Year(1996), -107.0);
            timeSeries.add((RegularTimePeriod)new Year(1997), -22.0);
            timeSeries.add((RegularTimePeriod)new Year(1998), 69.0);
            timeSeries.add((RegularTimePeriod)new Year(1999), 126.0);
            timeSeries.add((RegularTimePeriod)new Year(2000), 236.0);
            timeSeries.add((RegularTimePeriod)new Year(2001), 128.0);
            timeSeries.add((RegularTimePeriod)new Year(2002), -158.0);
            timeSeries.add((RegularTimePeriod)new Year(2003), -378.0);
            timeSeries.add((RegularTimePeriod)new Year(2004), -412.0);
        }
        catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection(timeSeries);
        return timeSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        return new ChartPanel(XYBarChartDemo5.createChart(XYBarChartDemo5.createDataset()));
    }

    public static void main(String[] arrstring) {
        XYBarChartDemo5 xYBarChartDemo5 = new XYBarChartDemo5("US Budget Deficit");
        xYBarChartDemo5.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)xYBarChartDemo5));
        xYBarChartDemo5.setVisible(true);
    }
}

