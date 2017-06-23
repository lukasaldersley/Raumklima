/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartRenderingInfo
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.LegendItem
 *  org.jfree.chart.LegendItemCollection
 *  org.jfree.chart.LegendItemSource
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.axis.CategoryLabelPositions
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.TickUnitSource
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.labels.CategoryItemLabelGenerator
 *  org.jfree.chart.labels.CategorySeriesLabelGenerator
 *  org.jfree.chart.labels.StandardCategoryItemLabelGenerator
 *  org.jfree.chart.labels.StandardCategorySeriesLabelGenerator
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.PiePlot3D
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.category.BarRenderer
 *  org.jfree.chart.renderer.category.CategoryItemRenderer
 *  org.jfree.chart.renderer.category.LineAndShapeRenderer
 *  org.jfree.chart.renderer.xy.DeviationRenderer
 *  org.jfree.chart.renderer.xy.XYBarRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.chart.title.LegendTitle
 *  org.jfree.chart.title.TextTitle
 *  org.jfree.chart.title.Title
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.data.general.DefaultPieDataset
 *  org.jfree.data.general.PieDataset
 *  org.jfree.data.statistics.HistogramDataset
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.Week
 *  org.jfree.data.xy.IntervalXYDataset
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.YIntervalSeries
 *  org.jfree.data.xy.YIntervalSeriesCollection
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.HorizontalAlignment
 *  org.jfree.ui.RectangleEdge
 *  org.jfree.ui.RectangleInsets
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.util.Rotation
 */
package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.Window;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.LegendItemSource;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.CategorySeriesLabelGenerator;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategorySeriesLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.DeviationRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.Week;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.YIntervalSeries;
import org.jfree.data.xy.YIntervalSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.Rotation;

