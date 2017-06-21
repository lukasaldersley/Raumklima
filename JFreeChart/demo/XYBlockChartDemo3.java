/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.SymbolAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.PiePlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.LookupPaintScale
 *  org.jfree.chart.renderer.PaintScale
 *  org.jfree.chart.renderer.xy.XYBlockRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.title.PaintScaleLegend
 *  org.jfree.chart.title.Title
 *  org.jfree.data.xy.DefaultXYZDataset
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.XYZDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RectangleEdge
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
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.LookupPaintScale;
import org.jfree.chart.renderer.PaintScale;
import org.jfree.chart.renderer.xy.XYBlockRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.PaintScaleLegend;
import org.jfree.chart.title.Title;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class XYBlockChartDemo3
extends ApplicationFrame {
    public XYBlockChartDemo3(String string) {
        super(string);
        JPanel jPanel = XYBlockChartDemo3.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(XYZDataset xYZDataset) {
        NumberAxis numberAxis = new NumberAxis("X");
        numberAxis.setLowerMargin(0.0);
        numberAxis.setUpperMargin(0.0);
        NumberAxis numberAxis2 = new NumberAxis("Y");
        numberAxis2.setAutoRangeIncludesZero(false);
        numberAxis2.setInverted(true);
        numberAxis2.setLowerMargin(0.0);
        numberAxis2.setUpperMargin(0.0);
        numberAxis2.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        XYBlockRenderer xYBlockRenderer = new XYBlockRenderer();
        LookupPaintScale lookupPaintScale = new LookupPaintScale(0.5, 3.5, (Paint)Color.black);
        lookupPaintScale.add(0.5, (Paint)Color.green);
        lookupPaintScale.add(1.5, (Paint)Color.orange);
        lookupPaintScale.add(2.5, (Paint)Color.red);
        xYBlockRenderer.setPaintScale((PaintScale)lookupPaintScale);
        XYPlot xYPlot = new XYPlot((XYDataset)xYZDataset, (ValueAxis)numberAxis, (ValueAxis)numberAxis2, (XYItemRenderer)xYBlockRenderer);
        xYPlot.setBackgroundPaint((Paint)Color.lightGray);
        xYPlot.setDomainGridlinePaint((Paint)Color.white);
        xYPlot.setRangeGridlinePaint((Paint)Color.white);
        xYPlot.setForegroundAlpha(0.66f);
        xYPlot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        JFreeChart jFreeChart = new JFreeChart("XYBlockChartDemo3", (Plot)xYPlot);
        jFreeChart.removeLegend();
        SymbolAxis symbolAxis = new SymbolAxis(null, new String[]{"", "OK", "Uncertain", "Bad"});
        symbolAxis.setRange(0.5, 3.5);
        symbolAxis.setPlot((Plot)new PiePlot());
        symbolAxis.setGridBandsVisible(false);
        PaintScaleLegend paintScaleLegend = new PaintScaleLegend((PaintScale)lookupPaintScale, (ValueAxis)symbolAxis);
        paintScaleLegend.setAxisOffset(5.0);
        paintScaleLegend.setPosition(RectangleEdge.BOTTOM);
        paintScaleLegend.setMargin(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        jFreeChart.addSubtitle((Title)paintScaleLegend);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    private static void setValue(double[][] arrd, int n, int n2, double d) {
        arrd[0][(n2 - 8) * 60 + n] = n;
        arrd[1][(n2 - 8) * 60 + n] = n2;
        arrd[2][(n2 - 8) * 60 + n] = d;
    }

    private static XYZDataset createDataset() {
        int n;
        int n2;
        double[] arrd = new double[840];
        double[] arrd2 = new double[840];
        double[] arrd3 = new double[840];
        double[][] arrarrd = new double[][]{arrd, arrd2, arrd3};
        for (n2 = 0; n2 < 60; ++n2) {
            for (n = 8; n < 22; ++n) {
                XYBlockChartDemo3.setValue(arrarrd, n2, n, 0.0);
            }
        }
        for (n2 = 8; n2 < 12; ++n2) {
            for (n = 13; n < 48; ++n) {
                XYBlockChartDemo3.setValue(arrarrd, n, n2, 1.0);
            }
        }
        for (n2 = 12; n2 < 20; ++n2) {
            for (n = 23; n < 43; ++n) {
                XYBlockChartDemo3.setValue(arrarrd, n, n2, 1.0);
            }
        }
        XYBlockChartDemo3.setValue(arrarrd, 2, 20, 2.0);
        XYBlockChartDemo3.setValue(arrarrd, 5, 20, 3.0);
        XYBlockChartDemo3.setValue(arrarrd, 6, 20, 3.0);
        XYBlockChartDemo3.setValue(arrarrd, 7, 20, 3.0);
        XYBlockChartDemo3.setValue(arrarrd, 8, 20, 3.0);
        XYBlockChartDemo3.setValue(arrarrd, 9, 20, 3.0);
        XYBlockChartDemo3.setValue(arrarrd, 11, 20, 3.0);
        XYBlockChartDemo3.setValue(arrarrd, 17, 20, 2.0);
        XYBlockChartDemo3.setValue(arrarrd, 18, 20, 2.0);
        XYBlockChartDemo3.setValue(arrarrd, 19, 20, 2.0);
        XYBlockChartDemo3.setValue(arrarrd, 20, 20, 2.0);
        XYBlockChartDemo3.setValue(arrarrd, 22, 20, 2.0);
        XYBlockChartDemo3.setValue(arrarrd, 25, 20, 2.0);
        XYBlockChartDemo3.setValue(arrarrd, 28, 20, 2.0);
        XYBlockChartDemo3.setValue(arrarrd, 35, 20, 2.0);
        for (n2 = 40; n2 < 60; ++n2) {
            XYBlockChartDemo3.setValue(arrarrd, n2, 20, 3.0);
        }
        for (n2 = 23; n2 < 43; ++n2) {
            XYBlockChartDemo3.setValue(arrarrd, n2, 21, 1.0);
        }
        DefaultXYZDataset defaultXYZDataset = new DefaultXYZDataset();
        defaultXYZDataset.addSeries((Comparable)((Object)"Series 1"), (double[][])arrarrd);
        return defaultXYZDataset;
    }

    public static JPanel createDemoPanel() {
        return new ChartPanel(XYBlockChartDemo3.createChart(XYBlockChartDemo3.createDataset()));
    }

    public static void main(String[] arrstring) {
        XYBlockChartDemo3 xYBlockChartDemo3 = new XYBlockChartDemo3("Block Chart Demo 3");
        xYBlockChartDemo3.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)xYBlockChartDemo3));
        xYBlockChartDemo3.setVisible(true);
    }
}

