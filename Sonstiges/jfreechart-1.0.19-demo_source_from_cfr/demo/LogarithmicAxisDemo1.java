/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.LogarithmicAxis
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
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class LogarithmicAxisDemo1
extends ApplicationFrame {
    public LogarithmicAxisDemo1(String string) {
        super(string);
        JPanel jPanel = LogarithmicAxisDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createScatterPlot((String)"Logarithmic Axis Demo 1", (String)"X", (String)"Y", (XYDataset)xYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        LogarithmicAxis logarithmicAxis = new LogarithmicAxis("X");
        LogarithmicAxis logarithmicAxis2 = new LogarithmicAxis("Y");
        xYPlot.setDomainAxis((ValueAxis)logarithmicAxis);
        xYPlot.setRangeAxis((ValueAxis)logarithmicAxis2);
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
        xYSeries.add(3000.0, 453.2);
        return new XYSeriesCollection(xYSeries);
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = LogarithmicAxisDemo1.createChart(LogarithmicAxisDemo1.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        LogarithmicAxisDemo1 logarithmicAxisDemo1 = new LogarithmicAxisDemo1("JFreeChart: LogarithmicAxisDemo1.java");
        logarithmicAxisDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)logarithmicAxisDemo1));
        logarithmicAxisDemo1.setVisible(true);
    }
}

