/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.Chart3D
 *  com.orsoncharts.Chart3DPanel
 *  com.orsoncharts.data.xyz.XYZDataset
 *  com.orsoncharts.graphics3d.swing.DisplayPanel3D
 *  com.orsoncharts.graphics3d.swing.Panel3D
 */
package demo.orsoncharts.swing;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.data.xyz.XYZDataset;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;
import com.orsoncharts.graphics3d.swing.Panel3D;
import demo.orsoncharts.XYZBarChart3D1;
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

public class XYZBarChart3DDemo1
extends JFrame {
    public XYZBarChart3DDemo1(String string) {
        super(string);
        this.addWindowListener(new ExitOnClose());
        this.getContentPane().add(XYZBarChart3DDemo1.createDemoPanel());
    }

    public static JPanel createDemoPanel() {
        DemoPanel demoPanel = new DemoPanel(new BorderLayout());
        demoPanel.setPreferredSize(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        XYZDataset xYZDataset = XYZBarChart3D1.createDataset();
        Chart3D chart3D = XYZBarChart3D1.createChart(xYZDataset);
        Chart3DPanel chart3DPanel = new Chart3DPanel(chart3D);
        demoPanel.setChartPanel(chart3DPanel);
        chart3DPanel.zoomToFit((Dimension2D)OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        demoPanel.add((Component)new DisplayPanel3D((Panel3D)chart3DPanel));
        return demoPanel;
    }

    public static void main(String[] arrstring) {
        XYZBarChart3DDemo1 xYZBarChart3DDemo1 = new XYZBarChart3DDemo1("OrsonCharts: XYZBarChart3DDemo1.java");
        xYZBarChart3DDemo1.pack();
        xYZBarChart3DDemo1.setVisible(true);
    }
}

