package javacode.table.QLMT;

import java.awt.Color;
import java.awt.Component;
import javacode.table.QLMT.ActionQLMT;
import javacode.table.QLMT.ModelActionQLMT;
import QLQN_Model.QLMT_model;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableCellActionQLMT extends DefaultCellEditor {

    private ModelActionQLMT data;

    public TableCellActionQLMT() {
        super(new JCheckBox());
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int i, int i1) {
        data = (ModelActionQLMT) o;
        ActionQLMT cell = new ActionQLMT(data);
        cell.setBackground(new Color(239, 244, 255));
        return cell;
    }

    //  This method to pass data to cell render when focus lose in cell
    @Override
    public Object getCellEditorValue() {
        return data;
    }
}
