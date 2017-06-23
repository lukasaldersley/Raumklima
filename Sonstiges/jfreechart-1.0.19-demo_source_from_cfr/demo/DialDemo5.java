/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.dial.DialBackground
 *  org.jfree.chart.plot.dial.DialCap
 *  org.jfree.chart.plot.dial.DialFrame
 *  org.jfree.chart.plot.dial.DialLayer
 *  org.jfree.chart.plot.dial.DialPlot
 *  org.jfree.chart.plot.dial.DialPointer
 *  org.jfree.chart.plot.dial.DialPointer$Pointer
 *  org.jfree.chart.plot.dial.DialScale
 *  org.jfree.chart.plot.dial.StandardDialFrame
 *  org.jfree.chart.plot.dial.StandardDialScale
 *  org.jfree.data.general.DefaultValueDataset
 *  org.jfree.data.general.ValueDataset
 *  org.jfree.ui.GradientPaintTransformType
 *  org.jfree.ui.GradientPaintTransformer
 *  org.jfree.ui.StandardGradientPaintTransformer
 */
package demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Paint;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.dial.DialBackground;
import org.jfree.chart.plot.dial.DialCap;
import org.jfree.chart.plot.dial.DialFrame;
import org.jfree.chart.plot.dial.DialLayer;
import org.jfree.chart.plot.dial.DialPlot;
import org.jfree.chart.plot.dial.DialPointer;
import org.jfree.chart.plot.dial.DialScale;
import org.jfree.chart.plot.dial.StandardDialFrame;
import org.jfree.chart.plot.dial.StandardDialScale;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.general.ValueDataset;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.StandardGradientPaintTransformer;

public class DialDemo5
extends JFrame {
    public DialDemo5(String string) {
        super(string);
        this.setDefaultCloseOperation(3);
        this.setContentPane(DialDemo5.createDemoPanel());
    }

    public static JPanel createDemoPanel() {
        return new DemoPanel();
    }

    public static void main(String[] arrstring) {
        DialDemo5 dialDemo5 = new DialDemo5("JFreeChart: DialDemo5.java");
        dialDemo5.pack();
        dialDemo5.setVisible(true);
    }

    static class DemoPanel
    extends JPanel
    implements ChangeListener {
        DefaultValueDataset hoursDataset = new DefaultValueDataset(6.0);
        DefaultValueDataset dataset2 = new DefaultValueDataset(15.0);
        JSlider slider1;
        JSlider slider2;

        public DemoPanel() {
            super(new BorderLayout());
            DialPlot dialPlot = new DialPlot();
            dialPlot.setView(0.0, 0.0, 1.0, 1.0);
            dialPlot.setDataset(0, (ValueDataset)this.hoursDataset);
            dialPlot.setDataset(1, (ValueDataset)this.dataset2);
            StandardDialFrame standardDialFrame = new StandardDialFrame();
            standardDialFrame.setBackgroundPaint((Paint)Color.lightGray);
            standardDialFrame.setForegroundPaint((Paint)Color.darkGray);
            dialPlot.setDialFrame((DialFrame)standardDialFrame);
            DialBackground dialBackground = new DialBackground((Paint)Color.white);
            dialBackground.setGradientPaintTransformer((GradientPaintTransformer)new StandardGradientPaintTransformer(GradientPaintTransformType.VERTICAL));
            dialPlot.setBackground((DialLayer)dialBackground);
            StandardDialScale standardDialScale = new StandardDialScale(0.0, 12.0, 90.0, -360.0, 10.0, 4);
            standardDialScale.setFirstTickLabelVisible(false);
            standardDialScale.setMajorTickIncrement(1.0);
            standardDialScale.setTickRadius(0.88);
            standardDialScale.setTickLabelOffset(0.15);
            standardDialScale.setTickLabelFont(new Font("Dialog", 0, 14));
            dialPlot.addScale(0, (DialScale)standardDialScale);
            StandardDialScale standardDialScale2 = new StandardDialScale(0.0, 60.0, 90.0, -360.0, 10.0, 4);
            standardDialScale2.setVisible(false);
            standardDialScale2.setMajorTickIncrement(5.0);
            standardDialScale2.setTickRadius(0.68);
            standardDialScale2.setTickLabelOffset(0.15);
            standardDialScale2.setTickLabelFont(new Font("Dialog", 0, 14));
            dialPlot.addScale(1, (DialScale)standardDialScale2);
            DialPointer.Pointer pointer = new DialPointer.Pointer(0);
            pointer.setRadius(0.55);
            dialPlot.addLayer((DialLayer)pointer);
            dialPlot.mapDatasetToScale(1, 1);
            DialPointer.Pointer pointer2 = new DialPointer.Pointer(1);
            dialPlot.addLayer((DialLayer)pointer2);
            DialCap dialCap = new DialCap();
            dialCap.setRadius(0.1);
            dialPlot.setCap((DialLayer)dialCap);
            JFreeChart jFreeChart = new JFreeChart((Plot)dialPlot);
            jFreeChart.setTitle("Dial Demo 5");
            ChartPanel chartPanel = new ChartPanel(jFreeChart);
            chartPanel.setPreferredSize(new Dimension(400, 400));
            JPanel jPanel = new JPanel(new GridLayout(2, 2));
            jPanel.add(new JLabel("Hours:"));
            jPanel.add(new JLabel("Minutes:"));
            this.slider1 = new JSlider(0, 12);
            this.slider1.setMajorTickSpacing(2);
            this.slider1.setPaintTicks(true);
            this.slider1.setPaintLabels(true);
            this.slider1.addChangeListener(this);
            jPanel.add(this.slider1);
            jPanel.add(this.slider1);
            this.slider2 = new JSlider(0, 60);
            this.slider2.setValue(15);
            this.slider2.setMajorTickSpacing(10);
            this.slider2.setPaintTicks(true);
            this.slider2.setPaintLabels(true);
            this.slider2.addChangeListener(this);
            jPanel.add(this.slider2);
            this.add((Component)chartPanel);
            this.add((Component)jPanel, "South");
        }

        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            this.hoursDataset.setValue((Number)new Integer(this.slider1.getValue()));
            this.dataset2.setValue((Number)new Integer(this.slider2.getValue()));
        }
    }

}

