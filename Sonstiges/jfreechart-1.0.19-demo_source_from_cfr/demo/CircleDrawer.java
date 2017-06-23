/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.ui.Drawable
 */
package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import org.jfree.ui.Drawable;

public class CircleDrawer
implements Drawable {
    private Paint outlinePaint;
    private Stroke outlineStroke;
    private Paint fillPaint;

    public CircleDrawer(Paint paint, Stroke stroke, Paint paint2) {
        this.outlinePaint = paint;
        this.outlineStroke = stroke;
        this.fillPaint = paint2;
    }

    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        Ellipse2D.Double double_ = new Ellipse2D.Double(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
        if (this.fillPaint != null) {
            graphics2D.setPaint(this.fillPaint);
            graphics2D.fill(double_);
        }
        if (this.outlinePaint != null && this.outlineStroke != null) {
            graphics2D.setPaint(this.outlinePaint);
            graphics2D.setStroke(this.outlineStroke);
            graphics2D.draw(double_);
        }
        graphics2D.setPaint(Color.black);
        graphics2D.setStroke(new BasicStroke(1.0f));
        Line2D.Double double_2 = new Line2D.Double(rectangle2D.getCenterX(), rectangle2D.getMinY(), rectangle2D.getCenterX(), rectangle2D.getMaxY());
        Line2D.Double double_3 = new Line2D.Double(rectangle2D.getMinX(), rectangle2D.getCenterY(), rectangle2D.getMaxX(), rectangle2D.getCenterY());
        graphics2D.draw(double_2);
        graphics2D.draw(double_3);
    }
}

