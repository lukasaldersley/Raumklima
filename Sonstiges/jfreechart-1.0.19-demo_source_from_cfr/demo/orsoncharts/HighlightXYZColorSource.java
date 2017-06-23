/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.Range
 *  com.orsoncharts.data.xyz.XYZDataset
 *  com.orsoncharts.renderer.xyz.StandardXYZColorSource
 */
package demo.orsoncharts;

import com.orsoncharts.Range;
import com.orsoncharts.data.xyz.XYZDataset;
import com.orsoncharts.renderer.xyz.StandardXYZColorSource;
import java.awt.Color;

public class HighlightXYZColorSource
extends StandardXYZColorSource {
    private XYZDataset dataset;
    private Range xRange;
    private Range yRange;
    private Range zRange;
    private Color highlightColor;

    public /* varargs */ HighlightXYZColorSource(XYZDataset xYZDataset, Color color, Range range, Range range2, Range range3, Color ... arrcolor) {
        super(arrcolor);
        this.dataset = xYZDataset;
        this.xRange = range;
        this.yRange = range2;
        this.zRange = range3;
        this.highlightColor = color;
    }

    public Color getColor(int n, int n2) {
        double d = this.dataset.getX(n, n2);
        double d2 = this.dataset.getY(n, n2);
        double d3 = this.dataset.getZ(n, n2);
        if (this.xRange.contains(d) && this.yRange.contains(d2) && this.zRange.contains(d3)) {
            return this.highlightColor;
        }
        return super.getColor(n, n2);
    }
}

