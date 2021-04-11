package keyosk_gui;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	ServerSocket server;
	Socket s;
	static int num = 1;
	static ServerThread st;
	static ArrayList<ObjectOutputStream> list = new ArrayList<ObjectOutputStream>();
	public Server() {
		try {
			server = new ServerSocket(5555);
			System.out.println("--->서버시작.....");
			while(true) {
				s = server.accept();
				st = new ServerThread(s);
				st.start();
				list.add(st.oos);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static public void Casting() {
		
		try {
			System.out.println("대기번호 전송 시작");
			st.oos.writeObject(num);
			System.out.println("대기번호 전송 완료 // 대기번호 : " + num);
			num++;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
