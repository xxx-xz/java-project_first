package score_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import project_system.Commons;



public class LHS_ClientCall extends JFrame{
	//Field
	JFrame f;
    JPanel line_panel, panel, wait_panel, call_panel; 
	//Constructor
	public LHS_ClientCall() {
		
		init();
	}
	
	//Method
	public void init() {
		f = new JFrame();
		Panel label_panel = new Panel(new GridLayout(1,0,0,0));
		Panel tf_panel = new Panel(new GridLayout(1,1,1,1));
		Panel btn_panel = new Panel();
		
				
		////////////////////////////////////LABEL
		JLabel wait_label = new JLabel();
		wait_label.setText("<html>     &nbsp;&nbsp;&nbsp;&nbsp; 제품을<br>준비중입니다.</html>");
		JLabel call_label = new JLabel("");
		call_label.setText("<html>   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;주문하신<br>제품이 나왔습니다.</html>");
		wait_label.setFont(Commons.getFont());
		call_label.setFont(Commons.getFont());
		
		wait_label.setHorizontalAlignment(JLabel.CENTER);
		call_label.setHorizontalAlignment(JLabel.CENTER);
		label_panel.add(wait_label); 
		label_panel.add(call_label); 
		 
		f.add(BorderLayout.NORTH, label_panel);
        ////////////////////////////////////////////////////////////////////////////////// 
        ///////////////////////////////////PANEL
         wait_panel = new JPanel();
         wait_panel.setBackground(Color.black);
         
         call_panel = new JPanel();
         call_panel.setBackground(Color.red);
         
        tf_panel.add(call_panel); 
        tf_panel.add(wait_panel);
        f.add(tf_panel);
        
         
        
		f.setVisible(true);
		f.setSize(500, 500);
		
		
	}

	
	
	}