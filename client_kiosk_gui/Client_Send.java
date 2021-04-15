package client_kiosk_gui;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import client_kiosk_vo.MenuVO;

public class Client_Send {
	
	ArrayList<MenuVO> order_list;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	static Socket s;
	int watingnumber;
	
	public Client_Send(ArrayList<MenuVO> order_list) {
		this.order_list = order_list;
		try {
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void init() throws Exception{
		for(MenuVO vo : order_list) {
			System.out.println(vo.getMenu() + vo.getPrice());
		}
		s = new Socket("127.0.0.1",5555);
		oos = new ObjectOutputStream(s.getOutputStream());
		ois = new ObjectInputStream(s.getInputStream());
		oos.writeObject(order_list);
//		oos.writeObject(null);
		new ClientThread(this).start();
		
	}
}
