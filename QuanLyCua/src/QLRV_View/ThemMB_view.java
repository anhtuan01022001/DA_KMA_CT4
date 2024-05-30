package QLRV_View;

import QLRV_Controller.QLMB_controller;
import QLRV_Model.QLMB_model;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javacode.custom.Message;
import javacode.custom.Panel;
import javacode.custom.TextField;
import javacode.custom.outlineButton;
import javacode.custom.passwordField;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;

public class ThemMB_view extends JFrame {

	
	private JLabel lblGachB;
	private TextField txtuser;
	private passwordField txtpass;
	private passwordField txtxacnhan;
        
	private TextField txtSoTienNap;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemMB_view frame = new ThemMB_view();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ThemMB_view() {
//-------------------------------------------------------------------------------this            
		 this.setUndecorated(true);
                this.setBounds(0,0,1360,740);
                this.setBackground(new Color(0,0,0,150));
                this.setLocationRelativeTo(null);
                this.setLayout(null);
		

                
                JTextField txtTenMay1 = new JTextField();
                txtTenMay1.setBounds(0, 0, 0, 0);
                this.add(txtTenMay1);
		
//-------------------------------------------------------------------------------Tên tài khoản		
		JLabel lblNewLabel_2 = new JLabel("User ID :");
		lblNewLabel_2.setFont(new Font("sansserif", 0, 16));
		lblNewLabel_2.setBounds(383+10, 108+72, 110, 30);
		this.add(lblNewLabel_2);
		
		txtuser = new TextField();
		txtuser.setFont(new Font("sansserif", 0, 15));
		txtuser.setBounds(166+373+10, 93+72, 348, 59);
                txtuser.setRound(20);
		this.add(txtuser);
		txtuser.setColumns(10);
//-------------------------------------------------------------------------------Mật khẩu		
		JLabel lblNewLabel_2_1 = new JLabel("User Name : ");
		lblNewLabel_2_1.setFont(new Font("sansserif", 0, 16));
		lblNewLabel_2_1.setBounds(10+373+10, 192+72, 110, 30);
		this.add(lblNewLabel_2_1);
		
		txtpass = new passwordField();
		txtpass.setFont(new Font("sansserif", 0, 20));
		txtpass.setColumns(10);
                txtpass.setEchoChar('*');
		txtpass.setBounds(166+373+10, 177+72, 348, 59);
                txtpass.setRound(20);
		this.add(txtpass);
//-------------------------------------------------------------------------------Xác nhận mật khẩu		
		JLabel lblNewLabel_2_2 = new JLabel("Thông tin User :");
		lblNewLabel_2_2.setFont(new Font("sansserif", 0, 16));
		lblNewLabel_2_2.setBounds(10+373+10, 277+72, 167, 30);
		this.add(lblNewLabel_2_2);
		
		txtxacnhan = new passwordField();
		txtxacnhan.setFont(new Font("sansserif", 0, 20));
                txtxacnhan.setEchoChar('*');
		txtxacnhan.setColumns(10);
		txtxacnhan.setBounds(166+373+10, 262+72, 348, 59);
                txtxacnhan.setRound(20);
		this.add(txtxacnhan);
//-------------------------------------------------------------------------------Check box		
                JCheckBox chkThem = new JCheckBox("  Tiếp tục thêm thành viên ?");
                chkThem.setFont(new Font("sansserif",2,15));
                chkThem.setForeground(new Color(56,172,243));
                chkThem.setBounds(10+373+80+10,345+72+59+15,300,40);
                chkThem.setBackground(new Color(255,255,255));
                chkThem.setFocusPainted(false);
                this.add(chkThem);
//-------------------------------------------------------------------------------Tiêu đề                
		JLabel lblNewLabel = new JLabel("Thêm thành viên");
		lblNewLabel.setFont(new Font("sansserif", 0, 20));
		lblNewLabel.setBounds(214+373, 15+72, 167, 38);
		this.add(lblNewLabel);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setBounds(517+367, 20+72, 30, 30);
                lblIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
                lblIcon.setIcon(new ImageIcon(getClass().getResource("/Image/cross.png")));
                 lblIcon.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            dispose();
                        }
                    });
		
		this.add(lblIcon);
