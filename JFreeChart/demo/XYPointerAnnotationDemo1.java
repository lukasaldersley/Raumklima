/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.annotations.XYAnnotation
 *  org.jfree.chart.annotations.XYPointerAnnotation
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
 *  org.jfree.data.xy.DefaultXYDataset
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.Layer
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.ui.TextAnchor
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYAnnotation;
import org.jfree.chart.annotations.XYPointerAnnotation;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.Layer;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class XYPointerAnnotationDemo1
extends ApplicationFrame {
    public XYPointerAnnotationDemo1(String string) {
        super(string);
        JPanel jPanel = XYPointerAnnotationDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    public static XYDataset createDataset() {
        DefaultXYDataset defaultXYDataset = new DefaultXYDataset();
        double[] arrd = new double[]{1.7, 2.2, 2.7, 3.0, 3.2};
        double[] arrd2 = new double[]{4.0, 3.0, 6.0, 1.0, 9.0};
        double[][] arrarrd = new double[][]{arrd, arrd2};
        defaultXYDataset.addSeries((Comparable)((Object)"Series 1"), (double[][])arrarrd);
        double[] arrd3 = new double[]{2.1, 2.2, 2.4, 2.7, 3.2};
        double[] arrd4 = new double[]{4.5, 6.0, 4.0, 8.0, 5.1};
        double[][] arrarrd2 = new double[][]{arrd3, arrd4};
        defaultXYDataset.addSeries((Comparable)((Object)"Series 2"), (double[][])arrarrd2);
        return defaultXYDataset;
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createScatterPlot((String)"XYPointerAnnotationDemo1", (String)"X", (String)"Y", (XYDataset)xYDataset, (PlotOrientation)PlotOrientation.HORIZONTAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        XYLineAndShapeRenderer xYLineAndShapeRenderer = (XYLineAndShapeRenderer)xYPlot.getRenderer();
        XYPointerAnnotation xYPointerAnnotation = new XYPointerAnnotation("Special point", 2.2, 6.0, 3.9269908169872414);
        xYPointerAnnotation.setTextAnchor(TextAnchor.BOTTOM_RIGHT);
        xYPointerAnnotation.setToolTipText("The pointer has a tool tip!");
        xYLineAndShapeRenderer.addAnnotation((XYAnnotation)xYPointerAnnotation, Layer.BACKGROUND);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = XYPointerAnnotationDemo1.createChart(XYPointerAnnotationDemo1.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        XYPointerAnnotationDemo1 xYPointerAnnotationDemo1 = new XYPointerAnnotationDemo1("XYPointerAnnotationDemo1");
        xYPointerAnnotationDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)xYPointerAnnotationDemo1));
        xYPointerAnnotationDemo1.setVisible(true);
    }
}

