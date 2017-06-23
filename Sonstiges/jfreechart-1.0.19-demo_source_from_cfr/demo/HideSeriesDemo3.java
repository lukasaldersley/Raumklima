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
 *  org.jfree.data.xy.DefaultXYZDataset
 *  org.jfree.data.xy.XYZDataset
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
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class HideSeriesDemo3
extends ApplicationFrame {
    public HideSeriesDemo3(String string) {
        super(string);
        this.setContentPane((Container)new MyDemoPanel());
    }

    public static JPanel createDemoPanel() {
        return new MyDemoPanel();
    }

    public static void main(String[] arrstring) {
        HideSeriesDemo3 hideSeriesDemo3 = new HideSeriesDemo3("JFreeChart: HideSeriesDemo3.java");
        hideSeriesDemo3.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)hideSeriesDemo3));
        hideSeriesDemo3.setVisible(true);
    }

    static class MyDemoPanel
    extends DemoPanel
    implements ActionListener {
        private XYItemRenderer renderer;

        public MyDemoPanel() {
            super(new BorderLayout());
            XYZDataset xYZDataset = this.createSampleDataset();
            JFreeChart jFreeChart = this.createChart(xYZDataset);
            this.addChart(jFreeChart);
            ChartPanel chartPanel = new ChartPanel(jFreeChart);
            chartPanel.setMouseWheelEnabled(true);
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

        private XYZDataset createSampleDataset() {
            DefaultXYZDataset defaultXYZDataset = new DefaultXYZDataset();
            double[] arrd = new double[]{2.1, 2.3, 2.3};
            double[] arrd2 = new double[]{14.1, 11.1, 10.0};
            double[] arrd3 = new double[]{2.4, 2.7, 2.7};
            double[][] arrarrd = new double[][]{arrd, arrd2, arrd3};
            defaultXYZDataset.addSeries((Comparable)((Object)"Series 1"), (double[][])arrarrd);
            arrd = new double[]{2.2, 2.2, 1.8};
            arrd2 = new double[]{14.1, 11.1, 10.0};
            arrd3 = new double[]{2.2, 2.2, 2.2};
            arrarrd = new double[][]{arrd, arrd2, arrd3};
            defaultXYZDataset.addSeries((Comparable)((Object)"Series 2"), (double[][])arrarrd);
            arrd = new double[]{1.8, 1.9, 2.3, 3.8};
            arrd2 = new double[]{5.4, 4.1, 4.1, 25.0};
            arrd3 = new double[]{2.1, 2.2, 1.6, 4.0};
            arrarrd = new double[][]{arrd, arrd2, arrd3};
            defaultXYZDataset.addSeries((Comparable)((Object)"Series 3"), (double[][])arrarrd);
            return defaultXYZDataset;
        }

        private JFreeChart createChart(XYZDataset xYZDataset) {
            JFreeChart jFreeChart = ChartFactory.createBubbleChart((String)"Hide Series Demo 3", (String)"X", (String)"Y", (XYZDataset)xYZDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
            XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
            xYPlot.setDomainPannable(true);
            xYPlot.setRangePannable(true);
            this.renderer = xYPlot.getRenderer(0);
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

