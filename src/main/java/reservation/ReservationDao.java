package reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;

public class ReservationDao {
	private DBConnect dbconn;

	public ReservationDao() {
		dbconn = DBConnect.getInstance();
	}

	public void insert(ReservationVo vo) {
		String sql = "insert into reservation values(seq_reservation.nextval,?,?,?,?,sysdate,?)";

		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUser_id());
			pstmt.setString(2, vo.getSitter_id());
			pstmt.setDate(3, vo.getStart_date());
			pstmt.setDate(4, vo.getEnd_date());
			pstmt.setString(5, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public ArrayList<ReservationVo> selectAll() {

		ResultSet rs = null;
		ArrayList<ReservationVo> list = new ArrayList<ReservationVo>();
		String sql = "select * from reservation";
		Connection conn = dbconn.conn();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new ReservationVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5),
						rs.getDate(6), rs.getString(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public ArrayList<ReservationVo> selectAllBySitter_id(String sitter_id) {

		ResultSet rs = null;
		ArrayList<ReservationVo> list = new ArrayList<ReservationVo>();
		String sql = "select * from reservation where sitter_id=?";
		Connection conn = dbconn.conn();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sitter_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new ReservationVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5),
						rs.getDate(6), rs.getString(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public ArrayList<ReservationVo> selectAllByUser_id(String user_id) {

		ResultSet rs = null;
		ArrayList<ReservationVo> list = new ArrayList<ReservationVo>();
		String sql = "select * from reservation where user_id=?";
		Connection conn = dbconn.conn();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new ReservationVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5),
						rs.getDate(6), rs.getString(7)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public ReservationVo select(int num) {

		ResultSet rs = null;
		ReservationVo vo = null;
		String sql = "select * from reservation where num=?";
		Connection conn = dbconn.conn();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo = new ReservationVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5),
						rs.getDate(6), rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vo;
	}

	public void update(ReservationVo vo) {
		String sql = "update reservation set content=? where num=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getContent());
			pstmt.setInt(2, vo.getNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void delete(int num) {
		String sql = "delete from reservation where num=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
