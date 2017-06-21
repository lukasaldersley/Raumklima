/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
 *  org.jfree.chart.title.TextTitle
 *  org.jfree.chart.title.Title
 *  org.jfree.chart.util.DefaultShadowGenerator
 *  org.jfree.chart.util.ShadowGenerator
 *  org.jfree.data.time.Month
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.Window;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.chart.util.DefaultShadowGenerator;
import org.jfree.chart.util.ShadowGenerator;
import org.jfree.data.time.Month;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesDemo14
extends ApplicationFrame {
    public TimeSeriesDemo14(String string) {
        super(string);
        JPanel jPanel = TimeSeriesDemo14.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(720, 340));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Browser Market Share", (String)"Date", (String)"Market Share", (XYDataset)xYDataset, (boolean)true, (boolean)true, (boolean)false);
        jFreeChart.addSubtitle((Title)new TextTitle("Source: http://gs.statcounter.com"));
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setShadowGenerator((ShadowGenerator)new DefaultShadowGenerator());
        DateAxis dateAxis = (DateAxis)xYPlot.getDomainAxis();
        dateAxis.setLowerMargin(0.0);
        NumberAxis numberAxis = (NumberAxis)xYPlot.getRangeAxis();
        numberAxis.setNumberFormatOverride((NumberFormat)new DecimalFormat("0.0%"));
        xYPlot.setDomainCrosshairVisible(true);
        xYPlot.setRangeCrosshairVisible(true);
        XYItemRenderer xYItemRenderer = xYPlot.getRenderer();
        if (xYItemRenderer instanceof XYLineAndShapeRenderer) {
            XYLineAndShapeRenderer xYLineAndShapeRenderer = (XYLineAndShapeRenderer)xYItemRenderer;
            xYLineAndShapeRenderer.setBaseStroke((Stroke)new BasicStroke(3.0f));
            xYLineAndShapeRenderer.setAutoPopulateSeriesStroke(false);
            xYLineAndShapeRenderer.setSeriesPaint(0, (Paint)new Color(1742401));
            xYLineAndShapeRenderer.setSeriesPaint(1, (Paint)new Color(10934634));
            xYLineAndShapeRenderer.setSeriesPaint(2, (Paint)new Color(16625249));
            xYLineAndShapeRenderer.setSeriesPaint(3, (Paint)new Color(16777151));
        }
        return jFreeChart;
    }

    private static XYDataset createDataset() {
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        timeSeriesCollection.addSeries(TimeSeriesDemo14.createChromeData());
        timeSeriesCollection.addSeries(TimeSeriesDemo14.createFirefoxData());
        timeSeriesCollection.addSeries(TimeSeriesDemo14.createInternetExplorerData());
        timeSeriesCollection.addSeries(TimeSeriesDemo14.createSafariData());
        return timeSeriesCollection;
    }

    private static TimeSeries createChromeData() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Chrome"));
        timeSeries.add((RegularTimePeriod)new Month(6, 2013), 0.4268);
        timeSeries.add((RegularTimePeriod)new Month(5, 2013), 0.4138);
        timeSeries.add((RegularTimePeriod)new Month(4, 2013), 0.3915);
        timeSeries.add((RegularTimePeriod)new Month(3, 2013), 0.3807);
        timeSeries.add((RegularTimePeriod)new Month(2, 2013), 0.3709);
        timeSeries.add((RegularTimePeriod)new Month(1, 2013), 0.3652);
        timeSeries.add((RegularTimePeriod)new Month(12, 2012), 0.3642);
        timeSeries.add((RegularTimePeriod)new Month(11, 2012), 0.3572);
        timeSeries.add((RegularTimePeriod)new Month(10, 2012), 0.3477);
        timeSeries.add((RegularTimePeriod)new Month(9, 2012), 0.3421);
        timeSeries.add((RegularTimePeriod)new Month(8, 2012), 0.3359);
        timeSeries.add((RegularTimePeriod)new Month(7, 2012), 0.3381);
        timeSeries.add((RegularTimePeriod)new Month(6, 2012), 0.3276);
        timeSeries.add((RegularTimePeriod)new Month(5, 2012), 0.3243);
        timeSeries.add((RegularTimePeriod)new Month(4, 2012), 0.3123);
        timeSeries.add((RegularTimePeriod)new Month(3, 2012), 0.3087);
        timeSeries.add((RegularTimePeriod)new Month(2, 2012), 0.2984);
        timeSeries.add((RegularTimePeriod)new Month(1, 2012), 0.284);
        timeSeries.add((RegularTimePeriod)new Month(12, 2011), 0.2727);
        timeSeries.add((RegularTimePeriod)new Month(11, 2011), 0.2569);
        timeSeries.add((RegularTimePeriod)new Month(10, 2011), 0.25);
        timeSeries.add((RegularTimePeriod)new Month(9, 2011), 0.2361);
        timeSeries.add((RegularTimePeriod)new Month(8, 2011), 0.2316);
        timeSeries.add((RegularTimePeriod)new Month(7, 2011), 0.2214);
        timeSeries.add((RegularTimePeriod)new Month(6, 2011), 0.2065);
        timeSeries.add((RegularTimePeriod)new Month(5, 2011), 0.1936);
        timeSeries.add((RegularTimePeriod)new Month(4, 2011), 0.1829);
        timeSeries.add((RegularTimePeriod)new Month(3, 2011), 0.1737);
        timeSeries.add((RegularTimePeriod)new Month(2, 2011), 0.1654);
        timeSeries.add((RegularTimePeriod)new Month(1, 2011), 0.1568);
        timeSeries.add((RegularTimePeriod)new Month(12, 2010), 0.1485);
        timeSeries.add((RegularTimePeriod)new Month(11, 2010), 0.1335);
        timeSeries.add((RegularTimePeriod)new Month(10, 2010), 0.1239);
        timeSeries.add((RegularTimePeriod)new Month(9, 2010), 0.1154);
        timeSeries.add((RegularTimePeriod)new Month(8, 2010), 0.1076);
        timeSeries.add((RegularTimePeriod)new Month(7, 2010), 0.0988);
        timeSeries.add((RegularTimePeriod)new Month(6, 2010), 0.0924);
        timeSeries.add((RegularTimePeriod)new Month(5, 2010), 0.0861);
        timeSeries.add((RegularTimePeriod)new Month(4, 2010), 0.0806);
        timeSeries.add((RegularTimePeriod)new Month(3, 2010), 0.0729);
        timeSeries.add((RegularTimePeriod)new Month(2, 2010), 0.0672);
        timeSeries.add((RegularTimePeriod)new Month(1, 2010), 0.0604);
        timeSeries.add((RegularTimePeriod)new Month(12, 2009), 0.0545);
        timeSeries.add((RegularTimePeriod)new Month(11, 2009), 0.0466);
        timeSeries.add((RegularTimePeriod)new Month(10, 2009), 0.0417);
        timeSeries.add((RegularTimePeriod)new Month(9, 2009), 0.0369);
        timeSeries.add((RegularTimePeriod)new Month(8, 2009), 0.0338);
        timeSeries.add((RegularTimePeriod)new Month(7, 2009), 0.0301);
        timeSeries.add((RegularTimePeriod)new Month(6, 2009), 0.0282);
        timeSeries.add((RegularTimePeriod)new Month(5, 2009), 0.0242);
        timeSeries.add((RegularTimePeriod)new Month(4, 2009), 0.0207);
        timeSeries.add((RegularTimePeriod)new Month(3, 2009), 0.0173);
        timeSeries.add((RegularTimePeriod)new Month(2, 2009), 0.0152);
        timeSeries.add((RegularTimePeriod)new Month(1, 2009), 0.0138);
        return timeSeries;
    }

    private static TimeSeries createFirefoxData() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Firefox"));
        timeSeries.add((RegularTimePeriod)new Month(6, 2013), 0.2001);
        timeSeries.add((RegularTimePeriod)new Month(5, 2013), 0.1976);
        timeSeries.add((RegularTimePeriod)new Month(4, 2013), 0.2006);
        timeSeries.add((RegularTimePeriod)new Month(3, 2013), 0.2087);
        timeSeries.add((RegularTimePeriod)new Month(2, 2013), 0.2134);
        timeSeries.add((RegularTimePeriod)new Month(1, 2013), 0.2142);
        timeSeries.add((RegularTimePeriod)new Month(12, 2012), 0.2189);
        timeSeries.add((RegularTimePeriod)new Month(11, 2012), 0.2237);
        timeSeries.add((RegularTimePeriod)new Month(10, 2012), 0.2232);
        timeSeries.add((RegularTimePeriod)new Month(9, 2012), 0.224);
        timeSeries.add((RegularTimePeriod)new Month(8, 2012), 0.2285);
        timeSeries.add((RegularTimePeriod)new Month(7, 2012), 0.2373);
        timeSeries.add((RegularTimePeriod)new Month(6, 2012), 0.2456);
        timeSeries.add((RegularTimePeriod)new Month(5, 2012), 0.2555);
        timeSeries.add((RegularTimePeriod)new Month(4, 2012), 0.2487);
        timeSeries.add((RegularTimePeriod)new Month(3, 2012), 0.2498);
        timeSeries.add((RegularTimePeriod)new Month(2, 2012), 0.2488);
        timeSeries.add((RegularTimePeriod)new Month(1, 2012), 0.2478);
        timeSeries.add((RegularTimePeriod)new Month(12, 2011), 0.2527);
        timeSeries.add((RegularTimePeriod)new Month(11, 2011), 0.2523);
        timeSeries.add((RegularTimePeriod)new Month(10, 2011), 0.2639);
        timeSeries.add((RegularTimePeriod)new Month(9, 2011), 0.2679);
        timeSeries.add((RegularTimePeriod)new Month(8, 2011), 0.2749);
        timeSeries.add((RegularTimePeriod)new Month(7, 2011), 0.2795);
        timeSeries.add((RegularTimePeriod)new Month(6, 2011), 0.2834);
        timeSeries.add((RegularTimePeriod)new Month(5, 2011), 0.2929);
        timeSeries.add((RegularTimePeriod)new Month(4, 2011), 0.2967);
        timeSeries.add((RegularTimePeriod)new Month(3, 2011), 0.2998);
        timeSeries.add((RegularTimePeriod)new Month(2, 2011), 0.3037);
        timeSeries.add((RegularTimePeriod)new Month(1, 2011), 0.3068);
        timeSeries.add((RegularTimePeriod)new Month(12, 2010), 0.3076);
        timeSeries.add((RegularTimePeriod)new Month(11, 2010), 0.3117);
        timeSeries.add((RegularTimePeriod)new Month(10, 2010), 0.3124);
        timeSeries.add((RegularTimePeriod)new Month(9, 2010), 0.315);
        timeSeries.add((RegularTimePeriod)new Month(8, 2010), 0.3109);
        timeSeries.add((RegularTimePeriod)new Month(7, 2010), 0.3069);
        timeSeries.add((RegularTimePeriod)new Month(6, 2010), 0.3115);
        timeSeries.add((RegularTimePeriod)new Month(5, 2010), 0.3164);
        timeSeries.add((RegularTimePeriod)new Month(4, 2010), 0.3174);
        timeSeries.add((RegularTimePeriod)new Month(3, 2010), 0.3127);
        timeSeries.add((RegularTimePeriod)new Month(2, 2010), 0.3182);
        timeSeries.add((RegularTimePeriod)new Month(1, 2010), 0.3164);
        timeSeries.add((RegularTimePeriod)new Month(12, 2009), 0.3197);
        timeSeries.add((RegularTimePeriod)new Month(11, 2009), 0.3221);
        timeSeries.add((RegularTimePeriod)new Month(10, 2009), 0.3182);
        timeSeries.add((RegularTimePeriod)new Month(9, 2009), 0.3134);
        timeSeries.add((RegularTimePeriod)new Month(8, 2009), 0.3128);
        timeSeries.add((RegularTimePeriod)new Month(7, 2009), 0.305);
        timeSeries.add((RegularTimePeriod)new Month(6, 2009), 0.3033);
        timeSeries.add((RegularTimePeriod)new Month(5, 2009), 0.2875);
        timeSeries.add((RegularTimePeriod)new Month(4, 2009), 0.2967);
        timeSeries.add((RegularTimePeriod)new Month(3, 2009), 0.294);
        timeSeries.add((RegularTimePeriod)new Month(2, 2009), 0.2785);
        timeSeries.add((RegularTimePeriod)new Month(1, 2009), 0.2703);
        return timeSeries;
    }

    private static TimeSeries createInternetExplorerData() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Internet Explorer"));
        timeSeries.add((RegularTimePeriod)new Month(6, 2013), 0.2544);
        timeSeries.add((RegularTimePeriod)new Month(5, 2013), 0.2772);
        timeSeries.add((RegularTimePeriod)new Month(4, 2013), 0.2971);
        timeSeries.add((RegularTimePeriod)new Month(3, 2013), 0.293);
        timeSeries.add((RegularTimePeriod)new Month(2, 2013), 0.2982);
        timeSeries.add((RegularTimePeriod)new Month(1, 2013), 0.3069);
        timeSeries.add((RegularTimePeriod)new Month(12, 2012), 0.3078);
        timeSeries.add((RegularTimePeriod)new Month(11, 2012), 0.3123);
        timeSeries.add((RegularTimePeriod)new Month(10, 2012), 0.3208);
        timeSeries.add((RegularTimePeriod)new Month(9, 2012), 0.327);
        timeSeries.add((RegularTimePeriod)new Month(8, 2012), 0.3285);
        timeSeries.add((RegularTimePeriod)new Month(7, 2012), 0.3204);
        timeSeries.add((RegularTimePeriod)new Month(6, 2012), 0.3231);
        timeSeries.add((RegularTimePeriod)new Month(5, 2012), 0.3212);
        timeSeries.add((RegularTimePeriod)new Month(4, 2012), 0.3407);
        timeSeries.add((RegularTimePeriod)new Month(3, 2012), 0.3481);
        timeSeries.add((RegularTimePeriod)new Month(2, 2012), 0.3575);
        timeSeries.add((RegularTimePeriod)new Month(1, 2012), 0.3745);
        timeSeries.add((RegularTimePeriod)new Month(12, 2011), 0.3865);
        timeSeries.add((RegularTimePeriod)new Month(11, 2011), 0.4063);
        timeSeries.add((RegularTimePeriod)new Month(10, 2011), 0.4018);
        timeSeries.add((RegularTimePeriod)new Month(9, 2011), 0.4166);
        timeSeries.add((RegularTimePeriod)new Month(8, 2011), 0.4189);
        timeSeries.add((RegularTimePeriod)new Month(7, 2011), 0.4245);
        timeSeries.add((RegularTimePeriod)new Month(6, 2011), 0.4358);
        timeSeries.add((RegularTimePeriod)new Month(5, 2011), 0.4387);
        timeSeries.add((RegularTimePeriod)new Month(4, 2011), 0.4452);
        timeSeries.add((RegularTimePeriod)new Month(3, 2011), 0.4511);
        timeSeries.add((RegularTimePeriod)new Month(2, 2011), 0.4544);
        timeSeries.add((RegularTimePeriod)new Month(1, 2011), 0.46);
        timeSeries.add((RegularTimePeriod)new Month(12, 2010), 0.4694);
        timeSeries.add((RegularTimePeriod)new Month(11, 2010), 0.4816);
        timeSeries.add((RegularTimePeriod)new Month(10, 2010), 0.4921);
        timeSeries.add((RegularTimePeriod)new Month(9, 2010), 0.4987);
        timeSeries.add((RegularTimePeriod)new Month(8, 2010), 0.5134);
        timeSeries.add((RegularTimePeriod)new Month(7, 2010), 0.5268);
        timeSeries.add((RegularTimePeriod)new Month(6, 2010), 0.5286);
        timeSeries.add((RegularTimePeriod)new Month(5, 2010), 0.5277);
        timeSeries.add((RegularTimePeriod)new Month(4, 2010), 0.5326);
        timeSeries.add((RegularTimePeriod)new Month(3, 2010), 0.5444);
        timeSeries.add((RegularTimePeriod)new Month(2, 2010), 0.545);
        timeSeries.add((RegularTimePeriod)new Month(1, 2010), 0.5525);
        timeSeries.add((RegularTimePeriod)new Month(12, 2009), 0.5572);
        timeSeries.add((RegularTimePeriod)new Month(11, 2009), 0.5657);
        timeSeries.add((RegularTimePeriod)new Month(10, 2009), 0.5796);
        timeSeries.add((RegularTimePeriod)new Month(9, 2009), 0.5837);
        timeSeries.add((RegularTimePeriod)new Month(8, 2009), 0.5869);
        timeSeries.add((RegularTimePeriod)new Month(7, 2009), 0.6011);
        timeSeries.add((RegularTimePeriod)new Month(6, 2009), 0.5949);
        timeSeries.add((RegularTimePeriod)new Month(5, 2009), 0.6209);
        timeSeries.add((RegularTimePeriod)new Month(4, 2009), 0.6188);
        timeSeries.add((RegularTimePeriod)new Month(3, 2009), 0.6252);
        timeSeries.add((RegularTimePeriod)new Month(2, 2009), 0.6443);
        timeSeries.add((RegularTimePeriod)new Month(1, 2009), 0.6541);
        return timeSeries;
    }

    private static TimeSeries createSafariData() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Safari"));
        timeSeries.add((RegularTimePeriod)new Month(6, 2013), 0.0839);
        timeSeries.add((RegularTimePeriod)new Month(5, 2013), 0.0796);
        timeSeries.add((RegularTimePeriod)new Month(4, 2013), 0.08);
        timeSeries.add((RegularTimePeriod)new Month(3, 2013), 0.085);
        timeSeries.add((RegularTimePeriod)new Month(2, 2013), 0.086);
        timeSeries.add((RegularTimePeriod)new Month(1, 2013), 0.083);
        timeSeries.add((RegularTimePeriod)new Month(12, 2012), 0.0792);
        timeSeries.add((RegularTimePeriod)new Month(11, 2012), 0.0783);
        timeSeries.add((RegularTimePeriod)new Month(10, 2012), 0.0781);
        timeSeries.add((RegularTimePeriod)new Month(9, 2012), 0.077);
        timeSeries.add((RegularTimePeriod)new Month(8, 2012), 0.0739);
        timeSeries.add((RegularTimePeriod)new Month(7, 2012), 0.0712);
        timeSeries.add((RegularTimePeriod)new Month(6, 2012), 0.07);
        timeSeries.add((RegularTimePeriod)new Month(5, 2012), 0.0709);
        timeSeries.add((RegularTimePeriod)new Month(4, 2012), 0.0713);
        timeSeries.add((RegularTimePeriod)new Month(3, 2012), 0.0672);
        timeSeries.add((RegularTimePeriod)new Month(2, 2012), 0.0677);
        timeSeries.add((RegularTimePeriod)new Month(1, 2012), 0.0662);
        timeSeries.add((RegularTimePeriod)new Month(12, 2011), 0.0608);
        timeSeries.add((RegularTimePeriod)new Month(11, 2011), 0.0592);
        timeSeries.add((RegularTimePeriod)new Month(10, 2011), 0.0593);
        timeSeries.add((RegularTimePeriod)new Month(9, 2011), 0.056);
        timeSeries.add((RegularTimePeriod)new Month(8, 2011), 0.0519);
        timeSeries.add((RegularTimePeriod)new Month(7, 2011), 0.0517);
        timeSeries.add((RegularTimePeriod)new Month(6, 2011), 0.0507);
        timeSeries.add((RegularTimePeriod)new Month(5, 2011), 0.0501);
        timeSeries.add((RegularTimePeriod)new Month(4, 2011), 0.0504);
        timeSeries.add((RegularTimePeriod)new Month(3, 2011), 0.0502);
        timeSeries.add((RegularTimePeriod)new Month(2, 2011), 0.0508);
        timeSeries.add((RegularTimePeriod)new Month(1, 2011), 0.0509);
        timeSeries.add((RegularTimePeriod)new Month(12, 2010), 0.0479);
        timeSeries.add((RegularTimePeriod)new Month(11, 2010), 0.047);
        timeSeries.add((RegularTimePeriod)new Month(10, 2010), 0.0456);
        timeSeries.add((RegularTimePeriod)new Month(9, 2010), 0.0442);
        timeSeries.add((RegularTimePeriod)new Month(8, 2010), 0.0423);
        timeSeries.add((RegularTimePeriod)new Month(7, 2010), 0.0409);
        timeSeries.add((RegularTimePeriod)new Month(6, 2010), 0.0407);
        timeSeries.add((RegularTimePeriod)new Month(5, 2010), 0.0414);
        timeSeries.add((RegularTimePeriod)new Month(4, 2010), 0.0423);
        timeSeries.add((RegularTimePeriod)new Month(3, 2010), 0.0416);
        timeSeries.add((RegularTimePeriod)new Month(2, 2010), 0.0408);
        timeSeries.add((RegularTimePeriod)new Month(1, 2010), 0.0376);
        timeSeries.add((RegularTimePeriod)new Month(12, 2009), 0.0348);
        timeSeries.add((RegularTimePeriod)new Month(11, 2009), 0.0367);
        timeSeries.add((RegularTimePeriod)new Month(10, 2009), 0.0347);
        timeSeries.add((RegularTimePeriod)new Month(9, 2009), 0.0328);
        timeSeries.add((RegularTimePeriod)new Month(8, 2009), 0.0325);
        timeSeries.add((RegularTimePeriod)new Month(7, 2009), 0.0302);
        timeSeries.add((RegularTimePeriod)new Month(6, 2009), 0.0293);
        timeSeries.add((RegularTimePeriod)new Month(5, 2009), 0.0265);
        timeSeries.add((RegularTimePeriod)new Month(4, 2009), 0.0275);
        timeSeries.add((RegularTimePeriod)new Month(3, 2009), 0.0273);
        timeSeries.add((RegularTimePeriod)new Month(2, 2009), 0.0259);
        timeSeries.add((RegularTimePeriod)new Month(1, 2009), 0.0257);
        return timeSeries;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = TimeSeriesDemo14.createChart(TimeSeriesDemo14.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        TimeSeriesDemo14 timeSeriesDemo14 = new TimeSeriesDemo14("JFreeChart: Time Series Demo 14");
        timeSeriesDemo14.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)timeSeriesDemo14));
        timeSeriesDemo14.setVisible(true);
    }
}

