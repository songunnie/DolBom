package dolbom;

import java.util.ArrayList;

public class DolbomService {
	private DolbomDao dao;

	public DolbomService() {
		dao = new DolbomDao();
	}
	
	public void addDolbom(DolbomVo vo) {
		dao.insert(vo);
	}
	
	public DolbomVo selectByNum(int num) {
		return dao.select(num);
	}
	
	public ArrayList<DolbomVo> selectAll() {
		return dao.selectAll();
	}
	
	public void updateDolbom(DolbomVo vo) {
		dao.update(vo);
	}
	
	public void delDolbom(int num) {
		dao.delete(num);
	}
}