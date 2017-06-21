/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.Chart3D
 *  com.orsoncharts.Chart3DFactory
 *  com.orsoncharts.Chart3DPanel
 *  com.orsoncharts.ChartElementVisitor
 *  com.orsoncharts.axis.CategoryAxis3D
 *  com.orsoncharts.axis.StandardCategoryAxis3D
 *  com.orsoncharts.data.DefaultKeyedValues
 *  com.orsoncharts.data.KeyedValues
 *  com.orsoncharts.data.KeyedValues3D
 *  com.orsoncharts.data.KeyedValues3DItemKey
 *  com.orsoncharts.data.KeyedValues3DItemKeys
 *  com.orsoncharts.data.category.CategoryDataset3D
 *  com.orsoncharts.data.category.StandardCategoryDataset3D
 *  com.orsoncharts.graphics3d.RenderedElement
 *  com.orsoncharts.graphics3d.ViewPoint3D
 *  com.orsoncharts.graphics3d.swing.DisplayPanel3D
 *  com.orsoncharts.graphics3d.swing.Panel3D
 *  com.orsoncharts.interaction.Chart3DMouseEvent
 *  com.orsoncharts.interaction.Chart3DMouseListener
 *  com.orsoncharts.interaction.InteractiveElementType
 *  com.orsoncharts.interaction.KeyedValues3DItemSelection
 *  com.orsoncharts.interaction.StandardKeyedValues3DItemSelection
 *  com.orsoncharts.label.CategoryItemLabelGenerator
 *  com.orsoncharts.label.StandardCategoryItemLabelGenerator
 *  com.orsoncharts.legend.LegendAnchor
 *  com.orsoncharts.marker.CategoryMarker
 *  com.orsoncharts.plot.CategoryPlot3D
 *  com.orsoncharts.plot.Plot3D
 *  com.orsoncharts.renderer.category.BarRenderer3D
 *  com.orsoncharts.renderer.category.CategoryColorSource
 *  com.orsoncharts.renderer.category.CategoryRenderer3D
 *  com.orsoncharts.style.ChartStyle
 *  com.orsoncharts.style.ChartStyler
 *  com.orsoncharts.util.Anchor2D
 */
