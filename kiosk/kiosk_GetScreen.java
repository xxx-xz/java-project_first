package kiosk;

import java.awt.*;
import javax.swing.*;

public class kiosk_GetScreen extends JFrame{
	//Field
	JLabel l_order, l_cus_call ,l_order_stic;
	JTextArea ta_date, ta_cal1, ta_cal2, ta_screan;
	JTable cus_order;
	JButton b_cus_call, serch, b_1, b_2, b_3;
	
	
	
	
	//Constructor
	public kiosk_GetScreen() {
		init();

	}
	
	
	//Method
	/** 레이아웃 설정 **/
	public void init() {
		
//		setTitle("버튼 크기 조절");
//        setSize(300,300);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLayout(null);
//        JButton b1 = new JButton("버튼1");
//        JButton b2 = new JButton("버튼2");
//        b1.setBounds(20, 5, 70, 30);
//        b2.setBounds(55, 45, 120, 60);
//        add(b1);
//        add(b2);
//        setVisible(true);
        
    	/** --------내꺼-------- **/
		setTitle("시발");
		setSize(1439,2000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/** 레이아웃 설정 **/
		setLayout(null);
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1439, 2000);
        layeredPane.setLayout(null);
		
        
        /** --------왼쪽-------- **/
        
        /**이미지**/
        ImageIcon img = new ImageIcon("image/call_button.png");
        ImageIcon img1 = new ImageIcon("image/serch.png");
        
        /** 오늘날짜 **/
        ta_date = new JTextArea();
        ta_date.setBounds(62, 50, 300, 30);
        layeredPane.add(ta_date);
		
        /** 주문내역**/
        l_order = new JLabel("주문내역");
        l_order.setBounds(62, 125, 75, 20);
		layeredPane.add(l_order);
		
		/** 날짜검색칸 **/
		ta_cal1 = new JTextArea();
		ta_cal2 = new JTextArea();
		ta_cal1.setBounds(62,145,141,31);
		ta_cal2.setBounds(238,145,141,31);
		layeredPane.add(ta_cal1);
		layeredPane.add(ta_cal2);
		
		l_order_stic = new JLabel("-");
		l_order_stic.setBounds(218, 159, 18, 4);
		layeredPane.add(l_order_stic);
		
		serch = new JButton(img1);
		serch.setBounds(382, 141, 40, 40);
		layeredPane.add(serch);
		
		/** 주문내역 **/
		cus_order = new JTable();
		cus_order.setBounds(62, 186, 626, 500);		
		layeredPane.add(cus_order);
		
		/**고객호출 라벨**/
		l_cus_call = new JLabel("고객호출");
		l_cus_call.setBounds(62,719, 75, 20);
		layeredPane.add(l_cus_call);
		
		/**고객호출 버튼**/
		b_cus_call = new JButton(img);
		b_cus_call.setBounds(62,739,628,80);
		b_cus_call.setBackground(Color.BLACK);
		
		layeredPane.add(b_cus_call);
		


		
		/** --------오른쪽-------- **/
		
		/** 박 **/
		ta_screan = new JTextArea();
		ta_screan.setBounds(751, 50, 636, 635);
		layeredPane.add(ta_screan);
		
		/** 왼쪽 **/
		b_1 = new JButton();
		b_1.setBounds(748, 739, 200, 80);//751, 50, 636, 763
		layeredPane.add(b_1);
		
		/** 중간 **/
		b_2 = new JButton();
		b_2.setBounds(970, 739, 200, 80);
		layeredPane.add(b_2);
		
		/** 오른쪽 **/
		b_3 = new JButton();
		b_3.setBounds(1190, 739, 200, 80);
		layeredPane.add(b_3);
		
       add(layeredPane);
       setVisible(true);
		
		
		
		
		
		
		
		
		
//		
//    JFrame f;
//   	JPanel all_panel, p_right, p_left, top_panel, center_panel, footer_panel, order_panel
//   			,f_center_panel,f_footer_panel;
//   	JLabel l_order, l_cus_call;
//   	JTextArea ta_date, ta_cal;
//
//   	JTable cus_order;
//   	JButton b_cus_call;
//   	
//   	String[] list = {"north","고객주문","고객호출"};
		
		
//		Panel p_cus_order = new Panel(new FlowLayout(FlowLayout.LEFT,0,-300));
//		Panel p_ta_cal = new Panel(); 
//		Panel p_ta_date = new Panel(); 
//		Panel p_l_order = new Panel(); 
//		Panel p_l_cus_call = new Panel();
//		Panel p_b_cus_call = new Panel();
//		 f_center_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		 f_footer_panel = new JPanel(new GridLayout(2,1));
//		
//		
//		all_panel = new JPanel(new GridLayout(1,2));
//		p_right = new JPanel();
//		p_left = new JPanel(new BorderLayout());
//		
//		top_panel  = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		
//		center_panel = new JPanel(new BorderLayout());
//		footer_panel  = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		
//		
//		
//		
//		order_panel = new JPanel(new GridLayout(2,1));
//		
//		l_order = new JLabel("고객주문"); 
//		l_cus_call = new JLabel("고객호출");
//		
//		ta_date = new JTextArea(2,10); 
//		ta_cal = new JTextArea(2,10); 
//	
//		cus_order = new JTable(100,50);
//		
//		
//		b_cus_call = new JButton(" bell");
//	
//
//		
//		/**넣기**/
//		p_cus_order.add(cus_order);
//		p_cus_order.setBounds(0,0,700,700);
//		p_ta_date.add(ta_date);
//		p_ta_cal.add(ta_cal);
//		p_l_order.add(l_order);
//		p_b_cus_call.add(b_cus_call);
//		p_l_cus_call.add(l_cus_call);
//		
//		order_panel.add(p_l_order);
//		order_panel.add(p_ta_cal);
//		
//		top_panel.add(p_ta_date);
//		
//		f_center_panel.add(BorderLayout.NORTH,order_panel);
//		//center_panel.add(p_ta_cal);
//		f_center_panel.add(BorderLayout.CENTER,p_cus_order);
//		
//		f_footer_panel.add(p_b_cus_call);
//		f_footer_panel.add(p_l_cus_call);
//	
//		center_panel.add(f_center_panel);
//		footer_panel.add(f_footer_panel);
//		
//		//p_left.setLayout(new BorderLayout());
//		p_left.add(BorderLayout.NORTH,top_panel);
//		p_left.add(BorderLayout.CENTER,center_panel);
//		p_left.add(BorderLayout.SOUTH,footer_panel);
//		
//		
//		all_panel.add(p_left);
//		all_panel.add(p_right);
//		
//		
//        layeredPane.add(all_panel);
//        add(layeredPane);
//        setVisible(true);
        
//		f.add(all_panel);
//		f.setSize(1439,2000);
//		f.setVisible(true);
		

//		for(String str : list) {
//			Label test = new Label(str);
//			if(str.equals("north")) {
//				
//				TextArea ta_date = new TextArea(1,5); 
//				p_ta_date.add(ta_date);
//				center_panel.add(p_ta_date);
//				
//			}else if(str.equals("고객주문")) {
//				l_order = new Label("고객주문");
//				TextArea ta_cal = new TextArea(1,5);
//				JTable cus_order = new JTable(10,10);
//				
//				
//				p_ta_cal.add(ta_cal);
//				p_cus_order.add(cus_order);
//				center_panel.add(p_ta_cal);
//				center_panel.add(p_cus_order);
//				
//			}else if(str.equals("고객호출")) {
//				l_cus_call = new Label("고객호출");
//				JButton b_cus_call = new JButton();
//				
//				
//				p_b_cus_call.add(b_cus_call);
//				center_panel.add(p_b_cus_call);
//			}
//			
//			
//		}//for
		
	}
}//class
