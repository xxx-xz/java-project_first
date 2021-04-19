package server_kiosk_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import client_kiosk_vo.MenuVO;

public class M_Kiosk_Server_DAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String url = "jdbc:oracle:thin:@localhost:1521";
	String user = "scott";
	String pass = "tiger";
	
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
		String sql = "insert into M_KIOSK_ORDER values (?,?,?)";
		
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
