package project_gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import project_system.Commons;
import project_system.LHS_Admin_System;

public class LHS_Admin_Login extends JFrame implements ActionListener {
	static LHS_Admin_System system = new LHS_Admin_System();
	
	
    BufferedImage img = null;
    JTextField loginTextField;
    JPasswordField passwordField;
    JButton join_bt, passch_bt, login_bt;
    JLabel login_Label;
    JLabel Pass_Label;
    JLayeredPane layeredPane = new JLayeredPane();
	
	
	public LHS_Admin_Login() {
		init();
	}
	
	public void init() {
		
        setTitle("로그인 테스트");
        setSize(450, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 
        // 레이아웃 설정
        setLayout(null);
        layeredPane.setBounds(0, 0, 450, 900);
        layeredPane.setLayout(null);
 
        
		

        // 패널1
        // 이미지 받아오기
        try {
            img = ImageIO.read(new File("keyosk_images/login.png"));
        } catch (IOException e) {
            System.out.println("이미지 불러오기 실패");
            System.exit(0);
        }
         
        MyPanel panel = new MyPanel();
        panel.setBounds(0, 0, 1600, 900);
         
        // 로그인 라벨 
        login_Label = new JLabel("ID");
        login_Label.setBounds(60, 300, 200, 30);
        login_Label.setForeground(Color.orange);
        login_Label.setFont(new Font("Serif", Font.BOLD, 20));
        
     // 패스워드  라벨 
        Pass_Label = new JLabel("Pass");
        Pass_Label.setBounds(60, 380, 280, 30);
        Pass_Label.setForeground(Color.orange);
        Pass_Label.setFont(new Font("Serif", Font.BOLD, 20));
        
        // 로그인 필드
        loginTextField = new JTextField(10);
        loginTextField.setBounds(140, 300, 280, 30);
        loginTextField.setBackground(Color.orange);
        loginTextField.setOpaque(true);
        loginTextField.setForeground(Color.red);
        loginTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        loginTextField.setPreferredSize(new Dimension(5, 5));
        layeredPane.add(loginTextField);
        // 패스워드
        passwordField = new JPasswordField(10);
        passwordField.setBounds(140, 380, 280, 30);
        passwordField.setOpaque(true);
        passwordField.setBackground(Color.orange);
        passwordField.setForeground(Color.red);
        passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        layeredPane.add(passwordField);
 
        // 버튼 추가
        join_bt = new JButton("회원가입");
        join_bt.setBounds(115, 500, 100, 20);
        
        login_bt = new JButton("로그인");
        login_bt.setBounds(245, 500, 100, 20);
        
        passch_bt = new JButton("비밀번호 찾기");
        passch_bt.setBounds(180, 550, 100, 20);
 
        // 버튼 투명처리
        join_bt.setBorderPainted(true);
        join_bt.setFocusPainted(true);
        join_bt.setContentAreaFilled(true);
 
        layeredPane.add(join_bt);
        layeredPane.add(login_bt);
        layeredPane.add(passch_bt);
        layeredPane.add(login_Label);
        layeredPane.add(Pass_Label);
 
        // 마지막 추가들
        layeredPane.add(panel);
        add(layeredPane);
        setVisible(true);
        
        join_bt.addActionListener(this);
        login_bt.addActionListener(this);
                                
       join_bt.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		dispose();
        		new LHS_Admin_Join();
        	}
        	
        });
        
    }
    
    public void windowClosing(WindowEvent e) {
	dispose();
	}
    
    
         class MyPanel extends JPanel {
        public void paint(Graphics g) {
            g.drawImage(img, 0, 0, null);
        }
         }
    
         @Override
         public void actionPerformed(ActionEvent e) {
        	 Object obj = e.getSource();
        	 if (obj == login_bt) {
        		 login_proc();
        	 }else if(obj == passch_bt) {
        		 passch_proc();
        	 }
         }
       public void login_proc() {
        	 if(loginTextField.getText().equals("")) {
        		 
        		         		 JOptionPane.showMessageDialog(null, 
        		         				 Commons.getMsg("아이디를 입력해주세요"));
        		         		 loginTextField.requestFocus();
        	 }
        	 else if(passwordField.getText().equals("")) {
        		 JOptionPane.showMessageDialog(null, 
      					Commons.getMsg("패스워드를 입력해주세요"));
        		 passwordField.requestFocus();
        	 }else {
        		 System.out.println(passwordField.getText());
        		 
        		 boolean result = system.logincheck(loginTextField.getText(), passwordField.getText());
        		 if(result) {
        			 JOptionPane.showMessageDialog(null, 
     						Commons.getMsg("로그인 성공"));
        			new kiosk_GetScreen();
        		 }else {
        			 JOptionPane.showMessageDialog(null, 
     						Commons.getMsg("로그인 실패"));
        		 }
        	 }
         }
       public void passch_proc() {
    	   
       }
	}
	

