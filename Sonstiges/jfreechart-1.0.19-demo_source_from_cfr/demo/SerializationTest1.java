/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.axis.ValueAxis
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.plot.XYPlot
 *  org.jfree.data.time.Millisecond
 *  org.jfree.data.time.RegularTimePeriod
 *  org.jfree.data.time.TimeSeries
 *  org.jfree.data.time.TimeSeriesCollection
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class SerializationTest1
extends ApplicationFrame
implements ActionListener {
    private TimeSeries series = new TimeSeries((Comparable)((Object)"Random Data"));
    private double lastValue = 100.0;

    public SerializationTest1(String string) {
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        Object object;
        super(string);
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection(this.series);
        JFreeChart jFreeChart = this.createChart((XYDataset)timeSeriesCollection);
        JFreeChart jFreeChart2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject((Object)jFreeChart);
            objectOutputStream.close();
            jFreeChart = null;
            timeSeriesCollection = null;
            this.series = null;
            System.gc();
            object = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            jFreeChart2 = (JFreeChart)object.readObject();
            object.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        byteArrayOutputStream = (XYPlot)jFreeChart2.getPlot();
        objectOutputStream = (TimeSeriesCollection)byteArrayOutputStream.getDataset();
        this.series = objectOutputStream.getSeries(0);
        object = new ChartPanel(jFreeChart2);
        JButton jButton = new JButton("Add New Data Item");
        jButton.setActionCommand("ADD_DATA");
        jButton.addActionListener(this);
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.add((Component)object);
        jPanel.add((Component)jButton, "South");
        object.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private JFreeChart createChart(XYDataset xYDataset) {
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"Serialization Test 1", (String)"Time", (String)"Value", (XYDataset)xYDataset, (boolean)true, (boolean)true, (boolean)false);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        ValueAxis valueAxis = xYPlot.getDomainAxis();
        valueAxis.setAutoRange(true);
        valueAxis.setFixedAutoRange(60000.0);
        return jFreeChart;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("ADD_DATA")) {
            double d = 0.9 + 0.2 * Math.random();
            this.lastValue *= d;
            Millisecond millisecond = new Millisecond();
            System.out.println("Now = " + millisecond.toString());
            this.series.add((RegularTimePeriod)new Millisecond(), this.lastValue);
        }
    }

    public static void main(String[] arrstring) {
        SerializationTest1 serializationTest1 = new SerializationTest1("Serialization Test 1");
        serializationTest1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)serializationTest1));
        serializationTest1.setVisible(true);
    }
}

