/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLRV_Model;

import java.text.NumberFormat;
import java.util.Locale;
import javacode.table.QLMB.ModelActionQLMB;
import javacode.table.QLMB.EventActionQLMB;


public class QLMB_model {
    private int MbID;
    private String MbName;
    private String MbData;

    public QLMB_model(int MbID, String MbName, String MbData) {
        this.MbID = MbID;
        this.MbName = MbName;
        this.MbData = MbData;
    }
    
    public Object[] toRowTable(EventActionQLMB event) {// dùng để chỉnh sửa thành phần trong bảng
         Locale locale =new Locale("vi","VN");
     
         NumberFormat format1 = NumberFormat.getInstance(locale);
        return new Object[]{MbID,MbName,MbData, new ModelActionQLMB(this,event)};
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
    
    public String getMbData() {
        return MbData;
    }

    public void setMbData(String MbData) {
        this.MbData = MbData;
    }

    public QLMB_model(){
    }     
           
}
