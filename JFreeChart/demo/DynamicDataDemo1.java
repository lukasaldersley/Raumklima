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

import demo.DemoPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
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

public class DynamicDataDemo1
extends ApplicationFrame {
    public DynamicDataDemo1(String string) {
        super(string);
        MyDemoPanel myDemoPanel = new MyDemoPanel();
        this.setContentPane((Container)myDemoPanel);
    }

    public static JPanel createDemoPanel() {
        return new MyDemoPanel();
    }

    public static void main(String[] arrstring) {
        DynamicDataDemo1 dynamicDataDemo1 = new DynamicDataDemo1("JFreeChart: DynamicDataDemo1.java");
        dynamicDataDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)dynamicDataDemo1));
        dynamicDataDemo1.setVisible(true);
    }

    static class MyDemoPanel
    extends DemoPanel
    implements ActionListener {
        private TimeSeries series = new TimeSeries((Comparable)((Object)"Random Data"));
        private double lastValue = 100.0;

        public MyDemoPanel() {
            super(new BorderLayout());
            TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection(this.series);
            ChartPanel chartPanel = new ChartPanel(this.createChart((XYDataset)timeSeriesCollection));
            chartPanel.setPreferredSize(new Dimension(500, 270));
            this.addChart(chartPanel.getChart());
            JPanel jPanel = new JPanel();
            jPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
            JButton jButton = new JButton("Add New Data Item");
            jButton.setActionCommand("ADD_DATA");
            jButton.addActionListener(this);
            jPanel.add(jButton);
            this.add((Component)chartPanel);
            this.add((Component)jPanel, "South");
        }

        private JFreeChart createChart(XYDataset xYDataset) {
            JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Dynamic Data Demo", (String)"Time", (String)"Value", (XYDataset)xYDataset);
            XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
            ValueAxis valueAxis = xYPlot.getDomainAxis();
            valueAxis.setAutoRange(true);
            valueAxis.setFixedAutoRange(60000.0);
            valueAxis = xYPlot.getRangeAxis();
            valueAxis.setRange(0.0, 200.0);
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
    }

}

