/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.axis.CategoryLabelPositions
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.renderer.AreaRendererEndType
 *  org.jfree.chart.renderer.category.AreaRenderer
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.title.TextTitle
 *  org.jfree.chart.title.Title
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RectangleEdge
 *  org.jfree.ui.RectangleInsets
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.ui.VerticalAlignment
 *  org.jfree.util.UnitType
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.renderer.AreaRendererEndType;
import org.jfree.chart.renderer.category.AreaRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.VerticalAlignment;
import org.jfree.util.UnitType;

public class AreaChartDemo1
extends ApplicationFrame {
    public AreaChartDemo1(String string) {
        super(string);
        JPanel jPanel = AreaChartDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(1.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Type 1"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Type 2"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Type 3"));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Type 4"));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Type 5"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Type 6"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Type 7"));
        defaultCategoryDataset.addValue(8.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Type 8"));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Type 1"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Type 2"));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Type 3"));
        defaultCategoryDataset.addValue(8.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Type 4"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Type 5"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Type 6"));
        defaultCategoryDataset.addValue(2.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Type 7"));
        defaultCategoryDataset.addValue(1.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Type 8"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Type 1"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Type 2"));
        defaultCategoryDataset.addValue(2.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Type 3"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Type 4"));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Type 5"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Type 6"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Type 7"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Type 8"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createAreaChart((String)"Area Chart", (String)"Category", (String)"Value", (CategoryDataset)categoryDataset);
        TextTitle textTitle = new TextTitle("An area chart demonstration.  We use this subtitle as an example of what happens when you get a really long title or subtitle.");
        textTitle.setPosition(RectangleEdge.TOP);
        textTitle.setPadding(new RectangleInsets(UnitType.RELATIVE, 0.05, 0.05, 0.05, 0.05));
        textTitle.setVerticalAlignment(VerticalAlignment.BOTTOM);
        jFreeChart.addSubtitle((Title)textTitle);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setForegroundAlpha(0.5f);
        categoryPlot.setDomainGridlinesVisible(true);
        AreaRenderer areaRenderer = (AreaRenderer)categoryPlot.getRenderer();
        areaRenderer.setEndType(AreaRendererEndType.LEVEL);
        CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        categoryAxis.setLowerMargin(0.0);
        categoryAxis.setUpperMargin(0.0);
        categoryAxis.addCategoryLabelToolTip((Comparable)((Object)"Type 1"), "The first type.");
        categoryAxis.addCategoryLabelToolTip((Comparable)((Object)"Type 2"), "The second type.");
        categoryAxis.addCategoryLabelToolTip((Comparable)((Object)"Type 3"), "The third type.");
        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberAxis.setLabelAngle(0.0);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = AreaChartDemo1.createChart(AreaChartDemo1.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        AreaChartDemo1 areaChartDemo1 = new AreaChartDemo1("JFreeChart: AreaChartDemo1.java");
        areaChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)areaChartDemo1));
        areaChartDemo1.setVisible(true);
    }
}

