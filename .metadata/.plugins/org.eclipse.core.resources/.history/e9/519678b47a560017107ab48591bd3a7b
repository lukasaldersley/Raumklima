/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.Chart3D
 *  com.orsoncharts.Chart3DFactory
 *  com.orsoncharts.Colors
 *  com.orsoncharts.axis.CategoryAxis3D
 *  com.orsoncharts.axis.NumberAxis3D
 *  com.orsoncharts.axis.StandardCategoryAxis3D
 *  com.orsoncharts.axis.ValueAxis3D
 *  com.orsoncharts.data.DefaultKeyedValues
 *  com.orsoncharts.data.KeyedValues
 *  com.orsoncharts.data.category.CategoryDataset3D
 *  com.orsoncharts.data.category.StandardCategoryDataset3D
 *  com.orsoncharts.graphics3d.ViewPoint3D
 *  com.orsoncharts.label.CategoryItemLabelGenerator
 *  com.orsoncharts.label.StandardCategoryItemLabelGenerator
 *  com.orsoncharts.legend.LegendAnchor
 *  com.orsoncharts.plot.CategoryPlot3D
 *  com.orsoncharts.plot.Plot3D
 *  com.orsoncharts.renderer.category.CategoryRenderer3D
 *  com.orsoncharts.util.Anchor2D
 *  com.orsoncharts.util.Orientation
 *  com.orsonpdf.PDFHints
 *  com.orsonpdf.PDFHints$Key
 */
package demo.orsoncharts;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Colors;
import com.orsoncharts.axis.CategoryAxis3D;
import com.orsoncharts.axis.NumberAxis3D;
import com.orsoncharts.axis.StandardCategoryAxis3D;
import com.orsoncharts.axis.ValueAxis3D;
import com.orsoncharts.data.DefaultKeyedValues;
import com.orsoncharts.data.KeyedValues;
import com.orsoncharts.data.category.CategoryDataset3D;
import com.orsoncharts.data.category.StandardCategoryDataset3D;
import com.orsoncharts.graphics3d.ViewPoint3D;
import com.orsoncharts.label.CategoryItemLabelGenerator;
import com.orsoncharts.label.StandardCategoryItemLabelGenerator;
import com.orsoncharts.legend.LegendAnchor;
import com.orsoncharts.plot.CategoryPlot3D;
import com.orsoncharts.plot.Plot3D;
import com.orsoncharts.renderer.category.CategoryRenderer3D;
import com.orsoncharts.util.Anchor2D;
import com.orsoncharts.util.Orientation;
import com.orsonpdf.PDFHints;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.RenderingHints;
import java.awt.Stroke;

public class BarChart3D2 {
    public static Chart3D createChart(CategoryDataset3D categoryDataset3D) {
        Chart3D chart3D = Chart3DFactory.createBarChart((String)"Average Maximum Temperature", (String)"http://www.worldclimateguide.co.uk/climateguides/", (CategoryDataset3D)categoryDataset3D, (String)null, (String)null, (String)"Temp \u00b0C");
        chart3D.getRenderingHints().put((Object)PDFHints.KEY_DRAW_STRING_TYPE, PDFHints.VALUE_DRAW_STRING_TYPE_VECTOR);
        chart3D.setLegendPosition(LegendAnchor.BOTTOM_RIGHT, Orientation.VERTICAL);
        chart3D.getViewPoint().panLeftRight(-0.05235987755982988);
        CategoryPlot3D categoryPlot3D = (CategoryPlot3D)chart3D.getPlot();
        StandardCategoryAxis3D standardCategoryAxis3D = (StandardCategoryAxis3D)categoryPlot3D.getColumnAxis();
        NumberAxis3D numberAxis3D = (NumberAxis3D)categoryPlot3D.getValueAxis();
        StandardCategoryAxis3D standardCategoryAxis3D2 = (StandardCategoryAxis3D)categoryPlot3D.getRowAxis();
        categoryPlot3D.setGridlineStrokeForValues((Stroke)new BasicStroke(0.0f));
        standardCategoryAxis3D.setLineColor(new Color(0, 0, 0, 0));
        numberAxis3D.setLineColor(new Color(0, 0, 0, 0));
        standardCategoryAxis3D2.setLineColor(new Color(0, 0, 0, 0));
        categoryPlot3D.getRenderer().setColors(Colors.createPastelColors());
        categoryPlot3D.setToolTipGenerator((CategoryItemLabelGenerator)new StandardCategoryItemLabelGenerator("%2$s (%3$s) = %4$s degrees"));
        return chart3D;
    }

