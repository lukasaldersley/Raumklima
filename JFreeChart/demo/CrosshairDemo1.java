/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.event.ChartProgressEvent
 *  org.jfree.chart.event.ChartProgressListener
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.data.Range
 *  org.jfree.data.time.Minute
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.time.TimeSeriesDataItem
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.DateCellRenderer
 *  org.jfree.ui.NumberCellRenderer
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.ChartProgressEvent;
import org.jfree.chart.event.ChartProgressListener;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.Range;
import org.jfree.data.time.Minute;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.TimeSeriesDataItem;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.DateCellRenderer;
import org.jfree.ui.NumberCellRenderer;
import org.jfree.ui.RefineryUtilities;

public class CrosshairDemo1
extends ApplicationFrame {
    public CrosshairDemo1(String string) {
        super(string);
        this.setContentPane((Container)new MyDemoPanel());
    }

    public static JPanel createDemoPanel() {
        return new MyDemoPanel();
    }

    public static void main(String[] arrstring) {
        CrosshairDemo1 crosshairDemo1 = new CrosshairDemo1("JFreeChart: CrosshairDemo1.java");
        crosshairDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)crosshairDemo1));
        crosshairDemo1.setVisible(true);
    }

    static class DemoTableModel
    extends AbstractTableModel {
        private Object[][] data;

        public DemoTableModel(int n) {
            this.data = new Object[n][7];
        }

        @Override
        public int getColumnCount() {
            return 7;
        }

        @Override
        public int getRowCount() {
            return 1;
        }

        @Override
        public Object getValueAt(int n, int n2) {
            return this.data[n][n2];
        }

        @Override
        public void setValueAt(Object object, int n, int n2) {
            this.data[n][n2] = object;
            this.fireTableDataChanged();
        }

        @Override
        public String getColumnName(int n) {
            switch (n) {
                case 0: {
                    return "Series Name:";
                }
                case 1: {
                    return "X:";
                }
                case 2: {
                    return "Y:";
                }
                case 3: {
                    return "X (prev)";
                }
                case 4: {
                    return "Y (prev):";
                }
                case 5: {
                    return "X (next):";
                }
                case 6: {
                    return "Y (next):";
                }
            }
            return null;
        }
    }

    private static class MyDemoPanel
    extends DemoPanel
    implements ChangeListener,
    ChartProgressListener {
        private TimeSeries series;
        private ChartPanel chartPanel;
        private DemoTableModel model;
        private JFreeChart chart;
        private JSlider slider;

        public MyDemoPanel() {
            super(new BorderLayout());
            this.chart = this.createChart();
            this.addChart(this.chart);
            this.chart.addProgressListener((ChartProgressListener)this);
            this.chartPanel = new ChartPanel(this.chart);
            this.chartPanel.setPreferredSize(new Dimension(600, 250));
            this.chartPanel.setDomainZoomable(true);
            this.chartPanel.setRangeZoomable(true);
            CompoundBorder compoundBorder = BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4), BorderFactory.createEtchedBorder());
            this.chartPanel.setBorder((Border)compoundBorder);
            this.add((Component)this.chartPanel);
            JPanel jPanel = new JPanel(new BorderLayout());
            jPanel.setPreferredSize(new Dimension(400, 80));
            jPanel.setBorder(BorderFactory.createEmptyBorder(0, 4, 4, 4));
            this.model = new DemoTableModel(3);
            XYPlot xYPlot = (XYPlot)this.chart.getPlot();
            this.model.setValueAt(xYPlot.getDataset().getSeriesKey(0), 0, 0);
            this.model.setValueAt(new Double("0.00"), 0, 1);
            this.model.setValueAt(new Double("0.00"), 0, 2);
            this.model.setValueAt(new Double("0.00"), 0, 3);
            this.model.setValueAt(new Double("0.00"), 0, 4);
            this.model.setValueAt(new Double("0.00"), 0, 5);
            this.model.setValueAt(new Double("0.00"), 0, 6);
            JTable jTable = new JTable(this.model);
            DateCellRenderer dateCellRenderer = new DateCellRenderer((DateFormat)new SimpleDateFormat("HH:mm"));
            NumberCellRenderer numberCellRenderer = new NumberCellRenderer();
            jTable.getColumnModel().getColumn(1).setCellRenderer((TableCellRenderer)dateCellRenderer);
            jTable.getColumnModel().getColumn(2).setCellRenderer((TableCellRenderer)numberCellRenderer);
            jTable.getColumnModel().getColumn(3).setCellRenderer((TableCellRenderer)dateCellRenderer);
            jTable.getColumnModel().getColumn(4).setCellRenderer((TableCellRenderer)numberCellRenderer);
            jTable.getColumnModel().getColumn(5).setCellRenderer((TableCellRenderer)dateCellRenderer);
            jTable.getColumnModel().getColumn(6).setCellRenderer((TableCellRenderer)numberCellRenderer);
            JScrollPane jScrollPane = new JScrollPane(jTable);
            jPanel.add(jScrollPane);
            this.slider = new JSlider(0, 100, 50);
            this.slider.addChangeListener(this);
            jPanel.add((Component)this.slider, "South");
            this.add((Component)jPanel, "South");
        }

        private JFreeChart createChart() {
            XYDataset xYDataset = this.createDataset("Random 1", 100.0, (RegularTimePeriod)new Minute(), 200);
            JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Crosshair Demo 1", (String)"Time of Day", (String)"Value", (XYDataset)xYDataset);
            XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
            xYPlot.setOrientation(PlotOrientation.VERTICAL);
            xYPlot.setDomainCrosshairVisible(true);
            xYPlot.setDomainCrosshairLockedOnData(false);
            xYPlot.setRangeCrosshairVisible(false);
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
            return timeSeriesCollection;
        }

        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            int n = this.slider.getValue();
            XYPlot xYPlot = (XYPlot)this.chart.getPlot();
            ValueAxis valueAxis = xYPlot.getDomainAxis();
            Range range = valueAxis.getRange();
            double d = valueAxis.getLowerBound() + (double)n / 100.0 * range.getLength();
            xYPlot.setDomainCrosshairValue(d);
        }

        public void chartProgress(ChartProgressEvent chartProgressEvent) {
            JFreeChart jFreeChart;
            if (chartProgressEvent.getType() != 2) {
                return;
            }
            if (this.chartPanel != null && (jFreeChart = this.chartPanel.getChart()) != null) {
                XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
                XYDataset xYDataset = xYPlot.getDataset();
                Comparable comparable = xYDataset.getSeriesKey(0);
                double d = xYPlot.getDomainCrosshairValue();
                this.model.setValueAt(comparable, 0, 0);
                long l = (long)d;
                this.model.setValueAt(new Long(l), 0, 1);
                int n = this.series.getIndex((RegularTimePeriod)new Minute(new Date(l)));
                if (n >= 0) {
                    TimeSeriesDataItem timeSeriesDataItem = this.series.getDataItem(Math.min(199, Math.max(0, n)));
                    TimeSeriesDataItem timeSeriesDataItem2 = this.series.getDataItem(Math.max(0, n - 1));
                    TimeSeriesDataItem timeSeriesDataItem3 = this.series.getDataItem(Math.min(199, n + 1));
                    long l2 = timeSeriesDataItem.getPeriod().getMiddleMillisecond();
                    double d2 = timeSeriesDataItem.getValue().doubleValue();
                    long l3 = timeSeriesDataItem2.getPeriod().getMiddleMillisecond();
                    double d3 = timeSeriesDataItem2.getValue().doubleValue();
                    long l4 = timeSeriesDataItem3.getPeriod().getMiddleMillisecond();
                    double d4 = timeSeriesDataItem3.getValue().doubleValue();
                    this.model.setValueAt(new Long(l2), 0, 1);
                    this.model.setValueAt(new Double(d2), 0, 2);
                    this.model.setValueAt(new Long(l3), 0, 3);
                    this.model.setValueAt(new Double(d3), 0, 4);
                    this.model.setValueAt(new Long(l4), 0, 5);
                    this.model.setValueAt(new Double(d4), 0, 6);
                }
            }
        }
    }

}

