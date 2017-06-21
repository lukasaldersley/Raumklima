/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.Chart3D
 *  com.orsoncharts.Chart3DFactory
 *  com.orsoncharts.Colors
 *  com.orsoncharts.data.DataUtils
 *  com.orsoncharts.data.JSONUtils
 *  com.orsoncharts.data.KeyedValues3D
 *  com.orsoncharts.data.xyz.XYZDataset
 *  com.orsoncharts.graphics3d.ViewPoint3D
 *  com.orsoncharts.legend.LegendAnchor
 *  com.orsoncharts.plot.Plot3D
 *  com.orsoncharts.plot.XYZPlot
 *  com.orsoncharts.renderer.xyz.ScatterXYZRenderer
 *  com.orsoncharts.renderer.xyz.XYZRenderer
 *  com.orsoncharts.style.StandardChartStyle
 *  com.orsoncharts.table.TableElement
 *  com.orsoncharts.table.TextElement
 *  com.orsoncharts.util.Anchor2D
 *  com.orsoncharts.util.Orientation
 */
package demo.orsoncharts;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Colors;
import com.orsoncharts.data.DataUtils;
import com.orsoncharts.data.JSONUtils;
import com.orsoncharts.data.KeyedValues3D;
import com.orsoncharts.data.xyz.XYZDataset;
import com.orsoncharts.graphics3d.ViewPoint3D;
import com.orsoncharts.legend.LegendAnchor;
import com.orsoncharts.plot.Plot3D;
import com.orsoncharts.plot.XYZPlot;
import com.orsoncharts.renderer.xyz.ScatterXYZRenderer;
import com.orsoncharts.renderer.xyz.XYZRenderer;
import com.orsoncharts.style.StandardChartStyle;
import com.orsoncharts.table.TableElement;
import com.orsoncharts.table.TextElement;
import com.orsoncharts.util.Anchor2D;
import com.orsoncharts.util.Orientation;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ScatterPlot3D3 {
    public static XYZDataset[] createDatasets() {
        XYZDataset[] arrxYZDataset = new XYZDataset[]{ScatterPlot3D3.createDataset("sepal length", "sepal width", "petal length"), ScatterPlot3D3.createDataset("sepal length", "sepal width", "petal width"), ScatterPlot3D3.createDataset("sepal length", "petal width", "petal length"), ScatterPlot3D3.createDataset("sepal width", "petal width", "petal length")};
        return arrxYZDataset;
    }

    public static Chart3D createChart(String string, XYZDataset xYZDataset, String string2, String string3, String string4) {
        Chart3D chart3D = Chart3DFactory.createScatterChart((String)null, (String)null, (XYZDataset)xYZDataset, (String)string2, (String)string3, (String)string4);
        TextElement textElement = new TextElement(string);
        textElement.setFont(StandardChartStyle.createDefaultFont((int)0, (int)16));
        chart3D.setTitle((TableElement)textElement);
        chart3D.setLegendAnchor(LegendAnchor.BOTTOM_LEFT);
        chart3D.setLegendOrientation(Orientation.VERTICAL);
        XYZPlot xYZPlot = (XYZPlot)chart3D.getPlot();
        ScatterXYZRenderer scatterXYZRenderer = (ScatterXYZRenderer)xYZPlot.getRenderer();
        scatterXYZRenderer.setSize(0.15);
        scatterXYZRenderer.setColors(Colors.createIntenseColors());
        chart3D.setViewPoint(ViewPoint3D.createAboveLeftViewPoint((double)40.0));
        return chart3D;
    }

    private static XYZDataset createDataset(Comparable<?> comparable, Comparable<?> comparable2, Comparable<?> comparable3) {
        KeyedValues3D keyedValues3D;
        InputStreamReader inputStreamReader = new InputStreamReader(ScatterPlot3D3.class.getResourceAsStream("iris.txt"));
        try {
            keyedValues3D = JSONUtils.readKeyedValues3D((Reader)inputStreamReader);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return DataUtils.extractXYZDatasetFromColumns((KeyedValues3D)keyedValues3D, comparable, comparable2, comparable3);
    }
}

