/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.annotations.XYAnnotation
 *  org.jfree.chart.annotations.XYDataImageAnnotation
 *  org.jfree.chart.axis.AxisLocation
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.event.ChartChangeEvent
 *  org.jfree.chart.event.ChartChangeListener
 *  org.jfree.chart.panel.CrosshairOverlay
 *  org.jfree.chart.panel.Overlay
 *  org.jfree.chart.plot.Crosshair
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.GrayPaintScale
 *  org.jfree.chart.renderer.PaintScale
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.Range
 *  org.jfree.data.general.DefaultHeatMapDataset
 *  org.jfree.data.general.HeatMapDataset
 *  org.jfree.data.general.HeatMapUtilities
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.XYSeriesCollection
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.Layer
 *  org.jfree.ui.RectangleAnchor
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import demo.DemoPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Paint;
import java.awt.Window;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYAnnotation;
import org.jfree.chart.annotations.XYDataImageAnnotation;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.ChartChangeEvent;
import org.jfree.chart.event.ChartChangeListener;
import org.jfree.chart.panel.CrosshairOverlay;
import org.jfree.chart.panel.Overlay;
import org.jfree.chart.plot.Crosshair;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.GrayPaintScale;
import org.jfree.chart.renderer.PaintScale;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.Range;
import org.jfree.data.general.DefaultHeatMapDataset;
import org.jfree.data.general.HeatMapDataset;
import org.jfree.data.general.HeatMapUtilities;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.Layer;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RefineryUtilities;

