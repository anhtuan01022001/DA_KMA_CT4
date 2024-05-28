
package QLQN_View;

import QLQN_Controller.QLKH_controller;
import QLQN_Controller.QLMayTram_controller;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javacode.custom.Button;
import javacode.custom.TextField;
import javacode.custom.outlineButton;
import javacode.custom.panelSearch;
import javacode.table.QLKH.EventActionQLKH;
import javacode.table.QLKH.tableQLKH;
import QLQN_Model.QLKH_model;
import static QLQN_View.Panel_QLMT_view.btnAdd;
import static QLQN_View.Panel_QLMT_view.loadData;
import java.awt.Cursor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javacode.AutoSearch.AutoSearch;
import javacode.custom.Confirm;
import javacode.custom.Message;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;


public class Panel_QLKH_view extends JPanel{
        private static Connection con;
        private static Locale locale =new Locale("vi","VN");
     
        private static NumberFormat format1 = NumberFormat.getInstance(locale);
      static  JPanel TopPanel = new JPanel();
       static JPanel LeftContent = new JPanel();
      public  static  JPanel RightContent = new JPanel(new MigLayout("fill","16[fill]16","16[fill]10[fill]0"));
       static JPanel headerContent = new JPanel(new MigLayout("fill","18[fill][]5[]16","0[fill]0"));
      static  JLabel lblTitleHeaderContent = new JLabel("Quản lý quán nét / Quản lý người chơi");
      static  JLabel lblTableTitle = new JLabel("Dữ liệu người chơi");
      static  tableQLKH TableLeft = new tableQLKH();
      static  JScrollPane  jScrollPane1 = new JScrollPane();
      static  EventActionQLKH even;
      static  DefaultTableModel model ;
      static  panelSearch pSearch = new panelSearch();
      static  outlineButton btnAdd = new outlineButton();
      public static AutoSearch autoSearch = new AutoSearch();
       public  static Button btnX = new Button();
      public  static JLabel lblTitleRight = new JLabel("Lịch sử nạp tiền");
    public  static  JPanel Right = new JPanel(new MigLayout("fill","0[fill]0","0[fill]0"));
       private  static ThemNguoiChoi_view v = new ThemNguoiChoi_view();
    public Panel_QLKH_view(){
        this.setLayout(new MigLayout("fill","0[fill]16[fill]0","0[fill]0"));
        
        
        
//-----------------------------------------------------------------------------------------------------Panel trên đầu        
        TopPanel = new JPanel();
        TopPanel.setLayout(new MigLayout("fill","0[]0","0[]0[100%]0"));
        
        this.add(TopPanel,"h 100!,span,grow");
        
//----------------------------------------------------------------------------------------------------- content bên trái                
        LeftContent.setLayout(new MigLayout("fill","10[fill]10","10[fill]10"));
        LeftContent.setBackground(Color.white);
        this.add(LeftContent,"h 100% , w 100%,gapleft 27");
        
//-----------------------------------------------------------------------------------------------------content bên phải         
        RightContent.setBackground(Color.WHITE);
        this.add(RightContent,"w 400!,gapright 16");
        
//------------------------------------------------------------------------------------------------------  btn thêm      
        
        headerContent.setBackground(new Color(252,252,252));
        headerContent.setBorder(new MatteBorder(1, 0, 0, 0, new Color(140, 140, 140, 40)));
        TopPanel.add(headerContent,"h 48!,span,grow,top");
        
        btnAdd.setIcon(new ImageIcon(getClass().getResource("/Image/plus (2).png")));
        btnAdd.setText("Thêm");
        btnAdd.setFont(new Font("sansserif", 0, 17));
        btnAdd.setIconTextGap(10);
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
         
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              
              
              

               if(!v.isVisible()){
              v.setVisible(true);
              }
               else{
                   v.toFront();
               }
               
              
              
            }
        }); 
        TopPanel.add(btnAdd,"w 100!,h 40!,right,gapright 45");
//-----------------------------------------------------------------------------------------------------chủ đề của Panel nội dung chính         
       lblTitleHeaderContent.setBounds(0, 0, 200, 25);
       lblTitleHeaderContent.setFont(new Font("sansserif",1,15));
       lblTitleHeaderContent.setForeground(new Color(4,72,210));
       headerContent.add(lblTitleHeaderContent,"w 100%,h 100%,center");
       headerContent.add(pSearch,"h 36!,w 400!,right");
//------------------------------------------------------------------------------------------------------
       lblTableTitle.setFont(new Font("sansserif",1,16));
       lblTableTitle.setForeground(new Color(76,76,76));
       LeftContent.add(lblTableTitle,"h 30!,span,grow");
 
//------------------------------------------------------------------------------------------------------       
        LeftContent.add(jScrollPane1,"w 100%,h 100%");

