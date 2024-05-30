/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacode.table.QLThe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javacode.custom.Button;
import javacode.table.QLThe.ModelActionQLThe;
import QLRV_Model.QLThe_model;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author sondu
 */
public class ActionQLThe extends JPanel{
  public  Button cmdEdit = new Button();
  public  Button cmdDelete = new Button();
  public  Button cmdMoney = new Button();
  public  Button cmdShow = new Button();
    public ActionQLThe(ModelActionQLThe data){
        this.setBorder(null);
        cmdEdit.setIcon(new ImageIcon(getClass().getResource("/Image/edit.png")));
        cmdDelete.setIcon(new ImageIcon(getClass().getResource("/Image/delete.png")));
//        cmdMoney.setIcon(new ImageIcon(getClass().getResource("/Image/money.png")));
//        cmdShow.setIcon(new ImageIcon(getClass().getResource("/Image/show.png")));
//        
//        cmdMoney.setBounds(5, 16, 30, 30);
//        cmdShow.setBounds(5, 16+30+5, 30, 30);
        cmdEdit.setBounds(5, 16+30+5+30+5, 30, 30);
        cmdDelete.setBounds(5, 16+30+5+30+5+30+5, 30, 30);
        
//        
//        cmdMoney.setRadius(90);
//        cmdShow.setRadius(90);
        cmdEdit.setRadius(90);
        cmdDelete.setRadius(90);
        
//        add(cmdMoney);
//        add(cmdShow);
        add(cmdEdit);
        add(cmdDelete);
        
//        cmdMoney.addActionListener(new ActionListener() {
//      
//            @Override
//            public void actionPerformed(ActionEvent e) {
////              
//                 data.getEvent().pay(data.getQLMT());
// 
//            }
//        });
//        
//        cmdShow.addActionListener(new ActionListener() {
//      
//            @Override
//            public void actionPerformed(ActionEvent e) {
////              
//                 data.getEvent().show(data.getQLMT());
// 
//            }
//        });
        
        cmdEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                data.getEvent().update(data.getQLMT());
            }
        });
        cmdDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                data.getEvent().delete(data.getQLMT());
            }
        });
}
    
   
}
