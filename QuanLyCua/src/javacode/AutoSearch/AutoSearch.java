
package javacode.AutoSearch;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;


public class AutoSearch extends JPanel {
    private JTextField txtSearch;
     private JPopupMenu menu = new JPopupMenu();
     

    public AutoSearch() {
        
        setLayout(new MigLayout("fillx", "0[fill]0", "0[]0"));
        this.setBackground(Color.WHITE);
        menu.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 255)));
    }

    private String removeAccent(String s) {
  
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("").replace('đ','d').replace('Đ','D');
   }
    
    private List<String> fixItem(List<String> data,String key){
        int limitData = 0;
        List<String> Item = new ArrayList<String>();
       key = "(?i)"+key+".+";
        
        for(String d:data){
         String temp = removeAccent(d);
            System.out.println(temp);
            if(limitData<=6){
            if(temp.matches(key)){
                Item.add(d);
                limitData++;
                 
            }
            }
        }
        
        return Item;
    }
    
    public void showList(){
        
    }
            
    
    public void setData(List<String> data,JTextField JTextField) {
        this.txtSearch = JTextField;
         menu.add(this);
         
        menu.setFocusable(false);
         txtSearch.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                String key = txtSearch.getText();
                removeAll();
              if(!key.equals("")){
                
                List<String> list = fixItem(data, key);
                if(list.size()>0){
                    
                for (String d : list) {
                    Search_Item item = new Search_Item(d);
                    item.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                           txtSearch.setText(d);
                           menu.setVisible(false);
                        }
                    });
                    add(item, "wrap,center,h 25!,w 100%");
                }
                menu.show(JTextField, 0, JTextField.getHeight()+3);
                menu.setPopupSize(JTextField.getWidth(), (getComponentCount() * 25) + 2);
                repaint();
                revalidate();
                }
                else{
                  menu.setVisible(false);
                }
              }
              else{
                 menu.setVisible(false);
               
              }
            }
           
           
        });
         
        
       
    }
    
    
    
        public int getItemSize() {
        return getComponentCount();
    }
        
    


}
