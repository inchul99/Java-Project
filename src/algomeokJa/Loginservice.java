package algomeokJa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Loginservice {
	
	 public static boolean verifyLogin(String userId, String password) {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        
	        try {
	            conn = DBConnectionMgr.getInstance().getConnection(); // DB 연결 가져오기
	            String query = "SELECT * FROM users WHERE id = ? AND password = ?";
	            pstmt = conn.prepareStatement(query);
	            pstmt.setString(1, userId);
	            pstmt.setString(2, password);

	            rs = pstmt.executeQuery();
	            return rs.next(); // 결과가 있으면 로그인 성공

	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        } finally {
	            DBConnectionMgr.getInstance().freeConnection(conn,null,null); // 커넥션 반환
	        }
	    }
}
