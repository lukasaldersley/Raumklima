/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.data.DomainInfo
 *  org.jfree.data.Range
 *  org.jfree.data.RangeInfo
 *  org.jfree.data.xy.AbstractXYDataset
 *  org.jfree.data.xy.XYDataset
 */
package demo;

import org.jfree.data.DomainInfo;
import org.jfree.data.Range;
import org.jfree.data.RangeInfo;
import org.jfree.data.xy.AbstractXYDataset;
import org.jfree.data.xy.XYDataset;

public class SampleXYDataset2
extends AbstractXYDataset
implements XYDataset,
DomainInfo,
RangeInfo {
    private static final int DEFAULT_SERIES_COUNT = 4;
    private static final int DEFAULT_ITEM_COUNT = 40;
    private static final double DEFAULT_RANGE = 200.0;
    private Double[][] xValues;
    private Double[][] yValues;
    private int seriesCount;
    private int itemCount;
    private Number domainMin;
    private Number domainMax;
    private Number rangeMin;
    private Number rangeMax;
    private Range domainRange;
    private Range range;

    public SampleXYDataset2() {
        this(4, 40);
    }

    public SampleXYDataset2(int n, int n2) {
        this.xValues = new Double[n][n2];
        this.yValues = new Double[n][n2];
        this.seriesCount = n;
        this.itemCount = n2;
        double d = Double.POSITIVE_INFINITY;
        double d2 = Double.NEGATIVE_INFINITY;
        double d3 = Double.POSITIVE_INFINITY;
        double d4 = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n2; ++j) {
                double d5 = (Math.random() - 0.5) * 200.0;
                this.xValues[i][j] = new Double(d5);
                if (d5 < d) {
                    d = d5;
                }
                if (d5 > d2) {
                    d2 = d5;
                }
                double d6 = (Math.random() + 0.5) * 6.0 * d5 + d5;
                this.yValues[i][j] = new Double(d6);
                if (d6 < d3) {
                    d3 = d6;
                }
                if (d6 <= d4) continue;
                d4 = d6;
            }
        }
        this.domainMin = new Double(d);
        this.domainMax = new Double(d2);
        this.domainRange = new Range(d, d2);
        this.rangeMin = new Double(d3);
        this.rangeMax = new Double(d4);
        this.range = new Range(d3, d4);
    }

    public Number getX(int n, int n2) {
        return this.xValues[n][n2];
    }

    public Number getY(int n, int n2) {
        return this.yValues[n][n2];
    }

    public int getSeriesCount() {
        return this.seriesCount;
    }

    public Comparable getSeriesKey(int n) {
        return "Sample " + n;
    }

    public int getItemCount(int n) {
        return this.itemCount;
    }

    public double getDomainLowerBound() {
        return this.domainMin.doubleValue();
    }

    public double getDomainLowerBound(boolean bl) {
        return this.domainMin.doubleValue();
    }

    public double getDomainUpperBound() {
        return this.domainMax.doubleValue();
    }

    public double getDomainUpperBound(boolean bl) {
        return this.domainMax.doubleValue();
    }

    public Range getDomainBounds() {
        return this.domainRange;
    }

    public Range getDomainBounds(boolean bl) {
        return this.domainRange;
    }

    public Range getDomainRange() {
        return this.domainRange;
    }

    public double getRangeLowerBound() {
        return this.rangeMin.doubleValue();
    }

    public double getRangeLowerBound(boolean bl) {
        return this.rangeMin.doubleValue();
    }

    public double getRangeUpperBound() {
        return this.rangeMax.doubleValue();
    }

    public double getRangeUpperBound(boolean bl) {
        return this.rangeMax.doubleValue();
    }

    public Range getRangeBounds(boolean bl) {
        return this.range;
    }

    public Range getValueRange() {
        return this.range;
    }

    public Number getMinimumDomainValue() {
        return this.domainMin;
    }

    public Number getMaximumDomainValue() {
        return this.domainMax;
    }

    public Number getMinimumRangeValue() {
        return this.domainMin;
    }

    public Number getMaximumRangeValue() {
        return this.domainMax;
    }
}

