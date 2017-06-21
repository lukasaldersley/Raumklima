/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.DeviationRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.time.Quarter
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.YIntervalSeries
 *  org.jfree.data.xy.YIntervalSeriesCollection
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
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.DeviationRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Quarter;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.YIntervalSeries;
import org.jfree.data.xy.YIntervalSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class DeviationRendererDemo3
extends ApplicationFrame {
    public DeviationRendererDemo3(String string) {
        super(string);
        JPanel jPanel = DeviationRendererDemo3.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static XYDataset createDataset() {
        YIntervalSeries yIntervalSeries = new YIntervalSeries((Comparable)((Object)"Band A"));
        YIntervalSeries yIntervalSeries2 = new YIntervalSeries((Comparable)((Object)"Band B"));
        YIntervalSeries yIntervalSeries3 = new YIntervalSeries((Comparable)((Object)"Band C"));
        Quarter quarter = new Quarter(1, 2005);
        double d = 0.0;
        for (int i = 0; i <= 12; ++i) {
            yIntervalSeries.add((double)quarter.getMiddleMillisecond(), d, d + 10.0, Math.max(50.0, (d += (Math.random() - 0.5) * 15.0) + 30.0));
            yIntervalSeries2.add((double)quarter.getMiddleMillisecond(), d, d - 10.0, d + 10.0);
            yIntervalSeries3.add((double)quarter.getMiddleMillisecond(), d, Math.min(-50.0, d - 30.0), d - 10.0);
            quarter = quarter.next();
        }
        YIntervalSeriesCollection yIntervalSeriesCollection = new YIntervalSeriesCollection();
        yIntervalSeriesCollection.addSeries(yIntervalSeries);
        yIntervalSeriesCollection.addSeries(yIntervalSeries2);
        yIntervalSeriesCollection.addSeries(yIntervalSeries3);
        return yIntervalSeriesCollection;
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYLineChart((String)"DeviationRenderer - Demo 3", (String)"X", (String)"Y", (XYDataset)xYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)false, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        DeviationRenderer deviationRenderer = new DeviationRenderer(false, false);
        deviationRenderer.setSeriesStroke(0, (Stroke)new BasicStroke(3.0f, 1, 1));
        deviationRenderer.setSeriesStroke(0, (Stroke)new BasicStroke(3.0f, 1, 1));
        deviationRenderer.setSeriesStroke(1, (Stroke)new BasicStroke(3.0f, 1, 1));
        deviationRenderer.setSeriesFillPaint(0, (Paint)Color.red);
        deviationRenderer.setSeriesFillPaint(1, (Paint)Color.orange);
        deviationRenderer.setSeriesFillPaint(2, (Paint)Color.green);
        xYPlot.setRenderer((XYItemRenderer)deviationRenderer);
        DateAxis dateAxis = new DateAxis("Date");
        dateAxis.setLowerMargin(0.0);
        dateAxis.setUpperMargin(0.0);
        xYPlot.setDomainAxis((ValueAxis)dateAxis);
        NumberAxis numberAxis = (NumberAxis)xYPlot.getRangeAxis();
        numberAxis.setRange(-40.0, 40.0);
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = DeviationRendererDemo3.createChart(DeviationRendererDemo3.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        DeviationRendererDemo3 deviationRendererDemo3 = new DeviationRendererDemo3("JFreeChart : DeviationRendererDemo3.java");
        deviationRendererDemo3.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)deviationRendererDemo3));
        deviationRendererDemo3.setVisible(true);
    }
}

