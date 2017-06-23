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
 *  org.jfree.data.general.DefaultPieDataset
 *  org.jfree.data.general.PieDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PieChartDemo7
extends ApplicationFrame {
    public PieChartDemo7(String string) {
        super(string);
        this.setContentPane((Container)PieChartDemo7.createDemoPanel());
    }

    private static PieDataset createDataset(int n) {
        DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
        for (int i = 0; i < n; ++i) {
            double d = 100.0 * Math.random();
            defaultPieDataset.setValue((Comparable)((Object)("Section " + i)), d);
        }
        return defaultPieDataset;
    }

    public static JPanel createDemoPanel() {
        PieDataset pieDataset = PieChartDemo7.createDataset(14);
        JFreeChart jFreeChart = ChartFactory.createPieChart((String)"Pie Chart Demo 7", (PieDataset)pieDataset, (boolean)false, (boolean)true, (boolean)false);
        PiePlot piePlot = (PiePlot)jFreeChart.getPlot();
        piePlot.setCircular(true);
        piePlot.setLabelGenerator((PieSectionLabelGenerator)new StandardPieSectionLabelGenerator("{0} = {2}", NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance()));
        piePlot.setNoDataMessage("No data available");
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        Rotator rotator = new Rotator(piePlot);
        rotator.start();
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        PieChartDemo7 pieChartDemo7 = new PieChartDemo7("JFreeChart: PieChartDemo7.java");
        pieChartDemo7.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)pieChartDemo7));
        pieChartDemo7.setVisible(true);
    }

    static class Rotator
    extends Timer
    implements ActionListener {
        private PiePlot plot;
        private int angle = 270;

        Rotator(PiePlot piePlot) {
            super(50, null);
            this.plot = piePlot;
            this.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            this.plot.setStartAngle((double)this.angle);
            ++this.angle;
            if (this.angle == 360) {
                this.angle = 0;
            }
        }
    }

}

