package javacode.table.QLThe;

import java.awt.Color;
import java.awt.Component;
import javacode.table.QLThe.ActionQLThe;
import javacode.table.QLThe.ModelActionQLThe;
import QLRV_Model.QLThe_model;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableCellActionQLThe extends DefaultCellEditor {

    private ModelActionQLThe data;

    public TableCellActionQLThe() {
        super(new JCheckBox());
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int i, int i1) {
        data = (ModelActionQLThe) o;
        ActionQLThe cell = new ActionQLThe(data);
        cell.setBackground(new Color(239, 244, 255));
        return cell;
    }

    //  This method to pass data to cell render when focus lose in cell
    @Override
    public Object getCellEditorValue() {
        return data;
    }
}
