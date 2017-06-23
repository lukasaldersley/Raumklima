/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.AxisLocation
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.StandardXYItemRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.title.TextTitle
 *  org.jfree.chart.title.Title
 *  org.jfree.data.time.Minute
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.time.Minute;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class MultipleAxisDemo1
extends ApplicationFrame {
    public MultipleAxisDemo1(String string) {
        super(string);
        ChartPanel chartPanel = (ChartPanel)MultipleAxisDemo1.createDemoPanel();
        chartPanel.setPreferredSize(new Dimension(600, 270));
        chartPanel.setDomainZoomable(true);
        chartPanel.setRangeZoomable(true);
        this.setContentPane((Container)chartPanel);
    }

    private static JFreeChart createChart() {
        XYDataset xYDataset = MultipleAxisDemo1.createDataset("Series 1", 100.0, (RegularTimePeriod)new Minute(), 200);
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Multiple Axis Demo 1", (String)"Time of Day", (String)"Primary Range Axis", (XYDataset)xYDataset, (boolean)true, (boolean)true, (boolean)false);
        jFreeChart.addSubtitle((Title)new TextTitle("Four datasets and four range axes."));
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setOrientation(PlotOrientation.VERTICAL);
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        NumberAxis numberAxis = new NumberAxis("Range Axis 2");
        numberAxis.setAutoRangeIncludesZero(false);
        xYPlot.setRangeAxis(1, (ValueAxis)numberAxis);
        xYPlot.setRangeAxisLocation(1, AxisLocation.BOTTOM_OR_LEFT);
        XYDataset xYDataset2 = MultipleAxisDemo1.createDataset("Series 2", 1000.0, (RegularTimePeriod)new Minute(), 170);
        xYPlot.setDataset(1, xYDataset2);
        xYPlot.mapDatasetToRangeAxis(1, 1);
        StandardXYItemRenderer standardXYItemRenderer = new StandardXYItemRenderer();
        xYPlot.setRenderer(1, (XYItemRenderer)standardXYItemRenderer);
        NumberAxis numberAxis2 = new NumberAxis("Range Axis 3");
        xYPlot.setRangeAxis(2, (ValueAxis)numberAxis2);
        XYDataset xYDataset3 = MultipleAxisDemo1.createDataset("Series 3", 10000.0, (RegularTimePeriod)new Minute(), 170);
        xYPlot.setDataset(2, xYDataset3);
        xYPlot.mapDatasetToRangeAxis(2, 2);
        StandardXYItemRenderer standardXYItemRenderer2 = new StandardXYItemRenderer();
        xYPlot.setRenderer(2, (XYItemRenderer)standardXYItemRenderer2);
        NumberAxis numberAxis3 = new NumberAxis("Range Axis 4");
        xYPlot.setRangeAxis(3, (ValueAxis)numberAxis3);
        XYDataset xYDataset4 = MultipleAxisDemo1.createDataset("Series 4", 25.0, (RegularTimePeriod)new Minute(), 200);
        xYPlot.setDataset(3, xYDataset4);
        xYPlot.mapDatasetToRangeAxis(3, 3);
        StandardXYItemRenderer standardXYItemRenderer3 = new StandardXYItemRenderer();
        xYPlot.setRenderer(3, (XYItemRenderer)standardXYItemRenderer3);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        xYPlot.getRenderer().setSeriesPaint(0, (Paint)Color.black);
        standardXYItemRenderer.setSeriesPaint(0, (Paint)Color.red);
        numberAxis.setLabelPaint((Paint)Color.red);
        numberAxis.setTickLabelPaint((Paint)Color.red);
        standardXYItemRenderer2.setSeriesPaint(0, (Paint)Color.blue);
        numberAxis2.setLabelPaint((Paint)Color.blue);
        numberAxis2.setTickLabelPaint((Paint)Color.blue);
        standardXYItemRenderer3.setSeriesPaint(0, (Paint)Color.green);
        numberAxis3.setLabelPaint((Paint)Color.green);
        numberAxis3.setTickLabelPaint((Paint)Color.green);
        return jFreeChart;
    }

    private static XYDataset createDataset(String string, double d, RegularTimePeriod regularTimePeriod, int n) {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)string));
        RegularTimePeriod regularTimePeriod2 = regularTimePeriod;
        double d2 = d;
        for (int i = 0; i < n; ++i) {
            timeSeries.add(regularTimePeriod2, d2);
            regularTimePeriod2 = regularTimePeriod2.next();
            d2 *= 1.0 + (Math.random() - 0.495) / 10.0;
        }
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        timeSeriesCollection.addSeries(timeSeries);
        return timeSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = MultipleAxisDemo1.createChart();
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        MultipleAxisDemo1 multipleAxisDemo1 = new MultipleAxisDemo1("JFreeChart: MultipleAxisDemo1.java");
        multipleAxisDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)multipleAxisDemo1));
        multipleAxisDemo1.setVisible(true);
    }
}

