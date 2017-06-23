/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.data.xy.AbstractXYZDataset
 *  org.jfree.data.xy.XYZDataset
 */
package demo;

import org.jfree.data.xy.AbstractXYZDataset;
import org.jfree.data.xy.XYZDataset;

public class SampleXYZDataset2
extends AbstractXYZDataset
implements XYZDataset {
    private double[][] xVal = new double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}};
    private double[][] yVal = new double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}};
    private double[][] zVal = new double[][]{{1.1, 2.2, 3.3}, {4.4, 5.5, 6.6}};

    public int getSeriesCount() {
        return this.xVal.length;
    }

    public Comparable getSeriesKey(int n) {
        return "Series " + n;
    }

    public int getItemCount(int n) {
        return this.xVal[0].length;
    }

    public Number getX(int n, int n2) {
        return new Double(this.xVal[n][n2]);
    }

    public Number getY(int n, int n2) {
        return new Double(this.yVal[n][n2]);
    }

    public Number getZ(int n, int n2) {
        return new Double(this.zVal[n][n2]);
    }
}

