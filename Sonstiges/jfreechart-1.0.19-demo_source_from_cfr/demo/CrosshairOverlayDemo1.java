/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartMouseEvent
 *  org.jfree.chart.ChartMouseListener
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.panel.CrosshairOverlay
 *  org.jfree.chart.panel.Overlay
 *  org.jfree.chart.plot.Crosshair
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.data.Range
 *  org.jfree.data.general.DatasetUtilities
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.XYSeries
 *  org.jfree.data.xy.XYSeriesCollection
 *  org.jfree.ui.RectangleEdge
 */
package demo;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.panel.CrosshairOverlay;
import org.jfree.chart.panel.Overlay;
import org.jfree.chart.plot.Crosshair;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.Range;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleEdge;

public class CrosshairOverlayDemo1
extends JFrame {
    public CrosshairOverlayDemo1(String string) {
        super(string);
        this.setContentPane(CrosshairOverlayDemo1.createDemoPanel());
    }

    public static JPanel createDemoPanel() {
        return new MyDemoPanel();
    }

    public static void main(String[] arrstring) {
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                CrosshairOverlayDemo1 crosshairOverlayDemo1 = new CrosshairOverlayDemo1("JFreeChart: CrosshairOverlayDemo1.java");
                crosshairOverlayDemo1.pack();
                crosshairOverlayDemo1.setVisible(true);
            }
        });
    }

    static class MyDemoPanel
    extends JPanel
    implements ChartMouseListener {
        private ChartPanel chartPanel;
        private Crosshair xCrosshair;
        private Crosshair yCrosshair;

        public MyDemoPanel() {
            super(new BorderLayout());
            JFreeChart jFreeChart = this.createChart(this.createDataset());
            this.chartPanel = new ChartPanel(jFreeChart);
            this.chartPanel.addChartMouseListener((ChartMouseListener)this);
            CrosshairOverlay crosshairOverlay = new CrosshairOverlay();
            this.xCrosshair = new Crosshair(Double.NaN, (Paint)Color.GRAY, (Stroke)new BasicStroke(0.0f));
            this.xCrosshair.setLabelVisible(true);
            this.yCrosshair = new Crosshair(Double.NaN, (Paint)Color.GRAY, (Stroke)new BasicStroke(0.0f));
            this.yCrosshair.setLabelVisible(true);
            crosshairOverlay.addDomainCrosshair(this.xCrosshair);
            crosshairOverlay.addRangeCrosshair(this.yCrosshair);
            this.chartPanel.addOverlay((Overlay)crosshairOverlay);
            this.add((Component)this.chartPanel);
        }

        private JFreeChart createChart(XYDataset xYDataset) {
            JFreeChart jFreeChart = ChartFactory.createXYLineChart((String)"CrosshairOverlayDemo1", (String)"X", (String)"Y", (XYDataset)xYDataset);
            return jFreeChart;
        }

        private XYDataset createDataset() {
            XYSeries xYSeries = new XYSeries((Comparable)((Object)"S1"));
            for (int i = 0; i < 10; ++i) {
                xYSeries.add((double)i, (double)i + Math.random() * 4.0);
            }
            XYSeriesCollection xYSeriesCollection = new XYSeriesCollection(xYSeries);
            return xYSeriesCollection;
        }

        public void chartMouseClicked(ChartMouseEvent chartMouseEvent) {
        }

        public void chartMouseMoved(ChartMouseEvent chartMouseEvent) {
            Rectangle2D rectangle2D = this.chartPanel.getScreenDataArea();
            JFreeChart jFreeChart = chartMouseEvent.getChart();
            XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
            ValueAxis valueAxis = xYPlot.getDomainAxis();
            double d = valueAxis.java2DToValue((double)chartMouseEvent.getTrigger().getX(), rectangle2D, RectangleEdge.BOTTOM);
            if (!valueAxis.getRange().contains(d)) {
                d = Double.NaN;
            }
            double d2 = DatasetUtilities.findYValue((XYDataset)xYPlot.getDataset(), (int)0, (double)d);
            this.xCrosshair.setValue(d);
            this.yCrosshair.setValue(d2);
        }
    }

}

