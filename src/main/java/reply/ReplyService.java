package reply;

import java.util.ArrayList;

public class ReplyService {
	private ReplyDao dao;

	public ReplyService() {
		dao = new ReplyDao();
	}
	
	public void addReply(ReplyVo vo) {
		dao.insert(vo);
	}
	
	public ArrayList<ReplyVo> selectAll() {
		return dao.selectAll();
	}
	
	public ReplyVo selectOne(int num) {
		return dao.selectOne(num);
	}
	
	public void updateReply(ReplyVo vo) {
		dao.update(vo);
	}
	
	public void delReply(int num) {
		dao.delete(num);
	}
}