package client_kiosk_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import client_kiosk_system.Client_ActionEvent;
import kiosk_vo.MenuVO;
public class Client_Payment implements ActionListener{
	JFrame f;
	JButton payment1,cancle1;
	Client_ActionEvent event;
	public Client_Payment(Client_ActionEvent event,MenuVO menu) {
		this.event = event;
		f = new JFrame("결제하기");
		JPanel price_panel = new JPanel();
		JPanel btn_panel = new JPanel();
		int total_price = 0;
		payment1 = new JButton("결제하기");
		cancle1 = new JButton("취소");
		payment1.setBackground(new Color(0,170,0));
		cancle1.setBackground(Color.red);
		
		for(MenuVO pricelist : Client_UI.order_menu_list) {
			total_price += pricelist.getPrice();
		}

		JLabel price = new JLabel("총 금액 " + String.valueOf(total_price) + "원");
		Font font = new Font("맑은 고딕",Font.BOLD,30);
		Font jta_font = new Font("맑은 고딕",Font.BOLD,13);
		price.setFont(font);
		price_panel.add(price);
		btn_panel.add(payment1);
		btn_panel.add(cancle1);
		JTextArea jta = new JTextArea(7,20);
		JScrollPane jp = new JScrollPane(jta);
		jta.setFont(jta_font);
		jta.append("메뉴\t\t수량\t\t가격\n");
		for(MenuVO vo : Client_UI.order_menu_list) {
			if(vo.getMenu().equals("DOUCHEESE_SET") || vo.getMenu().equals("EGGBULGOGI_SET")) {
				jta.append(vo.getMenu_kor() + "\t" + "1" + "\t\t" + vo.getPrice() + "\n");
			}else {
				jta.append(vo.getMenu_kor() + "\t\t" + "1" + "\t\t" + vo.getPrice() + "\n");
			}
		}
		payment1.addActionListener(this);
		cancle1.addActionListener(this);
		
		f.add(BorderLayout.NORTH,jp);
		f.add(BorderLayout.CENTER,price_panel);
		f.add(BorderLayout.SOUTH,btn_panel);
		
		
		f.setSize(600,300);
		f.setLocation(200,300);
		f.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == payment1) {
			new Client_Send(Client_UI.order_menu_list);
			f.setVisible(false);
		}else if(obj == cancle1) {
			f.setVisible(false);
		}
		
	}
}
