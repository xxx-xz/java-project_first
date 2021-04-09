package keyosk_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import keyosk_system.M_Keyosk_ActionEvent;
import keyosk_vo.MenuVO;

public class M_Keyosk_UI{
	Frame f;
	Panel top_ad_panel, menu_btn_panel, menu_image_panel, page_panel, bottom_panel,menu_image;
	public JButton set,single,side, beverage, previous,next,payment,cancle;
	public JButton bigmag_set_button,doucheese_set_button,bulgogi_set_button,shanghai_set_button,magchicken_set_button,eggbulgogi_set_button,
	cheese_set_button,susu_set_button,subi_set_button,nothing_button,bigmag_button,bulgogi_button,shanghai_button,magchicken_button,
	doucheese_button,eggbulgogi_button,cheese_button,susu_button,subi_button;
	JLabel count,price;
	public JButton applepie_button,cheesestick_button,eggmuffin_button,frenchfries_button,hotcake_button,icecream_button,macnugget_button,
	coke_button,cider_button,cheesemuffin_button;
	ImageIcon bigmag_set_image,bulgogi_set_image,shanghai_set_image,doucheese_set_image,magchicken_set_image,eggbulgogi_set_image,
	cheese_set_image,susu_set_image,subi_set_image,nothing_imgae,bigmag_single_image,bulgogi_single_image,
	shanghai_single_image,doucheese_single_image,macchicken_single_image,eggbulgogi_single_image,cheese_single_image,
	susu_single_image,subi_single_image;
	ImageIcon applepie,cheesestick,eggmuffin,frenchfries,hotcake,icecream,macnugget,coke,cider,cheesemuffin;
	public JTextArea order_menu;
	JScrollPane pane;
	M_Keyosk_ActionEvent event = new M_Keyosk_ActionEvent(this);
	public static ArrayList<MenuVO> order_menu_list = new ArrayList<MenuVO>();
	public static int page_check = 1;
	
	public M_Keyosk_UI() {
		init();
	}
	
	public void init() {
		f = new Frame("MacKeyosk");
		top_ad_panel = new Panel();
		menu_btn_panel = new Panel(new GridLayout(4,1));
		menu_image_panel = new Panel();
		menu_image_panel.setLayout(new GridBagLayout());
		page_panel = new Panel();
		bottom_panel = new Panel(new GridLayout(2,2));
		new M_Keyosk_image_create(this);
		
		set = new JButton("세트메뉴");
		single = new JButton("단품");
		side = new JButton("사이드");
		beverage = new JButton("음료");
		previous = new JButton("이전");
		next = new JButton("다음");
		payment = new JButton("결제하기");
		cancle = new JButton("주문취소");
		order_menu = new JTextArea(7,20);
		pane = new JScrollPane(order_menu);
		order_menu.setBackground(Color.white);
		order_menu.append("메뉴\t\t\t\t\t수량\t\t\t\t\t금액\n");
		
		count = new JLabel("주문수량");
		price = new JLabel("주문금액");
		
		set.setBackground(Color.orange);
		single.setBackground(Color.orange);
		side.setBackground(Color.orange);
		beverage.setBackground(Color.orange);
		
		previous.setBackground(Color.white);
		next.setBackground(Color.white);
		payment.setBackground(Color.green);
		cancle.setBackground(Color.red);
		
		
		menu_btn_panel.add(set);
		menu_btn_panel.add(single);
		menu_btn_panel.add(side);
		menu_btn_panel.add(beverage);
		
		
		page_panel.add(BorderLayout.WEST,previous);
		page_panel.add(BorderLayout.EAST,next);
		bottom_panel.setLayout(new GridLayout(1,2));
		bottom_panel.add(cancle);
		bottom_panel.add(payment);
		
		
		
		new M_Keyosk_Set_Menu_Image_FirstUI(this);
		
		f.setLayout(new BorderLayout());
		f.add(BorderLayout.NORTH,top_ad_panel);
		f.add(BorderLayout.CENTER,center_panel());
		f.add(BorderLayout.SOUTH,bottom_panel());
		
		f.setSize(1000,830);
		f.setVisible(true);
		
		top_ad_panel.setBackground(new Color(225,0,0));
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		next.addActionListener(event);
		previous.addActionListener(event);
		set.addActionListener(event);
		single.addActionListener(event);
		side.addActionListener(event);
		beverage.addActionListener(event);
		payment.addActionListener(event);
		cancle.addActionListener(event);
	
	}
	

//	public Panel top_panel() {
//		Panel top_panel = new Panel(new BorderLayout());
//		top_panel.add(BorderLayout.NORTH,top_ad_panel);
//		top_panel.add(BorderLayout.CENTER,menu_btn_panel);
//		return top_panel;
//	}
	
	public Panel center_panel() {
		Panel center_panel = new Panel(new BorderLayout());
		center_panel.add(BorderLayout.WEST,menu_btn_panel);
		center_panel.add(BorderLayout.CENTER,menu_image_panel);
		return center_panel;
	}
	
	public Panel bottom_panel() {
		Panel bottom_panel_1 = new Panel(new BorderLayout());
		bottom_panel_1.add(BorderLayout.NORTH,page_panel);
		bottom_panel_1.add(BorderLayout.CENTER,pane);
		bottom_panel_1.add(BorderLayout.SOUTH,bottom_panel);
		return bottom_panel_1;
	}
	
	public void switch_panel() {
		menu_image_panel.removeAll();
//		menu_image.setVisible(false);
		menu_image.setVisible(true);
		
	

	}


}
