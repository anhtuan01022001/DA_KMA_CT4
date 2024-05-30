package QLRV_Model;

import javacode.table.QLThe.ModelActionQLThe;
import javacode.table.QLThe.EventActionQLThe;

/*
đây là model của quán lý thẻ
hiện tại chỏ có lấy ra UID thẻ (trong database là UID  )
cái này có thể cho thêm UserName vào để về sau có thể xử lí nhiều thành phần
bên dưới có câu lệnh tRowTable để chỉnh sửa từ các thành phần nhập vào đến các thành phần xuất ra
*/

public class QLThe_model {
    // id,uid thẻ,UserID,Username
    private int ID;
    private String TheUID;
    private int User_ID;
    private String UserName;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public String getTheUID() {
        return TheUID;
    }

    public void setTheUID(String TheUID) {
        this.TheUID = TheUID;
    }
    
    public int getUserID() {
        return User_ID;
    }

    public void setUserID(int UserID) {
        this.User_ID = UserID;
    }
    
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public QLThe_model(){
    }

    public QLThe_model(int ID,String TheUID,int User_ID,String UserName) {
        this.ID = ID;
        this.TheUID = TheUID;
        this.User_ID = User_ID;
        this.UserName = UserName;
        
    }
    
    public Object[] toRowTable(EventActionQLThe event) {// dùng để chỉnh sửa thành phần trong bảng
       
        return new Object[]{ID, TheUID,User_ID,UserName, new ModelActionQLThe(this,event)};
    }

    
}
