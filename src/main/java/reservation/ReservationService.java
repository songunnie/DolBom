package reservation;

import java.util.ArrayList;

public class ReservationService {
	private ReservationDao dao;

	public ReservationService() {
		dao = new ReservationDao();
	}

	public void addReservation(ReservationVo vo) {
		dao.insert(vo);
	}

	public ArrayList<ReservationVo> selectAll() {
		return dao.selectAll();
	}

	public ArrayList<ReservationVo> selectAllBySitter_id(String sitter_id) {
		return dao.selectAllBySitter_id(sitter_id);
	}

	public ArrayList<ReservationVo> selectAllByUser_id(String user_id) {
		return dao.selectAllByUser_id(user_id);
	}

	public ReservationVo select(int num) {
		return dao.select(num);
	}

	public void updateReservation(ReservationVo vo) {
		dao.update(vo);
	}

	public void delReservation(int num) {
		dao.delete(num);
	}
}