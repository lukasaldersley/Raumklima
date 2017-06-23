/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.graphics3d.DefaultDrawable3D
 *  com.orsoncharts.graphics3d.Drawable3D
 *  com.orsoncharts.graphics3d.Object3D
 *  com.orsoncharts.graphics3d.Point3D
 *  com.orsoncharts.graphics3d.Rotate3D
 *  com.orsoncharts.graphics3d.ViewPoint3D
 *  com.orsoncharts.graphics3d.World
 *  com.orsoncharts.graphics3d.swing.DisplayPanel3D
 *  com.orsoncharts.graphics3d.swing.Panel3D
 */
package demo.orsoncharts.swing;

import com.orsoncharts.graphics3d.DefaultDrawable3D;
import com.orsoncharts.graphics3d.Drawable3D;
import com.orsoncharts.graphics3d.Object3D;
import com.orsoncharts.graphics3d.Point3D;
import com.orsoncharts.graphics3d.Rotate3D;
import com.orsoncharts.graphics3d.ViewPoint3D;
import com.orsoncharts.graphics3d.World;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;
import com.orsoncharts.graphics3d.swing.Panel3D;
import demo.orsoncharts.swing.ExitOnClose;
import demo.orsoncharts.swing.OrsonChartsDemo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ViewPoint3DDemo
extends JFrame {
    List<Point3D> xlist;
    List<Point3D> ylist;
    List<Point3D> zlist;
    Panel3D panel3D;

    public ViewPoint3DDemo(String string) {
        super(string);
        this.addWindowListener(new ExitOnClose());
        this.getContentPane().add(this.createDemoPanel());
    }

    public final JPanel createDemoPanel() {
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setPreferredSize(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        World world = new World();
        world.add(Object3D.createCube((double)1.0, (double)0.0, (double)0.0, (double)0.0, (Color)Color.BLUE));
        ViewPoint3D viewPoint3D = new ViewPoint3D(new Point3D(10.0, 10.0, 10.0), 0.0);
        this.xlist = this.addRing(true, world, new Point3D(0.0, 5.0, 0.0), Point3D.UNIT_X, Color.GREEN);
        this.ylist = this.addRing(true, world, new Point3D(0.0, 0.0, 5.0), Point3D.UNIT_Y, Color.ORANGE);
        this.zlist = this.addRing(true, world, new Point3D(0.0, 5.0, 0.0), Point3D.UNIT_Z, Color.RED);
        DefaultDrawable3D defaultDrawable3D = new DefaultDrawable3D(world);
        this.panel3D = new Panel3D((Drawable3D)defaultDrawable3D);
        this.panel3D.setViewPoint(viewPoint3D);
        jPanel.add((Component)new DisplayPanel3D(this.panel3D));
        return jPanel;
    }

    private List<Point3D> addRing(boolean bl, World world, Point3D point3D, Point3D point3D2, Color color) {
        boolean bl2 = true;
        ArrayList<Point3D> arrayList = new ArrayList<Point3D>();
        Rotate3D rotate3D = new Rotate3D(Point3D.ORIGIN, point3D2, 0.0);
        for (int i = 0; i < 60; ++i) {
            rotate3D.setAngle(0.10471975511965977 * (double)i);
            Point3D point3D3 = rotate3D.applyRotation(point3D);
            arrayList.add(point3D3);
            if (!bl) continue;
            if (bl2) {
                world.add(Object3D.createCube((double)0.2, (double)point3D3.x, (double)point3D3.y, (double)point3D3.z, (Color)Color.RED));
                bl2 = false;
                continue;
            }
            world.add(Object3D.createCube((double)0.2, (double)point3D3.x, (double)point3D3.y, (double)point3D3.z, (Color)color));
        }
        return arrayList;
    }

    public static void main(String[] arrstring) {
        ViewPoint3DDemo viewPoint3DDemo = new ViewPoint3DDemo("OrsonCharts: ViewPointDemo.java");
        viewPoint3DDemo.pack();
        viewPoint3DDemo.setVisible(true);
    }
}

