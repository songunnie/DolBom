package member;

import java.util.ArrayList;

public class MemberService {
	private MemberDao dao;

	public MemberService() {
		dao = new MemberDao();
	}
	
	public void addMember(MemberVo vo) {
		dao.insert(vo);
	}
	
	public MemberVo selectById(String user_id) {
		return dao.select(user_id);
	}
	
	public ArrayList<MemberVo> selectAll() {
		return dao.selectAll();
	}
	
	//성언 추가
//	public ArrayList<MemberVo> selectPetsitter() {
//		return dao.selectPetsitter();
//	}
	
	public void updateMember(MemberVo vo) {
		dao.update(vo);
	}
	
	public void delMember(String user_id) {
		dao.delete(user_id);
	}
}