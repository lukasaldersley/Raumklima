/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.AxisLocation
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.LookupPaintScale
 *  org.jfree.chart.renderer.PaintScale
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYShapeRenderer
 *  org.jfree.chart.title.PaintScaleLegend
 *  org.jfree.chart.title.Title
 *  org.jfree.data.xy.DefaultXYZDataset
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.XYZDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RectangleEdge
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
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.LookupPaintScale;
import org.jfree.chart.renderer.PaintScale;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYShapeRenderer;
import org.jfree.chart.title.PaintScaleLegend;
import org.jfree.chart.title.Title;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;

public class XYShapeRendererDemo1
extends ApplicationFrame {
    public XYShapeRendererDemo1(String string) {
        super(string);
        JPanel jPanel = XYShapeRendererDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(XYZDataset xYZDataset) {
        NumberAxis numberAxis = new NumberAxis("X");
        numberAxis.setAutoRangeIncludesZero(false);
        NumberAxis numberAxis2 = new NumberAxis("Y");
        numberAxis2.setAutoRangeIncludesZero(false);
        XYShapeRenderer xYShapeRenderer = new XYShapeRenderer();
        LookupPaintScale lookupPaintScale = new LookupPaintScale(1.0, 4.0, (Paint)new Color(0, 0, 255));
        lookupPaintScale.add(2.0, (Paint)new Color(100, 100, 255));
        lookupPaintScale.add(3.0, (Paint)new Color(200, 200, 255));
        xYShapeRenderer.setPaintScale((PaintScale)lookupPaintScale);
        XYPlot xYPlot = new XYPlot((XYDataset)xYZDataset, (ValueAxis)numberAxis, (ValueAxis)numberAxis2, (XYItemRenderer)xYShapeRenderer);
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        JFreeChart jFreeChart = new JFreeChart("XYShapeRendererDemo1", (Plot)xYPlot);
        jFreeChart.removeLegend();
        NumberAxis numberAxis3 = new NumberAxis("Score");
        numberAxis3.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        PaintScaleLegend paintScaleLegend = new PaintScaleLegend((PaintScale)lookupPaintScale, (ValueAxis)numberAxis3);
        paintScaleLegend.setPosition(RectangleEdge.RIGHT);
        paintScaleLegend.setMargin(4.0, 4.0, 40.0, 4.0);
        paintScaleLegend.setAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
        jFreeChart.addSubtitle((Title)paintScaleLegend);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static XYZDataset createDataset() {
        DefaultXYZDataset defaultXYZDataset = new DefaultXYZDataset();
        double[] arrd = new double[]{2.1, 2.3, 2.3, 2.2, 2.2, 1.8, 1.8, 1.9, 2.3, 2.8};
        double[] arrd2 = new double[]{14.1, 17.1, 10.0, 8.8, 8.7, 8.4, 5.4, 4.1, 4.1, 25.0};
        double[] arrd3 = new double[]{2.4, 2.7, 1.7, 2.2, 1.3, 2.2, 2.1, 3.2, 1.6, 3.4};
        double[][] arrarrd = new double[][]{arrd, arrd2, arrd3};
        defaultXYZDataset.addSeries((Comparable)((Object)"Series 1"), (double[][])arrarrd);
        return defaultXYZDataset;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = XYShapeRendererDemo1.createChart(XYShapeRendererDemo1.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        XYShapeRendererDemo1 xYShapeRendererDemo1 = new XYShapeRendererDemo1("JFreeChart: XYShapeRendererDemo1.java");
        xYShapeRendererDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)xYShapeRendererDemo1));
        xYShapeRendererDemo1.setVisible(true);
    }
}

