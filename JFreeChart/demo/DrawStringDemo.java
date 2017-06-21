/*
 * Decompiled with CFR 0_122.
 * 
 * Could not load the following classes:
 *  org.jfree.ui.ApplicationFrame
 *  org.jfree.ui.FontChooserPanel
 *  org.jfree.ui.RefineryUtilities
 *  org.jfree.ui.TextAnchor
 */
package demo;

import demo.DrawStringPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.FontChooserPanel;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class DrawStringDemo
extends ApplicationFrame
implements ActionListener,
ChangeListener {
    private JComboBox combo1;
    private JComboBox combo2;
    private JComboBox combo3;
    private JSlider rotation;
    private DrawStringPanel drawStringPanel1;
    private DrawStringPanel drawStringPanel2;

    public DrawStringDemo(String string) {
        super(string);
        this.setContentPane((Container)this.createContentPane());
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("fontButton.clicked")) {
            this.displayFontDialog();
        }
        if (actionEvent.getActionCommand().equals("combo1.changed")) {
            this.handleCombo1Change();
        }
        if (actionEvent.getActionCommand().equals("combo2.changed")) {
            this.handleCombo2Change();
        }
        if (actionEvent.getActionCommand().equals("combo3.changed")) {
            this.handleCombo3Change();
        }
    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        int n = this.rotation.getValue();
        double d = 6.283185307179586 * ((double)n / 360.0);
        this.drawStringPanel2.setAngle(d);
        this.drawStringPanel2.invalidate();
        this.drawStringPanel2.repaint();
    }

    private void handleCombo1Change() {
        String string = this.combo1.getSelectedItem().toString();
        this.drawStringPanel1.setAnchor(this.convertStringToAnchor(string));
        this.drawStringPanel1.invalidate();
        this.drawStringPanel1.repaint();
    }

    private void handleCombo2Change() {
        String string = this.combo2.getSelectedItem().toString();
        this.drawStringPanel2.setAnchor(this.convertStringToAnchor(string));
        this.drawStringPanel2.invalidate();
        this.drawStringPanel2.repaint();
    }

    private void handleCombo3Change() {
        String string = this.combo3.getSelectedItem().toString();
        this.drawStringPanel2.setRotationAnchor(this.convertStringToAnchor(string));
        this.drawStringPanel2.invalidate();
        this.drawStringPanel2.repaint();
    }

    private JPanel createContentPane() {
        JPanel jPanel = new JPanel(new BorderLayout());
        JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.add("Alignment", this.createTab1Content());
        jTabbedPane.add("Rotation", this.createTab2Content());
        jPanel.add(jTabbedPane);
        return jPanel;
    }

    private JPanel createTab1Content() {
        JPanel jPanel = new JPanel(new BorderLayout());
        this.combo1 = new JComboBox();
        this.combo1.setActionCommand("combo1.changed");
        this.populateTextAnchorCombo(this.combo1);
        this.combo1.addActionListener(this);
        JPanel jPanel2 = new JPanel();
        jPanel2.add(this.combo1);
        JButton jButton = new JButton("Select Font...");
        jButton.setActionCommand("fontButton.clicked");
        jButton.addActionListener(this);
        jPanel2.add(jButton);
        jPanel.add((Component)jPanel2, "North");
        this.drawStringPanel1 = new DrawStringPanel("0123456789", false);
        jPanel.add(this.drawStringPanel1);
        return jPanel;
    }

    private JPanel createTab2Content() {
        JPanel jPanel = new JPanel(new BorderLayout());
        JPanel jPanel2 = new JPanel();
        jPanel2.add(new JLabel("Text anchor: "));
        this.combo2 = new JComboBox();
        this.populateTextAnchorCombo(this.combo2);
        this.combo2.setActionCommand("combo2.changed");
        this.combo2.addActionListener(this);
        jPanel2.add(this.combo2);
        jPanel2.add(new JLabel("Rotation anchor: "));
        this.combo3 = new JComboBox();
        this.populateTextAnchorCombo(this.combo3);
        this.combo3.setActionCommand("combo3.changed");
        this.combo3.addActionListener(this);
        jPanel2.add(this.combo3);
        this.rotation = new JSlider(-360, 360, 0);
        this.rotation.setMajorTickSpacing(60);
        this.rotation.setMinorTickSpacing(10);
        this.rotation.setPaintLabels(true);
        this.rotation.setPaintTicks(true);
        this.rotation.addChangeListener(this);
        jPanel.add((Component)this.rotation, "South");
        jPanel.add((Component)jPanel2, "North");
        this.drawStringPanel2 = new DrawStringPanel("Rotated Text", true);
        jPanel.add(this.drawStringPanel2);
        return jPanel;
    }

    private void displayFontDialog() {
        FontChooserPanel fontChooserPanel = new FontChooserPanel(this.drawStringPanel1.getFont());
        int n = JOptionPane.showConfirmDialog((Component)((Object)this), (Object)fontChooserPanel, "Font Selection", 2, -1);
        if (n == 0) {
            this.drawStringPanel1.setFont(fontChooserPanel.getSelectedFont());
            this.drawStringPanel2.setFont(fontChooserPanel.getSelectedFont());
        }
    }

    private void populateTextAnchorCombo(JComboBox jComboBox) {
        jComboBox.addItem("TextAnchor.TOP_LEFT");
        jComboBox.addItem("TextAnchor.TOP_CENTER");
        jComboBox.addItem("TextAnchor.TOP_RIGHT");
        jComboBox.addItem("TextAnchor.HALF_ASCENT_LEFT");
        jComboBox.addItem("TextAnchor.HALF_ASCENT_CENTER");
        jComboBox.addItem("TextAnchor.HALF_ASCENT_RIGHT");
        jComboBox.addItem("TextAnchor.CENTER_LEFT");
        jComboBox.addItem("TextAnchor.CENTER");
        jComboBox.addItem("TextAnchor.CENTER_RIGHT");
        jComboBox.addItem("TextAnchor.BASELINE_LEFT");
        jComboBox.addItem("TextAnchor.BASELINE_CENTER");
        jComboBox.addItem("TextAnchor.BASELINE_RIGHT");
        jComboBox.addItem("TextAnchor.BOTTOM_LEFT");
        jComboBox.addItem("TextAnchor.BOTTOM_CENTER");
        jComboBox.addItem("TextAnchor.BOTTOM_RIGHT");
    }

    private TextAnchor convertStringToAnchor(String string) {
        if (string.equals("TextAnchor.TOP_LEFT")) {
            return TextAnchor.TOP_LEFT;
        }
        if (string.equals("TextAnchor.TOP_CENTER")) {
            return TextAnchor.TOP_CENTER;
        }
        if (string.equals("TextAnchor.TOP_RIGHT")) {
            return TextAnchor.TOP_RIGHT;
        }
        if (string.equals("TextAnchor.CENTER_LEFT")) {
            return TextAnchor.CENTER_LEFT;
        }
        if (string.equals("TextAnchor.CENTER")) {
            return TextAnchor.CENTER;
        }
        if (string.equals("TextAnchor.CENTER_RIGHT")) {
            return TextAnchor.CENTER_RIGHT;
        }
        if (string.equals("TextAnchor.HALF_ASCENT_LEFT")) {
            return TextAnchor.HALF_ASCENT_LEFT;
        }
        if (string.equals("TextAnchor.HALF_ASCENT_CENTER")) {
            return TextAnchor.HALF_ASCENT_CENTER;
        }
        if (string.equals("TextAnchor.HALF_ASCENT_RIGHT")) {
            return TextAnchor.HALF_ASCENT_RIGHT;
        }
        if (string.equals("TextAnchor.BASELINE_LEFT")) {
            return TextAnchor.BASELINE_LEFT;
        }
        if (string.equals("TextAnchor.BASELINE_CENTER")) {
            return TextAnchor.BASELINE_CENTER;
        }
        if (string.equals("TextAnchor.BASELINE_RIGHT")) {
            return TextAnchor.BASELINE_RIGHT;
        }
        if (string.equals("TextAnchor.BOTTOM_LEFT")) {
            return TextAnchor.BOTTOM_LEFT;
        }
        if (string.equals("TextAnchor.BOTTOM_CENTER")) {
            return TextAnchor.BOTTOM_CENTER;
        }
        if (string.equals("TextAnchor.BOTTOM_RIGHT")) {
            return TextAnchor.BOTTOM_RIGHT;
        }
        return null;
    }

    public static void main(String[] arrstring) {
        DrawStringDemo drawStringDemo = new DrawStringDemo("DrawString Demo");
        drawStringDemo.pack();
        RefineryUtilities.centerFrameOnScreen((Window)((Object)drawStringDemo));
        drawStringDemo.setVisible(true);
    }
}

