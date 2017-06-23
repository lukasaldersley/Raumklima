/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.PiePlot
 *  org.jfree.chart.plot.PiePlot3D
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.title.TextTitle
 *  org.jfree.chart.title.Title
 *  org.jfree.data.general.DefaultPieDataset
 *  org.jfree.data.general.PieDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import demo.DemoPanel;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PieChartDemo5
extends ApplicationFrame {
    public PieChartDemo5(String string) {
        super(string);
        this.setContentPane((Container)PieChartDemo5.createDemoPanel());
    }

    public static JPanel createDemoPanel() {
        DemoPanel demoPanel = new DemoPanel(new GridLayout(2, 2));
        DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
        defaultPieDataset.setValue((Comparable)((Object)"Section 1"), 23.3);
        defaultPieDataset.setValue((Comparable)((Object)"Section 2"), 56.5);
        defaultPieDataset.setValue((Comparable)((Object)"Section 3"), 43.3);
        defaultPieDataset.setValue((Comparable)((Object)"Section 4"), 11.1);
        JFreeChart jFreeChart = ChartFactory.createPieChart((String)"Chart 1", (PieDataset)defaultPieDataset, (boolean)false, (boolean)false, (boolean)false);
        jFreeChart.addSubtitle((Title)new TextTitle("setCircular(true);", new Font("Dialog", 0, 12)));
        PiePlot piePlot = (PiePlot)jFreeChart.getPlot();
        piePlot.setCircular(true);
        piePlot.setInteriorGap(0.04);
        piePlot.setMaximumLabelWidth(0.2);
        JFreeChart jFreeChart2 = ChartFactory.createPieChart((String)"Chart 2", (PieDataset)defaultPieDataset, (boolean)false, (boolean)false, (boolean)false);
        jFreeChart2.addSubtitle((Title)new TextTitle("setCircular(false);", new Font("Dialog", 0, 12)));
        PiePlot piePlot2 = (PiePlot)jFreeChart2.getPlot();
        piePlot2.setCircular(false);
        piePlot2.setInteriorGap(0.04);
        piePlot2.setMaximumLabelWidth(0.2);
        JFreeChart jFreeChart3 = ChartFactory.createPieChart3D((String)"Chart 3", (PieDataset)defaultPieDataset, (boolean)false, (boolean)false, (boolean)false);
        jFreeChart3.addSubtitle((Title)new TextTitle("setCircular(true);", new Font("Dialog", 0, 12)));
        PiePlot3D piePlot3D = (PiePlot3D)jFreeChart3.getPlot();
        piePlot3D.setForegroundAlpha(0.6f);
        piePlot3D.setCircular(true);
        piePlot3D.setInteriorGap(0.04);
        piePlot3D.setMaximumLabelWidth(0.2);
        JFreeChart jFreeChart4 = ChartFactory.createPieChart3D((String)"Chart 4", (PieDataset)defaultPieDataset, (boolean)false, (boolean)false, (boolean)false);
        jFreeChart4.addSubtitle((Title)new TextTitle("setCircular(false);", new Font("Dialog", 0, 12)));
        PiePlot3D piePlot3D2 = (PiePlot3D)jFreeChart4.getPlot();
        piePlot3D2.setForegroundAlpha(0.6f);
        piePlot3D2.setCircular(false);
        piePlot3D2.setInteriorGap(0.04);
        piePlot3D2.setMaximumLabelWidth(0.2);
        demoPanel.add((Component)new ChartPanel(jFreeChart));
        demoPanel.add((Component)new ChartPanel(jFreeChart2));
        demoPanel.add((Component)new ChartPanel(jFreeChart3));
        demoPanel.add((Component)new ChartPanel(jFreeChart4));
        demoPanel.addChart(jFreeChart);
        demoPanel.addChart(jFreeChart2);
        demoPanel.addChart(jFreeChart3);
        demoPanel.addChart(jFreeChart4);
        demoPanel.setPreferredSize(new Dimension(800, 600));
        return demoPanel;
    }

    public static void main(String[] arrstring) {
        PieChartDemo5 pieChartDemo5 = new PieChartDemo5("JFreeChart: PieChartDemo5.java");
        pieChartDemo5.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)pieChartDemo5));
        pieChartDemo5.setVisible(true);
    }
}

