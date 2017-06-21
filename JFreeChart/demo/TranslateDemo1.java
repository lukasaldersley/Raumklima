/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.data.Range
 *  org.jfree.data.general.DatasetChangeEvent
 *  org.jfree.data.general.DatasetChangeListener
 *  org.jfree.data.general.DatasetUtilities
 *  org.jfree.data.time.Minute
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.AbstractXYDataset
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import demo.DemoPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Window;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.Range;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.time.Minute;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.AbstractXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TranslateDemo1
extends ApplicationFrame {
    public TranslateDemo1(String string) {
        super(string);
        this.setContentPane((Container)TranslateDemo1.createDemoPanel());
    }

    public static JPanel createDemoPanel() {
        return new MyDemoPanel();
    }

    public static void main(String[] arrstring) {
        TranslateDemo1 translateDemo1 = new TranslateDemo1("Translate Demo 1");
        translateDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)translateDemo1));
        translateDemo1.setVisible(true);
    }

    private static class MyDemoPanel
    extends DemoPanel
    implements ChangeListener {
        private TimeSeries series;
        private ChartPanel chartPanel;
        private JFreeChart chart;
        private JSlider slider;
        private TranslatingXYDataset dataset;

        public MyDemoPanel() {
            super(new BorderLayout());
            this.chart = this.createChart();
            this.addChart(this.chart);
            this.chartPanel = new ChartPanel(this.chart);
            this.chartPanel.setPreferredSize(new Dimension(600, 270));
            this.chartPanel.setDomainZoomable(true);
            this.chartPanel.setRangeZoomable(true);
            CompoundBorder compoundBorder = BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4), BorderFactory.createEtchedBorder());
            this.chartPanel.setBorder((Border)compoundBorder);
            this.add((Component)this.chartPanel);
            JPanel jPanel = new JPanel(new BorderLayout());
            jPanel.setBorder(BorderFactory.createEmptyBorder(0, 4, 4, 4));
            this.slider = new JSlider(-200, 200, 0);
            this.slider.setPaintLabels(true);
            this.slider.setMajorTickSpacing(50);
            this.slider.setPaintTicks(true);
            this.slider.addChangeListener(this);
            jPanel.add(this.slider);
            this.add((Component)jPanel, "South");
        }

        private JFreeChart createChart() {
            XYDataset xYDataset = this.createDataset("Random 1", 100.0, (RegularTimePeriod)new Minute(), 200);
            JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Translate Demo 1", (String)"Time of Day", (String)"Value", (XYDataset)xYDataset);
            XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
            xYPlot.setOrientation(PlotOrientation.VERTICAL);
            xYPlot.setDomainCrosshairVisible(true);
            xYPlot.setDomainCrosshairLockedOnData(false);
            xYPlot.setRangeCrosshairVisible(false);
            DateAxis dateAxis = (DateAxis)xYPlot.getDomainAxis();
            Range range = DatasetUtilities.findDomainBounds((XYDataset)this.dataset);
            dateAxis.setRange(range);
            return jFreeChart;
        }

        private XYDataset createDataset(String string, double d, RegularTimePeriod regularTimePeriod, int n) {
            this.series = new TimeSeries((Comparable)((Object)string));
            RegularTimePeriod regularTimePeriod2 = regularTimePeriod;
            double d2 = d;
            for (int i = 0; i < n; ++i) {
                this.series.add(regularTimePeriod2, d2);
                regularTimePeriod2 = regularTimePeriod2.next();
                d2 *= 1.0 + (Math.random() - 0.495) / 10.0;
            }
            TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
            timeSeriesCollection.addSeries(this.series);
            this.dataset = new TranslatingXYDataset((XYDataset)timeSeriesCollection);
            return this.dataset;
        }

        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            int n = this.slider.getValue();
            this.dataset.setTranslate((double)(n * 60) * 1000.0);
        }

        static class TranslatingXYDataset
        extends AbstractXYDataset
        implements XYDataset,
        DatasetChangeListener {
            private XYDataset underlying;
            private double translate;

            public TranslatingXYDataset(XYDataset xYDataset) {
                this.underlying = xYDataset;
                this.underlying.addChangeListener((DatasetChangeListener)this);
                this.translate = 0.0;
            }

            public double getTranslate() {
                return this.translate;
            }

            public void setTranslate(double d) {
                this.translate = d;
                this.fireDatasetChanged();
            }

            public int getItemCount(int n) {
                return this.underlying.getItemCount(n);
            }

            public double getXValue(int n, int n2) {
                return this.underlying.getXValue(n, n2) + this.translate;
            }

            public Number getX(int n, int n2) {
                return new Double(this.getXValue(n, n2));
            }

            public Number getY(int n, int n2) {
                return new Double(this.getYValue(n, n2));
            }

            public double getYValue(int n, int n2) {
                return this.underlying.getYValue(n, n2);
            }

            public int getSeriesCount() {
                return this.underlying.getSeriesCount();
            }

            public Comparable getSeriesKey(int n) {
                return this.underlying.getSeriesKey(n);
            }

            public void datasetChanged(DatasetChangeEvent datasetChangeEvent) {
                this.fireDatasetChanged();
            }
        }

    }

}

