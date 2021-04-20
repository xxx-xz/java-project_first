package client_kiosk_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class LHS_ClientCall extends JFrame{
	//Field
	JFrame f;
    JPanel line_panel, panel;
    static JPanel complete, preparing; 
    static ObjectInputStream ois;
    static ObjectOutputStream oos;
    static Socket s;
    
    
    public static void main(String[] args) {
    	new LHS_ClientCall();
    }
	//Constructor
	public LHS_ClientCall() {
		try {
			System.out.println("연결 시도...");
			s = new Socket("127.0.0.1",5555);
			System.out.println("연결 성공");
			oos = new ObjectOutputStream(s.getOutputStream());
			ois = new ObjectInputStream(s.getInputStream());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		init();
		System.out.println("init()실행");
		
	}
	
	//Method
	public void init() {
		f = new JFrame();
		Panel label_panel = new Panel(new GridLayout(1,0,0,0));
		Panel tf_panel = new Panel(new GridLayout(1,1,1,1));
		Panel btn_panel = new Panel();
		
				
		////////////////////////////////////LABEL
		JLabel wait_label = new JLabel();
		wait_label.setText("<html>     &nbsp;&nbsp;&nbsp;&nbsp; 제품을<br>준비중입니다.</html>");
		JLabel call_label = new JLabel("");
		call_label.setText("<html>   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;주문하신<br>제품이 나왔습니다.</html>");
		Font font = new Font("맑은 고딕",Font.BOLD,15);
		wait_label.setFont(font);
		call_label.setFont(font);
		
		wait_label.setHorizontalAlignment(JLabel.CENTER);
		call_label.setHorizontalAlignment(JLabel.CENTER);
		label_panel.add(wait_label); 
		label_panel.add(call_label); 
		 
		f.add(BorderLayout.NORTH, label_panel);
        ////////////////////////////////////////////////////////////////////////////////// 
        ///////////////////////////////////PANEL
        complete = new JPanel(new GridLayout(5,1));
         

        preparing = new JPanel(new GridLayout(5,1));
         
        tf_panel.add(preparing); 
        tf_panel.add(complete);
        f.add(tf_panel);
        
         
        
		f.setSize(500, 500);
		f.setVisible(true);
		
		ClientCallThread cct = new ClientCallThread();
		cct.start();
		
	}

	static class ClientCallThread extends Thread {
		
		@Override
		public void run() {
			try {
				while(true) {
					System.out.println("while문 실행");
					int watingnumber = (int)ois.readObject();
					Panel wpanel = new Panel();
					JLabel watinglab = new JLabel(String.valueOf(watingnumber));
					System.out.println(watingnumber);
					wpanel.add(watinglab);
					preparing.add(wpanel);
					System.out.println("while문 1사이클 종료");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}