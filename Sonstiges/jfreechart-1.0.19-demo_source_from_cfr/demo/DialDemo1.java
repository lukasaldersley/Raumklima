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
 *  org.jfree.chart.plot.dial.DialPointer$Pin
 *  org.jfree.chart.plot.dial.DialPointer$Pointer
 *  org.jfree.chart.plot.dial.DialScale
 *  org.jfree.chart.plot.dial.DialTextAnnotation
 *  org.jfree.chart.plot.dial.DialValueIndicator
 *  org.jfree.chart.plot.dial.StandardDialFrame
 *  org.jfree.chart.plot.dial.StandardDialRange
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
import java.awt.GradientPaint;
import java.awt.LayoutManager;
import java.awt.Paint;
import java.awt.Point;
import java.awt.geom.Point2D;
import javax.swing.JFrame;
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
import org.jfree.chart.plot.dial.DialTextAnnotation;
import org.jfree.chart.plot.dial.DialValueIndicator;
import org.jfree.chart.plot.dial.StandardDialFrame;
import org.jfree.chart.plot.dial.StandardDialRange;
import org.jfree.chart.plot.dial.StandardDialScale;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.general.ValueDataset;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.StandardGradientPaintTransformer;

public class DialDemo1
extends JFrame {
    public DialDemo1(String string) {
        super(string);
        this.setDefaultCloseOperation(3);
        this.setContentPane(DialDemo1.createDemoPanel());
    }

    public static JPanel createDemoPanel() {
        return new DemoPanel();
    }

    public static void main(String[] arrstring) {
        DialDemo1 dialDemo1 = new DialDemo1("JFreeChart: DialDemo1.java");
        dialDemo1.pack();
        dialDemo1.setVisible(true);
    }

    static class DemoPanel
    extends JPanel
    implements ChangeListener {
        JSlider slider;
        DefaultValueDataset dataset = new DefaultValueDataset(10.0);

        public DemoPanel() {
            super(new BorderLayout());
            JFreeChart jFreeChart = DemoPanel.createStandardDialChart("Dial Demo 1", "Temperature", (ValueDataset)this.dataset, -40.0, 60.0, 10.0, 4);
            DialPlot dialPlot = (DialPlot)jFreeChart.getPlot();
            StandardDialRange standardDialRange = new StandardDialRange(40.0, 60.0, (Paint)Color.red);
            standardDialRange.setInnerRadius(0.52);
            standardDialRange.setOuterRadius(0.55);
            dialPlot.addLayer((DialLayer)standardDialRange);
            StandardDialRange standardDialRange2 = new StandardDialRange(10.0, 40.0, (Paint)Color.orange);
            standardDialRange2.setInnerRadius(0.52);
            standardDialRange2.setOuterRadius(0.55);
            dialPlot.addLayer((DialLayer)standardDialRange2);
            StandardDialRange standardDialRange3 = new StandardDialRange(-40.0, 10.0, (Paint)Color.green);
            standardDialRange3.setInnerRadius(0.52);
            standardDialRange3.setOuterRadius(0.55);
            dialPlot.addLayer((DialLayer)standardDialRange3);
            GradientPaint gradientPaint = new GradientPaint(new Point(), new Color(255, 255, 255), new Point(), new Color(170, 170, 220));
            DialBackground dialBackground = new DialBackground((Paint)gradientPaint);
            dialBackground.setGradientPaintTransformer((GradientPaintTransformer)new StandardGradientPaintTransformer(GradientPaintTransformType.VERTICAL));
            dialPlot.setBackground((DialLayer)dialBackground);
            dialPlot.removePointer(0);
            DialPointer.Pointer pointer = new DialPointer.Pointer();
            dialPlot.addPointer((DialPointer)pointer);
            ChartPanel chartPanel = new ChartPanel(jFreeChart);
            chartPanel.setPreferredSize(new Dimension(400, 400));
            this.slider = new JSlider(-40, 60);
            this.slider.setMajorTickSpacing(10);
            this.slider.setPaintLabels(true);
            this.slider.addChangeListener(this);
            this.add((Component)chartPanel);
            this.add((Component)this.slider, "South");
        }

        public static JFreeChart createStandardDialChart(String string, String string2, ValueDataset valueDataset, double d, double d2, double d3, int n) {
            DialPlot dialPlot = new DialPlot();
            dialPlot.setDataset(valueDataset);
            dialPlot.setDialFrame((DialFrame)new StandardDialFrame());
            dialPlot.setBackground((DialLayer)new DialBackground());
            DialTextAnnotation dialTextAnnotation = new DialTextAnnotation(string2);
            dialTextAnnotation.setFont(new Font("Dialog", 1, 14));
            dialTextAnnotation.setRadius(0.7);
            dialPlot.addLayer((DialLayer)dialTextAnnotation);
            DialValueIndicator dialValueIndicator = new DialValueIndicator(0);
            dialPlot.addLayer((DialLayer)dialValueIndicator);
            StandardDialScale standardDialScale = new StandardDialScale(d, d2, -120.0, -300.0, 10.0, 4);
            standardDialScale.setMajorTickIncrement(d3);
            standardDialScale.setMinorTickCount(n);
            standardDialScale.setTickRadius(0.88);
            standardDialScale.setTickLabelOffset(0.15);
            standardDialScale.setTickLabelFont(new Font("Dialog", 0, 14));
            dialPlot.addScale(0, (DialScale)standardDialScale);
            dialPlot.addPointer((DialPointer)new DialPointer.Pin());
            DialCap dialCap = new DialCap();
            dialPlot.setCap((DialLayer)dialCap);
            return new JFreeChart(string, (Plot)dialPlot);
        }

        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            this.dataset.setValue((Number)new Integer(this.slider.getValue()));
        }
    }

}

