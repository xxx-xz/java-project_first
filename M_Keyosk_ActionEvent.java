package jh_keyosk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class M_Keyosk_ActionEvent implements ActionListener{
	M_Keyosk_UI main;
	
	public M_Keyosk_ActionEvent(M_Keyosk_UI main) {
		this.main = main;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == main.next) {
			if(M_Keyosk_UI.page_check == 1) {
				new M_Keyosk_Set_Menu_Image_SecondUI(main);
			}else if(M_Keyosk_UI.page_check == 2) {
				new M_Keyosk_Single_SecondUI(main);
			}else if(M_Keyosk_UI.page_check == 3) {
				new M_Keyosk_Side_SecondUI(main);
			}else if(M_Keyosk_UI.page_check == 4) {
				new M_Keyosk_Bevarage_FirstUI(main);
			}
		}else if(obj == main.previous) {
			if(M_Keyosk_UI.page_check == 1) {
				new M_Keyosk_Set_Menu_Image_FirstUI(main);
			}else if(M_Keyosk_UI.page_check == 2) {
				new M_Keyosk_Single_FirstUI(main);
			}else if(M_Keyosk_UI.page_check == 3) {
				new M_Keyosk_Side_FirstUI(main);
			}else if(M_Keyosk_UI.page_check == 4) {
				
			}
		}else if(obj == main.set) {
			new M_Keyosk_Set_Menu_Image_FirstUI(main);
		}else if(obj == main.single) {
			new M_Keyosk_Single_FirstUI(main);
		}else if(obj == main.side) {
			new M_Keyosk_Side_FirstUI(main);
		}else if(obj == main.beverage) {
			new M_Keyosk_Bevarage_FirstUI(main);
		}else if(obj == main.bigmag_set_label) {
			System.out.println("ºò¸Æ¼¼Æ®»çÁø");
		}
	}

}
