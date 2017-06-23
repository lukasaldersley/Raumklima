/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.data.category.DefaultCategoryDataset
 */
package demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import org.jfree.data.category.DefaultCategoryDataset;

class Animator
extends Timer
implements ActionListener {
    private DefaultCategoryDataset dataset;

    Animator(DefaultCategoryDataset defaultCategoryDataset) {
        super(20, null);
        this.dataset = defaultCategoryDataset;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int n = (int)(Math.random() * (double)this.dataset.getRowCount());
        Comparable comparable = this.dataset.getRowKey(n);
        int n2 = (int)(Math.random() * (double)this.dataset.getColumnCount());
        Comparable comparable2 = this.dataset.getColumnKey(n2);
        int n3 = Math.random() - 0.5 < 0.0 ? -5 : 5;
        this.dataset.setValue(Math.max(0.0, this.dataset.getValue(n, n2).doubleValue() + (double)n3), comparable, comparable2);
    }
}

