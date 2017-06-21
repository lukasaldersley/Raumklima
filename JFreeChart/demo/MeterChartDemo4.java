/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartRenderingInfo
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.MeterPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.data.general.DefaultValueDataset
 *  org.jfree.data.general.ValueDataset
 */
package demo;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.MeterPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.general.ValueDataset;

public class MeterChartDemo4 {
    public static void main(String[] arrstring) {
        DefaultValueDataset defaultValueDataset = new DefaultValueDataset(75.0);
        MeterPlot meterPlot = new MeterPlot((ValueDataset)defaultValueDataset);
        JFreeChart jFreeChart = new JFreeChart("Scaled Image Test", (Plot)meterPlot);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        try {
            File file = new File("meterchart100.png");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            BufferedImage bufferedImage = jFreeChart.createBufferedImage(200, 200, 400.0, 400.0, null);
            ChartUtilities.writeBufferedImageAsPNG((OutputStream)bufferedOutputStream, (BufferedImage)bufferedImage);
        }
        catch (IOException iOException) {
            System.out.println(iOException.toString());
        }
    }
}

