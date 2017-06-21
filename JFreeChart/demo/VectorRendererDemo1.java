/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartRenderingInfo
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.entity.EntityCollection
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.VectorRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.xy.VectorSeries
 *  org.jfree.data.xy.VectorSeriesCollection
 *  org.jfree.data.xy.VectorXYDataset
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RectangleInsets
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
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.VectorRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.VectorSeries;
import org.jfree.data.xy.VectorSeriesCollection;
import org.jfree.data.xy.VectorXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class VectorRendererDemo1
extends ApplicationFrame {
    public VectorRendererDemo1(String string) {
        super(string);
        JPanel jPanel = VectorRendererDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(VectorXYDataset vectorXYDataset) {
        NumberAxis numberAxis = new NumberAxis("X");
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberAxis.setLowerMargin(0.01);
        numberAxis.setUpperMargin(0.01);
        numberAxis.setAutoRangeIncludesZero(false);
        NumberAxis numberAxis2 = new NumberAxis("Y");
        numberAxis2.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberAxis2.setLowerMargin(0.01);
        numberAxis2.setUpperMargin(0.01);
        numberAxis2.setAutoRangeIncludesZero(false);
        VectorRenderer vectorRenderer = new VectorRenderer();
        vectorRenderer.setSeriesPaint(0, (Paint)Color.blue);
        XYPlot xYPlot = new XYPlot((XYDataset)vectorXYDataset, (ValueAxis)numberAxis, (ValueAxis)numberAxis2, (XYItemRenderer)vectorRenderer);
        xYPlot.setBackgroundPaint((Paint)Color.lightGray);
        xYPlot.setDomainGridlinePaint((Paint)Color.white);
        xYPlot.setRangeGridlinePaint((Paint)Color.white);
        xYPlot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        xYPlot.setOutlinePaint((Paint)Color.black);
        JFreeChart jFreeChart = new JFreeChart("Vector Renderer Demo 1", (Plot)xYPlot);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    private static VectorXYDataset createDataset() {
        VectorSeries vectorSeries = new VectorSeries((Comparable)((Object)"Series 1"));
        for (double d = 0.0; d < 20.0; d += 1.0) {
            for (double d2 = 0.0; d2 < 20.0; d2 += 1.0) {
                vectorSeries.add(d + 10.0, d2 + 10.0, Math.sin(d / 5.0) / 2.0, Math.cos(d2 / 5.0) / 2.0);
            }
        }
        VectorSeriesCollection vectorSeriesCollection = new VectorSeriesCollection();
        vectorSeriesCollection.addSeries(vectorSeries);
        return vectorSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        ChartPanel chartPanel = new ChartPanel(VectorRendererDemo1.createChart(VectorRendererDemo1.createDataset()));
        chartPanel.getChartRenderingInfo().setEntityCollection(null);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        VectorRendererDemo1 vectorRendererDemo1 = new VectorRendererDemo1("JFreeChart : VectorRendererDemo1.java");
        vectorRendererDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)vectorRendererDemo1));
        vectorRendererDemo1.setVisible(true);
    }
}

