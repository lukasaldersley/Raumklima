/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.Chart3D
 *  com.orsoncharts.Chart3DFactory
 *  com.orsoncharts.Chart3DPanel
 *  com.orsoncharts.axis.ValueAxis3D
 *  com.orsoncharts.data.function.Function3D
 *  com.orsoncharts.graphics3d.Dimension3D
 *  com.orsoncharts.graphics3d.Drawable3D
 *  com.orsoncharts.graphics3d.ViewPoint3D
 *  com.orsoncharts.graphics3d.swing.DisplayPanel3D
 *  com.orsoncharts.graphics3d.swing.Panel3D
 *  com.orsoncharts.plot.Plot3D
 *  com.orsoncharts.plot.XYZPlot
 */
package demo.orsoncharts.swing;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.axis.ValueAxis3D;
import com.orsoncharts.data.function.Function3D;
import com.orsoncharts.graphics3d.Dimension3D;
import com.orsoncharts.graphics3d.Drawable3D;
import com.orsoncharts.graphics3d.ViewPoint3D;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;
import com.orsoncharts.graphics3d.swing.Panel3D;
import com.orsoncharts.plot.Plot3D;
import com.orsoncharts.plot.XYZPlot;
import demo.orsoncharts.swing.DemoPanel;
import demo.orsoncharts.swing.ExitOnClose;
import demo.orsoncharts.swing.OrsonChartsDemo;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.WindowListener;
import java.awt.geom.Dimension2D;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AxisRangeDemo6
extends JFrame {
    public AxisRangeDemo6(String string) {
        super(string);
        this.addWindowListener(new ExitOnClose());
        this.getContentPane().add(AxisRangeDemo6.createDemoPanel());
    }

    public static JPanel createDemoPanel() {
        CustomDemoPanel customDemoPanel = new CustomDemoPanel(new BorderLayout());
        customDemoPanel.setPreferredSize(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        Function3D function3D = new Function3D(){

            public double getValue(double d, double d2) {
                return Math.cos(d) * Math.sin(d2);
            }
        };
        Chart3D chart3D = Chart3DFactory.createSurfaceChart((String)"AxisRangeDemo6", (String)"Chart created with Orson Charts", (Function3D)function3D, (String)"X", (String)"Y", (String)"Z");
        XYZPlot xYZPlot = (XYZPlot)chart3D.getPlot();
        xYZPlot.setDimensions(new Dimension3D(10.0, 4.0, 10.0));
        xYZPlot.getXAxis().setRange(-5.0, 5.0);
        xYZPlot.getZAxis().setRange(-5.0, 5.0);
        chart3D.setViewPoint(ViewPoint3D.createAboveLeftViewPoint((double)40.0));
        Chart3DPanel chart3DPanel = new Chart3DPanel(chart3D);
        customDemoPanel.setChartPanel(chart3DPanel);
        chart3DPanel.zoomToFit((Dimension2D)OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        customDemoPanel.add((Component)new DisplayPanel3D((Panel3D)chart3DPanel));
        return customDemoPanel;
    }

    public static void main(String[] arrstring) {
        AxisRangeDemo6 axisRangeDemo6 = new AxisRangeDemo6("OrsonCharts : AxisRangeDemo6.java");
        axisRangeDemo6.pack();
        axisRangeDemo6.setVisible(true);
    }

    static class CustomDemoPanel
    extends DemoPanel
    implements ChangeListener {
        private JSlider xslider1 = new JSlider(0, 50);
        private JSlider xslider2;
        private JSlider yslider1;
        private JSlider yslider2;
        private JSlider zslider1;
        private JSlider zslider2;

        public CustomDemoPanel(LayoutManager layoutManager) {
            super(layoutManager);
            this.xslider1.setValue(0);
            this.xslider2 = new JSlider(50, 100);
            this.xslider2.setValue(100);
            this.xslider1.addChangeListener(this);
            this.xslider2.addChangeListener(this);
            this.yslider1 = new JSlider(0, 50);
            this.yslider1.setValue(0);
            this.yslider2 = new JSlider(50, 100);
            this.yslider2.setValue(100);
            this.yslider1.addChangeListener(this);
            this.yslider2.addChangeListener(this);
            this.zslider1 = new JSlider(0, 50);
            this.zslider1.setValue(0);
            this.zslider2 = new JSlider(50, 100);
            this.zslider2.setValue(100);
            this.zslider1.addChangeListener(this);
            this.zslider2.addChangeListener(this);
            JPanel jPanel = new JPanel(new GridLayout(3, 1));
            JPanel jPanel2 = new JPanel(new FlowLayout());
            jPanel2.add(new JLabel("X axis: "));
            jPanel2.add(new JLabel("Lower bound: "));
            jPanel2.add(this.xslider1);
            jPanel2.add(new JLabel("Upper bound: "));
            jPanel2.add(this.xslider2);
            jPanel.add(jPanel2);
            JPanel jPanel3 = new JPanel(new FlowLayout());
            jPanel3.add(new JLabel("Y axis: "));
            jPanel3.add(new JLabel("Lower bound: "));
            jPanel3.add(this.yslider1);
            jPanel3.add(new JLabel("Upper bound: "));
            jPanel3.add(this.yslider2);
            jPanel.add(jPanel3);
            JPanel jPanel4 = new JPanel(new FlowLayout());
            jPanel4.add(new JLabel("Z axis: "));
            jPanel4.add(new JLabel("Lower bound: "));
            jPanel4.add(this.zslider1);
            jPanel4.add(new JLabel("Upper bound: "));
            jPanel4.add(this.zslider2);
            jPanel.add(jPanel4);
            this.add((Component)jPanel, "South");
        }

        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            double d;
            double d2;
            double d3;
            Chart3D chart3D = (Chart3D)this.getChartPanel().getDrawable();
            XYZPlot xYZPlot = (XYZPlot)chart3D.getPlot();
            ValueAxis3D valueAxis3D = xYZPlot.getXAxis();
            double d4 = (double)this.xslider1.getValue() / 10.0 - 5.0;
            if (d4 != (d = (double)this.xslider2.getValue() / 10.0 - 5.0)) {
                valueAxis3D.setRange(d4, d);
            }
            ValueAxis3D valueAxis3D2 = xYZPlot.getYAxis();
            double d5 = (double)this.yslider1.getValue() / 40.0 - 1.0;
            if (d5 != (d3 = (double)this.yslider2.getValue() / 40.0 - 1.0)) {
                valueAxis3D2.setRange(d5, d3);
            }
            ValueAxis3D valueAxis3D3 = xYZPlot.getZAxis();
            double d6 = (double)this.zslider1.getValue() / 10.0 - 5.0;
            if (d6 != (d2 = (double)this.zslider2.getValue() / 10.0 - 5.0)) {
                valueAxis3D3.setRange(d6, d2);
            }
        }
    }

}

