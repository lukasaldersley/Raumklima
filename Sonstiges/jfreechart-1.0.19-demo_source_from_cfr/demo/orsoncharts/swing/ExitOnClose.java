/*
 * Decompiled with CFR 0_122.
 */
package demo.orsoncharts.swing;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ExitOnClose
extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent windowEvent) {
        System.exit(0);
    }
}

