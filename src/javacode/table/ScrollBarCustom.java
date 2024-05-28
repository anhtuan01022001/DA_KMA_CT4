package javacode.table;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarCustom extends JScrollBar {

    public ScrollBarCustom() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(8, 8));
        setBackground(new Color(231,245,252));;
        setForeground(new Color(126,126,126));
        setUnitIncrement(20);
        setOpaque(false);
    }
}
