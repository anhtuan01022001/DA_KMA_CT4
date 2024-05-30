
package javacode.table.QLThe;

import javacode.table.Table;
import javax.swing.table.TableCellEditor;


public class tableQLThe extends Table{
    
    @Override
    public TableCellEditor getCellEditor(int row, int col) {
        if (col == 2) {
            return new TableCellActionQLThe();
        } else {
            return super.getCellEditor(row, col);
        }
    }
}
