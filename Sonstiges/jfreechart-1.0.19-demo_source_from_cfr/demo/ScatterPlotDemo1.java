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
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import demo.SampleXYDataset2;
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
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class ScatterPlotDemo1
extends ApplicationFrame {
    public ScatterPlotDemo1(String string) {
        super(string);
        JPanel jPanel = ScatterPlotDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createScatterPlot((String)"Scatter Plot Demo 1", (String)"X", (String)"Y", (XYDataset)xYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setNoDataMessage("NO DATA");
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        xYPlot.setDomainZeroBaselineVisible(true);
        xYPlot.setRangeZeroBaselineVisible(true);
        xYPlot.setDomainGridlineStroke((Stroke)new BasicStroke(0.0f));
        xYPlot.setDomainMinorGridlineStroke((Stroke)new BasicStroke(0.0f));
        xYPlot.setDomainGridlinePaint((Paint)Color.blue);
        xYPlot.setRangeGridlineStroke((Stroke)new BasicStroke(0.0f));
        xYPlot.setRangeMinorGridlineStroke((Stroke)new BasicStroke(0.0f));
        xYPlot.setRangeGridlinePaint((Paint)Color.blue);
        xYPlot.setDomainMinorGridlinesVisible(true);
        xYPlot.setRangeMinorGridlinesVisible(true);
        XYLineAndShapeRenderer xYLineAndShapeRenderer = (XYLineAndShapeRenderer)xYPlot.getRenderer();
        xYLineAndShapeRenderer.setSeriesOutlinePaint(0, (Paint)Color.black);
        xYLineAndShapeRenderer.setUseOutlinePaint(true);
        NumberAxis numberAxis = (NumberAxis)xYPlot.getDomainAxis();
        numberAxis.setAutoRangeIncludesZero(false);
        numberAxis.setTickMarkInsideLength(2.0f);
        numberAxis.setTickMarkOutsideLength(2.0f);
        numberAxis.setMinorTickCount(2);
        numberAxis.setMinorTickMarksVisible(true);
        NumberAxis numberAxis2 = (NumberAxis)xYPlot.getRangeAxis();
        numberAxis2.setTickMarkInsideLength(2.0f);
        numberAxis2.setTickMarkOutsideLength(2.0f);
        numberAxis2.setMinorTickCount(2);
        numberAxis2.setMinorTickMarksVisible(true);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = ScatterPlotDemo1.createChart(new SampleXYDataset2());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        ScatterPlotDemo1 scatterPlotDemo1 = new ScatterPlotDemo1("JFreeChart: ScatterPlotDemo1.java");
        scatterPlotDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)scatterPlotDemo1));
        scatterPlotDemo1.setVisible(true);
    }
}

