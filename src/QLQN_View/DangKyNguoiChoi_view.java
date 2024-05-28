/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLQN_View;

import QLQN_Controller.DangKyNguoiChoi_Controller;
import QLQN_Controller.DangNhap_Controller;
import QLQN_Model.DangKyNguoiChoi_model;
import QLQN_Model.DangNhap_model;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import javacode.custom.ButtonGradient;
import javacode.custom.Label;
import javacode.custom.Message;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;


/**
 *
 * @author QuynhTn
 */

public class DangKyNguoiChoi_view extends JFrame{
    private JPanel contentPanel;
    
     public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangKyNguoiChoi_view frame = new DangKyNguoiChoi_view();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
     Color color1 = new Color(255,255,255);
        
    public DangKyNguoiChoi_view(){
        
    
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0, 0, 1400, 740);
        this.setTitle("Đăng nhập người chơi");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPanel);
        contentPanel.setLayout(null);
      
         
//-----------------------------------------------------------------------------------------------------------label thông báo
        
        JLabel lblThongBao = new JLabel();
        lblThongBao.setBounds(575,460,390,25);
        lblThongBao.setFont(new Font("Tahoma", 2, 14));
        lblThongBao.setForeground(new Color(219,76,21));
        contentPanel.add(lblThongBao);
