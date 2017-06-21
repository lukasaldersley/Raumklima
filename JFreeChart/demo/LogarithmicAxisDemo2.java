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

public class LogarithmicAxisDemo2
extends ApplicationFrame {
    public LogarithmicAxisDemo2(String string) {
        super(string);
        JPanel jPanel = LogarithmicAxisDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createScatterPlot((String)"Logarithmic Axis Demo 2", (String)"X", (String)"Y", (XYDataset)xYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        LogarithmicAxis logarithmicAxis = new LogarithmicAxis("X");
        logarithmicAxis.setExpTickLabelsFlag(true);
        logarithmicAxis.setStrictValuesFlag(false);
        LogarithmicAxis logarithmicAxis2 = new LogarithmicAxis("Y");
        logarithmicAxis2.setAllowNegativesFlag(true);
        logarithmicAxis2.setLog10TickLabelsFlag(true);
        xYPlot.setDomainAxis((ValueAxis)logarithmicAxis);
        xYPlot.setRangeAxis((ValueAxis)logarithmicAxis2);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    private static XYDataset createDataset() {
        XYSeries xYSeries = new XYSeries((Comparable)((Object)"Series 1"));
        xYSeries.add(-500.0, -500.0);
        xYSeries.add(-50.0, -50.0);
        xYSeries.add(-5.0, -5.0);
        xYSeries.add(0.0, 0.0);
        xYSeries.add(5.0, 5.0);
        xYSeries.add(50.0, 50.0);
        xYSeries.add(500.0, 500.0);
        return new XYSeriesCollection(xYSeries);
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = LogarithmicAxisDemo2.createChart(LogarithmicAxisDemo2.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        LogarithmicAxisDemo2 logarithmicAxisDemo2 = new LogarithmicAxisDemo2("JFreeChart: LogarithmicAxisDemo2.java");
        logarithmicAxisDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)logarithmicAxisDemo2));
        logarithmicAxisDemo2.setVisible(true);
    }
}

