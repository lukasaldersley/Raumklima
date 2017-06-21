/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.data.jdbc.JDBCXYDataset
 *  org.jfree.data.xy.XYDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Paint;
import java.awt.Window;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.jdbc.JDBCXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class JDBCXYChartDemo
extends ApplicationFrame {
    public JDBCXYChartDemo(String string) {
        super(string);
        XYDataset xYDataset = this.readData();
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart((String)"JDBC XY Chart Demo", (String)"Date", (String)"Value", (XYDataset)xYDataset, (boolean)true, (boolean)true, (boolean)false);
        jFreeChart.setBackgroundPaint((Paint)Color.yellow);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        this.setContentPane((Container)chartPanel);
    }

    private XYDataset readData() {
        JDBCXYDataset jDBCXYDataset = null;
        String string = "jdbc:postgresql://nomad/jfreechartdb";
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException classNotFoundException) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(classNotFoundException.getMessage());
        }
        try {
            Connection connection = DriverManager.getConnection(string, "jfreechart", "password");
            jDBCXYDataset = new JDBCXYDataset(connection);
            String string2 = "SELECT * FROM XYDATA1;";
            jDBCXYDataset.executeQuery(string2);
            connection.close();
        }
        catch (SQLException sQLException) {
            System.err.print("SQLException: ");
            System.err.println(sQLException.getMessage());
        }
        catch (Exception exception) {
            System.err.print("Exception: ");
            System.err.println(exception.getMessage());
        }
        return jDBCXYDataset;
    }

    public static void main(String[] arrstring) {
        JDBCXYChartDemo jDBCXYChartDemo = new JDBCXYChartDemo("JDBC XY Chart Demo");
        jDBCXYChartDemo.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)jDBCXYChartDemo));
        jDBCXYChartDemo.setVisible(true);
    }
}

