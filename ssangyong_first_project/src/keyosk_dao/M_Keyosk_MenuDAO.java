package keyosk_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import keyosk_gui.M_Keyosk_UI;
import keyosk_vo.MenuVO;

public class M_Keyosk_MenuDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String url = "jdbc:oracle:thin:@localhost:1521";
	String user = "scott";
	String pass = "tiger";
	
	public M_Keyosk_MenuDAO() {
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
				
	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
}
