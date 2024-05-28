package javacode.custom;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;


public class Message extends JFrame{
     private boolean ok;
    private final Animator animator;
    private boolean show = true;

    public Message()  {
    setSize(450, 140);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addMouseListener(mouseListener);
        addMouseMotionListener(mouseListener);
        setBackground(new Color(0,0,0,0));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setContentPane(constentPanel);
        constentPanel.setLayout(null);
        constentPanel.setBackground(Color.WHITE);
        constentPanel.setRadius(10);
        
        
        BorderRound Border = new  BorderRound(0);
        Border.setColor(new Color(75, 134, 253));
        Border.setRound(10);
        constentPanel.setBorder(Border);
        
        lbIcon.setBounds(40, 25, 65, 65);
        lbIcon.setHorizontalAlignment(SwingConstants.CENTER);
        constentPanel.add(lbIcon);
        
        lbMessage.setBounds(120, 20, 250, 65);
        lbMessage.setFont(new Font("sansserif",0,16));
        lbMessage.setForeground(new Color(82,82,82));
        lbMessage.setText("Message");
        constentPanel.add(lbMessage);
        
        
        
        setOpacity(0f);
         TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (show) {
                    setOpacity(fraction);
                } else {
                    setOpacity(1f - fraction);
                }
            }

            @Override
            public void end() {
                if (show == false) {
                   dispose();
                }
            }

        };
        animator = new Animator(200, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
    }
    
    
    
    private Button btnExit = new Button();
    private Panel  constentPanel = new Panel();
    private JLabel lbIcon = new JLabel(new ImageIcon(getClass().getResource("/Image/alarm (1).png")));
    private JLabel lbMessage = new JLabel();
    
    private void btnExitEvent(){
        btnExit.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
             closeMenu();
             }
         });
        
    }
        public void showMessage(String message) {
        btnExit.setBounds(300, 90, 60, 25);
        btnExit.setRadius(25);
        btnExit.setFont(new Font ("Tahoma",0,17));
        btnExit.setText("Đóng");
        btnExitEvent();
        constentPanel.add(btnExit);
        lbMessage.setText(message);
        animator.start();
        setVisible(true);
    }
   
    private void closeMenu() {
        if (animator.isRunning()) {
            animator.stop();
        }
        show = false;
        animator.start();
        
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
     
      public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                                    Message JF = new Message();
                                    JF.showMessage("1123");
                                        
                                 
                                    
                                     
                                } catch (Exception e) {
					e.printStackTrace();
				}
                        }
               });       
    } 

 
    
}
