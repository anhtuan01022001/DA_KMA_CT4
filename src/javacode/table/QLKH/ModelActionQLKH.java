
package javacode.table.QLKH;

import QLQN_Model.QLKH_model;




public class ModelActionQLKH {
    private EventActionQLKH event;
    private QLKH_model QLKH;
    
    public EventActionQLKH getEvent() {
        return event;
    }

    public void setEvent(EventActionQLKH event) {
        this.event = event;
    }
     public QLKH_model getQLKH() {
        return QLKH;
    }

    public void setQLMT(QLKH_model QLKH) {
        this.QLKH = QLKH;
    }
    
  
    public ModelActionQLKH(QLKH_model QLKH, EventActionQLKH event) {
        this.QLKH = QLKH;
        this.event = event;
    }
    
    
    
    public ModelActionQLKH() {
    }
   

   
}
