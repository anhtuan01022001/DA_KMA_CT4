package QLRV_Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import QLRV_Model.DangNhap_model;
import QLRV_Model.QLMB_model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DangNhap_Controller {
    private Connection con= null;
    int Kq = 0;

    public DangNhap_Controller() {
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:C:\\Users\\tuan\\Downloads\\yolov8\\detection_data.db"; 
            con = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println("Lỗi khi kết nối đến cơ sở dữ liệu: " + e.getMessage());
            Kq = 2;
        }
    }

    public int checkLoginAdmin(DangNhap_model DN_model) {
        String query = "SELECT * FROM admin WHERE Admin_name=? AND Passwords=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, DN_model.getUserName());
            ps.setString(2, DN_model.getPassWord());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Kq = 1;
            } else {
                Kq = 2;
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi kiểm tra đăng nhập: " + e.getMessage());
            e.printStackTrace(); // In ra stack trace của lỗi để hiểu rõ hơn vấn đề
            Kq = 3;
        } finally {
            // Đóng kết nối sau khi sử dụng
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println("Lỗi khi đóng kết nối: " + e.getMessage());
            }
        }
        return Kq;
    }

}
