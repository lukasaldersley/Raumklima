/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
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
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
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

public class CrosshairDemo4
extends ApplicationFrame {
    public CrosshairDemo4(String string) {
        super(string);
        JPanel jPanel = CrosshairDemo4.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static XYDataset createDataset() {
        XYSeries xYSeries = new XYSeries((Comparable)((Object)"First"));
        xYSeries.add(1.0, 1.0);
        xYSeries.add(2.0, 4.0);
        xYSeries.add(3.0, 3.0);
        xYSeries.add(4.0, 5.0);
        xYSeries.add(5.0, 5.0);
        xYSeries.add(6.0, 7.0);
        xYSeries.add(7.0, 7.0);
        xYSeries.add(8.0, 8.0);
        XYSeries xYSeries2 = new XYSeries((Comparable)((Object)"Second"));
        xYSeries2.add(1.0, 5.0);
        xYSeries2.add(2.0, 7.0);
        xYSeries2.add(3.0, 6.0);
        xYSeries2.add(4.0, 8.0);
        xYSeries2.add(5.0, 4.0);
        xYSeries2.add(6.0, 4.0);
        xYSeries2.add(7.0, 2.0);
        xYSeries2.add(8.0, 1.0);
        XYSeries xYSeries3 = new XYSeries((Comparable)((Object)"Third"));
        xYSeries3.add(3.0, 4.0);
        xYSeries3.add(4.0, 3.0);
        xYSeries3.add(5.0, 2.0);
        xYSeries3.add(6.0, 3.0);
        xYSeries3.add(7.0, 6.0);
        xYSeries3.add(8.0, 3.0);
        xYSeries3.add(9.0, 4.0);
        xYSeries3.add(10.0, 3.0);
        XYSeriesCollection xYSeriesCollection = new XYSeriesCollection();
        xYSeriesCollection.addSeries(xYSeries);
        xYSeriesCollection.addSeries(xYSeries2);
        xYSeriesCollection.addSeries(xYSeries3);
        return xYSeriesCollection;
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYLineChart((String)"Crosshair Demo 4", (String)"X", (String)"Y", (XYDataset)xYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainCrosshairVisible(true);
        xYPlot.setRangeCrosshairVisible(true);
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        XYLineAndShapeRenderer xYLineAndShapeRenderer = (XYLineAndShapeRenderer)xYPlot.getRenderer();
        xYLineAndShapeRenderer.setBaseShapesVisible(true);
        xYLineAndShapeRenderer.setBaseShapesFilled(true);
        NumberAxis numberAxis = (NumberAxis)xYPlot.getRangeAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = CrosshairDemo4.createChart(CrosshairDemo4.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        CrosshairDemo4 crosshairDemo4 = new CrosshairDemo4("JFreeChart: CrosshairDemo4.java");
        crosshairDemo4.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)crosshairDemo4));
        crosshairDemo4.setVisible(true);
    }
}

