package keyosk_system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import keyosk_dao.M_Keyosk_MenuDAO;
import keyosk_gui.M_Keyosk_Bevarage_FirstUI;
import keyosk_gui.M_Keyosk_Payment;
import keyosk_gui.M_Keyosk_Set_Menu_Image_FirstUI;
import keyosk_gui.M_Keyosk_Set_Menu_Image_SecondUI;
import keyosk_gui.M_Keyosk_Side_FirstUI;
import keyosk_gui.M_Keyosk_Side_SecondUI;
import keyosk_gui.M_Keyosk_Single_FirstUI;
import keyosk_gui.M_Keyosk_Single_SecondUI;
import keyosk_gui.M_Keyosk_UI;
import keyosk_vo.MenuVO;

public class M_Keyosk_ActionEvent implements ActionListener{
	public M_Keyosk_UI main;
	ArrayList<String> order_list = new ArrayList<String>();
	MenuVO menu = new MenuVO();
	public M_Keyosk_MenuDAO dao = new M_Keyosk_MenuDAO();
	public M_Keyosk_ActionEvent(M_Keyosk_UI main) {
		this.main = main;
//		M_Keyosk_image_create image = new M_Keyosk_image_create(main);
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
		}
		/** 세트메뉴 **/
		else if(obj == main.bigmag_set_button){
			menu = dao.menu_click_result("BIGMAC_SET");
			menu_list(menu);
		}else if(obj == main.doucheese_set_button) {
			menu = dao.menu_click_result("DOUCHEESE_SET");
			menu_list(menu);
		}else if(obj == main.bulgogi_set_button) {
			menu = dao.menu_click_result("BULGOGI_SET");
			menu_list(menu);
		}else if(obj == main.shanghai_set_button) {
			menu = dao.menu_click_result("SHANGHAI_SET");
			menu_list(menu);
		}else if(obj == main.magchicken_set_button) {
			menu = dao.menu_click_result("MACCHICKEN_SET");
			menu_list(menu);
		}else if(obj == main.eggbulgogi_set_button) {
			menu = dao.menu_click_result("EGGBULGOGI_SET");
			menu_list(menu);
		}else if(obj == main.cheese_set_button) {
			menu = dao.menu_click_result("CHEESE_SET");
			menu_list(menu);
		}else if(obj == main.susu_set_button) {
			menu = dao.menu_click_result("SUSU_SET");
			menu_list(menu);
		}else if(obj == main.subi_set_button) {
			menu = dao.menu_click_result("SUBI_SET");
			menu_list(menu);
		}
		/** 싱글 메뉴 **/
		else if(obj == main.bigmag_button){
			menu = dao.menu_click_result("BIGMAC");
			menu_list(menu);
		}else if(obj == main.doucheese_button) {
			menu = dao.menu_click_result("DOUCHEESE");
			menu_list(menu);
		}else if(obj == main.bulgogi_button) {
			menu = dao.menu_click_result("BULGOGI");
			menu_list(menu);
		}else if(obj == main.shanghai_button) {
			menu = dao.menu_click_result("SHANGHAI");
			menu_list(menu);
		}else if(obj == main.magchicken_button) {
			menu = dao.menu_click_result("MACCHICKEN");
			menu_list(menu);
		}else if(obj == main.eggbulgogi_button) {
			menu = dao.menu_click_result("EGGBULGOGI");
			menu_list(menu);
		}else if(obj == main.cheese_button) {
			menu = dao.menu_click_result("CHEESE");
			menu_list(menu);
		}else if(obj == main.susu_button) {
			menu = dao.menu_click_result("SUSU");
			menu_list(menu);
		}else if(obj == main.subi_button) {
			menu = dao.menu_click_result("SUBI");
			menu_list(menu);
		}
		/** 사이드 메뉴 **/
		else if(obj == main.applepie_button) {
			menu = dao.menu_click_result("APPLEPIE");
			menu_list(menu);
		}else if(obj == main.cheesestick_button) {
			menu = dao.menu_click_result("CHEESESTICK");
			menu_list(menu);
		}else if(obj == main.eggmuffin_button) {
			menu = dao.menu_click_result("EGGMUFFIN");
			menu_list(menu);
		}else if(obj == main.frenchfries_button) {
			menu = dao.menu_click_result("FRENCHFRIES");
			menu_list(menu);
		}else if(obj == main.hotcake_button) {
			menu = dao.menu_click_result("HOTCAKE");
			menu_list(menu);
		}else if(obj == main.icecream_button) {
			menu = dao.menu_click_result("ICECREAM");
			menu_list(menu);
		}else if(obj == main.macnugget_button) {
			menu = dao.menu_click_result("MACNUGGET");
			menu_list(menu);	
		}else if(obj == main.cheesemuffin_button) {
			menu = dao.menu_click_result("CHEESEMUFFIN");
			menu_list(menu);	
		}
		/** 음료 메뉴 **/
		else if(obj == main.coke_button) {
			menu = dao.menu_click_result("COKE");
			menu_list(menu);
		}else if(obj == main.cider_button) {
			menu = dao.menu_click_result("CIDER");
			menu_list(menu);
		}
		/** 결제,취소 **/
		else if(obj == main.payment) {
			new M_Keyosk_Payment(this,menu);
		}else if(obj == main.cancle) {
			
		}
		
		
	}
	public void menu_list(MenuVO menu) {
		if(menu.getMenu().equals("SHANGHAI_SET") || menu.getMenu().equals("MACCHICKEN_SET") || 
				menu.getMenu().equals("DOUCHEESE_SET") || menu.getMenu().equals("EGGBULGOGI_SET") ||
				menu.getMenu().equals("CHEESEMUFFIN") || menu.getMenu().equals("FRENCHFRIES") ||
				menu.getMenu().equals("CHEESESTICK")) {
			main.order_menu.append(menu.getMenu() + "\t\t\t\t" + 1 + "\t\t\t\t\t" + menu.getPrice() + "\n");
			M_Keyosk_UI.order_menu_list.add(menu);
		}else {
			main.order_menu.append(menu.getMenu() + "\t\t\t\t\t" + 1 + "\t\t\t\t\t" + menu.getPrice() + "\n");
			M_Keyosk_UI.order_menu_list.add(menu);
		}
	
	}

}
