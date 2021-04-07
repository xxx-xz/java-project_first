package jh_keyosk;

import java.awt.GridLayout;
import java.awt.Panel;

public class M_Keyosk_Side_FirstUI {
	M_Keyosk_UI main;
	
	public M_Keyosk_Side_FirstUI(M_Keyosk_UI main) {
		this.main = main;
		M_Keyosk_UI.page_check = 3;
		init();
	}
	
	public void init() {
		main.switch_panel();
		main.menu_image = new Panel(new GridLayout(2,3,50,30));
		
		main.menu_image.add(main.applepie_label);
		main.menu_image.add(main.cheesestick_label);
		main.menu_image.add(main.eggmuffin_label);
		main.menu_image.add(main.frenchfries_label);
		main.menu_image.add(main.hotcake_label);
		main.menu_image.add(main.icecream_label);
		
		main.menu_image_panel.add(main.menu_image);
		main.f.setVisible(true);
		
	}
}
