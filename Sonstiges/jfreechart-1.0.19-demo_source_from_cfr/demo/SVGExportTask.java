/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.JFreeChart
 *  org.jfree.graphics2d.svg.SVGGraphics2D
 *  org.jfree.graphics2d.svg.SVGUtils
 *  org.jfree.ui.RectangleInsets
 */
package demo;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import org.jfree.chart.JFreeChart;
import org.jfree.graphics2d.svg.SVGGraphics2D;
import org.jfree.graphics2d.svg.SVGUtils;
import org.jfree.ui.RectangleInsets;

public class SVGExportTask
implements Runnable {
    JFreeChart chart;
    int width;
    int height;
    File file;

    public SVGExportTask(JFreeChart jFreeChart, int n, int n2, File file) {
        this.chart = jFreeChart;
        this.file = file;
        this.width = n;
        this.height = n2;
        jFreeChart.setBorderVisible(true);
        jFreeChart.setPadding(new RectangleInsets(2.0, 2.0, 2.0, 2.0));
    }

    @Override
    public void run() {
        try {
            SVGGraphics2D sVGGraphics2D = new SVGGraphics2D(this.width, this.height);
            this.chart.draw((Graphics2D)sVGGraphics2D, (Rectangle2D)new Rectangle(this.width, this.height));
            SVGUtils.writeToHTML((File)this.file, (String)"title", (String)sVGGraphics2D.getSVGElement());
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }
}

