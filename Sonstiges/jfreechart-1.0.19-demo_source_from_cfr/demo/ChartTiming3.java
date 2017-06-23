/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartRenderingInfo
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.renderer.xy.XYDotRenderer
 *  org.jfree.chart.renderer.xy.XYItemRenderer
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.data.xy.XYSeries
 *  org.jfree.data.xy.XYSeriesCollection
 */
package demo;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.PrintStream;
import javax.swing.Timer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYDotRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class ChartTiming3
implements ActionListener {
    private boolean finished;

    public void run() {
        this.finished = false;
        XYSeries xYSeries = new XYSeries((Comparable)((Object)"Random Data"));
        for (int i = 0; i < 1440; ++i) {
            double d = Math.random();
            double d2 = Math.random();
            xYSeries.add(d, d2);
        }
        XYSeriesCollection xYSeriesCollection = new XYSeriesCollection(xYSeries);
        boolean bl = true;
        JFreeChart jFreeChart = ChartFactory.createScatterPlot((String)"Scatter plot timing", (String)"X", (String)"Y", (XYDataset)xYSeriesCollection, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)bl, (boolean)false, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setRenderer((XYItemRenderer)new XYDotRenderer());
        BufferedImage bufferedImage = new BufferedImage(400, 300, 1);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        Rectangle2D.Double double_ = new Rectangle2D.Double(0.0, 0.0, 400.0, 300.0);
        Timer timer = new Timer(10000, this);
        timer.setRepeats(false);
        int n = 0;
        timer.start();
        while (!this.finished) {
            jFreeChart.draw(graphics2D, (Rectangle2D)double_, null, null);
            System.out.println("Charts drawn..." + n);
            if (this.finished) continue;
            ++n;
        }
        System.out.println("DONE");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.finished = true;
    }

    public static void main(String[] arrstring) {
        ChartTiming3 chartTiming3 = new ChartTiming3();
        chartTiming3.run();
    }
}

