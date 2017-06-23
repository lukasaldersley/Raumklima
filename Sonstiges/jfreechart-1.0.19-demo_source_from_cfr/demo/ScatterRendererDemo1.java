/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.renderer.category.ScatterRenderer
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.statistics.DefaultMultiValueCategoryDataset
 *  org.jfree.data.statistics.MultiValueCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RectangleInsets
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.ScatterRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.statistics.DefaultMultiValueCategoryDataset;
import org.jfree.data.statistics.MultiValueCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class ScatterRendererDemo1
extends ApplicationFrame {
    public ScatterRendererDemo1(String string) {
        super(string);
        JPanel jPanel = ScatterRendererDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static List listOfValues(double[] arrd) {
        ArrayList<Double> arrayList = new ArrayList<Double>();
        for (int i = 0; i < arrd.length; ++i) {
            arrayList.add(new Double(arrd[i]));
        }
        return arrayList;
    }

    private static MultiValueCategoryDataset createDataset() {
        DefaultMultiValueCategoryDataset defaultMultiValueCategoryDataset = new DefaultMultiValueCategoryDataset();
        defaultMultiValueCategoryDataset.add(ScatterRendererDemo1.listOfValues(new double[]{1.0, 2.0, 3.0}), (Comparable)((Object)"Series 1"), (Comparable)((Object)"C1"));
        defaultMultiValueCategoryDataset.add(ScatterRendererDemo1.listOfValues(new double[]{1.2, 2.2, 3.2}), (Comparable)((Object)"Series 1"), (Comparable)((Object)"C2"));
        defaultMultiValueCategoryDataset.add(ScatterRendererDemo1.listOfValues(new double[]{1.4, 2.4, 3.4}), (Comparable)((Object)"Series 1"), (Comparable)((Object)"C3"));
        defaultMultiValueCategoryDataset.add(ScatterRendererDemo1.listOfValues(new double[]{1.0, 3.0}), (Comparable)((Object)"Series 2"), (Comparable)((Object)"C1"));
        defaultMultiValueCategoryDataset.add(ScatterRendererDemo1.listOfValues(new double[]{1.2, 3.2}), (Comparable)((Object)"Series 2"), (Comparable)((Object)"C2"));
        defaultMultiValueCategoryDataset.add(ScatterRendererDemo1.listOfValues(new double[]{1.4, 3.6}), (Comparable)((Object)"Series 2"), (Comparable)((Object)"C3"));
        return defaultMultiValueCategoryDataset;
    }

    private static JFreeChart createChart(MultiValueCategoryDataset multiValueCategoryDataset) {
        CategoryPlot categoryPlot = new CategoryPlot((CategoryDataset)multiValueCategoryDataset, new CategoryAxis("Category"), (ValueAxis)new NumberAxis("Value"), (CategoryItemRenderer)new ScatterRenderer());
        categoryPlot.setBackgroundPaint((Paint)Color.lightGray);
        categoryPlot.setDomainGridlinePaint((Paint)Color.white);
        categoryPlot.setRangeGridlinePaint((Paint)Color.white);
        categoryPlot.setAxisOffset(new RectangleInsets(4.0, 4.0, 4.0, 4.0));
        JFreeChart jFreeChart = new JFreeChart("ScatterRendererDemo1", (Plot)categoryPlot);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = ScatterRendererDemo1.createChart(ScatterRendererDemo1.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        ScatterRendererDemo1 scatterRendererDemo1 = new ScatterRendererDemo1("JFreeChart: ScatterRendererDemo1.java");
        scatterRendererDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)scatterRendererDemo1));
        scatterRendererDemo1.setVisible(true);
    }
}

