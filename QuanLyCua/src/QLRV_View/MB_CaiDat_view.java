package QLRV_View;

import QLRV_Controller.MB_controller;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javacode.custom.BorderRound;
import javacode.custom.Button;
import javacode.custom.Message;
import javacode.custom.Panel;
import javacode.custom.TextField;
import javacode.custom.outlineButton;
import javacode.custom.passwordField;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import net.miginfocom.swing.MigLayout;


public class MB_CaiDat_view extends JPanel{
    MigLayout layout = new MigLayout("fill","1[]1","0[]0[]");
    Panel contenPanel = new Panel();
    JLabel lblHeader = new JLabel("Thông tin đăng nhập");
    
    JPanel pUser = new JPanel();
    JLabel iconUser = new JLabel(new ImageIcon(getClass().getResource("/Image/user (1).png")));
    JLabel titleUser = new JLabel("Đổi tên tài khoản");
    JLabel noteUser = new JLabel("Bạn nên đổi tài khoản định kì");
    outlineButton btnUser = new outlineButton ();
    
    JPanel pPass = new JPanel();
    JLabel iconPass = new JLabel(new ImageIcon(getClass().getResource("/Image/key.png")));
    JLabel titlePass = new JLabel("Đổi mật khẩu");
    JLabel notePass = new JLabel("Bạn nên sử dụng mật khẩu mạnh");
    outlineButton btnPass = new outlineButton ();
    
    JPanel pEditUser = new JPanel();
    JLabel lblUsedFirst = new JLabel("Tài khoản hiện tại");
    JLabel lblUsedSec = new JLabel("Tài khoản mới");
    TextField txtUsedFirst = new TextField();
    TextField txtUsedSec = new TextField();
    outlineButton btnSaveUser = new outlineButton ();
    outlineButton btnExitUser = new outlineButton ();
    
