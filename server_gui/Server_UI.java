package server_gui;

import java.awt.*;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.*;

import server_system.Server_ActionEvent;

public class Server_UI extends JFrame {
	// Field
	String time;
	JLabel now;
	public static JPanel grid_panel = new JPanel(new GridLayout(8, 3));
	static JPanel line_panel;
	JLabel l_order, l_cus_call, l_order_stic, top_label;
	JTextArea ta_cal1, ta_cal2;
	public static JTextArea ta_screan;
	static JTextArea cus_order;
	public JButton b_cus_call, serch, b_1, b_2, b_3;
	static JLayeredPane layeredPane;
	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date datetoday = new Date();;
	ServerSocket server;
	Socket s;
	static int num = 100;
	public static ServerThread st;
	static ArrayList<ObjectOutputStream> boos = new ArrayList<ObjectOutputStream>();
	Server_ActionEvent event = new Server_ActionEvent(this, st);;
//	static ArrayList<ObjectOutputStream> list = new ArrayList<ObjectOutputStream>();

	// Constructor
	public Server_UI() {
		start();
	}

	// Method
	/** 레이아웃 설정 **/
	public void start() {

		/** --------내꺼-------- **/
		setTitle("주문현황");
		setSize(1000, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		/** 레이아웃 설정 **/
		setLayout(null);
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1439, 2000);
		layeredPane.setLayout(null);
		layeredPane.setBackground(new Color(226, 226, 226));

		/** --------왼쪽-------- **/

		/** 이미지 **/
		ImageIcon img = new ImageIcon("keyosk_images/call_button.png");
		ImageIcon img1 = new ImageIcon("keyosk_images/serch.png");

		/** 오늘날짜 **/
//		JPanel nn = new JPanel();
		now = new JLabel();
//		nn.add(now);
		now.setBounds(62, 50, 250, 30);
		Font font1 = new Font("맑은 고딕", Font.BOLD, 20);
		now.setFont(font1);
		layeredPane.add(now);
		setTime();

		/** 주문내역 **/
		l_order = new JLabel("주문내역");
		Font font2 = new Font("맑은 고딕", Font.BOLD, 18);
		l_order.setFont(font2);
		l_order.setBounds(62, 125, 150, 20);
		layeredPane.add(l_order);

//    		line_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//    		
//    		grid_panel.add(line_panel);
		grid_panel.setBounds(62, 156, 380, 380);
		layeredPane.add(grid_panel);

		/** 고객호출 라벨 **/
		l_cus_call = new JLabel("                             고객호출");
		l_cus_call.setBounds(62, 600, 500, 20);
		Font font3 = new Font("맑은 고딕", Font.BOLD, 18);
		l_cus_call.setFont(font3);
		layeredPane.add(l_cus_call);

		/** 고객호출 버튼 **/
		b_cus_call = new JButton(img);
		b_cus_call.setBounds(62, 639, 428, 80);
		b_cus_call.setBackground(Color.BLACK);

		layeredPane.add(b_cus_call);

		/** --------오른쪽-------- **/

		/** 박 **/
		ta_screan = new JTextArea();
		ta_screan.setFont(font3);
		ta_screan.setBounds(450, 50, 450, 515);
		layeredPane.add(ta_screan);

		/** 왼쪽 **/
		b_1 = new JButton("매출현황");
		b_1.setFont(font2);
		b_1.setBackground(Color.lightGray);
		b_1.setBounds(518, 650, 180, 60);//751, 50, 636, 763
		layeredPane.add(b_1);
		
		/** 중간 **/
//		b_2 = new JButton("뭐할지모름");
//		b_2.setFont(font2);
//		b_2.setBackground(Color.lightGray);
//		b_2.setBounds(738, 589, 180, 60);
//		layeredPane.add(b_2);
		
		/** 오른쪽 **/
		b_3 = new JButton("종료");
		b_3.setFont(font2);
		b_3.setBackground(Color.lightGray);
		b_3.setBounds(750, 650, 180, 60);
		layeredPane.add(b_3);

		add(layeredPane);
		setVisible(true);

		b_1.addActionListener(event);
		b_3.addActionListener(event);

		b_cus_call.addActionListener(event);

		serverStart();
	}

	public void setTime() {
		Thread timee = new Thread() {
			@Override
			public void run() {
				while (true) {
					time = format1.format(Calendar.getInstance().getTime());
					now.setText(time);
				//	System.out.println(time);

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			

			}
		};
		timee.start();
	}

	
	public void serverStart() {
		try {
			server = new ServerSocket(5555);
			System.out.println("--->서버1시작.....");
			while (true) {
				s = server.accept();
				System.out.println("클라이언트 접속!!");
				st = new ServerThread(s);
				boos.add(st.oos);
				st.start();

//				list.add(st.oos);
//				System.out.println(list.get(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	synchronized static public void Casting() {

		try {
			for (ObjectOutputStream os : boos) {
				System.out.println("대기번호 전송");
				os.writeObject(num);
			}
			num++;
//			boos.clear();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static public void CompleteSend(int comnumber) {
		try {
			for (ObjectOutputStream os : boos) {
				os.writeObject(comnumber + 100);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}// class