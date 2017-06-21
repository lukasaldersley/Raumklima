/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.StandardXYBarPainter
 *  org.jfree.chart.renderer.xy.XYBarPainter
 *  org.jfree.chart.renderer.xy.XYBarRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.statistics.HistogramDataset
 *  org.jfree.data.xy.IntervalXYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import java.io.IOException;
import java.util.Random;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class HistogramDemo1
extends ApplicationFrame {
    public HistogramDemo1(String string) {
        super(string);
        JPanel jPanel = HistogramDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static IntervalXYDataset createDataset() {
        int n;
        HistogramDataset histogramDataset = new HistogramDataset();
        double[] arrd = new double[1000];
        Random random = new Random(12345678);
        for (n = 0; n < 1000; ++n) {
            arrd[n] = random.nextGaussian() + 5.0;
        }
        histogramDataset.addSeries((Comparable)((Object)"H1"), arrd, 100, 2.0, 8.0);
        arrd = new double[1000];
        for (n = 0; n < 1000; ++n) {
            arrd[n] = random.nextGaussian() + 7.0;
        }
        histogramDataset.addSeries((Comparable)((Object)"H2"), arrd, 100, 4.0, 10.0);
        return histogramDataset;
    }

    private static JFreeChart createChart(IntervalXYDataset intervalXYDataset) {
        JFreeChart jFreeChart = ChartFactory.createHistogram((String)"Histogram Demo 1", (String)null, (String)null, (IntervalXYDataset)intervalXYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        xYPlot.setForegroundAlpha(0.85f);
        NumberAxis numberAxis = (NumberAxis)xYPlot.getRangeAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        XYBarRenderer xYBarRenderer = (XYBarRenderer)xYPlot.getRenderer();
        xYBarRenderer.setDrawBarOutline(false);
        xYBarRenderer.setBarPainter((XYBarPainter)new StandardXYBarPainter());
        xYBarRenderer.setShadowVisible(false);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = HistogramDemo1.createChart(HistogramDemo1.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) throws IOException {
        HistogramDemo1 histogramDemo1 = new HistogramDemo1("JFreeChart: HistogramDemo1.java");
        histogramDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)histogramDemo1));
        histogramDemo1.setVisible(true);
    }
}

