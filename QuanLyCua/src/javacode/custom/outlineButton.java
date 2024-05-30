/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacode.custom;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.color.ColorSpace;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;


public class outlineButton extends JButton{
    private int radius = 10;
    private Color boderColor = Color.decode("#0d6efd");
    private float alpha;
      private Animator animator;
      private Animator animator1;
      private int targetSize;
    private float animatSize;
    private boolean tagetButton = false;
    private Point pressedPoint;

    public Color getBoderColor() {
        return boderColor;
    }

    public void setBoderColor(Color boderColor) {
        this.boderColor = boderColor;
    }
    
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    public outlineButton() {
        setText("sdf");
        setContentAreaFilled(false);
        setBorder(null);
        defautColor();
        setFocusPainted(false);
        setForeground(boderColor);
//        setFont(new Font("Tahoma", 1, 25));
       
        
        addMouseListener(new MouseAdapter() {
            
            @Override
            public void mousePressed(MouseEvent me) {
              
                tagetButton = true;
                targetSize = Math.max(getWidth(), getHeight()) * 2;
                animatSize = 0;
                
                alpha = 0.5f;
                if (animator1.isRunning()) {
                    animator1.stop();
                }
                animator1.start();
            }
      
            
            @Override
            public void mouseExited(MouseEvent e) {
                defautColor();
                alpha = 0.5f;
                if (animator.isRunning()) {
                    animator.stop();
                }
                animator.start();
////                
            }
           
           
            
            @Override
            public void mouseEntered(MouseEvent me) {
                hoverColor();
                alpha = 0.5f;
                if (animator.isRunning()) {
                    animator.stop();
                }
                animator.start();
            }
        });
TimingTarget target = new TimingTargetAdapter() {
          
            
            @Override
            public void timingEvent(float fraction) {
                if (fraction > 0.5f) {
                    alpha = 1 - fraction;
                }
                
                repaint();
            }

        };
        animator = new Animator(110, target);
        animator.setResolution(0);
        
        TimingTarget target1 = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (fraction > 0.3f) {
                    alpha = 1 - fraction;
                }
                animatSize = fraction * targetSize;
                repaint();
            }

            @Override
            public void end() {
                tagetButton=false;
            }
            
        };
         animator1 = new Animator(300, target1);
        animator1.setResolution(0);
    }
    
    
    
    
    void defautColor(){
       
        setBackground(Color.white);
        setForeground(boderColor);
    }
    
    void hoverColor(){
        
        setBackground(boderColor);
        setForeground(Color.white);
    }
    @Override
    protected void paintComponent(Graphics grphcs) {
        int width = getWidth();
        int height = getHeight();
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(boderColor);
        g2.fillRoundRect(0, 0, width, height, radius, radius);
        g2.setColor(getBackground());
        g2.fillRoundRect(1, 1, width-2, height-2, radius-1, radius-1);
        
        if(tagetButton){
            
            g2.setColor(new Color(255, 255, 255));
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
            
            g2.fillRoundRect(1, 1, width-2, height-2, radius, radius);
        }
        else{
        if(getBackground()== Color.white){
            g2.setColor(boderColor);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
        g2.fillRoundRect(1, 1, width-2, height-2, radius, radius);
        }
        if(getBackground()!= Color.white){
            g2.setColor(Color.white);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
        g2.fillRoundRect(1, 1, width-2, height-2, radius, radius);
        }
        }
        
        
        g2.dispose();
        grphcs.drawImage(img, 0, 0, null);
        super.paintComponent(grphcs);
    }
  
}