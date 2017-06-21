/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.annotations.XYAnnotation
 *  org.jfree.chart.annotations.XYPointerAnnotation
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.XYSeries
 *  org.jfree.data.xy.XYSeriesCollection
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.ui.TextAnchor
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYAnnotation;
import org.jfree.chart.annotations.XYPointerAnnotation;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class XYAreaChartDemo1
extends ApplicationFrame {
    public XYAreaChartDemo1(String string) {
        super(string);
        XYDataset xYDataset = XYAreaChartDemo1.createDataset();
        JFreeChart jFreeChart = XYAreaChartDemo1.createChart(xYDataset);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)chartPanel);
    }

    private static XYDataset createDataset() {
        XYSeries xYSeries = new XYSeries((Comparable)((Object)"Random 1"));
        xYSeries.add((Number)new Integer(1), (Number)new Double(500.2));
        xYSeries.add((Number)new Integer(2), (Number)new Double(694.1));
        xYSeries.add((Number)new Integer(3), (Number)new Double(-734.4));
        xYSeries.add((Number)new Integer(4), (Number)new Double(453.2));
        xYSeries.add((Number)new Integer(5), (Number)new Double(500.2));
        xYSeries.add((Number)new Integer(6), (Number)new Double(300.7));
        xYSeries.add((Number)new Integer(7), (Number)new Double(734.4));
        xYSeries.add((Number)new Integer(8), (Number)new Double(453.2));
        XYSeries xYSeries2 = new XYSeries((Comparable)((Object)"Random 2"));
        xYSeries2.add((Number)new Integer(1), (Number)new Double(700.2));
        xYSeries2.add((Number)new Integer(2), (Number)new Double(534.1));
        xYSeries2.add((Number)new Integer(3), (Number)new Double(323.4));
        xYSeries2.add((Number)new Integer(4), (Number)new Double(125.2));
        xYSeries2.add((Number)new Integer(5), (Number)new Double(653.2));
        xYSeries2.add((Number)new Integer(6), (Number)new Double(432.7));
        xYSeries2.add((Number)new Integer(7), (Number)new Double(564.4));
        xYSeries2.add((Number)new Integer(8), (Number)new Double(322.2));
        XYSeriesCollection xYSeriesCollection = new XYSeriesCollection();
        xYSeriesCollection.addSeries(xYSeries);
        xYSeriesCollection.addSeries(xYSeries2);
        xYSeriesCollection.setIntervalWidth(0.0);
        return xYSeriesCollection;
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYAreaChart((String)"XY Area Chart Demo", (String)"Domain (X)", (String)"Range (Y)", (XYDataset)xYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setForegroundAlpha(0.65f);
        ValueAxis valueAxis = xYPlot.getDomainAxis();
        valueAxis.setTickMarkPaint((Paint)Color.black);
        valueAxis.setLowerMargin(0.0);
        valueAxis.setUpperMargin(0.0);
        ValueAxis valueAxis2 = xYPlot.getRangeAxis();
        valueAxis2.setTickMarkPaint((Paint)Color.black);
        XYPointerAnnotation xYPointerAnnotation = new XYPointerAnnotation("Test", 5.0, -500.0, 2.356194490192345);
        xYPointerAnnotation.setTipRadius(0.0);
        xYPointerAnnotation.setBaseRadius(35.0);
        xYPointerAnnotation.setFont(new Font("SansSerif", 0, 9));
        xYPointerAnnotation.setPaint((Paint)Color.blue);
        xYPointerAnnotation.setTextAnchor(TextAnchor.HALF_ASCENT_RIGHT);
        xYPlot.addAnnotation((XYAnnotation)xYPointerAnnotation);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        return new ChartPanel(XYAreaChartDemo1.createChart(XYAreaChartDemo1.createDataset()));
    }

    public static void main(String[] arrstring) {
        XYAreaChartDemo1 xYAreaChartDemo1 = new XYAreaChartDemo1("XY Area Chart Demo");
        xYAreaChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)xYAreaChartDemo1));
        xYAreaChartDemo1.setVisible(true);
    }
}

