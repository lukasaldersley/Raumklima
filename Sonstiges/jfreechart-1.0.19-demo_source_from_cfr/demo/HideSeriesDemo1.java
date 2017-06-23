/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.XYSeries
 *  org.jfree.data.xy.XYSeriesCollection
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
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class HideSeriesDemo1
extends ApplicationFrame {
    public HideSeriesDemo1(String string) {
        super(string);
        this.setContentPane((Container)new MyDemoPanel());
    }

    public static JPanel createDemoPanel() {
        return new MyDemoPanel();
    }

    public static void main(String[] arrstring) {
        HideSeriesDemo1 hideSeriesDemo1 = new HideSeriesDemo1("JFreeChart: HideSeriesDemo1.java");
        hideSeriesDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)hideSeriesDemo1));
        hideSeriesDemo1.setVisible(true);
    }

    static class MyDemoPanel
    extends DemoPanel
    implements ActionListener {
        private XYItemRenderer renderer;

        public MyDemoPanel() {
            super(new BorderLayout());
            XYDataset xYDataset = this.createSampleDataset();
            JFreeChart jFreeChart = this.createChart(xYDataset);
            this.addChart(jFreeChart);
            ChartPanel chartPanel = new ChartPanel(jFreeChart, true);
            JPanel jPanel = new JPanel();
            JCheckBox jCheckBox = new JCheckBox("Series 1");
            jCheckBox.setActionCommand("S1");
            jCheckBox.addActionListener(this);
            jCheckBox.setSelected(true);
            JCheckBox jCheckBox2 = new JCheckBox("Series 2");
            jCheckBox2.setActionCommand("S2");
            jCheckBox2.addActionListener(this);
            jCheckBox2.setSelected(true);
            JCheckBox jCheckBox3 = new JCheckBox("Series 3");
            jCheckBox3.setActionCommand("S3");
            jCheckBox3.addActionListener(this);
            jCheckBox3.setSelected(true);
            jPanel.add(jCheckBox);
            jPanel.add(jCheckBox2);
            jPanel.add(jCheckBox3);
            this.add((Component)chartPanel);
            this.add((Component)jPanel, "South");
            chartPanel.setPreferredSize(new Dimension(500, 270));
        }

        private XYDataset createSampleDataset() {
            XYSeries xYSeries = new XYSeries((Comparable)((Object)"Series 1"));
            xYSeries.add(1.0, 3.3);
            xYSeries.add(2.0, 4.4);
            xYSeries.add(3.0, 1.7);
            XYSeries xYSeries2 = new XYSeries((Comparable)((Object)"Series 2"));
            xYSeries2.add(1.0, 7.3);
            xYSeries2.add(2.0, 6.8);
            xYSeries2.add(3.0, 9.6);
            xYSeries2.add(4.0, 5.6);
            XYSeries xYSeries3 = new XYSeries((Comparable)((Object)"Series 3"));
            xYSeries3.add(1.0, 17.3);
            xYSeries3.add(2.0, 16.8);
            xYSeries3.add(3.0, 19.6);
            xYSeries3.add(4.0, 15.6);
            XYSeriesCollection xYSeriesCollection = new XYSeriesCollection();
            xYSeriesCollection.addSeries(xYSeries);
            xYSeriesCollection.addSeries(xYSeries2);
            xYSeriesCollection.addSeries(xYSeries3);
            return xYSeriesCollection;
        }

        private JFreeChart createChart(XYDataset xYDataset) {
            JFreeChart jFreeChart = ChartFactory.createXYLineChart((String)"Hide Series Demo 1", (String)"X", (String)"Y", (XYDataset)xYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
            XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
            this.renderer = xYPlot.getRenderer();
            return jFreeChart;
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            int n = -1;
            if (actionEvent.getActionCommand().equals("S1")) {
                n = 0;
            } else if (actionEvent.getActionCommand().equals("S2")) {
                n = 1;
            } else if (actionEvent.getActionCommand().equals("S3")) {
                n = 2;
            }
            if (n >= 0) {
                boolean bl = this.renderer.getItemVisible(n, 0);
                this.renderer.setSeriesVisible(n, Boolean.valueOf(!bl));
            }
        }
    }

}

