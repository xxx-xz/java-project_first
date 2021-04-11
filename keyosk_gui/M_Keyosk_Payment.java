package keyosk_gui;

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

import keyosk_system.M_Keyosk_ActionEvent;
import keyosk_vo.MenuVO;
public class M_Keyosk_Payment implements ActionListener{
	JFrame f;
	JButton payment1,cancle1;
	M_Keyosk_ActionEvent event;
	public M_Keyosk_Payment(M_Keyosk_ActionEvent event,MenuVO menu) {
		this.event = event;
		f = new JFrame("�����ϱ�");
		JPanel price_panel = new JPanel();
		JPanel btn_panel = new JPanel();
		int total_price = 0;
		payment1 = new JButton("�����ϱ�");
		cancle1 = new JButton("���");
		payment1.setBackground(Color.green);
		cancle1.setBackground(Color.red);
		
		for(MenuVO pricelist : M_Keyosk_UI.order_menu_list) {
			total_price += pricelist.getPrice();
		}

		JLabel price = new JLabel("�����ݾ� " + String.valueOf(total_price) + "��");
		Font font = new Font("���� ���",Font.BOLD,30);
		price.setFont(font);
		price_panel.add(price);
		btn_panel.add(payment1);
		btn_panel.add(cancle1);
		JTextArea jta = new JTextArea(7,20);
		JScrollPane jp = new JScrollPane(jta);
		jta.append("�޴�\t\t\t����\t\t\t����\n");
		for(MenuVO vo : M_Keyosk_UI.order_menu_list) {
			if(vo.getMenu().equals("SHANGHAI_SET") || vo.getMenu().equals("MACCHICKEN_SET") || 
					vo.getMenu().equals("DOUCHEESE_SET") || vo.getMenu().equals("EGGBULGOGI_SET") ||
					vo.getMenu().equals("CHEESEMUFFIN") || vo.getMenu().equals("FRENCHFRIES") ||
					vo.getMenu().equals("CHEESESTICK")) {
				jta.append(vo.getMenu() + "\t\t" + "1" + "\t\t\t" + vo.getPrice() + "\n");
			}else {
				jta.append(vo.getMenu() + "\t\t\t" + "1" + "\t\t\t" + vo.getPrice() + "\n");
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
			new M_Keyosk_Send(M_Keyosk_UI.order_menu_list);
			f.setVisible(false);
		}else if(obj == cancle1) {
			f.setVisible(false);
		}
		
	}
}
