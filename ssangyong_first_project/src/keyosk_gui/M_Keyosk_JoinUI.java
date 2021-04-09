package keyosk_gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class M_Keyosk_JoinUI implements ActionListener {

	JTextField id,pass,cpass,name,email,tel,addr;
	JFrame f;
	JPanel jl_panel,jtf_panel,btn_panel;
	JButton join,cancle;
	ArrayList<String> join_member = new ArrayList<String>();
	String[] label_list = {"���̵�","��й�ȣ","��й�ȣ Ȯ��","�̸�","�̸���","��ȭ��ȣ","�ּ�"};
	
	public M_Keyosk_JoinUI() {
		f = new JFrame("ȸ������");
		
		jl_panel = new JPanel(new GridLayout(7,1));
		jtf_panel = new JPanel(new GridLayout(7,1));
		btn_panel = new JPanel();
		
		for(String list : label_list) {
			JPanel l_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel label = new JLabel(list);
			l_panel.add(label);
			jl_panel.add(l_panel);
			
			JPanel tf_panel = new JPanel();
			JTextField tf = new JTextField(20);
			tf_panel.add(tf);
			jtf_panel.add(tf_panel);
			join_member.add(tf.getText());
		}
		join = new JButton("ȸ������");
		cancle = new JButton("���");
		join.setBackground(Color.lightGray);
		cancle.setBackground(Color.lightGray);
		join.addActionListener(this);
		join.addActionListener(this);
		btn_panel.add(join);
		btn_panel.add(cancle);
		
		
		
		
		
		join = new JButton("ȸ������");
		cancle = new JButton("���");
		join.setBackground(Color.lightGray);
		cancle.setBackground(Color.lightGray);
		
		f.add(BorderLayout.WEST,jl_panel);
		f.add(BorderLayout.CENTER,jtf_panel);
		f.add(BorderLayout.SOUTH,btn_panel);
		
		f.setSize(500,500);
		f.setVisible(true);
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand();
		if(name.equals("ȸ������")) {
			System.out.println(join_member);
		}else if(name.equals("���")) {
			System.exit(0);
		}
		
	}
	
	public boolean form_check() {
		boolean result = false;
		for(int i=0;i<join_member.size();i++) {
			if(join_member.get(i).equals("")){
				JOptionPane.showMessageDialog(null, label_list[i] + "�� �Էµ��� �ʾҽ��ϴ�");
				i = join_member.size();
			}else if(i == join_member.size()) {
				result = true;
			}
		}
		System.out.println("�� üũ ���");
		return result;
	}

}
