//
//package QLRV_View;
//
//import QLRV_Controller.MB_controller;
//import java.awt.Color;
//import java.awt.Cursor;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.text.NumberFormat;
//import java.util.Locale;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//import javacode.custom.Button;
//import javacode.custom.outlineButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import net.miginfocom.swing.MigLayout;
//
//public class MB_ThongTin_view extends JPanel{
//    Locale locale =new Locale("vi","VN");
//    NumberFormat format1 = NumberFormat.getInstance(locale);
//    JLabel lblTitle = new JLabel("Máy 1");
//    JLabel lblTime = new JLabel("Thời gian");
//    JLabel lblMoney = new JLabel("Tiền");
//    public outlineButton btnLogout = new outlineButton();
//    MB_controller c = new MB_controller();
//    private Connection conn;
//    private int ST =0;
//    private int TT=1;  
//    public MB_ThongTin_view(int id) {
//        setLayout(new MigLayout("fill", "[]", "[center][30!]20[30!][]"));
//        setBackground(Color.white);
//        add(lblTitle,"cell 0 0,center");
//         add(lblMoney,"cell 0 1 ,h 30!,gapleft 120!,gapbottom 16!");
//        add(lblTime,"cell 0 2,h 30!,gapleft 120!");
//        add(btnLogout,"cell 0 3,h 50!, w 110!,center");
//        
//        
//        lblTitle.setFont(new Font("sansserif", 1, 50));
//        
//        lblTime.setFont(new Font("sansserif", 1, 25));
//        lblTime.setText("Thời gian còn lại:"+"00:00:00");
//        
//        MB_controller con = new MB_controller();
//         
//        lblMoney.setFont(new Font("sansserif", 1, 25));
//        
//        btnLogout.setRadius(20);
//        btnLogout.setText("Đăng xuất");
//        btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
//   
//       
//        
//        try {
//                    Class.forName("org.sqlite.JDBC");
//                    String url = "jdbc:sqlite:src/db/detection_data.db";
//                    conn = DriverManager.getConnection(url);
//		    
//		} catch (ClassNotFoundException | SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//			}
//        
//       final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
//	    executorService.scheduleAtFixedRate(new Runnable() {
//	    	
//	        @Override
//	        public void run() {
//		
//	           truycap(con.TenMbName(id));
//                   if(TT==1) {
//                    ST=ST-3;
//	        	if(ST>0) {
//                           
//                            try {
//                                    PreparedStatement pstm1 = conn.prepareStatement("update AccountMember set SoTienNap = ? where MbID = ?");
//                                    pstm1.setInt(1, ST);
//                                    pstm1.setInt(2, id);
//                                    
//                                    pstm1.executeUpdate();
//
//                            } catch (SQLException e1) {
//                                    // TODO Auto-generated catch block
//                                    e1.printStackTrace();
//                            }
//	         
//	           
//	        	}
//                        else {
//                            try {
////            
//			PreparedStatement pstm1 = conn.prepareStatement("update QLMayTinh set status = ?  where Tenmay = 'Máy 1' ");
//			pstm1.setInt(1, 0);
//                      
//			pstm1.executeUpdate();
//                        TT=0;
//		
//		} catch (SQLException e1) {						
//			
//		}
//                        }
//                        }
//                   else if(TT==0){
//                       btnLogout.doClick();
//                       executorService.shutdown();
//                   }
////                 
//                    
//                }
//	      
//	    }, 0, 1, TimeUnit.SECONDS);
//        
//        
//    }
//    public void setEvenLogout(ActionListener e){
//        btnLogout.addActionListener(e);
//        
//    }
//
////    public void truycap(String nc) {
////		
////		
////		String STN = new String();
////		try {
////			PreparedStatement pstm2 = conn.prepareStatement("select sotiennap from AccountMember where MbName = ?");
////			pstm2.setString(1,nc );
////			
////			ResultSet rs = pstm2.executeQuery();
////			if(rs.next()) {
////				ST=rs.getInt("SoTienNap");
////				lblMoney.setText("Số tiền còn lại : "+format1.format(ST));
////			}
////	
////		} catch (SQLException e1) {
////			
////			e1.printStackTrace();
////		}
////                
////                try {
////			PreparedStatement pstm1 = conn.prepareStatement("select status from QLMayTinh  where Tenmay = 'Máy 1'");
////			
////			ResultSet rs = pstm1.executeQuery();
////			if(rs.next()) {
////				TT=rs.getInt("status");
////			}
////			
////			
////		} catch (SQLException e1) {
////			// TODO Auto-generated catch block
////			e1.printStackTrace();
////		}
////                
////                System.out.println(TT);
////                if(TT==0) {
////			try {
////				PreparedStatement pstm1 = conn.prepareStatement("update QLMayTinh set  Mbname = null , MbID = -1 where Tenmay = 'Máy 1' ");
////	    			
////				
////				
////	    			pstm1.executeUpdate();
////	    	
////	    		} catch (SQLException e1) {
////				// TODO Auto-generated catch block
////				e1.printStackTrace();
////	    		}
////			
////		}
////                
////                int gio,phut,giay;
////		float time;
////		time= (float)ST/10000;
////		
////		
////		gio=(int)time;
////		time=time-gio;
////		time=time*60;
////		phut= (int)time;
////		time=time-phut;
////		time=time*60;
////		giay=(int)time;
////		
////		String hiengio=String.valueOf(gio)+":"+String.valueOf(phut)+":"+String.valueOf(giay);
////		lblTime.setText("Số giờ còn lại : "+hiengio);
////    }
//    
//        
//   
//}
