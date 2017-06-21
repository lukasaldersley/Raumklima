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
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
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

public class MeterChartDemo1
extends ApplicationFrame {
    private static DefaultValueDataset dataset;

    public MeterChartDemo1(String string) {
        super(string);
        JPanel jPanel = MeterChartDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(ValueDataset valueDataset) {
        MeterPlot meterPlot = new MeterPlot(valueDataset);
        meterPlot.setRange(new Range(0.0, 60.0));
        meterPlot.addInterval(new MeterInterval("Normal", new Range(0.0, 35.0), (Paint)Color.lightGray, (Stroke)new BasicStroke(2.0f), (Paint)new Color(0, 255, 0, 64)));
        meterPlot.addInterval(new MeterInterval("Warning", new Range(35.0, 50.0), (Paint)Color.lightGray, (Stroke)new BasicStroke(2.0f), (Paint)new Color(255, 255, 0, 64)));
        meterPlot.addInterval(new MeterInterval("Critical", new Range(50.0, 60.0), (Paint)Color.lightGray, (Stroke)new BasicStroke(2.0f), (Paint)new Color(255, 0, 0, 128)));
        meterPlot.setNeedlePaint((Paint)Color.darkGray);
        meterPlot.setDialBackgroundPaint((Paint)Color.white);
        meterPlot.setDialOutlinePaint((Paint)Color.gray);
        meterPlot.setDialShape(DialShape.CHORD);
        meterPlot.setMeterAngle(260);
        meterPlot.setTickLabelsVisible(true);
        meterPlot.setTickLabelFont(new Font("Dialog", 1, 10));
        meterPlot.setTickLabelPaint((Paint)Color.darkGray);
        meterPlot.setTickSize(5.0);
        meterPlot.setTickPaint((Paint)Color.lightGray);
        meterPlot.setValuePaint((Paint)Color.black);
        meterPlot.setValueFont(new Font("Dialog", 1, 14));
        JFreeChart jFreeChart = new JFreeChart("Meter Chart 1", JFreeChart.DEFAULT_TITLE_FONT, (Plot)meterPlot, true);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        dataset = new DefaultValueDataset(23.0);
        JFreeChart jFreeChart = MeterChartDemo1.createChart((ValueDataset)dataset);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        MeterChartDemo1 meterChartDemo1 = new MeterChartDemo1("JFreeChart: MeterChartDemo1.java");
        meterChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)meterChartDemo1));
        meterChartDemo1.setVisible(true);
    }
}

