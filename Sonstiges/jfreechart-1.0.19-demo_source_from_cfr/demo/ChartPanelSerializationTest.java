/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
 *  org.jfree.data.time.Month
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RectangleInsets
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Window;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class ChartPanelSerializationTest
extends ApplicationFrame {
    public ChartPanelSerializationTest(String string) {
        super(string);
        XYDataset xYDataset = this.createDataset();
        JFreeChart jFreeChart = this.createChart(xYDataset);
        ChartPanel chartPanel = new ChartPanel(jFreeChart, true);
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        chartPanel.setMouseZoomable(true, true);
        ChartPanel chartPanel2 = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject((Object)chartPanel);
            objectOutputStream.close();
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            chartPanel2 = (ChartPanel)objectInputStream.readObject();
            objectInputStream.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        this.setContentPane((Container)chartPanel2);
    }

    private JFreeChart createChart(XYDataset xYDataset) {
        XYLineAndShapeRenderer xYLineAndShapeRenderer;
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Legal & General Unit Trust Prices", (String)"Date", (String)"Price Per Unit", (XYDataset)xYDataset, (boolean)true, (boolean)true, (boolean)false);
        jFreeChart.setBackgroundPaint((Paint)Color.white);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setBackgroundPaint((Paint)Color.lightGray);
        xYPlot.setDomainGridlinePaint((Paint)Color.white);
        xYPlot.setRangeGridlinePaint((Paint)Color.white);
        xYPlot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        xYPlot.setDomainCrosshairVisible(true);
        xYPlot.setRangeCrosshairVisible(true);
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(false);
        XYItemRenderer xYItemRenderer = xYPlot.getRenderer();
        if (xYItemRenderer instanceof XYLineAndShapeRenderer) {
            xYLineAndShapeRenderer = (XYLineAndShapeRenderer)xYItemRenderer;
            xYLineAndShapeRenderer.setBaseShapesVisible(true);
            xYLineAndShapeRenderer.setBaseShapesFilled(true);
            xYLineAndShapeRenderer.setBaseItemLabelsVisible(true);
        }
        xYLineAndShapeRenderer = (DateAxis)xYPlot.getDomainAxis();
        xYLineAndShapeRenderer.setDateFormatOverride((DateFormat)new SimpleDateFormat("MMM-yyyy"));
        return jFreeChart;
    }

    private XYDataset createDataset() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"L&G European Index Trust"));
        timeSeries.add((RegularTimePeriod)new Month(2, 2001), 181.8);
        timeSeries.add((RegularTimePeriod)new Month(3, 2001), 167.3);
        timeSeries.add((RegularTimePeriod)new Month(4, 2001), 153.8);
        timeSeries.add((RegularTimePeriod)new Month(5, 2001), 167.6);
        timeSeries.add((RegularTimePeriod)new Month(6, 2001), 158.8);
        timeSeries.add((RegularTimePeriod)new Month(7, 2001), 148.3);
        timeSeries.add((RegularTimePeriod)new Month(8, 2001), 153.9);
        timeSeries.add((RegularTimePeriod)new Month(9, 2001), 142.7);
        timeSeries.add((RegularTimePeriod)new Month(10, 2001), 123.2);
        timeSeries.add((RegularTimePeriod)new Month(11, 2001), 131.8);
        timeSeries.add((RegularTimePeriod)new Month(12, 2001), 139.6);
        timeSeries.add((RegularTimePeriod)new Month(1, 2002), 142.9);
        timeSeries.add((RegularTimePeriod)new Month(2, 2002), 138.7);
        timeSeries.add((RegularTimePeriod)new Month(3, 2002), 137.3);
        timeSeries.add((RegularTimePeriod)new Month(4, 2002), 143.9);
        timeSeries.add((RegularTimePeriod)new Month(5, 2002), 139.8);
        timeSeries.add((RegularTimePeriod)new Month(6, 2002), 137.0);
        timeSeries.add((RegularTimePeriod)new Month(7, 2002), 132.8);
        TimeSeries timeSeries2 = new TimeSeries((Comparable)((Object)"L&G UK Index Trust"));
        timeSeries2.add((RegularTimePeriod)new Month(2, 2001), 129.6);
        timeSeries2.add((RegularTimePeriod)new Month(3, 2001), 123.2);
        timeSeries2.add((RegularTimePeriod)new Month(4, 2001), 117.2);
        timeSeries2.add((RegularTimePeriod)new Month(5, 2001), 124.1);
        timeSeries2.add((RegularTimePeriod)new Month(6, 2001), 122.6);
        timeSeries2.add((RegularTimePeriod)new Month(7, 2001), 119.2);
        timeSeries2.add((RegularTimePeriod)new Month(8, 2001), 116.5);
        timeSeries2.add((RegularTimePeriod)new Month(9, 2001), 112.7);
        timeSeries2.add((RegularTimePeriod)new Month(10, 2001), 101.5);
        timeSeries2.add((RegularTimePeriod)new Month(11, 2001), 106.1);
        timeSeries2.add((RegularTimePeriod)new Month(12, 2001), 110.3);
        timeSeries2.add((RegularTimePeriod)new Month(1, 2002), 111.7);
        timeSeries2.add((RegularTimePeriod)new Month(2, 2002), 111.0);
        timeSeries2.add((RegularTimePeriod)new Month(3, 2002), 109.6);
        timeSeries2.add((RegularTimePeriod)new Month(4, 2002), 113.2);
        timeSeries2.add((RegularTimePeriod)new Month(5, 2002), 111.6);
        timeSeries2.add((RegularTimePeriod)new Month(6, 2002), 108.8);
        timeSeries2.add((RegularTimePeriod)new Month(7, 2002), 101.6);
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        timeSeriesCollection.addSeries(timeSeries);
        timeSeriesCollection.addSeries(timeSeries2);
        return timeSeriesCollection;
    }

    public static void main(String[] arrstring) {
        ChartPanelSerializationTest chartPanelSerializationTest = new ChartPanelSerializationTest("Serialization Test");
        chartPanelSerializationTest.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)chartPanelSerializationTest));
        chartPanelSerializationTest.setVisible(true);
    }
}

