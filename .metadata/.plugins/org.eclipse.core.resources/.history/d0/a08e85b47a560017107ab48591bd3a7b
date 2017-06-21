/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.Chart3D
 *  com.orsoncharts.Chart3DFactory
 *  com.orsoncharts.Range
 *  com.orsoncharts.axis.ValueAxis3D
 *  com.orsoncharts.data.function.Function3D
 *  com.orsoncharts.graphics3d.Dimension3D
 *  com.orsoncharts.legend.LegendAnchor
 *  com.orsoncharts.plot.Plot3D
 *  com.orsoncharts.plot.XYZPlot
 *  com.orsoncharts.renderer.ColorScale
 *  com.orsoncharts.renderer.RainbowScale
 *  com.orsoncharts.renderer.xyz.SurfaceRenderer
 *  com.orsoncharts.renderer.xyz.XYZRenderer
 *  com.orsoncharts.util.Anchor2D
 *  com.orsoncharts.util.Orientation
 */
package demo.orsoncharts;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Range;
import com.orsoncharts.axis.ValueAxis3D;
import com.orsoncharts.data.function.Function3D;
import com.orsoncharts.graphics3d.Dimension3D;
import com.orsoncharts.legend.LegendAnchor;
import com.orsoncharts.plot.Plot3D;
import com.orsoncharts.plot.XYZPlot;
import com.orsoncharts.renderer.ColorScale;
import com.orsoncharts.renderer.RainbowScale;
import com.orsoncharts.renderer.xyz.SurfaceRenderer;
import com.orsoncharts.renderer.xyz.XYZRenderer;
import com.orsoncharts.util.Anchor2D;
import com.orsoncharts.util.Orientation;

public class SurfaceRenderer2 {
    public static Chart3D createChart() {
        Function3D function3D = new Function3D(){

            public double getValue(double d, double d2) {
                return Math.sin(d * d + d2 * d2);
            }
        };
        Chart3D chart3D = Chart3DFactory.createSurfaceChart((String)"SurfaceRendererDemo2", (String)"y = sin(x^2 + z^2)", (Function3D)function3D, (String)"X", (String)"Y", (String)"Z");
        XYZPlot xYZPlot = (XYZPlot)chart3D.getPlot();
        xYZPlot.setDimensions(new Dimension3D(10.0, 5.0, 10.0));
        ValueAxis3D valueAxis3D = xYZPlot.getXAxis();
        valueAxis3D.setRange(-2.0, 2.0);
        ValueAxis3D valueAxis3D2 = xYZPlot.getZAxis();
        valueAxis3D2.setRange(-2.0, 2.0);
        SurfaceRenderer surfaceRenderer = (SurfaceRenderer)xYZPlot.getRenderer();
        surfaceRenderer.setColorScale((ColorScale)new RainbowScale(new Range(-1.0, 1.0)));
        surfaceRenderer.setDrawFaceOutlines(false);
        chart3D.setLegendPosition(LegendAnchor.BOTTOM_RIGHT, Orientation.VERTICAL);
        return chart3D;
    }

}

