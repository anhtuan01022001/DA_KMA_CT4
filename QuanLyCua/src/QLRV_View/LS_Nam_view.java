
package QLRV_View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.String.format;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;
import javacode.custom.Combobox;
import javacode.custom.outlineButton;
import javacode.table.Table;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javacode.custom.Message;

public class LS_Nam_view extends JPanel{
      JLabel lblDate = new JLabel();
    private static Connection conn;
    JPanel panTable = new JPanel(new MigLayout("fill","fill","0[fill]"));
     SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    
    Combobox<String> cbNam = new Combobox<>();
    JLabel lblTongTien = new JLabel();
    DefaultComboBoxModel modelNam = new DefaultComboBoxModel(new String[] { "Năm","2018", "2019", "2020", "2021", "2022","2023","2024","2025","2026","2027","2028","2029" });
    Table table = new Table();
    JScrollPane  jScrollPane1 = new JScrollPane();
    DefaultTableModel model ;
    outlineButton btnSearch = new outlineButton();
     Locale locale =new Locale("vi","VN");
     
         NumberFormat format1 = NumberFormat.getInstance(locale);
    public LS_Nam_view()  {
         setBackground(Color.white);
        setLayout(new MigLayout("fill","[][100%]10[]10[]","[][]"));
      add(lblTongTien,"w 100%,cell 0 0");
        add(lblDate,"left,gapleft 16!,bottom,cell 0 1");
        
        add(cbNam,"cell 1 0,right,w 100!,h 36!");
        add(btnSearch,"cell 2 0 , h 40!,w 100!,gapright 20!");
        add(panTable,"gaptop 7!,w 100%,h 100%,cell 0 2 3 1");
        
        panTable.setBorder(new LineBorder(Color.DARK_GRAY));
        panTable.setBackground(Color.WHITE);
        panTable.add(jScrollPane1,"w 100%,h 100%");
        
        lblDate.setFont(new Font("sansserif", 0, 16));
        lblTongTien.setFont(new Font("sansserif", 0, 16));
        lblTongTien.setForeground(Color.red);
        
        btnSearch.setText("Tìm kiếm");
         btnSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                 model.setRowCount(0);
               SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String nam1 = (String) cbNam.getSelectedItem();
                if(nam1.equals("Năm")){
                    Message msg = new Message();
                     msg.showMessage("Vui lòng chọn thông tin cần tìm!");
                }
                else{
               
                 Calendar c1 = Calendar.getInstance();
                 lblDate.setText("<html><font color=blue>Năm : </font>"+cbNam.getSelectedItem());
                 int nam = Integer.parseInt((String) cbNam.getSelectedItem());
                try {
			PreparedStatement pstm = conn.prepareStatement("select MbName,date,SoTienNap from ThongKe where YEAR(date) = ? ");
                        pstm.setInt(1, nam);
					               
			ResultSet rs = pstm.executeQuery();
                        int k = 0;
			while(rs.next()) {
                            c1.setTime(rs.getDate("date"));
                            c1.roll(Calendar.DATE, 0);
				k=1;		
			    model.addRow(new Object [] {rs.getString("MbName") ,dateFormat.format(c1.getTime()),format1.format(rs.getInt("SoTienNap"))});
                            
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
					PreparedStatement pstm = conn.prepareStatement("select dbo.TDTNam(?)'a'");
					pstm.setInt(1,nam);
					
					ResultSet rs = pstm.executeQuery();
					while(rs.next()) {
						lblTongTien.setText( "Tổng số tiền: "+format1.format(rs.getInt("a")) ); 
					
						
					}
                                         
				} catch (SQLException e1) {						
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
                   
            
            
                }
            
            }
        });
       
       
//        modelThang.addListDataListener(cbNam);
        
        cbNam.setModel(modelNam);
         
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
         SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String toDay = df.format(date);
        int DAY = Integer.valueOf(toDay.split("-")[0]);
        int MONTH = Integer.valueOf(toDay.split("-")[1]);
        int YEAR = Integer.valueOf(toDay.split("-")[2]);
        System.out.println("m "+MONTH);
        System.out.println("y "+YEAR);
		try {
			PreparedStatement pstm = conn.prepareStatement("select MbName,date,SoTienNap from ThongKe where YEAR(date) = ? ");
			 pstm.setInt(1, YEAR);
			
			ResultSet rs = pstm.executeQuery();
                     
			while(rs.next()) {
				
				
				model.addRow(new Object [] {rs.getString("MbName") ,df.format(rs.getDate("date")),format1.format(rs.getInt("SoTienNap"))});
			
                        }
			 
		} catch (SQLException e1) {						
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
               try {
			PreparedStatement pstm = conn.prepareStatement("select * from dbo.returnNam() ");
			                
			
			ResultSet rs = pstm.executeQuery();
                      
			while(rs.next()) {
				lblDate.setText("<html><font color=blue>Năm : </font>"+rs.getInt("nam"));
				
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
                                    LS_Nam_view panel = new LS_Nam_view();
                                    JF.setContentPane(panel);
                                    JF.setVisible(true);
                                     
                                } catch (Exception e) {
					e.printStackTrace();
				}
                        }
               });  
    }
    
}
