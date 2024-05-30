
package javacode.compoment;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javacode.custom.ButtonGradient;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;


public class menuButton extends ButtonGradient{
    private boolean forcusButton;
    private int radius = 20;
    private String textButton = new String();
    private Animator animator;
    private boolean clickButton;
    private Point pressedPoint;
    private float alpha;
    private Color effectColor = new Color(0,0,0);
    
    
    
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    public boolean isForcusButton() {
        return forcusButton;
    }

    public void setForcusButton(boolean forcusButton) {
        if(!forcusButton){
            setBackground(new Color(0,0,0,0));
        }
        else{
                setBackground(new Color(255,255,255,100));
            }
        this.forcusButton = forcusButton;
    }
    
   
    public menuButton(){
        setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setBorder(null);
        showText(true);
        setForeground(Color.white);
        setFont(new Font("Tahoma", 0, 14));
        this.setColor1(new Color(0,0,0,0));
        this.setColor2(new Color(0,0,0,0));
        this.setBackground(new Color(0,0,0,0));
         setBorder(new EmptyBorder(1, 10, 1, 1));

        addMouseListener(new MouseAdapter() {
           
            
            @Override
            public void mousePressed(MouseEvent me) {
                forcusButton = true;
                alpha = 0.5f;
                if (animator.isRunning()) {
                    animator.stop();
                }
                animator.start();
            }
        });
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void begin() {
                
                setBackground(new Color(255,255,255,100));
                
            }
            
            @Override
            public void timingEvent(float fraction) {
                if (fraction > 0.5f) {
                    alpha = 1 - fraction;
                }
                
                repaint();
            }

            
            

            
            
            

            
            
        };
        animator = new Animator(400, target);
        animator.setResolution(0);
    }

    
    @Override
    protected void paintComponent(Graphics grphcs) {
        int width = getWidth();
        int height = getHeight();
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, width, height, radius, radius);
//        if (pressedPoint != null) {
            g2.setColor(effectColor);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
            g2.fillRoundRect(0, 0, width, height, radius, radius);
//        }
        g2.dispose();
        grphcs.drawImage(img, 0, 0, null);
        super.paintComponent(grphcs);
    
    }
    
    public void setMenuItem(String Icon, String text){
        textButton = text;
        setIcon(new ImageIcon(getClass().getResource(Icon)));
        setText("     "+text);
    }
    
    public void showText(boolean ShowText){
        String textShow = new String();
          if(!ShowText){
//              setHorizontalAlignment(SwingConstants.CENTER);
              setText("");
        }
        else{
              setHorizontalAlignment(SwingConstants.LEFT);
            textShow = "     "+textButton;  
            setText(textShow);
        }
    }
}   
