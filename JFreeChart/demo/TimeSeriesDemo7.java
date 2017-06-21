/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
 *  org.jfree.data.time.Day
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.BasicStroke;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.Window;
import java.awt.geom.GeneralPath;
import java.util.Arrays;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesDemo7
extends ApplicationFrame {
    public TimeSeriesDemo7(String string) {
        super(string);
        JPanel jPanel = TimeSeriesDemo7.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Time Series Demo 7", (String)"Date", (String)"Value", (XYDataset)xYDataset);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        NumberAxis numberAxis = new NumberAxis(null);
        numberAxis.setAutoRangeIncludesZero(false);
        xYPlot.setRangeAxis(1, (ValueAxis)numberAxis);
        List<Integer> list = Arrays.asList(new Integer(0), new Integer(1));
        xYPlot.mapDatasetToRangeAxes(0, list);
        XYLineAndShapeRenderer xYLineAndShapeRenderer = (XYLineAndShapeRenderer)xYPlot.getRenderer();
        xYLineAndShapeRenderer.setAutoPopulateSeriesStroke(false);
        xYLineAndShapeRenderer.setBaseStroke((Stroke)new BasicStroke(1.5f, 1, 1));
        xYLineAndShapeRenderer.setDrawSeriesLineAsPath(true);
        GeneralPath generalPath = new GeneralPath();
        generalPath.moveTo(-6.0f, 0.0f);
        generalPath.lineTo(-3.0f, 6.0f);
        generalPath.lineTo(3.0f, -6.0f);
        generalPath.lineTo(6.0f, 0.0f);
        xYLineAndShapeRenderer.setLegendLine((Shape)generalPath);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    private static XYDataset createDataset() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"EUR/GBP"));
        timeSeries.add((RegularTimePeriod)new Day(2, 1, 2001), (Number)new Double(1.5788));
        timeSeries.add((RegularTimePeriod)new Day(3, 1, 2001), (Number)new Double(1.5913));
        timeSeries.add((RegularTimePeriod)new Day(4, 1, 2001), (Number)new Double(1.5807));
        timeSeries.add((RegularTimePeriod)new Day(5, 1, 2001), (Number)new Double(1.5711));
        timeSeries.add((RegularTimePeriod)new Day(8, 1, 2001), (Number)new Double(1.5778));
        timeSeries.add((RegularTimePeriod)new Day(9, 1, 2001), (Number)new Double(1.5851));
        timeSeries.add((RegularTimePeriod)new Day(10, 1, 2001), (Number)new Double(1.5846));
        timeSeries.add((RegularTimePeriod)new Day(11, 1, 2001), (Number)new Double(1.5727));
        timeSeries.add((RegularTimePeriod)new Day(12, 1, 2001), (Number)new Double(1.5585));
        timeSeries.add((RegularTimePeriod)new Day(15, 1, 2001), (Number)new Double(1.5694));
        timeSeries.add((RegularTimePeriod)new Day(16, 1, 2001), (Number)new Double(1.5629));
        timeSeries.add((RegularTimePeriod)new Day(17, 1, 2001), (Number)new Double(1.5831));
        timeSeries.add((RegularTimePeriod)new Day(18, 1, 2001), (Number)new Double(1.5624));
        timeSeries.add((RegularTimePeriod)new Day(19, 1, 2001), (Number)new Double(1.5694));
        timeSeries.add((RegularTimePeriod)new Day(22, 1, 2001), (Number)new Double(1.5615));
        timeSeries.add((RegularTimePeriod)new Day(23, 1, 2001), (Number)new Double(1.5656));
        timeSeries.add((RegularTimePeriod)new Day(24, 1, 2001), (Number)new Double(1.5795));
        timeSeries.add((RegularTimePeriod)new Day(25, 1, 2001), (Number)new Double(1.5852));
        timeSeries.add((RegularTimePeriod)new Day(26, 1, 2001), (Number)new Double(1.5797));
        timeSeries.add((RegularTimePeriod)new Day(29, 1, 2001), (Number)new Double(1.5862));
        timeSeries.add((RegularTimePeriod)new Day(30, 1, 2001), (Number)new Double(1.5803));
        timeSeries.add((RegularTimePeriod)new Day(31, 1, 2001), (Number)new Double(1.5714));
        timeSeries.add((RegularTimePeriod)new Day(1, 2, 2001), (Number)new Double(1.5717));
        timeSeries.add((RegularTimePeriod)new Day(2, 2, 2001), (Number)new Double(1.5735));
        timeSeries.add((RegularTimePeriod)new Day(5, 2, 2001), (Number)new Double(1.5691));
        timeSeries.add((RegularTimePeriod)new Day(6, 2, 2001), (Number)new Double(1.5676));
        timeSeries.add((RegularTimePeriod)new Day(7, 2, 2001), (Number)new Double(1.5677));
        timeSeries.add((RegularTimePeriod)new Day(8, 2, 2001), (Number)new Double(1.5737));
        timeSeries.add((RegularTimePeriod)new Day(9, 2, 2001), (Number)new Double(1.5654));
        timeSeries.add((RegularTimePeriod)new Day(12, 2, 2001), (Number)new Double(1.5621));
        timeSeries.add((RegularTimePeriod)new Day(13, 2, 2001), (Number)new Double(1.5761));
        timeSeries.add((RegularTimePeriod)new Day(14, 2, 2001), (Number)new Double(1.5898));
        timeSeries.add((RegularTimePeriod)new Day(15, 2, 2001), (Number)new Double(1.6045));
        timeSeries.add((RegularTimePeriod)new Day(16, 2, 2001), (Number)new Double(1.5852));
        timeSeries.add((RegularTimePeriod)new Day(19, 2, 2001), (Number)new Double(1.5704));
        timeSeries.add((RegularTimePeriod)new Day(20, 2, 2001), (Number)new Double(1.5892));
        timeSeries.add((RegularTimePeriod)new Day(21, 2, 2001), (Number)new Double(1.5844));
        timeSeries.add((RegularTimePeriod)new Day(22, 2, 2001), (Number)new Double(1.5934));
        timeSeries.add((RegularTimePeriod)new Day(23, 2, 2001), (Number)new Double(1.5951));
        timeSeries.add((RegularTimePeriod)new Day(26, 2, 2001), (Number)new Double(1.5848));
        timeSeries.add((RegularTimePeriod)new Day(27, 2, 2001), (Number)new Double(1.5706));
        timeSeries.add((RegularTimePeriod)new Day(28, 2, 2001), (Number)new Double(1.568));
        timeSeries.add((RegularTimePeriod)new Day(1, 3, 2001), (Number)new Double(1.5645));
        timeSeries.add((RegularTimePeriod)new Day(2, 3, 2001), (Number)new Double(1.5754));
        timeSeries.add((RegularTimePeriod)new Day(5, 3, 2001), (Number)new Double(1.5808));
        timeSeries.add((RegularTimePeriod)new Day(6, 3, 2001), (Number)new Double(1.5766));
        timeSeries.add((RegularTimePeriod)new Day(7, 3, 2001), (Number)new Double(1.5756));
        timeSeries.add((RegularTimePeriod)new Day(8, 3, 2001), (Number)new Double(1.576));
        timeSeries.add((RegularTimePeriod)new Day(9, 3, 2001), (Number)new Double(1.5748));
        timeSeries.add((RegularTimePeriod)new Day(12, 3, 2001), (Number)new Double(1.5779));
        timeSeries.add((RegularTimePeriod)new Day(13, 3, 2001), (Number)new Double(1.5837));
        timeSeries.add((RegularTimePeriod)new Day(14, 3, 2001), (Number)new Double(1.5886));
        timeSeries.add((RegularTimePeriod)new Day(15, 3, 2001), (Number)new Double(1.5931));
        timeSeries.add((RegularTimePeriod)new Day(16, 3, 2001), (Number)new Double(1.5945));
        timeSeries.add((RegularTimePeriod)new Day(19, 3, 2001), (Number)new Double(1.588));
        timeSeries.add((RegularTimePeriod)new Day(20, 3, 2001), (Number)new Double(1.5817));
        timeSeries.add((RegularTimePeriod)new Day(21, 3, 2001), (Number)new Double(1.5927));
        timeSeries.add((RegularTimePeriod)new Day(22, 3, 2001), (Number)new Double(1.6065));
        timeSeries.add((RegularTimePeriod)new Day(23, 3, 2001), (Number)new Double(1.6006));
        timeSeries.add((RegularTimePeriod)new Day(26, 3, 2001), (Number)new Double(1.6007));
        timeSeries.add((RegularTimePeriod)new Day(27, 3, 2001), (Number)new Double(1.5989));
        timeSeries.add((RegularTimePeriod)new Day(28, 3, 2001), (Number)new Double(1.6135));
        timeSeries.add((RegularTimePeriod)new Day(29, 3, 2001), (Number)new Double(1.6282));
        timeSeries.add((RegularTimePeriod)new Day(30, 3, 2001), (Number)new Double(1.609));
        timeSeries.add((RegularTimePeriod)new Day(2, 4, 2001), (Number)new Double(1.6107));
        timeSeries.add((RegularTimePeriod)new Day(3, 4, 2001), (Number)new Double(1.6093));
        timeSeries.add((RegularTimePeriod)new Day(4, 4, 2001), (Number)new Double(1.588));
        timeSeries.add((RegularTimePeriod)new Day(5, 4, 2001), (Number)new Double(1.5931));
        timeSeries.add((RegularTimePeriod)new Day(6, 4, 2001), (Number)new Double(1.5968));
        timeSeries.add((RegularTimePeriod)new Day(9, 4, 2001), (Number)new Double(1.6072));
        timeSeries.add((RegularTimePeriod)new Day(10, 4, 2001), (Number)new Double(1.6167));
        timeSeries.add((RegularTimePeriod)new Day(11, 4, 2001), (Number)new Double(1.6214));
        timeSeries.add((RegularTimePeriod)new Day(12, 4, 2001), (Number)new Double(1.612));
        timeSeries.add((RegularTimePeriod)new Day(17, 4, 2001), (Number)new Double(1.6229));
        timeSeries.add((RegularTimePeriod)new Day(18, 4, 2001), (Number)new Double(1.6298));
        timeSeries.add((RegularTimePeriod)new Day(19, 4, 2001), (Number)new Double(1.6159));
        timeSeries.add((RegularTimePeriod)new Day(20, 4, 2001), (Number)new Double(1.5996));
        timeSeries.add((RegularTimePeriod)new Day(23, 4, 2001), (Number)new Double(1.6042));
        timeSeries.add((RegularTimePeriod)new Day(24, 4, 2001), (Number)new Double(1.6061));
        timeSeries.add((RegularTimePeriod)new Day(25, 4, 2001), (Number)new Double(1.6045));
        timeSeries.add((RegularTimePeriod)new Day(26, 4, 2001), (Number)new Double(1.597));
        timeSeries.add((RegularTimePeriod)new Day(27, 4, 2001), (Number)new Double(1.6095));
        timeSeries.add((RegularTimePeriod)new Day(30, 4, 2001), (Number)new Double(1.6141));
        timeSeries.add((RegularTimePeriod)new Day(1, 5, 2001), (Number)new Double(1.6076));
        timeSeries.add((RegularTimePeriod)new Day(2, 5, 2001), (Number)new Double(1.6077));
        timeSeries.add((RegularTimePeriod)new Day(3, 5, 2001), (Number)new Double(1.6035));
        timeSeries.add((RegularTimePeriod)new Day(4, 5, 2001), (Number)new Double(1.606));
        timeSeries.add((RegularTimePeriod)new Day(8, 5, 2001), (Number)new Double(1.6178));
        timeSeries.add((RegularTimePeriod)new Day(9, 5, 2001), (Number)new Double(1.6083));
        timeSeries.add((RegularTimePeriod)new Day(10, 5, 2001), (Number)new Double(1.6107));
        timeSeries.add((RegularTimePeriod)new Day(11, 5, 2001), (Number)new Double(1.6209));
        timeSeries.add((RegularTimePeriod)new Day(14, 5, 2001), (Number)new Double(1.6228));
        timeSeries.add((RegularTimePeriod)new Day(15, 5, 2001), (Number)new Double(1.6184));
        timeSeries.add((RegularTimePeriod)new Day(16, 5, 2001), (Number)new Double(1.6167));
        timeSeries.add((RegularTimePeriod)new Day(17, 5, 2001), (Number)new Double(1.6223));
        timeSeries.add((RegularTimePeriod)new Day(18, 5, 2001), (Number)new Double(1.6305));
        timeSeries.add((RegularTimePeriod)new Day(21, 5, 2001), (Number)new Double(1.642));
        timeSeries.add((RegularTimePeriod)new Day(22, 5, 2001), (Number)new Double(1.6484));
        timeSeries.add((RegularTimePeriod)new Day(23, 5, 2001), (Number)new Double(1.6547));
        timeSeries.add((RegularTimePeriod)new Day(24, 5, 2001), (Number)new Double(1.6444));
        timeSeries.add((RegularTimePeriod)new Day(25, 5, 2001), (Number)new Double(1.6577));
        timeSeries.add((RegularTimePeriod)new Day(29, 5, 2001), (Number)new Double(1.6606));
        timeSeries.add((RegularTimePeriod)new Day(30, 5, 2001), (Number)new Double(1.6604));
        timeSeries.add((RegularTimePeriod)new Day(31, 5, 2001), (Number)new Double(1.6772));
        timeSeries.add((RegularTimePeriod)new Day(1, 6, 2001), (Number)new Double(1.6717));
        timeSeries.add((RegularTimePeriod)new Day(4, 6, 2001), (Number)new Double(1.6685));
        timeSeries.add((RegularTimePeriod)new Day(5, 6, 2001), (Number)new Double(1.6621));
        timeSeries.add((RegularTimePeriod)new Day(6, 6, 2001), (Number)new Double(1.646));
        timeSeries.add((RegularTimePeriod)new Day(7, 6, 2001), (Number)new Double(1.6333));
        timeSeries.add((RegularTimePeriod)new Day(8, 6, 2001), (Number)new Double(1.6265));
        timeSeries.add((RegularTimePeriod)new Day(11, 6, 2001), (Number)new Double(1.6311));
        timeSeries.add((RegularTimePeriod)new Day(12, 6, 2001), (Number)new Double(1.6238));
        timeSeries.add((RegularTimePeriod)new Day(13, 6, 2001), (Number)new Double(1.63));
        timeSeries.add((RegularTimePeriod)new Day(14, 6, 2001), (Number)new Double(1.6289));
        timeSeries.add((RegularTimePeriod)new Day(15, 6, 2001), (Number)new Double(1.6276));
        timeSeries.add((RegularTimePeriod)new Day(18, 6, 2001), (Number)new Double(1.6299));
        timeSeries.add((RegularTimePeriod)new Day(19, 6, 2001), (Number)new Double(1.6353));
        timeSeries.add((RegularTimePeriod)new Day(20, 6, 2001), (Number)new Double(1.6378));
        timeSeries.add((RegularTimePeriod)new Day(21, 6, 2001), (Number)new Double(1.6567));
        timeSeries.add((RegularTimePeriod)new Day(22, 6, 2001), (Number)new Double(1.6523));
        timeSeries.add((RegularTimePeriod)new Day(25, 6, 2001), (Number)new Double(1.6418));
        timeSeries.add((RegularTimePeriod)new Day(26, 6, 2001), (Number)new Double(1.6429));
        timeSeries.add((RegularTimePeriod)new Day(27, 6, 2001), (Number)new Double(1.6439));
        timeSeries.add((RegularTimePeriod)new Day(28, 6, 2001), (Number)new Double(1.6605));
        timeSeries.add((RegularTimePeriod)new Day(29, 6, 2001), (Number)new Double(1.6599));
        timeSeries.add((RegularTimePeriod)new Day(2, 7, 2001), (Number)new Double(1.6727));
        timeSeries.add((RegularTimePeriod)new Day(3, 7, 2001), (Number)new Double(1.662));
        timeSeries.add((RegularTimePeriod)new Day(4, 7, 2001), (Number)new Double(1.6628));
        timeSeries.add((RegularTimePeriod)new Day(5, 7, 2001), (Number)new Double(1.673));
        timeSeries.add((RegularTimePeriod)new Day(6, 7, 2001), (Number)new Double(1.6649));
        timeSeries.add((RegularTimePeriod)new Day(9, 7, 2001), (Number)new Double(1.6603));
        timeSeries.add((RegularTimePeriod)new Day(10, 7, 2001), (Number)new Double(1.6489));
        timeSeries.add((RegularTimePeriod)new Day(11, 7, 2001), (Number)new Double(1.6421));
        timeSeries.add((RegularTimePeriod)new Day(12, 7, 2001), (Number)new Double(1.6498));
        timeSeries.add((RegularTimePeriod)new Day(13, 7, 2001), (Number)new Double(1.6447));
        timeSeries.add((RegularTimePeriod)new Day(16, 7, 2001), (Number)new Double(1.6373));
        timeSeries.add((RegularTimePeriod)new Day(17, 7, 2001), (Number)new Double(1.6443));
        timeSeries.add((RegularTimePeriod)new Day(18, 7, 2001), (Number)new Double(1.6246));
        timeSeries.add((RegularTimePeriod)new Day(19, 7, 2001), (Number)new Double(1.6295));
        timeSeries.add((RegularTimePeriod)new Day(20, 7, 2001), (Number)new Double(1.6362));
        timeSeries.add((RegularTimePeriod)new Day(23, 7, 2001), (Number)new Double(1.6348));
        timeSeries.add((RegularTimePeriod)new Day(24, 7, 2001), (Number)new Double(1.6242));
        timeSeries.add((RegularTimePeriod)new Day(25, 7, 2001), (Number)new Double(1.6241));
        timeSeries.add((RegularTimePeriod)new Day(26, 7, 2001), (Number)new Double(1.6281));
        timeSeries.add((RegularTimePeriod)new Day(27, 7, 2001), (Number)new Double(1.6296));
        timeSeries.add((RegularTimePeriod)new Day(30, 7, 2001), (Number)new Double(1.6279));
        timeSeries.add((RegularTimePeriod)new Day(31, 7, 2001), (Number)new Double(1.63));
        timeSeries.add((RegularTimePeriod)new Day(1, 8, 2001), (Number)new Double(1.629));
        timeSeries.add((RegularTimePeriod)new Day(2, 8, 2001), (Number)new Double(1.6237));
        timeSeries.add((RegularTimePeriod)new Day(3, 8, 2001), (Number)new Double(1.6138));
        timeSeries.add((RegularTimePeriod)new Day(6, 8, 2001), (Number)new Double(1.6121));
        timeSeries.add((RegularTimePeriod)new Day(7, 8, 2001), (Number)new Double(1.617));
        timeSeries.add((RegularTimePeriod)new Day(8, 8, 2001), (Number)new Double(1.6135));
        timeSeries.add((RegularTimePeriod)new Day(9, 8, 2001), (Number)new Double(1.5996));
        timeSeries.add((RegularTimePeriod)new Day(10, 8, 2001), (Number)new Double(1.5931));
        timeSeries.add((RegularTimePeriod)new Day(13, 8, 2001), (Number)new Double(1.5828));
        timeSeries.add((RegularTimePeriod)new Day(14, 8, 2001), (Number)new Double(1.5824));
        timeSeries.add((RegularTimePeriod)new Day(15, 8, 2001), (Number)new Double(1.5783));
        timeSeries.add((RegularTimePeriod)new Day(16, 8, 2001), (Number)new Double(1.581));
        timeSeries.add((RegularTimePeriod)new Day(17, 8, 2001), (Number)new Double(1.5761));
        timeSeries.add((RegularTimePeriod)new Day(20, 8, 2001), (Number)new Double(1.5831));
        timeSeries.add((RegularTimePeriod)new Day(21, 8, 2001), (Number)new Double(1.587));
        timeSeries.add((RegularTimePeriod)new Day(22, 8, 2001), (Number)new Double(1.5808));
        timeSeries.add((RegularTimePeriod)new Day(23, 8, 2001), (Number)new Double(1.5845));
        timeSeries.add((RegularTimePeriod)new Day(24, 8, 2001), (Number)new Double(1.5844));
        timeSeries.add((RegularTimePeriod)new Day(28, 8, 2001), (Number)new Double(1.5924));
        timeSeries.add((RegularTimePeriod)new Day(29, 8, 2001), (Number)new Double(1.595));
        timeSeries.add((RegularTimePeriod)new Day(30, 8, 2001), (Number)new Double(1.5941));
        timeSeries.add((RegularTimePeriod)new Day(31, 8, 2001), (Number)new Double(1.5968));
        timeSeries.add((RegularTimePeriod)new Day(3, 9, 2001), (Number)new Double(1.602));
        timeSeries.add((RegularTimePeriod)new Day(4, 9, 2001), (Number)new Double(1.6236));
        timeSeries.add((RegularTimePeriod)new Day(5, 9, 2001), (Number)new Double(1.6352));
        timeSeries.add((RegularTimePeriod)new Day(6, 9, 2001), (Number)new Double(1.6302));
        timeSeries.add((RegularTimePeriod)new Day(7, 9, 2001), (Number)new Double(1.618));
        timeSeries.add((RegularTimePeriod)new Day(10, 9, 2001), (Number)new Double(1.6218));
        timeSeries.add((RegularTimePeriod)new Day(11, 9, 2001), (Number)new Double(1.6182));
        timeSeries.add((RegularTimePeriod)new Day(12, 9, 2001), (Number)new Double(1.6157));
        timeSeries.add((RegularTimePeriod)new Day(13, 9, 2001), (Number)new Double(1.6171));
        timeSeries.add((RegularTimePeriod)new Day(14, 9, 2001), (Number)new Double(1.596));
        timeSeries.add((RegularTimePeriod)new Day(17, 9, 2001), (Number)new Double(1.5952));
        timeSeries.add((RegularTimePeriod)new Day(18, 9, 2001), (Number)new Double(1.5863));
        timeSeries.add((RegularTimePeriod)new Day(19, 9, 2001), (Number)new Double(1.579));
        timeSeries.add((RegularTimePeriod)new Day(20, 9, 2001), (Number)new Double(1.5811));
        timeSeries.add((RegularTimePeriod)new Day(21, 9, 2001), (Number)new Double(1.5917));
        timeSeries.add((RegularTimePeriod)new Day(24, 9, 2001), (Number)new Double(1.6005));
        timeSeries.add((RegularTimePeriod)new Day(25, 9, 2001), (Number)new Double(1.5915));
        timeSeries.add((RegularTimePeriod)new Day(26, 9, 2001), (Number)new Double(1.6012));
        timeSeries.add((RegularTimePeriod)new Day(27, 9, 2001), (Number)new Double(1.6032));
        timeSeries.add((RegularTimePeriod)new Day(28, 9, 2001), (Number)new Double(1.6133));
        timeSeries.add((RegularTimePeriod)new Day(1, 10, 2001), (Number)new Double(1.6147));
        timeSeries.add((RegularTimePeriod)new Day(2, 10, 2001), (Number)new Double(1.6002));
        timeSeries.add((RegularTimePeriod)new Day(3, 10, 2001), (Number)new Double(1.6041));
        timeSeries.add((RegularTimePeriod)new Day(4, 10, 2001), (Number)new Double(1.6172));
        timeSeries.add((RegularTimePeriod)new Day(5, 10, 2001), (Number)new Double(1.6121));
        timeSeries.add((RegularTimePeriod)new Day(8, 10, 2001), (Number)new Double(1.6044));
        timeSeries.add((RegularTimePeriod)new Day(9, 10, 2001), (Number)new Double(1.5974));
        timeSeries.add((RegularTimePeriod)new Day(10, 10, 2001), (Number)new Double(1.5915));
        timeSeries.add((RegularTimePeriod)new Day(11, 10, 2001), (Number)new Double(1.6022));
        timeSeries.add((RegularTimePeriod)new Day(12, 10, 2001), (Number)new Double(1.6014));
        timeSeries.add((RegularTimePeriod)new Day(15, 10, 2001), (Number)new Double(1.5942));
        timeSeries.add((RegularTimePeriod)new Day(16, 10, 2001), (Number)new Double(1.5925));
        timeSeries.add((RegularTimePeriod)new Day(17, 10, 2001), (Number)new Double(1.6007));
        timeSeries.add((RegularTimePeriod)new Day(18, 10, 2001), (Number)new Double(1.6));
        timeSeries.add((RegularTimePeriod)new Day(19, 10, 2001), (Number)new Double(1.603));
        timeSeries.add((RegularTimePeriod)new Day(22, 10, 2001), (Number)new Double(1.6014));
        timeSeries.add((RegularTimePeriod)new Day(23, 10, 2001), (Number)new Double(1.5995));
        timeSeries.add((RegularTimePeriod)new Day(24, 10, 2001), (Number)new Double(1.5951));
        timeSeries.add((RegularTimePeriod)new Day(25, 10, 2001), (Number)new Double(1.5953));
        timeSeries.add((RegularTimePeriod)new Day(26, 10, 2001), (Number)new Double(1.6057));
        timeSeries.add((RegularTimePeriod)new Day(29, 10, 2001), (Number)new Double(1.6051));
        timeSeries.add((RegularTimePeriod)new Day(30, 10, 2001), (Number)new Double(1.6027));
        timeSeries.add((RegularTimePeriod)new Day(31, 10, 2001), (Number)new Double(1.6144));
        timeSeries.add((RegularTimePeriod)new Day(1, 11, 2001), (Number)new Double(1.6139));
        timeSeries.add((RegularTimePeriod)new Day(2, 11, 2001), (Number)new Double(1.6189));
        timeSeries.add((RegularTimePeriod)new Day(5, 11, 2001), (Number)new Double(1.6248));
        timeSeries.add((RegularTimePeriod)new Day(6, 11, 2001), (Number)new Double(1.6267));
        timeSeries.add((RegularTimePeriod)new Day(7, 11, 2001), (Number)new Double(1.6281));
        timeSeries.add((RegularTimePeriod)new Day(8, 11, 2001), (Number)new Double(1.631));
        timeSeries.add((RegularTimePeriod)new Day(9, 11, 2001), (Number)new Double(1.6313));
        timeSeries.add((RegularTimePeriod)new Day(12, 11, 2001), (Number)new Double(1.6272));
        timeSeries.add((RegularTimePeriod)new Day(13, 11, 2001), (Number)new Double(1.6361));
        timeSeries.add((RegularTimePeriod)new Day(14, 11, 2001), (Number)new Double(1.6323));
        timeSeries.add((RegularTimePeriod)new Day(15, 11, 2001), (Number)new Double(1.6252));
        timeSeries.add((RegularTimePeriod)new Day(16, 11, 2001), (Number)new Double(1.6141));
        timeSeries.add((RegularTimePeriod)new Day(19, 11, 2001), (Number)new Double(1.6086));
        timeSeries.add((RegularTimePeriod)new Day(20, 11, 2001), (Number)new Double(1.6055));
        timeSeries.add((RegularTimePeriod)new Day(21, 11, 2001), (Number)new Double(1.6132));
        timeSeries.add((RegularTimePeriod)new Day(22, 11, 2001), (Number)new Double(1.6074));
        timeSeries.add((RegularTimePeriod)new Day(23, 11, 2001), (Number)new Double(1.6065));
        timeSeries.add((RegularTimePeriod)new Day(26, 11, 2001), (Number)new Double(1.6061));
        timeSeries.add((RegularTimePeriod)new Day(27, 11, 2001), (Number)new Double(1.6039));
        timeSeries.add((RegularTimePeriod)new Day(28, 11, 2001), (Number)new Double(1.6069));
        timeSeries.add((RegularTimePeriod)new Day(29, 11, 2001), (Number)new Double(1.6044));
        timeSeries.add((RegularTimePeriod)new Day(30, 11, 2001), (Number)new Double(1.5928));
        return new TimeSeriesCollection(timeSeries);
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = TimeSeriesDemo7.createChart(TimeSeriesDemo7.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        TimeSeriesDemo7 timeSeriesDemo7 = new TimeSeriesDemo7("Time Series Demo 7");
        timeSeriesDemo7.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)timeSeriesDemo7));
        timeSeriesDemo7.setVisible(true);
    }
}

