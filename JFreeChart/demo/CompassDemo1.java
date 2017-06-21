/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.CompassPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.data.general.DefaultValueDataset
 *  org.jfree.data.general.ValueDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CompassPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.general.ValueDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class CompassDemo1
extends ApplicationFrame {
    public CompassDemo1(String string) {
        super(string);
        ChartPanel chartPanel = (ChartPanel)CompassDemo1.createDemoPanel();
        chartPanel.setPreferredSize(new Dimension(500, 270));
        chartPanel.setEnforceFileExtensions(false);
        this.setContentPane((Container)chartPanel);
    }

    private static JFreeChart createChart(ValueDataset valueDataset) {
        CompassPlot compassPlot = new CompassPlot(valueDataset);
        compassPlot.setSeriesNeedle(7);
        compassPlot.setSeriesPaint(0, (Paint)Color.black);
        compassPlot.setSeriesOutlinePaint(0, (Paint)Color.black);
        compassPlot.setRosePaint((Paint)Color.red);
        compassPlot.setRoseHighlightPaint((Paint)Color.gray);
        compassPlot.setRoseCenterPaint((Paint)Color.white);
        compassPlot.setDrawBorder(false);
        JFreeChart jFreeChart = new JFreeChart((Plot)compassPlot);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = CompassDemo1.createChart((ValueDataset)new DefaultValueDataset((Number)new Double(45.0)));
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        CompassDemo1 compassDemo1 = new CompassDemo1("JFreeChart: CompassDemo1.java");
        compassDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)compassDemo1));
        compassDemo1.setVisible(true);
    }
}

