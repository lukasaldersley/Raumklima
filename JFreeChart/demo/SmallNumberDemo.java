/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.StandardTickUnitSource
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.XYSeries
 *  org.jfree.data.xy.XYSeriesCollection
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import java.io.PrintStream;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.StandardTickUnitSource;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class SmallNumberDemo
extends ApplicationFrame {
    public SmallNumberDemo(String string) {
        super(string);
        XYSeries xYSeries = new XYSeries((Comparable)((Object)"Small Numbers"));
        xYSeries.add(1.0E-5, 1.0E-16);
        xYSeries.add(5.0E-5, 2.0E-12);
        XYSeriesCollection xYSeriesCollection = new XYSeriesCollection(xYSeries);
        JFreeChart jFreeChart = ChartFactory.createXYLineChart((String)"Small Number Demo", (String)"X", (String)"Y", (XYDataset)xYSeriesCollection, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        NumberAxis numberAxis = (NumberAxis)xYPlot.getDomainAxis();
        numberAxis.setStandardTickUnits((TickUnitSource)new StandardTickUnitSource());
        NumberAxis numberAxis2 = (NumberAxis)xYPlot.getRangeAxis();
        numberAxis2.setStandardTickUnits((TickUnitSource)new StandardTickUnitSource());
        numberAxis2.setAutoRangeMinimumSize(Double.MIN_VALUE);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)chartPanel);
    }

    public static void main(String[] arrstring) {
        System.out.println("Min Double: 4.9E-324");
        SmallNumberDemo smallNumberDemo = new SmallNumberDemo("Small Number Demo");
        smallNumberDemo.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)smallNumberDemo));
        smallNumberDemo.setVisible(true);
    }
}

