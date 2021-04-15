package kiosk;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import client_kiosk_gui.ClientThread;

public class kiosk_GetScreen extends JFrame implements Runnable{
	//Field
	static JPanel grid_panel = new JPanel(new GridLayout(8,3));
	static JPanel line_panel; 
	JLabel l_order, l_cus_call ,l_order_stic,top_label;
	JTextArea ta_cal1, ta_cal2, ta_screan;
	static JTextArea cus_order;
	JButton b_cus_call, serch, b_1, b_2, b_3;
	static JLayeredPane layeredPane;
	SimpleDateFormat format1 = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
	Date datetoday;
	ServerSocket server;
	Socket s;
	static int num = 1;
	static ServerThread st;
	static ArrayList<ObjectOutputStream> list = new ArrayList<ObjectOutputStream>();
	
	
	//Constructor
	public kiosk_GetScreen() {
		run();
	    
	}
	
	
	//Method
	/** 레이아웃 설정 **/
	public void run() {
		
    		/** --------내꺼-------- **/
    		setTitle("주문현황");
    		setSize(1000,800);
    		setDefaultCloseOperation(EXIT_ON_CLOSE);
    		
    		/** 레이아웃 설정 **/
    		setLayout(null);
    		layeredPane = new JLayeredPane();
    		layeredPane.setBounds(0, 0, 1439, 2000);
    		layeredPane.setLayout(null);
    		layeredPane.setBackground(new Color(226,226,226));
    		
    		/** --------왼쪽-------- **/
    		
    		/**이미지**/
    		ImageIcon img = new ImageIcon("keyosk_images/call_button.png");
    		ImageIcon img1 = new ImageIcon("keyosk_images/serch.png");
    		
    		/** 오늘날짜 **/
    		datetoday = new Date();
    		String time = format1.format(datetoday);
    		JLabel now = new JLabel(time);
    		//        top_label = new JLabel("주문현황");
    		now.setBounds(62, 50, 200, 30);
    		Font font1 = new Font("맑은 고딕",Font.BOLD,20);
    		now.setFont(font1);
    		layeredPane.add(now);
    		
    		
    		/** 주문내역**/
    		l_order = new JLabel("주문내역");
    		Font font2 = new Font("맑은 고딕",Font.BOLD,18);
    		l_order.setFont(font2);
    		l_order.setBounds(62, 125, 150, 20);
    		layeredPane.add(l_order);
    		
    		
    		line_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
  
    		grid_panel.setBounds(62, 186, 380, 380);	
    		layeredPane.add(grid_panel);
    		
    		
    		/**고객호출 라벨**/
    		l_cus_call = new JLabel("                             고객호출");
    		l_cus_call.setBounds(62,600, 500, 20);
    		Font font3 = new Font("맑은 고딕",Font.BOLD,18);
    		l_cus_call.setFont(font3);
    		layeredPane.add(l_cus_call);
    		
    		/**고객호출 버튼**/
    		b_cus_call = new JButton(img);
    		b_cus_call.setBounds(62,639,428,80);
    		b_cus_call.setBackground(Color.BLACK);
    		
    		layeredPane.add(b_cus_call);
    		
    		
    		
    		
    		/** --------오른쪽-------- **/
    		
    		/** 박 **/
    		ta_screan = new JTextArea();
    		ta_screan.setBounds(450, 50, 450, 515);
    		layeredPane.add(ta_screan);
    		
    		/** 왼쪽 **/
    		b_1 = new JButton("매출현황");
    		b_1.setFont(font2);
    		b_1.setBackground(Color.lightGray);
    		b_1.setBounds(518, 589, 180, 60);//751, 50, 636, 763
    		layeredPane.add(b_1);
    		
    		/** 중간 **/
    		b_2 = new JButton("뭐할지모름");
    		b_2.setFont(font2);
    		b_2.setBackground(Color.lightGray);
    		b_2.setBounds(738, 589, 180, 60);
    		layeredPane.add(b_2);
    		
    		/** 오른쪽 **/
    		b_3 = new JButton("종료");
    		b_3.setFont(font2);
    		b_3.setBackground(Color.lightGray);
    		b_3.setBounds(618, 689, 200, 60);
    		layeredPane.add(b_3);
    		
    		add(layeredPane);
    		setVisible(true);
        
    		serverStart();
	}
	public void serverStart() {
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
			st.oos.writeObject(num);
			num++;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}//class
