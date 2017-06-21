/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.PieLabelLinkStyle
 *  org.jfree.chart.plot.PiePlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.data.general.DefaultPieDataset
 *  org.jfree.data.general.PieDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.util.SortOrder
 */
package demo;

import demo.DemoPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PieLabelLinkStyle;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.SortOrder;

public class PieChartDemo4
extends ApplicationFrame {
    public PieChartDemo4(String string) {
        super(string);
        JPanel jPanel = PieChartDemo4.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static DefaultPieDataset createDataset() {
        DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
        defaultPieDataset.setValue((Comparable)((Object)"Section A"), (Number)new Double(43.2));
        defaultPieDataset.setValue((Comparable)((Object)"Section B"), (Number)new Double(10.0));
        defaultPieDataset.setValue((Comparable)((Object)"Section C"), (Number)new Double(27.5));
        defaultPieDataset.setValue((Comparable)((Object)"Section D"), (Number)new Double(17.5));
        defaultPieDataset.setValue((Comparable)((Object)"Section E"), (Number)new Double(11.0));
        defaultPieDataset.setValue((Comparable)((Object)"Section F"), (Number)new Double(19.4));
        return defaultPieDataset;
    }

    private static JFreeChart createChart(PieDataset pieDataset) {
        JFreeChart jFreeChart = ChartFactory.createPieChart((String)"Pie Chart Demo 4", (PieDataset)pieDataset, (boolean)true, (boolean)true, (boolean)false);
        PiePlot piePlot = (PiePlot)jFreeChart.getPlot();
        piePlot.setNoDataMessage("No data available");
        piePlot.setCircular(false);
        piePlot.setLabelGap(0.02);
        piePlot.setExplodePercent((Comparable)((Object)"Section D"), 0.5);
        piePlot.setLabelLinkStyle(PieLabelLinkStyle.CUBIC_CURVE);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        return new MyDemoPanel(PieChartDemo4.createDataset());
    }

    public static void main(String[] arrstring) {
        PieChartDemo4 pieChartDemo4 = new PieChartDemo4("JFreeChart: PieChartDemo4.java");
        pieChartDemo4.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)pieChartDemo4));
        pieChartDemo4.setVisible(true);
    }

    private static class MyDemoPanel
    extends DemoPanel
    implements ActionListener {
        JFreeChart chart;
        DefaultPieDataset dataset;
        boolean ascendingByKey = false;
        boolean ascendingByValue = false;

        public MyDemoPanel(DefaultPieDataset defaultPieDataset) {
            super(new BorderLayout());
            this.dataset = defaultPieDataset;
            this.chart = PieChartDemo4.createChart((PieDataset)defaultPieDataset);
            this.addChart(this.chart);
            ChartPanel chartPanel = new ChartPanel(this.chart);
            chartPanel.setMouseWheelEnabled(true);
            this.add((Component)chartPanel);
            JPanel jPanel = new JPanel(new FlowLayout());
            JButton jButton = new JButton("By Key");
            jButton.setActionCommand("BY_KEY");
            jButton.addActionListener(this);
            JButton jButton2 = new JButton("By Value");
            jButton2.setActionCommand("BY_VALUE");
            jButton2.addActionListener(this);
            JButton jButton3 = new JButton("Random");
            jButton3.setActionCommand("RANDOM");
            jButton3.addActionListener(this);
            JCheckBox jCheckBox = new JCheckBox("Simple Labels");
            jCheckBox.setActionCommand("LABELS");
            jCheckBox.addActionListener(this);
            jPanel.add(jButton);
            jPanel.add(jButton2);
            jPanel.add(jButton3);
            jPanel.add(jCheckBox);
            this.add((Component)jPanel, "South");
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String string = actionEvent.getActionCommand();
            if ("BY_KEY".equals(string)) {
                if (!this.ascendingByKey) {
                    this.dataset.sortByKeys(SortOrder.ASCENDING);
                    this.ascendingByKey = true;
                } else {
                    this.dataset.sortByKeys(SortOrder.DESCENDING);
                    this.ascendingByKey = false;
                }
            } else if ("BY_VALUE".equals(string)) {
                if (!this.ascendingByValue) {
                    this.dataset.sortByValues(SortOrder.ASCENDING);
                    this.ascendingByValue = true;
                } else {
                    this.dataset.sortByValues(SortOrder.DESCENDING);
                    this.ascendingByValue = false;
                }
            } else if ("RANDOM".equals(string)) {
                Comparable comparable2;
                ArrayList arrayList = new ArrayList(this.dataset.getKeys());
                Collections.shuffle(arrayList);
                DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
                for (Comparable comparable2 : arrayList) {
                    defaultPieDataset.setValue(comparable2, this.dataset.getValue(comparable2));
                }
                comparable2 = (PiePlot)this.chart.getPlot();
                comparable2.setDataset((PieDataset)defaultPieDataset);
                this.dataset = defaultPieDataset;
            } else if ("LABELS".equals(string)) {
                PiePlot piePlot = (PiePlot)this.chart.getPlot();
                boolean bl = piePlot.getSimpleLabels();
                if (bl) {
                    piePlot.setInteriorGap(0.05);
                    piePlot.setSimpleLabels(false);
                } else {
                    piePlot.setInteriorGap(0.01);
                    piePlot.setSimpleLabels(true);
                }
            }
        }
    }

}

