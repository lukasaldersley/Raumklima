/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.plot.PiePlot3D
 */
package demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import org.jfree.chart.plot.PiePlot3D;

class Rotator
extends Timer
implements ActionListener {
    private PiePlot3D plot;
    private int angle = 270;

    Rotator(PiePlot3D piePlot3D) {
        super(100, null);
        this.plot = piePlot3D;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.plot.setStartAngle((double)this.angle);
        ++this.angle;
        if (this.angle == 360) {
            this.angle = 0;
        }
    }
}

