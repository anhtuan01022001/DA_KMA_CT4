package QLRV_Model;

import javacode.table.QLLS.ModelActionQLLS;
import javacode.table.QLLS.EventActionQLLS;
import javacode.table.QLLS.EventActionQLLS;
import javacode.table.QLLS.ModelActionQLLS;
/**
 *
 * @author tuan
 */
public class QLLS_model {
    private int ID;
    private int User_ID;
    private String UserName;
    private String TimeIn;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getTimeIn() {
        return TimeIn;
    }

    public void setTimeIn(String TimeIn) {
        this.TimeIn = TimeIn;
    }
    
    public QLLS_model(int ID,int User_ID,String UserName, String TimeIn) {
        this.ID = ID;
        this.User_ID = User_ID;
        this.UserName = UserName;
        this.TimeIn = TimeIn;
    }
    
    public QLLS_model(int User_ID,String UserName, String TimeIn) {
        this.User_ID = User_ID;
        this.UserName = UserName;
        this.TimeIn = TimeIn;
    }
    
    public Object[] toRowTable(EventActionQLLS event) {// dùng để chỉnh sửa thành phần trong bảng
       
        return new Object[]{ID, User_ID, UserName,TimeIn, new ModelActionQLLS(this,event)};
    }
    
    public Object[] toRowUser(EventActionQLLS event) {// dùng để chỉnh sửa thành phần trong bảng
       
        return new Object[]{User_ID, UserName,TimeIn, new ModelActionQLLS(this,event)};
    }
}
