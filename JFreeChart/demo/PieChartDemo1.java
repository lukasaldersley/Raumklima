/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartTheme
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.StandardChartTheme
 *  org.jfree.chart.plot.PiePlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.title.TextTitle
 *  org.jfree.chart.title.Title
 *  org.jfree.data.general.DefaultPieDataset
 *  org.jfree.data.general.PieDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.HorizontalAlignment
 *  org.jfree.ui.RectangleEdge
 *  org.jfree.ui.RectangleInsets
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.Stroke;
import java.awt.Window;
import java.awt.geom.Point2D;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartTheme;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class PieChartDemo1
extends ApplicationFrame {
    private static final long serialVersionUID = 1;

    public PieChartDemo1(String string) {
        super(string);
        ChartFactory.setChartTheme((ChartTheme)new StandardChartTheme("JFree/Shadow", true));
        this.setContentPane((Container)PieChartDemo1.createDemoPanel());
    }

    private static PieDataset createDataset() {
        DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
        defaultPieDataset.setValue((Comparable)((Object)"Samsung"), (Number)new Double(27.8));
        defaultPieDataset.setValue((Comparable)((Object)"Others"), (Number)new Double(55.3));
        defaultPieDataset.setValue((Comparable)((Object)"Nokia"), (Number)new Double(16.8));
        defaultPieDataset.setValue((Comparable)((Object)"Apple"), (Number)new Double(17.1));
        return defaultPieDataset;
    }

    private static JFreeChart createChart(PieDataset pieDataset) {
        JFreeChart jFreeChart = ChartFactory.createPieChart((String)"Smart Phones Manufactured / Q3 2011", (PieDataset)pieDataset, (boolean)false, (boolean)true, (boolean)false);
        jFreeChart.setBackgroundPaint((Paint)new GradientPaint(new Point(0, 0), new Color(20, 20, 20), new Point(400, 200), Color.DARK_GRAY));
        TextTitle textTitle = jFreeChart.getTitle();
        textTitle.setHorizontalAlignment(HorizontalAlignment.LEFT);
        textTitle.setPaint((Paint)new Color(240, 240, 240));
        textTitle.setFont(new Font("Arial", 1, 26));
        PiePlot piePlot = (PiePlot)jFreeChart.getPlot();
        piePlot.setBackgroundPaint(null);
        piePlot.setInteriorGap(0.04);
        piePlot.setOutlineVisible(false);
        piePlot.setSectionPaint((Comparable)((Object)"Others"), (Paint)PieChartDemo1.createGradientPaint(new Color(200, 200, 255), Color.BLUE));
        piePlot.setSectionPaint((Comparable)((Object)"Samsung"), (Paint)PieChartDemo1.createGradientPaint(new Color(255, 200, 200), Color.RED));
        piePlot.setSectionPaint((Comparable)((Object)"Apple"), (Paint)PieChartDemo1.createGradientPaint(new Color(200, 255, 200), Color.GREEN));
        piePlot.setSectionPaint((Comparable)((Object)"Nokia"), (Paint)PieChartDemo1.createGradientPaint(new Color(200, 255, 200), Color.YELLOW));
        piePlot.setBaseSectionOutlinePaint((Paint)Color.WHITE);
        piePlot.setSectionOutlinesVisible(true);
        piePlot.setBaseSectionOutlineStroke((Stroke)new BasicStroke(2.0f));
        piePlot.setLabelFont(new Font("Courier New", 1, 20));
        piePlot.setLabelLinkPaint((Paint)Color.WHITE);
        piePlot.setLabelLinkStroke((Stroke)new BasicStroke(2.0f));
        piePlot.setLabelOutlineStroke(null);
        piePlot.setLabelPaint((Paint)Color.WHITE);
        piePlot.setLabelBackgroundPaint(null);
        TextTitle textTitle2 = new TextTitle("Source: http://www.bbc.co.uk/news/business-15489523", new Font("Courier New", 0, 12));
        textTitle2.setPaint((Paint)Color.WHITE);
        textTitle2.setPosition(RectangleEdge.BOTTOM);
        textTitle2.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        jFreeChart.addSubtitle((Title)textTitle2);
        return jFreeChart;
    }

    private static RadialGradientPaint createGradientPaint(Color color, Color color2) {
        Point2D.Float float_ = new Point2D.Float(0.0f, 0.0f);
        float f = 200.0f;
        float[] arrf = new float[]{0.0f, 1.0f};
        return new RadialGradientPaint(float_, f, arrf, new Color[]{color, color2});
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = PieChartDemo1.createChart(PieChartDemo1.createDataset());
        jFreeChart.setPadding(new RectangleInsets(4.0, 8.0, 2.0, 2.0));
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setPreferredSize(new Dimension(600, 300));
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        PieChartDemo1 pieChartDemo1 = new PieChartDemo1("JFreeChart: Pie Chart Demo 1");
        pieChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)pieChartDemo1));
        pieChartDemo1.setVisible(true);
    }
}

