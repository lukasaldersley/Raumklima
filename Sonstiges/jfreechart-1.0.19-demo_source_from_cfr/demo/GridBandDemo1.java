/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.XYSeries
 *  org.jfree.data.xy.XYSeriesCollection
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
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class GridBandDemo1
extends ApplicationFrame {
    public GridBandDemo1(String string) {
        super(string);
        JPanel jPanel = GridBandDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createScatterPlot((String)"Grid Band Demo 1", (String)"X", (String)"Y", (XYDataset)xYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)false, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setNoDataMessage("NO DATA");
        xYPlot.setRangeZeroBaselineVisible(true);
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        xYPlot.setDomainTickBandPaint((Paint)new Color(0, 100, 0, 50));
        xYPlot.setRangeTickBandPaint((Paint)new Color(0, 100, 0, 50));
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        XYSeries xYSeries = new XYSeries((Comparable)((Object)"Random Data"));
        for (int i = 0; i < 100; ++i) {
            xYSeries.add(Math.random() + 1.0, Math.random() + 1.0);
        }
        XYSeriesCollection xYSeriesCollection = new XYSeriesCollection();
        xYSeriesCollection.addSeries(xYSeries);
        JFreeChart jFreeChart = GridBandDemo1.createChart((XYDataset)xYSeriesCollection);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        GridBandDemo1 gridBandDemo1 = new GridBandDemo1("JFreeChart: GridBandDemo1.java");
        gridBandDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)gridBandDemo1));
        gridBandDemo1.setVisible(true);
    }
}

