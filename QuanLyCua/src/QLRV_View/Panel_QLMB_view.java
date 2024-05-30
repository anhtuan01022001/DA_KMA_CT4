
package QLRV_View;

import QLRV_Controller.QLMB_controller;
import QLRV_Controller.QLThe_controller;
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
import javacode.table.QLMB.tableQLMB;
import QLRV_Model.QLMB_model;
import static QLRV_View.Panel_QLThe_view.btnAdd;
import static QLRV_View.Panel_QLThe_view.loadData;
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
import javacode.table.QLMB.EventActionQLMB;


public class Panel_QLMB_view extends JPanel{
        private static Connection con;
        private static Locale locale =new Locale("vi","VN");
     
        private static NumberFormat format1 = NumberFormat.getInstance(locale);
      static  JPanel TopPanel = new JPanel();
       static JPanel LeftContent = new JPanel();
      public  static  JPanel RightContent = new JPanel(new MigLayout("fill","16[fill]16","16[fill]10[fill]0"));
       static JPanel headerContent = new JPanel(new MigLayout("fill","18[fill][]5[]16","0[fill]0"));
      static  JLabel lblTitleHeaderContent = new JLabel("Quản lý cửa / Quản lý thành viên");
      static  JLabel lblTableTitle = new JLabel("Dữ liệu thành viên");//
      static  tableQLMB TableLeft = new tableQLMB();
      static  JScrollPane  jScrollPane1 = new JScrollPane();
      static  EventActionQLMB even;
      static  DefaultTableModel model ;
      static  panelSearch pSearch = new panelSearch();
      static  outlineButton btnAdd = new outlineButton();
      public static AutoSearch autoSearch = new AutoSearch();
//       public  static Button btnX = new Button();
//      public  static JLabel lblTitleRight = new JLabel("Lịch sử vào/ra");
//    public  static  JPanel Right = new JPanel(new MigLayout("fill","0[fill]0","0[fill]0"));
       private  static ThemMB_view v = new ThemMB_view();
    public Panel_QLMB_view(){
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
//        RightContent.setBackground(Color.WHITE);
//        this.add(RightContent,"w 400!,gapright 16");
        
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
//   RightContent.add(lblTitleRight,"h 30!,w 100%,cell 0 0");
//   RightContent.add(btnX,"h 30!,w 30! , cell 1 0");
//        RightContent.add(Right,"h 100%,w 100%,cell 0 1 2 1");
//        
//        lblTitleRight.setFont(new Font("sansserif", 1, 16));
//        lblTitleRight.setForeground(new Color(24,24,24));
//        
//         lblTitleRight.setText("Lịch sử ra vào");
//        
//           Right.removeAll();
//        
//        btnX.setText("x");
//        btnX.setFont(new Font("Tahoma", 1, 18));
//        btnX.setForeground(new Color(140,140,140));
//        btnX.setVisible(false);
//        btnX.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                lblTitleRight.setText("Lịch sử ra vào");
//                Right.removeAll();
//                Right.revalidate();
//                  Right.repaint();
//                  btnX.setVisible(false);
//               
//            }
//        });
        
//        Right.setBackground(Color.WHITE);
//        Right.setBorder(new MatteBorder(1, 0, 0, 0, new Color(200, 200, 200)));
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
                    PreparedStatement pstm = con.prepareStatement("Select * from QLMembers where User_Name = ? ");
                    pstm.setString(1, textSearch);
                    ResultSet rs = pstm.executeQuery();
                  
                    while(rs.next()) {
                    
                        model.setRowCount(0);
                        
                             TableLeft.addRow(new QLMB_model(rs.getInt("User_ID"),rs.getString("User_Name"),rs.getString("UserData")).toRowTable(even));
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
                        Class.forName("org.sqlite.JDBC");
                        String url = "jdbc:sqlite:C:\\Users\\tuan\\Downloads\\yolov8\\detection_data.db"; 
                        con = DriverManager.getConnection(url); 
                    } catch (Exception e) {

                    }
		
		
		try {
			PreparedStatement pstm = con.prepareStatement("Select User_Name from QLMembers");
			
			
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				data1.add(rs.getString("User_Name"));
				
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
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:C:\\Users\\tuan\\Downloads\\yolov8\\detection_data.db"; 
            con = DriverManager.getConnection(url);
        } catch (Exception e) {
             
        }

	try {
		PreparedStatement pstm = con.prepareStatement("Select * from QLMembers");
		ResultSet rs = pstm.executeQuery();

		while(rs.next()) {

			 TableLeft.addRow(new QLMB_model(rs.getInt("UserID"),rs.getString("UserName"),rs.getString("UserData")).toRowTable(even));
		}
		
	} catch (SQLException e1) {
		
		e1.printStackTrace();
	}
    }
//--------------------------------------------------------------------------------------------sự kiện    
    private void evenTable() {
          even = new EventActionQLMB() {
            @Override
            public void delete(QLMB_model QLKH) {
                QLMB_controller con = new QLMB_controller();

                if(showConfirm("Bạn chắn chắn muốn xóa "+QLKH.getMbName()+" ?")){
                    
                    int kq = con.XoaNguoiChoi(QLKH);
                    if(kq == 1){

                        Message msg = new Message();
                        msg.showMessage("Xóa thành công!");
                        loadData();
                    }
                 }
            }

//              @Override
//              public void show(QLMB_model QLKH) {
//                  btnX.setVisible(true);
//                  lblTitleRight.setText("Lịch sử nạp tiền        "+QLKH.getMbName());
//                  Right.removeAll();
////                 NC_LichSuNapTien_view lichSu = new NC_LichSuNapTien_view(QLKH.getMbID());
////                 Right.add(lichSu);
//                 Right.revalidate();
//                 Right.repaint();
//              }
//            
//
//            @Override
//            public void pay(QLMB_model QLKH) {
////                NapTien_view v = new NapTien_view(QLKH.getMbName());
//                v.setVisible(true);
//                
//            }
        };
    }
    
    private void setUpTable(){
        model = new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
               "UserID" , "Tên thành viên", "Thông tin", "Hành động"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
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
                                    Panel_QLMB_view panel = new Panel_QLMB_view();
                                    JF.setContentPane(panel);
                                    JF.setVisible(true);
                                     
                                } catch (Exception e) {
					e.printStackTrace();
				}
                        }
               });       
    }                    

    
}
