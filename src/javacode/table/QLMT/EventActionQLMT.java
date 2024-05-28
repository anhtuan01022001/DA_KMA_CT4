package javacode.table.QLMT;


import QLQN_Model.QLMT_model;

public interface EventActionQLMT {

    public void delete(QLMT_model QLMT);

    public void update(QLMT_model QLMT);

    public void pay(QLMT_model QLMT);
    
    public void show(QLMT_model QLMT);
}
