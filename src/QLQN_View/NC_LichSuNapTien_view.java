/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLQN_View;
import QLQN_Controller.NguoiChoi_controller;
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
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javacode.custom.Message;
import javacode.custom.TextField;
import javacode.custom.outlineButton;
import javacode.table.Table;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author QuynhTn
 */
public class NC_LichSuNapTien_view extends JPanel {
    private static Connection conn;
   static Table table = new Table();
   static JScrollPane  jScrollPane1 = new JScrollPane();
   static DefaultTableModel model ;
   static DateChooser dC1 = new DateChooser();
  static  DateChooser dC2 = new DateChooser();
  static  TextField date1 = new TextField();
   static TextField date2 = new TextField();
   static JLabel lbl = new JLabel();
    JLabel icon = new JLabel(new ImageIcon(getClass().getResource("/Image/next.png")));
   static outlineButton btnSearch = new outlineButton();
   static  Locale locale =new Locale("vi","VN");
   static NumberFormat format1 = NumberFormat.getInstance(locale);
   static NguoiChoi_controller c = new NguoiChoi_controller();
    
    
    public NC_LichSuNapTien_view(int id) {
        setLayout(new MigLayout("fill", "[]", "[]"));
        add(date1,"cell 0 0,w 40%,gapleft 8!");
        add(icon,"cell 1 0");
        add(date2,"cell 2 0,w 40%");
        add(btnSearch,"cell 3 0 ,w 80!,h 35!");
        
        add(jScrollPane1,"w 100%,h 100%,cell 0 1 4 1");
        setBackground(Color.white);
        
        
         lbl.setText(c.TenMbName(id));
       
        
        dC1.setTextRefernce(date1);
        date1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        dC2.setTextRefernce(date2);
        date2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnSearch.setText("Tìm kiếm");
        btnSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                Date date1 = dC1.getSelectedDateSQL();
                Date date2 = dC2.getSelectedDateSQL();
                 Message msg = new Message();
                    msg.setLocation(900, 200);
                    
                NguoiChoi_controller con = new NguoiChoi_controller();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		 Calendar c1 = Calendar.getInstance();
                    if(date1.getTime()<date2.getTime()){
                         model.setRowCount(0);
                         ResultSet rs = con.timKiem(c.TenMbName(id),date1, date2);
                        try {
                            int k =0;
                            while(rs.next()){
                                k=1;
                                c1.setTime(rs.getDate("date"));
                                c1.roll(Calendar.DATE, 0);
                                model.addRow(new Object [] {dateFormat.format(c1.getTime()),format1.format(rs.getInt("SoTienNap"))});

                            }
                            if(k==0){
                                 msg.showMessage("Không có bản ghi!"); 
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(NC_LichSuNapTien_view.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else if(date1.getTime()== date2.getTime())
                    {
                        model.setRowCount(0);
                         ResultSet rs = con.timKiemNgay(c.TenMbName(id),date1);
                        try {
                            int k =0;
                            while(rs.next()){
                                k=1;
                                c1.setTime(rs.getDate("date"));
                                c1.roll(Calendar.DATE, 0);
                                model.addRow(new Object [] {dateFormat.format(c1.getTime()),format1.format(rs.getInt("SoTienNap"))});

                            }
                            if(k==0){
                               msg.showMessage("Không có bản ghi!");
                            }
                             
                        } catch (SQLException ex) {
                            Logger.getLogger(NC_LichSuNapTien_view.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    else{
                        msg.showMessage("Thời gian tìm kiếm không hợp lệ !");

                    }

                
            }
        } );
        
        
        SetUpTable();
        loadData();
    }
    public static void loadData(){
        model.setRowCount(0);
       

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QUAN_NET;user=sa;password=Nq25142001");  
        } catch (Exception e) {
             
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		 Calendar c1 = Calendar.getInstance();
		try {
			PreparedStatement pstm = conn.prepareStatement("select * from ThongKe where MbName = ? order by date desc");
			pstm.setString(1,lbl.getText() );
			
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
                                c1.setTime(rs.getDate("date"));
				c1.roll(Calendar.DATE, 0);
				model.addRow(new Object [] {dateFormat.format(c1.getTime()),format1.format(rs.getInt("SoTienNap"))});
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
                "Ngày nạp", "Số tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        table.setModel(model);
        
         jScrollPane1.setViewportView(table);
        
        
        table.fixTable(jScrollPane1); // sửa cái jScrooll
    }
   
}
