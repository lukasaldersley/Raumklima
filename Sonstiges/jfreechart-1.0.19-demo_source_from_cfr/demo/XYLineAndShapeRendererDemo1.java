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
 *  org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
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
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYLineAndShapeRendererDemo1
extends ApplicationFrame {
    public XYLineAndShapeRendererDemo1(String string) {
        super(string);
        JPanel jPanel = XYLineAndShapeRendererDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 300));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYLineChart((String)"XYLineAndShapeRenderer Demo 1", (String)"X", (String)"Y", (XYDataset)xYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        XYLineAndShapeRenderer xYLineAndShapeRenderer = new XYLineAndShapeRenderer();
        xYLineAndShapeRenderer.setSeriesLinesVisible(0, true);
        xYLineAndShapeRenderer.setSeriesShapesVisible(0, false);
        xYLineAndShapeRenderer.setSeriesLinesVisible(1, false);
        xYLineAndShapeRenderer.setSeriesShapesVisible(1, true);
        xYLineAndShapeRenderer.setBaseToolTipGenerator((XYToolTipGenerator)new StandardXYToolTipGenerator());
        xYLineAndShapeRenderer.setDefaultEntityRadius(6);
        xYPlot.setRenderer((XYItemRenderer)xYLineAndShapeRenderer);
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
        JFreeChart jFreeChart = XYLineAndShapeRendererDemo1.createChart(XYLineAndShapeRendererDemo1.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        XYLineAndShapeRendererDemo1 xYLineAndShapeRendererDemo1 = new XYLineAndShapeRendererDemo1("JFreeChart: XYLineAndShapeRendererDemo1.java");
        xYLineAndShapeRendererDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)xYLineAndShapeRendererDemo1));
        xYLineAndShapeRendererDemo1.setVisible(true);
    }
}