//-----------------------------------------------------------------------------------------label tiêu đề
//        JLabel lblTieuDe = new JLabel("ĐĂNG KÝ");
//        lblTieuDe.setBounds(620,60,430,40);
//        lblTieuDe.setFont(new Font("Serif", 0, 36));
//        lblTieuDe.setForeground(new Color(9, 14, 20));
//        contentPanel.add(lblTieuDe);
        
                
        JTextField txf = new JTextField();
        txf.setBounds(20,20,0,0);
        contentPanel.add(txf);
 //------------------------------------------------------------------------------------------------------textfield userName      
        JLabel lblTong = new JLabel();
        lblTong.setBorder(new MatteBorder(0, 0, 1, 0,new Color(191,187,187)));
        lblTong.setBounds(565,80,340,180);
        contentPanel.add(lblTong);
        
        JLabel lblIconUser = new JLabel();
        lblIconUser.setBounds(570,190,50,50);
        lblIconUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-user-32.png")));
        lblIconUser.setBorder(new EmptyBorder(5, 5,5,5));
        contentPanel.add(lblIconUser);
        
        JTextField txfUserName = new JTextField("Tên tài khoản"); 
        txfUserName.setBounds(615, 185, 290, 65);
        txfUserName.setFont(new Font("Tahoma",0, 20));
        txfUserName.setForeground(new Color(74,126,171));
        txfUserName.setBackground(new Color(255,255,255));
        txfUserName.setBorder(null);
        
        txfUserName.addFocusListener(new java.awt.event.FocusAdapter() {
            
            public void focusGained(java.awt.event.FocusEvent evt) {
                
                if(txfUserName.getText().equals("Tên tài khoản") ){
                    lblThongBao.setText("");
                    txfUserName.setText("");
                    txfUserName.setForeground(new Color(0,0,0));
                    lblTong.setBorder(new MatteBorder(0, 0, 2, 0,new Color(90,5,40)));
                    
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if(txfUserName.getText().equals("")){
                    txfUserName.setText("Tên tài khoản");
                    txfUserName.setForeground(new Color(74,126,171));
                    lblTong.setBorder(new MatteBorder(0, 0, 1, 0,new Color(191,187,187)));
                }
            }
        });
        contentPanel.add(txfUserName);
 //--------------------------------------------------------------------------------------------------------textfield PassWord         
        JLabel lblTong1 = new JLabel();
        lblTong1.setBorder(new MatteBorder(0, 0, 1, 0,new Color(191,187,187)));
        lblTong1.setBounds(565,290,340,60);
        contentPanel.add(lblTong1);
        
        JLabel lblIconPassword = new JLabel();
        lblIconPassword.setBounds(570,280,50,50);
        lblIconPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-lock-32.png")));
        lblIconPassword.setBorder(new EmptyBorder(5, 5,5,5));
        contentPanel.add(lblIconPassword);
        
        JPasswordField txfPassword = new JPasswordField("Mật khẩu"); 
        txfPassword.setBounds(615, 275, 290, 65);
        txfPassword.setText("Mật khẩu");
        txfPassword.setEchoChar((char) 0);
        txfPassword.setFont(new Font("Tahoma",0, 20));
        txfPassword.setForeground(new Color(74,126,171));
        txfPassword.setBorder(null);
        txfPassword.setBackground(new Color(255,255,255));
        txfPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                String p = new String(txfPassword.getText());
          
                if(p.equals("Mật khẩu")){
                    lblThongBao.setText("");
                    txfPassword.setText("");
                    txfPassword.setEchoChar('●');
                    txfPassword.setForeground(new Color(0,0,0));
                    lblTong1.setBorder(new MatteBorder(0, 0, 2, 0,new Color(90,5,40)));
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                 String p = new String(txfPassword.getText());
                if(p.equals("")){
                    txfPassword.setText("Mật khẩu");
                     txfPassword.setEchoChar((char) 0);
                    txfPassword.setForeground(new Color(74,126,171));
                    lblTong1.setBorder(new MatteBorder(0, 0, 1, 0,new Color(191,187,187)));
                }
            }
        });
        contentPanel.add(txfPassword);  
        
 //--------------------------------------------------------------------------------------------------------textfield confirmPassWord         
        JLabel lblTong2 = new JLabel();
        lblTong2.setBorder(new MatteBorder(0, 0, 1, 0,new Color(191,187,187)));
        lblTong2.setBounds(565,390,340,60);
        contentPanel.add(lblTong2);
        
        JLabel lblIconPassword1 = new JLabel();
        lblIconPassword1.setBounds(570,370,50,50);
        lblIconPassword1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-lock-32.png")));
        lblIconPassword1.setBorder(new EmptyBorder(5, 5,5,5));
        contentPanel.add(lblIconPassword1);
        
        JPasswordField txfconfirmPassword = new JPasswordField("Xác nhận mật khẩu"); 
        txfconfirmPassword.setBounds(615, 365, 290, 65);
        txfconfirmPassword.setText("Xác nhận mật khẩu");
        txfconfirmPassword.setEchoChar((char) 0);
        txfconfirmPassword.setFont(new Font("Tahoma",0, 20));
        txfconfirmPassword.setForeground(new Color(74,126,171));
        txfconfirmPassword.setBorder(null);
        txfconfirmPassword.setBackground(new Color(255,255,255  ));
        txfconfirmPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                String cp = new String(txfconfirmPassword.getText());
          
                if(cp.equals("Xác nhận mật khẩu")){
                    lblThongBao.setText("");
                    txfconfirmPassword.setText("");
                    txfconfirmPassword.setEchoChar('●');
                    txfconfirmPassword.setForeground(new Color(0,0,0));
                    lblTong2.setBorder(new MatteBorder(0, 0, 2, 0,new Color(90,5,40)));
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                 String cp = new String(txfconfirmPassword.getText());
                if(cp.equals("")){
                    txfconfirmPassword.setText("Xác nhận mật khẩu");
                     txfconfirmPassword.setEchoChar((char) 0);
                    txfconfirmPassword.setForeground(new Color(74,126,171));
                    lblTong2.setBorder(new MatteBorder(0, 0, 1, 0,new Color(191,187,187)));
                }
            }
        });
        contentPanel.add(txfconfirmPassword);
