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
 *  org.jfree.chart.renderer.xy.StandardXYItemRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.time.Day
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
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Paint;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class MultipleDatasetDemo1
extends ApplicationFrame {
    public MultipleDatasetDemo1(String string) {
        super(string);
        this.setContentPane((Container)MultipleDatasetDemo1.createDemoPanel());
    }

    public static JPanel createDemoPanel() {
        return new MyDemoPanel();
    }

    public static void main(String[] arrstring) {
        MultipleDatasetDemo1 multipleDatasetDemo1 = new MultipleDatasetDemo1("JFreeChart: MultipleDatasetDemo1.java");
        multipleDatasetDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)multipleDatasetDemo1));
        multipleDatasetDemo1.setVisible(true);
    }

    static class MyDemoPanel
    extends DemoPanel
    implements ActionListener {
        private XYPlot plot;
        private int datasetIndex = 0;

        public MyDemoPanel() {
            super(new BorderLayout());
            TimeSeriesCollection timeSeriesCollection = this.createRandomDataset("Series 1");
            JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Multiple Dataset Demo 1", (String)"Time", (String)"Value", (XYDataset)timeSeriesCollection, (boolean)true, (boolean)true, (boolean)false);
            jFreeChart.setBackgroundPaint(null);
            this.addChart(jFreeChart);
            this.plot = (XYPlot)jFreeChart.getPlot();
            ValueAxis valueAxis = this.plot.getDomainAxis();
            valueAxis.setAutoRange(true);
            NumberAxis numberAxis = new NumberAxis("Range Axis 2");
            numberAxis.setAutoRangeIncludesZero(false);
            ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
            JPanel jPanel = new JPanel(new BorderLayout());
            ChartPanel chartPanel = new ChartPanel(jFreeChart);
            jPanel.add((Component)chartPanel);
            JButton jButton = new JButton("Add Dataset");
            jButton.setActionCommand("ADD_DATASET");
            jButton.addActionListener(this);
            JButton jButton2 = new JButton("Remove Dataset");
            jButton2.setActionCommand("REMOVE_DATASET");
            jButton2.addActionListener(this);
            JPanel jPanel2 = new JPanel(new FlowLayout());
            jPanel2.add(jButton);
            jPanel2.add(jButton2);
            jPanel.add((Component)jPanel2, "South");
            chartPanel.setPreferredSize(new Dimension(500, 270));
            this.add(jPanel);
        }

        private TimeSeriesCollection createRandomDataset(String string) {
            TimeSeries timeSeries = new TimeSeries((Comparable)((Object)string));
            double d = 100.0;
            Day day = new Day();
            for (int i = 0; i < 50; ++i) {
                timeSeries.add((RegularTimePeriod)day, d);
                day = day.next();
                d *= 1.0 + Math.random() / 100.0;
            }
            return new TimeSeriesCollection(timeSeries);
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getActionCommand().equals("ADD_DATASET")) {
                if (this.datasetIndex < 20) {
                    ++this.datasetIndex;
                    this.plot.setDataset(this.datasetIndex, (XYDataset)this.createRandomDataset("S" + this.datasetIndex));
                    this.plot.setRenderer(this.datasetIndex, (XYItemRenderer)new StandardXYItemRenderer());
                }
            } else if (actionEvent.getActionCommand().equals("REMOVE_DATASET") && this.datasetIndex >= 1) {
                this.plot.setDataset(this.datasetIndex, null);
                this.plot.setRenderer(this.datasetIndex, null);
                --this.datasetIndex;
            }
        }
    }

}

