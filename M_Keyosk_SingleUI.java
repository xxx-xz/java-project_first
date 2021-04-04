package jh_keyosk;

import java.awt.GridLayout;
import java.awt.Panel;

public class M_Keyosk_SingleUI {
	M_Keyosk_UI main;
	
	public M_Keyosk_SingleUI(M_Keyosk_UI main) {
		this.main = main;
		init();
	}
	
	public void init() {
		main.menu_image = new Panel(new GridLayout(2,3,50,30));
		main.switch_panel(M_Keyosk_UI.SIDE_MENU);
		
		
	}

}
