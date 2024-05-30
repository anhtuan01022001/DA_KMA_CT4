
package QLRV_View;

import QLRV_Controller.MB_controller;
import QLRV_Controller.QLLS_controller;
import QLRV_Model.QLMB_model;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javacode.custom.Button;
import javacode.custom.TextField;
import javacode.custom.outlineButton;
import javacode.custom.panelSearch;
import javacode.table.QLLS.tableQLLS;
import QLRV_Model.QLLS_model;
import static QLRV_View.Panel_QLMB_view.model;
import java.awt.Cursor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;
import javacode.table.QLLS.EventActionQLLS;


public class Panel_QLLS_view extends JPanel{
      private static Connection con;
      public  static  JPanel TopPanel = new JPanel();
      public  static  JPanel LeftContent = new JPanel();
      public  static  JPanel RightContent = new JPanel(new MigLayout("fill","16[fill]16","16[fill]10[fill]0"));
      public static AutoSearch autoSearch = new AutoSearch();
      public  static  JPanel headerContent = new JPanel(new MigLayout("fill","10[fill][]5[]16","0[fill]0"));
      public  static  JLabel lblTitleHeaderContent = new JLabel("Quản lý cửa / Quản lý lịch sửa");
      public  static  JLabel lblTableTitle = new JLabel("Lịch sử ra vào");
     public  static tableQLLS TableLeft = new tableQLLS();
     public  static   JScrollPane  jScrollPane1 = new JScrollPane();
     public  static   EventActionQLLS even;
     public  static DefaultTableModel model ;
     public  static tableQLLS TableRight = new tableQLLS();
      public  static  panelSearch pSearch = new panelSearch();
//      public  static  outlineButton btnAdd = new outlineButton();
//     static String TinhTrang=new String();
      public  static Button btnX = new Button();
     public  static JLabel lblTitleRight = new JLabel("Tìm kiếm");
     public  static   JScrollPane  jScrollPane2 = new JScrollPane();
//    public  static  JPanel Right = new JPanel();
    public static JPanel Right = new JPanel(new MigLayout("fill", "0[fill]0", "0[fill]0"));
//    public  static  JPanel Right = new JPanel();
//    private  static ThemMayTram_view v = new ThemMayTram_view();
    public Panel_QLLS_view(){
        this.setLayout(new MigLayout("fill","0[fill]16[fill]0","0[fill]0"));
        
        
//-----------------------------------------------------------------------------------------------------Panel trên đầu        
        TopPanel = new JPanel();
        TopPanel.setLayout(new MigLayout("fill","0[]0","0[]0[100%]0"));
        this.add(TopPanel,"h 100!,span,grow");
        
//----------------------------------------------------------------------------------------------------- content bên trái                
        LeftContent.setLayout(new MigLayout("fill","10[fill]10","10[fill]10"));
        LeftContent.setBackground(Color.WHITE);
        this.add(LeftContent,"h 100% , w 55%,gapleft 27");
        
//-----------------------------------------------------------------------------------------------------content bên phải         
//        RightContent.setLayout(new MigLayout("fill","10[fill]10","10[fill]10"));
        RightContent.setBackground(Color.WHITE);
        this.add(RightContent,"w 100%, w 45%,gapright 16");
        
//------------------------------------------------------------------------------------------------------        
        
        headerContent.setBackground(new Color(252,252,252));
//        headerContent.setBackground(Color.BLACK);
        headerContent.setBorder(new MatteBorder(1, 0, 0, 0, new Color(140, 140, 140, 40)));
        TopPanel.add(headerContent,"h 48!,span,grow,top");
        
//-----------------------------------------------------------------------------------------------------chủ đề của Panel nội dung chính         
       lblTitleHeaderContent.setBounds(0, 0, 200, 25);
       lblTitleHeaderContent.setFont(new Font("Tahoma",1,20));
       lblTitleHeaderContent.setFont(new Font("sansserif",1,15));
       lblTitleHeaderContent.setForeground(new Color(4,72,210));
       headerContent.add(lblTitleHeaderContent,"w 100%,h 100%,center");
//       headerContent.add(pSearch,"h 36!,w 400!,right");
//------------------------------------------------------------------------------------------------------
       lblTableTitle.setFont(new Font("Tahoma",1,16));
       LeftContent.add(lblTableTitle,"h 30!,span,grow");
 
//------------------------------------------------------------------------------------------------------       
        LeftContent.add(jScrollPane1,"w 100%,h 100%");

//------------------------------------------------------------------------------------------------------    
        RightContent.setLayout(new MigLayout("fill","10[fill]10","10[fill]10"));
        RightContent.add(lblTitleRight,"h 30!,w 100%");
        RightContent.add(pSearch,"h 36!,w 160!,cell 1 0, right");
//        RightContent.add(btnX,"h 30!,w 30! , cell 1 0");
        RightContent.add(Right, "h 100%, w 100%, cell 0 1 2 1");

        lblTitleRight.setFont(new Font("sansserif", 1, 16));
        lblTitleRight.setForeground(new Color(24,24,24));
//------------------------------------------------------------------------------------------------------
        Right.setBackground(Color.WHITE);
        Right.setBorder(new MatteBorder(1, 0, 0, 0, new Color(200, 200, 200)));
        Right.setLayout(new MigLayout("fill", "0[fill]0", "0[fill]0"));

        Right.add(jScrollPane2, "w 100%, h 100%");
//        RightContent.add(jScrollPane2,"w 100%, h 100%");

//------------------------------------------------------------------------------------------------------     
        Right.removeAll();
        
//        btnX.setText("x");
//        btnX.setFont(new Font("Tahoma", 1, 18));
//        btnX.setForeground(new Color(140,140,140));
//        btnX.setVisible(false);
//        btnX.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                clearRightConstent();
//               
//            }
//        });
//        Right.setBackground(Color.WHITE);
//        Right.setBorder(new MatteBorder(1, 0, 0, 0, new Color(200, 200, 200)));
//        Right.setLayout(new MigLayout("fill","0[fill]0","10[fill]10"));
//------------------------------------------------------------------------------------------------------
        setUpTable();
        setUpTableUser();
        loadData();   
//        autoUpdateData();
        ActionSearch();
        DataSearch();
    }
    
//    static void clearRightConstent(){
//        Right.removeAll();
//        Right.revalidate();
//        Right.repaint();
//        btnX.setVisible(false);
//    }
    
private void ActionSearch() {
    // Kết nối tới cơ sở dữ liệu
    try {
        Class.forName("org.sqlite.JDBC");
        String url = "jdbc:sqlite:src/db/detection_data.db"; 
        con = DriverManager.getConnection(url);
    } catch (Exception e) {
        e.printStackTrace();
        return; // Thoát phương thức nếu không kết nối được đến cơ sở dữ liệu
    }

    // Đăng ký sự kiện tìm kiếm
    pSearch.EvenSearch(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String textSearch = pSearch.getText();
            if (textSearch.isEmpty()) {
                // Nếu ô tìm kiếm trống, chỉ hiển thị bảng lịch sử chung
                TableLeft.setVisible(true);
                TableRight.setVisible(false);
            } else {
                // Nếu có nội dung trong ô tìm kiếm, hiển thị bảng kết quả tìm kiếm
                TableLeft.setVisible(true);
                TableRight.setVisible(true);
                String query = "SELECT QLLS.UserID, QLMembers.UserName, QLLS.TimeIn " +
                               "FROM QLLS JOIN QLMembers ON QLLS.UserID = QLMembers.UserID " +
                               "WHERE UserName = ?";
                try {
                    PreparedStatement ps = con.prepareStatement(query);
                    ps.setString(1, textSearch);
                    ResultSet rs = ps.executeQuery();
                    model.setRowCount(0);

                    while (rs.next()) {
                        TableRight.addRow(new QLLS_model(
                            rs.getInt("UserID"),
                            rs.getString("UserName"),
                            rs.getString("TimeIn")
                        ).toRowUser(even));
                    }

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
    });
}

  
    private void autoUpdateData() {
        Timer timer = new Timer(30000, new ActionListener() { // Cập nhật dữ liệu sau mỗi 30 giây
            @Override
            public void actionPerformed(ActionEvent e) {
                loadData(); // Cập nhật dữ liệu trong bảng lịch sử chung
            }
        });
        timer.start();
    }
    public void DataSearch(){
        List<String> data1 = new ArrayList();
        try {
                        Class.forName("org.sqlite.JDBC");
                        String url = "jdbc:sqlite:src/db/detection_data.db";
                        con = DriverManager.getConnection(url); 
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
		
//		
		try {
			PreparedStatement pstm = con.prepareStatement("Select UserName from QLLS  join QLMembers on QLLS.UserID = QLMembers.UserID");
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				data1.add(rs.getString("UserName"));
                        }
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
                
        autoSearch.setData(data1, pSearch.txtSearch);
        
    }
        
    public static void loadData(){
     model.setRowCount(0);
    
         try {
            Class.forName("org.sqlite.JDBC");
//            String url = "jdbc:sqlite:C:\\Users\\tuan\\Downloads\\yolov8\\detection_data.db"; 
               String url = "jdbc:sqlite:src/db/detection_data.db";
            con = DriverManager.getConnection(url);
        } catch (Exception e) {
             

        }

	try {
		PreparedStatement pstm = con.prepareStatement(
                    "SELECT QLLS.ID, QLLS.UserID, QLMembers.UserName, QLLS.TimeIn " +
                    "FROM QLLS " +
                    "JOIN QLMembers ON QLLS.UserID = QLMembers.UserID " 
                   + "ORDER BY QLLS.TimeIn DESC"
                );
		ResultSet rs = pstm.executeQuery();
                  
		while(rs.next()) {
			 TableLeft.addRow(new QLLS_model(rs.getInt("ID"),rs.getInt("UserID"),rs.getString("UserName"),rs.getString("TimeIn")).toRowTable(even));
                }
		
	} catch (SQLException e1) {
		
		e1.printStackTrace();
	}
    }

    private void setUpTable(){
        model = new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "User_ID","User_Name", "Thời gian"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        TableLeft.setModel(model);
        
         jScrollPane1.setViewportView(TableLeft);
        
        TableLeft.fixTable(jScrollPane1); // sửa cái jScrooll
       
        
    }
    
    private void setUpTableUser(){
        model = new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User_ID","User_Name", "Thời gian"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        TableRight.setModel(model);
        
         jScrollPane2.setViewportView(TableRight);
        
        TableRight.fixTable(jScrollPane2); // sửa cái jScrooll
       
        
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
                                    Panel_QLLS_view panel = new Panel_QLLS_view();
                                    JF.setContentPane(panel);
                                    JF.setVisible(true);
                                     panel.autoUpdateData();
                                } catch (Exception e) {
					e.printStackTrace();
				}
                        }
               });       
    }                    

    
}
