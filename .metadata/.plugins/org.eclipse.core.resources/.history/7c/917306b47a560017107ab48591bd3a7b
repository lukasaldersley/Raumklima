/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.Chart3D
 *  com.orsoncharts.Chart3DFactory
 *  com.orsoncharts.Chart3DPanel
 *  com.orsoncharts.axis.CategoryAxis3D
 *  com.orsoncharts.axis.ValueAxis3D
 *  com.orsoncharts.data.DefaultKeyedValues
 *  com.orsoncharts.data.KeyedValues
 *  com.orsoncharts.data.category.CategoryDataset3D
 *  com.orsoncharts.data.category.StandardCategoryDataset3D
 *  com.orsoncharts.graphics3d.Drawable3D
 *  com.orsoncharts.graphics3d.ViewPoint3D
 *  com.orsoncharts.graphics3d.swing.DisplayPanel3D
 *  com.orsoncharts.graphics3d.swing.Panel3D
 *  com.orsoncharts.label.CategoryItemLabelGenerator
 *  com.orsoncharts.label.StandardCategoryItemLabelGenerator
 *  com.orsoncharts.plot.CategoryPlot3D
 *  com.orsoncharts.plot.Plot3D
 *  com.orsoncharts.renderer.category.CategoryRenderer3D
 *  com.orsoncharts.renderer.category.StackedBarRenderer3D
 */
