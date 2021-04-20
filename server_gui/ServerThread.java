package server_gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import client_kiosk_vo.MenuVO;
import server_kiosk_dao.M_Kiosk_Server_DAO;
import server_system.Server_ActionEvent;

public class ServerThread extends Thread implements ActionListener{
	ObjectOutputStream oos;
	ObjectInputStream ois;
	JButton detail;
	public static JPanel pp;
	public static JLabel wnumber; 
	public static M_Kiosk_Server_DAO sdao = new M_Kiosk_Server_DAO();;
	public ArrayList<MenuVO> detail_order = new ArrayList<MenuVO>();
	public static ArrayList<Integer> wating_list = new ArrayList<Integer>();
	
	Server_ActionEvent sa = new Server_ActionEvent();
	public ServerThread(Socket s) {
		try {
			ois = new ObjectInputStream(s.getInputStream());
			oos= new ObjectOutputStream(s.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				System.out.println("ServerThread 시작");
				ArrayList<MenuVO> menu =(ArrayList<MenuVO>)ois.readObject();
				Server_UI.Casting();
				
				// ** DB에 주문내역과 대기번호 Insert **
				sdao.insertorder(menu,Server_UI.num-1);
				
				// ** 서버 메인화면에 주문번호 출력 **
				Font font1 = new Font("맑은 고딕",Font.BOLD,15);
				pp = new JPanel(new GridLayout(1,3));
				JLabel lab = new JLabel("주문번호");
				wnumber = new JLabel(String.valueOf(Server_UI.num-1) + "번");
				wating_list.add(Server_UI.num-1);
				detail = new JButton(String.valueOf(Server_UI.num-1) + "번 상세보기");
				lab.setFont(font1);
				wnumber.setFont(font1);
				wnumber.setBackground(Color.red);
				detail.setFont(font1);
				detail.setBackground(Color.lightGray);
				detail.setSize(100,70);
				
				pp.add(lab);
				pp.add(wnumber);
				pp.add(detail);
				
				Server_UI.grid_panel.add(pp);
				Server_UI.grid_panel.revalidate();
				Server_UI.grid_panel.repaint();
				
				detail.addActionListener(this);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// ** 상세보기 버튼 클릭시 우측에 메뉴 출력
		if(e.getSource() == detail) {
			String detail_number = detail.getText().substring(0,1);
			int int_detail_number = Integer.valueOf(detail_number);
			detail_order = sdao.selectOrder(int_detail_number);
			
			Server_UI.ta_screan.setText("");
			Server_UI.ta_screan.append("메뉴\t\t가격\n");
			for(int i=0; i<detail_order.size(); i++) {
				if(detail_order.get(i).getMenu_kor().equals("더블치즈버거-세트") || detail_order.get(i).getMenu_kor().equals("에그불고기버거-세트")
					|| detail_order.get(i).getMenu_kor().equals("맥치킨버거-세트")) {
					Server_UI.ta_screan.append(detail_order.get(i).getMenu_kor() + "\t" + detail_order.get(i).getPrice() + "\n");
				}else {
					Server_UI.ta_screan.append(detail_order.get(i).getMenu_kor() + "\t\t" + detail_order.get(i).getPrice() + "\n");
				}
			}
		}
		
	}
}
