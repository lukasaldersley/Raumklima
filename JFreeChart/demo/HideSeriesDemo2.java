/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.renderer.category.StatisticalLineAndShapeRenderer
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.statistics.DefaultStatisticalCategoryDataset
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
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.StatisticalLineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.statistics.DefaultStatisticalCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class HideSeriesDemo2
extends ApplicationFrame {
    public HideSeriesDemo2(String string) {
        super(string);
        this.setContentPane((Container)new MyDemoPanel());
    }

    public static JPanel createDemoPanel() {
        return new MyDemoPanel();
    }

    public static void main(String[] arrstring) {
        HideSeriesDemo2 hideSeriesDemo2 = new HideSeriesDemo2("JFreeChart: HideSeriesDemo2.java");
        hideSeriesDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)hideSeriesDemo2));
        hideSeriesDemo2.setVisible(true);
    }

    static class MyDemoPanel
    extends DemoPanel
    implements ActionListener {
        private CategoryItemRenderer renderer;

        public MyDemoPanel() {
            super(new BorderLayout());
            CategoryDataset categoryDataset = this.createSampleDataset();
            JFreeChart jFreeChart = this.createChart(categoryDataset);
            this.addChart(jFreeChart);
            ChartPanel chartPanel = new ChartPanel(jFreeChart);
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

        private CategoryDataset createSampleDataset() {
            DefaultStatisticalCategoryDataset defaultStatisticalCategoryDataset = new DefaultStatisticalCategoryDataset();
            defaultStatisticalCategoryDataset.add(10.0, 2.4, (Comparable)((Object)"Row 1"), (Comparable)((Object)"Column 1"));
            defaultStatisticalCategoryDataset.add(15.0, 4.4, (Comparable)((Object)"Row 1"), (Comparable)((Object)"Column 2"));
            defaultStatisticalCategoryDataset.add(13.0, 2.1, (Comparable)((Object)"Row 1"), (Comparable)((Object)"Column 3"));
            defaultStatisticalCategoryDataset.add(7.0, 1.3, (Comparable)((Object)"Row 1"), (Comparable)((Object)"Column 4"));
            defaultStatisticalCategoryDataset.add(22.0, 2.4, (Comparable)((Object)"Row 2"), (Comparable)((Object)"Column 1"));
            defaultStatisticalCategoryDataset.add(18.0, 4.4, (Comparable)((Object)"Row 2"), (Comparable)((Object)"Column 2"));
            defaultStatisticalCategoryDataset.add(28.0, 2.1, (Comparable)((Object)"Row 2"), (Comparable)((Object)"Column 3"));
            defaultStatisticalCategoryDataset.add(7.0, 1.3, (Comparable)((Object)"Row 2"), (Comparable)((Object)"Column 4"));
            defaultStatisticalCategoryDataset.add(2.0, 2.4, (Comparable)((Object)"Row 3"), (Comparable)((Object)"Column 1"));
            defaultStatisticalCategoryDataset.add(8.0, 4.4, (Comparable)((Object)"Row 3"), (Comparable)((Object)"Column 2"));
            defaultStatisticalCategoryDataset.add(8.0, 2.1, (Comparable)((Object)"Row 3"), (Comparable)((Object)"Column 3"));
            defaultStatisticalCategoryDataset.add(7.0, 1.3, (Comparable)((Object)"Row 3"), (Comparable)((Object)"Column 4"));
            return defaultStatisticalCategoryDataset;
        }

        private JFreeChart createChart(CategoryDataset categoryDataset) {
            JFreeChart jFreeChart = ChartFactory.createAreaChart((String)"Hide Series Demo 2", (String)"Category", (String)"Value", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
            CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
            categoryPlot.setRenderer((CategoryItemRenderer)new StatisticalLineAndShapeRenderer());
            this.renderer = categoryPlot.getRenderer(0);
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