    public static CategoryDataset3D createDataset() {
        StandardCategoryDataset3D standardCategoryDataset3D = new StandardCategoryDataset3D();
        DefaultKeyedValues defaultKeyedValues = new DefaultKeyedValues();
        defaultKeyedValues.put((Comparable)((Object)"Jan"), (Object)7);
        defaultKeyedValues.put((Comparable)((Object)"Feb"), (Object)7);
        defaultKeyedValues.put((Comparable)((Object)"Mar"), (Object)10);
        defaultKeyedValues.put((Comparable)((Object)"Apr"), (Object)13);
        defaultKeyedValues.put((Comparable)((Object)"May"), (Object)17);
        defaultKeyedValues.put((Comparable)((Object)"Jun"), (Object)20);
        defaultKeyedValues.put((Comparable)((Object)"Jul"), (Object)22);
        defaultKeyedValues.put((Comparable)((Object)"Aug"), (Object)21);
        defaultKeyedValues.put((Comparable)((Object)"Sep"), (Object)19);
        defaultKeyedValues.put((Comparable)((Object)"Oct"), (Object)15);
        defaultKeyedValues.put((Comparable)((Object)"Nov"), (Object)10);
        defaultKeyedValues.put((Comparable)((Object)"Dec"), (Object)8);
        standardCategoryDataset3D.addSeriesAsRow((Comparable)((Object)"London"), (KeyedValues)defaultKeyedValues);
        DefaultKeyedValues defaultKeyedValues2 = new DefaultKeyedValues();
        defaultKeyedValues2.put((Comparable)((Object)"Jan"), (Object)3);
        defaultKeyedValues2.put((Comparable)((Object)"Feb"), (Object)5);
        defaultKeyedValues2.put((Comparable)((Object)"Mar"), (Object)9);
        defaultKeyedValues2.put((Comparable)((Object)"Apr"), (Object)14);
        defaultKeyedValues2.put((Comparable)((Object)"May"), (Object)18);
        defaultKeyedValues2.put((Comparable)((Object)"Jun"), (Object)22);
        defaultKeyedValues2.put((Comparable)((Object)"Jul"), (Object)25);
        defaultKeyedValues2.put((Comparable)((Object)"Aug"), (Object)24);
        defaultKeyedValues2.put((Comparable)((Object)"Sep"), (Object)20);
        defaultKeyedValues2.put((Comparable)((Object)"Oct"), (Object)14);
        defaultKeyedValues2.put((Comparable)((Object)"Nov"), (Object)8);
        defaultKeyedValues2.put((Comparable)((Object)"Dec"), (Object)4);
        standardCategoryDataset3D.addSeriesAsRow((Comparable)((Object)"Geneva"), (KeyedValues)defaultKeyedValues2);
        DefaultKeyedValues defaultKeyedValues3 = new DefaultKeyedValues();
        defaultKeyedValues3.put((Comparable)((Object)"Jan"), (Object)9);
        defaultKeyedValues3.put((Comparable)((Object)"Feb"), (Object)11);
        defaultKeyedValues3.put((Comparable)((Object)"Mar"), (Object)13);
        defaultKeyedValues3.put((Comparable)((Object)"Apr"), (Object)16);
        defaultKeyedValues3.put((Comparable)((Object)"May"), (Object)20);
        defaultKeyedValues3.put((Comparable)((Object)"Jun"), (Object)23);
        defaultKeyedValues3.put((Comparable)((Object)"Jul"), (Object)26);
        defaultKeyedValues3.put((Comparable)((Object)"Aug"), (Object)26);
        defaultKeyedValues3.put((Comparable)((Object)"Sep"), (Object)24);
        defaultKeyedValues3.put((Comparable)((Object)"Oct"), (Object)19);
        defaultKeyedValues3.put((Comparable)((Object)"Nov"), (Object)13);
        defaultKeyedValues3.put((Comparable)((Object)"Dec"), (Object)9);
        standardCategoryDataset3D.addSeriesAsRow((Comparable)((Object)"Bergerac"), (KeyedValues)defaultKeyedValues3);
        DefaultKeyedValues defaultKeyedValues4 = new DefaultKeyedValues();
        defaultKeyedValues4.put((Comparable)((Object)"Jan"), (Object)22);
        defaultKeyedValues4.put((Comparable)((Object)"Feb"), (Object)22);
        defaultKeyedValues4.put((Comparable)((Object)"Mar"), (Object)20);
        defaultKeyedValues4.put((Comparable)((Object)"Apr"), (Object)17);
        defaultKeyedValues4.put((Comparable)((Object)"May"), (Object)14);
        defaultKeyedValues4.put((Comparable)((Object)"Jun"), (Object)11);
        defaultKeyedValues4.put((Comparable)((Object)"Jul"), (Object)11);
        defaultKeyedValues4.put((Comparable)((Object)"Aug"), (Object)12);
        defaultKeyedValues4.put((Comparable)((Object)"Sep"), (Object)14);
        defaultKeyedValues4.put((Comparable)((Object)"Oct"), (Object)17);
        defaultKeyedValues4.put((Comparable)((Object)"Nov"), (Object)19);
        defaultKeyedValues4.put((Comparable)((Object)"Dec"), (Object)21);
        standardCategoryDataset3D.addSeriesAsRow((Comparable)((Object)"Christchurch"), (KeyedValues)defaultKeyedValues4);
        DefaultKeyedValues defaultKeyedValues5 = new DefaultKeyedValues();
        defaultKeyedValues5.put((Comparable)((Object)"Jan"), (Object)20);
        defaultKeyedValues5.put((Comparable)((Object)"Feb"), (Object)20);
        defaultKeyedValues5.put((Comparable)((Object)"Mar"), (Object)19);
        defaultKeyedValues5.put((Comparable)((Object)"Apr"), (Object)17);
        defaultKeyedValues5.put((Comparable)((Object)"May"), (Object)14);
        defaultKeyedValues5.put((Comparable)((Object)"Jun"), (Object)12);
        defaultKeyedValues5.put((Comparable)((Object)"Jul"), (Object)11);
        defaultKeyedValues5.put((Comparable)((Object)"Aug"), (Object)12);
        defaultKeyedValues5.put((Comparable)((Object)"Sep"), (Object)13);
        defaultKeyedValues5.put((Comparable)((Object)"Oct"), (Object)15);
        defaultKeyedValues5.put((Comparable)((Object)"Nov"), (Object)17);
        defaultKeyedValues5.put((Comparable)((Object)"Dec"), (Object)19);
        standardCategoryDataset3D.addSeriesAsRow((Comparable)((Object)"Wellington"), (KeyedValues)defaultKeyedValues5);
        return standardCategoryDataset3D;
    }
}

