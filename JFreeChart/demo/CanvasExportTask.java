/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.JFreeChart
 *  org.jfree.graphics2d.canvas.CanvasGraphics2D
 *  org.jfree.graphics2d.canvas.CanvasUtils
 *  org.jfree.ui.RectangleInsets
 */
package demo;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import org.jfree.chart.JFreeChart;
import org.jfree.graphics2d.canvas.CanvasGraphics2D;
import org.jfree.graphics2d.canvas.CanvasUtils;
import org.jfree.ui.RectangleInsets;

public class CanvasExportTask
implements Runnable {
    JFreeChart chart;
    int width;
    int height;
    File file;

    public CanvasExportTask(JFreeChart jFreeChart, int n, int n2, File file) {
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
            CanvasGraphics2D canvasGraphics2D = new CanvasGraphics2D("canvas1");
            this.chart.draw((Graphics2D)canvasGraphics2D, (Rectangle2D)new Rectangle(this.width, this.height));
            CanvasUtils.writeToHTML((File)this.file, (String)"", (String)canvasGraphics2D.getCanvasID(), (int)this.width, (int)this.height, (String)(canvasGraphics2D.getScript() + "\n"));
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }
}

