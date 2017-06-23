/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.Chart3D
 *  com.orsoncharts.Chart3DFactory
 *  com.orsoncharts.Chart3DPanel
 *  com.orsoncharts.axis.ValueAxis3D
 *  com.orsoncharts.data.xyz.XYZDataset
 *  com.orsoncharts.data.xyz.XYZItemKeys
 *  com.orsoncharts.data.xyz.XYZSeries
 *  com.orsoncharts.data.xyz.XYZSeriesCollection
 *  com.orsoncharts.graphics3d.Dimension3D
 *  com.orsoncharts.graphics3d.Drawable3D
 *  com.orsoncharts.graphics3d.ViewPoint3D
 *  com.orsoncharts.graphics3d.swing.DisplayPanel3D
 *  com.orsoncharts.graphics3d.swing.Panel3D
 *  com.orsoncharts.interaction.StandardXYZDataItemSelection
 *  com.orsoncharts.interaction.XYZDataItemSelection
 *  com.orsoncharts.label.StandardXYZItemLabelGenerator
 *  com.orsoncharts.label.XYZItemLabelGenerator
 *  com.orsoncharts.plot.Plot3D
 *  com.orsoncharts.plot.XYZPlot
 *  com.orsoncharts.renderer.xyz.ScatterXYZRenderer
 *  com.orsoncharts.renderer.xyz.XYZRenderer
 */
