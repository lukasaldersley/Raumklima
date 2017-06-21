/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsonpdf.PDFDocument
 *  com.orsonpdf.PDFGraphics2D
 *  com.orsonpdf.Page
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartTheme
 *  org.jfree.chart.ChartTransferable
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.StandardChartTheme
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.CombinedDomainCategoryPlot
 *  org.jfree.chart.plot.CombinedDomainXYPlot
 *  org.jfree.chart.plot.CombinedRangeCategoryPlot
 *  org.jfree.chart.plot.CombinedRangeXYPlot
 *  org.jfree.chart.plot.MultiplePiePlot
 *  org.jfree.chart.plot.PiePlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.chart.util.ShadowGenerator
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RectangleInsets
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import com.orsonpdf.PDFDocument;
import com.orsonpdf.PDFGraphics2D;
import com.orsonpdf.Page;
import demo.CanvasExportTask;
import demo.DemoDescription;
import demo.DemoPanel;
import demo.MemoryUsageDemo;
import demo.SVGExportTask;
import demo.orsoncharts.swing.OrsonChartsDemoComponent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartTheme;
import org.jfree.chart.ChartTransferable;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CombinedDomainCategoryPlot;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.CombinedRangeCategoryPlot;
import org.jfree.chart.plot.CombinedRangeXYPlot;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.util.ShadowGenerator;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class SuperDemo
extends ApplicationFrame
implements ActionListener,
TreeSelectionListener,
ChangeListener {
    private static final long serialVersionUID = 1;
    public static final String EXIT_COMMAND = "EXIT";
    private JPanel displayPanel;
    private JPanel chartContainer;
    private JPanel descriptionContainer;
    private JTextPane descriptionPane;
    private JEditorPane editorPane;
    private TreePath defaultChartPath;
    JTabbedPane tabs;
    private JMenuItem exportToPDFMenuItem;
    private JMenuItem exportToSVGMenuItem;
    private JMenuItem exportToCanvasMenuItem;
    private JMenu editMenu;
    private JMenu themeMenu;

    public SuperDemo(String string) {
        super(string);
        this.setContentPane((Container)this.createContent());
        this.setJMenuBar(this.createMenuBar());
    }

    private JComponent createContent() {
        MemoryUsageDemo memoryUsageDemo;
        JPanel jPanel = new JPanel(new BorderLayout());
        this.tabs = new JTabbedPane();
        this.tabs.addChangeListener(this);
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        JSplitPane jSplitPane = new JSplitPane(1);
        JTree jTree = new JTree(this.createTreeModel());
        jTree.addTreeSelectionListener(this);
        JScrollPane jScrollPane = new JScrollPane(jTree);
        jScrollPane.setPreferredSize(new Dimension(300, 100));
        jSplitPane.setLeftComponent(jScrollPane);
        jSplitPane.setRightComponent(this.createChartDisplayPanel());
        jPanel2.add(jSplitPane);
        this.tabs.add("Demos", jPanel2);
        MemoryUsageDemo memoryUsageDemo2 = memoryUsageDemo = new MemoryUsageDemo(300000);
        memoryUsageDemo2.getClass();
        memoryUsageDemo2.new MemoryUsageDemo.DataGenerator(1000).start();
        this.tabs.add("Memory Usage", memoryUsageDemo);
        this.tabs.add("Source Code", this.createSourceCodePanel());
        this.tabs.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        JPanel jPanel3 = new JPanel(new BorderLayout());
        JPanel jPanel4 = new JPanel(new BorderLayout());
        jPanel4.setBorder(new EmptyBorder(3, 3, 3, 3));
        JTextPane jTextPane = new JTextPane();
        jTextPane.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.RED, 2), BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        jTextPane.setEditable(false);
        URL uRL = SuperDemo.class.getResource("notice.html");
        try {
            jTextPane.setPage(uRL);
        }
        catch (IOException iOException) {
            Logger.getLogger(SuperDemo.class.getName()).log(Level.SEVERE, null, iOException);
        }
        jPanel4.add(jTextPane);
        jPanel3.add((Component)jPanel4, "North");
        jPanel3.add(new OrsonChartsDemoComponent());
        this.tabs.add("Orson Charts 3D", jPanel3);
        jPanel.add(this.tabs);
        jTree.setSelectionPath(this.defaultChartPath);
        return jPanel;
    }

    private JMenuBar createMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("File", true);
        jMenu.setMnemonic('F');
        this.exportToPDFMenuItem = new JMenuItem("Export to PDF...", 112);
        this.exportToPDFMenuItem.setActionCommand("EXPORT_TO_PDF");
        this.exportToPDFMenuItem.addActionListener(this);
        jMenu.add(this.exportToPDFMenuItem);
        this.exportToCanvasMenuItem = new JMenuItem("Export to Canvas...", 106);
        this.exportToCanvasMenuItem.setActionCommand("EXPORT_TO_CANVAS");
        this.exportToCanvasMenuItem.addActionListener(this);
        jMenu.add(this.exportToCanvasMenuItem);
        this.exportToSVGMenuItem = new JMenuItem("Export to SVG...", 106);
        this.exportToSVGMenuItem.setActionCommand("EXPORT_TO_SVG");
        this.exportToSVGMenuItem.addActionListener(this);
        jMenu.add(this.exportToSVGMenuItem);
        jMenu.addSeparator();
        JMenuItem jMenuItem = new JMenuItem("Exit", 120);
        jMenuItem.setActionCommand("EXIT");
        jMenuItem.addActionListener(this);
        jMenu.add(jMenuItem);
        jMenuBar.add(jMenu);
        this.editMenu = new JMenu("Edit", false);
        jMenuBar.add(this.editMenu);
        JMenuItem jMenuItem2 = new JMenuItem("Copy", 67);
        jMenuItem2.setActionCommand("COPY");
        jMenuItem2.addActionListener(this);
        this.editMenu.add(jMenuItem2);
        this.themeMenu = new JMenu("Theme", true);
        this.themeMenu.setMnemonic('T');
        JCheckBoxMenuItem jCheckBoxMenuItem = new JCheckBoxMenuItem("JFree", true);
        jCheckBoxMenuItem.setActionCommand("JFREE_THEME");
        jCheckBoxMenuItem.addActionListener(this);
        this.themeMenu.add(jCheckBoxMenuItem);
        JCheckBoxMenuItem jCheckBoxMenuItem2 = new JCheckBoxMenuItem("JFree/Shadow", false);
        jCheckBoxMenuItem2.setActionCommand("JFREE_SHADOW_THEME");
        jCheckBoxMenuItem2.addActionListener(this);
        this.themeMenu.add(jCheckBoxMenuItem2);
        JCheckBoxMenuItem jCheckBoxMenuItem3 = new JCheckBoxMenuItem("Darkness", false);
        jCheckBoxMenuItem3.setActionCommand("DARKNESS_THEME");
        jCheckBoxMenuItem3.addActionListener(this);
        this.themeMenu.add(jCheckBoxMenuItem3);
        JCheckBoxMenuItem jCheckBoxMenuItem4 = new JCheckBoxMenuItem("Legacy", false);
        jCheckBoxMenuItem4.setActionCommand("LEGACY_THEME");
        jCheckBoxMenuItem4.addActionListener(this);
        this.themeMenu.add(jCheckBoxMenuItem4);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jCheckBoxMenuItem);
        buttonGroup.add(jCheckBoxMenuItem2);
        buttonGroup.add(jCheckBoxMenuItem3);
        buttonGroup.add(jCheckBoxMenuItem4);
        jMenuBar.add(this.themeMenu);
        return jMenuBar;
    }

    private JPanel createSourceCodePanel() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        this.editorPane = new JEditorPane();
        this.editorPane.setEditable(false);
        this.editorPane.setFont(new Font("Monospaced", 0, 12));
        this.updateSourceCodePanel("source.html");
        JScrollPane jScrollPane = new JScrollPane(this.editorPane);
        jScrollPane.setVerticalScrollBarPolicy(20);
        jScrollPane.setPreferredSize(new Dimension(250, 145));
        jScrollPane.setMinimumSize(new Dimension(10, 10));
        jPanel.add(jScrollPane);
        return jPanel;
    }

    private void updateSourceCodePanel(String string) {
        URL uRL = null;
        if (string != null) {
            uRL = SuperDemo.class.getResource(string);
        }
        if (uRL == null) {
            uRL = SuperDemo.class.getResource("source.html");
        }
        if (uRL != null) {
            try {
                this.editorPane.setPage(uRL);
            }
            catch (IOException iOException) {
                System.err.println("Attempted to read a bad URL: " + uRL);
            }
        } else {
            System.err.println("Couldn't find file: source.html");
        }
    }

    private void copyToClipboard() {
        Object object;
        JFreeChart jFreeChart = null;
        int n = 0;
        int n2 = 0;
        Component component = this.chartContainer.getComponent(0);
        if (component instanceof ChartPanel) {
            object = (ChartPanel)component;
            jFreeChart = object.getChart();
            n = object.getWidth();
            n2 = object.getHeight();
        } else if (component instanceof DemoPanel) {
            object = (DemoPanel)component;
            jFreeChart = (JFreeChart)object.charts.get(0);
            n = object.getWidth();
            n2 = object.getHeight();
        }
        if (jFreeChart != null) {
            object = Toolkit.getDefaultToolkit().getSystemClipboard();
            ChartTransferable chartTransferable = new ChartTransferable(jFreeChart, n, n2);
            object.setContents((Transferable)chartTransferable, null);
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("EXPORT_TO_PDF")) {
            this.exportToPDF();
        } else if (string.equals("EXPORT_TO_CANVAS")) {
            this.exportToCanvas();
        } else if (string.equals("EXPORT_TO_SVG")) {
            this.exportToSVG();
        } else if (string.equals("COPY")) {
            this.copyToClipboard();
        } else if (string.equals("LEGACY_THEME")) {
            ChartFactory.setChartTheme((ChartTheme)StandardChartTheme.createLegacyTheme());
            this.applyThemeToChart();
        } else if (string.equals("JFREE_THEME")) {
            ChartFactory.setChartTheme((ChartTheme)StandardChartTheme.createJFreeTheme());
            this.applyThemeToChart();
        } else if (string.equals("JFREE_SHADOW_THEME")) {
            ChartFactory.setChartTheme((ChartTheme)new StandardChartTheme("JFreeChart/Shadow", true));
            this.applyThemeToChart();
        } else if (string.equals("DARKNESS_THEME")) {
            ChartFactory.setChartTheme((ChartTheme)StandardChartTheme.createDarknessTheme());
            this.applyThemeToChart();
        } else if (string.equals("EXIT")) {
            System.exit(0);
        }
    }

    private void applyThemeToChart() {
        Component component = this.chartContainer.getComponent(0);
        if (component instanceof ChartPanel) {
            ChartPanel chartPanel = (ChartPanel)component;
            ChartUtilities.applyCurrentTheme((JFreeChart)chartPanel.getChart());
        } else if (component instanceof DemoPanel) {
            DemoPanel demoPanel = (DemoPanel)component;
            JFreeChart[] arrjFreeChart = demoPanel.getCharts();
            for (int i = 0; i < arrjFreeChart.length; ++i) {
                ChartUtilities.applyCurrentTheme((JFreeChart)arrjFreeChart[i]);
            }
        }
    }

    private void exportToCanvas() {
        Object object;
        if (this.tabs.getSelectedIndex() != 0) {
            return;
        }
        JFreeChart jFreeChart = null;
        int n = 0;
        int n2 = 0;
        Component component = this.chartContainer.getComponent(0);
        if (component instanceof ChartPanel) {
            object = (ChartPanel)component;
            jFreeChart = object.getChart();
            n = object.getWidth();
            n2 = object.getHeight();
        } else if (component instanceof DemoPanel) {
            object = (DemoPanel)component;
            jFreeChart = (JFreeChart)object.charts.get(0);
            n = object.getWidth();
            n2 = object.getHeight();
        }
        if (jFreeChart != null) {
            object = new JFileChooser();
            object.setName("untitled.html");
            object.setFileFilter(new FileFilter(){

                @Override
                public boolean accept(File file) {
                    return file.isDirectory() || file.getName().endsWith(".html");
                }

                @Override
                public String getDescription() {
                    return "HTML (HTML)";
                }
            });
            int n3 = object.showSaveDialog((Component)((Object)this));
            if (n3 == 0) {
                try {
                    JFreeChart jFreeChart2 = (JFreeChart)jFreeChart.clone();
                    CanvasExportTask canvasExportTask = new CanvasExportTask(jFreeChart2, n, n2, object.getSelectedFile());
                    Thread thread = new Thread(canvasExportTask);
                    thread.start();
                }
                catch (CloneNotSupportedException cloneNotSupportedException) {
                    cloneNotSupportedException.printStackTrace();
                }
            }
        } else {
            object = "Unable to export the selected item.  There is ";
            object = (String)object + "either no chart selected,\nor else the chart is not ";
            object = (String)object + "at the expected location in the component hierarchy\n";
            object = (String)object + "(future versions of the demo may include code to ";
            object = (String)object + "handle these special cases).";
            JOptionPane.showMessageDialog((Component)((Object)this), object, "PDF Export", 1);
        }
    }

    private void exportToSVG() {
        Object object;
        if (this.tabs.getSelectedIndex() != 0) {
            return;
        }
        JFreeChart jFreeChart = null;
        int n = 0;
        int n2 = 0;
        Component component = this.chartContainer.getComponent(0);
        if (component instanceof ChartPanel) {
            object = (ChartPanel)component;
            jFreeChart = object.getChart();
            n = object.getWidth();
            n2 = object.getHeight();
        } else if (component instanceof DemoPanel) {
            object = (DemoPanel)component;
            jFreeChart = (JFreeChart)object.charts.get(0);
            n = object.getWidth();
            n2 = object.getHeight();
        }
        if (jFreeChart != null) {
            object = new JFileChooser();
            object.setName("untitled.html");
            object.setFileFilter(new FileFilter(){

                @Override
                public boolean accept(File file) {
                    return file.isDirectory() || file.getName().endsWith(".html");
                }

                @Override
                public String getDescription() {
                    return "HTML (HTML)";
                }
            });
            int n3 = object.showSaveDialog((Component)((Object)this));
            if (n3 == 0) {
                try {
                    JFreeChart jFreeChart2 = (JFreeChart)jFreeChart.clone();
                    this.disableShadowGeneration(jFreeChart2);
                    SVGExportTask sVGExportTask = new SVGExportTask(jFreeChart2, n, n2, object.getSelectedFile());
                    Thread thread = new Thread(sVGExportTask);
                    thread.start();
                }
                catch (CloneNotSupportedException cloneNotSupportedException) {
                    cloneNotSupportedException.printStackTrace();
                }
            }
        } else {
            object = "Unable to export the selected item.  There is ";
            object = (String)object + "either no chart selected,\nor else the chart is not ";
            object = (String)object + "at the expected location in the component hierarchy\n";
            object = (String)object + "(future versions of the demo may include code to ";
            object = (String)object + "handle these special cases).";
            JOptionPane.showMessageDialog((Component)((Object)this), object, "PDF Export", 1);
        }
    }

    private void exportToPDF() {
        if (this.tabs.getSelectedIndex() == 0) {
            Object object;
            JFreeChart jFreeChart = null;
            int n = 0;
            int n2 = 0;
            Component component = this.chartContainer.getComponent(0);
            if (component instanceof ChartPanel) {
                object = (ChartPanel)component;
                jFreeChart = object.getChart();
                n = object.getWidth();
                n2 = object.getHeight();
            } else if (component instanceof DemoPanel) {
                object = (DemoPanel)component;
                jFreeChart = (JFreeChart)object.charts.get(0);
                n = object.getWidth();
                n2 = object.getHeight();
            }
            if (jFreeChart != null) {
                object = new JFileChooser();
                object.setName("untitled.pdf");
                object.setFileFilter(new FileFilter(){

                    @Override
                    public boolean accept(File file) {
                        return file.isDirectory() || file.getName().endsWith(".pdf");
                    }

                    @Override
                    public String getDescription() {
                        return "Portable Document Format (PDF)";
                    }
                });
                int n3 = object.showSaveDialog((Component)((Object)this));
                if (n3 == 0) {
                    try {
                        JFreeChart jFreeChart2 = (JFreeChart)jFreeChart.clone();
                        this.disableShadowGeneration(jFreeChart2);
                        PDFExportTask pDFExportTask = new PDFExportTask(jFreeChart2, n, n2, object.getSelectedFile());
                        Thread thread = new Thread(pDFExportTask);
                        thread.start();
                    }
                    catch (CloneNotSupportedException cloneNotSupportedException) {
                        cloneNotSupportedException.printStackTrace();
                    }
                }
            } else {
                object = "Unable to export the selected item.  There is ";
                object = (String)object + "either no chart selected,\nor else the chart is not ";
                object = (String)object + "at the expected location in the component hierarchy\n";
                object = (String)object + "(future versions of the demo may include code to ";
                object = (String)object + "handle these special cases).";
                JOptionPane.showMessageDialog((Component)((Object)this), object, "PDF Export", 1);
            }
        }
    }

    private void disableShadowGeneration(JFreeChart jFreeChart) {
        Plot plot = jFreeChart.getPlot();
        if (plot instanceof CategoryPlot) {
            ((CategoryPlot)plot).setShadowGenerator(null);
        } else if (plot instanceof XYPlot) {
            ((XYPlot)plot).setShadowGenerator(null);
        } else if (plot instanceof PiePlot) {
            ((PiePlot)plot).setShadowGenerator(null);
        } else if (plot instanceof MultiplePiePlot) {
            this.disableShadowGeneration(((MultiplePiePlot)plot).getPieChart());
        } else if (plot instanceof CombinedDomainCategoryPlot) {
            ((CombinedDomainCategoryPlot)plot).setShadowGenerator(null);
        } else if (plot instanceof CombinedRangeCategoryPlot) {
            ((CombinedRangeCategoryPlot)plot).setShadowGenerator(null);
        } else if (plot instanceof CombinedDomainXYPlot) {
            ((CombinedDomainXYPlot)plot).setShadowGenerator(null);
        } else if (plot instanceof CombinedRangeXYPlot) {
            ((CombinedRangeXYPlot)plot).setShadowGenerator(null);
        }
    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        if (changeEvent.getSource() instanceof JTabbedPane) {
            JTabbedPane jTabbedPane = (JTabbedPane)changeEvent.getSource();
            if (this.themeMenu != null) {
                this.themeMenu.setEnabled(jTabbedPane.getSelectedIndex() == 0);
            }
            if (this.editMenu != null) {
                this.editMenu.setEnabled(jTabbedPane.getSelectedIndex() == 0);
            }
            if (this.exportToCanvasMenuItem != null) {
                this.exportToCanvasMenuItem.setEnabled(jTabbedPane.getSelectedIndex() == 0);
            }
            if (this.exportToSVGMenuItem != null) {
                this.exportToSVGMenuItem.setEnabled(jTabbedPane.getSelectedIndex() == 0);
            }
            if (this.exportToPDFMenuItem != null) {
                this.exportToPDFMenuItem.setEnabled(jTabbedPane.getSelectedIndex() == 0);
            }
        }
    }

    public static void saveChartAsPDF(File file, JFreeChart jFreeChart, int n, int n2) throws IOException {
        PDFDocument pDFDocument = new PDFDocument();
        Page page = pDFDocument.createPage((Rectangle2D)new Rectangle(n, n2));
        PDFGraphics2D pDFGraphics2D = page.getGraphics2D();
        jFreeChart.draw((Graphics2D)pDFGraphics2D, (Rectangle2D)new Rectangle(n, n2));
        pDFDocument.writeToFile(file);
    }

    private JPanel createChartDisplayPanel() {
        this.displayPanel = new JPanel(new BorderLayout());
        this.chartContainer = new JPanel(new BorderLayout());
        this.chartContainer.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4), BorderFactory.createLineBorder(Color.black)));
        this.chartContainer.add(this.createNoDemoSelectedPanel());
        this.descriptionContainer = new JPanel(new BorderLayout());
        this.descriptionContainer.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        this.descriptionContainer.setPreferredSize(new Dimension(600, 140));
        this.descriptionPane = new JTextPane();
        this.descriptionPane.setEditable(false);
        JScrollPane jScrollPane = new JScrollPane(this.descriptionPane, 20, 31);
        this.descriptionContainer.add(jScrollPane);
        this.displayDescription("select.html");
        JSplitPane jSplitPane = new JSplitPane(0);
        jSplitPane.setTopComponent(this.chartContainer);
        jSplitPane.setBottomComponent(this.descriptionContainer);
        this.displayPanel.add(jSplitPane);
        jSplitPane.setDividerLocation(0.75);
        return this.displayPanel;
    }

    private TreeModel createTreeModel() {
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("JFreeChart");
        MutableTreeNode mutableTreeNode = this.createShowcaseNode(defaultMutableTreeNode);
        defaultMutableTreeNode.add(mutableTreeNode);
        defaultMutableTreeNode.add(this.createAreaChartsNode());
        defaultMutableTreeNode.add(this.createBarChartsNode());
        defaultMutableTreeNode.add(this.createStackedBarChartsNode());
        defaultMutableTreeNode.add(this.createCombinedAxisChartsNode());
        defaultMutableTreeNode.add(this.createFinancialChartsNode());
        defaultMutableTreeNode.add(this.createGanttChartsNode());
        defaultMutableTreeNode.add(this.createLineChartsNode());
        defaultMutableTreeNode.add(this.createMeterChartsNode());
        defaultMutableTreeNode.add(this.createMultipleAxisChartsNode());
        defaultMutableTreeNode.add(this.createOverlaidChartsNode());
        defaultMutableTreeNode.add(this.createPieChartsNode());
        defaultMutableTreeNode.add(this.createStatisticalChartsNode());
        defaultMutableTreeNode.add(this.createTimeSeriesChartsNode());
        defaultMutableTreeNode.add(this.createXYChartsNode());
        defaultMutableTreeNode.add(this.createMiscellaneousChartsNode());
        return new DefaultTreeModel(defaultMutableTreeNode);
    }

    private MutableTreeNode createPieChartsNode() {
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("Pie Charts");
        defaultMutableTreeNode.add(this.createNode("demo.PieChartDemo1", "PieChartDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.PieChartDemo2", "PieChartDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.PieChartDemo3", "PieChartDemo3.java"));
        defaultMutableTreeNode.add(this.createNode("demo.PieChartDemo4", "PieChartDemo4.java"));
        defaultMutableTreeNode.add(this.createNode("demo.PieChartDemo5", "PieChartDemo5.java"));
        defaultMutableTreeNode.add(this.createNode("demo.PieChartDemo6", "PieChartDemo6.java"));
        defaultMutableTreeNode.add(this.createNode("demo.PieChartDemo7", "PieChartDemo7.java"));
        defaultMutableTreeNode.add(this.createNode("demo.PieChartDemo8", "PieChartDemo8.java"));
        defaultMutableTreeNode.add(this.createNode("demo.PieChart3DDemo1", "PieChart3DDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.PieChart3DDemo2", "PieChart3DDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.PieChart3DDemo3", "PieChart3DDemo3.java"));
        defaultMutableTreeNode.add(this.createNode("demo.MultiplePieChartDemo1", "MultiplePieChartDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.MultiplePieChartDemo2", "MultiplePieChartDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.MultiplePieChartDemo3", "MultiplePieChartDemo3.java"));
        defaultMutableTreeNode.add(this.createNode("demo.MultiplePieChartDemo4", "MultiplePieChartDemo4.java"));
        defaultMutableTreeNode.add(this.createNode("demo.RingChartDemo1", "RingChartDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.RingChartDemo2", "RingChartDemo2.java"));
        return defaultMutableTreeNode;
    }

    private MutableTreeNode createOverlaidChartsNode() {
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("Overlaid Charts");
        defaultMutableTreeNode.add(this.createNode("demo.OverlaidBarChartDemo1", "OverlaidBarChartDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.OverlaidBarChartDemo2", "OverlaidBarChartDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.OverlaidXYPlotDemo1", "OverlaidXYPlotDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.OverlaidXYPlotDemo2", "OverlaidXYPlotDemo2.java"));
        return defaultMutableTreeNode;
    }

    private MutableTreeNode createBarChartsNode() {
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("Bar Charts");
        defaultMutableTreeNode.add(this.createCategoryBarChartsNode());
        defaultMutableTreeNode.add(this.createXYBarChartsNode());
        return defaultMutableTreeNode;
    }

    private MutableTreeNode createStackedBarChartsNode() {
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("Bar Charts - Stacked");
        defaultMutableTreeNode.add(this.createNode("demo.PopulationChartDemo1", "PopulationChartDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.StackedBarChartDemo1", "StackedBarChartDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.StackedBarChartDemo2", "StackedBarChartDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.StackedBarChartDemo3", "StackedBarChartDemo3.java"));
        defaultMutableTreeNode.add(this.createNode("demo.StackedBarChartDemo4", "StackedBarChartDemo4.java"));
        defaultMutableTreeNode.add(this.createNode("demo.StackedBarChartDemo5", "StackedBarChartDemo5.java"));
        defaultMutableTreeNode.add(this.createNode("demo.StackedBarChartDemo6", "StackedBarChartDemo6.java"));
        defaultMutableTreeNode.add(this.createNode("demo.StackedBarChartDemo7", "StackedBarChartDemo7.java"));
        defaultMutableTreeNode.add(this.createNode("demo.StackedBarChart3DDemo1", "StackedBarChart3DDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.StackedBarChart3DDemo2", "StackedBarChart3DDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.StackedBarChart3DDemo3", "StackedBarChart3DDemo3.java"));
        defaultMutableTreeNode.add(this.createNode("demo.StackedBarChart3DDemo4", "StackedBarChart3DDemo4.java"));
        defaultMutableTreeNode.add(this.createNode("demo.StackedBarChart3DDemo5", "StackedBarChart3DDemo5.java"));
        return defaultMutableTreeNode;
    }

    private MutableTreeNode createCategoryBarChartsNode() {
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("CategoryPlot");
        defaultMutableTreeNode.add(this.createNode("demo.BarChartDemo1", "BarChartDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.BarChartDemo2", "BarChartDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.BarChartDemo3", "BarChartDemo3.java"));
        defaultMutableTreeNode.add(this.createNode("demo.BarChartDemo4", "BarChartDemo4.java"));
        defaultMutableTreeNode.add(this.createNode("demo.BarChartDemo5", "BarChartDemo5.java"));
        defaultMutableTreeNode.add(this.createNode("demo.BarChartDemo6", "BarChartDemo6.java"));
        defaultMutableTreeNode.add(this.createNode("demo.BarChartDemo7", "BarChartDemo7.java"));
        defaultMutableTreeNode.add(this.createNode("demo.BarChartDemo8", "BarChartDemo8.java"));
        defaultMutableTreeNode.add(this.createNode("demo.BarChartDemo9", "BarChartDemo9.java"));
        defaultMutableTreeNode.add(this.createNode("demo.BarChartDemo10", "BarChartDemo10.java"));
        defaultMutableTreeNode.add(this.createNode("demo.BarChartDemo11", "BarChartDemo11.java"));
        defaultMutableTreeNode.add(this.createNode("demo.BarChart3DDemo1", "BarChart3DDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.BarChart3DDemo2", "BarChart3DDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.BarChart3DDemo3", "BarChart3DDemo3.java"));
        defaultMutableTreeNode.add(this.createNode("demo.BarChart3DDemo4", "BarChart3DDemo4.java"));
        defaultMutableTreeNode.add(this.createNode("demo.CylinderChartDemo1", "CylinderChartDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.CylinderChartDemo2", "CylinderChartDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.IntervalBarChartDemo1", "IntervalBarChartDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.LayeredBarChartDemo1", "LayeredBarChartDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.LayeredBarChartDemo2", "LayeredBarChartDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.SlidingCategoryDatasetDemo1", "SlidingCategoryDatasetDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.SlidingCategoryDatasetDemo2", "SlidingCategoryDatasetDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.StatisticalBarChartDemo1", "StatisticalBarChartDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.SurveyResultsDemo1", "SurveyResultsDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.SurveyResultsDemo2", "SurveyResultsDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.SurveyResultsDemo3", "SurveyResultsDemo3.java"));
        defaultMutableTreeNode.add(this.createNode("demo.WaterfallChartDemo1", "WaterfallChartDemo1.java"));
        return defaultMutableTreeNode;
    }

    private MutableTreeNode createXYBarChartsNode() {
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("XYPlot");
        defaultMutableTreeNode.add(this.createNode("demo.XYBarChartDemo1", "XYBarChartDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.XYBarChartDemo2", "XYBarChartDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.XYBarChartDemo3", "XYBarChartDemo3.java"));
        defaultMutableTreeNode.add(this.createNode("demo.XYBarChartDemo4", "XYBarChartDemo4.java"));
        defaultMutableTreeNode.add(this.createNode("demo.XYBarChartDemo5", "XYBarChartDemo5.java"));
        defaultMutableTreeNode.add(this.createNode("demo.XYBarChartDemo6", "XYBarChartDemo6.java"));
        defaultMutableTreeNode.add(this.createNode("demo.XYBarChartDemo7", "XYBarChartDemo7.java"));
        defaultMutableTreeNode.add(this.createNode("demo.ClusteredXYBarRendererDemo1", "ClusteredXYBarRendererDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.StackedXYBarChartDemo1", "StackedXYBarChartDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.StackedXYBarChartDemo2", "StackedXYBarChartDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.StackedXYBarChartDemo3", "StackedXYBarChartDemo3.java"));
        defaultMutableTreeNode.add(this.createNode("demo.RelativeDateFormatDemo1", "RelativeDateFormatDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.RelativeDateFormatDemo2", "RelativeDateFormatDemo2.java"));
        return defaultMutableTreeNode;
    }

    private MutableTreeNode createLineChartsNode() {
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("Line Charts");
        DefaultMutableTreeNode defaultMutableTreeNode2 = new DefaultMutableTreeNode(new DemoDescription("demo.AnnotationDemo1", "AnnotationDemo1.java"));
        DefaultMutableTreeNode defaultMutableTreeNode3 = new DefaultMutableTreeNode(new DemoDescription("demo.LineChartDemo1", "LineChartDemo1.java"));
        DefaultMutableTreeNode defaultMutableTreeNode4 = new DefaultMutableTreeNode(new DemoDescription("demo.LineChartDemo2", "LineChartDemo2.java"));
        DefaultMutableTreeNode defaultMutableTreeNode5 = new DefaultMutableTreeNode(new DemoDescription("demo.LineChartDemo3", "LineChartDemo3.java"));
        DefaultMutableTreeNode defaultMutableTreeNode6 = new DefaultMutableTreeNode(new DemoDescription("demo.LineChartDemo4", "LineChartDemo4.java"));
        DefaultMutableTreeNode defaultMutableTreeNode7 = new DefaultMutableTreeNode(new DemoDescription("demo.LineChartDemo5", "LineChartDemo5.java"));
        DefaultMutableTreeNode defaultMutableTreeNode8 = new DefaultMutableTreeNode(new DemoDescription("demo.LineChartDemo6", "LineChartDemo6.java"));
        DefaultMutableTreeNode defaultMutableTreeNode9 = new DefaultMutableTreeNode(new DemoDescription("demo.LineChartDemo7", "LineChartDemo7.java"));
        DefaultMutableTreeNode defaultMutableTreeNode10 = new DefaultMutableTreeNode(new DemoDescription("demo.LineChartDemo8", "LineChartDemo8.java"));
        DefaultMutableTreeNode defaultMutableTreeNode11 = new DefaultMutableTreeNode(new DemoDescription("demo.LineChart3DDemo1", "LineChart3DDemo1.java"));
        DefaultMutableTreeNode defaultMutableTreeNode12 = new DefaultMutableTreeNode(new DemoDescription("demo.StatisticalLineChartDemo1", "StatisticalLineChartDemo1.java"));
        DefaultMutableTreeNode defaultMutableTreeNode13 = new DefaultMutableTreeNode(new DemoDescription("demo.XYSplineRendererDemo1", "XYSplineRendererDemo1.java"));
        DefaultMutableTreeNode defaultMutableTreeNode14 = new DefaultMutableTreeNode(new DemoDescription("demo.XYStepRendererDemo1", "XYStepRendererDemo1.java"));
        DefaultMutableTreeNode defaultMutableTreeNode15 = new DefaultMutableTreeNode(new DemoDescription("demo.XYStepRendererDemo2", "XYStepRendererDemo2.java"));
        defaultMutableTreeNode.add(defaultMutableTreeNode2);
        defaultMutableTreeNode.add(defaultMutableTreeNode3);
        defaultMutableTreeNode.add(defaultMutableTreeNode4);
        defaultMutableTreeNode.add(defaultMutableTreeNode5);
        defaultMutableTreeNode.add(defaultMutableTreeNode6);
        defaultMutableTreeNode.add(defaultMutableTreeNode7);
        defaultMutableTreeNode.add(defaultMutableTreeNode8);
        defaultMutableTreeNode.add(defaultMutableTreeNode9);
        defaultMutableTreeNode.add(defaultMutableTreeNode10);
        defaultMutableTreeNode.add(defaultMutableTreeNode11);
        defaultMutableTreeNode.add(defaultMutableTreeNode12);
        defaultMutableTreeNode.add(defaultMutableTreeNode13);
        defaultMutableTreeNode.add(defaultMutableTreeNode14);
        defaultMutableTreeNode.add(defaultMutableTreeNode15);
        return defaultMutableTreeNode;
    }

    private MutableTreeNode createNode(String string, String string2) {
        return new DefaultMutableTreeNode(new DemoDescription(string, string2));
    }

    private MutableTreeNode createShowcaseNode(DefaultMutableTreeNode defaultMutableTreeNode) {
        DefaultMutableTreeNode defaultMutableTreeNode2 = new DefaultMutableTreeNode("*** Showcase Charts ***");
        MutableTreeNode mutableTreeNode = this.createNode("demo.BarChart3DDemo1", "BarChart3DDemo1.java");
        this.defaultChartPath = new TreePath(new Object[]{defaultMutableTreeNode, defaultMutableTreeNode2, mutableTreeNode});
        defaultMutableTreeNode2.add(mutableTreeNode);
        defaultMutableTreeNode2.add(this.createNode("demo.CrosshairOverlayDemo2", "CrosshairOverlayDemo2.java"));
        defaultMutableTreeNode2.add(this.createNode("demo.CrosshairDemo2", "CrosshairDemo2.java"));
        defaultMutableTreeNode2.add(this.createNode("demo.CrossSectionDemo1", "CrossSectionDemo1.java"));
        defaultMutableTreeNode2.add(this.createNode("demo.DeviationRendererDemo2", "DeviationRendererDemo2.java"));
        defaultMutableTreeNode2.add(this.createNode("demo.DifferenceChartDemo1", "DifferenceChartDemo1.java"));
        defaultMutableTreeNode2.add(this.createNode("demo.DifferenceChartDemo2", "DifferenceChartDemo2.java"));
        defaultMutableTreeNode2.add(this.createNode("demo.DialDemo2a", "DialDemo2a.java"));
        defaultMutableTreeNode2.add(this.createNode("demo.DualAxisDemo1", "DualAxisDemo1.java"));
        defaultMutableTreeNode2.add(this.createNode("demo.HistogramDemo1", "HistogramDemo1.java"));
        defaultMutableTreeNode2.add(this.createNode("demo.LineChartDemo1", "LineChartDemo1.java"));
        defaultMutableTreeNode2.add(this.createNode("demo.MultipleAxisDemo1", "MultipleAxisDemo1.java"));
        defaultMutableTreeNode2.add(this.createNode("demo.MultiplePieChartDemo1", "MultiplePieChartDemo1.java"));
        defaultMutableTreeNode2.add(this.createNode("demo.NormalDistributionDemo2", "NormalDistributionDemo2.java"));
        defaultMutableTreeNode2.add(this.createNode("demo.ParetoChartDemo1", "ParetoChartDemo1.java"));
        defaultMutableTreeNode2.add(this.createNode("demo.PieChartDemo1", "PieChartDemo1.java"));
        defaultMutableTreeNode2.add(this.createNode("demo.PieChartDemo2", "PieChartDemo2.java"));
        defaultMutableTreeNode2.add(this.createNode("demo.PieChartDemo4", "PieChartDemo4.java"));
        defaultMutableTreeNode2.add(this.createNode("demo.PriceVolumeDemo1", "PriceVolumeDemo1.java"));
        defaultMutableTreeNode2.add(this.createNode("demo.RingChartDemo2", "RingChartDemo2.java"));
        defaultMutableTreeNode2.add(this.createNode("demo.ScatterPlotDemo4", "ScatterPlotDemo4.java"));
        defaultMutableTreeNode2.add(this.createNode("demo.SlidingCategoryDatasetDemo2", "SlidingCategoryDatasetDemo2.java"));
        defaultMutableTreeNode2.add(this.createNode("demo.StackedBarChartDemo2", "StackedBarChartDemo2.java"));
        defaultMutableTreeNode2.add(this.createNode("demo.StackedXYBarChartDemo2", "StackedXYBarChartDemo2.java"));
        defaultMutableTreeNode2.add(this.createNode("demo.StatisticalBarChartDemo1", "StatisticalBarChartDemo1.java"));
        defaultMutableTreeNode2.add(this.createNode("demo.TimeSeriesDemo6", "TimeSeriesDemo6.java"));
        defaultMutableTreeNode2.add(this.createNode("demo.TimeSeriesDemo14", "TimeSeriesDemo14.java"));
        defaultMutableTreeNode2.add(this.createNode("demo.VectorPlotDemo1", "VectorPlotDemo1.java"));
        defaultMutableTreeNode2.add(this.createNode("demo.WaterfallChartDemo1", "WaterfallChartDemo1.java"));
        defaultMutableTreeNode2.add(this.createNode("demo.XYDrawableAnnotationDemo1", "XYDrawableAnnotationDemo1.java"));
        defaultMutableTreeNode2.add(this.createNode("demo.XYSplineRendererDemo1", "XYSplineRendererDemo1.java"));
        defaultMutableTreeNode2.add(this.createNode("demo.XYTaskDatasetDemo2", "XYTaskDatasetDemo2.java"));
        defaultMutableTreeNode2.add(this.createNode("demo.YieldCurveDemo1", "YieldCurveDemo1.java"));
        return defaultMutableTreeNode2;
    }

    private MutableTreeNode createAreaChartsNode() {
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("Area Charts");
        defaultMutableTreeNode.add(this.createNode("demo.AreaChartDemo1", "AreaChartDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.StackedAreaChartDemo1", "StackedAreaChartDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.StackedXYAreaChartDemo1", "StackedXYAreaChartDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.StackedXYAreaChartDemo2", "StackedXYAreaChartDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.StackedXYAreaRendererDemo1", "StackedXYAreaRendererDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.XYAreaChartDemo1", "XYAreaChartDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.XYAreaChartDemo2", "XYAreaChartDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.XYAreaRenderer2Demo1", "XYAreaRenderer2Demo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.XYStepAreaRendererDemo1", "XYStepAreaRendererDemo1.java"));
        return defaultMutableTreeNode;
    }

    private MutableTreeNode createStatisticalChartsNode() {
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("Statistical Charts");
        defaultMutableTreeNode.add(this.createNode("demo.BoxAndWhiskerChartDemo1", "BoxAndWhiskerChartDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.BoxAndWhiskerChartDemo2", "BoxAndWhiskerChartDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.HistogramDemo1", "HistogramDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.HistogramDemo2", "HistogramDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.MinMaxCategoryPlotDemo1", "MinMaxCategoryPlotDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.NormalDistributionDemo1", "NormalDistributionDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.NormalDistributionDemo2", "NormalDistributionDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.RegressionDemo1", "RegressionDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.ScatterPlotDemo1", "ScatterPlotDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.ScatterPlotDemo2", "ScatterPlotDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.ScatterPlotDemo3", "ScatterPlotDemo3.java"));
        defaultMutableTreeNode.add(this.createNode("demo.ScatterPlotDemo4", "ScatterPlotDemo4.java"));
        defaultMutableTreeNode.add(this.createNode("demo.ScatterPlotDemo5", "ScatterPlotDemo5.java"));
        defaultMutableTreeNode.add(this.createNode("demo.XYErrorRendererDemo1", "XYErrorRendererDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.XYErrorRendererDemo2", "XYErrorRendererDemo2.java"));
        return defaultMutableTreeNode;
    }

    private MutableTreeNode createTimeSeriesChartsNode() {
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("Time Series Charts");
        defaultMutableTreeNode.add(this.createNode("demo.TimeSeriesDemo1", "TimeSeriesDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.TimeSeriesDemo2", "TimeSeriesDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.TimeSeriesDemo3", "TimeSeriesDemo3.java"));
        defaultMutableTreeNode.add(this.createNode("demo.TimeSeriesDemo4", "TimeSeriesDemo4.java"));
        defaultMutableTreeNode.add(this.createNode("demo.TimeSeriesDemo5", "TimeSeriesDemo5.java"));
        defaultMutableTreeNode.add(this.createNode("demo.TimeSeriesDemo6", "TimeSeriesDemo6.java"));
        defaultMutableTreeNode.add(this.createNode("demo.TimeSeriesDemo7", "TimeSeriesDemo7.java"));
        defaultMutableTreeNode.add(this.createNode("demo.TimeSeriesDemo8", "TimeSeriesDemo8.java"));
        defaultMutableTreeNode.add(this.createNode("demo.TimeSeriesDemo9", "TimeSeriesDemo9.java"));
        defaultMutableTreeNode.add(this.createNode("demo.TimeSeriesDemo10", "TimeSeriesDemo10.java"));
        defaultMutableTreeNode.add(this.createNode("demo.TimeSeriesDemo11", "TimeSeriesDemo11.java"));
        defaultMutableTreeNode.add(this.createNode("demo.TimeSeriesDemo12", "TimeSeriesDemo12.java"));
        defaultMutableTreeNode.add(this.createNode("demo.TimeSeriesDemo13", "TimeSeriesDemo13.java"));
        defaultMutableTreeNode.add(this.createNode("demo.TimeSeriesDemo14", "TimeSeriesDemo14.java"));
        defaultMutableTreeNode.add(this.createNode("demo.PeriodAxisDemo1", "PeriodAxisDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.PeriodAxisDemo2", "PeriodAxisDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.PeriodAxisDemo3", "PeriodAxisDemo3.java"));
        defaultMutableTreeNode.add(this.createNode("demo.RelativeDateFormatDemo1", "RelativeDateFormatDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.DeviationRendererDemo1", "DeviationRendererDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.DeviationRendererDemo2", "DeviationRendererDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.DifferenceChartDemo1", "DifferenceChartDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.DifferenceChartDemo2", "DifferenceChartDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.CompareToPreviousYearDemo", "CompareToPreviousYearDemo.java"));
        return defaultMutableTreeNode;
    }

    private MutableTreeNode createFinancialChartsNode() {
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("Financial Charts");
        defaultMutableTreeNode.add(this.createNode("demo.CandlestickChartDemo1", "CandlestickChartDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.HighLowChartDemo1", "HighLowChartDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.HighLowChartDemo2", "HighLowChartDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.HighLowChartDemo3", "HighLowChartDemo3.java"));
        defaultMutableTreeNode.add(this.createNode("demo.MovingAverageDemo1", "MovingAverageDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.PriceVolumeDemo1", "PriceVolumeDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.PriceVolumeDemo2", "PriceVolumeDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.YieldCurveDemo1", "YieldCurveDemo1.java"));
        return defaultMutableTreeNode;
    }

    private MutableTreeNode createXYChartsNode() {
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("XY Charts");
        defaultMutableTreeNode.add(this.createNode("demo.ScatterPlotDemo1", "ScatterPlotDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.ScatterPlotDemo2", "ScatterPlotDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.ScatterPlotDemo3", "ScatterPlotDemo3.java"));
        defaultMutableTreeNode.add(this.createNode("demo.LogAxisDemo1", "LogAxisDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.Function2DDemo1", "Function2DDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.XYBlockChartDemo1", "XYBlockChartDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.XYBlockChartDemo2", "XYBlockChartDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.XYBlockChartDemo3", "XYBlockChartDemo3.java"));
        defaultMutableTreeNode.add(this.createNode("demo.XYLineAndShapeRendererDemo1", "XYLineAndShapeRendererDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.XYLineAndShapeRendererDemo2", "XYLineAndShapeRendererDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.XYSeriesDemo1", "XYSeriesDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.XYSeriesDemo2", "XYSeriesDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.XYSeriesDemo3", "XYSeriesDemo3.java"));
        defaultMutableTreeNode.add(this.createNode("demo.XYShapeRendererDemo1", "XYShapeRendererDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.VectorPlotDemo1", "VectorPlotDemo1.java"));
        return defaultMutableTreeNode;
    }

    private MutableTreeNode createMeterChartsNode() {
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("Dial / Meter Charts");
        defaultMutableTreeNode.add(this.createNode("demo.DialDemo1", "DialDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.DialDemo2", "DialDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.DialDemo2a", "DialDemo2a.java"));
        defaultMutableTreeNode.add(this.createNode("demo.DialDemo3", "DialDemo3.java"));
        defaultMutableTreeNode.add(this.createNode("demo.DialDemo4", "DialDemo4.java"));
        defaultMutableTreeNode.add(this.createNode("demo.DialDemo5", "DialDemo5.java"));
        defaultMutableTreeNode.add(this.createNode("demo.MeterChartDemo1", "MeterChartDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.MeterChartDemo2", "MeterChartDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.MeterChartDemo3", "MeterChartDemo3.java"));
        defaultMutableTreeNode.add(this.createNode("demo.ThermometerDemo1", "ThermometerDemo1.java"));
        return defaultMutableTreeNode;
    }

    private MutableTreeNode createMultipleAxisChartsNode() {
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("Multiple Axis Charts");
        defaultMutableTreeNode.add(this.createNode("demo.DualAxisDemo1", "DualAxisDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.DualAxisDemo2", "DualAxisDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.DualAxisDemo3", "DualAxisDemo3.java"));
        defaultMutableTreeNode.add(this.createNode("demo.DualAxisDemo4", "DualAxisDemo4.java"));
        defaultMutableTreeNode.add(this.createNode("demo.DualAxisDemo5", "DualAxisDemo5.java"));
        defaultMutableTreeNode.add(this.createNode("demo.MultipleAxisDemo1", "MultipleAxisDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.MultipleAxisDemo2", "MultipleAxisDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.MultipleAxisDemo3", "MultipleAxisDemo3.java"));
        defaultMutableTreeNode.add(this.createNode("demo.ParetoChartDemo1", "ParetoChartDemo1.java"));
        return defaultMutableTreeNode;
    }

    private MutableTreeNode createCombinedAxisChartsNode() {
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("Combined Axis Charts");
        defaultMutableTreeNode.add(this.createNode("demo.CombinedCategoryPlotDemo1", "CombinedCategoryPlotDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.CombinedCategoryPlotDemo2", "CombinedCategoryPlotDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.CombinedTimeSeriesDemo1", "CombinedTimeSeriesDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.CombinedXYPlotDemo1", "CombinedXYPlotDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.CombinedXYPlotDemo2", "CombinedXYPlotDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.CombinedXYPlotDemo3", "CombinedXYPlotDemo3.java"));
        defaultMutableTreeNode.add(this.createNode("demo.CombinedXYPlotDemo4", "CombinedXYPlotDemo4.java"));
        return defaultMutableTreeNode;
    }

    private MutableTreeNode createGanttChartsNode() {
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("Gantt Charts");
        defaultMutableTreeNode.add(this.createNode("demo.GanttDemo1", "GanttDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.GanttDemo2", "GanttDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.SlidingGanttDatasetDemo1", "SlidingGanttDatasetDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.XYTaskDatasetDemo1", "XYTaskDatasetDemo1"));
        defaultMutableTreeNode.add(this.createNode("demo.XYTaskDatasetDemo2", "XYTaskDatasetDemo2"));
        return defaultMutableTreeNode;
    }

    private MutableTreeNode createMiscellaneousChartsNode() {
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("Miscellaneous");
        defaultMutableTreeNode.add(this.createAnnotationsNode());
        defaultMutableTreeNode.add(this.createCrosshairChartsNode());
        defaultMutableTreeNode.add(this.createDynamicChartsNode());
        defaultMutableTreeNode.add(this.createItemLabelsNode());
        defaultMutableTreeNode.add(this.createLegendNode());
        defaultMutableTreeNode.add(this.createMarkersNode());
        defaultMutableTreeNode.add(this.createOrientationNode());
        defaultMutableTreeNode.add(this.createNode("demo.AxisOffsetsDemo1", "AxisOffsetsDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.BubbleChartDemo1", "BubbleChartDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.BubbleChartDemo2", "BubbleChartDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.CategoryLabelPositionsDemo1", "CategoryLabelPositionsDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.CategoryStepChartDemo1", "CategoryStepChartDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.CompassDemo1", "CompassDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.CompassFormatDemo1", "CompassFormatDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.CompassFormatDemo2", "CompassFormatDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.EventFrequencyDemo1", "EventFrequencyDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.GradientPaintTransformerDemo1", "GradientPaintTransformerDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.GridBandDemo1", "GridBandDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.HideSeriesDemo1", "HideSeriesDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.HideSeriesDemo2", "HideSeriesDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.HideSeriesDemo3", "HideSeriesDemo3.java"));
        defaultMutableTreeNode.add(this.createNode("demo.MultipleDatasetDemo1", "MultipleDatasetDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.PolarChartDemo1", "PolarChartDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.ScatterRendererDemo1", "ScatterRendererDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.SpiderWebChartDemo1", "SpiderWebChartDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.SymbolAxisDemo1", "SymbolAxisDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.ThermometerDemo1", "ThermometerDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.ThermometerDemo2", "ThermometerDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.ThumbnailDemo1", "ThumbnailDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.TranslateDemo1", "TranslateDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.WindChartDemo1", "WindChartDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.YIntervalChartDemo1", "YIntervalChartDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.YIntervalChartDemo2", "YIntervalChartDemo2.java"));
        return defaultMutableTreeNode;
    }

    private MutableTreeNode createAnnotationsNode() {
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("Annotations");
        defaultMutableTreeNode.add(this.createNode("demo.AnnotationDemo1", "AnnotationDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.AnnotationDemo2", "AnnotationDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.CategoryPointerAnnotationDemo1", "CategoryPointerAnnotationDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.XYBoxAnnotationDemo1", "XYBoxAnnotationDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.XYPolygonAnnotationDemo1", "XYPolygonAnnotationDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.XYTitleAnnotationDemo1", "XYTitleAnnotationDemo1.java"));
        return defaultMutableTreeNode;
    }

    private MutableTreeNode createCrosshairChartsNode() {
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("Crosshairs");
        defaultMutableTreeNode.add(this.createNode("demo.CrosshairOverlayDemo1", "CrosshairOverlayDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.CrosshairOverlayDemo2", "CrosshairOverlayDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.CrosshairDemo1", "CrosshairDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.CrosshairDemo2", "CrosshairDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.CrosshairDemo3", "CrosshairDemo3.java"));
        defaultMutableTreeNode.add(this.createNode("demo.CrosshairDemo4", "CrosshairDemo4.java"));
        return defaultMutableTreeNode;
    }

    private MutableTreeNode createDynamicChartsNode() {
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("Dynamic Charts");
        defaultMutableTreeNode.add(this.createNode("demo.DynamicDataDemo1", "DynamicDataDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.DynamicDataDemo2", "DynamicDataDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.DynamicDataDemo3", "DynamicDataDemo3.java"));
        defaultMutableTreeNode.add(this.createNode("demo.MouseOverDemo1", "MouseOverDemo1.java"));
        return defaultMutableTreeNode;
    }

    private MutableTreeNode createItemLabelsNode() {
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("Item Labels");
        defaultMutableTreeNode.add(this.createNode("demo.ItemLabelDemo1", "ItemLabelDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.ItemLabelDemo2", "ItemLabelDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.ItemLabelDemo3", "ItemLabelDemo3.java"));
        defaultMutableTreeNode.add(this.createNode("demo.ItemLabelDemo4", "ItemLabelDemo4.java"));
        defaultMutableTreeNode.add(this.createNode("demo.ItemLabelDemo5", "ItemLabelDemo5.java"));
        return defaultMutableTreeNode;
    }

    private MutableTreeNode createLegendNode() {
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("Legends");
        defaultMutableTreeNode.add(this.createNode("demo.LegendWrapperDemo1", "LegendWrapperDemo1.java"));
        return defaultMutableTreeNode;
    }

    private MutableTreeNode createMarkersNode() {
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("Markers");
        defaultMutableTreeNode.add(this.createNode("demo.CategoryMarkerDemo1", "CategoryMarkerDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.CategoryMarkerDemo2", "CategoryMarkerDemo2.java"));
        defaultMutableTreeNode.add(this.createNode("demo.MarkerDemo1", "MarkerDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.MarkerDemo2", "MarkerDemo2.java"));
        return defaultMutableTreeNode;
    }

    private MutableTreeNode createOrientationNode() {
        DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("Plot Orientation");
        defaultMutableTreeNode.add(this.createNode("demo.PlotOrientationDemo1", "PlotOrientationDemo1.java"));
        defaultMutableTreeNode.add(this.createNode("demo.PlotOrientationDemo2", "PlotOrientationDemo2.java"));
        return defaultMutableTreeNode;
    }

    private void displayDescription(String string) {
        URL uRL = SuperDemo.class.getResource(string);
        if (uRL != null) {
            try {
                this.descriptionPane.setPage(uRL);
            }
            catch (IOException iOException) {
                System.err.println("Attempted to read a bad URL: " + uRL);
            }
        } else {
            System.err.println("Couldn't find file: " + string);
        }
    }

    @Override
    public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
        String string = null;
        TreePath treePath = treeSelectionEvent.getPath();
        Object object = treePath.getLastPathComponent();
        if (object != null) {
            DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode)object;
            Object object2 = defaultMutableTreeNode.getUserObject();
            if (object2 instanceof DemoDescription) {
                DemoDescription demoDescription = (DemoDescription)object2;
                string = demoDescription.getDescription();
                this.updateSourceCodePanel(string);
                SwingUtilities.invokeLater(new DisplayDemo(this, demoDescription));
            } else {
                this.chartContainer.removeAll();
                this.chartContainer.add(this.createNoDemoSelectedPanel());
                this.displayPanel.validate();
                this.displayDescription("select.html");
                this.updateSourceCodePanel(null);
            }
        }
    }

    private JPanel createNoDemoSelectedPanel() {
        JPanel jPanel = new JPanel(new FlowLayout()){

            @Override
            public String getToolTipText() {
                return "(" + this.getWidth() + ", " + this.getHeight() + ")";
            }
        };
        ToolTipManager.sharedInstance().registerComponent(jPanel);
        jPanel.add(new JLabel("No demo selected"));
        jPanel.setPreferredSize(new Dimension(600, 400));
        return jPanel;
    }

    public static void main(String[] arrstring) {
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                }
                catch (Exception exception) {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    }
                    catch (Exception exception2) {
                        exception2.printStackTrace();
                    }
                }
                ChartFactory.setChartTheme((ChartTheme)new StandardChartTheme("JFree/Shadow", true));
                SuperDemo superDemo = new SuperDemo("JFreeChart 1.0.19 Demo Collection");
                superDemo.pack();
                RefineryUtilities.centerFrameOnScreen((Window)((Object)superDemo));
                superDemo.setVisible(true);
            }
        });
    }

    static class DisplayDemo
    implements Runnable {
        private SuperDemo app;
        private DemoDescription demoDescription;

        public DisplayDemo(SuperDemo superDemo, DemoDescription demoDescription) {
            this.app = superDemo;
            this.demoDescription = demoDescription;
        }

        @Override
        public void run() {
            try {
                String string;
                Class class_ = Class.forName(this.demoDescription.getClassName());
                Method method = class_.getDeclaredMethod("createDemoPanel", null);
                JPanel jPanel = (JPanel)method.invoke(null, null);
                this.app.chartContainer.removeAll();
                this.app.chartContainer.add(jPanel);
                this.app.displayPanel.validate();
                String string2 = string = class_.getName();
                int n = string.lastIndexOf(46);
                if (n > 0) {
                    string2 = string.substring(n + 1);
                }
                string2 = string2 + ".html";
                this.app.displayDescription(string2);
            }
            catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
            catch (NoSuchMethodException noSuchMethodException) {
                noSuchMethodException.printStackTrace();
            }
            catch (InvocationTargetException invocationTargetException) {
                invocationTargetException.printStackTrace();
            }
            catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }
        }
    }

    static class PDFExportTask
    implements Runnable {
        JFreeChart chart;
        int width;
        int height;
        File file;

        public PDFExportTask(JFreeChart jFreeChart, int n, int n2, File file) {
            this.chart = jFreeChart;
            this.file = file;
            this.width = n;
            this.height = n2;
            jFreeChart.setBorderVisible(true);
            jFreeChart.setPadding(new RectangleInsets(2.0, 2.0, 2.0, 2.0));
        }

        @Override
        public void run() {
            try {
                SuperDemo.saveChartAsPDF(this.file, this.chart, this.width, this.height);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

}

