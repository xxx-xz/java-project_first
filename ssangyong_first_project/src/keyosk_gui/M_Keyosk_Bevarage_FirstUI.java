package keyosk_gui;

import java.awt.GridLayout;
import java.awt.Panel;

public class M_Keyosk_Bevarage_FirstUI {
	M_Keyosk_UI main;
	
	public M_Keyosk_Bevarage_FirstUI(M_Keyosk_UI main) {
		this.main = main;
		M_Keyosk_UI.page_check = 4;
		init();
	}
	
	public void init() {
		main.switch_panel();
		main.menu_image = new Panel(new GridLayout(1,2,50,10));
		
		main.menu_image.add(main.coke_button);
		main.menu_image.add(main.cider_button);
		
		main.menu_image_panel.add(main.menu_image);
		main.f.setVisible(true);
		
	}
}
