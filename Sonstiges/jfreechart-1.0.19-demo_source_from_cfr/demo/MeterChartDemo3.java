/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.DialShape
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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.DialShape;
import org.jfree.chart.plot.MeterInterval;
import org.jfree.chart.plot.MeterPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.data.Range;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.general.ValueDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class MeterChartDemo3
extends ApplicationFrame {
    public MeterChartDemo3(String string) {
        super(string);
        JPanel jPanel = MeterChartDemo3.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(String string, ValueDataset valueDataset, DialShape dialShape) {
        MeterPlot meterPlot = new MeterPlot(valueDataset);
        meterPlot.setDialShape(dialShape);
        meterPlot.setRange(new Range(0.0, 60.0));
        meterPlot.addInterval(new MeterInterval("Normal", new Range(0.0, 35.0), (Paint)Color.lightGray, (Stroke)new BasicStroke(2.0f), (Paint)new Color(0, 255, 0, 64)));
        meterPlot.addInterval(new MeterInterval("Warning", new Range(35.0, 50.0), (Paint)Color.lightGray, (Stroke)new BasicStroke(2.0f), (Paint)new Color(255, 255, 0, 64)));
        meterPlot.addInterval(new MeterInterval("Critical", new Range(50.0, 60.0), (Paint)Color.lightGray, (Stroke)new BasicStroke(2.0f), (Paint)new Color(255, 0, 0, 128)));
        meterPlot.setNeedlePaint((Paint)Color.darkGray);
        meterPlot.setDialBackgroundPaint((Paint)Color.white);
        meterPlot.setDialOutlinePaint((Paint)Color.gray);
        meterPlot.setMeterAngle(260);
        meterPlot.setTickLabelsVisible(true);
        meterPlot.setTickLabelFont(new Font("Dialog", 1, 10));
        meterPlot.setTickLabelPaint((Paint)Color.darkGray);
        meterPlot.setTickSize(5.0);
        meterPlot.setTickPaint((Paint)Color.lightGray);
        meterPlot.setValuePaint((Paint)Color.black);
        meterPlot.setValueFont(new Font("Dialog", 1, 14));
        JFreeChart jFreeChart = new JFreeChart(string, JFreeChart.DEFAULT_TITLE_FONT, (Plot)meterPlot, true);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JPanel jPanel = new JPanel(new GridLayout(1, 3));
        DefaultValueDataset defaultValueDataset = new DefaultValueDataset(23.0);
        ChartPanel chartPanel = new ChartPanel(MeterChartDemo3.createChart("DialShape.PIE", (ValueDataset)defaultValueDataset, DialShape.PIE));
        ChartPanel chartPanel2 = new ChartPanel(MeterChartDemo3.createChart("DialShape.CHORD", (ValueDataset)defaultValueDataset, DialShape.CHORD));
        ChartPanel chartPanel3 = new ChartPanel(MeterChartDemo3.createChart("DialShape.CIRCLE", (ValueDataset)defaultValueDataset, DialShape.CIRCLE));
        jPanel.add((Component)chartPanel);
        jPanel.add((Component)chartPanel2);
        jPanel.add((Component)chartPanel3);
        return jPanel;
    }

    public static void main(String[] arrstring) {
        MeterChartDemo3 meterChartDemo3 = new MeterChartDemo3("JFreeChart: MeterChartDemo3.java");
        meterChartDemo3.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)meterChartDemo3));
        meterChartDemo3.setVisible(true);
    }
}

