/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLQN_Controller;

import QLQN_Model.DangKyNguoiChoi_model;
import QLQN_Model.DangNhap_model;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

/**
 *
 * @author QuynhTn
 */
public class DangKyNguoiChoi_Controller {
    private Connection conn= null;
    int rs=0;
    int Kq=0;
    public DangKyNguoiChoi_Controller(){
               
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QUAN_NET;user=sa;password=Nq25142001");  
        } catch (Exception e) {
             
        }
    }
    public int Insert_Member(DangKyNguoiChoi_model member){
                String query = "INSERT INTO AccountMember values (?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, member.getMbName());
            ps.setString(2, member.getPassWord());
            ps.setString(3,"" ); 
             rs=1; 
             ps.executeUpdate();

                          
        } catch (Exception e) {
          
        }
        return   rs; 
        
    }
      public int checkLoginNguoiChoi(DangKyNguoiChoi_model DN_model){
          
        String query = "SELECT * FROM AccountMember WHERE MbName=? ";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, DN_model.getMbName());
            
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Kq=1;
                
            }
            else{
                Kq=2;
            }
        } catch (Exception e) {
            Kq=2;
        }
        return Kq;
    } 
    
 
}
