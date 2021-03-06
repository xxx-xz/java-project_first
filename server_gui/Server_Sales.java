package server_gui;



//originally uploaded to http://blog.naver.com/azure0777
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import server_kiosk_dao.M_Kiosk_Server_DAO;

class CalendarDataManager{ // 6*7�迭�� ��Ÿ�� �޷� ���� ���ϴ� class
	static final int CAL_WIDTH = 7;
	final static int CAL_HEIGHT = 6;
	int calDates[][] = new int[CAL_HEIGHT][CAL_WIDTH];
	int calYear;
	int calMonth;
	int calDayOfMon;
	final int calLastDateOfMonth[]={31,28,31,30,31,30,31,31,30,31,30,31};
	int calLastDate;
	Calendar today = Calendar.getInstance();
	Calendar cal;
	public static String choiceDate;
	String month;
	String day;
	
	
	public CalendarDataManager(){ 
		setToday(); 
	}
	public void setToday(){
		calYear = today.get(Calendar.YEAR); 
		calMonth = today.get(Calendar.MONTH);
		calDayOfMon = today.get(Calendar.DAY_OF_MONTH);
		makeCalData(today);
	}
	private void makeCalData(Calendar cal){
		// 1���� ��ġ�� ������ ��¥�� ���� 
		int calStartingPos = (cal.get(Calendar.DAY_OF_WEEK)+7-(cal.get(Calendar.DAY_OF_MONTH))%7)%7;
		if(calMonth == 1) calLastDate = calLastDateOfMonth[calMonth] + leapCheck(calYear);
		else calLastDate = calLastDateOfMonth[calMonth];
		// �޷� �迭 �ʱ�ȭ
		for(int i = 0 ; i<CAL_HEIGHT ; i++){
			for(int j = 0 ; j<CAL_WIDTH ; j++){
				calDates[i][j] = 0;
			}
		}
		// �޷� �迭�� �� ä���ֱ�
		for(int i = 0, num = 1, k = 0 ; i<CAL_HEIGHT ; i++){
			if(i == 0) k = calStartingPos;
			else k = 0;
			for(int j = k ; j<CAL_WIDTH ; j++){
				if(num <= calLastDate) calDates[i][j]=num++;
			}
		}
	}
	private int leapCheck(int year){ // �������� Ȯ���ϴ� �Լ�
		if(year%4 == 0 && year%100 != 0 || year%400 == 0) return 1;
		else return 0;
	}
	public void moveMonth(int mon){ // ����޷� ���� n�� ���ĸ� �޾� �޷� �迭�� ����� �Լ�(1���� +12, -12�޷� �̵� ����)
		calMonth += mon;
		if(calMonth>11) while(calMonth>11){
			calYear++;
			calMonth -= 12;
		} else if (calMonth<0) while(calMonth<0){
			calYear--;
			calMonth += 12;
		}
		cal = new GregorianCalendar(calYear,calMonth,calDayOfMon);
		makeCalData(cal);
	}
}

public class Server_Sales extends CalendarDataManager{ // CalendarDataManager�� GUI + �޸��� + �ð�
	// â ������ҿ� ��ġ��
	JFrame mainFrame;
//		ImageIcon icon = new ImageIcon ( Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
	static ServerThread st;
	JPanel calOpPanel;
		JButton todayBut;
		JLabel todayLab;
		JButton lYearBut;
		JButton lMonBut;
		JLabel curMMYYYYLab;
		JButton nMonBut;
		JButton nYearBut;
		ListenForCalOpButtons lForCalOpButtons = new ListenForCalOpButtons();
	
	JPanel calPanel;
		JButton weekDaysName[];
		JButton dateButs[][] = new JButton[6][7];
		listenForDateButs lForDateButs = new listenForDateButs(); 
		M_Kiosk_Server_DAO sdao = new M_Kiosk_Server_DAO();
	JPanel infoPanel;
		JLabel infoClock;
	
	JPanel memoPanel;
		JLabel selectedDate,totallab;
		public static JTextArea memoArea;
		JScrollPane memoAreaSP;
		JPanel memoSubPanel;
		JButton saveBut; 
		JButton delBut; 
		JButton clearBut;
	
