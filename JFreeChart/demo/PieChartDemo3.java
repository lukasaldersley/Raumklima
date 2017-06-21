/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.PiePlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.data.general.DefaultPieDataset
 *  org.jfree.data.general.PieDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PieChartDemo3
extends ApplicationFrame {
    public PieChartDemo3(String string) {
        super(string);
        JPanel jPanel = PieChartDemo3.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(PieDataset pieDataset) {
        JFreeChart jFreeChart = ChartFactory.createPieChart((String)"Pie Chart Demo 3", (PieDataset)pieDataset, (boolean)true, (boolean)true, (boolean)false);
        PiePlot piePlot = (PiePlot)jFreeChart.getPlot();
        piePlot.setNoDataMessage("No data available so we go into this really long spiel about what that means and it runs off the end of the line but what can you do about that!");
        piePlot.setNoDataMessageFont(new Font("Serif", 2, 10));
        piePlot.setNoDataMessagePaint((Paint)Color.red);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = PieChartDemo3.createChart((PieDataset)new DefaultPieDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        PieChartDemo3 pieChartDemo3 = new PieChartDemo3("Pie Chart Demo 3");
        pieChartDemo3.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)pieChartDemo3));
        pieChartDemo3.setVisible(true);
    }
}

