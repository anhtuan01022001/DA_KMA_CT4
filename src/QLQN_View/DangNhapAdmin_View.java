
package QLQN_View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import QLQN_Model.DangNhap_model;
import QLQN_Controller.DangNhap_Controller;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import javacode.custom.ButtonGradient;
import javacode.custom.Label;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;


public class DangNhapAdmin_View extends JFrame{
    private JPanel contentPanel;
    private ButtonGradient btnDangNhap;
    private JTextField txfUserName;
    private JPasswordField txfPassword;
    
    public DangNhapAdmin_View(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0, 0, 1280, 745);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPanel);
        contentPanel.setLayout(null);
//-----------------------------------------------------------------------------------------------------------exit
       Label lblExit = new Label();
        lblExit.setBounds(1198, 14, 70, 70);
        lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-logout-rounded-64.png")));
        lblExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblExit.setRound(100);
        lblExit.setBackground(new Color(200,200,200,200));
        lblExit.setHorizontalAlignment(SwingConstants.CENTER );
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblExit.setBackground(new Color(240,240,240));
            }

            @Override
            public void mouseExited(MouseEvent e) {
               lblExit.setBackground(new Color(200,200,200,200));
            }
            
            
            public void mouseClicked(java.awt.event.MouseEvent evt) {
              
                dispose();
            }
        });

        contentPanel.add(lblExit);
        


        
//-----------------------------------------------------------------------------------------------------------tiêu đề        
        JLabel lblNewLabel = new JLabel();
	lblNewLabel.setForeground(Color.WHITE);
	lblNewLabel.setBounds(525, 130, 360, 75);
        lblNewLabel.setText("ĐĂNG NHẬP");
	lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 45));
	contentPanel.add(lblNewLabel);
///////////////////////////////////////
        JTextField txf = new JTextField();
        txf.setBounds(20,20,0,0);
        contentPanel.add(txf);
//-----------------------------------------------------------------------------------------------------------label thông báo
        
        JLabel lblThongBao = new JLabel();
        lblThongBao.setBounds(478,410,390,25);
        lblThongBao.setFont(new Font("Tahoma", 0, 13));
        lblThongBao.setForeground(Color.RED);
        contentPanel.add(lblThongBao);
        



 //------------------------------------------------------------------------------------------------------textfield userName      
        JLabel lblTong = new JLabel();
        lblTong.setBorder(new MatteBorder(0, 0, 1, 0,new Color(191,187,187)));
        lblTong.setBounds(450, 230, 390, 85);
        contentPanel.add(lblTong);
        
        JLabel lblIconUser = new JLabel();
        lblIconUser.setBounds(450,245,50,50);
        lblIconUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-user-32.png")));
        lblIconUser.setBorder(new EmptyBorder(5, 5,5,5));
        contentPanel.add(lblIconUser);
        
        JTextField txfUserName = new JTextField("Tên tài khoản"); 
        txfUserName.setBounds(500, 236, 340, 65);
        txfUserName.setFont(new Font("Tahoma",0, 20));
        txfUserName.setForeground(new Color(85,85,85));
        txfUserName.setBackground(new Color(255,255,255));
        txfUserName.setBorder(null);
        
        txfUserName.addFocusListener(new java.awt.event.FocusAdapter() {
            
            public void focusGained(java.awt.event.FocusEvent evt) {
                
                if(txfUserName.getText().equals("Tên tài khoản") ){
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
        lblTong1.setBounds(450, 322, 390, 80);
        contentPanel.add(lblTong1);
        
        JLabel lblIconPassword = new JLabel();
        lblIconPassword.setBounds(450,335,50,30);
        lblIconPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-lock-32.png")));
        lblIconPassword.setBorder(new EmptyBorder(5, 5,5,5));
        contentPanel.add(lblIconPassword);
        
        JPasswordField txfPassword = new JPasswordField("Mật khẩu"); 
        txfPassword.setBounds(500, 318, 340, 70);
        txfPassword.setText("Mật khẩu");
        txfPassword.setEchoChar((char) 0);
        txfPassword.setFont(new Font("Tahoma",0, 20));
        txfPassword.setForeground(new Color(85,85,85));
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
        btnDangNhap.setBounds(545, 450, 200, 50);
        btnDangNhap.setFont(new Font("Tahoma",0, 23));
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
                
            DangNhap_model model = new DangNhap_model();
            model.setUserName(txfUserName.getText());
            model.setPassWord(p);
        
             DangNhap_Controller controler = new DangNhap_Controller();
            int kq = controler.checkLoginAdmin(model);
            if(kq ==1){
               QL_Admin_view v = new QL_Admin_view();
               v.setVisible(true);
               dispose();
                
             }
             else if (kq==2){

                lblThongBao.setText("* Tài khoản hoặc mật khẩu không đúng"); 
             }
            }
            }
        });       
        contentPanel.add(btnDangNhap);

        
//---------------------------------------------------------------------------------------------------------background content        
	
	Label lblBackground_Boder = new Label();
	lblBackground_Boder.setBounds(445, 212, 400, 330);
	lblBackground_Boder.setRound(55);
        lblBackground_Boder.setBackground(new Color(255,255,255));
	contentPanel.add(lblBackground_Boder);
//-----------------------------------------------------------------------------------------------------------background Jframe
        JPanel panel = new JPanel(){   
            protected void paintComponent(Graphics g){
	        g.setColor( getBackground() );
	        g.fillRect(0, 0, getWidth(), getHeight());
	        super.paintComponent(g);
	    }
		};

	panel.setBounds(0, 0, 1280, 745);
	panel.setOpaque(true); 
	panel.setBackground(new Color(0,0,0,65) );
	contentPanel.add(panel);
	panel.setLayout(null);
		       
	JLabel lblNewLabel_2 = new JLabel("");
	lblNewLabel_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bgDangNhap.jpg")));
	lblNewLabel_2.setBounds(0, 0, 1280, 745);
	contentPanel.add(lblNewLabel_2);
        
//------------------------------------------------------------------------------------------------------------------------end    
    }    
   
}
