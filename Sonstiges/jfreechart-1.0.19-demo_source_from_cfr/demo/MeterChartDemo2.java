/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.MeterInterval
 *  org.jfree.chart.plot.MeterPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.data.Range
 *  org.jfree.data.general.DefaultValueDataset
 *  org.jfree.data.general.ValueDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Paint;
import java.awt.Window;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.MeterInterval;
import org.jfree.chart.plot.MeterPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.data.Range;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.general.ValueDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class MeterChartDemo2
extends ApplicationFrame {
    private static DefaultValueDataset dataset;

    public MeterChartDemo2(String string) {
        super(string);
        JPanel jPanel = MeterChartDemo2.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(ValueDataset valueDataset) {
        MeterPlot meterPlot = new MeterPlot(valueDataset);
        meterPlot.addInterval(new MeterInterval("High", new Range(80.0, 100.0)));
        meterPlot.setDialOutlinePaint((Paint)Color.white);
        JFreeChart jFreeChart = new JFreeChart("Meter Chart 2", JFreeChart.DEFAULT_TITLE_FONT, (Plot)meterPlot, false);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        dataset = new DefaultValueDataset(50.0);
        JFreeChart jFreeChart = MeterChartDemo2.createChart((ValueDataset)dataset);
        JPanel jPanel = new JPanel(new BorderLayout());
        JSlider jSlider = new JSlider(-10, 110, 50);
        jSlider.setMajorTickSpacing(10);
        jSlider.setMinorTickSpacing(5);
        jSlider.setPaintLabels(true);
        jSlider.setPaintTicks(true);
        jSlider.addChangeListener(new ChangeListener(){

            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                JSlider jSlider = (JSlider)changeEvent.getSource();
                dataset.setValue((Number)new Integer(jSlider.getValue()));
            }
        });
        jPanel.add((Component)new ChartPanel(jFreeChart));
        jPanel.add("South", jSlider);
        return jPanel;
    }

    public static void main(String[] arrstring) {
        MeterChartDemo2 meterChartDemo2 = new MeterChartDemo2("JFreeChart: MeterChartDemo2.java");
        meterChartDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)meterChartDemo2));
        meterChartDemo2.setVisible(true);
    }

}

