/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartMouseEvent
 *  org.jfree.chart.ChartMouseListener
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.entity.ChartEntity
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.io.PrintStream;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class MouseListenerDemo2
extends ApplicationFrame
implements ChartMouseListener {
    public MouseListenerDemo2(String string) {
        super(string);
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(1.0, (Comparable)((Object)"S1"), (Comparable)((Object)"C1"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"S1"), (Comparable)((Object)"C2"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"S1"), (Comparable)((Object)"C3"));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)"S1"), (Comparable)((Object)"C4"));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)"S1"), (Comparable)((Object)"C5"));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)"S1"), (Comparable)((Object)"C6"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"S1"), (Comparable)((Object)"C7"));
        defaultCategoryDataset.addValue(8.0, (Comparable)((Object)"S1"), (Comparable)((Object)"C8"));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)"S2"), (Comparable)((Object)"C1"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"S2"), (Comparable)((Object)"C2"));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)"S2"), (Comparable)((Object)"C3"));
        defaultCategoryDataset.addValue(8.0, (Comparable)((Object)"S2"), (Comparable)((Object)"C4"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"S2"), (Comparable)((Object)"C5"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"S2"), (Comparable)((Object)"C6"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"S2"), (Comparable)((Object)"C7"));
        defaultCategoryDataset.addValue(1.0, (Comparable)((Object)"S2"), (Comparable)((Object)"C8"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"S3"), (Comparable)((Object)"C1"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"S3"), (Comparable)((Object)"C2"));
        defaultCategoryDataset.addValue(2.0, (Comparable)((Object)"S3"), (Comparable)((Object)"C3"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"S3"), (Comparable)((Object)"C4"));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)"S3"), (Comparable)((Object)"C5"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"S3"), (Comparable)((Object)"C6"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"S3"), (Comparable)((Object)"C7"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"S3"), (Comparable)((Object)"C8"));
        JFreeChart jFreeChart = ChartFactory.createBarChart((String)"MouseListenerDemo2", (String)"Category", (String)"Value", (CategoryDataset)defaultCategoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.addChartMouseListener((ChartMouseListener)this);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)chartPanel);
    }

    public void chartMouseClicked(ChartMouseEvent chartMouseEvent) {
        ChartEntity chartEntity = chartMouseEvent.getEntity();
        if (chartEntity != null) {
            System.out.println("Mouse clicked: " + chartEntity.toString());
        } else {
            System.out.println("Mouse clicked: null entity.");
        }
    }

    public void chartMouseMoved(ChartMouseEvent chartMouseEvent) {
        int n = chartMouseEvent.getTrigger().getX();
        int n2 = chartMouseEvent.getTrigger().getY();
        ChartEntity chartEntity = chartMouseEvent.getEntity();
        if (chartEntity != null) {
            System.out.println("Mouse moved: " + n + ", " + n2 + ": " + chartEntity.toString());
        } else {
            System.out.println("Mouse moved: " + n + ", " + n2 + ": null entity.");
        }
    }

    public static void main(String[] arrstring) {
        MouseListenerDemo2 mouseListenerDemo2 = new MouseListenerDemo2("JFreeChart: MouseListenerDemo2.java");
        mouseListenerDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)mouseListenerDemo2));
        mouseListenerDemo2.setVisible(true);
    }
}

