package test;
 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
 
public class join extends JFrame {
 
	static JLayeredPane f = new JLayeredPane();
    BufferedImage img = null;
    JTextField loginTextField;
    JPasswordField passwordField, passwordField2;
    JButton join_bt;
    JButton bt2;
    JLabel Pass_Label, Pass2_Label, login_Label, phone_label, phone2_label, phone3_label, e_mail_label, e_mail2_label;
    String[] namelist = {"���̵�", "��й�ȣ", "��й�ȣȮ��", "�ڵ���","�ڵ���2","�ڵ���3","Email", "Email2"};
    // ����
    public static void main(String[] args) {
        new join();
    }
 
    // ������
    public join() {
        setTitle("�α��� �׽�Ʈ");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 
        // ���̾ƿ� ����
        setLayout(null);
        f.setBounds(0, 0, 700, 700);
        f.setLayout(null);
 
        // �г�1
        // �̹��� �޾ƿ���
        try {
            img = ImageIO.read(new File("C:\\Users\\F1\\Downloads/222.png"));
        } catch (IOException e) {
            System.out.println("�̹��� �ҷ����� ����");
            System.exit(0);
        }
         
        MyPanel panel = new MyPanel();
        panel.setBounds(0, 0, 1600, 900);
         
        // �α��� �� 
        login_Label = new JLabel("���̵�");
        login_Label.setBounds(175, 225, 100, 30);
        login_Label.setForeground(Color.orange);
        login_Label.setFont(new Font("Serif", Font.BOLD, 15));
        
     // �н�����  �� 
        Pass_Label = new JLabel("��й�ȣ");
        Pass_Label.setBounds(165, 275, 100, 30);
        Pass_Label.setForeground(Color.orange);
        Pass_Label.setFont(new Font("Serif", Font.BOLD, 15));
     // �н����� Ȯ�� ��
        Pass2_Label = new JLabel("��й�ȣ Ȯ��");
        Pass2_Label.setBounds(135, 325, 360, 30);
        Pass2_Label.setForeground(Color.orange);
        Pass2_Label.setFont(new Font("Serif", Font.BOLD, 15));
     // - �� 
        phone_label = new JLabel("-");  phone_label.setForeground(Color.orange); phone_label.setFont(new Font("Serif", Font.BOLD, 25));
        phone2_label = new JLabel("-"); phone2_label.setForeground(Color.orange); phone2_label.setFont(new Font("Serif", Font.BOLD, 25));
        phone_label.setBounds(384, 370, 360, 30); phone2_label.setBounds(500, 370, 360, 30);
        f.add(phone_label); f.add(phone2_label);
        
     // �ڵ��� �� 
        phone3_label = new JLabel("�ڵ���");  phone3_label.setForeground(Color.orange); phone3_label.setFont(new Font("Serif", Font.BOLD, 15));
        phone3_label.setBounds(175, 375, 360, 30);
        f.add(phone3_label);
     // �̸��� �� 
        e_mail_label = new JLabel("�̸���"); e_mail_label.setForeground(Color.orange); e_mail_label.setFont(new Font("Serif", Font.BOLD, 15));
        e_mail_label.setBounds(175, 423, 100, 30);
        f.add(e_mail_label);
        e_mail2_label = new JLabel("@"); e_mail2_label.setForeground(Color.orange); e_mail2_label.setFont(new Font("Serif", Font.BOLD, 23));
        e_mail2_label.setBounds(382, 423, 100, 30);
        f.add(e_mail2_label);
        // �α��� �ʵ�
        loginTextField = new JTextField(15);
        loginTextField.setBounds(280, 225, 100, 30);
        f.add(loginTextField);
        loginTextField.setBackground(Color.orange);
        loginTextField.setOpaque(true);
        loginTextField.setForeground(Color.red);
        loginTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        loginTextField.setPreferredSize(new Dimension(5, 5));
        // �н����� �ʵ� 
        passwordField = new JPasswordField(10);
        passwordField.setBounds(279, 275, 100, 30);
        passwordField.setOpaque(true);
        passwordField.setBackground(Color.orange);
        passwordField.setForeground(Color.red);
        passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        f.add(passwordField);
        
        // �н����� �ʵ� 
        passwordField2 = new JPasswordField(10);
        passwordField2.setBounds(279, 325, 100, 30);
        passwordField2.setOpaque(true);
        passwordField2.setBackground(Color.orange);
        passwordField2.setForeground(Color.red);
        passwordField2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        f.add(passwordField2);
 
        // �ڵ��� �ʵ� 
        JTextField hp1 = new JTextField(5);
        JTextField hp2 = new JTextField(5);
        JTextField hp3 = new JTextField(5);
        hp1.setBounds(279, 375, 100,30); hp1.setBackground(Color.orange); hp1.setForeground(Color.red);
        hp2.setBounds(395, 375, 100,30); hp2.setBackground(Color.orange); hp2.setForeground(Color.red);
        hp3.setBounds(512, 375, 100,30); hp3.setBackground(Color.orange); hp3.setForeground(Color.red); 
        hp1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        hp2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        hp3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        f.add(hp1); 
        f.add(hp2); 
        f.add(hp3);
        
        // E-mail �ʵ� 
        JTextField mail1 = new JTextField(10); mail1.setBackground(Color.orange); mail1.setForeground(Color.red);
        JTextField mail2 = new JTextField(10); mail2.setBackground(Color.orange); mail2.setForeground(Color.red);
        mail1.setBorder(javax.swing.BorderFactory.createEmptyBorder()); mail2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        mail1.setBounds(279, 423, 100,30); mail2.setBounds(410, 423, 100,30);
        f.add(mail1); f.add(mail2);
        
        // �α��ι�ư �߰�
        join_bt = new JButton("ȸ������");
        join_bt.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        join_bt.setBounds(310, 532, 100, 20);
        join_bt.setFont(new Font("Serif", Font.BOLD, 15));
 
        // ��ư ����ó��
        join_bt.setBorderPainted(true);
        join_bt.setFocusPainted(true);
        join_bt.setContentAreaFilled(true);
 
        f.add(join_bt);
        f.add(login_Label);
        f.add(Pass_Label); f.add(Pass2_Label);
 
        // ������ �߰���
        f.add(panel);
        add(f);
        setVisible(true);
        
       // join_bt.addActionListener(new joinUIEvent(this));
    }
 
    class MyPanel extends JPanel {
        public void paint(Graphics g) {
            g.drawImage(img, 0, 0, null);
        }
    }
 
}