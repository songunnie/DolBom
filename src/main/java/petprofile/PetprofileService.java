package petprofile;

import java.util.ArrayList;

public class PetprofileService {
	private PetprofileDao dao;

	public PetprofileService() {
		dao = new PetprofileDao();
	}

	public void addPetprofile(PetprofileVo vo) {
		dao.insert(vo);
	}

	public ArrayList<PetprofileVo> selectAll() {
		return dao.selectAll();
	}

	public PetprofileVo select(int pet_id) {
		return dao.selectByPet_Id(pet_id);
	}

	public void updatePetprofile(PetprofileVo vo) {
		dao.update(vo);
	}

	public void delPetprofile(int pet_id) {
		dao.delete(pet_id);
	}
}