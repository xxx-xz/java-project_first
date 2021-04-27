package kiosk_vo;

import java.io.Serializable;

public class MenuVO implements Serializable{
	String menu ,menu_kor;
	int price;
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMenu_kor() {
		return menu_kor;
	}
	public void setMenu_kor(String menu_kor) {
		this.menu_kor = menu_kor;
	}
	
	
	
}
