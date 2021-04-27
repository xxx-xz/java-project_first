package server_gui;

import kiosk_vo.LHS_Admin_VO;
import server_kiosk_dao.DBConn;

public class LHS_Admin_MemberDAO extends DBConn{

	
	
	// ·Î±×ÀÎ Â÷¸® 	
	public boolean getLoginResult(String id, String pass) {
		boolean result = false;
		try {
			String sql = " SELECT COUNT(*) FROM ADMIN_MEMBER " + 
					" WHERE ID=? AND PASS=?";
			getPstmt(sql);
			
			
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getInt(1) == 1) result = true;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean getJoinResult(LHS_Admin_VO member) {
		boolean result = false;
		try {
			
			String sql = "insert into admin_member values(?, ?, ?, ?)";
			getPstmt(sql);
			
			String hp = member.getHp1() + "-" + member.getHp2() + "-" + member.getHp3();
			String mail = member.getMail1() + "@" + member.getMail2();
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPass());
			pstmt.setString(3, hp);
			pstmt.setString(4, mail);
			
			int val = pstmt.executeUpdate();
			if(val != 0) result = true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean search(String id, String email) {
		boolean result = false;
		try {
			String sql = " SELECT COUNT(*) FROM ADMIN_MEMBER " + 
					" WHERE ID=? AND MAIL=?";
			getPstmt(sql);
			
			
			pstmt.setString(1, id);
			pstmt.setString(2, email);
			//pstmt.setString(3, member.getMail2());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getInt(1) == 1) result = true;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public int update(String id, String pass, String pass2) {
		System.out.println("dao");
		System.out.println(id);
		int result = 0;
		try {
			String sql = "UPDATE ADMIN_MEMBER"
					+ " SET"
					+ " PASS = ?"
					+ " WHERE"
					+ " ID = ?";
			getPstmt(sql);
			
			
			pstmt.setString(1, pass);
			pstmt.setString(2, id);
//			pstmt.setString(3, pass2);
			result = pstmt.executeUpdate();	
			System.out.println("sql return :  " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
}
