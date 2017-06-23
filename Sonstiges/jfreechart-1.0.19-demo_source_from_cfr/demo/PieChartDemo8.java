/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.labels.PieSectionLabelGenerator
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
import java.awt.font.TextAttribute;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PieChartDemo8
extends ApplicationFrame {
    public PieChartDemo8(String string) {
        super(string);
        JPanel jPanel = PieChartDemo8.createDemoPanel();
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
        JFreeChart jFreeChart = ChartFactory.createPieChart((String)"Pie Chart Demo 8", (PieDataset)pieDataset, (boolean)false, (boolean)true, (boolean)false);
        PiePlot piePlot = (PiePlot)jFreeChart.getPlot();
        piePlot.setLabelGenerator((PieSectionLabelGenerator)new CustomLabelGenerator());
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = PieChartDemo8.createChart(PieChartDemo8.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        PieChartDemo8 pieChartDemo8 = new PieChartDemo8("JFreeChart: PieChartDemo8.java");
        pieChartDemo8.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)pieChartDemo8));
        pieChartDemo8.setVisible(true);
    }

    static class CustomLabelGenerator
    implements PieSectionLabelGenerator {
        CustomLabelGenerator() {
        }

        public String generateSectionLabel(PieDataset pieDataset, Comparable comparable) {
            String string = null;
            if (pieDataset != null && !comparable.equals("Two")) {
                string = comparable.toString();
            }
            return string;
        }

        public AttributedString generateAttributedSectionLabel(PieDataset pieDataset, Comparable comparable) {
            AttributedString attributedString = null;
            String string = comparable.toString();
            String string2 = string + " : " + String.valueOf(pieDataset.getValue(comparable));
            attributedString = new AttributedString(string2);
            attributedString.addAttribute(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD, 0, string.length() - 1);
            return attributedString;
        }
    }

}

