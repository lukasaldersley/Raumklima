/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.CategoryAxis
 *  org.jfree.chart.axis.CategoryLabelPositions
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.CategoryPlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.category.DefaultCategoryDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import demo.DemoPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class CategoryLabelPositionsDemo1
extends ApplicationFrame {
    static JFreeChart chart;
    static JCheckBox invertCheckBox;
    static JRadioButton horizontalRadioButton;
    static JRadioButton verticalRadioButton;
    static JSlider slider;

    public CategoryLabelPositionsDemo1(String string) {
        super(string);
        JPanel jPanel = CategoryLabelPositionsDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 350));
        this.setContentPane((Container)jPanel);
    }

    private static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jFreeChart = ChartFactory.createBarChart((String)"CategoryLabelPositionsDemo1", (String)"Category", (String)"Value", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)false, (boolean)false, (boolean)false);
        CategoryPlot categoryPlot = (CategoryPlot)jFreeChart.getPlot();
        CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
        categoryAxis.setMaximumCategoryLabelLines(Integer.MAX_VALUE);
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions((double)0.7853981633974483));
        return jFreeChart;
    }

    public static CategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(1.0, (Comparable)((Object)"R1"), (Comparable)((Object)"Category 1 (Long)"));
        defaultCategoryDataset.addValue(5.0, (Comparable)((Object)"R1"), (Comparable)((Object)"Category 2 (Long)"));
        defaultCategoryDataset.addValue(3.0, (Comparable)((Object)"R1"), (Comparable)((Object)"Category 3 (Long)"));
        defaultCategoryDataset.addValue(2.0, (Comparable)((Object)"R1"), (Comparable)((Object)"Category 4 (Long)"));
        defaultCategoryDataset.addValue(9.0, (Comparable)((Object)"R1"), (Comparable)((Object)"Category 5 (Long)"));
        defaultCategoryDataset.addValue(7.0, (Comparable)((Object)"R1"), (Comparable)((Object)"Category 6 (Long)"));
        defaultCategoryDataset.addValue(6.0, (Comparable)((Object)"R1"), (Comparable)((Object)"Category 7 (Long)"));
        defaultCategoryDataset.addValue(8.0, (Comparable)((Object)"R1"), (Comparable)((Object)"Category 8 (Long)"));
        return defaultCategoryDataset;
    }

    public static JPanel createDemoPanel() {
        CategoryDataset categoryDataset = CategoryLabelPositionsDemo1.createDataset();
        chart = CategoryLabelPositionsDemo1.createChart(categoryDataset);
        DemoPanel demoPanel = new DemoPanel(new BorderLayout());
        JPanel jPanel = new JPanel(new BorderLayout());
        JPanel jPanel2 = new JPanel();
        invertCheckBox = new JCheckBox("Invert Range Axis?");
        invertCheckBox.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                CategoryPlot categoryPlot = (CategoryPlot)CategoryLabelPositionsDemo1.chart.getPlot();
                categoryPlot.getRangeAxis().setInverted(CategoryLabelPositionsDemo1.invertCheckBox.isSelected());
            }
        });
        jPanel2.add(invertCheckBox);
        ButtonGroup buttonGroup = new ButtonGroup();
        horizontalRadioButton = new JRadioButton("Horizontal", false);
        horizontalRadioButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (CategoryLabelPositionsDemo1.horizontalRadioButton.isSelected()) {
                    CategoryPlot categoryPlot = (CategoryPlot)CategoryLabelPositionsDemo1.chart.getPlot();
                    categoryPlot.setOrientation(PlotOrientation.HORIZONTAL);
                }
            }
        });
        buttonGroup.add(horizontalRadioButton);
        verticalRadioButton = new JRadioButton("Vertical", true);
        verticalRadioButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (CategoryLabelPositionsDemo1.verticalRadioButton.isSelected()) {
                    CategoryPlot categoryPlot = (CategoryPlot)CategoryLabelPositionsDemo1.chart.getPlot();
                    categoryPlot.setOrientation(PlotOrientation.VERTICAL);
                }
            }
        });
        buttonGroup.add(verticalRadioButton);
        jPanel2.add(horizontalRadioButton);
        jPanel2.add(verticalRadioButton);
        jPanel2.setBorder(new TitledBorder("Plot Settings: "));
        JPanel jPanel3 = new JPanel(new BorderLayout());
        slider = new JSlider(0, 90, 45);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.addChangeListener(new ChangeListener(){

            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                CategoryPlot categoryPlot = (CategoryPlot)CategoryLabelPositionsDemo1.chart.getPlot();
                CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
                categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions((double)((double)CategoryLabelPositionsDemo1.slider.getValue() * 3.141592653589793 / 180.0)));
            }
        });
        jPanel3.add(slider);
        jPanel3.setBorder(new TitledBorder("Axis Label Rotation Angle:"));
        jPanel.add("North", jPanel2);
        jPanel.add(jPanel3);
        demoPanel.add((Component)new ChartPanel(chart));
        demoPanel.addChart(chart);
        demoPanel.add("South", jPanel);
        return demoPanel;
    }

    public static void main(String[] arrstring) {
        CategoryLabelPositionsDemo1 categoryLabelPositionsDemo1 = new CategoryLabelPositionsDemo1("JFreeChart: CategoryLabelPositionsDemo1.java");
        categoryLabelPositionsDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)categoryLabelPositionsDemo1));
        categoryLabelPositionsDemo1.setVisible(true);
    }

}

