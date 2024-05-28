
package javacode.compoment;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;
import net.miginfocom.swing.SwingContainerWrapper;


public class LogoPanel extends JPanel{
    
    private JLabel Logo = new JLabel(new ImageIcon(getClass().getResource("/Image/logo.png")));
    private JLabel textLogo = new JLabel("Q.N.E.T");
    public LogoPanel(){
        setLayout(new MigLayout("fill","0[]10[]","0[]15"));
        setBackground(new Color(0,0,0,0));
        
        add(Logo);
        add(textLogo,"wrap,w 100%");
        
        Edit_Logo();
        Edit_textLogo();
        
    }
    
    private void Edit_Logo(){
        Logo.setBackground(new Color(0,0,0,0));
    }
    
    private void Edit_textLogo(){
        textLogo.setFont(new Font("sansserif", 1, 25));
        
        textLogo.setForeground(new Color(224,224,224));
    }
}
