/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.Chart3D
 *  com.orsoncharts.Chart3DPanel
 *  com.orsoncharts.data.category.CategoryDataset3D
 *  com.orsoncharts.graphics3d.swing.DisplayPanel3D
 *  com.orsoncharts.graphics3d.swing.Panel3D
 */
package demo.orsoncharts.swing;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.data.category.CategoryDataset3D;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;
import com.orsoncharts.graphics3d.swing.Panel3D;
import demo.orsoncharts.BarChart3D1;
import demo.orsoncharts.swing.DemoPanel;
import demo.orsoncharts.swing.ExitOnClose;
import demo.orsoncharts.swing.OrsonChartsDemo;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.WindowListener;
import java.awt.geom.Dimension2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BarChart3DDemo1
extends JFrame {
    public BarChart3DDemo1(String string) {
        super(string);
        this.addWindowListener(new ExitOnClose());
        this.getContentPane().add(BarChart3DDemo1.createDemoPanel());
    }

    public static JPanel createDemoPanel() {
        DemoPanel demoPanel = new DemoPanel(new BorderLayout());
        demoPanel.setPreferredSize(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        CategoryDataset3D categoryDataset3D = BarChart3D1.createDataset();
        Chart3D chart3D = BarChart3D1.createChart(categoryDataset3D);
        Chart3DPanel chart3DPanel = new Chart3DPanel(chart3D);
        chart3DPanel.setMargin(0.3);
        demoPanel.setChartPanel(chart3DPanel);
        chart3DPanel.zoomToFit((Dimension2D)OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        demoPanel.add((Component)new DisplayPanel3D((Panel3D)chart3DPanel));
        return demoPanel;
    }

    public static void main(String[] arrstring) {
        BarChart3DDemo1 barChart3DDemo1 = new BarChart3DDemo1("OrsonCharts: BarChart3DDemo1.java");
        barChart3DDemo1.pack();
        barChart3DDemo1.setVisible(true);
    }
}

