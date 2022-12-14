package review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dbconn.DBConnect;

public class ReviewDao {
	private DBConnect dbconn;

	public ReviewDao() {
		dbconn = DBConnect.getInstance();
	}

	public void insert(ReviewVo vo) {
		String sql = "insert into review values(seq_review.nextval,?,?,sysdate,?)";

		Connection con = dbconn.conn();

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getSitter_id());
			pstmt.setString(2, vo.getUser_id());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public ArrayList<ReviewVo> selectAll() {
		String sql = "select * from review";
		ArrayList<ReviewVo> list = new ArrayList<ReviewVo>();
		
		Connection con = dbconn.conn();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new ReviewVo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public ArrayList<ReviewVo> selectAllBySitter(String sitter_id) {
		String sql = "select * from review where sitter_id=? order by num";
		ArrayList<ReviewVo> list = new ArrayList<ReviewVo>();
		
		Connection con = dbconn.conn();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sitter_id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new ReviewVo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public ArrayList<ReviewVo> selectAllByUser(String user_id) {
		String sql = "select * from review where user_id=? order by num";
		ArrayList<ReviewVo> list = new ArrayList<ReviewVo>();
		
		Connection con = dbconn.conn();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new ReviewVo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public ReviewVo select(int num) {
		ReviewVo vo = null;
		ResultSet rs = null;
		
		String sql = "select * from review where num=?";
		Connection conn = dbconn.conn();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new ReviewVo(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getDate(4),
						rs.getString(5));
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
	
	public void update(ReviewVo vo) {
		String sql = "update review set content=? where num=?";

		Connection con = dbconn.conn();

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getContent());
			pstmt.setInt(2, vo.getNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void delete(int num) {
		String sql = "delete from review where num=?";

		Connection con = dbconn.conn();

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
