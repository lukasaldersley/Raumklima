/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsoncharts.Chart3DPanel
 */
package demo.orsoncharts.swing;

import com.orsoncharts.Chart3DPanel;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class DemoPanel
extends JPanel {
    private List<Chart3DPanel> chartPanels = new ArrayList<Chart3DPanel>();

    public DemoPanel(LayoutManager layoutManager) {
        super(layoutManager);
    }

    public Chart3DPanel getChartPanel() {
        if (this.chartPanels.isEmpty()) {
            return null;
        }
        return this.chartPanels.get(0);
    }

    public List<Chart3DPanel> getChartPanels() {
        return this.chartPanels;
    }

    public void setChartPanel(Chart3DPanel chart3DPanel) {
        this.chartPanels.clear();
        this.chartPanels.add(chart3DPanel);
    }

    public void addChartPanel(Chart3DPanel chart3DPanel) {
        this.chartPanels.add(chart3DPanel);
    }
}

