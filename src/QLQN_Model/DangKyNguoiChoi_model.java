/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLQN_Model;

/**
 *
 * @author QuynhTn
 */
public class DangKyNguoiChoi_model {
    String MbName;
    String PassWord;
    String SoTienNap;

    public DangKyNguoiChoi_model() {
    }



    public DangKyNguoiChoi_model(String MbName, String PassWord, String SoTienNap) {
        this.MbName = MbName;
        this.PassWord = PassWord;
        this.SoTienNap = SoTienNap;
    }

    public String getSoTienNap() {
        return SoTienNap;
    }

    public void setSoTienNap(String SoTienNap) {
        this.SoTienNap = SoTienNap;
    }
    
    public String getMbName() {
        return MbName;
    }

    public void setMbName(String MbName) {
        this.MbName = MbName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
    }

 
    
    
    
    
}
