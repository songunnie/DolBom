package board;

import java.util.ArrayList;

public class BoardService {
	private BoardDao dao;

	public BoardService() {
		dao = new BoardDao();
	}
	
	public void addBoard(BoardVo vo) {
		dao.insert(vo);
	}
	
	public BoardVo selectByNum(int num) {
		return dao.select(num);
	}
	
	public ArrayList<BoardVo> selectAll() {
		return dao.selectAll();
	}
	
	public ArrayList<BoardVo> selectByTitle(String title) {
		return dao.selectByTitle(title);
	}
	
	public void updateBoard(BoardVo vo) {
		dao.update(vo);
	}
	
	public void updateHit(int hit) {
		dao.updateHit(hit);
	}
	
	public void delBoard(int num) {
		dao.delete(num);
	}
}