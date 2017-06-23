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
 *  org.jfree.chart.renderer.xy.XYStepRenderer
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.XYSeries
 *  org.jfree.data.xy.XYSeriesCollection
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.BasicStroke;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Stroke;
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
import org.jfree.chart.renderer.xy.XYStepRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYStepRendererDemo1
extends ApplicationFrame {
    public XYStepRendererDemo1(String string) {
        super(string);
        JPanel jPanel = XYStepRendererDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 300));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYLineChart((String)"XYStepRenderer Demo 1", (String)"X", (String)"Y", (XYDataset)xYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        XYStepRenderer xYStepRenderer = new XYStepRenderer();
        xYStepRenderer.setBaseShapesVisible(true);
        xYStepRenderer.setSeriesStroke(0, (Stroke)new BasicStroke(2.0f));
        xYStepRenderer.setSeriesStroke(1, (Stroke)new BasicStroke(2.0f));
        xYStepRenderer.setBaseToolTipGenerator((XYToolTipGenerator)new StandardXYToolTipGenerator());
        xYStepRenderer.setDefaultEntityRadius(6);
        xYPlot.setRenderer((XYItemRenderer)xYStepRenderer);
        return jFreeChart;
    }

    private static XYDataset createDataset() {
        XYSeries xYSeries = new XYSeries((Comparable)((Object)"Series 1"));
        xYSeries.add(1.0, 3.0);
        xYSeries.add(2.0, 4.0);
        xYSeries.add(3.0, 2.0);
        xYSeries.add(6.0, 3.0);
        XYSeries xYSeries2 = new XYSeries((Comparable)((Object)"Series 2"));
        xYSeries2.add(1.0, 7.0);
        xYSeries2.add(2.0, 6.0);
        xYSeries2.add(3.0, 9.0);
        xYSeries2.add(4.0, 5.0);
        xYSeries2.add(6.0, 4.0);
        XYSeriesCollection xYSeriesCollection = new XYSeriesCollection();
        xYSeriesCollection.addSeries(xYSeries);
        xYSeriesCollection.addSeries(xYSeries2);
        return xYSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = XYStepRendererDemo1.createChart(XYStepRendererDemo1.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        XYStepRendererDemo1 xYStepRendererDemo1 = new XYStepRendererDemo1("JFreeChart: XYStepRendererDemo1.java");
        xYStepRendererDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)xYStepRendererDemo1));
        xYStepRendererDemo1.setVisible(true);
    }
}

