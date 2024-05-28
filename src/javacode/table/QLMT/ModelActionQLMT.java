
package javacode.table.QLMT;

import QLQN_Model.QLMT_model;


public class ModelActionQLMT {
    private EventActionQLMT event;
    private QLMT_model QLMT;
    
    public EventActionQLMT getEvent() {
        return event;
    }

    public void setEvent(EventActionQLMT event) {
        this.event = event;
    }
     public QLMT_model getQLMT() {
        return QLMT;
    }

    public void setQLMT(QLMT_model QLMT) {
        this.QLMT = QLMT;
    }
    
  
    public ModelActionQLMT(QLMT_model QLMT, EventActionQLMT event) {
        this.QLMT = QLMT;
        this.event = event;
    }
    
    
    
    public ModelActionQLMT() {
    }
   

   
}
