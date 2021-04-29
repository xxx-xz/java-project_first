package server_gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import client_kiosk_gui.Commons;
import kiosk_vo.LHS_Admin_VO;

public class LHS_Admin_UIEvent  implements ActionListener {
	LHS_Admin_Login main;
	static LHS_Admin_Join ui;
	
	
	
	LHS_Admin_UIEvent(){}
	LHS_Admin_UIEvent(LHS_Admin_Join ui){
		this.ui = ui;
	}
	
	public LHS_Admin_UIEvent(LHS_Admin_Join ui, LHS_Admin_Login main) {
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
				member.setPass(jlist.get(1).getText());
				member.setPass2(jlist.get(2).getText());
				member.setHp1(jlist.get(3).getText());
				member.setHp2(jlist.get(4).getText());
				member.setHp3(jlist.get(5).getText());
				member.setMail1(jlist.get(6).getText());
				member.setMail2(jlist.get(7).getText());
				
				boolean result = main.system.join(member);
				
				
				
				if(result) {
					JOptionPane.showMessageDialog(null, 
							Commons.getMsg("회원가입 성공"));
					ui.dispose();
					
					//new LHS_Admin_Login();
					for(Object obj2 : ui.list) {
						JTextField tf = (JTextField)obj2;
						tf.setText("");
					}
					
					//ui.f.setVisible(false);
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
		
		
		 if(!ui.passwordField.getText().equals(ui.passwordField2.getText())) {
			 System.out.println(ui.passwordField.getText());
			 System.out.println(ui.passwordField2.getText());
			JOptionPane.showMessageDialog(null, 
					Commons.getMsg("비밀번호가 일치하지 않습니다."));
			result = false;
		}else if(ui.passwordField.getText().equals(ui.passwordField2.getText())) {
			result = true;
		}
		 return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
