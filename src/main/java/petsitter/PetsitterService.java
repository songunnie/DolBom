package petsitter;

import java.util.ArrayList;

public class PetsitterService {
	private PetsitterDao dao;

	public PetsitterService() {
		dao = new PetsitterDao();
	}
	
	public void addPetsitter(PetsitterVo vo) {
		dao.insert(vo);
	}
	
	public ArrayList<PetsitterVo> selectAll() {
		return dao.selectAll();
	}
	
	public ArrayList<PetsitterVo> selectByRegion(String region) {
		return dao.selectByRegion(region);
	}
	
	//새로추가
	public PetsitterVo selectById(String sitter_id) {
		return dao.select(sitter_id);
	}
	
	public void updatePetsitter(PetsitterVo vo) {
		dao.update(vo);
	}
	
	public void delPetsitter(String sitter_id) {
		dao.delete(sitter_id);
	}
}