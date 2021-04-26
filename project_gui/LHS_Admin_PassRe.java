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

public class LHS_Admin_PassRe implements ActionListener {
	LHS_Admin_Login main;
	LHS_Admin_System system;
	LHS_AdminPass pass;
	Frame f;
	JLabel pass_label, pass2_label;
	JTextField pass_field, pass2_field;
	JButton bt;
	ArrayList<Object> list = new ArrayList<Object>();
	
	public LHS_Admin_PassRe(LHS_Admin_System system) {
		this.system = system;
		init();
	}
	
	public LHS_Admin_PassRe(LHS_Admin_Login main, LHS_Admin_System system, LHS_AdminPass pass) {
		this.main = main;
		this.system = system;
		this.pass = pass;
	}
	public void init() {
		pass = new LHS_AdminPass();
		f = new Frame();
		pass_label = new JLabel("��й�ȣ"); 
		pass2_label = new JLabel("��й�ȣ Ȯ��");
		pass_field = new JTextField(20);
		pass2_field = new JTextField(20);
		bt = new JButton("��й�ȣ ����");
		
		Panel lb_panel = new Panel(new GridLayout(2,1,0,5));
		Panel tf_panel = new Panel(new GridLayout(2,1,0,5));
		Panel bt_panel = new Panel();
		
		list.add(pass_field); list.add(pass2_field);
		
		lb_panel.add(pass_label); lb_panel.add(pass2_label);
		tf_panel.add(pass_field); tf_panel.add(pass2_field);
		bt_panel.add(bt);
		
		f.add(BorderLayout.WEST, lb_panel);
		f.add(BorderLayout.CENTER, tf_panel);
		f.add(BorderLayout.SOUTH, bt_panel);
		
		f.setVisible(true);
		f.setSize(300,150);
		bt.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == bt) {
			proc();
		}
	}
	public void proc() {
 if(pass_field.getText().equals("")) {
    		 
     		 JOptionPane.showMessageDialog(null, 
     				 Commons.getMsg("��й�ȣ�� �Է����ּ���"));
     		 pass_field.requestFocus();
		 }
		 else if(pass2_field.getText().equals("")) {
			 JOptionPane.showMessageDialog(null, 
					 Commons.getMsg("��й�ȣ2�� �Է����ּ���"));
			 	pass2_field.requestFocus();
			 	
			 	
		 }else if(!pass_field.getText().equals(pass2_field.getText())){
			 
			 
			 System.out.println(pass_field.getText());
			 System.out.println(pass2_field.getText());
			 JOptionPane.showMessageDialog(null, 
					 Commons.getMsg("��й�ȣ�� ��ġ���� �ʽ��ϴ�."));
		 }else {
			 int result = system.update(pass.id, pass_field.getText(), pass2_field.getText());
			 System.out.println(result);
			 if(result == 0) {
				 System.out.println("��й�ȣ���� �Ϸ�");
				 JOptionPane.showMessageDialog(null, 
  						Commons.getMsg("��й�ȣ ����Ϸ�"));
				 new LHS_Admin_Login();
			 }else {
				 JOptionPane.showMessageDialog(null, 
  						Commons.getMsg("��й�ȣ ���� ����"));
			 }
		 }
	}
}
