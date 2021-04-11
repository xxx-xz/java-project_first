package keyosk_vo;

import java.io.Serializable;

public class MenuVO implements Serializable{
	String menu;
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
	
	
	
}
