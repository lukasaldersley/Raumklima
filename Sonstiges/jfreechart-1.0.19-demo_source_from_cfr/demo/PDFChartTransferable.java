/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  com.orsonpdf.PDFDocument
 *  com.orsonpdf.PDFGraphics2D
 *  com.orsonpdf.Page
 *  org.jfree.chart.JFreeChart
 */
package demo;

import com.orsonpdf.PDFDocument;
import com.orsonpdf.PDFGraphics2D;
import com.orsonpdf.Page;
import java.awt.Graphics2D;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.geom.Rectangle2D;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.jfree.chart.JFreeChart;

public class PDFChartTransferable
implements Transferable {
    final DataFlavor pdfFlavor = new DataFlavor("application/pdf", "PDF");
    private JFreeChart chart;
    private int width;
    private int height;

    public PDFChartTransferable(JFreeChart jFreeChart, int n, int n2) {
        this(jFreeChart, n, n2, true);
    }

    public PDFChartTransferable(JFreeChart jFreeChart, int n, int n2, boolean bl) {
        try {
            this.chart = (JFreeChart)jFreeChart.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            this.chart = jFreeChart;
        }
        this.width = n;
        this.height = n2;
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{this.pdfFlavor};
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor dataFlavor) {
        return this.pdfFlavor.equals(dataFlavor);
    }

    @Override
    public Object getTransferData(DataFlavor dataFlavor) throws UnsupportedFlavorException, IOException {
        if (this.pdfFlavor.equals(dataFlavor)) {
            PDFDocument pDFDocument = new PDFDocument();
            Rectangle2D.Double double_ = new Rectangle2D.Double(0.0, 0.0, this.width, this.height);
            Page page = pDFDocument.createPage((Rectangle2D)double_);
            PDFGraphics2D pDFGraphics2D = page.getGraphics2D();
            this.chart.draw((Graphics2D)pDFGraphics2D, (Rectangle2D)double_);
            return new ByteArrayInputStream(pDFDocument.getPDFBytes());
        }
        throw new UnsupportedFlavorException(dataFlavor);
    }
}