	JPanel frameBottomPanel;
//		JLabel bottomInfo = new JLabel("Welcome to Memo Calendar!");
	//���, �޼���
	final String WEEK_DAY_NAME[] = { "일", "월", "화", "수", "목", "금", "토" };
	final String title = "매출조회";
//	final String SaveButMsg1 = "�� MemoData������ �����Ͽ����ϴ�.";
//	final String SaveButMsg2 = "�޸� ���� �ۼ��� �ּ���.";
//	final String SaveButMsg3 = "<html><font color=red>ERROR : ���� ���� ����</html>";
//	final String DelButMsg1 = "�޸� �����Ͽ����ϴ�.";
//	final String DelButMsg2 = "�ۼ����� �ʾҰų� �̹� ������ memo�Դϴ�.";
//	final String DelButMsg3 = "<html><font color=red>ERROR : ���� ���� ����</html>";
//	final String ClrButMsg1 = "�Էµ� �޸� ������ϴ�.";

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new Server_Sales(st);
			}
		});
	}
	public Server_Sales(ServerThread st){ //������� ������ ���ĵǾ� ����. �� �ǳ� ���̿� ���ٷ� ����
		this.st = st;
		mainFrame = new JFrame(title);
		mainFrame.setSize(700,400);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setResizable(false);
//		mainFrame.setIconImage(icon.getImage());
//		try{
//			UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");//LookAndFeel Windows ��Ÿ�� ����
//			SwingUtilities.updateComponentTreeUI(mainFrame) ;
//		}catch(Exception e){
//			bottomInfo.setText("ERROR : LookAndFeel setting failed");
//		}
		
		calOpPanel = new JPanel();
//			todayBut = new JButton("Today");
//			todayBut.setToolTipText("Today");
//			todayBut.addActionListener(lForCalOpButtons);
			todayLab = new JLabel(today.get(Calendar.MONTH)+1+"/"+today.get(Calendar.DAY_OF_MONTH)+"/"+today.get(Calendar.YEAR));
			lYearBut = new JButton("<<");
			lYearBut.setToolTipText("Previous Year");
			lYearBut.addActionListener(lForCalOpButtons);
			lMonBut = new JButton("<");
			lMonBut.setToolTipText("Previous Month");
			lMonBut.addActionListener(lForCalOpButtons);
			curMMYYYYLab = new JLabel("<html><table width=100><tr><th><font size=5>"+((calMonth+1)<10?"&nbsp;":"")+(calMonth+1)+" / "+calYear+"</th></tr></table></html>");
			nMonBut = new JButton(">");
			nMonBut.setToolTipText("Next Month");
			nMonBut.addActionListener(lForCalOpButtons);
			nYearBut = new JButton(">>");
			nYearBut.setToolTipText("Next Year");
			nYearBut.addActionListener(lForCalOpButtons);
			calOpPanel.setLayout(new GridBagLayout());
			GridBagConstraints calOpGC = new GridBagConstraints();
			calOpGC.gridx = 1;
			calOpGC.gridy = 1;
			calOpGC.gridwidth = 2;
			calOpGC.gridheight = 1;
			calOpGC.weightx = 1;
			calOpGC.weighty = 1;
			calOpGC.insets = new Insets(5,5,0,0);
			calOpGC.anchor = GridBagConstraints.WEST;
			calOpGC.fill = GridBagConstraints.NONE;
			calOpPanel.add(todayLab,calOpGC);
//			calOpGC.gridwidth = 3;
//			calOpGC.gridx = 2;
//			calOpGC.gridy = 1;
//			calOpPanel.add(todayLab,calOpGC);
			calOpGC.anchor = GridBagConstraints.CENTER;
			calOpGC.gridwidth = 1;
			calOpGC.gridx = 1;
			calOpGC.gridy = 2;
			calOpPanel.add(lYearBut,calOpGC);
			calOpGC.gridwidth = 1;
			calOpGC.gridx = 2;
			calOpGC.gridy = 2;
			calOpPanel.add(lMonBut,calOpGC);
			calOpGC.gridwidth = 2;
			calOpGC.gridx = 3;
			calOpGC.gridy = 2;
			calOpPanel.add(curMMYYYYLab,calOpGC);
			calOpGC.gridwidth = 1;
			calOpGC.gridx = 5;
			calOpGC.gridy = 2;
			calOpPanel.add(nMonBut,calOpGC);
			calOpGC.gridwidth = 1;
			calOpGC.gridx = 6;
			calOpGC.gridy = 2;
			calOpPanel.add(nYearBut,calOpGC);
		
		calPanel=new JPanel();
			weekDaysName = new JButton[7];
			for(int i=0 ; i<CAL_WIDTH ; i++){
				weekDaysName[i]=new JButton(WEEK_DAY_NAME[i]);
				weekDaysName[i].setBorderPainted(false);
				weekDaysName[i].setContentAreaFilled(false);
				weekDaysName[i].setForeground(Color.WHITE);
				if(i == 0) weekDaysName[i].setBackground(new Color(200, 50, 50));
				else if (i == 6) weekDaysName[i].setBackground(new Color(50, 100, 200));
				else weekDaysName[i].setBackground(new Color(150, 150, 150));
				weekDaysName[i].setOpaque(true);
				weekDaysName[i].setFocusPainted(false);
				calPanel.add(weekDaysName[i]);
			}
			for(int i=0 ; i<CAL_HEIGHT ; i++){
				for(int j=0 ; j<CAL_WIDTH ; j++){
					dateButs[i][j]=new JButton();
					dateButs[i][j].setBorderPainted(false);
					dateButs[i][j].setContentAreaFilled(false);
					dateButs[i][j].setBackground(Color.WHITE);
					dateButs[i][j].setOpaque(true);
					dateButs[i][j].addActionListener(lForDateButs);
					calPanel.add(dateButs[i][j]);
				}
			}
			calPanel.setLayout(new GridLayout(0,7,2,2));
			calPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
			showCal(); // �޷��� ǥ��
						
		infoPanel = new JPanel();
			infoPanel.setLayout(new BorderLayout());
			infoClock = new JLabel("", SwingConstants.RIGHT);
			infoClock.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			infoPanel.add(infoClock, BorderLayout.NORTH);
			selectedDate = new JLabel("<Html><font size=3>"+(today.get(Calendar.MONTH)+1)+"/"+today.get(Calendar.DAY_OF_MONTH)+"/"+today.get(Calendar.YEAR)+"&nbsp;(Today)</html>", SwingConstants.LEFT);
			selectedDate.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
						
		memoPanel=new JPanel();
			memoPanel.setBorder(BorderFactory.createTitledBorder("매출현황"));
			memoArea = new JTextArea();
			memoArea.setLineWrap(true);
			memoArea.setWrapStyleWord(true);
			memoAreaSP = new JScrollPane(memoArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//			readMemo();
			
			memoSubPanel=new JPanel();
//			saveBut = new JButton("Save"); 
//			saveBut.addActionListener(new ActionListener(){
//				public void actionPerformed(ActionEvent arg0) {
//					try {
//						File f= new File("MemoData");
//						if(!f.isDirectory()) f.mkdir();
//						
//						String memo = memoArea.getText();
//						if(memo.length()>0){
//							BufferedWriter out = new BufferedWriter(new FileWriter("MemoData/"+calYear+((calMonth+1)<10?"0":"")+(calMonth+1)+(calDayOfMon<10?"0":"")+calDayOfMon+".txt"));
//							String str = memoArea.getText();
//							out.write(str);  
//							out.close();
//							bottomInfo.setText(calYear+((calMonth+1)<10?"0":"")+(calMonth+1)+(calDayOfMon<10?"0":"")+calDayOfMon+".txt"+SaveButMsg1);
//						}
//						else 
//							bottomInfo.setText(SaveButMsg2);
//					} catch (IOException e) {
//						bottomInfo.setText(SaveButMsg3);
//					}
//					showCal();
//				}					
//			});
//			delBut = new JButton("Delete");
//			delBut.addActionListener(new ActionListener(){
//				public void actionPerformed(ActionEvent e) {
//					memoArea.setText("");
//					File f =new File("MemoData/"+calYear+((calMonth+1)<10?"0":"")+(calMonth+1)+(calDayOfMon<10?"0":"")+calDayOfMon+".txt");
//					if(f.exists()){
//						f.delete();
//						showCal();
//						bottomInfo.setText(DelButMsg1);
//					}
//					else 
//						bottomInfo.setText(DelButMsg2);					
//				}					
//			});
			clearBut = new JButton("종료");
			clearBut.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					mainFrame.setVisible(false);
				}
			});
			clearBut.setBackground(new Color(255,50,0));
