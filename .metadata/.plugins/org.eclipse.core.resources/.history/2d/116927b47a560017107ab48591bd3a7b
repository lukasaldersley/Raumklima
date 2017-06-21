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
import demo.orsoncharts.ScatterPlot3D3;
import demo.orsoncharts.swing.DemoPanel;
import demo.orsoncharts.swing.ExitOnClose;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.WindowListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ScatterPlot3DDemo3
extends JFrame {
    public ScatterPlot3DDemo3(String string) {
        super(string);
        this.addWindowListener(new ExitOnClose());
        this.getContentPane().add(ScatterPlot3DDemo3.createDemoPanel());
    }

    public static JPanel createDemoPanel() {
        DemoPanel demoPanel = new DemoPanel(new GridLayout(2, 2));
        XYZDataset[] arrxYZDataset = ScatterPlot3D3.createDatasets();
        Chart3D chart3D = ScatterPlot3D3.createChart("Iris Dataset : Combination 1", arrxYZDataset[0], "Sepal Length", "Sepal Width", "Petal Length");
        Chart3DPanel chart3DPanel = new Chart3DPanel(chart3D);
        chart3DPanel.setPreferredSize(new Dimension(10, 10));
        chart3DPanel.setBorder((Border)BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 0)), BorderFactory.createLineBorder(Color.DARK_GRAY)));
        chart3DPanel.setMargin(0.35);
        Chart3D chart3D2 = ScatterPlot3D3.createChart("Iris Dataset : Combination 2", arrxYZDataset[1], "Sepal Length", "Sepal Width", "Petal Width");
        Chart3DPanel chart3DPanel2 = new Chart3DPanel(chart3D2);
        chart3DPanel2.setPreferredSize(new Dimension(10, 10));
        chart3DPanel2.setBorder((Border)BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 0)), BorderFactory.createLineBorder(Color.DARK_GRAY)));
        chart3DPanel2.setMargin(0.35);
        Chart3D chart3D3 = ScatterPlot3D3.createChart("Iris Dataset : Combination 3", arrxYZDataset[2], "Sepal Length", "Petal Width", "Petal Length");
        Chart3DPanel chart3DPanel3 = new Chart3DPanel(chart3D3);
        chart3DPanel3.setPreferredSize(new Dimension(10, 10));
        chart3DPanel3.setBorder((Border)BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 0)), BorderFactory.createLineBorder(Color.DARK_GRAY)));
        chart3DPanel3.setMargin(0.35);
        Chart3D chart3D4 = ScatterPlot3D3.createChart("Iris Dataset : Combination 4", arrxYZDataset[3], "Sepal Width", "Petal Width", "Petal Length");
        Chart3DPanel chart3DPanel4 = new Chart3DPanel(chart3D4);
        chart3DPanel4.setPreferredSize(new Dimension(10, 10));
        chart3DPanel4.setBorder((Border)BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 0)), BorderFactory.createLineBorder(Color.DARK_GRAY)));
        chart3DPanel4.setMargin(0.35);
        demoPanel.add((Component)new DisplayPanel3D((Panel3D)chart3DPanel, false, true));
        demoPanel.addChartPanel(chart3DPanel);
        demoPanel.add((Component)new DisplayPanel3D((Panel3D)chart3DPanel2, false, true));
        demoPanel.addChartPanel(chart3DPanel2);
        demoPanel.add((Component)new DisplayPanel3D((Panel3D)chart3DPanel3, false, true));
        demoPanel.addChartPanel(chart3DPanel3);
        demoPanel.add((Component)new DisplayPanel3D((Panel3D)chart3DPanel4, false, true));
        demoPanel.addChartPanel(chart3DPanel4);
        demoPanel.setPreferredSize(new Dimension(400, 400));
        return demoPanel;
    }

    public static void main(String[] arrstring) {
        ScatterPlot3DDemo3 scatterPlot3DDemo3 = new ScatterPlot3DDemo3("OrsonCharts : ScatterPlot3DDemo3.java");
        scatterPlot3DDemo3.pack();
        scatterPlot3DDemo3.setVisible(true);
    }
}

