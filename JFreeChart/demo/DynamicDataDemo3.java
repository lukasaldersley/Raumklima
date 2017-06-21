/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.DateAxis
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.CombinedDomainXYPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.StandardXYItemRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.title.LegendTitle
 *  org.jfree.chart.title.Title
 *  org.jfree.data.time.Millisecond
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RectangleEdge
 *  org.jfree.ui.RectangleInsets
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.util.UnitType
 */
package demo;

import demo.DemoPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Paint;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.UnitType;

public class DynamicDataDemo3
extends ApplicationFrame {
    public DynamicDataDemo3(String string) {
        super(string);
        this.setContentPane((Container)DynamicDataDemo3.createDemoPanel());
    }

    public static JPanel createDemoPanel() {
        return new MyDemoPanel();
    }

    public static void main(String[] arrstring) {
        DynamicDataDemo3 dynamicDataDemo3 = new DynamicDataDemo3("JFreeChart: DynamicDataDemo3.java");
        dynamicDataDemo3.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)dynamicDataDemo3));
        dynamicDataDemo3.setVisible(true);
    }

    static class MyDemoPanel
    extends DemoPanel
    implements ActionListener {
        public static final int SUBPLOT_COUNT = 3;
        private TimeSeriesCollection[] datasets;
        private double[] lastValue = new double[3];

        public MyDemoPanel() {
            ChartPanel chartPanel;
            LegendTitle legendTitle;
            ValueAxis valueAxis;
            super(new BorderLayout());
            CombinedDomainXYPlot combinedDomainXYPlot = new CombinedDomainXYPlot((ValueAxis)new DateAxis("Time"));
            this.datasets = new TimeSeriesCollection[3];
            for (int i = 0; i < 3; ++i) {
                this.lastValue[i] = 100.0;
                legendTitle = new TimeSeries((Comparable)((Object)("Random " + i)));
                this.datasets[i] = new TimeSeriesCollection((TimeSeries)legendTitle);
                valueAxis = new NumberAxis("Y" + i);
                valueAxis.setAutoRangeIncludesZero(false);
                chartPanel = new XYPlot((XYDataset)this.datasets[i], null, valueAxis, (XYItemRenderer)new StandardXYItemRenderer());
                chartPanel.setBackgroundPaint((Paint)Color.lightGray);
                chartPanel.setDomainGridlinePaint((Paint)Color.white);
                chartPanel.setRangeGridlinePaint((Paint)Color.white);
                combinedDomainXYPlot.add((XYPlot)chartPanel);
            }
            JFreeChart jFreeChart = new JFreeChart("Dynamic Data Demo 3", (Plot)combinedDomainXYPlot);
            this.addChart(jFreeChart);
            legendTitle = (LegendTitle)jFreeChart.getSubtitle(0);
            legendTitle.setPosition(RectangleEdge.RIGHT);
            legendTitle.setMargin(new RectangleInsets(UnitType.ABSOLUTE, 0.0, 4.0, 0.0, 4.0));
            jFreeChart.setBorderPaint((Paint)Color.black);
            jFreeChart.setBorderVisible(true);
            valueAxis = combinedDomainXYPlot.getDomainAxis();
            valueAxis.setAutoRange(true);
            valueAxis.setFixedAutoRange(20000.0);
            ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
            chartPanel = new ChartPanel(jFreeChart);
            this.add((Component)chartPanel);
            JPanel jPanel = new JPanel(new FlowLayout());
            for (int i = 0; i < 3; ++i) {
                JButton jButton = new JButton("Series " + i);
                jButton.setActionCommand("ADD_DATA_" + i);
                jButton.addActionListener(this);
                jPanel.add(jButton);
            }
            JButton jButton = new JButton("ALL");
            jButton.setActionCommand("ADD_ALL");
            jButton.addActionListener(this);
            jPanel.add(jButton);
            this.add((Component)jPanel, "South");
            chartPanel.setPreferredSize(new Dimension(500, 470));
            chartPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            for (int i = 0; i < 3; ++i) {
                if (!actionEvent.getActionCommand().endsWith(String.valueOf(i))) continue;
                Millisecond millisecond = new Millisecond();
                System.out.println("Now = " + millisecond.toString());
                this.lastValue[i] = this.lastValue[i] * (0.9 + 0.2 * Math.random());
                this.datasets[i].getSeries(0).add((RegularTimePeriod)new Millisecond(), this.lastValue[i]);
            }
            if (actionEvent.getActionCommand().equals("ADD_ALL")) {
                Millisecond millisecond = new Millisecond();
                System.out.println("Now = " + millisecond.toString());
                for (int i = 0; i < 3; ++i) {
                    this.lastValue[i] = this.lastValue[i] * (0.9 + 0.2 * Math.random());
                    this.datasets[i].getSeries(0).add((RegularTimePeriod)new Millisecond(), this.lastValue[i]);
                }
            }
        }
    }

}

