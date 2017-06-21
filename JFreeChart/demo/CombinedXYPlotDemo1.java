/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.LegendItemSource
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.StandardXYToolTipGenerator
 *  org.jfree.chart.labels.XYToolTipGenerator
 *  org.jfree.chart.plot.CombinedDomainXYPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.StandardXYBarPainter
 *  org.jfree.chart.renderer.xy.XYBarPainter
 *  org.jfree.chart.renderer.xy.XYBarRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
 *  org.jfree.chart.title.LegendTitle
 *  org.jfree.chart.title.TextTitle
 *  org.jfree.chart.title.Title
 *  org.jfree.data.time.Month
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.IntervalXYDataset
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.HorizontalAlignment
 *  org.jfree.ui.RectangleEdge
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
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItemSource;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYBarPainter;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.time.Month;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;

public class CombinedXYPlotDemo1
extends ApplicationFrame {
    public CombinedXYPlotDemo1(String string) {
        super(string);
        JPanel jPanel = CombinedXYPlotDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createCombinedChart() {
        IntervalXYDataset intervalXYDataset = CombinedXYPlotDemo1.createDataset1();
        XYLineAndShapeRenderer xYLineAndShapeRenderer = new XYLineAndShapeRenderer(true, false);
        xYLineAndShapeRenderer.setBaseToolTipGenerator((XYToolTipGenerator)new StandardXYToolTipGenerator("{0}: ({1}, {2})", (DateFormat)new SimpleDateFormat("d-MMM-yyyy"), (NumberFormat)new DecimalFormat("0.00")));
        xYLineAndShapeRenderer.setSeriesStroke(0, (Stroke)new BasicStroke(4.0f, 1, 2));
        xYLineAndShapeRenderer.setSeriesPaint(0, (Paint)Color.blue);
        DateAxis dateAxis = new DateAxis("Year");
        dateAxis.setLowerMargin(0.0);
        dateAxis.setUpperMargin(0.02);
        NumberAxis numberAxis = new NumberAxis("$billion");
        XYPlot xYPlot = new XYPlot((XYDataset)intervalXYDataset, null, (ValueAxis)numberAxis, (XYItemRenderer)xYLineAndShapeRenderer);
        xYPlot.setBackgroundPaint((Paint)Color.lightGray);
        xYPlot.setDomainGridlinePaint((Paint)Color.white);
        xYPlot.setRangeGridlinePaint((Paint)Color.white);
        IntervalXYDataset intervalXYDataset2 = CombinedXYPlotDemo1.createDataset2();
        XYBarRenderer xYBarRenderer = new XYBarRenderer(){

            public Paint getItemPaint(int n, int n2) {
                XYDataset xYDataset = this.getPlot().getDataset();
                if (xYDataset.getYValue(n, n2) >= 0.0) {
                    return Color.red;
                }
                return Color.green;
            }
        };
        xYBarRenderer.setSeriesPaint(0, (Paint)Color.red);
        xYBarRenderer.setDrawBarOutline(false);
        xYBarRenderer.setBaseToolTipGenerator((XYToolTipGenerator)new StandardXYToolTipGenerator("{0}: ({1}, {2})", (DateFormat)new SimpleDateFormat("d-MMM-yyyy"), (NumberFormat)new DecimalFormat("0.00")));
        XYPlot xYPlot2 = new XYPlot((XYDataset)intervalXYDataset2, null, (ValueAxis)new NumberAxis("$billion"), (XYItemRenderer)xYBarRenderer);
        xYPlot2.setBackgroundPaint((Paint)Color.lightGray);
        xYPlot2.setDomainGridlinePaint((Paint)Color.white);
        xYPlot2.setRangeGridlinePaint((Paint)Color.white);
        CombinedDomainXYPlot combinedDomainXYPlot = new CombinedDomainXYPlot((ValueAxis)dateAxis);
        combinedDomainXYPlot.add(xYPlot, 3);
        combinedDomainXYPlot.add(xYPlot2, 2);
        combinedDomainXYPlot.setGap(8.0);
        combinedDomainXYPlot.setDomainGridlinePaint((Paint)Color.white);
        combinedDomainXYPlot.setDomainGridlinesVisible(true);
        combinedDomainXYPlot.setDomainPannable(true);
        JFreeChart jFreeChart = new JFreeChart("United States Public Debt", JFreeChart.DEFAULT_TITLE_FONT, (Plot)combinedDomainXYPlot, false);
        TextTitle textTitle = new TextTitle("Source: http://www.publicdebt.treas.gov/opd/opdhisms.htm", new Font("Dialog", 0, 10));
        textTitle.setPosition(RectangleEdge.BOTTOM);
        textTitle.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        jFreeChart.addSubtitle((Title)textTitle);
        LegendTitle legendTitle = new LegendTitle((LegendItemSource)combinedDomainXYPlot);
        jFreeChart.addSubtitle((Title)legendTitle);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        xYBarRenderer.setBarPainter((XYBarPainter)new StandardXYBarPainter());
        xYBarRenderer.setShadowVisible(false);
        return jFreeChart;
    }

    private static IntervalXYDataset createDataset1() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Public Debt Outstanding"));
        timeSeries.add((RegularTimePeriod)new Month(1, 1990), 2974.584);
        timeSeries.add((RegularTimePeriod)new Month(2, 1990), 2994.354);
        timeSeries.add((RegularTimePeriod)new Month(3, 1990), 3051.956);
        timeSeries.add((RegularTimePeriod)new Month(4, 1990), 3061.013);
        timeSeries.add((RegularTimePeriod)new Month(5, 1990), 3095.172);
        timeSeries.add((RegularTimePeriod)new Month(6, 1990), 3143.754);
        timeSeries.add((RegularTimePeriod)new Month(7, 1990), 3168.772);
        timeSeries.add((RegularTimePeriod)new Month(8, 1990), 3211.691);
        timeSeries.add((RegularTimePeriod)new Month(9, 1990), 3233.313);
        timeSeries.add((RegularTimePeriod)new Month(10, 1990), 3274.95);
        timeSeries.add((RegularTimePeriod)new Month(11, 1990), 3330.685);
        timeSeries.add((RegularTimePeriod)new Month(12, 1990), 3364.82);
        timeSeries.add((RegularTimePeriod)new Month(1, 1991), 3411.409);
        timeSeries.add((RegularTimePeriod)new Month(2, 1991), 3458.637);
        timeSeries.add((RegularTimePeriod)new Month(3, 1991), 3441.367);
        timeSeries.add((RegularTimePeriod)new Month(4, 1991), 3445.059);
        timeSeries.add((RegularTimePeriod)new Month(5, 1991), 3497.232);
        timeSeries.add((RegularTimePeriod)new Month(6, 1991), 3537.988);
        timeSeries.add((RegularTimePeriod)new Month(7, 1991), 3576.827);
        timeSeries.add((RegularTimePeriod)new Month(8, 1991), 3614.399);
        timeSeries.add((RegularTimePeriod)new Month(9, 1991), 3665.303);
        timeSeries.add((RegularTimePeriod)new Month(10, 1991), 3717.106);
        timeSeries.add((RegularTimePeriod)new Month(11, 1991), 3747.363);
        timeSeries.add((RegularTimePeriod)new Month(12, 1991), 3801.698);
        timeSeries.add((RegularTimePeriod)new Month(1, 1992), 3809.334);
        timeSeries.add((RegularTimePeriod)new Month(2, 1992), 3829.059);
        timeSeries.add((RegularTimePeriod)new Month(3, 1992), 3881.288);
        timeSeries.add((RegularTimePeriod)new Month(4, 1992), 3891.974);
        timeSeries.add((RegularTimePeriod)new Month(5, 1992), 3934.435);
        timeSeries.add((RegularTimePeriod)new Month(6, 1992), 3984.656);
        timeSeries.add((RegularTimePeriod)new Month(7, 1992), 4010.612);
        timeSeries.add((RegularTimePeriod)new Month(8, 1992), 4048.938);
        timeSeries.add((RegularTimePeriod)new Month(9, 1992), 4064.621);
        timeSeries.add((RegularTimePeriod)new Month(10, 1992), 4067.329);
        timeSeries.add((RegularTimePeriod)new Month(11, 1992), 4132.525);
        timeSeries.add((RegularTimePeriod)new Month(12, 1992), 4177.009);
        timeSeries.add((RegularTimePeriod)new Month(1, 1993), 4167.2);
        timeSeries.add((RegularTimePeriod)new Month(2, 1993), 4197.004);
        timeSeries.add((RegularTimePeriod)new Month(3, 1993), 4230.58);
        timeSeries.add((RegularTimePeriod)new Month(4, 1993), 4254.084);
        timeSeries.add((RegularTimePeriod)new Month(5, 1993), 4296.278);
        timeSeries.add((RegularTimePeriod)new Month(6, 1993), 4351.95);
        timeSeries.add((RegularTimePeriod)new Month(7, 1993), 4350.261);
        timeSeries.add((RegularTimePeriod)new Month(8, 1993), 4403.313);
        timeSeries.add((RegularTimePeriod)new Month(9, 1993), 4411.489);
        timeSeries.add((RegularTimePeriod)new Month(10, 1993), 4422.511);
        timeSeries.add((RegularTimePeriod)new Month(11, 1993), 4493.535);
        timeSeries.add((RegularTimePeriod)new Month(12, 1993), 4535.687);
        timeSeries.add((RegularTimePeriod)new Month(1, 1994), 4526.308);
        timeSeries.add((RegularTimePeriod)new Month(2, 1994), 4559.541);
        timeSeries.add((RegularTimePeriod)new Month(3, 1994), 4575.869);
        timeSeries.add((RegularTimePeriod)new Month(4, 1994), 4568.704);
        timeSeries.add((RegularTimePeriod)new Month(5, 1994), 4609.296);
        timeSeries.add((RegularTimePeriod)new Month(6, 1994), 4645.802);
        timeSeries.add((RegularTimePeriod)new Month(7, 1994), 4636.362);
        timeSeries.add((RegularTimePeriod)new Month(8, 1994), 4691.991);
        timeSeries.add((RegularTimePeriod)new Month(9, 1994), 4692.75);
        timeSeries.add((RegularTimePeriod)new Month(10, 1994), 4734.167);
        timeSeries.add((RegularTimePeriod)new Month(11, 1994), 4778.52);
        timeSeries.add((RegularTimePeriod)new Month(12, 1994), 4800.15);
        timeSeries.add((RegularTimePeriod)new Month(1, 1995), 4815.827);
        timeSeries.add((RegularTimePeriod)new Month(2, 1995), 4854.298);
        timeSeries.add((RegularTimePeriod)new Month(3, 1995), 4864.116);
        timeSeries.add((RegularTimePeriod)new Month(4, 1995), 4852.327);
        timeSeries.add((RegularTimePeriod)new Month(5, 1995), 4903.926);
        timeSeries.add((RegularTimePeriod)new Month(6, 1995), 4951.372);
        timeSeries.add((RegularTimePeriod)new Month(7, 1995), 4960.152);
        timeSeries.add((RegularTimePeriod)new Month(8, 1995), 4970.756);
        timeSeries.add((RegularTimePeriod)new Month(9, 1995), 4973.983);
        timeSeries.add((RegularTimePeriod)new Month(10, 1995), 4985.262);
        timeSeries.add((RegularTimePeriod)new Month(11, 1995), 4989.33);
        timeSeries.add((RegularTimePeriod)new Month(12, 1995), 4988.665);
        timeSeries.add((RegularTimePeriod)new Month(1, 1996), 4987.436);
        timeSeries.add((RegularTimePeriod)new Month(2, 1996), 5017.041);
        timeSeries.add((RegularTimePeriod)new Month(3, 1996), 5117.786);
        timeSeries.add((RegularTimePeriod)new Month(4, 1996), 5102.049);
        timeSeries.add((RegularTimePeriod)new Month(5, 1996), 5128.509);
        timeSeries.add((RegularTimePeriod)new Month(6, 1996), 5161.076);
        timeSeries.add((RegularTimePeriod)new Month(7, 1996), 5188.889);
        timeSeries.add((RegularTimePeriod)new Month(8, 1996), 5208.303);
        timeSeries.add((RegularTimePeriod)new Month(9, 1996), 5224.811);
        timeSeries.add((RegularTimePeriod)new Month(10, 1996), 5247.32);
        timeSeries.add((RegularTimePeriod)new Month(11, 1996), 5296.549);
        timeSeries.add((RegularTimePeriod)new Month(12, 1996), 5323.172);
        timeSeries.add((RegularTimePeriod)new Month(1, 1997), 5313.997);
        timeSeries.add((RegularTimePeriod)new Month(2, 1997), 5349.937);
        timeSeries.add((RegularTimePeriod)new Month(3, 1997), 5380.89);
        timeSeries.add((RegularTimePeriod)new Month(4, 1997), 5353.971);
        timeSeries.add((RegularTimePeriod)new Month(5, 1997), 5344.961);
        timeSeries.add((RegularTimePeriod)new Month(6, 1997), 5376.151);
        timeSeries.add((RegularTimePeriod)new Month(7, 1997), 5373.231);
        timeSeries.add((RegularTimePeriod)new Month(8, 1997), 5404.42);
        timeSeries.add((RegularTimePeriod)new Month(9, 1997), 5413.146);
        timeSeries.add((RegularTimePeriod)new Month(10, 1997), 5427.225);
        timeSeries.add((RegularTimePeriod)new Month(11, 1997), 5462.622);
        timeSeries.add((RegularTimePeriod)new Month(12, 1997), 5502.388);
        timeSeries.add((RegularTimePeriod)new Month(1, 1998), 5490.064);
        timeSeries.add((RegularTimePeriod)new Month(2, 1998), 5520.668);
        timeSeries.add((RegularTimePeriod)new Month(3, 1998), 5542.426);
        timeSeries.add((RegularTimePeriod)new Month(4, 1998), 5499.895);
        timeSeries.add((RegularTimePeriod)new Month(5, 1998), 5506.356);
        timeSeries.add((RegularTimePeriod)new Month(6, 1998), 5547.935);
        timeSeries.add((RegularTimePeriod)new Month(7, 1998), 5527.738);
        timeSeries.add((RegularTimePeriod)new Month(8, 1998), 5564.553);
        timeSeries.add((RegularTimePeriod)new Month(9, 1998), 5526.193);
        timeSeries.add((RegularTimePeriod)new Month(10, 1998), 5559.255);
        timeSeries.add((RegularTimePeriod)new Month(11, 1998), 5591.979);
        timeSeries.add((RegularTimePeriod)new Month(12, 1998), 5614.217);
        timeSeries.add((RegularTimePeriod)new Month(1, 1999), 5610.117);
        timeSeries.add((RegularTimePeriod)new Month(2, 1999), 5621.946);
        timeSeries.add((RegularTimePeriod)new Month(3, 1999), 5651.615);
        timeSeries.add((RegularTimePeriod)new Month(4, 1999), 5585.84);
        timeSeries.add((RegularTimePeriod)new Month(5, 1999), 5604.198);
        timeSeries.add((RegularTimePeriod)new Month(6, 1999), 5638.78);
        timeSeries.add((RegularTimePeriod)new Month(7, 1999), 5638.656);
        timeSeries.add((RegularTimePeriod)new Month(8, 1999), 5672.386);
        timeSeries.add((RegularTimePeriod)new Month(9, 1999), 5656.271);
        timeSeries.add((RegularTimePeriod)new Month(10, 1999), 5679.727);
        timeSeries.add((RegularTimePeriod)new Month(11, 1999), 5693.6);
        timeSeries.add((RegularTimePeriod)new Month(12, 1999), 5776.091);
        timeSeries.add((RegularTimePeriod)new Month(1, 2000), 5711.285);
        timeSeries.add((RegularTimePeriod)new Month(2, 2000), 5735.333);
        timeSeries.add((RegularTimePeriod)new Month(3, 2000), 5773.392);
        timeSeries.add((RegularTimePeriod)new Month(4, 2000), 5685.108);
        timeSeries.add((RegularTimePeriod)new Month(5, 2000), 5647.17);
        timeSeries.add((RegularTimePeriod)new Month(6, 2000), 5685.938);
        timeSeries.add((RegularTimePeriod)new Month(7, 2000), 5658.807);
        timeSeries.add((RegularTimePeriod)new Month(8, 2000), 5677.822);
        timeSeries.add((RegularTimePeriod)new Month(9, 2000), 5674.178);
        timeSeries.add((RegularTimePeriod)new Month(10, 2000), 5657.328);
        timeSeries.add((RegularTimePeriod)new Month(11, 2000), 5709.699);
        timeSeries.add((RegularTimePeriod)new Month(12, 2000), 5662.216);
        timeSeries.add((RegularTimePeriod)new Month(1, 2001), 5716.071);
        timeSeries.add((RegularTimePeriod)new Month(2, 2001), 5735.859);
        timeSeries.add((RegularTimePeriod)new Month(3, 2001), 5773.74);
        timeSeries.add((RegularTimePeriod)new Month(4, 2001), 5661.348);
        timeSeries.add((RegularTimePeriod)new Month(5, 2001), 5656.182);
        timeSeries.add((RegularTimePeriod)new Month(6, 2001), 5726.815);
        timeSeries.add((RegularTimePeriod)new Month(7, 2001), 5718.303);
        timeSeries.add((RegularTimePeriod)new Month(8, 2001), 5769.876);
        timeSeries.add((RegularTimePeriod)new Month(9, 2001), 5807.463);
        timeSeries.add((RegularTimePeriod)new Month(10, 2001), 5815.983);
        timeSeries.add((RegularTimePeriod)new Month(11, 2001), 5888.897);
        timeSeries.add((RegularTimePeriod)new Month(12, 2001), 5943.439);
        timeSeries.add((RegularTimePeriod)new Month(1, 2002), 5937.229);
        timeSeries.add((RegularTimePeriod)new Month(2, 2002), 6003.453);
        timeSeries.add((RegularTimePeriod)new Month(3, 2002), 6006.032);
        timeSeries.add((RegularTimePeriod)new Month(4, 2002), 5984.677);
        timeSeries.add((RegularTimePeriod)new Month(5, 2002), 6019.332);
        timeSeries.add((RegularTimePeriod)new Month(6, 2002), 6126.469);
        timeSeries.add((RegularTimePeriod)new Month(7, 2002), 6159.741);
        timeSeries.add((RegularTimePeriod)new Month(8, 2002), 6210.482);
        timeSeries.add((RegularTimePeriod)new Month(9, 2002), 6228.236);
        timeSeries.add((RegularTimePeriod)new Month(10, 2002), 6282.528);
        timeSeries.add((RegularTimePeriod)new Month(11, 2002), 6343.46);
        timeSeries.add((RegularTimePeriod)new Month(12, 2002), 6405.707);
        timeSeries.add((RegularTimePeriod)new Month(1, 2003), 6401.377);
        timeSeries.add((RegularTimePeriod)new Month(2, 2003), 6445.79);
        timeSeries.add((RegularTimePeriod)new Month(3, 2003), 6460.776);
        timeSeries.add((RegularTimePeriod)new Month(4, 2003), 6460.381);
        timeSeries.add((RegularTimePeriod)new Month(5, 2003), 6558.147);
        timeSeries.add((RegularTimePeriod)new Month(6, 2003), 6670.121);
        timeSeries.add((RegularTimePeriod)new Month(7, 2003), 6751.195);
        timeSeries.add((RegularTimePeriod)new Month(8, 2003), 6790.041);
        timeSeries.add((RegularTimePeriod)new Month(9, 2003), 6783.231);
        timeSeries.add((RegularTimePeriod)new Month(10, 2003), 6872.676);
        timeSeries.add((RegularTimePeriod)new Month(11, 2003), 6925.065);
        timeSeries.add((RegularTimePeriod)new Month(12, 2003), 6997.964);
        timeSeries.add((RegularTimePeriod)new Month(1, 2004), 7009.235);
        timeSeries.add((RegularTimePeriod)new Month(2, 2004), 7091.943);
        timeSeries.add((RegularTimePeriod)new Month(3, 2004), 7131.068);
        timeSeries.add((RegularTimePeriod)new Month(4, 2004), 7133.789);
        timeSeries.add((RegularTimePeriod)new Month(5, 2004), 7196.383);
        timeSeries.add((RegularTimePeriod)new Month(6, 2004), 7274.335);
        timeSeries.add((RegularTimePeriod)new Month(7, 2004), 7316.568);
        timeSeries.add((RegularTimePeriod)new Month(8, 2004), 7350.95);
        timeSeries.add((RegularTimePeriod)new Month(9, 2004), 7379.053);
        timeSeries.add((RegularTimePeriod)new Month(10, 2004), 7429.677);
        timeSeries.add((RegularTimePeriod)new Month(11, 2004), 7525.21);
        timeSeries.add((RegularTimePeriod)new Month(12, 2004), 7596.144);
        timeSeries.add((RegularTimePeriod)new Month(1, 2005), 7627.743);
        timeSeries.add((RegularTimePeriod)new Month(2, 2005), 7713.138);
        timeSeries.add((RegularTimePeriod)new Month(3, 2005), 7776.939);
        timeSeries.add((RegularTimePeriod)new Month(4, 2005), 7764.537);
        timeSeries.add((RegularTimePeriod)new Month(5, 2005), 7777.88);
        timeSeries.add((RegularTimePeriod)new Month(6, 2005), 7836.496);
        timeSeries.add((RegularTimePeriod)new Month(7, 2005), 7887.618);
        timeSeries.add((RegularTimePeriod)new Month(8, 2005), 7926.933);
        timeSeries.add((RegularTimePeriod)new Month(9, 2005), 7932.71);
        timeSeries.add((RegularTimePeriod)new Month(10, 2005), 8027.123);
        timeSeries.add((RegularTimePeriod)new Month(11, 2005), 8092.322);
        timeSeries.add((RegularTimePeriod)new Month(12, 2005), 8170.414);
        timeSeries.add((RegularTimePeriod)new Month(1, 2006), 8196.07);
        timeSeries.add((RegularTimePeriod)new Month(2, 2006), 8269.886);
        timeSeries.add((RegularTimePeriod)new Month(3, 2006), 8371.156);
        timeSeries.add((RegularTimePeriod)new Month(4, 2006), 8355.718);
        timeSeries.add((RegularTimePeriod)new Month(5, 2006), 8356.777);
        timeSeries.add((RegularTimePeriod)new Month(6, 2006), 8420.042);
        timeSeries.add((RegularTimePeriod)new Month(7, 2006), 8444.347);
        timeSeries.add((RegularTimePeriod)new Month(8, 2006), 8515.034);
        timeSeries.add((RegularTimePeriod)new Month(9, 2006), 8506.974);
        timeSeries.add((RegularTimePeriod)new Month(10, 2006), 8584.329);
        timeSeries.add((RegularTimePeriod)new Month(11, 2006), 8633.246);
        timeSeries.add((RegularTimePeriod)new Month(12, 2006), 8680.224);
        timeSeries.add((RegularTimePeriod)new Month(1, 2007), 8707.561);
        return new TimeSeriesCollection(timeSeries);
    }

    private static IntervalXYDataset createDataset2() {
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Change from previous year"));
        timeSeries.add((RegularTimePeriod)new Month(1, 1990), 276.627);
        timeSeries.add((RegularTimePeriod)new Month(2, 1990), 271.509);
        timeSeries.add((RegularTimePeriod)new Month(3, 1990), 311.058);
        timeSeries.add((RegularTimePeriod)new Month(4, 1990), 304.345);
        timeSeries.add((RegularTimePeriod)new Month(5, 1990), 317.632);
        timeSeries.add((RegularTimePeriod)new Month(6, 1990), 343.831);
        timeSeries.add((RegularTimePeriod)new Month(7, 1990), 368.317);
        timeSeries.add((RegularTimePeriod)new Month(8, 1990), 375.266);
        timeSeries.add((RegularTimePeriod)new Month(9, 1990), 375.882);
        timeSeries.add((RegularTimePeriod)new Month(10, 1990), 373.731);
        timeSeries.add((RegularTimePeriod)new Month(11, 1990), 407.096);
        timeSeries.add((RegularTimePeriod)new Month(12, 1990), 411.826);
        timeSeries.add((RegularTimePeriod)new Month(1, 1991), 436.825);
        timeSeries.add((RegularTimePeriod)new Month(2, 1991), 464.283);
        timeSeries.add((RegularTimePeriod)new Month(3, 1991), 389.411);
        timeSeries.add((RegularTimePeriod)new Month(4, 1991), 384.046);
        timeSeries.add((RegularTimePeriod)new Month(5, 1991), 402.06);
        timeSeries.add((RegularTimePeriod)new Month(6, 1991), 394.234);
        timeSeries.add((RegularTimePeriod)new Month(7, 1991), 408.055);
        timeSeries.add((RegularTimePeriod)new Month(8, 1991), 402.708);
        timeSeries.add((RegularTimePeriod)new Month(9, 1991), 431.99);
        timeSeries.add((RegularTimePeriod)new Month(10, 1991), 442.156);
        timeSeries.add((RegularTimePeriod)new Month(11, 1991), 416.678);
        timeSeries.add((RegularTimePeriod)new Month(12, 1991), 436.878);
        timeSeries.add((RegularTimePeriod)new Month(1, 1992), 397.925);
        timeSeries.add((RegularTimePeriod)new Month(2, 1992), 370.422);
        timeSeries.add((RegularTimePeriod)new Month(3, 1992), 439.921);
        timeSeries.add((RegularTimePeriod)new Month(4, 1992), 446.915);
        timeSeries.add((RegularTimePeriod)new Month(5, 1992), 437.203);
        timeSeries.add((RegularTimePeriod)new Month(6, 1992), 446.668);
        timeSeries.add((RegularTimePeriod)new Month(7, 1992), 433.785);
        timeSeries.add((RegularTimePeriod)new Month(8, 1992), 434.539);
        timeSeries.add((RegularTimePeriod)new Month(9, 1992), 399.318);
        timeSeries.add((RegularTimePeriod)new Month(10, 1992), 350.223);
        timeSeries.add((RegularTimePeriod)new Month(11, 1992), 385.162);
        timeSeries.add((RegularTimePeriod)new Month(12, 1992), 375.311);
        timeSeries.add((RegularTimePeriod)new Month(1, 1993), 357.866);
        timeSeries.add((RegularTimePeriod)new Month(2, 1993), 367.945);
        timeSeries.add((RegularTimePeriod)new Month(3, 1993), 349.292);
        timeSeries.add((RegularTimePeriod)new Month(4, 1993), 362.11);
        timeSeries.add((RegularTimePeriod)new Month(5, 1993), 361.843);
        timeSeries.add((RegularTimePeriod)new Month(6, 1993), 367.294);
        timeSeries.add((RegularTimePeriod)new Month(7, 1993), 339.649);
        timeSeries.add((RegularTimePeriod)new Month(8, 1993), 354.375);
        timeSeries.add((RegularTimePeriod)new Month(9, 1993), 346.868);
        timeSeries.add((RegularTimePeriod)new Month(10, 1993), 355.182);
        timeSeries.add((RegularTimePeriod)new Month(11, 1993), 361.01);
        timeSeries.add((RegularTimePeriod)new Month(12, 1993), 358.678);
        timeSeries.add((RegularTimePeriod)new Month(1, 1994), 359.108);
        timeSeries.add((RegularTimePeriod)new Month(2, 1994), 362.537);
        timeSeries.add((RegularTimePeriod)new Month(3, 1994), 345.289);
        timeSeries.add((RegularTimePeriod)new Month(4, 1994), 314.62);
        timeSeries.add((RegularTimePeriod)new Month(5, 1994), 313.018);
        timeSeries.add((RegularTimePeriod)new Month(6, 1994), 293.852);
        timeSeries.add((RegularTimePeriod)new Month(7, 1994), 286.101);
        timeSeries.add((RegularTimePeriod)new Month(8, 1994), 288.678);
        timeSeries.add((RegularTimePeriod)new Month(9, 1994), 281.261);
        timeSeries.add((RegularTimePeriod)new Month(10, 1994), 311.656);
        timeSeries.add((RegularTimePeriod)new Month(11, 1994), 284.985);
        timeSeries.add((RegularTimePeriod)new Month(12, 1994), 264.463);
        timeSeries.add((RegularTimePeriod)new Month(1, 1995), 289.519);
        timeSeries.add((RegularTimePeriod)new Month(2, 1995), 294.757);
        timeSeries.add((RegularTimePeriod)new Month(3, 1995), 288.247);
        timeSeries.add((RegularTimePeriod)new Month(4, 1995), 283.623);
        timeSeries.add((RegularTimePeriod)new Month(5, 1995), 294.63);
        timeSeries.add((RegularTimePeriod)new Month(6, 1995), 305.57);
        timeSeries.add((RegularTimePeriod)new Month(7, 1995), 323.79);
        timeSeries.add((RegularTimePeriod)new Month(8, 1995), 278.765);
        timeSeries.add((RegularTimePeriod)new Month(9, 1995), 281.233);
        timeSeries.add((RegularTimePeriod)new Month(10, 1995), 251.095);
        timeSeries.add((RegularTimePeriod)new Month(11, 1995), 210.81);
        timeSeries.add((RegularTimePeriod)new Month(12, 1995), 188.515);
        timeSeries.add((RegularTimePeriod)new Month(1, 1996), 171.609);
        timeSeries.add((RegularTimePeriod)new Month(2, 1996), 162.743);
        timeSeries.add((RegularTimePeriod)new Month(3, 1996), 253.67);
        timeSeries.add((RegularTimePeriod)new Month(4, 1996), 249.722);
        timeSeries.add((RegularTimePeriod)new Month(5, 1996), 224.583);
        timeSeries.add((RegularTimePeriod)new Month(6, 1996), 209.704);
        timeSeries.add((RegularTimePeriod)new Month(7, 1996), 228.737);
        timeSeries.add((RegularTimePeriod)new Month(8, 1996), 237.547);
        timeSeries.add((RegularTimePeriod)new Month(9, 1996), 250.828);
        timeSeries.add((RegularTimePeriod)new Month(10, 1996), 262.058);
        timeSeries.add((RegularTimePeriod)new Month(11, 1996), 307.219);
        timeSeries.add((RegularTimePeriod)new Month(12, 1996), 334.507);
        timeSeries.add((RegularTimePeriod)new Month(1, 1997), 326.561);
        timeSeries.add((RegularTimePeriod)new Month(2, 1997), 332.896);
        timeSeries.add((RegularTimePeriod)new Month(3, 1997), 263.104);
        timeSeries.add((RegularTimePeriod)new Month(4, 1997), 251.922);
        timeSeries.add((RegularTimePeriod)new Month(5, 1997), 216.452);
        timeSeries.add((RegularTimePeriod)new Month(6, 1997), 215.075);
        timeSeries.add((RegularTimePeriod)new Month(7, 1997), 184.342);
        timeSeries.add((RegularTimePeriod)new Month(8, 1997), 196.117);
        timeSeries.add((RegularTimePeriod)new Month(9, 1997), 188.335);
        timeSeries.add((RegularTimePeriod)new Month(10, 1997), 179.905);
        timeSeries.add((RegularTimePeriod)new Month(11, 1997), 166.073);
        timeSeries.add((RegularTimePeriod)new Month(12, 1997), 179.216);
        timeSeries.add((RegularTimePeriod)new Month(1, 1998), 176.067);
        timeSeries.add((RegularTimePeriod)new Month(2, 1998), 170.731);
        timeSeries.add((RegularTimePeriod)new Month(3, 1998), 161.536);
        timeSeries.add((RegularTimePeriod)new Month(4, 1998), 145.924);
        timeSeries.add((RegularTimePeriod)new Month(5, 1998), 161.395);
        timeSeries.add((RegularTimePeriod)new Month(6, 1998), 171.784);
        timeSeries.add((RegularTimePeriod)new Month(7, 1998), 154.507);
        timeSeries.add((RegularTimePeriod)new Month(8, 1998), 160.133);
        timeSeries.add((RegularTimePeriod)new Month(9, 1998), 113.047);
        timeSeries.add((RegularTimePeriod)new Month(10, 1998), 132.03);
        timeSeries.add((RegularTimePeriod)new Month(11, 1998), 129.357);
        timeSeries.add((RegularTimePeriod)new Month(12, 1998), 111.829);
        timeSeries.add((RegularTimePeriod)new Month(1, 1999), 120.053);
        timeSeries.add((RegularTimePeriod)new Month(2, 1999), 101.278);
        timeSeries.add((RegularTimePeriod)new Month(3, 1999), 109.189);
        timeSeries.add((RegularTimePeriod)new Month(4, 1999), 85.945);
        timeSeries.add((RegularTimePeriod)new Month(5, 1999), 97.842);
        timeSeries.add((RegularTimePeriod)new Month(6, 1999), 90.845);
        timeSeries.add((RegularTimePeriod)new Month(7, 1999), 110.918);
        timeSeries.add((RegularTimePeriod)new Month(8, 1999), 107.833);
        timeSeries.add((RegularTimePeriod)new Month(9, 1999), 130.078);
        timeSeries.add((RegularTimePeriod)new Month(10, 1999), 120.472);
        timeSeries.add((RegularTimePeriod)new Month(11, 1999), 101.621);
        timeSeries.add((RegularTimePeriod)new Month(12, 1999), 161.874);
        timeSeries.add((RegularTimePeriod)new Month(1, 2000), 101.168);
        timeSeries.add((RegularTimePeriod)new Month(2, 2000), 113.387);
        timeSeries.add((RegularTimePeriod)new Month(3, 2000), 121.777);
        timeSeries.add((RegularTimePeriod)new Month(4, 2000), 99.268);
        timeSeries.add((RegularTimePeriod)new Month(5, 2000), 42.972);
        timeSeries.add((RegularTimePeriod)new Month(6, 2000), 47.158);
        timeSeries.add((RegularTimePeriod)new Month(7, 2000), 20.151);
        timeSeries.add((RegularTimePeriod)new Month(8, 2000), 5.436);
        timeSeries.add((RegularTimePeriod)new Month(9, 2000), 17.907);
        timeSeries.add((RegularTimePeriod)new Month(10, 2000), -22.399);
        timeSeries.add((RegularTimePeriod)new Month(11, 2000), 16.099);
        timeSeries.add((RegularTimePeriod)new Month(12, 2000), -113.875);
        timeSeries.add((RegularTimePeriod)new Month(1, 2001), 4.786);
        timeSeries.add((RegularTimePeriod)new Month(2, 2001), 0.526);
        timeSeries.add((RegularTimePeriod)new Month(3, 2001), 0.348);
        timeSeries.add((RegularTimePeriod)new Month(4, 2001), -23.76);
        timeSeries.add((RegularTimePeriod)new Month(5, 2001), 9.012);
        timeSeries.add((RegularTimePeriod)new Month(6, 2001), 40.877);
        timeSeries.add((RegularTimePeriod)new Month(7, 2001), 59.496);
        timeSeries.add((RegularTimePeriod)new Month(8, 2001), 92.054);
        timeSeries.add((RegularTimePeriod)new Month(9, 2001), 133.285);
        timeSeries.add((RegularTimePeriod)new Month(10, 2001), 158.655);
        timeSeries.add((RegularTimePeriod)new Month(11, 2001), 179.198);
        timeSeries.add((RegularTimePeriod)new Month(12, 2001), 281.223);
        timeSeries.add((RegularTimePeriod)new Month(1, 2002), 221.158);
        timeSeries.add((RegularTimePeriod)new Month(2, 2002), 267.594);
        timeSeries.add((RegularTimePeriod)new Month(3, 2002), 232.292);
        timeSeries.add((RegularTimePeriod)new Month(4, 2002), 323.329);
        timeSeries.add((RegularTimePeriod)new Month(5, 2002), 363.15);
        timeSeries.add((RegularTimePeriod)new Month(6, 2002), 399.654);
        timeSeries.add((RegularTimePeriod)new Month(7, 2002), 441.438);
        timeSeries.add((RegularTimePeriod)new Month(8, 2002), 440.606);
        timeSeries.add((RegularTimePeriod)new Month(9, 2002), 420.773);
        timeSeries.add((RegularTimePeriod)new Month(10, 2002), 466.545);
        timeSeries.add((RegularTimePeriod)new Month(11, 2002), 454.563);
        timeSeries.add((RegularTimePeriod)new Month(12, 2002), 462.268);
        timeSeries.add((RegularTimePeriod)new Month(1, 2003), 464.148);
        timeSeries.add((RegularTimePeriod)new Month(2, 2003), 442.337);
        timeSeries.add((RegularTimePeriod)new Month(3, 2003), 454.744);
        timeSeries.add((RegularTimePeriod)new Month(4, 2003), 475.704);
        timeSeries.add((RegularTimePeriod)new Month(5, 2003), 538.815);
        timeSeries.add((RegularTimePeriod)new Month(6, 2003), 543.652);
        timeSeries.add((RegularTimePeriod)new Month(7, 2003), 591.454);
        timeSeries.add((RegularTimePeriod)new Month(8, 2003), 579.559);
        timeSeries.add((RegularTimePeriod)new Month(9, 2003), 554.995);
        timeSeries.add((RegularTimePeriod)new Month(10, 2003), 590.148);
        timeSeries.add((RegularTimePeriod)new Month(11, 2003), 581.605);
        timeSeries.add((RegularTimePeriod)new Month(12, 2003), 592.257);
        timeSeries.add((RegularTimePeriod)new Month(1, 2004), 607.858);
        timeSeries.add((RegularTimePeriod)new Month(2, 2004), 646.153);
        timeSeries.add((RegularTimePeriod)new Month(3, 2004), 670.292);
        timeSeries.add((RegularTimePeriod)new Month(4, 2004), 673.408);
        timeSeries.add((RegularTimePeriod)new Month(5, 2004), 638.236);
        timeSeries.add((RegularTimePeriod)new Month(6, 2004), 604.214);
        timeSeries.add((RegularTimePeriod)new Month(7, 2004), 565.373);
        timeSeries.add((RegularTimePeriod)new Month(8, 2004), 560.909);
        timeSeries.add((RegularTimePeriod)new Month(9, 2004), 595.822);
        timeSeries.add((RegularTimePeriod)new Month(10, 2004), 557.001);
        timeSeries.add((RegularTimePeriod)new Month(11, 2004), 600.145);
        timeSeries.add((RegularTimePeriod)new Month(12, 2004), 598.18);
        timeSeries.add((RegularTimePeriod)new Month(1, 2005), 618.508);
        timeSeries.add((RegularTimePeriod)new Month(2, 2005), 621.195);
        timeSeries.add((RegularTimePeriod)new Month(3, 2005), 645.871);
        timeSeries.add((RegularTimePeriod)new Month(4, 2005), 630.748);
        timeSeries.add((RegularTimePeriod)new Month(5, 2005), 581.497);
        timeSeries.add((RegularTimePeriod)new Month(6, 2005), 562.161);
        timeSeries.add((RegularTimePeriod)new Month(7, 2005), 571.05);
        timeSeries.add((RegularTimePeriod)new Month(8, 2005), 575.983);
        timeSeries.add((RegularTimePeriod)new Month(9, 2005), 553.657);
        timeSeries.add((RegularTimePeriod)new Month(10, 2005), 597.446);
        timeSeries.add((RegularTimePeriod)new Month(11, 2005), 567.112);
        timeSeries.add((RegularTimePeriod)new Month(12, 2005), 574.27);
        timeSeries.add((RegularTimePeriod)new Month(1, 2006), 568.327);
        timeSeries.add((RegularTimePeriod)new Month(2, 2006), 556.748);
        timeSeries.add((RegularTimePeriod)new Month(3, 2006), 594.217);
        timeSeries.add((RegularTimePeriod)new Month(4, 2006), 591.181);
        timeSeries.add((RegularTimePeriod)new Month(5, 2006), 578.897);
        timeSeries.add((RegularTimePeriod)new Month(6, 2006), 583.546);
        timeSeries.add((RegularTimePeriod)new Month(7, 2006), 556.729);
        timeSeries.add((RegularTimePeriod)new Month(8, 2006), 588.101);
        timeSeries.add((RegularTimePeriod)new Month(9, 2006), 574.264);
        timeSeries.add((RegularTimePeriod)new Month(10, 2006), 557.206);
        timeSeries.add((RegularTimePeriod)new Month(11, 2006), 540.924);
        timeSeries.add((RegularTimePeriod)new Month(12, 2006), 509.81);
        timeSeries.add((RegularTimePeriod)new Month(1, 2007), 511.491);
        timeSeriesCollection.addSeries(timeSeries);
        return timeSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = CombinedXYPlotDemo1.createCombinedChart();
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        CombinedXYPlotDemo1 combinedXYPlotDemo1 = new CombinedXYPlotDemo1("JFreeChart : CombinedXYPlotDemo1.java");
        combinedXYPlotDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)combinedXYPlotDemo1));
        combinedXYPlotDemo1.setVisible(true);
    }

}

