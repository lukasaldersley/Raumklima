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

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Window;
import javax.swing.JPanel;
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

public class PieChartDemo2
extends ApplicationFrame {
    public PieChartDemo2(String string) {
        super(string);
        JPanel jPanel = PieChartDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static PieDataset createDataset() {
        DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
        defaultPieDataset.setValue((Comparable)((Object)"One"), 43.2);
        defaultPieDataset.setValue((Comparable)((Object)"Two"), 10.0);
        defaultPieDataset.setValue((Comparable)((Object)"Three"), 27.5);
        defaultPieDataset.setValue((Comparable)((Object)"Four"), 17.5);
        defaultPieDataset.setValue((Comparable)((Object)"Five"), 11.0);
        defaultPieDataset.setValue((Comparable)((Object)"Six"), 19.4);
        return defaultPieDataset;
    }

    private static JFreeChart createChart(PieDataset pieDataset) {
        JFreeChart jFreeChart = ChartFactory.createPieChart((String)"Pie Chart Demo 2", (PieDataset)pieDataset, (boolean)true, (boolean)true, (boolean)false);
        PiePlot piePlot = (PiePlot)jFreeChart.getPlot();
        piePlot.setSectionPaint((Comparable)((Object)"One"), (Paint)new Color(160, 160, 255));
        piePlot.setSectionPaint((Comparable)((Object)"Two"), (Paint)new Color(128, 128, 223));
        piePlot.setSectionPaint((Comparable)((Object)"Three"), (Paint)new Color(96, 96, 191));
        piePlot.setSectionPaint((Comparable)((Object)"Four"), (Paint)new Color(64, 64, 159));
        piePlot.setSectionPaint((Comparable)((Object)"Five"), (Paint)new Color(32, 32, 127));
        piePlot.setSectionPaint((Comparable)((Object)"Six"), (Paint)new Color(0, 0, 111));
        piePlot.setNoDataMessage("No data available");
        piePlot.setExplodePercent((Comparable)((Object)"Two"), 0.2);
        piePlot.setLabelGenerator((PieSectionLabelGenerator)new StandardPieSectionLabelGenerator("{0} ({2} percent)"));
        piePlot.setLabelBackgroundPaint((Paint)new Color(220, 220, 220));
        piePlot.setLegendLabelToolTipGenerator((PieSectionLabelGenerator)new StandardPieSectionLabelGenerator("Tooltip for legend item {0}"));
        piePlot.setSimpleLabels(true);
        piePlot.setInteriorGap(0.0);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = PieChartDemo2.createChart(PieChartDemo2.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        PieChartDemo2 pieChartDemo2 = new PieChartDemo2("JFreeChart: PieChartDemo2.java");
        pieChartDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)pieChartDemo2));
        pieChartDemo2.setVisible(true);
    }
}

