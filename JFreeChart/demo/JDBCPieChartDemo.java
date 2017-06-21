/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.PiePlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.data.general.PieDataset
 *  org.jfree.data.jdbc.JDBCPieDataset
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
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.data.general.PieDataset;
import org.jfree.data.jdbc.JDBCPieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class JDBCPieChartDemo
extends ApplicationFrame {
    public JDBCPieChartDemo(String string) {
        super(string);
        PieDataset pieDataset = this.readData();
        JFreeChart jFreeChart = ChartFactory.createPieChart((String)"JDBC Pie Chart Demo", (PieDataset)pieDataset, (boolean)true, (boolean)true, (boolean)false);
        jFreeChart.setBackgroundPaint((Paint)Color.yellow);
        PiePlot piePlot = (PiePlot)jFreeChart.getPlot();
        piePlot.setNoDataMessage("No data available");
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        this.setContentPane((Container)chartPanel);
    }

    private PieDataset readData() {
        JDBCPieDataset jDBCPieDataset = null;
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
            jDBCPieDataset = new JDBCPieDataset(connection);
            String string2 = "SELECT * FROM PIEDATA1;";
            jDBCPieDataset.executeQuery(string2);
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
        return jDBCPieDataset;
    }

    public static void main(String[] arrstring) {
        JDBCPieChartDemo jDBCPieChartDemo = new JDBCPieChartDemo("JDBC Pie Chart Demo");
        jDBCPieChartDemo.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)jDBCPieChartDemo));
        jDBCPieChartDemo.setVisible(true);
    }
}

