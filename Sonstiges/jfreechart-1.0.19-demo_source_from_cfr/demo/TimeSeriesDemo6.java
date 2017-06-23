/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.block.BlockBorder
 *  org.jfree.chart.block.BlockFrame
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
 *  org.jfree.chart.title.LegendTitle
 *  org.jfree.chart.title.TextTitle
 *  org.jfree.chart.title.Title
 *  org.jfree.data.time.Month
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.HorizontalAlignment
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.block.BlockFrame;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.time.Month;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesDemo6
extends ApplicationFrame {
    public TimeSeriesDemo6(String string) {
        super(string);
        ChartPanel chartPanel = (ChartPanel)TimeSeriesDemo6.createDemoPanel();
        chartPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)chartPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"International Coffee Organisation : Coffee Prices", (String)null, (String)"US cents/lb", (XYDataset)xYDataset, (boolean)true, (boolean)true, (boolean)false);
        String string = "Palatino";
        jFreeChart.getTitle().setFont(new Font(string, 1, 18));
        jFreeChart.addSubtitle((Title)new TextTitle("Source: http://www.ico.org/historical/2010-19/PDF/HIST-PRICES.pdf", new Font(string, 0, 14)));
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(false);
        xYPlot.setDomainCrosshairVisible(true);
        xYPlot.setRangeCrosshairVisible(true);
        xYPlot.getDomainAxis().setLowerMargin(0.0);
        xYPlot.getDomainAxis().setLabelFont(new Font(string, 1, 14));
        xYPlot.getDomainAxis().setTickLabelFont(new Font(string, 0, 12));
        xYPlot.getRangeAxis().setLabelFont(new Font(string, 1, 14));
        xYPlot.getRangeAxis().setTickLabelFont(new Font(string, 0, 12));
        jFreeChart.getLegend().setItemFont(new Font(string, 0, 14));
        jFreeChart.getLegend().setFrame((BlockFrame)BlockBorder.NONE);
        jFreeChart.getLegend().setHorizontalAlignment(HorizontalAlignment.CENTER);
        XYItemRenderer xYItemRenderer = xYPlot.getRenderer();
        if (xYItemRenderer instanceof XYLineAndShapeRenderer) {
            XYLineAndShapeRenderer xYLineAndShapeRenderer = (XYLineAndShapeRenderer)xYItemRenderer;
            xYLineAndShapeRenderer.setBaseShapesVisible(false);
            xYLineAndShapeRenderer.setDrawSeriesLineAsPath(true);
            xYLineAndShapeRenderer.setAutoPopulateSeriesStroke(false);
            xYLineAndShapeRenderer.setBaseStroke((Stroke)new BasicStroke(3.0f, 1, 2), false);
            xYLineAndShapeRenderer.setSeriesPaint(0, (Paint)Color.RED);
            xYLineAndShapeRenderer.setSeriesPaint(1, (Paint)new Color(24, 123, 58));
            xYLineAndShapeRenderer.setSeriesPaint(2, (Paint)new Color(149, 201, 136));
            xYLineAndShapeRenderer.setSeriesPaint(3, (Paint)new Color(1, 62, 29));
            xYLineAndShapeRenderer.setSeriesPaint(4, (Paint)new Color(81, 176, 86));
            xYLineAndShapeRenderer.setSeriesPaint(5, (Paint)new Color(0, 55, 122));
            xYLineAndShapeRenderer.setSeriesPaint(6, (Paint)new Color(0, 92, 165));
        }
        return jFreeChart;
    }

    private static XYDataset createDataset() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Indicator Price"));
        timeSeries.add((RegularTimePeriod)new Month(1, 2010), 126.8);
        timeSeries.add((RegularTimePeriod)new Month(2, 2010), 123.37);
        timeSeries.add((RegularTimePeriod)new Month(3, 2010), 125.3);
        timeSeries.add((RegularTimePeriod)new Month(4, 2010), 126.89);
        timeSeries.add((RegularTimePeriod)new Month(5, 2010), 128.1);
        timeSeries.add((RegularTimePeriod)new Month(6, 2010), 142.2);
        timeSeries.add((RegularTimePeriod)new Month(7, 2010), 153.41);
        timeSeries.add((RegularTimePeriod)new Month(8, 2010), 157.46);
        timeSeries.add((RegularTimePeriod)new Month(9, 2010), 163.61);
        timeSeries.add((RegularTimePeriod)new Month(10, 2010), 161.56);
        timeSeries.add((RegularTimePeriod)new Month(11, 2010), 173.9);
        timeSeries.add((RegularTimePeriod)new Month(12, 2010), 184.26);
        timeSeries.add((RegularTimePeriod)new Month(1, 2011), 197.35);
        timeSeries.add((RegularTimePeriod)new Month(2, 2011), 216.03);
        timeSeries.add((RegularTimePeriod)new Month(3, 2011), 224.33);
        timeSeries.add((RegularTimePeriod)new Month(4, 2011), 231.24);
        timeSeries.add((RegularTimePeriod)new Month(5, 2011), 227.97);
        timeSeries.add((RegularTimePeriod)new Month(6, 2011), 215.58);
        timeSeries.add((RegularTimePeriod)new Month(7, 2011), 210.36);
        timeSeries.add((RegularTimePeriod)new Month(8, 2011), 212.19);
        timeSeries.add((RegularTimePeriod)new Month(9, 2011), 213.04);
        timeSeries.add((RegularTimePeriod)new Month(10, 2011), 193.9);
        timeSeries.add((RegularTimePeriod)new Month(11, 2011), 193.66);
        timeSeries.add((RegularTimePeriod)new Month(12, 2011), 189.02);
        timeSeries.add((RegularTimePeriod)new Month(1, 2012), 188.9);
        timeSeries.add((RegularTimePeriod)new Month(2, 2012), 182.29);
        timeSeries.add((RegularTimePeriod)new Month(3, 2012), 167.77);
        timeSeries.add((RegularTimePeriod)new Month(4, 2012), 160.46);
        timeSeries.add((RegularTimePeriod)new Month(5, 2012), 157.68);
        timeSeries.add((RegularTimePeriod)new Month(6, 2012), 145.31);
        timeSeries.add((RegularTimePeriod)new Month(7, 2012), 159.07);
        timeSeries.add((RegularTimePeriod)new Month(8, 2012), 148.5);
        timeSeries.add((RegularTimePeriod)new Month(9, 2012), 151.28);
        timeSeries.add((RegularTimePeriod)new Month(10, 2012), 147.12);
        timeSeries.add((RegularTimePeriod)new Month(11, 2012), 136.35);
        timeSeries.add((RegularTimePeriod)new Month(12, 2012), 131.31);
        timeSeries.add((RegularTimePeriod)new Month(1, 2013), 135.38);
        timeSeries.add((RegularTimePeriod)new Month(2, 2013), 131.51);
        timeSeries.add((RegularTimePeriod)new Month(3, 2013), 131.38);
        TimeSeries timeSeries2 = new TimeSeries((Comparable)((Object)"Columbian Milds"));
        timeSeries2.add((RegularTimePeriod)new Month(1, 2010), 207.51);
        timeSeries2.add((RegularTimePeriod)new Month(2, 2010), 204.71);
        timeSeries2.add((RegularTimePeriod)new Month(3, 2010), 205.71);
        timeSeries2.add((RegularTimePeriod)new Month(4, 2010), 200.0);
        timeSeries2.add((RegularTimePeriod)new Month(5, 2010), 200.54);
        timeSeries2.add((RegularTimePeriod)new Month(6, 2010), 224.49);
        timeSeries2.add((RegularTimePeriod)new Month(7, 2010), 235.52);
        timeSeries2.add((RegularTimePeriod)new Month(8, 2010), 243.98);
        timeSeries2.add((RegularTimePeriod)new Month(9, 2010), 247.77);
        timeSeries2.add((RegularTimePeriod)new Month(10, 2010), 230.02);
        timeSeries2.add((RegularTimePeriod)new Month(11, 2010), 244.02);
        timeSeries2.add((RegularTimePeriod)new Month(12, 2010), 261.97);
        timeSeries2.add((RegularTimePeriod)new Month(1, 2011), 279.88);
        timeSeries2.add((RegularTimePeriod)new Month(2, 2011), 296.44);
        timeSeries2.add((RegularTimePeriod)new Month(3, 2011), 300.68);
        timeSeries2.add((RegularTimePeriod)new Month(4, 2011), 312.95);
        timeSeries2.add((RegularTimePeriod)new Month(5, 2011), 302.17);
        timeSeries2.add((RegularTimePeriod)new Month(6, 2011), 287.95);
        timeSeries2.add((RegularTimePeriod)new Month(7, 2011), 285.21);
        timeSeries2.add((RegularTimePeriod)new Month(8, 2011), 286.97);
        timeSeries2.add((RegularTimePeriod)new Month(9, 2011), 287.54);
        timeSeries2.add((RegularTimePeriod)new Month(10, 2011), 257.66);
        timeSeries2.add((RegularTimePeriod)new Month(11, 2011), 256.99);
        timeSeries2.add((RegularTimePeriod)new Month(12, 2011), 251.6);
        timeSeries2.add((RegularTimePeriod)new Month(1, 2012), 255.91);
        timeSeries2.add((RegularTimePeriod)new Month(2, 2012), 244.14);
        timeSeries2.add((RegularTimePeriod)new Month(3, 2012), 222.84);
        timeSeries2.add((RegularTimePeriod)new Month(4, 2012), 214.46);
        timeSeries2.add((RegularTimePeriod)new Month(5, 2012), 207.32);
        timeSeries2.add((RegularTimePeriod)new Month(6, 2012), 184.67);
        timeSeries2.add((RegularTimePeriod)new Month(7, 2012), 202.56);
        timeSeries2.add((RegularTimePeriod)new Month(8, 2012), 187.14);
        timeSeries2.add((RegularTimePeriod)new Month(9, 2012), 190.1);
        timeSeries2.add((RegularTimePeriod)new Month(10, 2012), 181.39);
        timeSeries2.add((RegularTimePeriod)new Month(11, 2012), 170.08);
        timeSeries2.add((RegularTimePeriod)new Month(12, 2012), 164.4);
        timeSeries2.add((RegularTimePeriod)new Month(1, 2013), 169.19);
        timeSeries2.add((RegularTimePeriod)new Month(2, 2013), 161.7);
        timeSeries2.add((RegularTimePeriod)new Month(3, 2013), 161.53);
        TimeSeries timeSeries3 = new TimeSeries((Comparable)((Object)"Other Milds"));
        timeSeries3.add((RegularTimePeriod)new Month(1, 2010), 158.9);
        timeSeries3.add((RegularTimePeriod)new Month(2, 2010), 157.86);
        timeSeries3.add((RegularTimePeriod)new Month(3, 2010), 164.5);
        timeSeries3.add((RegularTimePeriod)new Month(4, 2010), 169.55);
        timeSeries3.add((RegularTimePeriod)new Month(5, 2010), 173.38);
        timeSeries3.add((RegularTimePeriod)new Month(6, 2010), 190.9);
        timeSeries3.add((RegularTimePeriod)new Month(7, 2010), 203.21);
        timeSeries3.add((RegularTimePeriod)new Month(8, 2010), 211.59);
        timeSeries3.add((RegularTimePeriod)new Month(9, 2010), 222.71);
        timeSeries3.add((RegularTimePeriod)new Month(10, 2010), 217.64);
        timeSeries3.add((RegularTimePeriod)new Month(11, 2010), 233.48);
        timeSeries3.add((RegularTimePeriod)new Month(12, 2010), 248.17);
        timeSeries3.add((RegularTimePeriod)new Month(1, 2011), 263.77);
        timeSeries3.add((RegularTimePeriod)new Month(2, 2011), 287.89);
        timeSeries3.add((RegularTimePeriod)new Month(3, 2011), 292.07);
        timeSeries3.add((RegularTimePeriod)new Month(4, 2011), 300.12);
        timeSeries3.add((RegularTimePeriod)new Month(5, 2011), 291.09);
        timeSeries3.add((RegularTimePeriod)new Month(6, 2011), 274.98);
        timeSeries3.add((RegularTimePeriod)new Month(7, 2011), 268.02);
        timeSeries3.add((RegularTimePeriod)new Month(8, 2011), 270.44);
        timeSeries3.add((RegularTimePeriod)new Month(9, 2011), 274.88);
        timeSeries3.add((RegularTimePeriod)new Month(10, 2011), 247.82);
        timeSeries3.add((RegularTimePeriod)new Month(11, 2011), 245.09);
        timeSeries3.add((RegularTimePeriod)new Month(12, 2011), 236.71);
        timeSeries3.add((RegularTimePeriod)new Month(1, 2012), 237.21);
        timeSeries3.add((RegularTimePeriod)new Month(2, 2012), 224.16);
        timeSeries3.add((RegularTimePeriod)new Month(3, 2012), 201.26);
        timeSeries3.add((RegularTimePeriod)new Month(4, 2012), 191.45);
        timeSeries3.add((RegularTimePeriod)new Month(5, 2012), 184.65);
        timeSeries3.add((RegularTimePeriod)new Month(6, 2012), 168.69);
        timeSeries3.add((RegularTimePeriod)new Month(7, 2012), 190.45);
        timeSeries3.add((RegularTimePeriod)new Month(8, 2012), 174.82);
        timeSeries3.add((RegularTimePeriod)new Month(9, 2012), 178.98);
        timeSeries3.add((RegularTimePeriod)new Month(10, 2012), 173.32);
        timeSeries3.add((RegularTimePeriod)new Month(11, 2012), 159.91);
        timeSeries3.add((RegularTimePeriod)new Month(12, 2012), 152.74);
        timeSeries3.add((RegularTimePeriod)new Month(1, 2013), 157.29);
        timeSeries3.add((RegularTimePeriod)new Month(2, 2013), 149.46);
        timeSeries3.add((RegularTimePeriod)new Month(3, 2013), 149.78);
        TimeSeries timeSeries4 = new TimeSeries((Comparable)((Object)"Brazilian Naturals"));
        timeSeries4.add((RegularTimePeriod)new Month(1, 2010), 131.67);
        timeSeries4.add((RegularTimePeriod)new Month(2, 2010), 124.57);
        timeSeries4.add((RegularTimePeriod)new Month(3, 2010), 126.21);
        timeSeries4.add((RegularTimePeriod)new Month(4, 2010), 126.07);
        timeSeries4.add((RegularTimePeriod)new Month(5, 2010), 127.45);
        timeSeries4.add((RegularTimePeriod)new Month(6, 2010), 143.2);
        timeSeries4.add((RegularTimePeriod)new Month(7, 2010), 156.87);
        timeSeries4.add((RegularTimePeriod)new Month(8, 2010), 163.21);
        timeSeries4.add((RegularTimePeriod)new Month(9, 2010), 175.15);
        timeSeries4.add((RegularTimePeriod)new Month(10, 2010), 175.38);
        timeSeries4.add((RegularTimePeriod)new Month(11, 2010), 190.62);
        timeSeries4.add((RegularTimePeriod)new Month(12, 2010), 204.25);
        timeSeries4.add((RegularTimePeriod)new Month(1, 2011), 219.77);
        timeSeries4.add((RegularTimePeriod)new Month(2, 2011), 247.0);
        timeSeries4.add((RegularTimePeriod)new Month(3, 2011), 260.98);
        timeSeries4.add((RegularTimePeriod)new Month(4, 2011), 273.4);
        timeSeries4.add((RegularTimePeriod)new Month(5, 2011), 268.66);
        timeSeries4.add((RegularTimePeriod)new Month(6, 2011), 250.59);
        timeSeries4.add((RegularTimePeriod)new Month(7, 2011), 245.69);
        timeSeries4.add((RegularTimePeriod)new Month(8, 2011), 249.83);
        timeSeries4.add((RegularTimePeriod)new Month(9, 2011), 255.64);
        timeSeries4.add((RegularTimePeriod)new Month(10, 2011), 234.28);
        timeSeries4.add((RegularTimePeriod)new Month(11, 2011), 236.75);
        timeSeries4.add((RegularTimePeriod)new Month(12, 2011), 228.79);
        timeSeries4.add((RegularTimePeriod)new Month(1, 2012), 228.21);
        timeSeries4.add((RegularTimePeriod)new Month(2, 2012), 215.4);
        timeSeries4.add((RegularTimePeriod)new Month(3, 2012), 192.03);
        timeSeries4.add((RegularTimePeriod)new Month(4, 2012), 180.9);
        timeSeries4.add((RegularTimePeriod)new Month(5, 2012), 174.17);
        timeSeries4.add((RegularTimePeriod)new Month(6, 2012), 156.17);
        timeSeries4.add((RegularTimePeriod)new Month(7, 2012), 175.98);
        timeSeries4.add((RegularTimePeriod)new Month(8, 2012), 160.05);
        timeSeries4.add((RegularTimePeriod)new Month(9, 2012), 166.53);
        timeSeries4.add((RegularTimePeriod)new Month(10, 2012), 161.2);
        timeSeries4.add((RegularTimePeriod)new Month(11, 2012), 148.25);
        timeSeries4.add((RegularTimePeriod)new Month(12, 2012), 140.69);
        timeSeries4.add((RegularTimePeriod)new Month(1, 2013), 145.17);
        timeSeries4.add((RegularTimePeriod)new Month(2, 2013), 136.63);
        timeSeries4.add((RegularTimePeriod)new Month(3, 2013), 133.61);
        TimeSeries timeSeries5 = new TimeSeries((Comparable)((Object)"Robustas"));
        timeSeries5.add((RegularTimePeriod)new Month(1, 2010), 69.92);
        timeSeries5.add((RegularTimePeriod)new Month(2, 2010), 67.88);
        timeSeries5.add((RegularTimePeriod)new Month(3, 2010), 67.25);
        timeSeries5.add((RegularTimePeriod)new Month(4, 2010), 71.59);
        timeSeries5.add((RegularTimePeriod)new Month(5, 2010), 70.7);
        timeSeries5.add((RegularTimePeriod)new Month(6, 2010), 76.92);
        timeSeries5.add((RegularTimePeriod)new Month(7, 2010), 85.27);
        timeSeries5.add((RegularTimePeriod)new Month(8, 2010), 82.68);
        timeSeries5.add((RegularTimePeriod)new Month(9, 2010), 81.28);
        timeSeries5.add((RegularTimePeriod)new Month(10, 2010), 85.27);
        timeSeries5.add((RegularTimePeriod)new Month(11, 2010), 92.04);
        timeSeries5.add((RegularTimePeriod)new Month(12, 2010), 94.09);
        timeSeries5.add((RegularTimePeriod)new Month(1, 2011), 101.09);
        timeSeries5.add((RegularTimePeriod)new Month(2, 2011), 109.35);
        timeSeries5.add((RegularTimePeriod)new Month(3, 2011), 118.13);
        timeSeries5.add((RegularTimePeriod)new Month(4, 2011), 117.37);
        timeSeries5.add((RegularTimePeriod)new Month(5, 2011), 121.98);
        timeSeries5.add((RegularTimePeriod)new Month(6, 2011), 117.95);
        timeSeries5.add((RegularTimePeriod)new Month(7, 2011), 112.73);
        timeSeries5.add((RegularTimePeriod)new Month(8, 2011), 112.07);
        timeSeries5.add((RegularTimePeriod)new Month(9, 2011), 106.06);
        timeSeries5.add((RegularTimePeriod)new Month(10, 2011), 98.1);
        timeSeries5.add((RegularTimePeriod)new Month(11, 2011), 97.24);
        timeSeries5.add((RegularTimePeriod)new Month(12, 2011), 98.41);
        timeSeries5.add((RegularTimePeriod)new Month(1, 2012), 96.72);
        timeSeries5.add((RegularTimePeriod)new Month(2, 2012), 101.93);
        timeSeries5.add((RegularTimePeriod)new Month(3, 2012), 103.57);
        timeSeries5.add((RegularTimePeriod)new Month(4, 2012), 101.8);
        timeSeries5.add((RegularTimePeriod)new Month(5, 2012), 106.88);
        timeSeries5.add((RegularTimePeriod)new Month(6, 2012), 105.7);
        timeSeries5.add((RegularTimePeriod)new Month(7, 2012), 107.06);
        timeSeries5.add((RegularTimePeriod)new Month(8, 2012), 106.52);
        timeSeries5.add((RegularTimePeriod)new Month(9, 2012), 104.95);
        timeSeries5.add((RegularTimePeriod)new Month(10, 2012), 104.47);
        timeSeries5.add((RegularTimePeriod)new Month(11, 2012), 97.67);
        timeSeries5.add((RegularTimePeriod)new Month(12, 2012), 96.59);
        timeSeries5.add((RegularTimePeriod)new Month(1, 2013), 99.69);
        timeSeries5.add((RegularTimePeriod)new Month(2, 2013), 104.03);
        timeSeries5.add((RegularTimePeriod)new Month(3, 2013), 106.26);
        TimeSeries timeSeries6 = new TimeSeries((Comparable)((Object)"Futures (London)"));
        timeSeries6.add((RegularTimePeriod)new Month(1, 2010), 62.66);
        timeSeries6.add((RegularTimePeriod)new Month(2, 2010), 60.37);
        timeSeries6.add((RegularTimePeriod)new Month(3, 2010), 58.64);
        timeSeries6.add((RegularTimePeriod)new Month(4, 2010), 62.21);
        timeSeries6.add((RegularTimePeriod)new Month(5, 2010), 62.46);
        timeSeries6.add((RegularTimePeriod)new Month(6, 2010), 69.72);
        timeSeries6.add((RegularTimePeriod)new Month(7, 2010), 78.17);
        timeSeries6.add((RegularTimePeriod)new Month(8, 2010), 78.42);
        timeSeries6.add((RegularTimePeriod)new Month(9, 2010), 75.87);
        timeSeries6.add((RegularTimePeriod)new Month(10, 2010), 80.08);
        timeSeries6.add((RegularTimePeriod)new Month(11, 2010), 86.4);
        timeSeries6.add((RegularTimePeriod)new Month(12, 2010), 88.7);
        timeSeries6.add((RegularTimePeriod)new Month(1, 2011), 96.02);
        timeSeries6.add((RegularTimePeriod)new Month(2, 2011), 104.53);
        timeSeries6.add((RegularTimePeriod)new Month(3, 2011), 111.36);
        timeSeries6.add((RegularTimePeriod)new Month(4, 2011), 111.34);
        timeSeries6.add((RegularTimePeriod)new Month(5, 2011), 116.76);
        timeSeries6.add((RegularTimePeriod)new Month(6, 2011), 110.51);
        timeSeries6.add((RegularTimePeriod)new Month(7, 2011), 103.36);
        timeSeries6.add((RegularTimePeriod)new Month(8, 2011), 102.71);
        timeSeries6.add((RegularTimePeriod)new Month(9, 2011), 96.1);
        timeSeries6.add((RegularTimePeriod)new Month(10, 2011), 88.64);
        timeSeries6.add((RegularTimePeriod)new Month(11, 2011), 85.78);
        timeSeries6.add((RegularTimePeriod)new Month(12, 2011), 87.65);
        timeSeries6.add((RegularTimePeriod)new Month(1, 2012), 84.19);
        timeSeries6.add((RegularTimePeriod)new Month(2, 2012), 88.69);
        timeSeries6.add((RegularTimePeriod)new Month(3, 2012), 91.37);
        timeSeries6.add((RegularTimePeriod)new Month(4, 2012), 91.81);
        timeSeries6.add((RegularTimePeriod)new Month(5, 2012), 96.82);
        timeSeries6.add((RegularTimePeriod)new Month(6, 2012), 94.75);
        timeSeries6.add((RegularTimePeriod)new Month(7, 2012), 96.14);
        timeSeries6.add((RegularTimePeriod)new Month(8, 2012), 96.12);
        timeSeries6.add((RegularTimePeriod)new Month(9, 2012), 94.65);
        timeSeries6.add((RegularTimePeriod)new Month(10, 2012), 94.66);
        timeSeries6.add((RegularTimePeriod)new Month(11, 2012), 87.32);
        timeSeries6.add((RegularTimePeriod)new Month(12, 2012), 85.94);
        timeSeries6.add((RegularTimePeriod)new Month(1, 2013), 88.85);
        timeSeries6.add((RegularTimePeriod)new Month(2, 2013), 94.41);
        timeSeries6.add((RegularTimePeriod)new Month(3, 2013), 97.22);
        TimeSeries timeSeries7 = new TimeSeries((Comparable)((Object)"Futures (New York)"));
        timeSeries7.add((RegularTimePeriod)new Month(1, 2010), 142.76);
        timeSeries7.add((RegularTimePeriod)new Month(2, 2010), 134.35);
        timeSeries7.add((RegularTimePeriod)new Month(3, 2010), 134.97);
        timeSeries7.add((RegularTimePeriod)new Month(4, 2010), 135.12);
        timeSeries7.add((RegularTimePeriod)new Month(5, 2010), 135.81);
        timeSeries7.add((RegularTimePeriod)new Month(6, 2010), 152.36);
        timeSeries7.add((RegularTimePeriod)new Month(7, 2010), 165.23);
        timeSeries7.add((RegularTimePeriod)new Month(8, 2010), 175.1);
        timeSeries7.add((RegularTimePeriod)new Month(9, 2010), 187.8);
        timeSeries7.add((RegularTimePeriod)new Month(10, 2010), 190.43);
        timeSeries7.add((RegularTimePeriod)new Month(11, 2010), 206.92);
        timeSeries7.add((RegularTimePeriod)new Month(12, 2010), 221.51);
        timeSeries7.add((RegularTimePeriod)new Month(1, 2011), 238.05);
        timeSeries7.add((RegularTimePeriod)new Month(2, 2011), 261.41);
        timeSeries7.add((RegularTimePeriod)new Month(3, 2011), 274.1);
        timeSeries7.add((RegularTimePeriod)new Month(4, 2011), 285.58);
        timeSeries7.add((RegularTimePeriod)new Month(5, 2011), 277.72);
        timeSeries7.add((RegularTimePeriod)new Month(6, 2011), 262.52);
        timeSeries7.add((RegularTimePeriod)new Month(7, 2011), 255.9);
        timeSeries7.add((RegularTimePeriod)new Month(8, 2011), 260.39);
        timeSeries7.add((RegularTimePeriod)new Month(9, 2011), 261.39);
        timeSeries7.add((RegularTimePeriod)new Month(10, 2011), 236.74);
        timeSeries7.add((RegularTimePeriod)new Month(11, 2011), 235.25);
        timeSeries7.add((RegularTimePeriod)new Month(12, 2011), 227.23);
        timeSeries7.add((RegularTimePeriod)new Month(1, 2012), 227.5);
        timeSeries7.add((RegularTimePeriod)new Month(2, 2012), 212.09);
        timeSeries7.add((RegularTimePeriod)new Month(3, 2012), 188.78);
        timeSeries7.add((RegularTimePeriod)new Month(4, 2012), 181.75);
        timeSeries7.add((RegularTimePeriod)new Month(5, 2012), 176.5);
        timeSeries7.add((RegularTimePeriod)new Month(6, 2012), 159.93);
        timeSeries7.add((RegularTimePeriod)new Month(7, 2012), 183.2);
        timeSeries7.add((RegularTimePeriod)new Month(8, 2012), 169.77);
        timeSeries7.add((RegularTimePeriod)new Month(9, 2012), 175.36);
        timeSeries7.add((RegularTimePeriod)new Month(10, 2012), 170.43);
        timeSeries7.add((RegularTimePeriod)new Month(11, 2012), 155.72);
        timeSeries7.add((RegularTimePeriod)new Month(12, 2012), 149.58);
        timeSeries7.add((RegularTimePeriod)new Month(1, 2013), 154.28);
        timeSeries7.add((RegularTimePeriod)new Month(2, 2013), 144.89);
        timeSeries7.add((RegularTimePeriod)new Month(3, 2013), 141.43);
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        timeSeriesCollection.addSeries(timeSeries);
        timeSeriesCollection.addSeries(timeSeries2);
        timeSeriesCollection.addSeries(timeSeries3);
        timeSeriesCollection.addSeries(timeSeries4);
        timeSeriesCollection.addSeries(timeSeries5);
        timeSeriesCollection.addSeries(timeSeries6);
        timeSeriesCollection.addSeries(timeSeries7);
        return timeSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = TimeSeriesDemo6.createChart(TimeSeriesDemo6.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        TimeSeriesDemo6 timeSeriesDemo6 = new TimeSeriesDemo6("JFreeChart: TimeSeriesDemo6.java");
        timeSeriesDemo6.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)timeSeriesDemo6));
        timeSeriesDemo6.setVisible(true);
    }
}

