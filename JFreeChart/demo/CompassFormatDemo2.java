/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.CompassFormat
 *  org.jfree.chart.axis.ModuloAxis
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.NumberTickUnit
 *  org.jfree.chart.axis.TickUnit
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.TickUnits
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYAreaRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
 *  org.jfree.data.Range
 *  org.jfree.data.time.Minute
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import demo.DemoPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Paint;
import java.awt.Window;
import java.text.NumberFormat;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CompassFormat;
import org.jfree.chart.axis.ModuloAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.TickUnit;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.TickUnits;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.Range;
import org.jfree.data.time.Minute;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class CompassFormatDemo2
extends ApplicationFrame {
    public CompassFormatDemo2(String string) {
        super(string);
        this.setContentPane((Container)new MyDemoPanel());
    }

    public static JPanel createDemoPanel() {
        return new MyDemoPanel();
    }

    public static void main(String[] arrstring) {
        CompassFormatDemo2 compassFormatDemo2 = new CompassFormatDemo2("JFreeChart: CompassFormatDemo2.java");
        compassFormatDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)compassFormatDemo2));
        compassFormatDemo2.setVisible(true);
    }

    private static class MyDemoPanel
    extends DemoPanel
    implements ChangeListener {
        private JSlider directionSlider;
        private JSlider fieldSlider;
        private ModuloAxis rangeAxis;
        private double direction = 0.0;
        private double degrees = 45.0;

        public MyDemoPanel() {
            super(new BorderLayout());
            JPanel jPanel = new JPanel(new GridLayout(1, 2));
            this.fieldSlider = new JSlider(1, 10, 180, 45);
            this.fieldSlider.setPaintLabels(true);
            this.fieldSlider.setPaintTicks(true);
            this.fieldSlider.setMajorTickSpacing(10);
            this.fieldSlider.setMinorTickSpacing(5);
            this.fieldSlider.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            this.fieldSlider.addChangeListener(this);
            this.directionSlider = new JSlider(1, 0, 360, 0);
            this.directionSlider.setMajorTickSpacing(30);
            this.directionSlider.setMinorTickSpacing(5);
            this.directionSlider.setPaintLabels(true);
            this.directionSlider.setPaintTicks(true);
            this.directionSlider.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            this.directionSlider.setPaintTrack(true);
            this.directionSlider.addChangeListener(this);
            jPanel.add(this.fieldSlider);
            jPanel.add(this.directionSlider);
            JFreeChart jFreeChart = this.createChart();
            this.addChart(jFreeChart);
            ChartPanel chartPanel = new ChartPanel(jFreeChart);
            chartPanel.setPreferredSize(new Dimension(500, 270));
            this.add((Component)jPanel, "West");
            this.add((Component)chartPanel);
        }

        private XYDataset createDirectionDataset(int n) {
            TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
            TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Wind Direction"));
            Minute minute = new Minute();
            double d = 0.0;
            for (int i = 0; i < n; ++i) {
                timeSeries.add((RegularTimePeriod)minute, d);
                minute = minute.next();
                if ((d += (Math.random() - 0.5) * 15.0) < 0.0) {
                    d += 360.0;
                    continue;
                }
                if (d <= 360.0) continue;
                d -= 360.0;
            }
            timeSeriesCollection.addSeries(timeSeries);
            return timeSeriesCollection;
        }

        private XYDataset createForceDataset(int n) {
            TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
            TimeSeries timeSeries = new TimeSeries((Comparable)((Object)"Wind Force"));
            Minute minute = new Minute();
            double d = 3.0;
            for (int i = 0; i < n; ++i) {
                timeSeries.add((RegularTimePeriod)minute, d);
                minute = minute.next();
                d = Math.max(0.5, d + (Math.random() - 0.5) * 0.5);
            }
            timeSeriesCollection.addSeries(timeSeries);
            return timeSeriesCollection;
        }

        private JFreeChart createChart() {
            XYDataset xYDataset = this.createDirectionDataset(100);
            JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Time", (String)"Date", (String)"Direction", (XYDataset)xYDataset, (boolean)true, (boolean)true, (boolean)false);
            XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
            xYPlot.getDomainAxis().setLowerMargin(0.0);
            xYPlot.getDomainAxis().setUpperMargin(0.0);
            this.rangeAxis = new ModuloAxis("Direction", new Range(0.0, 360.0));
            TickUnits tickUnits = new TickUnits();
            tickUnits.add((TickUnit)new NumberTickUnit(180.0, (NumberFormat)new CompassFormat()));
            tickUnits.add((TickUnit)new NumberTickUnit(90.0, (NumberFormat)new CompassFormat()));
            tickUnits.add((TickUnit)new NumberTickUnit(45.0, (NumberFormat)new CompassFormat()));
            tickUnits.add((TickUnit)new NumberTickUnit(22.5, (NumberFormat)new CompassFormat()));
            this.rangeAxis.setStandardTickUnits((TickUnitSource)tickUnits);
            XYLineAndShapeRenderer xYLineAndShapeRenderer = new XYLineAndShapeRenderer();
            xYLineAndShapeRenderer.setBaseLinesVisible(false);
            xYLineAndShapeRenderer.setBaseShapesVisible(true);
            xYPlot.setRenderer((XYItemRenderer)xYLineAndShapeRenderer);
            xYPlot.setRangeAxis((ValueAxis)this.rangeAxis);
            this.rangeAxis.setDisplayRange(-45.0, 45.0);
            XYAreaRenderer xYAreaRenderer = new XYAreaRenderer();
            NumberAxis numberAxis = new NumberAxis("Force");
            numberAxis.setRange(0.0, 12.0);
            xYAreaRenderer.setSeriesPaint(0, (Paint)new Color(0, 0, 255, 128));
            xYPlot.setDataset(1, this.createForceDataset(100));
            xYPlot.setRenderer(1, (XYItemRenderer)xYAreaRenderer);
            xYPlot.setRangeAxis(1, (ValueAxis)numberAxis);
            xYPlot.mapDatasetToRangeAxis(1, 1);
            ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
            return jFreeChart;
        }

        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            if (changeEvent.getSource() == this.directionSlider) {
                this.direction = this.directionSlider.getValue();
                this.rangeAxis.setDisplayRange(this.direction - this.degrees, this.direction + this.degrees);
            } else if (changeEvent.getSource() == this.fieldSlider) {
                this.degrees = this.fieldSlider.getValue();
                this.rangeAxis.setDisplayRange(this.direction - this.degrees, this.direction + this.degrees);
            }
        }
    }

}