//-------------------------------------------------------------------------------------------------------------btn Đăngký        
        ButtonGradient btnDangNhap = new ButtonGradient();
        btnDangNhap.setText("Đăng ký");
        btnDangNhap.setBounds(630, 490, 200, 50);
        btnDangNhap.setFont(new Font("Tahoma",0, 23));
        btnDangNhap.setFocusPainted(false);
        btnDangNhap.setBorder(new EmptyBorder(0,0,0,0));
        btnDangNhap.setColor1(new Color(1,25,35));
        btnDangNhap.setColor2(new Color(137,162,170));
        
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int k;
                String p = new String(txfPassword.getText());
                String cp = new String(txfconfirmPassword.getText());
                
            if(txfUserName.getText().equals("Tên tài khoản")||p.equals("Mật khẩu")|| txfUserName.getText().equals("")
                    ||p.equals("") || cp.equals("")|| cp.equals("Xác nhận mật khẩu") ){
              
                Message msg = new Message();
                    msg.showMessage("Bạn cần nhập đủ thông tin!");
//                lblThongBao.setText("* Bạn cần nhập đủ thông tin"); 
                
            }
            else if (p.equals(cp)){
                DangKyNguoiChoi_model member = new DangKyNguoiChoi_model();
                member.setMbName(txfUserName.getText());
                member.setPassWord(p);
                member.setSoTienNap("");
                
                DangKyNguoiChoi_Controller MbControl = new DangKyNguoiChoi_Controller();
//                DangNhap_Controller check = new DangNhap_Controller();
                
                int chk = MbControl.checkLoginNguoiChoi(member);
                System.out.println(chk);
                if(chk == 1){
                    lblThongBao.setText("* Tài khoản đã tồn tại"); 
                }
                else {
                    k = MbControl.Insert_Member(member);
                    System.out.println(k);
                    if(k == 1){
                        
                        DangNhapNChoi_view m = new DangNhapNChoi_view();
                        m.setVisible(true);
                        
                        dispose();
                        Panel_QLKH_view.loadData();
                        Message msg = new Message();
                        msg.setLocationRelativeTo(m);
                        msg.showMessage("Đăng ký thành công !");
                        
                    }
                }

                }
                
                
                
                
            
            
            
            else {
                
                lblThongBao.setText("* Mật khẩu xác nhận không đúng"); 
             
            }
            }
        });       
        contentPanel.add(btnDangNhap);
        
//--------------------------------------------------------------------------------------------lbl Dang ky
        JLabel lblText = new JLabel("Bạn đã có tài khoản? ");
        lblText.setBounds(612,550,136,25);
        lblText.setFont(new Font("Tahoma", 0, 14));
        lblText.setForeground(new Color(5,5,5));
        contentPanel.add(lblText);

        JLabel lblDangKy = new JLabel("Đăng nhập");
        lblDangKy.setBounds(743,550,90,25);
        lblDangKy.setFont(new Font("sansserif", 2, 16));
        lblDangKy.setForeground(new Color(0,107,255));
        lblDangKy.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblDangKy.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
//                lblDangKy.setFont(new Font("sansserif", 2, 18));
                 lblDangKy.setForeground(new Color(255,0,0));
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
              lblDangKy.setFont(new Font("sansserif", 2, 16));
        lblDangKy.setForeground(new Color(0,107,255));
            }
            
            
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DangNhapNChoi_view home = new DangNhapNChoi_view();
                home.setVisible(true);
                dispose();
            }
        });

        contentPanel.add(lblDangKy);
        
        JLabel lblDangKy1 = new JLabel();
        lblDangKy1.setBounds(745,550,69,23);
        lblDangKy1.setBorder(new MatteBorder(0, 0, 1, 0,new Color(21,53,63)));
        contentPanel.add(lblDangKy1);

//-----------------------------------------------------------------------------------------label content

        Label lblContent = new Label();
        lblContent.setBounds(560,157,350,457);
        lblContent.setBackground(new Color(255,255,255));
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
	panel.setBackground(new Color(255,255,255,15) );
	contentPanel.add(panel);
	panel.setLayout(null);
        

        
        JLabel lblNewLabel_2 = new JLabel("");
	lblNewLabel_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/dangkynguoichoi.jpg")));
	lblNewLabel_2.setBounds(0, 0, 1400, 740);
	contentPanel.add(lblNewLabel_2);
        
       
        
        
        
    }    
        
        
        
        
        
}
