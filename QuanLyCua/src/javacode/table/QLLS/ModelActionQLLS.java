
package javacode.table.QLLS;

import javacode.table.QLLS.*;
import QLRV_Model.QLLS_model;


public class ModelActionQLLS {
    private EventActionQLLS event;
    private QLLS_model QLLS;
    
    public EventActionQLLS getEvent() {
        return event;
    }

    public void setEvent(EventActionQLLS event) {
        this.event = event;
    }
     public QLLS_model getQLLS() {
        return QLLS;
    }

    public void setQLLS(QLLS_model QLLS) {
        this.QLLS = QLLS;
    }
    
  
    public ModelActionQLLS(QLLS_model QLLS, EventActionQLLS event) {
        this.QLLS = QLLS;
        this.event = event;
    }
    
    
    
    public ModelActionQLLS() {
    }
   

   
}
