/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.FastScatterPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.title.TextTitle
 *  org.jfree.chart.title.Title
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.RenderingHints;
import java.awt.Window;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.FastScatterPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class FastScatterPlotDemo
extends ApplicationFrame {
    private static final int COUNT = 100000;
    private float[][] data = new float[2][100000];

    public FastScatterPlotDemo(String string) {
        super(string);
        this.populateData();
        NumberAxis numberAxis = new NumberAxis("X");
        numberAxis.setAutoRangeIncludesZero(false);
        NumberAxis numberAxis2 = new NumberAxis("Y");
        numberAxis2.setAutoRangeIncludesZero(false);
        FastScatterPlot fastScatterPlot = new FastScatterPlot(this.data, (ValueAxis)numberAxis, (ValueAxis)numberAxis2);
        fastScatterPlot.setDomainPannable(true);
        fastScatterPlot.setRangePannable(true);
        JFreeChart jFreeChart = new JFreeChart("Fast Scatter Plot", (Plot)fastScatterPlot);
        jFreeChart.addSubtitle((Title)new TextTitle("This chart contains 100000 data points."));
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        jFreeChart.getRenderingHints().put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ChartPanel chartPanel = new ChartPanel(jFreeChart, true);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        chartPanel.setDomainZoomable(true);
        chartPanel.setRangeZoomable(true);
        chartPanel.setMinimumDrawHeight(10);
        chartPanel.setMaximumDrawHeight(2000);
        chartPanel.setMinimumDrawWidth(20);
        chartPanel.setMaximumDrawWidth(2000);
        chartPanel.setMouseWheelEnabled(true);
        this.setContentPane((Container)chartPanel);
    }

    private void populateData() {
        for (int i = 0; i < this.data[0].length; ++i) {
            float f;
            this.data[0][i] = f = (float)i + 100000.0f;
            this.data[1][i] = 100000.0f + (float)Math.random() * 100000.0f;
        }
    }

    public static void main(String[] arrstring) {
        FastScatterPlotDemo fastScatterPlotDemo = new FastScatterPlotDemo("JFreeChart: FastScatterPlotDemo.java");
        fastScatterPlotDemo.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)fastScatterPlotDemo));
        fastScatterPlotDemo.setVisible(true);
    }
}

