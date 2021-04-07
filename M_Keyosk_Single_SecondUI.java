package jh_keyosk;

import java.awt.GridLayout;
import java.awt.Panel;

public class M_Keyosk_Single_SecondUI {
	M_Keyosk_UI main;
	
	public  M_Keyosk_Single_SecondUI(M_Keyosk_UI main) {
		this.main = main;
		M_Keyosk_UI.page_check = 2;
		init();
	}
	
	public void init() {
		main.switch_panel();
		main.menu_image = new Panel(new GridLayout(1,3,50,30));
		
		main.menu_image.add(main.cheese_label);
		main.menu_image.add(main.susu_label);
		main.menu_image.add(main.subi_label);
		
		
		main.menu_image_panel.add(main.menu_image);
		main.f.setVisible(true);
	}
}
