/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacode.compoment;

import java.awt.Color;
import java.awt.Font;

import javacode.custom.PanelGradient;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author sondu
 */
public class Card1 extends PanelGradient{
    private JLabel lblTitle = new JLabel("Title");
    private JLabel lblValues = new JLabel("Values");
    private PanelGradient pg = new PanelGradient();
    private PanelGradient line = new PanelGradient();
    private JLabel icon = new JLabel();
    public Card1(){
        setRadius(20);
        setChoose(2);
        
        setLayout(new MigLayout("fill","[][]","[][]"));
       
        add(lblTitle,"cell 0 0,left,gapleft 16!");
        add(lblValues,"cell 0 1,left,gapleft 16!");
         add(pg,"pos 0 0 100% 100%");
        add(icon,"cell 1 0 1 2,right,gapright 16!");
        add(line,"cell 0 2 2 1,w 90%,h 5!,center");
        
//         
          
        
        
        System.out.println(pg.getColor1().getBlue());
        System.out.println(getHeight());
        lblTitle.setFont(new Font("sansserif", 1, 18));
        lblTitle.setForeground(new Color(240,240,240,200));
        lblTitle.setBounds(20, 20, 200, 30);
        
        lblValues.setFont(new Font("sansserif", 0, 22));
        lblValues.setForeground(new Color(240,240,240,200));
        lblValues.setBounds(20, 65, 100, 30);
    }
    public void addModelCard(Color color1 , Color color2,String Title,String Values,String iconIM){
        
        this.setColor1(color1);
        this.setColor2(color2);
        
        lblTitle.setText(Title);
        lblValues.setText(Values);
        
        icon.setIcon(new ImageIcon(getClass().getResource(iconIM)));
        icon.setBounds(getWidth()-80, getHeight()-100, 65, 65);
        
        line.setBounds(10, getHeight()-30, getWidth()-20, 5);
        line.setColor1(Color.white);
        line.setColor2(new Color(255, 255, 255, 100));
        
        pg.setChoose(1);
        pg.setColor1(new Color(this.getColor1().getRed(),this.getColor1().getGreen(),this.getColor1().getBlue(),100));
        pg.setColor2(new Color(this.getColor2().getRed(),this.getColor2().getGreen(),this.getColor2().getBlue(),100));  
        pg.setBounds(0, 0, getWidth(), getHeight());
        pg.setRadius(20);
    }
    
    public void setGardian(Color color1 , Color color2){
        this.setColor1(color1);
        this.setColor2(color2);
    }
    
    public static void main(String[] args) {
        JFrame JF = new JFrame();
        JF.getContentPane().setBackground(Color.white);
        JF.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JF.setSize(500, 300);
        JF.setLocationRelativeTo(null);
        
        Card1 card  = new Card1();
        card.setBounds(20, 20,350, 140);
        
        card.addModelCard(new Color(112,69,246), new Color(211,28,215),"Thống kê ngày","10000$","/Image/computerAvarta.png");
        
        JPanel conten = new JPanel();
        JF.setContentPane(conten);
        conten.setLayout(null);
        conten.add(card);
        JF.setVisible(true);
       
    }
}
