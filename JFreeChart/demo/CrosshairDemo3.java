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
 *  org.jfree.data.Range
 *  org.jfree.data.time.Month
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import demo.DemoPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Window;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.Range;
import org.jfree.data.time.Month;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class CrosshairDemo3
extends ApplicationFrame {
    public CrosshairDemo3(String string) {
        super(string);
        this.setContentPane((Container)CrosshairDemo3.createDemoPanel());
    }

    public static JPanel createDemoPanel() {
        return new MyDemoPanel();
    }

    public static void main(String[] arrstring) {
        CrosshairDemo3 crosshairDemo3 = new CrosshairDemo3("JFreeChart: CrosshairDemo3.java");
        crosshairDemo3.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)crosshairDemo3));
        crosshairDemo3.setVisible(true);
    }

    static class MyDemoPanel
    extends DemoPanel
    implements ChangeListener {
        private JFreeChart chart;
        private JSlider slider;

        public MyDemoPanel() {
            super(new BorderLayout());
            XYDataset xYDataset = this.createDataset();
            this.chart = this.createChart(xYDataset);
            this.addChart(this.chart);
            ChartPanel chartPanel = new ChartPanel(this.chart);
            chartPanel.setPreferredSize(new Dimension(500, 270));
            chartPanel.setMouseZoomable(true);
            JPanel jPanel = new JPanel(new BorderLayout());
            this.slider = new JSlider(0, 100, 50);
            this.slider.addChangeListener(this);
            jPanel.add(this.slider);
            this.add((Component)chartPanel);
            this.add((Component)jPanel, "South");
        }

        private JFreeChart createChart(XYDataset xYDataset) {
            XYLineAndShapeRenderer xYLineAndShapeRenderer;
            JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Legal & General Unit Trust Prices", (String)"Date", (String)"Price Per Unit", (XYDataset)xYDataset, (boolean)true, (boolean)true, (boolean)false);
            XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
            xYPlot.setDomainCrosshairVisible(true);
            xYPlot.setDomainCrosshairLockedOnData(false);
            xYPlot.setRangeCrosshairVisible(false);
            XYItemRenderer xYItemRenderer = xYPlot.getRenderer();
            if (xYItemRenderer instanceof XYLineAndShapeRenderer) {
                xYLineAndShapeRenderer = (XYLineAndShapeRenderer)xYItemRenderer;
                xYLineAndShapeRenderer.setBaseShapesVisible(true);
                xYLineAndShapeRenderer.setBaseShapesFilled(true);
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

        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            int n = this.slider.getValue();
            XYPlot xYPlot = (XYPlot)this.chart.getPlot();
            ValueAxis valueAxis = xYPlot.getDomainAxis();
            Range range = valueAxis.getRange();
            double d = valueAxis.getLowerBound() + (double)n / 100.0 * range.getLength();
            xYPlot.setDomainCrosshairValue(d);
        }
    }

}

