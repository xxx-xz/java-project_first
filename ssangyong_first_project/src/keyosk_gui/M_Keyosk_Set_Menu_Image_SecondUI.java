package keyosk_gui;

import java.awt.GridLayout;
import java.awt.Panel;

public class M_Keyosk_Set_Menu_Image_SecondUI {
	M_Keyosk_UI main;
	public M_Keyosk_Set_Menu_Image_SecondUI(M_Keyosk_UI main) {
		this.main = main;
		init();
	}
	
	
	public void init() {
		main.switch_panel();
		main.menu_image = new Panel(new GridLayout(1,3,50,30));
		
		main.menu_image.add(main.cheese_set_button);
		main.menu_image.add(main.susu_set_button);
		main.menu_image.add(main.subi_set_button);

		main.menu_image_panel.add(main.menu_image);
		main.f.setVisible(true);
	}
}