/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.block.RectangleConstraint
 *  org.jfree.chart.title.LegendTitle
 *  org.jfree.data.Range
 *  org.jfree.data.general.DefaultPieDataset
 *  org.jfree.data.general.PieDataset
 *  org.jfree.ui.Size2D
 */
package demo;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.RectangleConstraint;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.Range;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.Size2D;

public class LegendTitleToImageDemo2 {
    public static void main(String[] arrstring) throws IOException {
        DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
        defaultPieDataset.setValue((Comparable)((Object)"England"), 1.0);
        defaultPieDataset.setValue((Comparable)((Object)"France"), 2.0);
        defaultPieDataset.setValue((Comparable)((Object)"Germany"), 3.0);
        defaultPieDataset.setValue((Comparable)((Object)"Italy"), 4.0);
        defaultPieDataset.setValue((Comparable)((Object)"Scotland"), 5.0);
        defaultPieDataset.setValue((Comparable)((Object)"Belgium"), 6.0);
        defaultPieDataset.setValue((Comparable)((Object)"Poland"), 7.0);
        defaultPieDataset.setValue((Comparable)((Object)"Spain"), 8.0);
        defaultPieDataset.setValue((Comparable)((Object)"Portugal"), 9.0);
        defaultPieDataset.setValue((Comparable)((Object)"Switzerland"), 10.0);
        defaultPieDataset.setValue((Comparable)((Object)"Austria"), 11.0);
        defaultPieDataset.setValue((Comparable)((Object)"Luxembourg"), 12.0);
        JFreeChart jFreeChart = ChartFactory.createPieChart((String)"Test", (PieDataset)defaultPieDataset, (boolean)true, (boolean)false, (boolean)false);
        LegendTitle legendTitle = jFreeChart.getLegend();
        legendTitle.setMargin(0.0, 0.0, 1.0, 1.0);
        BufferedImage bufferedImage = new BufferedImage(1, 1, 2);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        Size2D size2D = legendTitle.arrange(graphics2D, new RectangleConstraint(250.0, new Range(0.0, 10000.0)));
        graphics2D.dispose();
        int n = (int)Math.rint(size2D.width);
        int n2 = (int)Math.rint(size2D.height);
        BufferedImage bufferedImage2 = new BufferedImage(n, n2, 2);
        Graphics2D graphics2D2 = bufferedImage2.createGraphics();
        legendTitle.draw(graphics2D2, (Rectangle2D)new Rectangle2D.Double(0.0, 0.0, n, n2));
        graphics2D2.dispose();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File("LegendTitleToImageDemo2.png")));
        ChartUtilities.writeBufferedImageAsPNG((OutputStream)bufferedOutputStream, (BufferedImage)bufferedImage2);
        bufferedOutputStream.close();
    }
}

