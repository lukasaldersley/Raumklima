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
import java.awt.GridLayout;
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

public class DialDemo2a
extends JFrame {
    public DialDemo2a(String string) {
        super(string);
        this.setDefaultCloseOperation(3);
        this.setContentPane(DialDemo2a.createDemoPanel());
    }

    public static JPanel createDemoPanel() {
        JPanel jPanel = new JPanel(new GridLayout(1, 2));
        jPanel.add(new DemoPanelA());
        jPanel.add(new DemoPanelB());
        return jPanel;
    }

    public static void main(String[] arrstring) {
        DialDemo2a dialDemo2a = new DialDemo2a("JFreeChart: DialDemo2a.java");
        dialDemo2a.pack();
        dialDemo2a.setVisible(true);
    }

    static class DemoPanelB
    extends JPanel
    implements ChangeListener {
        DefaultValueDataset dataset1 = new DefaultValueDataset(10.0);
        DefaultValueDataset dataset2 = new DefaultValueDataset(50.0);
        JSlider slider1;
        JSlider slider2;

        public DemoPanelB() {
            super(new BorderLayout());
            DialPlot dialPlot = new DialPlot();
            dialPlot.setView(0.0, 0.0, 1.0, 1.0);
            dialPlot.setDataset(0, (ValueDataset)this.dataset1);
            dialPlot.setDataset(1, (ValueDataset)this.dataset2);
            StandardDialFrame standardDialFrame = new StandardDialFrame();
            standardDialFrame.setBackgroundPaint((Paint)Color.lightGray);
            standardDialFrame.setForegroundPaint((Paint)Color.darkGray);
            dialPlot.setDialFrame((DialFrame)standardDialFrame);
            GradientPaint gradientPaint = new GradientPaint(new Point(), new Color(255, 255, 255), new Point(), new Color(170, 170, 220));
            DialBackground dialBackground = new DialBackground((Paint)gradientPaint);
            dialBackground.setGradientPaintTransformer((GradientPaintTransformer)new StandardGradientPaintTransformer(GradientPaintTransformType.VERTICAL));
            dialPlot.setBackground((DialLayer)dialBackground);
            DialTextAnnotation dialTextAnnotation = new DialTextAnnotation("Temperature");
            dialTextAnnotation.setFont(new Font("Dialog", 1, 14));
            dialTextAnnotation.setRadius(0.7);
            dialPlot.addLayer((DialLayer)dialTextAnnotation);
            DialValueIndicator dialValueIndicator = new DialValueIndicator(0);
            dialValueIndicator.setFont(new Font("Dialog", 0, 10));
            dialValueIndicator.setOutlinePaint((Paint)Color.darkGray);
            dialValueIndicator.setRadius(0.6);
            dialValueIndicator.setAngle(-103.0);
            dialPlot.addLayer((DialLayer)dialValueIndicator);
            DialValueIndicator dialValueIndicator2 = new DialValueIndicator(1);
            dialValueIndicator2.setFont(new Font("Dialog", 0, 10));
            dialValueIndicator2.setOutlinePaint((Paint)Color.red);
            dialValueIndicator2.setRadius(0.6);
            dialValueIndicator2.setAngle(-77.0);
            dialPlot.addLayer((DialLayer)dialValueIndicator2);
            StandardDialScale standardDialScale = new StandardDialScale(-40.0, 60.0, -120.0, -300.0, 10.0, 4);
            standardDialScale.setTickRadius(0.88);
            standardDialScale.setTickLabelOffset(0.15);
            standardDialScale.setTickLabelFont(new Font("Dialog", 0, 14));
            dialPlot.addScale(0, (DialScale)standardDialScale);
            StandardDialScale standardDialScale2 = new StandardDialScale(0.0, 100.0, -120.0, -300.0, 10.0, 4);
            standardDialScale2.setTickRadius(0.5);
            standardDialScale2.setTickLabelOffset(0.15);
            standardDialScale2.setTickLabelFont(new Font("Dialog", 0, 10));
            standardDialScale2.setMajorTickPaint((Paint)Color.red);
            standardDialScale2.setMinorTickPaint((Paint)Color.red);
            dialPlot.addScale(1, (DialScale)standardDialScale2);
            dialPlot.mapDatasetToScale(1, 1);
            StandardDialRange standardDialRange = new StandardDialRange(90.0, 100.0, (Paint)Color.blue);
            standardDialRange.setScaleIndex(1);
            standardDialRange.setInnerRadius(0.59);
            standardDialRange.setOuterRadius(0.59);
            dialPlot.addLayer((DialLayer)standardDialRange);
            DialPointer.Pin pin = new DialPointer.Pin(1);
            pin.setRadius(0.55);
            dialPlot.addPointer((DialPointer)pin);
            DialPointer.Pointer pointer = new DialPointer.Pointer(0);
            dialPlot.addPointer((DialPointer)pointer);
            DialCap dialCap = new DialCap();
            dialCap.setRadius(0.1);
            dialPlot.setCap((DialLayer)dialCap);
            JFreeChart jFreeChart = new JFreeChart((Plot)dialPlot);
            jFreeChart.setTitle("Dial Demo 2");
            ChartPanel chartPanel = new ChartPanel(jFreeChart);
            chartPanel.setPreferredSize(new Dimension(400, 400));
            JPanel jPanel = new JPanel(new GridLayout(1, 2));
            this.slider1 = new JSlider(-40, 60);
            this.slider1.setMajorTickSpacing(20);
            this.slider1.setPaintTicks(false);
            this.slider1.setPaintLabels(true);
            this.slider1.addChangeListener(this);
            jPanel.add(this.slider1);
            jPanel.add(this.slider1);
            this.slider2 = new JSlider(0, 100);
            this.slider2.setMajorTickSpacing(20);
            this.slider2.setPaintTicks(false);
            this.slider2.setPaintLabels(true);
            this.slider2.addChangeListener(this);
            jPanel.add(this.slider2);
            this.add((Component)chartPanel);
            this.add((Component)jPanel, "South");
        }

        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            this.dataset1.setValue((Number)new Integer(this.slider1.getValue()));
            this.dataset2.setValue((Number)new Integer(this.slider2.getValue()));
        }
    }

    static class DemoPanelA
    extends JPanel
    implements ChangeListener {
        JSlider slider;
        DefaultValueDataset dataset = new DefaultValueDataset(10.0);

        public DemoPanelA() {
            super(new BorderLayout());
            JFreeChart jFreeChart = DemoPanelA.createStandardDialChart("Dial Demo 1", "Temperature", (ValueDataset)this.dataset, -40.0, 60.0, 10.0, 4);
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
            dialPlot.addPointer((DialPointer)new DialPointer.Pointer());
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

