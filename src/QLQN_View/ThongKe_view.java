/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLQN_View;

import QLQN_Controller.QLTK_controller;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javacode.compoment.Card1;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import net.miginfocom.swing.MigLayout;
import java.text.NumberFormat;
import java.util.Locale;
/**
 *
 * @author sondu
 */
public class ThongKe_view extends JPanel{
         Locale locale =new Locale("vi","VN");
     
         NumberFormat format1 = NumberFormat.getInstance(locale);
    
    JPanel contenLeft = new JPanel(new MigLayout("fill","[fill]","[fill]"));
    JPanel contenRight = new JPanel(new MigLayout("fill,wrap","[fill,center]","[fill]"));
    JLabel lblTitle = new JLabel("Thống kê / Ngày");
    Card1 cardNgay = new Card1();
    Card1 cardThang = new Card1();
    Card1 cardQuy = new Card1();
    Card1 cardNam = new Card1();
    String tongNgay = new String("00000$") ;
    String tongThang = new String("00000$") ;
    String tongQuy= new String("00000$") ;
    String tongNam = new String("00000$") ;
    QLTK_controller con = new QLTK_controller();
    TK_Ngay_view TKnagy = new TK_Ngay_view();
   
   
    public ThongKe_view(){
        setLayout(new MigLayout("fill","16[]16[fill]32","10[fill]20[fill]0"));
        add(lblTitle," cell 0 0");
        add(contenLeft,"gapleft 16!, w 70%,h 100%,cell 0 1"); 
        
        add(contenRight,"w 28%,cell 1 0 1 2");
        
        contenLeft.setBackground(Color.WHITE);
        contenLeft.add(TKnagy);
       
        lblTitle.setFont(new Font("sansserif", 1, 14));
        lblTitle.setForeground(new Color(4,72,210));
        
        contenRight.add(cardNgay,"w 85%,h 140!");
        contenRight.add(cardThang,"w 85%,h 140!");
        contenRight.add(cardQuy,"w 85%,h 140!");
        contenRight.add(cardNam,"w 85%,h 140!");
        
        tongNgay = format1.format(con.tongNgay())+"đ";
         tongThang = format1.format(con.tongThang())+"đ";
          tongQuy = format1.format(con.tongQuy())+"đ";
           tongNam = format1.format(con.tongNam())+"đ";
        
        
        
        cardNgay.addModelCard(new Color(112,69,246), new Color(211,28,215),"Thống kê ngày",tongNgay,"/Image/dola.png");
        cardThang.addModelCard(new Color(10,30,214), new Color(72,11,252),"Thống kê tháng",tongThang,"/Image/money-bag.png");
        cardQuy.addModelCard(new Color(194,58,1), new Color(255,212,99),"Thống kê quý",tongQuy,"/Image/salary.png");
        cardNam.addModelCard(new Color(60,195,0), new Color(208,255,90),"Thống kê năm",tongNam,"/Image/money-bag (1).png");
        
        cardNgay.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cardThang.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cardQuy.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cardNam.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        EvenTK();
    }
    
    private void EvenTK(){
        cardNgay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTitle.setText("Thống kê / Ngày");
                contenLeft.removeAll();
                contenLeft.add(TKnagy);
                contenLeft.revalidate();
                contenLeft.repaint();
                
            }
        });
         cardThang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTitle.setText("Thống kê / Tháng");
                TK_Thang_view TKthang = new TK_Thang_view();
                contenLeft.removeAll();
                contenLeft.add(TKthang);
               
                contenLeft.repaint();
                 contenLeft.revalidate();
            }
        });
          cardQuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTitle.setText("Thống kê / Quý");
                TK_Quy_view TKquy = new TK_Quy_view();
                contenLeft.removeAll();
                contenLeft.add(TKquy);
                contenLeft.revalidate();
                contenLeft.repaint();
                
            }
        });
           cardNam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                
                lblTitle.setText("Thống kê / Năm");
                TK_Nam_view TKnam = new TK_Nam_view();
                contenLeft.removeAll();
                contenLeft.add(TKnam);
                contenLeft.revalidate();
                contenLeft.repaint();
                
            }
        });
    }
    
    
    public static void main(String[] args) {
        JFrame JF = new JFrame();
        JF.setDefaultCloseOperation(JF.EXIT_ON_CLOSE);
        ThongKe_view contenPanel = new ThongKe_view();
        
        JF.setSize(1000, 650);
        JF.setContentPane(contenPanel);
        
        JF.setVisible(true);
    }
}
