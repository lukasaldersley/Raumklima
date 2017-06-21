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
 *  org.jfree.chart.renderer.category.CategoryItemRendererState
 *  org.jfree.chart.renderer.category.StackedBarRenderer
 *  org.jfree.chart.urls.CategoryURLGenerator
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.text.TextUtilities
 *  org.jfree.ui.RectangleEdge
 *  org.jfree.ui.TextAnchor
 */
package demo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.text.NumberFormat;
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
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.chart.urls.CategoryURLGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.text.TextUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.TextAnchor;

public class ExtendedStackedBarRenderer
extends StackedBarRenderer {
    private boolean showPositiveTotal = true;
    private boolean showNegativeTotal = true;
    private Font totalLabelFont = new Font("SansSerif", 1, 12);
    private NumberFormat totalFormatter = NumberFormat.getInstance();

    public NumberFormat getTotalFormatter() {
        return this.totalFormatter;
    }

    public void setTotalFormatter(NumberFormat numberFormat) {
        if (numberFormat == null) {
            throw new IllegalArgumentException("Null format not permitted.");
        }
        this.totalFormatter = numberFormat;
    }

    public void drawItem(Graphics2D graphics2D, CategoryItemRendererState categoryItemRendererState, Rectangle2D rectangle2D, CategoryPlot categoryPlot, CategoryAxis categoryAxis, ValueAxis valueAxis, CategoryDataset categoryDataset, int n, int n2, int n3) {
        double d;
        float f;
        EntityCollection entityCollection;
        TextAnchor textAnchor;
        double d2;
        double d3;
        float f2;
        CategoryItemLabelGenerator categoryItemLabelGenerator;
        Number number = categoryDataset.getValue(n, n2);
        if (number == null) {
            return;
        }
        double d4 = number.doubleValue();
        PlotOrientation plotOrientation = categoryPlot.getOrientation();
        double d5 = categoryAxis.getCategoryMiddle(n2, this.getColumnCount(), rectangle2D, categoryPlot.getDomainAxisEdge()) - categoryItemRendererState.getBarWidth() / 2.0;
        double d6 = 0.0;
        double d7 = 0.0;
        for (int i = 0; i < n; ++i) {
            Number number2 = categoryDataset.getValue(i, n2);
            if (number2 == null) continue;
            d2 = number2.doubleValue();
            if (d2 > 0.0) {
                d6 += d2;
                continue;
            }
            d7 += d2;
        }
        RectangleEdge rectangleEdge = categoryPlot.getRangeAxisEdge();
        if (d4 > 0.0) {
            d3 = valueAxis.valueToJava2D(d6, rectangle2D, rectangleEdge);
            d2 = valueAxis.valueToJava2D(d6 + d4, rectangle2D, rectangleEdge);
        } else {
            d3 = valueAxis.valueToJava2D(d7, rectangle2D, rectangleEdge);
            d2 = valueAxis.valueToJava2D(d7 + d4, rectangle2D, rectangleEdge);
        }
        double d8 = Math.min(d3, d2);
        double d9 = Math.max(Math.abs(d2 - d3), this.getMinimumBarLength());
        Rectangle2D.Double double_ = null;
        double_ = plotOrientation == PlotOrientation.HORIZONTAL ? new Rectangle2D.Double(d8, d5, d9, categoryItemRendererState.getBarWidth()) : new Rectangle2D.Double(d5, d8, categoryItemRendererState.getBarWidth(), d9);
        Paint paint = this.getItemPaint(n, n2);
        graphics2D.setPaint(paint);
        graphics2D.fill(double_);
        if (this.isDrawBarOutline() && categoryItemRendererState.getBarWidth() > 3.0) {
            graphics2D.setStroke(this.getItemStroke(n, n2));
            graphics2D.setPaint(this.getItemOutlinePaint(n, n2));
            graphics2D.draw(double_);
        }
        if ((categoryItemLabelGenerator = this.getItemLabelGenerator(n, n2)) != null && this.isItemLabelVisible(n, n2)) {
            this.drawItemLabel(graphics2D, categoryDataset, n, n2, categoryPlot, categoryItemLabelGenerator, (Rectangle2D)double_, d4 < 0.0);
        }
        if (d4 > 0.0) {
            if (this.showPositiveTotal && this.isLastPositiveItem(categoryDataset, n, n2)) {
                graphics2D.setPaint(Color.black);
                graphics2D.setFont(this.totalLabelFont);
                d = this.calculateSumOfPositiveValuesForCategory(categoryDataset, n2);
                f = (float)double_.getCenterX();
                f2 = (float)double_.getMinY() - 4.0f;
                textAnchor = TextAnchor.BOTTOM_CENTER;
                if (plotOrientation == PlotOrientation.HORIZONTAL) {
                    f = (float)double_.getMaxX() + 4.0f;
                    f2 = (float)double_.getCenterY();
                    textAnchor = TextAnchor.CENTER_LEFT;
                }
                TextUtilities.drawRotatedString((String)this.totalFormatter.format(d), (Graphics2D)graphics2D, (float)f, (float)f2, (TextAnchor)textAnchor, (double)0.0, (TextAnchor)TextAnchor.CENTER);
            }
        } else if (this.showNegativeTotal && this.isLastNegativeItem(categoryDataset, n, n2)) {
            graphics2D.setPaint(Color.black);
            graphics2D.setFont(this.totalLabelFont);
            d = this.calculateSumOfNegativeValuesForCategory(categoryDataset, n2);
            f = (float)double_.getCenterX();
            f2 = (float)double_.getMaxY() + 4.0f;
            textAnchor = TextAnchor.TOP_CENTER;
            if (plotOrientation == PlotOrientation.HORIZONTAL) {
                f = (float)double_.getMinX() - 4.0f;
                f2 = (float)double_.getCenterY();
                textAnchor = TextAnchor.CENTER_RIGHT;
            }
            TextUtilities.drawRotatedString((String)this.totalFormatter.format(d), (Graphics2D)graphics2D, (float)f, (float)f2, (TextAnchor)textAnchor, (double)0.0, (TextAnchor)TextAnchor.CENTER);
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
            textAnchor = new CategoryItemEntity((Shape)double_, string, string2, categoryDataset, categoryDataset.getRowKey(n), categoryDataset.getColumnKey(n2));
            entityCollection.add((ChartEntity)textAnchor);
        }
    }

    private boolean isLastPositiveItem(CategoryDataset categoryDataset, int n, int n2) {
        boolean bl = true;
        Number number = categoryDataset.getValue(n, n2);
        if (number == null) {
            return false;
        }
        for (int i = n + 1; i < categoryDataset.getRowCount(); ++i) {
            number = categoryDataset.getValue(i, n2);
            if (number == null) continue;
            bl = bl && number.doubleValue() <= 0.0;
        }
        return bl;
    }

    private boolean isLastNegativeItem(CategoryDataset categoryDataset, int n, int n2) {
        boolean bl = true;
        Number number = categoryDataset.getValue(n, n2);
        if (number == null) {
            return false;
        }
        for (int i = n + 1; i < categoryDataset.getRowCount(); ++i) {
            number = categoryDataset.getValue(i, n2);
            if (number == null) continue;
            bl = bl && number.doubleValue() >= 0.0;
        }
        return bl;
    }

    private double calculateSumOfPositiveValuesForCategory(CategoryDataset categoryDataset, int n) {
        double d = 0.0;
        for (int i = 0; i < categoryDataset.getRowCount(); ++i) {
            double d2;
            Number number = categoryDataset.getValue(i, n);
            if (number == null || (d2 = number.doubleValue()) <= 0.0) continue;
            d += d2;
        }
        return d;
    }

    private double calculateSumOfNegativeValuesForCategory(CategoryDataset categoryDataset, int n) {
        double d = 0.0;
        for (int i = 0; i < categoryDataset.getRowCount(); ++i) {
            double d2;
            Number number = categoryDataset.getValue(i, n);
            if (number == null || (d2 = number.doubleValue()) >= 0.0) continue;
            d += d2;
        }
        return d;
    }
}

