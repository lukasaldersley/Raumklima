/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.Chart3D
 *  com.orsoncharts.Chart3DFactory
 *  com.orsoncharts.TitleAnchor
 *  com.orsoncharts.data.PieDataset3D
 *  com.orsoncharts.data.StandardPieDataset3D
 *  com.orsoncharts.legend.LegendAnchor
 *  com.orsoncharts.util.Anchor2D
 *  com.orsoncharts.util.Orientation
 */
package demo.orsoncharts;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.TitleAnchor;
import com.orsoncharts.data.PieDataset3D;
import com.orsoncharts.data.StandardPieDataset3D;
import com.orsoncharts.legend.LegendAnchor;
import com.orsoncharts.util.Anchor2D;
import com.orsoncharts.util.Orientation;

public class PieChart3D1 {
    public static Chart3D createChart(PieDataset3D pieDataset3D) {
        Chart3D chart3D = Chart3DFactory.createPieChart((String)"New Zealand Exports 2012", (String)"http://www.stats.govt.nz/browse_for_stats/snapshots-of-nz/nz-in-profile-2013.aspx", (PieDataset3D)PieChart3D1.createDataset());
        chart3D.setTitleAnchor(TitleAnchor.TOP_LEFT);
        chart3D.setLegendPosition(LegendAnchor.BOTTOM_CENTER, Orientation.HORIZONTAL);
        return chart3D;
    }

    public static PieDataset3D createDataset() {
        StandardPieDataset3D standardPieDataset3D = new StandardPieDataset3D();
        standardPieDataset3D.add((Comparable)((Object)"Milk Products"), 11625.0);
        standardPieDataset3D.add((Comparable)((Object)"Meat"), 5114.0);
        standardPieDataset3D.add((Comparable)((Object)"Wood/Logs"), 3060.0);
        standardPieDataset3D.add((Comparable)((Object)"Crude Oil"), 2023.0);
        standardPieDataset3D.add((Comparable)((Object)"Machinery"), 1865.0);
        standardPieDataset3D.add((Comparable)((Object)"Fruit"), 1587.0);
        standardPieDataset3D.add((Comparable)((Object)"Fish"), 1367.0);
        standardPieDataset3D.add((Comparable)((Object)"Wine"), 1177.0);
        standardPieDataset3D.add((Comparable)((Object)"Other"), 18870.0);
        return standardPieDataset3D;
    }
}

