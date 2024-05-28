
package javacode.table.QLKH;

import javacode.table.Table;
import javax.swing.table.TableCellEditor;


public class tableQLKH extends Table{
    
    @Override
    public TableCellEditor getCellEditor(int row, int col) {
        if (col == 2) {
            return new TableCellActionQLKH();
        } else {
            return super.getCellEditor(row, col);
        }
    }
}
