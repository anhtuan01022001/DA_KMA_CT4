package QLQN_Model;

import javacode.table.QLMT.EventActionQLMT;
import javacode.table.QLMT.ModelActionQLMT;

/*
đây là model của quán lý máy trạm
hiện tại chỏ có lấy ra tên máy (trong database là mã máy )
cái này có thể cho thêm mbname vào để về sau có thể sử lí nhiều thành phần
bên dưới có câu lệnh tRowTable để chỉnh sửa từ các thành phần nhập vào đến các thành phần xuất ra
*/

public class QLMT_model {
    // idmaytram,tenmay,tinhtrang,mbname
    private int MayID;
    private String TenMay;
    private String TinhTrang;
    private String mbName;
    private int MbID;

    public int getMbID() {
        return MbID;
    }

    public void setMbID(int MbID) {
        this.MbID = MbID;
    }
    

    public int getMayID() {
        return MayID;
    }

    public void setMayID(int MayID) {
        this.MayID = MayID;
    }

    
    public String getMbName() {
        return mbName;
    }

    public void setMbName(String mbName) {
        this.mbName = mbName;
    }

    public String getTenMay() {
        return TenMay;
    }

    public void setTenMay(String TenMay) {
        this.TenMay = TenMay;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }
    public QLMT_model(){
    }

    public QLMT_model(int MayID, String TenMay, String TinhTrang, String mbName,int MbID) {
        this.MayID = MayID;
        this.TenMay = TenMay;
        this.TinhTrang = TinhTrang;
        this.mbName = mbName;
        this.MbID = MbID;
    }
    
    public Object[] toRowTable(EventActionQLMT event) {// dùng để chỉnh sửa thành phần trong bảng
       
        return new Object[]{TenMay, TinhTrang, new ModelActionQLMT(this,event)};
    }

    
}
