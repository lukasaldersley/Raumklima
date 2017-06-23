/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.LegendItemSource
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.block.Arrangement
 *  org.jfree.chart.block.Block
 *  org.jfree.chart.block.BlockContainer
 *  org.jfree.chart.block.BorderArrangement
 *  org.jfree.chart.block.EmptyBlock
 *  org.jfree.chart.labels.StandardXYToolTipGenerator
 *  org.jfree.chart.labels.XYToolTipGenerator
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
 *  org.jfree.chart.title.CompositeTitle
 *  org.jfree.chart.title.LegendTitle
 *  org.jfree.chart.title.Title
 *  org.jfree.data.time.Month
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RectangleEdge
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Window;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItemSource;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.block.Arrangement;
import org.jfree.chart.block.Block;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.BorderArrangement;
import org.jfree.chart.block.EmptyBlock;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.CompositeTitle;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.time.Month;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;

public class DualAxisDemo2
extends ApplicationFrame {
    public DualAxisDemo2(String string) {
        super(string);
        JPanel jPanel = DualAxisDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static XYDataset createDataset1() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Random Data 1"));
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
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        timeSeriesCollection.addSeries(timeSeries);
        return timeSeriesCollection;
    }

    private static XYDataset createDataset2() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Random Data 2"));
        timeSeries.add((RegularTimePeriod)new Month(2, 2001), 429.6);
        timeSeries.add((RegularTimePeriod)new Month(3, 2001), 323.2);
        timeSeries.add((RegularTimePeriod)new Month(4, 2001), 417.2);
        timeSeries.add((RegularTimePeriod)new Month(5, 2001), 624.1);
        timeSeries.add((RegularTimePeriod)new Month(6, 2001), 422.6);
        timeSeries.add((RegularTimePeriod)new Month(7, 2001), 619.2);
        timeSeries.add((RegularTimePeriod)new Month(8, 2001), 416.5);
        timeSeries.add((RegularTimePeriod)new Month(9, 2001), 512.7);
        timeSeries.add((RegularTimePeriod)new Month(10, 2001), 501.5);
        timeSeries.add((RegularTimePeriod)new Month(11, 2001), 306.1);
        timeSeries.add((RegularTimePeriod)new Month(12, 2001), 410.3);
        timeSeries.add((RegularTimePeriod)new Month(1, 2002), 511.7);
        timeSeries.add((RegularTimePeriod)new Month(2, 2002), 611.0);
        timeSeries.add((RegularTimePeriod)new Month(3, 2002), 709.6);
        timeSeries.add((RegularTimePeriod)new Month(4, 2002), 613.2);
        timeSeries.add((RegularTimePeriod)new Month(5, 2002), 711.6);
        timeSeries.add((RegularTimePeriod)new Month(6, 2002), 708.8);
        timeSeries.add((RegularTimePeriod)new Month(7, 2002), 501.6);
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        timeSeriesCollection.addSeries(timeSeries);
        return timeSeriesCollection;
    }

    private static JFreeChart createChart() {
        XYLineAndShapeRenderer xYLineAndShapeRenderer;
        XYDataset xYDataset = DualAxisDemo2.createDataset1();
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Dual Axis Demo 2", (String)"Date", (String)"Price Per Unit", (XYDataset)xYDataset, (boolean)false, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        NumberAxis numberAxis = new NumberAxis("Secondary");
        numberAxis.setAutoRangeIncludesZero(false);
        xYPlot.setRangeAxis(1, (ValueAxis)numberAxis);
        xYPlot.setDataset(1, DualAxisDemo2.createDataset2());
        xYPlot.mapDatasetToRangeAxis(1, 1);
        XYItemRenderer xYItemRenderer = xYPlot.getRenderer();
        xYItemRenderer.setBaseToolTipGenerator((XYToolTipGenerator)StandardXYToolTipGenerator.getTimeSeriesInstance());
        if (xYItemRenderer instanceof XYLineAndShapeRenderer) {
            xYLineAndShapeRenderer = (XYLineAndShapeRenderer)xYItemRenderer;
            xYLineAndShapeRenderer.setBaseShapesVisible(true);
            xYLineAndShapeRenderer.setBaseShapesFilled(true);
        }
        xYLineAndShapeRenderer = new XYLineAndShapeRenderer();
        xYLineAndShapeRenderer.setSeriesPaint(0, (Paint)Color.black);
        xYLineAndShapeRenderer.setBaseShapesVisible(true);
        xYLineAndShapeRenderer.setBaseToolTipGenerator((XYToolTipGenerator)StandardXYToolTipGenerator.getTimeSeriesInstance());
        xYPlot.setRenderer(1, (XYItemRenderer)xYLineAndShapeRenderer);
        DateAxis dateAxis = (DateAxis)xYPlot.getDomainAxis();
        dateAxis.setDateFormatOverride((DateFormat)new SimpleDateFormat("MMM-yyyy"));
        LegendTitle legendTitle = new LegendTitle((LegendItemSource)xYItemRenderer);
        LegendTitle legendTitle2 = new LegendTitle((LegendItemSource)xYLineAndShapeRenderer);
        BlockContainer blockContainer = new BlockContainer((Arrangement)new BorderArrangement());
        blockContainer.add((Block)legendTitle, (Object)RectangleEdge.LEFT);
        blockContainer.add((Block)legendTitle2, (Object)RectangleEdge.RIGHT);
        blockContainer.add((Block)new EmptyBlock(2000.0, 0.0));
        CompositeTitle compositeTitle = new CompositeTitle(blockContainer);
        compositeTitle.setPosition(RectangleEdge.BOTTOM);
        jFreeChart.addSubtitle((Title)compositeTitle);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = DualAxisDemo2.createChart();
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        DualAxisDemo2 dualAxisDemo2 = new DualAxisDemo2("JFreeChart: DualAxisDemo2.java");
        dualAxisDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)dualAxisDemo2));
        dualAxisDemo2.setVisible(true);
    }
}

