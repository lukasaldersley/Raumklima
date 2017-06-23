/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
 *  org.jfree.chart.title.TextTitle
 *  org.jfree.chart.title.Title
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.XYSeries
 *  org.jfree.data.xy.XYSeriesCollection
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Window;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYLineAndShapeRendererDemo2
extends ApplicationFrame {
    public XYLineAndShapeRendererDemo2(String string) {
        super(string);
        JPanel jPanel = XYLineAndShapeRendererDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 300));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart() {
        XYDataset xYDataset = XYLineAndShapeRendererDemo2.createDataset(1, 1.0);
        JFreeChart jFreeChart = ChartFactory.createXYLineChart((String)"XYLineAndShapeRenderer Demo 2", (String)"X", (String)"Y", (XYDataset)xYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        TextTitle textTitle = new TextTitle("This chart shows various combinations of the useFillPaint and useOutlinePaint flags.");
        textTitle.setFont(new Font("Dialog", 0, 10));
        jFreeChart.addSubtitle((Title)textTitle);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        NumberAxis numberAxis = (NumberAxis)xYPlot.getRangeAxis();
        numberAxis.setAutoRangeIncludesZero(false);
        Ellipse2D.Double double_ = new Ellipse2D.Double(-4.0, -4.0, 8.0, 8.0);
        XYLineAndShapeRenderer xYLineAndShapeRenderer = (XYLineAndShapeRenderer)xYPlot.getRenderer();
        xYLineAndShapeRenderer.setBaseShapesVisible(true);
        xYLineAndShapeRenderer.setSeriesShape(0, (Shape)double_);
        xYLineAndShapeRenderer.setSeriesPaint(0, (Paint)Color.red);
        xYLineAndShapeRenderer.setSeriesFillPaint(0, (Paint)Color.yellow);
        xYLineAndShapeRenderer.setSeriesOutlinePaint(0, (Paint)Color.gray);
        XYDataset xYDataset2 = XYLineAndShapeRendererDemo2.createDataset(2, 2.0);
        XYLineAndShapeRenderer xYLineAndShapeRenderer2 = new XYLineAndShapeRenderer();
        xYPlot.setDataset(1, xYDataset2);
        xYPlot.setRenderer(1, (XYItemRenderer)xYLineAndShapeRenderer2);
        xYLineAndShapeRenderer2.setSeriesShape(0, (Shape)double_);
        xYLineAndShapeRenderer2.setSeriesPaint(0, (Paint)Color.red);
        xYLineAndShapeRenderer2.setSeriesFillPaint(0, (Paint)Color.yellow);
        xYLineAndShapeRenderer2.setSeriesOutlinePaint(0, (Paint)Color.gray);
        xYLineAndShapeRenderer2.setUseFillPaint(true);
        XYDataset xYDataset3 = XYLineAndShapeRendererDemo2.createDataset(3, 3.0);
        XYLineAndShapeRenderer xYLineAndShapeRenderer3 = new XYLineAndShapeRenderer();
        xYPlot.setDataset(2, xYDataset3);
        xYPlot.setRenderer(2, (XYItemRenderer)xYLineAndShapeRenderer3);
        xYLineAndShapeRenderer3.setSeriesShape(0, (Shape)double_);
        xYLineAndShapeRenderer3.setSeriesPaint(0, (Paint)Color.red);
        xYLineAndShapeRenderer3.setSeriesFillPaint(0, (Paint)Color.yellow);
        xYLineAndShapeRenderer3.setSeriesOutlinePaint(0, (Paint)Color.gray);
        xYLineAndShapeRenderer3.setUseOutlinePaint(true);
        XYDataset xYDataset4 = XYLineAndShapeRendererDemo2.createDataset(4, 4.0);
        XYLineAndShapeRenderer xYLineAndShapeRenderer4 = new XYLineAndShapeRenderer();
        xYPlot.setDataset(3, xYDataset4);
        xYPlot.setRenderer(3, (XYItemRenderer)xYLineAndShapeRenderer4);
        xYLineAndShapeRenderer4.setSeriesShape(0, (Shape)double_);
        xYLineAndShapeRenderer4.setSeriesPaint(0, (Paint)Color.red);
        xYLineAndShapeRenderer4.setSeriesFillPaint(0, (Paint)Color.yellow);
        xYLineAndShapeRenderer4.setSeriesOutlinePaint(0, (Paint)Color.gray);
        xYLineAndShapeRenderer4.setUseOutlinePaint(true);
        xYLineAndShapeRenderer4.setUseFillPaint(true);
        XYDataset xYDataset5 = XYLineAndShapeRendererDemo2.createDataset(5, 5.0);
        XYLineAndShapeRenderer xYLineAndShapeRenderer5 = new XYLineAndShapeRenderer();
        xYPlot.setDataset(4, xYDataset5);
        xYPlot.setRenderer(4, (XYItemRenderer)xYLineAndShapeRenderer5);
        xYLineAndShapeRenderer5.setSeriesShape(0, (Shape)double_);
        xYLineAndShapeRenderer5.setSeriesPaint(0, (Paint)Color.red);
        xYLineAndShapeRenderer5.setSeriesFillPaint(0, (Paint)Color.yellow);
        xYLineAndShapeRenderer5.setSeriesOutlinePaint(0, (Paint)Color.gray);
        xYLineAndShapeRenderer5.setUseOutlinePaint(true);
        xYLineAndShapeRenderer5.setUseFillPaint(true);
        xYLineAndShapeRenderer5.setDrawOutlines(false);
        return jFreeChart;
    }

    private static XYDataset createDataset(int n, double d) {
        XYSeries xYSeries = new XYSeries((Comparable)((Object)("Series " + n)));
        xYSeries.add(1.0, d);
        xYSeries.add(2.0, d);
        xYSeries.add(3.0, d);
        XYSeriesCollection xYSeriesCollection = new XYSeriesCollection();
        xYSeriesCollection.addSeries(xYSeries);
        return xYSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = XYLineAndShapeRendererDemo2.createChart();
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        XYLineAndShapeRendererDemo2 xYLineAndShapeRendererDemo2 = new XYLineAndShapeRendererDemo2("JFreeChart: XYLineAndShapeRendererDemo2");
        xYLineAndShapeRendererDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)xYLineAndShapeRendererDemo2));
        xYLineAndShapeRendererDemo2.setVisible(true);
    }
}

