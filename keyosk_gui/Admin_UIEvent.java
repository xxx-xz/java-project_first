package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Admin_UIEvent implements ActionListener {
	login main;
	
	
	
	public Admin_UIEvent(login main) {
		this.main = main;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == main.join_bt) {
			main.layeredPane.setVisible(false);
			new join();
			
			
		}
		
		


		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
