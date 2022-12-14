package dolbom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;


public class DolbomDao {
	
	private DBConnect dbconn;

	public DolbomDao() {
		dbconn = DBConnect.getInstance();
	}

	public void insert(DolbomVo vo) {
		String sql = "insert into dolbom "
				+ "values(seq_dolbom.nextval,?,?,?,?,?,?,sysdate)";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSitter_id());
			pstmt.setInt(2, vo.getReservation_num());
			pstmt.setString(3, vo.getUser_id());
			pstmt.setString(4, vo.getTitle());
			pstmt.setString(5, vo.getImg());
			pstmt.setString(6, vo.getContent());
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
	
	public DolbomVo select(int num) {
		ResultSet rs = null;
		DolbomVo vo = null;
		String sql = "select * from dolbom where num=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new DolbomVo(rs.getInt(1), rs.getString(2),
						rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7),rs.getDate(8));
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
	
	public ArrayList<DolbomVo> selectAll() {
		ResultSet rs = null;
		ArrayList<DolbomVo> list = new ArrayList<DolbomVo>();
		String sql = "select * from dolbom";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new DolbomVo(rs.getInt(1), rs.getString(2),
						rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7),rs.getDate(8)));
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
	
	public void update(DolbomVo vo) {
		String sql = "update dolbom set title=?, img=?, content=? where "
				+ "num=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getImg());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getNum());
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
		String sql = "delete from dolbom where num=?";
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
