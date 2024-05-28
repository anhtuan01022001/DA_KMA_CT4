/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLQN_Model;

import java.text.NumberFormat;
import java.util.Locale;
import javacode.table.QLKH.EventActionQLKH;
import javacode.table.QLKH.ModelActionQLKH;


public class QLKH_model {
    private int MbID;
    private String MbName;
    private String PassWords;
    private int SoTienNap;

    public QLKH_model(int MbID, String MbName, String PassWords, int SoTienNap) {
        this.MbID = MbID;
        this.MbName = MbName;
        this.PassWords = PassWords;
        this.SoTienNap = SoTienNap;
    }
    
    public Object[] toRowTable(EventActionQLKH event) {// dùng để chỉnh sửa thành phần trong bảng
         Locale locale =new Locale("vi","VN");
     
         NumberFormat format1 = NumberFormat.getInstance(locale);
        return new Object[]{MbName,format1.format(SoTienNap) , new ModelActionQLKH(this,event)};
    }

    public int getMbID() {
        return MbID;
    }

    public void setMbID(int MbID) {
        this.MbID = MbID;
    }

    public String getMbName() {
        return MbName;
    }

    public void setMbName(String MbName) {
        this.MbName = MbName;
    }

    public String getPassWords() {
        return PassWords;
    }

    public void setPassWords(String PassWords) {
        this.PassWords = PassWords;
    }

    public int getSoTienNap() {
        return SoTienNap;
    }

    public void setSoTienNap(int SoTienNap) {
        this.SoTienNap = SoTienNap;
    }
    public QLKH_model(){
    }     
           
}
