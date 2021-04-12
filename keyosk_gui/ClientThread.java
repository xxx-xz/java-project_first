package keyosk_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClientThread extends Thread implements ActionListener{
	ObjectInputStream ois;
	ObjectOutputStream oos;
	int watingnumber;
	JButton reset;
	JFrame jf;
	
	public ClientThread (M_Keyosk_Send send) {
		ois = send.ois;
		oos = send.oos;
		watingnumber = send.watingnumber;
		
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				System.out.println("Client Thread run 메소드 실행");
				
				watingnumber = (int)ois.readObject();
				System.out.println("Thread에서 Watingnumber 읽어옴");
				init();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void init() {
		String number = watingnumber + "번";
		System.out.println(number);
		jf = new JFrame("결제완료");
		JPanel jp = new JPanel(new BorderLayout());
		JLabel jl = new JLabel("           결제완료");
		JLabel wating = new JLabel("  대기번호 " +number);
		reset = new JButton("초기화면으로");
		Font font = new Font("맑은 고딕",Font.BOLD,15);
		reset.setFont(font);
		reset.setBackground(Color.white);
		
		Font font1 = new Font("맑은 고딕",Font.BOLD,30);
		Font font2 = new Font("맑은 고딕",Font.BOLD,50);
		
		jl.setFont(font1);
		wating.setFont(font2);
		jp.add(BorderLayout.NORTH,jl);
		jp.add(BorderLayout.CENTER,wating);
		jp.add(BorderLayout.SOUTH,reset);
		
		jf.add(jp);
		
		jf.setSize(400,300);
		jf.setLocation(500,300);
		jf.setVisible(true);
		
		reset.addActionListener(this);
		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				jf.setVisible(false);
				M_Keyosk_UI.order_menu_list.clear();
				M_Keyosk_UI.order_menu.setText("");
				M_Keyosk_UI.order_menu.append("메뉴\t\t\t\t\t수량\t\t\t\t\t금액\n");
			}
		});
//		try {
//			M_Keyosk_Send.s.close();
//		} catch (Exception e) {
//			System.out.println("socket Close 에러");
//			e.printStackTrace();
//		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == reset) {
			jf.setVisible(false);
			M_Keyosk_UI.order_menu_list.clear();
			M_Keyosk_UI.order_menu.setText("");
			M_Keyosk_UI.order_menu.append("메뉴\t\t\t\t\t수량\t\t\t\t\t금액\n");
		}
		
	}
	
}