package demo.orsoncharts.swing;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.axis.CategoryAxis3D;
import com.orsoncharts.axis.ValueAxis3D;
import com.orsoncharts.data.DefaultKeyedValues;
import com.orsoncharts.data.KeyedValues;
import com.orsoncharts.data.category.CategoryDataset3D;
import com.orsoncharts.data.category.StandardCategoryDataset3D;
import com.orsoncharts.graphics3d.Drawable3D;
import com.orsoncharts.graphics3d.ViewPoint3D;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;
import com.orsoncharts.graphics3d.swing.Panel3D;
import com.orsoncharts.label.CategoryItemLabelGenerator;
import com.orsoncharts.label.StandardCategoryItemLabelGenerator;
import com.orsoncharts.plot.CategoryPlot3D;
import com.orsoncharts.plot.Plot3D;
import com.orsoncharts.renderer.category.CategoryRenderer3D;
import com.orsoncharts.renderer.category.StackedBarRenderer3D;
import demo.orsoncharts.swing.DemoPanel;
import demo.orsoncharts.swing.ExitOnClose;
import demo.orsoncharts.swing.OrsonChartsDemo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.WindowListener;
import java.awt.geom.Dimension2D;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AxisRangeDemo4
extends JFrame {
    public AxisRangeDemo4(String string) {
        super(string);
        this.addWindowListener(new ExitOnClose());
        this.getContentPane().add(AxisRangeDemo4.createDemoPanel());
    }

    public static JPanel createDemoPanel() {
        CustomDemoPanel customDemoPanel = new CustomDemoPanel(new BorderLayout());
        customDemoPanel.setPreferredSize(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        CategoryDataset3D categoryDataset3D = AxisRangeDemo4.createDataset();
        Chart3D chart3D = Chart3DFactory.createStackedBarChart((String)"AxisRangeDemo4", (String)"A test for axis range changes on a stacked bar chart", (CategoryDataset3D)categoryDataset3D, (String)"Row", (String)"Category", (String)"Value");
        chart3D.setChartBoxColor(new Color(255, 255, 255, 128));
        chart3D.setViewPoint(ViewPoint3D.createAboveLeftViewPoint((double)40.0));
        CategoryPlot3D categoryPlot3D = (CategoryPlot3D)chart3D.getPlot();
        categoryPlot3D.getValueAxis().setRange(-500.0, 500.0);
        categoryPlot3D.getRowAxis().setVisible(false);
        StackedBarRenderer3D stackedBarRenderer3D = (StackedBarRenderer3D)categoryPlot3D.getRenderer();
        stackedBarRenderer3D.setItemLabelGenerator((CategoryItemLabelGenerator)new StandardCategoryItemLabelGenerator("%4$.2f"));
        Chart3DPanel chart3DPanel = new Chart3DPanel(chart3D);
        customDemoPanel.setChartPanel(chart3DPanel);
        customDemoPanel.add((Component)new DisplayPanel3D((Panel3D)chart3DPanel));
        chart3DPanel.zoomToFit((Dimension2D)OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        return customDemoPanel;
    }

    private static CategoryDataset3D createDataset() {
        StandardCategoryDataset3D standardCategoryDataset3D = new StandardCategoryDataset3D();
        DefaultKeyedValues defaultKeyedValues = new DefaultKeyedValues();
        defaultKeyedValues.put((Comparable)((Object)"A"), (Object)-500);
        defaultKeyedValues.put((Comparable)((Object)"B"), (Object)-200);
        defaultKeyedValues.put((Comparable)((Object)"C"), (Object)-400);
        defaultKeyedValues.put((Comparable)((Object)"D"), (Object)-150);
        standardCategoryDataset3D.addSeriesAsRow((Comparable)((Object)"S1"), (Comparable)((Object)"A"), (KeyedValues)defaultKeyedValues);
        DefaultKeyedValues defaultKeyedValues2 = new DefaultKeyedValues();
        defaultKeyedValues2.put((Comparable)((Object)"A"), (Object)-500);
        defaultKeyedValues2.put((Comparable)((Object)"B"), (Object)500);
        defaultKeyedValues2.put((Comparable)((Object)"C"), (Object)0);
        defaultKeyedValues2.put((Comparable)((Object)"D"), (Object)-150);
        standardCategoryDataset3D.addSeriesAsRow((Comparable)((Object)"S2"), (Comparable)((Object)"A"), (KeyedValues)defaultKeyedValues2);
        DefaultKeyedValues defaultKeyedValues3 = new DefaultKeyedValues();
        defaultKeyedValues3.put((Comparable)((Object)"A"), (Object)500);
        defaultKeyedValues3.put((Comparable)((Object)"B"), (Object)-500);
        defaultKeyedValues3.put((Comparable)((Object)"C"), (Object)0);
        defaultKeyedValues3.put((Comparable)((Object)"D"), (Object)150);
        standardCategoryDataset3D.addSeriesAsRow((Comparable)((Object)"S3"), (Comparable)((Object)"B"), (KeyedValues)defaultKeyedValues3);
        DefaultKeyedValues defaultKeyedValues4 = new DefaultKeyedValues();
        defaultKeyedValues4.put((Comparable)((Object)"A"), (Object)500);
        defaultKeyedValues4.put((Comparable)((Object)"B"), (Object)200);
        defaultKeyedValues4.put((Comparable)((Object)"C"), (Object)400);
        defaultKeyedValues4.put((Comparable)((Object)"D"), (Object)150);
        standardCategoryDataset3D.addSeriesAsRow((Comparable)((Object)"S4"), (Comparable)((Object)"B"), (KeyedValues)defaultKeyedValues4);
        return standardCategoryDataset3D;
    }

    public static void main(String[] arrstring) {
        AxisRangeDemo4 axisRangeDemo4 = new AxisRangeDemo4("OrsonCharts: AxisRangeDemo4.java");
        axisRangeDemo4.pack();
        axisRangeDemo4.setVisible(true);
    }

    static class CustomDemoPanel
    extends DemoPanel
    implements ChangeListener {
        private JSlider slider1 = new JSlider(-1000, 0);
        private JSlider slider2;

        public CustomDemoPanel(LayoutManager layoutManager) {
            super(layoutManager);
            this.slider1.setValue(-500);
            this.slider2 = new JSlider(0, 1000);
            this.slider2.setValue(500);
            this.slider1.addChangeListener(this);
            this.slider2.addChangeListener(this);
            JPanel jPanel = new JPanel(new FlowLayout());
            jPanel.add(new JLabel("Lower bound: "));
            jPanel.add(this.slider1);
            jPanel.add(new JLabel("Upper bound: "));
            jPanel.add(this.slider2);
            this.add((Component)jPanel, "South");
        }

        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            int n;
            Chart3D chart3D = (Chart3D)this.getChartPanel().getDrawable();
            CategoryPlot3D categoryPlot3D = (CategoryPlot3D)chart3D.getPlot();
            ValueAxis3D valueAxis3D = categoryPlot3D.getValueAxis();
            int n2 = this.slider1.getValue();
            if (n2 != (n = this.slider2.getValue())) {
                valueAxis3D.setRange((double)n2, (double)n);
            }
        }
    }

}

