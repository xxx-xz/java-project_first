package keyosk_gui;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class M_Keyosk_image_create {
	M_Keyosk_UI main;
	ImageIcon bigmag_set_image_change;

	public M_Keyosk_image_create(M_Keyosk_UI main) {
		this.main = main;
		init();
	}
	
	public void init() {
		//top_panel
				ImageIcon top_image = new ImageIcon("keyosk_images/top_logo.PNG");
				//세트메뉴 이미지
				main.bigmag_set_image = new ImageIcon("keyosk_images\\bigmac_set.PNG");
				main.bulgogi_set_image = new ImageIcon("keyosk_images\\bulgogi_set.PNG");
				main.shanghai_set_image = new ImageIcon("keyosk_images\\shanghai_set.PNG");
				main.doucheese_set_image = new ImageIcon("keyosk_images/doucheese_set.PNG");
				main.magchicken_set_image = new ImageIcon("keyosk_images/macchicken_set.PNG");
				main.eggbulgogi_set_image = new ImageIcon("keyosk_images/eggbulgogi_set.PNG");
				main.cheese_set_image = new ImageIcon("keyosk_images/cheese_set.PNG");
				main.susu_set_image = new ImageIcon("keyosk_images/susu_set.PNG");
				main.subi_set_image = new ImageIcon("keyosk_images/subi_set.PNG");
				main.nothing_imgae = new ImageIcon("keyosk_images/Inkednothing.jpg");
				//단품 이미지
				main.bigmag_single_image = new ImageIcon("keyosk_images/bigmac.PNG");
				main.bulgogi_single_image = new ImageIcon("keyosk_images/bulgogi.PNG");
				main.shanghai_single_image = new ImageIcon("keyosk_images/shanghai.PNG");
				main.doucheese_single_image = new ImageIcon("keyosk_images/doucheese.PNG");
				main.macchicken_single_image = new ImageIcon("keyosk_images/macchicken.PNG");
				main.eggbulgogi_single_image = new ImageIcon("keyosk_images/eggbulgogi.PNG");
				main.cheese_single_image = new ImageIcon("keyosk_images/cheese.PNG");
				main.susu_single_image = new ImageIcon("keyosk_images/susu.PNG");
				main.subi_single_image = new ImageIcon("keyosk_images/subi.PNG");
				
				//사이드 이미지
				main.applepie = new ImageIcon("keyosk_images/applepie.PNG");
				main.cheesestick = new ImageIcon("keyosk_images/cheesestick.PNG");
				main.eggmuffin = new ImageIcon("keyosk_images/eggmuffin.PNG");
				main.frenchfries = new ImageIcon("keyosk_images/frenchfries.PNG");
				main.hotcake = new ImageIcon("keyosk_images/hotcake.jpg");
				main.icecream = new ImageIcon("keyosk_images/icecream.PNG");
				main.macnugget = new ImageIcon("keyosk_images/macnugget.PNG");
				main.cheesemuffin = new ImageIcon("keyosk_images/cheesemuffin.PNG");
				//음료 이미지
				main.coke = new ImageIcon("keyosk_images/coke.PNG");
				main.cider = new ImageIcon("keyosk_images/cider.PNG");
				
				//이미지 크기조절
				
//				Image top_img = top_image.getImage();
//				Image top_img_change = top_img.getScaledInstance(986, 110, Image.SCALE_SMOOTH);
//				ImageIcon top_image_change = new ImageIcon(top_img_change);
				JLabel top_ad_label = new JLabel(top_image);
				main.top_ad_panel.add(top_ad_label);
				
//				Image bigmag_set_img = main.bigmag_set_image.getImage();
//				Image bigmag_set_changeimg = bigmag_set_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
//				bigmag_set_image_change = new ImageIcon(bigmag_set_changeimg);
//				
//				Image bulgogi_set_img = main.bulgogi_set_image.getImage();
//				Image bulgogi_set_changeimg = bulgogi_set_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
//				ImageIcon bulgogi_set_image_change = new ImageIcon(bulgogi_set_changeimg);
//				
//				Image shanghai_set_img = main.shanghai_set_image.getImage();
//				Image shanghai_set_changeimg = shanghai_set_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
//				ImageIcon shanghai_set_image_change = new ImageIcon(shanghai_set_changeimg);
//				
//				Image doucheese_set_img = main.doucheese_set_image.getImage();
//				Image doucheese_set_changeimg = doucheese_set_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
//				ImageIcon doucheese_set_image_change = new ImageIcon(doucheese_set_changeimg);
//				
//				Image magchicken_set_img = main.magchicken_set_image.getImage();
//				Image magchicken_set_changeimg = magchicken_set_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
//				ImageIcon magchicken_set_image_change = new ImageIcon(magchicken_set_changeimg);
//				
//				Image eggbulgogi_set_img = main.eggbulgogi_set_image.getImage();
//				Image eggbulgogi_set_changeimg = eggbulgogi_set_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
//				ImageIcon eggbulgogi_set_image_change = new ImageIcon(eggbulgogi_set_changeimg);
//			
//				Image cheese_set_img = main.cheese_set_image.getImage();
//				Image cheese_set_changeimg = cheese_set_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
//				ImageIcon cheese_set_image_change = new ImageIcon(cheese_set_changeimg);
//				
//				Image susu_set_img = main.susu_set_image.getImage();
//				Image susu_set_changeimg = susu_set_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
//				ImageIcon susu_set_image_change = new ImageIcon(susu_set_changeimg);
//				
//				Image subi_set_img = main.subi_set_image.getImage();
//				Image subi_set_changeimg = subi_set_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
//				ImageIcon subi_set_image_change = new ImageIcon(subi_set_changeimg);
				
//				Image bigmag_single_img = main.bigmag_single_image.getImage();
//				Image bigmag_single_changeimg = bigmag_single_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
//				ImageIcon bigmag_single_image_change = new ImageIcon(bigmag_single_changeimg);
//				
//				Image bulgogi_single_img = main.bulgogi_single_image.getImage();
//				Image bulgogi_single_changeimg = bulgogi_single_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
//				ImageIcon bulgogi_single_image_change = new ImageIcon(bulgogi_single_changeimg);
//				
//				Image shanghai_single_img = main.shanghai_single_image.getImage();
//				Image shanghai_single_changeimg = shanghai_single_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
//				ImageIcon shanghai_single_image_change = new ImageIcon(shanghai_single_changeimg);
//				
//				Image doucheese_single_img = main.doucheese_single_image.getImage();
//				Image doucheese_single_changeimg = doucheese_single_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
//				ImageIcon doucheese_single_image_change = new ImageIcon(doucheese_single_changeimg);
//				
//				Image magchiken_single_img = main.macchicken_single_image.getImage();
//				Image magchiken_single_changeimg = magchiken_single_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
//				ImageIcon magchiken_single_image_change = new ImageIcon(magchiken_single_changeimg);
//				
//				Image eggbulgogi_single_img = main.eggbulgogi_single_image.getImage();
//				Image eggbulgogi_single_changeimg = eggbulgogi_single_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
//				ImageIcon eggbulgogi_single_image_change = new ImageIcon(eggbulgogi_single_changeimg);
//				
//				Image cheese_single_img = main.cheese_single_image.getImage();
//				Image cheese_single_changeimg = cheese_single_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
//				ImageIcon cheese_single_image_change = new ImageIcon(cheese_single_changeimg);
//				
//				Image susu_single_img = main.susu_single_image.getImage();
//				Image susu_single_changeimg = susu_single_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
//				ImageIcon susu_single_image_change = new ImageIcon(susu_single_changeimg);
//				
//				Image subi_single_img = main.subi_single_image.getImage();
//				Image subi_single_changeimg = subi_single_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
//				ImageIcon subi_single_image_change = new ImageIcon(subi_single_changeimg);
				
				
				//사이드이미지라벨 applepie,cheesestick,eggmuffin,frenchfries,hotcake,icecream,magnugget,coke,cider,cheesemuffin;
//				Image applepie_img = main.applepie.getImage();
//				Image applepie_changeimg = applepie_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
//				ImageIcon applepie_image_change = new ImageIcon(applepie_changeimg);
//				
//				Image cheesestick_img = main.cheesestick.getImage();
//				Image cheesestick_changeimg = cheesestick_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
//				ImageIcon cheesestick_image_change = new ImageIcon(cheesestick_changeimg);
//				
//				Image eggmuffin_img = main.eggmuffin.getImage();
//				Image eggmuffin_changeimg = eggmuffin_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
//				ImageIcon eggmuffin_image_change = new ImageIcon(eggmuffin_changeimg);
//				
//				Image frenchfries_img = main.frenchfries.getImage();
//				Image frenchfries_changeimg = frenchfries_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
//				ImageIcon frenchfries_image_change = new ImageIcon(frenchfries_changeimg);
//				
//				Image hotcake_img = main.hotcake.getImage();
//				Image hotcake_changeimg = hotcake_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
//				ImageIcon hotcake_image_change = new ImageIcon(hotcake_changeimg);
//				
//				Image icecream_img = main.icecream.getImage();
//				Image icecream_changeimg = icecream_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
//				ImageIcon icecream_image_change = new ImageIcon(icecream_changeimg);
//				
//				Image magnugget_img = main.magnugget.getImage();
//				Image magnugget_changeimg = magnugget_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
//				ImageIcon magnugget_image_change = new ImageIcon(magnugget_changeimg);
//				
//				Image cheesemuffine_img = main.cheesemuffin.getImage();
//				Image cheesemuffin_changeimg = cheesemuffine_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
//				ImageIcon cheesemuffin_image_change = new ImageIcon(cheesemuffin_changeimg);
//				
//				//음료이미지라벨
//				Image coke_img = main.coke.getImage();
//				Image coke_changeimg = coke_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
//				ImageIcon coke_image_change = new ImageIcon(coke_changeimg);
//				
//				Image cider_img = main.cider.getImage();
//				Image cider_changeimg = cider_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
//				ImageIcon cider_image_change = new ImageIcon(cider_changeimg);
				
				//세트이미지버튼
//				String[] name_list = {"bigmag_set_button","doucheese_set_button",
//						"bulgogi_set_button","shanghai_set_button","magchicken_set_button",
//						"eggbulgogi_set_button","cheese_set_button","susu_set_button",
//						"subi_set_button","nothing_button","bigmag_button","bulgogi_button",
//						"shanghai_button","magchicken_button","doucheese_button",
//						"eggbulgogi_button","cheese_button","susu_button","subi_button"};
		
				main.bigmag_set_button = new JButton(main.bigmag_set_image);
				main.bigmag_set_button.addActionListener(main.event);
				main.bigmag_set_button.setBackground(Color.white);
				main.bulgogi_set_button = new JButton(main.bulgogi_set_image);
				main.bulgogi_set_button.addActionListener(main.event);
				main.bulgogi_set_button.setBackground(Color.white);
				main.shanghai_set_button = new JButton(main.shanghai_set_image);
				main.shanghai_set_button.addActionListener(main.event);
				main.shanghai_set_button.setBackground(Color.white);
				main.doucheese_set_button = new JButton(main.doucheese_set_image);
				main.doucheese_set_button.addActionListener(main.event);
				main.doucheese_set_button.setBackground(Color.white);
				main.magchicken_set_button = new JButton(main.magchicken_set_image);
				main.magchicken_set_button.addActionListener(main.event);
				main.magchicken_set_button.setBackground(Color.white);
				main.eggbulgogi_set_button = new JButton(main.eggbulgogi_set_image);
				main.eggbulgogi_set_button.addActionListener(main.event);
				main.eggbulgogi_set_button.setBackground(Color.white);
				main.cheese_set_button = new JButton(main.cheese_set_image);
				main.cheese_set_button.addActionListener(main.event);
				main.cheese_set_button.setBackground(Color.white);
				main.susu_set_button = new JButton(main.susu_set_image);
				main.susu_set_button.addActionListener(main.event);
				main.susu_set_button.setBackground(Color.white);
				main.subi_set_button = new JButton(main.subi_set_image);
				main.subi_set_button.addActionListener(main.event);
				main.subi_set_button.setBackground(Color.white);
				main.nothing_button = new JButton(main.nothing_imgae);
				//단품이미지버튼
				main.bigmag_button = new JButton(main.bigmag_single_image);
				main.bigmag_button.addActionListener(main.event);
				main.bigmag_button.setBackground(Color.white);
				main.bulgogi_button = new JButton(main.bulgogi_single_image);
				main.bulgogi_button.addActionListener(main.event);
				main.bulgogi_button.setBackground(Color.white);
				main.shanghai_button = new JButton(main.shanghai_single_image);
				main.shanghai_button.addActionListener(main.event);
				main.shanghai_button.setBackground(Color.white);
				main.doucheese_button = new JButton(main.doucheese_single_image);
				main.doucheese_button.addActionListener(main.event);
				main.doucheese_button.setBackground(Color.white);
				main.magchicken_button = new JButton(main.macchicken_single_image);
				main.magchicken_button.addActionListener(main.event);
				main.magchicken_button.setBackground(Color.white);
				main.eggbulgogi_button = new JButton(main.eggbulgogi_single_image);
				main.eggbulgogi_button.addActionListener(main.event);
				main.eggbulgogi_button.setBackground(Color.white);
				main.cheese_button = new JButton(main.cheese_single_image);
				main.cheese_button.addActionListener(main.event);
				main.cheese_button.setBackground(Color.white);
				main.susu_button = new JButton(main.susu_single_image);
				main.susu_button.addActionListener(main.event);
				main.susu_button.setBackground(Color.white);
				main.subi_button = new JButton(main.subi_single_image);
				main.subi_button.addActionListener(main.event);
				main.subi_button.setBackground(Color.white);
				//사이드이미지버튼
				main.applepie_button = new JButton(main.applepie);
				main.applepie_button.addActionListener(main.event);
				main.applepie_button.setBackground(Color.white);
				main.cheesestick_button = new JButton(main.cheesestick);
				main.cheesestick_button.addActionListener(main.event);
				main.cheesestick_button.setBackground(Color.white);
				main.eggmuffin_button = new JButton(main.eggmuffin);
				main.eggmuffin_button.addActionListener(main.event);
				main.eggmuffin_button.setBackground(Color.white);
				main.frenchfries_button = new JButton(main.frenchfries);
				main.frenchfries_button.addActionListener(main.event);
				main.frenchfries_button.setBackground(Color.white);
				main.hotcake_button = new JButton(main.hotcake);
				main.hotcake_button.addActionListener(main.event);
				main.hotcake_button.setBackground(Color.white);
				main.icecream_button = new JButton(main.icecream);
				main.icecream_button.addActionListener(main.event);
				main.icecream_button.setBackground(Color.white);
				main.macnugget_button = new JButton(main.macnugget);
				main.macnugget_button.addActionListener(main.event);
				main.macnugget_button.setBackground(Color.white);
				main.cheesemuffin_button = new JButton(main.cheesemuffin);
				main.cheesemuffin_button.addActionListener(main.event);
				main.cheesemuffin_button.setBackground(Color.white);
				//음료이미지버튼
				main.coke_button = new JButton(main.coke);
				main.coke_button.addActionListener(main.event);
				main.coke_button.setBackground(Color.white);
				main.cider_button = new JButton(main.cider);
				main.cider_button.addActionListener(main.event);
				main.cider_button.setBackground(Color.white);
	}
}
