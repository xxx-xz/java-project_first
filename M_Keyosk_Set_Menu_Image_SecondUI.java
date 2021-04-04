package jh_keyosk;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Panel;

public class M_Keyosk_Set_Menu_Image_SecondUI {
	M_Keyosk_UI main;
	public M_Keyosk_Set_Menu_Image_SecondUI(M_Keyosk_UI main) {
		this.main = main;
		init();
	}
	
	
	public void init() {
		main.switch_panel(M_Keyosk_UI.SET_MENU_TWO);
		main.menu_image = new Panel(new GridLayout(1,3,50,30));
		
		main.menu_image.add(main.cheese_set_label);
		main.menu_image.add(main.susu_set_label);
		main.menu_image.add(main.subi_set_label);

		main.menu_image_panel.add(main.menu_image);
		main.f.setVisible(true);
	}
}
