/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLQN_Controller;

import QLQN_Model.QLMT_model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author QuynhTn
 */
public class QLMayTram_controller {
    private Connection conn;
    int kq;
    public QLMayTram_controller(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QUAN_NET;user=sa;password=Nq25142001");  
        } catch (Exception e) {
             
        }
    }
    public int XoaMayTram(QLMT_model maytram){
         try {
            PreparedStatement pstm = conn.prepareStatement("delete from QLMayTinh where MayID = ? ");
            pstm.setInt(1, maytram.getMayID());
            pstm.executeUpdate();
            kq=1;
				
	} catch (SQLException e1) {
            kq=2;
				}
        
        return kq;
    }
    public int ThemMayTram(QLMT_model maytram){
                String query = "INSERT INTO QLMayTinh values (?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maytram.getTenMay());
            ps.setString(2, "False");
            ps.setString(3,""); 
             ps.executeUpdate();
             System.out.println("4");
             kq=1; 
 
                          
        } catch (Exception e) {
          kq=2;
        }
        return   kq; 
        
    }
        public int CheckMayTram(QLMT_model maytram){
         try {
            PreparedStatement pstm = conn.prepareStatement("select * from QLMayTinh where MayID = ? ");
            pstm.setInt(1, maytram.getMayID());
             ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                kq=1;
                
            }
            else{
                kq=2;
            }
      
					
	} catch (SQLException e1) {
            kq=2;
				}
        
        return kq;
    }
    public int CheckTenMayTram(QLMT_model maytram){
         try {
            PreparedStatement pstm = conn.prepareStatement("select * from QLMayTinh where Tenmay = ? ");
            pstm.setString(1, maytram.getTenMay());
            
             ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                kq=1;
                
            }
            else{
                kq=2;
            }
   
	 				
	} catch (SQLException e1) {
            kq=3;
				}
        
        return kq;
    }
     public int CheckMayTramSua(QLMT_model maytramSua){
         try {
            PreparedStatement pstm = conn.prepareStatement("select Tenmay from QLMayTinh where MayID = ? ");
            pstm.setInt(1, maytramSua.getMayID());
             ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                String ten = rs.getString("Tenmay");
                if(ten.equals(maytramSua.getTenMay())){
                    
                    kq=1; //Ten may k sua
                }
                else{
                    kq=2; //Ten may da sua
                }
                
                
            }
					
	} catch (SQLException e1) {
            kq=2;
				}
        
        return kq;
    }


    public int SuaMayTram(QLMT_model maytram){
            String query = "UPDATE QLMayTinh set Tenmay=?,Status=?,MbName=? where MayID=? ";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maytram.getTenMay());
            ps.setString(2, maytram.getTinhTrang());
            ps.setString(3,maytram.getMbName()); 
            ps.setInt(4,maytram.getMayID());
             ps.executeUpdate();
             System.out.println(5);
             kq=1; 
        } catch (Exception e) {
          kq=2;
        }
        
        return  kq; 
        
    }
    
       public String TenMayTram(QLMT_model maytram){
           String ten =null;
            String query = "select Tenmay from QLMayTinh where MayID = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1,maytram.getMayID());
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 ten = rs.getString("Tenmay");
             }
        } catch (Exception e) {
          
        }
        
        return  ten; 
        
    }
       
    
    
}
