package project_system;

import project_dao.LHS_Admin_MemberDAO;
import project_vo.LHS_Admin_VO;

public class LHS_Admin_System {

	
	LHS_Admin_MemberDAO mdao = new LHS_Admin_MemberDAO();
	
	
	
	public LHS_Admin_System() {}

	
	// 로그인 
	public boolean logincheck(String id, String pass) {
		
		return mdao.getLoginResult(id, pass);
	}
	
	// 회원가입
	public boolean join(LHS_Admin_VO member) {
		return mdao.getJoinResult(member);
	}
	
	public boolean search(String id, String email) {
		return mdao.search(id, email);
	}
	public int update(String id, String pass, String pass2) {
		System.out.println("system");
		return mdao.update(id, pass, pass2);
	}
}
