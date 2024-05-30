
package javacode.custom;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.border.EmptyBorder;


public class BorderRound extends EmptyBorder{
    
        public int getRound() {
            return round;
        }

        public void setRound(int round) {
            this.round = round;
        }

        

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

       
        private Color color = new Color(206, 212, 218);
        private int round;
        private int n=0;
        
        public BorderRound(int border) {
            super(border, border, border, border);
        }

        public BorderRound() {
            this(5);
        }

        @Override
        public void paintBorder(Component cmpnt, Graphics grphcs, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) grphcs.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(color);
            g2.drawRoundRect(x, y, width - 1, height - 1, round, round);
            for(int i=0;i<n;i++){
            g2.drawRoundRect(x+1, y+1, width - 1-2, height - 1-2, round, round);
            }
            g2.dispose();
        }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    }
    

