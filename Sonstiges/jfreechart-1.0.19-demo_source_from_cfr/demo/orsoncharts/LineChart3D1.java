/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.Chart3D
 *  com.orsoncharts.Chart3DFactory
 *  com.orsoncharts.Colors
 *  com.orsoncharts.axis.CategoryAxis3D
 *  com.orsoncharts.axis.NumberAxis3D
 *  com.orsoncharts.axis.NumberTickSelector
 *  com.orsoncharts.axis.TickSelector
 *  com.orsoncharts.axis.ValueAxis3D
 *  com.orsoncharts.data.DefaultKeyedValues
 *  com.orsoncharts.data.KeyedValues
 *  com.orsoncharts.data.category.CategoryDataset3D
 *  com.orsoncharts.data.category.StandardCategoryDataset3D
 *  com.orsoncharts.graphics3d.Dimension3D
 *  com.orsoncharts.graphics3d.ViewPoint3D
 *  com.orsoncharts.plot.CategoryPlot3D
 *  com.orsoncharts.plot.Plot3D
 *  com.orsoncharts.renderer.category.CategoryRenderer3D
 */
package demo.orsoncharts;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Colors;
import com.orsoncharts.axis.CategoryAxis3D;
import com.orsoncharts.axis.NumberAxis3D;
import com.orsoncharts.axis.NumberTickSelector;
import com.orsoncharts.axis.TickSelector;
import com.orsoncharts.axis.ValueAxis3D;
import com.orsoncharts.data.DefaultKeyedValues;
import com.orsoncharts.data.KeyedValues;
import com.orsoncharts.data.category.CategoryDataset3D;
import com.orsoncharts.data.category.StandardCategoryDataset3D;
import com.orsoncharts.graphics3d.Dimension3D;
import com.orsoncharts.graphics3d.ViewPoint3D;
import com.orsoncharts.plot.CategoryPlot3D;
import com.orsoncharts.plot.Plot3D;
import com.orsoncharts.renderer.category.CategoryRenderer3D;
import java.awt.Color;

public class LineChart3D1 {
    public static Chart3D createChart(CategoryDataset3D categoryDataset3D) {
        Chart3D chart3D = Chart3DFactory.createLineChart((String)"Web Browser Market Share", (String)"Source: http://gs.statcounter.com", (CategoryDataset3D)categoryDataset3D, (String)null, (String)null, (String)"Market Share (%)");
        CategoryPlot3D categoryPlot3D = (CategoryPlot3D)chart3D.getPlot();
        categoryPlot3D.setDimensions(new Dimension3D(18.0, 8.0, 4.0));
        categoryPlot3D.getRowAxis().setVisible(false);
        NumberAxis3D numberAxis3D = (NumberAxis3D)categoryPlot3D.getValueAxis();
        numberAxis3D.setTickSelector((TickSelector)new NumberTickSelector(true));
        categoryPlot3D.getRenderer().setColors(Colors.createFancyDarkColors());
        chart3D.setViewPoint(ViewPoint3D.createAboveViewPoint((double)30.0));
        return chart3D;
    }

    public static CategoryDataset3D createDataset() {
        StandardCategoryDataset3D standardCategoryDataset3D = new StandardCategoryDataset3D();
        standardCategoryDataset3D.addSeriesAsRow((Comparable)((Object)"Safari"), LineChart3D1.createSafariData());
        standardCategoryDataset3D.addSeriesAsRow((Comparable)((Object)"Firefox"), LineChart3D1.createFirefoxData());
        standardCategoryDataset3D.addSeriesAsRow((Comparable)((Object)"Internet Explorer"), LineChart3D1.createInternetExplorerData());
        standardCategoryDataset3D.addSeriesAsRow((Comparable)((Object)"Chrome"), LineChart3D1.createChromeData());
        return standardCategoryDataset3D;
    }

