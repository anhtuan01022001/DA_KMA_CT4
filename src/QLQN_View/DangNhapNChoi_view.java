/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLQN_View;


import QLQN_Controller.DangNhap_Controller;
import QLQN_Controller.NguoiChoi_controller;
import QLQN_Model.DangKyNguoiChoi_model;
import QLQN_Model.DangNhap_model;
import QLQN_Model.QLKH_model;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import javacode.custom.ButtonGradient;
import javacode.custom.Label;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

/**
 *
 * @author QuynhTn
 */
public class DangNhapNChoi_view extends JFrame {
    private JPanel contentPanel;
    public JLabel lblTieuDe;

    
    public DangNhapNChoi_view() {
    
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0, 0, 1400, 740);
        this.setTitle("Đăng nhập người chơi");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPanel);
        contentPanel.setLayout(null);
      
//-----------------------------------------------------------------------------------------------------------exit
        Label lblExit = new Label();
        lblExit.setBounds(1278, 14, 70, 70);
        lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-logout-rounded-64.png")));
        lblExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblExit.setRound(100);
        lblExit.setBackground(new Color(150,150,150,200));
        lblExit.setHorizontalAlignment(SwingConstants.CENTER );     
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
             @Override
            public void mouseEntered(MouseEvent e) {
                lblExit.setBackground(new Color(240,240,240));
            }

            @Override
            public void mouseExited(MouseEvent e) {
               lblExit.setBackground(new Color(150,150,150,200));
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
          
                dispose();
//                    
//                
                
                dispose();
            }
        });

        contentPanel.add(lblExit);
        
               
//-----------------------------------------------------------------------------------------------------------label thông báo
        
        JLabel lblThongBao = new JLabel();
        lblThongBao.setBounds(565,410,390,25);
        lblThongBao.setFont(new Font("Tahoma", 0, 16));
        lblThongBao.setForeground(Color.RED);
        contentPanel.add(lblThongBao);
//-----------------------------------------------------------------------------------------label tiêu đề
        JLabel lblTieuDe = new JLabel("ĐĂNG NHẬP");
        lblTieuDe.setBounds(570,140,430,40);
        lblTieuDe.setFont(new Font("Serif", 0, 36));
        lblTieuDe.setForeground(new Color(9, 14, 20));
        contentPanel.add(lblTieuDe);
        
                
        JTextField txf = new JTextField();
        txf.setBounds(20,20,0,0);
        contentPanel.add(txf);
 //------------------------------------------------------------------------------------------------------textfield userName      
        JLabel lblTong = new JLabel();
        lblTong.setBorder(new MatteBorder(0, 0, 1, 0,new Color(191,187,187)));
        lblTong.setBounds(457,110,435,180);
        contentPanel.add(lblTong);
        
        JLabel lblIconUser = new JLabel();
        lblIconUser.setBounds(457,220,50,50);
        lblIconUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-user-32.png")));
        lblIconUser.setBorder(new EmptyBorder(5, 5,5,5));
        contentPanel.add(lblIconUser);
        
        JTextField txfUserName = new JTextField("Tên tài khoản"); 
        txfUserName.setBounds(510, 214, 385, 65);
        txfUserName.setFont(new Font("Tahoma",0, 20));
        txfUserName.setForeground(new Color(85,85,85));
        txfUserName.setBackground(new Color(255,255,255));
        txfUserName.setBorder(null);
        
        txfUserName.addFocusListener(new java.awt.event.FocusAdapter() {
            
            public void focusGained(java.awt.event.FocusEvent evt) {
                
                if(txfUserName.getText().equals("Tên tài khoản")){
                     lblThongBao.setText("");
                    txfUserName.setText("");
                    txfUserName.setForeground(new Color(0,0,0));
                    lblTong.setBorder(new MatteBorder(0, 0, 1, 0,new Color(153,0,153)));
                    
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if(txfUserName.getText().equals("")){
                    txfUserName.setText("Tên tài khoản");
                    txfUserName.setForeground(new Color(85,85,85));
                    lblTong.setBorder(new MatteBorder(0, 0, 1, 0,new Color(191,187,187)));
                }
            }
        });
        contentPanel.add(txfUserName);
 //--------------------------------------------------------------------------------------------------------textfield PassWord         
        JLabel lblTong1 = new JLabel();
        lblTong1.setBorder(new MatteBorder(0, 0, 1, 0,new Color(191,187,187)));
        lblTong1.setBounds(457,335,435,60);
        contentPanel.add(lblTong1);
        
        JLabel lblIconPassword = new JLabel();
        lblIconPassword.setBounds(457,330,50,50);
        lblIconPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-lock-32.png")));
        lblIconPassword.setBorder(new EmptyBorder(5, 5,5,5));
        contentPanel.add(lblIconPassword);
        
        JPasswordField txfPassword = new JPasswordField("Mật khẩu"); 
        txfPassword.setBounds(510, 320, 385, 65);
        txfPassword.setText("Mật khẩu");
        txfPassword.setEchoChar((char) 0);
        txfPassword.setFont(new Font("Tahoma",0, 20));
        txfPassword.setForeground(new Color(85,85,85));
        txfPassword.setBorder(null);
        txfPassword.setBackground(new Color(255, 255,255));
        txfPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                String p = new String(txfPassword.getText());
          
                if(p.equals("Mật khẩu")){
                    lblThongBao.setText("");
                    txfPassword.setText("");
                    txfPassword.setEchoChar('●');
                    txfPassword.setForeground(new Color(0,0,0));
                    lblTong1.setBorder(new MatteBorder(0, 0, 1, 0,new Color(153,0,153)));
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                 String p = new String(txfPassword.getText());
                if(p.equals("")){
                    txfPassword.setText("Mật khẩu");
                     txfPassword.setEchoChar((char) 0);
                    txfPassword.setForeground(new Color(85,85,85));
                    lblTong1.setBorder(new MatteBorder(0, 0, 1, 0,new Color(191,187,187)));
                }
            }
        });
        contentPanel.add(txfPassword);    