//			memoSubPanel.add(saveBut);
//			memoSubPanel.add(delBut);
			
			totallab = new JLabel("");
			memoSubPanel.add(clearBut);
		
			memoPanel.setLayout(new BorderLayout());
//			memoPanel.add(selectedDate, BorderLayout.NORTH);
			memoPanel.add(memoAreaSP,BorderLayout.CENTER);
			memoPanel.add(totallab,BorderLayout.NORTH);
			memoPanel.add(memoSubPanel,BorderLayout.SOUTH);

		//calOpPanel, calPanel��  frameSubPanelWest�� ��ġ
		JPanel frameSubPanelWest = new JPanel();
		Dimension calOpPanelSize = calOpPanel.getPreferredSize();
		calOpPanelSize.height = 90;
		calOpPanel.setPreferredSize(calOpPanelSize);
		frameSubPanelWest.setLayout(new BorderLayout());
		frameSubPanelWest.add(calOpPanel,BorderLayout.NORTH);
		frameSubPanelWest.add(calPanel,BorderLayout.CENTER);

		//infoPanel, memoPanel��  frameSubPanelEast�� ��ġ
		JPanel frameSubPanelEast = new JPanel();
		Dimension infoPanelSize=infoPanel.getPreferredSize();
		infoPanelSize.height = 65;
		infoPanel.setPreferredSize(infoPanelSize);
		frameSubPanelEast.setLayout(new BorderLayout());
		frameSubPanelEast.add(infoPanel,BorderLayout.NORTH);
		frameSubPanelEast.add(memoPanel,BorderLayout.CENTER);

		Dimension frameSubPanelWestSize = frameSubPanelWest.getPreferredSize();
		frameSubPanelWestSize.width = 410;
		frameSubPanelWest.setPreferredSize(frameSubPanelWestSize);
		
		//�ڴʰ� �߰��� bottom Panel..
		frameBottomPanel = new JPanel();
