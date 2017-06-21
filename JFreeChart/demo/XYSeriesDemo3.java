/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.IntervalMarker
 *  org.jfree.chart.plot.Marker
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.data.xy.IntervalXYDataset
 *  org.jfree.data.xy.XYSeries
 *  org.jfree.data.xy.XYSeriesCollection
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.Layer
 *  org.jfree.ui.RectangleAnchor
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.ui.TextAnchor
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.Layer;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class XYSeriesDemo3
extends ApplicationFrame {
    public XYSeriesDemo3(String string) {
        super(string);
        IntervalXYDataset intervalXYDataset = XYSeriesDemo3.createDataset();
        JFreeChart jFreeChart = XYSeriesDemo3.createChart(intervalXYDataset);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)chartPanel);
    }

    private static IntervalXYDataset createDataset() {
        XYSeries xYSeries = new XYSeries((Comparable)((Object)"Random Data"));
        xYSeries.add(1.0, 400.2);
        xYSeries.add(5.0, 294.1);
        xYSeries.add(4.0, 100.0);
        xYSeries.add(12.5, 734.4);
        xYSeries.add(17.3, 453.2);
        xYSeries.add(21.2, 500.2);
        xYSeries.add(21.9, null);
        xYSeries.add(25.6, 734.4);
        xYSeries.add(30.0, 453.2);
        XYSeriesCollection xYSeriesCollection = new XYSeriesCollection(xYSeries);
        return xYSeriesCollection;
    }

    private static JFreeChart createChart(IntervalXYDataset intervalXYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYBarChart((String)"XY Series Demo 3", (String)"X", (boolean)false, (String)"Y", (IntervalXYDataset)intervalXYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        IntervalMarker intervalMarker = new IntervalMarker(400.0, 700.0);
        intervalMarker.setLabel("Target Range");
        intervalMarker.setLabelFont(new Font("SansSerif", 2, 11));
        intervalMarker.setLabelAnchor(RectangleAnchor.LEFT);
        intervalMarker.setLabelTextAnchor(TextAnchor.CENTER_LEFT);
        intervalMarker.setPaint((Paint)new Color(222, 222, 255, 128));
        xYPlot.addRangeMarker((Marker)intervalMarker, Layer.BACKGROUND);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = XYSeriesDemo3.createChart(XYSeriesDemo3.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        XYSeriesDemo3 xYSeriesDemo3 = new XYSeriesDemo3("JFreeChart: XYSeriesDemo3.java");
        xYSeriesDemo3.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)xYSeriesDemo3));
        xYSeriesDemo3.setVisible(true);
    }
}

