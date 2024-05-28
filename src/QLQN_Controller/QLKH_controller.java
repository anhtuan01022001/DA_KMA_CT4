/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLQN_Controller;

import QLQN_Model.QLKH_model;
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
public class QLKH_controller {
     private Connection conn;
    int kq;
    public QLKH_controller(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QUAN_NET;user=sa;password=Nq25142001");  
        } catch (Exception e) {
             
        }
    }
    public int XoaNguoiChoi(QLKH_model khachhang){
         try {
            PreparedStatement pstm = conn.prepareStatement("delete from AccountMember where MbID = ? ");
            pstm.setInt(1, khachhang.getMbID());
            pstm.executeUpdate();
            kq=1;
	 				
	} catch (SQLException e1) {
            kq=2;
				}
        
        return kq;
    }
    public int ThemNguoiChoi(QLKH_model khachhang){
                String query = "INSERT INTO AccountMember values (?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, khachhang.getMbName());
            ps.setString(2, khachhang.getPassWords());
            ps.setInt(3, khachhang.getSoTienNap());
             ps.executeUpdate();
             kq=1; 
           
        } catch (Exception e) {
          kq=2;
        }
        return   kq; 
        
    }
        public int CheckTenNguoiChoi(QLKH_model khachhang){
         try {
            PreparedStatement pstm = conn.prepareStatement("select * from AccountMember where MbName = ? ");
            pstm.setString(1, khachhang.getMbName());
            
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
    public int Naptien(String MbName,int sotiennap){
        try {
            PreparedStatement pstm1=conn.prepareStatement(" select * from AccountMember where MbName= ? ");
            System.out.println(-1);
            pstm1.setString(1,MbName);
            System.out.println(MbName);
            ResultSet rs = pstm1.executeQuery();
            System.out.println(10);
		int TS;				
						
            if(rs.next()) {
                TS=rs.getInt("SoTienNap");
                System.out.println(1);
                TS=TS+sotiennap;
                System.out.println(TS);
                pstm1=conn.prepareStatement("update AccountMember set SoTienNap = ? where MbName = ?");	
                pstm1.setInt(1, TS);
                System.out.println(2);
		pstm1.setString(2,MbName);
                System.out.println(3);
                
		pstm1.executeUpdate();
                System.out.println(4);
		pstm1 = conn.prepareStatement("insert into ThongKe values ('"+java.time.LocalDate.now()+"',?,?,?)");
                System.out.println(5);
		pstm1.setInt(1,sotiennap);
                System.out.println(6);
		pstm1.setInt(2,rs.getInt("MbID"));
                System.out.println(7);
                pstm1.setString(3,MbName);
                System.out.println(8);
				
		pstm1.executeUpdate();
                System.out.println(9);
                kq =1;
                }
           
        } catch (Exception e) {
            kq=2;
        }
		return kq;
    }              
    
    
}
