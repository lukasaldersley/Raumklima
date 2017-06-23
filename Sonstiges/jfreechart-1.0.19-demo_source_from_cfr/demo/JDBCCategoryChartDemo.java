/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.plot.PlotOrientation
 *  org.jfree.data.category.CategoryDataset
 *  org.jfree.data.jdbc.JDBCCategoryDataset
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
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class JDBCCategoryChartDemo
extends ApplicationFrame {
    public JDBCCategoryChartDemo(String string) {
        super(string);
        CategoryDataset categoryDataset = this.readData();
        JFreeChart jFreeChart = ChartFactory.createBarChart3D((String)"JDBC Category Chart Demo", (String)"Category", (String)"Value", (CategoryDataset)categoryDataset, (PlotOrientation)PlotOrientation.VERTICAL, (boolean)true, (boolean)true, (boolean)false);
        jFreeChart.setBackgroundPaint((Paint)Color.yellow);
        ChartPanel chartPanel = new ChartPanel(jFreeChart);
        this.setContentPane((Container)chartPanel);
    }

    private CategoryDataset readData() {
        JDBCCategoryDataset jDBCCategoryDataset = null;
        String string = "jdbc:postgresql://localhost/jfreechartdb";
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException classNotFoundException) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(classNotFoundException.getMessage());
        }
        try {
            Connection connection = DriverManager.getConnection(string, "jfreechart", "password");
            jDBCCategoryDataset = new JDBCCategoryDataset(connection);
            String string2 = "SELECT * FROM CATEGORYDATA1;";
            System.out.println("Once...");
            jDBCCategoryDataset.executeQuery(string2);
            System.out.println("Again...");
            jDBCCategoryDataset.executeQuery(string2);
            System.out.println("Done.");
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
        return jDBCCategoryDataset;
    }

    public static void main(String[] arrstring) {
        JDBCCategoryChartDemo jDBCCategoryChartDemo = new JDBCCategoryChartDemo("JDBC Category Chart Demo");
        jDBCCategoryChartDemo.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)jDBCCategoryChartDemo));
        jDBCCategoryChartDemo.setVisible(true);
    }
}

