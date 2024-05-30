package QLRV_View;

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
import javacode.custom.Panel;
import javacode.custom.TextField;
import javacode.custom.outlineButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.border.MatteBorder;

public class SuaMB_view extends JFrame {

	
	private JLabel lblGachB;
	private TextField txtuser;
	private TextField txtpassCu;
	private TextField txtxacnhan;
	private TextField txtSoTienNap;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuaMB_view frame = new SuaMB_view();
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
	public SuaMB_view() {
//-------------------------------------------------------------------------------this
		 this.setUndecorated(true);
                this.setBounds(0,0,1360,740);
                this.setBackground(new Color(0,0,0,150));
                this.setLayout(null);
		

                
                JTextField txtTenMay1 = new JTextField();
                txtTenMay1.setBounds(0, 0, 0, 0);
                this.add(txtTenMay1);
//-------------------------------------------------------------------------------Tên tài khoản		
		
		JLabel lblNewLabel_2 = new JLabel("Tên tài khoản :");
		lblNewLabel_2.setFont(new Font("sansserif", 0, 16));
		lblNewLabel_2.setBounds(383, 108+72, 110, 30);
		this.add(lblNewLabel_2);
		
		txtuser = new TextField();
		txtuser.setFont(new Font("sansserif", 0, 15));
		txtuser.setBounds(166+373, 93+72, 348, 59);
                txtuser.setRound(20);
		this.add(txtuser);
		txtuser.setColumns(10);
//-------------------------------------------------------------------------------Mật khẩu cũ		
		JLabel lblNewLabel_2_1 = new JLabel("Mật khẩu cũ : ");
		lblNewLabel_2_1.setFont(new Font("sansserif", 0, 16));
		lblNewLabel_2_1.setBounds(10+373, 192+72, 110, 30);
		this.add(lblNewLabel_2_1);
		
		txtpassCu = new TextField();
		txtpassCu.setFont(new Font("sansserif", 0, 15));
		txtpassCu.setColumns(10);
		txtpassCu.setBounds(166+373, 177+72, 348, 59);
                txtpassCu.setRound(20);
		this.add(txtpassCu);
		
		JLabel lblNewLabel_2_2 = new JLabel("Mật khẩu mới :");
		lblNewLabel_2_2.setFont(new Font("sansserif", 0, 16));
		lblNewLabel_2_2.setBounds(10+373, 277+72, 167, 30);
		this.add(lblNewLabel_2_2);
		
		txtxacnhan = new TextField();
		txtxacnhan.setFont(new Font("sansserif", 0, 15));
		txtxacnhan.setColumns(10);
		txtxacnhan.setBounds(166+373, 262+72, 348, 59);
                txtxacnhan.setRound(20);
		this.add(txtxacnhan);
		
		JLabel lblNewLabel_2_3 = new JLabel("Số tiền nạp :");
		lblNewLabel_2_3.setFont(new Font("sansserif", 0, 16));
		lblNewLabel_2_3.setBounds(10+373, 360+72, 110, 30);
		this.add(lblNewLabel_2_3);
		
		txtSoTienNap = new TextField();
		txtSoTienNap.setFont(new Font("sansserif", 0, 15));
		txtSoTienNap.setColumns(10);
                txtSoTienNap.setBounds(166+373, 345+72, 348, 59);
                txtSoTienNap.setRound(20);
		this.add(txtSoTienNap);
		
                JCheckBox chkThem = new JCheckBox("  Tiếp tục thêm máy trạm ?");
                chkThem.setFont(new Font("sansserif",2,15));
                chkThem.setForeground(new Color(56,172,243));
                chkThem.setBounds(10+373+80,345+72+59+15,300,40);
                chkThem.setBackground(new Color(255,255,255));
                chkThem.setFocusPainted(false);
                this.add(chkThem);
                
		JLabel lblNewLabel = new JLabel("Thêm người chơi");
		lblNewLabel.setFont(new Font("sansserif", 0, 20));
		lblNewLabel.setBounds(214+373, 15+72, 167, 38);
		this.add(lblNewLabel);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setBounds(517+373, 10+72, 30, 30);
                lblIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
                lblIcon.setIcon(new ImageIcon(getClass().getResource("/Image/cross.png")));
                 lblIcon.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            dispose();
                        }
                    });
		
		this.add(lblIcon);
		
		outlineButton btnThem = new outlineButton();
                btnThem.setText("Thêm");
                
		btnThem.setFont(new Font("sansserif", 0, 15));
		btnThem.setBounds(330+373, 474+72+20, 85, 45);
                btnThem.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnThem.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                       dispose();
                    }
                });
		this.add(btnThem);
		
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
                
                
		lblGachB = new JLabel("");
		lblGachB.setBounds(373, 454+72+20, 550, 68);
                lblGachB.setBorder(new MatteBorder(1, 0, 0, 0,new Color(191,187,187)));
		this.add(lblGachB);
		
		JLabel lblgachTop = new JLabel("");
		lblgachTop.setBounds(373, 0+72, 550, 68);
                lblgachTop.setBorder(new MatteBorder(0, 0, 1, 0,new Color(191,187,187)));
		this.add(lblgachTop);
                
                Panel panel = new Panel();
		panel.setBackground(new Color(255,255,255));
                panel.setRadius(20);
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(373, 72, 550, 550);
		this.add(panel);
		panel.setLayout(null);
	}
}