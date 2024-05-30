
package QLRV_View;

import QLRV_Controller.MB_controller;
import QLRV_Model.QLThe_model;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javacode.custom.Confirm;
import javacode.custom.Message;
import javacode.custom.outlineButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;

    

public class ChiTietThe_view extends JPanel{
    private int ST =0;
    private JLabel NameMay = new JLabel("Tên máy");
    private JLabel NameKH = new JLabel("Tên người chơi");
    private JLabel lblMoney = new JLabel("Số tiền còn lại:");
    private JLabel lblTime = new JLabel("Thời gian còn lại:");
    private outlineButton btnLogout  = new outlineButton();
    private Connection conn;
   
    MB_controller c = new MB_controller();
        
    static  Locale locale =new Locale("vi","VN");
   static NumberFormat format1 = NumberFormat.getInstance(locale);
    public ChiTietThe_view(QLThe_model model) {
        if(model.getUserName().equals("")){
            screennull();
        }
        else{
            screenEX(model);
        }
        
    }
    
    public void screennull(){
//        Panel_QLThe_view.btnX.setVisible(false);
        setLayout(new MigLayout("fill", "0[fill]0", "0[fill]0"));
        setBackground(Color.white);
        removeAll();
        revalidate();
        repaint();
        
        
    }
    public void screenEX(QLThe_model model){
//        Panel_QLThe_view.btnX.setVisible(true);
        setLayout(new MigLayout("fill,wrap", "0[center]0", "30[][50][50!][50!][]90"));
        removeAll();
        setBackground(Color.white);
        add(NameMay);
        add(NameKH,"gapbottom 20!");
        add(lblMoney,"left,gapleft 36!");
        add(lblTime,"left,gapleft 36!");
        add(btnLogout,"gaptop 50!,w 110!,h 50!");
        
        NameMay.setFont(new Font("sansserif", 1, 50));
        NameMay.setText(model.getTheUID());
//        int id = c.IDmbName(model.getMbName());
       
        NameKH.setFont(new Font("sansserif", 1, 30));
        NameKH.setText("Tài khoản: "+c.TenMbName(model.getUserID()));
        
        lblMoney.setFont(new Font("sansserif", 1, 20));
        
        lblTime.setFont(new Font("sansserif", 1, 20));
        
        btnLogout.setBoderColor(Color.DARK_GRAY);
        btnLogout.setForeground(Color.DARK_GRAY);
        btnLogout.setText("Tắt máy");
//        btnLogout.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(showConfirm("Bạn chắn chắn muốn tắt "+ c.TenMbName(model.getMbID())+"?")){
//                    
////                    if(model.getMayID()==1){
////                        QL_NguoiChoi_view v = new QL_NguoiChoi_view(1);
////                        v.dispose();
////                    }
//                    
//                   try {
//					
//					PreparedStatement pstm = conn.prepareStatement("update QLMayTinh set status = 0, MbName = ? ,MbID = ? where Mayid = ?  ");
//					 pstm.setString(1,null);
//                                        pstm.setInt(2, -1);
//                                        pstm.setInt(3, model.getMayID());
//					pstm.executeUpdate();
//                                       
//					
//					Panel_QLThe_view.loadData();
//					Message msg = new Message();
//                                        msg.showMessage("Tắt máy thành công!");
//                                        screennull();
//					
//			} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//                 }
//				
//            }
//        });
        
        
        
		try {
			Class.forName("org.sqlite.JDBC");
                        String url = "jdbc:sqlite:C:\\Users\\tuan\\Downloads\\yolov8\\detection_data.db"; 
                        conn = DriverManager.getConnection(url);
		    
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}

		final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
	    executorService.scheduleAtFixedRate(new Runnable() {
	    	
	        @Override
	        public void run() {
		
	           truycap(c.TenMbName(model.getUserID()));
                   NameKH.setText("Tài khoản: "+c.TenMbName(model.getUserID()));
                    
                }
	      
	    }, 0, 1, TimeUnit.SECONDS);
    }
    
        private boolean showConfirm(String message) {
        Confirm obj = new Confirm(QL_Admin_view.getFrames()[1],true);
        obj.showConfirm(message);
        return obj.isOk();
    }
	
	
	public void truycap(String name) {
		String STN = new String();
		
		try {
			PreparedStatement pstm2 = conn.prepareStatement("select sotiennap from AccountMember where MbName = ?");
			pstm2.setString(1,name );
			
			ResultSet rs = pstm2.executeQuery();
			if(rs.next()) {
				ST=rs.getInt("SoTienNap");
				
                                
				lblMoney.setText("Số tiền còn lại:  "+format1.format(ST)+"đ");
				
				
			}
	
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		
		int gio,phut,giay;
		float time;
		time= (float)ST/10000;
		
		
		gio=(int)time;
		time=time-gio;
		time=time*60;
		phut= (int)time;
		time=time-phut;
		time=time*60;
		giay=(int)time;
		
		String hiengio=String.valueOf(gio)+":"+String.valueOf(phut)+":"+String.valueOf(giay);
		lblTime.setText("Số giờ còn lại:  "+hiengio);
	}
    
    
    
    
}
