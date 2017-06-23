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
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.XYSeries
 *  org.jfree.data.xy.XYSeriesCollection
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import java.util.Arrays;
import java.util.List;
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
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYSeriesDemo1
extends ApplicationFrame {
    public XYSeriesDemo1(String string) {
        super(string);
        JPanel jPanel = XYSeriesDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYLineChart((String)"XY Series Demo 1", (String)"X", (String)"Y", (XYDataset)xYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        NumberAxis numberAxis = new NumberAxis(null);
        xYPlot.setDomainAxis(1, (ValueAxis)numberAxis);
        NumberAxis numberAxis2 = new NumberAxis(null);
        xYPlot.setRangeAxis(1, (ValueAxis)numberAxis2);
        List<Integer> list = Arrays.asList(new Integer(0), new Integer(1));
        xYPlot.mapDatasetToDomainAxes(0, list);
        xYPlot.mapDatasetToRangeAxes(0, list);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    private static XYDataset createDataset() {
        XYSeries xYSeries = new XYSeries((Comparable)((Object)"Random Data"));
        xYSeries.add(1.0, 500.2);
        xYSeries.add(5.0, 694.1);
        xYSeries.add(4.0, 100.0);
        xYSeries.add(12.5, 734.4);
        xYSeries.add(17.3, 453.2);
        xYSeries.add(21.2, 500.2);
        xYSeries.add(21.9, null);
        xYSeries.add(25.6, 734.4);
        xYSeries.add(30.0, 453.2);
        return new XYSeriesCollection(xYSeries);
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = XYSeriesDemo1.createChart(XYSeriesDemo1.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        XYSeriesDemo1 xYSeriesDemo1 = new XYSeriesDemo1("JFreeChart: XYSeriesDemo1.java");
        xYSeriesDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)xYSeriesDemo1));
        xYSeriesDemo1.setVisible(true);
    }
}