    JPanel pEditPass = new JPanel();
    JLabel lblPassFirst = new JLabel("Mật khẩu hiện tại");
    JLabel lblPassSec = new JLabel("Mật khẩu mới");
    JLabel lblPassCon = new JLabel("Nhập lại mật khẩu mới");
    passwordField txtPassFirst = new passwordField();
    passwordField txtPassSec = new passwordField();
    passwordField txtPassCon = new passwordField();
    outlineButton btnSavePass = new outlineButton ();
    outlineButton btnExitPass = new outlineButton ();
    MB_controller c = new MB_controller();
    
    
    MatteBorder topBorder = new MatteBorder(1, 0, 0, 0,new Color(206, 212, 218) );
    public MB_CaiDat_view(int id) {
        setLayout(new MigLayout("fill", "",""));
        setBackground(Color.white);
        add(contenPanel,"w 70%,center,top,gaptop 36!");
        
        BorderRound boder = new BorderRound(0);
        boder.setRound(15);
        contenPanel.setBorder(boder);
        contenPanel.setBackground(new Color(245,245,245));
        contenPanel.setRadius(15);
        contenPanel.setLayout(layout);
        contenPanel.add(lblHeader,"h 45!,gapleft 12!");
        contenPanel.add(pUser,"h 65!,w 100%,newline");
        contenPanel.add(pPass,"h 65!,w 100%,newline");
        
        pUser.setBackground(Color.white);
        pUser.setBorder(topBorder);
        pUser.setLayout(new MigLayout("fill", "[]", "[]"));
        pUser.add(iconUser,"cell 0 0 1 3,center,gapleft 16!,gapright 8!");
        pUser.add(titleUser,"cell 1 0,w 100%,bottom");
        pUser.add(noteUser,"cell 1 2,top");
        pUser.add(btnUser,"cell 2 0 1 3,w 70!,h 25!  ,center,right,gapright 6!");
        
        noteUser.setForeground(new Color(150,150,150));
        
        btnUser.setRadius(5);
        btnUser.setText("Chỉnh sửa");
        btnUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnUser.setForeground(new Color(110,110,110));
        btnUser.setBoderColor(new Color(110,110,110));
       
        
        txtUsedFirst.setText(c.TenMbName(id));
        
        
        JLabel lineTopU = new JLabel();
        lineTopU.setBorder(topBorder);
        JLabel lineDownU = new JLabel();
        lineDownU.setBorder(topBorder);
          
        pEditUser.setLayout(new MigLayout("fill", "", "[2!][]"));
        pEditUser.add(lineTopU,"w 85%,h 2!,span,grow,center,top");
        pEditUser.add(lblUsedFirst,"gapleft 36!,newline");
        pEditUser.add(txtUsedFirst,"w 180!,wrap");
        pEditUser.add(lblUsedSec,"gapleft 36!,newline");
        pEditUser.add(txtUsedSec,"w 180!,wrap");
        pEditUser.add(lineDownU,"newline,w 40%,h 2!,span,grow,top,gapleft 36!");
        pEditUser.add(btnSaveUser,"newline,h 25!,w 85!,gapleft 36!");
        pEditUser.setBackground(Color.white);
        
        txtUsedFirst.setEditable(false);
        
        btnSaveUser.setText("Lưu thay đổi");
        btnSaveUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSaveUser.setRadius(5);
        
        btnExitUser.setBoderColor(new Color(110,110,110));
        btnExitUser.setForeground(new Color(110,110,110));
        btnExitUser.setRadius(5);
        btnExitUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnExitUser.setText("Đóng");
        
        
        JLabel lineTopP = new JLabel();
        lineTopP.setBorder(topBorder);
        JLabel lineDownP = new JLabel();
        lineDownP.setBorder(topBorder);
        
        pPass.setBackground(Color.white);
        pPass.setBorder(topBorder);
        pPass.setLayout(new MigLayout("fill", "[]", "[]"));
        pPass.add(iconPass,"cell 0 0 1 3,center,gapleft 16!,gapright 8!");
        pPass.add(titlePass,"cell 1 0,w 100%,bottom");
        pPass.add(notePass,"cell 1 2,top");
        pPass.add(btnPass,"cell 2 0 1 3,w 70!,h 25!  ,center,right,gapright 6!");
        
        notePass.setForeground(new Color(150,150,150));
        
        btnPass.setRadius(5);
        btnPass.setText("Chỉnh sửa");
         btnPass.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnPass.setForeground(new Color(110,110,110));
        btnPass.setBoderColor(new Color(110,110,110));
        
        pEditPass.setLayout(new MigLayout("fill", "", "[2!][]"));
        pEditPass.add(lineTopP,"w 85%,h 2!,span,grow,center,top");
        pEditPass.add(lblPassFirst,"gapleft 36!,newline");
        pEditPass.add(txtPassFirst,"w 180!,wrap");
        pEditPass.add(lblPassSec,"gapleft 36!,newline");
        pEditPass.add(txtPassSec,"w 180!,wrap");
        pEditPass.add(lblPassCon,"gapleft 36!,newline");
        pEditPass.add(txtPassCon,"w 180!,wrap");
        pEditPass.add(lineDownP,"newline,w 40%,h 2!,span,grow,top,gapleft 36!");
        pEditPass.add(btnSavePass,"newline,h 25!,w 85!,gapleft 36!");
        pEditPass.setBackground(Color.white);
        
        
        
        btnSavePass.setText("Lưu thay đổi");
         btnSavePass.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSavePass.setRadius(5);
        
        btnExitPass.setBoderColor(new Color(110,110,110));
        btnExitPass.setForeground(new Color(110,110,110));
         btnExitPass.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnExitPass.setRadius(5);
        btnExitPass.setText("Đóng");
        
        actionButtonEdit();
        actionExit();
        EvenEdit();
    }
    
