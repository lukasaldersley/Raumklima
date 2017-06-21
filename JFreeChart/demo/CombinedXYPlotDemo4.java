/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.annotations.XYAnnotation
 *  org.jfree.chart.annotations.XYTextAnnotation
 *  org.jfree.chart.axis.AxisLocation
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.CombinedDomainXYPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.StandardXYItemRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.XYSeries
 *  org.jfree.data.xy.XYSeriesCollection
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYAnnotation;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class CombinedXYPlotDemo4
extends ApplicationFrame {
    public CombinedXYPlotDemo4(String string) {
        super(string);
        ChartPanel chartPanel = (ChartPanel)CombinedXYPlotDemo4.createDemoPanel();
        chartPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)chartPanel);
    }

    private static JFreeChart createCombinedChart() {
        XYDataset xYDataset = CombinedXYPlotDemo4.createDataset1();
        StandardXYItemRenderer standardXYItemRenderer = new StandardXYItemRenderer();
        NumberAxis numberAxis = new NumberAxis("Range 1");
        XYPlot xYPlot = new XYPlot(xYDataset, null, (ValueAxis)numberAxis, (XYItemRenderer)standardXYItemRenderer);
        xYPlot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
        xYPlot.setDataset(1, CombinedXYPlotDemo4.createDataset2());
        NumberAxis numberAxis2 = new NumberAxis("Range Axis 2");
        numberAxis2.setAutoRangeIncludesZero(false);
        xYPlot.setRangeAxis(1, (ValueAxis)numberAxis2);
        xYPlot.setRangeAxisLocation(1, AxisLocation.BOTTOM_OR_RIGHT);
        xYPlot.setRenderer(1, (XYItemRenderer)new StandardXYItemRenderer());
        xYPlot.mapDatasetToRangeAxis(1, 1);
        xYPlot.setRangePannable(true);
        XYTextAnnotation xYTextAnnotation = new XYTextAnnotation("Hello!", 50.0, 10000.0);
        xYTextAnnotation.setFont(new Font("SansSerif", 0, 9));
        xYTextAnnotation.setRotationAngle(0.7853981633974483);
        xYPlot.addAnnotation((XYAnnotation)xYTextAnnotation);
        XYDataset xYDataset2 = CombinedXYPlotDemo4.createDataset2();
        StandardXYItemRenderer standardXYItemRenderer2 = new StandardXYItemRenderer();
        NumberAxis numberAxis3 = new NumberAxis("Range 2");
        numberAxis3.setAutoRangeIncludesZero(false);
        XYPlot xYPlot2 = new XYPlot(xYDataset2, null, (ValueAxis)numberAxis3, (XYItemRenderer)standardXYItemRenderer2);
        xYPlot2.setRangeAxisLocation(AxisLocation.TOP_OR_LEFT);
        CombinedDomainXYPlot combinedDomainXYPlot = new CombinedDomainXYPlot((ValueAxis)new NumberAxis("Domain"));
        combinedDomainXYPlot.setGap(10.0);
        combinedDomainXYPlot.setDomainPannable(true);
        combinedDomainXYPlot.add(xYPlot, 1);
        combinedDomainXYPlot.add(xYPlot2, 1);
        combinedDomainXYPlot.setOrientation(PlotOrientation.VERTICAL);
        JFreeChart jFreeChart = new JFreeChart("CombinedDomainXYPlot Demo", JFreeChart.DEFAULT_TITLE_FONT, (Plot)combinedDomainXYPlot, true);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    private static XYDataset createDataset1() {
        XYSeries xYSeries = new XYSeries((Comparable)((Object)"Series 1a"));
        xYSeries.add(10.0, 12353.3);
        xYSeries.add(20.0, 13734.4);
        xYSeries.add(30.0, 14525.3);
        xYSeries.add(40.0, 13984.3);
        xYSeries.add(50.0, 12999.4);
        xYSeries.add(60.0, 14274.3);
        xYSeries.add(70.0, 15943.5);
        xYSeries.add(80.0, 14845.3);
        xYSeries.add(90.0, 14645.4);
        xYSeries.add(100.0, 16234.6);
        xYSeries.add(110.0, 17232.3);
        xYSeries.add(120.0, 14232.2);
        xYSeries.add(130.0, 13102.2);
        xYSeries.add(140.0, 14230.2);
        xYSeries.add(150.0, 11235.2);
        XYSeries xYSeries2 = new XYSeries((Comparable)((Object)"Series 1b"));
        xYSeries2.add(10.0, 15000.3);
        xYSeries2.add(20.0, 11000.4);
        xYSeries2.add(30.0, 17000.3);
        xYSeries2.add(40.0, 15000.3);
        xYSeries2.add(50.0, 14000.4);
        xYSeries2.add(60.0, 12000.3);
        xYSeries2.add(70.0, 11000.5);
        xYSeries2.add(80.0, 12000.3);
        xYSeries2.add(90.0, 13000.4);
        xYSeries2.add(100.0, 12000.6);
        xYSeries2.add(110.0, 13000.3);
        xYSeries2.add(120.0, 17000.2);
        xYSeries2.add(130.0, 18000.2);
        xYSeries2.add(140.0, 16000.2);
        xYSeries2.add(150.0, 17000.2);
        XYSeriesCollection xYSeriesCollection = new XYSeriesCollection();
        xYSeriesCollection.addSeries(xYSeries);
        xYSeriesCollection.addSeries(xYSeries2);
        return xYSeriesCollection;
    }

    private static XYDataset createDataset2() {
        XYSeries xYSeries = new XYSeries((Comparable)((Object)"Series 2"));
        xYSeries.add(10.0, 6853.2);
        xYSeries.add(20.0, 9642.3);
        xYSeries.add(30.0, 8253.5);
        xYSeries.add(40.0, 5352.3);
        xYSeries.add(50.0, 3532.0);
        xYSeries.add(60.0, 2635.3);
        xYSeries.add(70.0, 3998.2);
        xYSeries.add(80.0, 1943.2);
        xYSeries.add(90.0, 6943.9);
        xYSeries.add(100.0, 7843.2);
        xYSeries.add(105.0, 6495.3);
        xYSeries.add(110.0, 7943.6);
        xYSeries.add(115.0, 8500.7);
        xYSeries.add(120.0, 9595.9);
        return new XYSeriesCollection(xYSeries);
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = CombinedXYPlotDemo4.createCombinedChart();
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        CombinedXYPlotDemo4 combinedXYPlotDemo4 = new CombinedXYPlotDemo4("JFreeChart: CombinedDomainXYPlotDemo4.java");
        combinedXYPlotDemo4.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)combinedXYPlotDemo4));
        combinedXYPlotDemo4.setVisible(true);
    }
}

