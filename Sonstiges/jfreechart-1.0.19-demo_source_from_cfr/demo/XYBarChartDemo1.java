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
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
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
import org.jfree.ui.RefineryUtilities;

public class XYBarChartDemo1
extends ApplicationFrame {
    public XYBarChartDemo1(String string) {
        super(string);
        JPanel jPanel = XYBarChartDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(IntervalXYDataset intervalXYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYBarChart((String)"State Executions - USA", (String)"Year", (boolean)true, (String)"Number of People", (IntervalXYDataset)intervalXYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)false, (boolean)false);
        jFreeChart.addSubtitle((Title)new TextTitle("Source: http://www.amnestyusa.org/abolish/listbyyear.do", new Font("Dialog", 2, 10)));
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        XYBarRenderer xYBarRenderer = (XYBarRenderer)xYPlot.getRenderer();
        StandardXYToolTipGenerator standardXYToolTipGenerator = new StandardXYToolTipGenerator("{1} = {2}", (DateFormat)new SimpleDateFormat("yyyy"), (NumberFormat)new DecimalFormat("0"));
        xYBarRenderer.setBaseToolTipGenerator((XYToolTipGenerator)standardXYToolTipGenerator);
        xYBarRenderer.setMargin(0.1);
        DateAxis dateAxis = (DateAxis)xYPlot.getDomainAxis();
        dateAxis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
        dateAxis.setLowerMargin(0.01);
        dateAxis.setUpperMargin(0.01);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    private static IntervalXYDataset createDataset() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Executions"), "Year", "Count");
        try {
            timeSeries.add((RegularTimePeriod)new Year(1976), (Number)new Integer(0));
            timeSeries.add((RegularTimePeriod)new Year(1977), (Number)new Integer(1));
            timeSeries.add((RegularTimePeriod)new Year(1978), (Number)new Integer(0));
            timeSeries.add((RegularTimePeriod)new Year(1979), (Number)new Integer(2));
            timeSeries.add((RegularTimePeriod)new Year(1980), (Number)new Integer(0));
            timeSeries.add((RegularTimePeriod)new Year(1981), (Number)new Integer(1));
            timeSeries.add((RegularTimePeriod)new Year(1982), (Number)new Integer(2));
            timeSeries.add((RegularTimePeriod)new Year(1983), (Number)new Integer(5));
            timeSeries.add((RegularTimePeriod)new Year(1984), (Number)new Integer(21));
            timeSeries.add((RegularTimePeriod)new Year(1985), (Number)new Integer(18));
            timeSeries.add((RegularTimePeriod)new Year(1986), (Number)new Integer(18));
            timeSeries.add((RegularTimePeriod)new Year(1987), (Number)new Integer(25));
            timeSeries.add((RegularTimePeriod)new Year(1988), (Number)new Integer(11));
            timeSeries.add((RegularTimePeriod)new Year(1989), (Number)new Integer(16));
            timeSeries.add((RegularTimePeriod)new Year(1990), (Number)new Integer(23));
            timeSeries.add((RegularTimePeriod)new Year(1991), (Number)new Integer(14));
            timeSeries.add((RegularTimePeriod)new Year(1992), (Number)new Integer(31));
            timeSeries.add((RegularTimePeriod)new Year(1993), (Number)new Integer(38));
            timeSeries.add((RegularTimePeriod)new Year(1994), (Number)new Integer(31));
            timeSeries.add((RegularTimePeriod)new Year(1995), (Number)new Integer(56));
            timeSeries.add((RegularTimePeriod)new Year(1996), (Number)new Integer(45));
            timeSeries.add((RegularTimePeriod)new Year(1997), (Number)new Integer(74));
            timeSeries.add((RegularTimePeriod)new Year(1998), (Number)new Integer(68));
            timeSeries.add((RegularTimePeriod)new Year(1999), (Number)new Integer(98));
            timeSeries.add((RegularTimePeriod)new Year(2000), (Number)new Integer(85));
            timeSeries.add((RegularTimePeriod)new Year(2001), (Number)new Integer(66));
            timeSeries.add((RegularTimePeriod)new Year(2002), (Number)new Integer(71));
            timeSeries.add((RegularTimePeriod)new Year(2003), (Number)new Integer(65));
            timeSeries.add((RegularTimePeriod)new Year(2004), (Number)new Integer(59));
            timeSeries.add((RegularTimePeriod)new Year(2005), (Number)new Integer(60));
        }
        catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection(timeSeries);
        return timeSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        return new ChartPanel(XYBarChartDemo1.createChart(XYBarChartDemo1.createDataset()));
    }

    public static void main(String[] arrstring) {
        XYBarChartDemo1 xYBarChartDemo1 = new XYBarChartDemo1("State Executions - USA");
        xYBarChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)xYBarChartDemo1));
        xYBarChartDemo1.setVisible(true);
    }
}

