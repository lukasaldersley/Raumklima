/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.Chart3D
 *  com.orsoncharts.Chart3DFactory
 *  com.orsoncharts.Colors
 *  com.orsoncharts.data.xyz.XYZDataset
 *  com.orsoncharts.data.xyz.XYZSeries
 *  com.orsoncharts.data.xyz.XYZSeriesCollection
 *  com.orsoncharts.graphics3d.Dimension3D
 *  com.orsoncharts.graphics3d.ViewPoint3D
 *  com.orsoncharts.label.StandardXYZLabelGenerator
 *  com.orsoncharts.label.XYZLabelGenerator
 *  com.orsoncharts.plot.Plot3D
 *  com.orsoncharts.plot.XYZPlot
 *  com.orsoncharts.renderer.xyz.ScatterXYZRenderer
 *  com.orsoncharts.renderer.xyz.XYZRenderer
 */
package demo.orsoncharts;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Colors;
import com.orsoncharts.data.xyz.XYZDataset;
import com.orsoncharts.data.xyz.XYZSeries;
import com.orsoncharts.data.xyz.XYZSeriesCollection;
import com.orsoncharts.graphics3d.Dimension3D;
import com.orsoncharts.graphics3d.ViewPoint3D;
import com.orsoncharts.label.StandardXYZLabelGenerator;
import com.orsoncharts.label.XYZLabelGenerator;
import com.orsoncharts.plot.Plot3D;
import com.orsoncharts.plot.XYZPlot;
import com.orsoncharts.renderer.xyz.ScatterXYZRenderer;
import com.orsoncharts.renderer.xyz.XYZRenderer;
import java.awt.Color;

public class ScatterPlot3D1 {
    public static Chart3D createChart(XYZDataset xYZDataset) {
        Chart3D chart3D = Chart3DFactory.createScatterChart((String)"ScatterPlot3DDemo1", (String)"Chart created with Orson Charts", (XYZDataset)xYZDataset, (String)"X", (String)"Y", (String)"Z");
        XYZPlot xYZPlot = (XYZPlot)chart3D.getPlot();
        xYZPlot.setDimensions(new Dimension3D(10.0, 4.0, 4.0));
        xYZPlot.setLegendLabelGenerator((XYZLabelGenerator)new StandardXYZLabelGenerator("%s (%2$,d)"));
        ScatterXYZRenderer scatterXYZRenderer = (ScatterXYZRenderer)xYZPlot.getRenderer();
        scatterXYZRenderer.setSize(0.15);
        scatterXYZRenderer.setColors(Colors.createIntenseColors());
        chart3D.setViewPoint(ViewPoint3D.createAboveLeftViewPoint((double)40.0));
        return chart3D;
    }

    public static XYZDataset createDataset() {
        XYZSeries xYZSeries = ScatterPlot3D1.createRandomSeries("S1", 10);
        XYZSeries xYZSeries2 = ScatterPlot3D1.createRandomSeries("S2", 50);
        XYZSeries xYZSeries3 = ScatterPlot3D1.createRandomSeries("S3", 150);
        XYZSeriesCollection xYZSeriesCollection = new XYZSeriesCollection();
        xYZSeriesCollection.add(xYZSeries);
        xYZSeriesCollection.add(xYZSeries2);
        xYZSeriesCollection.add(xYZSeries3);
        return xYZSeriesCollection;
    }

    private static XYZSeries createRandomSeries(String string, int n) {
        XYZSeries xYZSeries = new XYZSeries((Comparable)((Object)string));
        for (int i = 0; i < n; ++i) {
            xYZSeries.add(Math.random() * 100.0, Math.random() / 100.0, Math.random() * 100.0);
        }
        return xYZSeries;
    }
}

