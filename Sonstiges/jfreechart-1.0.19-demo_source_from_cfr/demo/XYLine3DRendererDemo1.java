/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.labels.StandardXYToolTipGenerator
 *  org.jfree.chart.labels.XYToolTipGenerator
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYLine3DRenderer
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
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLine3DRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYLine3DRendererDemo1
extends ApplicationFrame {
    public XYLine3DRendererDemo1(String string) {
        super(string);
        JPanel jPanel = XYLine3DRendererDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 300));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYLineChart((String)"XYLine3DRenderer Demo 1", (String)"X", (String)"Y", (XYDataset)xYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        XYLine3DRenderer xYLine3DRenderer = new XYLine3DRenderer();
        xYLine3DRenderer.setWallPaint((Paint)Color.gray);
        xYLine3DRenderer.setXOffset(2.0);
        xYLine3DRenderer.setYOffset(3.0);
        xYLine3DRenderer.setBaseToolTipGenerator((XYToolTipGenerator)new StandardXYToolTipGenerator());
        xYLine3DRenderer.setDefaultEntityRadius(6);
        xYPlot.setRenderer((XYItemRenderer)xYLine3DRenderer);
        return jFreeChart;
    }

    private static XYDataset createDataset() {
        XYSeries xYSeries = new XYSeries((Comparable)((Object)"Series 1"));
        xYSeries.add(1.0, 3.3);
        xYSeries.add(2.0, 4.4);
        xYSeries.add(3.0, 1.7);
        XYSeries xYSeries2 = new XYSeries((Comparable)((Object)"Series 2"));
        xYSeries2.add(1.0, 7.3);
        xYSeries2.add(2.0, 0.0);
        xYSeries2.add(3.0, 9.6);
        xYSeries2.add(4.0, 5.6);
        XYSeriesCollection xYSeriesCollection = new XYSeriesCollection();
        xYSeriesCollection.addSeries(xYSeries);
        xYSeriesCollection.addSeries(xYSeries2);
        return xYSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = XYLine3DRendererDemo1.createChart(XYLine3DRendererDemo1.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        XYLine3DRendererDemo1 xYLine3DRendererDemo1 = new XYLine3DRendererDemo1("JFreeChart: XYLine3DRendererDemo1.java");
        xYLine3DRendererDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)xYLine3DRendererDemo1));
        xYLine3DRendererDemo1.setVisible(true);
    }
}

