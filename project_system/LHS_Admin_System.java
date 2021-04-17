package project_system;

import project_dao.LHS_Admin_MemberDAO;
import project_vo.LHS_Admin_VO;

public class LHS_Admin_System {

	
	LHS_Admin_MemberDAO mdao = new LHS_Admin_MemberDAO();
	
	public static boolean LOGIN_RESULT = false;
	
	public LHS_Admin_System() {}

	
	// 로그인 
	public boolean logincheck(String id, String pass) {
		
		return mdao.getLoginResult(id, pass);
	}
	
	// 회원가입
	public boolean join(LHS_Admin_VO member) {
		return mdao.getJoinResult(member);
	}
}
