/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.SymbolAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.XYSeries
 *  org.jfree.data.xy.XYSeriesCollection
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class SymbolAxisDemo1
extends ApplicationFrame {
    public SymbolAxisDemo1(String string) {
        super(string);
        JPanel jPanel = SymbolAxisDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 300));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        SymbolAxis symbolAxis = new SymbolAxis("Domain", new String[]{"A", "B", "C", "DDDDDDDDDDDDDDDDDDD"});
        SymbolAxis symbolAxis2 = new SymbolAxis("Range", new String[]{"V", "X", "Y", "Z"});
        symbolAxis2.setUpperMargin(0.0);
        XYLineAndShapeRenderer xYLineAndShapeRenderer = new XYLineAndShapeRenderer(false, true);
        XYPlot xYPlot = new XYPlot(xYDataset, (ValueAxis)symbolAxis, (ValueAxis)symbolAxis2, (XYItemRenderer)xYLineAndShapeRenderer);
        JFreeChart jFreeChart = new JFreeChart("SymbolAxis Demo 1", (Plot)xYPlot);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    private static XYDataset createDataset() {
        XYSeries xYSeries = new XYSeries((Comparable)((Object)"Series 1"));
        xYSeries.add(0.0, 3.0);
        xYSeries.add(1.0, 3.0);
        xYSeries.add(2.0, 0.0);
        xYSeries.add(3.0, 1.0);
        XYSeries xYSeries2 = new XYSeries((Comparable)((Object)"Series 2"));
        xYSeries2.add(0.0, 1.0);
        xYSeries2.add(1.0, 2.0);
        xYSeries2.add(2.0, 1.0);
        xYSeries2.add(3.0, 3.0);
        XYSeriesCollection xYSeriesCollection = new XYSeriesCollection();
        xYSeriesCollection.addSeries(xYSeries);
        xYSeriesCollection.addSeries(xYSeries2);
        return xYSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        return new ChartPanel(SymbolAxisDemo1.createChart(SymbolAxisDemo1.createDataset()));
    }

    public static void main(String[] arrstring) {
        SymbolAxisDemo1 symbolAxisDemo1 = new SymbolAxisDemo1("JFreeChart: SymbolAxisDemo1.java");
        symbolAxisDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)symbolAxisDemo1));
        symbolAxisDemo1.setVisible(true);
    }
}