//		frameBottomPanel.add(bottomInfo);
		
		//frame�� ���� ��ġ
		mainFrame.setLayout(new BorderLayout());
		mainFrame.add(frameSubPanelWest, BorderLayout.WEST);
		mainFrame.add(frameSubPanelEast, BorderLayout.CENTER);
		mainFrame.add(frameBottomPanel, BorderLayout.SOUTH);
		mainFrame.setVisible(true);

		focusToday(); //���� ��¥�� focus�� �� (mainFrame.setVisible(true) ���Ŀ� ��ġ�ؾ���)
		
		//Thread �۵�(�ð�, bottomMsg �����ð��� ����)
//		ThreadConrol threadCnl = new ThreadConrol();
//		threadCnl.start();	
	}
	private void focusToday(){
		if(today.get(Calendar.DAY_OF_WEEK) == 1)
			dateButs[today.get(Calendar.WEEK_OF_MONTH)][today.get(Calendar.DAY_OF_WEEK)-1].requestFocusInWindow();
		else
			dateButs[today.get(Calendar.WEEK_OF_MONTH)-1][today.get(Calendar.DAY_OF_WEEK)-1].requestFocusInWindow();
	}
//	private void readMemo(){
//		try{
//			File f = new File("MemoData/"+calYear+((calMonth+1)<10?"0":"")+(calMonth+1)+(calDayOfMon<10?"0":"")+calDayOfMon+".txt");
//			if(f.exists()){
//				BufferedReader in = new BufferedReader(new FileReader("MemoData/"+calYear+((calMonth+1)<10?"0":"")+(calMonth+1)+(calDayOfMon<10?"0":"")+calDayOfMon+".txt"));
//				String memoAreaText= new String();
//				while(true){
//					String tempStr = in.readLine();
//					if(tempStr == null) break;
//					memoAreaText = memoAreaText + tempStr + System.getProperty("line.separator");
//				}
//				memoArea.setText(memoAreaText);
//				in.close();	
//			}
//			else memoArea.setText("");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	private void showCal(){
		for(int i=0;i<CAL_HEIGHT;i++){
			for(int j=0;j<CAL_WIDTH;j++){
				String fontColor="black";
				if(j==0) fontColor="red";
				else if(j==6) fontColor="blue";
				
				File f =new File("MemoData/"+calYear+((calMonth+1)<10?"0":"")+(calMonth+1)+(calDates[i][j]<10?"0":"")+calDates[i][j]+".txt");
				if(f.exists()){
					dateButs[i][j].setText("calDates[i][j]");
				}
				else dateButs[i][j].setText(String.valueOf(calDates[i][j]));

				JLabel todayMark = new JLabel("<html><font color=green>*</html>");
				dateButs[i][j].removeAll();
				if(calMonth == today.get(Calendar.MONTH) &&
						calYear == today.get(Calendar.YEAR) &&
						calDates[i][j] == today.get(Calendar.DAY_OF_MONTH)){
					dateButs[i][j].add(todayMark);
					dateButs[i][j].setToolTipText("Today");
				}
				
				if(calDates[i][j] == 0) dateButs[i][j].setVisible(false);
				else dateButs[i][j].setVisible(true);
			}
		}
	}
	private class ListenForCalOpButtons implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == todayBut){
				setToday();
				lForDateButs.actionPerformed(e);
				focusToday();
			}
			else if(e.getSource() == lYearBut) moveMonth(-12);
			else if(e.getSource() == lMonBut) moveMonth(-1);
			else if(e.getSource() == nMonBut) moveMonth(1);
			else if(e.getSource() == nYearBut) moveMonth(12);
			
			curMMYYYYLab.setText("<html><table width=100><tr><th><font size=5>"+((calMonth+1)<10?"&nbsp;":"")+(calMonth+1)+" / "+calYear+"</th></tr></table></html>");
			showCal();
		}
	}
	private class listenForDateButs implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int k=0,l=0;
			for(int i=0 ; i<CAL_HEIGHT ; i++){
				for(int j=0 ; j<CAL_WIDTH ; j++){
					if(e.getSource() == dateButs[i][j]){ 
						k=i;
						l=j;
					}
				}
			}
	
