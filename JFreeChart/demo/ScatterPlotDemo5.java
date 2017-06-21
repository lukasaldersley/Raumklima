/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYDotRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.XYSeries
 *  org.jfree.data.xy.XYSeriesCollection
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RectangleInsets
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Window;
import java.awt.font.TextAttribute;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYDotRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class ScatterPlotDemo5
extends ApplicationFrame {
    public ScatterPlotDemo5(String string) {
        super(string);
        JPanel jPanel = ScatterPlotDemo5.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    public static XYDataset createDataset() {
        XYSeriesCollection xYSeriesCollection = new XYSeriesCollection();
        XYSeries xYSeries = new XYSeries((Comparable)((Object)"S1"));
        XYSeries xYSeries2 = new XYSeries((Comparable)((Object)"S2"));
        for (int i = 0; i < 100; ++i) {
            xYSeries.add(Math.random() * 50.0, Math.random() * 100.0);
            xYSeries2.add(Math.random() * 50.0, Math.random() * 100.0);
        }
        xYSeriesCollection.addSeries(xYSeries);
        xYSeriesCollection.addSeries(xYSeries2);
        return xYSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = ChartFactory.createScatterPlot((String)"Scatter Plot Demo 5", (String)"X", (String)"Y", (XYDataset)ScatterPlotDemo5.createDataset());
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setBackgroundPaint(null);
        xYPlot.setAxisOffset(RectangleInsets.ZERO_INSETS);
        xYPlot.setOutlineVisible(false);
        XYDotRenderer xYDotRenderer = new XYDotRenderer();
        xYDotRenderer.setDotWidth(4);
        xYDotRenderer.setDotHeight(4);
        xYPlot.setRenderer((XYItemRenderer)xYDotRenderer);
        xYPlot.setDomainCrosshairVisible(true);
        xYPlot.setRangeCrosshairVisible(true);
        NumberAxis numberAxis = (NumberAxis)xYPlot.getDomainAxis();
        AttributedString attributedString = new AttributedString("H20");
        attributedString.addAttribute(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUB, 1, 2);
        numberAxis.setAttributedLabel(attributedString);
        numberAxis.setPositiveArrowVisible(true);
        numberAxis.setAutoRangeIncludesZero(false);
        NumberAxis numberAxis2 = (NumberAxis)xYPlot.getRangeAxis();
        AttributedString attributedString2 = new AttributedString("kg x 106");
        attributedString2.addAttribute(TextAttribute.SUPERSCRIPT, TextAttribute.SUPERSCRIPT_SUPER, 7, 8);
        numberAxis2.setAttributedLabel(attributedString2);
        numberAxis2.setPositiveArrowVisible(true);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        ScatterPlotDemo5 scatterPlotDemo5 = new ScatterPlotDemo5("JFreeChart: ScatterPlotDemo5.java");
        scatterPlotDemo5.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)scatterPlotDemo5));
        scatterPlotDemo5.setVisible(true);
    }
}