public class ThumbnailDemo1
extends ApplicationFrame {
    public ThumbnailDemo1(String string) {
        super(string);
        JPanel jPanel = ThumbnailDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static CategoryDataset createDataset1() {
        String string = "First";
        String string2 = "Second";
        String string3 = "Third";
        String string4 = "Category 1";
        String string5 = "Category 2";
        String string6 = "Category 3";
        String string7 = "Category 4";
        String string8 = "Category 5";
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(1.0, (Comparable)((Object)string), (Comparable)((Object)string4));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)string), (Comparable)((Object)string5));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)string), (Comparable)((Object)string6));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)string), (Comparable)((Object)string7));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)string), (Comparable)((Object)string8));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)string2), (Comparable)((Object)string4));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)string2), (Comparable)((Object)string5));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)string2), (Comparable)((Object)string6));
        defaultCategoryDataset.addValue(8.0, (Comparable)((Object)string2), (Comparable)((Object)string7));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)string2), (Comparable)((Object)string8));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)string3), (Comparable)((Object)string4));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)string3), (Comparable)((Object)string5));
        defaultCategoryDataset.addValue(2.0, (Comparable)((Object)string3), (Comparable)((Object)string6));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)string3), (Comparable)((Object)string7));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)string3), (Comparable)((Object)string8));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart1(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createBarChart((String)"Bar Chart Demo 1", (String)"Category", (String)"Value", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        jFreeChart.setBackgroundPaint((Paint)Color.white);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer barRenderer = (BarRenderer)categoryPlot.getRenderer();
        barRenderer.setDrawBarOutline(false);
        GradientPaint gradientPaint = new GradientPaint(0.0f, 0.0f, Color.blue, 0.0f, 0.0f, new Color(0, 0, 64));
        GradientPaint gradientPaint2 = new GradientPaint(0.0f, 0.0f, Color.green, 0.0f, 0.0f, new Color(0, 64, 0));
        GradientPaint gradientPaint3 = new GradientPaint(0.0f, 0.0f, Color.red, 0.0f, 0.0f, new Color(64, 0, 0));
        barRenderer.setSeriesPaint(0, (Paint)gradientPaint);
        barRenderer.setSeriesPaint(1, (Paint)gradientPaint2);
        barRenderer.setSeriesPaint(2, (Paint)gradientPaint3);
        barRenderer.setLegendItemToolTipGenerator((CategorySeriesLabelGenerator)new StandardCategorySeriesLabelGenerator("Tooltip: {0}"));
        CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions((double)0.5235987755982988));
        return jFreeChart;
    }

    private static PieDataset createDataset2() {
        DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
        defaultPieDataset.setValue((Comparable)((Object)"Java"), (Number)new Double(43.2));
        defaultPieDataset.setValue((Comparable)((Object)"Visual Basic"), (Number)new Double(10.0));
        defaultPieDataset.setValue((Comparable)((Object)"C/C++"), (Number)new Double(17.5));
        defaultPieDataset.setValue((Comparable)((Object)"PHP"), (Number)new Double(32.5));
        defaultPieDataset.setValue((Comparable)((Object)"Perl"), null);
        return defaultPieDataset;
    }

    private static JFreeChart createChart2(PieDataset pieDataset) {
        JFreeChart jFreeChart = ChartFactory.createPieChart3D((String)"Pie Chart 3D Demo 1", (PieDataset)pieDataset, (boolean)true, (boolean)true, (boolean)false);
        jFreeChart.setBackgroundPaint((Paint)Color.white);
        PiePlot3D piePlot3D = (PiePlot3D)jFreeChart.getPlot();
        piePlot3D.setDarkerSides(true);
        piePlot3D.setStartAngle(290.0);
        piePlot3D.setDirection(Rotation.CLOCKWISE);
        piePlot3D.setForegroundAlpha(0.5f);
        piePlot3D.setOutlinePaint(null);
        piePlot3D.setNoDataMessage("No data to display");
        return jFreeChart;
    }

    private static CategoryDataset createDataset3() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(81.0, (Comparable)((Object)"Against all torture"), (Comparable)((Object)"Italy"));
        defaultCategoryDataset.addValue(72.0, (Comparable)((Object)"Against all torture"), (Comparable)((Object)"Great Britain"));
        defaultCategoryDataset.addValue(58.0, (Comparable)((Object)"Against all torture"), (Comparable)((Object)"USA"));
        defaultCategoryDataset.addValue(48.0, (Comparable)((Object)"Against all torture"), (Comparable)((Object)"Israel"));
        defaultCategoryDataset.addValue(43.0, (Comparable)((Object)"Against all torture"), (Comparable)((Object)"Russia"));
        defaultCategoryDataset.addValue(23.0, (Comparable)((Object)"Against all torture"), (Comparable)((Object)"India"));
        defaultCategoryDataset.addValue(59.0, (Comparable)((Object)"Against all torture"), (Comparable)((Object)"Average (*)"));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)"-"), (Comparable)((Object)"Italy"));
        defaultCategoryDataset.addValue(4.0, (Comparable)((Object)"-"), (Comparable)((Object)"Great Britain"));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)"-"), (Comparable)((Object)"USA"));
        defaultCategoryDataset.addValue(9.0, (Comparable)((Object)"-"), (Comparable)((Object)"Israel"));
        defaultCategoryDataset.addValue(20.0, (Comparable)((Object)"-"), (Comparable)((Object)"Russia"));
        defaultCategoryDataset.addValue(45.0, (Comparable)((Object)"-"), (Comparable)((Object)"India"));
        defaultCategoryDataset.addValue(12.0, (Comparable)((Object)"-"), (Comparable)((Object)"Average (*)"));
        defaultCategoryDataset.addValue(14.0, (Comparable)((Object)"Some degree permissible"), (Comparable)((Object)"Italy"));
        defaultCategoryDataset.addValue(24.0, (Comparable)((Object)"Some degree permissible"), (Comparable)((Object)"Great Britain"));
        defaultCategoryDataset.addValue(36.0, (Comparable)((Object)"Some degree permissible"), (Comparable)((Object)"USA"));
        defaultCategoryDataset.addValue(43.0, (Comparable)((Object)"Some degree permissible"), (Comparable)((Object)"Israel"));
        defaultCategoryDataset.addValue(37.0, (Comparable)((Object)"Some degree permissible"), (Comparable)((Object)"Russia"));
        defaultCategoryDataset.addValue(32.0, (Comparable)((Object)"Some degree permissible"), (Comparable)((Object)"India"));
        defaultCategoryDataset.addValue(29.0, (Comparable)((Object)"Some degree permissible"), (Comparable)((Object)"Average (*)"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart3(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createStackedBarChart((String)"Public Opinion : Torture of Prisoners", (String)"Country", (String)"%", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.HORIZONTAL, (boolean)false, (boolean)true, (boolean)false);
        jFreeChart.getTitle().setMargin(2.0, 0.0, 0.0, 0.0);
        TextTitle textTitle = new TextTitle("Source: http://news.bbc.co.uk/1/hi/world/6063386.stm", new Font("Dialog", 0, 11));
        textTitle.setPosition(RectangleEdge.BOTTOM);
        textTitle.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        textTitle.setMargin(0.0, 0.0, 4.0, 4.0);
        jFreeChart.addSubtitle((Title)textTitle);
        TextTitle textTitle2 = new TextTitle("(*) Across 27,000 respondents in 25 countries", new Font("Dialog", 0, 11));
        textTitle2.setPosition(RectangleEdge.BOTTOM);
        textTitle2.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        textTitle2.setMargin(4.0, 0.0, 2.0, 4.0);
        jFreeChart.addSubtitle((Title)textTitle2);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        LegendItemCollection legendItemCollection = new LegendItemCollection();
        legendItemCollection.add(new LegendItem("Against all torture", null, null, null, (Shape)new Rectangle2D.Double(-6.0, -3.0, 12.0, 6.0), (Paint)Color.green));
        legendItemCollection.add(new LegendItem("Some degree permissible", null, null, null, (Shape)new Rectangle2D.Double(-6.0, -3.0, 12.0, 6.0), (Paint)Color.red));
        categoryPlot.setFixedLegendItems(legendItemCollection);
        categoryPlot.setInsets(new RectangleInsets(5.0, 5.0, 5.0, 20.0));
        LegendTitle legendTitle = new LegendTitle((LegendItemSource)categoryPlot);
        legendTitle.setPosition(RectangleEdge.BOTTOM);
        jFreeChart.addSubtitle((Title)legendTitle);
        categoryPlot.setBackgroundPaint((Paint)Color.lightGray);
        categoryPlot.setDomainGridlinePaint((Paint)Color.white);
        categoryPlot.setDomainGridlinesVisible(true);
        categoryPlot.setRangeGridlinePaint((Paint)Color.white);
        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberAxis.setUpperMargin(0.0);
        BarRenderer barRenderer = (BarRenderer)categoryPlot.getRenderer();
        barRenderer.setDrawBarOutline(false);
        GradientPaint gradientPaint = new GradientPaint(0.0f, 0.0f, Color.green, 0.0f, 0.0f, new Color(0, 64, 0));
        Color color = new Color(0, 0, 0, 0);
        GradientPaint gradientPaint2 = new GradientPaint(0.0f, 0.0f, Color.red, 0.0f, 0.0f, new Color(64, 0, 0));
        barRenderer.setSeriesPaint(0, (Paint)gradientPaint);
        barRenderer.setSeriesPaint(1, (Paint)color);
        barRenderer.setSeriesPaint(2, (Paint)gradientPaint2);
        return jFreeChart;
    }

    private static XYDataset createDataset4() {
        YIntervalSeries yIntervalSeries = new YIntervalSeries((Comparable)((Object)"Series 1"));
        YIntervalSeries yIntervalSeries2 = new YIntervalSeries((Comparable)((Object)"Series 2"));
        Week week = new Week();
        double d = 100.0;
        double d2 = 100.0;
        for (int i = 0; i <= 52; ++i) {
            double d3 = 0.05 * (double)i;
            yIntervalSeries.add((double)week.getFirstMillisecond(), d, d - d3, d + d3);
            d = d + Math.random() - 0.45;
            double d4 = 0.07 * (double)i;
            yIntervalSeries2.add((double)week.getFirstMillisecond(), d2, d2 - d4, d2 + d4);
            d2 = d2 + Math.random() - 0.55;
            week = week.next();
        }
        YIntervalSeriesCollection yIntervalSeriesCollection = new YIntervalSeriesCollection();
        yIntervalSeriesCollection.addSeries(yIntervalSeries);
        yIntervalSeriesCollection.addSeries(yIntervalSeries2);
        return yIntervalSeriesCollection;
    }

    private static JFreeChart createChart4(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Projected Values - Test", (String)"Date", (String)"Index Projection", (XYDataset)xYDataset, (boolean)true, (boolean)true, (boolean)false);
        jFreeChart.setBackgroundPaint((Paint)Color.white);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setInsets(new RectangleInsets(5.0, 5.0, 5.0, 20.0));
        xYPlot.setBackgroundPaint((Paint)Color.lightGray);
        xYPlot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        xYPlot.setDomainGridlinePaint((Paint)Color.white);
        xYPlot.setRangeGridlinePaint((Paint)Color.white);
        DeviationRenderer deviationRenderer = new DeviationRenderer(true, false);
        deviationRenderer.setSeriesStroke(0, (Stroke)new BasicStroke(3.0f, 1, 1));
        deviationRenderer.setSeriesStroke(0, (Stroke)new BasicStroke(3.0f, 1, 1));
        deviationRenderer.setSeriesStroke(1, (Stroke)new BasicStroke(3.0f, 1, 1));
        deviationRenderer.setSeriesFillPaint(0, (Paint)new Color(255, 200, 200));
        deviationRenderer.setSeriesFillPaint(1, (Paint)new Color(200, 200, 255));
        xYPlot.setRenderer((XYItemRenderer)deviationRenderer);
        NumberAxis numberAxis = (NumberAxis)xYPlot.getRangeAxis();
        numberAxis.setAutoRangeIncludesZero(false);
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        return jFreeChart;
    }

    private static IntervalXYDataset createDataset5() {
        int n;
        HistogramDataset histogramDataset = new HistogramDataset();
        double[] arrd = new double[1000];
        Random random = new Random(12345678);
        for (n = 0; n < 1000; ++n) {
            arrd[n] = random.nextGaussian() + 5.0;
        }
        histogramDataset.addSeries((Comparable)((Object)"H1"), arrd, 100, 2.0, 8.0);
        arrd = new double[1000];
        for (n = 0; n < 1000; ++n) {
            arrd[n] = random.nextGaussian() + 7.0;
        }
        histogramDataset.addSeries((Comparable)((Object)"H2"), arrd, 100, 4.0, 10.0);
        return histogramDataset;
    }

    private static JFreeChart createChart5(IntervalXYDataset intervalXYDataset) {
        JFreeChart jFreeChart = ChartFactory.createHistogram((String)"Histogram Demo 1", (String)null, (String)null, (IntervalXYDataset)intervalXYDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        jFreeChart.setBackgroundPaint((Paint)Color.white);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setBackgroundPaint((Paint)Color.lightGray);
        xYPlot.setDomainGridlinePaint((Paint)Color.white);
        xYPlot.setRangeGridlinePaint((Paint)Color.white);
        xYPlot.setForegroundAlpha(0.85f);
        XYBarRenderer xYBarRenderer = (XYBarRenderer)xYPlot.getRenderer();
        xYBarRenderer.setDrawBarOutline(false);
        return jFreeChart;
    }

    private static CategoryDataset createDataset6() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(212.0, (Comparable)((Object)"Classes"), (Comparable)((Object)"JDK 1.0"));
        defaultCategoryDataset.addValue(504.0, (Comparable)((Object)"Classes"), (Comparable)((Object)"JDK 1.1"));
        defaultCategoryDataset.addValue(1520.0, (Comparable)((Object)"Classes"), (Comparable)((Object)"SDK 1.2"));
        defaultCategoryDataset.addValue(1842.0, (Comparable)((Object)"Classes"), (Comparable)((Object)"SDK 1.3"));
        defaultCategoryDataset.addValue(2991.0, (Comparable)((Object)"Classes"), (Comparable)((Object)"SDK 1.4"));
        return defaultCategoryDataset;
    }

    private static JFreeChart createChart6(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createLineChart((String)"Java Standard Class Library", (String)"Release", (String)"Class Count", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)false, (boolean)true, (boolean)false);
        jFreeChart.addSubtitle((Title)new TextTitle("Number of Classes By Release"));
        TextTitle textTitle = new TextTitle("Source: Java In A Nutshell (4th Edition) by David Flanagan (O'Reilly)");
        textTitle.setFont(new Font("SansSerif", 0, 10));
        textTitle.setPosition(RectangleEdge.BOTTOM);
        textTitle.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        jFreeChart.addSubtitle((Title)textTitle);
        jFreeChart.setBackgroundPaint((Paint)Color.white);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        categoryPlot.setBackgroundPaint((Paint)Color.lightGray);
        categoryPlot.setRangeGridlinePaint((Paint)Color.white);
        NumberAxis numberAxis = (NumberAxis)categoryPlot.getRangeAxis();
        numberAxis.setUpperMargin(0.15);
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        LineAndShapeRenderer lineAndShapeRenderer = (LineAndShapeRenderer)categoryPlot.getRenderer();
        lineAndShapeRenderer.setBaseShapesVisible(true);
        lineAndShapeRenderer.setDrawOutlines(true);
        lineAndShapeRenderer.setUseFillPaint(true);
        lineAndShapeRenderer.setBaseFillPaint((Paint)Color.white);
        lineAndShapeRenderer.setBaseItemLabelGenerator((CategoryItemLabelGenerator)new StandardCategoryItemLabelGenerator());
        lineAndShapeRenderer.setBaseItemLabelsVisible(true);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JPanel jPanel = new JPanel(new GridLayout(2, 3));
        JFreeChart jFreeChart = ThumbnailDemo1.createChart1(ThumbnailDemo1.createDataset1());
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        BufferedImage bufferedImage = jFreeChart.createBufferedImage(120, 80, 360.0, 240.0, null);
        ImageIcon imageIcon = new ImageIcon(bufferedImage);
        jPanel.add(new JButton(imageIcon));
        JFreeChart jFreeChart2 = ThumbnailDemo1.createChart2(ThumbnailDemo1.createDataset2());
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart2);
        BufferedImage bufferedImage2 = jFreeChart2.createBufferedImage(120, 80, 360.0, 240.0, null);
        ImageIcon imageIcon2 = new ImageIcon(bufferedImage2);
        jPanel.add(new JButton(imageIcon2));
        JFreeChart jFreeChart3 = ThumbnailDemo1.createChart3(ThumbnailDemo1.createDataset3());
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart3);
        BufferedImage bufferedImage3 = jFreeChart3.createBufferedImage(120, 80, 360.0, 240.0, null);
        ImageIcon imageIcon3 = new ImageIcon(bufferedImage3);
        jPanel.add(new JButton(imageIcon3));
        JFreeChart jFreeChart4 = ThumbnailDemo1.createChart4(ThumbnailDemo1.createDataset4());
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart4);
        BufferedImage bufferedImage4 = jFreeChart4.createBufferedImage(120, 80, 360.0, 240.0, null);
        ImageIcon imageIcon4 = new ImageIcon(bufferedImage4);
        jPanel.add(new JButton(imageIcon4));
        JFreeChart jFreeChart5 = ThumbnailDemo1.createChart5(ThumbnailDemo1.createDataset5());
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart5);
        BufferedImage bufferedImage5 = jFreeChart5.createBufferedImage(120, 80, 360.0, 240.0, null);
        ImageIcon imageIcon5 = new ImageIcon(bufferedImage5);
        jPanel.add(new JButton(imageIcon5));
        JFreeChart jFreeChart6 = ThumbnailDemo1.createChart6(ThumbnailDemo1.createDataset6());
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart6);
        BufferedImage bufferedImage6 = jFreeChart6.createBufferedImage(120, 80, 360.0, 240.0, null);
        ImageIcon imageIcon6 = new ImageIcon(bufferedImage6);
        jPanel.add(new JButton(imageIcon6));
        return jPanel;
    }

    public static void main(String[] arrstring) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        ThumbnailDemo1 thumbnailDemo1 = new ThumbnailDemo1("JFreeChart: ThumbnailDemo1.java");
        thumbnailDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)thumbnailDemo1));
        thumbnailDemo1.setVisible(true);
    }
}

