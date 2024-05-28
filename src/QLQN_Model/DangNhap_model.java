package QLQN_Model;

public class DangNhap_model {
    String UserName;
    String PassWord;

    public DangNhap_model() {
    }

    public DangNhap_model(String UserName, String PassWord) {
        this.UserName = UserName;
        this.PassWord = PassWord;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
    }
    
    
}
