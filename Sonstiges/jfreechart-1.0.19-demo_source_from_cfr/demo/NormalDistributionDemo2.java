/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.annotations.XYAnnotation
 *  org.jfree.chart.annotations.XYPointerAnnotation
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
 *  org.jfree.data.function.Function2D
 *  org.jfree.data.function.NormalDistributionFunction2D
 *  org.jfree.data.general.DatasetUtilities
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.XYSeries
 *  org.jfree.data.xy.XYSeriesCollection
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.ui.TextAnchor
 */
package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYAnnotation;
import org.jfree.chart.annotations.XYPointerAnnotation;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.function.Function2D;
import org.jfree.data.function.NormalDistributionFunction2D;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class NormalDistributionDemo2
extends ApplicationFrame {
    public NormalDistributionDemo2(String string) {
        super(string);
        JPanel jPanel = NormalDistributionDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = NormalDistributionDemo2.createChart(NormalDistributionDemo2.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static XYDataset createDataset() {
        XYSeriesCollection xYSeriesCollection = new XYSeriesCollection();
        NormalDistributionFunction2D normalDistributionFunction2D = new NormalDistributionFunction2D(0.0, 1.0);
        XYSeries xYSeries = DatasetUtilities.sampleFunction2DToSeries((Function2D)normalDistributionFunction2D, (double)-5.1, (double)5.1, (int)121, (Comparable)((Object)"N1"));
        xYSeriesCollection.addSeries(xYSeries);
        NormalDistributionFunction2D normalDistributionFunction2D2 = new NormalDistributionFunction2D(0.0, Math.sqrt(0.2));
        XYSeries xYSeries2 = DatasetUtilities.sampleFunction2DToSeries((Function2D)normalDistributionFunction2D2, (double)-5.1, (double)5.1, (int)121, (Comparable)((Object)"N2"));
        xYSeriesCollection.addSeries(xYSeries2);
        NormalDistributionFunction2D normalDistributionFunction2D3 = new NormalDistributionFunction2D(0.0, Math.sqrt(5.0));
        XYSeries xYSeries3 = DatasetUtilities.sampleFunction2DToSeries((Function2D)normalDistributionFunction2D3, (double)-5.1, (double)5.1, (int)121, (Comparable)((Object)"N3"));
        xYSeriesCollection.addSeries(xYSeries3);
        NormalDistributionFunction2D normalDistributionFunction2D4 = new NormalDistributionFunction2D(-2.0, Math.sqrt(0.5));
        XYSeries xYSeries4 = DatasetUtilities.sampleFunction2DToSeries((Function2D)normalDistributionFunction2D4, (double)-5.1, (double)5.1, (int)121, (Comparable)((Object)"N4"));
        xYSeriesCollection.addSeries(xYSeries4);
        return xYSeriesCollection;
    }

    public static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYLineChart((String)"Normal Distribution Demo 2", (String)"X", (String)"Y", (XYDataset)xYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainZeroBaselineVisible(true);
        xYPlot.setRangeZeroBaselineVisible(true);
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        ValueAxis valueAxis = xYPlot.getDomainAxis();
        valueAxis.setLowerMargin(0.0);
        valueAxis.setUpperMargin(0.0);
        XYLineAndShapeRenderer xYLineAndShapeRenderer = (XYLineAndShapeRenderer)xYPlot.getRenderer();
        xYLineAndShapeRenderer.setDrawSeriesLineAsPath(true);
        xYLineAndShapeRenderer.setSeriesStroke(0, (Stroke)new BasicStroke(1.5f));
        xYLineAndShapeRenderer.setSeriesStroke(1, (Stroke)new BasicStroke(2.0f, 1, 1, 1.0f, new float[]{6.0f, 4.0f}, 0.0f));
        xYLineAndShapeRenderer.setSeriesStroke(2, (Stroke)new BasicStroke(2.0f, 1, 1, 1.0f, new float[]{6.0f, 4.0f, 3.0f, 3.0f}, 0.0f));
        xYLineAndShapeRenderer.setSeriesStroke(3, (Stroke)new BasicStroke(2.0f, 1, 1, 1.0f, new float[]{4.0f, 4.0f}, 0.0f));
        XYPointerAnnotation xYPointerAnnotation = new XYPointerAnnotation("\u03bc = -2.0, \u03c3\u00b2 = 0.5", -2.0, 0.564, 3.9269908169872414);
        xYPointerAnnotation.setLabelOffset(4.0);
        xYPointerAnnotation.setTextAnchor(TextAnchor.BOTTOM_RIGHT);
        xYPointerAnnotation.setBackgroundPaint((Paint)Color.yellow);
        xYPlot.addAnnotation((XYAnnotation)xYPointerAnnotation);
        XYPointerAnnotation xYPointerAnnotation2 = new XYPointerAnnotation("\u03bc = 0.0, \u03c3\u00b2 = 0.2", 0.225, 0.8, 0.0);
        xYPointerAnnotation2.setLabelOffset(4.0);
        xYPointerAnnotation2.setTextAnchor(TextAnchor.CENTER_LEFT);
        xYPointerAnnotation2.setBackgroundPaint((Paint)new Color(0, 0, 255, 63));
        xYPlot.addAnnotation((XYAnnotation)xYPointerAnnotation2);
        XYPointerAnnotation xYPointerAnnotation3 = new XYPointerAnnotation("\u03bc = 0.0, \u03c3\u00b2 = 1.0", 0.75, 0.3, 5.497787143782138);
        xYPointerAnnotation3.setLabelOffset(4.0);
        xYPointerAnnotation3.setTextAnchor(TextAnchor.HALF_ASCENT_LEFT);
        xYPointerAnnotation3.setBackgroundPaint((Paint)new Color(255, 0, 0, 63));
        xYPlot.addAnnotation((XYAnnotation)xYPointerAnnotation3);
        XYPointerAnnotation xYPointerAnnotation4 = new XYPointerAnnotation("\u03bc = 0.0, \u03c3\u00b2 = 5.0", 3.0, 0.075, 4.71238898038469);
        xYPointerAnnotation4.setLabelOffset(4.0);
        xYPointerAnnotation4.setTextAnchor(TextAnchor.BOTTOM_CENTER);
        xYPointerAnnotation4.setBackgroundPaint((Paint)new Color(0, 255, 0, 63));
        xYPlot.addAnnotation((XYAnnotation)xYPointerAnnotation4);
        return jFreeChart;
    }

    public static void main(String[] arrstring) {
        NormalDistributionDemo2 normalDistributionDemo2 = new NormalDistributionDemo2("JFreeChart: NormalDistributionDemo2.java");
        normalDistributionDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)normalDistributionDemo2));
        normalDistributionDemo2.setVisible(true);
    }
}

