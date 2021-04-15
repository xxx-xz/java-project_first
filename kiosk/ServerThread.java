package kiosk;

import java.awt.Color;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import client_kiosk_gui.ClientThread;
import client_kiosk_vo.MenuVO;

public class ServerThread extends Thread {
	static ObjectInputStream ois;
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
				System.out.println("ServerThread 시작");
				ArrayList<MenuVO> menu =(ArrayList<MenuVO>)ois.readObject();
				kiosk_GetScreen.Casting();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
