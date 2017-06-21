/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.Chart3D
 *  com.orsoncharts.Chart3DFactory
 *  com.orsoncharts.axis.CategoryAxis3D
 *  com.orsoncharts.data.DefaultKeyedValues
 *  com.orsoncharts.data.KeyedValues
 *  com.orsoncharts.data.category.CategoryDataset3D
 *  com.orsoncharts.data.category.StandardCategoryDataset3D
 *  com.orsoncharts.plot.CategoryPlot3D
 *  com.orsoncharts.plot.Plot3D
 *  com.orsoncharts.renderer.category.AreaRenderer3D
 *  com.orsoncharts.renderer.category.CategoryRenderer3D
 */
package demo.orsoncharts;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.axis.CategoryAxis3D;
import com.orsoncharts.data.DefaultKeyedValues;
import com.orsoncharts.data.KeyedValues;
import com.orsoncharts.data.category.CategoryDataset3D;
import com.orsoncharts.data.category.StandardCategoryDataset3D;
import com.orsoncharts.plot.CategoryPlot3D;
import com.orsoncharts.plot.Plot3D;
import com.orsoncharts.renderer.category.AreaRenderer3D;
import com.orsoncharts.renderer.category.CategoryRenderer3D;
import java.awt.Color;

public class AreaChart3D1 {
    public static Chart3D createChart(CategoryDataset3D categoryDataset3D) {
        Chart3D chart3D = Chart3DFactory.createAreaChart((String)"Reported Revenues By Quarter", (String)"Large companies in the IT industry", (CategoryDataset3D)categoryDataset3D, (String)"Company", (String)"Quarter", (String)"Value");
        chart3D.setChartBoxColor(new Color(255, 255, 255, 128));
        CategoryPlot3D categoryPlot3D = (CategoryPlot3D)chart3D.getPlot();
        categoryPlot3D.getRowAxis().setVisible(false);
        AreaRenderer3D areaRenderer3D = (AreaRenderer3D)categoryPlot3D.getRenderer();
        areaRenderer3D.setBaseColor(Color.GRAY);
        return chart3D;
    }

    public static CategoryDataset3D createDataset() {
        StandardCategoryDataset3D standardCategoryDataset3D = new StandardCategoryDataset3D();
        DefaultKeyedValues defaultKeyedValues = new DefaultKeyedValues();
        defaultKeyedValues.put((Comparable)((Object)"Q2/11"), (Object)8.181);
        defaultKeyedValues.put((Comparable)((Object)"Q3/11"), (Object)8.792);
        defaultKeyedValues.put((Comparable)((Object)"Q4/11"), (Object)9.039);
        defaultKeyedValues.put((Comparable)((Object)"Q1/12"), (Object)10.916);
        defaultKeyedValues.put((Comparable)((Object)"Q2/12"), (Object)8.181);
        defaultKeyedValues.put((Comparable)((Object)"Q3/12"), (Object)9.094);
        defaultKeyedValues.put((Comparable)((Object)"Q4/12"), (Object)8.958);
        defaultKeyedValues.put((Comparable)((Object)"Q1/13"), (Object)10.947);
        defaultKeyedValues.put((Comparable)((Object)"Q2/13"), (Object)8.372);
        defaultKeyedValues.put((Comparable)((Object)"Q3/13"), (Object)9.275);
        standardCategoryDataset3D.addSeriesAsRow((Comparable)((Object)"Oracle"), (KeyedValues)defaultKeyedValues);
        DefaultKeyedValues defaultKeyedValues2 = new DefaultKeyedValues();
        defaultKeyedValues2.put((Comparable)((Object)"Q2/11"), (Object)9.03);
        defaultKeyedValues2.put((Comparable)((Object)"Q3/11"), (Object)9.72);
        defaultKeyedValues2.put((Comparable)((Object)"Q4/11"), (Object)10.58);
        defaultKeyedValues2.put((Comparable)((Object)"Q1/12"), (Object)10.65);
        defaultKeyedValues2.put((Comparable)((Object)"Q2/12"), (Object)12.214);
        defaultKeyedValues2.put((Comparable)((Object)"Q3/12"), (Object)14.101);
        defaultKeyedValues2.put((Comparable)((Object)"Q4/12"), (Object)14.419);
        defaultKeyedValues2.put((Comparable)((Object)"Q1/13"), (Object)13.969);
        defaultKeyedValues2.put((Comparable)((Object)"Q2/13"), (Object)14.105);
        defaultKeyedValues2.put((Comparable)((Object)"Q3/13"), (Object)14.893);
        defaultKeyedValues2.put((Comparable)((Object)"Q4/13"), (Object)16.858);
        standardCategoryDataset3D.addSeriesAsRow((Comparable)((Object)"Google"), (KeyedValues)defaultKeyedValues2);
        DefaultKeyedValues defaultKeyedValues3 = new DefaultKeyedValues();
        defaultKeyedValues3.put((Comparable)((Object)"Q2/11"), (Object)17.37);
        defaultKeyedValues3.put((Comparable)((Object)"Q3/11"), (Object)17.37);
        defaultKeyedValues3.put((Comparable)((Object)"Q4/11"), (Object)20.89);
        defaultKeyedValues3.put((Comparable)((Object)"Q1/12"), (Object)17.41);
        defaultKeyedValues3.put((Comparable)((Object)"Q2/12"), (Object)18.06);
        defaultKeyedValues3.put((Comparable)((Object)"Q3/12"), (Object)16.008);
        defaultKeyedValues3.put((Comparable)((Object)"Q4/12"), (Object)21.456);
        defaultKeyedValues3.put((Comparable)((Object)"Q1/13"), (Object)20.489);
        defaultKeyedValues3.put((Comparable)((Object)"Q2/13"), (Object)19.896);
        defaultKeyedValues3.put((Comparable)((Object)"Q3/13"), (Object)18.529);
        defaultKeyedValues3.put((Comparable)((Object)"Q4/13"), (Object)24.519);
        standardCategoryDataset3D.addSeriesAsRow((Comparable)((Object)"Microsoft"), (KeyedValues)defaultKeyedValues3);
        DefaultKeyedValues defaultKeyedValues4 = new DefaultKeyedValues();
        defaultKeyedValues4.put((Comparable)((Object)"Q2/11"), (Object)28.57);
        defaultKeyedValues4.put((Comparable)((Object)"Q3/11"), (Object)28.27);
        defaultKeyedValues4.put((Comparable)((Object)"Q4/11"), (Object)46.33);
        defaultKeyedValues4.put((Comparable)((Object)"Q1/12"), (Object)39.2);
        defaultKeyedValues4.put((Comparable)((Object)"Q2/12"), (Object)35.0);
        defaultKeyedValues4.put((Comparable)((Object)"Q3/12"), (Object)36.0);
        defaultKeyedValues4.put((Comparable)((Object)"Q4/12"), (Object)54.5);
        defaultKeyedValues4.put((Comparable)((Object)"Q1/13"), (Object)43.6);
        defaultKeyedValues4.put((Comparable)((Object)"Q2/13"), (Object)35.323);
        defaultKeyedValues4.put((Comparable)((Object)"Q3/13"), (Object)37.5);
        defaultKeyedValues4.put((Comparable)((Object)"Q4/13"), (Object)57.594);
        standardCategoryDataset3D.addSeriesAsRow((Comparable)((Object)"Apple"), (KeyedValues)defaultKeyedValues4);
        return standardCategoryDataset3D;
    }
}

