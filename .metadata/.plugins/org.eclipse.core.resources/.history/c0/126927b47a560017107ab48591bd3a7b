/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.Chart3D
 *  com.orsoncharts.Chart3DPanel
 *  com.orsoncharts.graphics3d.Drawable3D
 *  com.orsoncharts.style.ChartStyle
 *  com.orsoncharts.style.ChartStyles
 *  org.jfree.graphics2d.svg.SVGGraphics2D
 *  org.jfree.graphics2d.svg.SVGUtils
 */
package demo.orsoncharts.swing;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.graphics3d.Drawable3D;
import com.orsoncharts.style.ChartStyle;
import com.orsoncharts.style.ChartStyles;
import demo.orsoncharts.swing.DemoPanel;
import demo.orsoncharts.swing.ExitOnClose;
import demo.orsoncharts.swing.OrsonChartsDemoComponent;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import org.jfree.graphics2d.svg.SVGGraphics2D;
import org.jfree.graphics2d.svg.SVGUtils;

public class OrsonChartsDemo
extends JFrame
implements ActionListener {
    public static final Dimension DEFAULT_CONTENT_SIZE = new Dimension(760, 480);
    private OrsonChartsDemoComponent demoComponent;

    public OrsonChartsDemo(String string) {
        super(string);
        this.addWindowListener(new ExitOnClose());
        this.setJMenuBar(this.createMenuBar());
        this.add(this.createContent());
    }

    private JMenuBar createMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.add(this.createFileMenu("File"));
        jMenuBar.add(this.createStyleMenu("Style"));
        return jMenuBar;
    }

    private JMenu createFileMenu(String string) {
        JMenu jMenu = new JMenu(string);
        JMenuItem jMenuItem = new JMenuItem("Exit");
        jMenuItem.setActionCommand("EXIT");
        jMenuItem.addActionListener(this);
        jMenu.add(jMenuItem);
        return jMenu;
    }

    private JMenu createStyleMenu(String string) {
        JMenu jMenu = new JMenu(string);
        JRadioButtonMenuItem jRadioButtonMenuItem = new JRadioButtonMenuItem("No Style (style as coded)");
        jRadioButtonMenuItem.setActionCommand("NO_STYLE");
        jRadioButtonMenuItem.addActionListener(this);
        JRadioButtonMenuItem jRadioButtonMenuItem2 = new JRadioButtonMenuItem("Orson 1 Style");
        jRadioButtonMenuItem2.setActionCommand("ORSON1_STYLE");
        jRadioButtonMenuItem2.addActionListener(this);
        JRadioButtonMenuItem jRadioButtonMenuItem3 = new JRadioButtonMenuItem("Orson 2 Style");
        jRadioButtonMenuItem3.setActionCommand("ORSON2_STYLE");
        jRadioButtonMenuItem3.addActionListener(this);
        JRadioButtonMenuItem jRadioButtonMenuItem4 = new JRadioButtonMenuItem("Ice Cube Style");
        jRadioButtonMenuItem4.setActionCommand("ICE_CUBE_STYLE");
        jRadioButtonMenuItem4.addActionListener(this);
        JRadioButtonMenuItem jRadioButtonMenuItem5 = new JRadioButtonMenuItem("Pastel");
        jRadioButtonMenuItem5.setActionCommand("PASTEL_STYLE");
        jRadioButtonMenuItem5.addActionListener(this);
        JRadioButtonMenuItem jRadioButtonMenuItem6 = new JRadioButtonMenuItem("Logical Font Style");
        jRadioButtonMenuItem6.setActionCommand("LOGICAL_FONT_STYLE");
        jRadioButtonMenuItem6.addActionListener(this);
        jMenu.add(jRadioButtonMenuItem);
        jMenu.add(jRadioButtonMenuItem2);
        jMenu.add(jRadioButtonMenuItem3);
        jMenu.add(jRadioButtonMenuItem4);
        jMenu.add(jRadioButtonMenuItem5);
        jMenu.add(jRadioButtonMenuItem6);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButtonMenuItem);
        buttonGroup.add(jRadioButtonMenuItem2);
        buttonGroup.add(jRadioButtonMenuItem3);
        buttonGroup.add(jRadioButtonMenuItem4);
        buttonGroup.add(jRadioButtonMenuItem5);
        buttonGroup.add(jRadioButtonMenuItem6);
        jRadioButtonMenuItem.setSelected(true);
        return jMenu;
    }

    private JComponent createContent() {
        JTabbedPane jTabbedPane = new JTabbedPane();
        this.demoComponent = new OrsonChartsDemoComponent();
        jTabbedPane.add("Demos", this.demoComponent);
        jTabbedPane.add("About", this.createAboutPanel());
        return jTabbedPane;
    }

    private JPanel createAboutPanel() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        JTextPane jTextPane = new JTextPane();
        jTextPane.setEditable(false);
        jTextPane.setPreferredSize(new Dimension(800, 400));
        URL uRL = OrsonChartsDemo.class.getResource("/demo/orsoncharts/about.html");
        try {
            jTextPane.setPage(uRL);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        JScrollPane jScrollPane = new JScrollPane(jTextPane);
        jPanel.add(jScrollPane);
        return jPanel;
    }

    private void applyStyleToChartsInPanels(List<Chart3DPanel> list, ChartStyle chartStyle) {
        for (Chart3DPanel chart3DPanel : list) {
            Chart3D chart3D = (Chart3D)chart3DPanel.getDrawable();
            ChartStyle chartStyle2 = chartStyle.clone();
            chart3D.setStyle(chartStyle2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Component component;
        if ("EXIT".equals(actionEvent.getActionCommand())) {
            System.exit(0);
        }
        if ((component = this.demoComponent.getChartContainer().getComponent(0)) instanceof DemoPanel) {
            DemoPanel demoPanel = (DemoPanel)component;
            List<Chart3DPanel> list = demoPanel.getChartPanels();
            if ("NO_STYLE".equals(actionEvent.getActionCommand())) {
                this.demoComponent.setChartStyle(null);
                int n = this.demoComponent.getWidth();
                int n2 = this.demoComponent.getHeight();
                SVGGraphics2D sVGGraphics2D = new SVGGraphics2D(n, n2);
                this.demoComponent.paint((Graphics)sVGGraphics2D);
                try {
                    SVGUtils.writeToSVG((File)new File("test.svg"), (String)sVGGraphics2D.getSVGElement());
                }
                catch (IOException iOException) {
                    // empty catch block
                }
            }
            if ("ORSON1_STYLE".equals(actionEvent.getActionCommand())) {
                this.demoComponent.setChartStyle(ChartStyles.createOrson1Style());
                this.applyStyleToChartsInPanels(list, ChartStyles.createOrson1Style());
            }
            if ("ORSON2_STYLE".equals(actionEvent.getActionCommand())) {
                this.demoComponent.setChartStyle(ChartStyles.createOrson2Style());
                this.applyStyleToChartsInPanels(list, ChartStyles.createOrson2Style());
            }
            if ("ICE_CUBE_STYLE".equals(actionEvent.getActionCommand())) {
                this.demoComponent.setChartStyle(ChartStyles.createIceCubeStyle());
                this.applyStyleToChartsInPanels(list, ChartStyles.createIceCubeStyle());
            }
            if ("PASTEL_STYLE".equals(actionEvent.getActionCommand())) {
                this.demoComponent.setChartStyle(ChartStyles.createPastelStyle());
                this.applyStyleToChartsInPanels(list, ChartStyles.createPastelStyle());
            }
            if ("LOGICAL_FONT_STYLE".equals(actionEvent.getActionCommand())) {
                this.demoComponent.setChartStyle(ChartStyles.createLogicalFontStyle());
                this.applyStyleToChartsInPanels(list, ChartStyles.createLogicalFontStyle());
            }
        }
    }

    public static void main(String[] arrstring) {
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                for (UIManager.LookAndFeelInfo lookAndFeelInfo : UIManager.getInstalledLookAndFeels()) {
                    if (!"Nimbus".equals(lookAndFeelInfo.getName())) continue;
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    }
                    catch (Exception exception) {
                        try {
                            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                        }
                        catch (Exception exception2) {
                            // empty catch block
                        }
                    }
                }
                OrsonChartsDemo orsonChartsDemo = new OrsonChartsDemo("Orson Charts Demo 1.4");
                orsonChartsDemo.pack();
                orsonChartsDemo.setVisible(true);
            }
        });
    }

}

