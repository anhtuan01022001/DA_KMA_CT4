/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacode.custom;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author sondu
 */
public class panelSearch extends PanelGradient{

    
    public JTextField txtSearch = new JTextField();
    public   Button btnSearch = new Button();
    
    public void setIcon(ImageIcon Icon){
        btnSearch.setIcon(Icon);
        
    }
    
    public panelSearch() {
        setLayout(new MigLayout("fill","8[]8","0[]0"));
        setRadius(10);
        Borderde border = new Borderde(0);
        
        border.setRound(10);
        
        setBorder(border);
        setColor1(Color.WHITE);
        setColor2(Color.WHITE);
        
        txtSearch.setBackground(Color.WHITE);
        txtSearch.setBorder(null);
        txtSearch.setFont(new Font("sansserif",0,15));
        txtSearch.setSelectedTextColor(Color.WHITE);
        txtSearch.setSelectionColor(new Color(54, 189, 248));
        txtSearch.setBorder(new MatteBorder(0, 0, 0, 1, border.getColor()));
      
        btnSearch.setIcon(new ImageIcon(getClass().getResource("/Image/search.png")));
        btnSearch.setBackground(new Color(0,0,0,0));
        
        btnSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(txtSearch,"center,h 28!,w 100%");
        add(btnSearch,"right");
        
        txtSearch.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent fe) {
                border.setColor(new Color(100, 100, 255));
                txtSearch.setBorder(new MatteBorder(0, 0, 0, 1, border.getColor()));
                txtSearch.repaint();
                repaint();
            }

            @Override
            public void focusLost(FocusEvent fe) {
                border.setColor(new Color(128, 189, 255));
                txtSearch.setBorder(new MatteBorder(0, 0, 0, 1, border.getColor()));
                txtSearch.repaint();
                repaint();
            }
        });

    
        
    }
    
    public String getText(){
        return txtSearch.getText();
    }
    
    public void EvenSearch(ActionListener event) {
        btnSearch.addActionListener(event);
    }
            
     
            
    
     public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                                    JFrame JF = new JFrame();
                                    JF.setDefaultCloseOperation(JF.EXIT_ON_CLOSE);
                                    JF.setSize(400  , 300);
                                    JF.setLocationRelativeTo(null);
                                    JPanel panel = new JPanel();
                                    JF.setContentPane(panel);
                                    panelSearch PS = new panelSearch();
                                    PS.setBounds(50, 50, 300, 36);
                                    panelSearch PS1 = new panelSearch();
                                    PS1.setBounds(50, 100, 300, 36);
                                    panel.setLayout(null);
                                    panel.add(PS);
                                    panel.add(PS1);        
                                    JF.setVisible(true);
                                     
                                } catch (Exception e) {
					e.printStackTrace();
				}
                        }
               });       
    }   
    
    
    
    
    private class Borderde extends EmptyBorder {

        public int getRound() {
            return round;
        }

        public void setRound(int round) {
            this.round = round;
        }

        public Color getFocusColor() {
            return focusColor;
        }

        public void setFocusColor(Color focusColor) {
            this.focusColor = focusColor;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        private Color focusColor = new Color(100, 100, 255);
        private Color color = new Color(128, 189, 255);
        private int round;

        public Borderde(int border) {
            super(border, border, border, border);
        }

        public Borderde() {
            this(0);
        }

        @Override
        public void paintBorder(Component cmpnt, Graphics grphcs, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) grphcs.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (cmpnt.isFocusOwner()) {
                g2.setColor(focusColor);
            } else {
                g2.setColor(color);
            }
           
            g2.drawRoundRect(x, y, width-1 , height-1 , round, round);
            
            g2.drawRoundRect(x, y, width-3 , height-3 , round-2, round-2);
            
            g2.dispose();
        }
    }
}