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
 *  org.jfree.data.function.Function2D
 *  org.jfree.data.function.LineFunction2D
 *  org.jfree.data.function.PowerFunction2D
 *  org.jfree.data.general.DatasetUtilities
 *  org.jfree.data.statistics.Regression
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.XYSeries
 *  org.jfree.data.xy.XYSeriesCollection
 *  org.jfree.ui.ApplicationFrame
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
import org.jfree.data.function.Function2D;
import org.jfree.data.function.LineFunction2D;
import org.jfree.data.function.PowerFunction2D;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.statistics.Regression;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class RegressionDemo1
extends ApplicationFrame {
    public RegressionDemo1(String string) {
        super(string);
        JPanel jPanel = RegressionDemo1.createDemoPanel();
        this.getContentPane().add(jPanel);
    }

    public static JPanel createDemoPanel() {
        return new MyDemoPanel();
    }

    public static void main(String[] arrstring) {
        RegressionDemo1 regressionDemo1 = new RegressionDemo1("JFreeChart: Regression Demo 1");
        regressionDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)regressionDemo1));
        regressionDemo1.setVisible(true);
    }

    static class MyDemoPanel
    extends DemoPanel {
        private XYDataset data1;

        public MyDemoPanel() {
            super(new BorderLayout());
            this.data1 = this.createSampleData1();
            this.add(this.createContent());
        }

        private XYDataset createSampleData1() {
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
            return xYSeriesCollection;
        }

        private JTabbedPane createContent() {
            JTabbedPane jTabbedPane = new JTabbedPane();
            jTabbedPane.add("Linear", (Component)this.createChartPanel1());
            jTabbedPane.add("Power", (Component)this.createChartPanel2());
            return jTabbedPane;
        }

        private ChartPanel createChartPanel1() {
            NumberAxis numberAxis = new NumberAxis("X");
            numberAxis.setAutoRangeIncludesZero(false);
            NumberAxis numberAxis2 = new NumberAxis("Y");
            numberAxis2.setAutoRangeIncludesZero(false);
            XYLineAndShapeRenderer xYLineAndShapeRenderer = new XYLineAndShapeRenderer(false, true);
            XYPlot xYPlot = new XYPlot(this.data1, (ValueAxis)numberAxis, (ValueAxis)numberAxis2, (XYItemRenderer)xYLineAndShapeRenderer);
            double[] arrd = Regression.getOLSRegression((XYDataset)this.data1, (int)0);
            LineFunction2D lineFunction2D = new LineFunction2D(arrd[0], arrd[1]);
            XYDataset xYDataset = DatasetUtilities.sampleFunction2D((Function2D)lineFunction2D, (double)2.0, (double)11.0, (int)100, (Comparable)((Object)"Fitted Regression Line"));
            xYPlot.setDataset(1, xYDataset);
            XYLineAndShapeRenderer xYLineAndShapeRenderer2 = new XYLineAndShapeRenderer(true, false);
            xYLineAndShapeRenderer2.setSeriesPaint(0, (Paint)Color.blue);
            xYPlot.setRenderer(1, (XYItemRenderer)xYLineAndShapeRenderer2);
            JFreeChart jFreeChart = new JFreeChart("Linear Regression", JFreeChart.DEFAULT_TITLE_FONT, (Plot)xYPlot, true);
            ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
            this.addChart(jFreeChart);
            ChartPanel chartPanel = new ChartPanel(jFreeChart);
            return chartPanel;
        }

        private ChartPanel createChartPanel2() {
            NumberAxis numberAxis = new NumberAxis("X");
            numberAxis.setAutoRangeIncludesZero(false);
            NumberAxis numberAxis2 = new NumberAxis("Y");
            numberAxis2.setAutoRangeIncludesZero(false);
            XYLineAndShapeRenderer xYLineAndShapeRenderer = new XYLineAndShapeRenderer(false, true);
            XYPlot xYPlot = new XYPlot(this.data1, (ValueAxis)numberAxis, (ValueAxis)numberAxis2, (XYItemRenderer)xYLineAndShapeRenderer);
            double[] arrd = Regression.getPowerRegression((XYDataset)this.data1, (int)0);
            PowerFunction2D powerFunction2D = new PowerFunction2D(arrd[0], arrd[1]);
            XYDataset xYDataset = DatasetUtilities.sampleFunction2D((Function2D)powerFunction2D, (double)2.0, (double)11.0, (int)100, (Comparable)((Object)"Fitted Regression Line"));
            XYLineAndShapeRenderer xYLineAndShapeRenderer2 = new XYLineAndShapeRenderer(true, false);
            xYLineAndShapeRenderer2.setSeriesPaint(0, (Paint)Color.blue);
            xYPlot.setDataset(1, xYDataset);
            xYPlot.setRenderer(1, (XYItemRenderer)xYLineAndShapeRenderer2);
            JFreeChart jFreeChart = new JFreeChart("Power Regression", JFreeChart.DEFAULT_TITLE_FONT, (Plot)xYPlot, true);
            ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
            this.addChart(jFreeChart);
            ChartPanel chartPanel = new ChartPanel(jFreeChart);
            return chartPanel;
        }
    }

}

