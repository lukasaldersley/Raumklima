/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberTickUnit
 *  org.jfree.chart.axis.TickUnit
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.TickUnits
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.CategoryItemLabelGenerator
 *  org.jfree.chart.labels.CategoryToolTipGenerator
 *  org.jfree.chart.labels.StandardCategoryItemLabelGenerator
 *  org.jfree.chart.labels.StandardCategoryToolTipGenerator
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.renderer.category.BarRenderer
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.TickUnit;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.TickUnits;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class WaterfallChartDemo1
extends ApplicationFrame {
    public WaterfallChartDemo1(String string) {
        super(string);
        JPanel jPanel = WaterfallChartDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(15.76, (Comparable)((Object)"Product 1"), (Comparable)((Object)"Labour"));
        defaultCategoryDataset.addValue(8.66, (Comparable)((Object)"Product 1"), (Comparable)((Object)"Administration"));
        defaultCategoryDataset.addValue(4.71, (Comparable)((Object)"Product 1"), (Comparable)((Object)"Marketing"));
        defaultCategoryDataset.addValue(3.51, (Comparable)((Object)"Product 1"), (Comparable)((Object)"Distribution"));
        defaultCategoryDataset.addValue(32.64, (Comparable)((Object)"Product 1"), (Comparable)((Object)"Total Expense"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createWaterfallChart((String)"Product Cost Breakdown", (String)"Expense Category", (String)"Cost Per Unit", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)false, (boolean)true, (boolean)false);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        ValueAxis valueAxis = categoryPlot.getRangeAxis();
        DecimalFormat decimalFormat = new DecimalFormat("##,###");
        decimalFormat.setNegativePrefix("(");
        decimalFormat.setNegativeSuffix(")");
        TickUnits tickUnits = new TickUnits();
        tickUnits.add((TickUnit)new NumberTickUnit(5.0, (NumberFormat)decimalFormat));
        tickUnits.add((TickUnit)new NumberTickUnit(10.0, (NumberFormat)decimalFormat));
        tickUnits.add((TickUnit)new NumberTickUnit(20.0, (NumberFormat)decimalFormat));
        tickUnits.add((TickUnit)new NumberTickUnit(50.0, (NumberFormat)decimalFormat));
        tickUnits.add((TickUnit)new NumberTickUnit(100.0, (NumberFormat)decimalFormat));
        tickUnits.add((TickUnit)new NumberTickUnit(200.0, (NumberFormat)decimalFormat));
        tickUnits.add((TickUnit)new NumberTickUnit(500.0, (NumberFormat)decimalFormat));
        tickUnits.add((TickUnit)new NumberTickUnit(1000.0, (NumberFormat)decimalFormat));
        tickUnits.add((TickUnit)new NumberTickUnit(2000.0, (NumberFormat)decimalFormat));
        tickUnits.add((TickUnit)new NumberTickUnit(5000.0, (NumberFormat)decimalFormat));
        valueAxis.setStandardTickUnits((TickUnitSource)tickUnits);
        BarRenderer barRenderer = (BarRenderer)categoryPlot.getRenderer();
        barRenderer.setDrawBarOutline(false);
        barRenderer.setBase(5.0);
        DecimalFormat decimalFormat2 = new DecimalFormat("$##,###.00");
        decimalFormat2.setNegativePrefix("(");
        decimalFormat2.setNegativeSuffix(")");
        barRenderer.setBaseItemLabelGenerator((CategoryItemLabelGenerator)new StandardCategoryItemLabelGenerator("{2}", (NumberFormat)decimalFormat2));
        barRenderer.setBaseToolTipGenerator((CategoryToolTipGenerator)new StandardCategoryToolTipGenerator("{0}, {1}) = {2}", (NumberFormat)new DecimalFormat("$##,###.00")));
        barRenderer.setBaseItemLabelsVisible(true);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        return new ChartPanel(WaterfallChartDemo1.createChart(WaterfallChartDemo1.createDataset()));
    }

    public static void main(String[] arrstring) {
        WaterfallChartDemo1 waterfallChartDemo1 = new WaterfallChartDemo1("JFreeChart: WaterfallChartDemo1.java");
        waterfallChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)waterfallChartDemo1));
        waterfallChartDemo1.setVisible(true);
    }
}

