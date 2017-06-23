/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartMouseEvent
 *  org.jfree.chart.ChartMouseListener
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartRenderingInfo
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.PlotRenderingInfo
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RectangleEdge
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import demo.SampleXYDataset2;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.PrintStream;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;

public class ScatterPlotDemo3
extends ApplicationFrame {
    public ScatterPlotDemo3(String string) {
        super(string);
        JPanel jPanel = ScatterPlotDemo3.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createScatterPlot((String)"Scatter Plot Demo 3", (String)"X", (String)"Y", (XYDataset)xYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainCrosshairVisible(true);
        xYPlot.setDomainCrosshairLockedOnData(true);
        xYPlot.setRangeCrosshairVisible(true);
        xYPlot.setRangeCrosshairLockedOnData(true);
        xYPlot.setDomainZeroBaselineVisible(true);
        xYPlot.setRangeZeroBaselineVisible(true);
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        NumberAxis numberAxis = (NumberAxis)xYPlot.getDomainAxis();
        numberAxis.setAutoRangeIncludesZero(false);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = ScatterPlotDemo3.createChart(new SampleXYDataset2());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.addChartMouseListener((ChartMouseListener)new MyChartMouseListener(chartPanel));
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        ScatterPlotDemo3 scatterPlotDemo3 = new ScatterPlotDemo3("JFreeChart: ScatterPlotDemo3.java");
        scatterPlotDemo3.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)scatterPlotDemo3));
        scatterPlotDemo3.setVisible(true);
    }

    static class MyChartMouseListener
    implements ChartMouseListener {
        ChartPanel panel;

        public MyChartMouseListener(ChartPanel chartPanel) {
            this.panel = chartPanel;
        }

        public void chartMouseClicked(ChartMouseEvent chartMouseEvent) {
            int n = chartMouseEvent.getTrigger().getX();
            int n2 = chartMouseEvent.getTrigger().getY();
            Point2D point2D = this.panel.translateScreenToJava2D(new Point(n, n2));
            XYPlot xYPlot = (XYPlot)this.panel.getChart().getPlot();
            ChartRenderingInfo chartRenderingInfo = this.panel.getChartRenderingInfo();
            Rectangle2D rectangle2D = chartRenderingInfo.getPlotInfo().getDataArea();
            double d = xYPlot.getDomainAxis().java2DToValue(point2D.getX(), rectangle2D, xYPlot.getDomainAxisEdge());
            double d2 = xYPlot.getRangeAxis().java2DToValue(point2D.getY(), rectangle2D, xYPlot.getRangeAxisEdge());
            ValueAxis valueAxis = xYPlot.getDomainAxis();
            ValueAxis valueAxis2 = xYPlot.getRangeAxis();
            double d3 = valueAxis.valueToJava2D(d, rectangle2D, xYPlot.getDomainAxisEdge());
            double d4 = valueAxis2.valueToJava2D(d2, rectangle2D, xYPlot.getRangeAxisEdge());
            Point point = this.panel.translateJava2DToScreen((Point2D)new Point2D.Double(d3, d4));
            System.out.println("Mouse coordinates are (" + n + ", " + n2 + "), in data space = (" + d + ", " + d2 + ").");
            System.out.println("--> (" + point.getX() + ", " + point.getY() + ")");
        }

        public void chartMouseMoved(ChartMouseEvent chartMouseEvent) {
        }
    }

}

