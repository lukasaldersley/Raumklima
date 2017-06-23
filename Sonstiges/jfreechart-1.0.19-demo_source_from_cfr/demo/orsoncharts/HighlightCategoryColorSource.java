/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.Colors
 *  com.orsoncharts.renderer.category.StandardCategoryColorSource
 *  com.orsoncharts.util.ArgChecks
 */
package demo.orsoncharts;

import com.orsoncharts.Colors;
import com.orsoncharts.renderer.category.StandardCategoryColorSource;
import com.orsoncharts.util.ArgChecks;
import java.awt.Color;

public class HighlightCategoryColorSource
extends StandardCategoryColorSource {
    private int highlightRowIndex;
    private int highlightColumnIndex;
    private Color highlightColor;

    public HighlightCategoryColorSource() {
        this(-1, -1, Color.RED, Colors.getDefaultColors());
    }

    public /* varargs */ HighlightCategoryColorSource(int n, int n2, Color color, Color ... arrcolor) {
        super(arrcolor);
        this.highlightRowIndex = n;
        this.highlightColumnIndex = n2;
        this.highlightColor = color;
    }

    public int getHighlightRowIndex() {
        return this.highlightRowIndex;
    }

    public void setHighlightRowIndex(int n) {
        this.highlightRowIndex = n;
    }

    public int getHighlightColumnIndex() {
        return this.highlightColumnIndex;
    }

    public void setHighlightColumnIndex(int n) {
        this.highlightColumnIndex = n;
    }

    public Color getHighlightColor() {
        return this.highlightColor;
    }

    public void setHighlightColor(Color color) {
        ArgChecks.nullNotPermitted((Object)color, (String)"color");
        this.highlightColor = color;
    }

    public Color getColor(int n, int n2, int n3) {
        Color color = super.getColor(n, n2, n3);
        if (n2 == this.highlightRowIndex && n3 == this.highlightColumnIndex) {
            color = this.highlightColor;
        }
        return color;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof HighlightCategoryColorSource)) {
            return false;
        }
        HighlightCategoryColorSource highlightCategoryColorSource = (HighlightCategoryColorSource)((Object)object);
        if (this.highlightColumnIndex != highlightCategoryColorSource.highlightColumnIndex) {
            return false;
        }
        if (this.highlightRowIndex != highlightCategoryColorSource.highlightRowIndex) {
            return false;
        }
        if (!this.highlightColor.equals(highlightCategoryColorSource.highlightColor)) {
            return false;
        }
        return super.equals(object);
    }
}

