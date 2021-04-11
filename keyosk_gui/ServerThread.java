package keyosk_gui;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import keyosk_vo.MenuVO;

public class ServerThread extends Thread {
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	public ServerThread(Socket s) {
		try {
			ois = new ObjectInputStream(s.getInputStream());
			oos= new ObjectOutputStream(s.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	synchronized  public void run() {
		try {
			while(true) {
				System.out.println("ServerThread Ω√¿€");
				ArrayList<MenuVO> menu =(ArrayList<MenuVO>)ois.readObject();
				Server.Casting();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
