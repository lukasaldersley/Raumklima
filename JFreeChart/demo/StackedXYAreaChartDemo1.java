/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.labels.StandardXYToolTipGenerator
 *  org.jfree.chart.labels.XYToolTipGenerator
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.StackedXYAreaRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.xy.DefaultTableXYDataset
 *  org.jfree.data.xy.TableXYDataset
 *  org.jfree.data.xy.XYSeries
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
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StackedXYAreaRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StackedXYAreaChartDemo1
extends ApplicationFrame {
    public StackedXYAreaChartDemo1(String string) {
        super(string);
        JPanel jPanel = StackedXYAreaChartDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static TableXYDataset createDataset() {
        DefaultTableXYDataset defaultTableXYDataset = new DefaultTableXYDataset();
        XYSeries xYSeries = new XYSeries((Comparable)((Object)"Series 1"), true, false);
        xYSeries.add(5.0, 5.0);
        xYSeries.add(10.0, 15.5);
        xYSeries.add(15.0, 9.5);
        xYSeries.add(20.0, 7.5);
        defaultTableXYDataset.addSeries(xYSeries);
        XYSeries xYSeries2 = new XYSeries((Comparable)((Object)"Series 2"), true, false);
        xYSeries2.add(5.0, 5.0);
        xYSeries2.add(10.0, 15.5);
        xYSeries2.add(15.0, 9.5);
        xYSeries2.add(20.0, 3.5);
        defaultTableXYDataset.addSeries(xYSeries2);
        return defaultTableXYDataset;
    }

    private static JFreeChart createChart(TableXYDataset tableXYDataset) {
        JFreeChart jFreeChart = ChartFactory.createStackedXYAreaChart((String)"Stacked XY Area Chart Demo 1", (String)"X Value", (String)"Y Value", (TableXYDataset)tableXYDataset);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        StackedXYAreaRenderer stackedXYAreaRenderer = new StackedXYAreaRenderer();
        stackedXYAreaRenderer.setSeriesPaint(0, (Paint)Color.lightGray);
        stackedXYAreaRenderer.setBaseToolTipGenerator((XYToolTipGenerator)new StandardXYToolTipGenerator());
        xYPlot.setRenderer(0, (XYItemRenderer)stackedXYAreaRenderer);
        xYPlot.setDomainCrosshairVisible(true);
        xYPlot.setRangeCrosshairVisible(true);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = StackedXYAreaChartDemo1.createChart(StackedXYAreaChartDemo1.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        StackedXYAreaChartDemo1 stackedXYAreaChartDemo1 = new StackedXYAreaChartDemo1("Stacked XY Area Chart Demo 1");
        stackedXYAreaChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)stackedXYAreaChartDemo1));
        stackedXYAreaChartDemo1.setVisible(true);
    }
}

