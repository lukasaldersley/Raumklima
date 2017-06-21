/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.annotations.XYAnnotation
 *  org.jfree.chart.annotations.XYDrawableAnnotation
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.DateTickUnit
 *  org.jfree.chart.axis.DateTickUnitType
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnit
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.TickUnits
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.StandardXYToolTipGenerator
 *  org.jfree.chart.labels.XYToolTipGenerator
 *  org.jfree.chart.plot.PiePlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.data.general.DefaultPieDataset
 *  org.jfree.data.general.PieDataset
 *  org.jfree.data.time.Month
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.time.Year
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.Drawable
 *  org.jfree.ui.RectangleInsets
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.Window;
import java.awt.geom.Ellipse2D;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYAnnotation;
import org.jfree.chart.annotations.XYDrawableAnnotation;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.DateTickUnitType;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnit;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.TickUnits;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.time.Month;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.Drawable;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class XYDrawableAnnotationDemo1
extends ApplicationFrame {
    public XYDrawableAnnotationDemo1(String string) {
        super(string);
        JPanel jPanel = XYDrawableAnnotationDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 300));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"XYDrawableAnnotationDemo1", (String)null, (String)"$ million", (XYDataset)xYDataset, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        DateAxis dateAxis = (DateAxis)xYPlot.getDomainAxis();
        dateAxis.setLowerMargin(0.2);
        dateAxis.setUpperMargin(0.2);
        dateAxis.setStandardTickUnits(XYDrawableAnnotationDemo1.createStandardDateTickUnits());
        NumberAxis numberAxis = (NumberAxis)xYPlot.getRangeAxis();
        numberAxis.setLowerMargin(0.2);
        numberAxis.setUpperMargin(0.2);
        XYLineAndShapeRenderer xYLineAndShapeRenderer = new XYLineAndShapeRenderer();
        xYLineAndShapeRenderer.setBaseShapesVisible(true);
        xYLineAndShapeRenderer.setBaseLinesVisible(true);
        xYLineAndShapeRenderer.setSeriesShape(0, (Shape)new Ellipse2D.Double(-5.0, -5.0, 10.0, 10.0));
        xYLineAndShapeRenderer.setSeriesShape(1, (Shape)new Ellipse2D.Double(-5.0, -5.0, 10.0, 10.0));
        xYLineAndShapeRenderer.setSeriesStroke(0, (Stroke)new BasicStroke(3.0f));
        xYLineAndShapeRenderer.setSeriesStroke(1, (Stroke)new BasicStroke(3.0f, 1, 1, 5.0f, new float[]{10.0f, 5.0f}, 0.0f));
        xYLineAndShapeRenderer.setSeriesFillPaint(0, (Paint)Color.white);
        xYLineAndShapeRenderer.setSeriesFillPaint(1, (Paint)Color.white);
        xYLineAndShapeRenderer.setUseFillPaint(true);
        xYLineAndShapeRenderer.setBaseToolTipGenerator((XYToolTipGenerator)new StandardXYToolTipGenerator());
        xYLineAndShapeRenderer.setDefaultEntityRadius(6);
        xYLineAndShapeRenderer.addAnnotation((XYAnnotation)new XYDrawableAnnotation((double)new Month(4, 2005).getFirstMillisecond(), 600.0, 180.0, 100.0, 3.0, (Drawable)XYDrawableAnnotationDemo1.createPieChart()));
        xYLineAndShapeRenderer.addAnnotation((XYAnnotation)new XYDrawableAnnotation((double)new Month(9, 2007).getFirstMillisecond(), 1250.0, 120.0, 100.0, 2.0, (Drawable)XYDrawableAnnotationDemo1.createBarChart()));
        xYPlot.setRenderer((XYItemRenderer)xYLineAndShapeRenderer);
        return jFreeChart;
    }

    private static XYDataset createDataset() {
        TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Division A"));
        timeSeries.add((RegularTimePeriod)new Year(2005), 1520.0);
        timeSeries.add((RegularTimePeriod)new Year(2006), 1132.0);
        timeSeries.add((RegularTimePeriod)new Year(2007), 450.0);
        timeSeries.add((RegularTimePeriod)new Year(2008), 620.0);
        TimeSeries timeSeries2 = new TimeSeries((Comparable)((Object)"Division B"));
        timeSeries2.add((RegularTimePeriod)new Year(2005), 1200.0);
        timeSeries2.add((RegularTimePeriod)new Year(2006), 1300.0);
        timeSeries2.add((RegularTimePeriod)new Year(2007), 640.0);
        timeSeries2.add((RegularTimePeriod)new Year(2008), 520.0);
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        timeSeriesCollection.addSeries(timeSeries);
        timeSeriesCollection.addSeries(timeSeries2);
        return timeSeriesCollection;
    }

    private static JFreeChart createPieChart() {
        DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
        defaultPieDataset.setValue((Comparable)((Object)"Engineering"), 43.2);
        defaultPieDataset.setValue((Comparable)((Object)"Research"), 13.2);
        defaultPieDataset.setValue((Comparable)((Object)"Advertising"), 20.9);
        PiePlot piePlot = new PiePlot((PieDataset)defaultPieDataset);
        piePlot.setBackgroundPaint(null);
        piePlot.setOutlinePaint(null);
        piePlot.setBaseSectionOutlinePaint((Paint)Color.white);
        piePlot.setBaseSectionOutlineStroke((Stroke)new BasicStroke(2.0f));
        piePlot.setLabelFont(new Font("Dialog", 0, 18));
        piePlot.setMaximumLabelWidth(0.25);
        JFreeChart jFreeChart = new JFreeChart((Plot)piePlot);
        jFreeChart.setBackgroundPaint(null);
        jFreeChart.removeLegend();
        jFreeChart.setPadding(RectangleInsets.ZERO_INSETS);
        return jFreeChart;
    }

    private static JFreeChart createBarChart() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(10.0, (Comparable)((Object)"R1"), (Comparable)((Object)"Q1"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"R1"), (Comparable)((Object)"Q2"));
        defaultCategoryDataset.addValue(8.0, (Comparable)((Object)"R1"), (Comparable)((Object)"Q3"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"R1"), (Comparable)((Object)"Q4"));
        defaultCategoryDataset.addValue(10.6, (Comparable)((Object)"R2"), (Comparable)((Object)"Q1"));
        defaultCategoryDataset.addValue(6.1, (Comparable)((Object)"R2"), (Comparable)((Object)"Q2"));
        defaultCategoryDataset.addValue(8.5, (Comparable)((Object)"R2"), (Comparable)((Object)"Q3"));
        defaultCategoryDataset.addValue(4.3, (Comparable)((Object)"R2"), (Comparable)((Object)"Q4"));
        JFreeChart jFreeChart = ChartFactory.createBarChart((String)"Sales 2008", (String)null, (String)null, (CategoryDataset)defaultCategoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)false, (boolean)false, (boolean)false);
        jFreeChart.setBackgroundPaint(null);
        jFreeChart.getPlot().setBackgroundPaint((Paint)new Color(200, 200, 255, 60));
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = XYDrawableAnnotationDemo1.createChart(XYDrawableAnnotationDemo1.createDataset());
        return new ChartPanel(jFreeChart);
    }

    private static TickUnitSource createStandardDateTickUnits() {
        TickUnits tickUnits = new TickUnits();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        tickUnits.add((TickUnit)new DateTickUnit(DateTickUnitType.YEAR, 1, DateTickUnitType.YEAR, 1, (DateFormat)simpleDateFormat));
        tickUnits.add((TickUnit)new DateTickUnit(DateTickUnitType.YEAR, 2, DateTickUnitType.YEAR, 1, (DateFormat)simpleDateFormat));
        tickUnits.add((TickUnit)new DateTickUnit(DateTickUnitType.YEAR, 5, DateTickUnitType.YEAR, 5, (DateFormat)simpleDateFormat));
        return tickUnits;
    }

    public static void main(String[] arrstring) {
        XYDrawableAnnotationDemo1 xYDrawableAnnotationDemo1 = new XYDrawableAnnotationDemo1("JFreeChart: XYDrawableAnnotationDemo1.java");
        xYDrawableAnnotationDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)xYDrawableAnnotationDemo1));
        xYDrawableAnnotationDemo1.setVisible(true);
    }
}

