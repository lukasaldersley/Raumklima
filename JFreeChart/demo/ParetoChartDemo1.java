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
 *  org.jfree.chart.plot.DatasetRenderingOrder
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.renderer.category.LineAndShapeRenderer
 *  org.jfree.chart.title.TextTitle
 *  org.jfree.chart.title.Title
 *  org.jfree.data.DataUtilities
 *  org.jfree.data.DefaultKeyedValues
 *  org.jfree.data.KeyedValues
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.general.DatasetUtilities
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.HorizontalAlignment
 *  org.jfree.ui.RectangleEdge
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.util.SortOrder
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.text.NumberFormat;
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
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.SortOrder;

public class ParetoChartDemo1
extends ApplicationFrame {
    public ParetoChartDemo1(String string) {
        super(string);
        JPanel jPanel = ParetoChartDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(550, 270));
        this.setContentPane((Container)jPanel);
    }

    public static JFreeChart createChart(CategoryDataset[] arrcategoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createBarChart((String)"TIOBE Index of Programming Languages", (String)null, (String)"Index Value", (CategoryDataset)arrcategoryDataset[0]);
        jFreeChart.addSubtitle((Title)new TextTitle("As at August 2013"));
        jFreeChart.removeLegend();
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
        categoryAxis.setLowerMargin(0.02);
        categoryAxis.setUpperMargin(0.02);
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        LineAndShapeRenderer lineAndShapeRenderer = new LineAndShapeRenderer();
        NumberAxis numberAxis2 = new NumberAxis("Percent");
        numberAxis2.setNumberFormatOverride(NumberFormat.getPercentInstance());
        categoryPlot.setRangeAxis(1, (ValueAxis)numberAxis2);
        categoryPlot.setDataset(1, arrcategoryDataset[1]);
        categoryPlot.setRenderer(1, (CategoryItemRenderer)lineAndShapeRenderer);
        categoryPlot.mapDatasetToRangeAxis(1, 1);
        categoryPlot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        TextTitle textTitle = new TextTitle("http://www.tiobe.com/index.php/content/paperinfo/tpci/index.html", new Font("Monospaced", 0, 10));
        textTitle.setPosition(RectangleEdge.BOTTOM);
        textTitle.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        jFreeChart.addSubtitle((Title)textTitle);
        return jFreeChart;
    }

    public static CategoryDataset[] createDatasets() {
        DefaultKeyedValues defaultKeyedValues = new DefaultKeyedValues();
        defaultKeyedValues.addValue((Comparable)((Object)"C"), 15.974);
        defaultKeyedValues.addValue((Comparable)((Object)"C++"), 9.371);
        defaultKeyedValues.addValue((Comparable)((Object)"C#"), 6.117);
        defaultKeyedValues.addValue((Comparable)((Object)"Java"), 15.978);
        defaultKeyedValues.addValue((Comparable)((Object)"Javascript"), 2.093);
        defaultKeyedValues.addValue((Comparable)((Object)"Obj-C"), 8.082);
        defaultKeyedValues.addValue((Comparable)((Object)"PHP"), 6.694);
        defaultKeyedValues.addValue((Comparable)((Object)"Python"), 3.603);
        defaultKeyedValues.addValue((Comparable)((Object)"Ruby"), 2.067);
        defaultKeyedValues.addValue((Comparable)((Object)"VB"), 3.873);
        defaultKeyedValues.sortByValues(SortOrder.DESCENDING);
        KeyedValues keyedValues = DataUtilities.getCumulativePercentages((KeyedValues)defaultKeyedValues);
        CategoryDataset categoryDataset = DatasetUtilities.createCategoryDataset((Comparable)((Object)"Languages"), (KeyedValues)defaultKeyedValues);
        CategoryDataset categoryDataset2 = DatasetUtilities.createCategoryDataset((Comparable)((Object)"Cumulative"), (KeyedValues)keyedValues);
        return new CategoryDataset[]{categoryDataset, categoryDataset2};
    }

    public static JPanel createDemoPanel() {
        CategoryDataset[] arrcategoryDataset = ParetoChartDemo1.createDatasets();
        JFreeChart jFreeChart = ParetoChartDemo1.createChart(arrcategoryDataset);
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        ParetoChartDemo1 paretoChartDemo1 = new ParetoChartDemo1("JFreeChart: ParetoChartDemo1.java");
        paretoChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)paretoChartDemo1));
        paretoChartDemo1.setVisible(true);
    }
}

