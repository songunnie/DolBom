package petprofile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;

public class PetprofileDao {
	DBConnect dbconn;
	
	public PetprofileDao() {
		dbconn = DBConnect.getInstance();
	}
	
	public void insert(PetprofileVo vo) {
		String sql = "insert into petprofile values (seq_petprofile.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUser_id());
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, vo.getAge());
			pstmt.setString(4, vo.getKind());
			pstmt.setString(5, vo.getType());
			pstmt.setString(6, vo.getSex());
			pstmt.setString(7, vo.getImg());
			pstmt.setString(8, vo.getContent());
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
	
	public ArrayList<PetprofileVo> selectAll() {
		ResultSet rs = null;
		ArrayList<PetprofileVo> list = new ArrayList<PetprofileVo>();
		String sql = "select * from petprofile";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new PetprofileVo(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9)));
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
	
	public PetprofileVo selectByPet_Id(int pet_id) {
	      ResultSet rs = null;
	      PetprofileVo vo = null;
	      String sql = "select * from petprofile where pet_id=?";
	      Connection conn = dbconn.conn();
	      try {
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         if(rs.next()) {
	            vo = new PetprofileVo(rs.getInt(1), rs.getString(2),
	                  rs.getString(3), rs.getInt(4), rs.getString(5),
	                  rs.getString(6), rs.getString(7), rs.getString(8),
	                  rs.getString(9));
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
	
	public void update(PetprofileVo vo) {
		String sql = "update petprofile set name=?, age=?, kind=?, type=?, "
				+ "sex=?, img=?, content=? where pet_id=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, vo.getKind());
			pstmt.setString(4, vo.getType());
			pstmt.setString(5, vo.getSex());
			pstmt.setString(6, vo.getImg());
			pstmt.setString(7, vo.getContent());
			pstmt.setInt(8, vo.getPet_id());
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
	
	public void delete(int pet_id) {
		String sql = "delete from petprofile where pet_id=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pet_id);
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
