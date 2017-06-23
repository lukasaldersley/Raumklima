/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.Chart3D
 *  com.orsoncharts.Chart3DPanel
 *  com.orsoncharts.data.PieDataset3D
 *  com.orsoncharts.graphics3d.RenderedElement
 *  com.orsoncharts.graphics3d.swing.DisplayPanel3D
 *  com.orsoncharts.graphics3d.swing.Panel3D
 *  com.orsoncharts.interaction.Chart3DMouseEvent
 *  com.orsoncharts.interaction.Chart3DMouseListener
 */
package demo.orsoncharts.swing;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.data.PieDataset3D;
import com.orsoncharts.graphics3d.RenderedElement;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;
import com.orsoncharts.graphics3d.swing.Panel3D;
import com.orsoncharts.interaction.Chart3DMouseEvent;
import com.orsoncharts.interaction.Chart3DMouseListener;
import demo.orsoncharts.PieChart3D1;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PieChart3DDemo1
extends JFrame {
    public PieChart3DDemo1(String string) {
        super(string);
        this.addWindowListener(new ExitOnClose());
        this.getContentPane().add(PieChart3DDemo1.createDemoPanel());
    }

    public static JPanel createDemoPanel() {
        final DemoPanel demoPanel = new DemoPanel(new BorderLayout());
        demoPanel.setPreferredSize(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        PieDataset3D pieDataset3D = PieChart3D1.createDataset();
        Chart3D chart3D = PieChart3D1.createChart(pieDataset3D);
        Chart3DPanel chart3DPanel = new Chart3DPanel(chart3D);
        chart3DPanel.setMargin(0.05);
        chart3DPanel.addChartMouseListener(new Chart3DMouseListener(){

            public void chartMouseClicked(Chart3DMouseEvent chart3DMouseEvent) {
                RenderedElement renderedElement = chart3DMouseEvent.getElement();
                if (renderedElement != null) {
                    JOptionPane.showMessageDialog(demoPanel, Chart3D.renderedElementToString((RenderedElement)chart3DMouseEvent.getElement()));
                }
            }

            public void chartMouseMoved(Chart3DMouseEvent chart3DMouseEvent) {
            }
        });
        demoPanel.setChartPanel(chart3DPanel);
        demoPanel.add((Component)new DisplayPanel3D((Panel3D)chart3DPanel));
        chart3DPanel.zoomToFit((Dimension2D)OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        return demoPanel;
    }

    public static void main(String[] arrstring) {
        PieChart3DDemo1 pieChart3DDemo1 = new PieChart3DDemo1("OrsonCharts: PieChart3DDemo1.java");
        pieChart3DDemo1.pack();
        pieChart3DDemo1.setVisible(true);
    }

}

