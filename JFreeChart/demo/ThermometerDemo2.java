/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.ThermometerPlot
 *  org.jfree.data.general.DefaultValueDataset
 *  org.jfree.data.general.ValueDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.ThermometerPlot;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.general.ValueDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class ThermometerDemo2
extends ApplicationFrame {
    public ThermometerDemo2(String string) {
        super(string);
        JPanel jPanel = ThermometerDemo2.createDemoPanel();
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart() {
        DefaultValueDataset defaultValueDataset = new DefaultValueDataset(37.2);
        ThermometerPlot thermometerPlot = new ThermometerPlot((ValueDataset)defaultValueDataset);
        JFreeChart jFreeChart = new JFreeChart("ThermometerDemo2", (Plot)thermometerPlot);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = ThermometerDemo2.createChart();
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        ThermometerDemo2 thermometerDemo2 = new ThermometerDemo2("JFreeChart: ThermometerDemo2.java");
        thermometerDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)thermometerDemo2));
        thermometerDemo2.setVisible(true);
    }
}

