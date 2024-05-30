
package QLRV_View;

import QLRV_Controller.MB_controller;
import QLRV_Controller.QLThe_controller;
import QLRV_Model.QLMB_model;
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
import javacode.table.QLThe.tableQLThe;
import QLRV_Model.QLThe_model;
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
import javacode.table.QLThe.EventActionQLThe;


public class Panel_QLThe_view extends JPanel{
        private static Connection con;
      public  static  JPanel TopPanel = new JPanel();
      public  static  JPanel LeftContent = new JPanel();
      public  static  JPanel RightContent = new JPanel(new MigLayout("fill","16[fill]16","16[fill]10[fill]0"));
      public static AutoSearch autoSearch = new AutoSearch();
      public  static  JPanel headerContent = new JPanel(new MigLayout("fill","10[fill][]5[]16","0[fill]0"));
      public  static  JLabel lblTitleHeaderContent = new JLabel("Quản lý cửa / Quản lý thẻ");
      public  static  JLabel lblTableTitle = new JLabel("Dữ liệu thẻ");
     public  static tableQLThe TableLeft = new tableQLThe();
     public  static   JScrollPane  jScrollPane1 = new JScrollPane();
     public  static   EventActionQLThe even;
     public  static DefaultTableModel model ;
      public  static  panelSearch pSearch = new panelSearch();
      public  static  outlineButton btnAdd = new outlineButton();
//      public  static Button btnX = new Button();
//     public  static JLabel lblTitleRight = new JLabel("Chi tiết thẻ");
//    public  static  JPanel Right = new JPanel(new MigLayout("fill","0[fill]0","0[fill]0"));
    private  static ThemThe_view v = new ThemThe_view();
    public Panel_QLThe_view(){
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
        
//------------------------------------------------------------------------------------------------------        
        
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
       lblTitleHeaderContent.setFont(new Font("Tahoma",1,20));
       lblTitleHeaderContent.setFont(new Font("sansserif",1,15));
       lblTitleHeaderContent.setForeground(new Color(4,72,210));
       headerContent.add(lblTitleHeaderContent,"w 100%,h 100%,center");
       headerContent.add(pSearch,"h 36!,w 400!,right");
//------------------------------------------------------------------------------------------------------
       lblTableTitle.setFont(new Font("Tahoma",1,16));
       LeftContent.add(lblTableTitle,"h 30!,span,grow");
 
//------------------------------------------------------------------------------------------------------       
        LeftContent.add(jScrollPane1,"w 100%,h 100%");

//------------------------------------------------------------------------------------------------------    
      
//        RightContent.add(lblTitleRight,"h 30!,w 100%,cell 0 0");
//        RightContent.add(btnX,"h 30!,w 30! , cell 1 0");
//        RightContent.add(Right,"h 100%,w 100%,cell 0 1 2 1");
//        
//        lblTitleRight.setFont(new Font("sansserif", 1, 16));
//        lblTitleRight.setForeground(new Color(24,24,24));
//        
//        Right.removeAll();
//        
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
//        
//        Right.setBackground(Color.WHITE);
//        Right.setBorder(new MatteBorder(1, 0, 0, 0, new Color(200, 200, 200)));
       
//------------------------------------------------------------------------------------------------------
        setUpTable();
        evenTable();
        loadData();     
        ActionSearch();
        DataSearch();
    }
    
   
    
//    static void clearRightConstent(){
//        Right.removeAll();
//                Right.revalidate();
//                  Right.repaint();
//                  btnX.setVisible(false);
//    }
    
    private void ActionSearch(){
        pSearch.EvenSearch(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textSearch = pSearch.getText();
                String query = " Select QLThe.ID, QLThe.TheUID, QLMembers.UserID, QLMembers.UserName from QLThe  join QLMembers on QLThe.UserID = QLMembers.UserID where UserName = ? ";
                try {
                    PreparedStatement ps = con.prepareStatement(query);

                    ps.setString(1,textSearch);
                   ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                           model.setRowCount(0);
                                TableLeft.addRow(new QLThe_model(rs.getInt("ID"),rs.getString("TheUID"),rs.getInt("UserID"),rs.getString("UserName")).toRowTable(even));

                    }
                    

                } catch (Exception e1) {

                }
            }
        });
    }
    
    public void DataSearch(){
        List<String> data1 = new ArrayList();
        try {
                        Class.forName("org.sqlite.JDBC");
                        String url = "jdbc:sqlite:src/db/detection_data.db"; 
                        con = DriverManager.getConnection(url); 
                    } catch (Exception e) {

                    }
		
//		
		try {
			PreparedStatement pstm = con.prepareStatement("Select UserName from QLThe");
			
			
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				data1.add(rs.getString("UserName"));
				
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
            String url = "jdbc:sqlite:src/db/detection_data.db"; 
            con = DriverManager.getConnection(url);
        } catch (Exception e) {
             

        }

	try {
		PreparedStatement pstm = con.prepareStatement("Select QLThe.ID, QLThe.TheUID, QLMembers.UserID, QLMembers.UserName from QLThe  join QLMembers on QLThe.UserID = QLMembers.UserID");
		ResultSet rs = pstm.executeQuery();
                  
		while(rs.next()) {
                        

			 TableLeft.addRow(new QLThe_model(rs.getInt("ID"),rs.getString("TheUID"),rs.getInt("UserID"),rs.getString("UserName")).toRowTable(even));
		}
		
	} catch (SQLException e1) {
		
		e1.printStackTrace();
	}
    }

//---------------------------------------------------------------------------------------------sự kiện   
    private void evenTable() {
          even = new EventActionQLThe() {
            @Override
            public void delete(QLThe_model QLMT) {
               QLThe_controller con = new QLThe_controller();
               String tinhtrang = QLMT.getUserName();
                      if(showConfirm("Bạn chắn chắn muốn xóa "+QLMT.getUserName()+" ?")){
                    
                    int kq = con.XoaMayTram(QLMT);
                    if(kq == 1){

                        Message msg = new Message();
                        msg.showMessage("Xóa thành công!");
                        loadData();
                    }
                 }
            }

            @Override
            public void update(QLThe_model QLMT) {
                SuaThe_view v = new SuaThe_view(QLMT);
                v.setVisible(true);
            }

        };
    }
    
    private void setUpTable(){
        model = new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "UID thẻ", "User_ID","User_Name", "Hành động"
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
                                    Panel_QLThe_view panel = new Panel_QLThe_view();
                                    JF.setContentPane(panel);
                                    JF.setVisible(true);
                                     
                                } catch (Exception e) {
					e.printStackTrace();
				}
                        }
               });       
    }                    

    
}
