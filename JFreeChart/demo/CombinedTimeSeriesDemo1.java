/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartMouseEvent
 *  org.jfree.chart.ChartMouseListener
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.entity.ChartEntity
 *  org.jfree.chart.labels.StandardXYToolTipGenerator
 *  org.jfree.chart.labels.XYToolTipGenerator
 *  org.jfree.chart.plot.CombinedRangeXYPlot
 *  org.jfree.chart.plot.DatasetRenderingOrder
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.StandardXYItemRenderer
 *  org.jfree.chart.renderer.xy.XYAreaRenderer
 *  org.jfree.chart.renderer.xy.XYBarRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.time.Month
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.time.Year
 *  org.jfree.data.xy.XYDataset
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
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CombinedRangeXYPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class CombinedTimeSeriesDemo1
extends ApplicationFrame {
    public CombinedTimeSeriesDemo1(String string) {
        super(string);
        this.setContentPane((Container)CombinedTimeSeriesDemo1.createDemoPanel());
    }

    public static JPanel createDemoPanel() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Annual"));
        timeSeries.add((RegularTimePeriod)new Year(1998), 80.0);
        timeSeries.add((RegularTimePeriod)new Year(1999), 85.0);
        timeSeries.add((RegularTimePeriod)new Year(2000), 87.6);
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection(timeSeries);
        TimeSeries timeSeries2 = new TimeSeries((Comparable)((Object)"Monthly A"));
        timeSeries2.add((RegularTimePeriod)new Month(7, 2000), 85.8);
        timeSeries2.add((RegularTimePeriod)new Month(8, 2000), 85.8);
        timeSeries2.add((RegularTimePeriod)new Month(9, 2000), 85.8);
        timeSeries2.add((RegularTimePeriod)new Month(10, 2000), 86.5);
        timeSeries2.add((RegularTimePeriod)new Month(11, 2000), 86.5);
        timeSeries2.add((RegularTimePeriod)new Month(12, 2000), 86.5);
        timeSeries2.add((RegularTimePeriod)new Month(1, 2001), 87.7);
        timeSeries2.add((RegularTimePeriod)new Month(2, 2001), 87.7);
        timeSeries2.add((RegularTimePeriod)new Month(3, 2001), 87.7);
        timeSeries2.add((RegularTimePeriod)new Month(4, 2001), 88.5);
        timeSeries2.add((RegularTimePeriod)new Month(5, 2001), 88.5);
        timeSeries2.add((RegularTimePeriod)new Month(6, 2001), 88.5);
        timeSeries2.add((RegularTimePeriod)new Month(7, 2001), 90.0);
        timeSeries2.add((RegularTimePeriod)new Month(8, 2001), 90.0);
        timeSeries2.add((RegularTimePeriod)new Month(9, 2001), 90.0);
        timeSeries2.add((RegularTimePeriod)new Month(10, 2001), 90.0);
        timeSeries2.add((RegularTimePeriod)new Month(11, 2001), 90.0);
        timeSeries2.add((RegularTimePeriod)new Month(12, 2001), 90.0);
        timeSeries2.add((RegularTimePeriod)new Month(1, 2002), 90.0);
        timeSeries2.add((RegularTimePeriod)new Month(2, 2002), 90.0);
        timeSeries2.add((RegularTimePeriod)new Month(3, 2002), 90.0);
        timeSeries2.add((RegularTimePeriod)new Month(4, 2002), 90.0);
        timeSeries2.add((RegularTimePeriod)new Month(5, 2002), 90.0);
        timeSeries2.add((RegularTimePeriod)new Month(6, 2002), 90.0);
        TimeSeries timeSeries3 = new TimeSeries((Comparable)((Object)"Monthly B"));
        timeSeries3.add((RegularTimePeriod)new Month(7, 2000), 83.8);
        timeSeries3.add((RegularTimePeriod)new Month(8, 2000), 83.8);
        timeSeries3.add((RegularTimePeriod)new Month(9, 2000), 83.8);
        timeSeries3.add((RegularTimePeriod)new Month(10, 2000), 84.5);
        timeSeries3.add((RegularTimePeriod)new Month(11, 2000), 84.5);
        timeSeries3.add((RegularTimePeriod)new Month(12, 2000), 84.5);
        timeSeries3.add((RegularTimePeriod)new Month(1, 2001), 85.7);
        timeSeries3.add((RegularTimePeriod)new Month(2, 2001), 85.7);
        timeSeries3.add((RegularTimePeriod)new Month(3, 2001), 85.7);
        timeSeries3.add((RegularTimePeriod)new Month(4, 2001), 86.5);
        timeSeries3.add((RegularTimePeriod)new Month(5, 2001), 86.5);
        timeSeries3.add((RegularTimePeriod)new Month(6, 2001), 86.5);
        timeSeries3.add((RegularTimePeriod)new Month(7, 2001), 88.0);
        timeSeries3.add((RegularTimePeriod)new Month(8, 2001), 88.0);
        timeSeries3.add((RegularTimePeriod)new Month(9, 2001), 88.0);
        timeSeries3.add((RegularTimePeriod)new Month(10, 2001), 88.0);
        timeSeries3.add((RegularTimePeriod)new Month(11, 2001), 88.0);
        timeSeries3.add((RegularTimePeriod)new Month(12, 2001), 88.0);
        timeSeries3.add((RegularTimePeriod)new Month(1, 2002), 88.0);
        timeSeries3.add((RegularTimePeriod)new Month(2, 2002), 88.0);
        timeSeries3.add((RegularTimePeriod)new Month(3, 2002), 88.0);
        timeSeries3.add((RegularTimePeriod)new Month(4, 2002), 88.0);
        timeSeries3.add((RegularTimePeriod)new Month(5, 2002), 88.0);
        timeSeries3.add((RegularTimePeriod)new Month(6, 2002), 88.0);
        TimeSeriesCollection timeSeriesCollection2 = new TimeSeriesCollection();
        timeSeriesCollection2.addSeries(timeSeries2);
        timeSeriesCollection2.addSeries(timeSeries3);
        TimeSeries timeSeries4 = new TimeSeries((Comparable)((Object)"XXX"));
        timeSeries4.add((RegularTimePeriod)new Month(7, 2000), 81.5);
        timeSeries4.add((RegularTimePeriod)new Month(8, 2000), 86.0);
        timeSeries4.add((RegularTimePeriod)new Month(9, 2000), 82.0);
        timeSeries4.add((RegularTimePeriod)new Month(10, 2000), 89.5);
        timeSeries4.add((RegularTimePeriod)new Month(11, 2000), 88.0);
        timeSeries4.add((RegularTimePeriod)new Month(12, 2000), 88.0);
        timeSeries4.add((RegularTimePeriod)new Month(1, 2001), 90.0);
        timeSeries4.add((RegularTimePeriod)new Month(2, 2001), 89.5);
        timeSeries4.add((RegularTimePeriod)new Month(3, 2001), 90.2);
        timeSeries4.add((RegularTimePeriod)new Month(4, 2001), 90.6);
        timeSeries4.add((RegularTimePeriod)new Month(5, 2001), 87.5);
        timeSeries4.add((RegularTimePeriod)new Month(6, 2001), 91.0);
        timeSeries4.add((RegularTimePeriod)new Month(7, 2001), 89.7);
        timeSeries4.add((RegularTimePeriod)new Month(8, 2001), 87.0);
        timeSeries4.add((RegularTimePeriod)new Month(9, 2001), 91.2);
        timeSeries4.add((RegularTimePeriod)new Month(10, 2001), 84.0);
        timeSeries4.add((RegularTimePeriod)new Month(11, 2001), 90.0);
        timeSeries4.add((RegularTimePeriod)new Month(12, 2001), 92.0);
        TimeSeriesCollection timeSeriesCollection3 = new TimeSeriesCollection(timeSeries4);
        XYBarRenderer xYBarRenderer = new XYBarRenderer(0.2);
        xYBarRenderer.setBaseToolTipGenerator((XYToolTipGenerator)new StandardXYToolTipGenerator("{0} ({1}, {2})", (DateFormat)new SimpleDateFormat("yyyy"), (NumberFormat)new DecimalFormat("0.00")));
        XYPlot xYPlot = new XYPlot((XYDataset)timeSeriesCollection, (ValueAxis)new DateAxis("Date"), null, (XYItemRenderer)xYBarRenderer);
        XYAreaRenderer xYAreaRenderer = new XYAreaRenderer();
        XYPlot xYPlot2 = new XYPlot((XYDataset)timeSeriesCollection2, (ValueAxis)new DateAxis("Date"), null, (XYItemRenderer)xYAreaRenderer);
        StandardXYItemRenderer standardXYItemRenderer = new StandardXYItemRenderer(3);
        standardXYItemRenderer.setBaseShapesFilled(true);
        xYPlot2.setDataset(1, (XYDataset)timeSeriesCollection3);
        xYPlot2.setRenderer(1, (XYItemRenderer)standardXYItemRenderer);
        xYPlot2.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
        NumberAxis numberAxis = new NumberAxis("Value");
        numberAxis.setAutoRangeIncludesZero(false);
        CombinedRangeXYPlot combinedRangeXYPlot = new CombinedRangeXYPlot((ValueAxis)numberAxis);
        combinedRangeXYPlot.add(xYPlot, 1);
        combinedRangeXYPlot.add(xYPlot2, 4);
        JFreeChart jFreeChart = new JFreeChart("Sample Combined Plot", JFreeChart.DEFAULT_TITLE_FONT, (Plot)combinedRangeXYPlot, true);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        chartPanel.addChartMouseListener(new ChartMouseListener(){

            public void chartMouseClicked(ChartMouseEvent chartMouseEvent) {
                System.out.println((Object)chartMouseEvent.getEntity());
            }

            public void chartMouseMoved(ChartMouseEvent chartMouseEvent) {
                System.out.println((Object)chartMouseEvent.getEntity());
            }
        });
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        CombinedTimeSeriesDemo1 combinedTimeSeriesDemo1 = new CombinedTimeSeriesDemo1("JFreeChart: CombinedTimeSeriesDemo1.java");
        combinedTimeSeriesDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)combinedTimeSeriesDemo1));
        combinedTimeSeriesDemo1.setVisible(true);
    }

}

