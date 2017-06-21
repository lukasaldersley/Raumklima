/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.DateTickMarkPosition
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.StandardXYToolTipGenerator
 *  org.jfree.chart.labels.XYToolTipGenerator
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.StackedXYBarRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.title.TextTitle
 *  org.jfree.chart.title.Title
 *  org.jfree.data.time.TimePeriod
 *  org.jfree.data.time.TimeTableXYDataset
 *  org.jfree.data.time.Year
 *  org.jfree.data.xy.TableXYDataset
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.GradientPaintTransformType
 *  org.jfree.ui.GradientPaintTransformer
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.ui.StandardGradientPaintTransformer
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Window;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickMarkPosition;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StackedXYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.time.TimePeriod;
import org.jfree.data.time.TimeTableXYDataset;
import org.jfree.data.time.Year;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.StandardGradientPaintTransformer;

public class StackedXYBarChartDemo3
extends ApplicationFrame {
    public StackedXYBarChartDemo3(String string) {
        super(string);
        JPanel jPanel = StackedXYBarChartDemo3.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static TableXYDataset createDataset() {
        TimeTableXYDataset timeTableXYDataset = new TimeTableXYDataset();
        timeTableXYDataset.add((TimePeriod)new Year(2002), 41287.0, (Comparable)((Object)"Landfilled"));
        timeTableXYDataset.add((TimePeriod)new Year(2003), 41096.0, (Comparable)((Object)"Landfilled"));
        timeTableXYDataset.add((TimePeriod)new Year(2004), 39603.0, (Comparable)((Object)"Landfilled"));
        timeTableXYDataset.add((TimePeriod)new Year(2005), 39693.0, (Comparable)((Object)"Landfilled"));
        timeTableXYDataset.add((TimePeriod)new Year(2006), 37227.0, (Comparable)((Object)"Landfilled"));
        timeTableXYDataset.add((TimePeriod)new Year(2002), 7717.0, (Comparable)((Object)"Recycled"));
        timeTableXYDataset.add((TimePeriod)new Year(2003), 8317.0, (Comparable)((Object)"Recycled"));
        timeTableXYDataset.add((TimePeriod)new Year(2004), 9493.0, (Comparable)((Object)"Recycled"));
        timeTableXYDataset.add((TimePeriod)new Year(2005), 11228.0, (Comparable)((Object)"Recycled"));
        timeTableXYDataset.add((TimePeriod)new Year(2006), 14941.0, (Comparable)((Object)"Recycled"));
        return timeTableXYDataset;
    }

    private static JFreeChart createChart(TableXYDataset tableXYDataset) {
        DateAxis dateAxis = new DateAxis("Year");
        dateAxis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
        dateAxis.setLowerMargin(0.01);
        dateAxis.setUpperMargin(0.01);
        NumberAxis numberAxis = new NumberAxis("Tonnes");
        numberAxis.setNumberFormatOverride((NumberFormat)new DecimalFormat("0.0%"));
        StackedXYBarRenderer stackedXYBarRenderer = new StackedXYBarRenderer(0.3);
        stackedXYBarRenderer.setRenderAsPercentages(true);
        stackedXYBarRenderer.setDrawBarOutline(false);
        stackedXYBarRenderer.setBaseToolTipGenerator((XYToolTipGenerator)new StandardXYToolTipGenerator("{0} : {1} = {2} tonnes", (DateFormat)new SimpleDateFormat("yyyy"), (NumberFormat)new DecimalFormat("#,##0")));
        XYPlot xYPlot = new XYPlot((XYDataset)tableXYDataset, (ValueAxis)dateAxis, (ValueAxis)numberAxis, (XYItemRenderer)stackedXYBarRenderer);
        xYPlot.setBackgroundPaint((Paint)Color.lightGray);
        xYPlot.setDomainGridlinePaint((Paint)Color.white);
        xYPlot.setRangeGridlinePaint((Paint)Color.white);
        JFreeChart jFreeChart = new JFreeChart("Waste Management", (Plot)xYPlot);
        jFreeChart.setBackgroundPaint((Paint)Color.white);
        jFreeChart.addSubtitle((Title)new TextTitle("St Albans City and District Council"));
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        GradientPaint gradientPaint = new GradientPaint(0.0f, 0.0f, new Color(64, 0, 0), 0.0f, 0.0f, Color.red);
        GradientPaint gradientPaint2 = new GradientPaint(0.0f, 0.0f, new Color(0, 64, 0), 0.0f, 0.0f, Color.green);
        stackedXYBarRenderer.setSeriesPaint(0, (Paint)gradientPaint);
        stackedXYBarRenderer.setSeriesPaint(1, (Paint)gradientPaint2);
        stackedXYBarRenderer.setGradientPaintTransformer((GradientPaintTransformer)new StandardGradientPaintTransformer(GradientPaintTransformType.HORIZONTAL));
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = StackedXYBarChartDemo3.createChart(StackedXYBarChartDemo3.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        StackedXYBarChartDemo3 stackedXYBarChartDemo3 = new StackedXYBarChartDemo3("JFreeChart: StackedXYBarChartDemo3");
        stackedXYBarChartDemo3.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)stackedXYBarChartDemo3));
        stackedXYBarChartDemo3.setVisible(true);
    }
}

