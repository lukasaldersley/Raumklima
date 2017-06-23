/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PolarPlot
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
import java.awt.Paint;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PolarChartDemo1
extends ApplicationFrame {
    public PolarChartDemo1(String string) {
        super(string);
        JPanel jPanel = PolarChartDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static XYDataset createDataset() {
        XYSeriesCollection xYSeriesCollection = new XYSeriesCollection();
        XYSeries xYSeries = new XYSeries((Comparable)((Object)"Series 1"));
        xYSeries.add(0.0, 2.0);
        xYSeries.add(90.0, 13.0);
        xYSeries.add(180.0, 9.0);
        xYSeries.add(270.0, 8.0);
        xYSeriesCollection.addSeries(xYSeries);
        XYSeries xYSeries2 = new XYSeries((Comparable)((Object)"Series 2"));
        xYSeries2.add(90.0, -11.2);
        xYSeries2.add(180.0, 21.4);
        xYSeries2.add(250.0, 17.3);
        xYSeries2.add(355.0, 10.9);
        xYSeriesCollection.addSeries(xYSeries2);
        return xYSeriesCollection;
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createPolarChart((String)"Polar Chart Demo 1", (XYDataset)xYDataset, (boolean)true, (boolean)false, (boolean)false);
        PolarPlot polarPlot = (PolarPlot)jFreeChart.getPlot();
        polarPlot.addCornerTextItem("Corner Item 1");
        polarPlot.addCornerTextItem("Corner Item 2");
        polarPlot.setAngleGridlinePaint((Paint)Color.white);
        polarPlot.setRadiusGridlinePaint((Paint)Color.white);
        NumberAxis numberAxis = (NumberAxis)polarPlot.getAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = PolarChartDemo1.createChart(PolarChartDemo1.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseZoomable(false);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        PolarChartDemo1 polarChartDemo1 = new PolarChartDemo1("JFreeChart: PolarChartDemo1.java");
        polarChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)polarChartDemo1));
        polarChartDemo1.setVisible(true);
    }
}

