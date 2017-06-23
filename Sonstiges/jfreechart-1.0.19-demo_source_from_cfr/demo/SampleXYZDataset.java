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

public class SampleXYZDataset
extends AbstractXYZDataset
implements XYZDataset {
    private double[] xVal = new double[]{2.1, 2.375625, 2.375625, 2.232928726, 2.232928726, 1.860415253, 1.840842668, 1.905415253, 2.336029412, 3.8};
    private double[] yVal = new double[]{14.168, 11.156, 10.089, 8.884, 8.719, 8.466, 5.489, 4.107, 4.101, 25.0};
    private double[] zVal = new double[]{2.45, 2.791285714, 2.791285714, 2.2125, 2.2125, 2.22, 2.1, 2.22, 1.64875, 4.0};

    public int getSeriesCount() {
        return 1;
    }

    public Comparable getSeriesKey(int n) {
        return "Series 1";
    }

    public int getItemCount(int n) {
        return this.xVal.length;
    }

    public Number getX(int n, int n2) {
        return new Double(this.xVal[n2]);
    }

    public Number getY(int n, int n2) {
        return new Double(this.yVal[n2]);
    }

    public Number getZ(int n, int n2) {
        return new Double(this.zVal[n2]);
    }
}

