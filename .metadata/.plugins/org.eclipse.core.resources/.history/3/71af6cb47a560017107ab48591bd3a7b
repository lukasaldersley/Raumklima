/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.Chart3D
 *  com.orsoncharts.Chart3DFactory
 *  com.orsoncharts.Colors
 *  com.orsoncharts.axis.CategoryAxis3D
 *  com.orsoncharts.data.category.CategoryDataset3D
 *  com.orsoncharts.data.category.StandardCategoryDataset3D
 *  com.orsoncharts.graphics3d.Dimension3D
 *  com.orsoncharts.graphics3d.ViewPoint3D
 *  com.orsoncharts.plot.CategoryPlot3D
 *  com.orsoncharts.plot.Plot3D
 *  com.orsoncharts.renderer.category.CategoryRenderer3D
 *  com.orsoncharts.renderer.category.StackedBarRenderer3D
 */
package demo.orsoncharts;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Colors;
import com.orsoncharts.axis.CategoryAxis3D;
import com.orsoncharts.data.category.CategoryDataset3D;
import com.orsoncharts.data.category.StandardCategoryDataset3D;
import com.orsoncharts.graphics3d.Dimension3D;
import com.orsoncharts.graphics3d.ViewPoint3D;
import com.orsoncharts.plot.CategoryPlot3D;
import com.orsoncharts.plot.Plot3D;
import com.orsoncharts.renderer.category.CategoryRenderer3D;
import com.orsoncharts.renderer.category.StackedBarRenderer3D;
import java.awt.Color;

public class StackedBarChart3D2 {
    public static Chart3D createChart(CategoryDataset3D categoryDataset3D) {
        Chart3D chart3D = Chart3DFactory.createStackedBarChart((String)"Water Usage Chart", (String)"Source: http://en.wikipedia.org/wiki/Peak_water#Water_supply", (CategoryDataset3D)categoryDataset3D, (String)null, (String)null, (String)"Cubic meters / person / year");
        CategoryPlot3D categoryPlot3D = (CategoryPlot3D)chart3D.getPlot();
        categoryPlot3D.setDimensions(new Dimension3D(14.0, 6.5, 2.0));
        categoryPlot3D.getRowAxis().setVisible(false);
        StackedBarRenderer3D stackedBarRenderer3D = (StackedBarRenderer3D)categoryPlot3D.getRenderer();
        stackedBarRenderer3D.setBarZWidth(0.3);
        stackedBarRenderer3D.setColors(Colors.createBlueOceanColors());
        chart3D.getViewPoint().moveUpDown(0.10471975511965977);
        return chart3D;
    }

