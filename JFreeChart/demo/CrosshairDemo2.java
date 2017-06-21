/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.event.ChartChangeEvent
 *  org.jfree.chart.event.ChartChangeListener
 *  org.jfree.chart.event.ChartProgressEvent
 *  org.jfree.chart.event.ChartProgressListener
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
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
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.ChartChangeEvent;
import org.jfree.chart.event.ChartChangeListener;
import org.jfree.chart.event.ChartProgressEvent;
import org.jfree.chart.event.ChartProgressListener;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
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

public class CrosshairDemo2
extends ApplicationFrame {
    public CrosshairDemo2(String string) {
        super(string);
        this.setContentPane((Container)new MyDemoPanel());
    }

    public static JPanel createDemoPanel() {
        return new MyDemoPanel();
    }

    public static void main(String[] arrstring) {
        CrosshairDemo2 crosshairDemo2 = new CrosshairDemo2("JFreeChart: CrosshairDemo2.java");
        crosshairDemo2.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)crosshairDemo2));
        crosshairDemo2.setVisible(true);
    }

    static class DemoTableModel
    extends AbstractTableModel
    implements TableModel {
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
            return this.data.length;
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
    implements ChartChangeListener,
    ChartProgressListener {
        private static final int SERIES_COUNT = 4;
        private TimeSeriesCollection[] datasets = new TimeSeriesCollection[4];
        private TimeSeries[] series = new TimeSeries[4];
        private ChartPanel chartPanel;
        private DemoTableModel model;

        public MyDemoPanel() {
            XYPlot xYPlot;
            super(new BorderLayout());
            JPanel jPanel = new JPanel(new BorderLayout());
            JFreeChart jFreeChart = this.createChart();
            this.addChart(jFreeChart);
            this.chartPanel = new ChartPanel(jFreeChart);
            this.chartPanel.setPreferredSize(new Dimension(600, 270));
            this.chartPanel.setDomainZoomable(true);
            this.chartPanel.setRangeZoomable(true);
            CompoundBorder compoundBorder = BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4), BorderFactory.createEtchedBorder());
            this.chartPanel.setBorder((Border)compoundBorder);
            jPanel.add((Component)this.chartPanel);
            JPanel jPanel2 = new JPanel(new BorderLayout());
            jPanel2.setPreferredSize(new Dimension(400, 120));
            jPanel2.setBorder(BorderFactory.createEmptyBorder(0, 4, 4, 4));
            this.model = new DemoTableModel(4);
            for (int i = 0; i < 4; ++i) {
                xYPlot = (XYPlot)jFreeChart.getPlot();
                this.model.setValueAt(xYPlot.getDataset(i).getSeriesKey(0), i, 0);
                this.model.setValueAt(new Double("0.00"), i, 1);
                this.model.setValueAt(new Double("0.00"), i, 2);
                this.model.setValueAt(new Double("0.00"), i, 3);
                this.model.setValueAt(new Double("0.00"), i, 4);
                this.model.setValueAt(new Double("0.00"), i, 5);
                this.model.setValueAt(new Double("0.00"), i, 6);
            }
            JTable jTable = new JTable(this.model);
            xYPlot = new DateCellRenderer((DateFormat)new SimpleDateFormat("HH:mm:ss"));
            NumberCellRenderer numberCellRenderer = new NumberCellRenderer();
            jTable.getColumnModel().getColumn(1).setCellRenderer((TableCellRenderer)xYPlot);
            jTable.getColumnModel().getColumn(2).setCellRenderer((TableCellRenderer)numberCellRenderer);
            jTable.getColumnModel().getColumn(3).setCellRenderer((TableCellRenderer)xYPlot);
            jTable.getColumnModel().getColumn(4).setCellRenderer((TableCellRenderer)numberCellRenderer);
            jTable.getColumnModel().getColumn(5).setCellRenderer((TableCellRenderer)xYPlot);
            jTable.getColumnModel().getColumn(6).setCellRenderer((TableCellRenderer)numberCellRenderer);
            jPanel2.add(new JScrollPane(jTable));
            jPanel.add((Component)jPanel2, "South");
            this.add(jPanel);
        }

        private XYDataset createDataset(int n, String string, double d, RegularTimePeriod regularTimePeriod, int n2) {
            this.series[n] = new TimeSeries((Comparable)((Object)string));
            RegularTimePeriod regularTimePeriod2 = regularTimePeriod;
            double d2 = d;
            for (int i = 0; i < n2; ++i) {
                this.series[n].add(regularTimePeriod2, d2);
                regularTimePeriod2 = regularTimePeriod2.next();
                d2 *= 1.0 + (Math.random() - 0.495) / 10.0;
            }
            this.datasets[n] = new TimeSeriesCollection();
            this.datasets[n].addSeries(this.series[n]);
            return this.datasets[n];
        }

        public void chartChanged(ChartChangeEvent chartChangeEvent) {
            if (this.chartPanel == null) {
                return;
            }
            JFreeChart jFreeChart = this.chartPanel.getChart();
            if (jFreeChart != null) {
                XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
                XYDataset xYDataset = xYPlot.getDataset();
                Comparable comparable = xYDataset.getSeriesKey(0);
                double d = xYPlot.getDomainCrosshairValue();
                this.model.setValueAt(comparable, 0, 0);
                long l = (long)d;
                for (int i = 0; i < 4; ++i) {
                    TimeSeriesDataItem timeSeriesDataItem;
                    Number number;
                    this.model.setValueAt(new Long(l), i, 1);
                    int[] arrn = this.datasets[i].getSurroundingItems(0, l);
                    long l2 = 0;
                    long l3 = 0;
                    double d2 = 0.0;
                    double d3 = 0.0;
                    if (arrn[0] >= 0) {
                        timeSeriesDataItem = this.series[i].getDataItem(arrn[0]);
                        l2 = timeSeriesDataItem.getPeriod().getMiddleMillisecond();
                        number = timeSeriesDataItem.getValue();
                        if (number != null) {
                            d2 = number.doubleValue();
                            this.model.setValueAt(new Double(d2), i, 4);
                        } else {
                            this.model.setValueAt(null, i, 4);
                        }
                        this.model.setValueAt(new Long(l2), i, 3);
                    } else {
                        this.model.setValueAt(new Double(0.0), i, 4);
                        this.model.setValueAt(new Double(xYPlot.getDomainAxis().getRange().getLowerBound()), i, 3);
                    }
                    if (arrn[1] >= 0) {
                        timeSeriesDataItem = this.series[i].getDataItem(arrn[1]);
                        l3 = timeSeriesDataItem.getPeriod().getMiddleMillisecond();
                        number = timeSeriesDataItem.getValue();
                        if (number != null) {
                            d3 = number.doubleValue();
                            this.model.setValueAt(new Double(d3), i, 6);
                        } else {
                            this.model.setValueAt(null, i, 6);
                        }
                        this.model.setValueAt(new Long(l3), i, 5);
                    } else {
                        this.model.setValueAt(new Double(0.0), i, 6);
                        this.model.setValueAt(new Double(xYPlot.getDomainAxis().getRange().getUpperBound()), i, 5);
                    }
                    double d4 = l3 - l2 > 0 ? d2 + ((double)l - (double)l2) / ((double)l3 - (double)l2) * (d3 - d2) : d2;
                    this.model.setValueAt(new Double(d4), i, 2);
                }
            }
        }

        private JFreeChart createChart() {
            JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Crosshair Demo 2", (String)"Time of Day", (String)"Value", (XYDataset)null, (boolean)true, (boolean)true, (boolean)false);
            XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
            XYDataset[] arrxYDataset = new XYDataset[4];
            for (int i = 0; i < 4; ++i) {
                arrxYDataset[i] = this.createDataset(i, "Series " + i, 100.0 + (double)i * 200.0, (RegularTimePeriod)new Minute(), 200);
                if (i == 0) {
                    xYPlot.setDataset(arrxYDataset[i]);
                    continue;
                }
                xYPlot.setDataset(i, arrxYDataset[i]);
                xYPlot.setRangeAxis(i, (ValueAxis)new NumberAxis("Axis " + (i + 1)));
                xYPlot.mapDatasetToRangeAxis(i, i);
                xYPlot.setRenderer(i, (XYItemRenderer)new XYLineAndShapeRenderer(true, false));
            }
            jFreeChart.addChangeListener((ChartChangeListener)this);
            jFreeChart.addProgressListener((ChartProgressListener)this);
            xYPlot.setOrientation(PlotOrientation.VERTICAL);
            xYPlot.setDomainCrosshairVisible(true);
            xYPlot.setDomainCrosshairLockedOnData(false);
            xYPlot.setRangeCrosshairVisible(false);
            ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
            return jFreeChart;
        }

        public void chartProgress(ChartProgressEvent chartProgressEvent) {
            if (chartProgressEvent.getType() != 2) {
                return;
            }
            if (this.chartPanel == null) {
                return;
            }
            JFreeChart jFreeChart = this.chartPanel.getChart();
            if (jFreeChart != null) {
                XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
                XYDataset xYDataset = xYPlot.getDataset();
                Comparable comparable = xYDataset.getSeriesKey(0);
                double d = xYPlot.getDomainCrosshairValue();
                this.model.setValueAt(comparable, 0, 0);
                long l = (long)d;
                this.model.setValueAt(new Long(l), 0, 1);
                for (int i = 0; i < 4; ++i) {
                    int n = this.series[i].getIndex((RegularTimePeriod)new Minute(new Date(l)));
                    if (n < 0) continue;
                    TimeSeriesDataItem timeSeriesDataItem = this.series[i].getDataItem(Math.min(199, Math.max(0, n)));
                    TimeSeriesDataItem timeSeriesDataItem2 = this.series[i].getDataItem(Math.max(0, n - 1));
                    TimeSeriesDataItem timeSeriesDataItem3 = this.series[i].getDataItem(Math.min(199, n + 1));
                    long l2 = timeSeriesDataItem.getPeriod().getMiddleMillisecond();
                    double d2 = timeSeriesDataItem.getValue().doubleValue();
                    long l3 = timeSeriesDataItem2.getPeriod().getMiddleMillisecond();
                    double d3 = timeSeriesDataItem2.getValue().doubleValue();
                    long l4 = timeSeriesDataItem3.getPeriod().getMiddleMillisecond();
                    double d4 = timeSeriesDataItem3.getValue().doubleValue();
                    this.model.setValueAt(new Long(l2), i, 1);
                    this.model.setValueAt(new Double(d2), i, 2);
                    this.model.setValueAt(new Long(l3), i, 3);
                    this.model.setValueAt(new Double(d3), i, 4);
                    this.model.setValueAt(new Long(l4), i, 5);
                    this.model.setValueAt(new Double(d4), i, 6);
                }
            }
        }
    }

}

