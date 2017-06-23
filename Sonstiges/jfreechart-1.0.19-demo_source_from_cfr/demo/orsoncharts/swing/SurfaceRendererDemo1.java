/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.Chart3D
 *  com.orsoncharts.Chart3DPanel
 *  com.orsoncharts.graphics3d.swing.DisplayPanel3D
 *  com.orsoncharts.graphics3d.swing.Panel3D
 */
package demo.orsoncharts.swing;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;
import com.orsoncharts.graphics3d.swing.Panel3D;
import demo.orsoncharts.SurfaceRenderer1;
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

public class SurfaceRendererDemo1
extends JFrame {
    public SurfaceRendererDemo1(String string) {
        super(string);
        this.addWindowListener(new ExitOnClose());
        this.getContentPane().add(SurfaceRendererDemo1.createDemoPanel());
    }

    public static JPanel createDemoPanel() {
        DemoPanel demoPanel = new DemoPanel(new BorderLayout());
        demoPanel.setPreferredSize(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        Chart3D chart3D = SurfaceRenderer1.createChart();
        Chart3DPanel chart3DPanel = new Chart3DPanel(chart3D);
        chart3DPanel.zoomToFit((Dimension2D)OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        demoPanel.setChartPanel(chart3DPanel);
        demoPanel.add((Component)new DisplayPanel3D((Panel3D)chart3DPanel));
        return demoPanel;
    }

    public static void main(String[] arrstring) {
        SurfaceRendererDemo1 surfaceRendererDemo1 = new SurfaceRendererDemo1("OrsonCharts: SurfaceRendererDemo1.java");
        surfaceRendererDemo1.pack();
        surfaceRendererDemo1.setVisible(true);
    }
}

