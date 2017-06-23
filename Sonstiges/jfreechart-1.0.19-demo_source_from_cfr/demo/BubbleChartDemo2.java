/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.BubbleXYItemLabelGenerator
 *  org.jfree.chart.labels.ItemLabelAnchor
 *  org.jfree.chart.labels.ItemLabelPosition
 *  org.jfree.chart.labels.StandardXYZToolTipGenerator
 *  org.jfree.chart.labels.XYItemLabelGenerator
 *  org.jfree.chart.labels.XYToolTipGenerator
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYBubbleRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.xy.XYZDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.ui.TextAnchor
 */
package demo;

import demo.SampleXYZDataset2;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.BubbleXYItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardXYZToolTipGenerator;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBubbleRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class BubbleChartDemo2
extends ApplicationFrame {
    public BubbleChartDemo2(String string) {
        super(string);
        JPanel jPanel = BubbleChartDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(XYZDataset xYZDataset) {
        JFreeChart jFreeChart = ChartFactory.createBubbleChart((String)"Bubble Chart Demo 2", (String)"X", (String)"Y", (XYZDataset)xYZDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setRenderer((XYItemRenderer)new XYBubbleRenderer(0));
        xYPlot.setForegroundAlpha(0.65f);
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        XYItemRenderer xYItemRenderer = xYPlot.getRenderer();
        xYItemRenderer.setSeriesPaint(0, (Paint)Color.blue);
        xYItemRenderer.setBaseItemLabelGenerator((XYItemLabelGenerator)new BubbleXYItemLabelGenerator());
        xYItemRenderer.setBaseToolTipGenerator((XYToolTipGenerator)new StandardXYZToolTipGenerator());
        xYItemRenderer.setBaseItemLabelsVisible(true);
        xYItemRenderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
        NumberAxis numberAxis = (NumberAxis)xYPlot.getDomainAxis();
        numberAxis.setRange(0.0, 10.0);
        NumberAxis numberAxis2 = (NumberAxis)xYPlot.getRangeAxis();
        numberAxis2.setRange(0.0, 10.0);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = BubbleChartDemo2.createChart(new SampleXYZDataset2());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        BubbleChartDemo2 bubbleChartDemo2 = new BubbleChartDemo2("JFreeChart: BubbleChartDemo2.java");
        bubbleChartDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)bubbleChartDemo2));
        bubbleChartDemo2.setVisible(true);
    }
}

