/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.StandardXYToolTipGenerator
 *  org.jfree.chart.labels.XYToolTipGenerator
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.StandardXYBarPainter
 *  org.jfree.chart.renderer.xy.XYBarPainter
 *  org.jfree.chart.renderer.xy.XYBarRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.time.Day
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.time.ohlc.OHLCSeries
 *  org.jfree.data.time.ohlc.OHLCSeriesCollection
 *  org.jfree.data.xy.IntervalXYDataset
 *  org.jfree.data.xy.OHLCDataset
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.ohlc.OHLCSeries;
import org.jfree.data.time.ohlc.OHLCSeriesCollection;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PriceVolumeDemo2
extends ApplicationFrame {
    public PriceVolumeDemo2(String string) {
        super(string);
        JFreeChart jFreeChart = PriceVolumeDemo2.createChart();
        ChartPanel chartPanel = new ChartPanel(jFreeChart, true, true, true, false, true);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)chartPanel);
    }

    private static JFreeChart createChart() {
        OHLCDataset oHLCDataset = PriceVolumeDemo2.createPriceDataset();
        String string = "Sun Microsystems (SUNW)";
        JFreeChart jFreeChart = ChartFactory.createHighLowChart((String)string, (String)"Date", (String)"Price", (OHLCDataset)oHLCDataset, (boolean)true);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        DateAxis dateAxis = (DateAxis)xYPlot.getDomainAxis();
        dateAxis.setLowerMargin(0.01);
        dateAxis.setUpperMargin(0.01);
        NumberAxis numberAxis = (NumberAxis)xYPlot.getRangeAxis();
        numberAxis.setLowerMargin(0.6);
        numberAxis.setAutoRangeIncludesZero(false);
        XYItemRenderer xYItemRenderer = xYPlot.getRenderer();
        xYItemRenderer.setBaseToolTipGenerator((XYToolTipGenerator)new StandardXYToolTipGenerator("{0}: ({1}, {2})", (DateFormat)new SimpleDateFormat("d-MMM-yyyy"), (NumberFormat)new DecimalFormat("0.00")));
        NumberAxis numberAxis2 = new NumberAxis("Volume");
        numberAxis2.setUpperMargin(1.0);
        xYPlot.setRangeAxis(1, (ValueAxis)numberAxis2);
        xYPlot.setDataset(1, (XYDataset)PriceVolumeDemo2.createVolumeDataset());
        xYPlot.setRangeAxis(1, (ValueAxis)numberAxis2);
        xYPlot.mapDatasetToRangeAxis(1, 1);
        XYBarRenderer xYBarRenderer = new XYBarRenderer();
        xYBarRenderer.setDrawBarOutline(false);
        xYBarRenderer.setBaseToolTipGenerator((XYToolTipGenerator)new StandardXYToolTipGenerator("{0}: ({1}, {2})", (DateFormat)new SimpleDateFormat("d-MMM-yyyy"), (NumberFormat)new DecimalFormat("0,000.00")));
        xYPlot.setRenderer(1, (XYItemRenderer)xYBarRenderer);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        xYBarRenderer.setShadowVisible(false);
        xYBarRenderer.setBarPainter((XYBarPainter)new StandardXYBarPainter());
        return jFreeChart;
    }

    private static OHLCDataset createPriceDataset() {
        OHLCSeries oHLCSeries = new OHLCSeries((Comparable)((Object)"SUNW"));
        oHLCSeries.add((RegularTimePeriod)new Day(12, 4, 2007), 5.9, 5.96, 5.87, 5.9);
        oHLCSeries.add((RegularTimePeriod)new Day(13, 4, 2007), 5.89, 5.9, 5.78, 5.8);
        oHLCSeries.add((RegularTimePeriod)new Day(16, 4, 2007), 5.81, 5.87, 5.79, 5.86);
        oHLCSeries.add((RegularTimePeriod)new Day(17, 4, 2007), 5.87, 5.95, 5.82, 5.95);
        oHLCSeries.add((RegularTimePeriod)new Day(18, 4, 2007), 5.89, 5.95, 5.87, 5.94);
        oHLCSeries.add((RegularTimePeriod)new Day(19, 4, 2007), 5.87, 5.96, 5.86, 5.89);
        oHLCSeries.add((RegularTimePeriod)new Day(20, 4, 2007), 5.94, 5.95, 5.87, 5.93);
        oHLCSeries.add((RegularTimePeriod)new Day(23, 4, 2007), 5.93, 5.95, 5.89, 5.92);
        oHLCSeries.add((RegularTimePeriod)new Day(24, 4, 2007), 5.93, 5.97, 5.88, 5.94);
        oHLCSeries.add((RegularTimePeriod)new Day(25, 4, 2007), 5.58, 5.58, 5.17, 5.27);
        oHLCSeries.add((RegularTimePeriod)new Day(26, 4, 2007), 5.25, 5.3, 5.2, 5.25);
        oHLCSeries.add((RegularTimePeriod)new Day(27, 4, 2007), 5.23, 5.28, 5.19, 5.26);
        oHLCSeries.add((RegularTimePeriod)new Day(30, 4, 2007), 5.25, 5.26, 5.2, 5.22);
        oHLCSeries.add((RegularTimePeriod)new Day(1, 5, 2007), 5.23, 5.24, 4.99, 5.09);
        oHLCSeries.add((RegularTimePeriod)new Day(2, 5, 2007), 5.09, 5.17, 5.08, 5.15);
        oHLCSeries.add((RegularTimePeriod)new Day(3, 5, 2007), 5.14, 5.2, 5.11, 5.18);
        oHLCSeries.add((RegularTimePeriod)new Day(4, 5, 2007), 5.21, 5.3, 5.2, 5.24);
        oHLCSeries.add((RegularTimePeriod)new Day(7, 5, 2007), 5.22, 5.28, 5.21, 5.22);
        oHLCSeries.add((RegularTimePeriod)new Day(8, 5, 2007), 5.24, 5.27, 5.21, 5.22);
        oHLCSeries.add((RegularTimePeriod)new Day(9, 5, 2007), 5.21, 5.22, 5.15, 5.2);
        oHLCSeries.add((RegularTimePeriod)new Day(10, 5, 2007), 5.16, 5.19, 5.13, 5.13);
        oHLCSeries.add((RegularTimePeriod)new Day(11, 5, 2007), 5.14, 5.18, 5.12, 5.15);
        oHLCSeries.add((RegularTimePeriod)new Day(14, 5, 2007), 5.16, 5.29, 5.16, 5.22);
        oHLCSeries.add((RegularTimePeriod)new Day(15, 5, 2007), 5.22, 5.23, 5.13, 5.14);
        oHLCSeries.add((RegularTimePeriod)new Day(16, 5, 2007), 5.14, 5.16, 5.07, 5.12);
        oHLCSeries.add((RegularTimePeriod)new Day(17, 5, 2007), 5.35, 5.43, 5.3, 5.3);
        oHLCSeries.add((RegularTimePeriod)new Day(18, 5, 2007), 5.35, 5.35, 5.26, 5.29);
        oHLCSeries.add((RegularTimePeriod)new Day(21, 5, 2007), 5.29, 5.39, 5.24, 5.39);
        oHLCSeries.add((RegularTimePeriod)new Day(22, 5, 2007), 5.39, 5.42, 5.34, 5.38);
        oHLCSeries.add((RegularTimePeriod)new Day(23, 5, 2007), 5.37, 5.43, 5.36, 5.38);
        oHLCSeries.add((RegularTimePeriod)new Day(24, 5, 2007), 5.36, 5.37, 5.15, 5.15);
        oHLCSeries.add((RegularTimePeriod)new Day(25, 5, 2007), 5.18, 5.21, 5.15, 5.16);
        oHLCSeries.add((RegularTimePeriod)new Day(29, 5, 2007), 5.16, 5.17, 5.0, 5.06);
        oHLCSeries.add((RegularTimePeriod)new Day(30, 5, 2007), 5.01, 5.15, 4.96, 5.12);
        oHLCSeries.add((RegularTimePeriod)new Day(31, 5, 2007), 5.16, 5.19, 5.07, 5.1);
        oHLCSeries.add((RegularTimePeriod)new Day(1, 6, 2007), 5.12, 5.2, 5.12, 5.18);
        oHLCSeries.add((RegularTimePeriod)new Day(4, 6, 2007), 5.15, 5.24, 5.07, 5.11);
        oHLCSeries.add((RegularTimePeriod)new Day(5, 6, 2007), 5.08, 5.08, 4.97, 5.07);
        oHLCSeries.add((RegularTimePeriod)new Day(6, 6, 2007), 5.03, 5.05, 4.99, 5.02);
        oHLCSeries.add((RegularTimePeriod)new Day(7, 6, 2007), 5.0, 5.05, 4.97, 4.97);
        oHLCSeries.add((RegularTimePeriod)new Day(8, 6, 2007), 4.98, 5.04, 4.95, 5.04);
        oHLCSeries.add((RegularTimePeriod)new Day(11, 6, 2007), 5.05, 5.06, 4.95, 4.96);
        oHLCSeries.add((RegularTimePeriod)new Day(12, 6, 2007), 4.95, 5.01, 4.92, 4.92);
        oHLCSeries.add((RegularTimePeriod)new Day(13, 6, 2007), 4.95, 4.99, 4.83, 4.99);
        oHLCSeries.add((RegularTimePeriod)new Day(14, 6, 2007), 5.05, 5.1, 5.02, 5.08);
        oHLCSeries.add((RegularTimePeriod)new Day(15, 6, 2007), 5.13, 5.13, 5.03, 5.05);
        oHLCSeries.add((RegularTimePeriod)new Day(18, 6, 2007), 5.06, 5.07, 5.01, 5.05);
        oHLCSeries.add((RegularTimePeriod)new Day(19, 6, 2007), 5.03, 5.16, 5.03, 5.1);
        oHLCSeries.add((RegularTimePeriod)new Day(20, 6, 2007), 5.14, 5.15, 5.05, 5.05);
        oHLCSeries.add((RegularTimePeriod)new Day(21, 6, 2007), 5.07, 5.18, 5.06, 5.13);
        oHLCSeries.add((RegularTimePeriod)new Day(22, 6, 2007), 5.11, 5.14, 5.08, 5.08);
        oHLCSeries.add((RegularTimePeriod)new Day(25, 6, 2007), 5.08, 5.1, 4.99, 5.02);
        oHLCSeries.add((RegularTimePeriod)new Day(26, 6, 2007), 5.04, 5.1, 4.99, 5.01);
        oHLCSeries.add((RegularTimePeriod)new Day(27, 6, 2007), 5.0, 5.09, 4.99, 5.07);
        oHLCSeries.add((RegularTimePeriod)new Day(28, 6, 2007), 5.08, 5.19, 5.07, 5.16);
        oHLCSeries.add((RegularTimePeriod)new Day(29, 6, 2007), 5.19, 5.33, 5.16, 5.26);
        oHLCSeries.add((RegularTimePeriod)new Day(2, 7, 2007), 5.13, 5.33, 5.12, 5.19);
        oHLCSeries.add((RegularTimePeriod)new Day(3, 7, 2007), 5.2, 5.24, 5.17, 5.22);
        oHLCSeries.add((RegularTimePeriod)new Day(5, 7, 2007), 5.28, 5.35, 5.24, 5.33);
        oHLCSeries.add((RegularTimePeriod)new Day(6, 7, 2007), 5.36, 5.49, 5.34, 5.38);
        oHLCSeries.add((RegularTimePeriod)new Day(9, 7, 2007), 5.4, 5.44, 5.31, 5.33);
        oHLCSeries.add((RegularTimePeriod)new Day(10, 7, 2007), 5.29, 5.41, 5.28, 5.32);
        oHLCSeries.add((RegularTimePeriod)new Day(11, 7, 2007), 5.29, 5.38, 5.29, 5.38);
        oHLCSeries.add((RegularTimePeriod)new Day(12, 7, 2007), 5.38, 5.43, 5.33, 5.43);
        oHLCSeries.add((RegularTimePeriod)new Day(13, 7, 2007), 5.42, 5.43, 5.34, 5.37);
        oHLCSeries.add((RegularTimePeriod)new Day(16, 7, 2007), 5.33, 5.38, 5.3, 5.34);
        OHLCSeriesCollection oHLCSeriesCollection = new OHLCSeriesCollection();
        oHLCSeriesCollection.addSeries(oHLCSeries);
        return oHLCSeriesCollection;
    }

    private static IntervalXYDataset createVolumeDataset() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Volume"));
        timeSeries.add((RegularTimePeriod)new Day(12, 4, 2007), 4.96468E7);
        timeSeries.add((RegularTimePeriod)new Day(13, 4, 2007), 6.73193E7);
        timeSeries.add((RegularTimePeriod)new Day(16, 4, 2007), 5.68402E7);
        timeSeries.add((RegularTimePeriod)new Day(17, 4, 2007), 4.07523E7);
        timeSeries.add((RegularTimePeriod)new Day(18, 4, 2007), 4.25338E7);
        timeSeries.add((RegularTimePeriod)new Day(19, 4, 2007), 3.42321E7);
        timeSeries.add((RegularTimePeriod)new Day(20, 4, 2007), 3.24376E7);
        timeSeries.add((RegularTimePeriod)new Day(23, 4, 2007), 2.87559E7);
        timeSeries.add((RegularTimePeriod)new Day(24, 4, 2007), 7.45033E7);
        timeSeries.add((RegularTimePeriod)new Day(25, 4, 2007), 3.22214E8);
        timeSeries.add((RegularTimePeriod)new Day(26, 4, 2007), 9.61417E7);
        timeSeries.add((RegularTimePeriod)new Day(27, 4, 2007), 6.23262E7);
        timeSeries.add((RegularTimePeriod)new Day(30, 4, 2007), 5.23344E7);
        timeSeries.add((RegularTimePeriod)new Day(1, 5, 2007), 1.330961E8);
        timeSeries.add((RegularTimePeriod)new Day(2, 5, 2007), 9.38745E7);
        timeSeries.add((RegularTimePeriod)new Day(3, 5, 2007), 1.010114E8);
        timeSeries.add((RegularTimePeriod)new Day(4, 5, 2007), 5.66297E7);
        timeSeries.add((RegularTimePeriod)new Day(7, 5, 2007), 4.33022E7);
        timeSeries.add((RegularTimePeriod)new Day(8, 5, 2007), 5.14565E7);
        timeSeries.add((RegularTimePeriod)new Day(9, 5, 2007), 4.82309E7);
        timeSeries.add((RegularTimePeriod)new Day(10, 5, 2007), 6.5536E7);
        timeSeries.add((RegularTimePeriod)new Day(11, 5, 2007), 4.64697E7);
        timeSeries.add((RegularTimePeriod)new Day(14, 5, 2007), 1.1858E8);
        timeSeries.add((RegularTimePeriod)new Day(15, 5, 2007), 5.07741E7);
        timeSeries.add((RegularTimePeriod)new Day(16, 5, 2007), 4.45902E7);
        timeSeries.add((RegularTimePeriod)new Day(17, 5, 2007), 1.254825E8);
        timeSeries.add((RegularTimePeriod)new Day(18, 5, 2007), 4.99875E7);
        timeSeries.add((RegularTimePeriod)new Day(21, 5, 2007), 4.83874E7);
        timeSeries.add((RegularTimePeriod)new Day(22, 5, 2007), 6.79926E7);
        timeSeries.add((RegularTimePeriod)new Day(23, 5, 2007), 4.56292E7);
        timeSeries.add((RegularTimePeriod)new Day(24, 5, 2007), 1.232886E8);
        timeSeries.add((RegularTimePeriod)new Day(25, 5, 2007), 4.73453E7);
        timeSeries.add((RegularTimePeriod)new Day(29, 5, 2007), 9.0454E7);
        timeSeries.add((RegularTimePeriod)new Day(30, 5, 2007), 7.30492E7);
        timeSeries.add((RegularTimePeriod)new Day(31, 5, 2007), 6.03954E7);
        timeSeries.add((RegularTimePeriod)new Day(1, 6, 2007), 4.87923E7);
        timeSeries.add((RegularTimePeriod)new Day(4, 6, 2007), 1.099728E8);
        timeSeries.add((RegularTimePeriod)new Day(5, 6, 2007), 1.982012E8);
        timeSeries.add((RegularTimePeriod)new Day(6, 6, 2007), 1.214157E8);
        timeSeries.add((RegularTimePeriod)new Day(7, 6, 2007), 5.66374E7);
        timeSeries.add((RegularTimePeriod)new Day(8, 6, 2007), 6.41166E7);
        timeSeries.add((RegularTimePeriod)new Day(11, 6, 2007), 6.02748E7);
        timeSeries.add((RegularTimePeriod)new Day(12, 6, 2007), 9.34513E7);
        timeSeries.add((RegularTimePeriod)new Day(13, 6, 2007), 1.03309E8);
        timeSeries.add((RegularTimePeriod)new Day(14, 6, 2007), 1.031354E8);
        timeSeries.add((RegularTimePeriod)new Day(15, 6, 2007), 1.044159E8);
        timeSeries.add((RegularTimePeriod)new Day(18, 6, 2007), 5.15069E7);
        timeSeries.add((RegularTimePeriod)new Day(19, 6, 2007), 7.45921E7);
        timeSeries.add((RegularTimePeriod)new Day(20, 6, 2007), 6.90276E7);
        timeSeries.add((RegularTimePeriod)new Day(21, 6, 2007), 9.72125E7);
        timeSeries.add((RegularTimePeriod)new Day(22, 6, 2007), 5.1612E7);
        timeSeries.add((RegularTimePeriod)new Day(25, 6, 2007), 6.38454E7);
        timeSeries.add((RegularTimePeriod)new Day(26, 6, 2007), 8.48184E7);
        timeSeries.add((RegularTimePeriod)new Day(27, 6, 2007), 7.35129E7);
        timeSeries.add((RegularTimePeriod)new Day(28, 6, 2007), 7.52751E7);
        timeSeries.add((RegularTimePeriod)new Day(29, 6, 2007), 1.042039E8);
        timeSeries.add((RegularTimePeriod)new Day(2, 7, 2007), 6.65404E7);
        timeSeries.add((RegularTimePeriod)new Day(3, 7, 2007), 2.85208E7);
        timeSeries.add((RegularTimePeriod)new Day(5, 7, 2007), 4.71763E7);
        timeSeries.add((RegularTimePeriod)new Day(6, 7, 2007), 7.00848E7);
        timeSeries.add((RegularTimePeriod)new Day(9, 7, 2007), 9.16308E7);
        timeSeries.add((RegularTimePeriod)new Day(10, 7, 2007), 1.140717E8);
        timeSeries.add((RegularTimePeriod)new Day(11, 7, 2007), 3.42179E7);
        timeSeries.add((RegularTimePeriod)new Day(12, 7, 2007), 3.0298E7);
        timeSeries.add((RegularTimePeriod)new Day(13, 7, 2007), 4.04235E7);
        timeSeries.add((RegularTimePeriod)new Day(16, 7, 2007), 3.9238E7);
        return new TimeSeriesCollection(timeSeries);
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = PriceVolumeDemo2.createChart();
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        PriceVolumeDemo2 priceVolumeDemo2 = new PriceVolumeDemo2("JFreeChart: PriceVolumeDemo2.java");
        priceVolumeDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)priceVolumeDemo2));
        priceVolumeDemo2.setVisible(true);
    }
}

