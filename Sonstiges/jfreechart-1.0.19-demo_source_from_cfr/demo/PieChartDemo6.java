/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.labels.PieSectionLabelGenerator
 *  org.jfree.chart.labels.StandardPieSectionLabelGenerator
 *  org.jfree.chart.plot.PiePlot
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
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PieChartDemo6
extends ApplicationFrame {
    public PieChartDemo6(String string) {
        super(string);
        JPanel jPanel = PieChartDemo6.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(800, 600));
        this.setContentPane((Container)jPanel);
    }

    private static PieDataset createDataset() {
        DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
        defaultPieDataset.setValue((Comparable)((Object)"S1"), 7.0);
        defaultPieDataset.setValue((Comparable)((Object)"S2"), null);
        defaultPieDataset.setValue((Comparable)((Object)"S3"), 0.0);
        defaultPieDataset.setValue((Comparable)((Object)"S4"), 3.0);
        defaultPieDataset.setValue((Comparable)((Object)"S5"), -1.0);
        return defaultPieDataset;
    }

    private static JFreeChart createChart(String string, PieDataset pieDataset) {
        JFreeChart jFreeChart = ChartFactory.createPieChart((String)string, (PieDataset)pieDataset, (boolean)true, (boolean)true, (boolean)false);
        PiePlot piePlot = (PiePlot)jFreeChart.getPlot();
        piePlot.setLabelGenerator((PieSectionLabelGenerator)new StandardPieSectionLabelGenerator("{0} = {1}"));
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        DemoPanel demoPanel = new DemoPanel(new GridLayout(2, 2));
        JFreeChart jFreeChart = PieChartDemo6.createChart("Pie Chart 1", PieChartDemo6.createDataset());
        Font font = new Font("Dialog", 0, 12);
        jFreeChart.addSubtitle((Title)new TextTitle("Ignore nulls: false; Ignore zeros: false;", font));
        JFreeChart jFreeChart2 = PieChartDemo6.createChart("Pie Chart 2", PieChartDemo6.createDataset());
        jFreeChart2.addSubtitle((Title)new TextTitle("Ignore nulls: true; Ignore zeros: false;", font));
        PiePlot piePlot = (PiePlot)jFreeChart2.getPlot();
        piePlot.setIgnoreNullValues(true);
        piePlot.setIgnoreZeroValues(false);
        JFreeChart jFreeChart3 = PieChartDemo6.createChart("Pie Chart 3", PieChartDemo6.createDataset());
        jFreeChart3.addSubtitle((Title)new TextTitle("Ignore nulls: false; Ignore zeros: true;", font));
        PiePlot piePlot2 = (PiePlot)jFreeChart3.getPlot();
        piePlot2.setIgnoreNullValues(false);
        piePlot2.setIgnoreZeroValues(true);
        JFreeChart jFreeChart4 = PieChartDemo6.createChart("Pie Chart 4", PieChartDemo6.createDataset());
        jFreeChart4.addSubtitle((Title)new TextTitle("Ignore nulls: true; Ignore zeros: true;", font));
        PiePlot piePlot3 = (PiePlot)jFreeChart4.getPlot();
        piePlot3.setIgnoreNullValues(true);
        piePlot3.setIgnoreZeroValues(true);
        demoPanel.add((Component)new ChartPanel(jFreeChart));
        demoPanel.add((Component)new ChartPanel(jFreeChart2));
        demoPanel.add((Component)new ChartPanel(jFreeChart3));
        demoPanel.add((Component)new ChartPanel(jFreeChart4));
        demoPanel.addChart(jFreeChart);
        demoPanel.addChart(jFreeChart2);
        demoPanel.addChart(jFreeChart3);
        demoPanel.addChart(jFreeChart4);
        return demoPanel;
    }

    public static void main(String[] arrstring) {
        PieChartDemo6 pieChartDemo6 = new PieChartDemo6("JFreeChart: PieChartDemo6.java");
        pieChartDemo6.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)pieChartDemo6));
        pieChartDemo6.setVisible(true);
    }
}

