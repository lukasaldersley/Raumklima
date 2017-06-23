/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.Chart3D
 *  com.orsoncharts.Chart3DFactory
 *  com.orsoncharts.Colors
 *  com.orsoncharts.axis.CategoryAxis3D
 *  com.orsoncharts.axis.LabelOrientation
 *  com.orsoncharts.axis.StandardCategoryAxis3D
 *  com.orsoncharts.data.category.CategoryDataset3D
 *  com.orsoncharts.data.category.StandardCategoryDataset3D
 *  com.orsoncharts.label.CategoryItemLabelGenerator
 *  com.orsoncharts.label.CategoryLabelGenerator
 *  com.orsoncharts.label.StandardCategoryItemLabelGenerator
 *  com.orsoncharts.label.StandardCategoryLabelGenerator
 *  com.orsoncharts.plot.CategoryPlot3D
 *  com.orsoncharts.plot.Plot3D
 *  com.orsoncharts.renderer.category.CategoryRenderer3D
 *  com.orsoncharts.renderer.category.StackedBarRenderer3D
 *  com.orsoncharts.table.RectanglePainter
 *  com.orsoncharts.table.StandardRectanglePainter
 *  com.orsoncharts.util.Fit2D
 */
package demo.orsoncharts;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Colors;
import com.orsoncharts.axis.CategoryAxis3D;
import com.orsoncharts.axis.LabelOrientation;
import com.orsoncharts.axis.StandardCategoryAxis3D;
import com.orsoncharts.data.category.CategoryDataset3D;
import com.orsoncharts.data.category.StandardCategoryDataset3D;
import com.orsoncharts.label.CategoryItemLabelGenerator;
import com.orsoncharts.label.CategoryLabelGenerator;
import com.orsoncharts.label.StandardCategoryItemLabelGenerator;
import com.orsoncharts.label.StandardCategoryLabelGenerator;
import com.orsoncharts.plot.CategoryPlot3D;
import com.orsoncharts.plot.Plot3D;
import com.orsoncharts.renderer.category.CategoryRenderer3D;
import com.orsoncharts.renderer.category.StackedBarRenderer3D;
import com.orsoncharts.table.RectanglePainter;
import com.orsoncharts.table.StandardRectanglePainter;
import com.orsoncharts.util.Fit2D;
import java.awt.Color;
import java.awt.Image;
import java.awt.Paint;
import java.net.URL;
import javax.swing.ImageIcon;

public class StackedBarChart3D3 {
    public static Chart3D createChart(CategoryDataset3D categoryDataset3D) {
        Chart3D chart3D = Chart3DFactory.createStackedBarChart((String)"The Sinking of the Titanic", (String)"Survival data for 2,201 passengers", (CategoryDataset3D)categoryDataset3D, (String)null, (String)"Class", (String)"Passengers");
        URL uRL = StackedBarChart3D3.class.getResource("iStock_000003105870Small.jpg");
        ImageIcon imageIcon = new ImageIcon(uRL);
        StandardRectanglePainter standardRectanglePainter = new StandardRectanglePainter((Paint)Color.WHITE, imageIcon.getImage(), Fit2D.SCALE_TO_FIT_TARGET);
        chart3D.setBackground((RectanglePainter)standardRectanglePainter);
        chart3D.setChartBoxColor(new Color(255, 255, 255, 155));
        CategoryPlot3D categoryPlot3D = (CategoryPlot3D)chart3D.getPlot();
        categoryPlot3D.setLegendLabelGenerator((CategoryLabelGenerator)new StandardCategoryLabelGenerator("%s (%3$,.0f)"));
        categoryPlot3D.setToolTipGenerator((CategoryItemLabelGenerator)new StandardCategoryItemLabelGenerator("%s, %s, %s = %4$.0f"));
        StandardCategoryAxis3D standardCategoryAxis3D = (StandardCategoryAxis3D)categoryPlot3D.getRowAxis();
        standardCategoryAxis3D.setTickLabelGenerator((CategoryLabelGenerator)new StandardCategoryLabelGenerator("%s (%3$,.0f)"));
        StandardCategoryAxis3D standardCategoryAxis3D2 = (StandardCategoryAxis3D)categoryPlot3D.getColumnAxis();
        standardCategoryAxis3D2.setTickLabelGenerator((CategoryLabelGenerator)new StandardCategoryLabelGenerator("%s (%3$,.0f)"));
        standardCategoryAxis3D2.setTickLabelOrientation(LabelOrientation.PARALLEL);
        standardCategoryAxis3D2.setMaxTickLabelLevels(2);
        StackedBarRenderer3D stackedBarRenderer3D = (StackedBarRenderer3D)categoryPlot3D.getRenderer();
        stackedBarRenderer3D.setColors(Colors.createIceCubeColors());
        return chart3D;
    }

