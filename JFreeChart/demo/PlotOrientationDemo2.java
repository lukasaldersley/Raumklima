/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.annotations.XYAnnotation
 *  org.jfree.chart.annotations.XYLineAnnotation
 *  org.jfree.chart.annotations.XYShapeAnnotation
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.IntervalMarker
 *  org.jfree.chart.plot.Marker
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.XYSeries
 *  org.jfree.data.xy.XYSeriesCollection
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.Layer
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import demo.DemoPanel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
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
import org.jfree.chart.annotations.XYLineAnnotation;
import org.jfree.chart.annotations.XYShapeAnnotation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.Layer;
import org.jfree.ui.RefineryUtilities;

public class PlotOrientationDemo2
extends ApplicationFrame {
    private static final int CHART_COUNT = 8;

    public PlotOrientationDemo2(String string) {
        super(string);
        this.setContentPane((Container)new MyDemoPanel());
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
        PlotOrientationDemo2 plotOrientationDemo2 = new PlotOrientationDemo2("JFreeChart: PlotOrientationDemo2.java");
        plotOrientationDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)plotOrientationDemo2));
        plotOrientationDemo2.setVisible(true);
    }

    static class MyDemoPanel
    extends DemoPanel {
        private XYDataset[] datasets = new XYDataset[8];
        private JFreeChart[] charts = new JFreeChart[8];
        private ChartPanel[] panels = new ChartPanel[8];

        public MyDemoPanel() {
            XYPlot xYPlot;
            XYPlot xYPlot2;
            XYPlot xYPlot3;
            super(new GridLayout(2, 4));
            for (int i = 0; i < 8; ++i) {
                this.datasets[i] = PlotOrientationDemo2.createDataset(i);
                this.charts[i] = PlotOrientationDemo2.createChart(i, this.datasets[i]);
                xYPlot3 = (XYPlot)this.charts[i].getPlot();
                xYPlot3.setDomainPannable(true);
                xYPlot3.setRangePannable(true);
                xYPlot = new XYShapeAnnotation((Shape)new Rectangle2D.Double(1.0, 2.0, 2.0, 3.0), (Stroke)new BasicStroke(1.0f), (Paint)Color.blue);
                xYPlot2 = new XYLineAnnotation(0.0, -5.0, 10.0, -5.0);
                xYPlot3.addAnnotation((XYAnnotation)xYPlot);
                xYPlot3.addAnnotation((XYAnnotation)xYPlot2);
                xYPlot3.addDomainMarker((Marker)new IntervalMarker(5.0, 10.0), Layer.BACKGROUND);
                xYPlot3.addRangeMarker((Marker)new IntervalMarker(-2.0, 0.0), Layer.BACKGROUND);
                this.addChart(this.charts[i]);
                this.panels[i] = new ChartPanel(this.charts[i]);
            }
            XYPlot xYPlot4 = (XYPlot)this.charts[1].getPlot();
            xYPlot3 = (XYPlot)this.charts[2].getPlot();
            xYPlot = (XYPlot)this.charts[3].getPlot();
            xYPlot2 = (XYPlot)this.charts[4].getPlot();
            XYPlot xYPlot5 = (XYPlot)this.charts[5].getPlot();
            XYPlot xYPlot6 = (XYPlot)this.charts[6].getPlot();
            XYPlot xYPlot7 = (XYPlot)this.charts[7].getPlot();
            xYPlot4.getDomainAxis().setInverted(true);
            xYPlot3.getRangeAxis().setInverted(true);
            xYPlot.getDomainAxis().setInverted(true);
            xYPlot.getRangeAxis().setInverted(true);
            xYPlot5.getDomainAxis().setInverted(true);
            xYPlot6.getRangeAxis().setInverted(true);
            xYPlot2.getDomainAxis().setInverted(true);
            xYPlot2.getRangeAxis().setInverted(true);
            xYPlot2.setOrientation(PlotOrientation.HORIZONTAL);
            xYPlot5.setOrientation(PlotOrientation.HORIZONTAL);
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

