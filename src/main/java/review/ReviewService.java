package review;

import java.util.ArrayList;

public class ReviewService {
	private ReviewDao dao;

	public ReviewService() {
		dao = new ReviewDao();
	}

	public void addReview(ReviewVo vo) {
		dao.insert(vo);
	}

	public ArrayList<ReviewVo> selectAll() {
		return dao.selectAll();
	}

	public ArrayList<ReviewVo> selectBySitter(String sitter_id) {
		return dao.selectAllBySitter(sitter_id);
	}
	
	public ArrayList<ReviewVo> selectByUser(String user_id) {
		return dao.selectAllByUser(user_id);
	}
	
	public ReviewVo selectOne(int num) {
		return dao.select(num);
	}
	
	public void updateReview(ReviewVo vo) {
		dao.update(vo);
	}

	public void delReview(int num) {
		dao.delete(num);
	}
}