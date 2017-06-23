/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
 *  org.jfree.chart.renderer.xy.XYSplineRenderer
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.XYSeries
 *  org.jfree.data.xy.XYSeriesCollection
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RectangleInsets
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import demo.DemoPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Paint;
import java.awt.Window;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class XYSplineRendererDemo1
extends ApplicationFrame {
    public XYSplineRendererDemo1(String string) {
        super(string);
        JPanel jPanel = XYSplineRendererDemo1.createDemoPanel();
        this.getContentPane().add(jPanel);
    }

    public static JPanel createDemoPanel() {
        return new MyDemoPanel();
    }

    public static void main(String[] arrstring) {
        XYSplineRendererDemo1 xYSplineRendererDemo1 = new XYSplineRendererDemo1("JFreeChart: XYSplineRendererDemo1.java");
        xYSplineRendererDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)xYSplineRendererDemo1));
        xYSplineRendererDemo1.setVisible(true);
    }

    static class MyDemoPanel
    extends DemoPanel {
        private XYDataset data1;

        public MyDemoPanel() {
            super(new BorderLayout());
            this.data1 = this.createSampleData();
            this.add(this.createContent());
        }

        private XYDataset createSampleData() {
            XYSeries xYSeries = new XYSeries((Comparable)((Object)"Series 1"));
            xYSeries.add(2.0, 56.27);
            xYSeries.add(3.0, 41.32);
            xYSeries.add(4.0, 31.45);
            xYSeries.add(5.0, 30.05);
            xYSeries.add(6.0, 24.69);
            xYSeries.add(7.0, 19.78);
            xYSeries.add(8.0, 20.94);
            xYSeries.add(9.0, 16.73);
            xYSeries.add(10.0, 14.21);
            xYSeries.add(11.0, 12.44);
            XYSeriesCollection xYSeriesCollection = new XYSeriesCollection(xYSeries);
            XYSeries xYSeries2 = new XYSeries((Comparable)((Object)"Series 2"));
            xYSeries2.add(11.0, 56.27);
            xYSeries2.add(10.0, 41.32);
            xYSeries2.add(9.0, 31.45);
            xYSeries2.add(8.0, 30.05);
            xYSeries2.add(7.0, 24.69);
            xYSeries2.add(6.0, 19.78);
            xYSeries2.add(5.0, 20.94);
            xYSeries2.add(4.0, 16.73);
            xYSeries2.add(3.0, 14.21);
            xYSeries2.add(2.0, 12.44);
            xYSeriesCollection.addSeries(xYSeries2);
            return xYSeriesCollection;
        }

        private JTabbedPane createContent() {
            JTabbedPane jTabbedPane = new JTabbedPane();
            jTabbedPane.add("Splines:", (Component)this.createChartPanel1());
            jTabbedPane.add("Lines:", (Component)this.createChartPanel2());
            return jTabbedPane;
        }

        private ChartPanel createChartPanel1() {
            NumberAxis numberAxis = new NumberAxis("X");
            numberAxis.setAutoRangeIncludesZero(false);
            NumberAxis numberAxis2 = new NumberAxis("Y");
            numberAxis2.setAutoRangeIncludesZero(false);
            XYSplineRenderer xYSplineRenderer = new XYSplineRenderer();
            XYPlot xYPlot = new XYPlot(this.data1, (ValueAxis)numberAxis, (ValueAxis)numberAxis2, (XYItemRenderer)xYSplineRenderer);
            xYPlot.setBackgroundPaint((Paint)Color.lightGray);
            xYPlot.setDomainGridlinePaint((Paint)Color.white);
            xYPlot.setRangeGridlinePaint((Paint)Color.white);
            xYPlot.setAxisOffset(new RectangleInsets(4.0, 4.0, 4.0, 4.0));
            JFreeChart jFreeChart = new JFreeChart("XYSplineRenderer", JFreeChart.DEFAULT_TITLE_FONT, (Plot)xYPlot, true);
            this.addChart(jFreeChart);
            ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
            ChartPanel chartPanel = new ChartPanel(jFreeChart);
            return chartPanel;
        }

        private ChartPanel createChartPanel2() {
            NumberAxis numberAxis = new NumberAxis("X");
            numberAxis.setAutoRangeIncludesZero(false);
            NumberAxis numberAxis2 = new NumberAxis("Y");
            numberAxis2.setAutoRangeIncludesZero(false);
            XYLineAndShapeRenderer xYLineAndShapeRenderer = new XYLineAndShapeRenderer();
            XYPlot xYPlot = new XYPlot(this.data1, (ValueAxis)numberAxis, (ValueAxis)numberAxis2, (XYItemRenderer)xYLineAndShapeRenderer);
            xYPlot.setBackgroundPaint((Paint)Color.lightGray);
            xYPlot.setDomainGridlinePaint((Paint)Color.white);
            xYPlot.setRangeGridlinePaint((Paint)Color.white);
            xYPlot.setAxisOffset(new RectangleInsets(4.0, 4.0, 4.0, 4.0));
            JFreeChart jFreeChart = new JFreeChart("XYLineAndShapeRenderer", JFreeChart.DEFAULT_TITLE_FONT, (Plot)xYPlot, true);
            this.addChart(jFreeChart);
            ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
            ChartPanel chartPanel = new ChartPanel(jFreeChart);
            return chartPanel;
        }
    }

}

