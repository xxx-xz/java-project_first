package server_gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LHS_Admin_Join extends JFrame{
//	LHS_Admin_UIEvent eventobj = new LHS_Admin_UIEvent();
	LHS_Admin_Login main;
	static JLayeredPane f = new JLayeredPane();
    BufferedImage img = null;
    JTextField loginTextField, hp1, hp2, hp3, mail1, mail2;
    JPasswordField passwordField, passwordField2;
    JButton join_bt;
    JButton bt2;
    JLabel Pass_Label, Pass2_Label, login_Label, phone_label, phone2_label, phone3_label, e_mail_label, e_mail2_label;
    String[] namelist = {"아이디", "비밀번호", "비밀번호확인", "핸드폰","핸드폰2","핸드폰3","Email", "Email2"};
    ArrayList<Object> list = new ArrayList<Object>();
	
	
	
	public LHS_Admin_Join() {
		init();
	}
	public LHS_Admin_Join(LHS_Admin_Login main) {
		this.main = main;
		init();
	}
	
	public void init() {
		
        setTitle("로그인 테스트");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 
        // 레이아웃 설정
        setLayout(null);
        f.setBounds(0, 0, 700, 700);
        f.setLayout(null);
 
        // 패널1
        // 이미지 받아오기
        try {
            img = ImageIO.read(new File("keyosk_images/join.png"));
        } catch (IOException e) {
            System.out.println("이미지 불러오기 실패");
            System.exit(0);
        }
         
        MyPanel panel = new MyPanel();
        panel.setBounds(0, 0, 1600, 900);
         
        // 로그인 라벨 
        login_Label = new JLabel("아이디");
        login_Label.setBounds(175, 225, 100, 30);
        login_Label.setForeground(Color.orange);
        login_Label.setFont(new Font("Serif", Font.BOLD, 15));
        
     // 패스워드  라벨 
        Pass_Label = new JLabel("비밀번호");
        Pass_Label.setBounds(165, 275, 100, 30);
        Pass_Label.setForeground(Color.orange);
        Pass_Label.setFont(new Font("Serif", Font.BOLD, 15));
     // 패스워드 확인 라벨
        Pass2_Label = new JLabel("비밀번호 확인");
        Pass2_Label.setBounds(135, 325, 360, 30);
        Pass2_Label.setForeground(Color.orange);
        Pass2_Label.setFont(new Font("Serif", Font.BOLD, 15));
     // - 라벨 
        phone_label = new JLabel("-");  phone_label.setForeground(Color.orange); phone_label.setFont(new Font("Serif", Font.BOLD, 25));
        phone2_label = new JLabel("-"); phone2_label.setForeground(Color.orange); phone2_label.setFont(new Font("Serif", Font.BOLD, 25));
        phone_label.setBounds(384, 370, 360, 30); phone2_label.setBounds(500, 370, 360, 30);
        f.add(phone_label); f.add(phone2_label);
        
     // 핸드폰 라벨 
        phone3_label = new JLabel("핸드폰");  phone3_label.setForeground(Color.orange); phone3_label.setFont(new Font("Serif", Font.BOLD, 15));
        phone3_label.setBounds(175, 375, 360, 30);
        f.add(phone3_label);
     // 이메일 라벨 
        e_mail_label = new JLabel("이메일"); e_mail_label.setForeground(Color.orange); e_mail_label.setFont(new Font("Serif", Font.BOLD, 15));
        e_mail_label.setBounds(175, 423, 100, 30);
        f.add(e_mail_label);
        e_mail2_label = new JLabel("@"); e_mail2_label.setForeground(Color.orange); e_mail2_label.setFont(new Font("Serif", Font.BOLD, 23));
        e_mail2_label.setBounds(382, 423, 100, 30);
        f.add(e_mail2_label);
        
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 로그인 필드
        loginTextField = new JTextField(15);
        loginTextField.setBounds(280, 225, 100, 30);
        f.add(loginTextField);
        loginTextField.setBackground(Color.orange);
        loginTextField.setOpaque(true);
        loginTextField.setForeground(Color.red);
        loginTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        loginTextField.setPreferredSize(new Dimension(5, 5));
        list.add(loginTextField);
        // 패스워드 필드 
        passwordField = new JPasswordField(10);
        passwordField.setBounds(279, 275, 100, 30);
        passwordField.setOpaque(true);
        passwordField.setBackground(Color.orange);
        passwordField.setForeground(Color.red);
        passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        f.add(passwordField);
        list.add(passwordField);
        
        
         
        // 패스워드 필드 
        passwordField2 = new JPasswordField(10);
        passwordField2.setBounds(279, 325, 100, 30);
        passwordField2.setOpaque(true);
        passwordField2.setBackground(Color.orange);
        passwordField2.setForeground(Color.red);
        passwordField2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        f.add(passwordField2);
        list.add(passwordField2);
 
        // 핸드폰 필드 
         hp1 = new JTextField(5);
         hp2 = new JTextField(5);
         hp3 = new JTextField(5);
        hp1.setBounds(279, 375, 100,30); hp1.setBackground(Color.orange); hp1.setForeground(Color.red);
        hp2.setBounds(395, 375, 100,30); hp2.setBackground(Color.orange); hp2.setForeground(Color.red);
        hp3.setBounds(512, 375, 100,30); hp3.setBackground(Color.orange); hp3.setForeground(Color.red); 
        hp1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        hp2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        hp3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        f.add(hp1); list.add(hp1); list.add(hp2); list.add(hp3);
        f.add(hp2); 
        f.add(hp3);       
        
        // E-mail 필드 
        mail1 = new JTextField(10); mail1.setBackground(Color.orange); mail1.setForeground(Color.red);
        mail2 = new JTextField(10); mail2.setBackground(Color.orange); mail2.setForeground(Color.red);
        mail1.setBorder(javax.swing.BorderFactory.createEmptyBorder()); mail2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        mail1.setBounds(279, 423, 100,30); mail2.setBounds(410, 423, 100,30);
        f.add(mail1); f.add(mail2); list.add(mail1); list.add(mail2);
        
        // 로그인버튼 추가
        
        join_bt = new JButton("회원가입");
     //  join_bt.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        
        join_bt.setBounds(310, 532, 100, 20);
        join_bt.setFont(new Font("Serif", Font.BOLD, 15));
        
        // 버튼 투명처리
//        join_bt.setBorderPainted(true);
//        join_bt.setFocusPainted(true);
//        join_bt.setContentAreaFilled(true);
        f.add(join_bt);
        f.add(login_Label);
        f.add(Pass_Label); f.add(Pass2_Label);
 
        // 마지막 추가들
        f.add(panel);
        add(f);
        setVisible(true);
        
        join_bt.addActionListener(new LHS_Admin_UIEvent(this));
        setLocationRelativeTo(null);
        
       // join_bt.addActionListener(new joinUIEvent(this));
    }
 
    class MyPanel extends JPanel {
        public void paint(Graphics g) {
            g.drawImage(img, 0, 0, null);
        }
    }

////	@Override
//public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		Object obj = e.getSource();
//		if(obj == join_bt) {
//			//join_proc();
//		}
//		
//	}
//		public void join_proc() { 
//		if(loginTextField.getText().equals("")) {
//				JOptionPane.showMessageDialog(null, 
//	 					Commons.getMsg("아이디를 입력해주세요"));
//				loginTextField.requestFocus();
//		}else if(passwordField.getText().equals(passwordField2)){
//			JOptionPane.showMessageDialog(null, 
// 					Commons.getMsg("패스워드가 같지 않습니다"));
//		}else if(passwordField.getText().equals("")) {
//				JOptionPane.showMessageDialog(null, 
//	 					Commons.getMsg("패스워드를 입력해주세요"));
//				passwordField.requestFocus();
//		}else if(passwordField2.getText().equals("")) {
//				JOptionPane.showMessageDialog(null, 
// 					Commons.getMsg("패스워드를 입력해주세요"));
//				passwordField2.requestFocus();
//				
//		}else if(hp1.getText().equals("")) {
//				JOptionPane.showMessageDialog(null, 
//					Commons.getMsg("핸드폰 번호를 입력해주세요"));
//				hp1.requestFocus();
//		}else if(hp2.getText().equals("")) {
//				JOptionPane.showMessageDialog(null, 
//					Commons.getMsg("핸드폰 번호를 입력해주세요"));
//					hp2.requestFocus();
//		}else if(hp3.getText().equals("")) {
//				JOptionPane.showMessageDialog(null, 
//					Commons.getMsg("핸드폰 번호를 입력해주세요"));
//				hp3.requestFocus();
//		}else if(mail1.getText().equals("")) {
//		JOptionPane.showMessageDialog(null, 
//					Commons.getMsg("이메일을 입력해주세요"));
//		mail1.requestFocus();
//		}else if(mail2.getText().equals("")) {
//		JOptionPane.showMessageDialog(null, 
//					Commons.getMsg("이메일을 입력해주세요"));
//		mail2.requestFocus();
//		}
//			
//		}
		
		
	}
