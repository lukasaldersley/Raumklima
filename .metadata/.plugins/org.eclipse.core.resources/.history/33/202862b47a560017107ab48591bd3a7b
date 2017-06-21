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
 *  com.orsoncharts.plot.Plot3D
 *  com.orsoncharts.plot.XYZPlot
 *  com.orsoncharts.renderer.ColorScale
 *  com.orsoncharts.renderer.GradientColorScale
 *  com.orsoncharts.renderer.xyz.SurfaceRenderer
 *  com.orsoncharts.renderer.xyz.XYZRenderer
 */
package demo.orsoncharts;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Range;
import com.orsoncharts.axis.ValueAxis3D;
import com.orsoncharts.data.function.Function3D;
import com.orsoncharts.graphics3d.Dimension3D;
import com.orsoncharts.plot.Plot3D;
import com.orsoncharts.plot.XYZPlot;
import com.orsoncharts.renderer.ColorScale;
import com.orsoncharts.renderer.GradientColorScale;
import com.orsoncharts.renderer.xyz.SurfaceRenderer;
import com.orsoncharts.renderer.xyz.XYZRenderer;
import java.awt.Color;

public class SurfaceRenderer1 {
    public static Chart3D createChart() {
        Function3D function3D = new Function3D(){

            public double getValue(double d, double d2) {
                return Math.cos(d) * Math.sin(d2);
            }
        };
        Chart3D chart3D = Chart3DFactory.createSurfaceChart((String)"SurfaceRendererDemo1", (String)"y = cos(x) * sin(z)", (Function3D)function3D, (String)"X", (String)"Y", (String)"Z");
        XYZPlot xYZPlot = (XYZPlot)chart3D.getPlot();
        xYZPlot.setDimensions(new Dimension3D(10.0, 5.0, 10.0));
        ValueAxis3D valueAxis3D = xYZPlot.getXAxis();
        valueAxis3D.setRange(-3.141592653589793, 3.141592653589793);
        ValueAxis3D valueAxis3D2 = xYZPlot.getZAxis();
        valueAxis3D2.setRange(-3.141592653589793, 3.141592653589793);
        SurfaceRenderer surfaceRenderer = (SurfaceRenderer)xYZPlot.getRenderer();
        surfaceRenderer.setColorScale((ColorScale)new GradientColorScale(new Range(-1.0, 1.0), Color.RED, Color.YELLOW));
        return chart3D;
    }

}

