/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.Chart3D
 *  com.orsoncharts.Chart3DFactory
 *  com.orsoncharts.Colors
 *  com.orsoncharts.TitleAnchor
 *  com.orsoncharts.data.PieDataset3D
 *  com.orsoncharts.data.StandardPieDataset3D
 *  com.orsoncharts.label.PieLabelGenerator
 *  com.orsoncharts.label.StandardPieLabelGenerator
 *  com.orsoncharts.plot.PiePlot3D
 *  com.orsoncharts.plot.Plot3D
 *  com.orsoncharts.util.Anchor2D
 */
package demo.orsoncharts;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Colors;
import com.orsoncharts.TitleAnchor;
import com.orsoncharts.data.PieDataset3D;
import com.orsoncharts.data.StandardPieDataset3D;
import com.orsoncharts.label.PieLabelGenerator;
import com.orsoncharts.label.StandardPieLabelGenerator;
import com.orsoncharts.plot.PiePlot3D;
import com.orsoncharts.plot.Plot3D;
import com.orsoncharts.util.Anchor2D;
import java.awt.Color;

public class PieChart3D2 {
    public static PieDataset3D createDataset() {
        StandardPieDataset3D standardPieDataset3D = new StandardPieDataset3D();
        standardPieDataset3D.add((Comparable)((Object)"United States"), Math.random() * 30.0);
        standardPieDataset3D.add((Comparable)((Object)"France"), Math.random() * 20.0);
        standardPieDataset3D.add((Comparable)((Object)"New Zealand"), Math.random() * 12.0);
        standardPieDataset3D.add((Comparable)((Object)"United Kingdom"), Math.random() * 43.0);
        standardPieDataset3D.add((Comparable)((Object)"Australia"), Math.random() * 43.0);
        standardPieDataset3D.add((Comparable)((Object)"Canada"), Math.random() * 43.0);
        return standardPieDataset3D;
    }

    public static Chart3D createChart(PieDataset3D pieDataset3D) {
        Chart3D chart3D = Chart3DFactory.createPieChart((String)"Orson Charts 3D", (String)"For more info see: http://www.object-refinery.com/orsoncharts/", (PieDataset3D)PieChart3D2.createDataset());
        chart3D.setTitleAnchor(TitleAnchor.TOP_LEFT);
        PiePlot3D piePlot3D = (PiePlot3D)chart3D.getPlot();
        piePlot3D.setLegendLabelGenerator((PieLabelGenerator)new StandardPieLabelGenerator("%s (%3$,.0f%%)"));
        piePlot3D.setSectionLabelGenerator((PieLabelGenerator)new StandardPieLabelGenerator("%s (%3$,.0f%%)"));
        piePlot3D.setSectionColors(Colors.createFancyLightColors());
        return chart3D;
    }
}

