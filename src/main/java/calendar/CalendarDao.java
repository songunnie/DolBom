package calendar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;

public class CalendarDao {
	DBConnect dbconn;

	public CalendarDao() {
		dbconn = DBConnect.getInstance();
	}

	public void insert(CalendarVo vo) {
		String sql = "insert into calendar values(seq_calendar.nextval,?,?,?)";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSitter_id());
			pstmt.setDate(2, vo.getReserved_date());
			pstmt.setDate(3, vo.getAbled_date());
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

//     public CalendarVo selectBySitterid(String sitter_id) {
//        ResultSet rs = null;
//        CalendarVo vo = null;
//        String sql = "select * from boards where num=?";
//        Connection conn = dbconn.conn();
//        try {
//           PreparedStatement pstmt = conn.prepareStatement(sql);
//           pstmt.setString(1, sitter_id);
//           rs = pstmt.executeQuery();
//           if(rs.next()) {
//              vo = new CalendarVo(rs.getInt(1), rs.getString(2), rs.getDate(3),
//            		  rs.getDate(4));
//           }
//        } catch (SQLException e) {
//           // TODO Auto-generated catch block
//           e.printStackTrace();
//        } finally {
//           try {
//              conn.close();
//           } catch (SQLException e) {
//              // TODO Auto-generated catch block
//              e.printStackTrace();
//           }
//        }
//        return vo;
//     }

	public ArrayList<CalendarVo> selectBySitterid(String sitter_id) {
		ResultSet rs = null;
		ArrayList<CalendarVo> list = new ArrayList<CalendarVo>();
		String sql = "select * from calendar where sitter_id = ?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sitter_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new CalendarVo(rs.getInt(1), rs.getInt(2), rs.getString(3), 
						rs.getDate(4), rs.getDate(5)));
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

	public void update(CalendarVo vo) {
		String sql = "update calendar set reserved_date = ? where sitter_id = ?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, vo.getReserved_date());
			pstmt.setString(2, vo.getSitter_id());
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

	public void delete(int reserv_num) {
		String sql = "delete reserved_date from calendar where reserv_num = ?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reserv_num);
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
