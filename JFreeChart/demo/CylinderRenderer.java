/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.entity.CategoryItemEntity
 *  org.jfree.chart.entity.ChartEntity
 *  org.jfree.chart.entity.EntityCollection
 *  org.jfree.chart.labels.CategoryItemLabelGenerator
 *  org.jfree.chart.labels.CategoryToolTipGenerator
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.chart.plot.PlotRenderingInfo
 *  org.jfree.chart.renderer.category.BarRenderer3D
 *  org.jfree.chart.renderer.category.CategoryItemRendererState
 *  org.jfree.chart.urls.CategoryURLGenerator
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.ui.GradientPaintTransformer
 *  org.jfree.ui.RectangleEdge
 */
package demo;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.chart.urls.CategoryURLGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.RectangleEdge;

public class CylinderRenderer
extends BarRenderer3D {
    public CylinderRenderer() {
    }

    public CylinderRenderer(double d, double d2) {
        super(d, d2);
    }

    public void drawItem(Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, CategoryDataset categoryDataset, int n, int n2, int n3) {
        Object object;
        GradientPaint gradientPaint;
        EntityCollection entityCollection;
        Number number = categoryDataset.getValue(n, n2);
        if (number == null) {
            return;
        }
        double d = number.doubleValue();
        Rectangle2D.Double double_ = new Rectangle2D.Double(rectangle2D.getX(), rectangle2D.getY() + this.getYOffset(), rectangle2D.getWidth() - this.getXOffset(), rectangle2D.getHeight() - this.getYOffset());
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        double d2 = this.calculateBarW0(categoryPlot, plotOrientation, (Rectangle2D)double_, categoryAxis, categoryItemRendererState, n, n2);
        double[] arrd = this.calculateBarL0L1(d);
        if (arrd == null) {
            return;
        }
        RectangleEdge rectangleEdge = categoryPlot.getRangeAxisEdge();
        float f = (float)valueAxis.valueToJava2D(arrd[0], (Rectangle2D)double_, rectangleEdge);
        float f2 = (float)valueAxis.valueToJava2D(arrd[1], (Rectangle2D)double_, rectangleEdge);
        float f3 = Math.min(f, f2);
        float f4 = Math.abs(f2 - f);
        GeneralPath generalPath = new GeneralPath();
        Ellipse2D.Double double_2 = null;
        if (plotOrientation == PlotOrientation.HORIZONTAL) {
            generalPath.moveTo((float)((double)f3 + this.getXOffset() / 2.0), (float)d2);
            generalPath.lineTo((float)((double)(f3 + f4) + this.getXOffset() / 2.0), (float)d2);
            object = new Arc2D.Double(f3 + f4, d2, this.getXOffset(), categoryItemRendererState.getBarWidth(), 90.0, 180.0, 0);
            generalPath.append((Shape)object, true);
            generalPath.lineTo((float)((double)f3 + this.getXOffset() / 2.0), (float)(d2 + categoryItemRendererState.getBarWidth()));
            object = new Arc2D.Double(f3, d2, this.getXOffset(), categoryItemRendererState.getBarWidth(), 270.0, -180.0, 0);
            generalPath.append((Shape)object, true);
            generalPath.closePath();
            double_2 = new Ellipse2D.Double(f3 + f4, d2, this.getXOffset(), categoryItemRendererState.getBarWidth());
        } else {
            generalPath.moveTo((float)d2, (float)((double)f3 - this.getYOffset() / 2.0));
            generalPath.lineTo((float)d2, (float)((double)(f3 + f4) - this.getYOffset() / 2.0));
            object = new Arc2D.Double(d2, (double)(f3 + f4) - this.getYOffset(), categoryItemRendererState.getBarWidth(), this.getYOffset(), 180.0, 180.0, 0);
            generalPath.append((Shape)object, true);
            generalPath.lineTo((float)(d2 + categoryItemRendererState.getBarWidth()), (float)((double)f3 - this.getYOffset() / 2.0));
            object = new Arc2D.Double(d2, (double)f3 - this.getYOffset(), categoryItemRendererState.getBarWidth(), this.getYOffset(), 0.0, -180.0, 0);
            generalPath.append((Shape)object, true);
            generalPath.closePath();
            double_2 = new Ellipse2D.Double(d2, (double)f3 - this.getYOffset(), categoryItemRendererState.getBarWidth(), this.getYOffset());
        }
        object = this.getItemPaint(n, n2);
        if (this.getGradientPaintTransformer() != null && object instanceof GradientPaint) {
            gradientPaint = (GradientPaint)object;
            object = this.getGradientPaintTransformer().transform(gradientPaint, (Shape)generalPath);
        }
        graphics2D.setPaint((Paint)object);
        graphics2D.fill(generalPath);
        if (object instanceof GradientPaint) {
            graphics2D.setPaint(((GradientPaint)object).getColor2());
        }
        if (double_2 != null) {
            graphics2D.fill(double_2);
        }
        if (this.isDrawBarOutline() && categoryItemRendererState.getBarWidth() > 3.0) {
            graphics2D.setStroke(this.getItemOutlineStroke(n, n2));
            graphics2D.setPaint(this.getItemOutlinePaint(n, n2));
            graphics2D.draw(generalPath);
            if (double_2 != null) {
                graphics2D.draw(double_2);
            }
        }
        if ((gradientPaint = this.getItemLabelGenerator(n, n2)) != null && this.isItemLabelVisible(n, n2)) {
            this.drawItemLabel(graphics2D, categoryDataset, n, n2, categoryPlot, (CategoryItemLabelGenerator)gradientPaint, generalPath.getBounds2D(), d < 0.0);
        }
        if (categoryItemRendererState.getInfo() != null && (entityCollection = categoryItemRendererState.getEntityCollection()) != null) {
            String string = null;
            CategoryToolTipGenerator categoryToolTipGenerator = this.getToolTipGenerator(n, n2);
            if (categoryToolTipGenerator != null) {
                string = categoryToolTipGenerator.generateToolTip(categoryDataset, n, n2);
            }
            String string2 = null;
            if (this.getItemURLGenerator(n, n2) != null) {
                string2 = this.getItemURLGenerator(n, n2).generateURL(categoryDataset, n, n2);
            }
            CategoryItemEntity categoryItemEntity = new CategoryItemEntity((Shape)generalPath.getBounds2D(), string, string2, categoryDataset, categoryDataset.getRowKey(n), categoryDataset.getColumnKey(n2));
            entityCollection.add((ChartEntity)categoryItemEntity);
        }
    }
}

