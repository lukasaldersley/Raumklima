/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.data.time.Millisecond
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class CloneTest1
extends ApplicationFrame
implements ActionListener {
    private TimeSeries series = new TimeSeries((Comparable)((Object)"Random Data"));
    private double lastValue = 100.0;

    public CloneTest1(String string) {
        super(string);
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection(this.series);
        JFreeChart jFreeChart = this.createChart((XYDataset)timeSeriesCollection);
        JFreeChart jFreeChart2 = null;
        try {
            jFreeChart2 = (JFreeChart)jFreeChart.clone();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        XYPlot xYPlot = (XYPlot)jFreeChart2.getPlot();
        TimeSeriesCollection timeSeriesCollection2 = (TimeSeriesCollection)xYPlot.getDataset();
        this.series = timeSeriesCollection2.getSeries(0);
        ChartPanel chartPanel = new ChartPanel(jFreeChart2);
        JButton jButton = new JButton("Add New Data Item");
        jButton.setActionCommand("ADD_DATA");
        jButton.addActionListener(this);
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.add((Component)chartPanel);
        jPanel.add((Component)jButton, "South");
        chartPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Clone Test 1", (String)"Time", (String)"Value", (XYDataset)xYDataset, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        ValueAxis valueAxis = xYPlot.getDomainAxis();
        valueAxis.setAutoRange(true);
        valueAxis.setFixedAutoRange(60000.0);
        return jFreeChart;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("ADD_DATA")) {
            double d = 0.9 + 0.2 * Math.random();
            this.lastValue *= d;
            Millisecond millisecond = new Millisecond();
            System.out.println("Now = " + millisecond.toString());
            this.series.add((RegularTimePeriod)new Millisecond(), this.lastValue);
        }
    }

    public static void main(String[] arrstring) {
        CloneTest1 cloneTest1 = new CloneTest1("JFreeChart : Clone Test 1");
        cloneTest1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)cloneTest1));
        cloneTest1.setVisible(true);
    }
}

