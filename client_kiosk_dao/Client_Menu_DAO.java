package client_kiosk_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kiosk_vo.MenuVO;
import server_kiosk_dao.DBConn;

public class Client_Menu_DAO extends DBConn{

	public MenuVO menu_click_result(String menu) {
		MenuVO vo = new MenuVO();
		try {
			String sql = "select * from M_KEYOSK_MENU where menu_name = ?";
			getPstmt(sql);
			
			pstmt.setString(1, menu);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo.setMenu(rs.getString(1));
				vo.setPrice(rs.getInt(2));
				vo.setMenu_kor(rs.getString(3));
	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
}
