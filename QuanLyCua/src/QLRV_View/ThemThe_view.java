/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLRV_View;

import QLRV_Controller.QLThe_controller;
import QLRV_Model.QLThe_model;
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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;



/**
 *
 * @author QuynhTn
 */
public class ThemThe_view  extends JFrame{
      Panel_QLThe_view  v;

     public int w = 220;
     public static void main(String[] args) {
        ThemThe_view v = new ThemThe_view();
        v.setVisible(true);
    }

    public ThemThe_view() {
//-------------------------------------------------------------------------------this
        this.setUndecorated(true);
        this.setBounds(0,0,1360,740);
        this.setBackground(new Color(0,0,0,150));
        this.setLocationRelativeTo(null);
        this.setLayout(null);
//-------------------------------------------------------------------------------icon thoát
          JLabel lblicon = new JLabel();
        lblicon.setBounds(940,w+14,30,30);
        lblicon.setIcon(new ImageIcon(getClass().getResource("/Image/cross.png")));
        
        lblicon.setCursor(new Cursor(Cursor.HAND_CURSOR));
       lblicon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dispose();
            }
        });
        this.add(lblicon);
//-------------------------------------------------------------------------------tiêu đề       
        JLabel lblTitle = new JLabel("Thêm thẻ ");
        lblTitle.setBounds(655,w+17,160,23);
        lblTitle.setFont(new Font("sansserif",0,22));
        this.add(lblTitle);
 //-------------------------------------------------------------------------------gạch trên       
        JLabel lblgach = new JLabel();
        lblgach.setBorder(new MatteBorder(0, 0, 1, 0,new Color(191,187,187)));
        lblgach.setBounds(480, w, 500, 55);
        this.add(lblgach);

        JTextField txtTheUID1 = new JTextField();
        txtTheUID1.setBounds(0, 0, 0, 0);
        this.add(txtTheUID1);
//-------------------------------------------------------------------------------Tên máy        
        JLabel lblTen = new JLabel("UID của thẻ: ");
        lblTen.setBounds(490,w+55+40,200,40);
        lblTen.setFont(new Font("sansserif",0,18));
        this.add(lblTen);
        
        TextField txtTenMay = new TextField();
        txtTenMay.setBounds(600, w+55+30, 350, 60);
        txtTenMay.setFont(new Font("sansserif",0,17));
        txtTenMay.setRound(15);
        this.add(txtTenMay);
//-------------------------------------------------------------------------------Tình trạng        
        JLabel lblUserID = new JLabel("User ID: ");
        lblUserID.setBounds(490,w+55+130,100,40);
        lblUserID.setFont(new Font("sansserif",0,18));
        this.add(lblUserID);
        
        TextField txtUserID = new TextField();
        txtUserID.setBounds(600,w+55+130,350, 60);
        txtUserID.setFont(new Font("sansserif",0,17));
        txtUserID.setRound(15);
        this.add(txtUserID);
//-------------------------------------------------------------------------------check box        
        JCheckBox chkThem = new JCheckBox("  Tiếp tục thêm thẻ ?");
        chkThem.setFont(new Font("sansserif",2,15));
        chkThem.setForeground(new Color(56,172,243));
        chkThem.setBounds(560,w+55+130+60,300,40);
        chkThem.setBackground(new Color(255,255,255));
        chkThem.setFocusPainted(false);
        this.add(chkThem);
       
//-------------------------------------------------------------------------------button Thêm        
        outlineButton btnAdd = new outlineButton();
        btnAdd.setText("Thêm");
        btnAdd.setBounds(810, 520, 70, 40);
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tenmay = txtTenMay.getText();
                
                if(tenmay.equals("")){

                    Message msg = new Message();
                    msg.showMessage("Bạn cần nhập đủ thông tin!");
                  
                    
                }
                else{
                    QLThe_model maytram = new QLThe_model();
                    maytram.setTheUID(tenmay);
                    maytram.setUserName("False");
                    maytram.setUserName("");
                    
                    QLThe_controller con = new QLThe_controller();
                    int tontai = con.CheckMayTram(maytram);
                    if(tontai==1){
                        Message msg = new Message();
                           
                            msg.showMessage("UID của thẻ đã tồn tại !");
                    }
                    else{
                        int kq = con.ThemMayTram(maytram);
                        if(kq==1){


                            Message msg = new Message();

                            msg.showMessage("Thêm mới thành công!");
                            Panel_QLThe_view.loadData();
                            if(chkThem.isSelected()){
                                txtTenMay.setText("");
                                chkThem.setSelected(false);
                            }
                            else{
                            dispose();
                            }
                        }
                        else if (kq==2){
                            Message msg = new Message();
                            msg.showMessage("Lỗi kết nối!");

                        }
                    }
                    

                }
              
            }
        });
//-------------------------------------------------------------------------------button thoát        
        outlineButton btnExit = new outlineButton();
        btnExit.setText("Thoát");
        btnExit.setBoderColor(Color.DARK_GRAY);
        btnExit.setForeground(Color.DARK_GRAY);
        btnExit.setBounds(890, 520, 70, 40);
        this.add(btnExit);
        btnExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  
               dispose();
            }
        });
//-------------------------------------------------------------------------------gạch dưới        
         JLabel lblgacht = new JLabel();
        lblgacht.setBorder(new MatteBorder(1, 0, 0, 0,new Color(191,187,187)));
        lblgacht.setBounds(480, 500, 500, 55);
        this.add(lblgacht);
//-------------------------------------------------------------------------------panel content      
        Panel contenPanel = new Panel();
        contenPanel.setLayout(null);
        contenPanel.setBounds(480, 220, 500, 350);
        contenPanel.setBackground(new Color(255,255,255));
        contenPanel.setRadius(20);
        this.add(contenPanel);
    }
    



    

    
}
