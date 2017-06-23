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
 *  org.jfree.chart.renderer.xy.XYStepAreaRenderer
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
import org.jfree.chart.renderer.xy.XYStepAreaRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYStepAreaRendererDemo1
extends ApplicationFrame {
    public XYStepAreaRendererDemo1(String string) {
        super(string);
        JPanel jPanel = XYStepAreaRendererDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 300));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYLineChart((String)"XYStepAreaRenderer Demo 1", (String)"X", (String)"Y", (XYDataset)xYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainPannable(true);
        XYStepAreaRenderer xYStepAreaRenderer = new XYStepAreaRenderer(2);
        xYStepAreaRenderer.setDataBoundsIncludesVisibleSeriesOnly(false);
        xYStepAreaRenderer.setBaseToolTipGenerator((XYToolTipGenerator)new StandardXYToolTipGenerator());
        xYStepAreaRenderer.setDefaultEntityRadius(6);
        xYPlot.setRenderer((XYItemRenderer)xYStepAreaRenderer);
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
        JFreeChart jFreeChart = XYStepAreaRendererDemo1.createChart(XYStepAreaRendererDemo1.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        XYStepAreaRendererDemo1 xYStepAreaRendererDemo1 = new XYStepAreaRendererDemo1("XYStepAreaRenderer Demo 1");
        xYStepAreaRendererDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)xYStepAreaRendererDemo1));
        xYStepAreaRendererDemo1.setVisible(true);
    }
}

