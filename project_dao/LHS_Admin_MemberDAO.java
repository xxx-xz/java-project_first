package project_dao;

import project_vo.LHS_Admin_VO;

public class LHS_Admin_MemberDAO extends LHS_Admin_DBConn{

	
	
	// 로그인 차리 	
	public boolean getLoginResult(String id, String pass) {
		boolean result = false;
		try {
			String sql = " SELECT COUNT(*) FROM ADMIN_MEMBER " + 
					" WHERE ID=? AND PASS=?";
			getPreparedStatement(sql);
			
			
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
			System.out.println("dqdqdqdqdq");
			String sql = "insert into admin_member values(?, ?, ?, ?)";
			getPreparedStatement(sql);
			
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
}
