/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.Chart3D
 *  com.orsoncharts.Chart3DFactory
 *  com.orsoncharts.ChartElementVisitor
 *  com.orsoncharts.Range
 *  com.orsoncharts.axis.NumberAxis3D
 *  com.orsoncharts.axis.ValueAxis3D
 *  com.orsoncharts.data.xyz.XYZDataset
 *  com.orsoncharts.data.xyz.XYZSeries
 *  com.orsoncharts.data.xyz.XYZSeriesCollection
 *  com.orsoncharts.graphics3d.Dimension3D
 *  com.orsoncharts.graphics3d.ViewPoint3D
 *  com.orsoncharts.interaction.StandardXYZDataItemSelection
 *  com.orsoncharts.interaction.XYZDataItemSelection
 *  com.orsoncharts.label.StandardXYZItemLabelGenerator
 *  com.orsoncharts.label.XYZItemLabelGenerator
 *  com.orsoncharts.marker.RangeMarker
 *  com.orsoncharts.marker.ValueMarker
 *  com.orsoncharts.plot.Plot3D
 *  com.orsoncharts.plot.XYZPlot
 *  com.orsoncharts.renderer.xyz.ScatterXYZRenderer
 *  com.orsoncharts.renderer.xyz.XYZColorSource
 *  com.orsoncharts.renderer.xyz.XYZRenderer
 *  com.orsoncharts.style.ChartStyle
 *  com.orsoncharts.style.ChartStyler
 *  com.orsoncharts.style.ChartStyles
 *  com.orsoncharts.util.Anchor2D
 */
package demo.orsoncharts;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.ChartElementVisitor;
import com.orsoncharts.Range;
import com.orsoncharts.axis.NumberAxis3D;
import com.orsoncharts.axis.ValueAxis3D;
import com.orsoncharts.data.xyz.XYZDataset;
import com.orsoncharts.data.xyz.XYZSeries;
import com.orsoncharts.data.xyz.XYZSeriesCollection;
import com.orsoncharts.graphics3d.Dimension3D;
import com.orsoncharts.graphics3d.ViewPoint3D;
import com.orsoncharts.interaction.StandardXYZDataItemSelection;
import com.orsoncharts.interaction.XYZDataItemSelection;
import com.orsoncharts.label.StandardXYZItemLabelGenerator;
import com.orsoncharts.label.XYZItemLabelGenerator;
import com.orsoncharts.marker.RangeMarker;
import com.orsoncharts.marker.ValueMarker;
import com.orsoncharts.plot.Plot3D;
import com.orsoncharts.plot.XYZPlot;
import com.orsoncharts.renderer.xyz.ScatterXYZRenderer;
import com.orsoncharts.renderer.xyz.XYZColorSource;
import com.orsoncharts.renderer.xyz.XYZRenderer;
import com.orsoncharts.style.ChartStyle;
import com.orsoncharts.style.ChartStyler;
import com.orsoncharts.style.ChartStyles;
import com.orsoncharts.util.Anchor2D;
import demo.orsoncharts.HighlightXYZColorSource;
import java.awt.Color;

public class RangeMarker1 {
    public static Chart3D createChart(XYZDataset xYZDataset) {
        Chart3D chart3D = Chart3DFactory.createScatterChart((String)"RangeMarkerDemo1", (String)null, (XYZDataset)xYZDataset, (String)"X", (String)"Y", (String)"Z");
        chart3D.setStyle(ChartStyles.createOrson1Style());
        XYZPlot xYZPlot = (XYZPlot)chart3D.getPlot();
        xYZPlot.setDimensions(new Dimension3D(10.0, 6.0, 10.0));
        ChartStyler chartStyler = new ChartStyler(chart3D.getStyle());
        NumberAxis3D numberAxis3D = (NumberAxis3D)xYZPlot.getXAxis();
        RangeMarker rangeMarker = new RangeMarker(60.0, 90.0, "X: 60 to 90");
        rangeMarker.receive((ChartElementVisitor)chartStyler);
        rangeMarker.setFillColor(new Color(128, 128, 255, 128));
        rangeMarker.setLabelAnchor(Anchor2D.BOTTOM_LEFT);
        numberAxis3D.setMarker("X1", (ValueMarker)rangeMarker);
        NumberAxis3D numberAxis3D2 = (NumberAxis3D)xYZPlot.getYAxis();
        RangeMarker rangeMarker2 = new RangeMarker(0.002, 0.006, "Y: 0.002 to 0.006");
        rangeMarker2.receive((ChartElementVisitor)chartStyler);
        rangeMarker2.setFillColor(new Color(128, 255, 128, 128));
        numberAxis3D2.setMarker("Y1", (ValueMarker)rangeMarker2);
        NumberAxis3D numberAxis3D3 = (NumberAxis3D)xYZPlot.getZAxis();
        RangeMarker rangeMarker3 = new RangeMarker(20.0, 60.0, "Z: 20 to 60");
        rangeMarker3.setLabelAnchor(Anchor2D.TOP_LEFT);
        rangeMarker3.receive((ChartElementVisitor)chartStyler);
        rangeMarker3.setFillColor(new Color(255, 128, 128, 128));
        numberAxis3D3.setMarker("Z1", (ValueMarker)rangeMarker3);
        ScatterXYZRenderer scatterXYZRenderer = (ScatterXYZRenderer)xYZPlot.getRenderer();
        scatterXYZRenderer.setSize(0.15);
        HighlightXYZColorSource highlightXYZColorSource = new HighlightXYZColorSource(xYZPlot.getDataset(), Color.RED, rangeMarker.getRange(), rangeMarker2.getRange(), rangeMarker3.getRange(), chart3D.getStyle().getStandardColors());
        scatterXYZRenderer.setColorSource((XYZColorSource)highlightXYZColorSource);
        StandardXYZItemLabelGenerator standardXYZItemLabelGenerator = new StandardXYZItemLabelGenerator();
        StandardXYZDataItemSelection standardXYZDataItemSelection = new StandardXYZDataItemSelection();
        standardXYZItemLabelGenerator.setItemSelection((XYZDataItemSelection)standardXYZDataItemSelection);
        scatterXYZRenderer.setItemLabelGenerator((XYZItemLabelGenerator)standardXYZItemLabelGenerator);
        chart3D.setViewPoint(ViewPoint3D.createAboveLeftViewPoint((double)40.0));
        return chart3D;
    }

    public static XYZDataset createDataset() {
        XYZSeries xYZSeries = RangeMarker1.createRandomSeries("S1", 10);
        XYZSeries xYZSeries2 = RangeMarker1.createRandomSeries("S2", 50);
        XYZSeries xYZSeries3 = RangeMarker1.createRandomSeries("S3", 150);
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

