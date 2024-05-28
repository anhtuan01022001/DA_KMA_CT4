
package javacode.table.QLMT;

import javacode.table.Table;
import javax.swing.table.TableCellEditor;


public class tableQLMT extends Table{
    
    @Override
    public TableCellEditor getCellEditor(int row, int col) {
        if (col == 2) {
            return new TableCellActionQLMT();
        } else {
            return super.getCellEditor(row, col);
        }
    }
}
