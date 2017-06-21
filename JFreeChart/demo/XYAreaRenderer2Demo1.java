/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYAreaRenderer2
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.XYSeries
 *  org.jfree.data.xy.XYSeriesCollection
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
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYAreaRenderer2;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYAreaRenderer2Demo1
extends ApplicationFrame {
    public XYAreaRenderer2Demo1(String string) {
        super(string);
        JPanel jPanel = XYAreaRenderer2Demo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static XYDataset createDataset() {
        XYSeries xYSeries = new XYSeries((Comparable)((Object)"Random 1"));
        xYSeries.add((Number)new Integer(1), (Number)new Double(500.2));
        xYSeries.add((Number)new Integer(2), (Number)new Double(694.1));
        xYSeries.add((Number)new Integer(3), (Number)new Double(-734.4));
        xYSeries.add((Number)new Integer(4), (Number)new Double(453.2));
        xYSeries.add((Number)new Integer(5), (Number)new Double(500.2));
        xYSeries.add((Number)new Integer(6), (Number)new Double(300.7));
        xYSeries.add((Number)new Integer(7), (Number)new Double(734.4));
        xYSeries.add((Number)new Integer(8), (Number)new Double(453.2));
        XYSeries xYSeries2 = new XYSeries((Comparable)((Object)"Random 2"));
        xYSeries2.add((Number)new Integer(1), (Number)new Double(700.2));
        xYSeries2.add((Number)new Integer(2), (Number)new Double(534.1));
        xYSeries2.add((Number)new Integer(3), (Number)new Double(323.4));
        xYSeries2.add((Number)new Integer(4), (Number)new Double(125.2));
        xYSeries2.add((Number)new Integer(5), (Number)new Double(653.2));
        xYSeries2.add((Number)new Integer(6), (Number)new Double(432.7));
        xYSeries2.add((Number)new Integer(7), (Number)new Double(564.4));
        xYSeries2.add((Number)new Integer(8), (Number)new Double(322.2));
        XYSeriesCollection xYSeriesCollection = new XYSeriesCollection();
        xYSeriesCollection.addSeries(xYSeries);
        xYSeriesCollection.addSeries(xYSeries2);
        xYSeriesCollection.setIntervalWidth(0.0);
        return xYSeriesCollection;
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYAreaChart((String)"XYAreaRenderer2Demo1", (String)"Domain (X)", (String)"Range (Y)", (XYDataset)xYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setRenderer((XYItemRenderer)new XYAreaRenderer2());
        xYPlot.setForegroundAlpha(0.65f);
        ValueAxis valueAxis = xYPlot.getDomainAxis();
        valueAxis.setTickMarkPaint((Paint)Color.black);
        valueAxis.setLowerMargin(0.0);
        valueAxis.setUpperMargin(0.0);
        ValueAxis valueAxis2 = xYPlot.getRangeAxis();
        valueAxis2.setTickMarkPaint((Paint)Color.black);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        return new ChartPanel(XYAreaRenderer2Demo1.createChart(XYAreaRenderer2Demo1.createDataset()));
    }

    public static void main(String[] arrstring) {
        XYAreaRenderer2Demo1 xYAreaRenderer2Demo1 = new XYAreaRenderer2Demo1("XYAreaRenderer2Demo1");
        xYAreaRenderer2Demo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)xYAreaRenderer2Demo1));
        xYAreaRenderer2Demo1.setVisible(true);
    }
}

