/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.xml.DatasetReader
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.xml.DatasetReader;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XMLBarChartDemo
extends ApplicationFrame {
    public XMLBarChartDemo(String string) {
        InputStream inputStream;
        super(string);
        CategoryDataset categoryDataset = null;
        URL uRL = this.getClass().getResource("/demo/categorydata.xml");
        try {
            inputStream = uRL.openStream();
            categoryDataset = DatasetReader.readCategoryDatasetFromXML((InputStream)inputStream);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        inputStream = ChartFactory.createBarChart((String)"Bar Chart", (String)"Domain", (String)"Range", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        ChartPanel chartPanel = new ChartPanel((JFreeChart)inputStream);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)chartPanel);
    }

    public static void main(String[] arrstring) {
        XMLBarChartDemo xMLBarChartDemo = new XMLBarChartDemo("XML Bar Chart Demo");
        xMLBarChartDemo.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)xMLBarChartDemo));
        xMLBarChartDemo.setVisible(true);
    }
}

