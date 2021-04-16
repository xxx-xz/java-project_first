package project_gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import project_system.Commons;
import project_system.LHS_Admin_System;
import project_vo.LHS_Admin_VO;

public class LHS_Admin_UIEvent  implements ActionListener {
	LHS_Admin_Login main;
	LHS_Admin_Join ui;
	
	
	
	
	public LHS_Admin_UIEvent(LHS_Admin_Login main, LHS_Admin_Join ui) {
		this.main = main;
		this.ui = ui;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String name = e.getActionCommand();
		Object obj = e.getSource();
	
		if(obj == ui.join_bt) {
			if(form_check()) {
				ArrayList<JTextField> jlist = new ArrayList<JTextField>();
				for(Object tf : ui.list) {
					JTextField jtf = (JTextField)tf;
					jlist.add(jtf);
				}
				
				LHS_Admin_VO member = new LHS_Admin_VO();
				member.setId(jlist.get(0).getText());
				System.out.println("Action");
				member.setPass(jlist.get(1).getText());
				member.setHp1(jlist.get(2).getText());
				member.setHp2(jlist.get(3).getText());
				member.setHp3(jlist.get(4).getText());
				member.setMail1(jlist.get(5).getText());
				member.setMail2(jlist.get(6).getText());
				
				
				boolean result = main.system.join(member);
				
				if(result) {
					JOptionPane.showMessageDialog(null, 
							Commons.getMsg("회원가입 성공"));
					for(Object obj2 : ui.list) {
						JTextField tf = (JTextField)obj2;
						tf.setText("");
					}
					
					ui.f.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, 
							Commons.getMsg("회원가입 실패"));
				}
			}
			
		}else {		
			for(Object obj2 : ui.list) {
				JTextField tf = (JTextField)obj2;
				tf.setText("");
			}

				}
			}
		
		
	
	
	
	public boolean form_check() {
		boolean result = false;
		
		for(int i=0; i<ui.list.size(); i++) {
			JTextField tf = (JTextField)ui.list.get(i);
			
			if(tf.getText().equals("")) {
				JOptionPane.showMessageDialog(null, 
						Commons.getMsg(ui.namelist[i]+"를 입력해주세요"));
				tf.requestFocus();
				i = ui.list.size();
			}else if (i == ui.list.size()-1) {
				result = true;
			}
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
