/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLRV_Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tuan
 */
public class QLLS_controller {
       
    private Connection conn;
    int kq;
     String kq1;
    public QLLS_controller(){
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:src/db/detection_data.db";
            conn = DriverManager.getConnection(url); 
        } catch (Exception e) {
             
        }
    }
    
//    public int tongNgay(){
//        try {
//			PreparedStatement pstm = conn.prepareStatement("select dbo.TongdoanhThuNgay() 'a'");
//			ResultSet rs = pstm.executeQuery();
//			while(rs.next()) {
//                             kq = rs.getInt("a");
//                            
//			
//			}
//			
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//        return kq;
//    }
//     public int tongThang(){
//        try {
//			PreparedStatement pstm = conn.prepareStatement("select dbo.TongdoanhThuThang() 'a'");
//			ResultSet rs = pstm.executeQuery();
//			while(rs.next()) {
//                            kq = rs.getInt("a");
//			
//			}
//			
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//        return kq;
//    }
//    public int tongNam(){
//        try {
//			PreparedStatement pstm = conn.prepareStatement("select dbo.TongdoanhThuNam() 'a'");
//			ResultSet rs = pstm.executeQuery();
//			while(rs.next()) {
//                            kq = rs.getInt("a");
//			
//			}
//		
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//        return kq;
//    }
//    public int tongQuy(){
//        try {
//			PreparedStatement pstm = conn.prepareStatement("select dbo.TongDoanhthuQuy() 'a'");
//			ResultSet rs = pstm.executeQuery();
//			while(rs.next()) {
//                            kq = rs.getInt("a");
//			
//			}
//		
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//        return kq;
//    }
    
}
