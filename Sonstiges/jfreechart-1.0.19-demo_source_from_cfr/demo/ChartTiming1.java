/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartRenderingInfo
 *  org.jfree.chart.JFreeChart
 *  org.jfree.data.general.DefaultPieDataset
 *  org.jfree.data.general.PieDataset
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
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class ChartTiming1
implements ActionListener {
    private boolean finished;

    public void run() {
        this.finished = false;
        DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
        defaultPieDataset.setValue((Comparable)((Object)"One"), (Number)new Double(10.3));
        defaultPieDataset.setValue((Comparable)((Object)"Two"), (Number)new Double(8.5));
        defaultPieDataset.setValue((Comparable)((Object)"Three"), (Number)new Double(3.9));
        defaultPieDataset.setValue((Comparable)((Object)"Four"), (Number)new Double(3.9));
        defaultPieDataset.setValue((Comparable)((Object)"Five"), (Number)new Double(3.9));
        defaultPieDataset.setValue((Comparable)((Object)"Six"), (Number)new Double(3.9));
        boolean bl = true;
        JFreeChart jFreeChart = ChartFactory.createPieChart((String)"Testing", (PieDataset)defaultPieDataset, (boolean)bl, (boolean)true, (boolean)false);
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
        ChartTiming1 chartTiming1 = new ChartTiming1();
        chartTiming1.run();
    }
}