package demo.orsoncharts.swing;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.ChartElementVisitor;
import com.orsoncharts.axis.CategoryAxis3D;
import com.orsoncharts.axis.StandardCategoryAxis3D;
import com.orsoncharts.data.DefaultKeyedValues;
import com.orsoncharts.data.KeyedValues;
import com.orsoncharts.data.KeyedValues3D;
import com.orsoncharts.data.KeyedValues3DItemKey;
import com.orsoncharts.data.KeyedValues3DItemKeys;
import com.orsoncharts.data.category.CategoryDataset3D;
import com.orsoncharts.data.category.StandardCategoryDataset3D;
import com.orsoncharts.graphics3d.RenderedElement;
import com.orsoncharts.graphics3d.ViewPoint3D;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;
import com.orsoncharts.graphics3d.swing.Panel3D;
import com.orsoncharts.interaction.Chart3DMouseEvent;
import com.orsoncharts.interaction.Chart3DMouseListener;
import com.orsoncharts.interaction.InteractiveElementType;
import com.orsoncharts.interaction.KeyedValues3DItemSelection;
import com.orsoncharts.interaction.StandardKeyedValues3DItemSelection;
import com.orsoncharts.label.CategoryItemLabelGenerator;
import com.orsoncharts.label.StandardCategoryItemLabelGenerator;
import com.orsoncharts.legend.LegendAnchor;
import com.orsoncharts.marker.CategoryMarker;
import com.orsoncharts.plot.CategoryPlot3D;
import com.orsoncharts.plot.Plot3D;
import com.orsoncharts.renderer.category.BarRenderer3D;
import com.orsoncharts.renderer.category.CategoryColorSource;
import com.orsoncharts.renderer.category.CategoryRenderer3D;
import com.orsoncharts.style.ChartStyle;
import com.orsoncharts.style.ChartStyler;
import com.orsoncharts.util.Anchor2D;
import demo.orsoncharts.HighlightCategoryColorSource;
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
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.geom.Dimension2D;
import java.util.Collection;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CategoryMarkerDemo1
extends JFrame {
    public CategoryMarkerDemo1(String string) {
        super(string);
        this.addWindowListener(new ExitOnClose());
        this.getContentPane().add(CategoryMarkerDemo1.createDemoPanel());
    }

    public static JPanel createDemoPanel() {
        CustomDemoPanel customDemoPanel = new CustomDemoPanel(new BorderLayout());
        customDemoPanel.setPreferredSize(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        Chart3D chart3D = CategoryMarkerDemo1.createChart(CategoryMarkerDemo1.createDataset());
        Chart3DPanel chart3DPanel = new Chart3DPanel(chart3D);
        chart3DPanel.setMargin(0.3);
        chart3DPanel.getViewPoint().panLeftRight(-0.3);
        chart3DPanel.getViewPoint().moveUpDown(-0.12);
        chart3DPanel.getViewPoint().roll(-0.05235987755982988);
        customDemoPanel.setChartPanel(chart3DPanel);
        chart3DPanel.zoomToFit((Dimension2D)OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        chart3DPanel.addChartMouseListener((Chart3DMouseListener)customDemoPanel);
        customDemoPanel.add((Component)new DisplayPanel3D((Panel3D)chart3DPanel));
        return customDemoPanel;
    }

    public static Chart3D createChart(CategoryDataset3D categoryDataset3D) {
        Chart3D chart3D = Chart3DFactory.createBarChart((String)"Quarterly Revenues", (String)"For some large IT companies", (CategoryDataset3D)categoryDataset3D, (String)null, (String)"Quarter", (String)"$billion Revenues");
        chart3D.setChartBoxColor(new Color(255, 255, 255, 127));
        chart3D.setLegendAnchor(LegendAnchor.BOTTOM_RIGHT);
        CategoryPlot3D categoryPlot3D = (CategoryPlot3D)chart3D.getPlot();
        categoryPlot3D.setGridlinePaintForValues((Paint)Color.BLACK);
        StandardCategoryAxis3D standardCategoryAxis3D = (StandardCategoryAxis3D)categoryPlot3D.getRowAxis();
        standardCategoryAxis3D.setMarker("RM1", new CategoryMarker((Comparable)((Object)"Apple")));
        StandardCategoryAxis3D standardCategoryAxis3D2 = (StandardCategoryAxis3D)categoryPlot3D.getColumnAxis();
        standardCategoryAxis3D2.setMarker("CM1", new CategoryMarker((Comparable)((Object)"Q4/12")));
        BarRenderer3D barRenderer3D = (BarRenderer3D)categoryPlot3D.getRenderer();
        StandardCategoryItemLabelGenerator standardCategoryItemLabelGenerator = new StandardCategoryItemLabelGenerator("%4$.2f");
        StandardKeyedValues3DItemSelection standardKeyedValues3DItemSelection = new StandardKeyedValues3DItemSelection();
        standardCategoryItemLabelGenerator.setItemSelection(standardKeyedValues3DItemSelection);
        barRenderer3D.setItemLabelGenerator((CategoryItemLabelGenerator)standardCategoryItemLabelGenerator);
        HighlightCategoryColorSource highlightCategoryColorSource = new HighlightCategoryColorSource();
        highlightCategoryColorSource.setHighlightRowIndex(3);
        highlightCategoryColorSource.setHighlightColumnIndex(6);
        barRenderer3D.setColorSource((CategoryColorSource)highlightCategoryColorSource);
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

    public static void main(String[] arrstring) {
        CategoryMarkerDemo1 categoryMarkerDemo1 = new CategoryMarkerDemo1("OrsonCharts: CategoryMarkerDemo1.java");
        categoryMarkerDemo1.pack();
        categoryMarkerDemo1.setVisible(true);
    }

    static class CustomDemoPanel
    extends DemoPanel
    implements ActionListener,
    Chart3DMouseListener {
        private String selectedRowKey;
        private String selectedColumnKey;
        private JCheckBox itemLabelCheckBox;

        public CustomDemoPanel(LayoutManager layoutManager) {
            super(layoutManager);
            JPanel jPanel = new JPanel(new FlowLayout());
            this.itemLabelCheckBox = new JCheckBox("Show item labels?");
            this.itemLabelCheckBox.addActionListener(this);
            jPanel.add(this.itemLabelCheckBox);
            this.selectedRowKey = "Apple";
            this.selectedColumnKey = "Q4/12";
            this.add((Component)jPanel, "South");
        }

        private void updateColorSource(String string, String string2) {
            HighlightCategoryColorSource highlightCategoryColorSource = (HighlightCategoryColorSource)this.getRenderer().getColorSource();
            int n = this.getPlot().getDataset().getRowIndex((Comparable)((Object)string));
            int n2 = this.getPlot().getDataset().getColumnIndex((Comparable)((Object)string2));
            highlightCategoryColorSource.setHighlightRowIndex(n);
            highlightCategoryColorSource.setHighlightColumnIndex(n2);
        }

        private void updateItemSelection(String string, String string2) {
            StandardKeyedValues3DItemSelection standardKeyedValues3DItemSelection = (StandardKeyedValues3DItemSelection)this.getItemSelection();
            standardKeyedValues3DItemSelection.clear();
            if (this.itemLabelCheckBox.isSelected()) {
                standardKeyedValues3DItemSelection.addAll(KeyedValues3DItemKeys.itemKeysForColumn((KeyedValues3D)this.getPlot().getDataset(), (Comparable)((Object)string2)));
                standardKeyedValues3DItemSelection.addAll(KeyedValues3DItemKeys.itemKeysForRow((KeyedValues3D)this.getPlot().getDataset(), (Comparable)((Object)string)));
            }
        }

        private CategoryPlot3D getPlot() {
            Chart3D chart3D = this.getChartPanel().getChart();
            return (CategoryPlot3D)chart3D.getPlot();
        }

        private BarRenderer3D getRenderer() {
            return (BarRenderer3D)this.getPlot().getRenderer();
        }

        private KeyedValues3DItemSelection getItemSelection() {
            StandardCategoryItemLabelGenerator standardCategoryItemLabelGenerator = (StandardCategoryItemLabelGenerator)this.getRenderer().getItemLabelGenerator();
            return standardCategoryItemLabelGenerator.getItemSelection();
        }

        private void handleSelectItem(Comparable comparable, Comparable comparable2) {
            CategoryMarker categoryMarker;
            StandardCategoryAxis3D standardCategoryAxis3D;
            Chart3D chart3D = this.getChartPanel().getChart();
            chart3D.setNotify(false);
            CategoryPlot3D categoryPlot3D = this.getPlot();
            StandardCategoryAxis3D standardCategoryAxis3D2 = (StandardCategoryAxis3D)categoryPlot3D.getRowAxis();
            CategoryMarker categoryMarker2 = standardCategoryAxis3D2.getMarker("RM1");
            if (categoryMarker2 == null) {
                categoryMarker2 = new CategoryMarker((Comparable)((Object)""));
                categoryMarker2.receive((ChartElementVisitor)new ChartStyler(chart3D.getStyle()));
            }
            if ((categoryMarker = (standardCategoryAxis3D = (StandardCategoryAxis3D)categoryPlot3D.getColumnAxis()).getMarker("CM1")) == null) {
                categoryMarker = new CategoryMarker((Comparable)((Object)""));
                categoryMarker.receive((ChartElementVisitor)new ChartStyler(chart3D.getStyle()));
            }
            this.selectedRowKey = comparable.toString();
            this.selectedColumnKey = comparable2.toString();
            categoryMarker2.setCategory((Comparable)((Object)this.selectedRowKey));
            categoryMarker.setCategory((Comparable)((Object)this.selectedColumnKey));
            this.updateColorSource(this.selectedRowKey, this.selectedColumnKey);
            this.updateItemSelection(this.selectedRowKey, this.selectedColumnKey);
            chart3D.setNotify(true);
        }

        private void handleSelectRow(Comparable comparable) {
            this.handleSelectItem(comparable, (Comparable)((Object)this.selectedColumnKey));
        }

        private void handleSelectColumn(Comparable comparable) {
            this.handleSelectItem((Comparable)((Object)this.selectedRowKey), comparable);
        }

        public void chartMouseClicked(Chart3DMouseEvent chart3DMouseEvent) {
            RenderedElement renderedElement = chart3DMouseEvent.getElement();
            if (renderedElement == null) {
                return;
            }
            KeyedValues3DItemKey keyedValues3DItemKey = (KeyedValues3DItemKey)renderedElement.getProperty("key");
            if (keyedValues3DItemKey != null) {
                this.handleSelectItem(keyedValues3DItemKey.getRowKey(), keyedValues3DItemKey.getColumnKey());
            } else if (InteractiveElementType.CATEGORY_AXIS_TICK_LABEL.equals(renderedElement.getType())) {
                String string = (String)renderedElement.getProperty("label");
                String string2 = (String)renderedElement.getProperty("axis");
                if (string2.equals("row")) {
                    this.handleSelectRow((Comparable)((Object)string));
                } else {
                    this.handleSelectColumn((Comparable)((Object)string));
                }
            } else if (InteractiveElementType.LEGEND_ITEM.equals(renderedElement.getType())) {
                Comparable comparable = (Comparable)renderedElement.getProperty("series_key");
                this.handleSelectRow(comparable);
            }
        }

        public void chartMouseMoved(Chart3DMouseEvent chart3DMouseEvent) {
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            this.updateItemSelection(this.selectedRowKey, this.selectedColumnKey);
            this.getChartPanel().getChart().setNotify(true);
        }
    }

}

