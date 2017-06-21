/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartFrame
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.XYToolTipGenerator
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.StandardXYItemRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.XYSeries
 *  org.jfree.data.xy.XYSeriesCollection
 */
package demo;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Second {
    public static void main(String[] arrstring) {
        XYSeries xYSeries = new XYSeries((Comparable)((Object)"Advisory Range"));
        xYSeries.add((Number)new Integer(1200), (Number)new Integer(1));
        xYSeries.add((Number)new Integer(1500), (Number)new Integer(1));
        XYSeries xYSeries2 = new XYSeries((Comparable)((Object)"Normal Range"));
        xYSeries2.add((Number)new Integer(2000), (Number)new Integer(4));
        xYSeries2.add((Number)new Integer(2300), (Number)new Integer(4));
        XYSeries xYSeries3 = new XYSeries((Comparable)((Object)"Recommended"));
        xYSeries3.add((Number)new Integer(2100), (Number)new Integer(2));
        XYSeries xYSeries4 = new XYSeries((Comparable)((Object)"Current"));
        xYSeries4.add((Number)new Integer(2400), (Number)new Integer(3));
        XYSeriesCollection xYSeriesCollection = new XYSeriesCollection();
        xYSeriesCollection.addSeries(xYSeries);
        xYSeriesCollection.addSeries(xYSeries2);
        xYSeriesCollection.addSeries(xYSeries3);
        xYSeriesCollection.addSeries(xYSeries4);
        JFreeChart jFreeChart = ChartFactory.createXYLineChart((String)"My Chart", (String)"Calories", (String)"Y", (XYDataset)xYSeriesCollection, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        StandardXYItemRenderer standardXYItemRenderer = new StandardXYItemRenderer(3, null);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setRenderer((XYItemRenderer)standardXYItemRenderer);
        ValueAxis valueAxis = xYPlot.getRangeAxis();
        valueAxis.setTickLabelsVisible(false);
        valueAxis.setRange(0.0, 5.0);
        ChartFrame chartFrame = new ChartFrame("Test", jFreeChart);
        chartFrame.pack();
        chartFrame.setVisible(true);
    }
}

