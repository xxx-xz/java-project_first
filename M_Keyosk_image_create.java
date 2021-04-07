package jh_keyosk;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class M_Keyosk_image_create {
	M_Keyosk_UI main;


	public M_Keyosk_image_create(M_Keyosk_UI main) {
		this.main = main;
		init();
	}
	
	public void init() {
		//top_panel
				ImageIcon top_image = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/top_logo.PNG");
				//세트메뉴 이미지
				main.bigmag_set_image = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/bigmac_set.PNG");
				main.bulgogi_set_image = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/bulgogi_set.PNG");
				main.shanghai_set_image = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/shanghai_set.PNG");
				main.doucheese_set_image = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/doucheese_set.PNG");
				main.magchicken_set_image = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/macchicken_set.PNG");
				main.eggbulgogi_set_image = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/eggbulgogi_set.PNG");
				main.cheese_set_image = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/cheese_set.PNG");
				main.susu_set_image = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/susu_set.PNG");
				main.subi_set_image = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/subi_set.PNG");
				main.nothing_imgae = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/Inkednothing.jpg");
				//단품 이미지
				main.bigmag_single_image = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/bigmac.PNG");
				main.bulgogi_single_image = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/bulgogi.PNG");
				main.shanghai_single_image = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/shanghai.PNG");
				main.doucheese_single_image = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/doucheese.PNG");
				main.magchicken_single_image = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/macchicken.PNG");
				main.eggbulgogi_single_image = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/eggbulgogi.PNG");
				main.cheese_single_image = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/cheese.PNG");
				main.susu_single_image = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/susu.PNG");
				main.subi_single_image = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/subi.PNG");
				
				//사이드 이미지
				main.applepie = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/applepie.PNG");
				main.cheesestick = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/cheesestick.PNG");
				main.eggmuffin = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/eggmuffin.PNG");
				main.frenchfries = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/frenchfries.PNG");
				main.hotcake = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/hotcake.jpg");
				main.icecream = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/icecream.PNG");
				main.magnugget = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/magnugget.PNG");
				main.cheesemuffin = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/cheesemuffin.PNG");
				//음료 이미지
				main.coke = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/coke.PNG");
				main.cider = new ImageIcon("C:\\Users\\torgl\\Desktop\\XX\\M_Keyosk_image/cider.PNG");
				
				//이미지 크기조절
				
				Image top_img = top_image.getImage();
				Image top_img_change = top_img.getScaledInstance(986, 110, Image.SCALE_SMOOTH);
				ImageIcon top_image_change = new ImageIcon(top_img_change);
				JLabel top_ad_label = new JLabel(top_image);
				main.top_ad_panel.add(top_ad_label);
				
				Image bigmag_set_img = main.bigmag_set_image.getImage();
				Image bigmag_set_changeimg = bigmag_set_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
				ImageIcon bigmag_set_image_change = new ImageIcon(bigmag_set_changeimg);
				
				Image bulgogi_set_img = main.bulgogi_set_image.getImage();
				Image bulgogi_set_changeimg = bulgogi_set_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
				ImageIcon bulgogi_set_image_change = new ImageIcon(bulgogi_set_changeimg);
				
				Image shanghai_set_img = main.shanghai_set_image.getImage();
				Image shanghai_set_changeimg = shanghai_set_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
				ImageIcon shanghai_set_image_change = new ImageIcon(shanghai_set_changeimg);
				
				Image doucheese_set_img = main.doucheese_set_image.getImage();
				Image doucheese_set_changeimg = doucheese_set_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
				ImageIcon doucheese_set_image_change = new ImageIcon(doucheese_set_changeimg);
				
				Image magchicken_set_img = main.magchicken_set_image.getImage();
				Image magchicken_set_changeimg = magchicken_set_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
				ImageIcon magchicken_set_image_change = new ImageIcon(magchicken_set_changeimg);
				
				Image eggbulgogi_set_img = main.eggbulgogi_set_image.getImage();
				Image eggbulgogi_set_changeimg = eggbulgogi_set_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
				ImageIcon eggbulgogi_set_image_change = new ImageIcon(eggbulgogi_set_changeimg);
				
				Image cheese_set_img = main.cheese_set_image.getImage();
				Image cheese_set_changeimg = cheese_set_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
				ImageIcon cheese_set_image_change = new ImageIcon(cheese_set_changeimg);
				
				Image susu_set_img = main.susu_set_image.getImage();
				Image susu_set_changeimg = susu_set_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
				ImageIcon susu_set_image_change = new ImageIcon(susu_set_changeimg);
				
				Image subi_set_img = main.subi_set_image.getImage();
				Image subi_set_changeimg = subi_set_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
				ImageIcon subi_set_image_change = new ImageIcon(subi_set_changeimg);
				
				Image bigmag_single_img = main.bigmag_single_image.getImage();
				Image bigmag_single_changeimg = bigmag_single_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
				ImageIcon bigmag_single_image_change = new ImageIcon(bigmag_single_changeimg);
				
				Image bulgogi_single_img = main.bulgogi_single_image.getImage();
				Image bulgogi_single_changeimg = bulgogi_single_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
				ImageIcon bulgogi_single_image_change = new ImageIcon(bulgogi_single_changeimg);
				
				Image shanghai_single_img = main.shanghai_single_image.getImage();
				Image shanghai_single_changeimg = shanghai_single_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
				ImageIcon shanghai_single_image_change = new ImageIcon(shanghai_single_changeimg);
				
				Image doucheese_single_img = main.doucheese_single_image.getImage();
				Image doucheese_single_changeimg = doucheese_single_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
				ImageIcon doucheese_single_image_change = new ImageIcon(doucheese_single_changeimg);
				
				Image magchiken_single_img = main.magchicken_single_image.getImage();
				Image magchiken_single_changeimg = magchiken_single_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
				ImageIcon magchiken_single_image_change = new ImageIcon(magchiken_single_changeimg);
				
				Image eggbulgogi_single_img = main.eggbulgogi_single_image.getImage();
				Image eggbulgogi_single_changeimg = eggbulgogi_single_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
				ImageIcon eggbulgogi_single_image_change = new ImageIcon(eggbulgogi_single_changeimg);
				
				Image cheese_single_img = main.cheese_single_image.getImage();
				Image cheese_single_changeimg = cheese_single_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
				ImageIcon cheese_single_image_change = new ImageIcon(cheese_single_changeimg);
				
				Image susu_single_img = main.susu_single_image.getImage();
				Image susu_single_changeimg = susu_single_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
				ImageIcon susu_single_image_change = new ImageIcon(susu_single_changeimg);
				
				Image subi_single_img = main.subi_single_image.getImage();
				Image subi_single_changeimg = subi_single_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
				ImageIcon subi_single_image_change = new ImageIcon(subi_single_changeimg);
				
				
				//사이드이미지라벨 applepie,cheesestick,eggmuffin,frenchfries,hotcake,icecream,magnugget,coke,cider,cheesemuffin;
				Image applepie_img = main.applepie.getImage();
				Image applepie_changeimg = applepie_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
				ImageIcon applepie_image_change = new ImageIcon(applepie_changeimg);
				
				Image cheesestick_img = main.cheesestick.getImage();
				Image cheesestick_changeimg = cheesestick_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
				ImageIcon cheesestick_image_change = new ImageIcon(cheesestick_changeimg);
				
				Image eggmuffin_img = main.eggmuffin.getImage();
				Image eggmuffin_changeimg = eggmuffin_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
				ImageIcon eggmuffin_image_change = new ImageIcon(eggmuffin_changeimg);
				
				Image frenchfries_img = main.frenchfries.getImage();
				Image frenchfries_changeimg = frenchfries_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
				ImageIcon frenchfries_image_change = new ImageIcon(frenchfries_changeimg);
				
				Image hotcake_img = main.hotcake.getImage();
				Image hotcake_changeimg = hotcake_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
				ImageIcon hotcake_image_change = new ImageIcon(hotcake_changeimg);
				
				Image icecream_img = main.icecream.getImage();
				Image icecream_changeimg = icecream_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
				ImageIcon icecream_image_change = new ImageIcon(icecream_changeimg);
				
				Image magnugget_img = main.magnugget.getImage();
				Image magnugget_changeimg = magnugget_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
				ImageIcon magnugget_image_change = new ImageIcon(magnugget_changeimg);
				
				Image cheesemuffine_img = main.cheesemuffin.getImage();
				Image cheesemuffin_changeimg = cheesemuffine_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
				ImageIcon cheesemuffin_image_change = new ImageIcon(cheesemuffin_changeimg);
				
				//음료이미지라벨
				Image coke_img = main.coke.getImage();
				Image coke_changeimg = coke_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
				ImageIcon coke_image_change = new ImageIcon(coke_changeimg);
				
				Image cider_img = main.cider.getImage();
				Image cider_changeimg = cider_img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
				ImageIcon cider_image_change = new ImageIcon(cider_changeimg);
				
				//세트이미지라벨
				
				main.bigmag_set_label = new JButton(bigmag_set_image_change);
				main.bigmag_set_label.addActionListener(main.event);
				main.bulgogi_set_label = new JButton(bulgogi_set_image_change);
				main.bulgogi_set_label.addActionListener(main.event);
				main.shanghai_set_label = new JButton(shanghai_set_image_change);
				main.shanghai_set_label.addActionListener(main.event);
				main.doucheese_set_label = new JButton(doucheese_set_image_change);
				main.doucheese_set_label.addActionListener(main.event);
				main.magchicken_set_label = new JButton(magchicken_set_image_change);
				main.magchicken_set_label.addActionListener(main.event);
				main.eggbulgogi_set_label = new JButton(eggbulgogi_set_image_change);
				main.eggbulgogi_set_label.addActionListener(main.event);
				main.cheese_set_label = new JButton(cheese_set_image_change);
				main.cheese_set_label.addActionListener(main.event);
				main.susu_set_label = new JButton(susu_set_image_change);
				main.susu_set_label.addActionListener(main.event);
				main.subi_set_label = new JButton(subi_set_image_change);
				main.subi_set_label.addActionListener(main.event);
				
				main.nothing_label = new JButton(main.nothing_imgae);
				//단품이미지라벨
				main.bigmag_label = new JButton(bigmag_single_image_change);
				main.bigmag_label.addActionListener(main.event);
				main.bulgogi_label = new JButton(bulgogi_single_image_change);
				main.bulgogi_label.addActionListener(main.event);
				main.shanghai_label = new JButton(shanghai_single_image_change);
				main.shanghai_label.addActionListener(main.event);
				main.doucheese_label = new JButton(doucheese_single_image_change);
				main.doucheese_label.addActionListener(main.event);
				main.magchicken_label = new JButton(magchiken_single_image_change);
				main.magchicken_label.addActionListener(main.event);
				main.eggbulgogi_label = new JButton(eggbulgogi_single_image_change);
				main.eggbulgogi_label.addActionListener(main.event);
				main.cheese_label = new JButton(cheese_single_image_change);
				main.cheese_label.addActionListener(main.event);
				main.susu_label = new JButton(susu_single_image_change);
				main.susu_label.addActionListener(main.event);
				main.subi_label = new JButton(subi_single_image_change);
				main.subi_label.addActionListener(main.event);
				//사이드이미지라벨
				main.applepie_label = new JButton(applepie_image_change);
				main.applepie_label.addActionListener(main.event);
				main.cheesestick_label = new JButton(cheesestick_image_change);
				main.cheesestick_label.addActionListener(main.event);
				main.eggmuffin_label = new JButton(eggmuffin_image_change);
				main.eggmuffin_label.addActionListener(main.event);
				main.frenchfries_label = new JButton(frenchfries_image_change);
				main.frenchfries_label.addActionListener(main.event);
				main.hotcake_label = new JButton(hotcake_image_change);
				main.hotcake_label.addActionListener(main.event);
				main.icecream_label = new JButton(icecream_image_change);
				main.icecream_label.addActionListener(main.event);
				main.magnugget_label = new JButton(magnugget_image_change);
				main.magnugget_label.addActionListener(main.event);
				main.cheesemuffin_label = new JButton(cheesemuffin_image_change);
				main.cheesemuffin_label.addActionListener(main.event);
				//음료이미지라벨
				main.coke_label = new JButton(coke_image_change);
				main.coke_label.addActionListener(main.event);
				main.cider_label = new JButton(cider_image_change);
				main.cider_label.addActionListener(main.event);
	}
}
