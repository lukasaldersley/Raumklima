/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.Chart3D
 *  com.orsoncharts.Chart3DPanel
 *  com.orsoncharts.Range
 *  com.orsoncharts.axis.ValueAxis3D
 *  com.orsoncharts.data.xyz.XYZDataset
 *  com.orsoncharts.data.xyz.XYZItemKey
 *  com.orsoncharts.graphics3d.Drawable3D
 *  com.orsoncharts.graphics3d.RenderedElement
 *  com.orsoncharts.graphics3d.swing.DisplayPanel3D
 *  com.orsoncharts.graphics3d.swing.Panel3D
 *  com.orsoncharts.interaction.Chart3DMouseEvent
 *  com.orsoncharts.interaction.Chart3DMouseListener
 *  com.orsoncharts.interaction.StandardXYZDataItemSelection
 *  com.orsoncharts.interaction.XYZDataItemSelection
 *  com.orsoncharts.label.StandardXYZItemLabelGenerator
 *  com.orsoncharts.label.XYZItemLabelGenerator
 *  com.orsoncharts.marker.RangeMarker
 *  com.orsoncharts.marker.ValueMarker
 *  com.orsoncharts.plot.Plot3D
 *  com.orsoncharts.plot.XYZPlot
 *  com.orsoncharts.renderer.xyz.ScatterXYZRenderer
 *  com.orsoncharts.renderer.xyz.StandardXYZColorSource
 *  com.orsoncharts.renderer.xyz.XYZColorSource
 *  com.orsoncharts.renderer.xyz.XYZRenderer
 *  com.orsoncharts.style.ChartStyle
 */
package demo.orsoncharts.swing;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.Range;
import com.orsoncharts.axis.ValueAxis3D;
import com.orsoncharts.data.xyz.XYZDataset;
import com.orsoncharts.data.xyz.XYZItemKey;
import com.orsoncharts.graphics3d.Drawable3D;
import com.orsoncharts.graphics3d.RenderedElement;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;
import com.orsoncharts.graphics3d.swing.Panel3D;
import com.orsoncharts.interaction.Chart3DMouseEvent;
import com.orsoncharts.interaction.Chart3DMouseListener;
import com.orsoncharts.interaction.StandardXYZDataItemSelection;
import com.orsoncharts.interaction.XYZDataItemSelection;
import com.orsoncharts.label.StandardXYZItemLabelGenerator;
import com.orsoncharts.label.XYZItemLabelGenerator;
import com.orsoncharts.marker.RangeMarker;
import com.orsoncharts.marker.ValueMarker;
import com.orsoncharts.plot.Plot3D;
import com.orsoncharts.plot.XYZPlot;
import com.orsoncharts.renderer.xyz.ScatterXYZRenderer;
import com.orsoncharts.renderer.xyz.StandardXYZColorSource;
import com.orsoncharts.renderer.xyz.XYZColorSource;
import com.orsoncharts.renderer.xyz.XYZRenderer;
import com.orsoncharts.style.ChartStyle;
import demo.orsoncharts.HighlightXYZColorSource;
import demo.orsoncharts.RangeMarker1;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowListener;
import java.awt.geom.Dimension2D;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RangeMarkerDemo1
extends JFrame {
    public RangeMarkerDemo1(String string) {
        super(string);
        this.addWindowListener(new ExitOnClose());
        this.getContentPane().add(RangeMarkerDemo1.createDemoPanel());
    }

    public static JPanel createDemoPanel() {
        CustomDemoPanel customDemoPanel = new CustomDemoPanel(new BorderLayout());
        customDemoPanel.setPreferredSize(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        XYZDataset xYZDataset = RangeMarker1.createDataset();
        Chart3D chart3D = RangeMarker1.createChart(xYZDataset);
        Chart3DPanel chart3DPanel = new Chart3DPanel(chart3D);
        customDemoPanel.setChartPanel(chart3DPanel);
        chart3DPanel.addChartMouseListener((Chart3DMouseListener)customDemoPanel);
        chart3DPanel.zoomToFit((Dimension2D)OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        customDemoPanel.add((Component)new DisplayPanel3D((Panel3D)chart3DPanel));
        return customDemoPanel;
    }

    public static void main(String[] arrstring) {
        RangeMarkerDemo1 rangeMarkerDemo1 = new RangeMarkerDemo1("OrsonCharts : RangeMarkerDemo1.java");
        rangeMarkerDemo1.pack();
        rangeMarkerDemo1.setVisible(true);
    }

    static class CustomDemoPanel
    extends DemoPanel
    implements ActionListener,
    Chart3DMouseListener {
        private JCheckBox checkBox = new JCheckBox("Highlight items within range intersection");

        public CustomDemoPanel(LayoutManager layoutManager) {
            super(layoutManager);
            this.checkBox.setSelected(true);
            this.checkBox.addActionListener(this);
            JPanel jPanel = new JPanel(new FlowLayout());
            jPanel.add(this.checkBox);
            this.add((Component)jPanel, "South");
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Chart3D chart3D = (Chart3D)this.getChartPanel().getDrawable();
            XYZPlot xYZPlot = (XYZPlot)chart3D.getPlot();
            RangeMarker rangeMarker = (RangeMarker)xYZPlot.getXAxis().getMarker("X1");
            RangeMarker rangeMarker2 = (RangeMarker)xYZPlot.getYAxis().getMarker("Y1");
            RangeMarker rangeMarker3 = (RangeMarker)xYZPlot.getZAxis().getMarker("Z1");
            if (this.checkBox.isSelected()) {
                HighlightXYZColorSource highlightXYZColorSource = new HighlightXYZColorSource(xYZPlot.getDataset(), Color.RED, rangeMarker.getRange(), rangeMarker2.getRange(), rangeMarker3.getRange(), chart3D.getStyle().getStandardColors());
                xYZPlot.getRenderer().setColorSource((XYZColorSource)highlightXYZColorSource);
            } else {
                StandardXYZColorSource standardXYZColorSource = new StandardXYZColorSource(chart3D.getStyle().getStandardColors());
                xYZPlot.getRenderer().setColorSource((XYZColorSource)standardXYZColorSource);
            }
        }

        public void chartMouseClicked(Chart3DMouseEvent chart3DMouseEvent) {
            RenderedElement renderedElement = chart3DMouseEvent.getElement();
            XYZItemKey xYZItemKey = (XYZItemKey)renderedElement.getProperty("key");
            if (xYZItemKey == null) {
                this.getItemSelection().clear();
                this.getChartPanel().getChart().setNotify(true);
                return;
            }
            if (chart3DMouseEvent.getTrigger().isShiftDown()) {
                this.getItemSelection().add(xYZItemKey);
            } else {
                this.getItemSelection().clear();
                this.getItemSelection().add(xYZItemKey);
            }
            this.getChartPanel().getChart().setNotify(true);
        }

        private StandardXYZDataItemSelection getItemSelection() {
            Chart3D chart3D = this.getChartPanel().getChart();
            XYZPlot xYZPlot = (XYZPlot)chart3D.getPlot();
            ScatterXYZRenderer scatterXYZRenderer = (ScatterXYZRenderer)xYZPlot.getRenderer();
            StandardXYZItemLabelGenerator standardXYZItemLabelGenerator = (StandardXYZItemLabelGenerator)scatterXYZRenderer.getItemLabelGenerator();
            return (StandardXYZDataItemSelection)standardXYZItemLabelGenerator.getItemSelection();
        }

        public void chartMouseMoved(Chart3DMouseEvent chart3DMouseEvent) {
        }
    }

}