    private static KeyedValues<Double> createChromeData() {
        DefaultKeyedValues defaultKeyedValues = new DefaultKeyedValues();
        defaultKeyedValues.put((Comparable)((Object)"Jan-12"), (Object)0.284);
        defaultKeyedValues.put((Comparable)((Object)"Feb-12"), (Object)0.2984);
        defaultKeyedValues.put((Comparable)((Object)"Mar-12"), (Object)0.3087);
        defaultKeyedValues.put((Comparable)((Object)"Apr-12"), (Object)0.3123);
        defaultKeyedValues.put((Comparable)((Object)"May-12"), (Object)0.3243);
        defaultKeyedValues.put((Comparable)((Object)"Jun-12"), (Object)0.3276);
        defaultKeyedValues.put((Comparable)((Object)"Jul-12"), (Object)0.3381);
        defaultKeyedValues.put((Comparable)((Object)"Aug-12"), (Object)0.3359);
        defaultKeyedValues.put((Comparable)((Object)"Sep-12"), (Object)0.3421);
        defaultKeyedValues.put((Comparable)((Object)"Oct-12"), (Object)0.3477);
        defaultKeyedValues.put((Comparable)((Object)"Nov-12"), (Object)0.3572);
        defaultKeyedValues.put((Comparable)((Object)"Dec-12"), (Object)0.3642);
        defaultKeyedValues.put((Comparable)((Object)"Jan-13"), (Object)0.3652);
        defaultKeyedValues.put((Comparable)((Object)"Feb-13"), (Object)0.3709);
        defaultKeyedValues.put((Comparable)((Object)"Mar-13"), (Object)0.3807);
        defaultKeyedValues.put((Comparable)((Object)"Apr-13"), (Object)0.3915);
        defaultKeyedValues.put((Comparable)((Object)"May-13"), (Object)0.4138);
        defaultKeyedValues.put((Comparable)((Object)"Jun-13"), (Object)0.4268);
        return defaultKeyedValues;
    }

    private static KeyedValues<Double> createFirefoxData() {
        DefaultKeyedValues defaultKeyedValues = new DefaultKeyedValues();
        defaultKeyedValues.put((Comparable)((Object)"Jan-12"), (Object)0.2478);
        defaultKeyedValues.put((Comparable)((Object)"Feb-12"), (Object)0.2488);
        defaultKeyedValues.put((Comparable)((Object)"Mar-12"), (Object)0.2498);
        defaultKeyedValues.put((Comparable)((Object)"Apr-12"), (Object)0.2487);
        defaultKeyedValues.put((Comparable)((Object)"May-12"), (Object)0.2555);
        defaultKeyedValues.put((Comparable)((Object)"Jun-12"), (Object)0.2456);
        defaultKeyedValues.put((Comparable)((Object)"Jul-12"), (Object)0.2373);
        defaultKeyedValues.put((Comparable)((Object)"Aug-12"), (Object)0.2285);
        defaultKeyedValues.put((Comparable)((Object)"Sep-12"), (Object)0.224);
        defaultKeyedValues.put((Comparable)((Object)"Oct-12"), (Object)0.2232);
        defaultKeyedValues.put((Comparable)((Object)"Nov-12"), (Object)0.2237);
        defaultKeyedValues.put((Comparable)((Object)"Dec-12"), (Object)0.2189);
        defaultKeyedValues.put((Comparable)((Object)"Jan-13"), (Object)0.2142);
        defaultKeyedValues.put((Comparable)((Object)"Feb-13"), (Object)0.2134);
        defaultKeyedValues.put((Comparable)((Object)"Mar-13"), (Object)0.2087);
        defaultKeyedValues.put((Comparable)((Object)"Apr-13"), (Object)0.2006);
        defaultKeyedValues.put((Comparable)((Object)"May-13"), (Object)0.1976);
        defaultKeyedValues.put((Comparable)((Object)"Jun-13"), (Object)0.2001);
        return defaultKeyedValues;
    }

