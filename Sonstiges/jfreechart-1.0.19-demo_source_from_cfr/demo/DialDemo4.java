/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.dial.ArcDialFrame
 *  org.jfree.chart.plot.dial.DialBackground
 *  org.jfree.chart.plot.dial.DialFrame
 *  org.jfree.chart.plot.dial.DialLayer
 *  org.jfree.chart.plot.dial.DialPlot
 *  org.jfree.chart.plot.dial.DialPointer
 *  org.jfree.chart.plot.dial.DialPointer$Pin
 *  org.jfree.chart.plot.dial.DialScale
 *  org.jfree.chart.plot.dial.StandardDialScale
 *  org.jfree.data.general.DefaultValueDataset
 *  org.jfree.data.general.ValueDataset
 *  org.jfree.ui.GradientPaintTransformType
 *  org.jfree.ui.GradientPaintTransformer
 *  org.jfree.ui.StandardGradientPaintTransformer
 */
package demo;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.LayoutManager;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.dial.ArcDialFrame;
import org.jfree.chart.plot.dial.DialBackground;
import org.jfree.chart.plot.dial.DialFrame;
import org.jfree.chart.plot.dial.DialLayer;
import org.jfree.chart.plot.dial.DialPlot;
import org.jfree.chart.plot.dial.DialPointer;
import org.jfree.chart.plot.dial.DialScale;
import org.jfree.chart.plot.dial.StandardDialScale;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.general.ValueDataset;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.StandardGradientPaintTransformer;

public class DialDemo4
extends JFrame {
    public static JPanel createDemoPanel() {
        return new DemoPanel();
    }

    public DialDemo4(String string) {
        super(string);
        this.setDefaultCloseOperation(3);
        this.setContentPane(DialDemo4.createDemoPanel());
    }

    public static void main(String[] arrstring) {
        DialDemo4 dialDemo4 = new DialDemo4("JFreeChart: DialDemo4.java");
        dialDemo4.pack();
        dialDemo4.setVisible(true);
    }

    static class DemoPanel
    extends JPanel
    implements ChangeListener {
        JSlider slider;
        DefaultValueDataset dataset = new DefaultValueDataset(50.0);

        public DemoPanel() {
            super(new BorderLayout());
            DialPlot dialPlot = new DialPlot();
            dialPlot.setView(0.78, 0.37, 0.22, 0.26);
            dialPlot.setDataset((ValueDataset)this.dataset);
            ArcDialFrame arcDialFrame = new ArcDialFrame(-10.0, 20.0);
            arcDialFrame.setInnerRadius(0.7);
            arcDialFrame.setOuterRadius(0.9);
            arcDialFrame.setForegroundPaint((Paint)Color.darkGray);
            arcDialFrame.setStroke((Stroke)new BasicStroke(3.0f));
            dialPlot.setDialFrame((DialFrame)arcDialFrame);
            GradientPaint gradientPaint = new GradientPaint(new Point(), new Color(255, 255, 255), new Point(), new Color(240, 240, 240));
            DialBackground dialBackground = new DialBackground((Paint)gradientPaint);
            dialBackground.setGradientPaintTransformer((GradientPaintTransformer)new StandardGradientPaintTransformer(GradientPaintTransformType.VERTICAL));
            dialPlot.addLayer((DialLayer)dialBackground);
            StandardDialScale standardDialScale = new StandardDialScale(0.0, 100.0, -8.0, 16.0, 10.0, 4);
            standardDialScale.setTickRadius(0.82);
            standardDialScale.setTickLabelOffset(-0.04);
            standardDialScale.setMajorTickIncrement(25.0);
            standardDialScale.setTickLabelFont(new Font("Dialog", 0, 14));
            dialPlot.addScale(0, (DialScale)standardDialScale);
            DialPointer.Pin pin = new DialPointer.Pin();
            pin.setRadius(0.84);
            dialPlot.addLayer((DialLayer)pin);
            JFreeChart jFreeChart = new JFreeChart((Plot)dialPlot);
            jFreeChart.setTitle("Dial Demo 4");
            ChartPanel chartPanel = new ChartPanel(jFreeChart);
            chartPanel.setPreferredSize(new Dimension(400, 250));
            this.slider = new JSlider(0, 100);
            this.slider.setMajorTickSpacing(10);
            this.slider.setPaintLabels(true);
            this.slider.addChangeListener(this);
            this.add((Component)chartPanel);
            this.add((Component)this.slider, "South");
        }

        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            this.dataset.setValue((Number)new Integer(this.slider.getValue()));
        }
    }

}