//			if(!(k ==0 && l == 0)) calDayOfMon = calDates[k][l]; //today��ư�� ���������� �� actionPerformed�Լ��� ����Ǳ� ������ ���� �κ�
//
//			cal = new GregorianCalendar(calYear,calMonth,calDayOfMon);
//			
//			String dDayString = new String();
//			int dDay=((int)((cal.getTimeInMillis() - today.getTimeInMillis())/1000/60/60/24));
//			if(dDay == 0 && (cal.get(Calendar.YEAR) == today.get(Calendar.YEAR)) 
//					&& (cal.get(Calendar.MONTH) == today.get(Calendar.MONTH))
//					&& (cal.get(Calendar.DAY_OF_MONTH) == today.get(Calendar.DAY_OF_MONTH))) dDayString = "Today"; 
//			else if(dDay >=0) dDayString = "D-"+(dDay+1);
//			else if(dDay < 0) dDayString = "D+"+(dDay)*(-1);
//			
//			selectedDate.setText("<Html><font size=3>"+(calMonth+1)+"/"+calDayOfMon+"/"+calYear+"&nbsp;("+dDayString+")</html>");
			
			int mon = calMonth;
			mon = mon+1;
			if(mon < 10) {
				month = "0" + String.valueOf(mon);
			}else {
				month = String.valueOf(mon);
			}
			
			if(Integer.parseInt(dateButs[k][l].getText()) < 10 ) {
				day = "0" + dateButs[k][l].getText();
			}else {
				day = dateButs[k][l].getText();
			}
			
			
			choiceDate = String.valueOf(calYear) + "-" +  month + "-" + day;
			Date ch_choiceDate = Date.valueOf(choiceDate);
			
			memoArea.append("메뉴 \t\t 금액");
			memoArea.setFont(new Font("맑은 고딕",Font.BOLD,10));
			st.sdao.selectSales(ch_choiceDate);
//			sdao.getSales(dateButs[k][l].getText());
//			readMemo();
		}
	}
//	private class ThreadConrol extends Thread{
//		public void run(){
//			boolean msgCntFlag = false;
//			int num = 0;
//			String curStr = new String();
//			while(true){
//				try{
//					today = Calendar.getInstance();
//					String amPm = (today.get(Calendar.AM_PM)==0?"AM":"PM");
//					String hour;
//							if(today.get(Calendar.HOUR) == 0) hour = "12"; 
//							else if(today.get(Calendar.HOUR) == 12) hour = " 0";
//							else hour = (today.get(Calendar.HOUR)<10?" ":"")+today.get(Calendar.HOUR);
//					String min = (today.get(Calendar.MINUTE)<10?"0":"")+today.get(Calendar.MINUTE);
//					String sec = (today.get(Calendar.SECOND)<10?"0":"")+today.get(Calendar.SECOND);
//					infoClock.setText(amPm+" "+hour+":"+min+":"+sec);
//
//					sleep(1000);
//					String infoStr = bottomInfo.getText();
//					
//					if(infoStr != " " && (msgCntFlag == false || curStr != infoStr)){
//						num = 5;
//						msgCntFlag = true;
//						curStr = infoStr;
//					}
//					else if(infoStr != " " && msgCntFlag == true){
//						if(num > 0) num--;
//						else{
//							msgCntFlag = false;
//							bottomInfo.setText(" ");
//						}
//					}		
//				}
//				catch(InterruptedException e){
//					System.out.println("Thread:Error");
//				}
//			}
//		}
//	}
}