package demo.orsoncharts.swing;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.axis.ValueAxis3D;
import com.orsoncharts.data.xyz.XYZDataset;
import com.orsoncharts.data.xyz.XYZItemKeys;
import com.orsoncharts.data.xyz.XYZSeries;
import com.orsoncharts.data.xyz.XYZSeriesCollection;
import com.orsoncharts.graphics3d.Dimension3D;
import com.orsoncharts.graphics3d.Drawable3D;
import com.orsoncharts.graphics3d.ViewPoint3D;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;
import com.orsoncharts.graphics3d.swing.Panel3D;
import com.orsoncharts.interaction.StandardXYZDataItemSelection;
import com.orsoncharts.interaction.XYZDataItemSelection;
import com.orsoncharts.label.StandardXYZItemLabelGenerator;
import com.orsoncharts.label.XYZItemLabelGenerator;
import com.orsoncharts.plot.Plot3D;
import com.orsoncharts.plot.XYZPlot;
import com.orsoncharts.renderer.xyz.ScatterXYZRenderer;
import com.orsoncharts.renderer.xyz.XYZRenderer;
import demo.orsoncharts.swing.DemoPanel;
import demo.orsoncharts.swing.ExitOnClose;
import demo.orsoncharts.swing.OrsonChartsDemo;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.WindowListener;
import java.awt.geom.Dimension2D;
import java.util.Collection;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AxisRangeDemo5
extends JFrame {
    public AxisRangeDemo5(String string) {
        super(string);
        this.addWindowListener(new ExitOnClose());
        this.getContentPane().add(AxisRangeDemo5.createDemoPanel());
    }

    public static JPanel createDemoPanel() {
        CustomDemoPanel customDemoPanel = new CustomDemoPanel(new BorderLayout());
        customDemoPanel.setPreferredSize(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        XYZDataset xYZDataset = AxisRangeDemo5.createDataset();
        Chart3D chart3D = Chart3DFactory.createScatterChart((String)"AxisRangeDemo5", (String)"Chart created with Orson Charts", (XYZDataset)xYZDataset, (String)"X", (String)"Y", (String)"Z");
        XYZPlot xYZPlot = (XYZPlot)chart3D.getPlot();
        xYZPlot.setDimensions(new Dimension3D(10.0, 4.0, 10.0));
        ScatterXYZRenderer scatterXYZRenderer = (ScatterXYZRenderer)xYZPlot.getRenderer();
        scatterXYZRenderer.setSize(0.1);
        StandardXYZItemLabelGenerator standardXYZItemLabelGenerator = new StandardXYZItemLabelGenerator();
        StandardXYZDataItemSelection standardXYZDataItemSelection = new StandardXYZDataItemSelection();
        standardXYZItemLabelGenerator.setItemSelection((XYZDataItemSelection)standardXYZDataItemSelection);
        standardXYZDataItemSelection.addAll(XYZItemKeys.itemKeysForSeries((XYZDataset)xYZDataset, (Comparable)((Object)"S1")));
        scatterXYZRenderer.setItemLabelGenerator((XYZItemLabelGenerator)standardXYZItemLabelGenerator);
        chart3D.setViewPoint(ViewPoint3D.createAboveLeftViewPoint((double)40.0));
        Chart3DPanel chart3DPanel = new Chart3DPanel(chart3D);
        customDemoPanel.setChartPanel(chart3DPanel);
        chart3DPanel.zoomToFit((Dimension2D)OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        customDemoPanel.add((Component)new DisplayPanel3D((Panel3D)chart3DPanel));
        return customDemoPanel;
    }

    private static XYZDataset createDataset() {
        XYZSeries xYZSeries = AxisRangeDemo5.createRandomSeries("S1", 10);
        XYZSeries xYZSeries2 = AxisRangeDemo5.createRandomSeries("S2", 50);
        XYZSeries xYZSeries3 = AxisRangeDemo5.createRandomSeries("S3", 150);
        XYZSeriesCollection xYZSeriesCollection = new XYZSeriesCollection();
        xYZSeriesCollection.add(xYZSeries);
        xYZSeriesCollection.add(xYZSeries2);
        xYZSeriesCollection.add(xYZSeries3);
        return xYZSeriesCollection;
    }

    private static XYZSeries createRandomSeries(String string, int n) {
        XYZSeries xYZSeries = new XYZSeries((Comparable)((Object)string));
        for (int i = 0; i < n; ++i) {
            xYZSeries.add(Math.random() * 100.0, Math.random() * 10.0, Math.random() * 100.0);
        }
        return xYZSeries;
    }

    public static void main(String[] arrstring) {
        AxisRangeDemo5 axisRangeDemo5 = new AxisRangeDemo5("OrsonCharts : AxisRangeDemo5.java");
        axisRangeDemo5.pack();
        axisRangeDemo5.setVisible(true);
    }

    static class CustomDemoPanel
    extends DemoPanel
    implements ChangeListener {
        private JSlider xslider1 = new JSlider(0, 50);
        private JSlider xslider2;
        private JSlider yslider1;
        private JSlider yslider2;
        private JSlider zslider1;
        private JSlider zslider2;

        public CustomDemoPanel(LayoutManager layoutManager) {
            super(layoutManager);
            this.xslider1.setValue(0);
            this.xslider2 = new JSlider(50, 100);
            this.xslider2.setValue(100);
            this.xslider1.addChangeListener(this);
            this.xslider2.addChangeListener(this);
            this.yslider1 = new JSlider(0, 50);
            this.yslider1.setValue(0);
            this.yslider2 = new JSlider(50, 100);
            this.yslider2.setValue(100);
            this.yslider1.addChangeListener(this);
            this.yslider2.addChangeListener(this);
            this.zslider1 = new JSlider(0, 50);
            this.zslider1.setValue(0);
            this.zslider2 = new JSlider(50, 100);
            this.zslider2.setValue(100);
            this.zslider1.addChangeListener(this);
            this.zslider2.addChangeListener(this);
            JPanel jPanel = new JPanel(new GridLayout(3, 1));
            JPanel jPanel2 = new JPanel(new FlowLayout());
            jPanel2.add(new JLabel("X axis: "));
            jPanel2.add(new JLabel("Lower bound: "));
            jPanel2.add(this.xslider1);
            jPanel2.add(new JLabel("Upper bound: "));
            jPanel2.add(this.xslider2);
            jPanel.add(jPanel2);
            JPanel jPanel3 = new JPanel(new FlowLayout());
            jPanel3.add(new JLabel("Y axis: "));
            jPanel3.add(new JLabel("Lower bound: "));
            jPanel3.add(this.yslider1);
            jPanel3.add(new JLabel("Upper bound: "));
            jPanel3.add(this.yslider2);
            jPanel.add(jPanel3);
            JPanel jPanel4 = new JPanel(new FlowLayout());
            jPanel4.add(new JLabel("Z axis: "));
            jPanel4.add(new JLabel("Lower bound: "));
            jPanel4.add(this.zslider1);
            jPanel4.add(new JLabel("Upper bound: "));
            jPanel4.add(this.zslider2);
            jPanel.add(jPanel4);
            this.add((Component)jPanel, "South");
        }

        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            double d;
            double d2;
            double d3;
            Chart3D chart3D = (Chart3D)this.getChartPanel().getDrawable();
            XYZPlot xYZPlot = (XYZPlot)chart3D.getPlot();
            ValueAxis3D valueAxis3D = xYZPlot.getXAxis();
            double d4 = this.xslider1.getValue();
            if (d4 != (d = (double)this.xslider2.getValue())) {
                valueAxis3D.setRange(d4, d);
            }
            ValueAxis3D valueAxis3D2 = xYZPlot.getYAxis();
            double d5 = (double)this.yslider1.getValue() / 10.0;
            if (d5 != (d3 = (double)this.yslider2.getValue() / 10.0)) {
                valueAxis3D2.setRange(d5, d3);
            }
            ValueAxis3D valueAxis3D3 = xYZPlot.getZAxis();
            double d6 = this.zslider1.getValue();
            if (d6 != (d2 = (double)this.zslider2.getValue())) {
                valueAxis3D3.setRange(d6, d2);
            }
        }
    }

}

