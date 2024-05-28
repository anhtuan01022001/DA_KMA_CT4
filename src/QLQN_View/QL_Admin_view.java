
package QLQN_View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javacode.compoment.LogoPanel;

import javacode.compoment.header;

import javacode.compoment.menuButton;
import javacode.custom.Button;
import javacode.custom.ButtonGradient;
import javacode.custom.PanelGradient;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;



public class QL_Admin_view extends JFrame{

    MigLayout layout=new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
                    MigLayout layoutMenu = new MigLayout("fillx, wrap","10[fill]10","[fill]10[fill,64!]10");
                        header header = new header();
                        PanelGradient menu =new PanelGradient();
                        JPanel main =new JPanel();
                        Animator animator ;
                       
                        JPanel p =new JPanel();
                        menuButton mainMayTram = new menuButton();
                        menuButton mainNguoiChoi = new menuButton();
                        menuButton mainThongKe = new menuButton();
                        
                        Button btnBar = new Button();
                        Panel_QLMT_view mainQLMT = new Panel_QLMT_view();
                        LogoPanel logo = new LogoPanel();
                        public boolean ShowMenu = true;
                        
    
    public QL_Admin_view(){
        
                        this.setUndecorated(true);
                        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
                        this.setBounds(0, 0, 1360, 740);
                        this.setBackground(new Color(240,240,240));
                        this.setLocationRelativeTo(null);
                        this.setVisible(true);
                        this.setContentPane(p);
                      
                        p.setLayout(layout);
                        menu.setLayout(layoutMenu); 
                       
                        main.setLayout(new MigLayout("fill","0[fill]0","0[fill]10"));
                         
                        p.add(menu, "w 230!, spany 2");    // Span Y 2cell
                        p.add(header, "h 55!, wrap");
                        p.add(main, "w 100%, h 100%");
                        
                        menu.setColor1(new Color(33, 105, 249));
                        menu.setColor2(new Color(93, 58, 196));
                    
                        
                        logo.setBackground(new Color(0,0,0,0));
                        
                       menu.add(logo);
                        menu.add(mainMayTram);
                        menu.add(mainNguoiChoi);
                        menu.add(mainThongKe);
                       
                        


                        
                       
                       
                        main.add(mainQLMT,"w 100%,h 100%");
                        
                        mainMayTram.setMenuItem("/Image/computer.png","Quản lý máy trạm");
                        mainNguoiChoi.setMenuItem("/Image/user.png", "Quản lý người chơi");
                        mainThongKe.setMenuItem("/Image/revenue (1).png", "Thống kê ");
                       
                      
                        mainMayTram.setForcusButton(true);
                        
                        ActionMenu();
                        ActionHeader();
                        ForcusButton();
                        AcitonButtonMenu();
    
    }
    
    void ActionMenu(){
                            TimingTarget taget =new TimingTargetAdapter(){
                            @Override
                            public void timingEvent(float fraction) {
                              double width;
                              if(ShowMenu){
                                  width = 60 + (170*(1f-fraction));
                                  
                              }
                              else{
                                  mainMayTram.showText(true);
                                  mainNguoiChoi.showText(true);
                                  mainThongKe.showText(true);
                                 
                                  width = 60 + (170 * fraction);
                              }
                              
                              layout.setComponentConstraints(menu,"w "+width+"!,spany2");
                              menu.revalidate();
                              double widthKey = width-20;
                              layoutMenu.setComponentConstraints(mainMayTram,"w "+widthKey+"!");
                              layoutMenu.setComponentConstraints(mainNguoiChoi,"w "+widthKey+"!");
                              layoutMenu.setComponentConstraints(mainThongKe,"w "+widthKey+"!");
                              
                              mainNguoiChoi.revalidate();
                               
                            }

                            @Override
                            public void end() {
                                if(ShowMenu){
                                  mainMayTram.showText(false);
                                  mainNguoiChoi.showText(false);
                                  mainThongKe.showText(false);
                                 
                                  
                              }
                                ShowMenu = !(ShowMenu);

                            }
                            
                        };
                        animator=new Animator(69,taget);
                        animator.setResolution(0);
                        animator.setDeceleration(0.5f);
                        animator.setAcceleration(0.5f);
                        }
                        
                        void ActionHeader(){
                            header.addMenuEvent(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                if(!animator.isRunning()){
                                    animator.start();
                                }
                                }
                            });
                            header.addExitEvent(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                dispose();
                                }
                               
                            });
                             
                        }
                        
                        void ForcusButton(){
                            mainMayTram.addActionListener(new ActionListener() {
                                
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                mainNguoiChoi.setForcusButton(false);
                                mainThongKe.setForcusButton(false);
                               
                            }
                        });
                        mainNguoiChoi.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                mainMayTram.setForcusButton(false);
                                mainThongKe.setForcusButton(false);
                              
                            }
                        });
                        mainThongKe.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                mainMayTram.setForcusButton(false);
                                mainNguoiChoi.setForcusButton(false);
                               
                            }
                        });
                        
                        }
                        
// viết sự kiện nút ở đây                        
                        void AcitonButtonMenu(){
                            mainMayTram.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    Panel_QLMT_view QLMT = new Panel_QLMT_view();
                                    main.removeAll();
                                    main.add(QLMT);
                                    main.repaint();
                                    main.revalidate();
                                }
                            });
                            
                            mainNguoiChoi.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    Panel_QLKH_view QLKH = new Panel_QLKH_view();
                                    main.removeAll();
                                    main.add(QLKH);
                                    main.repaint();
                                    main.revalidate();
                                }
                            });
                            
                            mainThongKe.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    ThongKe_view tk = new ThongKe_view();
                                    main.removeAll();
                                    main.add(tk);
                                    main.repaint();
                                    main.revalidate();

                                }
                            });
                        }
                        
                        
                         
                         
                    
	
   
    	public static void main(String[] args) {
            QL_Admin_view jF = new QL_Admin_view();
            jF.setVisible(true);
        }
                        
}
