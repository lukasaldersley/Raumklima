/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.JFreeChart
 */
package demo;

import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.JFreeChart;

public class DemoPanel
extends JPanel {
    List charts = new ArrayList();

    public DemoPanel(LayoutManager layoutManager) {
        super(layoutManager);
    }

    public void addChart(JFreeChart jFreeChart) {
        this.charts.add(jFreeChart);
    }

    public JFreeChart[] getCharts() {
        int n = this.charts.size();
        JFreeChart[] arrjFreeChart = new JFreeChart[n];
        for (int i = 0; i < n; ++i) {
            arrjFreeChart[i] = (JFreeChart)this.charts.get(i);
        }
        return arrjFreeChart;
    }
}

