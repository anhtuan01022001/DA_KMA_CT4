/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLRV_Controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author QuynhTn
 */
public class MB_controller {
    private Connection conn;
    int kq;
    public MB_controller(){
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:src/db/detection_data.db"; 
            conn = DriverManager.getConnection(url); 
        } catch (Exception e) {
             
        }
    }

    public ResultSet timKiem(String user,Date date1,Date date2){
        ResultSet rs = null;
        try {
			PreparedStatement pstm = conn.prepareStatement("select * from ThongKe where MbName= ? and date between ? and ? ");
			pstm.setString(1, user);
                        pstm.setDate(2,date1 );
                        pstm.setDate(3,date2 );
			
			rs = pstm.executeQuery();
			
		} catch (SQLException e1) {						
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        return rs;
    }
      public ResultSet timKiemNgay(String user,Date date){
        ResultSet rs = null;
        try {
			PreparedStatement pstm = conn.prepareStatement("select * from ThongKe where MbName= ? and date = ? ");
			pstm.setString(1, user);
                        pstm.setDate(2,date );
                        
			
			rs = pstm.executeQuery();
		
		} catch (SQLException e1) {						
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        return rs;
    }
      
    public int SuaTaiKhoan(String cu,String moi){
        try {
            
                PreparedStatement pstm = conn.prepareStatement("select * from AccountMember  where MbName= ? ");
                pstm.setString(1, moi);
                
                ResultSet rs = pstm.executeQuery();
                if (rs.next()){
                    kq =2;
                
                }
                else{
			PreparedStatement pstm1 = conn.prepareStatement("update AccountMember set MbName = ? where MbName = ? ");
			pstm1.setString(1, moi);
                        pstm1.setString(2, cu);
                        
			pstm1.executeUpdate();
                        kq=1;
                }
		
		} catch (SQLException e1) {						
			kq=3;
		}
                 
        
        
        
        return kq;
    }
     public int KTMatKhau(String user,String pass){
        try {
            
                PreparedStatement pstm = conn.prepareStatement("select * from AccountMember  where MbName= ? and PassWords = ? ");
                pstm.setString(1, user);
                 pstm.setString(2, pass);
                
                ResultSet rs = pstm.executeQuery();
                if (rs.next()){
                    kq =1;
                
                }
                else{
                    kq =2;
                }
                
		
		} catch (SQLException e1) {						
			kq=3;
		}
        return kq;
    }
     public int DoiMatKhau(String user,String pass){
        try {
            
			PreparedStatement pstm1 = conn.prepareStatement("update AccountMember set PassWords = ? where MbName = ? ");
			pstm1.setString(1, pass);
                        pstm1.setString(2, user);
                        
			pstm1.executeUpdate();
                        kq=1;
                
		
		} catch (SQLException e1) {						
			kq=2;
		}
                 
        
        
        
        return kq;
    }
     public void DoiMay1(int tt,String tenmay,int id){
        try {
            
			PreparedStatement pstm1 = conn.prepareStatement("update QLMayTinh set status = ? , MbName = ? , MbID = ? where Tenmay = 'Máy 1' ");
			pstm1.setInt(1, tt);
                        pstm1.setString(2,tenmay);
                        pstm1.setInt(3, id);
			pstm1.executeUpdate();
		
		} catch (SQLException e1) {						
			
		}
    }
         public int IDmbName(String user){
             int id =-1;
        try {
            
                PreparedStatement pstm = conn.prepareStatement("select MbID from AccountMember  where MbName= ? ");
                pstm.setString(1, user);
                
                
                ResultSet rs = pstm.executeQuery();
                while (rs.next()){
                    id =rs.getInt("MbID");
                
                }
		
		} catch (SQLException e1) {						
			
		}
        return id;
    }
     public String TenMbName( int id){
           String ten =null;
            String query = "select MbName from AccountMember where MbID = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1,id);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 ten = rs.getString("MbName");
             }
        } catch (Exception e) {
          
        }
        
        return  ten; 
        
    }
    
}
