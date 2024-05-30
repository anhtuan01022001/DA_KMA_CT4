
package QLRV_View;

import QLRV_Model.QLMB_model;
import static QLRV_View.Panel_QLMB_view.model;
import java.text.NumberFormat;
import java.util.Locale;
import com.raven.datechooser.DateChooser;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javacode.custom.Message;
import javacode.custom.panelSearch;
import javacode.table.Table;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;



public class LS_Ngay_view extends JPanel{
     Locale locale =new Locale("vi","VN");
     SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
     private NumberFormat format = NumberFormat.getCurrencyInstance(locale);
         NumberFormat format1 = NumberFormat.getInstance(locale);
    private static Connection conn;
    panelSearch DatePane = new panelSearch();
    JLabel lblDate = new JLabel();
    JLabel lblTongTien = new JLabel("");
    JPanel panTable = new JPanel(new MigLayout("fill ","fill","0[fill]"));
    Table table = new Table();
    JScrollPane  jScrollPane1 = new JScrollPane();
    DefaultTableModel model ;
    DateChooser dC = new DateChooser();
    public LS_Ngay_view() {
        setBackground(Color.white);
        setLayout(new MigLayout("fill","[]","[][]"));
        add(lblTongTien,"w 100%,cell 0 0");
        add(lblDate,"left,gapleft 16!,bottom,cell 0 1");
     
        
        add(DatePane,"w 300! ,cell 1 0,right,gapright 16!,wrap,bottom,gapbottom 8!");
        
        add(panTable,"gaptop 7!, w 100%,h 100%,cell 0 2 2 1");
        
        panTable.setBorder(new LineBorder(Color.DARK_GRAY));
        panTable.setBackground(Color.WHITE);
        panTable.add(jScrollPane1,"w 100%,h 100%");
        
        lblTongTien.setFont(new Font("sansserif", 0, 16));
        lblTongTien.setForeground(Color.red);
        lblDate.setFont(new Font("sansserif", 0, 16));
        

        
        dC.setTextRefernce(DatePane.txtSearch);
         DatePane.setCursor(new Cursor(Cursor.HAND_CURSOR));
        DatePane.EvenSearch(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                 model.setRowCount(0);
               

                 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                 Calendar c1 = Calendar.getInstance();
               
                 lblDate.setText("<html><font color=blue>Ngày : </font>"+DatePane.getText());
                try {
			PreparedStatement pstm = conn.prepareStatement("select * from ThongKe where date = ? ");
                        pstm.setDate(1, dC.getSelectedDateSQL());
					               
			ResultSet rs = pstm.executeQuery();
                        
                        int k=0;
                     
                            while(rs.next()) {
                                k=1;
                                
                                c1.setTime(rs.getDate("date"));
                                c1.roll(Calendar.DATE, 0);

                                model.addRow(new Object [] {rs.getString("MbName") ,dateFormat.format(c1.getTime()),format1.format(rs.getInt("SoTienNap"))});
//
                            }
                            if(k==0){
                                Message msg = new Message();
                                msg.showMessage("Không có bản ghi!");
                            }
                   
                } catch (SQLException e1) {						
					// TODO Auto-generated catch block
					e1.printStackTrace();
		}
				
				try {
					PreparedStatement pstm = conn.prepareStatement("select dbo.TDTNgay(?)'a'");
					pstm.setDate(1, dC.getSelectedDateSQL());
					
					ResultSet rs = pstm.executeQuery();
					while(rs.next()) {
						lblTongTien.setText( "Tổng số tiền: "+format.format(rs.getInt("a")) ); 
					
						
					}
                                       
				} catch (SQLException e1) {						
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
            
            
            
            
            
            
            }
        });
        
        SetUpTable();
        loadData();
    }
      private void loadData(){
        model.setRowCount(0);

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-3PATKKP\\SQLEXPRESS01:1433;databaseName=QUAN_NET;user=sa;password=12345678");  
        } catch (Exception e) {
             
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		 
		try {
			PreparedStatement pstm = conn.prepareStatement("select * from ThongKe where date = ? ");
                        pstm.setDate(1, dC.toDaySQL());
			
			
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {//rs.getDate("date")
                                Date dateSQL = rs.getDate("date");
//                           
                                System.out.println(Calendar.DATE);
				model.addRow(new Object [] {rs.getString("MbName") ,dateFormat.format(dateSQL),format1.format(rs.getInt("SoTienNap"))});
			}
			 
		} catch (SQLException e1) {						
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
                try {
			PreparedStatement pstm = conn.prepareStatement("select * from dbo.returnNgay() ");
			                
			
			ResultSet rs = pstm.executeQuery();
                      
			while(rs.next()) {
				lblDate.setText("<html><font color=blue>Ngày : </font>"+rs.getInt("ngay")+"/"+rs.getInt("thang")+"/"+rs.getInt("nam"));
				
                        }
			
		} catch (SQLException e1) {						
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }

    
    public void SetUpTable(){
        model = new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên khách hàng", "Ngày nạp tiền", "Số tiền nạp"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        table.setModel(model);
        
         jScrollPane1.setViewportView(table);
        
        
        table.fixTable(jScrollPane1); // sửa cái jScrooll
    }
    
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                                    JFrame JF = new JFrame();
                                    JF.setDefaultCloseOperation(JF.EXIT_ON_CLOSE);
                                    JF.setSize(1000, 800);
                                    JF.setLocationRelativeTo(null);
                                    LS_Ngay_view panel = new LS_Ngay_view();
                                    JF.setContentPane(panel);
                                    JF.setVisible(true);
                                     
                                } catch (Exception e) {
					e.printStackTrace();
				}
                        }
               });  
    }
    
}
