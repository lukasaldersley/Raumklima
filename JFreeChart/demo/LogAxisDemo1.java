/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.LogAxis
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

import java.awt.BasicStroke;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Stroke;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class LogAxisDemo1
extends ApplicationFrame {
    public LogAxisDemo1(String string) {
        super(string);
        JPanel jPanel = LogAxisDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createScatterPlot((String)"Log Axis Demo 1", (String)"X", (String)"Y", (XYDataset)xYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        xYPlot.setDomainGridlineStroke((Stroke)new BasicStroke(1.0f));
        xYPlot.setRangeGridlineStroke((Stroke)new BasicStroke(1.0f));
        xYPlot.setDomainMinorGridlinesVisible(true);
        xYPlot.setRangeMinorGridlinesVisible(true);
        xYPlot.setDomainMinorGridlineStroke((Stroke)new BasicStroke(0.1f));
        xYPlot.setRangeMinorGridlineStroke((Stroke)new BasicStroke(0.1f));
        LogAxis logAxis = new LogAxis("X");
        LogAxis logAxis2 = new LogAxis("Y");
        xYPlot.setDomainAxis((ValueAxis)logAxis);
        xYPlot.setRangeAxis((ValueAxis)logAxis2);
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
        xYSeries.add(21.9, 9005.5);
        xYSeries.add(25.6, 734.4);
        xYSeries.add(6663000.0, 6453.2);
        return new XYSeriesCollection(xYSeries);
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = LogAxisDemo1.createChart(LogAxisDemo1.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        LogAxisDemo1 logAxisDemo1 = new LogAxisDemo1("JFreeChart: LogAxisDemo1.java");
        logAxisDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)logAxisDemo1));
        logAxisDemo1.setVisible(true);
    }
}

