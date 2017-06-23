/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.PiePlot3D
 *  org.jfree.chart.plot.Plot
 *  org.jfree.data.general.DefaultPieDataset
 *  org.jfree.data.general.PieDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.util.Rotation
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.Plot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.Rotation;

public class PieChart3DDemo1
extends ApplicationFrame {
    public PieChart3DDemo1(String string) {
        super(string);
        ChartPanel chartPanel = PieChart3DDemo1.createDemoPanel();
        chartPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)chartPanel);
    }

    private static PieDataset createDataset() {
        DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
        defaultPieDataset.setValue((Comparable)((Object)"Java"), (Number)new Double(43.2));
        defaultPieDataset.setValue((Comparable)((Object)"Visual Basic"), (Number)new Double(10.0));
        defaultPieDataset.setValue((Comparable)((Object)"C/C++"), (Number)new Double(17.5));
        defaultPieDataset.setValue((Comparable)((Object)"PHP"), (Number)new Double(32.5));
        defaultPieDataset.setValue((Comparable)((Object)"Perl"), null);
        return defaultPieDataset;
    }

    private static JFreeChart createChart(PieDataset pieDataset) {
        JFreeChart jFreeChart = ChartFactory.createPieChart3D((String)"Pie Chart 3D Demo 1", (PieDataset)pieDataset, (boolean)true, (boolean)true, (boolean)false);
        PiePlot3D piePlot3D = (PiePlot3D)jFreeChart.getPlot();
        piePlot3D.setDarkerSides(true);
        piePlot3D.setStartAngle(290.0);
        piePlot3D.setDirection(Rotation.CLOCKWISE);
        piePlot3D.setForegroundAlpha(0.5f);
        piePlot3D.setNoDataMessage("No data to display");
        return jFreeChart;
    }

    public static ChartPanel createDemoPanel() {
        JFreeChart jFreeChart = PieChart3DDemo1.createChart(PieChart3DDemo1.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        PieChart3DDemo1 pieChart3DDemo1 = new PieChart3DDemo1("JFreeChart: PieChart3DDemo1.java");
        pieChart3DDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)pieChart3DDemo1));
        pieChart3DDemo1.setVisible(true);
    }
}

