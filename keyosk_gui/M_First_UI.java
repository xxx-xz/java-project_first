package jh_keyosk;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class M_First_UI implements ActionListener{
	Frame f;
	Panel top_panel, bottom_panel;
	JButton next_button;
	JLabel top_label, bottom_label;
	
	ImageIcon main_image; 
	ImageIcon next_image;
	ImageIcon c_main_image;
	ImageIcon c_next_image;
	
	public M_First_UI(){
		init();
	}
	
	public void init(){
		f = new Frame("MacKeyosk");
		top_panel = new Panel();
		bottom_panel = new Panel();
		
		main_image = new ImageIcon("keyosk_images/m_main_image.png");
		next_image = new ImageIcon("keyosk_images/m_bottom_image.png");
		
		Image im = main_image.getImage();
		Image im2 = im.getScaledInstance(500,550,Image.SCALE_SMOOTH);// 메인 이미지 사이즈 변경 
		c_main_image = new ImageIcon(im2);
		
		Image bm = next_image.getImage();
		Image bm2 = bm.getScaledInstance(500, 150,Image.SCALE_SMOOTH); // 스타트 이미지 사이즈 변경 
		c_next_image = new ImageIcon(bm2);
		
		
		next_button = new JButton(c_next_image);
		
		top_label = new JLabel(c_main_image);
		bottom_label = new JLabel(c_next_image);
		
		
		
		f.add(BorderLayout.NORTH, top_label);
		f.add(BorderLayout.SOUTH, next_button);
		
		f.setSize(500, 700);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == next_button) {
			System.out.println("다음 버튼 ");
		//	new M_keyosk_set_menu_image_firstUI(this);
		}
		
	}
	
	
}
