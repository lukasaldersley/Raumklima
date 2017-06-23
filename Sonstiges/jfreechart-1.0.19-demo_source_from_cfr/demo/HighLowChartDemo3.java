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
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.CandlestickRenderer
 *  org.jfree.chart.renderer.xy.HighLowRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.time.Day
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.ohlc.OHLCSeries
 *  org.jfree.data.time.ohlc.OHLCSeriesCollection
 *  org.jfree.data.xy.OHLCDataset
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickMarkPosition;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.CandlestickRenderer;
import org.jfree.chart.renderer.xy.HighLowRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.ohlc.OHLCSeries;
import org.jfree.data.time.ohlc.OHLCSeriesCollection;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class HighLowChartDemo3
extends ApplicationFrame {
    public HighLowChartDemo3(String string) {
        super(string);
        JPanel jPanel = HighLowChartDemo3.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    public static OHLCDataset createDataset1() {
        OHLCSeries oHLCSeries = new OHLCSeries((Comparable)((Object)"Series 1"));
        oHLCSeries.add((RegularTimePeriod)new Day(24, 9, 2007), 50.5, 53.2, 49.8, 50.1);
        oHLCSeries.add((RegularTimePeriod)new Day(25, 9, 2007), 50.2, 51.2, 47.8, 48.1);
        oHLCSeries.add((RegularTimePeriod)new Day(26, 9, 2007), 48.0, 49.2, 45.3, 47.4);
        oHLCSeries.add((RegularTimePeriod)new Day(27, 9, 2007), 47.5, 48.3, 46.8, 46.8);
        oHLCSeries.add((RegularTimePeriod)new Day(28, 9, 2007), 46.6, 47.0, 45.1, 46.0);
        oHLCSeries.add((RegularTimePeriod)new Day(1, 10, 2007), 46.6, 47.0, 45.1, 46.0);
        oHLCSeries.add((RegularTimePeriod)new Day(2, 10, 2007), 47.5, 48.3, 46.8, 46.8);
        oHLCSeries.add((RegularTimePeriod)new Day(3, 10, 2007), 48.0, 49.2, 45.3, 47.4);
        oHLCSeries.add((RegularTimePeriod)new Day(4, 10, 2007), 50.2, 51.2, 47.8, 48.1);
        oHLCSeries.add((RegularTimePeriod)new Day(5, 10, 2007), 50.5, 53.2, 49.8, 50.1);
        OHLCSeriesCollection oHLCSeriesCollection = new OHLCSeriesCollection();
        oHLCSeriesCollection.addSeries(oHLCSeries);
        return oHLCSeriesCollection;
    }

    public static OHLCDataset createDataset2() {
        OHLCSeries oHLCSeries = new OHLCSeries((Comparable)((Object)"Series 2"));
        oHLCSeries.add((RegularTimePeriod)new Day(24, 9, 2007), 5.5, 6.2, 4.8, 5.9);
        oHLCSeries.add((RegularTimePeriod)new Day(25, 9, 2007), 6.0, 6.9, 6.0, 6.7);
        oHLCSeries.add((RegularTimePeriod)new Day(26, 9, 2007), 6.8, 7.5, 6.4, 7.1);
        oHLCSeries.add((RegularTimePeriod)new Day(27, 9, 2007), 7.2, 8.2, 7.0, 7.9);
        oHLCSeries.add((RegularTimePeriod)new Day(28, 9, 2007), 7.8, 8.5, 7.7, 8.2);
        oHLCSeries.add((RegularTimePeriod)new Day(1, 10, 2007), 8.2, 8.5, 7.7, 7.8);
        oHLCSeries.add((RegularTimePeriod)new Day(2, 10, 2007), 7.9, 8.2, 7.0, 7.2);
        oHLCSeries.add((RegularTimePeriod)new Day(3, 10, 2007), 7.1, 7.5, 6.4, 6.8);
        oHLCSeries.add((RegularTimePeriod)new Day(4, 10, 2007), 6.0, 6.9, 6.0, 6.7);
        oHLCSeries.add((RegularTimePeriod)new Day(5, 10, 2007), 5.5, 6.2, 4.8, 5.9);
        OHLCSeriesCollection oHLCSeriesCollection = new OHLCSeriesCollection();
        oHLCSeriesCollection.addSeries(oHLCSeries);
        return oHLCSeriesCollection;
    }

    private static JFreeChart createChart(OHLCDataset oHLCDataset) {
        JFreeChart jFreeChart = ChartFactory.createHighLowChart((String)"OHLC Demo 3", (String)"Time", (String)"Price", (OHLCDataset)oHLCDataset, (boolean)true);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        HighLowRenderer highLowRenderer = (HighLowRenderer)xYPlot.getRenderer();
        highLowRenderer.setBaseStroke((Stroke)new BasicStroke(2.0f));
        highLowRenderer.setSeriesPaint(0, (Paint)Color.blue);
        DateAxis dateAxis = (DateAxis)xYPlot.getDomainAxis();
        dateAxis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
        NumberAxis numberAxis = (NumberAxis)xYPlot.getRangeAxis();
        numberAxis.setAutoRangeIncludesZero(false);
        NumberAxis numberAxis2 = new NumberAxis("Price 2");
        numberAxis2.setAutoRangeIncludesZero(false);
        xYPlot.setRangeAxis(1, (ValueAxis)numberAxis2);
        xYPlot.setDataset(1, (XYDataset)HighLowChartDemo3.createDataset2());
        xYPlot.setRenderer(1, (XYItemRenderer)new CandlestickRenderer(10.0));
        xYPlot.mapDatasetToRangeAxis(1, 1);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = HighLowChartDemo3.createChart(HighLowChartDemo3.createDataset1());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        HighLowChartDemo3 highLowChartDemo3 = new HighLowChartDemo3("JFreeChart: HighLowChartDemo3.java");
        highLowChartDemo3.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)highLowChartDemo3));
        highLowChartDemo3.setVisible(true);
    }
}

