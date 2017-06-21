/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.LegendItemSource
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.axis.CategoryLabelPositions
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.block.Arrangement
 *  org.jfree.chart.block.Block
 *  org.jfree.chart.block.BlockBorder
 *  org.jfree.chart.block.BlockContainer
 *  org.jfree.chart.block.BlockFrame
 *  org.jfree.chart.block.BorderArrangement
 *  org.jfree.chart.block.EmptyBlock
 *  org.jfree.chart.labels.CategoryToolTipGenerator
 *  org.jfree.chart.labels.StandardCategoryToolTipGenerator
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.DatasetRenderingOrder
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.renderer.category.LineAndShapeRenderer
 *  org.jfree.chart.title.CompositeTitle
 *  org.jfree.chart.title.LegendTitle
 *  org.jfree.chart.title.Title
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RectangleEdge
 *  org.jfree.ui.RectangleInsets
 *  org.jfree.ui.RefineryUtilities
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
import org.jfree.chart.LegendItemSource;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.block.Arrangement;
import org.jfree.chart.block.Block;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.BlockFrame;
import org.jfree.chart.block.BorderArrangement;
import org.jfree.chart.block.EmptyBlock;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.CompositeTitle;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class DualAxisDemo1
extends ApplicationFrame {
    public DualAxisDemo1(String string) {
        super(string);
        JPanel jPanel = DualAxisDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset1() {
        String string = "S1";
        String string2 = "S2";
        String string3 = "S3";
        String string4 = "Category 1";
        String string5 = "Category 2";
        String string6 = "Category 3";
        String string7 = "Category 4";
        String string8 = "Category 5";
        String string9 = "Category 6";
        String string10 = "Category 7";
        String string11 = "Category 8";
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(1.0, (Comparable)((Object)string), (Comparable)((Object)string4));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)string), (Comparable)((Object)string5));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)string), (Comparable)((Object)string6));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)string), (Comparable)((Object)string7));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)string), (Comparable)((Object)string8));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)string), (Comparable)((Object)string9));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)string), (Comparable)((Object)string10));
        defaultCategoryDataset.addValue(8.0, (Comparable)((Object)string), (Comparable)((Object)string11));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)string2), (Comparable)((Object)string4));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)string2), (Comparable)((Object)string5));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)string2), (Comparable)((Object)string6));
        defaultCategoryDataset.addValue(8.0, (Comparable)((Object)string2), (Comparable)((Object)string7));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)string2), (Comparable)((Object)string8));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)string2), (Comparable)((Object)string9));
        defaultCategoryDataset.addValue(2.0, (Comparable)((Object)string2), (Comparable)((Object)string10));
        defaultCategoryDataset.addValue(1.0, (Comparable)((Object)string2), (Comparable)((Object)string11));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)string3), (Comparable)((Object)string4));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)string3), (Comparable)((Object)string5));
        defaultCategoryDataset.addValue(2.0, (Comparable)((Object)string3), (Comparable)((Object)string6));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)string3), (Comparable)((Object)string7));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)string3), (Comparable)((Object)string8));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)string3), (Comparable)((Object)string9));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)string3), (Comparable)((Object)string10));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)string3), (Comparable)((Object)string11));
        return defaultCategoryDataset;
    }

    private static CategoryDataset createDataset2() {
        String string = "S4";
        String string2 = "Category 1";
        String string3 = "Category 2";
        String string4 = "Category 3";
        String string5 = "Category 4";
        String string6 = "Category 5";
        String string7 = "Category 6";
        String string8 = "Category 7";
        String string9 = "Category 8";
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(15.0, (Comparable)((Object)string), (Comparable)((Object)string2));
        defaultCategoryDataset.addValue(24.0, (Comparable)((Object)string), (Comparable)((Object)string3));
        defaultCategoryDataset.addValue(31.0, (Comparable)((Object)string), (Comparable)((Object)string4));
        defaultCategoryDataset.addValue(25.0, (Comparable)((Object)string), (Comparable)((Object)string5));
        defaultCategoryDataset.addValue(56.0, (Comparable)((Object)string), (Comparable)((Object)string6));
        defaultCategoryDataset.addValue(37.0, (Comparable)((Object)string), (Comparable)((Object)string7));
        defaultCategoryDataset.addValue(77.0, (Comparable)((Object)string), (Comparable)((Object)string8));
        defaultCategoryDataset.addValue(18.0, (Comparable)((Object)string), (Comparable)((Object)string9));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart() {
        JFreeChart jFreeChart = ChartFactory.createBarChart((String)"DualAxisDemo1", (String)"Category", (String)"Value", (CategoryDataset)DualAxisDemo1.createDataset1(), (PlotOrientation)PlotOrientation.VERTICAL, (boolean)false, (boolean)true, (boolean)false);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        CategoryDataset categoryDataset = DualAxisDemo1.createDataset2();
        categoryPlot.setDataset(1, categoryDataset);
        categoryPlot.mapDatasetToRangeAxis(1, 1);
        CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
        NumberAxis numberAxis = new NumberAxis("Secondary");
        categoryPlot.setRangeAxis(1, (ValueAxis)numberAxis);
        LineAndShapeRenderer lineAndShapeRenderer = new LineAndShapeRenderer();
        lineAndShapeRenderer.setBaseToolTipGenerator((CategoryToolTipGenerator)new StandardCategoryToolTipGenerator());
        categoryPlot.setRenderer(1, (CategoryItemRenderer)lineAndShapeRenderer);
        categoryPlot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
        LegendTitle legendTitle = new LegendTitle((LegendItemSource)categoryPlot.getRenderer(0));
        legendTitle.setMargin(new RectangleInsets(2.0, 2.0, 2.0, 2.0));
        legendTitle.setFrame((BlockFrame)new BlockBorder());
        LegendTitle legendTitle2 = new LegendTitle((LegendItemSource)categoryPlot.getRenderer(1));
        legendTitle2.setMargin(new RectangleInsets(2.0, 2.0, 2.0, 2.0));
        legendTitle2.setFrame((BlockFrame)new BlockBorder());
        BlockContainer blockContainer = new BlockContainer((Arrangement)new BorderArrangement());
        blockContainer.add((Block)legendTitle, (Object)RectangleEdge.LEFT);
        blockContainer.add((Block)legendTitle2, (Object)RectangleEdge.RIGHT);
        blockContainer.add((Block)new EmptyBlock(2000.0, 0.0));
        CompositeTitle compositeTitle = new CompositeTitle(blockContainer);
        compositeTitle.setPosition(RectangleEdge.BOTTOM);
        jFreeChart.addSubtitle((Title)compositeTitle);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = DualAxisDemo1.createChart();
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        DualAxisDemo1 dualAxisDemo1 = new DualAxisDemo1("JFreeChart: DualAxisDemo1.java");
        dualAxisDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)dualAxisDemo1));
        dualAxisDemo1.setVisible(true);
    }
}

