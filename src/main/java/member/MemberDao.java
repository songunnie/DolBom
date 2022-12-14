package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import dbconn.DBConnect;

public class MemberDao {
   private DBConnect dbconn;

   public MemberDao() {
      dbconn = DBConnect.getInstance();
   }

   public void insert(MemberVo vo) {
      String sql = "insert into members values(?,?,?,?,?,?)";
      Connection conn = dbconn.conn();
      try {
         PreparedStatement pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, vo.getUser_id());
         pstmt.setString(2, vo.getPwd());
         pstmt.setString(3, vo.getName());
         pstmt.setString(4, vo.getTel());
         pstmt.setString(5, vo.getAddress());
         pstmt.setInt(6, vo.getStatus());
         pstmt.executeUpdate();
      } catch (SQLIntegrityConstraintViolationException e) {
         System.out.println("중복된 아이디. 다시 입력하시오");
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
   public ArrayList<MemberVo> selectAll() {

      ResultSet rs = null;
      ArrayList<MemberVo> list = new ArrayList<MemberVo>();
      String sql = "select * from members";
      Connection conn = dbconn.conn();

      try {
         PreparedStatement pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();

         while(rs.next()) {
            list.add(new MemberVo(rs.getString(1), rs.getString(2), 
                  rs.getString(3), rs.getString(4),rs.getString(5),rs.getInt(6)));
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
   
   //성언 추가: status 기준으로 1로 등록된 회원, 즉 펫시터들만 받아옴.
//   public ArrayList<MemberVo> selectPetsitter() {
//
//	      ResultSet rs = null;
//	      ArrayList<MemberVo> list = new ArrayList<MemberVo>();
//	      String sql = "select * from members where status = 1";
//	      Connection conn = dbconn.conn();
//
//	      try {
//	         PreparedStatement pstmt = conn.prepareStatement(sql);
//	         rs = pstmt.executeQuery();
//
//	         while(rs.next()) {
//	            list.add(new MemberVo(rs.getString(1), rs.getString(2), 
//	                  rs.getString(3), rs.getInt(4),rs.getString(5),rs.getInt(6)));
//	         }
//	      } catch (SQLException e) {
//	         // TODO Auto-generated catch block
//	         e.printStackTrace();
//	      } finally {
//	         try {
//	            conn.close();
//	         } catch (SQLException e) {
//	            // TODO Auto-generated catch block
//	            e.printStackTrace();
//	         }
//	      }
//	      return list;
//	   }
   
   

   public MemberVo select(String user_id) {
		MemberVo vo = null;
		ResultSet rs = null;
		
		String sql = "select * from members where user_id=?";
		Connection conn = dbconn.conn();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new MemberVo(rs.getString(1), rs.getString(2), 
		                  rs.getString(3), rs.getString(4),rs.getString(5),rs.getInt(6));
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

   
   public void update(MemberVo vo) {
      String sql = "update members set pwd=?, address=?, tel=? where user_id=?";
      Connection conn = dbconn.conn();
      try {
         PreparedStatement pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, vo.getPwd());
         pstmt.setString(2, vo.getAddress());
         pstmt.setString(3, vo.getTel());
         pstmt.setString(4, vo.getUser_id());
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

   public void delete(String user_id) {
      String sql = "delete from members where user_id=?";
      Connection conn = dbconn.conn();
      try {
         PreparedStatement pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, user_id);
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