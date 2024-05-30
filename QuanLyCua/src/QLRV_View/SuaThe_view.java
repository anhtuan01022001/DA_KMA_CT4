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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
public class SuaThe_view  extends JFrame{
      Panel_QLThe_view  v;
QLThe_controller con = new QLThe_controller();
     public int w = 220;
//     public static void main(String[] args) {
//        SuaThe_view v = new SuaThe_view();
//        v.setVisible(true);
//    }

    public SuaThe_view(QLThe_model maytram) {
        this.setUndecorated(true);
        this.setBounds(0,0,1360,740);
        this.setBackground(new Color(0,0,0,150));
        this.setLocationRelativeTo(null);
        this.setLayout(null);
//-------------------------------------------------------------------------------icon
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
//-------------------------------------------------------------------------------Tiêu đề        
        JLabel lblTitle = new JLabel("Sửa thẻ ");
        lblTitle.setBounds(655,w+17,160,23);
        lblTitle.setFont(new Font("sansserif",0,22));
        this.add(lblTitle);
//-------------------------------------------------------------------------------gạch trên        
        JLabel lblgach = new JLabel();
        lblgach.setBorder(new MatteBorder(0, 0, 1, 0,new Color(191,187,187)));
        lblgach.setBounds(480, w, 500, 55);
        this.add(lblgach);

         JTextField txtTenMay1 = new JTextField();
        txtTenMay1.setBounds(0, 0, 0, 0);
        this.add(txtTenMay1);
//-------------------------------------------------------------------------------Tên máy        
        JLabel lblTen = new JLabel("User name: ");
        lblTen.setBounds(490,w+55+40,100,40);
        lblTen.setFont(new Font("sansserif",0,18));
        this.add(lblTen);
        
        
        
        TextField txtTenMay = new TextField();
        txtTenMay.setBounds(580, w+55+30, 370, 60);
        txtTenMay.setText(con.TenMayTram(maytram));
        txtTenMay.setFont(new Font("sansserif",0,17));
        txtTenMay.setRound(15);
        
        this.add(txtTenMay);
//-------------------------------------------------------------------------------Tình trạng        
//        JLabel lblTinhTrang = new JLabel("Tình trạng : ");
//        lblTinhTrang.setBounds(490,w+55+130,100,40);
//        lblTinhTrang.setFont(new Font("sansserif",0,18));
//        this.add(lblTinhTrang);
//        
//        JLabel lblTt = new JLabel(maytram.getTinhTrang());
//        lblTt.setBounds(610,w+55+130,100,40);
//        lblTt.setForeground(Color.red);
//        lblTt.setFont(new Font("sansserif",0,18));
//        this.add(lblTt);
//        
//-------------------------------------------------------------------------------button Sửa        
        outlineButton btnAdd = new outlineButton();
        btnAdd.setText("Sửa");
        btnAdd.setBounds(810, 520, 70, 40);
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 String tenmay = txtTenMay.getText();
                 String UName =maytram.getUserName();
                 String Tinhtrang = new String();
                 String uname = new String();
                 if(UName.equals("")){
                     uname="''";
                 }
                 else{
                     uname=UName;
                 }
                 
                  
                  QLThe_model maytramMoi = new QLThe_model();
                    maytramMoi.setID(maytram.getID());
                    maytramMoi.setTheUID(tenmay);
                    maytramMoi.setUserName(uname);
                    
                    
                  int checkSua = con.CheckMayTramSua(maytramMoi);
                 
                  if(checkSua ==1){
                      Message msg = new Message();
                           
                            msg.showMessage("Sửa thành công!");
                      dispose();
                      
                  }
                  else if(checkSua ==2){
                    
                    if(tenmay.equals("")){
                        Message msg = new Message();

                                msg.showMessage("Chưa nhập User Name");
                    }
                    else{
                        int tontai = con.CheckTenMayTram(maytramMoi);
                      
                        if(tontai==1){
                            Message msg = new Message();

                                msg.showMessage("Tên máy trạm đã tồn tại !");
                        }
                        else{
                            int kq = con.SuaMayTram(maytramMoi);
                            if(kq==1){


                                Message msg = new Message();

                                msg.showMessage("Cập nhật thành công!");
//                                Panel_QLThe_view.loadData();
                                dispose();

                            }
                            else if (kq==2){
                                Message msg = new Message();
                                msg.showMessage("Lỗi kết nối!");

                            }
                        }
                    }
                  }
                    

                    
                    
                   
                   
                    

                }
                
            
        });
//-------------------------------------------------------------------------------btn thoát        
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
 //------------------------------------------------------------------------------- panel       
        Panel contenPanel = new Panel();
        contenPanel.setLayout(null);
        contenPanel.setBounds(480, 220, 500, 350);
        contenPanel.setBackground(new Color(255,255,255));
        contenPanel.setRadius(20);
        this.add(contenPanel);
    }
    



    

    
}
