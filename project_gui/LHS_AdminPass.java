package project_gui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import project_system.Commons;
import project_system.LHS_Admin_System;

public class LHS_AdminPass implements ActionListener{
	LHS_Admin_Login main;
	LHS_Admin_System system;
	Frame f;
	JLabel id_label, email_label;
	JTextField id_field, email_field;
	JButton ch_bt;
	ArrayList<Object> list = new ArrayList<Object>();
	String id;
	
	public LHS_AdminPass() {
		init();
	}
	
	public LHS_AdminPass(LHS_Admin_Login main, LHS_Admin_System system) {
		this.main = main;
		this.system = system;
		
		init();
	}
	
	public void init() {
		f = new Frame();
		id_label = new JLabel("아이디"); 
		email_label = new JLabel("E-Mail");
		id_field = new JTextField(20);
		email_field = new JTextField(30);
		ch_bt = new JButton("Email 인증");
		
		Panel lb_panel = new Panel(new GridLayout(2,1,0,5));
		Panel tf_panel = new Panel(new GridLayout(2,1,0,5));
		Panel bt_panel = new Panel();
		
		list.add(id_field); list.add(email_field);
		
		lb_panel.add(id_label); lb_panel.add(email_label);
		tf_panel.add(id_field); tf_panel.add(email_field);
		bt_panel.add(ch_bt);
		
		f.add(BorderLayout.WEST, lb_panel);
		f.add(BorderLayout.CENTER, tf_panel);
		f.add(BorderLayout.SOUTH, bt_panel);
		
		f.setVisible(true);
		f.setSize(300,150);
		ch_bt.addActionListener(this);
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String name = e.getActionCommand();
		if(obj == ch_bt){
			ch_proc();
		}
		
		else {
			
		}
	}
	
	public void ch_proc() {
		 if(id_field.getText().equals("")) {
    		 
     		 JOptionPane.showMessageDialog(null, 
     				 Commons.getMsg("아이디를 입력해주세요"));
     		 id_field.requestFocus();
		 }
		 else if(email_field.getText().equals("")) {
			 JOptionPane.showMessageDialog(null, 
					 Commons.getMsg("Email을 입력해주세요"));
			 	email_field.requestFocus();
		 }else {
			 
			 
			 boolean result = system.search(id_field.getText(), email_field.getText());
			 id = id_field.getText();
			 
			 if(result) {
				 //this.dispose(); 
				new  LHS_Admin_PassRe(system);
						 
				 	
			 }else {
				 JOptionPane.showMessageDialog(null, 
						 Commons.getMsg("아이디 혹은 이메일이 올바르지 않습니다."));
}
}
		
		
	}
	
}
