package server_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kiosk_vo.MenuVO;
import server_gui.ServerThread;
import server_gui.Server_Sales;
import server_gui.Server_UI;

public class Server_ActionEvent extends MouseAdapter implements ActionListener {
	Server_UI main;
	ServerThread st;
	ArrayList<JLabel> wnumber = new ArrayList<JLabel>();
	int completenumber;
	ArrayList<JButton> jbt_list = new ArrayList<JButton>();
	
	public Server_ActionEvent() {
		
	}
	public Server_ActionEvent(Server_UI main,ServerThread st) {
		this.main = main;
		this.st = st;
	}
	
	
	//** 대기번호 라벨 이벤트 **//
	public void mouseEntered(MouseEvent e) {
		for(int i=0;i<ServerThread.wating_list.size();i++) {
			if(e.getSource() == wnumber.get(i)) {
				wnumber.get(i).setFont(new Font("맑은 고딕",Font.BOLD,22));
			}
		}
	}
	
	//** 대기번호 라벨 이벤트 **//
	public void mouseExited(MouseEvent e) {
		for(int i=0;i<ServerThread.wating_list.size();i++) {
			if(e.getSource() == wnumber.get(i)) {
				wnumber.get(i).setForeground(Color.red);
				wnumber.get(i).setFont(new Font("맑은 고딕",Font.BOLD,15));
			}
		}
	}
	//** 대기번호 라벨 이벤트 **//
	public void mouseClicked(MouseEvent e) {
		for(int i=0;i<ServerThread.wating_list.size();i++) {
			if(e.getSource() == wnumber.get(i)) {
				completenumber = Integer.parseInt(wnumber.get(i).getText().substring(0,3));
				int removenumber = ServerThread.wating_list.indexOf(completenumber);
				ServerThread.wating_list.remove(removenumber);
				wnumber.clear();
				redraw();
				Server_UI.ta_screan.setText("");
			}
		}
		Server_UI.CompleteSend(completenumber);
		
	}
	
	public void redraw_click() {
		Font font = new Font("맑은 고딕",Font.BOLD,15);
		Server_UI.grid_panel.removeAll();
		wnumber.clear();
		for(int i=0;i<ServerThread.wating_list.size();i++) {
			System.out.println("웨이팅 리스티 " + ServerThread.wating_list.get(i));
			JLabel wnum = new JLabel(String.valueOf(ServerThread.wating_list.get(i) + "번"));
			wnumber.add(wnum);
			wnumber.get(i).setForeground(Color.red);
			wnumber.get(i).setFont(font);
			
			wnumber.get(i).addMouseListener(this);
		}
		
		
		for(int i=0;i<ServerThread.wating_list.size();i++) {
			JPanel pan = new JPanel(new GridLayout(1,3));
			JLabel label = new JLabel("주문번호");
			JButton btn = new JButton(String.valueOf(ServerThread.wating_list.get(i) + "번 " + "내역"));
			
			
			btn.setBackground(Color.lightGray);
			btn.setSize(70,70);
			label.setFont(font);
			btn.setFont(font);
			
			pan.add(label);
			pan.add(wnumber.get(i));
			pan.add(btn);
			
			Server_UI.grid_panel.add(pan);
		}
		
		Server_UI.grid_panel.revalidate();
		Server_UI.grid_panel.repaint();
	}
	
	public void redraw() {
		Font font = new Font("맑은 고딕",Font.BOLD,15);
		Server_UI.grid_panel.removeAll();
		ArrayList<JButton> jbtn = null;
		
		// ** 완료된 번호를 제외한 대기번호 재생성 
		for(int i=0;i<ServerThread.wating_list.size();i++) {
			JLabel wnum = new JLabel(String.valueOf(ServerThread.wating_list.get(i) + "번"));
			wnumber.add(wnum);
			wnumber.get(i).setForeground(Color.black);
			wnumber.get(i).setFont(font);
		}
		
		
		for(int i=0;i<ServerThread.wating_list.size();i++) {
			JPanel pan = new JPanel(new GridLayout(1,3));
			JLabel label = new JLabel("주문번호");
			
			
			JButton button= new JButton(String.valueOf(ServerThread.wating_list.get(i) + "번 " + "내역"));
			jbt_list.add(button);
			
			
			button.setBackground(Color.lightGray);
			button.setSize(70,70);
			label.setFont(font);
			button.setFont(font);
			
			pan.add(label);
			pan.add(wnumber.get(i));
			pan.add(button);
			
			Server_UI.grid_panel.add(pan);
			button.addActionListener(this);
		}
		
		for(int i=0 ;i<jbt_list.size(); i++) {
			jbt_list.get(i).addActionListener(this);
		}
		
		Server_UI.grid_panel.revalidate();
		Server_UI.grid_panel.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == main.b_3) {
			main.st.sdao.exit();
			System.exit(0);
		}else if(obj == main.b_cus_call) {
			redraw_click();
		}else if(obj == main.b_1) {
			new Server_Sales(st);
		}
		// ** 호출버튼 클릭 후 다시 그렸을때 상세보기 버튼 기능
		else if(true) {
			for(int i=0; i<jbt_list.size(); i++) {
				if(obj == jbt_list.get(i)) {
					String detail_number = jbt_list.get(i).getText().substring(0,3);
					int int_detail_number = Integer.valueOf(detail_number);
					ArrayList<MenuVO> menu = new ArrayList<MenuVO>();
					menu = st.sdao.selectOrder(int_detail_number);
					
					Server_UI.ta_screan.setText("");
					Server_UI.ta_screan.append("메뉴\t\t가격\n");
					for(int j=0; j<menu.size(); j++) {
						if(menu.get(j).getMenu_kor().equals("더블치즈버거-세트") || menu.get(j).getMenu_kor().equals("에그불고기버거-세트")
								|| menu.get(j).getMenu_kor().equals("맥치킨버거-세트")) {
							Server_UI.ta_screan.append(menu.get(j).getMenu_kor() + "\t" + menu.get(j).getPrice() + "\n");
						}else {
							Server_UI.ta_screan.append(menu.get(j).getMenu_kor() + "\t\t" + menu.get(j).getPrice() + "\n");
						}
					}
					
				}
			}
		}
		
	}
}
