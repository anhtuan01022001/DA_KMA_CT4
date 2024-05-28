package QLQN_Controller;

import QLQN_Model.DangKyNguoiChoi_model;
import java.sql.Connection;
import java.sql.DriverManager;
import QLQN_Model.DangNhap_model;
import QLQN_Model.QLKH_model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DangNhap_Controller {
    private Connection conn= null;
    int Kq = 0;
    public DangNhap_Controller(){
               
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QUAN_NET;user=sa;password=Nq25142001");  
        } catch (Exception e) {
             
        }
    }
    public int checkLoginAdmin(DangNhap_model DN_model){
        String query = "SELECT * FROM AcountAdmin WHERE AdName=?  AND Passwords=?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, DN_model.getUserName());
            ps.setString(2, DN_model.getPassWord());
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Kq=1;
                
            }
            else{
                Kq=2;
            }
             conn.close();
        } catch (Exception e) {
            Kq=3;
        }
       
        return Kq;
    }

  public int checkLoginNguoiChoi(QLKH_model DN_model){
        String query = "SELECT * FROM AccountMember WHERE MbName=?  AND PassWords=?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, DN_model.getMbName());
            ps.setString(2, DN_model.getPassWords());
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Kq=1;
                
            }
            else{
                Kq=2;
            }
             conn.close();
        } catch (Exception e) {
            Kq=2;
        }
        return Kq;
    }  
}
