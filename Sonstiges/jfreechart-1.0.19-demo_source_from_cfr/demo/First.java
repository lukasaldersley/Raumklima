/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartFrame
 *  org.jfree.chart.JFreeChart
 *  org.jfree.data.general.DefaultPieDataset
 *  org.jfree.data.general.PieDataset
 */
package demo;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class First {
    public static void main(String[] arrstring) {
        DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
        defaultPieDataset.setValue((Comparable)((Object)"Category 1"), 43.2);
        defaultPieDataset.setValue((Comparable)((Object)"Category 2"), 27.9);
        defaultPieDataset.setValue((Comparable)((Object)"Category 3"), 79.5);
        JFreeChart jFreeChart = ChartFactory.createPieChart((String)"Sample Pie Chart", (PieDataset)defaultPieDataset, (boolean)true, (boolean)true, (boolean)false);
        ChartFrame chartFrame = new ChartFrame("JFreeChart: First.java", jFreeChart);
        chartFrame.pack();
        chartFrame.setVisible(true);
    }
}

