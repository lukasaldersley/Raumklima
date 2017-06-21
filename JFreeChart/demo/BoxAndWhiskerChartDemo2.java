/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYBoxAndWhiskerRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.statistics.BoxAndWhiskerCalculator
 *  org.jfree.data.statistics.BoxAndWhiskerItem
 *  org.jfree.data.statistics.BoxAndWhiskerXYDataset
 *  org.jfree.data.statistics.DefaultBoxAndWhiskerXYDataset
 *  org.jfree.data.time.Day
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Window;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBoxAndWhiskerRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.statistics.BoxAndWhiskerCalculator;
import org.jfree.data.statistics.BoxAndWhiskerItem;
import org.jfree.data.statistics.BoxAndWhiskerXYDataset;
import org.jfree.data.statistics.DefaultBoxAndWhiskerXYDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BoxAndWhiskerChartDemo2
extends ApplicationFrame {
    public BoxAndWhiskerChartDemo2(String string) {
        super(string);
        JPanel jPanel = BoxAndWhiskerChartDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static BoxAndWhiskerXYDataset createDataset() {
        DefaultBoxAndWhiskerXYDataset defaultBoxAndWhiskerXYDataset = new DefaultBoxAndWhiskerXYDataset((Comparable)((Object)"Series Name"));
        Day day = new Day();
        for (int i = 0; i < 10; ++i) {
            List list = BoxAndWhiskerChartDemo2.createValueList(0.0, 20.0, 20);
            defaultBoxAndWhiskerXYDataset.add(day.getStart(), BoxAndWhiskerCalculator.calculateBoxAndWhiskerStatistics((List)list));
            day = day.next();
        }
        return defaultBoxAndWhiskerXYDataset;
    }

    private static List createValueList(double d, double d2, int n) {
        ArrayList<Double> arrayList = new ArrayList<Double>();
        for (int i = 0; i < n; ++i) {
            double d3 = d + Math.random() * (d2 - d);
            arrayList.add(new Double(d3));
        }
        return arrayList;
    }

    private static JFreeChart createChart(BoxAndWhiskerXYDataset boxAndWhiskerXYDataset) {
        DateAxis dateAxis = new DateAxis("Day");
        NumberAxis numberAxis = new NumberAxis("Value");
        XYBoxAndWhiskerRenderer xYBoxAndWhiskerRenderer = new XYBoxAndWhiskerRenderer();
        XYPlot xYPlot = new XYPlot((XYDataset)boxAndWhiskerXYDataset, (ValueAxis)dateAxis, (ValueAxis)numberAxis, (XYItemRenderer)xYBoxAndWhiskerRenderer);
        JFreeChart jFreeChart = new JFreeChart("Box-and-Whisker Chart Demo 2", (Plot)xYPlot);
        jFreeChart.setBackgroundPaint((Paint)Color.white);
        xYPlot.setBackgroundPaint((Paint)Color.lightGray);
        xYPlot.setDomainGridlinePaint((Paint)Color.white);
        xYPlot.setDomainGridlinesVisible(true);
        xYPlot.setRangeGridlinePaint((Paint)Color.white);
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = BoxAndWhiskerChartDemo2.createChart(BoxAndWhiskerChartDemo2.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        BoxAndWhiskerChartDemo2 boxAndWhiskerChartDemo2 = new BoxAndWhiskerChartDemo2("JFreeChart: BoxAndWhiskerChartDemo2.java");
        boxAndWhiskerChartDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)boxAndWhiskerChartDemo2));
        boxAndWhiskerChartDemo2.setVisible(true);
    }
}

