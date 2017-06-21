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
import demo.orsoncharts.AreaChart3D2;
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

public class AreaChart3DDemo2
extends JFrame {
    public AreaChart3DDemo2(String string) {
        super(string);
        this.addWindowListener(new ExitOnClose());
        this.getContentPane().add(AreaChart3DDemo2.createDemoPanel());
    }

    public static JPanel createDemoPanel() {
        DemoPanel demoPanel = new DemoPanel(new BorderLayout());
        demoPanel.setPreferredSize(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        CategoryDataset3D categoryDataset3D = AreaChart3D2.createDataset();
        Chart3D chart3D = AreaChart3D2.createChart(categoryDataset3D);
        Chart3DPanel chart3DPanel = new Chart3DPanel(chart3D);
        demoPanel.setChartPanel(chart3DPanel);
        demoPanel.add((Component)new DisplayPanel3D((Panel3D)chart3DPanel));
        chart3DPanel.zoomToFit((Dimension2D)OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        return demoPanel;
    }

    public static void main(String[] arrstring) {
        AreaChart3DDemo2 areaChart3DDemo2 = new AreaChart3DDemo2("OrsonCharts: AreaChart3DDemo2.java");
        areaChart3DDemo2.pack();
        areaChart3DDemo2.setVisible(true);
    }
}

