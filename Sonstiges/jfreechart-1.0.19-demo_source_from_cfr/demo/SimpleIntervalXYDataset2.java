/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.data.general.DatasetChangeListener
 *  org.jfree.data.xy.AbstractIntervalXYDataset
 *  org.jfree.data.xy.IntervalXYDataset
 */
package demo;

import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;

public class SimpleIntervalXYDataset2
extends AbstractIntervalXYDataset
implements IntervalXYDataset {
    private Double[] yStart;
    private Double[] yEnd = new Double[3];
    private Double[] xValues = new Double[3];

    public SimpleIntervalXYDataset2(int n) {
        this.xValues = new Double[n];
        this.yStart = new Double[n];
        this.yEnd = new Double[n];
        double d = 100.0;
        for (int i = 1; i <= n; ++i) {
            this.xValues[i - 1] = new Double(i);
            this.yStart[i - 1] = new Double(d *= 1.0 + (Math.random() / 10.0 - 0.05));
            this.yEnd[i - 1] = new Double(this.yStart[i - 1] + Math.random() * 30.0);
        }
    }

    public int getSeriesCount() {
        return 1;
    }

    public Comparable getSeriesKey(int n) {
        return "Series 1";
    }

    public int getItemCount(int n) {
        return this.xValues.length;
    }

    public Number getX(int n, int n2) {
        return this.xValues[n2];
    }

    public Number getY(int n, int n2) {
        return this.yEnd[n2];
    }

    public Number getStartX(int n, int n2) {
        return this.xValues[n2];
    }

    public Number getEndX(int n, int n2) {
        return this.xValues[n2];
    }

    public Number getStartY(int n, int n2) {
        return this.yStart[n2];
    }

    public Number getEndY(int n, int n2) {
        return this.yEnd[n2];
    }

    public void addChangeListener(DatasetChangeListener datasetChangeListener) {
    }

    public void removeChangeListener(DatasetChangeListener datasetChangeListener) {
    }
}

