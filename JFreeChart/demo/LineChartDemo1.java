/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.renderer.category.LineAndShapeRenderer
 *  org.jfree.chart.title.TextTitle
 *  org.jfree.chart.title.Title
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
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
import java.awt.Image;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.Window;
import java.awt.geom.Ellipse2D;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;

public class LineChartDemo1
extends ApplicationFrame {
    public LineChartDemo1(String string) {
        super(string);
        JPanel jPanel = LineChartDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(212.0, (Comparable)((Object)"Classes"), (Comparable)((Object)"JDK 1.0"));
        defaultCategoryDataset.addValue(504.0, (Comparable)((Object)"Classes"), (Comparable)((Object)"JDK 1.1"));
        defaultCategoryDataset.addValue(1520.0, (Comparable)((Object)"Classes"), (Comparable)((Object)"JDK 1.2"));
        defaultCategoryDataset.addValue(1842.0, (Comparable)((Object)"Classes"), (Comparable)((Object)"JDK 1.3"));
        defaultCategoryDataset.addValue(2991.0, (Comparable)((Object)"Classes"), (Comparable)((Object)"JDK 1.4"));
        defaultCategoryDataset.addValue(3500.0, (Comparable)((Object)"Classes"), (Comparable)((Object)"JDK 1.5"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        Object object;
        JFreeChart jFreeChart = ChartFactory.createLineChart((String)"Java Standard Class Library", (String)null, (String)"Class Count", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)false, (boolean)true, (boolean)false);
        jFreeChart.addSubtitle((Title)new TextTitle("Number of Classes By Release"));
        TextTitle textTitle = new TextTitle("Source: Java In A Nutshell (5th Edition) by David Flanagan (O'Reilly)");
        textTitle.setFont(new Font("SansSerif", 0, 10));
        textTitle.setPosition(RectangleEdge.BOTTOM);
        textTitle.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        jFreeChart.addSubtitle((Title)textTitle);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setRangePannable(true);
        categoryPlot.setRangeGridlinesVisible(false);
        URL uRL = LineChartDemo1.class.getClassLoader().getResource("OnBridge11small.png");
        if (uRL != null) {
            object = new ImageIcon(uRL);
            jFreeChart.setBackgroundImage(object.getImage());
            categoryPlot.setBackgroundPaint(null);
        }
        object = (NumberAxis)categoryPlot.getRangeAxis();
        object.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        LineAndShapeRenderer lineAndShapeRenderer = (LineAndShapeRenderer)categoryPlot.getRenderer();
        lineAndShapeRenderer.setBaseShapesVisible(true);
        lineAndShapeRenderer.setDrawOutlines(true);
        lineAndShapeRenderer.setUseFillPaint(true);
        lineAndShapeRenderer.setBaseFillPaint((Paint)Color.white);
        lineAndShapeRenderer.setSeriesStroke(0, (Stroke)new BasicStroke(3.0f));
        lineAndShapeRenderer.setSeriesOutlineStroke(0, (Stroke)new BasicStroke(2.0f));
        lineAndShapeRenderer.setSeriesShape(0, (Shape)new Ellipse2D.Double(-5.0, -5.0, 10.0, 10.0));
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = LineChartDemo1.createChart(LineChartDemo1.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        LineChartDemo1 lineChartDemo1 = new LineChartDemo1("JFreeChart: LineChartDemo1.java");
        lineChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)lineChartDemo1));
        lineChartDemo1.setVisible(true);
    }
}

