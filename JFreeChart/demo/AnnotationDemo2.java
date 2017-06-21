/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.LegendItemSource
 *  org.jfree.chart.annotations.XYAnnotation
 *  org.jfree.chart.annotations.XYPointerAnnotation
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.block.Arrangement
 *  org.jfree.chart.block.Block
 *  org.jfree.chart.block.BlockBorder
 *  org.jfree.chart.block.BlockContainer
 *  org.jfree.chart.block.BlockFrame
 *  org.jfree.chart.block.BorderArrangement
 *  org.jfree.chart.block.EmptyBlock
 *  org.jfree.chart.labels.StandardXYToolTipGenerator
 *  org.jfree.chart.labels.XYToolTipGenerator
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
 *  org.jfree.chart.title.CompositeTitle
 *  org.jfree.chart.title.LegendTitle
 *  org.jfree.chart.title.Title
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.XYSeries
 *  org.jfree.data.xy.XYSeriesCollection
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RectangleEdge
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.ui.TextAnchor
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Paint;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItemSource;
import org.jfree.chart.annotations.XYAnnotation;
import org.jfree.chart.annotations.XYPointerAnnotation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.block.Arrangement;
import org.jfree.chart.block.Block;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.BlockFrame;
import org.jfree.chart.block.BorderArrangement;
import org.jfree.chart.block.EmptyBlock;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.CompositeTitle;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class AnnotationDemo2
extends ApplicationFrame {
    public AnnotationDemo2(String string) {
        super(string);
        this.setContentPane((Container)AnnotationDemo2.createDemoPanel());
    }

    private static XYDataset createDataset1() {
        XYSeries xYSeries = new XYSeries((Comparable)((Object)"Random Data 1"));
        xYSeries.add(1.0, 181.8);
        xYSeries.add(2.0, 167.3);
        xYSeries.add(3.0, 153.8);
        xYSeries.add(4.0, 167.6);
        xYSeries.add(5.0, 158.8);
        xYSeries.add(6.0, 148.3);
        xYSeries.add(7.0, 153.9);
        xYSeries.add(8.0, 142.7);
        xYSeries.add(9.0, 123.2);
        xYSeries.add(10.0, 131.8);
        xYSeries.add(11.0, 139.6);
        xYSeries.add(12.0, 142.9);
        xYSeries.add(13.0, 138.7);
        xYSeries.add(14.0, 137.3);
        xYSeries.add(15.0, 143.9);
        xYSeries.add(16.0, 139.8);
        xYSeries.add(17.0, 137.0);
        xYSeries.add(18.0, 132.8);
        XYSeriesCollection xYSeriesCollection = new XYSeriesCollection();
        xYSeriesCollection.addSeries(xYSeries);
        return xYSeriesCollection;
    }

    private static XYDataset createDataset2() {
        XYSeries xYSeries = new XYSeries((Comparable)((Object)"Random Data 2"));
        xYSeries.add(1.0, 429.6);
        xYSeries.add(2.0, 323.2);
        xYSeries.add(3.0, 417.2);
        xYSeries.add(4.0, 624.1);
        xYSeries.add(5.0, 422.6);
        xYSeries.add(6.0, 619.2);
        xYSeries.add(7.0, 416.5);
        xYSeries.add(8.0, 512.7);
        xYSeries.add(9.0, 501.5);
        xYSeries.add(10.0, 306.1);
        xYSeries.add(11.0, 410.3);
        xYSeries.add(12.0, 511.7);
        xYSeries.add(13.0, 611.0);
        xYSeries.add(14.0, 709.6);
        xYSeries.add(15.0, 613.2);
        xYSeries.add(16.0, 711.6);
        xYSeries.add(17.0, 708.8);
        xYSeries.add(18.0, 501.6);
        XYSeriesCollection xYSeriesCollection = new XYSeriesCollection();
        xYSeriesCollection.addSeries(xYSeries);
        return xYSeriesCollection;
    }

    private static JFreeChart createChart() {
        XYDataset xYDataset = AnnotationDemo2.createDataset1();
        JFreeChart jFreeChart = ChartFactory.createXYLineChart((String)"Annotation Demo 2", (String)"Date", (String)"Price Per Unit", (XYDataset)xYDataset);
        jFreeChart.removeLegend();
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        NumberAxis numberAxis = (NumberAxis)xYPlot.getRangeAxis();
        numberAxis.setAutoRangeIncludesZero(false);
        NumberAxis numberAxis2 = new NumberAxis("Secondary");
        numberAxis2.setAutoRangeIncludesZero(false);
        xYPlot.setRangeAxis(1, (ValueAxis)numberAxis2);
        xYPlot.setDataset(1, AnnotationDemo2.createDataset2());
        xYPlot.mapDatasetToRangeAxis(1, 1);
        XYLineAndShapeRenderer xYLineAndShapeRenderer = (XYLineAndShapeRenderer)xYPlot.getRenderer();
        xYLineAndShapeRenderer.setBaseToolTipGenerator((XYToolTipGenerator)StandardXYToolTipGenerator.getTimeSeriesInstance());
        xYLineAndShapeRenderer.setBaseShapesVisible(true);
        xYLineAndShapeRenderer.setBaseShapesFilled(true);
        XYPointerAnnotation xYPointerAnnotation = new XYPointerAnnotation("Annotation 1 (2.0, 167.3)", 2.0, 167.3, -0.7853981633974483);
        xYPointerAnnotation.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        xYPointerAnnotation.setPaint((Paint)Color.red);
        xYPointerAnnotation.setArrowPaint((Paint)Color.red);
        xYLineAndShapeRenderer.addAnnotation((XYAnnotation)xYPointerAnnotation);
        XYLineAndShapeRenderer xYLineAndShapeRenderer2 = new XYLineAndShapeRenderer(true, true);
        xYLineAndShapeRenderer2.setSeriesPaint(0, (Paint)Color.black);
        xYLineAndShapeRenderer.setBaseToolTipGenerator((XYToolTipGenerator)StandardXYToolTipGenerator.getTimeSeriesInstance());
        XYPointerAnnotation xYPointerAnnotation2 = new XYPointerAnnotation("Annotation 2 (15.0, 613.2)", 15.0, 613.2, 1.5707963267948966);
        xYPointerAnnotation2.setTextAnchor(TextAnchor.TOP_CENTER);
        xYLineAndShapeRenderer2.addAnnotation((XYAnnotation)xYPointerAnnotation2);
        xYPlot.setRenderer(1, (XYItemRenderer)xYLineAndShapeRenderer2);
        LegendTitle legendTitle = new LegendTitle((LegendItemSource)xYLineAndShapeRenderer);
        LegendTitle legendTitle2 = new LegendTitle((LegendItemSource)xYLineAndShapeRenderer2);
        BlockContainer blockContainer = new BlockContainer((Arrangement)new BorderArrangement());
        blockContainer.add((Block)legendTitle, (Object)RectangleEdge.LEFT);
        blockContainer.add((Block)legendTitle2, (Object)RectangleEdge.RIGHT);
        blockContainer.add((Block)new EmptyBlock(2000.0, 0.0));
        CompositeTitle compositeTitle = new CompositeTitle(blockContainer);
        compositeTitle.setFrame((BlockFrame)new BlockBorder((Paint)Color.red));
        compositeTitle.setBackgroundPaint((Paint)Color.LIGHT_GRAY);
        compositeTitle.setPosition(RectangleEdge.BOTTOM);
        jFreeChart.addSubtitle((Title)compositeTitle);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = AnnotationDemo2.createChart();
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        AnnotationDemo2 annotationDemo2 = new AnnotationDemo2("JFreeChart: AnnotationDemo2.java");
        annotationDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)annotationDemo2));
        annotationDemo2.setVisible(true);
    }
}

