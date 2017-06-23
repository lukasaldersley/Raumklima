/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartRenderingInfo
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.NumberAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.FastScatterPlot
 *  org.jfree.chart.plot.Plot
 */
package demo;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.PrintStream;
import javax.swing.Timer;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.FastScatterPlot;
import org.jfree.chart.plot.Plot;

public class ChartTiming4
implements ActionListener {
    private boolean finished;
    private float[][] data = new float[2][1440];

    public void run() {
        this.finished = false;
        this.populateData();
        FastScatterPlot fastScatterPlot = new FastScatterPlot(this.data, (ValueAxis)new NumberAxis("X"), (ValueAxis)new NumberAxis("Y"));
        JFreeChart jFreeChart = new JFreeChart("Fast Scatter Plot Timing", JFreeChart.DEFAULT_TITLE_FONT, (Plot)fastScatterPlot, true);
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

    private void populateData() {
        for (int i = 0; i < this.data[0].length; ++i) {
            float f;
            this.data[0][i] = f = (float)i;
            this.data[1][i] = 100.0f + 2.0f * f + (float)Math.random() * 1440.0f;
        }
    }

    public static void main(String[] arrstring) {
        ChartTiming4 chartTiming4 = new ChartTiming4();
        chartTiming4.run();
    }
}

