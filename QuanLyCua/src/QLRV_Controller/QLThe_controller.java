/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLRV_Controller;

import QLRV_Model.QLThe_model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author QuynhTn
 */
public class QLThe_controller {
    private Connection conn;
    int kq;
    public QLThe_controller(){
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:src/db/detection_data.db"; 
            conn = DriverManager.getConnection(url); 
        } catch (Exception e) {
             
        }
    }
    public int XoaMayTram(QLThe_model maytram){
         try {
            PreparedStatement pstm = conn.prepareStatement("delete from QLThe where UserID = ? ");
            pstm.setInt(1, maytram.getUserID());
            pstm.executeUpdate();
            kq=1;
				
	} catch (SQLException e1) {
            kq=2;
				}
        
        return kq;
    }
    public int ThemMayTram(QLThe_model maytram){
                String query = "INSERT INTO QLThe values (?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maytram.getTheUID());
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
        public int CheckMayTram(QLThe_model maytram){
         try {
            PreparedStatement pstm = conn.prepareStatement("select * from QLThe where User_ID = ? ");
            pstm.setInt(1, maytram.getUserID());
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
    public int CheckTenMayTram(QLThe_model maytram){
         try {
            PreparedStatement pstm = conn.prepareStatement("select * from QLThe where UserID = ? ");
            pstm.setString(1, maytram.getUserName());
            
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
     public int CheckMayTramSua(QLThe_model maytramSua){
         try {
            PreparedStatement pstm = conn.prepareStatement("select UserID from QLThe where UserID = ? ");
            pstm.setInt(1, maytramSua.getUserID());
             ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                String ten = rs.getString("Tenmay");
                if(ten.equals(maytramSua.getUserID())){
                    
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


    public int SuaMayTram(QLThe_model maytram){
            String query = "UPDATE QLThe set TheUID=?,UserID=? where UserID=? ";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,maytram.getTheUID());
            ps.setInt(2,maytram.getUserID());
            ps.setString(3, maytram.getUserName());
            
             ps.executeUpdate();
             System.out.println(4);
             kq=1; 
        } catch (Exception e) {
          kq=2;
        }
        
        return  kq; 
        
    }
    
       public String TenMayTram(QLThe_model maytram){
           String ten =null;
            String query = "select User_Name from QLThe where User_ID = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1,maytram.getUserID());
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 ten = rs.getString("Tenmay");
             }
        } catch (Exception e) {
          
        }
        
        return  ten; 
        
    }
       
    
    
}
