package client_kiosk_system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import client_kiosk_dao.Client_Menu_DAO;
import client_kiosk_gui.Client_Payment;
import client_kiosk_gui.Client_UI;
import client_kiosk_vo.MenuVO;

public class Client_ActionEvent implements ActionListener{
	public Client_UI main;
	ArrayList<String> order_list = new ArrayList<String>();
	MenuVO menu = new MenuVO();
	public Client_Menu_DAO dao = new Client_Menu_DAO();
	public Client_ActionEvent(Client_UI main) {
		this.main = main;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		/** ��Ʈ�޴� **/
		if(obj == Client_UI.menu_list.get(0)){
			System.out.println("��Ƽ�Ʈ��ưŬ��");
			menu = dao.menu_click_result("BIGMAC_SET");
			menu_list(menu);
		}else if(obj == Client_UI.menu_list.get(1)) {
			menu = dao.menu_click_result("BULGOGI_SET");
			menu_list(menu);
		}else if(obj == Client_UI.menu_list.get(2)) {
			menu = dao.menu_click_result("SHANGHAI_SET");
			menu_list(menu);
		}else if(obj == Client_UI.menu_list.get(3)) {
			menu = dao.menu_click_result("DOUCHEESE_SET");
			menu_list(menu);
		}else if(obj == Client_UI.menu_list.get(4)) {
			menu = dao.menu_click_result("MACCHICKEN_SET");
			menu_list(menu);
		}else if(obj == Client_UI.menu_list.get(5)) {
			menu = dao.menu_click_result("EGGBULGOGI_SET");
			menu_list(menu);
		}else if(obj == Client_UI.menu_list.get(6)) {
			menu = dao.menu_click_result("CHEESE_SET");
			menu_list(menu);
		}else if(obj == Client_UI.menu_list.get(7)) {
			menu = dao.menu_click_result("SUSU_SET");
			menu_list(menu);
		}else if(obj == Client_UI.menu_list.get(8)) {
			menu = dao.menu_click_result("SUBI_SET");
			menu_list(menu);
		}
		/** �̱� �޴� **/
		else if(obj == Client_UI.menu_list.get(9)){
			menu = dao.menu_click_result("BIGMAC");
			menu_list(menu);
		}else if(obj == Client_UI.menu_list.get(10)) {
			menu = dao.menu_click_result("BULGOGI");
			menu_list(menu);
		}else if(obj == Client_UI.menu_list.get(11)) {
			menu = dao.menu_click_result("SHANGHAI");
			menu_list(menu);
		}else if(obj == Client_UI.menu_list.get(12)) {
			menu = dao.menu_click_result("DOUCHEESE");
			menu_list(menu);
		}else if(obj == Client_UI.menu_list.get(13)) {
			menu = dao.menu_click_result("MACCHICKEN");
			menu_list(menu);
		}else if(obj == Client_UI.menu_list.get(14)) {
			menu = dao.menu_click_result("EGGBULGOGI");
			menu_list(menu);
		}else if(obj == Client_UI.menu_list.get(15)) {
			menu = dao.menu_click_result("CHEESE");
			menu_list(menu);
		}else if(obj == Client_UI.menu_list.get(16)) {
			menu = dao.menu_click_result("SUSU");
			menu_list(menu);
		}else if(obj == Client_UI.menu_list.get(17)) {
			menu = dao.menu_click_result("SUBI");
			menu_list(menu);
		}
		/** ���̵� �޴� **/
		else if(obj == Client_UI.menu_list.get(18)) {
			menu = dao.menu_click_result("APPLEPIE");
			menu_list(menu);
		}else if(obj == Client_UI.menu_list.get(19)) {
			menu = dao.menu_click_result("CHEESESTICK");
			menu_list(menu);
		}else if(obj == Client_UI.menu_list.get(20)) {
			menu = dao.menu_click_result("EGGMUFFIN");
			menu_list(menu);
		}else if(obj == Client_UI.menu_list.get(21)) {
			menu = dao.menu_click_result("FRENCHFRIES");
			menu_list(menu);
		}else if(obj == Client_UI.menu_list.get(22)) {
			menu = dao.menu_click_result("HOTCAKE");
			menu_list(menu);
		}else if(obj == Client_UI.menu_list.get(23)) {
			menu = dao.menu_click_result("ICECREAM");
			menu_list(menu);
		}else if(obj == Client_UI.menu_list.get(24)) {
			menu = dao.menu_click_result("MACNUGGET");
			menu_list(menu);	
		}else if(obj == Client_UI.menu_list.get(25)) {
			menu = dao.menu_click_result("CHEESEMUFFIN");
			menu_list(menu);	
		}
		/** ���� �޴� **/
		else if(obj == Client_UI.menu_list.get(26)) {
			menu = dao.menu_click_result("COKE");
			menu_list(menu);
		}else if(obj == Client_UI.menu_list.get(27)) {
			menu = dao.menu_click_result("CIDER");
			menu_list(menu);
		}
		/** ����,��� **/
		else if(obj == main.payment) {
			new Client_Payment(this,menu);
		}else if(obj == main.cancle) {
			
		}
		
		
	}
	public void menu_list(MenuVO menu) {
		if(menu.getMenu().equals("DOUCHEESE_SET") || menu.getMenu().equals("EGGBULGOGI_SET")){
			Client_UI.order_menu.append(menu.getMenu_kor() + "\t\t\t\t" + 1 + "\t\t\t\t\t" + menu.getPrice() + "\n");
			Client_UI.order_menu_list.add(menu);
		}else {
			Client_UI.order_menu.append(menu.getMenu_kor() + "\t\t\t\t\t" + 1 + "\t\t\t\t\t" + menu.getPrice() + "\n");
			Client_UI.order_menu_list.add(menu);
		}
	
	}

}
