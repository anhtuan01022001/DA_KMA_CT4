
package QLRV_View;

import QLRV_Controller.MB_controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javacode.custom.BorderRound;
import javacode.custom.Button;
import javacode.custom.Panel;
import javacode.custom.PanelRound;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;


public   class QL_MB_view extends JFrame{
    private static Panel contenPanel =new Panel();
    private static PanelRound headerPanel = new PanelRound();
    private static PanelRound pThongTin = new PanelRound();
    private static PanelRound pLichSu = new PanelRound();
    private static PanelRound pCaiDat   = new PanelRound();
    private static Button btnExit= new Button();
    private static Panel conten = new Panel();
    
    public QL_MB_view(int id){
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
//        setSize(550, 650);
        
        
        
        setUndecorated(true);
        setBackground(new Color(0,0,0,0));
        setBounds(0, 0, 550, 650);
         Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width-this.getSize().width, 0);
        setContentPane(contenPanel);
        
        
        contenPanel.setBackground(Color.WHITE);
        contenPanel.setLayout(new MigLayout("fill", "0[]0", "0[]10"));
        contenPanel.setRadius(20);
        
        BorderRound boder = new BorderRound(0);
        boder.setRound(20);
        boder.setColor(new Color(179,218,255));
        boder.setN(3);
        contenPanel.setBorder(boder);
        
        contenPanel.add(headerPanel,"h 60!,w 100%,grow,span");
       contenPanel.add(conten,"h 100%,w 99%,center");
        
       conten.setLayout(new MigLayout("fill","0[fill]0","0[fill]0"));
       conten.removeAll();
        MB_ThongTin_view thongTin = new MB_ThongTin_view(id); 
//        ActionLogout(thongTin);
        conten.add(thongTin,"w 100%,h 100%");
        
       
        headerPanel.setBounds(0, 0, 550, 60);
        headerPanel.setLayout(null);
        headerPanel.setRound(20);
        headerPanel.setBackground(new Color(179,218,255));
        headerPanel.addMouseListener(mouseListener);
        headerPanel.addMouseMotionListener(mouseListener);
        
        headerPanel.add(pThongTin);
       headerPanel.add(pLichSu);
       headerPanel.add(pCaiDat);
       headerPanel.add(btnExit);
       
       pThongTin.setBounds(10, 20, 100, headerPanel.getHeight());
       pThongTin.setLayout(null);
       pThongTin.setBackground(Color.WHITE);
       pThongTin.setRound(pThongTin.getWidth());
       pThongTin.setCursor(new Cursor(Cursor.HAND_CURSOR));
       pThongTin.setLayout(null);
        JLabel lblThongTin = new JLabel("Thông tin");
        lblThongTin.setHorizontalAlignment(SwingConstants.CENTER);
        lblThongTin.setBounds(8, 8, 84, 30);
        pThongTin.add(lblThongTin);
       
       pLichSu.setBounds(10+100+1, 20, 100, headerPanel.getHeight());
       pLichSu.setBackground(new Color(128,193,255));
       pLichSu.setRound(pLichSu.getWidth());
       pLichSu.setCursor(new Cursor(Cursor.HAND_CURSOR));
       pLichSu.setLayout(null);
        JLabel lblLichSu = new JLabel("Lịch sử");
        lblLichSu.setHorizontalAlignment(SwingConstants.CENTER);
        lblLichSu.setBounds(8, 8, 84, 30);
        pLichSu.add(lblLichSu);
       
       pCaiDat.setBounds(210+1+1, 20, 100, headerPanel.getHeight());
       pCaiDat.setBackground(new Color(128,193,255));
       pCaiDat.setRound(pCaiDat.getWidth());
       pCaiDat.setCursor(new Cursor(Cursor.HAND_CURSOR));
       pCaiDat.setLayout(null);
        JLabel lblCaiDat = new JLabel("Cài đặt");
        lblCaiDat.setHorizontalAlignment(SwingConstants.CENTER);
        lblCaiDat.setBounds(8, 8, 84, 30);
        pCaiDat.add(lblCaiDat);
       
       
       
       btnExit.setBounds(550-50-16, 6, 50, 50);
       btnExit.setIcon(new ImageIcon(getClass().getResource("/Image/exit.png")));
       btnExit.setBackground(headerPanel.getBackground());
//       btnExit.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                MB_controller c = new MB_controller();
//                c.DoiMay1(0,null,-1);
//                dispose();
////                Panel_QLThe_view.loadData();
//                Panel_QLThe_view.clearRightConstent();
//            }
//        });
       
       ActionMouse();
        Aciton(id);
        
    }
    
//    public  void ActionLogout(MB_ThongTin_view thongTin){
//       thongTin.setEvenLogout(new ActionListener() {
//           @Override
//           public void actionPerformed(ActionEvent e) {
//               MB_controller c = new MB_controller();
//                c.DoiMay1(0,null,-1);
//                dispose();
////                Panel_QLThe_view.loadData();
//                Panel_QLThe_view.clearRightConstent();
//           }
//       });
//    }
    
    private void Aciton(int id){
        pThongTin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MB_ThongTin_view thongTin = new MB_ThongTin_view(id); 
//                ActionLogout(thongTin);
                conten.removeAll();
                conten.add(thongTin);
                conten.repaint();
                conten.revalidate();
                
            }
            
        });
        pLichSu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                NC_LichSuNapTien_view lichSu = new NC_LichSuNapTien_view(id);
                conten.removeAll();
//                conten.add(lichSu);
                conten.repaint();
                conten.revalidate();
            }
            
        });
        pCaiDat.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                
                MB_CaiDat_view CaiDat = new MB_CaiDat_view(id);
                conten.removeAll();
                conten.add(CaiDat);
                conten.repaint();
                conten.revalidate();
            }
            
        });
    }
    
    private void ActionMouse(){
        pThongTin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               pThongTin.setBackground(Color.white);
               pLichSu.setBackground(new Color(128,193,255));
               pCaiDat.setBackground(new Color(128,193,255));
            }
        });
        
        pLichSu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               pLichSu.setBackground(Color.white);
               pThongTin.setBackground(new Color(128,193,255));
               pCaiDat.setBackground(new Color(128,193,255));
            }
        });
        pCaiDat.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               pCaiDat.setBackground(Color.white);
               pLichSu.setBackground(new Color(128,193,255));
               pThongTin.setBackground(new Color(128,193,255));
            }
        });
    }
    
    private final MouseAdapter mouseListener = new MouseAdapter() {

        int x, y;

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                x = e.getX();
                y = e.getY();
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if ((e.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) != 0) {
                setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
            }
        }
    };
    

}
