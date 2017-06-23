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
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.DefaultXYItemRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
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
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.DefaultXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class DynamicDataDemo2
extends ApplicationFrame {
    public DynamicDataDemo2(String string) {
        super(string);
        this.setContentPane((Container)DynamicDataDemo2.createDemoPanel());
    }

    public static JPanel createDemoPanel() {
        return new MyDemoPanel();
    }

    public static void main(String[] arrstring) {
        DynamicDataDemo2 dynamicDataDemo2 = new DynamicDataDemo2("JFreeChart: DynamicDataDemo2.java");
        dynamicDataDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)dynamicDataDemo2));
        dynamicDataDemo2.setVisible(true);
    }

    static class MyDemoPanel
    extends DemoPanel
    implements ActionListener {
        private TimeSeries series1 = new TimeSeries((Comparable)((Object)"Random 1"));
        private TimeSeries series2 = new TimeSeries((Comparable)((Object)"Random 2"));
        private double lastValue1 = 100.0;
        private double lastValue2 = 500.0;

        public MyDemoPanel() {
            super(new BorderLayout());
            TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection(this.series1);
            TimeSeriesCollection timeSeriesCollection2 = new TimeSeriesCollection(this.series2);
            JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Dynamic Data Demo 2", (String)"Time", (String)"Value", (XYDataset)timeSeriesCollection);
            this.addChart(jFreeChart);
            XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
            ValueAxis valueAxis = xYPlot.getDomainAxis();
            valueAxis.setAutoRange(true);
            valueAxis.setFixedAutoRange(10000.0);
            xYPlot.setDataset(1, (XYDataset)timeSeriesCollection2);
            NumberAxis numberAxis = new NumberAxis("Range Axis 2");
            numberAxis.setAutoRangeIncludesZero(false);
            xYPlot.setRenderer(1, (XYItemRenderer)new DefaultXYItemRenderer());
            xYPlot.setRangeAxis(1, (ValueAxis)numberAxis);
            xYPlot.mapDatasetToRangeAxis(1, 1);
            ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
            ChartPanel chartPanel = new ChartPanel(jFreeChart);
            this.add((Component)chartPanel);
            JButton jButton = new JButton("Add To Series 1");
            jButton.setActionCommand("ADD_DATA_1");
            jButton.addActionListener(this);
            JButton jButton2 = new JButton("Add To Series 2");
            jButton2.setActionCommand("ADD_DATA_2");
            jButton2.addActionListener(this);
            JButton jButton3 = new JButton("Add To Both");
            jButton3.setActionCommand("ADD_BOTH");
            jButton3.addActionListener(this);
            JPanel jPanel = new JPanel(new FlowLayout());
            jPanel.setBackground(Color.white);
            jPanel.add(jButton);
            jPanel.add(jButton2);
            jPanel.add(jButton3);
            this.add((Component)jPanel, "South");
            chartPanel.setPreferredSize(new Dimension(500, 270));
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            double d;
            Millisecond millisecond;
            boolean bl = false;
            boolean bl2 = false;
            if (actionEvent.getActionCommand().equals("ADD_DATA_1")) {
                bl = true;
            } else if (actionEvent.getActionCommand().equals("ADD_DATA_2")) {
                bl2 = true;
            } else if (actionEvent.getActionCommand().equals("ADD_BOTH")) {
                bl = true;
                bl2 = true;
            }
            if (bl) {
                d = 0.9 + 0.2 * Math.random();
                this.lastValue1 *= d;
                millisecond = new Millisecond();
                System.out.println("Now = " + millisecond.toString());
                this.series1.add((RegularTimePeriod)new Millisecond(), this.lastValue1);
            }
            if (bl2) {
                d = 0.9 + 0.2 * Math.random();
                this.lastValue2 *= d;
                millisecond = new Millisecond();
                System.out.println("Now = " + millisecond.toString());
                this.series2.add((RegularTimePeriod)new Millisecond(), this.lastValue2);
            }
        }
    }

}