public class CrossSectionDemo1
extends ApplicationFrame {
    public CrossSectionDemo1(String string) {
        super(string);
        JPanel jPanel = CrossSectionDemo1.createDemoPanel();
        this.setContentPane((Container)jPanel);
    }

    private static HeatMapDataset createMapDataset() {
        DefaultHeatMapDataset defaultHeatMapDataset = new DefaultHeatMapDataset(501, 501, -250.0, 250.0, -250.0, 250.0);
        for (int i = 0; i < 501; ++i) {
            for (int j = 0; j < 501; ++j) {
                defaultHeatMapDataset.setZValue(i, j, Math.sin(Math.sqrt(i * j) / 10.0));
            }
        }
        return defaultHeatMapDataset;
    }

    public static JPanel createDemoPanel() {
        return new MyDemoPanel();
    }

    public static void main(String[] arrstring) {
        CrossSectionDemo1 crossSectionDemo1 = new CrossSectionDemo1("JFreeChart: CrossSectionDemo1");
        crossSectionDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)crossSectionDemo1));
        crossSectionDemo1.setVisible(true);
    }

    static class MyDemoPanel
    extends DemoPanel
    implements ChangeListener,
    ChartChangeListener {
        private HeatMapDataset dataset;
        private JFreeChart mainChart;
        private JFreeChart subchart1;
        private JFreeChart subchart2;
        private JSlider slider1;
        private JSlider slider2;
        private Crosshair crosshair1;
        private Crosshair crosshair2;
        private Range lastXRange;
        private Range lastYRange;

        public MyDemoPanel() {
            super(new BorderLayout());
            ChartPanel chartPanel = (ChartPanel)this.createMainPanel();
            chartPanel.setPreferredSize(new Dimension(500, 270));
            CrosshairOverlay crosshairOverlay = new CrosshairOverlay();
            this.crosshair1 = new Crosshair(0.0);
            this.crosshair1.setPaint((Paint)Color.red);
            this.crosshair2 = new Crosshair(0.0);
            this.crosshair2.setPaint((Paint)Color.blue);
            crosshairOverlay.addDomainCrosshair(this.crosshair1);
            crosshairOverlay.addRangeCrosshair(this.crosshair2);
            chartPanel.addOverlay((Overlay)crosshairOverlay);
            this.crosshair1.setLabelVisible(true);
            this.crosshair1.setLabelAnchor(RectangleAnchor.BOTTOM_RIGHT);
            this.crosshair1.setLabelBackgroundPaint((Paint)new Color(255, 255, 0, 100));
            this.crosshair2.setLabelVisible(true);
            this.crosshair2.setLabelBackgroundPaint((Paint)new Color(255, 255, 0, 100));
            this.add((Component)chartPanel);
            JPanel jPanel = new JPanel(new BorderLayout());
            XYSeriesCollection xYSeriesCollection = new XYSeriesCollection();
            this.subchart1 = ChartFactory.createXYLineChart((String)"Cross-section A", (String)"Y", (String)"Z", (XYDataset)xYSeriesCollection, (PlotOrientation)PlotOrientation.HORIZONTAL, (boolean)false, (boolean)false, (boolean)false);
            XYPlot xYPlot = (XYPlot)this.subchart1.getPlot();
            xYPlot.getDomainAxis().setLowerMargin(0.0);
            xYPlot.getDomainAxis().setUpperMargin(0.0);
            xYPlot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
            ChartPanel chartPanel2 = new ChartPanel(this.subchart1);
            chartPanel2.setMinimumDrawWidth(0);
            chartPanel2.setMinimumDrawHeight(0);
            chartPanel2.setPreferredSize(new Dimension(200, 150));
            this.slider1 = new JSlider(-250, 250, 0);
            this.slider1.addChangeListener(this);
            this.slider1.setOrientation(1);
            jPanel.add((Component)chartPanel2);
            jPanel.add((Component)this.slider1, "West");
            JPanel jPanel2 = new JPanel(new BorderLayout());
            XYSeriesCollection xYSeriesCollection2 = new XYSeriesCollection();
            this.subchart2 = ChartFactory.createXYLineChart((String)"Cross-section B", (String)"X", (String)"Z", (XYDataset)xYSeriesCollection2, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)false, (boolean)false, (boolean)false);
            XYPlot xYPlot2 = (XYPlot)this.subchart2.getPlot();
            xYPlot2.getDomainAxis().setLowerMargin(0.0);
            xYPlot2.getDomainAxis().setUpperMargin(0.0);
            xYPlot2.getRenderer().setSeriesPaint(0, (Paint)Color.blue);
            ChartPanel chartPanel3 = new ChartPanel(this.subchart2);
            chartPanel3.setMinimumDrawWidth(0);
            chartPanel3.setMinimumDrawHeight(0);
            chartPanel3.setPreferredSize(new Dimension(200, 150));
            JPanel jPanel3 = new JPanel();
            jPanel3.setPreferredSize(new Dimension(200, 10));
            jPanel2.add((Component)jPanel3, "East");
            this.slider2 = new JSlider(-250, 250, 0);
            this.slider2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 200));
            this.slider2.addChangeListener(this);
            jPanel2.add((Component)chartPanel3);
            jPanel2.add((Component)this.slider2, "North");
            this.add((Component)jPanel, "East");
            this.add((Component)jPanel2, "South");
            this.mainChart.setNotify(true);
        }

        public JPanel createMainPanel() {
            this.mainChart = this.createChart((XYDataset)new XYSeriesCollection());
            this.mainChart.addChangeListener((ChartChangeListener)this);
            ChartPanel chartPanel = new ChartPanel(this.mainChart);
            chartPanel.setFillZoomRectangle(true);
            chartPanel.setMouseWheelEnabled(true);
            return chartPanel;
        }

        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            if (changeEvent.getSource() == this.slider1) {
                this.crosshair2.setValue((double)this.slider1.getValue());
                int n = this.slider1.getValue() - this.slider1.getMinimum();
                XYDataset xYDataset = HeatMapUtilities.extractColumnFromHeatMapDataset((HeatMapDataset)this.dataset, (int)n, (Comparable)((Object)"Y1"));
                this.subchart2.getXYPlot().setDataset(xYDataset);
            } else if (changeEvent.getSource() == this.slider2) {
                this.crosshair1.setValue((double)this.slider2.getValue());
                int n = this.slider2.getValue() - this.slider2.getMinimum();
                XYDataset xYDataset = HeatMapUtilities.extractRowFromHeatMapDataset((HeatMapDataset)this.dataset, (int)n, (Comparable)((Object)"Y2"));
                this.subchart1.getXYPlot().setDataset(xYDataset);
            }
        }

        public void chartChanged(ChartChangeEvent chartChangeEvent) {
            XYPlot xYPlot;
            XYPlot xYPlot2 = (XYPlot)this.mainChart.getPlot();
            if (!xYPlot2.getDomainAxis().getRange().equals((Object)this.lastXRange)) {
                this.lastXRange = xYPlot2.getDomainAxis().getRange();
                xYPlot = (XYPlot)this.subchart2.getPlot();
                xYPlot.getDomainAxis().setRange(this.lastXRange);
            }
            if (!xYPlot2.getRangeAxis().getRange().equals((Object)this.lastYRange)) {
                this.lastYRange = xYPlot2.getRangeAxis().getRange();
                xYPlot = (XYPlot)this.subchart1.getPlot();
                xYPlot.getDomainAxis().setRange(this.lastYRange);
            }
        }

        private JFreeChart createChart(XYDataset xYDataset) {
            JFreeChart jFreeChart = ChartFactory.createScatterPlot((String)"CrossSectionDemo1", (String)"X", (String)"Y", (XYDataset)xYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)false, (boolean)false);
            this.dataset = CrossSectionDemo1.createMapDataset();
            GrayPaintScale grayPaintScale = new GrayPaintScale(-1.0, 1.0, 128);
            BufferedImage bufferedImage = HeatMapUtilities.createHeatMapImage((HeatMapDataset)this.dataset, (PaintScale)grayPaintScale);
            XYDataImageAnnotation xYDataImageAnnotation = new XYDataImageAnnotation((Image)bufferedImage, -250.5, -250.5, 501.0, 501.0, true);
            XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
            xYPlot.setDomainPannable(true);
            xYPlot.setRangePannable(true);
            xYPlot.getRenderer().addAnnotation((XYAnnotation)xYDataImageAnnotation, Layer.BACKGROUND);
            NumberAxis numberAxis = (NumberAxis)xYPlot.getDomainAxis();
            numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
            numberAxis.setLowerMargin(0.0);
            numberAxis.setUpperMargin(0.0);
            NumberAxis numberAxis2 = (NumberAxis)xYPlot.getRangeAxis();
            numberAxis2.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
            numberAxis2.setLowerMargin(0.0);
            numberAxis2.setUpperMargin(0.0);
            return jFreeChart;
        }
    }

}

