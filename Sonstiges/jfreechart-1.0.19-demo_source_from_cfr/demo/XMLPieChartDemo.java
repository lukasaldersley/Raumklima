/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.labels.PieSectionLabelGenerator
 *  org.jfree.chart.labels.StandardPieSectionLabelGenerator
 *  org.jfree.chart.plot.PiePlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.data.general.PieDataset
 *  org.jfree.data.xml.DatasetReader
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Window;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.text.NumberFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xml.DatasetReader;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XMLPieChartDemo
extends ApplicationFrame {
    public XMLPieChartDemo(String string) {
        InputStream inputStream;
        super(string);
        PieDataset pieDataset = null;
        URL uRL = this.getClass().getResource("/org/jfree/chart/demo/piedata.xml");
        try {
            inputStream = uRL.openStream();
            pieDataset = DatasetReader.readPieDatasetFromXML((InputStream)inputStream);
        }
        catch (IOException iOException) {
            System.out.println(iOException.getMessage());
        }
        inputStream = ChartFactory.createPieChart((String)"Pie Chart Demo 1", (PieDataset)pieDataset, (boolean)true, (boolean)true, (boolean)false);
        inputStream.setBackgroundPaint((Paint)Color.yellow);
        PiePlot piePlot = (PiePlot)inputStream.getPlot();
        piePlot.setLabelGenerator((PieSectionLabelGenerator)new StandardPieSectionLabelGenerator("{0} = {2}", NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance()));
        piePlot.setNoDataMessage("No data available");
        ChartPanel chartPanel = new ChartPanel((JFreeChart)inputStream);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)chartPanel);
    }

    public static void main(String[] arrstring) {
        XMLPieChartDemo xMLPieChartDemo = new XMLPieChartDemo("XML Pie Chart Demo");
        xMLPieChartDemo.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)xMLPieChartDemo));
        xMLPieChartDemo.setVisible(true);
    }
}

