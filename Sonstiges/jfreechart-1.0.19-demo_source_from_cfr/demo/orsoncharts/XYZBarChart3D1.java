/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.Chart3D
 *  com.orsoncharts.Chart3DFactory
 *  com.orsoncharts.data.xyz.XYZDataset
 *  com.orsoncharts.data.xyz.XYZSeries
 *  com.orsoncharts.data.xyz.XYZSeriesCollection
 *  com.orsoncharts.graphics3d.ViewPoint3D
 */
package demo.orsoncharts;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.data.xyz.XYZDataset;
import com.orsoncharts.data.xyz.XYZSeries;
import com.orsoncharts.data.xyz.XYZSeriesCollection;
import com.orsoncharts.graphics3d.ViewPoint3D;

public class XYZBarChart3D1 {
    public static Chart3D createChart(XYZDataset xYZDataset) {
        Chart3D chart3D = Chart3DFactory.createXYZBarChart((String)"XYZBarChart3DDemo1", (String)"Chart created with Orson Charts", (XYZDataset)xYZDataset, (String)"X", (String)"Value", (String)"Z");
        chart3D.setViewPoint(ViewPoint3D.createAboveRightViewPoint((double)40.0));
        return chart3D;
    }

    public static XYZDataset createDataset() {
        XYZSeries xYZSeries = new XYZSeries((Comparable)((Object)"Series 1"));
        xYZSeries.add(1.0, 5.0, 1.0);
        XYZSeries xYZSeries2 = new XYZSeries((Comparable)((Object)"Series 2"));
        xYZSeries2.add(2.0, 8.0, 2.0);
        XYZSeries xYZSeries3 = new XYZSeries((Comparable)((Object)"Series 3"));
        xYZSeries3.add(1.0, 10.0, 2.0);
        XYZSeriesCollection xYZSeriesCollection = new XYZSeriesCollection();
        xYZSeriesCollection.add(xYZSeries);
        xYZSeriesCollection.add(xYZSeries2);
        xYZSeriesCollection.add(xYZSeries3);
        return xYZSeriesCollection;
    }
}

