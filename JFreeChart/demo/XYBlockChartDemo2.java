/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.SymbolAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.PiePlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.LookupPaintScale
 *  org.jfree.chart.renderer.PaintScale
 *  org.jfree.chart.renderer.xy.XYBlockRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.title.PaintScaleLegend
 *  org.jfree.chart.title.Title
 *  org.jfree.data.time.Day
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.xy.DefaultXYZDataset
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.XYZDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RectangleAnchor
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
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.LookupPaintScale;
import org.jfree.chart.renderer.PaintScale;
import org.jfree.chart.renderer.xy.XYBlockRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.PaintScaleLegend;
import org.jfree.chart.title.Title;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class XYBlockChartDemo2
extends ApplicationFrame {
    public XYBlockChartDemo2(String string) {
        super(string);
        JPanel jPanel = XYBlockChartDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(XYZDataset xYZDataset) {
        DateAxis dateAxis = new DateAxis("Date");
        dateAxis.setLowerMargin(0.0);
        dateAxis.setUpperMargin(0.0);
        dateAxis.setInverted(true);
        NumberAxis numberAxis = new NumberAxis("Hour");
        numberAxis.setUpperMargin(0.0);
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        XYBlockRenderer xYBlockRenderer = new XYBlockRenderer();
        xYBlockRenderer.setBlockWidth(8.64E7);
        xYBlockRenderer.setBlockAnchor(RectangleAnchor.BOTTOM_LEFT);
        LookupPaintScale lookupPaintScale = new LookupPaintScale(0.5, 4.5, (Paint)Color.white);
        lookupPaintScale.add(0.5, (Paint)Color.red);
        lookupPaintScale.add(1.5, (Paint)Color.green);
        lookupPaintScale.add(2.5, (Paint)Color.blue);
        lookupPaintScale.add(3.5, (Paint)Color.yellow);
        xYBlockRenderer.setPaintScale((PaintScale)lookupPaintScale);
        XYPlot xYPlot = new XYPlot((XYDataset)xYZDataset, (ValueAxis)dateAxis, (ValueAxis)numberAxis, (XYItemRenderer)xYBlockRenderer);
        xYPlot.setOrientation(PlotOrientation.HORIZONTAL);
        xYPlot.setBackgroundPaint((Paint)Color.lightGray);
        xYPlot.setRangeGridlinePaint((Paint)Color.white);
        xYPlot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        JFreeChart jFreeChart = new JFreeChart("XYBlockChartDemo2", (Plot)xYPlot);
        jFreeChart.removeLegend();
        jFreeChart.setBackgroundPaint((Paint)Color.white);
        SymbolAxis symbolAxis = new SymbolAxis(null, new String[]{"", "Unavailable", "Free", "Group 1", "Group 2"});
        symbolAxis.setRange(0.5, 4.5);
        symbolAxis.setPlot((Plot)new PiePlot());
        symbolAxis.setGridBandsVisible(false);
        PaintScaleLegend paintScaleLegend = new PaintScaleLegend((PaintScale)lookupPaintScale, (ValueAxis)symbolAxis);
        paintScaleLegend.setMargin(new RectangleInsets(3.0, 10.0, 3.0, 10.0));
        paintScaleLegend.setPosition(RectangleEdge.BOTTOM);
        paintScaleLegend.setAxisOffset(5.0);
        jFreeChart.addSubtitle((Title)paintScaleLegend);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    private static XYZDataset createDataset() {
        double[] arrd = new double[2400];
        double[] arrd2 = new double[2400];
        double[] arrd3 = new double[2400];
        Day day = new Day();
        for (int i = 0; i < 100; ++i) {
            double d = 1.0;
            for (int j = 0; j < 24; ++j) {
                if (Math.random() < 0.1) {
                    d = Math.random() * 4.0;
                }
                arrd[i * 24 + j] = day.getFirstMillisecond();
                arrd2[i * 24 + j] = j;
                arrd3[i * 24 + j] = d;
            }
            day = day.next();
        }
        DefaultXYZDataset defaultXYZDataset = new DefaultXYZDataset();
        defaultXYZDataset.addSeries((Comparable)((Object)"Series 1"), (double[][])new double[][]{arrd, arrd2, arrd3});
        return defaultXYZDataset;
    }

    public static JPanel createDemoPanel() {
        return new ChartPanel(XYBlockChartDemo2.createChart(XYBlockChartDemo2.createDataset()));
    }

    public static void main(String[] arrstring) {
        XYBlockChartDemo2 xYBlockChartDemo2 = new XYBlockChartDemo2("Block Chart Demo 2");
        xYBlockChartDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)xYBlockChartDemo2));
        xYBlockChartDemo2.setVisible(true);
    }
}

