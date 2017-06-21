/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.Chart3D
 *  com.orsoncharts.Chart3DFactory
 *  com.orsoncharts.data.DefaultKeyedValues
 *  com.orsoncharts.data.KeyedValues
 *  com.orsoncharts.data.category.CategoryDataset3D
 *  com.orsoncharts.data.category.StandardCategoryDataset3D
 *  com.orsoncharts.legend.LegendAnchor
 *  com.orsoncharts.util.Anchor2D
 */
package demo.orsoncharts;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.data.DefaultKeyedValues;
import com.orsoncharts.data.KeyedValues;
import com.orsoncharts.data.category.CategoryDataset3D;
import com.orsoncharts.data.category.StandardCategoryDataset3D;
import com.orsoncharts.legend.LegendAnchor;
import com.orsoncharts.util.Anchor2D;
import java.awt.Color;

public class LineChart3D2 {
    public static Chart3D createChart(CategoryDataset3D categoryDataset3D) {
        Chart3D chart3D = Chart3DFactory.createLineChart((String)"Quarterly Profits", (String)"Large Banks in USA", (CategoryDataset3D)categoryDataset3D, (String)null, (String)"Quarter", (String)"$ millions");
        chart3D.setChartBoxColor(new Color(255, 255, 255, 128));
        chart3D.setLegendAnchor(LegendAnchor.TOP_RIGHT);
        return chart3D;
    }

    public static CategoryDataset3D createDataset() {
        StandardCategoryDataset3D standardCategoryDataset3D = new StandardCategoryDataset3D();
        DefaultKeyedValues defaultKeyedValues = new DefaultKeyedValues();
        defaultKeyedValues.put((Comparable)((Object)"Q3/11"), (Object)5889);
        defaultKeyedValues.put((Comparable)((Object)"Q4/11"), (Object)1584);
        defaultKeyedValues.put((Comparable)((Object)"Q1/12"), (Object)328);
        defaultKeyedValues.put((Comparable)((Object)"Q2/12"), (Object)2098);
        defaultKeyedValues.put((Comparable)((Object)"Q3/12"), (Object)-33);
        defaultKeyedValues.put((Comparable)((Object)"Q4/12"), (Object)367);
        defaultKeyedValues.put((Comparable)((Object)"Q1/13"), (Object)1110);
        defaultKeyedValues.put((Comparable)((Object)"Q2/13"), (Object)3571);
        defaultKeyedValues.put((Comparable)((Object)"Q3/13"), (Object)2218);
        standardCategoryDataset3D.addSeriesAsRow((Comparable)((Object)"Bank of America"), (KeyedValues)defaultKeyedValues);
        DefaultKeyedValues defaultKeyedValues2 = new DefaultKeyedValues();
        defaultKeyedValues2.put((Comparable)((Object)"Q3/11"), (Object)3771);
        defaultKeyedValues2.put((Comparable)((Object)"Q4/11"), (Object)956);
        defaultKeyedValues2.put((Comparable)((Object)"Q1/12"), (Object)2931);
        defaultKeyedValues2.put((Comparable)((Object)"Q2/12"), (Object)2946);
        defaultKeyedValues2.put((Comparable)((Object)"Q3/12"), (Object)468);
        defaultKeyedValues2.put((Comparable)((Object)"Q4/12"), (Object)1196);
        defaultKeyedValues2.put((Comparable)((Object)"Q1/13"), (Object)3808);
        defaultKeyedValues2.put((Comparable)((Object)"Q2/13"), (Object)4182);
        defaultKeyedValues2.put((Comparable)((Object)"Q3/13"), (Object)3227);
        standardCategoryDataset3D.addSeriesAsRow((Comparable)((Object)"Citigroup"), (KeyedValues)defaultKeyedValues2);
        DefaultKeyedValues defaultKeyedValues3 = new DefaultKeyedValues();
        defaultKeyedValues3.put((Comparable)((Object)"Q3/11"), (Object)4055);
        defaultKeyedValues3.put((Comparable)((Object)"Q4/11"), (Object)4107);
        defaultKeyedValues3.put((Comparable)((Object)"Q1/12"), (Object)4248);
        defaultKeyedValues3.put((Comparable)((Object)"Q2/12"), (Object)4622);
        defaultKeyedValues3.put((Comparable)((Object)"Q3/12"), (Object)4937);
        defaultKeyedValues3.put((Comparable)((Object)"Q4/12"), (Object)4857);
        defaultKeyedValues3.put((Comparable)((Object)"Q1/13"), (Object)4931);
        defaultKeyedValues3.put((Comparable)((Object)"Q2/13"), (Object)5272);
        defaultKeyedValues3.put((Comparable)((Object)"Q3/13"), (Object)5317);
        standardCategoryDataset3D.addSeriesAsRow((Comparable)((Object)"Wells Fargo"), (KeyedValues)defaultKeyedValues3);
        DefaultKeyedValues defaultKeyedValues4 = new DefaultKeyedValues();
        defaultKeyedValues4.put((Comparable)((Object)"Q3/11"), (Object)4262);
        defaultKeyedValues4.put((Comparable)((Object)"Q4/11"), (Object)3728);
        defaultKeyedValues4.put((Comparable)((Object)"Q1/12"), (Object)4924);
        defaultKeyedValues4.put((Comparable)((Object)"Q2/12"), (Object)4960);
        defaultKeyedValues4.put((Comparable)((Object)"Q3/12"), (Object)5708);
        defaultKeyedValues4.put((Comparable)((Object)"Q4/12"), (Object)5692);
        defaultKeyedValues4.put((Comparable)((Object)"Q1/13"), (Object)6529);
        defaultKeyedValues4.put((Comparable)((Object)"Q2/13"), (Object)6496);
        defaultKeyedValues4.put((Comparable)((Object)"Q3/13"), (Object)-380);
        standardCategoryDataset3D.addSeriesAsRow((Comparable)((Object)"J.P.Morgan"), (KeyedValues)defaultKeyedValues4);
        return standardCategoryDataset3D;
    }
}

