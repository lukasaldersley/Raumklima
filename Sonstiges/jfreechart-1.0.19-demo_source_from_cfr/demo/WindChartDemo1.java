/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.JFreeChart
 *  org.jfree.data.xy.DefaultWindDataset
 *  org.jfree.data.xy.WindDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.DefaultWindDataset;
import org.jfree.data.xy.WindDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class WindChartDemo1
extends ApplicationFrame {
    public WindChartDemo1(String string) {
        super(string);
        JPanel jPanel = WindChartDemo1.createDemoPanel();
        jPanel.setPreferredSize(new Dimension(500, 270));
        this.setContentPane((Container)jPanel);
    }

    private static long millisForDate(int n, int n2, int n3) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(n3, n2 - 1, n, 12, 0);
        return calendar.getTimeInMillis();
    }

    private static Object[] createItem(long l, int n, int n2) {
        return new Object[]{new Date(l), new Integer(n), new Integer(n2)};
    }

    public static WindDataset createDataset() {
        Object[] arrobject = WindChartDemo1.createItem(WindChartDemo1.millisForDate(3, 1, 1999), 0, 10);
        Object[] arrobject2 = WindChartDemo1.createItem(WindChartDemo1.millisForDate(4, 1, 1999), 1, 8);
        Object[] arrobject3 = WindChartDemo1.createItem(WindChartDemo1.millisForDate(5, 1, 1999), 2, 10);
        Object[] arrobject4 = WindChartDemo1.createItem(WindChartDemo1.millisForDate(6, 1, 1999), 3, 10);
        Object[] arrobject5 = WindChartDemo1.createItem(WindChartDemo1.millisForDate(7, 1, 1999), 4, 7);
        Object[] arrobject6 = WindChartDemo1.createItem(WindChartDemo1.millisForDate(8, 1, 1999), 5, 10);
        Object[] arrobject7 = WindChartDemo1.createItem(WindChartDemo1.millisForDate(9, 1, 1999), 6, 8);
        Object[] arrobject8 = WindChartDemo1.createItem(WindChartDemo1.millisForDate(10, 1, 1999), 7, 11);
        Object[] arrobject9 = WindChartDemo1.createItem(WindChartDemo1.millisForDate(11, 1, 1999), 8, 10);
        Object[] arrobject10 = WindChartDemo1.createItem(WindChartDemo1.millisForDate(12, 1, 1999), 9, 11);
        Object[] arrobject11 = WindChartDemo1.createItem(WindChartDemo1.millisForDate(13, 1, 1999), 10, 3);
        Object[] arrobject12 = WindChartDemo1.createItem(WindChartDemo1.millisForDate(14, 1, 1999), 11, 9);
        Object[] arrobject13 = WindChartDemo1.createItem(WindChartDemo1.millisForDate(15, 1, 1999), 12, 11);
        Object[] arrobject14 = WindChartDemo1.createItem(WindChartDemo1.millisForDate(16, 1, 1999), 0, 0);
        Object[][] arrarrobject = new Object[][]{arrobject, arrobject2, arrobject3, arrobject4, arrobject5, arrobject6, arrobject7, arrobject8, arrobject9, arrobject10, arrobject11, arrobject12, arrobject13, arrobject14};
        Object[][][] arrobject15 = new Object[][][]{arrarrobject};
        return new DefaultWindDataset(arrobject15);
    }

    private static JFreeChart createChart(WindDataset windDataset) {
        JFreeChart jFreeChart = ChartFactory.createWindPlot((String)"Wind Chart Demo", (String)"Date", (String)"Direction / Force", (WindDataset)windDataset, (boolean)true, (boolean)false, (boolean)false);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        return new ChartPanel(WindChartDemo1.createChart(WindChartDemo1.createDataset()));
    }

    public static void main(String[] arrstring) {
        WindChartDemo1 windChartDemo1 = new WindChartDemo1("Wind Chart Demo 1");
        windChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)windChartDemo1));
        windChartDemo1.setVisible(true);
    }
}

