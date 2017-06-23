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
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.StackedXYAreaRenderer2
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.xy.CategoryTableXYDataset
 *  org.jfree.data.xy.TableXYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StackedXYAreaRenderer2;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.CategoryTableXYDataset;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StackedXYAreaChartDemo2
extends ApplicationFrame {
    public StackedXYAreaChartDemo2(String string) {
        super(string);
        JPanel jPanel = StackedXYAreaChartDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static TableXYDataset createDataset() {
        CategoryTableXYDataset categoryTableXYDataset = new CategoryTableXYDataset();
        categoryTableXYDataset.add(0.0, 0.0, "Series 1");
        categoryTableXYDataset.add(10.0, 20.0, "Series 1");
        categoryTableXYDataset.add(20.0, 15.0, "Series 1");
        categoryTableXYDataset.add(30.0, 25.0, "Series 1");
        categoryTableXYDataset.add(40.0, 21.0, "Series 1");
        categoryTableXYDataset.add(10.0, 9.0, "Series 2");
        categoryTableXYDataset.add(20.0, -7.0, "Series 2");
        categoryTableXYDataset.add(30.0, 15.0, "Series 2");
        categoryTableXYDataset.add(40.0, 11.0, "Series 2");
        categoryTableXYDataset.add(45.0, -10.0, "Series 2");
        categoryTableXYDataset.add(50.0, 0.0, "Series 2");
        return categoryTableXYDataset;
    }

    private static JFreeChart createChart(TableXYDataset tableXYDataset) {
        JFreeChart jFreeChart = ChartFactory.createStackedXYAreaChart((String)"Stacked XY Area Chart Demo 2", (String)"X Value", (String)"Y Value", (TableXYDataset)tableXYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        StackedXYAreaRenderer2 stackedXYAreaRenderer2 = new StackedXYAreaRenderer2();
        stackedXYAreaRenderer2.setRoundXCoordinates(true);
        stackedXYAreaRenderer2.setBaseToolTipGenerator((XYToolTipGenerator)new StandardXYToolTipGenerator());
        xYPlot.setRenderer(0, (XYItemRenderer)stackedXYAreaRenderer2);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = StackedXYAreaChartDemo2.createChart(StackedXYAreaChartDemo2.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        StackedXYAreaChartDemo2 stackedXYAreaChartDemo2 = new StackedXYAreaChartDemo2("Stacked XY Area Chart Demo 2");
        stackedXYAreaChartDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)stackedXYAreaChartDemo2));
        stackedXYAreaChartDemo2.setVisible(true);
    }
}