    public static CategoryDataset3D createDataset() {
        StandardCategoryDataset3D standardCategoryDataset3D = new StandardCategoryDataset3D();
        standardCategoryDataset3D.addValue((Number)197, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"R1"), (Comparable)((Object)"Brazil"));
        standardCategoryDataset3D.addValue((Number)64, (Comparable)((Object)"Domestic"), (Comparable)((Object)"R1"), (Comparable)((Object)"Brazil"));
        standardCategoryDataset3D.addValue((Number)57, (Comparable)((Object)"Industrial"), (Comparable)((Object)"R1"), (Comparable)((Object)"Brazil"));
        standardCategoryDataset3D.addValue((Number)339, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"R1"), (Comparable)((Object)"Indonesia"));
        standardCategoryDataset3D.addValue((Number)30, (Comparable)((Object)"Domestic"), (Comparable)((Object)"R1"), (Comparable)((Object)"Indonesia"));
        standardCategoryDataset3D.addValue((Number)4, (Comparable)((Object)"Industrial"), (Comparable)((Object)"R1"), (Comparable)((Object)"Indonesia"));
        standardCategoryDataset3D.addValue((Number)279, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"R1"), (Comparable)((Object)"China"));
        standardCategoryDataset3D.addValue((Number)27, (Comparable)((Object)"Domestic"), (Comparable)((Object)"R1"), (Comparable)((Object)"China"));
        standardCategoryDataset3D.addValue((Number)107, (Comparable)((Object)"Industrial"), (Comparable)((Object)"R1"), (Comparable)((Object)"China"));
        standardCategoryDataset3D.addValue((Number)92, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"R1"), (Comparable)((Object)"Germany"));
        standardCategoryDataset3D.addValue((Number)55, (Comparable)((Object)"Domestic"), (Comparable)((Object)"R1"), (Comparable)((Object)"Germany"));
        standardCategoryDataset3D.addValue((Number)313, (Comparable)((Object)"Industrial"), (Comparable)((Object)"R1"), (Comparable)((Object)"Germany"));
        standardCategoryDataset3D.addValue((Number)96, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"R1"), (Comparable)((Object)"Russia"));
        standardCategoryDataset3D.addValue((Number)102, (Comparable)((Object)"Domestic"), (Comparable)((Object)"R1"), (Comparable)((Object)"Russia"));
        standardCategoryDataset3D.addValue((Number)337, (Comparable)((Object)"Industrial"), (Comparable)((Object)"R1"), (Comparable)((Object)"Russia"));
        standardCategoryDataset3D.addValue((Number)403, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"R1"), (Comparable)((Object)"Turkey"));
        standardCategoryDataset3D.addValue((Number)82, (Comparable)((Object)"Domestic"), (Comparable)((Object)"R1"), (Comparable)((Object)"Turkey"));
        standardCategoryDataset3D.addValue((Number)60, (Comparable)((Object)"Industrial"), (Comparable)((Object)"R1"), (Comparable)((Object)"Turkey"));
        standardCategoryDataset3D.addValue((Number)536, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"R1"), (Comparable)((Object)"Bangladesh"));
        standardCategoryDataset3D.addValue((Number)17, (Comparable)((Object)"Domestic"), (Comparable)((Object)"R1"), (Comparable)((Object)"Bangladesh"));
        standardCategoryDataset3D.addValue((Number)6, (Comparable)((Object)"Industrial"), (Comparable)((Object)"R1"), (Comparable)((Object)"Bangladesh"));
        standardCategoryDataset3D.addValue((Number)508, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"R1"), (Comparable)((Object)"India"));
        standardCategoryDataset3D.addValue((Number)47, (Comparable)((Object)"Domestic"), (Comparable)((Object)"R1"), (Comparable)((Object)"India"));
        standardCategoryDataset3D.addValue((Number)30, (Comparable)((Object)"Industrial"), (Comparable)((Object)"R1"), (Comparable)((Object)"India"));
        standardCategoryDataset3D.addValue((Number)428, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"R1"), (Comparable)((Object)"Japan"));
        standardCategoryDataset3D.addValue((Number)138, (Comparable)((Object)"Domestic"), (Comparable)((Object)"R1"), (Comparable)((Object)"Japan"));
        standardCategoryDataset3D.addValue((Number)124, (Comparable)((Object)"Industrial"), (Comparable)((Object)"R1"), (Comparable)((Object)"Japan"));
        standardCategoryDataset3D.addValue((Number)325, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"R1"), (Comparable)((Object)"Italy"));
        standardCategoryDataset3D.addValue((Number)130, (Comparable)((Object)"Domestic"), (Comparable)((Object)"R1"), (Comparable)((Object)"Italy"));
        standardCategoryDataset3D.addValue((Number)268, (Comparable)((Object)"Industrial"), (Comparable)((Object)"R1"), (Comparable)((Object)"Italy"));
        standardCategoryDataset3D.addValue((Number)569, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"R1"), (Comparable)((Object)"Mexico"));
        standardCategoryDataset3D.addValue((Number)126, (Comparable)((Object)"Domestic"), (Comparable)((Object)"R1"), (Comparable)((Object)"Mexico"));
        standardCategoryDataset3D.addValue((Number)37, (Comparable)((Object)"Industrial"), (Comparable)((Object)"R1"), (Comparable)((Object)"Mexico"));
        standardCategoryDataset3D.addValue((Number)576, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"R1"), (Comparable)((Object)"Vietnam"));
        standardCategoryDataset3D.addValue((Number)68, (Comparable)((Object)"Domestic"), (Comparable)((Object)"R1"), (Comparable)((Object)"Vietnam"));
        standardCategoryDataset3D.addValue((Number)203, (Comparable)((Object)"Industrial"), (Comparable)((Object)"R1"), (Comparable)((Object)"Vietnam"));
        standardCategoryDataset3D.addValue((Number)794, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"R1"), (Comparable)((Object)"Egypt"));
        standardCategoryDataset3D.addValue((Number)74, (Comparable)((Object)"Domestic"), (Comparable)((Object)"R1"), (Comparable)((Object)"Egypt"));
        standardCategoryDataset3D.addValue((Number)55, (Comparable)((Object)"Industrial"), (Comparable)((Object)"R1"), (Comparable)((Object)"Egypt"));
        standardCategoryDataset3D.addValue((Number)954, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"R1"), (Comparable)((Object)"Iran"));
        standardCategoryDataset3D.addValue((Number)21, (Comparable)((Object)"Domestic"), (Comparable)((Object)"R1"), (Comparable)((Object)"Iran"));
        standardCategoryDataset3D.addValue((Number)73, (Comparable)((Object)"Industrial"), (Comparable)((Object)"R1"), (Comparable)((Object)"Iran"));
        standardCategoryDataset3D.addValue((Number)1029, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"R1"), (Comparable)((Object)"Pakistan"));
        standardCategoryDataset3D.addValue((Number)21, (Comparable)((Object)"Domestic"), (Comparable)((Object)"R1"), (Comparable)((Object)"Pakistan"));
        standardCategoryDataset3D.addValue((Number)21, (Comparable)((Object)"Industrial"), (Comparable)((Object)"R1"), (Comparable)((Object)"Pakistan"));
        standardCategoryDataset3D.addValue((Number)1236, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"R1"), (Comparable)((Object)"Thailand"));
        standardCategoryDataset3D.addValue((Number)26, (Comparable)((Object)"Domestic"), (Comparable)((Object)"R1"), (Comparable)((Object)"Thailand"));
        standardCategoryDataset3D.addValue((Number)26, (Comparable)((Object)"Industrial"), (Comparable)((Object)"R1"), (Comparable)((Object)"Thailand"));
        standardCategoryDataset3D.addValue((Number)165, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"R1"), (Comparable)((Object)"Canada"));
        standardCategoryDataset3D.addValue((Number)274, (Comparable)((Object)"Domestic"), (Comparable)((Object)"R1"), (Comparable)((Object)"Canada"));
        standardCategoryDataset3D.addValue((Number)947, (Comparable)((Object)"Industrial"), (Comparable)((Object)"R1"), (Comparable)((Object)"Canada"));
        standardCategoryDataset3D.addValue((Number)1363, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"R1"), (Comparable)((Object)"Iraq"));
        standardCategoryDataset3D.addValue((Number)44, (Comparable)((Object)"Domestic"), (Comparable)((Object)"R1"), (Comparable)((Object)"Iraq"));
        standardCategoryDataset3D.addValue((Number)74, (Comparable)((Object)"Industrial"), (Comparable)((Object)"R1"), (Comparable)((Object)"Iraq"));
        standardCategoryDataset3D.addValue((Number)656, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"R1"), (Comparable)((Object)"US"));
        standardCategoryDataset3D.addValue((Number)208, (Comparable)((Object)"Domestic"), (Comparable)((Object)"R1"), (Comparable)((Object)"US"));
        standardCategoryDataset3D.addValue((Number)736, (Comparable)((Object)"Industrial"), (Comparable)((Object)"R1"), (Comparable)((Object)"US"));
        standardCategoryDataset3D.addValue((Number)2040, (Comparable)((Object)"Agricultural"), (Comparable)((Object)"R1"), (Comparable)((Object)"Uzbekistan"));
        standardCategoryDataset3D.addValue((Number)110, (Comparable)((Object)"Domestic"), (Comparable)((Object)"R1"), (Comparable)((Object)"Uzbekistan"));
        standardCategoryDataset3D.addValue((Number)44, (Comparable)((Object)"Industrial"), (Comparable)((Object)"R1"), (Comparable)((Object)"Uzbekistan"));
        return standardCategoryDataset3D;
    }
}

