
package javacode.table.QLMB;

import javacode.table.Table;
import javax.swing.table.TableCellEditor;


public class tableQLMB extends Table{
    
    @Override
    public TableCellEditor getCellEditor(int row, int col) {
        if (col == 2) {
            return new TableCellActionQLMB();
        } else {
            return super.getCellEditor(row, col);
        }
    }
}
