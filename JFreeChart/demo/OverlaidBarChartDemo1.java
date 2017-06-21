/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartMouseEvent
 *  org.jfree.chart.ChartMouseListener
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.axis.CategoryLabelPositions
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.entity.ChartEntity
 *  org.jfree.chart.labels.CategoryItemLabelGenerator
 *  org.jfree.chart.labels.StandardCategoryItemLabelGenerator
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.DatasetRenderingOrder
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.renderer.category.BarRenderer
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.renderer.category.LineAndShapeRenderer
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import java.io.PrintStream;
import javax.swing.JPanel;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class OverlaidBarChartDemo1
extends ApplicationFrame {
    public OverlaidBarChartDemo1(String string) {
        super(string);
        JPanel jPanel = OverlaidBarChartDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    public static JFreeChart createChart() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(1.0, (Comparable)((Object)"S1"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"S1"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"S1"), (Comparable)((Object)"Category 3"));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)"S1"), (Comparable)((Object)"Category 4"));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)"S1"), (Comparable)((Object)"Category 5"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"S1"), (Comparable)((Object)"Category 6"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"S1"), (Comparable)((Object)"Category 7"));
        defaultCategoryDataset.addValue(8.0, (Comparable)((Object)"S1"), (Comparable)((Object)"Category 8"));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)"S2"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"S2"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)"S2"), (Comparable)((Object)"Category 3"));
        defaultCategoryDataset.addValue(8.0, (Comparable)((Object)"S2"), (Comparable)((Object)"Category 4"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"S2"), (Comparable)((Object)"Category 5"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"S2"), (Comparable)((Object)"Category 6"));
        defaultCategoryDataset.addValue(2.0, (Comparable)((Object)"S2"), (Comparable)((Object)"Category 7"));
        defaultCategoryDataset.addValue(1.0, (Comparable)((Object)"S2"), (Comparable)((Object)"Category 8"));
        StandardCategoryItemLabelGenerator standardCategoryItemLabelGenerator = new StandardCategoryItemLabelGenerator();
        BarRenderer barRenderer = new BarRenderer();
        barRenderer.setBaseItemLabelGenerator((CategoryItemLabelGenerator)standardCategoryItemLabelGenerator);
        barRenderer.setBaseItemLabelsVisible(true);
        CategoryPlot categoryPlot = new CategoryPlot();
        categoryPlot.setDataset((CategoryDataset)defaultCategoryDataset);
        categoryPlot.setRenderer((CategoryItemRenderer)barRenderer);
        categoryPlot.setDomainAxis(new CategoryAxis("Category"));
        categoryPlot.setRangeAxis((ValueAxis)new NumberAxis("Value"));
        categoryPlot.setOrientation(PlotOrientation.VERTICAL);
        categoryPlot.setRangeGridlinesVisible(true);
        categoryPlot.setDomainGridlinesVisible(true);
        DefaultCategoryDataset defaultCategoryDataset2 = new DefaultCategoryDataset();
        defaultCategoryDataset2.addValue(9.0, (Comparable)((Object)"T1"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset2.addValue(7.0, (Comparable)((Object)"T1"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset2.addValue(2.0, (Comparable)((Object)"T1"), (Comparable)((Object)"Category 3"));
        defaultCategoryDataset2.addValue(6.0, (Comparable)((Object)"T1"), (Comparable)((Object)"Category 4"));
        defaultCategoryDataset2.addValue(6.0, (Comparable)((Object)"T1"), (Comparable)((Object)"Category 5"));
        defaultCategoryDataset2.addValue(9.0, (Comparable)((Object)"T1"), (Comparable)((Object)"Category 6"));
        defaultCategoryDataset2.addValue(5.0, (Comparable)((Object)"T1"), (Comparable)((Object)"Category 7"));
        defaultCategoryDataset2.addValue(4.0, (Comparable)((Object)"T1"), (Comparable)((Object)"Category 8"));
        LineAndShapeRenderer lineAndShapeRenderer = new LineAndShapeRenderer();
        categoryPlot.setDataset(1, (CategoryDataset)defaultCategoryDataset2);
        categoryPlot.setRenderer(1, (CategoryItemRenderer)lineAndShapeRenderer);
        NumberAxis numberAxis = new NumberAxis("Axis 2");
        categoryPlot.setRangeAxis(1, (ValueAxis)numberAxis);
        DefaultCategoryDataset defaultCategoryDataset3 = new DefaultCategoryDataset();
        defaultCategoryDataset3.addValue(94.0, (Comparable)((Object)"R1"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset3.addValue(75.0, (Comparable)((Object)"R1"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset3.addValue(22.0, (Comparable)((Object)"R1"), (Comparable)((Object)"Category 3"));
        defaultCategoryDataset3.addValue(74.0, (Comparable)((Object)"R1"), (Comparable)((Object)"Category 4"));
        defaultCategoryDataset3.addValue(83.0, (Comparable)((Object)"R1"), (Comparable)((Object)"Category 5"));
        defaultCategoryDataset3.addValue(9.0, (Comparable)((Object)"R1"), (Comparable)((Object)"Category 6"));
        defaultCategoryDataset3.addValue(23.0, (Comparable)((Object)"R1"), (Comparable)((Object)"Category 7"));
        defaultCategoryDataset3.addValue(98.0, (Comparable)((Object)"R1"), (Comparable)((Object)"Category 8"));
        categoryPlot.setDataset(2, (CategoryDataset)defaultCategoryDataset3);
        LineAndShapeRenderer lineAndShapeRenderer2 = new LineAndShapeRenderer();
        categoryPlot.setRenderer(2, (CategoryItemRenderer)lineAndShapeRenderer2);
        categoryPlot.mapDatasetToRangeAxis(2, 1);
        categoryPlot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
        categoryPlot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        JFreeChart jFreeChart = new JFreeChart((Plot)categoryPlot);
        jFreeChart.setTitle("Overlaid Bar Chart");
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = OverlaidBarChartDemo1.createChart();
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.addChartMouseListener(new ChartMouseListener(){

            public void chartMouseClicked(ChartMouseEvent chartMouseEvent) {
                System.out.println((Object)chartMouseEvent.getEntity());
            }

            public void chartMouseMoved(ChartMouseEvent chartMouseEvent) {
            }
        });
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        OverlaidBarChartDemo1 overlaidBarChartDemo1 = new OverlaidBarChartDemo1("JFreeChart: OverlaidBarChartDemo1.java");
        overlaidBarChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)overlaidBarChartDemo1));
        overlaidBarChartDemo1.setVisible(true);
    }

}