//-------------------------------------------------------------------------------nút Thêm		
		outlineButton btnThem = new outlineButton();
                btnThem.setText("Thêm");
                
		btnThem.setFont(new Font("sansserif", 0, 15));
		btnThem.setBounds(330+373, 474+72+20, 85, 45);
                btnThem.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnThem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                        String user = txtuser.getText();
                        String pass = txtpass.getText();
                        String confirmpass = txtxacnhan.getText();
                        String sotiennap = txtSoTienNap.getText();
                
                if(user.equals("")||pass.equals("")||confirmpass.equals("")||sotiennap.equals("")){

                    Message msg = new Message();
                    msg.showMessage("Bạn cần nhập đủ thông tin!");
                }
                else{
                    try {
                       int Sotiennap = Integer.parseInt(sotiennap);
                       if(Sotiennap%1000 !=0){
                           Message msg = new Message();
                            msg.showMessage("Nhập sai định dạng tiền!");
                       }
                       else{
                           if(pass.equals(confirmpass)){
                             QLMB_model khachhang = new QLMB_model();
                             khachhang.setMbName(user);
                             
                             QLMB_controller con = new QLMB_controller();
                             int kq = con.CheckTenNguoiChoi(khachhang);
                             
                             if(kq==1){
                                Message msg = new Message();
                                msg.showMessage("Tên thành viên đã tồn tại!");
                             }
                             else if (kq ==2){
                                 int rs = con.ThemNguoiChoi(khachhang);
                                 if(rs==1){
                                     
                                     Message msg = new Message();
                                     msg.showMessage("Thêm mới thành công!");
                                     if(chkThem.isSelected()){
                                         txtuser.setText("");
                                         txtpass.setText("");
                                         txtxacnhan.setText("");
                                         txtSoTienNap.setText("");
                                         
                                     }
                                     else{
                                         Panel_QLMB_view.loadData();
                                         dispose();
                                     }
                                     
                                 }
                                 else if(rs==2){
                                     Message msg = new Message();
                                     msg.showMessage("Lỗi kết nối!");
                                 }
                                 
                             }
                             else if(kq==3){
                                Message msg = new Message();
                            msg.showMessage("Lỗi kết nối!"); 
                             }
                               
                               
                               
                           }
                           else{
                               Message msg = new Message();
                            msg.showMessage("Mật khẩu xác nhận không đúng!");
                           }
                       }
                       
                    } catch (NumberFormatException e1) {
                         Message msg = new Message();
                            msg.showMessage("Nhập sai định dạng tiền!");
                        
                    }
                }
                    }
                });
		this.add(btnThem);
//------------------------------------------------------------------------------- nút thoát		
		outlineButton btnThoat = new outlineButton();
		btnThoat.setFont(new Font("sansserif", 0, 15));
                btnThoat.setText("Thoát");
                btnThoat.setBoderColor(Color.DARK_GRAY);
                btnThoat.setForeground(Color.DARK_GRAY);
                btnThoat.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnThoat.setBounds(430+373, 474+72+20, 85, 45);
                btnThoat.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                       dispose();
                    }
                });
		this.add(btnThoat);
                
//-------------------------------------------------------------------------------gạch dưới                
		lblGachB = new JLabel("");
		lblGachB.setBounds(373, 454+72+20, 550, 68);
                lblGachB.setBorder(new MatteBorder(1, 0, 0, 0,new Color(191,187,187)));
		this.add(lblGachB);
//-------------------------------------------------------------------------------gạch trên		
		JLabel lblgachTop = new JLabel("");
		lblgachTop.setBounds(373, 0+72, 550, 68);
                lblgachTop.setBorder(new MatteBorder(0, 0, 1, 0,new Color(191,187,187)));
		this.add(lblgachTop);
//-------------------------------------------------------------------------------panel content                
                Panel panel = new Panel();
		panel.setBackground(new Color(255,255,255));
                panel.setRadius(20);
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(373, 72, 550, 550);
		this.add(panel);
		panel.setLayout(null);
	}
}