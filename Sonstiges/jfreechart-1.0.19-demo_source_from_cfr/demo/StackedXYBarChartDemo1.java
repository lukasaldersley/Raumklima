/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.StackedXYBarRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.xy.DefaultTableXYDataset
 *  org.jfree.data.xy.TableXYDataset
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.XYSeries
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
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StackedXYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StackedXYBarChartDemo1
extends ApplicationFrame {
    public StackedXYBarChartDemo1(String string) {
        super(string);
        JPanel jPanel = StackedXYBarChartDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static TableXYDataset createDataset() {
        DefaultTableXYDataset defaultTableXYDataset = new DefaultTableXYDataset();
        XYSeries xYSeries = new XYSeries((Comparable)((Object)"Series 1"), true, false);
        xYSeries.add(1.0, 5.0);
        xYSeries.add(2.0, 15.5);
        xYSeries.add(3.0, 9.5);
        xYSeries.add(4.0, 7.5);
        defaultTableXYDataset.addSeries(xYSeries);
        XYSeries xYSeries2 = new XYSeries((Comparable)((Object)"Series 2"), true, false);
        xYSeries2.add(1.0, 5.0);
        xYSeries2.add(2.0, 15.5);
        xYSeries2.add(3.0, 9.5);
        xYSeries2.add(4.0, 3.5);
        defaultTableXYDataset.addSeries(xYSeries2);
        return defaultTableXYDataset;
    }

    private static JFreeChart createChart(TableXYDataset tableXYDataset) {
        NumberAxis numberAxis = new NumberAxis("X");
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        NumberAxis numberAxis2 = new NumberAxis("Y");
        StackedXYBarRenderer stackedXYBarRenderer = new StackedXYBarRenderer(0.1);
        stackedXYBarRenderer.setDrawBarOutline(false);
        XYPlot xYPlot = new XYPlot((XYDataset)tableXYDataset, (ValueAxis)numberAxis, (ValueAxis)numberAxis2, (XYItemRenderer)stackedXYBarRenderer);
        JFreeChart jFreeChart = new JFreeChart("Stacked XY Bar Chart Demo 1", (Plot)xYPlot);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = StackedXYBarChartDemo1.createChart(StackedXYBarChartDemo1.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        StackedXYBarChartDemo1 stackedXYBarChartDemo1 = new StackedXYBarChartDemo1("Stacked XY Bar Chart Demo 1");
        stackedXYBarChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)stackedXYBarChartDemo1));
        stackedXYBarChartDemo1.setVisible(true);
    }
}

