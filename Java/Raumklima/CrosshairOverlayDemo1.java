package Raumklima;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.panel.CrosshairOverlay;
import org.jfree.chart.plot.Crosshair;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleEdge;

/**
 * A demo showing crosshairs that follow the data points on an XYPlot.
 */
public class CrosshairOverlayDemo1 implements ChartMouseListener {
    private ChartPanel chartPanel;
    private Crosshair xCrosshair;
    private Crosshair yCrosshair;
    private JFrame window;

    public CrosshairOverlayDemo1() {
        window=new JFrame("JFreeChart: CrosshairOverlayDemo1.java");
        window.setContentPane(createContent());
        
        window.pack();
        window.setVisible(true);
    }

    private JPanel createContent() {
        JFreeChart chart = createChart(createDataset());
        this.chartPanel = new ChartPanel(chart);
        this.chartPanel.addChartMouseListener(this);
        CrosshairOverlay crosshairOverlay = new CrosshairOverlay();
        this.xCrosshair = new Crosshair(Double.NaN, Color.GRAY, new BasicStroke(0f));
        this.xCrosshair.setLabelVisible(true);
        this.yCrosshair = new Crosshair(Double.NaN, Color.GRAY, new BasicStroke(0f));
        this.yCrosshair.setLabelVisible(true);
        crosshairOverlay.addDomainCrosshair(xCrosshair);
        crosshairOverlay.addRangeCrosshair(yCrosshair);
        chartPanel.addOverlay(crosshairOverlay);
        return chartPanel;
    }

    private JFreeChart createChart(XYDataset dataset) {
        JFreeChart chart = ChartFactory.createXYLineChart("Crosshair Demo", "X", "Y", dataset);
        return chart;
    }

    private XYDataset createDataset() {
        XYSeries series1 = new XYSeries("S1");
        XYSeries series2=new XYSeries("S2");
        int anz=2000;
        for (int x = 0; x < anz; x++) {
            series1.add(x, x + Math.random() * 40.0);
            System.out.print(x + Math.random() * 40.0);
            System.out.print(";");
            series2.add(x,(anz-x)+Math.random()*40.0);
            System.out.println((anz-x)+Math.random()*40.0);
        }
        XYSeriesCollection dataset = new XYSeriesCollection(/*series1*/);
        dataset.addSeries(series2);
        return dataset;
    }

    @Override
    public void chartMouseClicked(ChartMouseEvent event) {
        // ignore
    }

    @Override
    public void chartMouseMoved(ChartMouseEvent event) {
        Rectangle2D dataArea = this.chartPanel.getScreenDataArea();
        JFreeChart chart = event.getChart();
        //XYPlot plot = (XYPlot) chart.getPlot();
        XYPlot plot=chart.getXYPlot();
        ValueAxis xAxis = plot.getDomainAxis();
        double x = xAxis.java2DToValue(event.getTrigger().getX(), dataArea, 
                RectangleEdge.BOTTOM);
        double y = DatasetUtilities.findYValue(plot.getDataset(), 0, x);
        this.xCrosshair.setValue(x);
        this.yCrosshair.setValue(y);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    CrosshairOverlayDemo1 app = new CrosshairOverlayDemo1();
                }
            });
    }

}