    public static CategoryDataset3D createDataset() {
        StandardCategoryDataset3D standardCategoryDataset3D = new StandardCategoryDataset3D();
        standardCategoryDataset3D.addValue((Number)146, (Comparable)((Object)"Survivors"), (Comparable)((Object)"Women/Children"), (Comparable)((Object)"1st"));
        standardCategoryDataset3D.addValue((Number)104, (Comparable)((Object)"Survivors"), (Comparable)((Object)"Women/Children"), (Comparable)((Object)"2nd"));
        standardCategoryDataset3D.addValue((Number)103, (Comparable)((Object)"Survivors"), (Comparable)((Object)"Women/Children"), (Comparable)((Object)"3rd"));
        standardCategoryDataset3D.addValue((Number)20, (Comparable)((Object)"Survivors"), (Comparable)((Object)"Women/Children"), (Comparable)((Object)"Crew"));
        standardCategoryDataset3D.addValue((Number)57, (Comparable)((Object)"Survivors"), (Comparable)((Object)"Men"), (Comparable)((Object)"1st"));
        standardCategoryDataset3D.addValue((Number)14, (Comparable)((Object)"Survivors"), (Comparable)((Object)"Men"), (Comparable)((Object)"2nd"));
        standardCategoryDataset3D.addValue((Number)75, (Comparable)((Object)"Survivors"), (Comparable)((Object)"Men"), (Comparable)((Object)"3rd"));
        standardCategoryDataset3D.addValue((Number)192, (Comparable)((Object)"Survivors"), (Comparable)((Object)"Men"), (Comparable)((Object)"Crew"));
        standardCategoryDataset3D.addValue((Number)4, (Comparable)((Object)"Victims"), (Comparable)((Object)"Women/Children"), (Comparable)((Object)"1st"));
        standardCategoryDataset3D.addValue((Number)13, (Comparable)((Object)"Victims"), (Comparable)((Object)"Women/Children"), (Comparable)((Object)"2nd"));
        standardCategoryDataset3D.addValue((Number)141, (Comparable)((Object)"Victims"), (Comparable)((Object)"Women/Children"), (Comparable)((Object)"3rd"));
        standardCategoryDataset3D.addValue((Number)3, (Comparable)((Object)"Victims"), (Comparable)((Object)"Women/Children"), (Comparable)((Object)"Crew"));
        standardCategoryDataset3D.addValue((Number)118, (Comparable)((Object)"Victims"), (Comparable)((Object)"Men"), (Comparable)((Object)"1st"));
        standardCategoryDataset3D.addValue((Number)154, (Comparable)((Object)"Victims"), (Comparable)((Object)"Men"), (Comparable)((Object)"2nd"));
        standardCategoryDataset3D.addValue((Number)387, (Comparable)((Object)"Victims"), (Comparable)((Object)"Men"), (Comparable)((Object)"3rd"));
        standardCategoryDataset3D.addValue((Number)670, (Comparable)((Object)"Victims"), (Comparable)((Object)"Men"), (Comparable)((Object)"Crew"));
        return standardCategoryDataset3D;
    }
}

