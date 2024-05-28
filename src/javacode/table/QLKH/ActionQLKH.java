/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacode.table.QLKH;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javacode.custom.Button;
import javacode.table.QLMT.ModelActionQLMT;
import QLQN_Model.QLMT_model;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author sondu
 */
public class ActionQLKH extends JPanel{
  public  Button cmdDelete = new Button();
  public  Button cmdMoney = new Button();
  public  Button cmdShow = new Button();
    public ActionQLKH(ModelActionQLKH data){
        this.setBorder(null);
        cmdDelete.setIcon(new ImageIcon(getClass().getResource("/Image/delete.png")));
        cmdMoney.setIcon(new ImageIcon(getClass().getResource("/Image/money.png")));
         cmdShow.setIcon(new ImageIcon(getClass().getResource("/Image/show.png")));
         
        cmdMoney.setBounds(5, 16, 30, 30);
        cmdShow.setBounds(5, 16+30+5, 30, 30);
        cmdDelete.setBounds(5, 16+30+5+30+5, 30, 30);
        
        cmdMoney.setRadius(90);
        cmdDelete.setRadius(90);
        cmdShow.setRadius(90);
        
         cmdDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
         cmdMoney.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        add(cmdMoney);
        add(cmdShow);
        add(cmdDelete);
        
        cmdMoney.addActionListener(new ActionListener() {
      
            @Override
            public void actionPerformed(ActionEvent e) {
              
                data.getEvent().pay(data.getQLKH());
 
            }
        });
        cmdShow.addActionListener(new ActionListener() {
      
            @Override
            public void actionPerformed(ActionEvent e) {
//              
                 data.getEvent().show(data.getQLKH());
 
            }
        });

        cmdDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                data.getEvent().delete(data.getQLKH());
            }
        });
}
    

}
