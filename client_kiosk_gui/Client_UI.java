package client_kiosk_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import client_kiosk_system.Client_ActionEvent;
import kiosk_vo.MenuVO;

public class Client_UI implements ActionListener{
	Frame f;
	Panel top_ad_panel, menu_btn_panel, menu_image_panel, page_panel, bottom_panel,menu_image;
	public JButton set,single,side, beverage, previous,next,payment,cancle;
	JButton bigmag_set_button,doucheese_set_button,bulgogi_set_button,shanghai_set_button,magchicken_set_button,eggbulgogi_set_button,
	cheese_set_button,susu_set_button,subi_set_button,nothing_button,bigmag_button,bulgogi_button,shanghai_button,magchicken_button,
	doucheese_button,eggbulgogi_button,cheese_button,susu_button,subi_button;
	JLabel count,price;
	JButton applepie_button,cheesestick_button,eggmuffin_button,frenchfries_button,hotcake_button,icecream_button,macnugget_button,
	coke_button,cider_button,cheesemuffin_button;
	public static JTextArea order_menu;
	JScrollPane pane;
	Client_ActionEvent event = new Client_ActionEvent(this);
	public static ArrayList<MenuVO> order_menu_list = new ArrayList<MenuVO>();
	ArrayList<JButton> btn_list = new ArrayList<JButton>();
	public static ArrayList<JButton> menu_list = new ArrayList<JButton>();
	int page_check = 1;
	
	public Client_UI() {
		init();
	}
	
