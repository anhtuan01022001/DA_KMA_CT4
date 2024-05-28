/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLQN_View;

import QLQN_Controller.QLKH_controller;
import QLQN_Controller.QLMayTram_controller;
import QLQN_Model.QLKH_model;
import QLQN_Model.QLMT_model;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javacode.custom.BorderRound;
import javacode.custom.Button;

import javacode.custom.Confirm;
import javacode.custom.Message;
import javacode.custom.Panel;
import javacode.custom.TextField;
import javacode.custom.outlineButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;



/**
 *
 * @author QuynhTn
 */
public class NapTien_view  extends JFrame{

     public int w = 220;
    
public NapTien_view(){
    
}
    public NapTien_view(String khachhang) {
        this.setUndecorated(true);
        this.setBounds(0,0,1360,740);
        this.setBackground(new Color(0,0,0,150));
         this.setLocationRelativeTo(null);
        this.setLayout(null);

          JLabel lblicon = new JLabel();
        lblicon.setBounds(940-20,w+14-20,30,30);
        lblicon.setIcon(new ImageIcon(getClass().getResource("/Image/cross.png")));
        
        lblicon.setCursor(new Cursor(Cursor.HAND_CURSOR));
       lblicon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dispose();
            }
        });
        this.add(lblicon);
        
        JLabel lblTitle = new JLabel("Nạp tiền");
        lblTitle.setBounds(685-20,w+17-20,160,23);
        lblTitle.setFont(new Font("sansserif",0,22));
        this.add(lblTitle);
        
        JLabel lblgach = new JLabel();
        lblgach.setBorder(new MatteBorder(0, 0, 1, 0,new Color(191,187,187)));
        lblgach.setBounds(480-20, w-20, 500, 55);
        this.add(lblgach);

         JTextField txtTenMay1 = new JTextField();
        txtTenMay1.setBounds(0-20, 0, 0, 0);
        this.add(txtTenMay1);
        
        JLabel lblTen = new JLabel("Tên tài khoản : ");
        lblTen.setBounds(490-20,w+55+40-20,120,40);
        lblTen.setFont(new Font("sansserif",0,17));
        this.add(lblTen);
        
        JLabel lblTenuser = new JLabel();
        lblTenuser.setText(khachhang);
        lblTenuser.setBounds(610-20, w+55+30-20, 355, 60);
        lblTenuser.setFont(new Font("sansserif",1,19));
        this.add(lblTenuser);
        
        JLabel lblTinhTrang = new JLabel("Số tiền nạp : ");
        lblTinhTrang.setBounds(490-20,w+55+130-20,100,40);
        lblTinhTrang.setFont(new Font("sansserif",0,17));
        this.add(lblTinhTrang);
        
        TextField txtsotiennap = new TextField();
        txtsotiennap.setBounds(610-38, w+55+120-20, 355, 60);
        txtsotiennap.setFont(new Font("sansserif",0,17));
        txtsotiennap.setRound(15);
        this.add(txtsotiennap);
        
       
        
        outlineButton btnAdd = new outlineButton();
        btnAdd.setText("Nạp tiền");
        btnAdd.setBounds(780-20, 520-20, 100, 40);
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
//                System.out.println(java.time.LocalDate.now());
                String sotiennap = txtsotiennap.getText();
                if(sotiennap.equals("")){
                    Message msg = new Message();
                    msg.showMessage("Chưa nhập số tiền cần nạp !");
                }
                else{
                     int STN=0;
                     int k=0;
                    try {
                         STN = Integer.parseInt(sotiennap);
                         k=1;
                        } catch (Exception e1) {
                       Message msg = new Message();
                       msg.showMessage("Nhập sai định dạng tiền !");
                    }
                    if(k==1){
                        if(STN%1000 != 0){
                              Message msg = new Message();
                                msg.showMessage("Nhập sai định dạng tiền !");
                        }
                        else{
                            QLKH_controller con = new QLKH_controller();
                            int kq = con.Naptien(khachhang, STN);
                            if(kq==1){
                                Message msg = new Message();
                                 msg.showMessage("Nạp tiền cho "+khachhang+" thành công!");
                                 dispose();
                                 Panel_QLKH_view.loadData();
                                 NC_LichSuNapTien_view.loadData();
                                 
                            }
                            else if (kq ==2){
                                Message msg = new Message();
                                msg.showMessage("Lỗi kết nối !");
                            }
                        }
                        }
                        
                    
                }
                
               
               
               
               
              
            }
        });
        
        outlineButton btnExit = new outlineButton();
        btnExit.setText("Thoát");
        btnExit.setBoderColor(Color.DARK_GRAY);
        btnExit.setForeground(Color.DARK_GRAY);
        btnExit.setBounds(890-20, 520-20, 70, 40);
        this.add(btnExit);
        btnExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  
               dispose();
            }
        });
        
         JLabel lblgacht = new JLabel();
        lblgacht.setBorder(new MatteBorder(1, 0, 0, 0,new Color(191,187,187)));
        lblgacht.setBounds(480-20, 480, 500, 55);
        this.add(lblgacht);
        
        Panel contenPanel = new Panel();
        contenPanel.setLayout(null);
        contenPanel.setBounds(480-20, 200, 500, 350);
        contenPanel.setBackground(new Color(255,255,255));
        contenPanel.setRadius(20);
        this.add(contenPanel);
    }
    



    

    
}
