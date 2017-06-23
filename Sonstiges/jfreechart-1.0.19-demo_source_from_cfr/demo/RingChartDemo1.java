/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.RingPlot
 *  org.jfree.data.general.DefaultPieDataset
 *  org.jfree.data.general.PieDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.RingPlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class RingChartDemo1
extends ApplicationFrame {
    public RingChartDemo1(String string) {
        super(string);
        JPanel jPanel = RingChartDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static PieDataset createDataset() {
        DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
        defaultPieDataset.setValue((Comparable)((Object)"One"), (Number)new Double(43.2));
        defaultPieDataset.setValue((Comparable)((Object)"Two"), (Number)new Double(10.0));
        defaultPieDataset.setValue((Comparable)((Object)"Three"), (Number)new Double(27.5));
        defaultPieDataset.setValue((Comparable)((Object)"Four"), (Number)new Double(17.5));
        defaultPieDataset.setValue((Comparable)((Object)"Five"), (Number)new Double(11.0));
        defaultPieDataset.setValue((Comparable)((Object)"Six"), (Number)new Double(19.4));
        return defaultPieDataset;
    }

    private static JFreeChart createChart(PieDataset pieDataset) {
        JFreeChart jFreeChart = ChartFactory.createRingChart((String)"Ring Chart Demo 1", (PieDataset)pieDataset, (boolean)false, (boolean)true, (boolean)false);
        RingPlot ringPlot = (RingPlot)jFreeChart.getPlot();
        ringPlot.setLabelFont(new Font("SansSerif", 0, 12));
        ringPlot.setNoDataMessage("No data available");
        ringPlot.setSectionDepth(0.35);
        ringPlot.setCircular(false);
        ringPlot.setLabelGap(0.02);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = RingChartDemo1.createChart(RingChartDemo1.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        RingChartDemo1 ringChartDemo1 = new RingChartDemo1("JFreeChart: RingChartDemo1.java");
        ringChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)ringChartDemo1));
        ringChartDemo1.setVisible(true);
    }
}

