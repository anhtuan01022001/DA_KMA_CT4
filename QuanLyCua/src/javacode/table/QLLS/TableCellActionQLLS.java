package javacode.table.QLLS;

import javacode.table.QLLS.*;
import java.awt.Color;
import java.awt.Component;
import javacode.table.QLLS.ModelActionQLLS;
import QLRV_Model.QLLS_model;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableCellActionQLLS extends DefaultCellEditor {

    private ModelActionQLLS data;

    public TableCellActionQLLS() {
        super(new JCheckBox());
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int i, int i1) {
        data = (ModelActionQLLS) o;
        ActionQLLS cell = new ActionQLLS(data);
        cell.setBackground(new Color(239, 244, 255));
        return cell;
    }

    //  This method to pass data to cell render when focus lose in cell
    @Override
    public Object getCellEditorValue() {
        return data;
    }
}
