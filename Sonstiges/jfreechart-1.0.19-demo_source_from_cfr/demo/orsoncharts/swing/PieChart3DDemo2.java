/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.Chart3D
 *  com.orsoncharts.Chart3DPanel
 *  com.orsoncharts.data.PieDataset3D
 *  com.orsoncharts.graphics3d.swing.DisplayPanel3D
 *  com.orsoncharts.graphics3d.swing.Panel3D
 *  com.orsoncharts.plot.PiePlot3D
 *  com.orsoncharts.plot.Plot3D
 */
package demo.orsoncharts.swing;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.data.PieDataset3D;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;
import com.orsoncharts.graphics3d.swing.Panel3D;
import com.orsoncharts.plot.PiePlot3D;
import com.orsoncharts.plot.Plot3D;
import demo.orsoncharts.PieChart3D2;
import demo.orsoncharts.swing.DemoPanel;
import demo.orsoncharts.swing.ExitOnClose;
import demo.orsoncharts.swing.OrsonChartsDemo;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.geom.Dimension2D;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PieChart3DDemo2
extends JFrame {
    public static JPanel createDemoPanel() {
        DemoPanel demoPanel = new DemoPanel(new BorderLayout());
        demoPanel.setPreferredSize(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        PieDataset3D pieDataset3D = PieChart3D2.createDataset();
        final Chart3D chart3D = PieChart3D2.createChart(pieDataset3D);
        Chart3DPanel chart3DPanel = new Chart3DPanel(chart3D);
        chart3DPanel.setMargin(0.15);
        demoPanel.setChartPanel(chart3DPanel);
        chart3DPanel.zoomToFit((Dimension2D)OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        demoPanel.add((Component)new DisplayPanel3D((Panel3D)chart3DPanel));
        JButton jButton = new JButton("Change the Data");
        jButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                PieDataset3D pieDataset3D = PieChart3D2.createDataset();
                PiePlot3D piePlot3D = (PiePlot3D)chart3D.getPlot();
                piePlot3D.setDataset(pieDataset3D);
            }
        });
        demoPanel.add((Component)jButton, "South");
        return demoPanel;
    }

    public PieChart3DDemo2(String string) {
        super(string);
        this.addWindowListener(new ExitOnClose());
        this.getContentPane().add(PieChart3DDemo2.createDemoPanel());
    }

    public static void main(String[] arrstring) {
        PieChart3DDemo2 pieChart3DDemo2 = new PieChart3DDemo2("OrsonCharts: PieChart3DDemo2.java");
        pieChart3DDemo2.pack();
        pieChart3DDemo2.setVisible(true);
    }

}