    private static KeyedValues<Double> createInternetExplorerData() {
        DefaultKeyedValues defaultKeyedValues = new DefaultKeyedValues();
        defaultKeyedValues.put((Comparable)((Object)"Jan-12"), (Object)0.3745);
        defaultKeyedValues.put((Comparable)((Object)"Feb-12"), (Object)0.3575);
        defaultKeyedValues.put((Comparable)((Object)"Mar-12"), (Object)0.3481);
        defaultKeyedValues.put((Comparable)((Object)"Apr-12"), (Object)0.3407);
        defaultKeyedValues.put((Comparable)((Object)"May-12"), (Object)0.3212);
        defaultKeyedValues.put((Comparable)((Object)"Jun-12"), (Object)0.3231);
        defaultKeyedValues.put((Comparable)((Object)"Jul-12"), (Object)0.3204);
        defaultKeyedValues.put((Comparable)((Object)"Aug-12"), (Object)0.3285);
        defaultKeyedValues.put((Comparable)((Object)"Sep-12"), (Object)0.327);
        defaultKeyedValues.put((Comparable)((Object)"Oct-12"), (Object)0.3208);
        defaultKeyedValues.put((Comparable)((Object)"Nov-12"), (Object)0.3123);
        defaultKeyedValues.put((Comparable)((Object)"Dec-12"), (Object)0.3078);
        defaultKeyedValues.put((Comparable)((Object)"Jan-13"), (Object)0.3069);
        defaultKeyedValues.put((Comparable)((Object)"Feb-13"), (Object)0.2982);
        defaultKeyedValues.put((Comparable)((Object)"Mar-13"), (Object)0.293);
        defaultKeyedValues.put((Comparable)((Object)"Jun-13"), (Object)0.2544);
        defaultKeyedValues.put((Comparable)((Object)"May-13"), (Object)0.2772);
        defaultKeyedValues.put((Comparable)((Object)"Apr-13"), (Object)0.2971);
        return defaultKeyedValues;
    }

    private static KeyedValues<Double> createSafariData() {
        DefaultKeyedValues defaultKeyedValues = new DefaultKeyedValues();
        defaultKeyedValues.put((Comparable)((Object)"Jan-12"), (Object)0.0662);
        defaultKeyedValues.put((Comparable)((Object)"Feb-12"), (Object)0.0677);
        defaultKeyedValues.put((Comparable)((Object)"Mar-12"), (Object)0.0672);
        defaultKeyedValues.put((Comparable)((Object)"Apr-12"), (Object)0.0713);
        defaultKeyedValues.put((Comparable)((Object)"May-12"), (Object)0.0709);
        defaultKeyedValues.put((Comparable)((Object)"Jun-12"), (Object)0.07);
        defaultKeyedValues.put((Comparable)((Object)"Jul-12"), (Object)0.0712);
        defaultKeyedValues.put((Comparable)((Object)"Aug-12"), (Object)0.0739);
        defaultKeyedValues.put((Comparable)((Object)"Sep-12"), (Object)0.077);
        defaultKeyedValues.put((Comparable)((Object)"Oct-12"), (Object)0.0781);
        defaultKeyedValues.put((Comparable)((Object)"Nov-12"), (Object)0.0783);
        defaultKeyedValues.put((Comparable)((Object)"Dec-12"), (Object)0.0792);
        defaultKeyedValues.put((Comparable)((Object)"Jan-13"), (Object)0.083);
        defaultKeyedValues.put((Comparable)((Object)"Feb-13"), (Object)0.086);
        defaultKeyedValues.put((Comparable)((Object)"Mar-13"), (Object)0.085);
        defaultKeyedValues.put((Comparable)((Object)"Apr-13"), (Object)0.08);
        defaultKeyedValues.put((Comparable)((Object)"May-13"), (Object)0.0796);
        defaultKeyedValues.put((Comparable)((Object)"Jun-13"), (Object)0.0839);
        return defaultKeyedValues;
    }
}

