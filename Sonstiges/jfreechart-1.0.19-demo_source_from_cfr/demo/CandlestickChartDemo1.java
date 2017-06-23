/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.data.xy.DefaultHighLowDataset
 *  org.jfree.data.xy.OHLCDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultHighLowDataset;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class CandlestickChartDemo1
extends ApplicationFrame {
    private static final Calendar calendar = Calendar.getInstance();

    public CandlestickChartDemo1(String string) {
        super(string);
        JPanel jPanel = CandlestickChartDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(OHLCDataset oHLCDataset) {
        JFreeChart jFreeChart = ChartFactory.createCandlestickChart((String)"Candlestick Demo 1", (String)"Time", (String)"Value", (OHLCDataset)oHLCDataset, (boolean)true);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainPannable(true);
        NumberAxis numberAxis = (NumberAxis)xYPlot.getRangeAxis();
        numberAxis.setAutoRangeIncludesZero(false);
        numberAxis.setUpperMargin(0.0);
        numberAxis.setLowerMargin(0.0);
        return jFreeChart;
    }

    private static Date createDate(int n, int n2, int n3, int n4, int n5) {
        calendar.clear();
        calendar.set(n, n2 - 1, n3, n4, n5);
        return calendar.getTime();
    }

    public static OHLCDataset createDataset() {
        Date[] arrdate = new Date[47];
        double[] arrd = new double[47];
        double[] arrd2 = new double[47];
        double[] arrd3 = new double[47];
        double[] arrd4 = new double[47];
        double[] arrd5 = new double[47];
        int n = 1;
        int n2 = 2;
        arrdate[0] = CandlestickChartDemo1.createDate(2001, n, 4, 12, 0);
        arrd[0] = 47.0;
        arrd2[0] = 33.0;
        arrd3[0] = 35.0;
        arrd4[0] = 33.0;
        arrd5[0] = 100.0;
        arrdate[1] = CandlestickChartDemo1.createDate(2001, n, 5, 12, 0);
        arrd[1] = 47.0;
        arrd2[1] = 32.0;
        arrd3[1] = 41.0;
        arrd4[1] = 37.0;
        arrd5[1] = 150.0;
        arrdate[2] = CandlestickChartDemo1.createDate(2001, n, 6, 12, 0);
        arrd[2] = 49.0;
        arrd2[2] = 43.0;
        arrd3[2] = 46.0;
        arrd4[2] = 48.0;
        arrd5[2] = 70.0;
        arrdate[3] = CandlestickChartDemo1.createDate(2001, n, 7, 12, 0);
        arrd[3] = 51.0;
        arrd2[3] = 39.0;
        arrd3[3] = 40.0;
        arrd4[3] = 47.0;
        arrd5[3] = 200.0;
        arrdate[4] = CandlestickChartDemo1.createDate(2001, n, 8, 12, 0);
        arrd[4] = 60.0;
        arrd2[4] = 40.0;
        arrd3[4] = 46.0;
        arrd4[4] = 53.0;
        arrd5[4] = 120.0;
        arrdate[5] = CandlestickChartDemo1.createDate(2001, n, 9, 12, 0);
        arrd[5] = 62.0;
        arrd2[5] = 55.0;
        arrd3[5] = 57.0;
        arrd4[5] = 61.0;
        arrd5[5] = 110.0;
        arrdate[6] = CandlestickChartDemo1.createDate(2001, n, 10, 12, 0);
        arrd[6] = 65.0;
        arrd2[6] = 56.0;
        arrd3[6] = 62.0;
        arrd4[6] = 59.0;
        arrd5[6] = 70.0;
        arrdate[7] = CandlestickChartDemo1.createDate(2001, n, 11, 12, 0);
        arrd[7] = 55.0;
        arrd2[7] = 43.0;
        arrd3[7] = 45.0;
        arrd4[7] = 47.0;
        arrd5[7] = 20.0;
        arrdate[8] = CandlestickChartDemo1.createDate(2001, n, 12, 12, 0);
        arrd[8] = 54.0;
        arrd2[8] = 33.0;
        arrd3[8] = 40.0;
        arrd4[8] = 51.0;
        arrd5[8] = 30.0;
        arrdate[9] = CandlestickChartDemo1.createDate(2001, n, 13, 12, 0);
        arrd[9] = 47.0;
        arrd2[9] = 33.0;
        arrd3[9] = 35.0;
        arrd4[9] = 33.0;
        arrd5[9] = 100.0;
        arrdate[10] = CandlestickChartDemo1.createDate(2001, n, 14, 12, 0);
        arrd[10] = 54.0;
        arrd2[10] = 38.0;
        arrd3[10] = 43.0;
        arrd4[10] = 52.0;
        arrd5[10] = 50.0;
        arrdate[11] = CandlestickChartDemo1.createDate(2001, n, 15, 12, 0);
        arrd[11] = 48.0;
        arrd2[11] = 41.0;
        arrd3[11] = 44.0;
        arrd4[11] = 41.0;
        arrd5[11] = 80.0;
        arrdate[12] = CandlestickChartDemo1.createDate(2001, n, 17, 12, 0);
        arrd[12] = 60.0;
        arrd2[12] = 30.0;
        arrd3[12] = 34.0;
        arrd4[12] = 44.0;
        arrd5[12] = 90.0;
        arrdate[13] = CandlestickChartDemo1.createDate(2001, n, 18, 12, 0);
        arrd[13] = 58.0;
        arrd2[13] = 44.0;
        arrd3[13] = 54.0;
        arrd4[13] = 56.0;
        arrd5[13] = 20.0;
        arrdate[14] = CandlestickChartDemo1.createDate(2001, n, 19, 12, 0);
        arrd[14] = 54.0;
        arrd2[14] = 32.0;
        arrd3[14] = 42.0;
        arrd4[14] = 53.0;
        arrd5[14] = 70.0;
        arrdate[15] = CandlestickChartDemo1.createDate(2001, n, 20, 12, 0);
        arrd[15] = 53.0;
        arrd2[15] = 39.0;
        arrd3[15] = 50.0;
        arrd4[15] = 49.0;
        arrd5[15] = 60.0;
        arrdate[16] = CandlestickChartDemo1.createDate(2001, n, 21, 12, 0);
        arrd[16] = 47.0;
        arrd2[16] = 33.0;
        arrd3[16] = 41.0;
        arrd4[16] = 40.0;
        arrd5[16] = 30.0;
        arrdate[17] = CandlestickChartDemo1.createDate(2001, n, 22, 12, 0);
        arrd[17] = 55.0;
        arrd2[17] = 37.0;
        arrd3[17] = 43.0;
        arrd4[17] = 45.0;
        arrd5[17] = 90.0;
        arrdate[18] = CandlestickChartDemo1.createDate(2001, n, 23, 12, 0);
        arrd[18] = 54.0;
        arrd2[18] = 42.0;
        arrd3[18] = 50.0;
        arrd4[18] = 42.0;
        arrd5[18] = 150.0;
        arrdate[19] = CandlestickChartDemo1.createDate(2001, n, 24, 12, 0);
        arrd[19] = 48.0;
        arrd2[19] = 37.0;
        arrd3[19] = 37.0;
        arrd4[19] = 47.0;
        arrd5[19] = 120.0;
        arrdate[20] = CandlestickChartDemo1.createDate(2001, n, 25, 12, 0);
        arrd[20] = 58.0;
        arrd2[20] = 33.0;
        arrd3[20] = 39.0;
        arrd4[20] = 41.0;
        arrd5[20] = 80.0;
        arrdate[21] = CandlestickChartDemo1.createDate(2001, n, 26, 12, 0);
        arrd[21] = 47.0;
        arrd2[21] = 31.0;
        arrd3[21] = 36.0;
        arrd4[21] = 41.0;
        arrd5[21] = 40.0;
        arrdate[22] = CandlestickChartDemo1.createDate(2001, n, 27, 12, 0);
        arrd[22] = 58.0;
        arrd2[22] = 44.0;
        arrd3[22] = 49.0;
        arrd4[22] = 44.0;
        arrd5[22] = 20.0;
        arrdate[23] = CandlestickChartDemo1.createDate(2001, n, 28, 12, 0);
        arrd[23] = 46.0;
        arrd2[23] = 41.0;
        arrd3[23] = 43.0;
        arrd4[23] = 44.0;
        arrd5[23] = 60.0;
        arrdate[24] = CandlestickChartDemo1.createDate(2001, n, 29, 12, 0);
        arrd[24] = 56.0;
        arrd2[24] = 39.0;
        arrd3[24] = 39.0;
        arrd4[24] = 51.0;
        arrd5[24] = 40.0;
        arrdate[25] = CandlestickChartDemo1.createDate(2001, n, 30, 12, 0);
        arrd[25] = 56.0;
        arrd2[25] = 39.0;
        arrd3[25] = 47.0;
        arrd4[25] = 49.0;
        arrd5[25] = 70.0;
        arrdate[26] = CandlestickChartDemo1.createDate(2001, n, 31, 12, 0);
        arrd[26] = 53.0;
        arrd2[26] = 39.0;
        arrd3[26] = 52.0;
        arrd4[26] = 47.0;
        arrd5[26] = 60.0;
        arrdate[27] = CandlestickChartDemo1.createDate(2001, n2, 1, 12, 0);
        arrd[27] = 51.0;
        arrd2[27] = 30.0;
        arrd3[27] = 45.0;
        arrd4[27] = 47.0;
        arrd5[27] = 90.0;
        arrdate[28] = CandlestickChartDemo1.createDate(2001, n2, 2, 12, 0);
        arrd[28] = 47.0;
        arrd2[28] = 30.0;
        arrd3[28] = 34.0;
        arrd4[28] = 46.0;
        arrd5[28] = 100.0;
        arrdate[29] = CandlestickChartDemo1.createDate(2001, n2, 3, 12, 0);
        arrd[29] = 57.0;
        arrd2[29] = 37.0;
        arrd3[29] = 44.0;
        arrd4[29] = 56.0;
        arrd5[29] = 20.0;
        arrdate[30] = CandlestickChartDemo1.createDate(2001, n2, 4, 12, 0);
        arrd[30] = 49.0;
        arrd2[30] = 40.0;
        arrd3[30] = 47.0;
        arrd4[30] = 44.0;
        arrd5[30] = 50.0;
        arrdate[31] = CandlestickChartDemo1.createDate(2001, n2, 5, 12, 0);
        arrd[31] = 46.0;
        arrd2[31] = 38.0;
        arrd3[31] = 43.0;
        arrd4[31] = 40.0;
        arrd5[31] = 70.0;
        arrdate[32] = CandlestickChartDemo1.createDate(2001, n2, 6, 12, 0);
        arrd[32] = 55.0;
        arrd2[32] = 38.0;
        arrd3[32] = 39.0;
        arrd4[32] = 53.0;
        arrd5[32] = 120.0;
        arrdate[33] = CandlestickChartDemo1.createDate(2001, n2, 7, 12, 0);
        arrd[33] = 50.0;
        arrd2[33] = 33.0;
        arrd3[33] = 37.0;
        arrd4[33] = 37.0;
        arrd5[33] = 140.0;
        arrdate[34] = CandlestickChartDemo1.createDate(2001, n2, 8, 12, 0);
        arrd[34] = 59.0;
        arrd2[34] = 34.0;
        arrd3[34] = 57.0;
        arrd4[34] = 43.0;
        arrd5[34] = 70.0;
        arrdate[35] = CandlestickChartDemo1.createDate(2001, n2, 9, 12, 0);
        arrd[35] = 48.0;
        arrd2[35] = 39.0;
        arrd3[35] = 46.0;
        arrd4[35] = 47.0;
        arrd5[35] = 70.0;
        arrdate[36] = CandlestickChartDemo1.createDate(2001, n2, 10, 12, 0);
        arrd[36] = 55.0;
        arrd2[36] = 30.0;
        arrd3[36] = 37.0;
        arrd4[36] = 30.0;
        arrd5[36] = 30.0;
        arrdate[37] = CandlestickChartDemo1.createDate(2001, n2, 11, 12, 0);
        arrd[37] = 60.0;
        arrd2[37] = 32.0;
        arrd3[37] = 56.0;
        arrd4[37] = 36.0;
        arrd5[37] = 70.0;
        arrdate[38] = CandlestickChartDemo1.createDate(2001, n2, 12, 12, 0);
        arrd[38] = 56.0;
        arrd2[38] = 42.0;
        arrd3[38] = 53.0;
        arrd4[38] = 54.0;
        arrd5[38] = 40.0;
        arrdate[39] = CandlestickChartDemo1.createDate(2001, n2, 13, 12, 0);
        arrd[39] = 49.0;
        arrd2[39] = 42.0;
        arrd3[39] = 45.0;
        arrd4[39] = 42.0;
        arrd5[39] = 90.0;
        arrdate[40] = CandlestickChartDemo1.createDate(2001, n2, 14, 12, 0);
        arrd[40] = 55.0;
        arrd2[40] = 42.0;
        arrd3[40] = 47.0;
        arrd4[40] = 54.0;
        arrd5[40] = 70.0;
        arrdate[41] = CandlestickChartDemo1.createDate(2001, n2, 15, 12, 0);
        arrd[41] = 49.0;
        arrd2[41] = 35.0;
        arrd3[41] = 38.0;
        arrd4[41] = 35.0;
        arrd5[41] = 20.0;
        arrdate[42] = CandlestickChartDemo1.createDate(2001, n2, 16, 12, 0);
        arrd[42] = 47.0;
        arrd2[42] = 38.0;
        arrd3[42] = 43.0;
        arrd4[42] = 42.0;
        arrd5[42] = 10.0;
        arrdate[43] = CandlestickChartDemo1.createDate(2001, n2, 17, 12, 0);
        arrd[43] = 53.0;
        arrd2[43] = 42.0;
        arrd3[43] = 47.0;
        arrd4[43] = 48.0;
        arrd5[43] = 20.0;
        arrdate[44] = CandlestickChartDemo1.createDate(2001, n2, 18, 12, 0);
        arrd[44] = 47.0;
        arrd2[44] = 44.0;
        arrd3[44] = 46.0;
        arrd4[44] = 44.0;
        arrd5[44] = 30.0;
        arrdate[45] = CandlestickChartDemo1.createDate(2001, n2, 19, 12, 0);
        arrd[45] = 46.0;
        arrd2[45] = 40.0;
        arrd3[45] = 43.0;
        arrd4[45] = 44.0;
        arrd5[45] = 50.0;
        arrdate[46] = CandlestickChartDemo1.createDate(2001, n2, 20, 12, 0);
        arrd[46] = 48.0;
        arrd2[46] = 41.0;
        arrd3[46] = 46.0;
        arrd4[46] = 41.0;
        arrd5[46] = 100.0;
        return new DefaultHighLowDataset((Comparable)((Object)"Series 1"), arrdate, arrd, arrd2, arrd3, arrd4, arrd5);
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = CandlestickChartDemo1.createChart(CandlestickChartDemo1.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        CandlestickChartDemo1 candlestickChartDemo1 = new CandlestickChartDemo1("JFreeChart : CandlestickChartDemo1.java");
        candlestickChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)candlestickChartDemo1));
        candlestickChartDemo1.setVisible(true);
    }
}

