/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.LegendItemSource
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.DateTickMarkPosition
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.block.BlockBorder
 *  org.jfree.chart.block.BlockFrame
 *  org.jfree.chart.labels.ItemLabelAnchor
 *  org.jfree.chart.labels.ItemLabelPosition
 *  org.jfree.chart.labels.StandardXYItemLabelGenerator
 *  org.jfree.chart.labels.StandardXYToolTipGenerator
 *  org.jfree.chart.labels.XYItemLabelGenerator
 *  org.jfree.chart.labels.XYToolTipGenerator
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.StackedXYBarRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.title.LegendTitle
 *  org.jfree.chart.title.TextTitle
 *  org.jfree.chart.title.Title
 *  org.jfree.data.time.TimePeriod
 *  org.jfree.data.time.TimeTableXYDataset
 *  org.jfree.data.time.Year
 *  org.jfree.data.xy.TableXYDataset
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RectangleEdge
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.ui.TextAnchor
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Paint;
import java.awt.RenderingHints;
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
import org.jfree.chart.axis.DateTickMarkPosition;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.block.BlockFrame;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StackedXYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.time.TimePeriod;
import org.jfree.data.time.TimeTableXYDataset;
import org.jfree.data.time.Year;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class StackedXYBarChartDemo2
extends ApplicationFrame {
    public StackedXYBarChartDemo2(String string) {
        super(string);
        JPanel jPanel = StackedXYBarChartDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static TableXYDataset createDataset() {
        TimeTableXYDataset timeTableXYDataset = new TimeTableXYDataset();
        timeTableXYDataset.add((TimePeriod)new Year(1983), 0.0, (Comparable)((Object)"Albatrosses"));
        timeTableXYDataset.add((TimePeriod)new Year(1984), 2.0, (Comparable)((Object)"Albatrosses"));
        timeTableXYDataset.add((TimePeriod)new Year(1985), 1.0, (Comparable)((Object)"Albatrosses"));
        timeTableXYDataset.add((TimePeriod)new Year(1986), 1.0, (Comparable)((Object)"Albatrosses"));
        timeTableXYDataset.add((TimePeriod)new Year(1987), 2.0, (Comparable)((Object)"Albatrosses"));
        timeTableXYDataset.add((TimePeriod)new Year(1988), 2.0, (Comparable)((Object)"Albatrosses"));
        timeTableXYDataset.add((TimePeriod)new Year(1989), 1.0, (Comparable)((Object)"Albatrosses"));
        timeTableXYDataset.add((TimePeriod)new Year(1990), 5.0, (Comparable)((Object)"Albatrosses"));
        timeTableXYDataset.add((TimePeriod)new Year(1991), 5.0, (Comparable)((Object)"Albatrosses"));
        timeTableXYDataset.add((TimePeriod)new Year(1992), 2.0, (Comparable)((Object)"Albatrosses"));
        timeTableXYDataset.add((TimePeriod)new Year(1993), 4.0, (Comparable)((Object)"Albatrosses"));
        timeTableXYDataset.add((TimePeriod)new Year(1994), 3.0, (Comparable)((Object)"Albatrosses"));
        timeTableXYDataset.add((TimePeriod)new Year(1995), 2.0, (Comparable)((Object)"Albatrosses"));
        timeTableXYDataset.add((TimePeriod)new Year(1996), 1.0, (Comparable)((Object)"Albatrosses"));
        timeTableXYDataset.add((TimePeriod)new Year(1997), 2.0, (Comparable)((Object)"Albatrosses"));
        timeTableXYDataset.add((TimePeriod)new Year(1998), 1.0, (Comparable)((Object)"Albatrosses"));
        timeTableXYDataset.add((TimePeriod)new Year(1999), 4.0, (Comparable)((Object)"Albatrosses"));
        timeTableXYDataset.add((TimePeriod)new Year(2000), 6.0, (Comparable)((Object)"Albatrosses"));
        timeTableXYDataset.add((TimePeriod)new Year(2001), 5.0, (Comparable)((Object)"Albatrosses"));
        timeTableXYDataset.add((TimePeriod)new Year(2002), 4.0, (Comparable)((Object)"Albatrosses"));
        timeTableXYDataset.add((TimePeriod)new Year(2003), 2.0, (Comparable)((Object)"Albatrosses"));
        timeTableXYDataset.add((TimePeriod)new Year(1983), 21.0, (Comparable)((Object)"Aces"));
        timeTableXYDataset.add((TimePeriod)new Year(1984), 24.0, (Comparable)((Object)"Aces"));
        timeTableXYDataset.add((TimePeriod)new Year(1985), 32.0, (Comparable)((Object)"Aces"));
        timeTableXYDataset.add((TimePeriod)new Year(1986), 20.0, (Comparable)((Object)"Aces"));
        timeTableXYDataset.add((TimePeriod)new Year(1987), 28.0, (Comparable)((Object)"Aces"));
        timeTableXYDataset.add((TimePeriod)new Year(1988), 17.0, (Comparable)((Object)"Aces"));
        timeTableXYDataset.add((TimePeriod)new Year(1989), 31.0, (Comparable)((Object)"Aces"));
        timeTableXYDataset.add((TimePeriod)new Year(1990), 32.0, (Comparable)((Object)"Aces"));
        timeTableXYDataset.add((TimePeriod)new Year(1991), 29.0, (Comparable)((Object)"Aces"));
        timeTableXYDataset.add((TimePeriod)new Year(1992), 31.0, (Comparable)((Object)"Aces"));
        timeTableXYDataset.add((TimePeriod)new Year(1993), 25.0, (Comparable)((Object)"Aces"));
        timeTableXYDataset.add((TimePeriod)new Year(1994), 44.0, (Comparable)((Object)"Aces"));
        timeTableXYDataset.add((TimePeriod)new Year(1995), 35.0, (Comparable)((Object)"Aces"));
        timeTableXYDataset.add((TimePeriod)new Year(1996), 40.0, (Comparable)((Object)"Aces"));
        timeTableXYDataset.add((TimePeriod)new Year(1997), 32.0, (Comparable)((Object)"Aces"));
        timeTableXYDataset.add((TimePeriod)new Year(1998), 32.0, (Comparable)((Object)"Aces"));
        timeTableXYDataset.add((TimePeriod)new Year(1999), 30.0, (Comparable)((Object)"Aces"));
        timeTableXYDataset.add((TimePeriod)new Year(2000), 29.0, (Comparable)((Object)"Aces"));
        timeTableXYDataset.add((TimePeriod)new Year(2001), 28.0, (Comparable)((Object)"Aces"));
        timeTableXYDataset.add((TimePeriod)new Year(2002), 39.0, (Comparable)((Object)"Aces"));
        timeTableXYDataset.add((TimePeriod)new Year(2003), 32.0, (Comparable)((Object)"Aces"));
        return timeTableXYDataset;
    }

    private static JFreeChart createChart(TableXYDataset tableXYDataset) {
        DateAxis dateAxis = new DateAxis("Date");
        dateAxis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
        dateAxis.setLowerMargin(0.01);
        dateAxis.setUpperMargin(0.01);
        NumberAxis numberAxis = new NumberAxis("Count");
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberAxis.setUpperMargin(0.1);
        StackedXYBarRenderer stackedXYBarRenderer = new StackedXYBarRenderer(0.15);
        stackedXYBarRenderer.setDrawBarOutline(false);
        stackedXYBarRenderer.setBaseItemLabelsVisible(true);
        stackedXYBarRenderer.setBaseItemLabelGenerator((XYItemLabelGenerator)new StandardXYItemLabelGenerator());
        stackedXYBarRenderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER));
        stackedXYBarRenderer.setBaseToolTipGenerator((XYToolTipGenerator)new StandardXYToolTipGenerator("{0} : {1} = {2}", (DateFormat)new SimpleDateFormat("yyyy"), (NumberFormat)new DecimalFormat("0")));
        XYPlot xYPlot = new XYPlot((XYDataset)tableXYDataset, (ValueAxis)dateAxis, (ValueAxis)numberAxis, (XYItemRenderer)stackedXYBarRenderer);
        JFreeChart jFreeChart = new JFreeChart("Holes-In-One / Double Eagles", (Plot)xYPlot);
        jFreeChart.removeLegend();
        jFreeChart.addSubtitle((Title)new TextTitle("PGA Tour, 1983 to 2003"));
        TextTitle textTitle = new TextTitle("http://www.golfdigest.com/majors/masters/index.ssf?/majors/masters/gw20040402albatross.html", new Font("Dialog", 0, 8));
        jFreeChart.addSubtitle((Title)textTitle);
        jFreeChart.setTextAntiAlias(RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT);
        LegendTitle legendTitle = new LegendTitle((LegendItemSource)xYPlot);
        legendTitle.setBackgroundPaint((Paint)Color.white);
        legendTitle.setFrame((BlockFrame)new BlockBorder());
        legendTitle.setPosition(RectangleEdge.BOTTOM);
        jFreeChart.addSubtitle((Title)legendTitle);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = StackedXYBarChartDemo2.createChart(StackedXYBarChartDemo2.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        StackedXYBarChartDemo2 stackedXYBarChartDemo2 = new StackedXYBarChartDemo2("JFreeChart: Stacked XY Bar Chart Demo 2");
        stackedXYBarChartDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)stackedXYBarChartDemo2));
        stackedXYBarChartDemo2.setVisible(true);
    }
}

