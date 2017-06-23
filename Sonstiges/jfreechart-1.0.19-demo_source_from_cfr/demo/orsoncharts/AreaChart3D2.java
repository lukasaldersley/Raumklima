/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.Chart3D
 *  com.orsoncharts.Chart3DFactory
 *  com.orsoncharts.Colors
 *  com.orsoncharts.axis.CategoryAxis3D
 *  com.orsoncharts.data.DefaultKeyedValues
 *  com.orsoncharts.data.KeyedValues
 *  com.orsoncharts.data.category.CategoryDataset3D
 *  com.orsoncharts.data.category.StandardCategoryDataset3D
 *  com.orsoncharts.graphics3d.ViewPoint3D
 *  com.orsoncharts.plot.CategoryPlot3D
 *  com.orsoncharts.plot.Plot3D
 *  com.orsoncharts.renderer.category.AreaRenderer3D
 *  com.orsoncharts.renderer.category.CategoryRenderer3D
 */
package demo.orsoncharts;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Colors;
import com.orsoncharts.axis.CategoryAxis3D;
import com.orsoncharts.data.DefaultKeyedValues;
import com.orsoncharts.data.KeyedValues;
import com.orsoncharts.data.category.CategoryDataset3D;
import com.orsoncharts.data.category.StandardCategoryDataset3D;
import com.orsoncharts.graphics3d.ViewPoint3D;
import com.orsoncharts.plot.CategoryPlot3D;
import com.orsoncharts.plot.Plot3D;
import com.orsoncharts.renderer.category.AreaRenderer3D;
import com.orsoncharts.renderer.category.CategoryRenderer3D;
import java.awt.Color;

public class AreaChart3D2 {
    public static Chart3D createChart(CategoryDataset3D categoryDataset3D) {
        Chart3D chart3D = Chart3DFactory.createAreaChart((String)"AreaChart3DDemo2", (String)"Chart created with Orson Charts", (CategoryDataset3D)categoryDataset3D, (String)"Row", (String)"Category", (String)"Value");
        chart3D.setChartBoxColor(new Color(255, 255, 255, 128));
        chart3D.setViewPoint(ViewPoint3D.createAboveLeftViewPoint((double)40.0));
        CategoryPlot3D categoryPlot3D = (CategoryPlot3D)chart3D.getPlot();
        categoryPlot3D.getRowAxis().setVisible(false);
        AreaRenderer3D areaRenderer3D = (AreaRenderer3D)categoryPlot3D.getRenderer();
        areaRenderer3D.setBaseColor(Color.GRAY);
        areaRenderer3D.setColors(Colors.getSAPMultiColor());
        return chart3D;
    }

    public static CategoryDataset3D createDataset() {
        StandardCategoryDataset3D standardCategoryDataset3D = new StandardCategoryDataset3D();
        DefaultKeyedValues defaultKeyedValues = new DefaultKeyedValues();
        defaultKeyedValues.put((Comparable)((Object)"A"), (Object)-1);
        defaultKeyedValues.put((Comparable)((Object)"B"), (Object)-4);
        defaultKeyedValues.put((Comparable)((Object)"C"), (Object)-9);
        defaultKeyedValues.put((Comparable)((Object)"D"), (Object)-5);
        defaultKeyedValues.put((Comparable)((Object)"E"), (Object)-5);
        defaultKeyedValues.put((Comparable)((Object)"F"), (Object)-2);
        defaultKeyedValues.put((Comparable)((Object)"G"), (Object)-4);
        defaultKeyedValues.put((Comparable)((Object)"H"), (Object)-7);
        defaultKeyedValues.put((Comparable)((Object)"I"), (Object)-3);
        defaultKeyedValues.put((Comparable)((Object)"J"), (Object)-1);
        standardCategoryDataset3D.addSeriesAsRow((Comparable)((Object)"Series 1"), (KeyedValues)defaultKeyedValues);
        DefaultKeyedValues defaultKeyedValues2 = new DefaultKeyedValues();
        defaultKeyedValues2.put((Comparable)((Object)"A"), (Object)1);
        defaultKeyedValues2.put((Comparable)((Object)"B"), (Object)12);
        defaultKeyedValues2.put((Comparable)((Object)"C"), (Object)14);
        defaultKeyedValues2.put((Comparable)((Object)"D"), (Object)7);
        defaultKeyedValues2.put((Comparable)((Object)"E"), (Object)2);
        defaultKeyedValues2.put((Comparable)((Object)"F"), (Object)-9);
        defaultKeyedValues2.put((Comparable)((Object)"G"), (Object)-14);
        defaultKeyedValues2.put((Comparable)((Object)"H"), (Object)0);
        defaultKeyedValues2.put((Comparable)((Object)"I"), (Object)12);
        defaultKeyedValues2.put((Comparable)((Object)"J"), (Object)4);
        standardCategoryDataset3D.addSeriesAsRow((Comparable)((Object)"Series 2"), (KeyedValues)defaultKeyedValues2);
        DefaultKeyedValues defaultKeyedValues3 = new DefaultKeyedValues();
        defaultKeyedValues3.put((Comparable)((Object)"A"), (Object)5);
        defaultKeyedValues3.put((Comparable)((Object)"B"), (Object)13);
        defaultKeyedValues3.put((Comparable)((Object)"C"), (Object)19);
        defaultKeyedValues3.put((Comparable)((Object)"D"), (Object)11);
        defaultKeyedValues3.put((Comparable)((Object)"E"), (Object)10);
        defaultKeyedValues3.put((Comparable)((Object)"F"), (Object)5);
        defaultKeyedValues3.put((Comparable)((Object)"G"), (Object)-7);
        defaultKeyedValues3.put((Comparable)((Object)"H"), (Object)-3);
        defaultKeyedValues3.put((Comparable)((Object)"I"), (Object)-15);
        defaultKeyedValues3.put((Comparable)((Object)"J"), (Object)-20);
        standardCategoryDataset3D.addSeriesAsRow((Comparable)((Object)"Series 3"), (KeyedValues)defaultKeyedValues3);
        DefaultKeyedValues defaultKeyedValues4 = new DefaultKeyedValues();
        defaultKeyedValues4.put((Comparable)((Object)"A"), (Object)5);
        defaultKeyedValues4.put((Comparable)((Object)"B"), (Object)18);
        defaultKeyedValues4.put((Comparable)((Object)"C"), (Object)20);
        defaultKeyedValues4.put((Comparable)((Object)"D"), (Object)17);
        defaultKeyedValues4.put((Comparable)((Object)"E"), (Object)11);
        defaultKeyedValues4.put((Comparable)((Object)"F"), (Object)19);
        defaultKeyedValues4.put((Comparable)((Object)"G"), (Object)25);
        defaultKeyedValues4.put((Comparable)((Object)"H"), (Object)12);
        defaultKeyedValues4.put((Comparable)((Object)"I"), (Object)4);
        defaultKeyedValues4.put((Comparable)((Object)"J"), (Object)2);
        standardCategoryDataset3D.addSeriesAsRow((Comparable)((Object)"Series 4"), (KeyedValues)defaultKeyedValues4);
        return standardCategoryDataset3D;
    }
}

