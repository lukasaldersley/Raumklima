/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.annotations.CategoryAnnotation
 *  org.jfree.chart.annotations.CategoryPointerAnnotation
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
 *  org.jfree.ui.TextAnchor
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.CategoryAnnotation;
import org.jfree.chart.annotations.CategoryPointerAnnotation;
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
import org.jfree.ui.TextAnchor;

public class CategoryPointerAnnotationDemo1
extends ApplicationFrame {
    public CategoryPointerAnnotationDemo1(String string) {
        super(string);
        JPanel jPanel = CategoryPointerAnnotationDemo1.createDemoPanel();
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
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createLineChart((String)"Java Standard Class Library", (String)"Release", (String)"Class Count", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)false, (boolean)true, (boolean)false);
        jFreeChart.addSubtitle((Title)new TextTitle("Number of Classes By Release"));
        TextTitle textTitle = new TextTitle("Source: Java In A Nutshell (4th Edition) by David Flanagan (O'Reilly)");
        textTitle.setFont(new Font("SansSerif", 0, 10));
        textTitle.setPosition(RectangleEdge.BOTTOM);
        textTitle.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        jFreeChart.addSubtitle((Title)textTitle);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        LineAndShapeRenderer lineAndShapeRenderer = (LineAndShapeRenderer)categoryPlot.getRenderer();
        lineAndShapeRenderer.setBaseShapesVisible(true);
        lineAndShapeRenderer.setDrawOutlines(true);
        lineAndShapeRenderer.setUseFillPaint(true);
        lineAndShapeRenderer.setBaseFillPaint((Paint)Color.white);
        CategoryPointerAnnotation categoryPointerAnnotation = new CategoryPointerAnnotation("Released 4-Dec-1998", (Comparable)((Object)"JDK 1.2"), 1530.0, -2.356194490192345);
        categoryPointerAnnotation.setTextAnchor(TextAnchor.BOTTOM_RIGHT);
        categoryPlot.addAnnotation((CategoryAnnotation)categoryPointerAnnotation);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = CategoryPointerAnnotationDemo1.createChart(CategoryPointerAnnotationDemo1.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        CategoryPointerAnnotationDemo1 categoryPointerAnnotationDemo1 = new CategoryPointerAnnotationDemo1("JFreeChart: CategoryPointerAnnotationDemo1.java");
        categoryPointerAnnotationDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)categoryPointerAnnotationDemo1));
        categoryPointerAnnotationDemo1.setVisible(true);
    }
}

