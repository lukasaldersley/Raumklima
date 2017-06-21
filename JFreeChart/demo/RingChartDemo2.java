/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.labels.PieSectionLabelGenerator
 *  org.jfree.chart.plot.CenterTextMode
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.RingPlot
 *  org.jfree.chart.title.TextTitle
 *  org.jfree.data.general.DefaultPieDataset
 *  org.jfree.data.general.PieDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.HorizontalAlignment
 *  org.jfree.ui.RectangleInsets
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Window;
import java.awt.geom.Point2D;
import java.text.DecimalFormat;
import java.text.Format;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.plot.CenterTextMode;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class RingChartDemo2
extends ApplicationFrame {
    private static final long serialVersionUID = 1;

    public RingChartDemo2(String string) {
        super(string);
        this.setContentPane((Container)RingChartDemo2.createDemoPanel());
    }

    private static PieDataset createDataset() {
        DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
        defaultPieDataset.setValue((Comparable)((Object)"A"), (Number)new Double(0.653));
        defaultPieDataset.setValue((Comparable)((Object)"B"), (Number)new Double(0.347));
        return defaultPieDataset;
    }

    private static JFreeChart createChart(PieDataset pieDataset) {
        RingPlot ringPlot = new RingPlot(pieDataset);
        ringPlot.setCenterTextMode(CenterTextMode.VALUE);
        ringPlot.setCenterTextFont(new Font("SansSerif", 1, 24));
        ringPlot.setCenterTextColor(Color.LIGHT_GRAY);
        ringPlot.setCenterTextFormatter((Format)new DecimalFormat("0.0%"));
        JFreeChart jFreeChart = new JFreeChart("Machine Capacity", JFreeChart.DEFAULT_TITLE_FONT, (Plot)ringPlot, false);
        jFreeChart.setBackgroundPaint((Paint)new GradientPaint(new Point(0, 0), new Color(20, 20, 20), new Point(400, 200), Color.DARK_GRAY));
        TextTitle textTitle = jFreeChart.getTitle();
        textTitle.setHorizontalAlignment(HorizontalAlignment.LEFT);
        textTitle.setPaint((Paint)new Color(240, 240, 240));
        textTitle.setFont(new Font("Arial", 1, 26));
        ringPlot.setBackgroundPaint(null);
        ringPlot.setOutlineVisible(false);
        ringPlot.setLabelGenerator(null);
        ringPlot.setSectionPaint((Comparable)((Object)"A"), (Paint)Color.ORANGE);
        ringPlot.setSectionPaint((Comparable)((Object)"B"), (Paint)new Color(100, 100, 100));
        ringPlot.setSectionDepth(0.05);
        ringPlot.setSectionOutlinesVisible(false);
        ringPlot.setShadowPaint(null);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = RingChartDemo2.createChart(RingChartDemo2.createDataset());
        jFreeChart.setPadding(new RectangleInsets(4.0, 8.0, 2.0, 2.0));
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setPreferredSize(new Dimension(600, 300));
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        RingChartDemo2 ringChartDemo2 = new RingChartDemo2("JFreeChart: Ring Chart Demo 2");
        ringChartDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)ringChartDemo2));
        ringChartDemo2.setVisible(true);
    }
}

