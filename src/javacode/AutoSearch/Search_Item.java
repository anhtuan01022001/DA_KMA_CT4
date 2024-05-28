
package javacode.AutoSearch;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;


public class Search_Item extends JPanel{

    
    private JLabel lblText=new JLabel("sdfsa");
    public Search_Item(String Data) {
        setBackground(Color.white);
        addEventMouse(this);
        
        setLayout(null);
        add(lblText);

        
        
    
        lblText.setBounds(10, 3, 150, 18);
        lblText.setFont(new Font("Tahoma", 0, 14));
        lblText.setForeground(new Color(100,100,100));
        System.out.println(Data);
        lblText.setText(Data);
//        setBorder(new MatteBorder(0, 0, 1, 0, new Color(200, 200, 200)));
    }
    
      private void addEventMouse(Component com) {
        com.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                setBackground(new Color(204, 204, 255));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setBackground(Color.WHITE);
            }

        });
    }
      private ActionListener eventClick;
    
    
}
