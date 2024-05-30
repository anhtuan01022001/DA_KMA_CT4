/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacode.custom;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author sondu
 */
public class PanelGradient extends JPanel{
      public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
     public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    public int getChoose() {
        return choose;
    }

    public void setChoose(int choose) {
        this.choose = choose;
    }
    
    
     public PanelGradient(){
        setOpaque(false);
         borderColor = new Color(30, 136, 56);
         setForeground(Color.WHITE);
//          setBorder(new EmptyBorder(10, 20, 10, 20));
    }
     
    private Color borderColor;
    private int radius = 0;
    private Color color1 = Color.decode("#0099F7");
    private Color color2 = Color.decode("#F11712");
    int choose = 1;
    
  @Override
    protected void paintComponent(Graphics grphcs) {
        int width = getWidth();
        int height = getHeight();
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if(choose==1){
        GradientPaint gra = new GradientPaint(0, 0, color1, width,0, color2);
        g2.setPaint(gra);
        }
        else if(choose==2){
             GradientPaint gra =new GradientPaint(0, height, color1, width, 0, color2);
        g2.setPaint(gra);
        }
        else if(choose==3){
             GradientPaint gra =new GradientPaint(0, 0, color1, 0, height, color2);
        g2.setPaint(gra);
        }
        
        
        g2.fillRoundRect(0, 0, width, height, radius, radius);
         grphcs.drawImage(img, 0, 0, null);
        super.paintComponent(grphcs);
    }
   
}
