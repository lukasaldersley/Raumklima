/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.chart.ChartFactory
 *  org.jfree.chart.ChartPanel
 *  org.jfree.chart.ChartUtilities
 *  org.jfree.chart.JFreeChart
 *  org.jfree.chart.LegendItemSource
 *  org.jfree.chart.block.Arrangement
 *  org.jfree.chart.block.Block
 *  org.jfree.chart.block.BlockBorder
 *  org.jfree.chart.block.BlockContainer
 *  org.jfree.chart.block.BlockFrame
 *  org.jfree.chart.block.BorderArrangement
 *  org.jfree.chart.block.LabelBlock
 *  org.jfree.chart.plot.PiePlot
 *  org.jfree.chart.plot.Plot
 *  org.jfree.chart.title.LegendTitle
 *  org.jfree.chart.title.Title
 *  org.jfree.data.general.DefaultPieDataset
 *  org.jfree.data.general.PieDataset
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.HorizontalAlignment
 *  org.jfree.ui.RectangleEdge
 *  org.jfree.ui.RefineryUtilities
 */
package demo;

import java.awt.Container;
import java.awt.Font;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItemSource;
import org.jfree.chart.block.Arrangement;
import org.jfree.chart.block.Block;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.BlockFrame;
import org.jfree.chart.block.BorderArrangement;
import org.jfree.chart.block.LabelBlock;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RefineryUtilities;

public class LegendWrapperDemo1
extends ApplicationFrame {
    public LegendWrapperDemo1(String string) {
        super(string);
        this.setContentPane((Container)LegendWrapperDemo1.createDemoPanel());
    }

    private static PieDataset createDataset() {
        DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
        defaultPieDataset.setValue((Comparable)((Object)"One"), (Number)new Double(43.2));
        defaultPieDataset.setValue((Comparable)((Object)"Two"), (Number)new Double(10.0));
        defaultPieDataset.setValue((Comparable)((Object)"Three"), (Number)new Double(27.5));
        defaultPieDataset.setValue((Comparable)((Object)"Four"), (Number)new Double(17.5));
        defaultPieDataset.setValue((Comparable)((Object)"Five"), (Number)new Double(11.0));
        defaultPieDataset.setValue((Comparable)((Object)"Six"), (Number)new Double(19.4));
        return defaultPieDataset;
    }

    private static JFreeChart createChart(PieDataset pieDataset) {
        JFreeChart jFreeChart = ChartFactory.createPieChart((String)"Legend Wrapper Demo 1", (PieDataset)pieDataset, (boolean)false, (boolean)true, (boolean)false);
        PiePlot piePlot = (PiePlot)jFreeChart.getPlot();
        piePlot.setLabelFont(new Font("SansSerif", 0, 12));
        piePlot.setNoDataMessage("No data available");
        piePlot.setCircular(true);
        piePlot.setLabelGap(0.02);
        LegendTitle legendTitle = new LegendTitle((LegendItemSource)jFreeChart.getPlot());
        BlockContainer blockContainer = new BlockContainer((Arrangement)new BorderArrangement());
        blockContainer.setFrame((BlockFrame)new BlockBorder(1.0, 1.0, 1.0, 1.0));
        LabelBlock labelBlock = new LabelBlock("Legend Items:", new Font("SansSerif", 1, 12));
        labelBlock.setPadding(5.0, 5.0, 5.0, 5.0);
        blockContainer.add((Block)labelBlock, (Object)RectangleEdge.TOP);
        LabelBlock labelBlock2 = new LabelBlock("Source: http://www.jfree.org");
        labelBlock2.setPadding(8.0, 20.0, 2.0, 5.0);
        blockContainer.add((Block)labelBlock2, (Object)RectangleEdge.BOTTOM);
        BlockContainer blockContainer2 = legendTitle.getItemContainer();
        blockContainer2.setPadding(2.0, 10.0, 5.0, 2.0);
        blockContainer.add((Block)blockContainer2);
        legendTitle.setWrapper(blockContainer);
        legendTitle.setPosition(RectangleEdge.RIGHT);
        legendTitle.setHorizontalAlignment(HorizontalAlignment.LEFT);
        jFreeChart.addSubtitle((Title)legendTitle);
        ChartUtilities.applyCurrentTheme((JFreeChart)jFreeChart);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = LegendWrapperDemo1.createChart(LegendWrapperDemo1.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        LegendWrapperDemo1 legendWrapperDemo1 = new LegendWrapperDemo1("JFreeChart: LegendWrapperDemo1.java");
        legendWrapperDemo1.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)legendWrapperDemo1));
        legendWrapperDemo1.setVisible(true);
    }
}

