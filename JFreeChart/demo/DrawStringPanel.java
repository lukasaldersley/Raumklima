/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.text.TextUtilities
 *  org.jfree.ui.TextAnchor
 */
package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import org.jfree.text.TextUtilities;
import org.jfree.ui.TextAnchor;

public class DrawStringPanel
extends JPanel {
    private static final Dimension PREFERRED_SIZE = new Dimension(500, 300);
    private boolean rotate;
    private String text = "Hello World";
    private TextAnchor anchor = TextAnchor.TOP_LEFT;
    private TextAnchor rotationAnchor = TextAnchor.TOP_LEFT;
    private Font font = new Font("Serif", 0, 12);
    private double angle;

    public DrawStringPanel(String string, boolean bl) {
        this.text = string;
        this.rotate = bl;
    }

    @Override
    public Dimension getPreferredSize() {
        return PREFERRED_SIZE;
    }

    public void setAnchor(TextAnchor textAnchor) {
        this.anchor = textAnchor;
    }

    public void setRotationAnchor(TextAnchor textAnchor) {
        this.rotationAnchor = textAnchor;
    }

    public void setAngle(double d) {
        this.angle = d;
    }

    @Override
    public Font getFont() {
        return this.font;
    }

    @Override
    public void setFont(Font font) {
        this.font = font;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D)graphics;
        Dimension dimension = this.getSize();
        Insets insets = this.getInsets();
        Rectangle2D.Double double_ = new Rectangle2D.Double(insets.left, insets.top, dimension.getWidth() - (double)insets.left - (double)insets.right, dimension.getHeight() - (double)insets.top - (double)insets.bottom);
        double d = double_.getCenterX();
        double d2 = double_.getCenterY();
        Line2D.Double double_2 = new Line2D.Double(d - 2.0, d2 + 2.0, d + 2.0, d2 - 2.0);
        Line2D.Double double_3 = new Line2D.Double(d - 2.0, d2 - 2.0, d + 2.0, d2 + 2.0);
        graphics2D.setPaint(Color.red);
        graphics2D.draw(double_2);
        graphics2D.draw(double_3);
        graphics2D.setFont(this.font);
        graphics2D.setPaint(Color.black);
        if (this.rotate) {
            TextUtilities.drawRotatedString((String)this.text, (Graphics2D)graphics2D, (float)((float)d), (float)((float)d2), (TextAnchor)this.anchor, (double)this.angle, (TextAnchor)this.rotationAnchor);
        } else {
            TextUtilities.drawAlignedString((String)this.text, (Graphics2D)graphics2D, (float)((float)d), (float)((float)d2), (TextAnchor)this.anchor);
        }
    }
}