//------------------------------------------------------------------------------------------------------     
   RightContent.add(lblTitleRight,"h 30!,w 100%,cell 0 0");
   RightContent.add(btnX,"h 30!,w 30! , cell 1 0");
        RightContent.add(Right,"h 100%,w 100%,cell 0 1 2 1");
        
        lblTitleRight.setFont(new Font("sansserif", 1, 16));
        lblTitleRight.setForeground(new Color(24,24,24));
        
         lblTitleRight.setText("Lịch sử nạp tiền");
        
           Right.removeAll();
        
        btnX.setText("x");
        btnX.setFont(new Font("Tahoma", 1, 18));
        btnX.setForeground(new Color(140,140,140));
        btnX.setVisible(false);
        btnX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblTitleRight.setText("Lịch sử nạp tiền");
                Right.removeAll();
                Right.revalidate();
                  Right.repaint();
                  btnX.setVisible(false);
               
            }
        });
        
        Right.setBackground(Color.WHITE);
        Right.setBorder(new MatteBorder(1, 0, 0, 0, new Color(200, 200, 200)));
//------------------------------------------------------------------------------------------------------             
        
        setUpTable();
        evenTable();
        loadData();     
        ActionSearch();
        DataSearch();
    }
    
    private void ActionSearch(){
        pSearch.EvenSearch(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textSearch = pSearch.getText();
                try {
                    PreparedStatement pstm = con.prepareStatement("Select * from AccountMember where MbName = ? ");
                    pstm.setString(1, textSearch);
                    ResultSet rs = pstm.executeQuery();
                    
                    while(rs.next()) {
                        model.setRowCount(0);
                        
                             TableLeft.addRow(new QLKH_model(rs.getInt("MbID"),rs.getString("MbName") ,rs.getString("PassWords"),rs.getInt("SoTienNap")).toRowTable(even));
                    }
		
	} catch (SQLException e1) {
		
		e1.printStackTrace();
	}
            }
        });
    }
    public void DataSearch(){
        List<String> data1 = new ArrayList();
        try {
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QUAN_NET;user=sa;password=Nq25142001");  
                    } catch (Exception e) {

                    }
		
		
		try {
			PreparedStatement pstm = con.prepareStatement("Select MbName from AccountMember");
			
			
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				data1.add(rs.getString("MbName"));
				
                        }
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
                
        autoSearch.setData(data1, pSearch.txtSearch);
        
    }
    
    public static void loadData(){
        model.setRowCount(0);
    
         try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QUAN_NET;user=sa;password=Nq25142001");  
        } catch (Exception e) {
             
        }

	try {
		PreparedStatement pstm = con.prepareStatement("Select * from AccountMember ");
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			 TableLeft.addRow(new QLKH_model(rs.getInt("MbID"),rs.getString("MbName") ,rs.getString("PassWords"),rs.getInt("SoTienNap")).toRowTable(even));
		}
		
	} catch (SQLException e1) {
		
		e1.printStackTrace();
	}
    }
//--------------------------------------------------------------------------------------------sự kiện    
    private void evenTable() {
          even = new EventActionQLKH() {
            @Override
            public void delete(QLKH_model QLKH) {
                QLKH_controller con = new QLKH_controller();

                if(showConfirm("Bạn chắn chắn muốn xóa "+QLKH.getMbName()+" ?")){
                    
                    int kq = con.XoaNguoiChoi(QLKH);
                    if(kq == 1){

                        Message msg = new Message();
                        msg.showMessage("Xóa thành công!");
                        loadData();
                    }
                 }
            }

              @Override
              public void show(QLKH_model QLKH) {
                  btnX.setVisible(true);
                  lblTitleRight.setText("Lịch sử nạp tiền        "+QLKH.getMbName());
                  Right.removeAll();
                 NC_LichSuNapTien_view lichSu = new NC_LichSuNapTien_view(QLKH.getMbID());
                 Right.add(lichSu);
                 Right.revalidate();
                 Right.repaint();
              }
            

            @Override
            public void pay(QLKH_model QLKH) {
                NapTien_view v = new NapTien_view(QLKH.getMbName());
                v.setVisible(true);
                
            }
        };
    }
    
    private void setUpTable(){
        model = new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên tài khoản", "Số tiền", "Hành động"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        TableLeft.setModel(model);
        
         jScrollPane1.setViewportView(TableLeft);
        
        TableLeft.fixTable(jScrollPane1); // sửa cái jScrooll
       
        
    }
        private boolean showConfirm(String message) {
        Confirm obj = new Confirm(QL_Admin_view.getFrames()[1],true);
        obj.showConfirm(message);
        return obj.isOk();
    }

    
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                                    JFrame JF = new JFrame();
                                    JF.setDefaultCloseOperation(JF.EXIT_ON_CLOSE);
                                    JF.setSize(1000, 800);
                                    JF.setLocationRelativeTo(null);
                                    Panel_QLKH_view panel = new Panel_QLKH_view();
                                    JF.setContentPane(panel);
                                    JF.setVisible(true);
                                     
                                } catch (Exception e) {
					e.printStackTrace();
				}
                        }
               });       
    }                    

    
}
