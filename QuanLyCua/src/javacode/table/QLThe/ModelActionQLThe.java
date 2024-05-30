
package javacode.table.QLThe;

import QLRV_Model.QLThe_model;


public class ModelActionQLThe {
    private EventActionQLThe event;
    private QLThe_model QLMT;
    
    public EventActionQLThe getEvent() {
        return event;
    }

    public void setEvent(EventActionQLThe event) {
        this.event = event;
    }
     public QLThe_model getQLMT() {
        return QLMT;
    }

    public void setQLMT(QLThe_model QLMT) {
        this.QLMT = QLMT;
    }
    
  
    public ModelActionQLThe(QLThe_model QLMT, EventActionQLThe event) {
        this.QLMT = QLMT;
        this.event = event;
    }
    
    
    
    public ModelActionQLThe() {
    }
   

   
}
