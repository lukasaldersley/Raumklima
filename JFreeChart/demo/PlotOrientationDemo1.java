/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.annotations.XYAnnotation
 *  org.jfree.chart.annotations.XYDataImageAnnotation
 *  org.jfree.chart.annotations.XYLineAnnotation
 *  org.jfree.chart.annotations.XYShapeAnnotation
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.XYSeries
 *  org.jfree.data.xy.XYSeriesCollection
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.ui.about.ProjectInfo
 */
package demo;

import demo.DemoPanel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.Window;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYAnnotation;
import org.jfree.chart.annotations.XYDataImageAnnotation;
import org.jfree.chart.annotations.XYLineAnnotation;
import org.jfree.chart.annotations.XYShapeAnnotation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.about.ProjectInfo;

public class PlotOrientationDemo1
extends ApplicationFrame {
    private static int CHART_COUNT = 8;

    public PlotOrientationDemo1(String string) {
        super(string);
        this.setContentPane((Container)PlotOrientationDemo1.createDemoPanel());
    }

    private static XYDataset createDataset(int n) {
        XYSeries xYSeries = new XYSeries((Comparable)((Object)("Series " + (n + 1))));
        xYSeries.add(-10.0, -5.0);
        xYSeries.add(10.0, 5.0);
        XYSeriesCollection xYSeriesCollection = new XYSeriesCollection();
        xYSeriesCollection.addSeries(xYSeries);
        return xYSeriesCollection;
    }

    private static JFreeChart createChart(int n, XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createXYLineChart((String)("Chart " + (n + 1)), (String)"X", (String)"Y", (XYDataset)xYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)false, (boolean)false, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        XYLineAndShapeRenderer xYLineAndShapeRenderer = (XYLineAndShapeRenderer)xYPlot.getRenderer();
        xYLineAndShapeRenderer.setBaseShapesVisible(true);
        xYLineAndShapeRenderer.setBaseShapesFilled(true);
        ValueAxis valueAxis = xYPlot.getDomainAxis();
        valueAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        ValueAxis valueAxis2 = xYPlot.getRangeAxis();
        valueAxis2.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        return new MyDemoPanel();
    }

    public static void main(String[] arrstring) {
        PlotOrientationDemo1 plotOrientationDemo1 = new PlotOrientationDemo1("JFreeChart: PlotOrientationDemo1.java");
        plotOrientationDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)plotOrientationDemo1));
        plotOrientationDemo1.setVisible(true);
    }

    static class MyDemoPanel
    extends DemoPanel {
        private XYDataset[] datasets = new XYDataset[PlotOrientationDemo1.access$000()];
        private JFreeChart[] charts = new JFreeChart[PlotOrientationDemo1.access$000()];
        private ChartPanel[] panels = new ChartPanel[PlotOrientationDemo1.access$000()];

        public MyDemoPanel() {
            XYPlot xYPlot;
            XYPlot xYPlot2;
            XYPlot xYPlot3;
            XYPlot xYPlot4;
            super(new GridLayout(2, 4));
            for (int i = 0; i < CHART_COUNT; ++i) {
                this.datasets[i] = PlotOrientationDemo1.createDataset(i);
                this.charts[i] = PlotOrientationDemo1.createChart(i, this.datasets[i]);
                xYPlot4 = (XYPlot)this.charts[i].getPlot();
                xYPlot4.setDomainPannable(true);
                xYPlot4.setRangePannable(true);
                xYPlot = new XYShapeAnnotation((Shape)new Rectangle2D.Double(-2.0, -3.0, 1.0, 4.0), (Stroke)new BasicStroke(1.0f), (Paint)Color.blue, (Paint)Color.yellow);
                xYPlot2 = new XYLineAnnotation(0.0, -5.0, 10.0, -5.0);
                xYPlot3 = new XYDataImageAnnotation(JFreeChart.INFO.getLogo(), 5.0, 2.0, 6.0, 4.0, true);
                xYPlot4.addAnnotation((XYAnnotation)xYPlot);
                xYPlot4.addAnnotation((XYAnnotation)xYPlot2);
                xYPlot4.addAnnotation((XYAnnotation)xYPlot3);
                xYPlot4.setQuadrantPaint(0, (Paint)new Color(230, 230, 255));
                xYPlot4.setQuadrantPaint(1, (Paint)new Color(230, 255, 230));
                xYPlot4.setQuadrantPaint(2, (Paint)new Color(255, 230, 230));
                xYPlot4.setQuadrantPaint(3, (Paint)new Color(255, 230, 255));
                this.addChart(this.charts[i]);
                this.panels[i] = new ChartPanel(this.charts[i]);
                this.panels[i].setMouseWheelEnabled(true);
            }
            XYPlot xYPlot5 = (XYPlot)this.charts[1].getPlot();
            xYPlot4 = (XYPlot)this.charts[2].getPlot();
            xYPlot = (XYPlot)this.charts[3].getPlot();
            xYPlot2 = (XYPlot)this.charts[4].getPlot();
            xYPlot3 = (XYPlot)this.charts[5].getPlot();
            XYPlot xYPlot6 = (XYPlot)this.charts[6].getPlot();
            XYPlot xYPlot7 = (XYPlot)this.charts[7].getPlot();
            xYPlot5.getDomainAxis().setInverted(true);
            xYPlot4.getRangeAxis().setInverted(true);
            xYPlot.getDomainAxis().setInverted(true);
            xYPlot.getRangeAxis().setInverted(true);
            xYPlot3.getDomainAxis().setInverted(true);
            xYPlot6.getRangeAxis().setInverted(true);
            xYPlot2.getDomainAxis().setInverted(true);
            xYPlot2.getRangeAxis().setInverted(true);
            xYPlot2.setOrientation(PlotOrientation.HORIZONTAL);
            xYPlot3.setOrientation(PlotOrientation.HORIZONTAL);
            xYPlot6.setOrientation(PlotOrientation.HORIZONTAL);
            xYPlot7.setOrientation(PlotOrientation.HORIZONTAL);
            this.add((Component)this.panels[0]);
            this.add((Component)this.panels[1]);
            this.add((Component)this.panels[4]);
            this.add((Component)this.panels[5]);
            this.add((Component)this.panels[2]);
            this.add((Component)this.panels[3]);
            this.add((Component)this.panels[6]);
            this.add((Component)this.panels[7]);
            this.setPreferredSize(new Dimension(800, 600));
        }
    }

}

