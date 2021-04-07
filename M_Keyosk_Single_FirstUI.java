package jh_keyosk;

import java.awt.GridLayout;
import java.awt.Panel;

public class M_Keyosk_Single_FirstUI {
	M_Keyosk_UI main;
	
	public M_Keyosk_Single_FirstUI(M_Keyosk_UI main) {
		this.main = main;
		M_Keyosk_UI.page_check = 2;
		init();
	}
	
	public void init() {
		main.switch_panel();
		main.menu_image = new Panel(new GridLayout(2,3,50,30));
		
		main.menu_image.add(main.bigmag_label);
		main.menu_image.add(main.bulgogi_label);
		main.menu_image.add(main.shanghai_label);
		main.menu_image.add(main.doucheese_label);
		main.menu_image.add(main.magchicken_label);
		main.menu_image.add(main.eggbulgogi_label);
		
		main.menu_image_panel.add(main.menu_image);
		main.f.setVisible(true);
		
	}

}
