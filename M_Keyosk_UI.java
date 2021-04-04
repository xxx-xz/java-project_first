package jh_keyosk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class M_Keyosk_UI implements ActionListener{
	Frame f;
	Panel top_ad_panel, menu_btn_panel, menu_image_panel, page_panel, bottom_panel,menu_image;
	JButton set,single,side, beverage, previous,next,payment,cancle;
	JLabel count,price,doucheese_set_label,bigmag_set_label,bulgogi_set_label,shanghai_set_label,magchicken_set_label,eggbulgogi_set_label,
	cheese_set_label,susu_set_label,subi_set_label,nothing_label;
	ImageIcon bigmag_set_image,bulgogi_set_image,shanghai_set_image,doucheese_set_image,magchicken_set_image,eggbulgogi_set_image,
	cheese_set_image,susu_set_image,subi_set_image,nothing_imgae;
	JTextArea order_menu;
	 
	String[] set_image_label = {"bigmag_set","bulgogi_set","shanghai_set","doucheese_set","amgchicken_set","eggbulgogi_set"
			,"cheese_set","susu_set","subi_set"};
	public static final int SET_MENU_FIRST = 1;
	public static final int SET_MENU_TWO = 2;
	public static final int SINGLE_MENU = 3;
	public static final int SIDE_MENU = 4;
	public static final int BEVERAGE_MENU = 5;
	
	public M_Keyosk_UI() {
		init();
	}
	
	public void init() {
		f = new Frame("MacKeyosk");
		top_ad_panel = new Panel();
		menu_btn_panel = new Panel(new GridLayout(1,4));
		menu_image_panel = new Panel();
		menu_image_panel.setLayout(new GridBagLayout());
		page_panel = new Panel();
		bottom_panel = new Panel(new GridLayout(2,2));
		
		set = new JButton("세트메뉴");
		single = new JButton("단품");
		side = new JButton("사이드");
		beverage = new JButton("음료");
		previous = new JButton("이전");
		next = new JButton("다음");
		payment = new JButton("결제하기");
		cancle = new JButton("주문취소");
		order_menu = new JTextArea(7,20);
		order_menu.setBackground(Color.blue);
		
		count = new JLabel("주문수량");
		price = new JLabel("주문금액");
		
		set.setBackground(Color.LIGHT_GRAY);
		single.setBackground(Color.LIGHT_GRAY);
		side.setBackground(Color.LIGHT_GRAY);
		beverage.setBackground(Color.LIGHT_GRAY);
		
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
		bottom_panel.setLayout(new GridLayout(1,2,300,0));
		bottom_panel.add(cancle);
		bottom_panel.add(payment);
		
		ImageIcon top_image = new ImageIcon("jh_keyosk.image/top_panel_image.PNG");
		bigmag_set_image = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/bigmac_set.PNG");
		bulgogi_set_image = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/bulgogi_set.PNG");
		shanghai_set_image = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/shanghai_set.PNG");
		doucheese_set_image = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/doucheese_set.PNG");
		magchicken_set_image = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/macchicken_set.PNG");
		eggbulgogi_set_image = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/eggbulgogi_set.PNG");
		cheese_set_image = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/cheese_set.PNG");
		susu_set_image = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/susu_set.PNG");
		subi_set_image = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/subi_set.PNG");
		nothing_imgae = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/Inkednothing.jpg");
		
		//top_ad, set_image 크기 조절
		Image top_img = top_image.getImage();
		Image top_img_change = top_img.getScaledInstance(800, 150, Image.SCALE_SMOOTH);
		ImageIcon top_image_change = new ImageIcon(top_img_change);
		JLabel top_ad_label = new JLabel(top_image_change);
		top_ad_panel.add(top_ad_label);
		
		Image bigmag_set_img = bigmag_set_image.getImage();
		Image bigmag_set_changeimg = bigmag_set_img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon bigmag_set_image_change = new ImageIcon(bigmag_set_changeimg);
		
		Image bulgogi_set_img = bulgogi_set_image.getImage();
		Image bulgogi_set_changeimg = bulgogi_set_img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon bulgogi_set_image_change = new ImageIcon(bulgogi_set_changeimg);
		
		Image shanghai_set_img = shanghai_set_image.getImage();
		Image shanghai_set_changeimg = shanghai_set_img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon shanghai_set_image_change = new ImageIcon(shanghai_set_changeimg);
		
		Image doucheese_set_img = doucheese_set_image.getImage();
		Image doucheese_set_changeimg = doucheese_set_img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon doucheese_set_image_change = new ImageIcon(doucheese_set_changeimg);
		
		Image magchiken_set_img = magchicken_set_image.getImage();
		Image magchiken_set_changeimg = magchiken_set_img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon magchiken_set_image_change = new ImageIcon(magchiken_set_changeimg);
		
		Image eggbulgogi_set_img = eggbulgogi_set_image.getImage();
		Image eggbulgogi_set_changeimg = eggbulgogi_set_img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon eggbulgogi_set_image_change = new ImageIcon(eggbulgogi_set_changeimg);
		
		Image cheese_set_img = cheese_set_image.getImage();
		Image cheese_set_changeimg = cheese_set_img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon cheese_set_image_change = new ImageIcon(cheese_set_changeimg);
		
		Image susu_set_img = susu_set_image.getImage();
		Image susu_set_changeimg = susu_set_img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon susu_set_image_change = new ImageIcon(susu_set_changeimg);
		
		Image subi_set_img = subi_set_image.getImage();
		Image subi_set_changeimg = subi_set_img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon subi_set_image_change = new ImageIcon(subi_set_changeimg);
		
		
		bigmag_set_label = new JLabel(bigmag_set_image_change);
		bulgogi_set_label = new JLabel(bulgogi_set_image_change);
		shanghai_set_label = new JLabel(shanghai_set_image_change);
		doucheese_set_label = new JLabel(doucheese_set_image_change);
		magchicken_set_label = new JLabel(magchiken_set_image_change);
		eggbulgogi_set_label = new JLabel(eggbulgogi_set_image_change);
		cheese_set_label = new JLabel(cheese_set_image_change);
		susu_set_label = new JLabel(susu_set_image_change);
		subi_set_label = new JLabel(subi_set_image_change);
		nothing_label = new JLabel(nothing_imgae);
		
		new M_Keyosk_Set_Menu_Image_FirstUI(this);
		
		f.add(BorderLayout.NORTH,top_panel());
		f.add(BorderLayout.CENTER,menu_image_panel);
		f.add(BorderLayout.SOUTH,bottom_panel());
		
		f.setSize(1000,830);
		f.setVisible(true);
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		next.addActionListener(this);
		previous.addActionListener(this);
		single.addActionListener(this);
		side.addActionListener(this);
		beverage.addActionListener(this);
	
	}
	

	public Panel top_panel() {
		Panel top_panel = new Panel(new BorderLayout());
		top_panel.add(BorderLayout.NORTH,top_ad_panel);
		top_panel.add(BorderLayout.CENTER,menu_btn_panel);
		return top_panel;
	}
	
	public Panel bottom_panel() {
		Panel bottom_panel_1 = new Panel(new BorderLayout());
		bottom_panel_1.add(BorderLayout.NORTH,page_panel);
		bottom_panel_1.add(BorderLayout.CENTER,order_menu);
		bottom_panel_1.add(BorderLayout.SOUTH,bottom_panel);
		return bottom_panel_1;
	}
	
	public void switch_panel(int pname) {
		menu_image_panel.removeAll();
		menu_image.setVisible(false);
		
		switch(pname) {
		case SET_MENU_FIRST:
			menu_image.removeAll();
			menu_image.setVisible(true);
			break;
		case SET_MENU_TWO:
			menu_image.removeAll();
			menu_image.setVisible(true);
			break;
		case SINGLE_MENU:
			menu_image.removeAll();
			menu_image.setVisible(true);
			break;
		case SIDE_MENU:
			menu_image.removeAll();
			menu_image.setVisible(true);
			break;
		case BEVERAGE_MENU:
			menu_image.removeAll();
			menu_image.setVisible(true);
			break;
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == next) {
			new M_Keyosk_Set_Menu_Image_SecondUI(this);
		}else if(obj == previous) {
			new M_Keyosk_Set_Menu_Image_FirstUI(this);
		}else if(obj == single) {
			new M_Keyosk_SingleUI(this);
		}else if(obj == side) {
			
		}else if(obj == beverage) {
			
		}
		
	}
	
	
	

}