    private void actionButtonEdit(){
        btnUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contenPanel.remove(pEditPass);
                pPass.remove(btnExitPass);
                
                contenPanel.remove(pPass);
                contenPanel.add(pEditUser,"w 100%,newline");
                contenPanel.add(pPass,"w 100%,h 65!,newline");
                pPass.add(btnPass,"cell 2 0 1 3,w 70!,h 25!  ,center,right,gapright 6!");
                
                pUser.remove(btnUser);
                pUser.add(btnExitUser,"cell 2 0 1 3,w 50!,h 25!  ,center,right,gapright 6!");
                
               
                contenPanel.repaint();
                contenPanel.revalidate();
                
               
            }
        });
        btnPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pUser.remove(btnExitUser);
                pUser.add(btnUser,"cell 2 0 1 3,w 70!,h 25!  ,center,right,gapright 6!");
                
                contenPanel.remove(pEditUser);
                contenPanel.add(pEditPass,"w 100%,h 220!,newline");
                pPass.remove(btnPass);
                pPass.add(btnExitPass,"cell 2 0 1 3,w 50!,h 25!  ,center,right,gapright 6!");
                
               
                contenPanel.repaint();
                contenPanel.revalidate();
               
               
            }
        });
        
    }
    private void actionExit(){
        btnExitUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contenPanel.remove(pEditUser);
                pUser.remove(btnExitUser);
                pUser.add(btnUser,"cell 2 0 1 3,w 70!,h 25!  ,center,right,gapright 6!");
                
                
                contenPanel.repaint();
                contenPanel.revalidate();
            }
        });
        btnExitPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contenPanel.remove(pEditPass);
                pPass.remove(btnExitPass);
                pPass.add(btnPass,"cell 2 0 1 3,w 70!,h 25!  ,center,right,gapright 6!");
                
                
                contenPanel.repaint();
                contenPanel.revalidate();
            }
        });
        
    }
    
    private void EvenEdit(){
        MB_controller con = new MB_controller();
       
        btnSaveUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                 String userName = txtUsedSec.getText();
                
                if(userName.equals("")){
                     Message msg = new Message();
                    msg.setLocation(900, 200);
                    msg.showMessage("Chưa nhập tên tài khoản mới");
                }
                else{
                    if(userName.equals(txtUsedFirst.getText())){
                         Message msg = new Message();
                    msg.setLocation(900, 200);
                        msg.showMessage("Tài khoản mới giống tài khoản cũ");
                    }
                    else{
                        int k = con.SuaTaiKhoan(txtUsedFirst.getText(), userName);
                        if(k==2){
                             Message msg = new Message();
                    msg.setLocation(900, 200);
                            msg.showMessage("Tên tài khoản đã tồn tại !");
                           

                        }
                        else if (k==1){
                           
                             contenPanel.remove(pEditUser);
                               pUser.remove(btnExitUser);
                            pUser.add(btnUser,"cell 2 0 1 3,w 70!,h 25!  ,center,right,gapright 6!");
                            contenPanel.repaint();
                            contenPanel.revalidate();    
                        Message msg = new Message();
                    msg.setLocation(900, 200);
                            msg.showMessage("Đổi tên tài khoản thành công!");
//                            Panel_QLMT_view.loadData();
                            Panel_QLMB_view.loadData();
                            txtUsedFirst.setText(userName);
                        }
                        else if(k==3){
                             Message msg = new Message();
                    msg.setLocation(900, 200);
                            msg.showMessage("Lỗi !");
                            


                        }

                    }
                }
  
            }
            
        });
        btnSavePass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                 String passCu = txtPassFirst.getText();
                String passMoi = txtPassSec.getText();
                String passCon = txtPassCon.getText();
                
                if(passCu.equals("")||passMoi.equals("")||passCon.equals("")){
                    Message msg = new Message();
                    msg.setLocation(900, 200);
                    msg.showMessage("Bạn cần nhập đủ thông tin");
                }
                else{
                    int k = con.KTMatKhau(txtUsedFirst.getText(), passCu);
                    if(k==1){
                        if(passMoi.equals(passCon)){
                            int k1= con.DoiMatKhau(txtUsedFirst.getText(), passMoi);
                            if(k1==1){
                                Message msg = new Message();
                                msg.setLocation(900, 200);
                                msg.showMessage("Đổi mật khẩu thành công");
                                contenPanel.remove(pEditPass);
                                pPass.remove(btnExitPass);
                                pPass.add(btnPass,"cell 2 0 1 3,w 70!,h 25!  ,center,right,gapright 6!");
                                contenPanel.repaint();
                                contenPanel.revalidate();
                            }
                            else if(k==2){
                                  Message msg = new Message();
                    msg.setLocation(900, 200);
                                 msg.showMessage("Lỗi");
                            }
                        }
                        else{
                              Message msg = new Message();
                    msg.setLocation(900, 200);
                            msg.showMessage("Mật khẩu xác nhận không đúng");
                        }
                        
                        
                        
                    }
                    else if(k==2){
                          Message msg = new Message();
                    msg.setLocation(900, 200);
                        msg.showMessage("Mật khẩu cũ không đúng");
                    }
                    
                    
                    
                      
                        }

               
                
               
                
                
                
                
            }
        });
    }
    
}
