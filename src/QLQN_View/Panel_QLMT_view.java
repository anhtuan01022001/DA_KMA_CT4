
package QLQN_View;

import QLQN_Controller.NguoiChoi_controller;
import QLQN_Controller.QLMayTram_controller;
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
import javacode.table.QLMT.EventActionQLMT;
import javacode.table.QLMT.tableQLMT;
import QLQN_Model.QLMT_model;
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


public class Panel_QLMT_view extends JPanel{
        private static Connection con;
      public  static  JPanel TopPanel = new JPanel();
      public  static  JPanel LeftContent = new JPanel();
      public  static  JPanel RightContent = new JPanel(new MigLayout("fill","16[fill]16","16[fill]10[fill]0"));
      public static AutoSearch autoSearch = new AutoSearch();
      public  static  JPanel headerContent = new JPanel(new MigLayout("fill","10[fill][]5[]16","0[fill]0"));
      public  static  JLabel lblTitleHeaderContent = new JLabel("Quản lý quán net / Quản lý máy trạm");
      public  static  JLabel lblTableTitle = new JLabel("Dữ liệu máy trạm");
     public  static tableQLMT TableLeft = new tableQLMT();
     public  static   JScrollPane  jScrollPane1 = new JScrollPane();
     public  static   EventActionQLMT even;
     public  static DefaultTableModel model ;
      public  static  panelSearch pSearch = new panelSearch();
      public  static  outlineButton btnAdd = new outlineButton();
     static String TinhTrang=new String();
      public  static Button btnX = new Button();
     public  static JLabel lblTitleRight = new JLabel("Chi tiết máy trạm");
    public  static  JPanel Right = new JPanel(new MigLayout("fill","0[fill]0","0[fill]0"));
    private  static ThemMayTram_view v = new ThemMayTram_view();
    public Panel_QLMT_view(){
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
      
        RightContent.add(lblTitleRight,"h 30!,w 100%,cell 0 0");
        RightContent.add(btnX,"h 30!,w 30! , cell 1 0");
        RightContent.add(Right,"h 100%,w 100%,cell 0 1 2 1");
        
        lblTitleRight.setFont(new Font("sansserif", 1, 16));
        lblTitleRight.setForeground(new Color(24,24,24));
        
        Right.removeAll();
        
        btnX.setText("x");
        btnX.setFont(new Font("Tahoma", 1, 18));
        btnX.setForeground(new Color(140,140,140));
        btnX.setVisible(false);
        btnX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearRightConstent();
               
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
    
   
    
    static void clearRightConstent(){
        Right.removeAll();
                Right.revalidate();
                  Right.repaint();
                  btnX.setVisible(false);
    }
    
    private void ActionSearch(){
        pSearch.EvenSearch(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textSearch = pSearch.getText();
                String query = "select * from QLMayTinh where Tenmay = ? ";
                try {
                    PreparedStatement ps = con.prepareStatement(query);

                    ps.setString(1,textSearch);
                   ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        System.out.println("QLQN_Controller.QLMayTram_controller.TimMayTram()");
                           model.setRowCount(0);
                                if(rs.getInt("Status")==0) {
                                    TinhTrang="<html><font color=red>Offline</font>";

                                }
                                else {TinhTrang="<html><font color=green>Online</font>";

                                }

                                TableLeft.addRow(new QLMT_model(rs.getInt("MayID"),rs.getString("Tenmay"),TinhTrang,rs.getString("MbName"),rs.getInt("MbID")).toRowTable(even));

                    }
                    

                } catch (Exception e1) {

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
			PreparedStatement pstm = con.prepareStatement("Select Tenmay from QLMayTinh");
			
			
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				data1.add(rs.getString("Tenmay"));
				
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
			PreparedStatement pstm = con.prepareStatement("Select * from QLMayTinh order by Status desc");
			
			
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				
				if(rs.getInt("Status")==0) {
					TinhTrang="<html><font color=red>Offline</font>";
					
				}
				else {TinhTrang="<html><font color=green>Online</font>";
				
				}
				
                                TableLeft.addRow(new QLMT_model(rs.getInt("MayID"),rs.getString("Tenmay"),TinhTrang,rs.getString("MbName"),rs.getInt("MbID")).toRowTable(even));
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }

//---------------------------------------------------------------------------------------------sự kiện   
    private void evenTable() {
          even = new EventActionQLMT() {
              @Override
              public void show(QLMT_model QLMT) {
                 
                  Right.removeAll();
                  ChiTietMayTram_view v= new ChiTietMayTram_view(QLMT);
                  Right.add(v,"w 100% , h 100%");
                  Right.revalidate();
                  Right.repaint();
              }
              
            @Override
            public void delete(QLMT_model QLMT) {
               QLMayTram_controller con = new QLMayTram_controller();
               String tinhtrang = QLMT.getTinhTrang();
                if(tinhtrang.equals("<html><font color=red>Offline</font>")){
                      if(showConfirm("Bạn chắn chắn muốn xóa "+QLMT.getTenMay()+" ?")){
                    
                    int kq = con.XoaMayTram(QLMT);
                    if(kq == 1){

                        Message msg = new Message();
                        msg.showMessage("Xóa thành công!");
                        loadData();
                    }
                 }
                 }
                 else if(tinhtrang.equals("<html><font color=green>Online</font>")){
                      Message msg = new Message();
                        msg.showMessage("Lỗi!Máy đang online");
                         }

                
               
            }

            @Override
            public void update(QLMT_model QLMT) {
                SuaMayTram_view v = new SuaMayTram_view(QLMT);
                v.setVisible(true);
            }

            @Override
            public void pay(QLMT_model QLMT) {
                
                String tinhtrang = QLMT.getTinhTrang();
                System.out.println(tinhtrang);
                if(tinhtrang.equals("<html><font color=red>Offline</font>")){
                      Message msg = new Message();
                        msg.showMessage("Lỗi! Máy trạm đang offline.");
                 }
                 else if(tinhtrang.equals("<html><font color=green>Online</font>")){
                       NapTien_view v = new NapTien_view(QLMT.getMbName());
                         v.setVisible(true);
                         }
                
                
                
            }
        };
    }
    
    private void setUpTable(){
        model = new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên máy", "Tình trạng", "Hành động"
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
                                    Panel_QLMT_view panel = new Panel_QLMT_view();
                                    JF.setContentPane(panel);
                                    JF.setVisible(true);
                                     
                                } catch (Exception e) {
					e.printStackTrace();
				}
                        }
               });       
    }                    

    
}
