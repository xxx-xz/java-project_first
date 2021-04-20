package server_kiosk_dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import client_kiosk_vo.MenuVO;
import server_gui.Server_Sales;

public class M_Kiosk_Server_DAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String url = "jdbc:oracle:thin:@localhost:1521";
	String user = "scott";
	String pass = "tiger";
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public M_Kiosk_Server_DAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,user,pass);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getPstmt(String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertorder(ArrayList<MenuVO> menu,int number) {
		String sql = "insert into M_KIOSK_ORDER(ORDERNO,MENU,PRICE) values (?,?,?)";
		
		getPstmt(sql);
		
		try {
			for(int i=0; i<menu.size(); i++) {
				pstmt.setInt(1, number);
				pstmt.setString(2, menu.get(i).getMenu_kor());
				pstmt.setInt(3, menu.get(i).getPrice());
				pstmt.executeUpdate();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<MenuVO> selectOrder(int detail_number) {
		ArrayList<MenuVO> detail_order = new ArrayList<MenuVO>();
		String sql = "select menu, price from m_kiosk_order where orderno = ?";
		getPstmt(sql);
		
		try {
			pstmt.setInt(1, detail_number);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MenuVO menu = new MenuVO();
				menu.setMenu_kor(rs.getString(1));
				menu.setPrice(rs.getInt(2));
				
				detail_order.add(menu);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return detail_order;
	}
	
	public void selectSales(Date date) {
		Server_Sales.memoArea.setText("");
		Server_Sales.memoArea.append("메뉴 \t\t 금액\n");
		int price_sum = 0;
		String sql = "select menu,price from m_kiosk_order where to_char(orderdate,'YYYY/MM/DD') = ?";
		getPstmt(sql);
		try {
			pstmt.setDate(1, date);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getString(1).equals("더블치즈버거-세트") || rs.getString(1).equals("맥치킨버거-세트") ||  
						rs.getString(1).equals("에그불고기버거-세트")) {
					Server_Sales.memoArea.append(rs.getString(1) + "\t");
					Server_Sales.memoArea.append(rs.getInt(2) + "\n");
					price_sum += rs.getInt(2);
				}else {
					Server_Sales.memoArea.append(rs.getString(1) + "\t\t");
					Server_Sales.memoArea.append(rs.getInt(2) + "\n");
					price_sum += rs.getInt(2);
				}
					
			}
			Server_Sales.memoArea.append("---------------------------------------------\n");
			Server_Sales.memoArea.append("총 금액: \t\t" + price_sum);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void exit() {
		String sql = "delete from m_kiosk_order";
		getPstmt(sql);
		
		try {
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
