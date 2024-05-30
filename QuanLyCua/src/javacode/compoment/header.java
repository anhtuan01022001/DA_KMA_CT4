
package javacode.compoment;

import java.awt.Color;
import java.awt.event.ActionListener;
import javacode.custom.Button;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
   
public class header extends JPanel{
     Button btnMenu = new Button();
     Button btnExit = new Button();
     
    public header() {
        setLayout(new MigLayout("fill","10[]10","[]"));
        setBackground(Color.WHITE);
        
        add(btnMenu,"w 34!,h 34!,left");
        add(btnExit,"w 34!,h 34!,right");   
        
        Edit_btnMenu();
        Edit_btnExit();
    }
     
    private void Edit_btnMenu(){
        btnMenu.setIcon(new ImageIcon(getClass().getResource("/Image/menu_1.png")));
    
    }
    private void Edit_btnExit(){
        btnExit.setIcon(new ImageIcon(getClass().getResource("/Image/exit.png")));
    
    }
    
    public void addMenuEvent(ActionListener event) {
        btnMenu.addActionListener(event);
    }
    
    public void addExitEvent(ActionListener event) {
        btnExit.addActionListener(event);
    }
}