	public void init() {
		f = new Frame("MacKeyosk");
		top_ad_panel = new Panel();
		menu_btn_panel = new Panel(new GridLayout(4,1,0,5));
		menu_image_panel = new Panel();
		menu_image_panel.setLayout(new GridBagLayout());
		page_panel = new Panel();
		bottom_panel = new Panel(new GridLayout(2,2));
		ImageIcon top_image = new ImageIcon("keyosk_images/top_logo.PNG");
		
		
		//��Ʈ�޴� �̹���
		ImageIcon bigmag_set_image = new ImageIcon("keyosk_images\\bigmac_set.PNG");
		ImageIcon bulgogi_set_image = new ImageIcon("keyosk_images\\bulgogi_set.PNG");
		ImageIcon shanghai_set_image = new ImageIcon("keyosk_images\\shanghai_set.PNG");
		ImageIcon doucheese_set_image = new ImageIcon("keyosk_images/doucheese_set.PNG");
		ImageIcon magchicken_set_image = new ImageIcon("keyosk_images/macchicken_set.PNG");
		ImageIcon eggbulgogi_set_image = new ImageIcon("keyosk_images/eggbulgogi_set.PNG");
		ImageIcon cheese_set_image = new ImageIcon("keyosk_images/cheese_set.PNG");
		ImageIcon susu_set_image = new ImageIcon("keyosk_images/susu_set.PNG");
		ImageIcon subi_set_image = new ImageIcon("keyosk_images/subi_set.PNG");
		ImageIcon nothing_imgae = new ImageIcon("keyosk_images/Inkednothing.jpg");
		//��ǰ �̹���
		ImageIcon bigmag_single_image = new ImageIcon("keyosk_images/bigmac.PNG");
		ImageIcon bulgogi_single_image = new ImageIcon("keyosk_images/bulgogi.PNG");
		ImageIcon shanghai_single_image = new ImageIcon("keyosk_images/shanghai.PNG");
		ImageIcon doucheese_single_image = new ImageIcon("keyosk_images/doucheese.PNG");
		ImageIcon macchicken_single_image = new ImageIcon("keyosk_images/macchicken.PNG");
		ImageIcon eggbulgogi_single_image = new ImageIcon("keyosk_images/eggbulgogi.PNG");
		ImageIcon cheese_single_image = new ImageIcon("keyosk_images/cheese.PNG");
		ImageIcon susu_single_image = new ImageIcon("keyosk_images/susu.PNG");
		ImageIcon subi_single_image = new ImageIcon("keyosk_images/subi.PNG");
		
		//���̵� �̹���
		ImageIcon applepie = new ImageIcon("keyosk_images/applepie.PNG");
		ImageIcon cheesestick = new ImageIcon("keyosk_images/cheesestick.PNG");
		ImageIcon eggmuffin = new ImageIcon("keyosk_images/eggmuffin.PNG");
		ImageIcon frenchfries = new ImageIcon("keyosk_images/frenchfries.PNG");
		ImageIcon hotcake = new ImageIcon("keyosk_images/hotcake.png");
		ImageIcon icecream = new ImageIcon("keyosk_images/icecream.PNG");
		ImageIcon macnugget = new ImageIcon("keyosk_images/macnugget.PNG");
		ImageIcon cheesemuffin = new ImageIcon("keyosk_images/cheesemuffin.PNG");
		//���� �̹���
		ImageIcon coke = new ImageIcon("keyosk_images/coke.PNG");
		ImageIcon cider = new ImageIcon("keyosk_images/cider.PNG");
		
		ImageIcon[] menu_images = {bigmag_set_image,bulgogi_set_image,shanghai_set_image,doucheese_set_image,magchicken_set_image,eggbulgogi_set_image,
				cheese_set_image,susu_set_image,subi_set_image,bigmag_single_image,bulgogi_single_image,
				shanghai_single_image,doucheese_single_image,macchicken_single_image,eggbulgogi_single_image,cheese_single_image,
				susu_single_image,subi_single_image,applepie,cheesestick,eggmuffin,frenchfries,hotcake,icecream,macnugget,cheesemuffin,coke,cider};
		
		for(int i=0;i<menu_images.length;i++) {
			JButton btn = new JButton();
			btn.setIcon(menu_images[i]);
			btn.setBorderPainted(false); btn.setFocusPainted(false); btn.setContentAreaFilled(false);
			btn.setBackground(Color.white);
			menu_list.add(btn);
			btn.addActionListener(event);
			
		}
		//��ư �̹���
		ImageIcon set_image = new ImageIcon("keyosk_images/set_image.png");
		ImageIcon single_image = new ImageIcon("keyosk_images/single_image.png");
		ImageIcon side_image = new ImageIcon("keyosk_images/side_image.png");
		ImageIcon beverage_image = new ImageIcon("keyosk_images/beverage_image.png");
		
		ImageIcon[] btn_image = {set_image,single_image,side_image,beverage_image};
		
		JLabel top_ad_label = new JLabel(top_image);
		top_ad_panel.add(top_ad_label);
		
		
		button_create();
		
//		set = new JButton(set_image);
//		single = new JButton(single_image);
//		side = new JButton(side_image);
//		beverage = new JButton(beverage_image);
//		set.setBackground(Color.white);
//		single.setBackground(Color.white);
//		side.setBackground(Color.white);
//		beverage.setBackground(Color.white);
//		
//		set.setBorderPainted(false); set.setFocusPainted(false); set.setContentAreaFilled(false);

//		String[] btn_list1 = {"set1","single1","side1","beverage1"};
		for(int i=0; i<btn_image.length;i++) {
			JButton btn = new JButton();
			btn.setIcon(btn_image[i]);
			btn.setBorderPainted(false); btn.setFocusPainted(false); btn.setContentAreaFilled(false);
			btn.setBackground(Color.white);
			btn_list.add(btn);
			btn.addActionListener(this);
			menu_btn_panel.add(btn);
		}
		
		
		previous = new JButton("이전");
		next = new JButton("다음");
		payment = new JButton("결제하기");
		cancle = new JButton("주문취소");
		order_menu = new JTextArea(7,20);
		pane = new JScrollPane(order_menu);
		
		Font font = new Font("맑은 고딕",Font.BOLD, 13);
//		Font font1 = new Font("���� ���",Font.BOLD, 25);
		
//		set.setFont(font);
//		single.setFont(font);
//		side.setFont(font);
//		beverage.setFont(font);
		previous.setFont(font);
		next.setFont(font);
		payment.setFont(font);
		cancle.setFont(font);
		order_menu.setFont(font);
		order_menu.append("메뉴\t\t\t\t수량\t\t\t\t가격\n");
		
		count = new JLabel("주문수량");
		price = new JLabel("주문금액");
		
//		set.setBackground(Color.orange);
//		single.setBackground(Color.orange);
//		side.setBackground(Color.orange);
//		beverage.setBackground(Color.orange);
		
		previous.setBackground(Color.white);
		next.setBackground(Color.white);
		payment.setBackground(new Color(0,170,0));
		cancle.setBackground(Color.red);
		
		
//		menu_btn_panel.add(set);
//		menu_btn_panel.add(single);
//		menu_btn_panel.add(side);
//		menu_btn_panel.add(beverage);
		
		
		page_panel.add(BorderLayout.WEST,previous);
		page_panel.add(BorderLayout.EAST,next);
		bottom_panel.setLayout(new GridLayout(1,2));
		bottom_panel.add(cancle);
		bottom_panel.add(payment);
		
		set_First_UI();
		
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
		
//		set.addActionListener(this);
//		single.addActionListener(this);
//		side.addActionListener(this);
//		beverage.addActionListener(this);
		next.addActionListener(this);
		previous.addActionListener(this);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn_list.get(0)) {
			set_First_UI();
		}else if(obj == btn_list.get(1)) {
			single_First_UI();
		}else if(obj == btn_list.get(2)) {
			side_First_UI();
		}else if(obj == btn_list.get(3)) {
			bevarage_UI();
		}else if(obj == next) {
			if(page_check == 1) {
				set_Second_UI();
			}else if(page_check == 2) {
				single_Second_UI();
			}else if(page_check == 3) {
				side_Second_UI();
			}else if(page_check == 4) {
				bevarage_UI();
			}
		}else if(obj == previous) {
			if(page_check == 1) {
				set_First_UI();
			}else if(page_check == 2) {
				single_First_UI();
			}else if(page_check == 3) {
				side_First_UI();
			}
		}
		
	}
	
	public void set_First_UI(){
		page_check = 1;
		menu_image = new Panel(new GridLayout(2,3,50,10));
		switch_panel();
		
		for(int i=0;i<6;i++) {
			menu_image.add(menu_list.get(i));
		}
		
		menu_image_panel.add(menu_image);
		f.setVisible(true);
	}
	
	public void set_Second_UI() {
		page_check = 1;
		switch_panel();
		menu_image = new Panel(new GridLayout(1,3,50,30));
		
		for(int i=6;i<9;i++) {
			menu_image.add(menu_list.get(i));
		}

		menu_image_panel.add(menu_image);
		f.setVisible(true);
	}
	
	public void single_First_UI() {
		page_check = 2;
		switch_panel();
		menu_image = new Panel(new GridLayout(2,3,50,10));
		
		for(int i=9;i<15;i++) {
			menu_image.add(menu_list.get(i));
		}
		
		menu_image_panel.add(menu_image);
		f.setVisible(true);
		
	}
	
	public void single_Second_UI() {
		page_check = 2;
		switch_panel();
		menu_image = new Panel(new GridLayout(1,3,50,30));
		
		for(int i=15;i<18;i++) {
			menu_image.add(menu_list.get(i));
		}
		
		
		menu_image_panel.add(menu_image);
		f.setVisible(true);
	}
	
	public void side_First_UI() {
		page_check = 3;
		switch_panel();
		menu_image = new Panel(new GridLayout(2,3,50,10));
		
		for(int i=18;i<24;i++) {
			menu_image.add(menu_list.get(i));
		}
		
		menu_image_panel.add(menu_image);
		f.setVisible(true);
		
	}
	
	public void side_Second_UI() {
		page_check = 3;
		switch_panel();
		menu_image = new Panel(new GridLayout(1,2,50,30));
		
		for(int i=24;i<26;i++) {
			menu_image.add(menu_list.get(i));
		}
		
		menu_image_panel.add(menu_image);
		f.setVisible(true);
		
	}
	
	public void bevarage_UI() {
		page_check = 4;
		switch_panel();
		menu_image = new Panel(new GridLayout(1,2,50,10));
		
		for(int i=26;i<28;i++) {
			menu_image.add(menu_list.get(i));
		}
		
		menu_image_panel.add(menu_image);
		f.setVisible(true);
		
	}
	
	public void button_create() {
//		bigmag_set_button = new JButton(bigmag_set_image);
//		bigmag_set_button.addActionListener(event);
//		bigmag_set_button.setBackground(Color.white);
//		bulgogi_set_button = new JButton(bulgogi_set_image);
//		bulgogi_set_button.addActionListener(event);
//		bulgogi_set_button.setBackground(Color.white);
//		shanghai_set_button = new JButton(shanghai_set_image);
//		shanghai_set_button.addActionListener(event);
//		shanghai_set_button.setBackground(Color.white);
//		doucheese_set_button = new JButton(doucheese_set_image);
//		doucheese_set_button.addActionListener(event);
//		doucheese_set_button.setBackground(Color.white);
//		magchicken_set_button = new JButton(magchicken_set_image);
//		magchicken_set_button.addActionListener(event);
//		magchicken_set_button.setBackground(Color.white);
//		eggbulgogi_set_button = new JButton(eggbulgogi_set_image);
//		eggbulgogi_set_button.addActionListener(event);
//		eggbulgogi_set_button.setBackground(Color.white);
//		cheese_set_button = new JButton(cheese_set_image);
//		cheese_set_button.addActionListener(event);
//		cheese_set_button.setBackground(Color.white);
//		susu_set_button = new JButton(susu_set_image);
//		susu_set_button.addActionListener(event);
//		susu_set_button.setBackground(Color.white);
//		subi_set_button = new JButton(subi_set_image);
//		subi_set_button.addActionListener(event);
//		subi_set_button.setBackground(Color.white);
//		nothing_button = new JButton(nothing_imgae);
//		//��ǰ�̹�����ư
//		bigmag_button = new JButton(bigmag_single_image);
//		bigmag_button.addActionListener(event);
//		bigmag_button.setBackground(Color.white);
//		bulgogi_button = new JButton(bulgogi_single_image);
//		bulgogi_button.addActionListener(event);
//		bulgogi_button.setBackground(Color.white);
//		shanghai_button = new JButton(shanghai_single_image);
//		shanghai_button.addActionListener(event);
//		shanghai_button.setBackground(Color.white);
//		doucheese_button = new JButton(doucheese_single_image);
//		doucheese_button.addActionListener(event);
//		doucheese_button.setBackground(Color.white);
//		magchicken_button = new JButton(macchicken_single_image);
//		magchicken_button.addActionListener(event);
//		magchicken_button.setBackground(Color.white);
//		eggbulgogi_button = new JButton(eggbulgogi_single_image);
//		eggbulgogi_button.addActionListener(event);
//		eggbulgogi_button.setBackground(Color.white);
//		cheese_button = new JButton(cheese_single_image);
//		cheese_button.addActionListener(event);
//		cheese_button.setBackground(Color.white);
//		susu_button = new JButton(susu_single_image);
//		susu_button.addActionListener(event);
//		susu_button.setBackground(Color.white);
//		subi_button = new JButton(subi_single_image);
//		subi_button.addActionListener(event);
//		subi_button.setBackground(Color.white);
//		//���̵��̹�����ư
//		applepie_button = new JButton(applepie);
//		applepie_button.addActionListener(event);
//		applepie_button.setBackground(Color.white);
//		cheesestick_button = new JButton(cheesestick);
//		cheesestick_button.addActionListener(event);
//		cheesestick_button.setBackground(Color.white);
//		eggmuffin_button = new JButton(eggmuffin);
//		eggmuffin_button.addActionListener(event);
//		eggmuffin_button.setBackground(Color.white);
//		frenchfries_button = new JButton(frenchfries);
//		frenchfries_button.addActionListener(event);
//		frenchfries_button.setBackground(Color.white);
//		hotcake_button = new JButton(hotcake);
//		hotcake_button.addActionListener(event);
//		hotcake_button.setBackground(Color.white);
//		icecream_button = new JButton(icecream);
//		icecream_button.addActionListener(event);
//		icecream_button.setBackground(Color.white);
//		macnugget_button = new JButton(macnugget);
//		macnugget_button.addActionListener(event);
//		macnugget_button.setBackground(Color.white);
//		cheesemuffin_button = new JButton(cheesemuffin);
//		cheesemuffin_button.addActionListener(event);
//		cheesemuffin_button.setBackground(Color.white);
//		//�����̹�����ư
//		coke_button = new JButton(coke);
//		coke_button.addActionListener(event);
//		coke_button.setBackground(Color.white);
//		cider_button = new JButton(cider);
//		cider_button.addActionListener(event);
//		cider_button.setBackground(Color.white);
	}


}
