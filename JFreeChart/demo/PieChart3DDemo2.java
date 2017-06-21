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

import demo.Rotator;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import javax.swing.JPanel;
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

public class PieChart3DDemo2
extends ApplicationFrame {
    public PieChart3DDemo2(String string) {
        super(string);
        JPanel jPanel = PieChart3DDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(PieDataset pieDataset) {
        JFreeChart jFreeChart = ChartFactory.createPieChart3D((String)"Pie Chart 3D Demo 2", (PieDataset)pieDataset, (boolean)true, (boolean)false, (boolean)false);
        PiePlot3D piePlot3D = (PiePlot3D)jFreeChart.getPlot();
        piePlot3D.setStartAngle(270.0);
        piePlot3D.setDirection(Rotation.ANTICLOCKWISE);
        piePlot3D.setForegroundAlpha(0.6f);
        return jFreeChart;
    }

    private static PieDataset createDataset() {
        DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
        defaultPieDataset.setValue((Comparable)((Object)"Java"), (Number)new Double(43.2));
        defaultPieDataset.setValue((Comparable)((Object)"Visual Basic"), (Number)new Double(10.0));
        defaultPieDataset.setValue((Comparable)((Object)"C/C++"), (Number)new Double(17.5));
        defaultPieDataset.setValue((Comparable)((Object)"PHP"), (Number)new Double(32.5));
        defaultPieDataset.setValue((Comparable)((Object)"Perl"), (Number)new Double(12.5));
        return defaultPieDataset;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = PieChart3DDemo2.createChart(PieChart3DDemo2.createDataset());
        Rotator rotator = new Rotator((PiePlot3D)jFreeChart.getPlot());
        rotator.start();
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        PieChart3DDemo2 pieChart3DDemo2 = new PieChart3DDemo2("JFreeChart: PieChart3DDemo2.java");
        pieChart3DDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)pieChart3DDemo2));
        pieChart3DDemo2.setVisible(true);
    }
}

