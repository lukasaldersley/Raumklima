/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.style.ChartStyle
 */
package demo.orsoncharts.swing;

import com.orsoncharts.style.ChartStyle;
import demo.orsoncharts.DemoDescription;
import demo.orsoncharts.swing.AreaChart3DDemo1;
import demo.orsoncharts.swing.DemoDisplayer;
import demo.orsoncharts.swing.DemoPanel;
import demo.orsoncharts.swing.OrsonChartsDemo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class OrsonChartsDemoComponent
extends JPanel
implements TreeSelectionListener {
    private static final String PREFIX = "demo.orsoncharts.swing.";
    private static final String ABOUT_PREFIX = "/demo/orsoncharts/";
    private TreePath defaultChartPath;
    private JPanel chartContainer;
    private JTextPane chartDescriptionPane;
    private ChartStyle style = null;

    public OrsonChartsDemoComponent() {
        super(new BorderLayout());
        this.add(this.createContent());
    }

    public ChartStyle getChartStyle() {
        if (this.style == null) {
            return null;
        }
        return this.style.clone();
    }

    public void setChartStyle(ChartStyle chartStyle) {
        this.style = chartStyle;
    }

    public JPanel getChartContainer() {
        return this.chartContainer;
    }

    public JTextPane getChartDescriptionPane() {
        return this.chartDescriptionPane;
    }

    private JComponent createContent() {
        JSplitPane jSplitPane = new JSplitPane(1);
        jSplitPane.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        JTree jTree = new JTree(this.createTreeModel());
        jTree.addTreeSelectionListener(this);
        jTree.setSelectionPath(this.defaultChartPath);
        JScrollPane jScrollPane = new JScrollPane(jTree);
        jScrollPane.setPreferredSize(new Dimension(300, 580));
        jSplitPane.add(jScrollPane);
        jSplitPane.add(this.createChartComponent());
        return jSplitPane;
    }

    private TreeModel createTreeModel() {
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("Orson Charts");
        defaultMutableTreeNode.add(this.createCategoryChartsNode(defaultMutableTreeNode));
        defaultMutableTreeNode.add(this.createPieChartsNode());
        defaultMutableTreeNode.add(this.createXYZChartsNode());
        defaultMutableTreeNode.add(this.createAxisRangeTestNode());
        return new DefaultTreeModel(defaultMutableTreeNode);
    }

    private MutableTreeNode createNode(String string, String string2, String string3) {
        return new DefaultMutableTreeNode(new DemoDescription(string, string2, string3));
    }

    private MutableTreeNode createCategoryChartsNode(DefaultMutableTreeNode defaultMutableTreeNode) {
        DefaultMutableTreeNode defaultMutableTreeNode2 = new DefaultMutableTreeNode("Category Charts");
        MutableTreeNode mutableTreeNode = this.createNode("demo.orsoncharts.swing.AreaChart3DDemo1", "AreaChart3DDemo1.java", "/demo/orsoncharts/AreaChart3D1.html");
        this.defaultChartPath = new TreePath(new Object[]{defaultMutableTreeNode, defaultMutableTreeNode2, mutableTreeNode});
        defaultMutableTreeNode2.add(mutableTreeNode);
        defaultMutableTreeNode2.add(this.createNode("demo.orsoncharts.swing.AreaChart3DDemo2", "AreaChart3DDemo2.java", "/demo/orsoncharts/AreaChart3D2.html"));
        defaultMutableTreeNode2.add(this.createNode("demo.orsoncharts.swing.BarChart3DDemo1", "BarChart3DDemo1.java", "/demo/orsoncharts/BarChart3D1.html"));
        defaultMutableTreeNode2.add(this.createNode("demo.orsoncharts.swing.BarChart3DDemo2", "BarChart3DDemo2.java", "/demo/orsoncharts/BarChart3D2.html"));
        defaultMutableTreeNode2.add(this.createNode("demo.orsoncharts.swing.CategoryMarkerDemo1", "CategoryMarkerDemo1.java", "/demo/orsoncharts/CategoryMarkerDemo1.html"));
        defaultMutableTreeNode2.add(this.createNode("demo.orsoncharts.swing.LineChart3DDemo1", "LineChart3DDemo1.java", "/demo/orsoncharts/LineChart3D1.html"));
        defaultMutableTreeNode2.add(this.createNode("demo.orsoncharts.swing.LineChart3DDemo2", "LineChart3DDemo2.java", "/demo/orsoncharts/LineChart3D2.html"));
        defaultMutableTreeNode2.add(this.createNode("demo.orsoncharts.swing.StackedBarChart3DDemo1", "StackedBarChart3DDemo1.java", "/demo/orsoncharts/StackedBarChart3D1.html"));
        defaultMutableTreeNode2.add(this.createNode("demo.orsoncharts.swing.StackedBarChart3DDemo2", "StackedBarChart3DDemo2.java", "/demo/orsoncharts/StackedBarChart3D2.html"));
        defaultMutableTreeNode2.add(this.createNode("demo.orsoncharts.swing.StackedBarChart3DDemo3", "StackedBarChart3DDemo3.java", "/demo/orsoncharts/StackedBarChart3D3.html"));
        return defaultMutableTreeNode2;
    }

    private MutableTreeNode createPieChartsNode() {
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("Pie Charts");
        defaultMutableTreeNode.add(this.createNode("demo.orsoncharts.swing.PieChart3DDemo1", "PieChart3DDemo1.java", "/demo/orsoncharts/PieChart3D1.html"));
        defaultMutableTreeNode.add(this.createNode("demo.orsoncharts.swing.PieChart3DDemo2", "PieChart3DDemo2.java", "/demo/orsoncharts/PieChart3D2.html"));
        return defaultMutableTreeNode;
    }

    private MutableTreeNode createXYZChartsNode() {
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("XYZ Charts");
        defaultMutableTreeNode.add(this.createNode("demo.orsoncharts.swing.RangeMarkerDemo1", "RangeMarkerDemo1.java", "/demo/orsoncharts/RangeMarker1.html"));
        defaultMutableTreeNode.add(this.createNode("demo.orsoncharts.swing.ScatterPlot3DDemo1", "ScatterPlot3DDemo1.java", "/demo/orsoncharts/ScatterPlot3D1.html"));
        defaultMutableTreeNode.add(this.createNode("demo.orsoncharts.swing.ScatterPlot3DDemo2", "ScatterPlot3DDemo2.java", "/demo/orsoncharts/ScatterPlot3D2.html"));
        defaultMutableTreeNode.add(this.createNode("demo.orsoncharts.swing.ScatterPlot3DDemo3", "ScatterPlot3DDemo3.java", "/demo/orsoncharts/ScatterPlot3D3.html"));
        defaultMutableTreeNode.add(this.createNode("demo.orsoncharts.swing.SurfaceRendererDemo1", "SurfaceRendererDemo1.java", "/demo/orsoncharts/SurfaceRenderer1.html"));
        defaultMutableTreeNode.add(this.createNode("demo.orsoncharts.swing.SurfaceRendererDemo2", "SurfaceRendererDemo2.java", "/demo/orsoncharts/SurfaceRenderer2.html"));
        defaultMutableTreeNode.add(this.createNode("demo.orsoncharts.swing.XYZBarChart3DDemo1", "XYZBarChart3DDemo1.java", "/demo/orsoncharts/XYZBarChart3D1.html"));
        return defaultMutableTreeNode;
    }

    private MutableTreeNode createAxisRangeTestNode() {
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("Axis Range Tests");
        defaultMutableTreeNode.add(this.createNode("demo.orsoncharts.swing.AxisRangeDemo1", "AxisRangeDemo1.java", "/demo/orsoncharts/AxisRangeDemo1.html"));
        defaultMutableTreeNode.add(this.createNode("demo.orsoncharts.swing.AxisRangeDemo2", "AxisRangeDemo2.java", "/demo/orsoncharts/AxisRangeDemo2.html"));
        defaultMutableTreeNode.add(this.createNode("demo.orsoncharts.swing.AxisRangeDemo3", "AxisRangeDemo3.java", "/demo/orsoncharts/AxisRangeDemo3.html"));
        defaultMutableTreeNode.add(this.createNode("demo.orsoncharts.swing.AxisRangeDemo4", "AxisRangeDemo4.java", "/demo/orsoncharts/AxisRangeDemo4.html"));
        defaultMutableTreeNode.add(this.createNode("demo.orsoncharts.swing.AxisRangeDemo5", "AxisRangeDemo5.java", "/demo/orsoncharts/AxisRangeDemo5.html"));
        defaultMutableTreeNode.add(this.createNode("demo.orsoncharts.swing.AxisRangeDemo6", "AxisRangeDemo6.java", "/demo/orsoncharts/AxisRangeDemo6.html"));
        return defaultMutableTreeNode;
    }

    private JComponent createChartComponent() {
        JSplitPane jSplitPane = new JSplitPane(0);
        CompoundBorder compoundBorder = BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4), BorderFactory.createLineBorder(Color.DARK_GRAY));
        this.chartContainer = new JPanel(new BorderLayout());
        this.chartContainer.setPreferredSize(new Dimension(400, 400));
        DemoPanel demoPanel = AreaChart3DDemo1.createDemoPanel();
        demoPanel.setBorder(compoundBorder);
        this.chartContainer.add(demoPanel);
        jSplitPane.add(this.chartContainer);
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4), BorderFactory.createLineBorder(Color.BLACK)));
        this.chartDescriptionPane = new JTextPane();
        this.chartDescriptionPane.setPreferredSize(new Dimension(400, 180));
        this.chartDescriptionPane.setEditable(false);
        this.chartDescriptionPane.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        this.chartDescriptionPane.setText("No chart description available.");
        jPanel.add(this.chartDescriptionPane);
        jSplitPane.add(jPanel);
        return jSplitPane;
    }

    @Override
    public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
        TreePath treePath = treeSelectionEvent.getPath();
        Object object = treePath.getLastPathComponent();
        if (object != null) {
            DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode)object;
            Object object2 = defaultMutableTreeNode.getUserObject();
            if (object2 instanceof DemoDescription) {
                DemoDescription demoDescription = (DemoDescription)object2;
                SwingUtilities.invokeLater(new DemoDisplayer(this, demoDescription));
            } else {
                this.chartContainer.removeAll();
                this.chartContainer.add(this.createNoDemoSelectedPanel());
                this.chartContainer.validate();
                URL uRL = OrsonChartsDemo.class.getResource("select.html");
                if (uRL != null) {
                    try {
                        this.chartDescriptionPane.setPage(uRL);
                    }
                    catch (IOException iOException) {
                        System.err.println("Attempted to read a bad URL: " + uRL);
                    }
                }
            }
        }
    }

    private JComponent createNoDemoSelectedPanel() {
        return new JButton("No demo selected.");
    }
}

