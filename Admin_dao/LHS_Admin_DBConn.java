package project_dao;

import java.sql.*;



public class LHS_Admin_DBConn {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String url = "jdbc:oracle:thin:localhost:1521";
	String user = "scott";
	String pass = "tiger";
	
	
	public LHS_Admin_DBConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// DBConn
	
	public void getPreParedStatement(String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	public void close() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null)conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
} // class
