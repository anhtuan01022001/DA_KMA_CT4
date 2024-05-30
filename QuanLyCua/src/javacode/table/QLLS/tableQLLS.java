
package javacode.table.QLLS;

import javacode.table.QLLS.*;
import javacode.table.Table;
import javax.swing.table.TableCellEditor;


public class tableQLLS extends Table{
    
    @Override
    public TableCellEditor getCellEditor(int row, int col) {
        if (col == 2) {
            return new TableCellActionQLLS();
        } else {
            return super.getCellEditor(row, col);
        }
    }
}
