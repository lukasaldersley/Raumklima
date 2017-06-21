/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.ThermometerPlot
 *  org.jfree.data.general.DefaultValueDataset
 *  org.jfree.data.general.ValueDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RectangleInsets
 */
package demo;

import demo.DemoPanel;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Paint;
import java.awt.Stroke;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.ThermometerPlot;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.general.ValueDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;

public class ThermometerDemo1
extends ApplicationFrame {
    public ThermometerDemo1(String string) {
        super(string);
        JPanel jPanel = ThermometerDemo1.createDemoPanel();
        this.setContentPane((Container)jPanel);
    }

    public static JPanel createDemoPanel() {
        return new ContentPanel();
    }

    public static void main(String[] arrstring) {
        ThermometerDemo1 thermometerDemo1 = new ThermometerDemo1("Thermometer Demo 1");
        thermometerDemo1.pack();
        thermometerDemo1.setVisible(true);
    }

    static class ContentPanel
    extends DemoPanel
    implements ChangeListener {
        JSlider slider = new JSlider(0, 200, 100);
        DefaultValueDataset dataset;

        public ContentPanel() {
            super(new BorderLayout());
            this.slider.setPaintLabels(true);
            this.slider.setPaintTicks(true);
            this.slider.setMajorTickSpacing(25);
            this.slider.addChangeListener(this);
            this.add((Component)this.slider, "South");
            this.dataset = new DefaultValueDataset((double)this.slider.getValue());
            JFreeChart jFreeChart = ContentPanel.createChart((ValueDataset)this.dataset);
            this.addChart(jFreeChart);
            this.add((Component)new ChartPanel(jFreeChart));
        }

        private static JFreeChart createChart(ValueDataset valueDataset) {
            ThermometerPlot thermometerPlot = new ThermometerPlot(valueDataset);
            JFreeChart jFreeChart = new JFreeChart("Thermometer Demo 1", JFreeChart.DEFAULT_TITLE_FONT, (Plot)thermometerPlot, true);
            thermometerPlot.setInsets(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
            thermometerPlot.setPadding(new RectangleInsets(10.0, 10.0, 10.0, 10.0));
            thermometerPlot.setThermometerStroke((Stroke)new BasicStroke(2.0f));
            thermometerPlot.setThermometerPaint((Paint)Color.lightGray);
            thermometerPlot.setUnits(1);
            thermometerPlot.setGap(3);
            thermometerPlot.setRange(0.0, 200.0);
            thermometerPlot.setSubrange(0, 0.0, 85.0);
            thermometerPlot.setSubrangePaint(0, (Paint)Color.red);
            thermometerPlot.setSubrange(1, 85.0, 125.0);
            thermometerPlot.setSubrangePaint(1, (Paint)Color.green);
            thermometerPlot.setSubrange(2, 125.0, 200.0);
            thermometerPlot.setSubrangePaint(2, (Paint)Color.red);
            ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
            return jFreeChart;
        }

        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            this.dataset.setValue((Number)new Integer(this.slider.getValue()));
        }
    }

}

