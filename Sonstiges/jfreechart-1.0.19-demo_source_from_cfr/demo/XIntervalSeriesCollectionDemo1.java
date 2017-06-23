/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYBarRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.xy.IntervalXYDataset
 *  org.jfree.data.xy.XIntervalSeries
 *  org.jfree.data.xy.XIntervalSeriesCollection
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
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XIntervalSeries;
import org.jfree.data.xy.XIntervalSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XIntervalSeriesCollectionDemo1
extends ApplicationFrame {
    public XIntervalSeriesCollectionDemo1(String string) {
        super(string);
        JPanel jPanel = XIntervalSeriesCollectionDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static IntervalXYDataset createDataset() {
        XIntervalSeriesCollection xIntervalSeriesCollection = new XIntervalSeriesCollection();
        XIntervalSeries xIntervalSeries = new XIntervalSeries((Comparable)((Object)"S1"));
        xIntervalSeries.add(5.0, 2.0, 7.5, 12.3);
        xIntervalSeries.add(10.0, 8.0, 11.0, 20.0);
        xIntervalSeriesCollection.addSeries(xIntervalSeries);
        return xIntervalSeriesCollection;
    }

    private static JFreeChart createChart(IntervalXYDataset intervalXYDataset) {
        DateAxis dateAxis = new DateAxis("Date");
        NumberAxis numberAxis = new NumberAxis("Y");
        XYBarRenderer xYBarRenderer = new XYBarRenderer();
        xYBarRenderer.setUseYInterval(false);
        XYPlot xYPlot = new XYPlot((XYDataset)intervalXYDataset, (ValueAxis)dateAxis, (ValueAxis)numberAxis, (XYItemRenderer)xYBarRenderer);
        JFreeChart jFreeChart = new JFreeChart((Plot)xYPlot);
        xYPlot.setBackgroundPaint((Paint)Color.lightGray);
        xYPlot.setDomainGridlinePaint((Paint)Color.white);
        xYPlot.setDomainGridlinesVisible(true);
        xYPlot.setRangeGridlinePaint((Paint)Color.white);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = XIntervalSeriesCollectionDemo1.createChart(XIntervalSeriesCollectionDemo1.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        XIntervalSeriesCollectionDemo1 xIntervalSeriesCollectionDemo1 = new XIntervalSeriesCollectionDemo1("Demo 1");
        xIntervalSeriesCollectionDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)xIntervalSeriesCollectionDemo1));
        xIntervalSeriesCollectionDemo1.setVisible(true);
    }
}

