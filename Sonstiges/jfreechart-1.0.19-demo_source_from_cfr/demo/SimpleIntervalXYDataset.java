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

public class SimpleIntervalXYDataset
extends AbstractIntervalXYDataset
implements IntervalXYDataset {
    private Double[] xStart = new Double[3];
    private Double[] xEnd = new Double[3];
    private Double[] yValues = new Double[3];

    public SimpleIntervalXYDataset() {
        this.xStart[0] = new Double(0.0);
        this.xStart[1] = new Double(2.0);
        this.xStart[2] = new Double(3.5);
        this.xEnd[0] = new Double(2.0);
        this.xEnd[1] = new Double(3.5);
        this.xEnd[2] = new Double(4.0);
        this.yValues[0] = new Double(3.0);
        this.yValues[1] = new Double(4.5);
        this.yValues[2] = new Double(2.5);
    }

    public int getSeriesCount() {
        return 1;
    }

    public Comparable getSeriesKey(int n) {
        return "Series 1";
    }

    public int getItemCount(int n) {
        return 3;
    }

    public Number getX(int n, int n2) {
        return this.xStart[n2];
    }

    public Number getY(int n, int n2) {
        return this.yValues[n2];
    }

    public Number getStartX(int n, int n2) {
        return this.xStart[n2];
    }

    public Number getEndX(int n, int n2) {
        return this.xEnd[n2];
    }

    public Number getStartY(int n, int n2) {
        return this.yValues[n2];
    }

    public Number getEndY(int n, int n2) {
        return this.yValues[n2];
    }

    public void addChangeListener(DatasetChangeListener datasetChangeListener) {
    }

    public void removeChangeListener(DatasetChangeListener datasetChangeListener) {
    }
}

