package javacode.table;

import javacode.table.QLThe.TableCellActionQLThe;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javacode.table.QLMB.ActionQLMB;
import javacode.table.QLMB.ModelActionQLMB;
import javacode.table.QLThe.ActionQLThe;
import javacode.table.QLThe.ModelActionQLThe;
import QLRV_Model.QLThe_model;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class Table extends JTable {

    public Table() {
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40);
        setFont(new Font("sansserif", 0, 14));
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "");

                if (i1 == 2) {
                    header.setHorizontalAlignment(JLabel.CENTER);
                }
                return header;
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean focus, int row, int col) {
                 if (o instanceof ModelActionQLThe) {
                    ModelActionQLThe data = (ModelActionQLThe) o;
                    ActionQLThe cell = new ActionQLThe(data);
                    if (selected) {
                         
                        cell.setBackground(new Color(239, 244, 255));
                    } else {
                       
                        cell.setBackground(Color.WHITE);
                        
//                        
                    }
                    return cell;
                }
                 
                 else if (o instanceof ModelActionQLMB) {
                    ModelActionQLMB data = (ModelActionQLMB) o;
                    ActionQLMB cell = new ActionQLMB(data);
                    if (selected) {
                         
                        cell.setBackground(new Color(239, 244, 255));
                    } else {
                       
                        cell.setBackground(Color.WHITE);
                        
//                        
                    }
                    return cell;
                }
                 
                
                 else {
                    Component com = super.getTableCellRendererComponent(jtable, o, selected, focus, row, col);
                    setBorder(noFocusBorder);
                     
                    com.setForeground(new Color(102, 102, 102));
                    if (selected) {
                        
                        com.setBackground(new Color(239, 244, 255));
                    } else {
                       
                        
                        com.setBackground(Color.WHITE);
                        
                    }
                    return com;
                }
            }
        });
    }
     
    

    public void addRow(Object[] row) {
        DefaultTableModel mod = (DefaultTableModel) getModel();
//       this.setFont(new Font("Tahoma",0,16));
        mod.addRow(row);
    }

    public void fixTable(JScrollPane scroll) {
        scroll.getViewport().setBackground(Color.WHITE);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        JPanel p = new JPanel();
        p.setBorder(new MatteBorder(0,0,1,0,new Color(0,0,0)));
        p.setBackground(Color.WHITE);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        scroll.setBorder(new EmptyBorder(0, 0, 0, 0));
    }
}
