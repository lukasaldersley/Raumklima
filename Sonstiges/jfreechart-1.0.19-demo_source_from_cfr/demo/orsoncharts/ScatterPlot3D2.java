/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.Chart3D
 *  com.orsoncharts.Chart3DFactory
 *  com.orsoncharts.ChartElementVisitor
 *  com.orsoncharts.axis.LabelOrientation
 *  com.orsoncharts.axis.LogAxis3D
 *  com.orsoncharts.axis.ValueAxis3D
 *  com.orsoncharts.data.xyz.XYZDataset
 *  com.orsoncharts.data.xyz.XYZSeries
 *  com.orsoncharts.data.xyz.XYZSeriesCollection
 *  com.orsoncharts.graphics3d.Dimension3D
 *  com.orsoncharts.graphics3d.ViewPoint3D
 *  com.orsoncharts.plot.Plot3D
 *  com.orsoncharts.plot.XYZPlot
 *  com.orsoncharts.renderer.xyz.ScatterXYZRenderer
 *  com.orsoncharts.renderer.xyz.XYZRenderer
 *  com.orsoncharts.style.ChartStyle
 *  com.orsoncharts.style.ChartStyler
 */
package demo.orsoncharts;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.ChartElementVisitor;
import com.orsoncharts.axis.LabelOrientation;
import com.orsoncharts.axis.LogAxis3D;
import com.orsoncharts.axis.ValueAxis3D;
import com.orsoncharts.data.xyz.XYZDataset;
import com.orsoncharts.data.xyz.XYZSeries;
import com.orsoncharts.data.xyz.XYZSeriesCollection;
import com.orsoncharts.graphics3d.Dimension3D;
import com.orsoncharts.graphics3d.ViewPoint3D;
import com.orsoncharts.plot.Plot3D;
import com.orsoncharts.plot.XYZPlot;
import com.orsoncharts.renderer.xyz.ScatterXYZRenderer;
import com.orsoncharts.renderer.xyz.XYZRenderer;
import com.orsoncharts.style.ChartStyle;
import com.orsoncharts.style.ChartStyler;
import java.awt.Color;

public class ScatterPlot3D2 {
    public static Chart3D createChart(XYZDataset xYZDataset) {
        Chart3D chart3D = Chart3DFactory.createScatterChart((String)"ScatterPlot3DDemo2", (String)null, (XYZDataset)xYZDataset, (String)"X", (String)"Y", (String)"Z");
        XYZPlot xYZPlot = (XYZPlot)chart3D.getPlot();
        ScatterXYZRenderer scatterXYZRenderer = (ScatterXYZRenderer)xYZPlot.getRenderer();
        xYZPlot.setDimensions(new Dimension3D(10.0, 6.0, 10.0));
        scatterXYZRenderer.setSize(0.1);
        scatterXYZRenderer.setColors(new Color[]{new Color(255, 128, 128), new Color(128, 255, 128)});
        LogAxis3D logAxis3D = new LogAxis3D("Y (log scale)");
        logAxis3D.setTickLabelOrientation(LabelOrientation.PERPENDICULAR);
        logAxis3D.receive((ChartElementVisitor)new ChartStyler(chart3D.getStyle()));
        xYZPlot.setYAxis((ValueAxis3D)logAxis3D);
        chart3D.setViewPoint(ViewPoint3D.createAboveLeftViewPoint((double)40.0));
        return chart3D;
    }

    public static XYZDataset createDataset() {
        XYZSeries xYZSeries = new XYZSeries((Comparable)((Object)"S1"));
        for (int i = 0; i < 1000; ++i) {
            xYZSeries.add(Math.random() * 100.0, Math.pow(10.0, Math.random() * 5.0), Math.random() * 100.0);
        }
        XYZSeries xYZSeries2 = new XYZSeries((Comparable)((Object)"S2"));
        for (int i = 0; i < 1000; ++i) {
            xYZSeries2.add(Math.random() * 100.0, Math.random() * 100000.0, Math.random() * 100.0);
        }
        XYZSeriesCollection xYZSeriesCollection = new XYZSeriesCollection();
        xYZSeriesCollection.add(xYZSeries);
        xYZSeriesCollection.add(xYZSeries2);
        return xYZSeriesCollection;
    }
}

