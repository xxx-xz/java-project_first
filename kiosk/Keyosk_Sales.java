package kiosk;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Keyosk_Sales {
	Calendar today = Calendar.getInstance();
	Calendar cal;
	JFrame jf;
	JPanel topcal_panel;
	JButton todaybtn,pyearbtn,pmonthbtn,nyearbtn,nmonthbtn;
	JLabel todaylab;
	
	int calLastDateOfMonth[]={31,28,31,30,31,30,31,31,30,31,30,31};
	int calYear = today.get(Calendar.YEAR);
	int calMonth = today.get(Calendar.MONTH);
	int calDayOfMon = today.get(Calendar.DAY_OF_WEEK);
	int calLastday;
	
	int cal_height = 6;
	int cal_width = 7;
	int calDates[][] = new int[cal_height][cal_width];
	
	public static void main(String[] args) {
		new Keyosk_Sales();
	}
	public Keyosk_Sales() {
		
		init();
	}
	
	public void init() {
		todaybtn = new JButton("Today");
		pyearbtn = new JButton("<<");
		pmonthbtn = new JButton("<");
		nyearbtn = new JButton(">>");
		nmonthbtn = new JButton(">");
		
		cal = new GregorianCalendar(calYear,calMonth,calDayOfMon);
		
		//1일 위치와 마지막 날짜 구하기
		int calfirstday = (cal.get(Calendar.DAY_OF_WEEK)+7-(cal.get(Calendar.DAY_OF_MONTH))%7)%7;
		if(calMonth == 1) {
			calLastday = calLastDateOfMonth[calMonth] + febcheck(calYear);
		}else {
			calLastday = calLastDateOfMonth[calMonth];
		}
		//달력 배열 초기화
		for(int i=0; i<cal_height; i++) {
			for (int j=0; j<cal_width; j++) {
				calDates[i][j] = 0;
			}
		}
		
		for(int i=0, k=0, num=1;i<cal_height;i++) {
			if(i == 0) {
				k = calfirstday;
			}else {
				k = 0;
			}
			for(int j=k; j<cal_width; j++) {
				if(num <= calLastday) {
					calDates[i][j] = num;
					num ++;
				}
			}
		}
		 
	}
	
	public int febcheck(int Year) {
		int result = 0;
		if(Year%4 == 0 && Year%100 != 0 || Year%400 == 0) {
			result = 1;
		}
		return result;
	}
	
	
	
}