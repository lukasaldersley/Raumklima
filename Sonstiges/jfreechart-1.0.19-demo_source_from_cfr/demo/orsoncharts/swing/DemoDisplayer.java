/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.Chart3D
 *  com.orsoncharts.Chart3DPanel
 *  com.orsoncharts.graphics3d.Drawable3D
 *  com.orsoncharts.style.ChartStyle
 */
package demo.orsoncharts.swing;

import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DPanel;
import com.orsoncharts.graphics3d.Drawable3D;
import com.orsoncharts.style.ChartStyle;
import demo.orsoncharts.DemoDescription;
import demo.orsoncharts.swing.DemoPanel;
import demo.orsoncharts.swing.OrsonChartsDemo;
import demo.orsoncharts.swing.OrsonChartsDemoComponent;
import java.awt.Color;
import java.awt.Component;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.Border;

public class DemoDisplayer
implements Runnable {
    private OrsonChartsDemoComponent demoComp;
    private DemoDescription demoDescription;

    public DemoDisplayer(OrsonChartsDemoComponent orsonChartsDemoComponent, DemoDescription demoDescription) {
        this.demoComp = orsonChartsDemoComponent;
        this.demoDescription = demoDescription;
    }

    @Override
    public void run() {
        try {
            Object object;
            Object object2;
            Class class_ = Class.forName(this.demoDescription.getClassName());
            Method method = class_.getDeclaredMethod("createDemoPanel", null);
            JPanel jPanel = (JPanel)method.invoke(null, null);
            jPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4), BorderFactory.createLineBorder(Color.BLACK)));
            this.demoComp.getChartContainer().removeAll();
            this.demoComp.getChartContainer().add(jPanel);
            this.demoComp.getChartContainer().validate();
            if (jPanel instanceof DemoPanel) {
                object2 = (DemoPanel)jPanel;
                object = object2.getChartPanels().iterator();
                while (object.hasNext()) {
                    Chart3DPanel chart3DPanel = (Chart3DPanel)object.next();
                    if (this.demoComp.getChartStyle() != null) {
                        Chart3D chart3D = (Chart3D)chart3DPanel.getDrawable();
                        chart3D.setStyle(this.demoComp.getChartStyle());
                    }
                    chart3DPanel.zoomToFit();
                }
            }
            if ((object = OrsonChartsDemo.class.getResource((String)(object2 = this.demoDescription.getDescriptionFileName()))) != null) {
                try {
                    this.demoComp.getChartDescriptionPane().setPage((URL)object);
                }
                catch (IOException iOException) {
                    System.err.println("Attempted to read a bad URL: " + object);
                }
            }
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

