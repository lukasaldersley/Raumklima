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
 *  org.jfree.data.general.DefaultPieDataset
 *  org.jfree.data.general.PieDataset
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
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class MouseListenerDemo1
extends ApplicationFrame
implements ChartMouseListener {
    public MouseListenerDemo1(String string) {
        super(string);
        DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
        defaultPieDataset.setValue((Comparable)((Object)"Java"), (Number)new Double(43.2));
        defaultPieDataset.setValue((Comparable)((Object)"Visual Basic"), (Number)new Double(0.0));
        defaultPieDataset.setValue((Comparable)((Object)"C/C++"), (Number)new Double(17.5));
        JFreeChart jFreeChart = ChartFactory.createPieChart((String)"MouseListenerDemo1", (PieDataset)defaultPieDataset, (boolean)true, (boolean)true, (boolean)false);
        ChartPanel chartPanel = new ChartPanel(jFreeChart, false, false, false, false, false);
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
        MouseListenerDemo1 mouseListenerDemo1 = new MouseListenerDemo1("JFreeChart: MouseListenerDemo1.java");
        mouseListenerDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)mouseListenerDemo1));
        mouseListenerDemo1.setVisible(true);
    }
}

