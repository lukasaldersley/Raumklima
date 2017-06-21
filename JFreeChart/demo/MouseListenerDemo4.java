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
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.PlotRenderingInfo
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.XYSeries
 *  org.jfree.data.xy.XYSeriesCollection
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RectangleEdge
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.PrintStream;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;

public class MouseListenerDemo4
extends ApplicationFrame
implements ChartMouseListener {
    private JFreeChart chart;
    private ChartPanel chartPanel;

    public MouseListenerDemo4(String string) {
        super(string);
        String string2 = "Mouse Listener Demo 4";
        XYDataset xYDataset = this.createDataset();
        this.chart = ChartFactory.createXYLineChart((String)string2, (String)"X", (String)"Y", (XYDataset)xYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)this.chart.getPlot();
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        this.chartPanel = new ChartPanel(this.chart);
        this.chartPanel.setMouseWheelEnabled(true);
        this.chartPanel.setPreferredSize(new Dimension(500, 270));
        this.chartPanel.setMouseZoomable(true);
        this.chartPanel.addChartMouseListener((ChartMouseListener)this);
        this.setContentPane((Container)this.chartPanel);
    }

    public XYDataset createDataset() {
        XYSeries xYSeries = new XYSeries((Comparable)((Object)"Series 1"));
        xYSeries.add(12.5, 11.0);
        xYSeries.add(15.0, 9.3);
        xYSeries.add(20.0, 21.0);
        XYSeriesCollection xYSeriesCollection = new XYSeriesCollection();
        xYSeriesCollection.addSeries(xYSeries);
        return xYSeriesCollection;
    }

    public void chartMouseClicked(ChartMouseEvent chartMouseEvent) {
        int n = chartMouseEvent.getTrigger().getX();
        int n2 = chartMouseEvent.getTrigger().getY();
        System.out.println("x = " + n + ", y = " + n2);
        Point2D point2D = this.chartPanel.translateScreenToJava2D(new Point(n, n2));
        XYPlot xYPlot = (XYPlot)this.chart.getPlot();
        ChartRenderingInfo chartRenderingInfo = this.chartPanel.getChartRenderingInfo();
        Rectangle2D rectangle2D = chartRenderingInfo.getPlotInfo().getDataArea();
        ValueAxis valueAxis = xYPlot.getDomainAxis();
        RectangleEdge rectangleEdge = xYPlot.getDomainAxisEdge();
        ValueAxis valueAxis2 = xYPlot.getRangeAxis();
        RectangleEdge rectangleEdge2 = xYPlot.getRangeAxisEdge();
        double d = valueAxis.java2DToValue(point2D.getX(), rectangle2D, rectangleEdge);
        double d2 = valueAxis2.java2DToValue(point2D.getY(), rectangle2D, rectangleEdge2);
        System.out.println("Chart: x = " + d + ", y = " + d2);
    }

    public void chartMouseMoved(ChartMouseEvent chartMouseEvent) {
    }

    public static void main(String[] arrstring) {
        MouseListenerDemo4 mouseListenerDemo4 = new MouseListenerDemo4("JFreeChart: MouseListenerDemo4.java");
        mouseListenerDemo4.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)mouseListenerDemo4));
        mouseListenerDemo4.setVisible(true);
    }
}

