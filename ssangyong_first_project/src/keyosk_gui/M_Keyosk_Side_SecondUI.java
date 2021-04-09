package keyosk_gui;

import java.awt.GridLayout;
import java.awt.Panel;

public class M_Keyosk_Side_SecondUI {
	M_Keyosk_UI main;
	
	public M_Keyosk_Side_SecondUI(M_Keyosk_UI main) {
		this.main = main;
		M_Keyosk_UI.page_check = 3;
		init();
	}
	
	public void init() {
		main.switch_panel();
		main.menu_image = new Panel(new GridLayout(1,2,50,30));
		
		main.menu_image.add(main.macnugget_button);
		main.menu_image.add(main.cheesemuffin_button);
		
		main.menu_image_panel.add(main.menu_image);
		main.f.setVisible(true);
		
	}
}
