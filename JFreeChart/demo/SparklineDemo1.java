/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.XYSeries
 *  org.jfree.data.xy.XYSeriesCollection
 *  org.jfree.ui.RectangleInsets
 */
package demo;

import java.awt.Paint;
import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;

public class SparklineDemo1 {
    public static void main(String[] arrstring) {
        XYSeries xYSeries = new XYSeries((Comparable)((Object)"Series 1"));
        xYSeries.add(1.0, 1.0);
        xYSeries.add(2.0, 3.0);
        xYSeries.add(3.0, 2.0);
        xYSeries.add(4.0, 4.0);
        XYSeriesCollection xYSeriesCollection = new XYSeriesCollection();
        xYSeriesCollection.addSeries(xYSeries);
        JFreeChart jFreeChart = ChartFactory.createXYLineChart((String)null, (String)"X", (String)"Y", (XYDataset)xYSeriesCollection, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)false, (boolean)false, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setInsets(RectangleInsets.ZERO_INSETS);
        xYPlot.setDomainGridlinesVisible(false);
        xYPlot.setRangeGridlinesVisible(false);
        xYPlot.setOutlinePaint(null);
        xYPlot.getDomainAxis().setVisible(false);
        xYPlot.getRangeAxis().setVisible(false);
        try {
            ChartUtilities.saveChartAsPNG((File)new File("Sparky.png"), (JFreeChart)jFreeChart, (int)100, (int)20);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}

