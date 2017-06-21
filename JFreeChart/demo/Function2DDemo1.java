/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.data.function.Function2D
 *  org.jfree.data.general.DatasetUtilities
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.function.Function2D;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class Function2DDemo1
extends ApplicationFrame {
    public Function2DDemo1(String string) {
        super(string);
        JPanel jPanel = Function2DDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYLineChart((String)"Function2DDemo1 ", (String)"X", (String)"Y", (XYDataset)xYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setDomainPannable(true);
        xYPlot.setRangePannable(true);
        ValueAxis valueAxis = xYPlot.getDomainAxis();
        valueAxis.setLowerMargin(0.0);
        valueAxis.setUpperMargin(0.0);
        valueAxis.setRange(-2.0, 2.0);
        ValueAxis valueAxis2 = xYPlot.getRangeAxis();
        valueAxis2.setRange(0.0, 5.0);
        return jFreeChart;
    }

    public static XYDataset createDataset() {
        XYDataset xYDataset = DatasetUtilities.sampleFunction2D((Function2D)new X2(), (double)-40.0, (double)40.0, (int)400, (Comparable)((Object)"f(x)"));
        return xYDataset;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = Function2DDemo1.createChart(Function2DDemo1.createDataset());
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        chartPanel.setMouseWheelEnabled(true);
        return chartPanel;
    }

    public static void main(String[] arrstring) {
        Function2DDemo1 function2DDemo1 = new Function2DDemo1("JFreeChart: Function2DDemo1.java");
        function2DDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)function2DDemo1));
        function2DDemo1.setVisible(true);
    }

    static class X2
    implements Function2D {
        X2() {
        }

        public double getValue(double d) {
            return d * d + 2.0;
        }
    }

}

