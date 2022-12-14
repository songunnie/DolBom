package petsitter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;

public class PetsitterDao {
	private DBConnect dbconn;
	
	public PetsitterDao() {
		dbconn = DBConnect.getInstance();
	}
	
	public void insert(PetsitterVo vo) {
		String sql = "insert into sitter values(?,?,?)";
		
		Connection con = dbconn.conn();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getSitter_id());
			pstmt.setString(2, vo.getRegion());
			pstmt.setString(3, vo.getType());
			
			pstmt.executeUpdate();
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
	}
	
	public ArrayList<PetsitterVo> selectByRegion(String region){
	      String sql = "select * from sitter where region like ?";
	      ArrayList<PetsitterVo> list = new ArrayList<PetsitterVo>();
	      
	      Connection con = dbconn.conn();
	      
	      try {
	         PreparedStatement pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, "%"+region+"%");
	         ResultSet rs = pstmt.executeQuery();
	         while(rs.next()) {
	            list.add(new PetsitterVo(rs.getString(1),rs.getString(2),rs.getString(3)));
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
	
	public ArrayList<PetsitterVo> selectAll() {
		String sql = "select * from sitter";
		ArrayList<PetsitterVo> list = new ArrayList<PetsitterVo>();
		
		Connection con = dbconn.conn();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new PetsitterVo(rs.getString(1),rs.getString(2),rs.getString(3)));
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
	
	//새로추가 
	public PetsitterVo select(String sitter_id) {
		PetsitterVo vo = null;
		ResultSet rs = null;
		
		String sql = "select * from sitter where sitter_id=?";
		Connection conn = dbconn.conn();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sitter_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new PetsitterVo(rs.getString(1),rs.getString(2),rs.getString(3));
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
	
	public void update(PetsitterVo vo) {
		String sql = "update sitter set region=?, type=? where sitter_id=?";
		
		Connection con = dbconn.conn();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getRegion());
			pstmt.setString(2, vo.getType());
			pstmt.setString(3, vo.getSitter_id());
			
			pstmt.executeUpdate();
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
	}
	
	public void delete(String sitter_id) {
		String sql = "delete from sitter where sitter_id=?";
		
		Connection con = dbconn.conn();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sitter_id);
			pstmt.executeUpdate();
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
	}
}
