/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.Chart3D
 *  com.orsoncharts.Chart3DPanel
 *  com.orsoncharts.ChartElementVisitor
 *  com.orsoncharts.axis.LabelOrientation
 *  com.orsoncharts.axis.LogAxis3D
 *  com.orsoncharts.axis.NumberAxis3D
 *  com.orsoncharts.axis.ValueAxis3D
 *  com.orsoncharts.data.xyz.XYZDataset
 *  com.orsoncharts.graphics3d.Drawable3D
 *  com.orsoncharts.graphics3d.swing.DisplayPanel3D
 *  com.orsoncharts.graphics3d.swing.Panel3D
 *  com.orsoncharts.plot.Plot3D
 *  com.orsoncharts.plot.XYZPlot
 *  com.orsoncharts.style.ChartStyle
 *  com.orsoncharts.style.ChartStyler
 */
package demo.orsoncharts.swing;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.ChartElementVisitor;
import com.orsoncharts.axis.LabelOrientation;
import com.orsoncharts.axis.LogAxis3D;
import com.orsoncharts.axis.NumberAxis3D;
import com.orsoncharts.axis.ValueAxis3D;
import com.orsoncharts.data.xyz.XYZDataset;
import com.orsoncharts.graphics3d.Drawable3D;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;
import com.orsoncharts.graphics3d.swing.Panel3D;
import com.orsoncharts.plot.Plot3D;
import com.orsoncharts.plot.XYZPlot;
import com.orsoncharts.style.ChartStyle;
import com.orsoncharts.style.ChartStyler;
import demo.orsoncharts.ScatterPlot3D2;
import demo.orsoncharts.swing.DemoPanel;
import demo.orsoncharts.swing.ExitOnClose;
import demo.orsoncharts.swing.OrsonChartsDemo;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.geom.Dimension2D;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ScatterPlot3DDemo2
extends JFrame {
    public ScatterPlot3DDemo2(String string) {
        super(string);
        this.addWindowListener(new ExitOnClose());
        this.getContentPane().add(ScatterPlot3DDemo2.createDemoPanel());
    }

    public static JPanel createDemoPanel() {
        CustomDemoPanel customDemoPanel = new CustomDemoPanel(new BorderLayout());
        customDemoPanel.setPreferredSize(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        XYZDataset xYZDataset = ScatterPlot3D2.createDataset();
        Chart3D chart3D = ScatterPlot3D2.createChart(xYZDataset);
        Chart3DPanel chart3DPanel = new Chart3DPanel(chart3D);
        customDemoPanel.setChartPanel(chart3DPanel);
        chart3DPanel.zoomToFit((Dimension2D)OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        customDemoPanel.add((Component)new DisplayPanel3D((Panel3D)chart3DPanel));
        return customDemoPanel;
    }

    public static void main(String[] arrstring) {
        ScatterPlot3DDemo2 scatterPlot3DDemo2 = new ScatterPlot3DDemo2("OrsonCharts : ScatterPlot3DDemo2.java");
        scatterPlot3DDemo2.pack();
        scatterPlot3DDemo2.setVisible(true);
    }

    static class CustomDemoPanel
    extends DemoPanel
    implements ActionListener {
        private JCheckBox checkBox = new JCheckBox("Logarithmic Scale");

        public CustomDemoPanel(LayoutManager layoutManager) {
            super(layoutManager);
            this.checkBox.setSelected(true);
            this.checkBox.addActionListener(this);
            JPanel jPanel = new JPanel(new FlowLayout());
            jPanel.add(this.checkBox);
            this.add((Component)jPanel, "South");
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Chart3D chart3D = (Chart3D)this.getChartPanel().getDrawable();
            XYZPlot xYZPlot = (XYZPlot)chart3D.getPlot();
            if (this.checkBox.isSelected()) {
                LogAxis3D logAxis3D = new LogAxis3D("Y (logarithmic scale)");
                logAxis3D.setTickLabelOrientation(LabelOrientation.PERPENDICULAR);
                logAxis3D.receive((ChartElementVisitor)new ChartStyler(chart3D.getStyle()));
                xYZPlot.setYAxis((ValueAxis3D)logAxis3D);
            } else {
                NumberAxis3D numberAxis3D = new NumberAxis3D("Y");
                numberAxis3D.setTickLabelOrientation(LabelOrientation.PERPENDICULAR);
                numberAxis3D.receive((ChartElementVisitor)new ChartStyler(chart3D.getStyle()));
                xYZPlot.setYAxis((ValueAxis3D)numberAxis3D);
            }
        }
    }

}

