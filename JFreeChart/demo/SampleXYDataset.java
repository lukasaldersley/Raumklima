/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.data.general.Dataset
 *  org.jfree.data.general.DatasetChangeEvent
 *  org.jfree.data.xy.AbstractXYDataset
 *  org.jfree.data.xy.XYDataset
 */
package demo;

import org.jfree.data.general.Dataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.xy.AbstractXYDataset;
import org.jfree.data.xy.XYDataset;

public class SampleXYDataset
extends AbstractXYDataset
implements XYDataset {
    private double translate = 0.0;

    public double getTranslate() {
        return this.translate;
    }

    public void setTranslate(double d) {
        this.translate = d;
        this.notifyListeners(new DatasetChangeEvent((Object)this, (Dataset)this));
    }

    public Number getX(int n, int n2) {
        return new Double(-10.0 + this.translate + (double)n2 / 10.0);
    }

    public Number getY(int n, int n2) {
        if (n == 0) {
            return new Double(Math.cos(-10.0 + this.translate + (double)n2 / 10.0));
        }
        return new Double(2.0 * Math.sin(-10.0 + this.translate + (double)n2 / 10.0));
    }

    public int getSeriesCount() {
        return 2;
    }

    public Comparable getSeriesKey(int n) {
        if (n == 0) {
            return "y = cosine(x)";
        }
        if (n == 1) {
            return "y = 2*sine(x)";
        }
        return "Error";
    }

    public int getItemCount(int n) {
        return 200;
    }
}

