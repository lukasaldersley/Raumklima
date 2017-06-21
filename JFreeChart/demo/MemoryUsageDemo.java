/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
 *  org.jfree.data.time.Millisecond
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.XYDataset
 */
package demo;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

public class MemoryUsageDemo
extends JPanel {
    private TimeSeries total = new TimeSeries((Comparable)((Object)"Total Memory"));
    private TimeSeries free;

    public MemoryUsageDemo(int n) {
        super(new BorderLayout());
        this.total.setMaximumItemAge((long)n);
        this.free = new TimeSeries((Comparable)((Object)"Free Memory"));
        this.free.setMaximumItemAge((long)n);
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        timeSeriesCollection.addSeries(this.total);
        timeSeriesCollection.addSeries(this.free);
        DateAxis dateAxis = new DateAxis("Time");
        NumberAxis numberAxis = new NumberAxis("Memory");
        dateAxis.setTickLabelFont(new Font("SansSerif", 0, 12));
        numberAxis.setTickLabelFont(new Font("SansSerif", 0, 12));
        dateAxis.setLabelFont(new Font("SansSerif", 0, 14));
        numberAxis.setLabelFont(new Font("SansSerif", 0, 14));
        XYLineAndShapeRenderer xYLineAndShapeRenderer = new XYLineAndShapeRenderer(true, false);
        xYLineAndShapeRenderer.setSeriesPaint(0, (Paint)Color.red);
        xYLineAndShapeRenderer.setSeriesPaint(1, (Paint)Color.green);
        xYLineAndShapeRenderer.setSeriesStroke(0, (Stroke)new BasicStroke(3.0f, 0, 2));
        xYLineAndShapeRenderer.setSeriesStroke(1, (Stroke)new BasicStroke(3.0f, 0, 2));
        XYPlot xYPlot = new XYPlot((XYDataset)timeSeriesCollection, (ValueAxis)dateAxis, (ValueAxis)numberAxis, (XYItemRenderer)xYLineAndShapeRenderer);
        dateAxis.setAutoRange(true);
        dateAxis.setLowerMargin(0.0);
        dateAxis.setUpperMargin(0.0);
        dateAxis.setTickLabelsVisible(true);
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        JFreeChart jFreeChart = new JFreeChart("JVM Memory Usage", new Font("SansSerif", 1, 24), (Plot)xYPlot, true);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        ChartPanel chartPanel = new ChartPanel(jFreeChart, true);
        chartPanel.setBorder((Border)BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4), BorderFactory.createLineBorder(Color.black)));
        this.add((Component)chartPanel);
    }

    private void addTotalObservation(double d) {
        this.total.add((RegularTimePeriod)new Millisecond(), d);
    }

    private void addFreeObservation(double d) {
        this.free.add((RegularTimePeriod)new Millisecond(), d);
    }

    public static void main(String[] arrstring) {
        JFrame jFrame = new JFrame("Memory Usage Demo");
        MemoryUsageDemo memoryUsageDemo = new MemoryUsageDemo(30000);
        jFrame.getContentPane().add((Component)memoryUsageDemo, "Center");
        jFrame.setBounds(200, 120, 600, 280);
        jFrame.setVisible(true);
        MemoryUsageDemo memoryUsageDemo2 = memoryUsageDemo;
        memoryUsageDemo2.getClass();
        memoryUsageDemo2.new DataGenerator(100).start();
        jFrame.addWindowListener(new WindowAdapter(){

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    class DataGenerator
    extends Timer
    implements ActionListener {
        DataGenerator(int n) {
            super(n, null);
            this.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            long l = Runtime.getRuntime().freeMemory();
            long l2 = Runtime.getRuntime().totalMemory();
            MemoryUsageDemo.this.addTotalObservation(l2);
            MemoryUsageDemo.this.addFreeObservation(l);
        }
    }

}

