package QLQN_View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import javacode.custom.Label;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;


/**
 *
 * @author QuynhTn
 */
public class Home extends JFrame{
    private JPanel contentPanel;

    public Home(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0, 0, 1024, 540);
        this.setLocationRelativeTo(null);
        this.setTitle("Home");
        this.setResizable(false);
        
        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5,0,5,5));
        setContentPane(contentPanel);
        contentPanel.setLayout(null);
//---------------------------------------------------------------------------------------------------chữ góc trái        
        JLabel lblText = new JLabel("Quản lý");
        lblText.setBounds(35,273,250,80);
        lblText.setFont(new Font("Arial",1, 68));
        lblText.setForeground(new Color(250,250,250));
        contentPanel.add(lblText);
        
        JLabel lblText1 = new JLabel("Quán NET");
        lblText1.setBounds(30,350,350,80);
        lblText1.setFont(new Font("Arial",1, 70));
        lblText1.setForeground(new Color(250,250,250));
        contentPanel.add(lblText1);
        
        JLabel lblText0 = new JLabel();
        lblText0.setBounds(40,350,240,80);
        lblText0.setBorder(new MatteBorder(0, 0, 2, 0,new Color(220,220,220)));
        contentPanel.add(lblText0);
        
        JLabel lblText2 = new JLabel("By nhóm 2_L02");
        lblText2.setBounds(50,410,350,80);
        lblText2.setFont(new Font("Arial",2, 20));
        lblText2.setForeground(new Color(250,250,250));
        contentPanel.add(lblText2);
//-----------------------------------------------------------------------------------------------lable chọn  admin     

        JLabel lblAdmin = new JLabel();
	lblAdmin.setBounds(537, 240, 65,65);
        lblAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-admin-settings-male-64.png")));
	lblAdmin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
             DangNhapAdmin_View admin = new DangNhapAdmin_View();
             admin.setVisible(true);
            }
        });
        contentPanel.add(lblAdmin);
        
        Label lblAdmin0 = new Label();
	lblAdmin0.setBounds(520, 228, 90,90);
        lblAdmin0.setRound(100);
        lblAdmin0.setBackground(new Color(220,220,220));
        contentPanel.add(lblAdmin0);
        
       
        JLabel lblAdmin1 = new JLabel("Quản trị Admin");
	lblAdmin1.setBounds(500, 340, 180,20);
        lblAdmin1.setFont(new Font("Calibri",1, 22));
        lblAdmin1.setForeground(new Color(54,54,54));
	contentPanel.add(lblAdmin1);
        
        JLabel lblBackground = new JLabel();
	lblBackground.setBackground(new Color(250,250,250));
	lblBackground.setOpaque(true);
	lblBackground.setBounds(495, 260, 150, 100);
	contentPanel.add(lblBackground);
        
	Label lblBackground_Boder = new Label();
	lblBackground_Boder.setBounds(450, 212, 230,180);
	lblBackground_Boder.setRound(55);
        lblBackground_Boder.setBackground(new Color(250,250,250));
	contentPanel.add(lblBackground_Boder);
        
//--------------------------------------------------------------------------------------------lable chọn người chơi        
        
        JLabel lblNguoiChoi = new JLabel();
	lblNguoiChoi.setBounds(815, 238, 70,70);
        lblNguoiChoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-businessman-64.png")));
        lblNguoiChoi.setCursor(new Cursor(Cursor.HAND_CURSOR));
	lblNguoiChoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DangNhapNChoi_view nguoichoi = new DangNhapNChoi_view();
                nguoichoi.setVisible(true);
            }
        });
        
        contentPanel.add(lblNguoiChoi);
        
        Label lblNguoiChoi0 = new Label();
	lblNguoiChoi0.setBounds(800, 232, 90,90);
        lblNguoiChoi0.setRound(100);
        lblNguoiChoi0.setBackground(new Color(220,220,220));
	contentPanel.add(lblNguoiChoi0);
        
        JLabel lblNguoiChoi1 = new JLabel("Quản trị Người chơi");
	lblNguoiChoi1.setBounds(750, 340, 280,20);
        lblNguoiChoi1.setFont(new Font("Calibri",1, 22));
        lblNguoiChoi1.setForeground(new Color(54,54,54));
	contentPanel.add(lblNguoiChoi1);
        
        JLabel lblBackground1 = new JLabel();
	lblBackground1.setBackground(new Color(250,250,250));
	lblBackground1.setOpaque(true);
	lblBackground1.setBounds(775, 260, 150, 100);
        
	contentPanel.add(lblBackground1);	
	Label lblBackground_Boder1 = new Label();
	lblBackground_Boder1.setBounds(730, 212, 230,180);	
        lblBackground_Boder.setRound(55);
        lblBackground_Boder1.setBackground(new Color(250,250,250));
	contentPanel.add(lblBackground_Boder1);
//-------------------------------------------------------------------------------------------background của JFrame        
        
        JPanel panel = new JPanel(){   
            protected void paintComponent(Graphics g){
	        g.setColor( getBackground() );
	        g.fillRect(0, 0, getWidth(), getHeight());
	        super.paintComponent(g);
	    }
		};

	panel.setBounds(0, 0, 1024, 512);
	panel.setOpaque(true); // background of parent will be painted first
	panel.setBackground(new Color(0,0,0,72) );
	contentPanel.add(panel);
	panel.setLayout(null);
                 
	JLabel lblNewLabel_2 = new JLabel("");
	lblNewLabel_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/02-Post-Featured-IMG.jpg")));
	lblNewLabel_2.setBounds(0, 0, 1024, 512);
	contentPanel.add(lblNewLabel_2);
 //------------------------------------------------------------------------------------------------------------end         
        
    }
    
    
    

    
}
