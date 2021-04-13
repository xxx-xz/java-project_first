package project_dao;

import project_vo.LHS_Admin_VO;

public class LHS_Admin_MemberDAO extends LHS_Admin_DBConn{

	
	
	// 로그인 차리 	
	public boolean getLoginResult(String id, String pass) {
		boolean result = false;
		String resultid = "";
		try {
			String sql = "select count(*),id from admin_member id = ? and pass = ? group by id";
			getPreParedStatement(sql);
			
			
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				if(rs.getInt(1) == 1) result = true;
				resultid = rs.getString(2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean getJoinResult(LHS_Admin_VO member) {
		boolean result = false;
		try {
			String sql = "insert into admin_member values(?, ?, ?, ?, ?)";
			getPreParedStatement(sql);
			
			String hp = member.getHp1() + "-" + member.getHp2() + "-" + member.getHp3();
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPass());
			pstmt.setString(3, member.getPass2());
			pstmt.setString(4, hp);
			pstmt.setString(5, member.getMail());
			
			int val = pstmt.executeUpdate();
			System.out.println(val);
			if(val != 0) result = true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
