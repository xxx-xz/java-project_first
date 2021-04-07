package jh_keyosk;

import java.awt.GridLayout;
import java.awt.Panel;

public class M_Keyosk_Set_Menu_Image_FirstUI {
	M_Keyosk_UI main;
	
	public M_Keyosk_Set_Menu_Image_FirstUI(M_Keyosk_UI main) {
		this.main = main;
		init();
	}
	
	public void init(){
		
		main.menu_image = new Panel(new GridLayout(2,3,50,30));
		main.switch_panel();
		
		main.menu_image.add(main.bigmag_set_label);
		main.menu_image.add(main.bulgogi_set_label);
		main.menu_image.add(main.shanghai_set_label);
		main.menu_image.add(main.doucheese_set_label);
		main.menu_image.add(main.magchicken_set_label);
		main.menu_image.add(main.eggbulgogi_set_label);

		
		
		main.menu_image_panel.add(main.menu_image);
		main.f.setVisible(true);
		
	
		
	}
}
