
package javacode.table.QLMB;

import QLRV_Model.QLMB_model;




public class ModelActionQLMB {
    private EventActionQLMB event;
    private QLMB_model QLKH;
    
    public EventActionQLMB getEvent() {
        return event;
    }

    public void setEvent(EventActionQLMB event) {
        this.event = event;
    }
     public QLMB_model getQLKH() {
        return QLKH;
    }

    public void setQLMT(QLMB_model QLKH) {
        this.QLKH = QLKH;
    }
    
  
    public ModelActionQLMB(QLMB_model QLKH, EventActionQLMB event) {
        this.QLKH = QLKH;
        this.event = event;
    }
    
    
    
    public ModelActionQLMB() {
    }
   

   
}
