/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.AxisLocation
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.block.BlockBorder
 *  org.jfree.chart.block.BlockFrame
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.GrayPaintScale
 *  org.jfree.chart.renderer.PaintScale
 *  org.jfree.chart.renderer.xy.XYBlockRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.title.PaintScaleLegend
 *  org.jfree.chart.title.Title
 *  org.jfree.data.DomainOrder
 *  org.jfree.data.general.DatasetChangeListener
 *  org.jfree.data.general.DatasetGroup
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.XYZDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RectangleEdge
 *  org.jfree.ui.RectangleInsets
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.block.BlockFrame;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.GrayPaintScale;
import org.jfree.chart.renderer.PaintScale;
import org.jfree.chart.renderer.xy.XYBlockRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.PaintScaleLegend;
import org.jfree.chart.title.Title;
import org.jfree.data.DomainOrder;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class XYBlockChartDemo1
extends ApplicationFrame {
    public XYBlockChartDemo1(String string) {
        super(string);
        JPanel jPanel = XYBlockChartDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(XYZDataset xYZDataset) {
        NumberAxis numberAxis = new NumberAxis("X");
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberAxis.setLowerMargin(0.0);
        numberAxis.setUpperMargin(0.0);
        numberAxis.setAxisLinePaint((Paint)Color.white);
        numberAxis.setTickMarkPaint((Paint)Color.white);
        NumberAxis numberAxis2 = new NumberAxis("Y");
        numberAxis2.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberAxis2.setLowerMargin(0.0);
        numberAxis2.setUpperMargin(0.0);
        numberAxis2.setAxisLinePaint((Paint)Color.white);
        numberAxis2.setTickMarkPaint((Paint)Color.white);
        XYBlockRenderer xYBlockRenderer = new XYBlockRenderer();
        GrayPaintScale grayPaintScale = new GrayPaintScale(-2.0, 1.0);
        xYBlockRenderer.setPaintScale((PaintScale)grayPaintScale);
        XYPlot xYPlot = new XYPlot((XYDataset)xYZDataset, (ValueAxis)numberAxis, (ValueAxis)numberAxis2, (XYItemRenderer)xYBlockRenderer);
        xYPlot.setBackgroundPaint((Paint)Color.lightGray);
        xYPlot.setDomainGridlinesVisible(false);
        xYPlot.setRangeGridlinePaint((Paint)Color.white);
        xYPlot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        xYPlot.setOutlinePaint((Paint)Color.blue);
        JFreeChart jFreeChart = new JFreeChart("XYBlockChartDemo1", (Plot)xYPlot);
        jFreeChart.removeLegend();
        NumberAxis numberAxis3 = new NumberAxis("Scale");
        numberAxis3.setAxisLinePaint((Paint)Color.white);
        numberAxis3.setTickMarkPaint((Paint)Color.white);
        numberAxis3.setTickLabelFont(new Font("Dialog", 0, 7));
        PaintScaleLegend paintScaleLegend = new PaintScaleLegend((PaintScale)new GrayPaintScale(), (ValueAxis)numberAxis3);
        paintScaleLegend.setStripOutlineVisible(false);
        paintScaleLegend.setSubdivisionCount(20);
        paintScaleLegend.setAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
        paintScaleLegend.setAxisOffset(5.0);
        paintScaleLegend.setMargin(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        paintScaleLegend.setFrame((BlockFrame)new BlockBorder((Paint)Color.red));
        paintScaleLegend.setPadding(new RectangleInsets(10.0, 10.0, 10.0, 10.0));
        paintScaleLegend.setStripWidth(10.0);
        paintScaleLegend.setPosition(RectangleEdge.LEFT);
        jFreeChart.addSubtitle((Title)paintScaleLegend);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    private static XYZDataset createDataset() {
        return new XYZDataset(){

            public int getSeriesCount() {
                return 1;
            }

            public int getItemCount(int n) {
                return 10000;
            }

            public Number getX(int n, int n2) {
                return new Double(this.getXValue(n, n2));
            }

            public double getXValue(int n, int n2) {
                return n2 / 100 - 50;
            }

            public Number getY(int n, int n2) {
                return new Double(this.getYValue(n, n2));
            }

            public double getYValue(int n, int n2) {
                return n2 - n2 / 100 * 100 - 50;
            }

            public Number getZ(int n, int n2) {
                return new Double(this.getZValue(n, n2));
            }

            public double getZValue(int n, int n2) {
                double d = this.getXValue(n, n2);
                double d2 = this.getYValue(n, n2);
                return Math.sin(Math.sqrt(d * d + d2 * d2) / 5.0);
            }

            public void addChangeListener(DatasetChangeListener datasetChangeListener) {
            }

            public void removeChangeListener(DatasetChangeListener datasetChangeListener) {
            }

            public DatasetGroup getGroup() {
                return null;
            }

            public void setGroup(DatasetGroup datasetGroup) {
            }

            public Comparable getSeriesKey(int n) {
                return "sin(sqrt(x + y))";
            }

            public int indexOf(Comparable comparable) {
                return 0;
            }

            public DomainOrder getDomainOrder() {
                return DomainOrder.ASCENDING;
            }
        };
    }

    public static JPanel createDemoPanel() {
        return new ChartPanel(XYBlockChartDemo1.createChart(XYBlockChartDemo1.createDataset()));
    }

    public static void main(String[] arrstring) {
        XYBlockChartDemo1 xYBlockChartDemo1 = new XYBlockChartDemo1("JFreeChart: XYBlockChartDemo1");
        xYBlockChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)xYBlockChartDemo1));
        xYBlockChartDemo1.setVisible(true);
    }

}

