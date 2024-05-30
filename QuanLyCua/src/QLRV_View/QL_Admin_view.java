
package QLRV_View;

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
                        menuButton mainThe = new menuButton();
                        menuButton mainMB = new menuButton();
                        menuButton mainLichSu = new menuButton();
                        
                        Button btnBar = new Button();
                        Panel_QLThe_view mainQLMT = new Panel_QLThe_view();
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
                        menu.add(mainThe);
                        menu.add(mainMB);
                        menu.add(mainLichSu);
                       
                        


                        
                       
                       
                        main.add(mainQLMT,"w 100%,h 100%");
                        
                        mainThe.setMenuItem("/Image/computer.png","Quản lý thẻ");
                        mainMB.setMenuItem("/Image/user.png", "Quản lý thành viên");
                        mainLichSu.setMenuItem("/Image/revenue (1).png", "Lịch sử vào/ra ");
                       
                      
                        mainThe.setForcusButton(true);
                        
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
                                  mainThe.showText(true);
                                  mainMB.showText(true);
                                  mainLichSu.showText(true);
                                 
                                  width = 60 + (170 * fraction);
                              }
                              
                              layout.setComponentConstraints(menu,"w "+width+"!,spany2");
                              menu.revalidate();
                              double widthKey = width-20;
                              layoutMenu.setComponentConstraints(mainThe,"w "+widthKey+"!");
                              layoutMenu.setComponentConstraints(mainMB,"w "+widthKey+"!");
                              layoutMenu.setComponentConstraints(mainLichSu,"w "+widthKey+"!");
                              
                              mainMB.revalidate();
                               
                            }

                            @Override
                            public void end() {
                                if(ShowMenu){
                                  mainThe.showText(false);
                                  mainMB.showText(false);
                                  mainLichSu.showText(false);
                                 
                                  
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
                            mainThe.addActionListener(new ActionListener() {
                                
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                mainMB.setForcusButton(false);
                                mainLichSu.setForcusButton(false);
                               
                            }
                        });
                        mainMB.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                mainThe.setForcusButton(false);
                                mainLichSu.setForcusButton(false);
                              
                            }
                        });
                        mainLichSu.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                mainThe.setForcusButton(false);
                                mainMB.setForcusButton(false);
                               
                            }
                        });
                        
                        }
                        
// viết sự kiện nút ở đây                        
                        void AcitonButtonMenu(){
                            mainThe.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    Panel_QLThe_view QLMT = new Panel_QLThe_view();
                                    main.removeAll();
                                    main.add(QLMT);
                                    main.repaint();
                                    main.revalidate();
                                }
                            });
                            
                            mainMB.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    Panel_QLMB_view QLKH = new Panel_QLMB_view();
                                    main.removeAll();
                                    main.add(QLKH);
                                    main.repaint();
                                    main.revalidate();
                                }
                            });
                            
                            mainLichSu.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    Panel_QLLS_view ls = new Panel_QLLS_view();
                                    main.removeAll();
                                    main.add(ls);
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
