/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import demo.DemoPanel;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StackedBarChart3DDemo5
extends ApplicationFrame {
    private static int CHART_COUNT = 4;

    public StackedBarChart3DDemo5(String string) {
        super(string);
        this.setContentPane((Container)StackedBarChart3DDemo5.createDemoPanel());
    }

    private static CategoryDataset createDataset(int n) {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(1.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue(2.0, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset.addValue(1.5, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Category 3"));
        defaultCategoryDataset.addValue(1.5, (Comparable)((Object)"Series 1"), (Comparable)((Object)"Category 4"));
        defaultCategoryDataset.addValue(-1.0, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue(-1.9, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset.addValue(-1.5, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Category 3"));
        defaultCategoryDataset.addValue(-1.5, (Comparable)((Object)"Series 2"), (Comparable)((Object)"Category 4"));
        defaultCategoryDataset.addValue(1.0, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Category 1"));
        defaultCategoryDataset.addValue(1.9, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Category 2"));
        defaultCategoryDataset.addValue(1.5, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Category 3"));
        defaultCategoryDataset.addValue(1.5, (Comparable)((Object)"Series 3"), (Comparable)((Object)"Category 4"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart(int n, CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createStackedBarChart3D((String)("Chart " + (n + 1)), (String)"Category", (String)"Value", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)false, (boolean)false, (boolean)false);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.getDomainAxis().setMaximumCategoryLabelLines(2);
        ValueAxis valueAxis = categoryPlot.getRangeAxis();
        valueAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        return new MyDemoPanel();
    }

    public static void main(String[] arrstring) {
        StackedBarChart3DDemo5 stackedBarChart3DDemo5 = new StackedBarChart3DDemo5("JFreeChart - Stacked Bar Chart 3D Demo 5");
        stackedBarChart3DDemo5.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)stackedBarChart3DDemo5));
        stackedBarChart3DDemo5.setVisible(true);
    }

    static class MyDemoPanel
    extends DemoPanel {
        private CategoryDataset[] datasets = new CategoryDataset[StackedBarChart3DDemo5.access$000()];
        private JFreeChart[] charts = new JFreeChart[StackedBarChart3DDemo5.access$000()];
        private ChartPanel[] panels = new ChartPanel[StackedBarChart3DDemo5.access$000()];

        public MyDemoPanel() {
            super(new GridLayout(2, 2));
            for (int i = 0; i < CHART_COUNT; ++i) {
                this.datasets[i] = StackedBarChart3DDemo5.createDataset(i);
                this.charts[i] = StackedBarChart3DDemo5.createChart(i, this.datasets[i]);
                this.addChart(this.charts[i]);
                this.panels[i] = new ChartPanel(this.charts[i]);
            }
            CategoryPlot categoryPlot = (CategoryPlot)this.charts[1].getPlot();
            CategoryPlot categoryPlot2 = (CategoryPlot)this.charts[2].getPlot();
            CategoryPlot categoryPlot3 = (CategoryPlot)this.charts[3].getPlot();
            categoryPlot.getRangeAxis().setInverted(true);
            categoryPlot3.getRangeAxis().setInverted(true);
            categoryPlot2.setOrientation(PlotOrientation.HORIZONTAL);
            categoryPlot3.setOrientation(PlotOrientation.HORIZONTAL);
            this.add((Component)this.panels[0]);
            this.add((Component)this.panels[1]);
            this.add((Component)this.panels[2]);
            this.add((Component)this.panels[3]);
            this.setPreferredSize(new Dimension(800, 600));
        }
    }

}