//-------------------------------------------------------------------------------------------------------------btn Đăng nhập        
        ButtonGradient btnDangNhap = new ButtonGradient();
        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.setBounds(565, 450, 200, 50);
        btnDangNhap.setFont(new Font("sansserif",0, 23));
        btnDangNhap.setFocusPainted(false);
        btnDangNhap.setBorder(new EmptyBorder(0,0,0,0));
        btnDangNhap.setColor1(new Color(51,51,255));
        btnDangNhap.setColor2(new Color(255,51,153));
        
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String p = new String(txfPassword.getText());
                
            if(txfUserName.getText().equals("Tên tài khoản")||p.equals("Mật khẩu")|| txfUserName.getText().equals("")
                    ||p.equals("") ){
              
                lblThongBao.setText("* Bạn cần nhập đủ thông tin"); 
                
            }
            else{
                NguoiChoi_controller c = new NguoiChoi_controller();
                int id = c.IDmbName(txfUserName.getText());
            QLKH_model model = new QLKH_model();
            model.setMbName(txfUserName.getText());
            model.setPassWords(p);
            model.setMbID(id);
        
             DangNhap_Controller controler = new DangNhap_Controller();
            int kq = controler.checkLoginNguoiChoi(model);
            if(kq ==1){
                
               
               c.DoiMay1(1,model.getMbName(),model.getMbID());
               QL_NguoiChoi_view v = new QL_NguoiChoi_view(c.IDmbName(model.getMbName()));
               v.setVisible(true);
               dispose();
               Panel_QLMT_view.loadData();
             }
             else if (kq==2){

                lblThongBao.setText("* Tài khoản hoặc mật khẩu không đúng"); 
             }
            }
            }
        });       
        contentPanel.add(btnDangNhap);
        
//--------------------------------------------------------------------------------------------lbl Dang ky
        JLabel lblText = new JLabel("Bạn chưa có tài khoản? ");
        lblText.setBounds(562,515,150,25);
        lblText.setFont(new Font("Tahoma", 0, 14));
        lblText.setForeground(new Color(5,5,5));

         
        contentPanel.add(lblText);

        JLabel lblDangKy = new JLabel("Đăng ký");
        lblDangKy.setBounds(710,515,90,25);
        lblDangKy.setFont(new Font("sansserif", 2, 16));
        lblDangKy.setForeground(new Color(51,51,255));
        lblDangKy.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblDangKy.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblDangKy.setForeground(new Color(255,0,0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblDangKy.setForeground(new Color(51,51,255));
            }
            
            
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DangKyNguoiChoi_view home = new DangKyNguoiChoi_view();
                home.setVisible(true);
                dispose();
            }
        });

        contentPanel.add(lblDangKy);
        
        JLabel lblDangKy1 = new JLabel();
        lblDangKy1.setBounds(713,515,45,23);
        lblDangKy1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblDangKy1.setBorder(new MatteBorder(0, 0, 1, 0,new Color(0,0,0)));
        contentPanel.add(lblDangKy1);

//-----------------------------------------------------------------------------------------label content
        
        Label lblContent = new Label();
        lblContent.setBounds(450,117,450,455);
        lblContent.setBackground(new Color(255, 255,255));
        lblContent.setRound(55);
        contentPanel.add(lblContent);
        

        
//----------------------------------------------------------------------------------------- background
	
        JPanel panel = new JPanel(){   
            protected void paintComponent(Graphics g){
	        g.setColor( getBackground() );
	        g.fillRect(0, 0, getWidth(), getHeight());
	        super.paintComponent(g);
	    }
		};
        panel.setBounds(0, 0, 1400, 740);
	panel.setOpaque(true); 
	panel.setBackground(new Color(0,0,0,65) );
	contentPanel.add(panel);
	panel.setLayout(null);
        

        
        JLabel lblNewLabel_2 = new JLabel("");
	lblNewLabel_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/backgroundNguoiChoi (1).png")));
	lblNewLabel_2.setBounds(0, 0, 1400, 740);
	contentPanel.add(lblNewLabel_2);
        
       
        
        
    }
    
}
